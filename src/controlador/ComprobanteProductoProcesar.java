/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.migradortdn.model.Almacen;
import com.migradortdn.model.ComprobanteDetalle;
import com.migradortdn.model.ComprobanteProducto;
import com.migradortdn.model.MontoImponible;
import com.migradortdn.model.Producto;
import com.migradortdn.model.Producto1;
import com.migradortdn.model.UnidadMedida;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.math3.util.Precision;

/**
 *
 * @author BlackSpider
 */
public class ComprobanteProductoProcesar {

    public ArrayList<ComprobanteProducto> procesarComprobante(ArrayList<String[]> csvArrayComprobante, ArrayList<Producto1> lproductos, ArrayList<Almacen> lAlmacen,
            ArrayList<UnidadMedida> lUnidadMedidaBase, ArrayList<String[]> csvLocacion) {

        ArrayList<ComprobanteProducto> out = new ArrayList<ComprobanteProducto>();

        for (String[] x : csvArrayComprobante) {

            boolean existe = false;
            ComprobanteProducto cp = new ComprobanteProducto();

            Almacen almacenActual = new Almacen();

            String almacenDescripcion = x[2].trim();

            if (!x[1].contains("C")) {

                if (!almacenDescripcion.contains(x[1].trim())) {

                    almacenDescripcion = x[1].trim() + " " + almacenDescripcion;

                }

            }

           // System.out.println("almacen " + almacenDescripcion);
            for (Almacen ax : lAlmacen) {

                if (ax.getDescripcion().trim().compareTo(almacenDescripcion) == 0) {

                    almacenActual = ax;
                    // System.out.println("encontre almacen " + almacenActual.getId());
                    break;

                }

            }

            /*
                TIPO DE IMPUESTO
                1 IVA 10
                2 IVA 5
                3 IVA EXCENTO
             */
            int iva = (int) Double.parseDouble(x[13].trim().replace(",", "."));

            for (ComprobanteProducto cpx : out) {

                //System.out.println(cpx.getDeposito().longValue());
                if (cpx.getDeposito().longValue() == almacenActual.getId().longValue()) {

                    if (iva == 10 && cpx.getMontosImponibles().get(0).getTipoImpuesto().longValue() == 1L) {

                        cp = cpx;
                        existe = true;
                        break;
                    }

                    if (iva == 5 && cpx.getMontosImponibles().get(0).getTipoImpuesto().longValue() == 2L) {

                        cp = cpx;
                        existe = true;
                        break;
                    }

                    if (iva == 0 && cpx.getMontosImponibles().get(0).getTipoImpuesto().longValue() == 3L) {

                        cp = cpx;
                        existe = true;
                        break;
                    }

                }

            }

            if (!existe) {

                System.out.println("No existe");

                cp.setCompra(2L); // este es el numero de fulujo
                cp.setCambio(1L);
                cp.setMoneda1(56L);
                cp.setImputarIvaGeneral(true);
                cp.setProveedor(6919L);//este es el codigo del proveedor
                cp.setSucursalProveedor(6952L);
                //cp.setTimbradoProveedor(30L);
                //cp.setRubroIva(4L);
                cp.setTipo(19L);
                cp.setFecha(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ").format(new Date()));
                cp.setDeposito(almacenActual.getId());

                for (String[] s : csvLocacion) {

                    if (s[1].trim().compareTo(String.valueOf(almacenActual.getSucursal().getId())) == 0) {

                        if (s[2].trim().compareTo("1") == 0) {

                            cp.setLocacion(Long.parseLong(s[0].trim()));

                            break;

                        }

                    }

                }

                int numero = out.size() + 1;

                if (numero < 10) {

                    cp.setNumero("001-001-000000" + numero);

                }

                if (numero > 10 && numero < 100) {

                    cp.setNumero("001-001-00000" + numero);

                }

                MontoImponible mi = new MontoImponible();

                if (iva == 10) {

                    mi.setTipoImpuesto(1L);

                }

                if (iva == 5) {

                    mi.setTipoImpuesto(2L);

                }

                if (iva == 0) {

                    mi.setTipoImpuesto(3L);

                }

                mi.setBaseImponible(0.00);
                //mi.setBaseImponibleView(mi.getBaseImponible() + "");
                mi.setValor(0.00);
                mi.setTotal(0.00);
                //mi.setTotalView(mi.getTotal() + "");

                cp.getMontosImponibles().add(mi);

                out.add(cp);

            }

            Producto1 p = null;

            for (Producto1 px : lproductos) {

                if (px.getNombre().compareTo(x[4].trim()) == 0) {

                    p = px;

                    break;

                }

            }

            ComprobanteDetalle cd = new ComprobanteDetalle();

            if (p != null) {
                cd.setProducto(p.getId());

                for (UnidadMedida umx : lUnidadMedidaBase) {

                    if (p.getUnidadMedidaBase().getDescripcion().compareTo(umx.getDescripcion()) == 0) {

                        cd.setUnidadMedida(umx.getId());
                        break;

                    }

                }

                //cd.setUnidadMedida(p.getUnidadMedidaBase().getId());
                //System.out.println("esta es la unidad de medida "+cd.getUnidadMedida());
            }else{
            
                System.out.println("Producto nulo");
                System.out.println("Falta "+x[4].trim());
                continue; //esto borrar en el final
            }
            cd.setTipo(106L);
            cd.setCantidad(Double.valueOf(x[11].trim().replace(",", ".")).intValue());
            cd.setCantidadView(cd.getCantidad() + "");
            cd.setUltimoPrecio(Precision.round(Double.valueOf(x[14].trim().replace(",", ".")),2));
            cd.setUltimoPrecioView("" + cd.getUltimoPrecio());
            cd.setDescuento(0);
            cd.setDescuentoView(cd.getDescuento() + "");
            cd.setTotalItem(Precision.round(cd.getUltimoPrecio() * cd.getCantidad(),2));
            cd.setTotalItemView(cd.getTotalItem() + "");

            MontoImponible mi2 = new MontoImponible();
            if (iva == 10) {

                mi2.setTipoImpuesto(1L);

            }

            if (iva == 5) {

                mi2.setTipoImpuesto(2L);

            }

            if (iva == 0) {

                mi2.setTipoImpuesto(3L);

            }
            mi2.setPorcentaje(new Long(iva));
           // mi2.setValor(Precision.round(Double.valueOf(x[12].trim().replace(",", ".")),2));
            mi2.setValor(Precision.round(cd.getTotalItem() - ((Double.valueOf(x[12].trim().replace(",", ".")))*cd.getCantidad()),2));
            mi2.setBaseImponible(Precision.round((Double.valueOf(x[12].trim().replace(",", ".")) * cd.getCantidad()),2));

            cd.getMontosImponibles().add(mi2);

            cp.getComprobanteDetalle().add(cd);
            
            double baseImponible = cp.getMontosImponibles().get(0).getBaseImponible() + mi2.getBaseImponible();
            cp.getMontosImponibles().get(0).setBaseImponible(Precision.round(baseImponible,2));
            cp.getMontosImponibles().get(0).setBaseImponibleView(cp.getMontosImponibles().get(0).getBaseImponible() + "");
            
            
            cp.getMontosImponibles().get(0).setValor(Precision.round((cp.getMontosImponibles().get(0).getValor() + mi2.getValor()),2));
            cp.getMontosImponibles().get(0).setValorView(cp.getMontosImponibles().get(0).getValor() + "");
            
            double total = cp.getMontosImponibles().get(0).getTotal() + cd.getTotalItem();
            cp.getMontosImponibles().get(0).setTotal(Precision.round(total,2));
            cp.getMontosImponibles().get(0).setTotalView(cp.getMontosImponibles().get(0).getTotal() + "");
            
            cp.setMontoTotal(total);

            //out.add(cp);
        }

        return out;

    }

}
