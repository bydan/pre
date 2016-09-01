/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.inventario.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.inventario.util.MovimientoInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.MovimientoInventarioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.MovimientoInventarioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class MovimientoInventarioConstantesFunciones extends MovimientoInventarioConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,-10);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="MovimientoInventario";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="MovimientoInventario"+MovimientoInventarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="MovimientoInventarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="MovimientoInventarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=MovimientoInventarioConstantesFunciones.SCHEMA+"_"+MovimientoInventarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/MovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=MovimientoInventarioConstantesFunciones.SCHEMA+"_"+MovimientoInventarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=MovimientoInventarioConstantesFunciones.SCHEMA+"_"+MovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/MovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=MovimientoInventarioConstantesFunciones.SCHEMA+"_"+MovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MovimientoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MovimientoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=MovimientoInventarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+MovimientoInventarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=MovimientoInventarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+MovimientoInventarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Movimiento Inventarios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Movimiento Inventario";
	public static final String SCLASSWEBTITULO_LOWER="Movimiento Inventario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="MovimientoInventario";
	public static final String OBJECTNAME="movimientoinventario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="movimiento_inventario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select movimientoinventario from "+MovimientoInventarioConstantesFunciones.SPERSISTENCENAME+" movimientoinventario";
	public static String QUERYSELECTNATIVE="select "+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".version_row,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_empresa,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_sucursal,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_modulo,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_ejercicio,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_periodo,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_anio,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_mes,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_usuario,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_transaccion,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".fecha_emision,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".fecha_entrega,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".numero_secuencial,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_moneda,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_tipo_cambio,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_estado_movimiento_inventario,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_empleado,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_formato,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_factura,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".numero_factura,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_guia_remision,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_transportista,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".descripcion,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".porcentaje_descuento,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".suman,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".ice,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".valor_descuento,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".total_descuento,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".iva,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".stock,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".sub_total,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".total_otro,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".ultimo_costo,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".numero_items,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".retencion,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".total,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".flete,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".impuesto,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_compra,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_asiento_contable,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".generico_id,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".tipo_id,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".numero_comprobante,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".fecha from "+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME;//+" as "+MovimientoInventarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected MovimientoInventarioConstantesFuncionesAdditional movimientoinventarioConstantesFuncionesAdditional=null;
	
	public MovimientoInventarioConstantesFuncionesAdditional getMovimientoInventarioConstantesFuncionesAdditional() {
		return this.movimientoinventarioConstantesFuncionesAdditional;
	}
	
	public void setMovimientoInventarioConstantesFuncionesAdditional(MovimientoInventarioConstantesFuncionesAdditional movimientoinventarioConstantesFuncionesAdditional) {
		try {
			this.movimientoinventarioConstantesFuncionesAdditional=movimientoinventarioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDMODULO= "id_modulo";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAENTREGA= "fecha_entrega";
    public static final String NUMEROSECUENCIAL= "numero_secuencial";
    public static final String IDMONEDA= "id_moneda";
    public static final String IDTIPOCAMBIO= "id_tipo_cambio";
    public static final String IDESTADOMOVIMIENTOINVENTARIO= "id_estado_movimiento_inventario";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDFORMATO= "id_formato";
    public static final String IDFACTURA= "id_factura";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String IDGUIAREMISION= "id_guia_remision";
    public static final String IDTRANSPORTISTA= "id_transportista";
    public static final String DESCRIPCION= "descripcion";
    public static final String PORCENTAJEDESCUENTO= "porcentaje_descuento";
    public static final String SUMAN= "suman";
    public static final String ICE= "ice";
    public static final String VALORDESCUENTO= "valor_descuento";
    public static final String TOTALDESCUENTO= "total_descuento";
    public static final String IVA= "iva";
    public static final String STOCK= "stock";
    public static final String SUBTOTAL= "sub_total";
    public static final String TOTALOTRO= "total_otro";
    public static final String ULTIMOCOSTO= "ultimo_costo";
    public static final String NUMEROITEMS= "numero_items";
    public static final String RETENCION= "retencion";
    public static final String TOTAL= "total";
    public static final String FLETE= "flete";
    public static final String IMPUESTO= "impuesto";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
    public static final String IDCOMPRA= "id_compra";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String GENERICOID= "generico_id";
    public static final String TIPOID= "tipo_id";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String FECHA= "fecha";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDTRANSACCION= "Tipo";
		public static final String LABEL_IDTRANSACCION_LOWER= "Tipo";
    	public static final String LABEL_FECHAEMISION= "F Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "F Emision";
    	public static final String LABEL_FECHAENTREGA= "F Entrega";
		public static final String LABEL_FECHAENTREGA_LOWER= "F Entrega";
    	public static final String LABEL_NUMEROSECUENCIAL= "No Secuencial";
		public static final String LABEL_NUMEROSECUENCIAL_LOWER= "No Secuen";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_IDTIPOCAMBIO= "T Cambio";
		public static final String LABEL_IDTIPOCAMBIO_LOWER= "Tipo Cambio";
    	public static final String LABEL_IDESTADOMOVIMIENTOINVENTARIO= "Estado";
		public static final String LABEL_IDESTADOMOVIMIENTOINVENTARIO_LOWER= "Estado";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_NUMEROFACTURA= "No Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_IDGUIAREMISION= "Guia Remision";
		public static final String LABEL_IDGUIAREMISION_LOWER= "Guia Remision";
    	public static final String LABEL_IDTRANSPORTISTA= "Transportista";
		public static final String LABEL_IDTRANSPORTISTA_LOWER= "Transportista";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_PORCENTAJEDESCUENTO= "Descuento %";
		public static final String LABEL_PORCENTAJEDESCUENTO_LOWER= "% Descuento";
    	public static final String LABEL_SUMAN= "Suman";
		public static final String LABEL_SUMAN_LOWER= "Suman";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_VALORDESCUENTO= "Descuento Valor";
		public static final String LABEL_VALORDESCUENTO_LOWER= "Val Desc";
    	public static final String LABEL_TOTALDESCUENTO= "Total Descuento";
		public static final String LABEL_TOTALDESCUENTO_LOWER= "Total Desc";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_STOCK= "Stock";
		public static final String LABEL_STOCK_LOWER= "Stock";
    	public static final String LABEL_SUBTOTAL= "Sub Total";
		public static final String LABEL_SUBTOTAL_LOWER= "Sub Total";
    	public static final String LABEL_TOTALOTRO= "Total Otro";
		public static final String LABEL_TOTALOTRO_LOWER= "Total Otro";
    	public static final String LABEL_ULTIMOCOSTO= "Ultimo Costo";
		public static final String LABEL_ULTIMOCOSTO_LOWER= "Ultimo Costo";
    	public static final String LABEL_NUMEROITEMS= "No Items";
		public static final String LABEL_NUMEROITEMS_LOWER= "No Items";
    	public static final String LABEL_RETENCION= "Retencion";
		public static final String LABEL_RETENCION_LOWER= "Retencion";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_IMPUESTO= "Impuesto";
		public static final String LABEL_IMPUESTO_LOWER= "Impuesto";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Transaccion Modulo";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo";
    	public static final String LABEL_IDCOMPRA= "Compra";
		public static final String LABEL_IDCOMPRA_LOWER= "Compra";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_GENERICOID= "Generico Id";
		public static final String LABEL_GENERICOID_LOWER= "Generico Id";
    	public static final String LABEL_TIPOID= "Tipo Id";
		public static final String LABEL_TIPOID_LOWER= "Tipo Id";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXTIPO_ID=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO_ID=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getMovimientoInventarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDEMPRESA)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDSUCURSAL)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDMODULO)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDEJERCICIO)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDPERIODO)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDANIO)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDMES)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDUSUARIO)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDTRANSACCION)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.FECHAEMISION)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.FECHAENTREGA)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_FECHAENTREGA;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.NUMEROSECUENCIAL)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_NUMEROSECUENCIAL;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDMONEDA)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDESTADOMOVIMIENTOINVENTARIO)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDESTADOMOVIMIENTOINVENTARIO;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDEMPLEADO)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDFORMATO)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDFACTURA)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDGUIAREMISION)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDGUIAREMISION;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDTRANSPORTISTA)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDTRANSPORTISTA;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.DESCRIPCION)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.PORCENTAJEDESCUENTO)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_PORCENTAJEDESCUENTO;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.SUMAN)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_SUMAN;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.ICE)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.VALORDESCUENTO)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_VALORDESCUENTO;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.TOTALDESCUENTO)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_TOTALDESCUENTO;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IVA)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.STOCK)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_STOCK;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.SUBTOTAL)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.TOTALOTRO)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_TOTALOTRO;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.ULTIMOCOSTO)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_ULTIMOCOSTO;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.NUMEROITEMS)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_NUMEROITEMS;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.RETENCION)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_RETENCION;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.TOTAL)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.FLETE)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IMPUESTO)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IMPUESTO;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDCOMPRA)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDCOMPRA;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.GENERICOID)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_GENERICOID;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.TIPOID)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_TIPOID;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(MovimientoInventarioConstantesFunciones.FECHA)) {sLabelColumna=MovimientoInventarioConstantesFunciones.LABEL_FECHA;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getMovimientoInventarioDescripcion(MovimientoInventario movimientoinventario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(movimientoinventario !=null/* && movimientoinventario.getId()!=0*/) {
			if(movimientoinventario.getId()!=null) {
				sDescripcion=movimientoinventario.getId().toString();
			}//movimientoinventariomovimientoinventario.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getMovimientoInventarioDescripcionDetallado(MovimientoInventario movimientoinventario) {
		String sDescripcion="";
			
		sDescripcion+=MovimientoInventarioConstantesFunciones.ID+"=";
		sDescripcion+=movimientoinventario.getId().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=movimientoinventario.getVersionRow().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=movimientoinventario.getid_empresa().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=movimientoinventario.getid_sucursal().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDMODULO+"=";
		sDescripcion+=movimientoinventario.getid_modulo().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=movimientoinventario.getid_ejercicio().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=movimientoinventario.getid_periodo().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDANIO+"=";
		sDescripcion+=movimientoinventario.getid_anio().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDMES+"=";
		sDescripcion+=movimientoinventario.getid_mes().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=movimientoinventario.getid_usuario().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=movimientoinventario.getid_transaccion().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=movimientoinventario.getfecha_emision().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.FECHAENTREGA+"=";
		sDescripcion+=movimientoinventario.getfecha_entrega().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.NUMEROSECUENCIAL+"=";
		sDescripcion+=movimientoinventario.getnumero_secuencial()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=movimientoinventario.getid_moneda().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=movimientoinventario.getid_tipo_cambio().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDESTADOMOVIMIENTOINVENTARIO+"=";
		sDescripcion+=movimientoinventario.getid_estado_movimiento_inventario().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=movimientoinventario.getid_empleado().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=movimientoinventario.getid_formato().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=movimientoinventario.getid_factura().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=movimientoinventario.getnumero_factura()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDGUIAREMISION+"=";
		sDescripcion+=movimientoinventario.getid_guia_remision().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDTRANSPORTISTA+"=";
		sDescripcion+=movimientoinventario.getid_transportista().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=movimientoinventario.getdescripcion()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.PORCENTAJEDESCUENTO+"=";
		sDescripcion+=movimientoinventario.getporcentaje_descuento().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.SUMAN+"=";
		sDescripcion+=movimientoinventario.getsuman().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.ICE+"=";
		sDescripcion+=movimientoinventario.getice().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.VALORDESCUENTO+"=";
		sDescripcion+=movimientoinventario.getvalor_descuento().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.TOTALDESCUENTO+"=";
		sDescripcion+=movimientoinventario.gettotal_descuento().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IVA+"=";
		sDescripcion+=movimientoinventario.getiva().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.STOCK+"=";
		sDescripcion+=movimientoinventario.getstock().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=movimientoinventario.getsub_total().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.TOTALOTRO+"=";
		sDescripcion+=movimientoinventario.gettotal_otro().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.ULTIMOCOSTO+"=";
		sDescripcion+=movimientoinventario.getultimo_costo().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.NUMEROITEMS+"=";
		sDescripcion+=movimientoinventario.getnumero_items().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.RETENCION+"=";
		sDescripcion+=movimientoinventario.getretencion().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.TOTAL+"=";
		sDescripcion+=movimientoinventario.gettotal().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.FLETE+"=";
		sDescripcion+=movimientoinventario.getflete().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IMPUESTO+"=";
		sDescripcion+=movimientoinventario.getimpuesto().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=movimientoinventario.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDCOMPRA+"=";
		sDescripcion+=movimientoinventario.getid_compra().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=movimientoinventario.getid_asiento_contable().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.GENERICOID+"=";
		sDescripcion+=movimientoinventario.getgenerico_id().toString()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.TIPOID+"=";
		sDescripcion+=movimientoinventario.gettipo_id()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=movimientoinventario.getnumero_comprobante()+",";
		sDescripcion+=MovimientoInventarioConstantesFunciones.FECHA+"=";
		sDescripcion+=movimientoinventario.getfecha().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setMovimientoInventarioDescripcion(MovimientoInventario movimientoinventario,String sValor) throws Exception {			
		if(movimientoinventario !=null) {
			//movimientoinventariomovimientoinventario.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
		}

		return sDescripcion;
	}

	public static String getTipoCambioDescripcion(TipoCambio tipocambio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocambio!=null/*&&tipocambio.getId()>0*/) {
			sDescripcion=TipoCambioConstantesFunciones.getTipoCambioDescripcion(tipocambio);
		}

		return sDescripcion;
	}

	public static String getEstadoMovimientoInventarioDescripcion(EstadoMovimientoInventario estadomovimientoinventario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadomovimientoinventario!=null/*&&estadomovimientoinventario.getId()>0*/) {
			sDescripcion=EstadoMovimientoInventarioConstantesFunciones.getEstadoMovimientoInventarioDescripcion(estadomovimientoinventario);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
		}

		return sDescripcion;
	}

	public static String getGuiaRemisionDescripcion(GuiaRemision guiaremision) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(guiaremision!=null/*&&guiaremision.getId()>0*/) {
			sDescripcion=GuiaRemisionConstantesFunciones.getGuiaRemisionDescripcion(guiaremision);
		}

		return sDescripcion;
	}

	public static String getTransportistaDescripcion(Transportista transportista) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transportista!=null/*&&transportista.getId()>0*/) {
			sDescripcion=TransportistaConstantesFunciones.getTransportistaDescripcion(transportista);
		}

		return sDescripcion;
	}

	public static String getTipoTransaccionModuloDescripcion(TipoTransaccionModulo tipotransaccionmodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotransaccionmodulo!=null/*&&tipotransaccionmodulo.getId()>0*/) {
			sDescripcion=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(tipotransaccionmodulo);
		}

		return sDescripcion;
	}

	public static String getCompraDescripcion(Compra compra) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(compra!=null/*&&compra.getId()>0*/) {
			sDescripcion=CompraConstantesFunciones.getCompraDescripcion(compra);
		}

		return sDescripcion;
	}

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdCompra")) {
			sNombreIndice="Tipo=  Por Compra";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoMovimientoInventario")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdGuiaRemision")) {
			sNombreIndice="Tipo=  Por Guia Remision";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCambio")) {
			sNombreIndice="Tipo=  Por T Cambio";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Transaccion Modulo";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Tipo";
		} else if(sNombreIndice.equals("FK_IdTransportista")) {
			sNombreIndice="Tipo=  Por Transportista";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento Contable="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCompra(Long id_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_compra!=null) {sDetalleIndice+=" Codigo Unico De Compra="+id_compra.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoMovimientoInventario(Long id_estado_movimiento_inventario) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_movimiento_inventario!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_movimiento_inventario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFactura(Long id_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_factura!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdGuiaRemision(Long id_guia_remision) {
		String sDetalleIndice=" Parametros->";
		if(id_guia_remision!=null) {sDetalleIndice+=" Codigo Unico De Guia Remision="+id_guia_remision.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCambio(Long id_tipo_cambio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cambio!=null) {sDetalleIndice+=" Codigo Unico De T Cambio="+id_tipo_cambio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTransaccionModulo(Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion Modulo="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Tipo="+id_transaccion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransportista(Long id_transportista) {
		String sDetalleIndice=" Parametros->";
		if(id_transportista!=null) {sDetalleIndice+=" Codigo Unico De Transportista="+id_transportista.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosMovimientoInventario(MovimientoInventario movimientoinventario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		movimientoinventario.setnumero_secuencial(movimientoinventario.getnumero_secuencial().trim());
		movimientoinventario.setnumero_factura(movimientoinventario.getnumero_factura().trim());
		movimientoinventario.setdescripcion(movimientoinventario.getdescripcion().trim());
		movimientoinventario.settipo_id(movimientoinventario.gettipo_id().trim());
		movimientoinventario.setnumero_comprobante(movimientoinventario.getnumero_comprobante().trim());
	}
	
	public static void quitarEspaciosMovimientoInventarios(List<MovimientoInventario> movimientoinventarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MovimientoInventario movimientoinventario: movimientoinventarios) {
			movimientoinventario.setnumero_secuencial(movimientoinventario.getnumero_secuencial().trim());
			movimientoinventario.setnumero_factura(movimientoinventario.getnumero_factura().trim());
			movimientoinventario.setdescripcion(movimientoinventario.getdescripcion().trim());
			movimientoinventario.settipo_id(movimientoinventario.gettipo_id().trim());
			movimientoinventario.setnumero_comprobante(movimientoinventario.getnumero_comprobante().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMovimientoInventario(MovimientoInventario movimientoinventario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && movimientoinventario.getConCambioAuxiliar()) {
			movimientoinventario.setIsDeleted(movimientoinventario.getIsDeletedAuxiliar());	
			movimientoinventario.setIsNew(movimientoinventario.getIsNewAuxiliar());	
			movimientoinventario.setIsChanged(movimientoinventario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			movimientoinventario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			movimientoinventario.setIsDeletedAuxiliar(false);	
			movimientoinventario.setIsNewAuxiliar(false);	
			movimientoinventario.setIsChangedAuxiliar(false);
			
			movimientoinventario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMovimientoInventarios(List<MovimientoInventario> movimientoinventarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(MovimientoInventario movimientoinventario : movimientoinventarios) {
			if(conAsignarBase && movimientoinventario.getConCambioAuxiliar()) {
				movimientoinventario.setIsDeleted(movimientoinventario.getIsDeletedAuxiliar());	
				movimientoinventario.setIsNew(movimientoinventario.getIsNewAuxiliar());	
				movimientoinventario.setIsChanged(movimientoinventario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				movimientoinventario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				movimientoinventario.setIsDeletedAuxiliar(false);	
				movimientoinventario.setIsNewAuxiliar(false);	
				movimientoinventario.setIsChangedAuxiliar(false);
				
				movimientoinventario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresMovimientoInventario(MovimientoInventario movimientoinventario,Boolean conEnteros) throws Exception  {
		movimientoinventario.setporcentaje_descuento(0.0);
		movimientoinventario.setsuman(0.0);
		movimientoinventario.setice(0.0);
		movimientoinventario.setvalor_descuento(0.0);
		movimientoinventario.settotal_descuento(0.0);
		movimientoinventario.setiva(0.0);
		movimientoinventario.setstock(0.0);
		movimientoinventario.setsub_total(0.0);
		movimientoinventario.settotal_otro(0.0);
		movimientoinventario.setultimo_costo(0.0);
		movimientoinventario.setretencion(0.0);
		movimientoinventario.settotal(0.0);
		movimientoinventario.setflete(0.0);
		movimientoinventario.setimpuesto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			movimientoinventario.setnumero_items(0);
			movimientoinventario.setgenerico_id(0L);
		}
	}		
	
	public static void InicializarValoresMovimientoInventarios(List<MovimientoInventario> movimientoinventarios,Boolean conEnteros) throws Exception  {
		
		for(MovimientoInventario movimientoinventario: movimientoinventarios) {
			movimientoinventario.setporcentaje_descuento(0.0);
			movimientoinventario.setsuman(0.0);
			movimientoinventario.setice(0.0);
			movimientoinventario.setvalor_descuento(0.0);
			movimientoinventario.settotal_descuento(0.0);
			movimientoinventario.setiva(0.0);
			movimientoinventario.setstock(0.0);
			movimientoinventario.setsub_total(0.0);
			movimientoinventario.settotal_otro(0.0);
			movimientoinventario.setultimo_costo(0.0);
			movimientoinventario.setretencion(0.0);
			movimientoinventario.settotal(0.0);
			movimientoinventario.setflete(0.0);
			movimientoinventario.setimpuesto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				movimientoinventario.setnumero_items(0);
				movimientoinventario.setgenerico_id(0L);
			}
		}				
	}
	
	public static void TotalizarValoresFilaMovimientoInventario(List<MovimientoInventario> movimientoinventarios,MovimientoInventario movimientoinventarioAux) throws Exception  {
		MovimientoInventarioConstantesFunciones.InicializarValoresMovimientoInventario(movimientoinventarioAux,true);
		
		for(MovimientoInventario movimientoinventario: movimientoinventarios) {
			if(movimientoinventario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			movimientoinventarioAux.setporcentaje_descuento(movimientoinventarioAux.getporcentaje_descuento()+movimientoinventario.getporcentaje_descuento());			
			movimientoinventarioAux.setsuman(movimientoinventarioAux.getsuman()+movimientoinventario.getsuman());			
			movimientoinventarioAux.setice(movimientoinventarioAux.getice()+movimientoinventario.getice());			
			movimientoinventarioAux.setvalor_descuento(movimientoinventarioAux.getvalor_descuento()+movimientoinventario.getvalor_descuento());			
			movimientoinventarioAux.settotal_descuento(movimientoinventarioAux.gettotal_descuento()+movimientoinventario.gettotal_descuento());			
			movimientoinventarioAux.setiva(movimientoinventarioAux.getiva()+movimientoinventario.getiva());			
			movimientoinventarioAux.setstock(movimientoinventarioAux.getstock()+movimientoinventario.getstock());			
			movimientoinventarioAux.setsub_total(movimientoinventarioAux.getsub_total()+movimientoinventario.getsub_total());			
			movimientoinventarioAux.settotal_otro(movimientoinventarioAux.gettotal_otro()+movimientoinventario.gettotal_otro());			
			movimientoinventarioAux.setultimo_costo(movimientoinventarioAux.getultimo_costo()+movimientoinventario.getultimo_costo());			
			movimientoinventarioAux.setnumero_items(movimientoinventarioAux.getnumero_items()+movimientoinventario.getnumero_items());			
			movimientoinventarioAux.setretencion(movimientoinventarioAux.getretencion()+movimientoinventario.getretencion());			
			movimientoinventarioAux.settotal(movimientoinventarioAux.gettotal()+movimientoinventario.gettotal());			
			movimientoinventarioAux.setflete(movimientoinventarioAux.getflete()+movimientoinventario.getflete());			
			movimientoinventarioAux.setimpuesto(movimientoinventarioAux.getimpuesto()+movimientoinventario.getimpuesto());			
			movimientoinventarioAux.setgenerico_id(movimientoinventarioAux.getgenerico_id()+movimientoinventario.getgenerico_id());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMovimientoInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=MovimientoInventarioConstantesFunciones.getArrayColumnasGlobalesMovimientoInventario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesMovimientoInventario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MovimientoInventarioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MovimientoInventarioConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MovimientoInventarioConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MovimientoInventarioConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MovimientoInventarioConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MovimientoInventarioConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MovimientoInventarioConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MovimientoInventarioConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MovimientoInventarioConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MovimientoInventarioConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MovimientoInventarioConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MovimientoInventarioConstantesFunciones.IDUSUARIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MovimientoInventarioConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MovimientoInventarioConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoMovimientoInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MovimientoInventario> movimientoinventarios,MovimientoInventario movimientoinventario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MovimientoInventario movimientoinventarioAux: movimientoinventarios) {
			if(movimientoinventarioAux!=null && movimientoinventario!=null) {
				if((movimientoinventarioAux.getId()==null && movimientoinventario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(movimientoinventarioAux.getId()!=null && movimientoinventario.getId()!=null){
					if(movimientoinventarioAux.getId().equals(movimientoinventario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMovimientoInventario(List<MovimientoInventario> movimientoinventarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentaje_descuentoTotal=0.0;
		Double sumanTotal=0.0;
		Double iceTotal=0.0;
		Double valor_descuentoTotal=0.0;
		Double total_descuentoTotal=0.0;
		Double ivaTotal=0.0;
		Double stockTotal=0.0;
		Double sub_totalTotal=0.0;
		Double total_otroTotal=0.0;
		Double ultimo_costoTotal=0.0;
		Double retencionTotal=0.0;
		Double totalTotal=0.0;
		Double fleteTotal=0.0;
		Double impuestoTotal=0.0;
	
		for(MovimientoInventario movimientoinventario: movimientoinventarios) {			
			if(movimientoinventario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentaje_descuentoTotal+=movimientoinventario.getporcentaje_descuento();
			sumanTotal+=movimientoinventario.getsuman();
			iceTotal+=movimientoinventario.getice();
			valor_descuentoTotal+=movimientoinventario.getvalor_descuento();
			total_descuentoTotal+=movimientoinventario.gettotal_descuento();
			ivaTotal+=movimientoinventario.getiva();
			stockTotal+=movimientoinventario.getstock();
			sub_totalTotal+=movimientoinventario.getsub_total();
			total_otroTotal+=movimientoinventario.gettotal_otro();
			ultimo_costoTotal+=movimientoinventario.getultimo_costo();
			retencionTotal+=movimientoinventario.getretencion();
			totalTotal+=movimientoinventario.gettotal();
			fleteTotal+=movimientoinventario.getflete();
			impuestoTotal+=movimientoinventario.getimpuesto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoInventarioConstantesFunciones.PORCENTAJEDESCUENTO);
		datoGeneral.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
		datoGeneral.setdValorDouble(porcentaje_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoInventarioConstantesFunciones.SUMAN);
		datoGeneral.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_SUMAN);
		datoGeneral.setdValorDouble(sumanTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoInventarioConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoInventarioConstantesFunciones.VALORDESCUENTO);
		datoGeneral.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_VALORDESCUENTO);
		datoGeneral.setdValorDouble(valor_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoInventarioConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoInventarioConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoInventarioConstantesFunciones.STOCK);
		datoGeneral.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_STOCK);
		datoGeneral.setdValorDouble(stockTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoInventarioConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoInventarioConstantesFunciones.TOTALOTRO);
		datoGeneral.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_TOTALOTRO);
		datoGeneral.setdValorDouble(total_otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoInventarioConstantesFunciones.ULTIMOCOSTO);
		datoGeneral.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_ULTIMOCOSTO);
		datoGeneral.setdValorDouble(ultimo_costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoInventarioConstantesFunciones.RETENCION);
		datoGeneral.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_RETENCION);
		datoGeneral.setdValorDouble(retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoInventarioConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoInventarioConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoInventarioConstantesFunciones.IMPUESTO);
		datoGeneral.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IMPUESTO);
		datoGeneral.setdValorDouble(impuestoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaMovimientoInventario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_ID, MovimientoInventarioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_VERSIONROW, MovimientoInventarioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDEMPRESA, MovimientoInventarioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDSUCURSAL, MovimientoInventarioConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDMODULO, MovimientoInventarioConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDEJERCICIO, MovimientoInventarioConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDPERIODO, MovimientoInventarioConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDANIO, MovimientoInventarioConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDMES, MovimientoInventarioConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDUSUARIO, MovimientoInventarioConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDTRANSACCION, MovimientoInventarioConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_FECHAEMISION, MovimientoInventarioConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_FECHAENTREGA, MovimientoInventarioConstantesFunciones.FECHAENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_NUMEROSECUENCIAL, MovimientoInventarioConstantesFunciones.NUMEROSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDMONEDA, MovimientoInventarioConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDTIPOCAMBIO, MovimientoInventarioConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDESTADOMOVIMIENTOINVENTARIO, MovimientoInventarioConstantesFunciones.IDESTADOMOVIMIENTOINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDEMPLEADO, MovimientoInventarioConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDFORMATO, MovimientoInventarioConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDFACTURA, MovimientoInventarioConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_NUMEROFACTURA, MovimientoInventarioConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDGUIAREMISION, MovimientoInventarioConstantesFunciones.IDGUIAREMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDTRANSPORTISTA, MovimientoInventarioConstantesFunciones.IDTRANSPORTISTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_DESCRIPCION, MovimientoInventarioConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_PORCENTAJEDESCUENTO, MovimientoInventarioConstantesFunciones.PORCENTAJEDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_SUMAN, MovimientoInventarioConstantesFunciones.SUMAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_ICE, MovimientoInventarioConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_VALORDESCUENTO, MovimientoInventarioConstantesFunciones.VALORDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_TOTALDESCUENTO, MovimientoInventarioConstantesFunciones.TOTALDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IVA, MovimientoInventarioConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_STOCK, MovimientoInventarioConstantesFunciones.STOCK,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_SUBTOTAL, MovimientoInventarioConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_TOTALOTRO, MovimientoInventarioConstantesFunciones.TOTALOTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_ULTIMOCOSTO, MovimientoInventarioConstantesFunciones.ULTIMOCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_NUMEROITEMS, MovimientoInventarioConstantesFunciones.NUMEROITEMS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_RETENCION, MovimientoInventarioConstantesFunciones.RETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_TOTAL, MovimientoInventarioConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_FLETE, MovimientoInventarioConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IMPUESTO, MovimientoInventarioConstantesFunciones.IMPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, MovimientoInventarioConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDCOMPRA, MovimientoInventarioConstantesFunciones.IDCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_IDASIENTOCONTABLE, MovimientoInventarioConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_GENERICOID, MovimientoInventarioConstantesFunciones.GENERICOID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_TIPOID, MovimientoInventarioConstantesFunciones.TIPOID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_NUMEROCOMPROBANTE, MovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoInventarioConstantesFunciones.LABEL_FECHA, MovimientoInventarioConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasMovimientoInventario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.FECHAENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.NUMEROSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDESTADOMOVIMIENTOINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDGUIAREMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDTRANSPORTISTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.PORCENTAJEDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.SUMAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.VALORDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.TOTALDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.STOCK;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.TOTALOTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.ULTIMOCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.NUMEROITEMS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.RETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IMPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.GENERICOID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.TIPOID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoInventarioConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMovimientoInventario() throws Exception  {
		return MovimientoInventarioConstantesFunciones.getTiposSeleccionarMovimientoInventario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMovimientoInventario(Boolean conFk) throws Exception  {
		return MovimientoInventarioConstantesFunciones.getTiposSeleccionarMovimientoInventario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMovimientoInventario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_FECHAENTREGA);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_FECHAENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_NUMEROSECUENCIAL);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_NUMEROSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDESTADOMOVIMIENTOINVENTARIO);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDESTADOMOVIMIENTOINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDGUIAREMISION);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDGUIAREMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDTRANSPORTISTA);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDTRANSPORTISTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_SUMAN);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_SUMAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_VALORDESCUENTO);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_VALORDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_TOTALDESCUENTO);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_TOTALDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_STOCK);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_STOCK);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_TOTALOTRO);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_TOTALOTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_ULTIMOCOSTO);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_ULTIMOCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_NUMEROITEMS);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_NUMEROITEMS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_RETENCION);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_RETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IMPUESTO);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IMPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDCOMPRA);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_GENERICOID);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_GENERICOID);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_TIPOID);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_TIPOID);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoInventarioConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(MovimientoInventarioConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesMovimientoInventario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesMovimientoInventario(MovimientoInventario movimientoinventarioAux) throws Exception {
		
			movimientoinventarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(movimientoinventarioAux.getEmpresa()));
			movimientoinventarioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(movimientoinventarioAux.getSucursal()));
			movimientoinventarioAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(movimientoinventarioAux.getModulo()));
			movimientoinventarioAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(movimientoinventarioAux.getEjercicio()));
			movimientoinventarioAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(movimientoinventarioAux.getPeriodo()));
			movimientoinventarioAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(movimientoinventarioAux.getAnio()));
			movimientoinventarioAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(movimientoinventarioAux.getMes()));
			movimientoinventarioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(movimientoinventarioAux.getUsuario()));
			movimientoinventarioAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(movimientoinventarioAux.getTransaccion()));
			movimientoinventarioAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(movimientoinventarioAux.getMoneda()));
			movimientoinventarioAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(movimientoinventarioAux.getTipoCambio()));
			movimientoinventarioAux.setestadomovimientoinventario_descripcion(EstadoMovimientoInventarioConstantesFunciones.getEstadoMovimientoInventarioDescripcion(movimientoinventarioAux.getEstadoMovimientoInventario()));
			movimientoinventarioAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(movimientoinventarioAux.getEmpleado()));
			movimientoinventarioAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(movimientoinventarioAux.getFormato()));
			movimientoinventarioAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(movimientoinventarioAux.getFactura()));
			movimientoinventarioAux.setguiaremision_descripcion(GuiaRemisionConstantesFunciones.getGuiaRemisionDescripcion(movimientoinventarioAux.getGuiaRemision()));
			movimientoinventarioAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(movimientoinventarioAux.getTransportista()));
			movimientoinventarioAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(movimientoinventarioAux.getTipoTransaccionModulo()));
			movimientoinventarioAux.setcompra_descripcion(CompraConstantesFunciones.getCompraDescripcion(movimientoinventarioAux.getCompra()));
			movimientoinventarioAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(movimientoinventarioAux.getAsientoContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesMovimientoInventario(List<MovimientoInventario> movimientoinventariosTemp) throws Exception {
		for(MovimientoInventario movimientoinventarioAux:movimientoinventariosTemp) {
			
			movimientoinventarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(movimientoinventarioAux.getEmpresa()));
			movimientoinventarioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(movimientoinventarioAux.getSucursal()));
			movimientoinventarioAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(movimientoinventarioAux.getModulo()));
			movimientoinventarioAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(movimientoinventarioAux.getEjercicio()));
			movimientoinventarioAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(movimientoinventarioAux.getPeriodo()));
			movimientoinventarioAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(movimientoinventarioAux.getAnio()));
			movimientoinventarioAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(movimientoinventarioAux.getMes()));
			movimientoinventarioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(movimientoinventarioAux.getUsuario()));
			movimientoinventarioAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(movimientoinventarioAux.getTransaccion()));
			movimientoinventarioAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(movimientoinventarioAux.getMoneda()));
			movimientoinventarioAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(movimientoinventarioAux.getTipoCambio()));
			movimientoinventarioAux.setestadomovimientoinventario_descripcion(EstadoMovimientoInventarioConstantesFunciones.getEstadoMovimientoInventarioDescripcion(movimientoinventarioAux.getEstadoMovimientoInventario()));
			movimientoinventarioAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(movimientoinventarioAux.getEmpleado()));
			movimientoinventarioAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(movimientoinventarioAux.getFormato()));
			movimientoinventarioAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(movimientoinventarioAux.getFactura()));
			movimientoinventarioAux.setguiaremision_descripcion(GuiaRemisionConstantesFunciones.getGuiaRemisionDescripcion(movimientoinventarioAux.getGuiaRemision()));
			movimientoinventarioAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(movimientoinventarioAux.getTransportista()));
			movimientoinventarioAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(movimientoinventarioAux.getTipoTransaccionModulo()));
			movimientoinventarioAux.setcompra_descripcion(CompraConstantesFunciones.getCompraDescripcion(movimientoinventarioAux.getCompra()));
			movimientoinventarioAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(movimientoinventarioAux.getAsientoContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(TipoCambio.class));
				classes.add(new Classe(EstadoMovimientoInventario.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(GuiaRemision.class));
				classes.add(new Classe(Transportista.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
				classes.add(new Classe(Compra.class));
				classes.add(new Classe(AsientoContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCambio.class)) {
						classes.add(new Classe(TipoCambio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoMovimientoInventario.class)) {
						classes.add(new Classe(EstadoMovimientoInventario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GuiaRemision.class)) {
						classes.add(new Classe(GuiaRemision.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transportista.class)) {
						classes.add(new Classe(Transportista.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransaccionModulo.class)) {
						classes.add(new Classe(TipoTransaccionModulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Compra.class)) {
						classes.add(new Classe(Compra.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfMovimientoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(EstadoMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoMovimientoInventario.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(GuiaRemision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GuiaRemision.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(Compra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Compra.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(EstadoMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoMovimientoInventario.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(GuiaRemision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GuiaRemision.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(Compra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Compra.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return MovimientoInventarioConstantesFunciones.getClassesRelationshipsOfMovimientoInventario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMovimientoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleMovimientoInventario.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleMovimientoInventario.class)) {
						classes.add(new Classe(DetalleMovimientoInventario.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMovimientoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return MovimientoInventarioConstantesFunciones.getClassesRelationshipsFromStringsOfMovimientoInventario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMovimientoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMovimientoInventario.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMovimientoInventario.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(MovimientoInventario movimientoinventario,List<MovimientoInventario> movimientoinventarios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			MovimientoInventario movimientoinventarioEncontrado=null;
			
			for(MovimientoInventario movimientoinventarioLocal:movimientoinventarios) {
				if(movimientoinventarioLocal.getId().equals(movimientoinventario.getId())) {
					movimientoinventarioEncontrado=movimientoinventarioLocal;
					
					movimientoinventarioLocal.setIsChanged(movimientoinventario.getIsChanged());
					movimientoinventarioLocal.setIsNew(movimientoinventario.getIsNew());
					movimientoinventarioLocal.setIsDeleted(movimientoinventario.getIsDeleted());
					
					movimientoinventarioLocal.setGeneralEntityOriginal(movimientoinventario.getGeneralEntityOriginal());
					
					movimientoinventarioLocal.setId(movimientoinventario.getId());	
					movimientoinventarioLocal.setVersionRow(movimientoinventario.getVersionRow());	
					movimientoinventarioLocal.setid_empresa(movimientoinventario.getid_empresa());	
					movimientoinventarioLocal.setid_sucursal(movimientoinventario.getid_sucursal());	
					movimientoinventarioLocal.setid_modulo(movimientoinventario.getid_modulo());	
					movimientoinventarioLocal.setid_ejercicio(movimientoinventario.getid_ejercicio());	
					movimientoinventarioLocal.setid_periodo(movimientoinventario.getid_periodo());	
					movimientoinventarioLocal.setid_anio(movimientoinventario.getid_anio());	
					movimientoinventarioLocal.setid_mes(movimientoinventario.getid_mes());	
					movimientoinventarioLocal.setid_usuario(movimientoinventario.getid_usuario());	
					movimientoinventarioLocal.setid_transaccion(movimientoinventario.getid_transaccion());	
					movimientoinventarioLocal.setfecha_emision(movimientoinventario.getfecha_emision());	
					movimientoinventarioLocal.setfecha_entrega(movimientoinventario.getfecha_entrega());	
					movimientoinventarioLocal.setnumero_secuencial(movimientoinventario.getnumero_secuencial());	
					movimientoinventarioLocal.setid_moneda(movimientoinventario.getid_moneda());	
					movimientoinventarioLocal.setid_tipo_cambio(movimientoinventario.getid_tipo_cambio());	
					movimientoinventarioLocal.setid_estado_movimiento_inventario(movimientoinventario.getid_estado_movimiento_inventario());	
					movimientoinventarioLocal.setid_empleado(movimientoinventario.getid_empleado());	
					movimientoinventarioLocal.setid_formato(movimientoinventario.getid_formato());	
					movimientoinventarioLocal.setid_factura(movimientoinventario.getid_factura());	
					movimientoinventarioLocal.setnumero_factura(movimientoinventario.getnumero_factura());	
					movimientoinventarioLocal.setid_guia_remision(movimientoinventario.getid_guia_remision());	
					movimientoinventarioLocal.setid_transportista(movimientoinventario.getid_transportista());	
					movimientoinventarioLocal.setdescripcion(movimientoinventario.getdescripcion());	
					movimientoinventarioLocal.setporcentaje_descuento(movimientoinventario.getporcentaje_descuento());	
					movimientoinventarioLocal.setsuman(movimientoinventario.getsuman());	
					movimientoinventarioLocal.setice(movimientoinventario.getice());	
					movimientoinventarioLocal.setvalor_descuento(movimientoinventario.getvalor_descuento());	
					movimientoinventarioLocal.settotal_descuento(movimientoinventario.gettotal_descuento());	
					movimientoinventarioLocal.setiva(movimientoinventario.getiva());	
					movimientoinventarioLocal.setstock(movimientoinventario.getstock());	
					movimientoinventarioLocal.setsub_total(movimientoinventario.getsub_total());	
					movimientoinventarioLocal.settotal_otro(movimientoinventario.gettotal_otro());	
					movimientoinventarioLocal.setultimo_costo(movimientoinventario.getultimo_costo());	
					movimientoinventarioLocal.setnumero_items(movimientoinventario.getnumero_items());	
					movimientoinventarioLocal.setretencion(movimientoinventario.getretencion());	
					movimientoinventarioLocal.settotal(movimientoinventario.gettotal());	
					movimientoinventarioLocal.setflete(movimientoinventario.getflete());	
					movimientoinventarioLocal.setimpuesto(movimientoinventario.getimpuesto());	
					movimientoinventarioLocal.setid_tipo_transaccion_modulo(movimientoinventario.getid_tipo_transaccion_modulo());	
					movimientoinventarioLocal.setid_compra(movimientoinventario.getid_compra());	
					movimientoinventarioLocal.setid_asiento_contable(movimientoinventario.getid_asiento_contable());	
					movimientoinventarioLocal.setgenerico_id(movimientoinventario.getgenerico_id());	
					movimientoinventarioLocal.settipo_id(movimientoinventario.gettipo_id());	
					movimientoinventarioLocal.setnumero_comprobante(movimientoinventario.getnumero_comprobante());	
					movimientoinventarioLocal.setfecha(movimientoinventario.getfecha());	
					
					
					movimientoinventarioLocal.setDetalleMovimientoInventarios(movimientoinventario.getDetalleMovimientoInventarios());
					
					existe=true;
					break;
				}
			}
			
			if(!movimientoinventario.getIsDeleted()) {
				if(!existe) {
					movimientoinventarios.add(movimientoinventario);
				}
			} else {
				if(movimientoinventarioEncontrado!=null && permiteQuitar)  {
					movimientoinventarios.remove(movimientoinventarioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(MovimientoInventario movimientoinventario,List<MovimientoInventario> movimientoinventarios) throws Exception {
		try	{			
			for(MovimientoInventario movimientoinventarioLocal:movimientoinventarios) {
				if(movimientoinventarioLocal.getId().equals(movimientoinventario.getId())) {
					movimientoinventarioLocal.setIsSelected(movimientoinventario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesMovimientoInventario(List<MovimientoInventario> movimientoinventariosAux) throws Exception {
		//this.movimientoinventariosAux=movimientoinventariosAux;
		
		for(MovimientoInventario movimientoinventarioAux:movimientoinventariosAux) {
			if(movimientoinventarioAux.getIsChanged()) {
				movimientoinventarioAux.setIsChanged(false);
			}		
			
			if(movimientoinventarioAux.getIsNew()) {
				movimientoinventarioAux.setIsNew(false);
			}	
			
			if(movimientoinventarioAux.getIsDeleted()) {
				movimientoinventarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesMovimientoInventario(MovimientoInventario movimientoinventarioAux) throws Exception {
		//this.movimientoinventarioAux=movimientoinventarioAux;
		
			if(movimientoinventarioAux.getIsChanged()) {
				movimientoinventarioAux.setIsChanged(false);
			}		
			
			if(movimientoinventarioAux.getIsNew()) {
				movimientoinventarioAux.setIsNew(false);
			}	
			
			if(movimientoinventarioAux.getIsDeleted()) {
				movimientoinventarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(MovimientoInventario movimientoinventarioAsignar,MovimientoInventario movimientoinventario) throws Exception {
		movimientoinventarioAsignar.setId(movimientoinventario.getId());	
		movimientoinventarioAsignar.setVersionRow(movimientoinventario.getVersionRow());	
		movimientoinventarioAsignar.setid_empresa(movimientoinventario.getid_empresa());
		movimientoinventarioAsignar.setempresa_descripcion(movimientoinventario.getempresa_descripcion());	
		movimientoinventarioAsignar.setid_sucursal(movimientoinventario.getid_sucursal());
		movimientoinventarioAsignar.setsucursal_descripcion(movimientoinventario.getsucursal_descripcion());	
		movimientoinventarioAsignar.setid_modulo(movimientoinventario.getid_modulo());
		movimientoinventarioAsignar.setmodulo_descripcion(movimientoinventario.getmodulo_descripcion());	
		movimientoinventarioAsignar.setid_ejercicio(movimientoinventario.getid_ejercicio());
		movimientoinventarioAsignar.setejercicio_descripcion(movimientoinventario.getejercicio_descripcion());	
		movimientoinventarioAsignar.setid_periodo(movimientoinventario.getid_periodo());
		movimientoinventarioAsignar.setperiodo_descripcion(movimientoinventario.getperiodo_descripcion());	
		movimientoinventarioAsignar.setid_anio(movimientoinventario.getid_anio());
		movimientoinventarioAsignar.setanio_descripcion(movimientoinventario.getanio_descripcion());	
		movimientoinventarioAsignar.setid_mes(movimientoinventario.getid_mes());
		movimientoinventarioAsignar.setmes_descripcion(movimientoinventario.getmes_descripcion());	
		movimientoinventarioAsignar.setid_usuario(movimientoinventario.getid_usuario());
		movimientoinventarioAsignar.setusuario_descripcion(movimientoinventario.getusuario_descripcion());	
		movimientoinventarioAsignar.setid_transaccion(movimientoinventario.getid_transaccion());
		movimientoinventarioAsignar.settransaccion_descripcion(movimientoinventario.gettransaccion_descripcion());	
		movimientoinventarioAsignar.setfecha_emision(movimientoinventario.getfecha_emision());	
		movimientoinventarioAsignar.setfecha_entrega(movimientoinventario.getfecha_entrega());	
		movimientoinventarioAsignar.setnumero_secuencial(movimientoinventario.getnumero_secuencial());	
		movimientoinventarioAsignar.setid_moneda(movimientoinventario.getid_moneda());
		movimientoinventarioAsignar.setmoneda_descripcion(movimientoinventario.getmoneda_descripcion());	
		movimientoinventarioAsignar.setid_tipo_cambio(movimientoinventario.getid_tipo_cambio());
		movimientoinventarioAsignar.settipocambio_descripcion(movimientoinventario.gettipocambio_descripcion());	
		movimientoinventarioAsignar.setid_estado_movimiento_inventario(movimientoinventario.getid_estado_movimiento_inventario());
		movimientoinventarioAsignar.setestadomovimientoinventario_descripcion(movimientoinventario.getestadomovimientoinventario_descripcion());	
		movimientoinventarioAsignar.setid_empleado(movimientoinventario.getid_empleado());
		movimientoinventarioAsignar.setempleado_descripcion(movimientoinventario.getempleado_descripcion());	
		movimientoinventarioAsignar.setid_formato(movimientoinventario.getid_formato());
		movimientoinventarioAsignar.setformato_descripcion(movimientoinventario.getformato_descripcion());	
		movimientoinventarioAsignar.setid_factura(movimientoinventario.getid_factura());
		movimientoinventarioAsignar.setfactura_descripcion(movimientoinventario.getfactura_descripcion());	
		movimientoinventarioAsignar.setnumero_factura(movimientoinventario.getnumero_factura());	
		movimientoinventarioAsignar.setid_guia_remision(movimientoinventario.getid_guia_remision());
		movimientoinventarioAsignar.setguiaremision_descripcion(movimientoinventario.getguiaremision_descripcion());	
		movimientoinventarioAsignar.setid_transportista(movimientoinventario.getid_transportista());
		movimientoinventarioAsignar.settransportista_descripcion(movimientoinventario.gettransportista_descripcion());	
		movimientoinventarioAsignar.setdescripcion(movimientoinventario.getdescripcion());	
		movimientoinventarioAsignar.setporcentaje_descuento(movimientoinventario.getporcentaje_descuento());	
		movimientoinventarioAsignar.setsuman(movimientoinventario.getsuman());	
		movimientoinventarioAsignar.setice(movimientoinventario.getice());	
		movimientoinventarioAsignar.setvalor_descuento(movimientoinventario.getvalor_descuento());	
		movimientoinventarioAsignar.settotal_descuento(movimientoinventario.gettotal_descuento());	
		movimientoinventarioAsignar.setiva(movimientoinventario.getiva());	
		movimientoinventarioAsignar.setstock(movimientoinventario.getstock());	
		movimientoinventarioAsignar.setsub_total(movimientoinventario.getsub_total());	
		movimientoinventarioAsignar.settotal_otro(movimientoinventario.gettotal_otro());	
		movimientoinventarioAsignar.setultimo_costo(movimientoinventario.getultimo_costo());	
		movimientoinventarioAsignar.setnumero_items(movimientoinventario.getnumero_items());	
		movimientoinventarioAsignar.setretencion(movimientoinventario.getretencion());	
		movimientoinventarioAsignar.settotal(movimientoinventario.gettotal());	
		movimientoinventarioAsignar.setflete(movimientoinventario.getflete());	
		movimientoinventarioAsignar.setimpuesto(movimientoinventario.getimpuesto());	
		movimientoinventarioAsignar.setid_tipo_transaccion_modulo(movimientoinventario.getid_tipo_transaccion_modulo());
		movimientoinventarioAsignar.settipotransaccionmodulo_descripcion(movimientoinventario.gettipotransaccionmodulo_descripcion());	
		movimientoinventarioAsignar.setid_compra(movimientoinventario.getid_compra());
		movimientoinventarioAsignar.setcompra_descripcion(movimientoinventario.getcompra_descripcion());	
		movimientoinventarioAsignar.setid_asiento_contable(movimientoinventario.getid_asiento_contable());
		movimientoinventarioAsignar.setasientocontable_descripcion(movimientoinventario.getasientocontable_descripcion());	
		movimientoinventarioAsignar.setgenerico_id(movimientoinventario.getgenerico_id());	
		movimientoinventarioAsignar.settipo_id(movimientoinventario.gettipo_id());	
		movimientoinventarioAsignar.setnumero_comprobante(movimientoinventario.getnumero_comprobante());	
		movimientoinventarioAsignar.setfecha(movimientoinventario.getfecha());	
	}
	
	public static void inicializarMovimientoInventario(MovimientoInventario movimientoinventario) throws Exception {
		try {
				movimientoinventario.setId(0L);	
					
				movimientoinventario.setid_empresa(-1L);	
				movimientoinventario.setid_sucursal(-1L);	
				movimientoinventario.setid_modulo(-1L);	
				movimientoinventario.setid_ejercicio(-1L);	
				movimientoinventario.setid_periodo(-1L);	
				movimientoinventario.setid_anio(null);	
				movimientoinventario.setid_mes(null);	
				movimientoinventario.setid_usuario(-1L);	
				movimientoinventario.setid_transaccion(-1L);	
				movimientoinventario.setfecha_emision(new Date());	
				movimientoinventario.setfecha_entrega(new Date());	
				movimientoinventario.setnumero_secuencial("");	
				movimientoinventario.setid_moneda(-1L);	
				movimientoinventario.setid_tipo_cambio(null);	
				movimientoinventario.setid_estado_movimiento_inventario(-1L);	
				movimientoinventario.setid_empleado(-1L);	
				movimientoinventario.setid_formato(-1L);	
				movimientoinventario.setid_factura(null);	
				movimientoinventario.setnumero_factura("");	
				movimientoinventario.setid_guia_remision(null);	
				movimientoinventario.setid_transportista(null);	
				movimientoinventario.setdescripcion("");	
				movimientoinventario.setporcentaje_descuento(0.0);	
				movimientoinventario.setsuman(0.0);	
				movimientoinventario.setice(0.0);	
				movimientoinventario.setvalor_descuento(0.0);	
				movimientoinventario.settotal_descuento(0.0);	
				movimientoinventario.setiva(0.0);	
				movimientoinventario.setstock(0.0);	
				movimientoinventario.setsub_total(0.0);	
				movimientoinventario.settotal_otro(0.0);	
				movimientoinventario.setultimo_costo(0.0);	
				movimientoinventario.setnumero_items(0);	
				movimientoinventario.setretencion(0.0);	
				movimientoinventario.settotal(0.0);	
				movimientoinventario.setflete(0.0);	
				movimientoinventario.setimpuesto(0.0);	
				movimientoinventario.setid_tipo_transaccion_modulo(null);	
				movimientoinventario.setid_compra(null);	
				movimientoinventario.setid_asiento_contable(null);	
				movimientoinventario.setgenerico_id(0L);	
				movimientoinventario.settipo_id("");	
				movimientoinventario.setnumero_comprobante("");	
				movimientoinventario.setfecha(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderMovimientoInventario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_FECHAENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_NUMEROSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDESTADOMOVIMIENTOINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDGUIAREMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDTRANSPORTISTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_SUMAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_VALORDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_TOTALDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_STOCK);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_TOTALOTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_ULTIMOCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_NUMEROITEMS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_RETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IMPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_GENERICOID);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_TIPOID);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoInventarioConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataMovimientoInventario(String sTipo,Row row,Workbook workbook,MovimientoInventario movimientoinventario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getfecha_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getnumero_secuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getestadomovimientoinventario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getguiaremision_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.gettransportista_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getporcentaje_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getsuman());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getvalor_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.gettotal_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getstock());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.gettotal_otro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getultimo_costo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getnumero_items());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getretencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getimpuesto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getcompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getgenerico_id());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.gettipo_id());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoinventario.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryMovimientoInventario=Constantes.SFINALQUERY;
	
	public String getsFinalQueryMovimientoInventario() {
		return this.sFinalQueryMovimientoInventario;
	}
	
	public void setsFinalQueryMovimientoInventario(String sFinalQueryMovimientoInventario) {
		this.sFinalQueryMovimientoInventario= sFinalQueryMovimientoInventario;
	}
	
	public Border resaltarSeleccionarMovimientoInventario=null;
	
	public Border setResaltarSeleccionarMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarMovimientoInventario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarMovimientoInventario() {
		return this.resaltarSeleccionarMovimientoInventario;
	}
	
	public void setResaltarSeleccionarMovimientoInventario(Border borderResaltarSeleccionarMovimientoInventario) {
		this.resaltarSeleccionarMovimientoInventario= borderResaltarSeleccionarMovimientoInventario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridMovimientoInventario=null;
	public Boolean mostraridMovimientoInventario=true;
	public Boolean activaridMovimientoInventario=true;

	public Border resaltarid_empresaMovimientoInventario=null;
	public Boolean mostrarid_empresaMovimientoInventario=true;
	public Boolean activarid_empresaMovimientoInventario=true;
	public Boolean cargarid_empresaMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_sucursalMovimientoInventario=null;
	public Boolean mostrarid_sucursalMovimientoInventario=true;
	public Boolean activarid_sucursalMovimientoInventario=true;
	public Boolean cargarid_sucursalMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_moduloMovimientoInventario=null;
	public Boolean mostrarid_moduloMovimientoInventario=true;
	public Boolean activarid_moduloMovimientoInventario=true;
	public Boolean cargarid_moduloMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_ejercicioMovimientoInventario=null;
	public Boolean mostrarid_ejercicioMovimientoInventario=true;
	public Boolean activarid_ejercicioMovimientoInventario=true;
	public Boolean cargarid_ejercicioMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_periodoMovimientoInventario=null;
	public Boolean mostrarid_periodoMovimientoInventario=true;
	public Boolean activarid_periodoMovimientoInventario=true;
	public Boolean cargarid_periodoMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_anioMovimientoInventario=null;
	public Boolean mostrarid_anioMovimientoInventario=true;
	public Boolean activarid_anioMovimientoInventario=false;
	public Boolean cargarid_anioMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_mesMovimientoInventario=null;
	public Boolean mostrarid_mesMovimientoInventario=true;
	public Boolean activarid_mesMovimientoInventario=false;
	public Boolean cargarid_mesMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_usuarioMovimientoInventario=null;
	public Boolean mostrarid_usuarioMovimientoInventario=true;
	public Boolean activarid_usuarioMovimientoInventario=true;
	public Boolean cargarid_usuarioMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_transaccionMovimientoInventario=null;
	public Boolean mostrarid_transaccionMovimientoInventario=true;
	public Boolean activarid_transaccionMovimientoInventario=true;
	public Boolean cargarid_transaccionMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarfecha_emisionMovimientoInventario=null;
	public Boolean mostrarfecha_emisionMovimientoInventario=true;
	public Boolean activarfecha_emisionMovimientoInventario=true;

	public Border resaltarfecha_entregaMovimientoInventario=null;
	public Boolean mostrarfecha_entregaMovimientoInventario=true;
	public Boolean activarfecha_entregaMovimientoInventario=true;

	public Border resaltarnumero_secuencialMovimientoInventario=null;
	public Boolean mostrarnumero_secuencialMovimientoInventario=true;
	public Boolean activarnumero_secuencialMovimientoInventario=false;

	public Border resaltarid_monedaMovimientoInventario=null;
	public Boolean mostrarid_monedaMovimientoInventario=true;
	public Boolean activarid_monedaMovimientoInventario=true;
	public Boolean cargarid_monedaMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_tipo_cambioMovimientoInventario=null;
	public Boolean mostrarid_tipo_cambioMovimientoInventario=true;
	public Boolean activarid_tipo_cambioMovimientoInventario=true;
	public Boolean cargarid_tipo_cambioMovimientoInventario=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_estado_movimiento_inventarioMovimientoInventario=null;
	public Boolean mostrarid_estado_movimiento_inventarioMovimientoInventario=true;
	public Boolean activarid_estado_movimiento_inventarioMovimientoInventario=false;
	public Boolean cargarid_estado_movimiento_inventarioMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_movimiento_inventarioMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_empleadoMovimientoInventario=null;
	public Boolean mostrarid_empleadoMovimientoInventario=true;
	public Boolean activarid_empleadoMovimientoInventario=true;
	public Boolean cargarid_empleadoMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_formatoMovimientoInventario=null;
	public Boolean mostrarid_formatoMovimientoInventario=true;
	public Boolean activarid_formatoMovimientoInventario=true;
	public Boolean cargarid_formatoMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_facturaMovimientoInventario=null;
	public Boolean mostrarid_facturaMovimientoInventario=true;
	public Boolean activarid_facturaMovimientoInventario=false;
	public Boolean cargarid_facturaMovimientoInventario=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarnumero_facturaMovimientoInventario=null;
	public Boolean mostrarnumero_facturaMovimientoInventario=true;
	public Boolean activarnumero_facturaMovimientoInventario=false;

	public Border resaltarid_guia_remisionMovimientoInventario=null;
	public Boolean mostrarid_guia_remisionMovimientoInventario=true;
	public Boolean activarid_guia_remisionMovimientoInventario=false;
	public Boolean cargarid_guia_remisionMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_guia_remisionMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_transportistaMovimientoInventario=null;
	public Boolean mostrarid_transportistaMovimientoInventario=true;
	public Boolean activarid_transportistaMovimientoInventario=true;
	public Boolean cargarid_transportistaMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transportistaMovimientoInventario=false;//ConEventDepend=true

	public Border resaltardescripcionMovimientoInventario=null;
	public Boolean mostrardescripcionMovimientoInventario=true;
	public Boolean activardescripcionMovimientoInventario=true;

	public Border resaltarporcentaje_descuentoMovimientoInventario=null;
	public Boolean mostrarporcentaje_descuentoMovimientoInventario=true;
	public Boolean activarporcentaje_descuentoMovimientoInventario=true;

	public Border resaltarsumanMovimientoInventario=null;
	public Boolean mostrarsumanMovimientoInventario=true;
	public Boolean activarsumanMovimientoInventario=true;

	public Border resaltariceMovimientoInventario=null;
	public Boolean mostrariceMovimientoInventario=true;
	public Boolean activariceMovimientoInventario=true;

	public Border resaltarvalor_descuentoMovimientoInventario=null;
	public Boolean mostrarvalor_descuentoMovimientoInventario=true;
	public Boolean activarvalor_descuentoMovimientoInventario=true;

	public Border resaltartotal_descuentoMovimientoInventario=null;
	public Boolean mostrartotal_descuentoMovimientoInventario=true;
	public Boolean activartotal_descuentoMovimientoInventario=true;

	public Border resaltarivaMovimientoInventario=null;
	public Boolean mostrarivaMovimientoInventario=true;
	public Boolean activarivaMovimientoInventario=true;

	public Border resaltarstockMovimientoInventario=null;
	public Boolean mostrarstockMovimientoInventario=true;
	public Boolean activarstockMovimientoInventario=true;

	public Border resaltarsub_totalMovimientoInventario=null;
	public Boolean mostrarsub_totalMovimientoInventario=true;
	public Boolean activarsub_totalMovimientoInventario=true;

	public Border resaltartotal_otroMovimientoInventario=null;
	public Boolean mostrartotal_otroMovimientoInventario=true;
	public Boolean activartotal_otroMovimientoInventario=true;

	public Border resaltarultimo_costoMovimientoInventario=null;
	public Boolean mostrarultimo_costoMovimientoInventario=true;
	public Boolean activarultimo_costoMovimientoInventario=true;

	public Border resaltarnumero_itemsMovimientoInventario=null;
	public Boolean mostrarnumero_itemsMovimientoInventario=true;
	public Boolean activarnumero_itemsMovimientoInventario=true;

	public Border resaltarretencionMovimientoInventario=null;
	public Boolean mostrarretencionMovimientoInventario=true;
	public Boolean activarretencionMovimientoInventario=true;

	public Border resaltartotalMovimientoInventario=null;
	public Boolean mostrartotalMovimientoInventario=true;
	public Boolean activartotalMovimientoInventario=true;

	public Border resaltarfleteMovimientoInventario=null;
	public Boolean mostrarfleteMovimientoInventario=true;
	public Boolean activarfleteMovimientoInventario=false;

	public Border resaltarimpuestoMovimientoInventario=null;
	public Boolean mostrarimpuestoMovimientoInventario=true;
	public Boolean activarimpuestoMovimientoInventario=false;

	public Border resaltarid_tipo_transaccion_moduloMovimientoInventario=null;
	public Boolean mostrarid_tipo_transaccion_moduloMovimientoInventario=true;
	public Boolean activarid_tipo_transaccion_moduloMovimientoInventario=false;
	public Boolean cargarid_tipo_transaccion_moduloMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_compraMovimientoInventario=null;
	public Boolean mostrarid_compraMovimientoInventario=true;
	public Boolean activarid_compraMovimientoInventario=false;
	public Boolean cargarid_compraMovimientoInventario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_compraMovimientoInventario=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableMovimientoInventario=null;
	public Boolean mostrarid_asiento_contableMovimientoInventario=true;
	public Boolean activarid_asiento_contableMovimientoInventario=false;
	public Boolean cargarid_asiento_contableMovimientoInventario=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableMovimientoInventario=false;//ConEventDepend=true

	public Border resaltargenerico_idMovimientoInventario=null;
	public Boolean mostrargenerico_idMovimientoInventario=true;
	public Boolean activargenerico_idMovimientoInventario=false;

	public Border resaltartipo_idMovimientoInventario=null;
	public Boolean mostrartipo_idMovimientoInventario=true;
	public Boolean activartipo_idMovimientoInventario=false;

	public Border resaltarnumero_comprobanteMovimientoInventario=null;
	public Boolean mostrarnumero_comprobanteMovimientoInventario=true;
	public Boolean activarnumero_comprobanteMovimientoInventario=false;

	public Border resaltarfechaMovimientoInventario=null;
	public Boolean mostrarfechaMovimientoInventario=true;
	public Boolean activarfechaMovimientoInventario=false;

	
	

	public Border setResaltaridMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltaridMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridMovimientoInventario() {
		return this.resaltaridMovimientoInventario;
	}

	public void setResaltaridMovimientoInventario(Border borderResaltar) {
		this.resaltaridMovimientoInventario= borderResaltar;
	}

	public Boolean getMostraridMovimientoInventario() {
		return this.mostraridMovimientoInventario;
	}

	public void setMostraridMovimientoInventario(Boolean mostraridMovimientoInventario) {
		this.mostraridMovimientoInventario= mostraridMovimientoInventario;
	}

	public Boolean getActivaridMovimientoInventario() {
		return this.activaridMovimientoInventario;
	}

	public void setActivaridMovimientoInventario(Boolean activaridMovimientoInventario) {
		this.activaridMovimientoInventario= activaridMovimientoInventario;
	}

	public Border setResaltarid_empresaMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_empresaMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaMovimientoInventario() {
		return this.resaltarid_empresaMovimientoInventario;
	}

	public void setResaltarid_empresaMovimientoInventario(Border borderResaltar) {
		this.resaltarid_empresaMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_empresaMovimientoInventario() {
		return this.mostrarid_empresaMovimientoInventario;
	}

	public void setMostrarid_empresaMovimientoInventario(Boolean mostrarid_empresaMovimientoInventario) {
		this.mostrarid_empresaMovimientoInventario= mostrarid_empresaMovimientoInventario;
	}

	public Boolean getActivarid_empresaMovimientoInventario() {
		return this.activarid_empresaMovimientoInventario;
	}

	public void setActivarid_empresaMovimientoInventario(Boolean activarid_empresaMovimientoInventario) {
		this.activarid_empresaMovimientoInventario= activarid_empresaMovimientoInventario;
	}

	public Boolean getCargarid_empresaMovimientoInventario() {
		return this.cargarid_empresaMovimientoInventario;
	}

	public void setCargarid_empresaMovimientoInventario(Boolean cargarid_empresaMovimientoInventario) {
		this.cargarid_empresaMovimientoInventario= cargarid_empresaMovimientoInventario;
	}

	public Border setResaltarid_sucursalMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_sucursalMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalMovimientoInventario() {
		return this.resaltarid_sucursalMovimientoInventario;
	}

	public void setResaltarid_sucursalMovimientoInventario(Border borderResaltar) {
		this.resaltarid_sucursalMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_sucursalMovimientoInventario() {
		return this.mostrarid_sucursalMovimientoInventario;
	}

	public void setMostrarid_sucursalMovimientoInventario(Boolean mostrarid_sucursalMovimientoInventario) {
		this.mostrarid_sucursalMovimientoInventario= mostrarid_sucursalMovimientoInventario;
	}

	public Boolean getActivarid_sucursalMovimientoInventario() {
		return this.activarid_sucursalMovimientoInventario;
	}

	public void setActivarid_sucursalMovimientoInventario(Boolean activarid_sucursalMovimientoInventario) {
		this.activarid_sucursalMovimientoInventario= activarid_sucursalMovimientoInventario;
	}

	public Boolean getCargarid_sucursalMovimientoInventario() {
		return this.cargarid_sucursalMovimientoInventario;
	}

	public void setCargarid_sucursalMovimientoInventario(Boolean cargarid_sucursalMovimientoInventario) {
		this.cargarid_sucursalMovimientoInventario= cargarid_sucursalMovimientoInventario;
	}

	public Border setResaltarid_moduloMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_moduloMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloMovimientoInventario() {
		return this.resaltarid_moduloMovimientoInventario;
	}

	public void setResaltarid_moduloMovimientoInventario(Border borderResaltar) {
		this.resaltarid_moduloMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_moduloMovimientoInventario() {
		return this.mostrarid_moduloMovimientoInventario;
	}

	public void setMostrarid_moduloMovimientoInventario(Boolean mostrarid_moduloMovimientoInventario) {
		this.mostrarid_moduloMovimientoInventario= mostrarid_moduloMovimientoInventario;
	}

	public Boolean getActivarid_moduloMovimientoInventario() {
		return this.activarid_moduloMovimientoInventario;
	}

	public void setActivarid_moduloMovimientoInventario(Boolean activarid_moduloMovimientoInventario) {
		this.activarid_moduloMovimientoInventario= activarid_moduloMovimientoInventario;
	}

	public Boolean getCargarid_moduloMovimientoInventario() {
		return this.cargarid_moduloMovimientoInventario;
	}

	public void setCargarid_moduloMovimientoInventario(Boolean cargarid_moduloMovimientoInventario) {
		this.cargarid_moduloMovimientoInventario= cargarid_moduloMovimientoInventario;
	}

	public Border setResaltarid_ejercicioMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioMovimientoInventario() {
		return this.resaltarid_ejercicioMovimientoInventario;
	}

	public void setResaltarid_ejercicioMovimientoInventario(Border borderResaltar) {
		this.resaltarid_ejercicioMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioMovimientoInventario() {
		return this.mostrarid_ejercicioMovimientoInventario;
	}

	public void setMostrarid_ejercicioMovimientoInventario(Boolean mostrarid_ejercicioMovimientoInventario) {
		this.mostrarid_ejercicioMovimientoInventario= mostrarid_ejercicioMovimientoInventario;
	}

	public Boolean getActivarid_ejercicioMovimientoInventario() {
		return this.activarid_ejercicioMovimientoInventario;
	}

	public void setActivarid_ejercicioMovimientoInventario(Boolean activarid_ejercicioMovimientoInventario) {
		this.activarid_ejercicioMovimientoInventario= activarid_ejercicioMovimientoInventario;
	}

	public Boolean getCargarid_ejercicioMovimientoInventario() {
		return this.cargarid_ejercicioMovimientoInventario;
	}

	public void setCargarid_ejercicioMovimientoInventario(Boolean cargarid_ejercicioMovimientoInventario) {
		this.cargarid_ejercicioMovimientoInventario= cargarid_ejercicioMovimientoInventario;
	}

	public Border setResaltarid_periodoMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_periodoMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoMovimientoInventario() {
		return this.resaltarid_periodoMovimientoInventario;
	}

	public void setResaltarid_periodoMovimientoInventario(Border borderResaltar) {
		this.resaltarid_periodoMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_periodoMovimientoInventario() {
		return this.mostrarid_periodoMovimientoInventario;
	}

	public void setMostrarid_periodoMovimientoInventario(Boolean mostrarid_periodoMovimientoInventario) {
		this.mostrarid_periodoMovimientoInventario= mostrarid_periodoMovimientoInventario;
	}

	public Boolean getActivarid_periodoMovimientoInventario() {
		return this.activarid_periodoMovimientoInventario;
	}

	public void setActivarid_periodoMovimientoInventario(Boolean activarid_periodoMovimientoInventario) {
		this.activarid_periodoMovimientoInventario= activarid_periodoMovimientoInventario;
	}

	public Boolean getCargarid_periodoMovimientoInventario() {
		return this.cargarid_periodoMovimientoInventario;
	}

	public void setCargarid_periodoMovimientoInventario(Boolean cargarid_periodoMovimientoInventario) {
		this.cargarid_periodoMovimientoInventario= cargarid_periodoMovimientoInventario;
	}

	public Border setResaltarid_anioMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_anioMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioMovimientoInventario() {
		return this.resaltarid_anioMovimientoInventario;
	}

	public void setResaltarid_anioMovimientoInventario(Border borderResaltar) {
		this.resaltarid_anioMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_anioMovimientoInventario() {
		return this.mostrarid_anioMovimientoInventario;
	}

	public void setMostrarid_anioMovimientoInventario(Boolean mostrarid_anioMovimientoInventario) {
		this.mostrarid_anioMovimientoInventario= mostrarid_anioMovimientoInventario;
	}

	public Boolean getActivarid_anioMovimientoInventario() {
		return this.activarid_anioMovimientoInventario;
	}

	public void setActivarid_anioMovimientoInventario(Boolean activarid_anioMovimientoInventario) {
		this.activarid_anioMovimientoInventario= activarid_anioMovimientoInventario;
	}

	public Boolean getCargarid_anioMovimientoInventario() {
		return this.cargarid_anioMovimientoInventario;
	}

	public void setCargarid_anioMovimientoInventario(Boolean cargarid_anioMovimientoInventario) {
		this.cargarid_anioMovimientoInventario= cargarid_anioMovimientoInventario;
	}

	public Border setResaltarid_mesMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_mesMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesMovimientoInventario() {
		return this.resaltarid_mesMovimientoInventario;
	}

	public void setResaltarid_mesMovimientoInventario(Border borderResaltar) {
		this.resaltarid_mesMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_mesMovimientoInventario() {
		return this.mostrarid_mesMovimientoInventario;
	}

	public void setMostrarid_mesMovimientoInventario(Boolean mostrarid_mesMovimientoInventario) {
		this.mostrarid_mesMovimientoInventario= mostrarid_mesMovimientoInventario;
	}

	public Boolean getActivarid_mesMovimientoInventario() {
		return this.activarid_mesMovimientoInventario;
	}

	public void setActivarid_mesMovimientoInventario(Boolean activarid_mesMovimientoInventario) {
		this.activarid_mesMovimientoInventario= activarid_mesMovimientoInventario;
	}

	public Boolean getCargarid_mesMovimientoInventario() {
		return this.cargarid_mesMovimientoInventario;
	}

	public void setCargarid_mesMovimientoInventario(Boolean cargarid_mesMovimientoInventario) {
		this.cargarid_mesMovimientoInventario= cargarid_mesMovimientoInventario;
	}

	public Border setResaltarid_usuarioMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_usuarioMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioMovimientoInventario() {
		return this.resaltarid_usuarioMovimientoInventario;
	}

	public void setResaltarid_usuarioMovimientoInventario(Border borderResaltar) {
		this.resaltarid_usuarioMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_usuarioMovimientoInventario() {
		return this.mostrarid_usuarioMovimientoInventario;
	}

	public void setMostrarid_usuarioMovimientoInventario(Boolean mostrarid_usuarioMovimientoInventario) {
		this.mostrarid_usuarioMovimientoInventario= mostrarid_usuarioMovimientoInventario;
	}

	public Boolean getActivarid_usuarioMovimientoInventario() {
		return this.activarid_usuarioMovimientoInventario;
	}

	public void setActivarid_usuarioMovimientoInventario(Boolean activarid_usuarioMovimientoInventario) {
		this.activarid_usuarioMovimientoInventario= activarid_usuarioMovimientoInventario;
	}

	public Boolean getCargarid_usuarioMovimientoInventario() {
		return this.cargarid_usuarioMovimientoInventario;
	}

	public void setCargarid_usuarioMovimientoInventario(Boolean cargarid_usuarioMovimientoInventario) {
		this.cargarid_usuarioMovimientoInventario= cargarid_usuarioMovimientoInventario;
	}

	public Border setResaltarid_transaccionMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_transaccionMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionMovimientoInventario() {
		return this.resaltarid_transaccionMovimientoInventario;
	}

	public void setResaltarid_transaccionMovimientoInventario(Border borderResaltar) {
		this.resaltarid_transaccionMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_transaccionMovimientoInventario() {
		return this.mostrarid_transaccionMovimientoInventario;
	}

	public void setMostrarid_transaccionMovimientoInventario(Boolean mostrarid_transaccionMovimientoInventario) {
		this.mostrarid_transaccionMovimientoInventario= mostrarid_transaccionMovimientoInventario;
	}

	public Boolean getActivarid_transaccionMovimientoInventario() {
		return this.activarid_transaccionMovimientoInventario;
	}

	public void setActivarid_transaccionMovimientoInventario(Boolean activarid_transaccionMovimientoInventario) {
		this.activarid_transaccionMovimientoInventario= activarid_transaccionMovimientoInventario;
	}

	public Boolean getCargarid_transaccionMovimientoInventario() {
		return this.cargarid_transaccionMovimientoInventario;
	}

	public void setCargarid_transaccionMovimientoInventario(Boolean cargarid_transaccionMovimientoInventario) {
		this.cargarid_transaccionMovimientoInventario= cargarid_transaccionMovimientoInventario;
	}

	public Border setResaltarfecha_emisionMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionMovimientoInventario() {
		return this.resaltarfecha_emisionMovimientoInventario;
	}

	public void setResaltarfecha_emisionMovimientoInventario(Border borderResaltar) {
		this.resaltarfecha_emisionMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionMovimientoInventario() {
		return this.mostrarfecha_emisionMovimientoInventario;
	}

	public void setMostrarfecha_emisionMovimientoInventario(Boolean mostrarfecha_emisionMovimientoInventario) {
		this.mostrarfecha_emisionMovimientoInventario= mostrarfecha_emisionMovimientoInventario;
	}

	public Boolean getActivarfecha_emisionMovimientoInventario() {
		return this.activarfecha_emisionMovimientoInventario;
	}

	public void setActivarfecha_emisionMovimientoInventario(Boolean activarfecha_emisionMovimientoInventario) {
		this.activarfecha_emisionMovimientoInventario= activarfecha_emisionMovimientoInventario;
	}

	public Border setResaltarfecha_entregaMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarfecha_entregaMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entregaMovimientoInventario() {
		return this.resaltarfecha_entregaMovimientoInventario;
	}

	public void setResaltarfecha_entregaMovimientoInventario(Border borderResaltar) {
		this.resaltarfecha_entregaMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarfecha_entregaMovimientoInventario() {
		return this.mostrarfecha_entregaMovimientoInventario;
	}

	public void setMostrarfecha_entregaMovimientoInventario(Boolean mostrarfecha_entregaMovimientoInventario) {
		this.mostrarfecha_entregaMovimientoInventario= mostrarfecha_entregaMovimientoInventario;
	}

	public Boolean getActivarfecha_entregaMovimientoInventario() {
		return this.activarfecha_entregaMovimientoInventario;
	}

	public void setActivarfecha_entregaMovimientoInventario(Boolean activarfecha_entregaMovimientoInventario) {
		this.activarfecha_entregaMovimientoInventario= activarfecha_entregaMovimientoInventario;
	}

	public Border setResaltarnumero_secuencialMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarnumero_secuencialMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencialMovimientoInventario() {
		return this.resaltarnumero_secuencialMovimientoInventario;
	}

	public void setResaltarnumero_secuencialMovimientoInventario(Border borderResaltar) {
		this.resaltarnumero_secuencialMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencialMovimientoInventario() {
		return this.mostrarnumero_secuencialMovimientoInventario;
	}

	public void setMostrarnumero_secuencialMovimientoInventario(Boolean mostrarnumero_secuencialMovimientoInventario) {
		this.mostrarnumero_secuencialMovimientoInventario= mostrarnumero_secuencialMovimientoInventario;
	}

	public Boolean getActivarnumero_secuencialMovimientoInventario() {
		return this.activarnumero_secuencialMovimientoInventario;
	}

	public void setActivarnumero_secuencialMovimientoInventario(Boolean activarnumero_secuencialMovimientoInventario) {
		this.activarnumero_secuencialMovimientoInventario= activarnumero_secuencialMovimientoInventario;
	}

	public Border setResaltarid_monedaMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_monedaMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaMovimientoInventario() {
		return this.resaltarid_monedaMovimientoInventario;
	}

	public void setResaltarid_monedaMovimientoInventario(Border borderResaltar) {
		this.resaltarid_monedaMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_monedaMovimientoInventario() {
		return this.mostrarid_monedaMovimientoInventario;
	}

	public void setMostrarid_monedaMovimientoInventario(Boolean mostrarid_monedaMovimientoInventario) {
		this.mostrarid_monedaMovimientoInventario= mostrarid_monedaMovimientoInventario;
	}

	public Boolean getActivarid_monedaMovimientoInventario() {
		return this.activarid_monedaMovimientoInventario;
	}

	public void setActivarid_monedaMovimientoInventario(Boolean activarid_monedaMovimientoInventario) {
		this.activarid_monedaMovimientoInventario= activarid_monedaMovimientoInventario;
	}

	public Boolean getCargarid_monedaMovimientoInventario() {
		return this.cargarid_monedaMovimientoInventario;
	}

	public void setCargarid_monedaMovimientoInventario(Boolean cargarid_monedaMovimientoInventario) {
		this.cargarid_monedaMovimientoInventario= cargarid_monedaMovimientoInventario;
	}

	public Border setResaltarid_tipo_cambioMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cambioMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioMovimientoInventario() {
		return this.resaltarid_tipo_cambioMovimientoInventario;
	}

	public void setResaltarid_tipo_cambioMovimientoInventario(Border borderResaltar) {
		this.resaltarid_tipo_cambioMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioMovimientoInventario() {
		return this.mostrarid_tipo_cambioMovimientoInventario;
	}

	public void setMostrarid_tipo_cambioMovimientoInventario(Boolean mostrarid_tipo_cambioMovimientoInventario) {
		this.mostrarid_tipo_cambioMovimientoInventario= mostrarid_tipo_cambioMovimientoInventario;
	}

	public Boolean getActivarid_tipo_cambioMovimientoInventario() {
		return this.activarid_tipo_cambioMovimientoInventario;
	}

	public void setActivarid_tipo_cambioMovimientoInventario(Boolean activarid_tipo_cambioMovimientoInventario) {
		this.activarid_tipo_cambioMovimientoInventario= activarid_tipo_cambioMovimientoInventario;
	}

	public Boolean getCargarid_tipo_cambioMovimientoInventario() {
		return this.cargarid_tipo_cambioMovimientoInventario;
	}

	public void setCargarid_tipo_cambioMovimientoInventario(Boolean cargarid_tipo_cambioMovimientoInventario) {
		this.cargarid_tipo_cambioMovimientoInventario= cargarid_tipo_cambioMovimientoInventario;
	}

	public Border setResaltarid_estado_movimiento_inventarioMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_estado_movimiento_inventarioMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_movimiento_inventarioMovimientoInventario() {
		return this.resaltarid_estado_movimiento_inventarioMovimientoInventario;
	}

	public void setResaltarid_estado_movimiento_inventarioMovimientoInventario(Border borderResaltar) {
		this.resaltarid_estado_movimiento_inventarioMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_estado_movimiento_inventarioMovimientoInventario() {
		return this.mostrarid_estado_movimiento_inventarioMovimientoInventario;
	}

	public void setMostrarid_estado_movimiento_inventarioMovimientoInventario(Boolean mostrarid_estado_movimiento_inventarioMovimientoInventario) {
		this.mostrarid_estado_movimiento_inventarioMovimientoInventario= mostrarid_estado_movimiento_inventarioMovimientoInventario;
	}

	public Boolean getActivarid_estado_movimiento_inventarioMovimientoInventario() {
		return this.activarid_estado_movimiento_inventarioMovimientoInventario;
	}

	public void setActivarid_estado_movimiento_inventarioMovimientoInventario(Boolean activarid_estado_movimiento_inventarioMovimientoInventario) {
		this.activarid_estado_movimiento_inventarioMovimientoInventario= activarid_estado_movimiento_inventarioMovimientoInventario;
	}

	public Boolean getCargarid_estado_movimiento_inventarioMovimientoInventario() {
		return this.cargarid_estado_movimiento_inventarioMovimientoInventario;
	}

	public void setCargarid_estado_movimiento_inventarioMovimientoInventario(Boolean cargarid_estado_movimiento_inventarioMovimientoInventario) {
		this.cargarid_estado_movimiento_inventarioMovimientoInventario= cargarid_estado_movimiento_inventarioMovimientoInventario;
	}

	public Border setResaltarid_empleadoMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_empleadoMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoMovimientoInventario() {
		return this.resaltarid_empleadoMovimientoInventario;
	}

	public void setResaltarid_empleadoMovimientoInventario(Border borderResaltar) {
		this.resaltarid_empleadoMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_empleadoMovimientoInventario() {
		return this.mostrarid_empleadoMovimientoInventario;
	}

	public void setMostrarid_empleadoMovimientoInventario(Boolean mostrarid_empleadoMovimientoInventario) {
		this.mostrarid_empleadoMovimientoInventario= mostrarid_empleadoMovimientoInventario;
	}

	public Boolean getActivarid_empleadoMovimientoInventario() {
		return this.activarid_empleadoMovimientoInventario;
	}

	public void setActivarid_empleadoMovimientoInventario(Boolean activarid_empleadoMovimientoInventario) {
		this.activarid_empleadoMovimientoInventario= activarid_empleadoMovimientoInventario;
	}

	public Boolean getCargarid_empleadoMovimientoInventario() {
		return this.cargarid_empleadoMovimientoInventario;
	}

	public void setCargarid_empleadoMovimientoInventario(Boolean cargarid_empleadoMovimientoInventario) {
		this.cargarid_empleadoMovimientoInventario= cargarid_empleadoMovimientoInventario;
	}

	public Border setResaltarid_formatoMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_formatoMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoMovimientoInventario() {
		return this.resaltarid_formatoMovimientoInventario;
	}

	public void setResaltarid_formatoMovimientoInventario(Border borderResaltar) {
		this.resaltarid_formatoMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_formatoMovimientoInventario() {
		return this.mostrarid_formatoMovimientoInventario;
	}

	public void setMostrarid_formatoMovimientoInventario(Boolean mostrarid_formatoMovimientoInventario) {
		this.mostrarid_formatoMovimientoInventario= mostrarid_formatoMovimientoInventario;
	}

	public Boolean getActivarid_formatoMovimientoInventario() {
		return this.activarid_formatoMovimientoInventario;
	}

	public void setActivarid_formatoMovimientoInventario(Boolean activarid_formatoMovimientoInventario) {
		this.activarid_formatoMovimientoInventario= activarid_formatoMovimientoInventario;
	}

	public Boolean getCargarid_formatoMovimientoInventario() {
		return this.cargarid_formatoMovimientoInventario;
	}

	public void setCargarid_formatoMovimientoInventario(Boolean cargarid_formatoMovimientoInventario) {
		this.cargarid_formatoMovimientoInventario= cargarid_formatoMovimientoInventario;
	}

	public Border setResaltarid_facturaMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_facturaMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaMovimientoInventario() {
		return this.resaltarid_facturaMovimientoInventario;
	}

	public void setResaltarid_facturaMovimientoInventario(Border borderResaltar) {
		this.resaltarid_facturaMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_facturaMovimientoInventario() {
		return this.mostrarid_facturaMovimientoInventario;
	}

	public void setMostrarid_facturaMovimientoInventario(Boolean mostrarid_facturaMovimientoInventario) {
		this.mostrarid_facturaMovimientoInventario= mostrarid_facturaMovimientoInventario;
	}

	public Boolean getActivarid_facturaMovimientoInventario() {
		return this.activarid_facturaMovimientoInventario;
	}

	public void setActivarid_facturaMovimientoInventario(Boolean activarid_facturaMovimientoInventario) {
		this.activarid_facturaMovimientoInventario= activarid_facturaMovimientoInventario;
	}

	public Boolean getCargarid_facturaMovimientoInventario() {
		return this.cargarid_facturaMovimientoInventario;
	}

	public void setCargarid_facturaMovimientoInventario(Boolean cargarid_facturaMovimientoInventario) {
		this.cargarid_facturaMovimientoInventario= cargarid_facturaMovimientoInventario;
	}

	public Border setResaltarnumero_facturaMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaMovimientoInventario() {
		return this.resaltarnumero_facturaMovimientoInventario;
	}

	public void setResaltarnumero_facturaMovimientoInventario(Border borderResaltar) {
		this.resaltarnumero_facturaMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaMovimientoInventario() {
		return this.mostrarnumero_facturaMovimientoInventario;
	}

	public void setMostrarnumero_facturaMovimientoInventario(Boolean mostrarnumero_facturaMovimientoInventario) {
		this.mostrarnumero_facturaMovimientoInventario= mostrarnumero_facturaMovimientoInventario;
	}

	public Boolean getActivarnumero_facturaMovimientoInventario() {
		return this.activarnumero_facturaMovimientoInventario;
	}

	public void setActivarnumero_facturaMovimientoInventario(Boolean activarnumero_facturaMovimientoInventario) {
		this.activarnumero_facturaMovimientoInventario= activarnumero_facturaMovimientoInventario;
	}

	public Border setResaltarid_guia_remisionMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_guia_remisionMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_guia_remisionMovimientoInventario() {
		return this.resaltarid_guia_remisionMovimientoInventario;
	}

	public void setResaltarid_guia_remisionMovimientoInventario(Border borderResaltar) {
		this.resaltarid_guia_remisionMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_guia_remisionMovimientoInventario() {
		return this.mostrarid_guia_remisionMovimientoInventario;
	}

	public void setMostrarid_guia_remisionMovimientoInventario(Boolean mostrarid_guia_remisionMovimientoInventario) {
		this.mostrarid_guia_remisionMovimientoInventario= mostrarid_guia_remisionMovimientoInventario;
	}

	public Boolean getActivarid_guia_remisionMovimientoInventario() {
		return this.activarid_guia_remisionMovimientoInventario;
	}

	public void setActivarid_guia_remisionMovimientoInventario(Boolean activarid_guia_remisionMovimientoInventario) {
		this.activarid_guia_remisionMovimientoInventario= activarid_guia_remisionMovimientoInventario;
	}

	public Boolean getCargarid_guia_remisionMovimientoInventario() {
		return this.cargarid_guia_remisionMovimientoInventario;
	}

	public void setCargarid_guia_remisionMovimientoInventario(Boolean cargarid_guia_remisionMovimientoInventario) {
		this.cargarid_guia_remisionMovimientoInventario= cargarid_guia_remisionMovimientoInventario;
	}

	public Border setResaltarid_transportistaMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_transportistaMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transportistaMovimientoInventario() {
		return this.resaltarid_transportistaMovimientoInventario;
	}

	public void setResaltarid_transportistaMovimientoInventario(Border borderResaltar) {
		this.resaltarid_transportistaMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_transportistaMovimientoInventario() {
		return this.mostrarid_transportistaMovimientoInventario;
	}

	public void setMostrarid_transportistaMovimientoInventario(Boolean mostrarid_transportistaMovimientoInventario) {
		this.mostrarid_transportistaMovimientoInventario= mostrarid_transportistaMovimientoInventario;
	}

	public Boolean getActivarid_transportistaMovimientoInventario() {
		return this.activarid_transportistaMovimientoInventario;
	}

	public void setActivarid_transportistaMovimientoInventario(Boolean activarid_transportistaMovimientoInventario) {
		this.activarid_transportistaMovimientoInventario= activarid_transportistaMovimientoInventario;
	}

	public Boolean getCargarid_transportistaMovimientoInventario() {
		return this.cargarid_transportistaMovimientoInventario;
	}

	public void setCargarid_transportistaMovimientoInventario(Boolean cargarid_transportistaMovimientoInventario) {
		this.cargarid_transportistaMovimientoInventario= cargarid_transportistaMovimientoInventario;
	}

	public Border setResaltardescripcionMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltardescripcionMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionMovimientoInventario() {
		return this.resaltardescripcionMovimientoInventario;
	}

	public void setResaltardescripcionMovimientoInventario(Border borderResaltar) {
		this.resaltardescripcionMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrardescripcionMovimientoInventario() {
		return this.mostrardescripcionMovimientoInventario;
	}

	public void setMostrardescripcionMovimientoInventario(Boolean mostrardescripcionMovimientoInventario) {
		this.mostrardescripcionMovimientoInventario= mostrardescripcionMovimientoInventario;
	}

	public Boolean getActivardescripcionMovimientoInventario() {
		return this.activardescripcionMovimientoInventario;
	}

	public void setActivardescripcionMovimientoInventario(Boolean activardescripcionMovimientoInventario) {
		this.activardescripcionMovimientoInventario= activardescripcionMovimientoInventario;
	}

	public Border setResaltarporcentaje_descuentoMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarporcentaje_descuentoMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_descuentoMovimientoInventario() {
		return this.resaltarporcentaje_descuentoMovimientoInventario;
	}

	public void setResaltarporcentaje_descuentoMovimientoInventario(Border borderResaltar) {
		this.resaltarporcentaje_descuentoMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarporcentaje_descuentoMovimientoInventario() {
		return this.mostrarporcentaje_descuentoMovimientoInventario;
	}

	public void setMostrarporcentaje_descuentoMovimientoInventario(Boolean mostrarporcentaje_descuentoMovimientoInventario) {
		this.mostrarporcentaje_descuentoMovimientoInventario= mostrarporcentaje_descuentoMovimientoInventario;
	}

	public Boolean getActivarporcentaje_descuentoMovimientoInventario() {
		return this.activarporcentaje_descuentoMovimientoInventario;
	}

	public void setActivarporcentaje_descuentoMovimientoInventario(Boolean activarporcentaje_descuentoMovimientoInventario) {
		this.activarporcentaje_descuentoMovimientoInventario= activarporcentaje_descuentoMovimientoInventario;
	}

	public Border setResaltarsumanMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarsumanMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsumanMovimientoInventario() {
		return this.resaltarsumanMovimientoInventario;
	}

	public void setResaltarsumanMovimientoInventario(Border borderResaltar) {
		this.resaltarsumanMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarsumanMovimientoInventario() {
		return this.mostrarsumanMovimientoInventario;
	}

	public void setMostrarsumanMovimientoInventario(Boolean mostrarsumanMovimientoInventario) {
		this.mostrarsumanMovimientoInventario= mostrarsumanMovimientoInventario;
	}

	public Boolean getActivarsumanMovimientoInventario() {
		return this.activarsumanMovimientoInventario;
	}

	public void setActivarsumanMovimientoInventario(Boolean activarsumanMovimientoInventario) {
		this.activarsumanMovimientoInventario= activarsumanMovimientoInventario;
	}

	public Border setResaltariceMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltariceMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceMovimientoInventario() {
		return this.resaltariceMovimientoInventario;
	}

	public void setResaltariceMovimientoInventario(Border borderResaltar) {
		this.resaltariceMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrariceMovimientoInventario() {
		return this.mostrariceMovimientoInventario;
	}

	public void setMostrariceMovimientoInventario(Boolean mostrariceMovimientoInventario) {
		this.mostrariceMovimientoInventario= mostrariceMovimientoInventario;
	}

	public Boolean getActivariceMovimientoInventario() {
		return this.activariceMovimientoInventario;
	}

	public void setActivariceMovimientoInventario(Boolean activariceMovimientoInventario) {
		this.activariceMovimientoInventario= activariceMovimientoInventario;
	}

	public Border setResaltarvalor_descuentoMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarvalor_descuentoMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_descuentoMovimientoInventario() {
		return this.resaltarvalor_descuentoMovimientoInventario;
	}

	public void setResaltarvalor_descuentoMovimientoInventario(Border borderResaltar) {
		this.resaltarvalor_descuentoMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarvalor_descuentoMovimientoInventario() {
		return this.mostrarvalor_descuentoMovimientoInventario;
	}

	public void setMostrarvalor_descuentoMovimientoInventario(Boolean mostrarvalor_descuentoMovimientoInventario) {
		this.mostrarvalor_descuentoMovimientoInventario= mostrarvalor_descuentoMovimientoInventario;
	}

	public Boolean getActivarvalor_descuentoMovimientoInventario() {
		return this.activarvalor_descuentoMovimientoInventario;
	}

	public void setActivarvalor_descuentoMovimientoInventario(Boolean activarvalor_descuentoMovimientoInventario) {
		this.activarvalor_descuentoMovimientoInventario= activarvalor_descuentoMovimientoInventario;
	}

	public Border setResaltartotal_descuentoMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltartotal_descuentoMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_descuentoMovimientoInventario() {
		return this.resaltartotal_descuentoMovimientoInventario;
	}

	public void setResaltartotal_descuentoMovimientoInventario(Border borderResaltar) {
		this.resaltartotal_descuentoMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrartotal_descuentoMovimientoInventario() {
		return this.mostrartotal_descuentoMovimientoInventario;
	}

	public void setMostrartotal_descuentoMovimientoInventario(Boolean mostrartotal_descuentoMovimientoInventario) {
		this.mostrartotal_descuentoMovimientoInventario= mostrartotal_descuentoMovimientoInventario;
	}

	public Boolean getActivartotal_descuentoMovimientoInventario() {
		return this.activartotal_descuentoMovimientoInventario;
	}

	public void setActivartotal_descuentoMovimientoInventario(Boolean activartotal_descuentoMovimientoInventario) {
		this.activartotal_descuentoMovimientoInventario= activartotal_descuentoMovimientoInventario;
	}

	public Border setResaltarivaMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarivaMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaMovimientoInventario() {
		return this.resaltarivaMovimientoInventario;
	}

	public void setResaltarivaMovimientoInventario(Border borderResaltar) {
		this.resaltarivaMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarivaMovimientoInventario() {
		return this.mostrarivaMovimientoInventario;
	}

	public void setMostrarivaMovimientoInventario(Boolean mostrarivaMovimientoInventario) {
		this.mostrarivaMovimientoInventario= mostrarivaMovimientoInventario;
	}

	public Boolean getActivarivaMovimientoInventario() {
		return this.activarivaMovimientoInventario;
	}

	public void setActivarivaMovimientoInventario(Boolean activarivaMovimientoInventario) {
		this.activarivaMovimientoInventario= activarivaMovimientoInventario;
	}

	public Border setResaltarstockMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarstockMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarstockMovimientoInventario() {
		return this.resaltarstockMovimientoInventario;
	}

	public void setResaltarstockMovimientoInventario(Border borderResaltar) {
		this.resaltarstockMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarstockMovimientoInventario() {
		return this.mostrarstockMovimientoInventario;
	}

	public void setMostrarstockMovimientoInventario(Boolean mostrarstockMovimientoInventario) {
		this.mostrarstockMovimientoInventario= mostrarstockMovimientoInventario;
	}

	public Boolean getActivarstockMovimientoInventario() {
		return this.activarstockMovimientoInventario;
	}

	public void setActivarstockMovimientoInventario(Boolean activarstockMovimientoInventario) {
		this.activarstockMovimientoInventario= activarstockMovimientoInventario;
	}

	public Border setResaltarsub_totalMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarsub_totalMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalMovimientoInventario() {
		return this.resaltarsub_totalMovimientoInventario;
	}

	public void setResaltarsub_totalMovimientoInventario(Border borderResaltar) {
		this.resaltarsub_totalMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarsub_totalMovimientoInventario() {
		return this.mostrarsub_totalMovimientoInventario;
	}

	public void setMostrarsub_totalMovimientoInventario(Boolean mostrarsub_totalMovimientoInventario) {
		this.mostrarsub_totalMovimientoInventario= mostrarsub_totalMovimientoInventario;
	}

	public Boolean getActivarsub_totalMovimientoInventario() {
		return this.activarsub_totalMovimientoInventario;
	}

	public void setActivarsub_totalMovimientoInventario(Boolean activarsub_totalMovimientoInventario) {
		this.activarsub_totalMovimientoInventario= activarsub_totalMovimientoInventario;
	}

	public Border setResaltartotal_otroMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltartotal_otroMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_otroMovimientoInventario() {
		return this.resaltartotal_otroMovimientoInventario;
	}

	public void setResaltartotal_otroMovimientoInventario(Border borderResaltar) {
		this.resaltartotal_otroMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrartotal_otroMovimientoInventario() {
		return this.mostrartotal_otroMovimientoInventario;
	}

	public void setMostrartotal_otroMovimientoInventario(Boolean mostrartotal_otroMovimientoInventario) {
		this.mostrartotal_otroMovimientoInventario= mostrartotal_otroMovimientoInventario;
	}

	public Boolean getActivartotal_otroMovimientoInventario() {
		return this.activartotal_otroMovimientoInventario;
	}

	public void setActivartotal_otroMovimientoInventario(Boolean activartotal_otroMovimientoInventario) {
		this.activartotal_otroMovimientoInventario= activartotal_otroMovimientoInventario;
	}

	public Border setResaltarultimo_costoMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarultimo_costoMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarultimo_costoMovimientoInventario() {
		return this.resaltarultimo_costoMovimientoInventario;
	}

	public void setResaltarultimo_costoMovimientoInventario(Border borderResaltar) {
		this.resaltarultimo_costoMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarultimo_costoMovimientoInventario() {
		return this.mostrarultimo_costoMovimientoInventario;
	}

	public void setMostrarultimo_costoMovimientoInventario(Boolean mostrarultimo_costoMovimientoInventario) {
		this.mostrarultimo_costoMovimientoInventario= mostrarultimo_costoMovimientoInventario;
	}

	public Boolean getActivarultimo_costoMovimientoInventario() {
		return this.activarultimo_costoMovimientoInventario;
	}

	public void setActivarultimo_costoMovimientoInventario(Boolean activarultimo_costoMovimientoInventario) {
		this.activarultimo_costoMovimientoInventario= activarultimo_costoMovimientoInventario;
	}

	public Border setResaltarnumero_itemsMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarnumero_itemsMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_itemsMovimientoInventario() {
		return this.resaltarnumero_itemsMovimientoInventario;
	}

	public void setResaltarnumero_itemsMovimientoInventario(Border borderResaltar) {
		this.resaltarnumero_itemsMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarnumero_itemsMovimientoInventario() {
		return this.mostrarnumero_itemsMovimientoInventario;
	}

	public void setMostrarnumero_itemsMovimientoInventario(Boolean mostrarnumero_itemsMovimientoInventario) {
		this.mostrarnumero_itemsMovimientoInventario= mostrarnumero_itemsMovimientoInventario;
	}

	public Boolean getActivarnumero_itemsMovimientoInventario() {
		return this.activarnumero_itemsMovimientoInventario;
	}

	public void setActivarnumero_itemsMovimientoInventario(Boolean activarnumero_itemsMovimientoInventario) {
		this.activarnumero_itemsMovimientoInventario= activarnumero_itemsMovimientoInventario;
	}

	public Border setResaltarretencionMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarretencionMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarretencionMovimientoInventario() {
		return this.resaltarretencionMovimientoInventario;
	}

	public void setResaltarretencionMovimientoInventario(Border borderResaltar) {
		this.resaltarretencionMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarretencionMovimientoInventario() {
		return this.mostrarretencionMovimientoInventario;
	}

	public void setMostrarretencionMovimientoInventario(Boolean mostrarretencionMovimientoInventario) {
		this.mostrarretencionMovimientoInventario= mostrarretencionMovimientoInventario;
	}

	public Boolean getActivarretencionMovimientoInventario() {
		return this.activarretencionMovimientoInventario;
	}

	public void setActivarretencionMovimientoInventario(Boolean activarretencionMovimientoInventario) {
		this.activarretencionMovimientoInventario= activarretencionMovimientoInventario;
	}

	public Border setResaltartotalMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltartotalMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalMovimientoInventario() {
		return this.resaltartotalMovimientoInventario;
	}

	public void setResaltartotalMovimientoInventario(Border borderResaltar) {
		this.resaltartotalMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrartotalMovimientoInventario() {
		return this.mostrartotalMovimientoInventario;
	}

	public void setMostrartotalMovimientoInventario(Boolean mostrartotalMovimientoInventario) {
		this.mostrartotalMovimientoInventario= mostrartotalMovimientoInventario;
	}

	public Boolean getActivartotalMovimientoInventario() {
		return this.activartotalMovimientoInventario;
	}

	public void setActivartotalMovimientoInventario(Boolean activartotalMovimientoInventario) {
		this.activartotalMovimientoInventario= activartotalMovimientoInventario;
	}

	public Border setResaltarfleteMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarfleteMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteMovimientoInventario() {
		return this.resaltarfleteMovimientoInventario;
	}

	public void setResaltarfleteMovimientoInventario(Border borderResaltar) {
		this.resaltarfleteMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarfleteMovimientoInventario() {
		return this.mostrarfleteMovimientoInventario;
	}

	public void setMostrarfleteMovimientoInventario(Boolean mostrarfleteMovimientoInventario) {
		this.mostrarfleteMovimientoInventario= mostrarfleteMovimientoInventario;
	}

	public Boolean getActivarfleteMovimientoInventario() {
		return this.activarfleteMovimientoInventario;
	}

	public void setActivarfleteMovimientoInventario(Boolean activarfleteMovimientoInventario) {
		this.activarfleteMovimientoInventario= activarfleteMovimientoInventario;
	}

	public Border setResaltarimpuestoMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarimpuestoMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimpuestoMovimientoInventario() {
		return this.resaltarimpuestoMovimientoInventario;
	}

	public void setResaltarimpuestoMovimientoInventario(Border borderResaltar) {
		this.resaltarimpuestoMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarimpuestoMovimientoInventario() {
		return this.mostrarimpuestoMovimientoInventario;
	}

	public void setMostrarimpuestoMovimientoInventario(Boolean mostrarimpuestoMovimientoInventario) {
		this.mostrarimpuestoMovimientoInventario= mostrarimpuestoMovimientoInventario;
	}

	public Boolean getActivarimpuestoMovimientoInventario() {
		return this.activarimpuestoMovimientoInventario;
	}

	public void setActivarimpuestoMovimientoInventario(Boolean activarimpuestoMovimientoInventario) {
		this.activarimpuestoMovimientoInventario= activarimpuestoMovimientoInventario;
	}

	public Border setResaltarid_tipo_transaccion_moduloMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloMovimientoInventario() {
		return this.resaltarid_tipo_transaccion_moduloMovimientoInventario;
	}

	public void setResaltarid_tipo_transaccion_moduloMovimientoInventario(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloMovimientoInventario() {
		return this.mostrarid_tipo_transaccion_moduloMovimientoInventario;
	}

	public void setMostrarid_tipo_transaccion_moduloMovimientoInventario(Boolean mostrarid_tipo_transaccion_moduloMovimientoInventario) {
		this.mostrarid_tipo_transaccion_moduloMovimientoInventario= mostrarid_tipo_transaccion_moduloMovimientoInventario;
	}

	public Boolean getActivarid_tipo_transaccion_moduloMovimientoInventario() {
		return this.activarid_tipo_transaccion_moduloMovimientoInventario;
	}

	public void setActivarid_tipo_transaccion_moduloMovimientoInventario(Boolean activarid_tipo_transaccion_moduloMovimientoInventario) {
		this.activarid_tipo_transaccion_moduloMovimientoInventario= activarid_tipo_transaccion_moduloMovimientoInventario;
	}

	public Boolean getCargarid_tipo_transaccion_moduloMovimientoInventario() {
		return this.cargarid_tipo_transaccion_moduloMovimientoInventario;
	}

	public void setCargarid_tipo_transaccion_moduloMovimientoInventario(Boolean cargarid_tipo_transaccion_moduloMovimientoInventario) {
		this.cargarid_tipo_transaccion_moduloMovimientoInventario= cargarid_tipo_transaccion_moduloMovimientoInventario;
	}

	public Border setResaltarid_compraMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_compraMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_compraMovimientoInventario() {
		return this.resaltarid_compraMovimientoInventario;
	}

	public void setResaltarid_compraMovimientoInventario(Border borderResaltar) {
		this.resaltarid_compraMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_compraMovimientoInventario() {
		return this.mostrarid_compraMovimientoInventario;
	}

	public void setMostrarid_compraMovimientoInventario(Boolean mostrarid_compraMovimientoInventario) {
		this.mostrarid_compraMovimientoInventario= mostrarid_compraMovimientoInventario;
	}

	public Boolean getActivarid_compraMovimientoInventario() {
		return this.activarid_compraMovimientoInventario;
	}

	public void setActivarid_compraMovimientoInventario(Boolean activarid_compraMovimientoInventario) {
		this.activarid_compraMovimientoInventario= activarid_compraMovimientoInventario;
	}

	public Boolean getCargarid_compraMovimientoInventario() {
		return this.cargarid_compraMovimientoInventario;
	}

	public void setCargarid_compraMovimientoInventario(Boolean cargarid_compraMovimientoInventario) {
		this.cargarid_compraMovimientoInventario= cargarid_compraMovimientoInventario;
	}

	public Border setResaltarid_asiento_contableMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableMovimientoInventario() {
		return this.resaltarid_asiento_contableMovimientoInventario;
	}

	public void setResaltarid_asiento_contableMovimientoInventario(Border borderResaltar) {
		this.resaltarid_asiento_contableMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableMovimientoInventario() {
		return this.mostrarid_asiento_contableMovimientoInventario;
	}

	public void setMostrarid_asiento_contableMovimientoInventario(Boolean mostrarid_asiento_contableMovimientoInventario) {
		this.mostrarid_asiento_contableMovimientoInventario= mostrarid_asiento_contableMovimientoInventario;
	}

	public Boolean getActivarid_asiento_contableMovimientoInventario() {
		return this.activarid_asiento_contableMovimientoInventario;
	}

	public void setActivarid_asiento_contableMovimientoInventario(Boolean activarid_asiento_contableMovimientoInventario) {
		this.activarid_asiento_contableMovimientoInventario= activarid_asiento_contableMovimientoInventario;
	}

	public Boolean getCargarid_asiento_contableMovimientoInventario() {
		return this.cargarid_asiento_contableMovimientoInventario;
	}

	public void setCargarid_asiento_contableMovimientoInventario(Boolean cargarid_asiento_contableMovimientoInventario) {
		this.cargarid_asiento_contableMovimientoInventario= cargarid_asiento_contableMovimientoInventario;
	}

	public Border setResaltargenerico_idMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltargenerico_idMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargenerico_idMovimientoInventario() {
		return this.resaltargenerico_idMovimientoInventario;
	}

	public void setResaltargenerico_idMovimientoInventario(Border borderResaltar) {
		this.resaltargenerico_idMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrargenerico_idMovimientoInventario() {
		return this.mostrargenerico_idMovimientoInventario;
	}

	public void setMostrargenerico_idMovimientoInventario(Boolean mostrargenerico_idMovimientoInventario) {
		this.mostrargenerico_idMovimientoInventario= mostrargenerico_idMovimientoInventario;
	}

	public Boolean getActivargenerico_idMovimientoInventario() {
		return this.activargenerico_idMovimientoInventario;
	}

	public void setActivargenerico_idMovimientoInventario(Boolean activargenerico_idMovimientoInventario) {
		this.activargenerico_idMovimientoInventario= activargenerico_idMovimientoInventario;
	}

	public Border setResaltartipo_idMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltartipo_idMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipo_idMovimientoInventario() {
		return this.resaltartipo_idMovimientoInventario;
	}

	public void setResaltartipo_idMovimientoInventario(Border borderResaltar) {
		this.resaltartipo_idMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrartipo_idMovimientoInventario() {
		return this.mostrartipo_idMovimientoInventario;
	}

	public void setMostrartipo_idMovimientoInventario(Boolean mostrartipo_idMovimientoInventario) {
		this.mostrartipo_idMovimientoInventario= mostrartipo_idMovimientoInventario;
	}

	public Boolean getActivartipo_idMovimientoInventario() {
		return this.activartipo_idMovimientoInventario;
	}

	public void setActivartipo_idMovimientoInventario(Boolean activartipo_idMovimientoInventario) {
		this.activartipo_idMovimientoInventario= activartipo_idMovimientoInventario;
	}

	public Border setResaltarnumero_comprobanteMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteMovimientoInventario() {
		return this.resaltarnumero_comprobanteMovimientoInventario;
	}

	public void setResaltarnumero_comprobanteMovimientoInventario(Border borderResaltar) {
		this.resaltarnumero_comprobanteMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteMovimientoInventario() {
		return this.mostrarnumero_comprobanteMovimientoInventario;
	}

	public void setMostrarnumero_comprobanteMovimientoInventario(Boolean mostrarnumero_comprobanteMovimientoInventario) {
		this.mostrarnumero_comprobanteMovimientoInventario= mostrarnumero_comprobanteMovimientoInventario;
	}

	public Boolean getActivarnumero_comprobanteMovimientoInventario() {
		return this.activarnumero_comprobanteMovimientoInventario;
	}

	public void setActivarnumero_comprobanteMovimientoInventario(Boolean activarnumero_comprobanteMovimientoInventario) {
		this.activarnumero_comprobanteMovimientoInventario= activarnumero_comprobanteMovimientoInventario;
	}

	public Border setResaltarfechaMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltar);
		
		this.resaltarfechaMovimientoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaMovimientoInventario() {
		return this.resaltarfechaMovimientoInventario;
	}

	public void setResaltarfechaMovimientoInventario(Border borderResaltar) {
		this.resaltarfechaMovimientoInventario= borderResaltar;
	}

	public Boolean getMostrarfechaMovimientoInventario() {
		return this.mostrarfechaMovimientoInventario;
	}

	public void setMostrarfechaMovimientoInventario(Boolean mostrarfechaMovimientoInventario) {
		this.mostrarfechaMovimientoInventario= mostrarfechaMovimientoInventario;
	}

	public Boolean getActivarfechaMovimientoInventario() {
		return this.activarfechaMovimientoInventario;
	}

	public void setActivarfechaMovimientoInventario(Boolean activarfechaMovimientoInventario) {
		this.activarfechaMovimientoInventario= activarfechaMovimientoInventario;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridMovimientoInventario(esInicial);
		this.setMostrarid_empresaMovimientoInventario(esInicial);
		this.setMostrarid_sucursalMovimientoInventario(esInicial);
		this.setMostrarid_moduloMovimientoInventario(esInicial);
		this.setMostrarid_ejercicioMovimientoInventario(esInicial);
		this.setMostrarid_periodoMovimientoInventario(esInicial);
		this.setMostrarid_anioMovimientoInventario(esInicial);
		this.setMostrarid_mesMovimientoInventario(esInicial);
		this.setMostrarid_usuarioMovimientoInventario(esInicial);
		this.setMostrarid_transaccionMovimientoInventario(esInicial);
		this.setMostrarfecha_emisionMovimientoInventario(esInicial);
		this.setMostrarfecha_entregaMovimientoInventario(esInicial);
		this.setMostrarnumero_secuencialMovimientoInventario(esInicial);
		this.setMostrarid_monedaMovimientoInventario(esInicial);
		this.setMostrarid_tipo_cambioMovimientoInventario(esInicial);
		this.setMostrarid_estado_movimiento_inventarioMovimientoInventario(esInicial);
		this.setMostrarid_empleadoMovimientoInventario(esInicial);
		this.setMostrarid_formatoMovimientoInventario(esInicial);
		this.setMostrarid_facturaMovimientoInventario(esInicial);
		this.setMostrarnumero_facturaMovimientoInventario(esInicial);
		this.setMostrarid_guia_remisionMovimientoInventario(esInicial);
		this.setMostrarid_transportistaMovimientoInventario(esInicial);
		this.setMostrardescripcionMovimientoInventario(esInicial);
		this.setMostrarporcentaje_descuentoMovimientoInventario(esInicial);
		this.setMostrarsumanMovimientoInventario(esInicial);
		this.setMostrariceMovimientoInventario(esInicial);
		this.setMostrarvalor_descuentoMovimientoInventario(esInicial);
		this.setMostrartotal_descuentoMovimientoInventario(esInicial);
		this.setMostrarivaMovimientoInventario(esInicial);
		this.setMostrarstockMovimientoInventario(esInicial);
		this.setMostrarsub_totalMovimientoInventario(esInicial);
		this.setMostrartotal_otroMovimientoInventario(esInicial);
		this.setMostrarultimo_costoMovimientoInventario(esInicial);
		this.setMostrarnumero_itemsMovimientoInventario(esInicial);
		this.setMostrarretencionMovimientoInventario(esInicial);
		this.setMostrartotalMovimientoInventario(esInicial);
		this.setMostrarfleteMovimientoInventario(esInicial);
		this.setMostrarimpuestoMovimientoInventario(esInicial);
		this.setMostrarid_tipo_transaccion_moduloMovimientoInventario(esInicial);
		this.setMostrarid_compraMovimientoInventario(esInicial);
		this.setMostrarid_asiento_contableMovimientoInventario(esInicial);
		this.setMostrargenerico_idMovimientoInventario(esInicial);
		this.setMostrartipo_idMovimientoInventario(esInicial);
		this.setMostrarnumero_comprobanteMovimientoInventario(esInicial);
		this.setMostrarfechaMovimientoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.ID)) {
				this.setMostraridMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDMES)) {
				this.setMostrarid_mesMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.FECHAENTREGA)) {
				this.setMostrarfecha_entregaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setMostrarnumero_secuencialMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDESTADOMOVIMIENTOINVENTARIO)) {
				this.setMostrarid_estado_movimiento_inventarioMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDGUIAREMISION)) {
				this.setMostrarid_guia_remisionMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDTRANSPORTISTA)) {
				this.setMostrarid_transportistaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setMostrarporcentaje_descuentoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.SUMAN)) {
				this.setMostrarsumanMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.ICE)) {
				this.setMostrariceMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.VALORDESCUENTO)) {
				this.setMostrarvalor_descuentoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.TOTALDESCUENTO)) {
				this.setMostrartotal_descuentoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IVA)) {
				this.setMostrarivaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.STOCK)) {
				this.setMostrarstockMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.TOTALOTRO)) {
				this.setMostrartotal_otroMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.ULTIMOCOSTO)) {
				this.setMostrarultimo_costoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.NUMEROITEMS)) {
				this.setMostrarnumero_itemsMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.RETENCION)) {
				this.setMostrarretencionMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.TOTAL)) {
				this.setMostrartotalMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.FLETE)) {
				this.setMostrarfleteMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IMPUESTO)) {
				this.setMostrarimpuestoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDCOMPRA)) {
				this.setMostrarid_compraMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.GENERICOID)) {
				this.setMostrargenerico_idMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.TIPOID)) {
				this.setMostrartipo_idMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.FECHA)) {
				this.setMostrarfechaMovimientoInventario(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridMovimientoInventario(esInicial);
		this.setActivarid_empresaMovimientoInventario(esInicial);
		this.setActivarid_sucursalMovimientoInventario(esInicial);
		this.setActivarid_moduloMovimientoInventario(esInicial);
		this.setActivarid_ejercicioMovimientoInventario(esInicial);
		this.setActivarid_periodoMovimientoInventario(esInicial);
		this.setActivarid_anioMovimientoInventario(esInicial);
		this.setActivarid_mesMovimientoInventario(esInicial);
		this.setActivarid_usuarioMovimientoInventario(esInicial);
		this.setActivarid_transaccionMovimientoInventario(esInicial);
		this.setActivarfecha_emisionMovimientoInventario(esInicial);
		this.setActivarfecha_entregaMovimientoInventario(esInicial);
		this.setActivarnumero_secuencialMovimientoInventario(esInicial);
		this.setActivarid_monedaMovimientoInventario(esInicial);
		this.setActivarid_tipo_cambioMovimientoInventario(esInicial);
		this.setActivarid_estado_movimiento_inventarioMovimientoInventario(esInicial);
		this.setActivarid_empleadoMovimientoInventario(esInicial);
		this.setActivarid_formatoMovimientoInventario(esInicial);
		this.setActivarid_facturaMovimientoInventario(esInicial);
		this.setActivarnumero_facturaMovimientoInventario(esInicial);
		this.setActivarid_guia_remisionMovimientoInventario(esInicial);
		this.setActivarid_transportistaMovimientoInventario(esInicial);
		this.setActivardescripcionMovimientoInventario(esInicial);
		this.setActivarporcentaje_descuentoMovimientoInventario(esInicial);
		this.setActivarsumanMovimientoInventario(esInicial);
		this.setActivariceMovimientoInventario(esInicial);
		this.setActivarvalor_descuentoMovimientoInventario(esInicial);
		this.setActivartotal_descuentoMovimientoInventario(esInicial);
		this.setActivarivaMovimientoInventario(esInicial);
		this.setActivarstockMovimientoInventario(esInicial);
		this.setActivarsub_totalMovimientoInventario(esInicial);
		this.setActivartotal_otroMovimientoInventario(esInicial);
		this.setActivarultimo_costoMovimientoInventario(esInicial);
		this.setActivarnumero_itemsMovimientoInventario(esInicial);
		this.setActivarretencionMovimientoInventario(esInicial);
		this.setActivartotalMovimientoInventario(esInicial);
		this.setActivarfleteMovimientoInventario(esInicial);
		this.setActivarimpuestoMovimientoInventario(esInicial);
		this.setActivarid_tipo_transaccion_moduloMovimientoInventario(esInicial);
		this.setActivarid_compraMovimientoInventario(esInicial);
		this.setActivarid_asiento_contableMovimientoInventario(esInicial);
		this.setActivargenerico_idMovimientoInventario(esInicial);
		this.setActivartipo_idMovimientoInventario(esInicial);
		this.setActivarnumero_comprobanteMovimientoInventario(esInicial);
		this.setActivarfechaMovimientoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.ID)) {
				this.setActivaridMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDANIO)) {
				this.setActivarid_anioMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDMES)) {
				this.setActivarid_mesMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.FECHAENTREGA)) {
				this.setActivarfecha_entregaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setActivarnumero_secuencialMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDESTADOMOVIMIENTOINVENTARIO)) {
				this.setActivarid_estado_movimiento_inventarioMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDGUIAREMISION)) {
				this.setActivarid_guia_remisionMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDTRANSPORTISTA)) {
				this.setActivarid_transportistaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setActivarporcentaje_descuentoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.SUMAN)) {
				this.setActivarsumanMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.ICE)) {
				this.setActivariceMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.VALORDESCUENTO)) {
				this.setActivarvalor_descuentoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.TOTALDESCUENTO)) {
				this.setActivartotal_descuentoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IVA)) {
				this.setActivarivaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.STOCK)) {
				this.setActivarstockMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.TOTALOTRO)) {
				this.setActivartotal_otroMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.ULTIMOCOSTO)) {
				this.setActivarultimo_costoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.NUMEROITEMS)) {
				this.setActivarnumero_itemsMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.RETENCION)) {
				this.setActivarretencionMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.TOTAL)) {
				this.setActivartotalMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.FLETE)) {
				this.setActivarfleteMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IMPUESTO)) {
				this.setActivarimpuestoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDCOMPRA)) {
				this.setActivarid_compraMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.GENERICOID)) {
				this.setActivargenerico_idMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.TIPOID)) {
				this.setActivartipo_idMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.FECHA)) {
				this.setActivarfechaMovimientoInventario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridMovimientoInventario(esInicial);
		this.setResaltarid_empresaMovimientoInventario(esInicial);
		this.setResaltarid_sucursalMovimientoInventario(esInicial);
		this.setResaltarid_moduloMovimientoInventario(esInicial);
		this.setResaltarid_ejercicioMovimientoInventario(esInicial);
		this.setResaltarid_periodoMovimientoInventario(esInicial);
		this.setResaltarid_anioMovimientoInventario(esInicial);
		this.setResaltarid_mesMovimientoInventario(esInicial);
		this.setResaltarid_usuarioMovimientoInventario(esInicial);
		this.setResaltarid_transaccionMovimientoInventario(esInicial);
		this.setResaltarfecha_emisionMovimientoInventario(esInicial);
		this.setResaltarfecha_entregaMovimientoInventario(esInicial);
		this.setResaltarnumero_secuencialMovimientoInventario(esInicial);
		this.setResaltarid_monedaMovimientoInventario(esInicial);
		this.setResaltarid_tipo_cambioMovimientoInventario(esInicial);
		this.setResaltarid_estado_movimiento_inventarioMovimientoInventario(esInicial);
		this.setResaltarid_empleadoMovimientoInventario(esInicial);
		this.setResaltarid_formatoMovimientoInventario(esInicial);
		this.setResaltarid_facturaMovimientoInventario(esInicial);
		this.setResaltarnumero_facturaMovimientoInventario(esInicial);
		this.setResaltarid_guia_remisionMovimientoInventario(esInicial);
		this.setResaltarid_transportistaMovimientoInventario(esInicial);
		this.setResaltardescripcionMovimientoInventario(esInicial);
		this.setResaltarporcentaje_descuentoMovimientoInventario(esInicial);
		this.setResaltarsumanMovimientoInventario(esInicial);
		this.setResaltariceMovimientoInventario(esInicial);
		this.setResaltarvalor_descuentoMovimientoInventario(esInicial);
		this.setResaltartotal_descuentoMovimientoInventario(esInicial);
		this.setResaltarivaMovimientoInventario(esInicial);
		this.setResaltarstockMovimientoInventario(esInicial);
		this.setResaltarsub_totalMovimientoInventario(esInicial);
		this.setResaltartotal_otroMovimientoInventario(esInicial);
		this.setResaltarultimo_costoMovimientoInventario(esInicial);
		this.setResaltarnumero_itemsMovimientoInventario(esInicial);
		this.setResaltarretencionMovimientoInventario(esInicial);
		this.setResaltartotalMovimientoInventario(esInicial);
		this.setResaltarfleteMovimientoInventario(esInicial);
		this.setResaltarimpuestoMovimientoInventario(esInicial);
		this.setResaltarid_tipo_transaccion_moduloMovimientoInventario(esInicial);
		this.setResaltarid_compraMovimientoInventario(esInicial);
		this.setResaltarid_asiento_contableMovimientoInventario(esInicial);
		this.setResaltargenerico_idMovimientoInventario(esInicial);
		this.setResaltartipo_idMovimientoInventario(esInicial);
		this.setResaltarnumero_comprobanteMovimientoInventario(esInicial);
		this.setResaltarfechaMovimientoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.ID)) {
				this.setResaltaridMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDMES)) {
				this.setResaltarid_mesMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.FECHAENTREGA)) {
				this.setResaltarfecha_entregaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setResaltarnumero_secuencialMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDESTADOMOVIMIENTOINVENTARIO)) {
				this.setResaltarid_estado_movimiento_inventarioMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDGUIAREMISION)) {
				this.setResaltarid_guia_remisionMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDTRANSPORTISTA)) {
				this.setResaltarid_transportistaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setResaltarporcentaje_descuentoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.SUMAN)) {
				this.setResaltarsumanMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.ICE)) {
				this.setResaltariceMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.VALORDESCUENTO)) {
				this.setResaltarvalor_descuentoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.TOTALDESCUENTO)) {
				this.setResaltartotal_descuentoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IVA)) {
				this.setResaltarivaMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.STOCK)) {
				this.setResaltarstockMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.TOTALOTRO)) {
				this.setResaltartotal_otroMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.ULTIMOCOSTO)) {
				this.setResaltarultimo_costoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.NUMEROITEMS)) {
				this.setResaltarnumero_itemsMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.RETENCION)) {
				this.setResaltarretencionMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.TOTAL)) {
				this.setResaltartotalMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.FLETE)) {
				this.setResaltarfleteMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IMPUESTO)) {
				this.setResaltarimpuestoMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDCOMPRA)) {
				this.setResaltarid_compraMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.GENERICOID)) {
				this.setResaltargenerico_idMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.TIPOID)) {
				this.setResaltartipo_idMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteMovimientoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoInventarioConstantesFunciones.FECHA)) {
				this.setResaltarfechaMovimientoInventario(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleMovimientoInventarioMovimientoInventario=null;

	public Border getResaltarDetalleMovimientoInventarioMovimientoInventario() {
		return this.resaltarDetalleMovimientoInventarioMovimientoInventario;
	}

	public void setResaltarDetalleMovimientoInventarioMovimientoInventario(Border borderResaltarDetalleMovimientoInventario) {
		if(borderResaltarDetalleMovimientoInventario!=null) {
			this.resaltarDetalleMovimientoInventarioMovimientoInventario= borderResaltarDetalleMovimientoInventario;
		}
	}

	public Border setResaltarDetalleMovimientoInventarioMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleMovimientoInventario=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//movimientoinventarioBeanSwingJInternalFrame.jTtoolBarMovimientoInventario.setBorder(borderResaltarDetalleMovimientoInventario);
			
		this.resaltarDetalleMovimientoInventarioMovimientoInventario= borderResaltarDetalleMovimientoInventario;

		 return borderResaltarDetalleMovimientoInventario;
	}



	public Boolean mostrarDetalleMovimientoInventarioMovimientoInventario=true;

	public Boolean getMostrarDetalleMovimientoInventarioMovimientoInventario() {
		return this.mostrarDetalleMovimientoInventarioMovimientoInventario;
	}

	public void setMostrarDetalleMovimientoInventarioMovimientoInventario(Boolean visibilidadResaltarDetalleMovimientoInventario) {
		this.mostrarDetalleMovimientoInventarioMovimientoInventario= visibilidadResaltarDetalleMovimientoInventario;
	}



	public Boolean activarDetalleMovimientoInventarioMovimientoInventario=true;

	public Boolean gethabilitarResaltarDetalleMovimientoInventarioMovimientoInventario() {
		return this.activarDetalleMovimientoInventarioMovimientoInventario;
	}

	public void setActivarDetalleMovimientoInventarioMovimientoInventario(Boolean habilitarResaltarDetalleMovimientoInventario) {
		this.activarDetalleMovimientoInventarioMovimientoInventario= habilitarResaltarDetalleMovimientoInventario;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarDetalleMovimientoInventarioMovimientoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleMovimientoInventario.class)) {
				this.setMostrarDetalleMovimientoInventarioMovimientoInventario(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarDetalleMovimientoInventarioMovimientoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleMovimientoInventario.class)) {
				this.setActivarDetalleMovimientoInventarioMovimientoInventario(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleMovimientoInventarioMovimientoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleMovimientoInventario.class)) {
				this.setResaltarDetalleMovimientoInventarioMovimientoInventario(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdAsientoContableMovimientoInventario=true;

	public Boolean getMostrarFK_IdAsientoContableMovimientoInventario() {
		return this.mostrarFK_IdAsientoContableMovimientoInventario;
	}

	public void setMostrarFK_IdAsientoContableMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCompraMovimientoInventario=true;

	public Boolean getMostrarFK_IdCompraMovimientoInventario() {
		return this.mostrarFK_IdCompraMovimientoInventario;
	}

	public void setMostrarFK_IdCompraMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCompraMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioMovimientoInventario=true;

	public Boolean getMostrarFK_IdEjercicioMovimientoInventario() {
		return this.mostrarFK_IdEjercicioMovimientoInventario;
	}

	public void setMostrarFK_IdEjercicioMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoMovimientoInventario=true;

	public Boolean getMostrarFK_IdEmpleadoMovimientoInventario() {
		return this.mostrarFK_IdEmpleadoMovimientoInventario;
	}

	public void setMostrarFK_IdEmpleadoMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaMovimientoInventario=true;

	public Boolean getMostrarFK_IdEmpresaMovimientoInventario() {
		return this.mostrarFK_IdEmpresaMovimientoInventario;
	}

	public void setMostrarFK_IdEmpresaMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoMovimientoInventarioMovimientoInventario=true;

	public Boolean getMostrarFK_IdEstadoMovimientoInventarioMovimientoInventario() {
		return this.mostrarFK_IdEstadoMovimientoInventarioMovimientoInventario;
	}

	public void setMostrarFK_IdEstadoMovimientoInventarioMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoMovimientoInventarioMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaMovimientoInventario=true;

	public Boolean getMostrarFK_IdFacturaMovimientoInventario() {
		return this.mostrarFK_IdFacturaMovimientoInventario;
	}

	public void setMostrarFK_IdFacturaMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdGuiaRemisionMovimientoInventario=true;

	public Boolean getMostrarFK_IdGuiaRemisionMovimientoInventario() {
		return this.mostrarFK_IdGuiaRemisionMovimientoInventario;
	}

	public void setMostrarFK_IdGuiaRemisionMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdGuiaRemisionMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloMovimientoInventario=true;

	public Boolean getMostrarFK_IdModuloMovimientoInventario() {
		return this.mostrarFK_IdModuloMovimientoInventario;
	}

	public void setMostrarFK_IdModuloMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoMovimientoInventario=true;

	public Boolean getMostrarFK_IdPeriodoMovimientoInventario() {
		return this.mostrarFK_IdPeriodoMovimientoInventario;
	}

	public void setMostrarFK_IdPeriodoMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalMovimientoInventario=true;

	public Boolean getMostrarFK_IdSucursalMovimientoInventario() {
		return this.mostrarFK_IdSucursalMovimientoInventario;
	}

	public void setMostrarFK_IdSucursalMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTransaccionModuloMovimientoInventario=true;

	public Boolean getMostrarFK_IdTipoTransaccionModuloMovimientoInventario() {
		return this.mostrarFK_IdTipoTransaccionModuloMovimientoInventario;
	}

	public void setMostrarFK_IdTipoTransaccionModuloMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTransaccionModuloMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionMovimientoInventario=true;

	public Boolean getMostrarFK_IdTransaccionMovimientoInventario() {
		return this.mostrarFK_IdTransaccionMovimientoInventario;
	}

	public void setMostrarFK_IdTransaccionMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionMovimientoInventario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioMovimientoInventario=true;

	public Boolean getMostrarFK_IdUsuarioMovimientoInventario() {
		return this.mostrarFK_IdUsuarioMovimientoInventario;
	}

	public void setMostrarFK_IdUsuarioMovimientoInventario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioMovimientoInventario= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableMovimientoInventario=true;

	public Boolean getActivarFK_IdAsientoContableMovimientoInventario() {
		return this.activarFK_IdAsientoContableMovimientoInventario;
	}

	public void setActivarFK_IdAsientoContableMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdCompraMovimientoInventario=true;

	public Boolean getActivarFK_IdCompraMovimientoInventario() {
		return this.activarFK_IdCompraMovimientoInventario;
	}

	public void setActivarFK_IdCompraMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdCompraMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioMovimientoInventario=true;

	public Boolean getActivarFK_IdEjercicioMovimientoInventario() {
		return this.activarFK_IdEjercicioMovimientoInventario;
	}

	public void setActivarFK_IdEjercicioMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoMovimientoInventario=true;

	public Boolean getActivarFK_IdEmpleadoMovimientoInventario() {
		return this.activarFK_IdEmpleadoMovimientoInventario;
	}

	public void setActivarFK_IdEmpleadoMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaMovimientoInventario=true;

	public Boolean getActivarFK_IdEmpresaMovimientoInventario() {
		return this.activarFK_IdEmpresaMovimientoInventario;
	}

	public void setActivarFK_IdEmpresaMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoMovimientoInventarioMovimientoInventario=true;

	public Boolean getActivarFK_IdEstadoMovimientoInventarioMovimientoInventario() {
		return this.activarFK_IdEstadoMovimientoInventarioMovimientoInventario;
	}

	public void setActivarFK_IdEstadoMovimientoInventarioMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoMovimientoInventarioMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaMovimientoInventario=true;

	public Boolean getActivarFK_IdFacturaMovimientoInventario() {
		return this.activarFK_IdFacturaMovimientoInventario;
	}

	public void setActivarFK_IdFacturaMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdGuiaRemisionMovimientoInventario=true;

	public Boolean getActivarFK_IdGuiaRemisionMovimientoInventario() {
		return this.activarFK_IdGuiaRemisionMovimientoInventario;
	}

	public void setActivarFK_IdGuiaRemisionMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdGuiaRemisionMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloMovimientoInventario=true;

	public Boolean getActivarFK_IdModuloMovimientoInventario() {
		return this.activarFK_IdModuloMovimientoInventario;
	}

	public void setActivarFK_IdModuloMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdModuloMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoMovimientoInventario=true;

	public Boolean getActivarFK_IdPeriodoMovimientoInventario() {
		return this.activarFK_IdPeriodoMovimientoInventario;
	}

	public void setActivarFK_IdPeriodoMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalMovimientoInventario=true;

	public Boolean getActivarFK_IdSucursalMovimientoInventario() {
		return this.activarFK_IdSucursalMovimientoInventario;
	}

	public void setActivarFK_IdSucursalMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTransaccionModuloMovimientoInventario=true;

	public Boolean getActivarFK_IdTipoTransaccionModuloMovimientoInventario() {
		return this.activarFK_IdTipoTransaccionModuloMovimientoInventario;
	}

	public void setActivarFK_IdTipoTransaccionModuloMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTransaccionModuloMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionMovimientoInventario=true;

	public Boolean getActivarFK_IdTransaccionMovimientoInventario() {
		return this.activarFK_IdTransaccionMovimientoInventario;
	}

	public void setActivarFK_IdTransaccionMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionMovimientoInventario= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioMovimientoInventario=true;

	public Boolean getActivarFK_IdUsuarioMovimientoInventario() {
		return this.activarFK_IdUsuarioMovimientoInventario;
	}

	public void setActivarFK_IdUsuarioMovimientoInventario(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioMovimientoInventario= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableMovimientoInventario=null;

	public Border getResaltarFK_IdAsientoContableMovimientoInventario() {
		return this.resaltarFK_IdAsientoContableMovimientoInventario;
	}

	public void setResaltarFK_IdAsientoContableMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdCompraMovimientoInventario=null;

	public Border getResaltarFK_IdCompraMovimientoInventario() {
		return this.resaltarFK_IdCompraMovimientoInventario;
	}

	public void setResaltarFK_IdCompraMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdCompraMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdCompraMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCompraMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioMovimientoInventario=null;

	public Border getResaltarFK_IdEjercicioMovimientoInventario() {
		return this.resaltarFK_IdEjercicioMovimientoInventario;
	}

	public void setResaltarFK_IdEjercicioMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdEjercicioMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoMovimientoInventario=null;

	public Border getResaltarFK_IdEmpleadoMovimientoInventario() {
		return this.resaltarFK_IdEmpleadoMovimientoInventario;
	}

	public void setResaltarFK_IdEmpleadoMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaMovimientoInventario=null;

	public Border getResaltarFK_IdEmpresaMovimientoInventario() {
		return this.resaltarFK_IdEmpresaMovimientoInventario;
	}

	public void setResaltarFK_IdEmpresaMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdEmpresaMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdEstadoMovimientoInventarioMovimientoInventario=null;

	public Border getResaltarFK_IdEstadoMovimientoInventarioMovimientoInventario() {
		return this.resaltarFK_IdEstadoMovimientoInventarioMovimientoInventario;
	}

	public void setResaltarFK_IdEstadoMovimientoInventarioMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdEstadoMovimientoInventarioMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdEstadoMovimientoInventarioMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoMovimientoInventarioMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdFacturaMovimientoInventario=null;

	public Border getResaltarFK_IdFacturaMovimientoInventario() {
		return this.resaltarFK_IdFacturaMovimientoInventario;
	}

	public void setResaltarFK_IdFacturaMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdFacturaMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdFacturaMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdGuiaRemisionMovimientoInventario=null;

	public Border getResaltarFK_IdGuiaRemisionMovimientoInventario() {
		return this.resaltarFK_IdGuiaRemisionMovimientoInventario;
	}

	public void setResaltarFK_IdGuiaRemisionMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdGuiaRemisionMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdGuiaRemisionMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdGuiaRemisionMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdModuloMovimientoInventario=null;

	public Border getResaltarFK_IdModuloMovimientoInventario() {
		return this.resaltarFK_IdModuloMovimientoInventario;
	}

	public void setResaltarFK_IdModuloMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdModuloMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdModuloMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoMovimientoInventario=null;

	public Border getResaltarFK_IdPeriodoMovimientoInventario() {
		return this.resaltarFK_IdPeriodoMovimientoInventario;
	}

	public void setResaltarFK_IdPeriodoMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdPeriodoMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdSucursalMovimientoInventario=null;

	public Border getResaltarFK_IdSucursalMovimientoInventario() {
		return this.resaltarFK_IdSucursalMovimientoInventario;
	}

	public void setResaltarFK_IdSucursalMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdSucursalMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdSucursalMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdTipoTransaccionModuloMovimientoInventario=null;

	public Border getResaltarFK_IdTipoTransaccionModuloMovimientoInventario() {
		return this.resaltarFK_IdTipoTransaccionModuloMovimientoInventario;
	}

	public void setResaltarFK_IdTipoTransaccionModuloMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdTipoTransaccionModuloMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdTipoTransaccionModuloMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTransaccionModuloMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionMovimientoInventario=null;

	public Border getResaltarFK_IdTransaccionMovimientoInventario() {
		return this.resaltarFK_IdTransaccionMovimientoInventario;
	}

	public void setResaltarFK_IdTransaccionMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdTransaccionMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionMovimientoInventario= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioMovimientoInventario=null;

	public Border getResaltarFK_IdUsuarioMovimientoInventario() {
		return this.resaltarFK_IdUsuarioMovimientoInventario;
	}

	public void setResaltarFK_IdUsuarioMovimientoInventario(Border borderResaltar) {
		this.resaltarFK_IdUsuarioMovimientoInventario= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioMovimientoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoInventarioBeanSwingJInternalFrame movimientoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioMovimientoInventario= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}