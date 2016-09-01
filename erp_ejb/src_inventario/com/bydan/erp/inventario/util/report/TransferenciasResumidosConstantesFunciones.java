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
package com.bydan.erp.inventario.util.report;

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


import com.bydan.erp.inventario.util.report.TransferenciasResumidosConstantesFunciones;
import com.bydan.erp.inventario.util.report.TransferenciasResumidosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.TransferenciasResumidosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TransferenciasResumidosConstantesFunciones{		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="TransferenciasResumidos";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TransferenciasResumidos"+TransferenciasResumidosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TransferenciasResumidosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TransferenciasResumidosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TransferenciasResumidosConstantesFunciones.SCHEMA+"_"+TransferenciasResumidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TransferenciasResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TransferenciasResumidosConstantesFunciones.SCHEMA+"_"+TransferenciasResumidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TransferenciasResumidosConstantesFunciones.SCHEMA+"_"+TransferenciasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TransferenciasResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TransferenciasResumidosConstantesFunciones.SCHEMA+"_"+TransferenciasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransferenciasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransferenciasResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransferenciasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransferenciasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransferenciasResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransferenciasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TransferenciasResumidosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TransferenciasResumidosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TransferenciasResumidosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TransferenciasResumidosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Transferencias Resumidoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Transferencias Resumidos";
	public static final String SCLASSWEBTITULO_LOWER="Transferencias Resumidos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TransferenciasResumidos";
	public static final String OBJECTNAME="transferenciasresumidos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="transferencias_resumidos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select transferenciasresumidos from "+TransferenciasResumidosConstantesFunciones.SPERSISTENCENAME+" transferenciasresumidos";
	public static String QUERYSELECTNATIVE="select "+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".id,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".version_row,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".id_empresa,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".id_sucursal,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".id_bodega,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".id_producto,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".id_transaccion,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".id_linea,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".id_linea_grupo,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".id_linea_categoria,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".id_linea_marca,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".fecha_emision_desde,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".nombre_transaccion,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".nombre_bodega,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".nombre_producto,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".nombre_unidad,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".cantidad,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".costo_unitario,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".costo_total,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".nombre_bodega_enviar,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".codigo_producto,"+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME+".tipo from "+TransferenciasResumidosConstantesFunciones.SCHEMA+"."+TransferenciasResumidosConstantesFunciones.TABLENAME;//+" as "+TransferenciasResumidosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBRETRANSACCION= "nombre_transaccion";
    public static final String NOMBREBODEGA= "nombre_bodega";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String CANTIDAD= "cantidad";
    public static final String COSTOUNITARIO= "costo_unitario";
    public static final String COSTOTOTAL= "costo_total";
    public static final String NOMBREBODEGAENVIAR= "nombre_bodega_enviar";
    public static final String CODIGOPRODUCTO= "codigo_producto";
    public static final String TIPO= "tipo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBRETRANSACCION= "Nombre Transaccion";
		public static final String LABEL_NOMBRETRANSACCION_LOWER= "Nombre Transaccion";
    	public static final String LABEL_NOMBREBODEGA= "Nombre Bodega";
		public static final String LABEL_NOMBREBODEGA_LOWER= "Nombre Bodega";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_COSTOUNITARIO= "Costo Unitario";
		public static final String LABEL_COSTOUNITARIO_LOWER= "Costo Unitario";
    	public static final String LABEL_COSTOTOTAL= "Costo Total";
		public static final String LABEL_COSTOTOTAL_LOWER= "Costo Total";
    	public static final String LABEL_NOMBREBODEGAENVIAR= "Nombre Bodega Enviar";
		public static final String LABEL_NOMBREBODEGAENVIAR_LOWER= "Nombre Bodega Enviar";
    	public static final String LABEL_CODIGOPRODUCTO= "Codigo Producto";
		public static final String LABEL_CODIGOPRODUCTO_LOWER= "Codigo Producto";
    	public static final String LABEL_TIPO= "Tipo";
		public static final String LABEL_TIPO_LOWER= "Tipo";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_TRANSACCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TRANSACCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_BODEGA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BODEGA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXNOMBRE_BODEGA_ENVIAR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BODEGA_ENVIAR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTIPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTransferenciasResumidosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.IDEMPRESA)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.IDBODEGA)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.IDPRODUCTO)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.IDTRANSACCION)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.IDLINEA)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.NOMBRETRANSACCION)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_NOMBRETRANSACCION;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.NOMBREBODEGA)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_NOMBREBODEGA;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.CANTIDAD)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.COSTOUNITARIO)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_COSTOUNITARIO;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.COSTOTOTAL)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.NOMBREBODEGAENVIAR)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_NOMBREBODEGAENVIAR;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		if(sNombreColumna.equals(TransferenciasResumidosConstantesFunciones.TIPO)) {sLabelColumna=TransferenciasResumidosConstantesFunciones.LABEL_TIPO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getTransferenciasResumidosDescripcion(TransferenciasResumidos transferenciasresumidos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(transferenciasresumidos !=null/* && transferenciasresumidos.getId()!=0*/) {
			if(transferenciasresumidos.getId()!=null) {
				sDescripcion=transferenciasresumidos.getId().toString();
			}//transferenciasresumidostransferenciasresumidos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTransferenciasResumidosDescripcionDetallado(TransferenciasResumidos transferenciasresumidos) {
		String sDescripcion="";
			
		sDescripcion+=TransferenciasResumidosConstantesFunciones.ID+"=";
		sDescripcion+=transferenciasresumidos.getId().toString()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=transferenciasresumidos.getVersionRow().toString()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=transferenciasresumidos.getid_empresa().toString()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=transferenciasresumidos.getid_sucursal().toString()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=transferenciasresumidos.getid_bodega().toString()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=transferenciasresumidos.getid_producto().toString()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=transferenciasresumidos.getid_transaccion().toString()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.IDLINEA+"=";
		sDescripcion+=transferenciasresumidos.getid_linea().toString()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=transferenciasresumidos.getid_linea_grupo().toString()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=transferenciasresumidos.getid_linea_categoria().toString()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=transferenciasresumidos.getid_linea_marca().toString()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=transferenciasresumidos.getfecha_emision_desde().toString()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=transferenciasresumidos.getfecha_emision_hasta().toString()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.NOMBRETRANSACCION+"=";
		sDescripcion+=transferenciasresumidos.getnombre_transaccion()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.NOMBREBODEGA+"=";
		sDescripcion+=transferenciasresumidos.getnombre_bodega()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=transferenciasresumidos.getnombre_producto()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=transferenciasresumidos.getnombre_unidad()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=transferenciasresumidos.getcantidad().toString()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.COSTOUNITARIO+"=";
		sDescripcion+=transferenciasresumidos.getcosto_unitario().toString()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=transferenciasresumidos.getcosto_total().toString()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.NOMBREBODEGAENVIAR+"=";
		sDescripcion+=transferenciasresumidos.getnombre_bodega_enviar()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=transferenciasresumidos.getcodigo_producto()+",";
		sDescripcion+=TransferenciasResumidosConstantesFunciones.TIPO+"=";
		sDescripcion+=transferenciasresumidos.gettipo()+",";
			
		return sDescripcion;
	}
	
	public static void setTransferenciasResumidosDescripcion(TransferenciasResumidos transferenciasresumidos,String sValor) throws Exception {			
		if(transferenciasresumidos !=null) {
			//transferenciasresumidostransferenciasresumidos.getId().toString();
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

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaGrupoDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaCategoriaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaMarcaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaTransferenciasResumidos")) {
			sNombreIndice="Tipo=  Por Bodega Por Producto Por Transaccion Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdLineaCategoria")) {
			sNombreIndice="Tipo=  Por Linea Categoria";
		} else if(sNombreIndice.equals("FK_IdLineaGrupo")) {
			sNombreIndice="Tipo=  Por Linea Grupo";
		} else if(sNombreIndice.equals("FK_IdLineaMarca")) {
			sNombreIndice="Tipo=  Por Linea Marca";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaTransferenciasResumidos(Long id_bodega,Long id_producto,Long id_transaccion,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();}
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();}
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();}
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaCategoria(Long id_linea_categoria) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaGrupo(Long id_linea_grupo) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaMarca(Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();} 

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

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTransferenciasResumidos(TransferenciasResumidos transferenciasresumidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		transferenciasresumidos.setnombre_transaccion(transferenciasresumidos.getnombre_transaccion().trim());
		transferenciasresumidos.setnombre_bodega(transferenciasresumidos.getnombre_bodega().trim());
		transferenciasresumidos.setnombre_producto(transferenciasresumidos.getnombre_producto().trim());
		transferenciasresumidos.setnombre_unidad(transferenciasresumidos.getnombre_unidad().trim());
		transferenciasresumidos.setnombre_bodega_enviar(transferenciasresumidos.getnombre_bodega_enviar().trim());
		transferenciasresumidos.setcodigo_producto(transferenciasresumidos.getcodigo_producto().trim());
		transferenciasresumidos.settipo(transferenciasresumidos.gettipo().trim());
	}
	
	public static void quitarEspaciosTransferenciasResumidoss(List<TransferenciasResumidos> transferenciasresumidoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TransferenciasResumidos transferenciasresumidos: transferenciasresumidoss) {
			transferenciasresumidos.setnombre_transaccion(transferenciasresumidos.getnombre_transaccion().trim());
			transferenciasresumidos.setnombre_bodega(transferenciasresumidos.getnombre_bodega().trim());
			transferenciasresumidos.setnombre_producto(transferenciasresumidos.getnombre_producto().trim());
			transferenciasresumidos.setnombre_unidad(transferenciasresumidos.getnombre_unidad().trim());
			transferenciasresumidos.setnombre_bodega_enviar(transferenciasresumidos.getnombre_bodega_enviar().trim());
			transferenciasresumidos.setcodigo_producto(transferenciasresumidos.getcodigo_producto().trim());
			transferenciasresumidos.settipo(transferenciasresumidos.gettipo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransferenciasResumidos(TransferenciasResumidos transferenciasresumidos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && transferenciasresumidos.getConCambioAuxiliar()) {
			transferenciasresumidos.setIsDeleted(transferenciasresumidos.getIsDeletedAuxiliar());	
			transferenciasresumidos.setIsNew(transferenciasresumidos.getIsNewAuxiliar());	
			transferenciasresumidos.setIsChanged(transferenciasresumidos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			transferenciasresumidos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			transferenciasresumidos.setIsDeletedAuxiliar(false);	
			transferenciasresumidos.setIsNewAuxiliar(false);	
			transferenciasresumidos.setIsChangedAuxiliar(false);
			
			transferenciasresumidos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransferenciasResumidoss(List<TransferenciasResumidos> transferenciasresumidoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TransferenciasResumidos transferenciasresumidos : transferenciasresumidoss) {
			if(conAsignarBase && transferenciasresumidos.getConCambioAuxiliar()) {
				transferenciasresumidos.setIsDeleted(transferenciasresumidos.getIsDeletedAuxiliar());	
				transferenciasresumidos.setIsNew(transferenciasresumidos.getIsNewAuxiliar());	
				transferenciasresumidos.setIsChanged(transferenciasresumidos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				transferenciasresumidos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				transferenciasresumidos.setIsDeletedAuxiliar(false);	
				transferenciasresumidos.setIsNewAuxiliar(false);	
				transferenciasresumidos.setIsChangedAuxiliar(false);
				
				transferenciasresumidos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTransferenciasResumidos(TransferenciasResumidos transferenciasresumidos,Boolean conEnteros) throws Exception  {
		transferenciasresumidos.setcosto_unitario(0.0);
		transferenciasresumidos.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			transferenciasresumidos.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresTransferenciasResumidoss(List<TransferenciasResumidos> transferenciasresumidoss,Boolean conEnteros) throws Exception  {
		
		for(TransferenciasResumidos transferenciasresumidos: transferenciasresumidoss) {
			transferenciasresumidos.setcosto_unitario(0.0);
			transferenciasresumidos.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				transferenciasresumidos.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaTransferenciasResumidos(List<TransferenciasResumidos> transferenciasresumidoss,TransferenciasResumidos transferenciasresumidosAux) throws Exception  {
		TransferenciasResumidosConstantesFunciones.InicializarValoresTransferenciasResumidos(transferenciasresumidosAux,true);
		
		for(TransferenciasResumidos transferenciasresumidos: transferenciasresumidoss) {
			if(transferenciasresumidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			transferenciasresumidosAux.setcantidad(transferenciasresumidosAux.getcantidad()+transferenciasresumidos.getcantidad());			
			transferenciasresumidosAux.setcosto_unitario(transferenciasresumidosAux.getcosto_unitario()+transferenciasresumidos.getcosto_unitario());			
			transferenciasresumidosAux.setcosto_total(transferenciasresumidosAux.getcosto_total()+transferenciasresumidos.getcosto_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTransferenciasResumidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TransferenciasResumidosConstantesFunciones.getArrayColumnasGlobalesTransferenciasResumidos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTransferenciasResumidos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransferenciasResumidosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransferenciasResumidosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransferenciasResumidosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransferenciasResumidosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTransferenciasResumidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TransferenciasResumidos> transferenciasresumidoss,TransferenciasResumidos transferenciasresumidos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TransferenciasResumidos transferenciasresumidosAux: transferenciasresumidoss) {
			if(transferenciasresumidosAux!=null && transferenciasresumidos!=null) {
				if((transferenciasresumidosAux.getId()==null && transferenciasresumidos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(transferenciasresumidosAux.getId()!=null && transferenciasresumidos.getId()!=null){
					if(transferenciasresumidosAux.getId().equals(transferenciasresumidos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTransferenciasResumidos(List<TransferenciasResumidos> transferenciasresumidoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costo_unitarioTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(TransferenciasResumidos transferenciasresumidos: transferenciasresumidoss) {			
			if(transferenciasresumidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costo_unitarioTotal+=transferenciasresumidos.getcosto_unitario();
			costo_totalTotal+=transferenciasresumidos.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciasResumidosConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciasResumidosConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTransferenciasResumidos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TransferenciasResumidosConstantesFunciones.LABEL_ID, TransferenciasResumidosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasResumidosConstantesFunciones.LABEL_VERSIONROW, TransferenciasResumidosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasResumidosConstantesFunciones.LABEL_NOMBRETRANSACCION, TransferenciasResumidosConstantesFunciones.NOMBRETRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasResumidosConstantesFunciones.LABEL_NOMBREBODEGA, TransferenciasResumidosConstantesFunciones.NOMBREBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasResumidosConstantesFunciones.LABEL_NOMBREPRODUCTO, TransferenciasResumidosConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasResumidosConstantesFunciones.LABEL_NOMBREUNIDAD, TransferenciasResumidosConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasResumidosConstantesFunciones.LABEL_CANTIDAD, TransferenciasResumidosConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasResumidosConstantesFunciones.LABEL_COSTOUNITARIO, TransferenciasResumidosConstantesFunciones.COSTOUNITARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasResumidosConstantesFunciones.LABEL_COSTOTOTAL, TransferenciasResumidosConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasResumidosConstantesFunciones.LABEL_NOMBREBODEGAENVIAR, TransferenciasResumidosConstantesFunciones.NOMBREBODEGAENVIAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasResumidosConstantesFunciones.LABEL_CODIGOPRODUCTO, TransferenciasResumidosConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciasResumidosConstantesFunciones.LABEL_TIPO, TransferenciasResumidosConstantesFunciones.TIPO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTransferenciasResumidos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TransferenciasResumidosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasResumidosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasResumidosConstantesFunciones.NOMBRETRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasResumidosConstantesFunciones.NOMBREBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasResumidosConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasResumidosConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasResumidosConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasResumidosConstantesFunciones.COSTOUNITARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasResumidosConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasResumidosConstantesFunciones.NOMBREBODEGAENVIAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasResumidosConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciasResumidosConstantesFunciones.TIPO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransferenciasResumidos() throws Exception  {
		return TransferenciasResumidosConstantesFunciones.getTiposSeleccionarTransferenciasResumidos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransferenciasResumidos(Boolean conFk) throws Exception  {
		return TransferenciasResumidosConstantesFunciones.getTiposSeleccionarTransferenciasResumidos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransferenciasResumidos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_NOMBRETRANSACCION);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_NOMBRETRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_NOMBREBODEGA);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_NOMBREBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_COSTOUNITARIO);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_COSTOUNITARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_NOMBREBODEGAENVIAR);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_NOMBREBODEGAENVIAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciasResumidosConstantesFunciones.LABEL_TIPO);
			reporte.setsDescripcion(TransferenciasResumidosConstantesFunciones.LABEL_TIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTransferenciasResumidos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTransferenciasResumidos(TransferenciasResumidos transferenciasresumidosAux) throws Exception {
		
			transferenciasresumidosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transferenciasresumidosAux.getEmpresa()));
			transferenciasresumidosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(transferenciasresumidosAux.getSucursal()));
			transferenciasresumidosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(transferenciasresumidosAux.getBodega()));
			transferenciasresumidosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(transferenciasresumidosAux.getProducto()));
			transferenciasresumidosAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(transferenciasresumidosAux.getTransaccion()));
			transferenciasresumidosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(transferenciasresumidosAux.getLinea()));
			transferenciasresumidosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(transferenciasresumidosAux.getLineaGrupo()));
			transferenciasresumidosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(transferenciasresumidosAux.getLineaCategoria()));
			transferenciasresumidosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(transferenciasresumidosAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTransferenciasResumidos(List<TransferenciasResumidos> transferenciasresumidossTemp) throws Exception {
		for(TransferenciasResumidos transferenciasresumidosAux:transferenciasresumidossTemp) {
			
			transferenciasresumidosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transferenciasresumidosAux.getEmpresa()));
			transferenciasresumidosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(transferenciasresumidosAux.getSucursal()));
			transferenciasresumidosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(transferenciasresumidosAux.getBodega()));
			transferenciasresumidosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(transferenciasresumidosAux.getProducto()));
			transferenciasresumidosAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(transferenciasresumidosAux.getTransaccion()));
			transferenciasresumidosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(transferenciasresumidosAux.getLinea()));
			transferenciasresumidosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(transferenciasresumidosAux.getLineaGrupo()));
			transferenciasresumidosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(transferenciasresumidosAux.getLineaCategoria()));
			transferenciasresumidosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(transferenciasresumidosAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTransferenciasResumidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				
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
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTransferenciasResumidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransferenciasResumidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransferenciasResumidosConstantesFunciones.getClassesRelationshipsOfTransferenciasResumidos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransferenciasResumidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransferenciasResumidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransferenciasResumidosConstantesFunciones.getClassesRelationshipsFromStringsOfTransferenciasResumidos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransferenciasResumidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TransferenciasResumidos transferenciasresumidos,List<TransferenciasResumidos> transferenciasresumidoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(TransferenciasResumidos transferenciasresumidos,List<TransferenciasResumidos> transferenciasresumidoss) throws Exception {
		try	{			
			for(TransferenciasResumidos transferenciasresumidosLocal:transferenciasresumidoss) {
				if(transferenciasresumidosLocal.getId().equals(transferenciasresumidos.getId())) {
					transferenciasresumidosLocal.setIsSelected(transferenciasresumidos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTransferenciasResumidos(List<TransferenciasResumidos> transferenciasresumidossAux) throws Exception {
		//this.transferenciasresumidossAux=transferenciasresumidossAux;
		
		for(TransferenciasResumidos transferenciasresumidosAux:transferenciasresumidossAux) {
			if(transferenciasresumidosAux.getIsChanged()) {
				transferenciasresumidosAux.setIsChanged(false);
			}		
			
			if(transferenciasresumidosAux.getIsNew()) {
				transferenciasresumidosAux.setIsNew(false);
			}	
			
			if(transferenciasresumidosAux.getIsDeleted()) {
				transferenciasresumidosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTransferenciasResumidos(TransferenciasResumidos transferenciasresumidosAux) throws Exception {
		//this.transferenciasresumidosAux=transferenciasresumidosAux;
		
			if(transferenciasresumidosAux.getIsChanged()) {
				transferenciasresumidosAux.setIsChanged(false);
			}		
			
			if(transferenciasresumidosAux.getIsNew()) {
				transferenciasresumidosAux.setIsNew(false);
			}	
			
			if(transferenciasresumidosAux.getIsDeleted()) {
				transferenciasresumidosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TransferenciasResumidos transferenciasresumidosAsignar,TransferenciasResumidos transferenciasresumidos) throws Exception {
		transferenciasresumidosAsignar.setId(transferenciasresumidos.getId());	
		transferenciasresumidosAsignar.setVersionRow(transferenciasresumidos.getVersionRow());	
		transferenciasresumidosAsignar.setnombre_transaccion(transferenciasresumidos.getnombre_transaccion());	
		transferenciasresumidosAsignar.setnombre_bodega(transferenciasresumidos.getnombre_bodega());	
		transferenciasresumidosAsignar.setnombre_producto(transferenciasresumidos.getnombre_producto());	
		transferenciasresumidosAsignar.setnombre_unidad(transferenciasresumidos.getnombre_unidad());	
		transferenciasresumidosAsignar.setcantidad(transferenciasresumidos.getcantidad());	
		transferenciasresumidosAsignar.setcosto_unitario(transferenciasresumidos.getcosto_unitario());	
		transferenciasresumidosAsignar.setcosto_total(transferenciasresumidos.getcosto_total());	
		transferenciasresumidosAsignar.setnombre_bodega_enviar(transferenciasresumidos.getnombre_bodega_enviar());	
		transferenciasresumidosAsignar.setcodigo_producto(transferenciasresumidos.getcodigo_producto());	
		transferenciasresumidosAsignar.settipo(transferenciasresumidos.gettipo());	
	}
	
	public static void inicializarTransferenciasResumidos(TransferenciasResumidos transferenciasresumidos) throws Exception {
		try {
				transferenciasresumidos.setId(0L);	
					
				transferenciasresumidos.setnombre_transaccion("");	
				transferenciasresumidos.setnombre_bodega("");	
				transferenciasresumidos.setnombre_producto("");	
				transferenciasresumidos.setnombre_unidad("");	
				transferenciasresumidos.setcantidad(0);	
				transferenciasresumidos.setcosto_unitario(0.0);	
				transferenciasresumidos.setcosto_total(0.0);	
				transferenciasresumidos.setnombre_bodega_enviar("");	
				transferenciasresumidos.setcodigo_producto("");	
				transferenciasresumidos.settipo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTransferenciasResumidos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_NOMBRETRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_NOMBREBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_COSTOUNITARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_NOMBREBODEGAENVIAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciasResumidosConstantesFunciones.LABEL_TIPO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTransferenciasResumidos(String sTipo,Row row,Workbook workbook,TransferenciasResumidos transferenciasresumidos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getnombre_transaccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getnombre_bodega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getcosto_unitario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getnombre_bodega_enviar());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferenciasresumidos.gettipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTransferenciasResumidos="";
	
	public String getsFinalQueryTransferenciasResumidos() {
		return this.sFinalQueryTransferenciasResumidos;
	}
	
	public void setsFinalQueryTransferenciasResumidos(String sFinalQueryTransferenciasResumidos) {
		this.sFinalQueryTransferenciasResumidos= sFinalQueryTransferenciasResumidos;
	}
	
	public Border resaltarSeleccionarTransferenciasResumidos=null;
	
	public Border setResaltarSeleccionarTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTransferenciasResumidos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTransferenciasResumidos() {
		return this.resaltarSeleccionarTransferenciasResumidos;
	}
	
	public void setResaltarSeleccionarTransferenciasResumidos(Border borderResaltarSeleccionarTransferenciasResumidos) {
		this.resaltarSeleccionarTransferenciasResumidos= borderResaltarSeleccionarTransferenciasResumidos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTransferenciasResumidos=null;
	public Boolean mostraridTransferenciasResumidos=true;
	public Boolean activaridTransferenciasResumidos=true;

	public Border resaltarid_empresaTransferenciasResumidos=null;
	public Boolean mostrarid_empresaTransferenciasResumidos=true;
	public Boolean activarid_empresaTransferenciasResumidos=true;
	public Boolean cargarid_empresaTransferenciasResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTransferenciasResumidos=false;//ConEventDepend=true

	public Border resaltarid_sucursalTransferenciasResumidos=null;
	public Boolean mostrarid_sucursalTransferenciasResumidos=true;
	public Boolean activarid_sucursalTransferenciasResumidos=true;
	public Boolean cargarid_sucursalTransferenciasResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalTransferenciasResumidos=false;//ConEventDepend=true

	public Border resaltarid_bodegaTransferenciasResumidos=null;
	public Boolean mostrarid_bodegaTransferenciasResumidos=true;
	public Boolean activarid_bodegaTransferenciasResumidos=true;
	public Boolean cargarid_bodegaTransferenciasResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaTransferenciasResumidos=false;//ConEventDepend=true

	public Border resaltarid_productoTransferenciasResumidos=null;
	public Boolean mostrarid_productoTransferenciasResumidos=true;
	public Boolean activarid_productoTransferenciasResumidos=true;
	public Boolean cargarid_productoTransferenciasResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoTransferenciasResumidos=false;//ConEventDepend=true

	public Border resaltarid_transaccionTransferenciasResumidos=null;
	public Boolean mostrarid_transaccionTransferenciasResumidos=true;
	public Boolean activarid_transaccionTransferenciasResumidos=true;
	public Boolean cargarid_transaccionTransferenciasResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionTransferenciasResumidos=false;//ConEventDepend=true

	public Border resaltarid_lineaTransferenciasResumidos=null;
	public Boolean mostrarid_lineaTransferenciasResumidos=true;
	public Boolean activarid_lineaTransferenciasResumidos=true;
	public Boolean cargarid_lineaTransferenciasResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaTransferenciasResumidos=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoTransferenciasResumidos=null;
	public Boolean mostrarid_linea_grupoTransferenciasResumidos=true;
	public Boolean activarid_linea_grupoTransferenciasResumidos=true;
	public Boolean cargarid_linea_grupoTransferenciasResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoTransferenciasResumidos=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaTransferenciasResumidos=null;
	public Boolean mostrarid_linea_categoriaTransferenciasResumidos=true;
	public Boolean activarid_linea_categoriaTransferenciasResumidos=true;
	public Boolean cargarid_linea_categoriaTransferenciasResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaTransferenciasResumidos=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaTransferenciasResumidos=null;
	public Boolean mostrarid_linea_marcaTransferenciasResumidos=true;
	public Boolean activarid_linea_marcaTransferenciasResumidos=true;
	public Boolean cargarid_linea_marcaTransferenciasResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaTransferenciasResumidos=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeTransferenciasResumidos=null;
	public Boolean mostrarfecha_emision_desdeTransferenciasResumidos=true;
	public Boolean activarfecha_emision_desdeTransferenciasResumidos=true;

	public Border resaltarfecha_emision_hastaTransferenciasResumidos=null;
	public Boolean mostrarfecha_emision_hastaTransferenciasResumidos=true;
	public Boolean activarfecha_emision_hastaTransferenciasResumidos=true;

	public Border resaltarnombre_transaccionTransferenciasResumidos=null;
	public Boolean mostrarnombre_transaccionTransferenciasResumidos=true;
	public Boolean activarnombre_transaccionTransferenciasResumidos=true;

	public Border resaltarnombre_bodegaTransferenciasResumidos=null;
	public Boolean mostrarnombre_bodegaTransferenciasResumidos=true;
	public Boolean activarnombre_bodegaTransferenciasResumidos=true;

	public Border resaltarnombre_productoTransferenciasResumidos=null;
	public Boolean mostrarnombre_productoTransferenciasResumidos=true;
	public Boolean activarnombre_productoTransferenciasResumidos=true;

	public Border resaltarnombre_unidadTransferenciasResumidos=null;
	public Boolean mostrarnombre_unidadTransferenciasResumidos=true;
	public Boolean activarnombre_unidadTransferenciasResumidos=true;

	public Border resaltarcantidadTransferenciasResumidos=null;
	public Boolean mostrarcantidadTransferenciasResumidos=true;
	public Boolean activarcantidadTransferenciasResumidos=true;

	public Border resaltarcosto_unitarioTransferenciasResumidos=null;
	public Boolean mostrarcosto_unitarioTransferenciasResumidos=true;
	public Boolean activarcosto_unitarioTransferenciasResumidos=true;

	public Border resaltarcosto_totalTransferenciasResumidos=null;
	public Boolean mostrarcosto_totalTransferenciasResumidos=true;
	public Boolean activarcosto_totalTransferenciasResumidos=true;

	public Border resaltarnombre_bodega_enviarTransferenciasResumidos=null;
	public Boolean mostrarnombre_bodega_enviarTransferenciasResumidos=true;
	public Boolean activarnombre_bodega_enviarTransferenciasResumidos=true;

	public Border resaltarcodigo_productoTransferenciasResumidos=null;
	public Boolean mostrarcodigo_productoTransferenciasResumidos=true;
	public Boolean activarcodigo_productoTransferenciasResumidos=true;

	public Border resaltartipoTransferenciasResumidos=null;
	public Boolean mostrartipoTransferenciasResumidos=true;
	public Boolean activartipoTransferenciasResumidos=true;

	
	

	public Border setResaltaridTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltaridTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTransferenciasResumidos() {
		return this.resaltaridTransferenciasResumidos;
	}

	public void setResaltaridTransferenciasResumidos(Border borderResaltar) {
		this.resaltaridTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostraridTransferenciasResumidos() {
		return this.mostraridTransferenciasResumidos;
	}

	public void setMostraridTransferenciasResumidos(Boolean mostraridTransferenciasResumidos) {
		this.mostraridTransferenciasResumidos= mostraridTransferenciasResumidos;
	}

	public Boolean getActivaridTransferenciasResumidos() {
		return this.activaridTransferenciasResumidos;
	}

	public void setActivaridTransferenciasResumidos(Boolean activaridTransferenciasResumidos) {
		this.activaridTransferenciasResumidos= activaridTransferenciasResumidos;
	}

	public Border setResaltarid_empresaTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarid_empresaTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTransferenciasResumidos() {
		return this.resaltarid_empresaTransferenciasResumidos;
	}

	public void setResaltarid_empresaTransferenciasResumidos(Border borderResaltar) {
		this.resaltarid_empresaTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarid_empresaTransferenciasResumidos() {
		return this.mostrarid_empresaTransferenciasResumidos;
	}

	public void setMostrarid_empresaTransferenciasResumidos(Boolean mostrarid_empresaTransferenciasResumidos) {
		this.mostrarid_empresaTransferenciasResumidos= mostrarid_empresaTransferenciasResumidos;
	}

	public Boolean getActivarid_empresaTransferenciasResumidos() {
		return this.activarid_empresaTransferenciasResumidos;
	}

	public void setActivarid_empresaTransferenciasResumidos(Boolean activarid_empresaTransferenciasResumidos) {
		this.activarid_empresaTransferenciasResumidos= activarid_empresaTransferenciasResumidos;
	}

	public Boolean getCargarid_empresaTransferenciasResumidos() {
		return this.cargarid_empresaTransferenciasResumidos;
	}

	public void setCargarid_empresaTransferenciasResumidos(Boolean cargarid_empresaTransferenciasResumidos) {
		this.cargarid_empresaTransferenciasResumidos= cargarid_empresaTransferenciasResumidos;
	}

	public Border setResaltarid_sucursalTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalTransferenciasResumidos() {
		return this.resaltarid_sucursalTransferenciasResumidos;
	}

	public void setResaltarid_sucursalTransferenciasResumidos(Border borderResaltar) {
		this.resaltarid_sucursalTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalTransferenciasResumidos() {
		return this.mostrarid_sucursalTransferenciasResumidos;
	}

	public void setMostrarid_sucursalTransferenciasResumidos(Boolean mostrarid_sucursalTransferenciasResumidos) {
		this.mostrarid_sucursalTransferenciasResumidos= mostrarid_sucursalTransferenciasResumidos;
	}

	public Boolean getActivarid_sucursalTransferenciasResumidos() {
		return this.activarid_sucursalTransferenciasResumidos;
	}

	public void setActivarid_sucursalTransferenciasResumidos(Boolean activarid_sucursalTransferenciasResumidos) {
		this.activarid_sucursalTransferenciasResumidos= activarid_sucursalTransferenciasResumidos;
	}

	public Boolean getCargarid_sucursalTransferenciasResumidos() {
		return this.cargarid_sucursalTransferenciasResumidos;
	}

	public void setCargarid_sucursalTransferenciasResumidos(Boolean cargarid_sucursalTransferenciasResumidos) {
		this.cargarid_sucursalTransferenciasResumidos= cargarid_sucursalTransferenciasResumidos;
	}

	public Border setResaltarid_bodegaTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarid_bodegaTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaTransferenciasResumidos() {
		return this.resaltarid_bodegaTransferenciasResumidos;
	}

	public void setResaltarid_bodegaTransferenciasResumidos(Border borderResaltar) {
		this.resaltarid_bodegaTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarid_bodegaTransferenciasResumidos() {
		return this.mostrarid_bodegaTransferenciasResumidos;
	}

	public void setMostrarid_bodegaTransferenciasResumidos(Boolean mostrarid_bodegaTransferenciasResumidos) {
		this.mostrarid_bodegaTransferenciasResumidos= mostrarid_bodegaTransferenciasResumidos;
	}

	public Boolean getActivarid_bodegaTransferenciasResumidos() {
		return this.activarid_bodegaTransferenciasResumidos;
	}

	public void setActivarid_bodegaTransferenciasResumidos(Boolean activarid_bodegaTransferenciasResumidos) {
		this.activarid_bodegaTransferenciasResumidos= activarid_bodegaTransferenciasResumidos;
	}

	public Boolean getCargarid_bodegaTransferenciasResumidos() {
		return this.cargarid_bodegaTransferenciasResumidos;
	}

	public void setCargarid_bodegaTransferenciasResumidos(Boolean cargarid_bodegaTransferenciasResumidos) {
		this.cargarid_bodegaTransferenciasResumidos= cargarid_bodegaTransferenciasResumidos;
	}

	public Border setResaltarid_productoTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarid_productoTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoTransferenciasResumidos() {
		return this.resaltarid_productoTransferenciasResumidos;
	}

	public void setResaltarid_productoTransferenciasResumidos(Border borderResaltar) {
		this.resaltarid_productoTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarid_productoTransferenciasResumidos() {
		return this.mostrarid_productoTransferenciasResumidos;
	}

	public void setMostrarid_productoTransferenciasResumidos(Boolean mostrarid_productoTransferenciasResumidos) {
		this.mostrarid_productoTransferenciasResumidos= mostrarid_productoTransferenciasResumidos;
	}

	public Boolean getActivarid_productoTransferenciasResumidos() {
		return this.activarid_productoTransferenciasResumidos;
	}

	public void setActivarid_productoTransferenciasResumidos(Boolean activarid_productoTransferenciasResumidos) {
		this.activarid_productoTransferenciasResumidos= activarid_productoTransferenciasResumidos;
	}

	public Boolean getCargarid_productoTransferenciasResumidos() {
		return this.cargarid_productoTransferenciasResumidos;
	}

	public void setCargarid_productoTransferenciasResumidos(Boolean cargarid_productoTransferenciasResumidos) {
		this.cargarid_productoTransferenciasResumidos= cargarid_productoTransferenciasResumidos;
	}

	public Border setResaltarid_transaccionTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarid_transaccionTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionTransferenciasResumidos() {
		return this.resaltarid_transaccionTransferenciasResumidos;
	}

	public void setResaltarid_transaccionTransferenciasResumidos(Border borderResaltar) {
		this.resaltarid_transaccionTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarid_transaccionTransferenciasResumidos() {
		return this.mostrarid_transaccionTransferenciasResumidos;
	}

	public void setMostrarid_transaccionTransferenciasResumidos(Boolean mostrarid_transaccionTransferenciasResumidos) {
		this.mostrarid_transaccionTransferenciasResumidos= mostrarid_transaccionTransferenciasResumidos;
	}

	public Boolean getActivarid_transaccionTransferenciasResumidos() {
		return this.activarid_transaccionTransferenciasResumidos;
	}

	public void setActivarid_transaccionTransferenciasResumidos(Boolean activarid_transaccionTransferenciasResumidos) {
		this.activarid_transaccionTransferenciasResumidos= activarid_transaccionTransferenciasResumidos;
	}

	public Boolean getCargarid_transaccionTransferenciasResumidos() {
		return this.cargarid_transaccionTransferenciasResumidos;
	}

	public void setCargarid_transaccionTransferenciasResumidos(Boolean cargarid_transaccionTransferenciasResumidos) {
		this.cargarid_transaccionTransferenciasResumidos= cargarid_transaccionTransferenciasResumidos;
	}

	public Border setResaltarid_lineaTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarid_lineaTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaTransferenciasResumidos() {
		return this.resaltarid_lineaTransferenciasResumidos;
	}

	public void setResaltarid_lineaTransferenciasResumidos(Border borderResaltar) {
		this.resaltarid_lineaTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarid_lineaTransferenciasResumidos() {
		return this.mostrarid_lineaTransferenciasResumidos;
	}

	public void setMostrarid_lineaTransferenciasResumidos(Boolean mostrarid_lineaTransferenciasResumidos) {
		this.mostrarid_lineaTransferenciasResumidos= mostrarid_lineaTransferenciasResumidos;
	}

	public Boolean getActivarid_lineaTransferenciasResumidos() {
		return this.activarid_lineaTransferenciasResumidos;
	}

	public void setActivarid_lineaTransferenciasResumidos(Boolean activarid_lineaTransferenciasResumidos) {
		this.activarid_lineaTransferenciasResumidos= activarid_lineaTransferenciasResumidos;
	}

	public Boolean getCargarid_lineaTransferenciasResumidos() {
		return this.cargarid_lineaTransferenciasResumidos;
	}

	public void setCargarid_lineaTransferenciasResumidos(Boolean cargarid_lineaTransferenciasResumidos) {
		this.cargarid_lineaTransferenciasResumidos= cargarid_lineaTransferenciasResumidos;
	}

	public Border setResaltarid_linea_grupoTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoTransferenciasResumidos() {
		return this.resaltarid_linea_grupoTransferenciasResumidos;
	}

	public void setResaltarid_linea_grupoTransferenciasResumidos(Border borderResaltar) {
		this.resaltarid_linea_grupoTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoTransferenciasResumidos() {
		return this.mostrarid_linea_grupoTransferenciasResumidos;
	}

	public void setMostrarid_linea_grupoTransferenciasResumidos(Boolean mostrarid_linea_grupoTransferenciasResumidos) {
		this.mostrarid_linea_grupoTransferenciasResumidos= mostrarid_linea_grupoTransferenciasResumidos;
	}

	public Boolean getActivarid_linea_grupoTransferenciasResumidos() {
		return this.activarid_linea_grupoTransferenciasResumidos;
	}

	public void setActivarid_linea_grupoTransferenciasResumidos(Boolean activarid_linea_grupoTransferenciasResumidos) {
		this.activarid_linea_grupoTransferenciasResumidos= activarid_linea_grupoTransferenciasResumidos;
	}

	public Boolean getCargarid_linea_grupoTransferenciasResumidos() {
		return this.cargarid_linea_grupoTransferenciasResumidos;
	}

	public void setCargarid_linea_grupoTransferenciasResumidos(Boolean cargarid_linea_grupoTransferenciasResumidos) {
		this.cargarid_linea_grupoTransferenciasResumidos= cargarid_linea_grupoTransferenciasResumidos;
	}

	public Border setResaltarid_linea_categoriaTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaTransferenciasResumidos() {
		return this.resaltarid_linea_categoriaTransferenciasResumidos;
	}

	public void setResaltarid_linea_categoriaTransferenciasResumidos(Border borderResaltar) {
		this.resaltarid_linea_categoriaTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaTransferenciasResumidos() {
		return this.mostrarid_linea_categoriaTransferenciasResumidos;
	}

	public void setMostrarid_linea_categoriaTransferenciasResumidos(Boolean mostrarid_linea_categoriaTransferenciasResumidos) {
		this.mostrarid_linea_categoriaTransferenciasResumidos= mostrarid_linea_categoriaTransferenciasResumidos;
	}

	public Boolean getActivarid_linea_categoriaTransferenciasResumidos() {
		return this.activarid_linea_categoriaTransferenciasResumidos;
	}

	public void setActivarid_linea_categoriaTransferenciasResumidos(Boolean activarid_linea_categoriaTransferenciasResumidos) {
		this.activarid_linea_categoriaTransferenciasResumidos= activarid_linea_categoriaTransferenciasResumidos;
	}

	public Boolean getCargarid_linea_categoriaTransferenciasResumidos() {
		return this.cargarid_linea_categoriaTransferenciasResumidos;
	}

	public void setCargarid_linea_categoriaTransferenciasResumidos(Boolean cargarid_linea_categoriaTransferenciasResumidos) {
		this.cargarid_linea_categoriaTransferenciasResumidos= cargarid_linea_categoriaTransferenciasResumidos;
	}

	public Border setResaltarid_linea_marcaTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaTransferenciasResumidos() {
		return this.resaltarid_linea_marcaTransferenciasResumidos;
	}

	public void setResaltarid_linea_marcaTransferenciasResumidos(Border borderResaltar) {
		this.resaltarid_linea_marcaTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaTransferenciasResumidos() {
		return this.mostrarid_linea_marcaTransferenciasResumidos;
	}

	public void setMostrarid_linea_marcaTransferenciasResumidos(Boolean mostrarid_linea_marcaTransferenciasResumidos) {
		this.mostrarid_linea_marcaTransferenciasResumidos= mostrarid_linea_marcaTransferenciasResumidos;
	}

	public Boolean getActivarid_linea_marcaTransferenciasResumidos() {
		return this.activarid_linea_marcaTransferenciasResumidos;
	}

	public void setActivarid_linea_marcaTransferenciasResumidos(Boolean activarid_linea_marcaTransferenciasResumidos) {
		this.activarid_linea_marcaTransferenciasResumidos= activarid_linea_marcaTransferenciasResumidos;
	}

	public Boolean getCargarid_linea_marcaTransferenciasResumidos() {
		return this.cargarid_linea_marcaTransferenciasResumidos;
	}

	public void setCargarid_linea_marcaTransferenciasResumidos(Boolean cargarid_linea_marcaTransferenciasResumidos) {
		this.cargarid_linea_marcaTransferenciasResumidos= cargarid_linea_marcaTransferenciasResumidos;
	}

	public Border setResaltarfecha_emision_desdeTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeTransferenciasResumidos() {
		return this.resaltarfecha_emision_desdeTransferenciasResumidos;
	}

	public void setResaltarfecha_emision_desdeTransferenciasResumidos(Border borderResaltar) {
		this.resaltarfecha_emision_desdeTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeTransferenciasResumidos() {
		return this.mostrarfecha_emision_desdeTransferenciasResumidos;
	}

	public void setMostrarfecha_emision_desdeTransferenciasResumidos(Boolean mostrarfecha_emision_desdeTransferenciasResumidos) {
		this.mostrarfecha_emision_desdeTransferenciasResumidos= mostrarfecha_emision_desdeTransferenciasResumidos;
	}

	public Boolean getActivarfecha_emision_desdeTransferenciasResumidos() {
		return this.activarfecha_emision_desdeTransferenciasResumidos;
	}

	public void setActivarfecha_emision_desdeTransferenciasResumidos(Boolean activarfecha_emision_desdeTransferenciasResumidos) {
		this.activarfecha_emision_desdeTransferenciasResumidos= activarfecha_emision_desdeTransferenciasResumidos;
	}

	public Border setResaltarfecha_emision_hastaTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaTransferenciasResumidos() {
		return this.resaltarfecha_emision_hastaTransferenciasResumidos;
	}

	public void setResaltarfecha_emision_hastaTransferenciasResumidos(Border borderResaltar) {
		this.resaltarfecha_emision_hastaTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaTransferenciasResumidos() {
		return this.mostrarfecha_emision_hastaTransferenciasResumidos;
	}

	public void setMostrarfecha_emision_hastaTransferenciasResumidos(Boolean mostrarfecha_emision_hastaTransferenciasResumidos) {
		this.mostrarfecha_emision_hastaTransferenciasResumidos= mostrarfecha_emision_hastaTransferenciasResumidos;
	}

	public Boolean getActivarfecha_emision_hastaTransferenciasResumidos() {
		return this.activarfecha_emision_hastaTransferenciasResumidos;
	}

	public void setActivarfecha_emision_hastaTransferenciasResumidos(Boolean activarfecha_emision_hastaTransferenciasResumidos) {
		this.activarfecha_emision_hastaTransferenciasResumidos= activarfecha_emision_hastaTransferenciasResumidos;
	}

	public Border setResaltarnombre_transaccionTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarnombre_transaccionTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_transaccionTransferenciasResumidos() {
		return this.resaltarnombre_transaccionTransferenciasResumidos;
	}

	public void setResaltarnombre_transaccionTransferenciasResumidos(Border borderResaltar) {
		this.resaltarnombre_transaccionTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarnombre_transaccionTransferenciasResumidos() {
		return this.mostrarnombre_transaccionTransferenciasResumidos;
	}

	public void setMostrarnombre_transaccionTransferenciasResumidos(Boolean mostrarnombre_transaccionTransferenciasResumidos) {
		this.mostrarnombre_transaccionTransferenciasResumidos= mostrarnombre_transaccionTransferenciasResumidos;
	}

	public Boolean getActivarnombre_transaccionTransferenciasResumidos() {
		return this.activarnombre_transaccionTransferenciasResumidos;
	}

	public void setActivarnombre_transaccionTransferenciasResumidos(Boolean activarnombre_transaccionTransferenciasResumidos) {
		this.activarnombre_transaccionTransferenciasResumidos= activarnombre_transaccionTransferenciasResumidos;
	}

	public Border setResaltarnombre_bodegaTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarnombre_bodegaTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bodegaTransferenciasResumidos() {
		return this.resaltarnombre_bodegaTransferenciasResumidos;
	}

	public void setResaltarnombre_bodegaTransferenciasResumidos(Border borderResaltar) {
		this.resaltarnombre_bodegaTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarnombre_bodegaTransferenciasResumidos() {
		return this.mostrarnombre_bodegaTransferenciasResumidos;
	}

	public void setMostrarnombre_bodegaTransferenciasResumidos(Boolean mostrarnombre_bodegaTransferenciasResumidos) {
		this.mostrarnombre_bodegaTransferenciasResumidos= mostrarnombre_bodegaTransferenciasResumidos;
	}

	public Boolean getActivarnombre_bodegaTransferenciasResumidos() {
		return this.activarnombre_bodegaTransferenciasResumidos;
	}

	public void setActivarnombre_bodegaTransferenciasResumidos(Boolean activarnombre_bodegaTransferenciasResumidos) {
		this.activarnombre_bodegaTransferenciasResumidos= activarnombre_bodegaTransferenciasResumidos;
	}

	public Border setResaltarnombre_productoTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarnombre_productoTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoTransferenciasResumidos() {
		return this.resaltarnombre_productoTransferenciasResumidos;
	}

	public void setResaltarnombre_productoTransferenciasResumidos(Border borderResaltar) {
		this.resaltarnombre_productoTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarnombre_productoTransferenciasResumidos() {
		return this.mostrarnombre_productoTransferenciasResumidos;
	}

	public void setMostrarnombre_productoTransferenciasResumidos(Boolean mostrarnombre_productoTransferenciasResumidos) {
		this.mostrarnombre_productoTransferenciasResumidos= mostrarnombre_productoTransferenciasResumidos;
	}

	public Boolean getActivarnombre_productoTransferenciasResumidos() {
		return this.activarnombre_productoTransferenciasResumidos;
	}

	public void setActivarnombre_productoTransferenciasResumidos(Boolean activarnombre_productoTransferenciasResumidos) {
		this.activarnombre_productoTransferenciasResumidos= activarnombre_productoTransferenciasResumidos;
	}

	public Border setResaltarnombre_unidadTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadTransferenciasResumidos() {
		return this.resaltarnombre_unidadTransferenciasResumidos;
	}

	public void setResaltarnombre_unidadTransferenciasResumidos(Border borderResaltar) {
		this.resaltarnombre_unidadTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadTransferenciasResumidos() {
		return this.mostrarnombre_unidadTransferenciasResumidos;
	}

	public void setMostrarnombre_unidadTransferenciasResumidos(Boolean mostrarnombre_unidadTransferenciasResumidos) {
		this.mostrarnombre_unidadTransferenciasResumidos= mostrarnombre_unidadTransferenciasResumidos;
	}

	public Boolean getActivarnombre_unidadTransferenciasResumidos() {
		return this.activarnombre_unidadTransferenciasResumidos;
	}

	public void setActivarnombre_unidadTransferenciasResumidos(Boolean activarnombre_unidadTransferenciasResumidos) {
		this.activarnombre_unidadTransferenciasResumidos= activarnombre_unidadTransferenciasResumidos;
	}

	public Border setResaltarcantidadTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarcantidadTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadTransferenciasResumidos() {
		return this.resaltarcantidadTransferenciasResumidos;
	}

	public void setResaltarcantidadTransferenciasResumidos(Border borderResaltar) {
		this.resaltarcantidadTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarcantidadTransferenciasResumidos() {
		return this.mostrarcantidadTransferenciasResumidos;
	}

	public void setMostrarcantidadTransferenciasResumidos(Boolean mostrarcantidadTransferenciasResumidos) {
		this.mostrarcantidadTransferenciasResumidos= mostrarcantidadTransferenciasResumidos;
	}

	public Boolean getActivarcantidadTransferenciasResumidos() {
		return this.activarcantidadTransferenciasResumidos;
	}

	public void setActivarcantidadTransferenciasResumidos(Boolean activarcantidadTransferenciasResumidos) {
		this.activarcantidadTransferenciasResumidos= activarcantidadTransferenciasResumidos;
	}

	public Border setResaltarcosto_unitarioTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarcosto_unitarioTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_unitarioTransferenciasResumidos() {
		return this.resaltarcosto_unitarioTransferenciasResumidos;
	}

	public void setResaltarcosto_unitarioTransferenciasResumidos(Border borderResaltar) {
		this.resaltarcosto_unitarioTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarcosto_unitarioTransferenciasResumidos() {
		return this.mostrarcosto_unitarioTransferenciasResumidos;
	}

	public void setMostrarcosto_unitarioTransferenciasResumidos(Boolean mostrarcosto_unitarioTransferenciasResumidos) {
		this.mostrarcosto_unitarioTransferenciasResumidos= mostrarcosto_unitarioTransferenciasResumidos;
	}

	public Boolean getActivarcosto_unitarioTransferenciasResumidos() {
		return this.activarcosto_unitarioTransferenciasResumidos;
	}

	public void setActivarcosto_unitarioTransferenciasResumidos(Boolean activarcosto_unitarioTransferenciasResumidos) {
		this.activarcosto_unitarioTransferenciasResumidos= activarcosto_unitarioTransferenciasResumidos;
	}

	public Border setResaltarcosto_totalTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarcosto_totalTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalTransferenciasResumidos() {
		return this.resaltarcosto_totalTransferenciasResumidos;
	}

	public void setResaltarcosto_totalTransferenciasResumidos(Border borderResaltar) {
		this.resaltarcosto_totalTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarcosto_totalTransferenciasResumidos() {
		return this.mostrarcosto_totalTransferenciasResumidos;
	}

	public void setMostrarcosto_totalTransferenciasResumidos(Boolean mostrarcosto_totalTransferenciasResumidos) {
		this.mostrarcosto_totalTransferenciasResumidos= mostrarcosto_totalTransferenciasResumidos;
	}

	public Boolean getActivarcosto_totalTransferenciasResumidos() {
		return this.activarcosto_totalTransferenciasResumidos;
	}

	public void setActivarcosto_totalTransferenciasResumidos(Boolean activarcosto_totalTransferenciasResumidos) {
		this.activarcosto_totalTransferenciasResumidos= activarcosto_totalTransferenciasResumidos;
	}

	public Border setResaltarnombre_bodega_enviarTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarnombre_bodega_enviarTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bodega_enviarTransferenciasResumidos() {
		return this.resaltarnombre_bodega_enviarTransferenciasResumidos;
	}

	public void setResaltarnombre_bodega_enviarTransferenciasResumidos(Border borderResaltar) {
		this.resaltarnombre_bodega_enviarTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarnombre_bodega_enviarTransferenciasResumidos() {
		return this.mostrarnombre_bodega_enviarTransferenciasResumidos;
	}

	public void setMostrarnombre_bodega_enviarTransferenciasResumidos(Boolean mostrarnombre_bodega_enviarTransferenciasResumidos) {
		this.mostrarnombre_bodega_enviarTransferenciasResumidos= mostrarnombre_bodega_enviarTransferenciasResumidos;
	}

	public Boolean getActivarnombre_bodega_enviarTransferenciasResumidos() {
		return this.activarnombre_bodega_enviarTransferenciasResumidos;
	}

	public void setActivarnombre_bodega_enviarTransferenciasResumidos(Boolean activarnombre_bodega_enviarTransferenciasResumidos) {
		this.activarnombre_bodega_enviarTransferenciasResumidos= activarnombre_bodega_enviarTransferenciasResumidos;
	}

	public Border setResaltarcodigo_productoTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoTransferenciasResumidos() {
		return this.resaltarcodigo_productoTransferenciasResumidos;
	}

	public void setResaltarcodigo_productoTransferenciasResumidos(Border borderResaltar) {
		this.resaltarcodigo_productoTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoTransferenciasResumidos() {
		return this.mostrarcodigo_productoTransferenciasResumidos;
	}

	public void setMostrarcodigo_productoTransferenciasResumidos(Boolean mostrarcodigo_productoTransferenciasResumidos) {
		this.mostrarcodigo_productoTransferenciasResumidos= mostrarcodigo_productoTransferenciasResumidos;
	}

	public Boolean getActivarcodigo_productoTransferenciasResumidos() {
		return this.activarcodigo_productoTransferenciasResumidos;
	}

	public void setActivarcodigo_productoTransferenciasResumidos(Boolean activarcodigo_productoTransferenciasResumidos) {
		this.activarcodigo_productoTransferenciasResumidos= activarcodigo_productoTransferenciasResumidos;
	}

	public Border setResaltartipoTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciasresumidosBeanSwingJInternalFrame.jTtoolBarTransferenciasResumidos.setBorder(borderResaltar);
		
		this.resaltartipoTransferenciasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipoTransferenciasResumidos() {
		return this.resaltartipoTransferenciasResumidos;
	}

	public void setResaltartipoTransferenciasResumidos(Border borderResaltar) {
		this.resaltartipoTransferenciasResumidos= borderResaltar;
	}

	public Boolean getMostrartipoTransferenciasResumidos() {
		return this.mostrartipoTransferenciasResumidos;
	}

	public void setMostrartipoTransferenciasResumidos(Boolean mostrartipoTransferenciasResumidos) {
		this.mostrartipoTransferenciasResumidos= mostrartipoTransferenciasResumidos;
	}

	public Boolean getActivartipoTransferenciasResumidos() {
		return this.activartipoTransferenciasResumidos;
	}

	public void setActivartipoTransferenciasResumidos(Boolean activartipoTransferenciasResumidos) {
		this.activartipoTransferenciasResumidos= activartipoTransferenciasResumidos;
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
		
		
		this.setMostraridTransferenciasResumidos(esInicial);
		this.setMostrarid_empresaTransferenciasResumidos(esInicial);
		this.setMostrarid_sucursalTransferenciasResumidos(esInicial);
		this.setMostrarid_bodegaTransferenciasResumidos(esInicial);
		this.setMostrarid_productoTransferenciasResumidos(esInicial);
		this.setMostrarid_transaccionTransferenciasResumidos(esInicial);
		this.setMostrarid_lineaTransferenciasResumidos(esInicial);
		this.setMostrarid_linea_grupoTransferenciasResumidos(esInicial);
		this.setMostrarid_linea_categoriaTransferenciasResumidos(esInicial);
		this.setMostrarid_linea_marcaTransferenciasResumidos(esInicial);
		this.setMostrarfecha_emision_desdeTransferenciasResumidos(esInicial);
		this.setMostrarfecha_emision_hastaTransferenciasResumidos(esInicial);
		this.setMostrarnombre_transaccionTransferenciasResumidos(esInicial);
		this.setMostrarnombre_bodegaTransferenciasResumidos(esInicial);
		this.setMostrarnombre_productoTransferenciasResumidos(esInicial);
		this.setMostrarnombre_unidadTransferenciasResumidos(esInicial);
		this.setMostrarcantidadTransferenciasResumidos(esInicial);
		this.setMostrarcosto_unitarioTransferenciasResumidos(esInicial);
		this.setMostrarcosto_totalTransferenciasResumidos(esInicial);
		this.setMostrarnombre_bodega_enviarTransferenciasResumidos(esInicial);
		this.setMostrarcodigo_productoTransferenciasResumidos(esInicial);
		this.setMostrartipoTransferenciasResumidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.ID)) {
				this.setMostraridTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.NOMBRETRANSACCION)) {
				this.setMostrarnombre_transaccionTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.NOMBREBODEGA)) {
				this.setMostrarnombre_bodegaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.COSTOUNITARIO)) {
				this.setMostrarcosto_unitarioTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.NOMBREBODEGAENVIAR)) {
				this.setMostrarnombre_bodega_enviarTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.TIPO)) {
				this.setMostrartipoTransferenciasResumidos(esAsigna);
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
		
		
		this.setActivaridTransferenciasResumidos(esInicial);
		this.setActivarid_empresaTransferenciasResumidos(esInicial);
		this.setActivarid_sucursalTransferenciasResumidos(esInicial);
		this.setActivarid_bodegaTransferenciasResumidos(esInicial);
		this.setActivarid_productoTransferenciasResumidos(esInicial);
		this.setActivarid_transaccionTransferenciasResumidos(esInicial);
		this.setActivarid_lineaTransferenciasResumidos(esInicial);
		this.setActivarid_linea_grupoTransferenciasResumidos(esInicial);
		this.setActivarid_linea_categoriaTransferenciasResumidos(esInicial);
		this.setActivarid_linea_marcaTransferenciasResumidos(esInicial);
		this.setActivarfecha_emision_desdeTransferenciasResumidos(esInicial);
		this.setActivarfecha_emision_hastaTransferenciasResumidos(esInicial);
		this.setActivarnombre_transaccionTransferenciasResumidos(esInicial);
		this.setActivarnombre_bodegaTransferenciasResumidos(esInicial);
		this.setActivarnombre_productoTransferenciasResumidos(esInicial);
		this.setActivarnombre_unidadTransferenciasResumidos(esInicial);
		this.setActivarcantidadTransferenciasResumidos(esInicial);
		this.setActivarcosto_unitarioTransferenciasResumidos(esInicial);
		this.setActivarcosto_totalTransferenciasResumidos(esInicial);
		this.setActivarnombre_bodega_enviarTransferenciasResumidos(esInicial);
		this.setActivarcodigo_productoTransferenciasResumidos(esInicial);
		this.setActivartipoTransferenciasResumidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.ID)) {
				this.setActivaridTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.NOMBRETRANSACCION)) {
				this.setActivarnombre_transaccionTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.NOMBREBODEGA)) {
				this.setActivarnombre_bodegaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.COSTOUNITARIO)) {
				this.setActivarcosto_unitarioTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.NOMBREBODEGAENVIAR)) {
				this.setActivarnombre_bodega_enviarTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.TIPO)) {
				this.setActivartipoTransferenciasResumidos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTransferenciasResumidos(esInicial);
		this.setResaltarid_empresaTransferenciasResumidos(esInicial);
		this.setResaltarid_sucursalTransferenciasResumidos(esInicial);
		this.setResaltarid_bodegaTransferenciasResumidos(esInicial);
		this.setResaltarid_productoTransferenciasResumidos(esInicial);
		this.setResaltarid_transaccionTransferenciasResumidos(esInicial);
		this.setResaltarid_lineaTransferenciasResumidos(esInicial);
		this.setResaltarid_linea_grupoTransferenciasResumidos(esInicial);
		this.setResaltarid_linea_categoriaTransferenciasResumidos(esInicial);
		this.setResaltarid_linea_marcaTransferenciasResumidos(esInicial);
		this.setResaltarfecha_emision_desdeTransferenciasResumidos(esInicial);
		this.setResaltarfecha_emision_hastaTransferenciasResumidos(esInicial);
		this.setResaltarnombre_transaccionTransferenciasResumidos(esInicial);
		this.setResaltarnombre_bodegaTransferenciasResumidos(esInicial);
		this.setResaltarnombre_productoTransferenciasResumidos(esInicial);
		this.setResaltarnombre_unidadTransferenciasResumidos(esInicial);
		this.setResaltarcantidadTransferenciasResumidos(esInicial);
		this.setResaltarcosto_unitarioTransferenciasResumidos(esInicial);
		this.setResaltarcosto_totalTransferenciasResumidos(esInicial);
		this.setResaltarnombre_bodega_enviarTransferenciasResumidos(esInicial);
		this.setResaltarcodigo_productoTransferenciasResumidos(esInicial);
		this.setResaltartipoTransferenciasResumidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.ID)) {
				this.setResaltaridTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.NOMBRETRANSACCION)) {
				this.setResaltarnombre_transaccionTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.NOMBREBODEGA)) {
				this.setResaltarnombre_bodegaTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.COSTOUNITARIO)) {
				this.setResaltarcosto_unitarioTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.NOMBREBODEGAENVIAR)) {
				this.setResaltarnombre_bodega_enviarTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoTransferenciasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciasResumidosConstantesFunciones.TIPO)) {
				this.setResaltartipoTransferenciasResumidos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaTransferenciasResumidosTransferenciasResumidos=true;

	public Boolean getMostrarBusquedaTransferenciasResumidosTransferenciasResumidos() {
		return this.mostrarBusquedaTransferenciasResumidosTransferenciasResumidos;
	}

	public void setMostrarBusquedaTransferenciasResumidosTransferenciasResumidos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaTransferenciasResumidosTransferenciasResumidos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaTransferenciasResumidosTransferenciasResumidos=true;

	public Boolean getActivarBusquedaTransferenciasResumidosTransferenciasResumidos() {
		return this.activarBusquedaTransferenciasResumidosTransferenciasResumidos;
	}

	public void setActivarBusquedaTransferenciasResumidosTransferenciasResumidos(Boolean habilitarResaltar) {
		this.activarBusquedaTransferenciasResumidosTransferenciasResumidos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaTransferenciasResumidosTransferenciasResumidos=null;

	public Border getResaltarBusquedaTransferenciasResumidosTransferenciasResumidos() {
		return this.resaltarBusquedaTransferenciasResumidosTransferenciasResumidos;
	}

	public void setResaltarBusquedaTransferenciasResumidosTransferenciasResumidos(Border borderResaltar) {
		this.resaltarBusquedaTransferenciasResumidosTransferenciasResumidos= borderResaltar;
	}

	public void setResaltarBusquedaTransferenciasResumidosTransferenciasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciasResumidosBeanSwingJInternalFrame transferenciasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaTransferenciasResumidosTransferenciasResumidos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}