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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.DetallePedidoExporConstantesFunciones;
import com.bydan.erp.facturacion.util.DetallePedidoExporParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetallePedidoExporParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetallePedidoExporConstantesFunciones extends DetallePedidoExporConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=150;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=150;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=150 + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=150 + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
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
	public static final String SNOMBREOPCION="DetallePedidoExpor";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetallePedidoExpor"+DetallePedidoExporConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetallePedidoExporHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetallePedidoExporHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetallePedidoExporConstantesFunciones.SCHEMA+"_"+DetallePedidoExporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetallePedidoExporHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetallePedidoExporConstantesFunciones.SCHEMA+"_"+DetallePedidoExporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetallePedidoExporConstantesFunciones.SCHEMA+"_"+DetallePedidoExporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetallePedidoExporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetallePedidoExporConstantesFunciones.SCHEMA+"_"+DetallePedidoExporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoExporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePedidoExporHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoExporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoExporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePedidoExporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoExporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetallePedidoExporConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetallePedidoExporConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetallePedidoExporConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetallePedidoExporConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Pedido Exportacions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Pedido Exportacion";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Pedido Expor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetallePedidoExpor";
	public static final String OBJECTNAME="detallepedidoexpor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="detalle_pedido_expor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallepedidoexpor from "+DetallePedidoExporConstantesFunciones.SPERSISTENCENAME+" detallepedidoexpor";
	public static String QUERYSELECTNATIVE="select "+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".version_row,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_empresa,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_sucursal,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_ejercicio,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_periodo,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_anio,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_mes,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_pedido_expor,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_bodega,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_producto,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_unidad,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".id_estado_detalle_pedido,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".cantidad,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".precio,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".descuento_porcentaje,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".descuento_valor,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".iva,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".total,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".ice,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".costo,"+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME+".utilidad from "+DetallePedidoExporConstantesFunciones.SCHEMA+"."+DetallePedidoExporConstantesFunciones.TABLENAME;//+" as "+DetallePedidoExporConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetallePedidoExporConstantesFuncionesAdditional detallepedidoexporConstantesFuncionesAdditional=null;
	
	public DetallePedidoExporConstantesFuncionesAdditional getDetallePedidoExporConstantesFuncionesAdditional() {
		return this.detallepedidoexporConstantesFuncionesAdditional;
	}
	
	public void setDetallePedidoExporConstantesFuncionesAdditional(DetallePedidoExporConstantesFuncionesAdditional detallepedidoexporConstantesFuncionesAdditional) {
		try {
			this.detallepedidoexporConstantesFuncionesAdditional=detallepedidoexporConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDPEDIDOEXPOR= "id_pedido_expor";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String IDESTADODETALLEPEDIDOEXPOR= "id_estado_detalle_pedido";
    public static final String CANTIDAD= "cantidad";
    public static final String PRECIO= "precio";
    public static final String DESCUENTOPORCENTAJE= "descuento_porcentaje";
    public static final String DESCUENTOVALOR= "descuento_valor";
    public static final String IVA= "iva";
    public static final String TOTAL= "total";
    public static final String ICE= "ice";
    public static final String COSTO= "costo";
    public static final String UTILIDAD= "utilidad";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDPEDIDOEXPOR= "Pedido Exportacion";
		public static final String LABEL_IDPEDIDOEXPOR_LOWER= "Pedido Expor";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unidad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_IDESTADODETALLEPEDIDOEXPOR= "Estado";
		public static final String LABEL_IDESTADODETALLEPEDIDOEXPOR_LOWER= "Estado Detalle Pedido Expor";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_DESCUENTOPORCENTAJE= "Dscto %";
		public static final String LABEL_DESCUENTOPORCENTAJE_LOWER= "Descuento Porcentaje";
    	public static final String LABEL_DESCUENTOVALOR= "Dscto Valor";
		public static final String LABEL_DESCUENTOVALOR_LOWER= "Descuento Valor";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_UTILIDAD= "Utilidad";
		public static final String LABEL_UTILIDAD_LOWER= "Utilidad";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getDetallePedidoExporLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.IDPERIODO)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.IDANIO)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.IDMES)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.IDPEDIDOEXPOR)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_IDPEDIDOEXPOR;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.IDBODEGA)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.IDESTADODETALLEPEDIDOEXPOR)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_IDESTADODETALLEPEDIDOEXPOR;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.CANTIDAD)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.PRECIO)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.DESCUENTOPORCENTAJE)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_DESCUENTOPORCENTAJE;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.IVA)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.TOTAL)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.ICE)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.COSTO)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(DetallePedidoExporConstantesFunciones.UTILIDAD)) {sLabelColumna=DetallePedidoExporConstantesFunciones.LABEL_UTILIDAD;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetallePedidoExporDescripcion(DetallePedidoExpor detallepedidoexpor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallepedidoexpor !=null/* && detallepedidoexpor.getId()!=0*/) {
			if(detallepedidoexpor.getId()!=null) {
				sDescripcion=detallepedidoexpor.getId().toString();
			}//detallepedidoexpordetallepedidoexpor.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetallePedidoExporDescripcionDetallado(DetallePedidoExpor detallepedidoexpor) {
		String sDescripcion="";
			
		sDescripcion+=DetallePedidoExporConstantesFunciones.ID+"=";
		sDescripcion+=detallepedidoexpor.getId().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallepedidoexpor.getVersionRow().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallepedidoexpor.getid_empresa().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallepedidoexpor.getid_sucursal().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detallepedidoexpor.getid_ejercicio().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detallepedidoexpor.getid_periodo().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.IDANIO+"=";
		sDescripcion+=detallepedidoexpor.getid_anio().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.IDMES+"=";
		sDescripcion+=detallepedidoexpor.getid_mes().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.IDPEDIDOEXPOR+"=";
		sDescripcion+=detallepedidoexpor.getid_pedido_expor().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detallepedidoexpor.getid_bodega().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detallepedidoexpor.getid_producto().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detallepedidoexpor.getid_unidad().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.IDESTADODETALLEPEDIDOEXPOR+"=";
		sDescripcion+=detallepedidoexpor.getid_estado_detalle_pedido().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detallepedidoexpor.getcantidad().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.PRECIO+"=";
		sDescripcion+=detallepedidoexpor.getprecio().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.DESCUENTOPORCENTAJE+"=";
		sDescripcion+=detallepedidoexpor.getdescuento_porcentaje().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=detallepedidoexpor.getdescuento_valor().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.IVA+"=";
		sDescripcion+=detallepedidoexpor.getiva().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.TOTAL+"=";
		sDescripcion+=detallepedidoexpor.gettotal().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.ICE+"=";
		sDescripcion+=detallepedidoexpor.getice().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.COSTO+"=";
		sDescripcion+=detallepedidoexpor.getcosto().toString()+",";
		sDescripcion+=DetallePedidoExporConstantesFunciones.UTILIDAD+"=";
		sDescripcion+=detallepedidoexpor.getutilidad().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetallePedidoExporDescripcion(DetallePedidoExpor detallepedidoexpor,String sValor) throws Exception {			
		if(detallepedidoexpor !=null) {
			//detallepedidoexpordetallepedidoexpor.getId().toString();
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

	public static String getPedidoExporDescripcion(PedidoExpor pedidoexpor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pedidoexpor!=null/*&&pedidoexpor.getId()>0*/) {
			sDescripcion=PedidoExporConstantesFunciones.getPedidoExporDescripcion(pedidoexpor);
		}

		return sDescripcion;
	}

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}

	public static String getUnidadDescripcion(Unidad unidad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(unidad!=null/*&&unidad.getId()>0*/) {
			sDescripcion=UnidadConstantesFunciones.getUnidadDescripcion(unidad);
		}

		return sDescripcion;
	}

	public static String getEstadoDetallePedidoExporDescripcion(EstadoDetallePedido estadodetallepedido) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadodetallepedido!=null/*&&estadodetallepedido.getId()>0*/) {
			sDescripcion=EstadoDetallePedidoConstantesFunciones.getEstadoDetallePedidoDescripcion(estadodetallepedido);
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
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoDetallePedidoExpor")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPedidoExpor")) {
			sNombreIndice="Tipo=  Por Pedido Exportacion";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unidad";
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

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoDetallePedidoExpor(Long id_estado_detalle_pedido) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_detalle_pedido!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_detalle_pedido.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPedidoExpor(Long id_pedido_expor) {
		String sDetalleIndice=" Parametros->";
		if(id_pedido_expor!=null) {sDetalleIndice+=" Codigo Unico De Pedido Exportacion="+id_pedido_expor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unidad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetallePedidoExpor(DetallePedidoExpor detallepedidoexpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosDetallePedidoExpors(List<DetallePedidoExpor> detallepedidoexpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetallePedidoExpor detallepedidoexpor: detallepedidoexpors) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePedidoExpor(DetallePedidoExpor detallepedidoexpor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallepedidoexpor.getConCambioAuxiliar()) {
			detallepedidoexpor.setIsDeleted(detallepedidoexpor.getIsDeletedAuxiliar());	
			detallepedidoexpor.setIsNew(detallepedidoexpor.getIsNewAuxiliar());	
			detallepedidoexpor.setIsChanged(detallepedidoexpor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallepedidoexpor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallepedidoexpor.setIsDeletedAuxiliar(false);	
			detallepedidoexpor.setIsNewAuxiliar(false);	
			detallepedidoexpor.setIsChangedAuxiliar(false);
			
			detallepedidoexpor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePedidoExpors(List<DetallePedidoExpor> detallepedidoexpors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetallePedidoExpor detallepedidoexpor : detallepedidoexpors) {
			if(conAsignarBase && detallepedidoexpor.getConCambioAuxiliar()) {
				detallepedidoexpor.setIsDeleted(detallepedidoexpor.getIsDeletedAuxiliar());	
				detallepedidoexpor.setIsNew(detallepedidoexpor.getIsNewAuxiliar());	
				detallepedidoexpor.setIsChanged(detallepedidoexpor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallepedidoexpor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallepedidoexpor.setIsDeletedAuxiliar(false);	
				detallepedidoexpor.setIsNewAuxiliar(false);	
				detallepedidoexpor.setIsChangedAuxiliar(false);
				
				detallepedidoexpor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetallePedidoExpor(DetallePedidoExpor detallepedidoexpor,Boolean conEnteros) throws Exception  {
		detallepedidoexpor.setprecio(0.0);
		detallepedidoexpor.setdescuento_porcentaje(0.0);
		detallepedidoexpor.setdescuento_valor(0.0);
		detallepedidoexpor.setiva(0.0);
		detallepedidoexpor.settotal(0.0);
		detallepedidoexpor.setice(0.0);
		detallepedidoexpor.setcosto(0.0);
		detallepedidoexpor.setutilidad(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detallepedidoexpor.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresDetallePedidoExpors(List<DetallePedidoExpor> detallepedidoexpors,Boolean conEnteros) throws Exception  {
		
		for(DetallePedidoExpor detallepedidoexpor: detallepedidoexpors) {
			detallepedidoexpor.setprecio(0.0);
			detallepedidoexpor.setdescuento_porcentaje(0.0);
			detallepedidoexpor.setdescuento_valor(0.0);
			detallepedidoexpor.setiva(0.0);
			detallepedidoexpor.settotal(0.0);
			detallepedidoexpor.setice(0.0);
			detallepedidoexpor.setcosto(0.0);
			detallepedidoexpor.setutilidad(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detallepedidoexpor.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetallePedidoExpor(List<DetallePedidoExpor> detallepedidoexpors,DetallePedidoExpor detallepedidoexporAux) throws Exception  {
		DetallePedidoExporConstantesFunciones.InicializarValoresDetallePedidoExpor(detallepedidoexporAux,true);
		
		for(DetallePedidoExpor detallepedidoexpor: detallepedidoexpors) {
			if(detallepedidoexpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallepedidoexporAux.setcantidad(detallepedidoexporAux.getcantidad()+detallepedidoexpor.getcantidad());			
			detallepedidoexporAux.setprecio(detallepedidoexporAux.getprecio()+detallepedidoexpor.getprecio());			
			detallepedidoexporAux.setdescuento_porcentaje(detallepedidoexporAux.getdescuento_porcentaje()+detallepedidoexpor.getdescuento_porcentaje());			
			detallepedidoexporAux.setdescuento_valor(detallepedidoexporAux.getdescuento_valor()+detallepedidoexpor.getdescuento_valor());			
			detallepedidoexporAux.setiva(detallepedidoexporAux.getiva()+detallepedidoexpor.getiva());			
			detallepedidoexporAux.settotal(detallepedidoexporAux.gettotal()+detallepedidoexpor.gettotal());			
			detallepedidoexporAux.setice(detallepedidoexporAux.getice()+detallepedidoexpor.getice());			
			detallepedidoexporAux.setcosto(detallepedidoexporAux.getcosto()+detallepedidoexpor.getcosto());			
			detallepedidoexporAux.setutilidad(detallepedidoexporAux.getutilidad()+detallepedidoexpor.getutilidad());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePedidoExpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetallePedidoExporConstantesFunciones.getArrayColumnasGlobalesDetallePedidoExpor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePedidoExpor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoExporConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoExporConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoExporConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoExporConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoExporConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoExporConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoExporConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoExporConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetallePedidoExpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetallePedidoExpor> detallepedidoexpors,DetallePedidoExpor detallepedidoexpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetallePedidoExpor detallepedidoexporAux: detallepedidoexpors) {
			if(detallepedidoexporAux!=null && detallepedidoexpor!=null) {
				if((detallepedidoexporAux.getId()==null && detallepedidoexpor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallepedidoexporAux.getId()!=null && detallepedidoexpor.getId()!=null){
					if(detallepedidoexporAux.getId().equals(detallepedidoexpor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetallePedidoExpor(List<DetallePedidoExpor> detallepedidoexpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double descuento_porcentajeTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double ivaTotal=0.0;
		Double totalTotal=0.0;
		Double iceTotal=0.0;
		Double costoTotal=0.0;
		Double utilidadTotal=0.0;
	
		for(DetallePedidoExpor detallepedidoexpor: detallepedidoexpors) {			
			if(detallepedidoexpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=detallepedidoexpor.getprecio();
			descuento_porcentajeTotal+=detallepedidoexpor.getdescuento_porcentaje();
			descuento_valorTotal+=detallepedidoexpor.getdescuento_valor();
			ivaTotal+=detallepedidoexpor.getiva();
			totalTotal+=detallepedidoexpor.gettotal();
			iceTotal+=detallepedidoexpor.getice();
			costoTotal+=detallepedidoexpor.getcosto();
			utilidadTotal+=detallepedidoexpor.getutilidad();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoExporConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoExporConstantesFunciones.DESCUENTOPORCENTAJE);
		datoGeneral.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		datoGeneral.setdValorDouble(descuento_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoExporConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoExporConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoExporConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoExporConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoExporConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoExporConstantesFunciones.UTILIDAD);
		datoGeneral.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_UTILIDAD);
		datoGeneral.setdValorDouble(utilidadTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetallePedidoExpor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_ID, DetallePedidoExporConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_VERSIONROW, DetallePedidoExporConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_IDEMPRESA, DetallePedidoExporConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_IDSUCURSAL, DetallePedidoExporConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_IDEJERCICIO, DetallePedidoExporConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_IDPERIODO, DetallePedidoExporConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_IDANIO, DetallePedidoExporConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_IDMES, DetallePedidoExporConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_IDPEDIDOEXPOR, DetallePedidoExporConstantesFunciones.IDPEDIDOEXPOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_IDBODEGA, DetallePedidoExporConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_IDPRODUCTO, DetallePedidoExporConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_IDUNIDAD, DetallePedidoExporConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_IDESTADODETALLEPEDIDOEXPOR, DetallePedidoExporConstantesFunciones.IDESTADODETALLEPEDIDOEXPOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_CANTIDAD, DetallePedidoExporConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_PRECIO, DetallePedidoExporConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_DESCUENTOPORCENTAJE, DetallePedidoExporConstantesFunciones.DESCUENTOPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_DESCUENTOVALOR, DetallePedidoExporConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_IVA, DetallePedidoExporConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_TOTAL, DetallePedidoExporConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_ICE, DetallePedidoExporConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_COSTO, DetallePedidoExporConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoExporConstantesFunciones.LABEL_UTILIDAD, DetallePedidoExporConstantesFunciones.UTILIDAD,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetallePedidoExpor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.IDPEDIDOEXPOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.IDESTADODETALLEPEDIDOEXPOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.DESCUENTOPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoExporConstantesFunciones.UTILIDAD;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePedidoExpor() throws Exception  {
		return DetallePedidoExporConstantesFunciones.getTiposSeleccionarDetallePedidoExpor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePedidoExpor(Boolean conFk) throws Exception  {
		return DetallePedidoExporConstantesFunciones.getTiposSeleccionarDetallePedidoExpor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePedidoExpor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_IDPEDIDOEXPOR);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_IDPEDIDOEXPOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_IDESTADODETALLEPEDIDOEXPOR);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_IDESTADODETALLEPEDIDOEXPOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoExporConstantesFunciones.LABEL_UTILIDAD);
			reporte.setsDescripcion(DetallePedidoExporConstantesFunciones.LABEL_UTILIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetallePedidoExpor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePedidoExpor(DetallePedidoExpor detallepedidoexporAux) throws Exception {
		
			detallepedidoexporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallepedidoexporAux.getEmpresa()));
			detallepedidoexporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallepedidoexporAux.getSucursal()));
			detallepedidoexporAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallepedidoexporAux.getEjercicio()));
			detallepedidoexporAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallepedidoexporAux.getPeriodo()));
			detallepedidoexporAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallepedidoexporAux.getAnio()));
			detallepedidoexporAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallepedidoexporAux.getMes()));
			detallepedidoexporAux.setpedidoexpor_descripcion(PedidoExporConstantesFunciones.getPedidoExporDescripcion(detallepedidoexporAux.getPedidoExpor()));
			detallepedidoexporAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallepedidoexporAux.getBodega()));
			detallepedidoexporAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallepedidoexporAux.getProducto()));
			detallepedidoexporAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallepedidoexporAux.getUnidad()));
			detallepedidoexporAux.setestadodetallepedidoexpor_descripcion(EstadoDetallePedidoConstantesFunciones.getEstadoDetallePedidoDescripcion(detallepedidoexporAux.getEstadoDetallePedidoExpor()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePedidoExpor(List<DetallePedidoExpor> detallepedidoexporsTemp) throws Exception {
		for(DetallePedidoExpor detallepedidoexporAux:detallepedidoexporsTemp) {
			
			detallepedidoexporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallepedidoexporAux.getEmpresa()));
			detallepedidoexporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallepedidoexporAux.getSucursal()));
			detallepedidoexporAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallepedidoexporAux.getEjercicio()));
			detallepedidoexporAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallepedidoexporAux.getPeriodo()));
			detallepedidoexporAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallepedidoexporAux.getAnio()));
			detallepedidoexporAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallepedidoexporAux.getMes()));
			detallepedidoexporAux.setpedidoexpor_descripcion(PedidoExporConstantesFunciones.getPedidoExporDescripcion(detallepedidoexporAux.getPedidoExpor()));
			detallepedidoexporAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallepedidoexporAux.getBodega()));
			detallepedidoexporAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallepedidoexporAux.getProducto()));
			detallepedidoexporAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallepedidoexporAux.getUnidad()));
			detallepedidoexporAux.setestadodetallepedidoexpor_descripcion(EstadoDetallePedidoConstantesFunciones.getEstadoDetallePedidoDescripcion(detallepedidoexporAux.getEstadoDetallePedidoExpor()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetallePedidoExpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(PedidoExpor.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(EstadoDetallePedido.class));
				
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
					if(clas.clas.equals(PedidoExpor.class)) {
						classes.add(new Classe(PedidoExpor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Unidad.class)) {
						classes.add(new Classe(Unidad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoDetallePedido.class)) {
						classes.add(new Classe(EstadoDetallePedido.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetallePedidoExpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(PedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoExpor.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(EstadoDetallePedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetallePedido.class)); continue;
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

					if(PedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoExpor.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(EstadoDetallePedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetallePedido.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePedidoExpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePedidoExporConstantesFunciones.getClassesRelationshipsOfDetallePedidoExpor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePedidoExpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePedidoExpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePedidoExporConstantesFunciones.getClassesRelationshipsFromStringsOfDetallePedidoExpor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePedidoExpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(DetallePedidoExpor detallepedidoexpor,List<DetallePedidoExpor> detallepedidoexpors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetallePedidoExpor detallepedidoexporEncontrado=null;
			
			for(DetallePedidoExpor detallepedidoexporLocal:detallepedidoexpors) {
				if(detallepedidoexporLocal.getId().equals(detallepedidoexpor.getId())) {
					detallepedidoexporEncontrado=detallepedidoexporLocal;
					
					detallepedidoexporLocal.setIsChanged(detallepedidoexpor.getIsChanged());
					detallepedidoexporLocal.setIsNew(detallepedidoexpor.getIsNew());
					detallepedidoexporLocal.setIsDeleted(detallepedidoexpor.getIsDeleted());
					
					detallepedidoexporLocal.setGeneralEntityOriginal(detallepedidoexpor.getGeneralEntityOriginal());
					
					detallepedidoexporLocal.setId(detallepedidoexpor.getId());	
					detallepedidoexporLocal.setVersionRow(detallepedidoexpor.getVersionRow());	
					detallepedidoexporLocal.setid_empresa(detallepedidoexpor.getid_empresa());	
					detallepedidoexporLocal.setid_sucursal(detallepedidoexpor.getid_sucursal());	
					detallepedidoexporLocal.setid_ejercicio(detallepedidoexpor.getid_ejercicio());	
					detallepedidoexporLocal.setid_periodo(detallepedidoexpor.getid_periodo());	
					detallepedidoexporLocal.setid_anio(detallepedidoexpor.getid_anio());	
					detallepedidoexporLocal.setid_mes(detallepedidoexpor.getid_mes());	
					detallepedidoexporLocal.setid_pedido_expor(detallepedidoexpor.getid_pedido_expor());	
					detallepedidoexporLocal.setid_bodega(detallepedidoexpor.getid_bodega());	
					detallepedidoexporLocal.setid_producto(detallepedidoexpor.getid_producto());	
					detallepedidoexporLocal.setid_unidad(detallepedidoexpor.getid_unidad());	
					detallepedidoexporLocal.setid_estado_detalle_pedido(detallepedidoexpor.getid_estado_detalle_pedido());	
					detallepedidoexporLocal.setcantidad(detallepedidoexpor.getcantidad());	
					detallepedidoexporLocal.setprecio(detallepedidoexpor.getprecio());	
					detallepedidoexporLocal.setdescuento_porcentaje(detallepedidoexpor.getdescuento_porcentaje());	
					detallepedidoexporLocal.setdescuento_valor(detallepedidoexpor.getdescuento_valor());	
					detallepedidoexporLocal.setiva(detallepedidoexpor.getiva());	
					detallepedidoexporLocal.settotal(detallepedidoexpor.gettotal());	
					detallepedidoexporLocal.setice(detallepedidoexpor.getice());	
					detallepedidoexporLocal.setcosto(detallepedidoexpor.getcosto());	
					detallepedidoexporLocal.setutilidad(detallepedidoexpor.getutilidad());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallepedidoexpor.getIsDeleted()) {
				if(!existe) {
					detallepedidoexpors.add(detallepedidoexpor);
				}
			} else {
				if(detallepedidoexporEncontrado!=null && permiteQuitar)  {
					detallepedidoexpors.remove(detallepedidoexporEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetallePedidoExpor detallepedidoexpor,List<DetallePedidoExpor> detallepedidoexpors) throws Exception {
		try	{			
			for(DetallePedidoExpor detallepedidoexporLocal:detallepedidoexpors) {
				if(detallepedidoexporLocal.getId().equals(detallepedidoexpor.getId())) {
					detallepedidoexporLocal.setIsSelected(detallepedidoexpor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetallePedidoExpor(List<DetallePedidoExpor> detallepedidoexporsAux) throws Exception {
		//this.detallepedidoexporsAux=detallepedidoexporsAux;
		
		for(DetallePedidoExpor detallepedidoexporAux:detallepedidoexporsAux) {
			if(detallepedidoexporAux.getIsChanged()) {
				detallepedidoexporAux.setIsChanged(false);
			}		
			
			if(detallepedidoexporAux.getIsNew()) {
				detallepedidoexporAux.setIsNew(false);
			}	
			
			if(detallepedidoexporAux.getIsDeleted()) {
				detallepedidoexporAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetallePedidoExpor(DetallePedidoExpor detallepedidoexporAux) throws Exception {
		//this.detallepedidoexporAux=detallepedidoexporAux;
		
			if(detallepedidoexporAux.getIsChanged()) {
				detallepedidoexporAux.setIsChanged(false);
			}		
			
			if(detallepedidoexporAux.getIsNew()) {
				detallepedidoexporAux.setIsNew(false);
			}	
			
			if(detallepedidoexporAux.getIsDeleted()) {
				detallepedidoexporAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetallePedidoExpor detallepedidoexporAsignar,DetallePedidoExpor detallepedidoexpor) throws Exception {
		detallepedidoexporAsignar.setId(detallepedidoexpor.getId());	
		detallepedidoexporAsignar.setVersionRow(detallepedidoexpor.getVersionRow());	
		detallepedidoexporAsignar.setid_empresa(detallepedidoexpor.getid_empresa());
		detallepedidoexporAsignar.setempresa_descripcion(detallepedidoexpor.getempresa_descripcion());	
		detallepedidoexporAsignar.setid_sucursal(detallepedidoexpor.getid_sucursal());
		detallepedidoexporAsignar.setsucursal_descripcion(detallepedidoexpor.getsucursal_descripcion());	
		detallepedidoexporAsignar.setid_ejercicio(detallepedidoexpor.getid_ejercicio());
		detallepedidoexporAsignar.setejercicio_descripcion(detallepedidoexpor.getejercicio_descripcion());	
		detallepedidoexporAsignar.setid_periodo(detallepedidoexpor.getid_periodo());
		detallepedidoexporAsignar.setperiodo_descripcion(detallepedidoexpor.getperiodo_descripcion());	
		detallepedidoexporAsignar.setid_anio(detallepedidoexpor.getid_anio());
		detallepedidoexporAsignar.setanio_descripcion(detallepedidoexpor.getanio_descripcion());	
		detallepedidoexporAsignar.setid_mes(detallepedidoexpor.getid_mes());
		detallepedidoexporAsignar.setmes_descripcion(detallepedidoexpor.getmes_descripcion());	
		detallepedidoexporAsignar.setid_pedido_expor(detallepedidoexpor.getid_pedido_expor());
		detallepedidoexporAsignar.setpedidoexpor_descripcion(detallepedidoexpor.getpedidoexpor_descripcion());	
		detallepedidoexporAsignar.setid_bodega(detallepedidoexpor.getid_bodega());
		detallepedidoexporAsignar.setbodega_descripcion(detallepedidoexpor.getbodega_descripcion());	
		detallepedidoexporAsignar.setid_producto(detallepedidoexpor.getid_producto());
		detallepedidoexporAsignar.setproducto_descripcion(detallepedidoexpor.getproducto_descripcion());	
		detallepedidoexporAsignar.setid_unidad(detallepedidoexpor.getid_unidad());
		detallepedidoexporAsignar.setunidad_descripcion(detallepedidoexpor.getunidad_descripcion());	
		detallepedidoexporAsignar.setid_estado_detalle_pedido(detallepedidoexpor.getid_estado_detalle_pedido());
		detallepedidoexporAsignar.setestadodetallepedidoexpor_descripcion(detallepedidoexpor.getestadodetallepedidoexpor_descripcion());	
		detallepedidoexporAsignar.setcantidad(detallepedidoexpor.getcantidad());	
		detallepedidoexporAsignar.setprecio(detallepedidoexpor.getprecio());	
		detallepedidoexporAsignar.setdescuento_porcentaje(detallepedidoexpor.getdescuento_porcentaje());	
		detallepedidoexporAsignar.setdescuento_valor(detallepedidoexpor.getdescuento_valor());	
		detallepedidoexporAsignar.setiva(detallepedidoexpor.getiva());	
		detallepedidoexporAsignar.settotal(detallepedidoexpor.gettotal());	
		detallepedidoexporAsignar.setice(detallepedidoexpor.getice());	
		detallepedidoexporAsignar.setcosto(detallepedidoexpor.getcosto());	
		detallepedidoexporAsignar.setutilidad(detallepedidoexpor.getutilidad());	
	}
	
	public static void inicializarDetallePedidoExpor(DetallePedidoExpor detallepedidoexpor) throws Exception {
		try {
				detallepedidoexpor.setId(0L);	
					
				detallepedidoexpor.setid_empresa(-1L);	
				detallepedidoexpor.setid_sucursal(-1L);	
				detallepedidoexpor.setid_ejercicio(-1L);	
				detallepedidoexpor.setid_periodo(-1L);	
				detallepedidoexpor.setid_anio(null);	
				detallepedidoexpor.setid_mes(null);	
				detallepedidoexpor.setid_pedido_expor(-1L);	
				detallepedidoexpor.setid_bodega(-1L);	
				detallepedidoexpor.setid_producto(-1L);	
				detallepedidoexpor.setid_unidad(-1L);	
				detallepedidoexpor.setid_estado_detalle_pedido(-1L);	
				detallepedidoexpor.setcantidad(0);	
				detallepedidoexpor.setprecio(0.0);	
				detallepedidoexpor.setdescuento_porcentaje(0.0);	
				detallepedidoexpor.setdescuento_valor(0.0);	
				detallepedidoexpor.setiva(0.0);	
				detallepedidoexpor.settotal(0.0);	
				detallepedidoexpor.setice(0.0);	
				detallepedidoexpor.setcosto(0.0);	
				detallepedidoexpor.setutilidad(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetallePedidoExpor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_IDPEDIDOEXPOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_IDESTADODETALLEPEDIDOEXPOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoExporConstantesFunciones.LABEL_UTILIDAD);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetallePedidoExpor(String sTipo,Row row,Workbook workbook,DetallePedidoExpor detallepedidoexpor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getpedidoexpor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getestadodetallepedidoexpor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getdescuento_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidoexpor.getutilidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetallePedidoExpor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetallePedidoExpor() {
		return this.sFinalQueryDetallePedidoExpor;
	}
	
	public void setsFinalQueryDetallePedidoExpor(String sFinalQueryDetallePedidoExpor) {
		this.sFinalQueryDetallePedidoExpor= sFinalQueryDetallePedidoExpor;
	}
	
	public Border resaltarSeleccionarDetallePedidoExpor=null;
	
	public Border setResaltarSeleccionarDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetallePedidoExpor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetallePedidoExpor() {
		return this.resaltarSeleccionarDetallePedidoExpor;
	}
	
	public void setResaltarSeleccionarDetallePedidoExpor(Border borderResaltarSeleccionarDetallePedidoExpor) {
		this.resaltarSeleccionarDetallePedidoExpor= borderResaltarSeleccionarDetallePedidoExpor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetallePedidoExpor=null;
	public Boolean mostraridDetallePedidoExpor=true;
	public Boolean activaridDetallePedidoExpor=true;

	public Border resaltarid_empresaDetallePedidoExpor=null;
	public Boolean mostrarid_empresaDetallePedidoExpor=true;
	public Boolean activarid_empresaDetallePedidoExpor=true;
	public Boolean cargarid_empresaDetallePedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetallePedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetallePedidoExpor=null;
	public Boolean mostrarid_sucursalDetallePedidoExpor=true;
	public Boolean activarid_sucursalDetallePedidoExpor=true;
	public Boolean cargarid_sucursalDetallePedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetallePedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetallePedidoExpor=null;
	public Boolean mostrarid_ejercicioDetallePedidoExpor=true;
	public Boolean activarid_ejercicioDetallePedidoExpor=true;
	public Boolean cargarid_ejercicioDetallePedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetallePedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_periodoDetallePedidoExpor=null;
	public Boolean mostrarid_periodoDetallePedidoExpor=true;
	public Boolean activarid_periodoDetallePedidoExpor=true;
	public Boolean cargarid_periodoDetallePedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetallePedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_anioDetallePedidoExpor=null;
	public Boolean mostrarid_anioDetallePedidoExpor=true;
	public Boolean activarid_anioDetallePedidoExpor=false;
	public Boolean cargarid_anioDetallePedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetallePedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_mesDetallePedidoExpor=null;
	public Boolean mostrarid_mesDetallePedidoExpor=true;
	public Boolean activarid_mesDetallePedidoExpor=false;
	public Boolean cargarid_mesDetallePedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetallePedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_pedido_exporDetallePedidoExpor=null;
	public Boolean mostrarid_pedido_exporDetallePedidoExpor=true;
	public Boolean activarid_pedido_exporDetallePedidoExpor=true;
	public Boolean cargarid_pedido_exporDetallePedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_pedido_exporDetallePedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetallePedidoExpor=null;
	public Boolean mostrarid_bodegaDetallePedidoExpor=true;
	public Boolean activarid_bodegaDetallePedidoExpor=true;
	public Boolean cargarid_bodegaDetallePedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetallePedidoExpor=false;//ConEventDepend=true

	public Border resaltarid_productoDetallePedidoExpor=null;
	public Boolean mostrarid_productoDetallePedidoExpor=true;
	public Boolean activarid_productoDetallePedidoExpor=true;
	public Boolean cargarid_productoDetallePedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetallePedidoExpor=true;//ConEventDepend=true

	public Border resaltarid_unidadDetallePedidoExpor=null;
	public Boolean mostrarid_unidadDetallePedidoExpor=true;
	public Boolean activarid_unidadDetallePedidoExpor=true;
	public Boolean cargarid_unidadDetallePedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetallePedidoExpor=true;//ConEventDepend=true

	public Border resaltarid_estado_detalle_pedidoDetallePedidoExpor=null;
	public Boolean mostrarid_estado_detalle_pedidoDetallePedidoExpor=true;
	public Boolean activarid_estado_detalle_pedidoDetallePedidoExpor=true;
	public Boolean cargarid_estado_detalle_pedidoDetallePedidoExpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_detalle_pedidoDetallePedidoExpor=false;//ConEventDepend=true

	public Border resaltarcantidadDetallePedidoExpor=null;
	public Boolean mostrarcantidadDetallePedidoExpor=true;
	public Boolean activarcantidadDetallePedidoExpor=true;

	public Border resaltarprecioDetallePedidoExpor=null;
	public Boolean mostrarprecioDetallePedidoExpor=true;
	public Boolean activarprecioDetallePedidoExpor=true;

	public Border resaltardescuento_porcentajeDetallePedidoExpor=null;
	public Boolean mostrardescuento_porcentajeDetallePedidoExpor=true;
	public Boolean activardescuento_porcentajeDetallePedidoExpor=true;

	public Border resaltardescuento_valorDetallePedidoExpor=null;
	public Boolean mostrardescuento_valorDetallePedidoExpor=true;
	public Boolean activardescuento_valorDetallePedidoExpor=true;

	public Border resaltarivaDetallePedidoExpor=null;
	public Boolean mostrarivaDetallePedidoExpor=true;
	public Boolean activarivaDetallePedidoExpor=true;

	public Border resaltartotalDetallePedidoExpor=null;
	public Boolean mostrartotalDetallePedidoExpor=true;
	public Boolean activartotalDetallePedidoExpor=true;

	public Border resaltariceDetallePedidoExpor=null;
	public Boolean mostrariceDetallePedidoExpor=true;
	public Boolean activariceDetallePedidoExpor=false;

	public Border resaltarcostoDetallePedidoExpor=null;
	public Boolean mostrarcostoDetallePedidoExpor=true;
	public Boolean activarcostoDetallePedidoExpor=false;

	public Border resaltarutilidadDetallePedidoExpor=null;
	public Boolean mostrarutilidadDetallePedidoExpor=true;
	public Boolean activarutilidadDetallePedidoExpor=false;

	
	

	public Border setResaltaridDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltaridDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetallePedidoExpor() {
		return this.resaltaridDetallePedidoExpor;
	}

	public void setResaltaridDetallePedidoExpor(Border borderResaltar) {
		this.resaltaridDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostraridDetallePedidoExpor() {
		return this.mostraridDetallePedidoExpor;
	}

	public void setMostraridDetallePedidoExpor(Boolean mostraridDetallePedidoExpor) {
		this.mostraridDetallePedidoExpor= mostraridDetallePedidoExpor;
	}

	public Boolean getActivaridDetallePedidoExpor() {
		return this.activaridDetallePedidoExpor;
	}

	public void setActivaridDetallePedidoExpor(Boolean activaridDetallePedidoExpor) {
		this.activaridDetallePedidoExpor= activaridDetallePedidoExpor;
	}

	public Border setResaltarid_empresaDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetallePedidoExpor() {
		return this.resaltarid_empresaDetallePedidoExpor;
	}

	public void setResaltarid_empresaDetallePedidoExpor(Border borderResaltar) {
		this.resaltarid_empresaDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetallePedidoExpor() {
		return this.mostrarid_empresaDetallePedidoExpor;
	}

	public void setMostrarid_empresaDetallePedidoExpor(Boolean mostrarid_empresaDetallePedidoExpor) {
		this.mostrarid_empresaDetallePedidoExpor= mostrarid_empresaDetallePedidoExpor;
	}

	public Boolean getActivarid_empresaDetallePedidoExpor() {
		return this.activarid_empresaDetallePedidoExpor;
	}

	public void setActivarid_empresaDetallePedidoExpor(Boolean activarid_empresaDetallePedidoExpor) {
		this.activarid_empresaDetallePedidoExpor= activarid_empresaDetallePedidoExpor;
	}

	public Boolean getCargarid_empresaDetallePedidoExpor() {
		return this.cargarid_empresaDetallePedidoExpor;
	}

	public void setCargarid_empresaDetallePedidoExpor(Boolean cargarid_empresaDetallePedidoExpor) {
		this.cargarid_empresaDetallePedidoExpor= cargarid_empresaDetallePedidoExpor;
	}

	public Border setResaltarid_sucursalDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetallePedidoExpor() {
		return this.resaltarid_sucursalDetallePedidoExpor;
	}

	public void setResaltarid_sucursalDetallePedidoExpor(Border borderResaltar) {
		this.resaltarid_sucursalDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetallePedidoExpor() {
		return this.mostrarid_sucursalDetallePedidoExpor;
	}

	public void setMostrarid_sucursalDetallePedidoExpor(Boolean mostrarid_sucursalDetallePedidoExpor) {
		this.mostrarid_sucursalDetallePedidoExpor= mostrarid_sucursalDetallePedidoExpor;
	}

	public Boolean getActivarid_sucursalDetallePedidoExpor() {
		return this.activarid_sucursalDetallePedidoExpor;
	}

	public void setActivarid_sucursalDetallePedidoExpor(Boolean activarid_sucursalDetallePedidoExpor) {
		this.activarid_sucursalDetallePedidoExpor= activarid_sucursalDetallePedidoExpor;
	}

	public Boolean getCargarid_sucursalDetallePedidoExpor() {
		return this.cargarid_sucursalDetallePedidoExpor;
	}

	public void setCargarid_sucursalDetallePedidoExpor(Boolean cargarid_sucursalDetallePedidoExpor) {
		this.cargarid_sucursalDetallePedidoExpor= cargarid_sucursalDetallePedidoExpor;
	}

	public Border setResaltarid_ejercicioDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetallePedidoExpor() {
		return this.resaltarid_ejercicioDetallePedidoExpor;
	}

	public void setResaltarid_ejercicioDetallePedidoExpor(Border borderResaltar) {
		this.resaltarid_ejercicioDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetallePedidoExpor() {
		return this.mostrarid_ejercicioDetallePedidoExpor;
	}

	public void setMostrarid_ejercicioDetallePedidoExpor(Boolean mostrarid_ejercicioDetallePedidoExpor) {
		this.mostrarid_ejercicioDetallePedidoExpor= mostrarid_ejercicioDetallePedidoExpor;
	}

	public Boolean getActivarid_ejercicioDetallePedidoExpor() {
		return this.activarid_ejercicioDetallePedidoExpor;
	}

	public void setActivarid_ejercicioDetallePedidoExpor(Boolean activarid_ejercicioDetallePedidoExpor) {
		this.activarid_ejercicioDetallePedidoExpor= activarid_ejercicioDetallePedidoExpor;
	}

	public Boolean getCargarid_ejercicioDetallePedidoExpor() {
		return this.cargarid_ejercicioDetallePedidoExpor;
	}

	public void setCargarid_ejercicioDetallePedidoExpor(Boolean cargarid_ejercicioDetallePedidoExpor) {
		this.cargarid_ejercicioDetallePedidoExpor= cargarid_ejercicioDetallePedidoExpor;
	}

	public Border setResaltarid_periodoDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetallePedidoExpor() {
		return this.resaltarid_periodoDetallePedidoExpor;
	}

	public void setResaltarid_periodoDetallePedidoExpor(Border borderResaltar) {
		this.resaltarid_periodoDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetallePedidoExpor() {
		return this.mostrarid_periodoDetallePedidoExpor;
	}

	public void setMostrarid_periodoDetallePedidoExpor(Boolean mostrarid_periodoDetallePedidoExpor) {
		this.mostrarid_periodoDetallePedidoExpor= mostrarid_periodoDetallePedidoExpor;
	}

	public Boolean getActivarid_periodoDetallePedidoExpor() {
		return this.activarid_periodoDetallePedidoExpor;
	}

	public void setActivarid_periodoDetallePedidoExpor(Boolean activarid_periodoDetallePedidoExpor) {
		this.activarid_periodoDetallePedidoExpor= activarid_periodoDetallePedidoExpor;
	}

	public Boolean getCargarid_periodoDetallePedidoExpor() {
		return this.cargarid_periodoDetallePedidoExpor;
	}

	public void setCargarid_periodoDetallePedidoExpor(Boolean cargarid_periodoDetallePedidoExpor) {
		this.cargarid_periodoDetallePedidoExpor= cargarid_periodoDetallePedidoExpor;
	}

	public Border setResaltarid_anioDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_anioDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetallePedidoExpor() {
		return this.resaltarid_anioDetallePedidoExpor;
	}

	public void setResaltarid_anioDetallePedidoExpor(Border borderResaltar) {
		this.resaltarid_anioDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_anioDetallePedidoExpor() {
		return this.mostrarid_anioDetallePedidoExpor;
	}

	public void setMostrarid_anioDetallePedidoExpor(Boolean mostrarid_anioDetallePedidoExpor) {
		this.mostrarid_anioDetallePedidoExpor= mostrarid_anioDetallePedidoExpor;
	}

	public Boolean getActivarid_anioDetallePedidoExpor() {
		return this.activarid_anioDetallePedidoExpor;
	}

	public void setActivarid_anioDetallePedidoExpor(Boolean activarid_anioDetallePedidoExpor) {
		this.activarid_anioDetallePedidoExpor= activarid_anioDetallePedidoExpor;
	}

	public Boolean getCargarid_anioDetallePedidoExpor() {
		return this.cargarid_anioDetallePedidoExpor;
	}

	public void setCargarid_anioDetallePedidoExpor(Boolean cargarid_anioDetallePedidoExpor) {
		this.cargarid_anioDetallePedidoExpor= cargarid_anioDetallePedidoExpor;
	}

	public Border setResaltarid_mesDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_mesDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetallePedidoExpor() {
		return this.resaltarid_mesDetallePedidoExpor;
	}

	public void setResaltarid_mesDetallePedidoExpor(Border borderResaltar) {
		this.resaltarid_mesDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_mesDetallePedidoExpor() {
		return this.mostrarid_mesDetallePedidoExpor;
	}

	public void setMostrarid_mesDetallePedidoExpor(Boolean mostrarid_mesDetallePedidoExpor) {
		this.mostrarid_mesDetallePedidoExpor= mostrarid_mesDetallePedidoExpor;
	}

	public Boolean getActivarid_mesDetallePedidoExpor() {
		return this.activarid_mesDetallePedidoExpor;
	}

	public void setActivarid_mesDetallePedidoExpor(Boolean activarid_mesDetallePedidoExpor) {
		this.activarid_mesDetallePedidoExpor= activarid_mesDetallePedidoExpor;
	}

	public Boolean getCargarid_mesDetallePedidoExpor() {
		return this.cargarid_mesDetallePedidoExpor;
	}

	public void setCargarid_mesDetallePedidoExpor(Boolean cargarid_mesDetallePedidoExpor) {
		this.cargarid_mesDetallePedidoExpor= cargarid_mesDetallePedidoExpor;
	}

	public Border setResaltarid_pedido_exporDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_pedido_exporDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_pedido_exporDetallePedidoExpor() {
		return this.resaltarid_pedido_exporDetallePedidoExpor;
	}

	public void setResaltarid_pedido_exporDetallePedidoExpor(Border borderResaltar) {
		this.resaltarid_pedido_exporDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_pedido_exporDetallePedidoExpor() {
		return this.mostrarid_pedido_exporDetallePedidoExpor;
	}

	public void setMostrarid_pedido_exporDetallePedidoExpor(Boolean mostrarid_pedido_exporDetallePedidoExpor) {
		this.mostrarid_pedido_exporDetallePedidoExpor= mostrarid_pedido_exporDetallePedidoExpor;
	}

	public Boolean getActivarid_pedido_exporDetallePedidoExpor() {
		return this.activarid_pedido_exporDetallePedidoExpor;
	}

	public void setActivarid_pedido_exporDetallePedidoExpor(Boolean activarid_pedido_exporDetallePedidoExpor) {
		this.activarid_pedido_exporDetallePedidoExpor= activarid_pedido_exporDetallePedidoExpor;
	}

	public Boolean getCargarid_pedido_exporDetallePedidoExpor() {
		return this.cargarid_pedido_exporDetallePedidoExpor;
	}

	public void setCargarid_pedido_exporDetallePedidoExpor(Boolean cargarid_pedido_exporDetallePedidoExpor) {
		this.cargarid_pedido_exporDetallePedidoExpor= cargarid_pedido_exporDetallePedidoExpor;
	}

	public Border setResaltarid_bodegaDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetallePedidoExpor() {
		return this.resaltarid_bodegaDetallePedidoExpor;
	}

	public void setResaltarid_bodegaDetallePedidoExpor(Border borderResaltar) {
		this.resaltarid_bodegaDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetallePedidoExpor() {
		return this.mostrarid_bodegaDetallePedidoExpor;
	}

	public void setMostrarid_bodegaDetallePedidoExpor(Boolean mostrarid_bodegaDetallePedidoExpor) {
		this.mostrarid_bodegaDetallePedidoExpor= mostrarid_bodegaDetallePedidoExpor;
	}

	public Boolean getActivarid_bodegaDetallePedidoExpor() {
		return this.activarid_bodegaDetallePedidoExpor;
	}

	public void setActivarid_bodegaDetallePedidoExpor(Boolean activarid_bodegaDetallePedidoExpor) {
		this.activarid_bodegaDetallePedidoExpor= activarid_bodegaDetallePedidoExpor;
	}

	public Boolean getCargarid_bodegaDetallePedidoExpor() {
		return this.cargarid_bodegaDetallePedidoExpor;
	}

	public void setCargarid_bodegaDetallePedidoExpor(Boolean cargarid_bodegaDetallePedidoExpor) {
		this.cargarid_bodegaDetallePedidoExpor= cargarid_bodegaDetallePedidoExpor;
	}

	public Border setResaltarid_productoDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_productoDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetallePedidoExpor() {
		return this.resaltarid_productoDetallePedidoExpor;
	}

	public void setResaltarid_productoDetallePedidoExpor(Border borderResaltar) {
		this.resaltarid_productoDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_productoDetallePedidoExpor() {
		return this.mostrarid_productoDetallePedidoExpor;
	}

	public void setMostrarid_productoDetallePedidoExpor(Boolean mostrarid_productoDetallePedidoExpor) {
		this.mostrarid_productoDetallePedidoExpor= mostrarid_productoDetallePedidoExpor;
	}

	public Boolean getActivarid_productoDetallePedidoExpor() {
		return this.activarid_productoDetallePedidoExpor;
	}

	public void setActivarid_productoDetallePedidoExpor(Boolean activarid_productoDetallePedidoExpor) {
		this.activarid_productoDetallePedidoExpor= activarid_productoDetallePedidoExpor;
	}

	public Boolean getCargarid_productoDetallePedidoExpor() {
		return this.cargarid_productoDetallePedidoExpor;
	}

	public void setCargarid_productoDetallePedidoExpor(Boolean cargarid_productoDetallePedidoExpor) {
		this.cargarid_productoDetallePedidoExpor= cargarid_productoDetallePedidoExpor;
	}

	public Border setResaltarid_unidadDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetallePedidoExpor() {
		return this.resaltarid_unidadDetallePedidoExpor;
	}

	public void setResaltarid_unidadDetallePedidoExpor(Border borderResaltar) {
		this.resaltarid_unidadDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetallePedidoExpor() {
		return this.mostrarid_unidadDetallePedidoExpor;
	}

	public void setMostrarid_unidadDetallePedidoExpor(Boolean mostrarid_unidadDetallePedidoExpor) {
		this.mostrarid_unidadDetallePedidoExpor= mostrarid_unidadDetallePedidoExpor;
	}

	public Boolean getActivarid_unidadDetallePedidoExpor() {
		return this.activarid_unidadDetallePedidoExpor;
	}

	public void setActivarid_unidadDetallePedidoExpor(Boolean activarid_unidadDetallePedidoExpor) {
		this.activarid_unidadDetallePedidoExpor= activarid_unidadDetallePedidoExpor;
	}

	public Boolean getCargarid_unidadDetallePedidoExpor() {
		return this.cargarid_unidadDetallePedidoExpor;
	}

	public void setCargarid_unidadDetallePedidoExpor(Boolean cargarid_unidadDetallePedidoExpor) {
		this.cargarid_unidadDetallePedidoExpor= cargarid_unidadDetallePedidoExpor;
	}

	public Border setResaltarid_estado_detalle_pedidoDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltarid_estado_detalle_pedidoDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_detalle_pedidoDetallePedidoExpor() {
		return this.resaltarid_estado_detalle_pedidoDetallePedidoExpor;
	}

	public void setResaltarid_estado_detalle_pedidoDetallePedidoExpor(Border borderResaltar) {
		this.resaltarid_estado_detalle_pedidoDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarid_estado_detalle_pedidoDetallePedidoExpor() {
		return this.mostrarid_estado_detalle_pedidoDetallePedidoExpor;
	}

	public void setMostrarid_estado_detalle_pedidoDetallePedidoExpor(Boolean mostrarid_estado_detalle_pedidoDetallePedidoExpor) {
		this.mostrarid_estado_detalle_pedidoDetallePedidoExpor= mostrarid_estado_detalle_pedidoDetallePedidoExpor;
	}

	public Boolean getActivarid_estado_detalle_pedidoDetallePedidoExpor() {
		return this.activarid_estado_detalle_pedidoDetallePedidoExpor;
	}

	public void setActivarid_estado_detalle_pedidoDetallePedidoExpor(Boolean activarid_estado_detalle_pedidoDetallePedidoExpor) {
		this.activarid_estado_detalle_pedidoDetallePedidoExpor= activarid_estado_detalle_pedidoDetallePedidoExpor;
	}

	public Boolean getCargarid_estado_detalle_pedidoDetallePedidoExpor() {
		return this.cargarid_estado_detalle_pedidoDetallePedidoExpor;
	}

	public void setCargarid_estado_detalle_pedidoDetallePedidoExpor(Boolean cargarid_estado_detalle_pedidoDetallePedidoExpor) {
		this.cargarid_estado_detalle_pedidoDetallePedidoExpor= cargarid_estado_detalle_pedidoDetallePedidoExpor;
	}

	public Border setResaltarcantidadDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltarcantidadDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetallePedidoExpor() {
		return this.resaltarcantidadDetallePedidoExpor;
	}

	public void setResaltarcantidadDetallePedidoExpor(Border borderResaltar) {
		this.resaltarcantidadDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarcantidadDetallePedidoExpor() {
		return this.mostrarcantidadDetallePedidoExpor;
	}

	public void setMostrarcantidadDetallePedidoExpor(Boolean mostrarcantidadDetallePedidoExpor) {
		this.mostrarcantidadDetallePedidoExpor= mostrarcantidadDetallePedidoExpor;
	}

	public Boolean getActivarcantidadDetallePedidoExpor() {
		return this.activarcantidadDetallePedidoExpor;
	}

	public void setActivarcantidadDetallePedidoExpor(Boolean activarcantidadDetallePedidoExpor) {
		this.activarcantidadDetallePedidoExpor= activarcantidadDetallePedidoExpor;
	}

	public Border setResaltarprecioDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltarprecioDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioDetallePedidoExpor() {
		return this.resaltarprecioDetallePedidoExpor;
	}

	public void setResaltarprecioDetallePedidoExpor(Border borderResaltar) {
		this.resaltarprecioDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarprecioDetallePedidoExpor() {
		return this.mostrarprecioDetallePedidoExpor;
	}

	public void setMostrarprecioDetallePedidoExpor(Boolean mostrarprecioDetallePedidoExpor) {
		this.mostrarprecioDetallePedidoExpor= mostrarprecioDetallePedidoExpor;
	}

	public Boolean getActivarprecioDetallePedidoExpor() {
		return this.activarprecioDetallePedidoExpor;
	}

	public void setActivarprecioDetallePedidoExpor(Boolean activarprecioDetallePedidoExpor) {
		this.activarprecioDetallePedidoExpor= activarprecioDetallePedidoExpor;
	}

	public Border setResaltardescuento_porcentajeDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltardescuento_porcentajeDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_porcentajeDetallePedidoExpor() {
		return this.resaltardescuento_porcentajeDetallePedidoExpor;
	}

	public void setResaltardescuento_porcentajeDetallePedidoExpor(Border borderResaltar) {
		this.resaltardescuento_porcentajeDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrardescuento_porcentajeDetallePedidoExpor() {
		return this.mostrardescuento_porcentajeDetallePedidoExpor;
	}

	public void setMostrardescuento_porcentajeDetallePedidoExpor(Boolean mostrardescuento_porcentajeDetallePedidoExpor) {
		this.mostrardescuento_porcentajeDetallePedidoExpor= mostrardescuento_porcentajeDetallePedidoExpor;
	}

	public Boolean getActivardescuento_porcentajeDetallePedidoExpor() {
		return this.activardescuento_porcentajeDetallePedidoExpor;
	}

	public void setActivardescuento_porcentajeDetallePedidoExpor(Boolean activardescuento_porcentajeDetallePedidoExpor) {
		this.activardescuento_porcentajeDetallePedidoExpor= activardescuento_porcentajeDetallePedidoExpor;
	}

	public Border setResaltardescuento_valorDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltardescuento_valorDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorDetallePedidoExpor() {
		return this.resaltardescuento_valorDetallePedidoExpor;
	}

	public void setResaltardescuento_valorDetallePedidoExpor(Border borderResaltar) {
		this.resaltardescuento_valorDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrardescuento_valorDetallePedidoExpor() {
		return this.mostrardescuento_valorDetallePedidoExpor;
	}

	public void setMostrardescuento_valorDetallePedidoExpor(Boolean mostrardescuento_valorDetallePedidoExpor) {
		this.mostrardescuento_valorDetallePedidoExpor= mostrardescuento_valorDetallePedidoExpor;
	}

	public Boolean getActivardescuento_valorDetallePedidoExpor() {
		return this.activardescuento_valorDetallePedidoExpor;
	}

	public void setActivardescuento_valorDetallePedidoExpor(Boolean activardescuento_valorDetallePedidoExpor) {
		this.activardescuento_valorDetallePedidoExpor= activardescuento_valorDetallePedidoExpor;
	}

	public Border setResaltarivaDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltarivaDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaDetallePedidoExpor() {
		return this.resaltarivaDetallePedidoExpor;
	}

	public void setResaltarivaDetallePedidoExpor(Border borderResaltar) {
		this.resaltarivaDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarivaDetallePedidoExpor() {
		return this.mostrarivaDetallePedidoExpor;
	}

	public void setMostrarivaDetallePedidoExpor(Boolean mostrarivaDetallePedidoExpor) {
		this.mostrarivaDetallePedidoExpor= mostrarivaDetallePedidoExpor;
	}

	public Boolean getActivarivaDetallePedidoExpor() {
		return this.activarivaDetallePedidoExpor;
	}

	public void setActivarivaDetallePedidoExpor(Boolean activarivaDetallePedidoExpor) {
		this.activarivaDetallePedidoExpor= activarivaDetallePedidoExpor;
	}

	public Border setResaltartotalDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltartotalDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalDetallePedidoExpor() {
		return this.resaltartotalDetallePedidoExpor;
	}

	public void setResaltartotalDetallePedidoExpor(Border borderResaltar) {
		this.resaltartotalDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrartotalDetallePedidoExpor() {
		return this.mostrartotalDetallePedidoExpor;
	}

	public void setMostrartotalDetallePedidoExpor(Boolean mostrartotalDetallePedidoExpor) {
		this.mostrartotalDetallePedidoExpor= mostrartotalDetallePedidoExpor;
	}

	public Boolean getActivartotalDetallePedidoExpor() {
		return this.activartotalDetallePedidoExpor;
	}

	public void setActivartotalDetallePedidoExpor(Boolean activartotalDetallePedidoExpor) {
		this.activartotalDetallePedidoExpor= activartotalDetallePedidoExpor;
	}

	public Border setResaltariceDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltariceDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceDetallePedidoExpor() {
		return this.resaltariceDetallePedidoExpor;
	}

	public void setResaltariceDetallePedidoExpor(Border borderResaltar) {
		this.resaltariceDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrariceDetallePedidoExpor() {
		return this.mostrariceDetallePedidoExpor;
	}

	public void setMostrariceDetallePedidoExpor(Boolean mostrariceDetallePedidoExpor) {
		this.mostrariceDetallePedidoExpor= mostrariceDetallePedidoExpor;
	}

	public Boolean getActivariceDetallePedidoExpor() {
		return this.activariceDetallePedidoExpor;
	}

	public void setActivariceDetallePedidoExpor(Boolean activariceDetallePedidoExpor) {
		this.activariceDetallePedidoExpor= activariceDetallePedidoExpor;
	}

	public Border setResaltarcostoDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltarcostoDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoDetallePedidoExpor() {
		return this.resaltarcostoDetallePedidoExpor;
	}

	public void setResaltarcostoDetallePedidoExpor(Border borderResaltar) {
		this.resaltarcostoDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarcostoDetallePedidoExpor() {
		return this.mostrarcostoDetallePedidoExpor;
	}

	public void setMostrarcostoDetallePedidoExpor(Boolean mostrarcostoDetallePedidoExpor) {
		this.mostrarcostoDetallePedidoExpor= mostrarcostoDetallePedidoExpor;
	}

	public Boolean getActivarcostoDetallePedidoExpor() {
		return this.activarcostoDetallePedidoExpor;
	}

	public void setActivarcostoDetallePedidoExpor(Boolean activarcostoDetallePedidoExpor) {
		this.activarcostoDetallePedidoExpor= activarcostoDetallePedidoExpor;
	}

	public Border setResaltarutilidadDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidoexporBeanSwingJInternalFrame.jTtoolBarDetallePedidoExpor.setBorder(borderResaltar);
		
		this.resaltarutilidadDetallePedidoExpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarutilidadDetallePedidoExpor() {
		return this.resaltarutilidadDetallePedidoExpor;
	}

	public void setResaltarutilidadDetallePedidoExpor(Border borderResaltar) {
		this.resaltarutilidadDetallePedidoExpor= borderResaltar;
	}

	public Boolean getMostrarutilidadDetallePedidoExpor() {
		return this.mostrarutilidadDetallePedidoExpor;
	}

	public void setMostrarutilidadDetallePedidoExpor(Boolean mostrarutilidadDetallePedidoExpor) {
		this.mostrarutilidadDetallePedidoExpor= mostrarutilidadDetallePedidoExpor;
	}

	public Boolean getActivarutilidadDetallePedidoExpor() {
		return this.activarutilidadDetallePedidoExpor;
	}

	public void setActivarutilidadDetallePedidoExpor(Boolean activarutilidadDetallePedidoExpor) {
		this.activarutilidadDetallePedidoExpor= activarutilidadDetallePedidoExpor;
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
		
		
		this.setMostraridDetallePedidoExpor(esInicial);
		this.setMostrarid_empresaDetallePedidoExpor(esInicial);
		this.setMostrarid_sucursalDetallePedidoExpor(esInicial);
		this.setMostrarid_ejercicioDetallePedidoExpor(esInicial);
		this.setMostrarid_periodoDetallePedidoExpor(esInicial);
		this.setMostrarid_anioDetallePedidoExpor(esInicial);
		this.setMostrarid_mesDetallePedidoExpor(esInicial);
		this.setMostrarid_pedido_exporDetallePedidoExpor(esInicial);
		this.setMostrarid_bodegaDetallePedidoExpor(esInicial);
		this.setMostrarid_productoDetallePedidoExpor(esInicial);
		this.setMostrarid_unidadDetallePedidoExpor(esInicial);
		this.setMostrarid_estado_detalle_pedidoDetallePedidoExpor(esInicial);
		this.setMostrarcantidadDetallePedidoExpor(esInicial);
		this.setMostrarprecioDetallePedidoExpor(esInicial);
		this.setMostrardescuento_porcentajeDetallePedidoExpor(esInicial);
		this.setMostrardescuento_valorDetallePedidoExpor(esInicial);
		this.setMostrarivaDetallePedidoExpor(esInicial);
		this.setMostrartotalDetallePedidoExpor(esInicial);
		this.setMostrariceDetallePedidoExpor(esInicial);
		this.setMostrarcostoDetallePedidoExpor(esInicial);
		this.setMostrarutilidadDetallePedidoExpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.ID)) {
				this.setMostraridDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDPEDIDOEXPOR)) {
				this.setMostrarid_pedido_exporDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDESTADODETALLEPEDIDOEXPOR)) {
				this.setMostrarid_estado_detalle_pedidoDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.PRECIO)) {
				this.setMostrarprecioDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setMostrardescuento_porcentajeDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IVA)) {
				this.setMostrarivaDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.TOTAL)) {
				this.setMostrartotalDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.ICE)) {
				this.setMostrariceDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.COSTO)) {
				this.setMostrarcostoDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.UTILIDAD)) {
				this.setMostrarutilidadDetallePedidoExpor(esAsigna);
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
		
		
		this.setActivaridDetallePedidoExpor(esInicial);
		this.setActivarid_empresaDetallePedidoExpor(esInicial);
		this.setActivarid_sucursalDetallePedidoExpor(esInicial);
		this.setActivarid_ejercicioDetallePedidoExpor(esInicial);
		this.setActivarid_periodoDetallePedidoExpor(esInicial);
		this.setActivarid_anioDetallePedidoExpor(esInicial);
		this.setActivarid_mesDetallePedidoExpor(esInicial);
		this.setActivarid_pedido_exporDetallePedidoExpor(esInicial);
		this.setActivarid_bodegaDetallePedidoExpor(esInicial);
		this.setActivarid_productoDetallePedidoExpor(esInicial);
		this.setActivarid_unidadDetallePedidoExpor(esInicial);
		this.setActivarid_estado_detalle_pedidoDetallePedidoExpor(esInicial);
		this.setActivarcantidadDetallePedidoExpor(esInicial);
		this.setActivarprecioDetallePedidoExpor(esInicial);
		this.setActivardescuento_porcentajeDetallePedidoExpor(esInicial);
		this.setActivardescuento_valorDetallePedidoExpor(esInicial);
		this.setActivarivaDetallePedidoExpor(esInicial);
		this.setActivartotalDetallePedidoExpor(esInicial);
		this.setActivariceDetallePedidoExpor(esInicial);
		this.setActivarcostoDetallePedidoExpor(esInicial);
		this.setActivarutilidadDetallePedidoExpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.ID)) {
				this.setActivaridDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDPEDIDOEXPOR)) {
				this.setActivarid_pedido_exporDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDESTADODETALLEPEDIDOEXPOR)) {
				this.setActivarid_estado_detalle_pedidoDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.PRECIO)) {
				this.setActivarprecioDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setActivardescuento_porcentajeDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IVA)) {
				this.setActivarivaDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.TOTAL)) {
				this.setActivartotalDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.ICE)) {
				this.setActivariceDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.COSTO)) {
				this.setActivarcostoDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.UTILIDAD)) {
				this.setActivarutilidadDetallePedidoExpor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetallePedidoExpor(esInicial);
		this.setResaltarid_empresaDetallePedidoExpor(esInicial);
		this.setResaltarid_sucursalDetallePedidoExpor(esInicial);
		this.setResaltarid_ejercicioDetallePedidoExpor(esInicial);
		this.setResaltarid_periodoDetallePedidoExpor(esInicial);
		this.setResaltarid_anioDetallePedidoExpor(esInicial);
		this.setResaltarid_mesDetallePedidoExpor(esInicial);
		this.setResaltarid_pedido_exporDetallePedidoExpor(esInicial);
		this.setResaltarid_bodegaDetallePedidoExpor(esInicial);
		this.setResaltarid_productoDetallePedidoExpor(esInicial);
		this.setResaltarid_unidadDetallePedidoExpor(esInicial);
		this.setResaltarid_estado_detalle_pedidoDetallePedidoExpor(esInicial);
		this.setResaltarcantidadDetallePedidoExpor(esInicial);
		this.setResaltarprecioDetallePedidoExpor(esInicial);
		this.setResaltardescuento_porcentajeDetallePedidoExpor(esInicial);
		this.setResaltardescuento_valorDetallePedidoExpor(esInicial);
		this.setResaltarivaDetallePedidoExpor(esInicial);
		this.setResaltartotalDetallePedidoExpor(esInicial);
		this.setResaltariceDetallePedidoExpor(esInicial);
		this.setResaltarcostoDetallePedidoExpor(esInicial);
		this.setResaltarutilidadDetallePedidoExpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.ID)) {
				this.setResaltaridDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDPEDIDOEXPOR)) {
				this.setResaltarid_pedido_exporDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IDESTADODETALLEPEDIDOEXPOR)) {
				this.setResaltarid_estado_detalle_pedidoDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.PRECIO)) {
				this.setResaltarprecioDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setResaltardescuento_porcentajeDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.IVA)) {
				this.setResaltarivaDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.TOTAL)) {
				this.setResaltartotalDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.ICE)) {
				this.setResaltariceDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.COSTO)) {
				this.setResaltarcostoDetallePedidoExpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoExporConstantesFunciones.UTILIDAD)) {
				this.setResaltarutilidadDetallePedidoExpor(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarFK_IdBodegaDetallePedidoExpor=true;

	public Boolean getMostrarFK_IdBodegaDetallePedidoExpor() {
		return this.mostrarFK_IdBodegaDetallePedidoExpor;
	}

	public void setMostrarFK_IdBodegaDetallePedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetallePedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetallePedidoExpor=true;

	public Boolean getMostrarFK_IdEjercicioDetallePedidoExpor() {
		return this.mostrarFK_IdEjercicioDetallePedidoExpor;
	}

	public void setMostrarFK_IdEjercicioDetallePedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetallePedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetallePedidoExpor=true;

	public Boolean getMostrarFK_IdEmpresaDetallePedidoExpor() {
		return this.mostrarFK_IdEmpresaDetallePedidoExpor;
	}

	public void setMostrarFK_IdEmpresaDetallePedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetallePedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoDetallePedidoExporDetallePedidoExpor=true;

	public Boolean getMostrarFK_IdEstadoDetallePedidoExporDetallePedidoExpor() {
		return this.mostrarFK_IdEstadoDetallePedidoExporDetallePedidoExpor;
	}

	public void setMostrarFK_IdEstadoDetallePedidoExporDetallePedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoDetallePedidoExporDetallePedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPedidoExporDetallePedidoExpor=true;

	public Boolean getMostrarFK_IdPedidoExporDetallePedidoExpor() {
		return this.mostrarFK_IdPedidoExporDetallePedidoExpor;
	}

	public void setMostrarFK_IdPedidoExporDetallePedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPedidoExporDetallePedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetallePedidoExpor=true;

	public Boolean getMostrarFK_IdPeriodoDetallePedidoExpor() {
		return this.mostrarFK_IdPeriodoDetallePedidoExpor;
	}

	public void setMostrarFK_IdPeriodoDetallePedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetallePedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetallePedidoExpor=true;

	public Boolean getMostrarFK_IdProductoDetallePedidoExpor() {
		return this.mostrarFK_IdProductoDetallePedidoExpor;
	}

	public void setMostrarFK_IdProductoDetallePedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetallePedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetallePedidoExpor=true;

	public Boolean getMostrarFK_IdSucursalDetallePedidoExpor() {
		return this.mostrarFK_IdSucursalDetallePedidoExpor;
	}

	public void setMostrarFK_IdSucursalDetallePedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetallePedidoExpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetallePedidoExpor=true;

	public Boolean getMostrarFK_IdUnidadDetallePedidoExpor() {
		return this.mostrarFK_IdUnidadDetallePedidoExpor;
	}

	public void setMostrarFK_IdUnidadDetallePedidoExpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetallePedidoExpor= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetallePedidoExpor=true;

	public Boolean getActivarFK_IdBodegaDetallePedidoExpor() {
		return this.activarFK_IdBodegaDetallePedidoExpor;
	}

	public void setActivarFK_IdBodegaDetallePedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetallePedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetallePedidoExpor=true;

	public Boolean getActivarFK_IdEjercicioDetallePedidoExpor() {
		return this.activarFK_IdEjercicioDetallePedidoExpor;
	}

	public void setActivarFK_IdEjercicioDetallePedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetallePedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetallePedidoExpor=true;

	public Boolean getActivarFK_IdEmpresaDetallePedidoExpor() {
		return this.activarFK_IdEmpresaDetallePedidoExpor;
	}

	public void setActivarFK_IdEmpresaDetallePedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetallePedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoDetallePedidoExporDetallePedidoExpor=true;

	public Boolean getActivarFK_IdEstadoDetallePedidoExporDetallePedidoExpor() {
		return this.activarFK_IdEstadoDetallePedidoExporDetallePedidoExpor;
	}

	public void setActivarFK_IdEstadoDetallePedidoExporDetallePedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoDetallePedidoExporDetallePedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdPedidoExporDetallePedidoExpor=true;

	public Boolean getActivarFK_IdPedidoExporDetallePedidoExpor() {
		return this.activarFK_IdPedidoExporDetallePedidoExpor;
	}

	public void setActivarFK_IdPedidoExporDetallePedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdPedidoExporDetallePedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetallePedidoExpor=true;

	public Boolean getActivarFK_IdPeriodoDetallePedidoExpor() {
		return this.activarFK_IdPeriodoDetallePedidoExpor;
	}

	public void setActivarFK_IdPeriodoDetallePedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetallePedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetallePedidoExpor=true;

	public Boolean getActivarFK_IdProductoDetallePedidoExpor() {
		return this.activarFK_IdProductoDetallePedidoExpor;
	}

	public void setActivarFK_IdProductoDetallePedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetallePedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetallePedidoExpor=true;

	public Boolean getActivarFK_IdSucursalDetallePedidoExpor() {
		return this.activarFK_IdSucursalDetallePedidoExpor;
	}

	public void setActivarFK_IdSucursalDetallePedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetallePedidoExpor= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetallePedidoExpor=true;

	public Boolean getActivarFK_IdUnidadDetallePedidoExpor() {
		return this.activarFK_IdUnidadDetallePedidoExpor;
	}

	public void setActivarFK_IdUnidadDetallePedidoExpor(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetallePedidoExpor= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetallePedidoExpor=null;

	public Border getResaltarFK_IdBodegaDetallePedidoExpor() {
		return this.resaltarFK_IdBodegaDetallePedidoExpor;
	}

	public void setResaltarFK_IdBodegaDetallePedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetallePedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetallePedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetallePedidoExpor=null;

	public Border getResaltarFK_IdEjercicioDetallePedidoExpor() {
		return this.resaltarFK_IdEjercicioDetallePedidoExpor;
	}

	public void setResaltarFK_IdEjercicioDetallePedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetallePedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetallePedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetallePedidoExpor=null;

	public Border getResaltarFK_IdEmpresaDetallePedidoExpor() {
		return this.resaltarFK_IdEmpresaDetallePedidoExpor;
	}

	public void setResaltarFK_IdEmpresaDetallePedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetallePedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetallePedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdEstadoDetallePedidoExporDetallePedidoExpor=null;

	public Border getResaltarFK_IdEstadoDetallePedidoExporDetallePedidoExpor() {
		return this.resaltarFK_IdEstadoDetallePedidoExporDetallePedidoExpor;
	}

	public void setResaltarFK_IdEstadoDetallePedidoExporDetallePedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdEstadoDetallePedidoExporDetallePedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdEstadoDetallePedidoExporDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoDetallePedidoExporDetallePedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdPedidoExporDetallePedidoExpor=null;

	public Border getResaltarFK_IdPedidoExporDetallePedidoExpor() {
		return this.resaltarFK_IdPedidoExporDetallePedidoExpor;
	}

	public void setResaltarFK_IdPedidoExporDetallePedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdPedidoExporDetallePedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdPedidoExporDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPedidoExporDetallePedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetallePedidoExpor=null;

	public Border getResaltarFK_IdPeriodoDetallePedidoExpor() {
		return this.resaltarFK_IdPeriodoDetallePedidoExpor;
	}

	public void setResaltarFK_IdPeriodoDetallePedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetallePedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetallePedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetallePedidoExpor=null;

	public Border getResaltarFK_IdProductoDetallePedidoExpor() {
		return this.resaltarFK_IdProductoDetallePedidoExpor;
	}

	public void setResaltarFK_IdProductoDetallePedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdProductoDetallePedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetallePedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetallePedidoExpor=null;

	public Border getResaltarFK_IdSucursalDetallePedidoExpor() {
		return this.resaltarFK_IdSucursalDetallePedidoExpor;
	}

	public void setResaltarFK_IdSucursalDetallePedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetallePedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetallePedidoExpor= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetallePedidoExpor=null;

	public Border getResaltarFK_IdUnidadDetallePedidoExpor() {
		return this.resaltarFK_IdUnidadDetallePedidoExpor;
	}

	public void setResaltarFK_IdUnidadDetallePedidoExpor(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetallePedidoExpor= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetallePedidoExpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoExporBeanSwingJInternalFrame detallepedidoexporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetallePedidoExpor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}