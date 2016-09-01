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


import com.bydan.erp.activosfijos.util.report.ListadoActivosFijosConstantesFunciones;
import com.bydan.erp.activosfijos.util.report.ListadoActivosFijosParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.ListadoActivosFijosParameterGeneral;

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
final public class ListadoActivosFijosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ListadoActivosFijos";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ListadoActivosFijos"+ListadoActivosFijosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ListadoActivosFijosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ListadoActivosFijosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ListadoActivosFijosConstantesFunciones.SCHEMA+"_"+ListadoActivosFijosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ListadoActivosFijosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ListadoActivosFijosConstantesFunciones.SCHEMA+"_"+ListadoActivosFijosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ListadoActivosFijosConstantesFunciones.SCHEMA+"_"+ListadoActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ListadoActivosFijosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ListadoActivosFijosConstantesFunciones.SCHEMA+"_"+ListadoActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadoActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ListadoActivosFijosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadoActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadoActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ListadoActivosFijosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadoActivosFijosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ListadoActivosFijosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ListadoActivosFijosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ListadoActivosFijosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ListadoActivosFijosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Listado Activos Fijoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Listado Activos Fijos";
	public static final String SCLASSWEBTITULO_LOWER="Listado Activos Fijos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ListadoActivosFijos";
	public static final String OBJECTNAME="listadoactivosfijos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="listado_activos_fijos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select listadoactivosfijos from "+ListadoActivosFijosConstantesFunciones.SPERSISTENCENAME+" listadoactivosfijos";
	public static String QUERYSELECTNATIVE="select "+ListadoActivosFijosConstantesFunciones.SCHEMA+"."+ListadoActivosFijosConstantesFunciones.TABLENAME+".id,"+ListadoActivosFijosConstantesFunciones.SCHEMA+"."+ListadoActivosFijosConstantesFunciones.TABLENAME+".version_row,"+ListadoActivosFijosConstantesFunciones.SCHEMA+"."+ListadoActivosFijosConstantesFunciones.TABLENAME+".id_empresa,"+ListadoActivosFijosConstantesFunciones.SCHEMA+"."+ListadoActivosFijosConstantesFunciones.TABLENAME+".codigo_sub_grupo,"+ListadoActivosFijosConstantesFunciones.SCHEMA+"."+ListadoActivosFijosConstantesFunciones.TABLENAME+".nombre_sub_grupo,"+ListadoActivosFijosConstantesFunciones.SCHEMA+"."+ListadoActivosFijosConstantesFunciones.TABLENAME+".codigo_detalle_grupo,"+ListadoActivosFijosConstantesFunciones.SCHEMA+"."+ListadoActivosFijosConstantesFunciones.TABLENAME+".nombre_detalle_grupo,"+ListadoActivosFijosConstantesFunciones.SCHEMA+"."+ListadoActivosFijosConstantesFunciones.TABLENAME+".clave,"+ListadoActivosFijosConstantesFunciones.SCHEMA+"."+ListadoActivosFijosConstantesFunciones.TABLENAME+".nombre,"+ListadoActivosFijosConstantesFunciones.SCHEMA+"."+ListadoActivosFijosConstantesFunciones.TABLENAME+".fecha_compra,"+ListadoActivosFijosConstantesFunciones.SCHEMA+"."+ListadoActivosFijosConstantesFunciones.TABLENAME+".vida_util,"+ListadoActivosFijosConstantesFunciones.SCHEMA+"."+ListadoActivosFijosConstantesFunciones.TABLENAME+".costo_de_compra from "+ListadoActivosFijosConstantesFunciones.SCHEMA+"."+ListadoActivosFijosConstantesFunciones.TABLENAME;//+" as "+ListadoActivosFijosConstantesFunciones.TABLENAME;
	
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
		
		
		
	
	public static String getListadoActivosFijosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ListadoActivosFijosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ListadoActivosFijosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ListadoActivosFijosConstantesFunciones.CODIGOSUBGRUPO)) {sLabelColumna=ListadoActivosFijosConstantesFunciones.LABEL_CODIGOSUBGRUPO;}
		if(sNombreColumna.equals(ListadoActivosFijosConstantesFunciones.NOMBRESUBGRUPO)) {sLabelColumna=ListadoActivosFijosConstantesFunciones.LABEL_NOMBRESUBGRUPO;}
		if(sNombreColumna.equals(ListadoActivosFijosConstantesFunciones.CODIGODETALLEGRUPO)) {sLabelColumna=ListadoActivosFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO;}
		if(sNombreColumna.equals(ListadoActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO)) {sLabelColumna=ListadoActivosFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO;}
		if(sNombreColumna.equals(ListadoActivosFijosConstantesFunciones.CLAVE)) {sLabelColumna=ListadoActivosFijosConstantesFunciones.LABEL_CLAVE;}
		if(sNombreColumna.equals(ListadoActivosFijosConstantesFunciones.NOMBRE)) {sLabelColumna=ListadoActivosFijosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ListadoActivosFijosConstantesFunciones.FECHACOMPRA)) {sLabelColumna=ListadoActivosFijosConstantesFunciones.LABEL_FECHACOMPRA;}
		if(sNombreColumna.equals(ListadoActivosFijosConstantesFunciones.VIDAUTIL)) {sLabelColumna=ListadoActivosFijosConstantesFunciones.LABEL_VIDAUTIL;}
		if(sNombreColumna.equals(ListadoActivosFijosConstantesFunciones.COSTODECOMPRA)) {sLabelColumna=ListadoActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getListadoActivosFijosDescripcion(ListadoActivosFijos listadoactivosfijos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(listadoactivosfijos !=null/* && listadoactivosfijos.getId()!=0*/) {
			sDescripcion=listadoactivosfijos.getnombre();//listadoactivosfijoslistadoactivosfijos.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getListadoActivosFijosDescripcionDetallado(ListadoActivosFijos listadoactivosfijos) {
		String sDescripcion="";
			
		sDescripcion+=ListadoActivosFijosConstantesFunciones.ID+"=";
		sDescripcion+=listadoactivosfijos.getId().toString()+",";
		sDescripcion+=ListadoActivosFijosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=listadoactivosfijos.getVersionRow().toString()+",";
		sDescripcion+=ListadoActivosFijosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=listadoactivosfijos.getid_empresa().toString()+",";
		sDescripcion+=ListadoActivosFijosConstantesFunciones.CODIGOSUBGRUPO+"=";
		sDescripcion+=listadoactivosfijos.getcodigo_sub_grupo()+",";
		sDescripcion+=ListadoActivosFijosConstantesFunciones.NOMBRESUBGRUPO+"=";
		sDescripcion+=listadoactivosfijos.getnombre_sub_grupo()+",";
		sDescripcion+=ListadoActivosFijosConstantesFunciones.CODIGODETALLEGRUPO+"=";
		sDescripcion+=listadoactivosfijos.getcodigo_detalle_grupo()+",";
		sDescripcion+=ListadoActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO+"=";
		sDescripcion+=listadoactivosfijos.getnombre_detalle_grupo()+",";
		sDescripcion+=ListadoActivosFijosConstantesFunciones.CLAVE+"=";
		sDescripcion+=listadoactivosfijos.getclave()+",";
		sDescripcion+=ListadoActivosFijosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=listadoactivosfijos.getnombre()+",";
		sDescripcion+=ListadoActivosFijosConstantesFunciones.FECHACOMPRA+"=";
		sDescripcion+=listadoactivosfijos.getfecha_compra().toString()+",";
		sDescripcion+=ListadoActivosFijosConstantesFunciones.VIDAUTIL+"=";
		sDescripcion+=listadoactivosfijos.getvida_util().toString()+",";
		sDescripcion+=ListadoActivosFijosConstantesFunciones.COSTODECOMPRA+"=";
		sDescripcion+=listadoactivosfijos.getcosto_de_compra().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setListadoActivosFijosDescripcion(ListadoActivosFijos listadoactivosfijos,String sValor) throws Exception {			
		if(listadoactivosfijos !=null) {
			listadoactivosfijos.setnombre(sValor);;//listadoactivosfijoslistadoactivosfijos.getnombre().trim();
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
		} else if(sNombreIndice.equals("BusquedaListadoActivosFijos")) {
			sNombreIndice="Tipo=  Por ";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaListadoActivosFijos(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" ="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosListadoActivosFijos(ListadoActivosFijos listadoactivosfijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		listadoactivosfijos.setcodigo_sub_grupo(listadoactivosfijos.getcodigo_sub_grupo().trim());
		listadoactivosfijos.setnombre_sub_grupo(listadoactivosfijos.getnombre_sub_grupo().trim());
		listadoactivosfijos.setcodigo_detalle_grupo(listadoactivosfijos.getcodigo_detalle_grupo().trim());
		listadoactivosfijos.setnombre_detalle_grupo(listadoactivosfijos.getnombre_detalle_grupo().trim());
		listadoactivosfijos.setclave(listadoactivosfijos.getclave().trim());
		listadoactivosfijos.setnombre(listadoactivosfijos.getnombre().trim());
	}
	
	public static void quitarEspaciosListadoActivosFijoss(List<ListadoActivosFijos> listadoactivosfijoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ListadoActivosFijos listadoactivosfijos: listadoactivosfijoss) {
			listadoactivosfijos.setcodigo_sub_grupo(listadoactivosfijos.getcodigo_sub_grupo().trim());
			listadoactivosfijos.setnombre_sub_grupo(listadoactivosfijos.getnombre_sub_grupo().trim());
			listadoactivosfijos.setcodigo_detalle_grupo(listadoactivosfijos.getcodigo_detalle_grupo().trim());
			listadoactivosfijos.setnombre_detalle_grupo(listadoactivosfijos.getnombre_detalle_grupo().trim());
			listadoactivosfijos.setclave(listadoactivosfijos.getclave().trim());
			listadoactivosfijos.setnombre(listadoactivosfijos.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresListadoActivosFijos(ListadoActivosFijos listadoactivosfijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && listadoactivosfijos.getConCambioAuxiliar()) {
			listadoactivosfijos.setIsDeleted(listadoactivosfijos.getIsDeletedAuxiliar());	
			listadoactivosfijos.setIsNew(listadoactivosfijos.getIsNewAuxiliar());	
			listadoactivosfijos.setIsChanged(listadoactivosfijos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			listadoactivosfijos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			listadoactivosfijos.setIsDeletedAuxiliar(false);	
			listadoactivosfijos.setIsNewAuxiliar(false);	
			listadoactivosfijos.setIsChangedAuxiliar(false);
			
			listadoactivosfijos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresListadoActivosFijoss(List<ListadoActivosFijos> listadoactivosfijoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ListadoActivosFijos listadoactivosfijos : listadoactivosfijoss) {
			if(conAsignarBase && listadoactivosfijos.getConCambioAuxiliar()) {
				listadoactivosfijos.setIsDeleted(listadoactivosfijos.getIsDeletedAuxiliar());	
				listadoactivosfijos.setIsNew(listadoactivosfijos.getIsNewAuxiliar());	
				listadoactivosfijos.setIsChanged(listadoactivosfijos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				listadoactivosfijos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				listadoactivosfijos.setIsDeletedAuxiliar(false);	
				listadoactivosfijos.setIsNewAuxiliar(false);	
				listadoactivosfijos.setIsChangedAuxiliar(false);
				
				listadoactivosfijos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresListadoActivosFijos(ListadoActivosFijos listadoactivosfijos,Boolean conEnteros) throws Exception  {
		listadoactivosfijos.setvida_util(0.0);
		listadoactivosfijos.setcosto_de_compra(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresListadoActivosFijoss(List<ListadoActivosFijos> listadoactivosfijoss,Boolean conEnteros) throws Exception  {
		
		for(ListadoActivosFijos listadoactivosfijos: listadoactivosfijoss) {
			listadoactivosfijos.setvida_util(0.0);
			listadoactivosfijos.setcosto_de_compra(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaListadoActivosFijos(List<ListadoActivosFijos> listadoactivosfijoss,ListadoActivosFijos listadoactivosfijosAux) throws Exception  {
		ListadoActivosFijosConstantesFunciones.InicializarValoresListadoActivosFijos(listadoactivosfijosAux,true);
		
		for(ListadoActivosFijos listadoactivosfijos: listadoactivosfijoss) {
			if(listadoactivosfijos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			listadoactivosfijosAux.setvida_util(listadoactivosfijosAux.getvida_util()+listadoactivosfijos.getvida_util());			
			listadoactivosfijosAux.setcosto_de_compra(listadoactivosfijosAux.getcosto_de_compra()+listadoactivosfijos.getcosto_de_compra());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesListadoActivosFijos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ListadoActivosFijosConstantesFunciones.getArrayColumnasGlobalesListadoActivosFijos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesListadoActivosFijos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ListadoActivosFijosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ListadoActivosFijosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoListadoActivosFijos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ListadoActivosFijos> listadoactivosfijoss,ListadoActivosFijos listadoactivosfijos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ListadoActivosFijos listadoactivosfijosAux: listadoactivosfijoss) {
			if(listadoactivosfijosAux!=null && listadoactivosfijos!=null) {
				if((listadoactivosfijosAux.getId()==null && listadoactivosfijos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(listadoactivosfijosAux.getId()!=null && listadoactivosfijos.getId()!=null){
					if(listadoactivosfijosAux.getId().equals(listadoactivosfijos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaListadoActivosFijos(List<ListadoActivosFijos> listadoactivosfijoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double vida_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
	
		for(ListadoActivosFijos listadoactivosfijos: listadoactivosfijoss) {			
			if(listadoactivosfijos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			vida_utilTotal+=listadoactivosfijos.getvida_util();
			costo_de_compraTotal+=listadoactivosfijos.getcosto_de_compra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadoActivosFijosConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(ListadoActivosFijosConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadoActivosFijosConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(ListadoActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA);
		datoGeneral.setdValorDouble(costo_de_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaListadoActivosFijos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ListadoActivosFijosConstantesFunciones.LABEL_ID, ListadoActivosFijosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoActivosFijosConstantesFunciones.LABEL_VERSIONROW, ListadoActivosFijosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoActivosFijosConstantesFunciones.LABEL_CODIGOSUBGRUPO, ListadoActivosFijosConstantesFunciones.CODIGOSUBGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoActivosFijosConstantesFunciones.LABEL_NOMBRESUBGRUPO, ListadoActivosFijosConstantesFunciones.NOMBRESUBGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoActivosFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO, ListadoActivosFijosConstantesFunciones.CODIGODETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoActivosFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO, ListadoActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoActivosFijosConstantesFunciones.LABEL_CLAVE, ListadoActivosFijosConstantesFunciones.CLAVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoActivosFijosConstantesFunciones.LABEL_NOMBRE, ListadoActivosFijosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoActivosFijosConstantesFunciones.LABEL_FECHACOMPRA, ListadoActivosFijosConstantesFunciones.FECHACOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoActivosFijosConstantesFunciones.LABEL_VIDAUTIL, ListadoActivosFijosConstantesFunciones.VIDAUTIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA, ListadoActivosFijosConstantesFunciones.COSTODECOMPRA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasListadoActivosFijos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ListadoActivosFijosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoActivosFijosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoActivosFijosConstantesFunciones.CODIGOSUBGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoActivosFijosConstantesFunciones.NOMBRESUBGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoActivosFijosConstantesFunciones.CODIGODETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoActivosFijosConstantesFunciones.CLAVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoActivosFijosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoActivosFijosConstantesFunciones.FECHACOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoActivosFijosConstantesFunciones.VIDAUTIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoActivosFijosConstantesFunciones.COSTODECOMPRA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadoActivosFijos() throws Exception  {
		return ListadoActivosFijosConstantesFunciones.getTiposSeleccionarListadoActivosFijos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadoActivosFijos(Boolean conFk) throws Exception  {
		return ListadoActivosFijosConstantesFunciones.getTiposSeleccionarListadoActivosFijos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadoActivosFijos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoActivosFijosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ListadoActivosFijosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoActivosFijosConstantesFunciones.LABEL_CODIGOSUBGRUPO);
			reporte.setsDescripcion(ListadoActivosFijosConstantesFunciones.LABEL_CODIGOSUBGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoActivosFijosConstantesFunciones.LABEL_NOMBRESUBGRUPO);
			reporte.setsDescripcion(ListadoActivosFijosConstantesFunciones.LABEL_NOMBRESUBGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoActivosFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
			reporte.setsDescripcion(ListadoActivosFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoActivosFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
			reporte.setsDescripcion(ListadoActivosFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoActivosFijosConstantesFunciones.LABEL_CLAVE);
			reporte.setsDescripcion(ListadoActivosFijosConstantesFunciones.LABEL_CLAVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoActivosFijosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ListadoActivosFijosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoActivosFijosConstantesFunciones.LABEL_FECHACOMPRA);
			reporte.setsDescripcion(ListadoActivosFijosConstantesFunciones.LABEL_FECHACOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoActivosFijosConstantesFunciones.LABEL_VIDAUTIL);
			reporte.setsDescripcion(ListadoActivosFijosConstantesFunciones.LABEL_VIDAUTIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA);
			reporte.setsDescripcion(ListadoActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesListadoActivosFijos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesListadoActivosFijos(ListadoActivosFijos listadoactivosfijosAux) throws Exception {
		
			listadoactivosfijosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(listadoactivosfijosAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesListadoActivosFijos(List<ListadoActivosFijos> listadoactivosfijossTemp) throws Exception {
		for(ListadoActivosFijos listadoactivosfijosAux:listadoactivosfijossTemp) {
			
			listadoactivosfijosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(listadoactivosfijosAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfListadoActivosFijos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfListadoActivosFijos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfListadoActivosFijos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ListadoActivosFijosConstantesFunciones.getClassesRelationshipsOfListadoActivosFijos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfListadoActivosFijos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfListadoActivosFijos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ListadoActivosFijosConstantesFunciones.getClassesRelationshipsFromStringsOfListadoActivosFijos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfListadoActivosFijos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ListadoActivosFijos listadoactivosfijos,List<ListadoActivosFijos> listadoactivosfijoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ListadoActivosFijos listadoactivosfijos,List<ListadoActivosFijos> listadoactivosfijoss) throws Exception {
		try	{			
			for(ListadoActivosFijos listadoactivosfijosLocal:listadoactivosfijoss) {
				if(listadoactivosfijosLocal.getId().equals(listadoactivosfijos.getId())) {
					listadoactivosfijosLocal.setIsSelected(listadoactivosfijos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesListadoActivosFijos(List<ListadoActivosFijos> listadoactivosfijossAux) throws Exception {
		//this.listadoactivosfijossAux=listadoactivosfijossAux;
		
		for(ListadoActivosFijos listadoactivosfijosAux:listadoactivosfijossAux) {
			if(listadoactivosfijosAux.getIsChanged()) {
				listadoactivosfijosAux.setIsChanged(false);
			}		
			
			if(listadoactivosfijosAux.getIsNew()) {
				listadoactivosfijosAux.setIsNew(false);
			}	
			
			if(listadoactivosfijosAux.getIsDeleted()) {
				listadoactivosfijosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesListadoActivosFijos(ListadoActivosFijos listadoactivosfijosAux) throws Exception {
		//this.listadoactivosfijosAux=listadoactivosfijosAux;
		
			if(listadoactivosfijosAux.getIsChanged()) {
				listadoactivosfijosAux.setIsChanged(false);
			}		
			
			if(listadoactivosfijosAux.getIsNew()) {
				listadoactivosfijosAux.setIsNew(false);
			}	
			
			if(listadoactivosfijosAux.getIsDeleted()) {
				listadoactivosfijosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ListadoActivosFijos listadoactivosfijosAsignar,ListadoActivosFijos listadoactivosfijos) throws Exception {
		listadoactivosfijosAsignar.setId(listadoactivosfijos.getId());	
		listadoactivosfijosAsignar.setVersionRow(listadoactivosfijos.getVersionRow());	
		listadoactivosfijosAsignar.setcodigo_sub_grupo(listadoactivosfijos.getcodigo_sub_grupo());	
		listadoactivosfijosAsignar.setnombre_sub_grupo(listadoactivosfijos.getnombre_sub_grupo());	
		listadoactivosfijosAsignar.setcodigo_detalle_grupo(listadoactivosfijos.getcodigo_detalle_grupo());	
		listadoactivosfijosAsignar.setnombre_detalle_grupo(listadoactivosfijos.getnombre_detalle_grupo());	
		listadoactivosfijosAsignar.setclave(listadoactivosfijos.getclave());	
		listadoactivosfijosAsignar.setnombre(listadoactivosfijos.getnombre());	
		listadoactivosfijosAsignar.setfecha_compra(listadoactivosfijos.getfecha_compra());	
		listadoactivosfijosAsignar.setvida_util(listadoactivosfijos.getvida_util());	
		listadoactivosfijosAsignar.setcosto_de_compra(listadoactivosfijos.getcosto_de_compra());	
	}
	
	public static void inicializarListadoActivosFijos(ListadoActivosFijos listadoactivosfijos) throws Exception {
		try {
				listadoactivosfijos.setId(0L);	
					
				listadoactivosfijos.setcodigo_sub_grupo("");	
				listadoactivosfijos.setnombre_sub_grupo("");	
				listadoactivosfijos.setcodigo_detalle_grupo("");	
				listadoactivosfijos.setnombre_detalle_grupo("");	
				listadoactivosfijos.setclave("");	
				listadoactivosfijos.setnombre("");	
				listadoactivosfijos.setfecha_compra(new Date());	
				listadoactivosfijos.setvida_util(0.0);	
				listadoactivosfijos.setcosto_de_compra(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderListadoActivosFijos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoActivosFijosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoActivosFijosConstantesFunciones.LABEL_CODIGOSUBGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoActivosFijosConstantesFunciones.LABEL_NOMBRESUBGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoActivosFijosConstantesFunciones.LABEL_CODIGODETALLEGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoActivosFijosConstantesFunciones.LABEL_NOMBREDETALLEGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoActivosFijosConstantesFunciones.LABEL_CLAVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoActivosFijosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoActivosFijosConstantesFunciones.LABEL_FECHACOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoActivosFijosConstantesFunciones.LABEL_VIDAUTIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataListadoActivosFijos(String sTipo,Row row,Workbook workbook,ListadoActivosFijos listadoactivosfijos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoactivosfijos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoactivosfijos.getcodigo_sub_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoactivosfijos.getnombre_sub_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoactivosfijos.getcodigo_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoactivosfijos.getnombre_detalle_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoactivosfijos.getclave());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoactivosfijos.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoactivosfijos.getfecha_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoactivosfijos.getvida_util());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoactivosfijos.getcosto_de_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryListadoActivosFijos="";
	
	public String getsFinalQueryListadoActivosFijos() {
		return this.sFinalQueryListadoActivosFijos;
	}
	
	public void setsFinalQueryListadoActivosFijos(String sFinalQueryListadoActivosFijos) {
		this.sFinalQueryListadoActivosFijos= sFinalQueryListadoActivosFijos;
	}
	
	public Border resaltarSeleccionarListadoActivosFijos=null;
	
	public Border setResaltarSeleccionarListadoActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoActivosFijosBeanSwingJInternalFrame listadoactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//listadoactivosfijosBeanSwingJInternalFrame.jTtoolBarListadoActivosFijos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarListadoActivosFijos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarListadoActivosFijos() {
		return this.resaltarSeleccionarListadoActivosFijos;
	}
	
	public void setResaltarSeleccionarListadoActivosFijos(Border borderResaltarSeleccionarListadoActivosFijos) {
		this.resaltarSeleccionarListadoActivosFijos= borderResaltarSeleccionarListadoActivosFijos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridListadoActivosFijos=null;
	public Boolean mostraridListadoActivosFijos=true;
	public Boolean activaridListadoActivosFijos=true;

	public Border resaltarid_empresaListadoActivosFijos=null;
	public Boolean mostrarid_empresaListadoActivosFijos=true;
	public Boolean activarid_empresaListadoActivosFijos=true;
	public Boolean cargarid_empresaListadoActivosFijos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaListadoActivosFijos=false;//ConEventDepend=true

	public Border resaltarcodigo_sub_grupoListadoActivosFijos=null;
	public Boolean mostrarcodigo_sub_grupoListadoActivosFijos=true;
	public Boolean activarcodigo_sub_grupoListadoActivosFijos=true;

	public Border resaltarnombre_sub_grupoListadoActivosFijos=null;
	public Boolean mostrarnombre_sub_grupoListadoActivosFijos=true;
	public Boolean activarnombre_sub_grupoListadoActivosFijos=true;

	public Border resaltarcodigo_detalle_grupoListadoActivosFijos=null;
	public Boolean mostrarcodigo_detalle_grupoListadoActivosFijos=true;
	public Boolean activarcodigo_detalle_grupoListadoActivosFijos=true;

	public Border resaltarnombre_detalle_grupoListadoActivosFijos=null;
	public Boolean mostrarnombre_detalle_grupoListadoActivosFijos=true;
	public Boolean activarnombre_detalle_grupoListadoActivosFijos=true;

	public Border resaltarclaveListadoActivosFijos=null;
	public Boolean mostrarclaveListadoActivosFijos=true;
	public Boolean activarclaveListadoActivosFijos=true;

	public Border resaltarnombreListadoActivosFijos=null;
	public Boolean mostrarnombreListadoActivosFijos=true;
	public Boolean activarnombreListadoActivosFijos=true;

	public Border resaltarfecha_compraListadoActivosFijos=null;
	public Boolean mostrarfecha_compraListadoActivosFijos=true;
	public Boolean activarfecha_compraListadoActivosFijos=true;

	public Border resaltarvida_utilListadoActivosFijos=null;
	public Boolean mostrarvida_utilListadoActivosFijos=true;
	public Boolean activarvida_utilListadoActivosFijos=true;

	public Border resaltarcosto_de_compraListadoActivosFijos=null;
	public Boolean mostrarcosto_de_compraListadoActivosFijos=true;
	public Boolean activarcosto_de_compraListadoActivosFijos=true;

	
	

	public Border setResaltaridListadoActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoActivosFijosBeanSwingJInternalFrame listadoactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoactivosfijosBeanSwingJInternalFrame.jTtoolBarListadoActivosFijos.setBorder(borderResaltar);
		
		this.resaltaridListadoActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridListadoActivosFijos() {
		return this.resaltaridListadoActivosFijos;
	}

	public void setResaltaridListadoActivosFijos(Border borderResaltar) {
		this.resaltaridListadoActivosFijos= borderResaltar;
	}

	public Boolean getMostraridListadoActivosFijos() {
		return this.mostraridListadoActivosFijos;
	}

	public void setMostraridListadoActivosFijos(Boolean mostraridListadoActivosFijos) {
		this.mostraridListadoActivosFijos= mostraridListadoActivosFijos;
	}

	public Boolean getActivaridListadoActivosFijos() {
		return this.activaridListadoActivosFijos;
	}

	public void setActivaridListadoActivosFijos(Boolean activaridListadoActivosFijos) {
		this.activaridListadoActivosFijos= activaridListadoActivosFijos;
	}

	public Border setResaltarid_empresaListadoActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoActivosFijosBeanSwingJInternalFrame listadoactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoactivosfijosBeanSwingJInternalFrame.jTtoolBarListadoActivosFijos.setBorder(borderResaltar);
		
		this.resaltarid_empresaListadoActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaListadoActivosFijos() {
		return this.resaltarid_empresaListadoActivosFijos;
	}

	public void setResaltarid_empresaListadoActivosFijos(Border borderResaltar) {
		this.resaltarid_empresaListadoActivosFijos= borderResaltar;
	}

	public Boolean getMostrarid_empresaListadoActivosFijos() {
		return this.mostrarid_empresaListadoActivosFijos;
	}

	public void setMostrarid_empresaListadoActivosFijos(Boolean mostrarid_empresaListadoActivosFijos) {
		this.mostrarid_empresaListadoActivosFijos= mostrarid_empresaListadoActivosFijos;
	}

	public Boolean getActivarid_empresaListadoActivosFijos() {
		return this.activarid_empresaListadoActivosFijos;
	}

	public void setActivarid_empresaListadoActivosFijos(Boolean activarid_empresaListadoActivosFijos) {
		this.activarid_empresaListadoActivosFijos= activarid_empresaListadoActivosFijos;
	}

	public Boolean getCargarid_empresaListadoActivosFijos() {
		return this.cargarid_empresaListadoActivosFijos;
	}

	public void setCargarid_empresaListadoActivosFijos(Boolean cargarid_empresaListadoActivosFijos) {
		this.cargarid_empresaListadoActivosFijos= cargarid_empresaListadoActivosFijos;
	}

	public Border setResaltarcodigo_sub_grupoListadoActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoActivosFijosBeanSwingJInternalFrame listadoactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoactivosfijosBeanSwingJInternalFrame.jTtoolBarListadoActivosFijos.setBorder(borderResaltar);
		
		this.resaltarcodigo_sub_grupoListadoActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_sub_grupoListadoActivosFijos() {
		return this.resaltarcodigo_sub_grupoListadoActivosFijos;
	}

	public void setResaltarcodigo_sub_grupoListadoActivosFijos(Border borderResaltar) {
		this.resaltarcodigo_sub_grupoListadoActivosFijos= borderResaltar;
	}

	public Boolean getMostrarcodigo_sub_grupoListadoActivosFijos() {
		return this.mostrarcodigo_sub_grupoListadoActivosFijos;
	}

	public void setMostrarcodigo_sub_grupoListadoActivosFijos(Boolean mostrarcodigo_sub_grupoListadoActivosFijos) {
		this.mostrarcodigo_sub_grupoListadoActivosFijos= mostrarcodigo_sub_grupoListadoActivosFijos;
	}

	public Boolean getActivarcodigo_sub_grupoListadoActivosFijos() {
		return this.activarcodigo_sub_grupoListadoActivosFijos;
	}

	public void setActivarcodigo_sub_grupoListadoActivosFijos(Boolean activarcodigo_sub_grupoListadoActivosFijos) {
		this.activarcodigo_sub_grupoListadoActivosFijos= activarcodigo_sub_grupoListadoActivosFijos;
	}

	public Border setResaltarnombre_sub_grupoListadoActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoActivosFijosBeanSwingJInternalFrame listadoactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoactivosfijosBeanSwingJInternalFrame.jTtoolBarListadoActivosFijos.setBorder(borderResaltar);
		
		this.resaltarnombre_sub_grupoListadoActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sub_grupoListadoActivosFijos() {
		return this.resaltarnombre_sub_grupoListadoActivosFijos;
	}

	public void setResaltarnombre_sub_grupoListadoActivosFijos(Border borderResaltar) {
		this.resaltarnombre_sub_grupoListadoActivosFijos= borderResaltar;
	}

	public Boolean getMostrarnombre_sub_grupoListadoActivosFijos() {
		return this.mostrarnombre_sub_grupoListadoActivosFijos;
	}

	public void setMostrarnombre_sub_grupoListadoActivosFijos(Boolean mostrarnombre_sub_grupoListadoActivosFijos) {
		this.mostrarnombre_sub_grupoListadoActivosFijos= mostrarnombre_sub_grupoListadoActivosFijos;
	}

	public Boolean getActivarnombre_sub_grupoListadoActivosFijos() {
		return this.activarnombre_sub_grupoListadoActivosFijos;
	}

	public void setActivarnombre_sub_grupoListadoActivosFijos(Boolean activarnombre_sub_grupoListadoActivosFijos) {
		this.activarnombre_sub_grupoListadoActivosFijos= activarnombre_sub_grupoListadoActivosFijos;
	}

	public Border setResaltarcodigo_detalle_grupoListadoActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoActivosFijosBeanSwingJInternalFrame listadoactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoactivosfijosBeanSwingJInternalFrame.jTtoolBarListadoActivosFijos.setBorder(borderResaltar);
		
		this.resaltarcodigo_detalle_grupoListadoActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_detalle_grupoListadoActivosFijos() {
		return this.resaltarcodigo_detalle_grupoListadoActivosFijos;
	}

	public void setResaltarcodigo_detalle_grupoListadoActivosFijos(Border borderResaltar) {
		this.resaltarcodigo_detalle_grupoListadoActivosFijos= borderResaltar;
	}

	public Boolean getMostrarcodigo_detalle_grupoListadoActivosFijos() {
		return this.mostrarcodigo_detalle_grupoListadoActivosFijos;
	}

	public void setMostrarcodigo_detalle_grupoListadoActivosFijos(Boolean mostrarcodigo_detalle_grupoListadoActivosFijos) {
		this.mostrarcodigo_detalle_grupoListadoActivosFijos= mostrarcodigo_detalle_grupoListadoActivosFijos;
	}

	public Boolean getActivarcodigo_detalle_grupoListadoActivosFijos() {
		return this.activarcodigo_detalle_grupoListadoActivosFijos;
	}

	public void setActivarcodigo_detalle_grupoListadoActivosFijos(Boolean activarcodigo_detalle_grupoListadoActivosFijos) {
		this.activarcodigo_detalle_grupoListadoActivosFijos= activarcodigo_detalle_grupoListadoActivosFijos;
	}

	public Border setResaltarnombre_detalle_grupoListadoActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoActivosFijosBeanSwingJInternalFrame listadoactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoactivosfijosBeanSwingJInternalFrame.jTtoolBarListadoActivosFijos.setBorder(borderResaltar);
		
		this.resaltarnombre_detalle_grupoListadoActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_detalle_grupoListadoActivosFijos() {
		return this.resaltarnombre_detalle_grupoListadoActivosFijos;
	}

	public void setResaltarnombre_detalle_grupoListadoActivosFijos(Border borderResaltar) {
		this.resaltarnombre_detalle_grupoListadoActivosFijos= borderResaltar;
	}

	public Boolean getMostrarnombre_detalle_grupoListadoActivosFijos() {
		return this.mostrarnombre_detalle_grupoListadoActivosFijos;
	}

	public void setMostrarnombre_detalle_grupoListadoActivosFijos(Boolean mostrarnombre_detalle_grupoListadoActivosFijos) {
		this.mostrarnombre_detalle_grupoListadoActivosFijos= mostrarnombre_detalle_grupoListadoActivosFijos;
	}

	public Boolean getActivarnombre_detalle_grupoListadoActivosFijos() {
		return this.activarnombre_detalle_grupoListadoActivosFijos;
	}

	public void setActivarnombre_detalle_grupoListadoActivosFijos(Boolean activarnombre_detalle_grupoListadoActivosFijos) {
		this.activarnombre_detalle_grupoListadoActivosFijos= activarnombre_detalle_grupoListadoActivosFijos;
	}

	public Border setResaltarclaveListadoActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoActivosFijosBeanSwingJInternalFrame listadoactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoactivosfijosBeanSwingJInternalFrame.jTtoolBarListadoActivosFijos.setBorder(borderResaltar);
		
		this.resaltarclaveListadoActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarclaveListadoActivosFijos() {
		return this.resaltarclaveListadoActivosFijos;
	}

	public void setResaltarclaveListadoActivosFijos(Border borderResaltar) {
		this.resaltarclaveListadoActivosFijos= borderResaltar;
	}

	public Boolean getMostrarclaveListadoActivosFijos() {
		return this.mostrarclaveListadoActivosFijos;
	}

	public void setMostrarclaveListadoActivosFijos(Boolean mostrarclaveListadoActivosFijos) {
		this.mostrarclaveListadoActivosFijos= mostrarclaveListadoActivosFijos;
	}

	public Boolean getActivarclaveListadoActivosFijos() {
		return this.activarclaveListadoActivosFijos;
	}

	public void setActivarclaveListadoActivosFijos(Boolean activarclaveListadoActivosFijos) {
		this.activarclaveListadoActivosFijos= activarclaveListadoActivosFijos;
	}

	public Border setResaltarnombreListadoActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoActivosFijosBeanSwingJInternalFrame listadoactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoactivosfijosBeanSwingJInternalFrame.jTtoolBarListadoActivosFijos.setBorder(borderResaltar);
		
		this.resaltarnombreListadoActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreListadoActivosFijos() {
		return this.resaltarnombreListadoActivosFijos;
	}

	public void setResaltarnombreListadoActivosFijos(Border borderResaltar) {
		this.resaltarnombreListadoActivosFijos= borderResaltar;
	}

	public Boolean getMostrarnombreListadoActivosFijos() {
		return this.mostrarnombreListadoActivosFijos;
	}

	public void setMostrarnombreListadoActivosFijos(Boolean mostrarnombreListadoActivosFijos) {
		this.mostrarnombreListadoActivosFijos= mostrarnombreListadoActivosFijos;
	}

	public Boolean getActivarnombreListadoActivosFijos() {
		return this.activarnombreListadoActivosFijos;
	}

	public void setActivarnombreListadoActivosFijos(Boolean activarnombreListadoActivosFijos) {
		this.activarnombreListadoActivosFijos= activarnombreListadoActivosFijos;
	}

	public Border setResaltarfecha_compraListadoActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoActivosFijosBeanSwingJInternalFrame listadoactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoactivosfijosBeanSwingJInternalFrame.jTtoolBarListadoActivosFijos.setBorder(borderResaltar);
		
		this.resaltarfecha_compraListadoActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_compraListadoActivosFijos() {
		return this.resaltarfecha_compraListadoActivosFijos;
	}

	public void setResaltarfecha_compraListadoActivosFijos(Border borderResaltar) {
		this.resaltarfecha_compraListadoActivosFijos= borderResaltar;
	}

	public Boolean getMostrarfecha_compraListadoActivosFijos() {
		return this.mostrarfecha_compraListadoActivosFijos;
	}

	public void setMostrarfecha_compraListadoActivosFijos(Boolean mostrarfecha_compraListadoActivosFijos) {
		this.mostrarfecha_compraListadoActivosFijos= mostrarfecha_compraListadoActivosFijos;
	}

	public Boolean getActivarfecha_compraListadoActivosFijos() {
		return this.activarfecha_compraListadoActivosFijos;
	}

	public void setActivarfecha_compraListadoActivosFijos(Boolean activarfecha_compraListadoActivosFijos) {
		this.activarfecha_compraListadoActivosFijos= activarfecha_compraListadoActivosFijos;
	}

	public Border setResaltarvida_utilListadoActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoActivosFijosBeanSwingJInternalFrame listadoactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoactivosfijosBeanSwingJInternalFrame.jTtoolBarListadoActivosFijos.setBorder(borderResaltar);
		
		this.resaltarvida_utilListadoActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvida_utilListadoActivosFijos() {
		return this.resaltarvida_utilListadoActivosFijos;
	}

	public void setResaltarvida_utilListadoActivosFijos(Border borderResaltar) {
		this.resaltarvida_utilListadoActivosFijos= borderResaltar;
	}

	public Boolean getMostrarvida_utilListadoActivosFijos() {
		return this.mostrarvida_utilListadoActivosFijos;
	}

	public void setMostrarvida_utilListadoActivosFijos(Boolean mostrarvida_utilListadoActivosFijos) {
		this.mostrarvida_utilListadoActivosFijos= mostrarvida_utilListadoActivosFijos;
	}

	public Boolean getActivarvida_utilListadoActivosFijos() {
		return this.activarvida_utilListadoActivosFijos;
	}

	public void setActivarvida_utilListadoActivosFijos(Boolean activarvida_utilListadoActivosFijos) {
		this.activarvida_utilListadoActivosFijos= activarvida_utilListadoActivosFijos;
	}

	public Border setResaltarcosto_de_compraListadoActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoActivosFijosBeanSwingJInternalFrame listadoactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoactivosfijosBeanSwingJInternalFrame.jTtoolBarListadoActivosFijos.setBorder(borderResaltar);
		
		this.resaltarcosto_de_compraListadoActivosFijos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_de_compraListadoActivosFijos() {
		return this.resaltarcosto_de_compraListadoActivosFijos;
	}

	public void setResaltarcosto_de_compraListadoActivosFijos(Border borderResaltar) {
		this.resaltarcosto_de_compraListadoActivosFijos= borderResaltar;
	}

	public Boolean getMostrarcosto_de_compraListadoActivosFijos() {
		return this.mostrarcosto_de_compraListadoActivosFijos;
	}

	public void setMostrarcosto_de_compraListadoActivosFijos(Boolean mostrarcosto_de_compraListadoActivosFijos) {
		this.mostrarcosto_de_compraListadoActivosFijos= mostrarcosto_de_compraListadoActivosFijos;
	}

	public Boolean getActivarcosto_de_compraListadoActivosFijos() {
		return this.activarcosto_de_compraListadoActivosFijos;
	}

	public void setActivarcosto_de_compraListadoActivosFijos(Boolean activarcosto_de_compraListadoActivosFijos) {
		this.activarcosto_de_compraListadoActivosFijos= activarcosto_de_compraListadoActivosFijos;
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
		
		
		this.setMostraridListadoActivosFijos(esInicial);
		this.setMostrarid_empresaListadoActivosFijos(esInicial);
		this.setMostrarcodigo_sub_grupoListadoActivosFijos(esInicial);
		this.setMostrarnombre_sub_grupoListadoActivosFijos(esInicial);
		this.setMostrarcodigo_detalle_grupoListadoActivosFijos(esInicial);
		this.setMostrarnombre_detalle_grupoListadoActivosFijos(esInicial);
		this.setMostrarclaveListadoActivosFijos(esInicial);
		this.setMostrarnombreListadoActivosFijos(esInicial);
		this.setMostrarfecha_compraListadoActivosFijos(esInicial);
		this.setMostrarvida_utilListadoActivosFijos(esInicial);
		this.setMostrarcosto_de_compraListadoActivosFijos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.ID)) {
				this.setMostraridListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setMostrarcodigo_sub_grupoListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setMostrarnombre_sub_grupoListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setMostrarcodigo_detalle_grupoListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setMostrarnombre_detalle_grupoListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.CLAVE)) {
				this.setMostrarclaveListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.FECHACOMPRA)) {
				this.setMostrarfecha_compraListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.VIDAUTIL)) {
				this.setMostrarvida_utilListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.COSTODECOMPRA)) {
				this.setMostrarcosto_de_compraListadoActivosFijos(esAsigna);
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
		
		
		this.setActivaridListadoActivosFijos(esInicial);
		this.setActivarid_empresaListadoActivosFijos(esInicial);
		this.setActivarcodigo_sub_grupoListadoActivosFijos(esInicial);
		this.setActivarnombre_sub_grupoListadoActivosFijos(esInicial);
		this.setActivarcodigo_detalle_grupoListadoActivosFijos(esInicial);
		this.setActivarnombre_detalle_grupoListadoActivosFijos(esInicial);
		this.setActivarclaveListadoActivosFijos(esInicial);
		this.setActivarnombreListadoActivosFijos(esInicial);
		this.setActivarfecha_compraListadoActivosFijos(esInicial);
		this.setActivarvida_utilListadoActivosFijos(esInicial);
		this.setActivarcosto_de_compraListadoActivosFijos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.ID)) {
				this.setActivaridListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setActivarcodigo_sub_grupoListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setActivarnombre_sub_grupoListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setActivarcodigo_detalle_grupoListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setActivarnombre_detalle_grupoListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.CLAVE)) {
				this.setActivarclaveListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.FECHACOMPRA)) {
				this.setActivarfecha_compraListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.VIDAUTIL)) {
				this.setActivarvida_utilListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.COSTODECOMPRA)) {
				this.setActivarcosto_de_compraListadoActivosFijos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ListadoActivosFijosBeanSwingJInternalFrame listadoactivosfijosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridListadoActivosFijos(esInicial);
		this.setResaltarid_empresaListadoActivosFijos(esInicial);
		this.setResaltarcodigo_sub_grupoListadoActivosFijos(esInicial);
		this.setResaltarnombre_sub_grupoListadoActivosFijos(esInicial);
		this.setResaltarcodigo_detalle_grupoListadoActivosFijos(esInicial);
		this.setResaltarnombre_detalle_grupoListadoActivosFijos(esInicial);
		this.setResaltarclaveListadoActivosFijos(esInicial);
		this.setResaltarnombreListadoActivosFijos(esInicial);
		this.setResaltarfecha_compraListadoActivosFijos(esInicial);
		this.setResaltarvida_utilListadoActivosFijos(esInicial);
		this.setResaltarcosto_de_compraListadoActivosFijos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.ID)) {
				this.setResaltaridListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.CODIGOSUBGRUPO)) {
				this.setResaltarcodigo_sub_grupoListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.NOMBRESUBGRUPO)) {
				this.setResaltarnombre_sub_grupoListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.CODIGODETALLEGRUPO)) {
				this.setResaltarcodigo_detalle_grupoListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.NOMBREDETALLEGRUPO)) {
				this.setResaltarnombre_detalle_grupoListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.CLAVE)) {
				this.setResaltarclaveListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.FECHACOMPRA)) {
				this.setResaltarfecha_compraListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.VIDAUTIL)) {
				this.setResaltarvida_utilListadoActivosFijos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoActivosFijosConstantesFunciones.COSTODECOMPRA)) {
				this.setResaltarcosto_de_compraListadoActivosFijos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ListadoActivosFijosBeanSwingJInternalFrame listadoactivosfijosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaListadoActivosFijosListadoActivosFijos=true;

	public Boolean getMostrarBusquedaListadoActivosFijosListadoActivosFijos() {
		return this.mostrarBusquedaListadoActivosFijosListadoActivosFijos;
	}

	public void setMostrarBusquedaListadoActivosFijosListadoActivosFijos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaListadoActivosFijosListadoActivosFijos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaListadoActivosFijosListadoActivosFijos=true;

	public Boolean getActivarBusquedaListadoActivosFijosListadoActivosFijos() {
		return this.activarBusquedaListadoActivosFijosListadoActivosFijos;
	}

	public void setActivarBusquedaListadoActivosFijosListadoActivosFijos(Boolean habilitarResaltar) {
		this.activarBusquedaListadoActivosFijosListadoActivosFijos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaListadoActivosFijosListadoActivosFijos=null;

	public Border getResaltarBusquedaListadoActivosFijosListadoActivosFijos() {
		return this.resaltarBusquedaListadoActivosFijosListadoActivosFijos;
	}

	public void setResaltarBusquedaListadoActivosFijosListadoActivosFijos(Border borderResaltar) {
		this.resaltarBusquedaListadoActivosFijosListadoActivosFijos= borderResaltar;
	}

	public void setResaltarBusquedaListadoActivosFijosListadoActivosFijos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoActivosFijosBeanSwingJInternalFrame listadoactivosfijosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaListadoActivosFijosListadoActivosFijos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}