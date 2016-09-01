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
package com.bydan.erp.activosfijos.util.report;

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


import com.bydan.erp.activosfijos.util.report.ResponsablesConstantesFunciones;
import com.bydan.erp.activosfijos.util.report.ResponsablesParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.ResponsablesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ResponsablesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="Responsables";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Responsables"+ResponsablesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ResponsablesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ResponsablesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ResponsablesConstantesFunciones.SCHEMA+"_"+ResponsablesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ResponsablesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ResponsablesConstantesFunciones.SCHEMA+"_"+ResponsablesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ResponsablesConstantesFunciones.SCHEMA+"_"+ResponsablesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ResponsablesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ResponsablesConstantesFunciones.SCHEMA+"_"+ResponsablesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResponsablesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ResponsablesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResponsablesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResponsablesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ResponsablesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResponsablesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ResponsablesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ResponsablesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ResponsablesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ResponsablesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Responsableses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Responsables";
	public static final String SCLASSWEBTITULO_LOWER="Responsables";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Responsables";
	public static final String OBJECTNAME="responsables";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="responsables";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select responsables from "+ResponsablesConstantesFunciones.SPERSISTENCENAME+" responsables";
	public static String QUERYSELECTNATIVE="select "+ResponsablesConstantesFunciones.SCHEMA+"."+ResponsablesConstantesFunciones.TABLENAME+".id,"+ResponsablesConstantesFunciones.SCHEMA+"."+ResponsablesConstantesFunciones.TABLENAME+".version_row,"+ResponsablesConstantesFunciones.SCHEMA+"."+ResponsablesConstantesFunciones.TABLENAME+".id_empresa,"+ResponsablesConstantesFunciones.SCHEMA+"."+ResponsablesConstantesFunciones.TABLENAME+".codigo_empleado,"+ResponsablesConstantesFunciones.SCHEMA+"."+ResponsablesConstantesFunciones.TABLENAME+".nombre_empleado,"+ResponsablesConstantesFunciones.SCHEMA+"."+ResponsablesConstantesFunciones.TABLENAME+".apellido_empleado,"+ResponsablesConstantesFunciones.SCHEMA+"."+ResponsablesConstantesFunciones.TABLENAME+".nombre_estructura,"+ResponsablesConstantesFunciones.SCHEMA+"."+ResponsablesConstantesFunciones.TABLENAME+".ubicacion,"+ResponsablesConstantesFunciones.SCHEMA+"."+ResponsablesConstantesFunciones.TABLENAME+".fecha,"+ResponsablesConstantesFunciones.SCHEMA+"."+ResponsablesConstantesFunciones.TABLENAME+".descripcion,"+ResponsablesConstantesFunciones.SCHEMA+"."+ResponsablesConstantesFunciones.TABLENAME+".nombre,"+ResponsablesConstantesFunciones.SCHEMA+"."+ResponsablesConstantesFunciones.TABLENAME+".clave,"+ResponsablesConstantesFunciones.SCHEMA+"."+ResponsablesConstantesFunciones.TABLENAME+".codigo_sub_grupo,"+ResponsablesConstantesFunciones.SCHEMA+"."+ResponsablesConstantesFunciones.TABLENAME+".nombre_sub_grupo,"+ResponsablesConstantesFunciones.SCHEMA+"."+ResponsablesConstantesFunciones.TABLENAME+".codigo_detalle_grupo,"+ResponsablesConstantesFunciones.SCHEMA+"."+ResponsablesConstantesFunciones.TABLENAME+".nombre_detalle_grupo from "+ResponsablesConstantesFunciones.SCHEMA+"."+ResponsablesConstantesFunciones.TABLENAME;//+" as "+ResponsablesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGOEMPLEADO= "codigo_empleado";
    public static final String NOMBREEMPLEADO= "nombre_empleado";
    public static final String APELLIDOEMPLEADO= "apellido_empleado";
    public static final String NOMBREESTRUCTURA= "nombre_estructura";
    public static final String UBICACION= "ubicacion";
    public static final String FECHA= "fecha";
    public static final String DESCRIPCION= "descripcion";
    public static final String NOMBRE= "nombre";
    public static final String CLAVE= "clave";
    public static final String CODIGOSUBGRUPO= "codigo_sub_grupo";
    public static final String NOMBRESUBGRUPO= "nombre_sub_grupo";
    public static final String CODIGODETALLEGRUPO= "codigo_detalle_grupo";
    public static final String NOMBREDETALLEGRUPO= "nombre_detalle_grupo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGOEMPLEADO= "Codigo Empleado";
		public static final String LABEL_CODIGOEMPLEADO_LOWER= "Codigo Empleado";
    	public static final String LABEL_NOMBREEMPLEADO= "Nombre Empleado";
		public static final String LABEL_NOMBREEMPLEADO_LOWER= "Nombre Empleado";
    	public static final String LABEL_APELLIDOEMPLEADO= "Apello Empleado";
		public static final String LABEL_APELLIDOEMPLEADO_LOWER= "Apellido Empleado";
    	public static final String LABEL_NOMBREESTRUCTURA= "Nombre Estructura";
		public static final String LABEL_NOMBREESTRUCTURA_LOWER= "Nombre Estructura";
    	public static final String LABEL_UBICACION= "Ubicacion";
		public static final String LABEL_UBICACION_LOWER= "Ubicacion";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_CLAVE= "Clave";
		public static final String LABEL_CLAVE_LOWER= "Clave";
    	public static final String LABEL_CODIGOSUBGRUPO= "Codigo Sub Grupo";
		public static final String LABEL_CODIGOSUBGRUPO_LOWER= "Codigo Sub Grupo";
    	public static final String LABEL_NOMBRESUBGRUPO= "Nombre Sub Grupo";
		public static final String LABEL_NOMBRESUBGRUPO_LOWER= "Nombre Sub Grupo";
    	public static final String LABEL_CODIGODETALLEGRUPO= "Codigo Detalle Grupo";
		public static final String LABEL_CODIGODETALLEGRUPO_LOWER= "Codigo Detalle Grupo";
    	public static final String LABEL_NOMBREDETALLEGRUPO= "Nombre Detalle Grupo";
		public static final String LABEL_NOMBREDETALLEGRUPO_LOWER= "Nombre Detalle Grupo";
	
		
		
		
	public static final String SREGEXCODIGO_EMPLEADO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_EMPLEADO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_EMPLEADO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_EMPLEADO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDO_EMPLEADO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDO_EMPLEADO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_ESTRUCTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_ESTRUCTURA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXUBICACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXUBICACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCLAVE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCLAVE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_SUB_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_SUB_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_SUB_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SUB_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_DETALLE_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_DETALLE_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_DETALLE_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_DETALLE_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getResponsablesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ResponsablesConstantesFunciones.IDEMPRESA)) {sLabelColumna=ResponsablesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ResponsablesConstantesFunciones.CODIGOEMPLEADO)) {sLabelColumna=ResponsablesConstantesFunciones.LABEL_CODIGOEMPLEADO;}
		if(sNombreColumna.equals(ResponsablesConstantesFunciones.NOMBREEMPLEADO)) {sLabelColumna=ResponsablesConstantesFunciones.LABEL_NOMBREEMPLEADO;}
		if(sNombreColumna.equals(ResponsablesConstantesFunciones.APELLIDOEMPLEADO)) {sLabelColumna=ResponsablesConstantesFunciones.LABEL_APELLIDOEMPLEADO;}
		if(sNombreColumna.equals(ResponsablesConstantesFunciones.NOMBREESTRUCTURA)) {sLabelColumna=ResponsablesConstantesFunciones.LABEL_NOMBREESTRUCTURA;}
		if(sNombreColumna.equals(ResponsablesConstantesFunciones.UBICACION)) {sLabelColumna=ResponsablesConstantesFunciones.LABEL_UBICACION;}
		if(sNombreColumna.equals(ResponsablesConstantesFunciones.FECHA)) {sLabelColumna=ResponsablesConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ResponsablesConstantesFunciones.DESCRIPCION)) {sLabelColumna=ResponsablesConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(ResponsablesConstantesFunciones.NOMBRE)) {sLabelColumna=ResponsablesConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ResponsablesConstantesFunciones.CLAVE)) {sLabelColumna=ResponsablesConstantesFunciones.LABEL_CLAVE;}
		if(sNombreColumna.equals(ResponsablesConstantesFunciones.CODIGOSUBGRUPO)) {sLabelColumna=ResponsablesConstantesFunciones.LABEL_CODIGOSUBGRUPO;}
		if(sNombreColumna.equals(ResponsablesConstantesFunciones.NOMBRESUBGRUPO)) {sLabelColumna=ResponsablesConstantesFunciones.LABEL_NOMBRESUBGRUPO;}
		if(sNombreColumna.equals(ResponsablesConstantesFunciones.CODIGODETALLEGRUPO)) {sLabelColumna=ResponsablesConstantesFunciones.LABEL_CODIGODETALLEGRUPO;}
		if(sNombreColumna.equals(ResponsablesConstantesFunciones.NOMBREDETALLEGRUPO)) {sLabelColumna=ResponsablesConstantesFunciones.LABEL_NOMBREDETALLEGRUPO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getResponsablesDescripcion(Responsables responsables) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(responsables !=null/* && responsables.getId()!=0*/) {
			sDescripcion=responsables.getnombre();//responsablesresponsables.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getResponsablesDescripcionDetallado(Responsables responsables) {
		String sDescripcion="";
			
		sDescripcion+=ResponsablesConstantesFunciones.ID+"=";
		sDescripcion+=responsables.getId().toString()+",";
		sDescripcion+=ResponsablesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=responsables.getVersionRow().toString()+",";
		sDescripcion+=ResponsablesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=responsables.getid_empresa().toString()+",";
		sDescripcion+=ResponsablesConstantesFunciones.CODIGOEMPLEADO+"=";
		sDescripcion+=responsables.getcodigo_empleado()+",";
		sDescripcion+=ResponsablesConstantesFunciones.NOMBREEMPLEADO+"=";
		sDescripcion+=responsables.getnombre_empleado()+",";
		sDescripcion+=ResponsablesConstantesFunciones.APELLIDOEMPLEADO+"=";
		sDescripcion+=responsables.getapellido_empleado()+",";
		sDescripcion+=ResponsablesConstantesFunciones.NOMBREESTRUCTURA+"=";
		sDescripcion+=responsables.getnombre_estructura()+",";
		sDescripcion+=ResponsablesConstantesFunciones.UBICACION+"=";
		sDescripcion+=responsables.getubicacion()+",";
		sDescripcion+=ResponsablesConstantesFunciones.FECHA+"=";
		sDescripcion+=responsables.getfecha().toString()+",";
		sDescripcion+=ResponsablesConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=responsables.getdescripcion()+",";
		sDescripcion+=ResponsablesConstantesFunciones.NOMBRE+"=";
		sDescripcion+=responsables.getnombre()+",";
		sDescripcion+=ResponsablesConstantesFunciones.CLAVE+"=";
		sDescripcion+=responsables.getclave()+",";
		sDescripcion+=ResponsablesConstantesFunciones.CODIGOSUBGRUPO+"=";
		sDescripcion+=responsables.getcodigo_sub_grupo()+",";
		sDescripcion+=ResponsablesConstantesFunciones.NOMBRESUBGRUPO+"=";
		sDescripcion+=responsables.getnombre_sub_grupo()+",";
		sDescripcion+=ResponsablesConstantesFunciones.CODIGODETALLEGRUPO+"=";
		sDescripcion+=responsables.getcodigo_detalle_grupo()+",";
		sDescripcion+=ResponsablesConstantesFunciones.NOMBREDETALLEGRUPO+"=";
		sDescripcion+=responsables.getnombre_detalle_grupo()+",";
			
		return sDescripcion;
	}
	
	public static void setResponsablesDescripcion(Responsables responsables,String sValor) throws Exception {			
		if(responsables !=null) {
			responsables.setnombre(sValor);;//responsablesresponsables.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaResponsables")) {
			sNombreIndice="Tipo=  Por ";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaResponsables(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" ="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosResponsables(Responsables responsables,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		responsables.setcodigo_empleado(responsables.getcodigo_empleado().trim());
		responsables.setnombre_empleado(responsables.getnombre_empleado().trim());
		responsables.setapellido_empleado(responsables.getapellido_empleado().trim());
		responsables.setnombre_estructura(responsables.getnombre_estructura().trim());
		responsables.setubicacion(responsables.getubicacion().trim());
		responsables.setdescripcion(responsables.getdescripcion().trim());
		responsables.setnombre(responsables.getnombre().trim());
		responsables.setclave(responsables.getclave().trim());
		responsables.setcodigo_sub_grupo(responsables.getcodigo_sub_grupo().trim());
		responsables.setnombre_sub_grupo(responsables.getnombre_sub_grupo().trim());
		responsables.setcodigo_detalle_grupo(responsables.getcodigo_detalle_grupo().trim());
		responsables.setnombre_detalle_grupo(responsables.getnombre_detalle_grupo().trim());
	}
	
	public static void quitarEspaciosResponsabless(List<Responsables> responsabless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Responsables responsables: responsabless) {
			responsables.setcodigo_empleado(responsables.getcodigo_empleado().trim());
			responsables.setnombre_empleado(responsables.getnombre_empleado().trim());
			responsables.setapellido_empleado(responsables.getapellido_empleado().trim());
			responsables.setnombre_estructura(responsables.getnombre_estructura().trim());
			responsables.setubicacion(responsables.getubicacion().trim());
			responsables.setdescripcion(responsables.getdescripcion().trim());
			responsables.setnombre(responsables.getnombre().trim());
			responsables.setclave(responsables.getclave().trim());
			responsables.setcodigo_sub_grupo(responsables.getcodigo_sub_grupo().trim());
			responsables.setnombre_sub_grupo(responsables.getnombre_sub_grupo().trim());
			responsables.setcodigo_detalle_grupo(responsables.getcodigo_detalle_grupo().trim());
			responsables.setnombre_detalle_grupo(responsables.getnombre_detalle_grupo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresResponsables(Responsables responsables,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && responsables.getConCambioAuxiliar()) {
			responsables.setIsDeleted(responsables.getIsDeletedAuxiliar());	
			responsables.setIsNew(responsables.getIsNewAuxiliar());	
			responsables.setIsChanged(responsables.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			responsables.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			responsables.setIsDeletedAuxiliar(false);	
			responsables.setIsNewAuxiliar(false);	
			responsables.setIsChangedAuxiliar(false);
			
			responsables.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresResponsabless(List<Responsables> responsabless,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Responsables responsables : responsabless) {
			if(conAsignarBase && responsables.getConCambioAuxiliar()) {
				responsables.setIsDeleted(responsables.getIsDeletedAuxiliar());	
				responsables.setIsNew(responsables.getIsNewAuxiliar());	
				responsables.setIsChanged(responsables.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				responsables.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				responsables.setIsDeletedAuxiliar(false);	
				responsables.setIsNewAuxiliar(false);	
				responsables.setIsChangedAuxiliar(false);
				
				responsables.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresResponsables(Responsables responsables,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresResponsabless(List<Responsables> responsabless,Boolean conEnteros) throws Exception  {
		
		for(Responsables responsables: responsabless) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaResponsables(List<Responsables> responsabless,Responsables responsablesAux) throws Exception  {
		ResponsablesConstantesFunciones.InicializarValoresResponsables(responsablesAux,true);
		
		for(Responsables responsables: responsabless) {
			if(responsables.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesResponsables(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ResponsablesConstantesFunciones.getArrayColumnasGlobalesResponsables(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesResponsables(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ResponsablesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ResponsablesConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoResponsables(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Responsables> responsabless,Responsables responsables,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Responsables responsablesAux: responsabless) {
			if(responsablesAux!=null && responsables!=null) {
				if((responsablesAux.getId()==null && responsables.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(responsablesAux.getId()!=null && responsables.getId()!=null){
					if(responsablesAux.getId().equals(responsables.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaResponsables(List<Responsables> responsabless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Responsables responsables: responsabless) {			
			if(responsables.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaResponsables() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ResponsablesConstantesFunciones.LABEL_ID, ResponsablesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsablesConstantesFunciones.LABEL_VERSIONROW, ResponsablesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsablesConstantesFunciones.LABEL_CODIGOEMPLEADO, ResponsablesConstantesFunciones.CODIGOEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsablesConstantesFunciones.LABEL_NOMBREEMPLEADO, ResponsablesConstantesFunciones.NOMBREEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsablesConstantesFunciones.LABEL_APELLIDOEMPLEADO, ResponsablesConstantesFunciones.APELLIDOEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsablesConstantesFunciones.LABEL_NOMBREESTRUCTURA, ResponsablesConstantesFunciones.NOMBREESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsablesConstantesFunciones.LABEL_UBICACION, ResponsablesConstantesFunciones.UBICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsablesConstantesFunciones.LABEL_FECHA, ResponsablesConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsablesConstantesFunciones.LABEL_DESCRIPCION, ResponsablesConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsablesConstantesFunciones.LABEL_NOMBRE, ResponsablesConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsablesConstantesFunciones.LABEL_CLAVE, ResponsablesConstantesFunciones.CLAVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsablesConstantesFunciones.LABEL_CODIGOSUBGRUPO, ResponsablesConstantesFunciones.CODIGOSUBGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsablesConstantesFunciones.LABEL_NOMBRESUBGRUPO, ResponsablesConstantesFunciones.NOMBRESUBGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsablesConstantesFunciones.LABEL_CODIGODETALLEGRUPO, ResponsablesConstantesFunciones.CODIGODETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsablesConstantesFunciones.LABEL_NOMBREDETALLEGRUPO, ResponsablesConstantesFunciones.NOMBREDETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasResponsables() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ResponsablesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsablesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsablesConstantesFunciones.CODIGOEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsablesConstantesFunciones.NOMBREEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsablesConstantesFunciones.APELLIDOEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsablesConstantesFunciones.NOMBREESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsablesConstantesFunciones.UBICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsablesConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsablesConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsablesConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsablesConstantesFunciones.CLAVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsablesConstantesFunciones.CODIGOSUBGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsablesConstantesFunciones.NOMBRESUBGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsablesConstantesFunciones.CODIGODETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsablesConstantesFunciones.NOMBREDETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResponsables() throws Exception  {
		return ResponsablesConstantesFunciones.getTiposSeleccionarResponsables(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResponsables(Boolean conFk) throws Exception  {
		return ResponsablesConstantesFunciones.getTiposSeleccionarResponsables(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResponsables(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsablesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ResponsablesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsablesConstantesFunciones.LABEL_CODIGOEMPLEADO);
			reporte.setsDescripcion(ResponsablesConstantesFunciones.LABEL_CODIGOEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsablesConstantesFunciones.LABEL_NOMBREEMPLEADO);
			reporte.setsDescripcion(ResponsablesConstantesFunciones.LABEL_NOMBREEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsablesConstantesFunciones.LABEL_APELLIDOEMPLEADO);
			reporte.setsDescripcion(ResponsablesConstantesFunciones.LABEL_APELLIDOEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsablesConstantesFunciones.LABEL_NOMBREESTRUCTURA);
			reporte.setsDescripcion(ResponsablesConstantesFunciones.LABEL_NOMBREESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsablesConstantesFunciones.LABEL_UBICACION);
			reporte.setsDescripcion(ResponsablesConstantesFunciones.LABEL_UBICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsablesConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ResponsablesConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsablesConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ResponsablesConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsablesConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ResponsablesConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsablesConstantesFunciones.LABEL_CLAVE);
			reporte.setsDescripcion(ResponsablesConstantesFunciones.LABEL_CLAVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsablesConstantesFunciones.LABEL_CODIGOSUBGRUPO);
			reporte.setsDescripcion(ResponsablesConstantesFunciones.LABEL_CODIGOSUBGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsablesConstantesFunciones.LABEL_NOMBRESUBGRUPO);
			reporte.setsDescripcion(ResponsablesConstantesFunciones.LABEL_NOMBRESUBGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsablesConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
			reporte.setsDescripcion(ResponsablesConstantesFunciones.LABEL_CODIGODETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsablesConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
			reporte.setsDescripcion(ResponsablesConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesResponsables(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesResponsables(Responsables responsablesAux) throws Exception {
		
			responsablesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(responsablesAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesResponsables(List<Responsables> responsablessTemp) throws Exception {
		for(Responsables responsablesAux:responsablessTemp) {
			
			responsablesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(responsablesAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfResponsables(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfResponsables(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfResponsables(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ResponsablesConstantesFunciones.getClassesRelationshipsOfResponsables(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfResponsables(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfResponsables(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ResponsablesConstantesFunciones.getClassesRelationshipsFromStringsOfResponsables(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfResponsables(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Responsables responsables,List<Responsables> responsabless,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(Responsables responsables,List<Responsables> responsabless) throws Exception {
		try	{			
			for(Responsables responsablesLocal:responsabless) {
				if(responsablesLocal.getId().equals(responsables.getId())) {
					responsablesLocal.setIsSelected(responsables.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesResponsables(List<Responsables> responsablessAux) throws Exception {
		//this.responsablessAux=responsablessAux;
		
		for(Responsables responsablesAux:responsablessAux) {
			if(responsablesAux.getIsChanged()) {
				responsablesAux.setIsChanged(false);
			}		
			
			if(responsablesAux.getIsNew()) {
				responsablesAux.setIsNew(false);
			}	
			
			if(responsablesAux.getIsDeleted()) {
				responsablesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesResponsables(Responsables responsablesAux) throws Exception {
		//this.responsablesAux=responsablesAux;
		
			if(responsablesAux.getIsChanged()) {
				responsablesAux.setIsChanged(false);
			}		
			
			if(responsablesAux.getIsNew()) {
				responsablesAux.setIsNew(false);
			}	
			
			if(responsablesAux.getIsDeleted()) {
				responsablesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Responsables responsablesAsignar,Responsables responsables) throws Exception {
		responsablesAsignar.setId(responsables.getId());	
		responsablesAsignar.setVersionRow(responsables.getVersionRow());	
		responsablesAsignar.setcodigo_empleado(responsables.getcodigo_empleado());	
		responsablesAsignar.setnombre_empleado(responsables.getnombre_empleado());	
		responsablesAsignar.setapellido_empleado(responsables.getapellido_empleado());	
		responsablesAsignar.setnombre_estructura(responsables.getnombre_estructura());	
		responsablesAsignar.setubicacion(responsables.getubicacion());	
		responsablesAsignar.setfecha(responsables.getfecha());	
		responsablesAsignar.setdescripcion(responsables.getdescripcion());	
		responsablesAsignar.setnombre(responsables.getnombre());	
		responsablesAsignar.setclave(responsables.getclave());	
		responsablesAsignar.setcodigo_sub_grupo(responsables.getcodigo_sub_grupo());	
		responsablesAsignar.setnombre_sub_grupo(responsables.getnombre_sub_grupo());	
		responsablesAsignar.setcodigo_detalle_grupo(responsables.getcodigo_detalle_grupo());	
		responsablesAsignar.setnombre_detalle_grupo(responsables.getnombre_detalle_grupo());	
	}
	
	public static void inicializarResponsables(Responsables responsables) throws Exception {
		try {
				responsables.setId(0L);	
					
				responsables.setcodigo_empleado("");	
				responsables.setnombre_empleado("");	
				responsables.setapellido_empleado("");	
				responsables.setnombre_estructura("");	
				responsables.setubicacion("");	
				responsables.setfecha(new Date());	
				responsables.setdescripcion("");	
				responsables.setnombre("");	
				responsables.setclave("");	
				responsables.setcodigo_sub_grupo("");	
				responsables.setnombre_sub_grupo("");	
				responsables.setcodigo_detalle_grupo("");	
				responsables.setnombre_detalle_grupo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderResponsables(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsablesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsablesConstantesFunciones.LABEL_CODIGOEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsablesConstantesFunciones.LABEL_NOMBREEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsablesConstantesFunciones.LABEL_APELLIDOEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsablesConstantesFunciones.LABEL_NOMBREESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsablesConstantesFunciones.LABEL_UBICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsablesConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsablesConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsablesConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsablesConstantesFunciones.LABEL_CLAVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsablesConstantesFunciones.LABEL_CODIGOSUBGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsablesConstantesFunciones.LABEL_NOMBRESUBGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsablesConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsablesConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataResponsables(String sTipo,Row row,Workbook workbook,Responsables responsables,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(responsables.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsables.getcodigo_empleado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsables.getnombre_empleado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsables.getapellido_empleado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsables.getnombre_estructura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsables.getubicacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsables.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsables.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsables.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsables.getclave());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsables.getcodigo_sub_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsables.getnombre_sub_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsables.getcodigo_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsables.getnombre_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryResponsables="";
	
	public String getsFinalQueryResponsables() {
		return this.sFinalQueryResponsables;
	}
	
	public void setsFinalQueryResponsables(String sFinalQueryResponsables) {
		this.sFinalQueryResponsables= sFinalQueryResponsables;
	}
	
	public Border resaltarSeleccionarResponsables=null;
	
	public Border setResaltarSeleccionarResponsables(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//responsablesBeanSwingJInternalFrame.jTtoolBarResponsables.setBorder(borderResaltar);
		
		this.resaltarSeleccionarResponsables= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarResponsables() {
		return this.resaltarSeleccionarResponsables;
	}
	
	public void setResaltarSeleccionarResponsables(Border borderResaltarSeleccionarResponsables) {
		this.resaltarSeleccionarResponsables= borderResaltarSeleccionarResponsables;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridResponsables=null;
	public Boolean mostraridResponsables=true;
	public Boolean activaridResponsables=true;

	public Border resaltarid_empresaResponsables=null;
	public Boolean mostrarid_empresaResponsables=true;
	public Boolean activarid_empresaResponsables=true;
	public Boolean cargarid_empresaResponsables=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaResponsables=false;//ConEventDepend=true

	public Border resaltarcodigo_empleadoResponsables=null;
	public Boolean mostrarcodigo_empleadoResponsables=true;
	public Boolean activarcodigo_empleadoResponsables=true;

	public Border resaltarnombre_empleadoResponsables=null;
	public Boolean mostrarnombre_empleadoResponsables=true;
	public Boolean activarnombre_empleadoResponsables=true;

	public Border resaltarapellido_empleadoResponsables=null;
	public Boolean mostrarapellido_empleadoResponsables=true;
	public Boolean activarapellido_empleadoResponsables=true;

	public Border resaltarnombre_estructuraResponsables=null;
	public Boolean mostrarnombre_estructuraResponsables=true;
	public Boolean activarnombre_estructuraResponsables=true;

	public Border resaltarubicacionResponsables=null;
	public Boolean mostrarubicacionResponsables=true;
	public Boolean activarubicacionResponsables=true;

	public Border resaltarfechaResponsables=null;
	public Boolean mostrarfechaResponsables=true;
	public Boolean activarfechaResponsables=true;

	public Border resaltardescripcionResponsables=null;
	public Boolean mostrardescripcionResponsables=true;
	public Boolean activardescripcionResponsables=true;

	public Border resaltarnombreResponsables=null;
	public Boolean mostrarnombreResponsables=true;
	public Boolean activarnombreResponsables=true;

	public Border resaltarclaveResponsables=null;
	public Boolean mostrarclaveResponsables=true;
	public Boolean activarclaveResponsables=true;

	public Border resaltarcodigo_sub_grupoResponsables=null;
	public Boolean mostrarcodigo_sub_grupoResponsables=true;
	public Boolean activarcodigo_sub_grupoResponsables=true;

	public Border resaltarnombre_sub_grupoResponsables=null;
	public Boolean mostrarnombre_sub_grupoResponsables=true;
	public Boolean activarnombre_sub_grupoResponsables=true;

	public Border resaltarcodigo_detalle_grupoResponsables=null;
	public Boolean mostrarcodigo_detalle_grupoResponsables=true;
	public Boolean activarcodigo_detalle_grupoResponsables=true;

	public Border resaltarnombre_detalle_grupoResponsables=null;
	public Boolean mostrarnombre_detalle_grupoResponsables=true;
	public Boolean activarnombre_detalle_grupoResponsables=true;

	
	

	public Border setResaltaridResponsables(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablesBeanSwingJInternalFrame.jTtoolBarResponsables.setBorder(borderResaltar);
		
		this.resaltaridResponsables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridResponsables() {
		return this.resaltaridResponsables;
	}

	public void setResaltaridResponsables(Border borderResaltar) {
		this.resaltaridResponsables= borderResaltar;
	}

	public Boolean getMostraridResponsables() {
		return this.mostraridResponsables;
	}

	public void setMostraridResponsables(Boolean mostraridResponsables) {
		this.mostraridResponsables= mostraridResponsables;
	}

	public Boolean getActivaridResponsables() {
		return this.activaridResponsables;
	}

	public void setActivaridResponsables(Boolean activaridResponsables) {
		this.activaridResponsables= activaridResponsables;
	}

	public Border setResaltarid_empresaResponsables(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablesBeanSwingJInternalFrame.jTtoolBarResponsables.setBorder(borderResaltar);
		
		this.resaltarid_empresaResponsables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaResponsables() {
		return this.resaltarid_empresaResponsables;
	}

	public void setResaltarid_empresaResponsables(Border borderResaltar) {
		this.resaltarid_empresaResponsables= borderResaltar;
	}

	public Boolean getMostrarid_empresaResponsables() {
		return this.mostrarid_empresaResponsables;
	}

	public void setMostrarid_empresaResponsables(Boolean mostrarid_empresaResponsables) {
		this.mostrarid_empresaResponsables= mostrarid_empresaResponsables;
	}

	public Boolean getActivarid_empresaResponsables() {
		return this.activarid_empresaResponsables;
	}

	public void setActivarid_empresaResponsables(Boolean activarid_empresaResponsables) {
		this.activarid_empresaResponsables= activarid_empresaResponsables;
	}

	public Boolean getCargarid_empresaResponsables() {
		return this.cargarid_empresaResponsables;
	}

	public void setCargarid_empresaResponsables(Boolean cargarid_empresaResponsables) {
		this.cargarid_empresaResponsables= cargarid_empresaResponsables;
	}

	public Border setResaltarcodigo_empleadoResponsables(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablesBeanSwingJInternalFrame.jTtoolBarResponsables.setBorder(borderResaltar);
		
		this.resaltarcodigo_empleadoResponsables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_empleadoResponsables() {
		return this.resaltarcodigo_empleadoResponsables;
	}

	public void setResaltarcodigo_empleadoResponsables(Border borderResaltar) {
		this.resaltarcodigo_empleadoResponsables= borderResaltar;
	}

	public Boolean getMostrarcodigo_empleadoResponsables() {
		return this.mostrarcodigo_empleadoResponsables;
	}

	public void setMostrarcodigo_empleadoResponsables(Boolean mostrarcodigo_empleadoResponsables) {
		this.mostrarcodigo_empleadoResponsables= mostrarcodigo_empleadoResponsables;
	}

	public Boolean getActivarcodigo_empleadoResponsables() {
		return this.activarcodigo_empleadoResponsables;
	}

	public void setActivarcodigo_empleadoResponsables(Boolean activarcodigo_empleadoResponsables) {
		this.activarcodigo_empleadoResponsables= activarcodigo_empleadoResponsables;
	}

	public Border setResaltarnombre_empleadoResponsables(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablesBeanSwingJInternalFrame.jTtoolBarResponsables.setBorder(borderResaltar);
		
		this.resaltarnombre_empleadoResponsables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_empleadoResponsables() {
		return this.resaltarnombre_empleadoResponsables;
	}

	public void setResaltarnombre_empleadoResponsables(Border borderResaltar) {
		this.resaltarnombre_empleadoResponsables= borderResaltar;
	}

	public Boolean getMostrarnombre_empleadoResponsables() {
		return this.mostrarnombre_empleadoResponsables;
	}

	public void setMostrarnombre_empleadoResponsables(Boolean mostrarnombre_empleadoResponsables) {
		this.mostrarnombre_empleadoResponsables= mostrarnombre_empleadoResponsables;
	}

	public Boolean getActivarnombre_empleadoResponsables() {
		return this.activarnombre_empleadoResponsables;
	}

	public void setActivarnombre_empleadoResponsables(Boolean activarnombre_empleadoResponsables) {
		this.activarnombre_empleadoResponsables= activarnombre_empleadoResponsables;
	}

	public Border setResaltarapellido_empleadoResponsables(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablesBeanSwingJInternalFrame.jTtoolBarResponsables.setBorder(borderResaltar);
		
		this.resaltarapellido_empleadoResponsables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellido_empleadoResponsables() {
		return this.resaltarapellido_empleadoResponsables;
	}

	public void setResaltarapellido_empleadoResponsables(Border borderResaltar) {
		this.resaltarapellido_empleadoResponsables= borderResaltar;
	}

	public Boolean getMostrarapellido_empleadoResponsables() {
		return this.mostrarapellido_empleadoResponsables;
	}

	public void setMostrarapellido_empleadoResponsables(Boolean mostrarapellido_empleadoResponsables) {
		this.mostrarapellido_empleadoResponsables= mostrarapellido_empleadoResponsables;
	}

	public Boolean getActivarapellido_empleadoResponsables() {
		return this.activarapellido_empleadoResponsables;
	}

	public void setActivarapellido_empleadoResponsables(Boolean activarapellido_empleadoResponsables) {
		this.activarapellido_empleadoResponsables= activarapellido_empleadoResponsables;
	}

	public Border setResaltarnombre_estructuraResponsables(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablesBeanSwingJInternalFrame.jTtoolBarResponsables.setBorder(borderResaltar);
		
		this.resaltarnombre_estructuraResponsables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_estructuraResponsables() {
		return this.resaltarnombre_estructuraResponsables;
	}

	public void setResaltarnombre_estructuraResponsables(Border borderResaltar) {
		this.resaltarnombre_estructuraResponsables= borderResaltar;
	}

	public Boolean getMostrarnombre_estructuraResponsables() {
		return this.mostrarnombre_estructuraResponsables;
	}

	public void setMostrarnombre_estructuraResponsables(Boolean mostrarnombre_estructuraResponsables) {
		this.mostrarnombre_estructuraResponsables= mostrarnombre_estructuraResponsables;
	}

	public Boolean getActivarnombre_estructuraResponsables() {
		return this.activarnombre_estructuraResponsables;
	}

	public void setActivarnombre_estructuraResponsables(Boolean activarnombre_estructuraResponsables) {
		this.activarnombre_estructuraResponsables= activarnombre_estructuraResponsables;
	}

	public Border setResaltarubicacionResponsables(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablesBeanSwingJInternalFrame.jTtoolBarResponsables.setBorder(borderResaltar);
		
		this.resaltarubicacionResponsables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarubicacionResponsables() {
		return this.resaltarubicacionResponsables;
	}

	public void setResaltarubicacionResponsables(Border borderResaltar) {
		this.resaltarubicacionResponsables= borderResaltar;
	}

	public Boolean getMostrarubicacionResponsables() {
		return this.mostrarubicacionResponsables;
	}

	public void setMostrarubicacionResponsables(Boolean mostrarubicacionResponsables) {
		this.mostrarubicacionResponsables= mostrarubicacionResponsables;
	}

	public Boolean getActivarubicacionResponsables() {
		return this.activarubicacionResponsables;
	}

	public void setActivarubicacionResponsables(Boolean activarubicacionResponsables) {
		this.activarubicacionResponsables= activarubicacionResponsables;
	}

	public Border setResaltarfechaResponsables(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablesBeanSwingJInternalFrame.jTtoolBarResponsables.setBorder(borderResaltar);
		
		this.resaltarfechaResponsables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaResponsables() {
		return this.resaltarfechaResponsables;
	}

	public void setResaltarfechaResponsables(Border borderResaltar) {
		this.resaltarfechaResponsables= borderResaltar;
	}

	public Boolean getMostrarfechaResponsables() {
		return this.mostrarfechaResponsables;
	}

	public void setMostrarfechaResponsables(Boolean mostrarfechaResponsables) {
		this.mostrarfechaResponsables= mostrarfechaResponsables;
	}

	public Boolean getActivarfechaResponsables() {
		return this.activarfechaResponsables;
	}

	public void setActivarfechaResponsables(Boolean activarfechaResponsables) {
		this.activarfechaResponsables= activarfechaResponsables;
	}

	public Border setResaltardescripcionResponsables(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablesBeanSwingJInternalFrame.jTtoolBarResponsables.setBorder(borderResaltar);
		
		this.resaltardescripcionResponsables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionResponsables() {
		return this.resaltardescripcionResponsables;
	}

	public void setResaltardescripcionResponsables(Border borderResaltar) {
		this.resaltardescripcionResponsables= borderResaltar;
	}

	public Boolean getMostrardescripcionResponsables() {
		return this.mostrardescripcionResponsables;
	}

	public void setMostrardescripcionResponsables(Boolean mostrardescripcionResponsables) {
		this.mostrardescripcionResponsables= mostrardescripcionResponsables;
	}

	public Boolean getActivardescripcionResponsables() {
		return this.activardescripcionResponsables;
	}

	public void setActivardescripcionResponsables(Boolean activardescripcionResponsables) {
		this.activardescripcionResponsables= activardescripcionResponsables;
	}

	public Border setResaltarnombreResponsables(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablesBeanSwingJInternalFrame.jTtoolBarResponsables.setBorder(borderResaltar);
		
		this.resaltarnombreResponsables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreResponsables() {
		return this.resaltarnombreResponsables;
	}

	public void setResaltarnombreResponsables(Border borderResaltar) {
		this.resaltarnombreResponsables= borderResaltar;
	}

	public Boolean getMostrarnombreResponsables() {
		return this.mostrarnombreResponsables;
	}

	public void setMostrarnombreResponsables(Boolean mostrarnombreResponsables) {
		this.mostrarnombreResponsables= mostrarnombreResponsables;
	}

	public Boolean getActivarnombreResponsables() {
		return this.activarnombreResponsables;
	}

	public void setActivarnombreResponsables(Boolean activarnombreResponsables) {
		this.activarnombreResponsables= activarnombreResponsables;
	}

	public Border setResaltarclaveResponsables(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablesBeanSwingJInternalFrame.jTtoolBarResponsables.setBorder(borderResaltar);
		
		this.resaltarclaveResponsables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarclaveResponsables() {
		return this.resaltarclaveResponsables;
	}

	public void setResaltarclaveResponsables(Border borderResaltar) {
		this.resaltarclaveResponsables= borderResaltar;
	}

	public Boolean getMostrarclaveResponsables() {
		return this.mostrarclaveResponsables;
	}

	public void setMostrarclaveResponsables(Boolean mostrarclaveResponsables) {
		this.mostrarclaveResponsables= mostrarclaveResponsables;
	}

	public Boolean getActivarclaveResponsables() {
		return this.activarclaveResponsables;
	}

	public void setActivarclaveResponsables(Boolean activarclaveResponsables) {
		this.activarclaveResponsables= activarclaveResponsables;
	}

	public Border setResaltarcodigo_sub_grupoResponsables(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablesBeanSwingJInternalFrame.jTtoolBarResponsables.setBorder(borderResaltar);
		
		this.resaltarcodigo_sub_grupoResponsables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_sub_grupoResponsables() {
		return this.resaltarcodigo_sub_grupoResponsables;
	}

	public void setResaltarcodigo_sub_grupoResponsables(Border borderResaltar) {
		this.resaltarcodigo_sub_grupoResponsables= borderResaltar;
	}

	public Boolean getMostrarcodigo_sub_grupoResponsables() {
		return this.mostrarcodigo_sub_grupoResponsables;
	}

	public void setMostrarcodigo_sub_grupoResponsables(Boolean mostrarcodigo_sub_grupoResponsables) {
		this.mostrarcodigo_sub_grupoResponsables= mostrarcodigo_sub_grupoResponsables;
	}

	public Boolean getActivarcodigo_sub_grupoResponsables() {
		return this.activarcodigo_sub_grupoResponsables;
	}

	public void setActivarcodigo_sub_grupoResponsables(Boolean activarcodigo_sub_grupoResponsables) {
		this.activarcodigo_sub_grupoResponsables= activarcodigo_sub_grupoResponsables;
	}

	public Border setResaltarnombre_sub_grupoResponsables(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablesBeanSwingJInternalFrame.jTtoolBarResponsables.setBorder(borderResaltar);
		
		this.resaltarnombre_sub_grupoResponsables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sub_grupoResponsables() {
		return this.resaltarnombre_sub_grupoResponsables;
	}

	public void setResaltarnombre_sub_grupoResponsables(Border borderResaltar) {
		this.resaltarnombre_sub_grupoResponsables= borderResaltar;
	}

	public Boolean getMostrarnombre_sub_grupoResponsables() {
		return this.mostrarnombre_sub_grupoResponsables;
	}

	public void setMostrarnombre_sub_grupoResponsables(Boolean mostrarnombre_sub_grupoResponsables) {
		this.mostrarnombre_sub_grupoResponsables= mostrarnombre_sub_grupoResponsables;
	}

	public Boolean getActivarnombre_sub_grupoResponsables() {
		return this.activarnombre_sub_grupoResponsables;
	}

	public void setActivarnombre_sub_grupoResponsables(Boolean activarnombre_sub_grupoResponsables) {
		this.activarnombre_sub_grupoResponsables= activarnombre_sub_grupoResponsables;
	}

	public Border setResaltarcodigo_detalle_grupoResponsables(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablesBeanSwingJInternalFrame.jTtoolBarResponsables.setBorder(borderResaltar);
		
		this.resaltarcodigo_detalle_grupoResponsables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_detalle_grupoResponsables() {
		return this.resaltarcodigo_detalle_grupoResponsables;
	}

	public void setResaltarcodigo_detalle_grupoResponsables(Border borderResaltar) {
		this.resaltarcodigo_detalle_grupoResponsables= borderResaltar;
	}

	public Boolean getMostrarcodigo_detalle_grupoResponsables() {
		return this.mostrarcodigo_detalle_grupoResponsables;
	}

	public void setMostrarcodigo_detalle_grupoResponsables(Boolean mostrarcodigo_detalle_grupoResponsables) {
		this.mostrarcodigo_detalle_grupoResponsables= mostrarcodigo_detalle_grupoResponsables;
	}

	public Boolean getActivarcodigo_detalle_grupoResponsables() {
		return this.activarcodigo_detalle_grupoResponsables;
	}

	public void setActivarcodigo_detalle_grupoResponsables(Boolean activarcodigo_detalle_grupoResponsables) {
		this.activarcodigo_detalle_grupoResponsables= activarcodigo_detalle_grupoResponsables;
	}

	public Border setResaltarnombre_detalle_grupoResponsables(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsablesBeanSwingJInternalFrame.jTtoolBarResponsables.setBorder(borderResaltar);
		
		this.resaltarnombre_detalle_grupoResponsables= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_detalle_grupoResponsables() {
		return this.resaltarnombre_detalle_grupoResponsables;
	}

	public void setResaltarnombre_detalle_grupoResponsables(Border borderResaltar) {
		this.resaltarnombre_detalle_grupoResponsables= borderResaltar;
	}

	public Boolean getMostrarnombre_detalle_grupoResponsables() {
		return this.mostrarnombre_detalle_grupoResponsables;
	}

	public void setMostrarnombre_detalle_grupoResponsables(Boolean mostrarnombre_detalle_grupoResponsables) {
		this.mostrarnombre_detalle_grupoResponsables= mostrarnombre_detalle_grupoResponsables;
	}

	public Boolean getActivarnombre_detalle_grupoResponsables() {
		return this.activarnombre_detalle_grupoResponsables;
	}

	public void setActivarnombre_detalle_grupoResponsables(Boolean activarnombre_detalle_grupoResponsables) {
		this.activarnombre_detalle_grupoResponsables= activarnombre_detalle_grupoResponsables;
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
		
		
		this.setMostraridResponsables(esInicial);
		this.setMostrarid_empresaResponsables(esInicial);
		this.setMostrarcodigo_empleadoResponsables(esInicial);
		this.setMostrarnombre_empleadoResponsables(esInicial);
		this.setMostrarapellido_empleadoResponsables(esInicial);
		this.setMostrarnombre_estructuraResponsables(esInicial);
		this.setMostrarubicacionResponsables(esInicial);
		this.setMostrarfechaResponsables(esInicial);
		this.setMostrardescripcionResponsables(esInicial);
		this.setMostrarnombreResponsables(esInicial);
		this.setMostrarclaveResponsables(esInicial);
		this.setMostrarcodigo_sub_grupoResponsables(esInicial);
		this.setMostrarnombre_sub_grupoResponsables(esInicial);
		this.setMostrarcodigo_detalle_grupoResponsables(esInicial);
		this.setMostrarnombre_detalle_grupoResponsables(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResponsablesConstantesFunciones.ID)) {
				this.setMostraridResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.CODIGOEMPLEADO)) {
				this.setMostrarcodigo_empleadoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.NOMBREEMPLEADO)) {
				this.setMostrarnombre_empleadoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.APELLIDOEMPLEADO)) {
				this.setMostrarapellido_empleadoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.NOMBREESTRUCTURA)) {
				this.setMostrarnombre_estructuraResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.UBICACION)) {
				this.setMostrarubicacionResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.FECHA)) {
				this.setMostrarfechaResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.CLAVE)) {
				this.setMostrarclaveResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setMostrarcodigo_sub_grupoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setMostrarnombre_sub_grupoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setMostrarcodigo_detalle_grupoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setMostrarnombre_detalle_grupoResponsables(esAsigna);
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
		
		
		this.setActivaridResponsables(esInicial);
		this.setActivarid_empresaResponsables(esInicial);
		this.setActivarcodigo_empleadoResponsables(esInicial);
		this.setActivarnombre_empleadoResponsables(esInicial);
		this.setActivarapellido_empleadoResponsables(esInicial);
		this.setActivarnombre_estructuraResponsables(esInicial);
		this.setActivarubicacionResponsables(esInicial);
		this.setActivarfechaResponsables(esInicial);
		this.setActivardescripcionResponsables(esInicial);
		this.setActivarnombreResponsables(esInicial);
		this.setActivarclaveResponsables(esInicial);
		this.setActivarcodigo_sub_grupoResponsables(esInicial);
		this.setActivarnombre_sub_grupoResponsables(esInicial);
		this.setActivarcodigo_detalle_grupoResponsables(esInicial);
		this.setActivarnombre_detalle_grupoResponsables(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResponsablesConstantesFunciones.ID)) {
				this.setActivaridResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.CODIGOEMPLEADO)) {
				this.setActivarcodigo_empleadoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.NOMBREEMPLEADO)) {
				this.setActivarnombre_empleadoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.APELLIDOEMPLEADO)) {
				this.setActivarapellido_empleadoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.NOMBREESTRUCTURA)) {
				this.setActivarnombre_estructuraResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.UBICACION)) {
				this.setActivarubicacionResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.FECHA)) {
				this.setActivarfechaResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.NOMBRE)) {
				this.setActivarnombreResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.CLAVE)) {
				this.setActivarclaveResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setActivarcodigo_sub_grupoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setActivarnombre_sub_grupoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setActivarcodigo_detalle_grupoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setActivarnombre_detalle_grupoResponsables(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridResponsables(esInicial);
		this.setResaltarid_empresaResponsables(esInicial);
		this.setResaltarcodigo_empleadoResponsables(esInicial);
		this.setResaltarnombre_empleadoResponsables(esInicial);
		this.setResaltarapellido_empleadoResponsables(esInicial);
		this.setResaltarnombre_estructuraResponsables(esInicial);
		this.setResaltarubicacionResponsables(esInicial);
		this.setResaltarfechaResponsables(esInicial);
		this.setResaltardescripcionResponsables(esInicial);
		this.setResaltarnombreResponsables(esInicial);
		this.setResaltarclaveResponsables(esInicial);
		this.setResaltarcodigo_sub_grupoResponsables(esInicial);
		this.setResaltarnombre_sub_grupoResponsables(esInicial);
		this.setResaltarcodigo_detalle_grupoResponsables(esInicial);
		this.setResaltarnombre_detalle_grupoResponsables(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResponsablesConstantesFunciones.ID)) {
				this.setResaltaridResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.CODIGOEMPLEADO)) {
				this.setResaltarcodigo_empleadoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.NOMBREEMPLEADO)) {
				this.setResaltarnombre_empleadoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.APELLIDOEMPLEADO)) {
				this.setResaltarapellido_empleadoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.NOMBREESTRUCTURA)) {
				this.setResaltarnombre_estructuraResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.UBICACION)) {
				this.setResaltarubicacionResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.FECHA)) {
				this.setResaltarfechaResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.CLAVE)) {
				this.setResaltarclaveResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setResaltarcodigo_sub_grupoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setResaltarnombre_sub_grupoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setResaltarcodigo_detalle_grupoResponsables(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsablesConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setResaltarnombre_detalle_grupoResponsables(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaResponsablesResponsables=true;

	public Boolean getMostrarBusquedaResponsablesResponsables() {
		return this.mostrarBusquedaResponsablesResponsables;
	}

	public void setMostrarBusquedaResponsablesResponsables(Boolean visibilidadResaltar) {
		this.mostrarBusquedaResponsablesResponsables= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaResponsablesResponsables=true;

	public Boolean getActivarBusquedaResponsablesResponsables() {
		return this.activarBusquedaResponsablesResponsables;
	}

	public void setActivarBusquedaResponsablesResponsables(Boolean habilitarResaltar) {
		this.activarBusquedaResponsablesResponsables= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaResponsablesResponsables=null;

	public Border getResaltarBusquedaResponsablesResponsables() {
		return this.resaltarBusquedaResponsablesResponsables;
	}

	public void setResaltarBusquedaResponsablesResponsables(Border borderResaltar) {
		this.resaltarBusquedaResponsablesResponsables= borderResaltar;
	}

	public void setResaltarBusquedaResponsablesResponsables(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsablesBeanSwingJInternalFrame responsablesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaResponsablesResponsables= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}