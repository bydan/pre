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


import com.bydan.erp.activosfijos.util.report.BajasActivosFijosConstantesFunciones;
import com.bydan.erp.activosfijos.util.report.BajasActivosFijosParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.BajasActivosFijosParameterGeneral;

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
final public class BajasActivosFijosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="BajasActivosFijos";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="BajasActivosFijos"+BajasActivosFijosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="BajasActivosFijosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="BajasActivosFijosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=BajasActivosFijosConstantesFunciones.SCHEMA+"_"+BajasActivosFijosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/BajasActivosFijosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=BajasActivosFijosConstantesFunciones.SCHEMA+"_"+BajasActivosFijosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=BajasActivosFijosConstantesFunciones.SCHEMA+"_"+BajasActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/BajasActivosFijosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=BajasActivosFijosConstantesFunciones.SCHEMA+"_"+BajasActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BajasActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BajasActivosFijosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BajasActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BajasActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BajasActivosFijosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BajasActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=BajasActivosFijosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+BajasActivosFijosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=BajasActivosFijosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+BajasActivosFijosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Bajas Activos Fijoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Bajas Activos Fijos";
	public static final String SCLASSWEBTITULO_LOWER="Bajas Activos Fijos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="BajasActivosFijos";
	public static final String OBJECTNAME="bajasactivosfijos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="bajas_activos_fijos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select bajasactivosfijos from "+BajasActivosFijosConstantesFunciones.SPERSISTENCENAME+" bajasactivosfijos";
	public static String QUERYSELECTNATIVE="select "+BajasActivosFijosConstantesFunciones.SCHEMA+"."+BajasActivosFijosConstantesFunciones.TABLENAME+".id,"+BajasActivosFijosConstantesFunciones.SCHEMA+"."+BajasActivosFijosConstantesFunciones.TABLENAME+".version_row,"+BajasActivosFijosConstantesFunciones.SCHEMA+"."+BajasActivosFijosConstantesFunciones.TABLENAME+".id_empresa,"+BajasActivosFijosConstantesFunciones.SCHEMA+"."+BajasActivosFijosConstantesFunciones.TABLENAME+".codigo_sub_grupo,"+BajasActivosFijosConstantesFunciones.SCHEMA+"."+BajasActivosFijosConstantesFunciones.TABLENAME+".nombre_sub_grupo,"+BajasActivosFijosConstantesFunciones.SCHEMA+"."+BajasActivosFijosConstantesFunciones.TABLENAME+".codigo_detalle_grupo,"+BajasActivosFijosConstantesFunciones.SCHEMA+"."+BajasActivosFijosConstantesFunciones.TABLENAME+".nombre_detalle_grupo,"+BajasActivosFijosConstantesFunciones.SCHEMA+"."+BajasActivosFijosConstantesFunciones.TABLENAME+".clave,"+BajasActivosFijosConstantesFunciones.SCHEMA+"."+BajasActivosFijosConstantesFunciones.TABLENAME+".nombre,"+BajasActivosFijosConstantesFunciones.SCHEMA+"."+BajasActivosFijosConstantesFunciones.TABLENAME+".fecha_compra,"+BajasActivosFijosConstantesFunciones.SCHEMA+"."+BajasActivosFijosConstantesFunciones.TABLENAME+".vida_util,"+BajasActivosFijosConstantesFunciones.SCHEMA+"."+BajasActivosFijosConstantesFunciones.TABLENAME+".costo_de_compra from "+BajasActivosFijosConstantesFunciones.SCHEMA+"."+BajasActivosFijosConstantesFunciones.TABLENAME;//+" as "+BajasActivosFijosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGOSUBGRUPO= "codigo_sub_grupo";
    public static final String NOMBRESUBGRUPO= "nombre_sub_grupo";
    public static final String CODIGODETALLEGRUPO= "codigo_detalle_grupo";
    public static final String NOMBREDETALLEGRUPO= "nombre_detalle_grupo";
    public static final String CLAVE= "clave";
    public static final String NOMBRE= "nombre";
    public static final String FECHACOMPRA= "fecha_compra";
    public static final String VIDAUTIL= "vida_util";
    public static final String COSTODECOMPRA= "costo_de_compra";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGOSUBGRUPO= "Codigo Sub Grupo";
		public static final String LABEL_CODIGOSUBGRUPO_LOWER= "Codigo Sub Grupo";
    	public static final String LABEL_NOMBRESUBGRUPO= "Nombre Sub Grupo";
		public static final String LABEL_NOMBRESUBGRUPO_LOWER= "Nombre Sub Grupo";
    	public static final String LABEL_CODIGODETALLEGRUPO= "Codigo Detalle Grupo";
		public static final String LABEL_CODIGODETALLEGRUPO_LOWER= "Codigo Detalle Grupo";
    	public static final String LABEL_NOMBREDETALLEGRUPO= "Nombre Detalle Grupo";
		public static final String LABEL_NOMBREDETALLEGRUPO_LOWER= "Nombre Detalle Grupo";
    	public static final String LABEL_CLAVE= "Clave";
		public static final String LABEL_CLAVE_LOWER= "Clave";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_FECHACOMPRA= "Fecha Compra";
		public static final String LABEL_FECHACOMPRA_LOWER= "Fecha Compra";
    	public static final String LABEL_VIDAUTIL= "Va Util";
		public static final String LABEL_VIDAUTIL_LOWER= "Vida Util";
    	public static final String LABEL_COSTODECOMPRA= "Costo Compra";
		public static final String LABEL_COSTODECOMPRA_LOWER= "Costo De Compra";
	
		
		
		
	public static final String SREGEXCODIGO_SUB_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_SUB_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_SUB_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SUB_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_DETALLE_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_DETALLE_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_DETALLE_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_DETALLE_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCLAVE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCLAVE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getBajasActivosFijosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(BajasActivosFijosConstantesFunciones.IDEMPRESA)) {sLabelColumna=BajasActivosFijosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(BajasActivosFijosConstantesFunciones.CODIGOSUBGRUPO)) {sLabelColumna=BajasActivosFijosConstantesFunciones.LABEL_CODIGOSUBGRUPO;}
		if(sNombreColumna.equals(BajasActivosFijosConstantesFunciones.NOMBRESUBGRUPO)) {sLabelColumna=BajasActivosFijosConstantesFunciones.LABEL_NOMBRESUBGRUPO;}
		if(sNombreColumna.equals(BajasActivosFijosConstantesFunciones.CODIGODETALLEGRUPO)) {sLabelColumna=BajasActivosFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO;}
		if(sNombreColumna.equals(BajasActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO)) {sLabelColumna=BajasActivosFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO;}
		if(sNombreColumna.equals(BajasActivosFijosConstantesFunciones.CLAVE)) {sLabelColumna=BajasActivosFijosConstantesFunciones.LABEL_CLAVE;}
		if(sNombreColumna.equals(BajasActivosFijosConstantesFunciones.NOMBRE)) {sLabelColumna=BajasActivosFijosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(BajasActivosFijosConstantesFunciones.FECHACOMPRA)) {sLabelColumna=BajasActivosFijosConstantesFunciones.LABEL_FECHACOMPRA;}
		if(sNombreColumna.equals(BajasActivosFijosConstantesFunciones.VIDAUTIL)) {sLabelColumna=BajasActivosFijosConstantesFunciones.LABEL_VIDAUTIL;}
		if(sNombreColumna.equals(BajasActivosFijosConstantesFunciones.COSTODECOMPRA)) {sLabelColumna=BajasActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getBajasActivosFijosDescripcion(BajasActivosFijos bajasactivosfijos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(bajasactivosfijos !=null/* && bajasactivosfijos.getId()!=0*/) {
			sDescripcion=bajasactivosfijos.getnombre();//bajasactivosfijosbajasactivosfijos.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getBajasActivosFijosDescripcionDetallado(BajasActivosFijos bajasactivosfijos) {
		String sDescripcion="";
			
		sDescripcion+=BajasActivosFijosConstantesFunciones.ID+"=";
		sDescripcion+=bajasactivosfijos.getId().toString()+",";
		sDescripcion+=BajasActivosFijosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=bajasactivosfijos.getVersionRow().toString()+",";
		sDescripcion+=BajasActivosFijosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=bajasactivosfijos.getid_empresa().toString()+",";
		sDescripcion+=BajasActivosFijosConstantesFunciones.CODIGOSUBGRUPO+"=";
		sDescripcion+=bajasactivosfijos.getcodigo_sub_grupo()+",";
		sDescripcion+=BajasActivosFijosConstantesFunciones.NOMBRESUBGRUPO+"=";
		sDescripcion+=bajasactivosfijos.getnombre_sub_grupo()+",";
		sDescripcion+=BajasActivosFijosConstantesFunciones.CODIGODETALLEGRUPO+"=";
		sDescripcion+=bajasactivosfijos.getcodigo_detalle_grupo()+",";
		sDescripcion+=BajasActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO+"=";
		sDescripcion+=bajasactivosfijos.getnombre_detalle_grupo()+",";
		sDescripcion+=BajasActivosFijosConstantesFunciones.CLAVE+"=";
		sDescripcion+=bajasactivosfijos.getclave()+",";
		sDescripcion+=BajasActivosFijosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=bajasactivosfijos.getnombre()+",";
		sDescripcion+=BajasActivosFijosConstantesFunciones.FECHACOMPRA+"=";
		sDescripcion+=bajasactivosfijos.getfecha_compra().toString()+",";
		sDescripcion+=BajasActivosFijosConstantesFunciones.VIDAUTIL+"=";
		sDescripcion+=bajasactivosfijos.getvida_util().toString()+",";
		sDescripcion+=BajasActivosFijosConstantesFunciones.COSTODECOMPRA+"=";
		sDescripcion+=bajasactivosfijos.getcosto_de_compra().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setBajasActivosFijosDescripcion(BajasActivosFijos bajasactivosfijos,String sValor) throws Exception {			
		if(bajasactivosfijos !=null) {
			bajasactivosfijos.setnombre(sValor);;//bajasactivosfijosbajasactivosfijos.getnombre().trim();
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
		} else if(sNombreIndice.equals("BusquedaBajasActivosFijos")) {
			sNombreIndice="Tipo=  Por ";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaBajasActivosFijos(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" ="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosBajasActivosFijos(BajasActivosFijos bajasactivosfijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		bajasactivosfijos.setcodigo_sub_grupo(bajasactivosfijos.getcodigo_sub_grupo().trim());
		bajasactivosfijos.setnombre_sub_grupo(bajasactivosfijos.getnombre_sub_grupo().trim());
		bajasactivosfijos.setcodigo_detalle_grupo(bajasactivosfijos.getcodigo_detalle_grupo().trim());
		bajasactivosfijos.setnombre_detalle_grupo(bajasactivosfijos.getnombre_detalle_grupo().trim());
		bajasactivosfijos.setclave(bajasactivosfijos.getclave().trim());
		bajasactivosfijos.setnombre(bajasactivosfijos.getnombre().trim());
	}
	
	public static void quitarEspaciosBajasActivosFijoss(List<BajasActivosFijos> bajasactivosfijoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(BajasActivosFijos bajasactivosfijos: bajasactivosfijoss) {
			bajasactivosfijos.setcodigo_sub_grupo(bajasactivosfijos.getcodigo_sub_grupo().trim());
			bajasactivosfijos.setnombre_sub_grupo(bajasactivosfijos.getnombre_sub_grupo().trim());
			bajasactivosfijos.setcodigo_detalle_grupo(bajasactivosfijos.getcodigo_detalle_grupo().trim());
			bajasactivosfijos.setnombre_detalle_grupo(bajasactivosfijos.getnombre_detalle_grupo().trim());
			bajasactivosfijos.setclave(bajasactivosfijos.getclave().trim());
			bajasactivosfijos.setnombre(bajasactivosfijos.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBajasActivosFijos(BajasActivosFijos bajasactivosfijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && bajasactivosfijos.getConCambioAuxiliar()) {
			bajasactivosfijos.setIsDeleted(bajasactivosfijos.getIsDeletedAuxiliar());	
			bajasactivosfijos.setIsNew(bajasactivosfijos.getIsNewAuxiliar());	
			bajasactivosfijos.setIsChanged(bajasactivosfijos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			bajasactivosfijos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			bajasactivosfijos.setIsDeletedAuxiliar(false);	
			bajasactivosfijos.setIsNewAuxiliar(false);	
			bajasactivosfijos.setIsChangedAuxiliar(false);
			
			bajasactivosfijos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBajasActivosFijoss(List<BajasActivosFijos> bajasactivosfijoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(BajasActivosFijos bajasactivosfijos : bajasactivosfijoss) {
			if(conAsignarBase && bajasactivosfijos.getConCambioAuxiliar()) {
				bajasactivosfijos.setIsDeleted(bajasactivosfijos.getIsDeletedAuxiliar());	
				bajasactivosfijos.setIsNew(bajasactivosfijos.getIsNewAuxiliar());	
				bajasactivosfijos.setIsChanged(bajasactivosfijos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				bajasactivosfijos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				bajasactivosfijos.setIsDeletedAuxiliar(false);	
				bajasactivosfijos.setIsNewAuxiliar(false);	
				bajasactivosfijos.setIsChangedAuxiliar(false);
				
				bajasactivosfijos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresBajasActivosFijos(BajasActivosFijos bajasactivosfijos,Boolean conEnteros) throws Exception  {
		bajasactivosfijos.setvida_util(0.0);
		bajasactivosfijos.setcosto_de_compra(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresBajasActivosFijoss(List<BajasActivosFijos> bajasactivosfijoss,Boolean conEnteros) throws Exception  {
		
		for(BajasActivosFijos bajasactivosfijos: bajasactivosfijoss) {
			bajasactivosfijos.setvida_util(0.0);
			bajasactivosfijos.setcosto_de_compra(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaBajasActivosFijos(List<BajasActivosFijos> bajasactivosfijoss,BajasActivosFijos bajasactivosfijosAux) throws Exception  {
		BajasActivosFijosConstantesFunciones.InicializarValoresBajasActivosFijos(bajasactivosfijosAux,true);
		
		for(BajasActivosFijos bajasactivosfijos: bajasactivosfijoss) {
			if(bajasactivosfijos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			bajasactivosfijosAux.setvida_util(bajasactivosfijosAux.getvida_util()+bajasactivosfijos.getvida_util());			
			bajasactivosfijosAux.setcosto_de_compra(bajasactivosfijosAux.getcosto_de_compra()+bajasactivosfijos.getcosto_de_compra());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBajasActivosFijos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=BajasActivosFijosConstantesFunciones.getArrayColumnasGlobalesBajasActivosFijos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesBajasActivosFijos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BajasActivosFijosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BajasActivosFijosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoBajasActivosFijos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<BajasActivosFijos> bajasactivosfijoss,BajasActivosFijos bajasactivosfijos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(BajasActivosFijos bajasactivosfijosAux: bajasactivosfijoss) {
			if(bajasactivosfijosAux!=null && bajasactivosfijos!=null) {
				if((bajasactivosfijosAux.getId()==null && bajasactivosfijos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(bajasactivosfijosAux.getId()!=null && bajasactivosfijos.getId()!=null){
					if(bajasactivosfijosAux.getId().equals(bajasactivosfijos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaBajasActivosFijos(List<BajasActivosFijos> bajasactivosfijoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double vida_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
	
		for(BajasActivosFijos bajasactivosfijos: bajasactivosfijoss) {			
			if(bajasactivosfijos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			vida_utilTotal+=bajasactivosfijos.getvida_util();
			costo_de_compraTotal+=bajasactivosfijos.getcosto_de_compra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BajasActivosFijosConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(BajasActivosFijosConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BajasActivosFijosConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(BajasActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA);
		datoGeneral.setdValorDouble(costo_de_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaBajasActivosFijos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,BajasActivosFijosConstantesFunciones.LABEL_ID, BajasActivosFijosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BajasActivosFijosConstantesFunciones.LABEL_VERSIONROW, BajasActivosFijosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BajasActivosFijosConstantesFunciones.LABEL_CODIGOSUBGRUPO, BajasActivosFijosConstantesFunciones.CODIGOSUBGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BajasActivosFijosConstantesFunciones.LABEL_NOMBRESUBGRUPO, BajasActivosFijosConstantesFunciones.NOMBRESUBGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BajasActivosFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO, BajasActivosFijosConstantesFunciones.CODIGODETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BajasActivosFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO, BajasActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BajasActivosFijosConstantesFunciones.LABEL_CLAVE, BajasActivosFijosConstantesFunciones.CLAVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BajasActivosFijosConstantesFunciones.LABEL_NOMBRE, BajasActivosFijosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BajasActivosFijosConstantesFunciones.LABEL_FECHACOMPRA, BajasActivosFijosConstantesFunciones.FECHACOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BajasActivosFijosConstantesFunciones.LABEL_VIDAUTIL, BajasActivosFijosConstantesFunciones.VIDAUTIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BajasActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA, BajasActivosFijosConstantesFunciones.COSTODECOMPRA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasBajasActivosFijos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=BajasActivosFijosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BajasActivosFijosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BajasActivosFijosConstantesFunciones.CODIGOSUBGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BajasActivosFijosConstantesFunciones.NOMBRESUBGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BajasActivosFijosConstantesFunciones.CODIGODETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BajasActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BajasActivosFijosConstantesFunciones.CLAVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BajasActivosFijosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BajasActivosFijosConstantesFunciones.FECHACOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BajasActivosFijosConstantesFunciones.VIDAUTIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BajasActivosFijosConstantesFunciones.COSTODECOMPRA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBajasActivosFijos() throws Exception  {
		return BajasActivosFijosConstantesFunciones.getTiposSeleccionarBajasActivosFijos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBajasActivosFijos(Boolean conFk) throws Exception  {
		return BajasActivosFijosConstantesFunciones.getTiposSeleccionarBajasActivosFijos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBajasActivosFijos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BajasActivosFijosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(BajasActivosFijosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BajasActivosFijosConstantesFunciones.LABEL_CODIGOSUBGRUPO);
			reporte.setsDescripcion(BajasActivosFijosConstantesFunciones.LABEL_CODIGOSUBGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BajasActivosFijosConstantesFunciones.LABEL_NOMBRESUBGRUPO);
			reporte.setsDescripcion(BajasActivosFijosConstantesFunciones.LABEL_NOMBRESUBGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BajasActivosFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
			reporte.setsDescripcion(BajasActivosFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BajasActivosFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
			reporte.setsDescripcion(BajasActivosFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BajasActivosFijosConstantesFunciones.LABEL_CLAVE);
			reporte.setsDescripcion(BajasActivosFijosConstantesFunciones.LABEL_CLAVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BajasActivosFijosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(BajasActivosFijosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BajasActivosFijosConstantesFunciones.LABEL_FECHACOMPRA);
			reporte.setsDescripcion(BajasActivosFijosConstantesFunciones.LABEL_FECHACOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BajasActivosFijosConstantesFunciones.LABEL_VIDAUTIL);
			reporte.setsDescripcion(BajasActivosFijosConstantesFunciones.LABEL_VIDAUTIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BajasActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA);
			reporte.setsDescripcion(BajasActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesBajasActivosFijos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesBajasActivosFijos(BajasActivosFijos bajasactivosfijosAux) throws Exception {
		
			bajasactivosfijosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bajasactivosfijosAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesBajasActivosFijos(List<BajasActivosFijos> bajasactivosfijossTemp) throws Exception {
		for(BajasActivosFijos bajasactivosfijosAux:bajasactivosfijossTemp) {
			
			bajasactivosfijosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bajasactivosfijosAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfBajasActivosFijos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfBajasActivosFijos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfBajasActivosFijos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return BajasActivosFijosConstantesFunciones.getClassesRelationshipsOfBajasActivosFijos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBajasActivosFijos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBajasActivosFijos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return BajasActivosFijosConstantesFunciones.getClassesRelationshipsFromStringsOfBajasActivosFijos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBajasActivosFijos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(BajasActivosFijos bajasactivosfijos,List<BajasActivosFijos> bajasactivosfijoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(BajasActivosFijos bajasactivosfijos,List<BajasActivosFijos> bajasactivosfijoss) throws Exception {
		try	{			
			for(BajasActivosFijos bajasactivosfijosLocal:bajasactivosfijoss) {
				if(bajasactivosfijosLocal.getId().equals(bajasactivosfijos.getId())) {
					bajasactivosfijosLocal.setIsSelected(bajasactivosfijos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesBajasActivosFijos(List<BajasActivosFijos> bajasactivosfijossAux) throws Exception {
		//this.bajasactivosfijossAux=bajasactivosfijossAux;
		
		for(BajasActivosFijos bajasactivosfijosAux:bajasactivosfijossAux) {
			if(bajasactivosfijosAux.getIsChanged()) {
				bajasactivosfijosAux.setIsChanged(false);
			}		
			
			if(bajasactivosfijosAux.getIsNew()) {
				bajasactivosfijosAux.setIsNew(false);
			}	
			
			if(bajasactivosfijosAux.getIsDeleted()) {
				bajasactivosfijosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesBajasActivosFijos(BajasActivosFijos bajasactivosfijosAux) throws Exception {
		//this.bajasactivosfijosAux=bajasactivosfijosAux;
		
			if(bajasactivosfijosAux.getIsChanged()) {
				bajasactivosfijosAux.setIsChanged(false);
			}		
			
			if(bajasactivosfijosAux.getIsNew()) {
				bajasactivosfijosAux.setIsNew(false);
			}	
			
			if(bajasactivosfijosAux.getIsDeleted()) {
				bajasactivosfijosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(BajasActivosFijos bajasactivosfijosAsignar,BajasActivosFijos bajasactivosfijos) throws Exception {
		bajasactivosfijosAsignar.setId(bajasactivosfijos.getId());	
		bajasactivosfijosAsignar.setVersionRow(bajasactivosfijos.getVersionRow());	
		bajasactivosfijosAsignar.setcodigo_sub_grupo(bajasactivosfijos.getcodigo_sub_grupo());	
		bajasactivosfijosAsignar.setnombre_sub_grupo(bajasactivosfijos.getnombre_sub_grupo());	
		bajasactivosfijosAsignar.setcodigo_detalle_grupo(bajasactivosfijos.getcodigo_detalle_grupo());	
		bajasactivosfijosAsignar.setnombre_detalle_grupo(bajasactivosfijos.getnombre_detalle_grupo());	
		bajasactivosfijosAsignar.setclave(bajasactivosfijos.getclave());	
		bajasactivosfijosAsignar.setnombre(bajasactivosfijos.getnombre());	
		bajasactivosfijosAsignar.setfecha_compra(bajasactivosfijos.getfecha_compra());	
		bajasactivosfijosAsignar.setvida_util(bajasactivosfijos.getvida_util());	
		bajasactivosfijosAsignar.setcosto_de_compra(bajasactivosfijos.getcosto_de_compra());	
	}
	
	public static void inicializarBajasActivosFijos(BajasActivosFijos bajasactivosfijos) throws Exception {
		try {
				bajasactivosfijos.setId(0L);	
					
				bajasactivosfijos.setcodigo_sub_grupo("");	
				bajasactivosfijos.setnombre_sub_grupo("");	
				bajasactivosfijos.setcodigo_detalle_grupo("");	
				bajasactivosfijos.setnombre_detalle_grupo("");	
				bajasactivosfijos.setclave("");	
				bajasactivosfijos.setnombre("");	
				bajasactivosfijos.setfecha_compra(new Date());	
				bajasactivosfijos.setvida_util(0.0);	
				bajasactivosfijos.setcosto_de_compra(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderBajasActivosFijos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(BajasActivosFijosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BajasActivosFijosConstantesFunciones.LABEL_CODIGOSUBGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BajasActivosFijosConstantesFunciones.LABEL_NOMBRESUBGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BajasActivosFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BajasActivosFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BajasActivosFijosConstantesFunciones.LABEL_CLAVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BajasActivosFijosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BajasActivosFijosConstantesFunciones.LABEL_FECHACOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BajasActivosFijosConstantesFunciones.LABEL_VIDAUTIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BajasActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataBajasActivosFijos(String sTipo,Row row,Workbook workbook,BajasActivosFijos bajasactivosfijos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(bajasactivosfijos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bajasactivosfijos.getcodigo_sub_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bajasactivosfijos.getnombre_sub_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bajasactivosfijos.getcodigo_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bajasactivosfijos.getnombre_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bajasactivosfijos.getclave());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bajasactivosfijos.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bajasactivosfijos.getfecha_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bajasactivosfijos.getvida_util());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bajasactivosfijos.getcosto_de_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryBajasActivosFijos="";
	
	public String getsFinalQueryBajasActivosFijos() {
		return this.sFinalQueryBajasActivosFijos;
	}
	
	public void setsFinalQueryBajasActivosFijos(String sFinalQueryBajasActivosFijos) {
		this.sFinalQueryBajasActivosFijos= sFinalQueryBajasActivosFijos;
	}
	
	public Border resaltarSeleccionarBajasActivosFijos=null;
	
	public Border setResaltarSeleccionarBajasActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*BajasActivosFijosBeanSwingJInternalFrame bajasactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//bajasactivosfijosBeanSwingJInternalFrame.jTtoolBarBajasActivosFijos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarBajasActivosFijos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarBajasActivosFijos() {
		return this.resaltarSeleccionarBajasActivosFijos;
	}
	
	public void setResaltarSeleccionarBajasActivosFijos(Border borderResaltarSeleccionarBajasActivosFijos) {
		this.resaltarSeleccionarBajasActivosFijos= borderResaltarSeleccionarBajasActivosFijos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridBajasActivosFijos=null;
	public Boolean mostraridBajasActivosFijos=true;
	public Boolean activaridBajasActivosFijos=true;

	public Border resaltarid_empresaBajasActivosFijos=null;
	public Boolean mostrarid_empresaBajasActivosFijos=true;
	public Boolean activarid_empresaBajasActivosFijos=true;
	public Boolean cargarid_empresaBajasActivosFijos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaBajasActivosFijos=false;//ConEventDepend=true

	public Border resaltarcodigo_sub_grupoBajasActivosFijos=null;
	public Boolean mostrarcodigo_sub_grupoBajasActivosFijos=true;
	public Boolean activarcodigo_sub_grupoBajasActivosFijos=true;

	public Border resaltarnombre_sub_grupoBajasActivosFijos=null;
	public Boolean mostrarnombre_sub_grupoBajasActivosFijos=true;
	public Boolean activarnombre_sub_grupoBajasActivosFijos=true;

	public Border resaltarcodigo_detalle_grupoBajasActivosFijos=null;
	public Boolean mostrarcodigo_detalle_grupoBajasActivosFijos=true;
	public Boolean activarcodigo_detalle_grupoBajasActivosFijos=true;

	public Border resaltarnombre_detalle_grupoBajasActivosFijos=null;
	public Boolean mostrarnombre_detalle_grupoBajasActivosFijos=true;
	public Boolean activarnombre_detalle_grupoBajasActivosFijos=true;

	public Border resaltarclaveBajasActivosFijos=null;
	public Boolean mostrarclaveBajasActivosFijos=true;
	public Boolean activarclaveBajasActivosFijos=true;

	public Border resaltarnombreBajasActivosFijos=null;
	public Boolean mostrarnombreBajasActivosFijos=true;
	public Boolean activarnombreBajasActivosFijos=true;

	public Border resaltarfecha_compraBajasActivosFijos=null;
	public Boolean mostrarfecha_compraBajasActivosFijos=true;
	public Boolean activarfecha_compraBajasActivosFijos=true;

	public Border resaltarvida_utilBajasActivosFijos=null;
	public Boolean mostrarvida_utilBajasActivosFijos=true;
	public Boolean activarvida_utilBajasActivosFijos=true;

	public Border resaltarcosto_de_compraBajasActivosFijos=null;
	public Boolean mostrarcosto_de_compraBajasActivosFijos=true;
	public Boolean activarcosto_de_compraBajasActivosFijos=true;

	
	

	public Border setResaltaridBajasActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*BajasActivosFijosBeanSwingJInternalFrame bajasactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bajasactivosfijosBeanSwingJInternalFrame.jTtoolBarBajasActivosFijos.setBorder(borderResaltar);
		
		this.resaltaridBajasActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridBajasActivosFijos() {
		return this.resaltaridBajasActivosFijos;
	}

	public void setResaltaridBajasActivosFijos(Border borderResaltar) {
		this.resaltaridBajasActivosFijos= borderResaltar;
	}

	public Boolean getMostraridBajasActivosFijos() {
		return this.mostraridBajasActivosFijos;
	}

	public void setMostraridBajasActivosFijos(Boolean mostraridBajasActivosFijos) {
		this.mostraridBajasActivosFijos= mostraridBajasActivosFijos;
	}

	public Boolean getActivaridBajasActivosFijos() {
		return this.activaridBajasActivosFijos;
	}

	public void setActivaridBajasActivosFijos(Boolean activaridBajasActivosFijos) {
		this.activaridBajasActivosFijos= activaridBajasActivosFijos;
	}

	public Border setResaltarid_empresaBajasActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*BajasActivosFijosBeanSwingJInternalFrame bajasactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bajasactivosfijosBeanSwingJInternalFrame.jTtoolBarBajasActivosFijos.setBorder(borderResaltar);
		
		this.resaltarid_empresaBajasActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaBajasActivosFijos() {
		return this.resaltarid_empresaBajasActivosFijos;
	}

	public void setResaltarid_empresaBajasActivosFijos(Border borderResaltar) {
		this.resaltarid_empresaBajasActivosFijos= borderResaltar;
	}

	public Boolean getMostrarid_empresaBajasActivosFijos() {
		return this.mostrarid_empresaBajasActivosFijos;
	}

	public void setMostrarid_empresaBajasActivosFijos(Boolean mostrarid_empresaBajasActivosFijos) {
		this.mostrarid_empresaBajasActivosFijos= mostrarid_empresaBajasActivosFijos;
	}

	public Boolean getActivarid_empresaBajasActivosFijos() {
		return this.activarid_empresaBajasActivosFijos;
	}

	public void setActivarid_empresaBajasActivosFijos(Boolean activarid_empresaBajasActivosFijos) {
		this.activarid_empresaBajasActivosFijos= activarid_empresaBajasActivosFijos;
	}

	public Boolean getCargarid_empresaBajasActivosFijos() {
		return this.cargarid_empresaBajasActivosFijos;
	}

	public void setCargarid_empresaBajasActivosFijos(Boolean cargarid_empresaBajasActivosFijos) {
		this.cargarid_empresaBajasActivosFijos= cargarid_empresaBajasActivosFijos;
	}

	public Border setResaltarcodigo_sub_grupoBajasActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*BajasActivosFijosBeanSwingJInternalFrame bajasactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bajasactivosfijosBeanSwingJInternalFrame.jTtoolBarBajasActivosFijos.setBorder(borderResaltar);
		
		this.resaltarcodigo_sub_grupoBajasActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_sub_grupoBajasActivosFijos() {
		return this.resaltarcodigo_sub_grupoBajasActivosFijos;
	}

	public void setResaltarcodigo_sub_grupoBajasActivosFijos(Border borderResaltar) {
		this.resaltarcodigo_sub_grupoBajasActivosFijos= borderResaltar;
	}

	public Boolean getMostrarcodigo_sub_grupoBajasActivosFijos() {
		return this.mostrarcodigo_sub_grupoBajasActivosFijos;
	}

	public void setMostrarcodigo_sub_grupoBajasActivosFijos(Boolean mostrarcodigo_sub_grupoBajasActivosFijos) {
		this.mostrarcodigo_sub_grupoBajasActivosFijos= mostrarcodigo_sub_grupoBajasActivosFijos;
	}

	public Boolean getActivarcodigo_sub_grupoBajasActivosFijos() {
		return this.activarcodigo_sub_grupoBajasActivosFijos;
	}

	public void setActivarcodigo_sub_grupoBajasActivosFijos(Boolean activarcodigo_sub_grupoBajasActivosFijos) {
		this.activarcodigo_sub_grupoBajasActivosFijos= activarcodigo_sub_grupoBajasActivosFijos;
	}

	public Border setResaltarnombre_sub_grupoBajasActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*BajasActivosFijosBeanSwingJInternalFrame bajasactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bajasactivosfijosBeanSwingJInternalFrame.jTtoolBarBajasActivosFijos.setBorder(borderResaltar);
		
		this.resaltarnombre_sub_grupoBajasActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sub_grupoBajasActivosFijos() {
		return this.resaltarnombre_sub_grupoBajasActivosFijos;
	}

	public void setResaltarnombre_sub_grupoBajasActivosFijos(Border borderResaltar) {
		this.resaltarnombre_sub_grupoBajasActivosFijos= borderResaltar;
	}

	public Boolean getMostrarnombre_sub_grupoBajasActivosFijos() {
		return this.mostrarnombre_sub_grupoBajasActivosFijos;
	}

	public void setMostrarnombre_sub_grupoBajasActivosFijos(Boolean mostrarnombre_sub_grupoBajasActivosFijos) {
		this.mostrarnombre_sub_grupoBajasActivosFijos= mostrarnombre_sub_grupoBajasActivosFijos;
	}

	public Boolean getActivarnombre_sub_grupoBajasActivosFijos() {
		return this.activarnombre_sub_grupoBajasActivosFijos;
	}

	public void setActivarnombre_sub_grupoBajasActivosFijos(Boolean activarnombre_sub_grupoBajasActivosFijos) {
		this.activarnombre_sub_grupoBajasActivosFijos= activarnombre_sub_grupoBajasActivosFijos;
	}

	public Border setResaltarcodigo_detalle_grupoBajasActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*BajasActivosFijosBeanSwingJInternalFrame bajasactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bajasactivosfijosBeanSwingJInternalFrame.jTtoolBarBajasActivosFijos.setBorder(borderResaltar);
		
		this.resaltarcodigo_detalle_grupoBajasActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_detalle_grupoBajasActivosFijos() {
		return this.resaltarcodigo_detalle_grupoBajasActivosFijos;
	}

	public void setResaltarcodigo_detalle_grupoBajasActivosFijos(Border borderResaltar) {
		this.resaltarcodigo_detalle_grupoBajasActivosFijos= borderResaltar;
	}

	public Boolean getMostrarcodigo_detalle_grupoBajasActivosFijos() {
		return this.mostrarcodigo_detalle_grupoBajasActivosFijos;
	}

	public void setMostrarcodigo_detalle_grupoBajasActivosFijos(Boolean mostrarcodigo_detalle_grupoBajasActivosFijos) {
		this.mostrarcodigo_detalle_grupoBajasActivosFijos= mostrarcodigo_detalle_grupoBajasActivosFijos;
	}

	public Boolean getActivarcodigo_detalle_grupoBajasActivosFijos() {
		return this.activarcodigo_detalle_grupoBajasActivosFijos;
	}

	public void setActivarcodigo_detalle_grupoBajasActivosFijos(Boolean activarcodigo_detalle_grupoBajasActivosFijos) {
		this.activarcodigo_detalle_grupoBajasActivosFijos= activarcodigo_detalle_grupoBajasActivosFijos;
	}

	public Border setResaltarnombre_detalle_grupoBajasActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*BajasActivosFijosBeanSwingJInternalFrame bajasactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bajasactivosfijosBeanSwingJInternalFrame.jTtoolBarBajasActivosFijos.setBorder(borderResaltar);
		
		this.resaltarnombre_detalle_grupoBajasActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_detalle_grupoBajasActivosFijos() {
		return this.resaltarnombre_detalle_grupoBajasActivosFijos;
	}

	public void setResaltarnombre_detalle_grupoBajasActivosFijos(Border borderResaltar) {
		this.resaltarnombre_detalle_grupoBajasActivosFijos= borderResaltar;
	}

	public Boolean getMostrarnombre_detalle_grupoBajasActivosFijos() {
		return this.mostrarnombre_detalle_grupoBajasActivosFijos;
	}

	public void setMostrarnombre_detalle_grupoBajasActivosFijos(Boolean mostrarnombre_detalle_grupoBajasActivosFijos) {
		this.mostrarnombre_detalle_grupoBajasActivosFijos= mostrarnombre_detalle_grupoBajasActivosFijos;
	}

	public Boolean getActivarnombre_detalle_grupoBajasActivosFijos() {
		return this.activarnombre_detalle_grupoBajasActivosFijos;
	}

	public void setActivarnombre_detalle_grupoBajasActivosFijos(Boolean activarnombre_detalle_grupoBajasActivosFijos) {
		this.activarnombre_detalle_grupoBajasActivosFijos= activarnombre_detalle_grupoBajasActivosFijos;
	}

	public Border setResaltarclaveBajasActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*BajasActivosFijosBeanSwingJInternalFrame bajasactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bajasactivosfijosBeanSwingJInternalFrame.jTtoolBarBajasActivosFijos.setBorder(borderResaltar);
		
		this.resaltarclaveBajasActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarclaveBajasActivosFijos() {
		return this.resaltarclaveBajasActivosFijos;
	}

	public void setResaltarclaveBajasActivosFijos(Border borderResaltar) {
		this.resaltarclaveBajasActivosFijos= borderResaltar;
	}

	public Boolean getMostrarclaveBajasActivosFijos() {
		return this.mostrarclaveBajasActivosFijos;
	}

	public void setMostrarclaveBajasActivosFijos(Boolean mostrarclaveBajasActivosFijos) {
		this.mostrarclaveBajasActivosFijos= mostrarclaveBajasActivosFijos;
	}

	public Boolean getActivarclaveBajasActivosFijos() {
		return this.activarclaveBajasActivosFijos;
	}

	public void setActivarclaveBajasActivosFijos(Boolean activarclaveBajasActivosFijos) {
		this.activarclaveBajasActivosFijos= activarclaveBajasActivosFijos;
	}

	public Border setResaltarnombreBajasActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*BajasActivosFijosBeanSwingJInternalFrame bajasactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bajasactivosfijosBeanSwingJInternalFrame.jTtoolBarBajasActivosFijos.setBorder(borderResaltar);
		
		this.resaltarnombreBajasActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreBajasActivosFijos() {
		return this.resaltarnombreBajasActivosFijos;
	}

	public void setResaltarnombreBajasActivosFijos(Border borderResaltar) {
		this.resaltarnombreBajasActivosFijos= borderResaltar;
	}

	public Boolean getMostrarnombreBajasActivosFijos() {
		return this.mostrarnombreBajasActivosFijos;
	}

	public void setMostrarnombreBajasActivosFijos(Boolean mostrarnombreBajasActivosFijos) {
		this.mostrarnombreBajasActivosFijos= mostrarnombreBajasActivosFijos;
	}

	public Boolean getActivarnombreBajasActivosFijos() {
		return this.activarnombreBajasActivosFijos;
	}

	public void setActivarnombreBajasActivosFijos(Boolean activarnombreBajasActivosFijos) {
		this.activarnombreBajasActivosFijos= activarnombreBajasActivosFijos;
	}

	public Border setResaltarfecha_compraBajasActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*BajasActivosFijosBeanSwingJInternalFrame bajasactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bajasactivosfijosBeanSwingJInternalFrame.jTtoolBarBajasActivosFijos.setBorder(borderResaltar);
		
		this.resaltarfecha_compraBajasActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_compraBajasActivosFijos() {
		return this.resaltarfecha_compraBajasActivosFijos;
	}

	public void setResaltarfecha_compraBajasActivosFijos(Border borderResaltar) {
		this.resaltarfecha_compraBajasActivosFijos= borderResaltar;
	}

	public Boolean getMostrarfecha_compraBajasActivosFijos() {
		return this.mostrarfecha_compraBajasActivosFijos;
	}

	public void setMostrarfecha_compraBajasActivosFijos(Boolean mostrarfecha_compraBajasActivosFijos) {
		this.mostrarfecha_compraBajasActivosFijos= mostrarfecha_compraBajasActivosFijos;
	}

	public Boolean getActivarfecha_compraBajasActivosFijos() {
		return this.activarfecha_compraBajasActivosFijos;
	}

	public void setActivarfecha_compraBajasActivosFijos(Boolean activarfecha_compraBajasActivosFijos) {
		this.activarfecha_compraBajasActivosFijos= activarfecha_compraBajasActivosFijos;
	}

	public Border setResaltarvida_utilBajasActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*BajasActivosFijosBeanSwingJInternalFrame bajasactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bajasactivosfijosBeanSwingJInternalFrame.jTtoolBarBajasActivosFijos.setBorder(borderResaltar);
		
		this.resaltarvida_utilBajasActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvida_utilBajasActivosFijos() {
		return this.resaltarvida_utilBajasActivosFijos;
	}

	public void setResaltarvida_utilBajasActivosFijos(Border borderResaltar) {
		this.resaltarvida_utilBajasActivosFijos= borderResaltar;
	}

	public Boolean getMostrarvida_utilBajasActivosFijos() {
		return this.mostrarvida_utilBajasActivosFijos;
	}

	public void setMostrarvida_utilBajasActivosFijos(Boolean mostrarvida_utilBajasActivosFijos) {
		this.mostrarvida_utilBajasActivosFijos= mostrarvida_utilBajasActivosFijos;
	}

	public Boolean getActivarvida_utilBajasActivosFijos() {
		return this.activarvida_utilBajasActivosFijos;
	}

	public void setActivarvida_utilBajasActivosFijos(Boolean activarvida_utilBajasActivosFijos) {
		this.activarvida_utilBajasActivosFijos= activarvida_utilBajasActivosFijos;
	}

	public Border setResaltarcosto_de_compraBajasActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*BajasActivosFijosBeanSwingJInternalFrame bajasactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bajasactivosfijosBeanSwingJInternalFrame.jTtoolBarBajasActivosFijos.setBorder(borderResaltar);
		
		this.resaltarcosto_de_compraBajasActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_de_compraBajasActivosFijos() {
		return this.resaltarcosto_de_compraBajasActivosFijos;
	}

	public void setResaltarcosto_de_compraBajasActivosFijos(Border borderResaltar) {
		this.resaltarcosto_de_compraBajasActivosFijos= borderResaltar;
	}

	public Boolean getMostrarcosto_de_compraBajasActivosFijos() {
		return this.mostrarcosto_de_compraBajasActivosFijos;
	}

	public void setMostrarcosto_de_compraBajasActivosFijos(Boolean mostrarcosto_de_compraBajasActivosFijos) {
		this.mostrarcosto_de_compraBajasActivosFijos= mostrarcosto_de_compraBajasActivosFijos;
	}

	public Boolean getActivarcosto_de_compraBajasActivosFijos() {
		return this.activarcosto_de_compraBajasActivosFijos;
	}

	public void setActivarcosto_de_compraBajasActivosFijos(Boolean activarcosto_de_compraBajasActivosFijos) {
		this.activarcosto_de_compraBajasActivosFijos= activarcosto_de_compraBajasActivosFijos;
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
		
		
		this.setMostraridBajasActivosFijos(esInicial);
		this.setMostrarid_empresaBajasActivosFijos(esInicial);
		this.setMostrarcodigo_sub_grupoBajasActivosFijos(esInicial);
		this.setMostrarnombre_sub_grupoBajasActivosFijos(esInicial);
		this.setMostrarcodigo_detalle_grupoBajasActivosFijos(esInicial);
		this.setMostrarnombre_detalle_grupoBajasActivosFijos(esInicial);
		this.setMostrarclaveBajasActivosFijos(esInicial);
		this.setMostrarnombreBajasActivosFijos(esInicial);
		this.setMostrarfecha_compraBajasActivosFijos(esInicial);
		this.setMostrarvida_utilBajasActivosFijos(esInicial);
		this.setMostrarcosto_de_compraBajasActivosFijos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.ID)) {
				this.setMostraridBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setMostrarcodigo_sub_grupoBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setMostrarnombre_sub_grupoBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setMostrarcodigo_detalle_grupoBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setMostrarnombre_detalle_grupoBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.CLAVE)) {
				this.setMostrarclaveBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.FECHACOMPRA)) {
				this.setMostrarfecha_compraBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.VIDAUTIL)) {
				this.setMostrarvida_utilBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.COSTODECOMPRA)) {
				this.setMostrarcosto_de_compraBajasActivosFijos(esAsigna);
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
		
		
		this.setActivaridBajasActivosFijos(esInicial);
		this.setActivarid_empresaBajasActivosFijos(esInicial);
		this.setActivarcodigo_sub_grupoBajasActivosFijos(esInicial);
		this.setActivarnombre_sub_grupoBajasActivosFijos(esInicial);
		this.setActivarcodigo_detalle_grupoBajasActivosFijos(esInicial);
		this.setActivarnombre_detalle_grupoBajasActivosFijos(esInicial);
		this.setActivarclaveBajasActivosFijos(esInicial);
		this.setActivarnombreBajasActivosFijos(esInicial);
		this.setActivarfecha_compraBajasActivosFijos(esInicial);
		this.setActivarvida_utilBajasActivosFijos(esInicial);
		this.setActivarcosto_de_compraBajasActivosFijos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.ID)) {
				this.setActivaridBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setActivarcodigo_sub_grupoBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setActivarnombre_sub_grupoBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setActivarcodigo_detalle_grupoBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setActivarnombre_detalle_grupoBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.CLAVE)) {
				this.setActivarclaveBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.FECHACOMPRA)) {
				this.setActivarfecha_compraBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.VIDAUTIL)) {
				this.setActivarvida_utilBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.COSTODECOMPRA)) {
				this.setActivarcosto_de_compraBajasActivosFijos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,BajasActivosFijosBeanSwingJInternalFrame bajasactivosfijosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridBajasActivosFijos(esInicial);
		this.setResaltarid_empresaBajasActivosFijos(esInicial);
		this.setResaltarcodigo_sub_grupoBajasActivosFijos(esInicial);
		this.setResaltarnombre_sub_grupoBajasActivosFijos(esInicial);
		this.setResaltarcodigo_detalle_grupoBajasActivosFijos(esInicial);
		this.setResaltarnombre_detalle_grupoBajasActivosFijos(esInicial);
		this.setResaltarclaveBajasActivosFijos(esInicial);
		this.setResaltarnombreBajasActivosFijos(esInicial);
		this.setResaltarfecha_compraBajasActivosFijos(esInicial);
		this.setResaltarvida_utilBajasActivosFijos(esInicial);
		this.setResaltarcosto_de_compraBajasActivosFijos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.ID)) {
				this.setResaltaridBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setResaltarcodigo_sub_grupoBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setResaltarnombre_sub_grupoBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setResaltarcodigo_detalle_grupoBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setResaltarnombre_detalle_grupoBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.CLAVE)) {
				this.setResaltarclaveBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.FECHACOMPRA)) {
				this.setResaltarfecha_compraBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.VIDAUTIL)) {
				this.setResaltarvida_utilBajasActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(BajasActivosFijosConstantesFunciones.COSTODECOMPRA)) {
				this.setResaltarcosto_de_compraBajasActivosFijos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,BajasActivosFijosBeanSwingJInternalFrame bajasactivosfijosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaBajasActivosFijosBajasActivosFijos=true;

	public Boolean getMostrarBusquedaBajasActivosFijosBajasActivosFijos() {
		return this.mostrarBusquedaBajasActivosFijosBajasActivosFijos;
	}

	public void setMostrarBusquedaBajasActivosFijosBajasActivosFijos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaBajasActivosFijosBajasActivosFijos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaBajasActivosFijosBajasActivosFijos=true;

	public Boolean getActivarBusquedaBajasActivosFijosBajasActivosFijos() {
		return this.activarBusquedaBajasActivosFijosBajasActivosFijos;
	}

	public void setActivarBusquedaBajasActivosFijosBajasActivosFijos(Boolean habilitarResaltar) {
		this.activarBusquedaBajasActivosFijosBajasActivosFijos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaBajasActivosFijosBajasActivosFijos=null;

	public Border getResaltarBusquedaBajasActivosFijosBajasActivosFijos() {
		return this.resaltarBusquedaBajasActivosFijosBajasActivosFijos;
	}

	public void setResaltarBusquedaBajasActivosFijosBajasActivosFijos(Border borderResaltar) {
		this.resaltarBusquedaBajasActivosFijosBajasActivosFijos= borderResaltar;
	}

	public void setResaltarBusquedaBajasActivosFijosBajasActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*BajasActivosFijosBeanSwingJInternalFrame bajasactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaBajasActivosFijosBajasActivosFijos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}