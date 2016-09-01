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


import com.bydan.erp.inventario.util.report.AutorizarRequisicionesConstantesFunciones;
import com.bydan.erp.inventario.util.report.AutorizarRequisicionesParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.AutorizarRequisicionesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AutorizarRequisicionesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="AutorizarRequisiciones";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AutorizarRequisiciones"+AutorizarRequisicionesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AutorizarRequisicionesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AutorizarRequisicionesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AutorizarRequisicionesConstantesFunciones.SCHEMA+"_"+AutorizarRequisicionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AutorizarRequisicionesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AutorizarRequisicionesConstantesFunciones.SCHEMA+"_"+AutorizarRequisicionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AutorizarRequisicionesConstantesFunciones.SCHEMA+"_"+AutorizarRequisicionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AutorizarRequisicionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AutorizarRequisicionesConstantesFunciones.SCHEMA+"_"+AutorizarRequisicionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutorizarRequisicionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AutorizarRequisicionesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutorizarRequisicionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutorizarRequisicionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AutorizarRequisicionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutorizarRequisicionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AutorizarRequisicionesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AutorizarRequisicionesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AutorizarRequisicionesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AutorizarRequisicionesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Autorizar Requisicioneses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Autorizar Requisiciones";
	public static final String SCLASSWEBTITULO_LOWER="Autorizar Requisiciones";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AutorizarRequisiciones";
	public static final String OBJECTNAME="autorizarrequisiciones";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="autorizar_requisiciones";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select autorizarrequisiciones from "+AutorizarRequisicionesConstantesFunciones.SPERSISTENCENAME+" autorizarrequisiciones";
	public static String QUERYSELECTNATIVE="select "+AutorizarRequisicionesConstantesFunciones.SCHEMA+"."+AutorizarRequisicionesConstantesFunciones.TABLENAME+".id,"+AutorizarRequisicionesConstantesFunciones.SCHEMA+"."+AutorizarRequisicionesConstantesFunciones.TABLENAME+".version_row,"+AutorizarRequisicionesConstantesFunciones.SCHEMA+"."+AutorizarRequisicionesConstantesFunciones.TABLENAME+".id_empresa,"+AutorizarRequisicionesConstantesFunciones.SCHEMA+"."+AutorizarRequisicionesConstantesFunciones.TABLENAME+".id_sucursal,"+AutorizarRequisicionesConstantesFunciones.SCHEMA+"."+AutorizarRequisicionesConstantesFunciones.TABLENAME+".fecha_desde,"+AutorizarRequisicionesConstantesFunciones.SCHEMA+"."+AutorizarRequisicionesConstantesFunciones.TABLENAME+".fecha_hasta,"+AutorizarRequisicionesConstantesFunciones.SCHEMA+"."+AutorizarRequisicionesConstantesFunciones.TABLENAME+".codigo_tipo_requisicion,"+AutorizarRequisicionesConstantesFunciones.SCHEMA+"."+AutorizarRequisicionesConstantesFunciones.TABLENAME+".codigo,"+AutorizarRequisicionesConstantesFunciones.SCHEMA+"."+AutorizarRequisicionesConstantesFunciones.TABLENAME+".fecha,"+AutorizarRequisicionesConstantesFunciones.SCHEMA+"."+AutorizarRequisicionesConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+AutorizarRequisicionesConstantesFunciones.SCHEMA+"."+AutorizarRequisicionesConstantesFunciones.TABLENAME+".nombre_bodega,"+AutorizarRequisicionesConstantesFunciones.SCHEMA+"."+AutorizarRequisicionesConstantesFunciones.TABLENAME+".nombre_producto,"+AutorizarRequisicionesConstantesFunciones.SCHEMA+"."+AutorizarRequisicionesConstantesFunciones.TABLENAME+".cantidad,"+AutorizarRequisicionesConstantesFunciones.SCHEMA+"."+AutorizarRequisicionesConstantesFunciones.TABLENAME+".fecha_autoriza from "+AutorizarRequisicionesConstantesFunciones.SCHEMA+"."+AutorizarRequisicionesConstantesFunciones.TABLENAME;//+" as "+AutorizarRequisicionesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String CODIGOTIPOREQUISICION= "codigo_tipo_requisicion";
    public static final String CODIGO= "codigo";
    public static final String FECHA= "fecha";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String NOMBREBODEGA= "nombre_bodega";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String CANTIDAD= "cantidad";
    public static final String FECHAAUTORIZA= "fecha_autoriza";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_CODIGOTIPOREQUISICION= "Codigo Tipo Requisicion";
		public static final String LABEL_CODIGOTIPOREQUISICION_LOWER= "Codigo Tipo Requisicion";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_NOMBREBODEGA= "Nombre Bodega";
		public static final String LABEL_NOMBREBODEGA_LOWER= "Nombre Bodega";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_FECHAAUTORIZA= "Fecha Autoriza";
		public static final String LABEL_FECHAAUTORIZA_LOWER= "Fecha Autoriza";
	
		
		
		
		
		
		
	public static final String SREGEXCODIGO_TIPO_REQUISICION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_TIPO_REQUISICION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_BODEGA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BODEGA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getAutorizarRequisicionesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AutorizarRequisicionesConstantesFunciones.IDEMPRESA)) {sLabelColumna=AutorizarRequisicionesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AutorizarRequisicionesConstantesFunciones.IDSUCURSAL)) {sLabelColumna=AutorizarRequisicionesConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(AutorizarRequisicionesConstantesFunciones.FECHADESDE)) {sLabelColumna=AutorizarRequisicionesConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(AutorizarRequisicionesConstantesFunciones.FECHAHASTA)) {sLabelColumna=AutorizarRequisicionesConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(AutorizarRequisicionesConstantesFunciones.CODIGOTIPOREQUISICION)) {sLabelColumna=AutorizarRequisicionesConstantesFunciones.LABEL_CODIGOTIPOREQUISICION;}
		if(sNombreColumna.equals(AutorizarRequisicionesConstantesFunciones.CODIGO)) {sLabelColumna=AutorizarRequisicionesConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(AutorizarRequisicionesConstantesFunciones.FECHA)) {sLabelColumna=AutorizarRequisicionesConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(AutorizarRequisicionesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=AutorizarRequisicionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(AutorizarRequisicionesConstantesFunciones.NOMBREBODEGA)) {sLabelColumna=AutorizarRequisicionesConstantesFunciones.LABEL_NOMBREBODEGA;}
		if(sNombreColumna.equals(AutorizarRequisicionesConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=AutorizarRequisicionesConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(AutorizarRequisicionesConstantesFunciones.CANTIDAD)) {sLabelColumna=AutorizarRequisicionesConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(AutorizarRequisicionesConstantesFunciones.FECHAAUTORIZA)) {sLabelColumna=AutorizarRequisicionesConstantesFunciones.LABEL_FECHAAUTORIZA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getAutorizarRequisicionesDescripcion(AutorizarRequisiciones autorizarrequisiciones) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(autorizarrequisiciones !=null/* && autorizarrequisiciones.getId()!=0*/) {
			sDescripcion=autorizarrequisiciones.getcodigo();//autorizarrequisicionesautorizarrequisiciones.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getAutorizarRequisicionesDescripcionDetallado(AutorizarRequisiciones autorizarrequisiciones) {
		String sDescripcion="";
			
		sDescripcion+=AutorizarRequisicionesConstantesFunciones.ID+"=";
		sDescripcion+=autorizarrequisiciones.getId().toString()+",";
		sDescripcion+=AutorizarRequisicionesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=autorizarrequisiciones.getVersionRow().toString()+",";
		sDescripcion+=AutorizarRequisicionesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=autorizarrequisiciones.getid_empresa().toString()+",";
		sDescripcion+=AutorizarRequisicionesConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=autorizarrequisiciones.getid_sucursal().toString()+",";
		sDescripcion+=AutorizarRequisicionesConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=autorizarrequisiciones.getfecha_desde().toString()+",";
		sDescripcion+=AutorizarRequisicionesConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=autorizarrequisiciones.getfecha_hasta().toString()+",";
		sDescripcion+=AutorizarRequisicionesConstantesFunciones.CODIGOTIPOREQUISICION+"=";
		sDescripcion+=autorizarrequisiciones.getcodigo_tipo_requisicion()+",";
		sDescripcion+=AutorizarRequisicionesConstantesFunciones.CODIGO+"=";
		sDescripcion+=autorizarrequisiciones.getcodigo()+",";
		sDescripcion+=AutorizarRequisicionesConstantesFunciones.FECHA+"=";
		sDescripcion+=autorizarrequisiciones.getfecha().toString()+",";
		sDescripcion+=AutorizarRequisicionesConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=autorizarrequisiciones.getnombre_completo_cliente()+",";
		sDescripcion+=AutorizarRequisicionesConstantesFunciones.NOMBREBODEGA+"=";
		sDescripcion+=autorizarrequisiciones.getnombre_bodega()+",";
		sDescripcion+=AutorizarRequisicionesConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=autorizarrequisiciones.getnombre_producto()+",";
		sDescripcion+=AutorizarRequisicionesConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=autorizarrequisiciones.getcantidad().toString()+",";
		sDescripcion+=AutorizarRequisicionesConstantesFunciones.FECHAAUTORIZA+"=";
		sDescripcion+=autorizarrequisiciones.getfecha_autoriza().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setAutorizarRequisicionesDescripcion(AutorizarRequisiciones autorizarrequisiciones,String sValor) throws Exception {			
		if(autorizarrequisiciones !=null) {
			autorizarrequisiciones.setcodigo(sValor);;//autorizarrequisicionesautorizarrequisiciones.getcodigo().trim();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaAutorizarRequisiciones")) {
			sNombreIndice="Tipo=  Por Fecha Desde Por Fecha Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaAutorizarRequisiciones(Date fecha_desde,Date fecha_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_desde!=null) {sDetalleIndice+=" Fecha Desde="+fecha_desde.toString();}
		if(fecha_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAutorizarRequisiciones(AutorizarRequisiciones autorizarrequisiciones,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		autorizarrequisiciones.setcodigo_tipo_requisicion(autorizarrequisiciones.getcodigo_tipo_requisicion().trim());
		autorizarrequisiciones.setcodigo(autorizarrequisiciones.getcodigo().trim());
		autorizarrequisiciones.setnombre_completo_cliente(autorizarrequisiciones.getnombre_completo_cliente().trim());
		autorizarrequisiciones.setnombre_bodega(autorizarrequisiciones.getnombre_bodega().trim());
		autorizarrequisiciones.setnombre_producto(autorizarrequisiciones.getnombre_producto().trim());
	}
	
	public static void quitarEspaciosAutorizarRequisicioness(List<AutorizarRequisiciones> autorizarrequisicioness,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AutorizarRequisiciones autorizarrequisiciones: autorizarrequisicioness) {
			autorizarrequisiciones.setcodigo_tipo_requisicion(autorizarrequisiciones.getcodigo_tipo_requisicion().trim());
			autorizarrequisiciones.setcodigo(autorizarrequisiciones.getcodigo().trim());
			autorizarrequisiciones.setnombre_completo_cliente(autorizarrequisiciones.getnombre_completo_cliente().trim());
			autorizarrequisiciones.setnombre_bodega(autorizarrequisiciones.getnombre_bodega().trim());
			autorizarrequisiciones.setnombre_producto(autorizarrequisiciones.getnombre_producto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAutorizarRequisiciones(AutorizarRequisiciones autorizarrequisiciones,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && autorizarrequisiciones.getConCambioAuxiliar()) {
			autorizarrequisiciones.setIsDeleted(autorizarrequisiciones.getIsDeletedAuxiliar());	
			autorizarrequisiciones.setIsNew(autorizarrequisiciones.getIsNewAuxiliar());	
			autorizarrequisiciones.setIsChanged(autorizarrequisiciones.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			autorizarrequisiciones.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			autorizarrequisiciones.setIsDeletedAuxiliar(false);	
			autorizarrequisiciones.setIsNewAuxiliar(false);	
			autorizarrequisiciones.setIsChangedAuxiliar(false);
			
			autorizarrequisiciones.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAutorizarRequisicioness(List<AutorizarRequisiciones> autorizarrequisicioness,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AutorizarRequisiciones autorizarrequisiciones : autorizarrequisicioness) {
			if(conAsignarBase && autorizarrequisiciones.getConCambioAuxiliar()) {
				autorizarrequisiciones.setIsDeleted(autorizarrequisiciones.getIsDeletedAuxiliar());	
				autorizarrequisiciones.setIsNew(autorizarrequisiciones.getIsNewAuxiliar());	
				autorizarrequisiciones.setIsChanged(autorizarrequisiciones.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				autorizarrequisiciones.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				autorizarrequisiciones.setIsDeletedAuxiliar(false);	
				autorizarrequisiciones.setIsNewAuxiliar(false);	
				autorizarrequisiciones.setIsChangedAuxiliar(false);
				
				autorizarrequisiciones.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAutorizarRequisiciones(AutorizarRequisiciones autorizarrequisiciones,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			autorizarrequisiciones.setcantidad(0L);
		}
	}		
	
	public static void InicializarValoresAutorizarRequisicioness(List<AutorizarRequisiciones> autorizarrequisicioness,Boolean conEnteros) throws Exception  {
		
		for(AutorizarRequisiciones autorizarrequisiciones: autorizarrequisicioness) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				autorizarrequisiciones.setcantidad(0L);
			}
		}				
	}
	
	public static void TotalizarValoresFilaAutorizarRequisiciones(List<AutorizarRequisiciones> autorizarrequisicioness,AutorizarRequisiciones autorizarrequisicionesAux) throws Exception  {
		AutorizarRequisicionesConstantesFunciones.InicializarValoresAutorizarRequisiciones(autorizarrequisicionesAux,true);
		
		for(AutorizarRequisiciones autorizarrequisiciones: autorizarrequisicioness) {
			if(autorizarrequisiciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			autorizarrequisicionesAux.setcantidad(autorizarrequisicionesAux.getcantidad()+autorizarrequisiciones.getcantidad());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAutorizarRequisiciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AutorizarRequisicionesConstantesFunciones.getArrayColumnasGlobalesAutorizarRequisiciones(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAutorizarRequisiciones(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutorizarRequisicionesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutorizarRequisicionesConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutorizarRequisicionesConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutorizarRequisicionesConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAutorizarRequisiciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AutorizarRequisiciones> autorizarrequisicioness,AutorizarRequisiciones autorizarrequisiciones,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AutorizarRequisiciones autorizarrequisicionesAux: autorizarrequisicioness) {
			if(autorizarrequisicionesAux!=null && autorizarrequisiciones!=null) {
				if((autorizarrequisicionesAux.getId()==null && autorizarrequisiciones.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(autorizarrequisicionesAux.getId()!=null && autorizarrequisiciones.getId()!=null){
					if(autorizarrequisicionesAux.getId().equals(autorizarrequisiciones.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAutorizarRequisiciones(List<AutorizarRequisiciones> autorizarrequisicioness) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(AutorizarRequisiciones autorizarrequisiciones: autorizarrequisicioness) {			
			if(autorizarrequisiciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAutorizarRequisiciones() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AutorizarRequisicionesConstantesFunciones.LABEL_ID, AutorizarRequisicionesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutorizarRequisicionesConstantesFunciones.LABEL_VERSIONROW, AutorizarRequisicionesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutorizarRequisicionesConstantesFunciones.LABEL_CODIGOTIPOREQUISICION, AutorizarRequisicionesConstantesFunciones.CODIGOTIPOREQUISICION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutorizarRequisicionesConstantesFunciones.LABEL_CODIGO, AutorizarRequisicionesConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutorizarRequisicionesConstantesFunciones.LABEL_FECHA, AutorizarRequisicionesConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutorizarRequisicionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, AutorizarRequisicionesConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutorizarRequisicionesConstantesFunciones.LABEL_NOMBREBODEGA, AutorizarRequisicionesConstantesFunciones.NOMBREBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutorizarRequisicionesConstantesFunciones.LABEL_NOMBREPRODUCTO, AutorizarRequisicionesConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutorizarRequisicionesConstantesFunciones.LABEL_CANTIDAD, AutorizarRequisicionesConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutorizarRequisicionesConstantesFunciones.LABEL_FECHAAUTORIZA, AutorizarRequisicionesConstantesFunciones.FECHAAUTORIZA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAutorizarRequisiciones() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AutorizarRequisicionesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutorizarRequisicionesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutorizarRequisicionesConstantesFunciones.CODIGOTIPOREQUISICION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutorizarRequisicionesConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutorizarRequisicionesConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutorizarRequisicionesConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutorizarRequisicionesConstantesFunciones.NOMBREBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutorizarRequisicionesConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutorizarRequisicionesConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutorizarRequisicionesConstantesFunciones.FECHAAUTORIZA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutorizarRequisiciones() throws Exception  {
		return AutorizarRequisicionesConstantesFunciones.getTiposSeleccionarAutorizarRequisiciones(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutorizarRequisiciones(Boolean conFk) throws Exception  {
		return AutorizarRequisicionesConstantesFunciones.getTiposSeleccionarAutorizarRequisiciones(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutorizarRequisiciones(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutorizarRequisicionesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AutorizarRequisicionesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutorizarRequisicionesConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(AutorizarRequisicionesConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutorizarRequisicionesConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(AutorizarRequisicionesConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutorizarRequisicionesConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(AutorizarRequisicionesConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutorizarRequisicionesConstantesFunciones.LABEL_CODIGOTIPOREQUISICION);
			reporte.setsDescripcion(AutorizarRequisicionesConstantesFunciones.LABEL_CODIGOTIPOREQUISICION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutorizarRequisicionesConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(AutorizarRequisicionesConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutorizarRequisicionesConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(AutorizarRequisicionesConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutorizarRequisicionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(AutorizarRequisicionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutorizarRequisicionesConstantesFunciones.LABEL_NOMBREBODEGA);
			reporte.setsDescripcion(AutorizarRequisicionesConstantesFunciones.LABEL_NOMBREBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutorizarRequisicionesConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(AutorizarRequisicionesConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutorizarRequisicionesConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(AutorizarRequisicionesConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutorizarRequisicionesConstantesFunciones.LABEL_FECHAAUTORIZA);
			reporte.setsDescripcion(AutorizarRequisicionesConstantesFunciones.LABEL_FECHAAUTORIZA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAutorizarRequisiciones(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAutorizarRequisiciones(AutorizarRequisiciones autorizarrequisicionesAux) throws Exception {
		
			autorizarrequisicionesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(autorizarrequisicionesAux.getEmpresa()));
			autorizarrequisicionesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(autorizarrequisicionesAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAutorizarRequisiciones(List<AutorizarRequisiciones> autorizarrequisicionessTemp) throws Exception {
		for(AutorizarRequisiciones autorizarrequisicionesAux:autorizarrequisicionessTemp) {
			
			autorizarrequisicionesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(autorizarrequisicionesAux.getEmpresa()));
			autorizarrequisicionesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(autorizarrequisicionesAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAutorizarRequisiciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAutorizarRequisiciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAutorizarRequisiciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AutorizarRequisicionesConstantesFunciones.getClassesRelationshipsOfAutorizarRequisiciones(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAutorizarRequisiciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAutorizarRequisiciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AutorizarRequisicionesConstantesFunciones.getClassesRelationshipsFromStringsOfAutorizarRequisiciones(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAutorizarRequisiciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(AutorizarRequisiciones autorizarrequisiciones,List<AutorizarRequisiciones> autorizarrequisicioness,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(AutorizarRequisiciones autorizarrequisiciones,List<AutorizarRequisiciones> autorizarrequisicioness) throws Exception {
		try	{			
			for(AutorizarRequisiciones autorizarrequisicionesLocal:autorizarrequisicioness) {
				if(autorizarrequisicionesLocal.getId().equals(autorizarrequisiciones.getId())) {
					autorizarrequisicionesLocal.setIsSelected(autorizarrequisiciones.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAutorizarRequisiciones(List<AutorizarRequisiciones> autorizarrequisicionessAux) throws Exception {
		//this.autorizarrequisicionessAux=autorizarrequisicionessAux;
		
		for(AutorizarRequisiciones autorizarrequisicionesAux:autorizarrequisicionessAux) {
			if(autorizarrequisicionesAux.getIsChanged()) {
				autorizarrequisicionesAux.setIsChanged(false);
			}		
			
			if(autorizarrequisicionesAux.getIsNew()) {
				autorizarrequisicionesAux.setIsNew(false);
			}	
			
			if(autorizarrequisicionesAux.getIsDeleted()) {
				autorizarrequisicionesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAutorizarRequisiciones(AutorizarRequisiciones autorizarrequisicionesAux) throws Exception {
		//this.autorizarrequisicionesAux=autorizarrequisicionesAux;
		
			if(autorizarrequisicionesAux.getIsChanged()) {
				autorizarrequisicionesAux.setIsChanged(false);
			}		
			
			if(autorizarrequisicionesAux.getIsNew()) {
				autorizarrequisicionesAux.setIsNew(false);
			}	
			
			if(autorizarrequisicionesAux.getIsDeleted()) {
				autorizarrequisicionesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AutorizarRequisiciones autorizarrequisicionesAsignar,AutorizarRequisiciones autorizarrequisiciones) throws Exception {
		autorizarrequisicionesAsignar.setId(autorizarrequisiciones.getId());	
		autorizarrequisicionesAsignar.setVersionRow(autorizarrequisiciones.getVersionRow());	
		autorizarrequisicionesAsignar.setcodigo_tipo_requisicion(autorizarrequisiciones.getcodigo_tipo_requisicion());	
		autorizarrequisicionesAsignar.setcodigo(autorizarrequisiciones.getcodigo());	
		autorizarrequisicionesAsignar.setfecha(autorizarrequisiciones.getfecha());	
		autorizarrequisicionesAsignar.setnombre_completo_cliente(autorizarrequisiciones.getnombre_completo_cliente());	
		autorizarrequisicionesAsignar.setnombre_bodega(autorizarrequisiciones.getnombre_bodega());	
		autorizarrequisicionesAsignar.setnombre_producto(autorizarrequisiciones.getnombre_producto());	
		autorizarrequisicionesAsignar.setcantidad(autorizarrequisiciones.getcantidad());	
		autorizarrequisicionesAsignar.setfecha_autoriza(autorizarrequisiciones.getfecha_autoriza());	
	}
	
	public static void inicializarAutorizarRequisiciones(AutorizarRequisiciones autorizarrequisiciones) throws Exception {
		try {
				autorizarrequisiciones.setId(0L);	
					
				autorizarrequisiciones.setcodigo_tipo_requisicion("");	
				autorizarrequisiciones.setcodigo("");	
				autorizarrequisiciones.setfecha(new Date());	
				autorizarrequisiciones.setnombre_completo_cliente("");	
				autorizarrequisiciones.setnombre_bodega("");	
				autorizarrequisiciones.setnombre_producto("");	
				autorizarrequisiciones.setcantidad(0L);	
				autorizarrequisiciones.setfecha_autoriza(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAutorizarRequisiciones(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AutorizarRequisicionesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutorizarRequisicionesConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutorizarRequisicionesConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutorizarRequisicionesConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutorizarRequisicionesConstantesFunciones.LABEL_CODIGOTIPOREQUISICION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutorizarRequisicionesConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutorizarRequisicionesConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutorizarRequisicionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutorizarRequisicionesConstantesFunciones.LABEL_NOMBREBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutorizarRequisicionesConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutorizarRequisicionesConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutorizarRequisicionesConstantesFunciones.LABEL_FECHAAUTORIZA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAutorizarRequisiciones(String sTipo,Row row,Workbook workbook,AutorizarRequisiciones autorizarrequisiciones,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(autorizarrequisiciones.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autorizarrequisiciones.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autorizarrequisiciones.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autorizarrequisiciones.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autorizarrequisiciones.getcodigo_tipo_requisicion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autorizarrequisiciones.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autorizarrequisiciones.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autorizarrequisiciones.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autorizarrequisiciones.getnombre_bodega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autorizarrequisiciones.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autorizarrequisiciones.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autorizarrequisiciones.getfecha_autoriza());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAutorizarRequisiciones="";
	
	public String getsFinalQueryAutorizarRequisiciones() {
		return this.sFinalQueryAutorizarRequisiciones;
	}
	
	public void setsFinalQueryAutorizarRequisiciones(String sFinalQueryAutorizarRequisiciones) {
		this.sFinalQueryAutorizarRequisiciones= sFinalQueryAutorizarRequisiciones;
	}
	
	public Border resaltarSeleccionarAutorizarRequisiciones=null;
	
	public Border setResaltarSeleccionarAutorizarRequisiciones(ParametroGeneralUsuario parametroGeneralUsuario/*AutorizarRequisicionesBeanSwingJInternalFrame autorizarrequisicionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//autorizarrequisicionesBeanSwingJInternalFrame.jTtoolBarAutorizarRequisiciones.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAutorizarRequisiciones= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAutorizarRequisiciones() {
		return this.resaltarSeleccionarAutorizarRequisiciones;
	}
	
	public void setResaltarSeleccionarAutorizarRequisiciones(Border borderResaltarSeleccionarAutorizarRequisiciones) {
		this.resaltarSeleccionarAutorizarRequisiciones= borderResaltarSeleccionarAutorizarRequisiciones;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAutorizarRequisiciones=null;
	public Boolean mostraridAutorizarRequisiciones=true;
	public Boolean activaridAutorizarRequisiciones=true;

	public Border resaltarid_empresaAutorizarRequisiciones=null;
	public Boolean mostrarid_empresaAutorizarRequisiciones=true;
	public Boolean activarid_empresaAutorizarRequisiciones=true;
	public Boolean cargarid_empresaAutorizarRequisiciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAutorizarRequisiciones=false;//ConEventDepend=true

	public Border resaltarid_sucursalAutorizarRequisiciones=null;
	public Boolean mostrarid_sucursalAutorizarRequisiciones=true;
	public Boolean activarid_sucursalAutorizarRequisiciones=true;
	public Boolean cargarid_sucursalAutorizarRequisiciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalAutorizarRequisiciones=false;//ConEventDepend=true

	public Border resaltarfecha_desdeAutorizarRequisiciones=null;
	public Boolean mostrarfecha_desdeAutorizarRequisiciones=true;
	public Boolean activarfecha_desdeAutorizarRequisiciones=true;

	public Border resaltarfecha_hastaAutorizarRequisiciones=null;
	public Boolean mostrarfecha_hastaAutorizarRequisiciones=true;
	public Boolean activarfecha_hastaAutorizarRequisiciones=true;

	public Border resaltarcodigo_tipo_requisicionAutorizarRequisiciones=null;
	public Boolean mostrarcodigo_tipo_requisicionAutorizarRequisiciones=true;
	public Boolean activarcodigo_tipo_requisicionAutorizarRequisiciones=true;

	public Border resaltarcodigoAutorizarRequisiciones=null;
	public Boolean mostrarcodigoAutorizarRequisiciones=true;
	public Boolean activarcodigoAutorizarRequisiciones=true;

	public Border resaltarfechaAutorizarRequisiciones=null;
	public Boolean mostrarfechaAutorizarRequisiciones=true;
	public Boolean activarfechaAutorizarRequisiciones=true;

	public Border resaltarnombre_completo_clienteAutorizarRequisiciones=null;
	public Boolean mostrarnombre_completo_clienteAutorizarRequisiciones=true;
	public Boolean activarnombre_completo_clienteAutorizarRequisiciones=true;

	public Border resaltarnombre_bodegaAutorizarRequisiciones=null;
	public Boolean mostrarnombre_bodegaAutorizarRequisiciones=true;
	public Boolean activarnombre_bodegaAutorizarRequisiciones=true;

	public Border resaltarnombre_productoAutorizarRequisiciones=null;
	public Boolean mostrarnombre_productoAutorizarRequisiciones=true;
	public Boolean activarnombre_productoAutorizarRequisiciones=true;

	public Border resaltarcantidadAutorizarRequisiciones=null;
	public Boolean mostrarcantidadAutorizarRequisiciones=true;
	public Boolean activarcantidadAutorizarRequisiciones=true;

	public Border resaltarfecha_autorizaAutorizarRequisiciones=null;
	public Boolean mostrarfecha_autorizaAutorizarRequisiciones=true;
	public Boolean activarfecha_autorizaAutorizarRequisiciones=true;

	
	

	public Border setResaltaridAutorizarRequisiciones(ParametroGeneralUsuario parametroGeneralUsuario/*AutorizarRequisicionesBeanSwingJInternalFrame autorizarrequisicionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorizarrequisicionesBeanSwingJInternalFrame.jTtoolBarAutorizarRequisiciones.setBorder(borderResaltar);
		
		this.resaltaridAutorizarRequisiciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAutorizarRequisiciones() {
		return this.resaltaridAutorizarRequisiciones;
	}

	public void setResaltaridAutorizarRequisiciones(Border borderResaltar) {
		this.resaltaridAutorizarRequisiciones= borderResaltar;
	}

	public Boolean getMostraridAutorizarRequisiciones() {
		return this.mostraridAutorizarRequisiciones;
	}

	public void setMostraridAutorizarRequisiciones(Boolean mostraridAutorizarRequisiciones) {
		this.mostraridAutorizarRequisiciones= mostraridAutorizarRequisiciones;
	}

	public Boolean getActivaridAutorizarRequisiciones() {
		return this.activaridAutorizarRequisiciones;
	}

	public void setActivaridAutorizarRequisiciones(Boolean activaridAutorizarRequisiciones) {
		this.activaridAutorizarRequisiciones= activaridAutorizarRequisiciones;
	}

	public Border setResaltarid_empresaAutorizarRequisiciones(ParametroGeneralUsuario parametroGeneralUsuario/*AutorizarRequisicionesBeanSwingJInternalFrame autorizarrequisicionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorizarrequisicionesBeanSwingJInternalFrame.jTtoolBarAutorizarRequisiciones.setBorder(borderResaltar);
		
		this.resaltarid_empresaAutorizarRequisiciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAutorizarRequisiciones() {
		return this.resaltarid_empresaAutorizarRequisiciones;
	}

	public void setResaltarid_empresaAutorizarRequisiciones(Border borderResaltar) {
		this.resaltarid_empresaAutorizarRequisiciones= borderResaltar;
	}

	public Boolean getMostrarid_empresaAutorizarRequisiciones() {
		return this.mostrarid_empresaAutorizarRequisiciones;
	}

	public void setMostrarid_empresaAutorizarRequisiciones(Boolean mostrarid_empresaAutorizarRequisiciones) {
		this.mostrarid_empresaAutorizarRequisiciones= mostrarid_empresaAutorizarRequisiciones;
	}

	public Boolean getActivarid_empresaAutorizarRequisiciones() {
		return this.activarid_empresaAutorizarRequisiciones;
	}

	public void setActivarid_empresaAutorizarRequisiciones(Boolean activarid_empresaAutorizarRequisiciones) {
		this.activarid_empresaAutorizarRequisiciones= activarid_empresaAutorizarRequisiciones;
	}

	public Boolean getCargarid_empresaAutorizarRequisiciones() {
		return this.cargarid_empresaAutorizarRequisiciones;
	}

	public void setCargarid_empresaAutorizarRequisiciones(Boolean cargarid_empresaAutorizarRequisiciones) {
		this.cargarid_empresaAutorizarRequisiciones= cargarid_empresaAutorizarRequisiciones;
	}

	public Border setResaltarid_sucursalAutorizarRequisiciones(ParametroGeneralUsuario parametroGeneralUsuario/*AutorizarRequisicionesBeanSwingJInternalFrame autorizarrequisicionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorizarrequisicionesBeanSwingJInternalFrame.jTtoolBarAutorizarRequisiciones.setBorder(borderResaltar);
		
		this.resaltarid_sucursalAutorizarRequisiciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalAutorizarRequisiciones() {
		return this.resaltarid_sucursalAutorizarRequisiciones;
	}

	public void setResaltarid_sucursalAutorizarRequisiciones(Border borderResaltar) {
		this.resaltarid_sucursalAutorizarRequisiciones= borderResaltar;
	}

	public Boolean getMostrarid_sucursalAutorizarRequisiciones() {
		return this.mostrarid_sucursalAutorizarRequisiciones;
	}

	public void setMostrarid_sucursalAutorizarRequisiciones(Boolean mostrarid_sucursalAutorizarRequisiciones) {
		this.mostrarid_sucursalAutorizarRequisiciones= mostrarid_sucursalAutorizarRequisiciones;
	}

	public Boolean getActivarid_sucursalAutorizarRequisiciones() {
		return this.activarid_sucursalAutorizarRequisiciones;
	}

	public void setActivarid_sucursalAutorizarRequisiciones(Boolean activarid_sucursalAutorizarRequisiciones) {
		this.activarid_sucursalAutorizarRequisiciones= activarid_sucursalAutorizarRequisiciones;
	}

	public Boolean getCargarid_sucursalAutorizarRequisiciones() {
		return this.cargarid_sucursalAutorizarRequisiciones;
	}

	public void setCargarid_sucursalAutorizarRequisiciones(Boolean cargarid_sucursalAutorizarRequisiciones) {
		this.cargarid_sucursalAutorizarRequisiciones= cargarid_sucursalAutorizarRequisiciones;
	}

	public Border setResaltarfecha_desdeAutorizarRequisiciones(ParametroGeneralUsuario parametroGeneralUsuario/*AutorizarRequisicionesBeanSwingJInternalFrame autorizarrequisicionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorizarrequisicionesBeanSwingJInternalFrame.jTtoolBarAutorizarRequisiciones.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeAutorizarRequisiciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeAutorizarRequisiciones() {
		return this.resaltarfecha_desdeAutorizarRequisiciones;
	}

	public void setResaltarfecha_desdeAutorizarRequisiciones(Border borderResaltar) {
		this.resaltarfecha_desdeAutorizarRequisiciones= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeAutorizarRequisiciones() {
		return this.mostrarfecha_desdeAutorizarRequisiciones;
	}

	public void setMostrarfecha_desdeAutorizarRequisiciones(Boolean mostrarfecha_desdeAutorizarRequisiciones) {
		this.mostrarfecha_desdeAutorizarRequisiciones= mostrarfecha_desdeAutorizarRequisiciones;
	}

	public Boolean getActivarfecha_desdeAutorizarRequisiciones() {
		return this.activarfecha_desdeAutorizarRequisiciones;
	}

	public void setActivarfecha_desdeAutorizarRequisiciones(Boolean activarfecha_desdeAutorizarRequisiciones) {
		this.activarfecha_desdeAutorizarRequisiciones= activarfecha_desdeAutorizarRequisiciones;
	}

	public Border setResaltarfecha_hastaAutorizarRequisiciones(ParametroGeneralUsuario parametroGeneralUsuario/*AutorizarRequisicionesBeanSwingJInternalFrame autorizarrequisicionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorizarrequisicionesBeanSwingJInternalFrame.jTtoolBarAutorizarRequisiciones.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaAutorizarRequisiciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaAutorizarRequisiciones() {
		return this.resaltarfecha_hastaAutorizarRequisiciones;
	}

	public void setResaltarfecha_hastaAutorizarRequisiciones(Border borderResaltar) {
		this.resaltarfecha_hastaAutorizarRequisiciones= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaAutorizarRequisiciones() {
		return this.mostrarfecha_hastaAutorizarRequisiciones;
	}

	public void setMostrarfecha_hastaAutorizarRequisiciones(Boolean mostrarfecha_hastaAutorizarRequisiciones) {
		this.mostrarfecha_hastaAutorizarRequisiciones= mostrarfecha_hastaAutorizarRequisiciones;
	}

	public Boolean getActivarfecha_hastaAutorizarRequisiciones() {
		return this.activarfecha_hastaAutorizarRequisiciones;
	}

	public void setActivarfecha_hastaAutorizarRequisiciones(Boolean activarfecha_hastaAutorizarRequisiciones) {
		this.activarfecha_hastaAutorizarRequisiciones= activarfecha_hastaAutorizarRequisiciones;
	}

	public Border setResaltarcodigo_tipo_requisicionAutorizarRequisiciones(ParametroGeneralUsuario parametroGeneralUsuario/*AutorizarRequisicionesBeanSwingJInternalFrame autorizarrequisicionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorizarrequisicionesBeanSwingJInternalFrame.jTtoolBarAutorizarRequisiciones.setBorder(borderResaltar);
		
		this.resaltarcodigo_tipo_requisicionAutorizarRequisiciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_tipo_requisicionAutorizarRequisiciones() {
		return this.resaltarcodigo_tipo_requisicionAutorizarRequisiciones;
	}

	public void setResaltarcodigo_tipo_requisicionAutorizarRequisiciones(Border borderResaltar) {
		this.resaltarcodigo_tipo_requisicionAutorizarRequisiciones= borderResaltar;
	}

	public Boolean getMostrarcodigo_tipo_requisicionAutorizarRequisiciones() {
		return this.mostrarcodigo_tipo_requisicionAutorizarRequisiciones;
	}

	public void setMostrarcodigo_tipo_requisicionAutorizarRequisiciones(Boolean mostrarcodigo_tipo_requisicionAutorizarRequisiciones) {
		this.mostrarcodigo_tipo_requisicionAutorizarRequisiciones= mostrarcodigo_tipo_requisicionAutorizarRequisiciones;
	}

	public Boolean getActivarcodigo_tipo_requisicionAutorizarRequisiciones() {
		return this.activarcodigo_tipo_requisicionAutorizarRequisiciones;
	}

	public void setActivarcodigo_tipo_requisicionAutorizarRequisiciones(Boolean activarcodigo_tipo_requisicionAutorizarRequisiciones) {
		this.activarcodigo_tipo_requisicionAutorizarRequisiciones= activarcodigo_tipo_requisicionAutorizarRequisiciones;
	}

	public Border setResaltarcodigoAutorizarRequisiciones(ParametroGeneralUsuario parametroGeneralUsuario/*AutorizarRequisicionesBeanSwingJInternalFrame autorizarrequisicionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorizarrequisicionesBeanSwingJInternalFrame.jTtoolBarAutorizarRequisiciones.setBorder(borderResaltar);
		
		this.resaltarcodigoAutorizarRequisiciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoAutorizarRequisiciones() {
		return this.resaltarcodigoAutorizarRequisiciones;
	}

	public void setResaltarcodigoAutorizarRequisiciones(Border borderResaltar) {
		this.resaltarcodigoAutorizarRequisiciones= borderResaltar;
	}

	public Boolean getMostrarcodigoAutorizarRequisiciones() {
		return this.mostrarcodigoAutorizarRequisiciones;
	}

	public void setMostrarcodigoAutorizarRequisiciones(Boolean mostrarcodigoAutorizarRequisiciones) {
		this.mostrarcodigoAutorizarRequisiciones= mostrarcodigoAutorizarRequisiciones;
	}

	public Boolean getActivarcodigoAutorizarRequisiciones() {
		return this.activarcodigoAutorizarRequisiciones;
	}

	public void setActivarcodigoAutorizarRequisiciones(Boolean activarcodigoAutorizarRequisiciones) {
		this.activarcodigoAutorizarRequisiciones= activarcodigoAutorizarRequisiciones;
	}

	public Border setResaltarfechaAutorizarRequisiciones(ParametroGeneralUsuario parametroGeneralUsuario/*AutorizarRequisicionesBeanSwingJInternalFrame autorizarrequisicionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorizarrequisicionesBeanSwingJInternalFrame.jTtoolBarAutorizarRequisiciones.setBorder(borderResaltar);
		
		this.resaltarfechaAutorizarRequisiciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaAutorizarRequisiciones() {
		return this.resaltarfechaAutorizarRequisiciones;
	}

	public void setResaltarfechaAutorizarRequisiciones(Border borderResaltar) {
		this.resaltarfechaAutorizarRequisiciones= borderResaltar;
	}

	public Boolean getMostrarfechaAutorizarRequisiciones() {
		return this.mostrarfechaAutorizarRequisiciones;
	}

	public void setMostrarfechaAutorizarRequisiciones(Boolean mostrarfechaAutorizarRequisiciones) {
		this.mostrarfechaAutorizarRequisiciones= mostrarfechaAutorizarRequisiciones;
	}

	public Boolean getActivarfechaAutorizarRequisiciones() {
		return this.activarfechaAutorizarRequisiciones;
	}

	public void setActivarfechaAutorizarRequisiciones(Boolean activarfechaAutorizarRequisiciones) {
		this.activarfechaAutorizarRequisiciones= activarfechaAutorizarRequisiciones;
	}

	public Border setResaltarnombre_completo_clienteAutorizarRequisiciones(ParametroGeneralUsuario parametroGeneralUsuario/*AutorizarRequisicionesBeanSwingJInternalFrame autorizarrequisicionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorizarrequisicionesBeanSwingJInternalFrame.jTtoolBarAutorizarRequisiciones.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteAutorizarRequisiciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteAutorizarRequisiciones() {
		return this.resaltarnombre_completo_clienteAutorizarRequisiciones;
	}

	public void setResaltarnombre_completo_clienteAutorizarRequisiciones(Border borderResaltar) {
		this.resaltarnombre_completo_clienteAutorizarRequisiciones= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteAutorizarRequisiciones() {
		return this.mostrarnombre_completo_clienteAutorizarRequisiciones;
	}

	public void setMostrarnombre_completo_clienteAutorizarRequisiciones(Boolean mostrarnombre_completo_clienteAutorizarRequisiciones) {
		this.mostrarnombre_completo_clienteAutorizarRequisiciones= mostrarnombre_completo_clienteAutorizarRequisiciones;
	}

	public Boolean getActivarnombre_completo_clienteAutorizarRequisiciones() {
		return this.activarnombre_completo_clienteAutorizarRequisiciones;
	}

	public void setActivarnombre_completo_clienteAutorizarRequisiciones(Boolean activarnombre_completo_clienteAutorizarRequisiciones) {
		this.activarnombre_completo_clienteAutorizarRequisiciones= activarnombre_completo_clienteAutorizarRequisiciones;
	}

	public Border setResaltarnombre_bodegaAutorizarRequisiciones(ParametroGeneralUsuario parametroGeneralUsuario/*AutorizarRequisicionesBeanSwingJInternalFrame autorizarrequisicionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorizarrequisicionesBeanSwingJInternalFrame.jTtoolBarAutorizarRequisiciones.setBorder(borderResaltar);
		
		this.resaltarnombre_bodegaAutorizarRequisiciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bodegaAutorizarRequisiciones() {
		return this.resaltarnombre_bodegaAutorizarRequisiciones;
	}

	public void setResaltarnombre_bodegaAutorizarRequisiciones(Border borderResaltar) {
		this.resaltarnombre_bodegaAutorizarRequisiciones= borderResaltar;
	}

	public Boolean getMostrarnombre_bodegaAutorizarRequisiciones() {
		return this.mostrarnombre_bodegaAutorizarRequisiciones;
	}

	public void setMostrarnombre_bodegaAutorizarRequisiciones(Boolean mostrarnombre_bodegaAutorizarRequisiciones) {
		this.mostrarnombre_bodegaAutorizarRequisiciones= mostrarnombre_bodegaAutorizarRequisiciones;
	}

	public Boolean getActivarnombre_bodegaAutorizarRequisiciones() {
		return this.activarnombre_bodegaAutorizarRequisiciones;
	}

	public void setActivarnombre_bodegaAutorizarRequisiciones(Boolean activarnombre_bodegaAutorizarRequisiciones) {
		this.activarnombre_bodegaAutorizarRequisiciones= activarnombre_bodegaAutorizarRequisiciones;
	}

	public Border setResaltarnombre_productoAutorizarRequisiciones(ParametroGeneralUsuario parametroGeneralUsuario/*AutorizarRequisicionesBeanSwingJInternalFrame autorizarrequisicionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorizarrequisicionesBeanSwingJInternalFrame.jTtoolBarAutorizarRequisiciones.setBorder(borderResaltar);
		
		this.resaltarnombre_productoAutorizarRequisiciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoAutorizarRequisiciones() {
		return this.resaltarnombre_productoAutorizarRequisiciones;
	}

	public void setResaltarnombre_productoAutorizarRequisiciones(Border borderResaltar) {
		this.resaltarnombre_productoAutorizarRequisiciones= borderResaltar;
	}

	public Boolean getMostrarnombre_productoAutorizarRequisiciones() {
		return this.mostrarnombre_productoAutorizarRequisiciones;
	}

	public void setMostrarnombre_productoAutorizarRequisiciones(Boolean mostrarnombre_productoAutorizarRequisiciones) {
		this.mostrarnombre_productoAutorizarRequisiciones= mostrarnombre_productoAutorizarRequisiciones;
	}

	public Boolean getActivarnombre_productoAutorizarRequisiciones() {
		return this.activarnombre_productoAutorizarRequisiciones;
	}

	public void setActivarnombre_productoAutorizarRequisiciones(Boolean activarnombre_productoAutorizarRequisiciones) {
		this.activarnombre_productoAutorizarRequisiciones= activarnombre_productoAutorizarRequisiciones;
	}

	public Border setResaltarcantidadAutorizarRequisiciones(ParametroGeneralUsuario parametroGeneralUsuario/*AutorizarRequisicionesBeanSwingJInternalFrame autorizarrequisicionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorizarrequisicionesBeanSwingJInternalFrame.jTtoolBarAutorizarRequisiciones.setBorder(borderResaltar);
		
		this.resaltarcantidadAutorizarRequisiciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadAutorizarRequisiciones() {
		return this.resaltarcantidadAutorizarRequisiciones;
	}

	public void setResaltarcantidadAutorizarRequisiciones(Border borderResaltar) {
		this.resaltarcantidadAutorizarRequisiciones= borderResaltar;
	}

	public Boolean getMostrarcantidadAutorizarRequisiciones() {
		return this.mostrarcantidadAutorizarRequisiciones;
	}

	public void setMostrarcantidadAutorizarRequisiciones(Boolean mostrarcantidadAutorizarRequisiciones) {
		this.mostrarcantidadAutorizarRequisiciones= mostrarcantidadAutorizarRequisiciones;
	}

	public Boolean getActivarcantidadAutorizarRequisiciones() {
		return this.activarcantidadAutorizarRequisiciones;
	}

	public void setActivarcantidadAutorizarRequisiciones(Boolean activarcantidadAutorizarRequisiciones) {
		this.activarcantidadAutorizarRequisiciones= activarcantidadAutorizarRequisiciones;
	}

	public Border setResaltarfecha_autorizaAutorizarRequisiciones(ParametroGeneralUsuario parametroGeneralUsuario/*AutorizarRequisicionesBeanSwingJInternalFrame autorizarrequisicionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autorizarrequisicionesBeanSwingJInternalFrame.jTtoolBarAutorizarRequisiciones.setBorder(borderResaltar);
		
		this.resaltarfecha_autorizaAutorizarRequisiciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_autorizaAutorizarRequisiciones() {
		return this.resaltarfecha_autorizaAutorizarRequisiciones;
	}

	public void setResaltarfecha_autorizaAutorizarRequisiciones(Border borderResaltar) {
		this.resaltarfecha_autorizaAutorizarRequisiciones= borderResaltar;
	}

	public Boolean getMostrarfecha_autorizaAutorizarRequisiciones() {
		return this.mostrarfecha_autorizaAutorizarRequisiciones;
	}

	public void setMostrarfecha_autorizaAutorizarRequisiciones(Boolean mostrarfecha_autorizaAutorizarRequisiciones) {
		this.mostrarfecha_autorizaAutorizarRequisiciones= mostrarfecha_autorizaAutorizarRequisiciones;
	}

	public Boolean getActivarfecha_autorizaAutorizarRequisiciones() {
		return this.activarfecha_autorizaAutorizarRequisiciones;
	}

	public void setActivarfecha_autorizaAutorizarRequisiciones(Boolean activarfecha_autorizaAutorizarRequisiciones) {
		this.activarfecha_autorizaAutorizarRequisiciones= activarfecha_autorizaAutorizarRequisiciones;
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
		
		
		this.setMostraridAutorizarRequisiciones(esInicial);
		this.setMostrarid_empresaAutorizarRequisiciones(esInicial);
		this.setMostrarid_sucursalAutorizarRequisiciones(esInicial);
		this.setMostrarfecha_desdeAutorizarRequisiciones(esInicial);
		this.setMostrarfecha_hastaAutorizarRequisiciones(esInicial);
		this.setMostrarcodigo_tipo_requisicionAutorizarRequisiciones(esInicial);
		this.setMostrarcodigoAutorizarRequisiciones(esInicial);
		this.setMostrarfechaAutorizarRequisiciones(esInicial);
		this.setMostrarnombre_completo_clienteAutorizarRequisiciones(esInicial);
		this.setMostrarnombre_bodegaAutorizarRequisiciones(esInicial);
		this.setMostrarnombre_productoAutorizarRequisiciones(esInicial);
		this.setMostrarcantidadAutorizarRequisiciones(esInicial);
		this.setMostrarfecha_autorizaAutorizarRequisiciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.ID)) {
				this.setMostraridAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.CODIGOTIPOREQUISICION)) {
				this.setMostrarcodigo_tipo_requisicionAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.FECHA)) {
				this.setMostrarfechaAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.NOMBREBODEGA)) {
				this.setMostrarnombre_bodegaAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.FECHAAUTORIZA)) {
				this.setMostrarfecha_autorizaAutorizarRequisiciones(esAsigna);
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
		
		
		this.setActivaridAutorizarRequisiciones(esInicial);
		this.setActivarid_empresaAutorizarRequisiciones(esInicial);
		this.setActivarid_sucursalAutorizarRequisiciones(esInicial);
		this.setActivarfecha_desdeAutorizarRequisiciones(esInicial);
		this.setActivarfecha_hastaAutorizarRequisiciones(esInicial);
		this.setActivarcodigo_tipo_requisicionAutorizarRequisiciones(esInicial);
		this.setActivarcodigoAutorizarRequisiciones(esInicial);
		this.setActivarfechaAutorizarRequisiciones(esInicial);
		this.setActivarnombre_completo_clienteAutorizarRequisiciones(esInicial);
		this.setActivarnombre_bodegaAutorizarRequisiciones(esInicial);
		this.setActivarnombre_productoAutorizarRequisiciones(esInicial);
		this.setActivarcantidadAutorizarRequisiciones(esInicial);
		this.setActivarfecha_autorizaAutorizarRequisiciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.ID)) {
				this.setActivaridAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.CODIGOTIPOREQUISICION)) {
				this.setActivarcodigo_tipo_requisicionAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.CODIGO)) {
				this.setActivarcodigoAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.FECHA)) {
				this.setActivarfechaAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.NOMBREBODEGA)) {
				this.setActivarnombre_bodegaAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.FECHAAUTORIZA)) {
				this.setActivarfecha_autorizaAutorizarRequisiciones(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AutorizarRequisicionesBeanSwingJInternalFrame autorizarrequisicionesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAutorizarRequisiciones(esInicial);
		this.setResaltarid_empresaAutorizarRequisiciones(esInicial);
		this.setResaltarid_sucursalAutorizarRequisiciones(esInicial);
		this.setResaltarfecha_desdeAutorizarRequisiciones(esInicial);
		this.setResaltarfecha_hastaAutorizarRequisiciones(esInicial);
		this.setResaltarcodigo_tipo_requisicionAutorizarRequisiciones(esInicial);
		this.setResaltarcodigoAutorizarRequisiciones(esInicial);
		this.setResaltarfechaAutorizarRequisiciones(esInicial);
		this.setResaltarnombre_completo_clienteAutorizarRequisiciones(esInicial);
		this.setResaltarnombre_bodegaAutorizarRequisiciones(esInicial);
		this.setResaltarnombre_productoAutorizarRequisiciones(esInicial);
		this.setResaltarcantidadAutorizarRequisiciones(esInicial);
		this.setResaltarfecha_autorizaAutorizarRequisiciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.ID)) {
				this.setResaltaridAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.CODIGOTIPOREQUISICION)) {
				this.setResaltarcodigo_tipo_requisicionAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.FECHA)) {
				this.setResaltarfechaAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.NOMBREBODEGA)) {
				this.setResaltarnombre_bodegaAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadAutorizarRequisiciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutorizarRequisicionesConstantesFunciones.FECHAAUTORIZA)) {
				this.setResaltarfecha_autorizaAutorizarRequisiciones(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AutorizarRequisicionesBeanSwingJInternalFrame autorizarrequisicionesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaAutorizarRequisicionesAutorizarRequisiciones=true;

	public Boolean getMostrarBusquedaAutorizarRequisicionesAutorizarRequisiciones() {
		return this.mostrarBusquedaAutorizarRequisicionesAutorizarRequisiciones;
	}

	public void setMostrarBusquedaAutorizarRequisicionesAutorizarRequisiciones(Boolean visibilidadResaltar) {
		this.mostrarBusquedaAutorizarRequisicionesAutorizarRequisiciones= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaAutorizarRequisicionesAutorizarRequisiciones=true;

	public Boolean getActivarBusquedaAutorizarRequisicionesAutorizarRequisiciones() {
		return this.activarBusquedaAutorizarRequisicionesAutorizarRequisiciones;
	}

	public void setActivarBusquedaAutorizarRequisicionesAutorizarRequisiciones(Boolean habilitarResaltar) {
		this.activarBusquedaAutorizarRequisicionesAutorizarRequisiciones= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaAutorizarRequisicionesAutorizarRequisiciones=null;

	public Border getResaltarBusquedaAutorizarRequisicionesAutorizarRequisiciones() {
		return this.resaltarBusquedaAutorizarRequisicionesAutorizarRequisiciones;
	}

	public void setResaltarBusquedaAutorizarRequisicionesAutorizarRequisiciones(Border borderResaltar) {
		this.resaltarBusquedaAutorizarRequisicionesAutorizarRequisiciones= borderResaltar;
	}

	public void setResaltarBusquedaAutorizarRequisicionesAutorizarRequisiciones(ParametroGeneralUsuario parametroGeneralUsuario/*AutorizarRequisicionesBeanSwingJInternalFrame autorizarrequisicionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaAutorizarRequisicionesAutorizarRequisiciones= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}