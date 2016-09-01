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

import com.bydan.erp.activosfijos.resources.general.AuxiliarGeneral;

import com.bydan.erp.activosfijos.util.report.ProcesarMayorizarConstantesFunciones;
import com.bydan.erp.activosfijos.util.report.ProcesarMayorizarParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.report.ProcesarMayorizarParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesarMayorizarConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesarMayorizar";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesarMayorizar"+ProcesarMayorizarConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesarMayorizarHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesarMayorizarHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesarMayorizarConstantesFunciones.SCHEMA+"_"+ProcesarMayorizarConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesarMayorizarHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesarMayorizarConstantesFunciones.SCHEMA+"_"+ProcesarMayorizarConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesarMayorizarConstantesFunciones.SCHEMA+"_"+ProcesarMayorizarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesarMayorizarHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesarMayorizarConstantesFunciones.SCHEMA+"_"+ProcesarMayorizarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesarMayorizarConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesarMayorizarHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesarMayorizarConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesarMayorizarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesarMayorizarHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesarMayorizarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesarMayorizarConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesarMayorizarConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesarMayorizarConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesarMayorizarConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Procesar Mayorizares";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Procesar Mayorizar";
	public static final String SCLASSWEBTITULO_LOWER="Procesar Mayorizar";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesarMayorizar";
	public static final String OBJECTNAME="procesarmayorizar";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="procesar_mayorizar";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesarmayorizar from "+ProcesarMayorizarConstantesFunciones.SPERSISTENCENAME+" procesarmayorizar";
	public static String QUERYSELECTNATIVE="select "+ProcesarMayorizarConstantesFunciones.SCHEMA+"."+ProcesarMayorizarConstantesFunciones.TABLENAME+".id,"+ProcesarMayorizarConstantesFunciones.SCHEMA+"."+ProcesarMayorizarConstantesFunciones.TABLENAME+".version_row,"+ProcesarMayorizarConstantesFunciones.SCHEMA+"."+ProcesarMayorizarConstantesFunciones.TABLENAME+".id_anio,"+ProcesarMayorizarConstantesFunciones.SCHEMA+"."+ProcesarMayorizarConstantesFunciones.TABLENAME+".id_mes,"+ProcesarMayorizarConstantesFunciones.SCHEMA+"."+ProcesarMayorizarConstantesFunciones.TABLENAME+".id_tipo_documento,"+ProcesarMayorizarConstantesFunciones.SCHEMA+"."+ProcesarMayorizarConstantesFunciones.TABLENAME+".codigo,"+ProcesarMayorizarConstantesFunciones.SCHEMA+"."+ProcesarMayorizarConstantesFunciones.TABLENAME+".nombre from "+ProcesarMayorizarConstantesFunciones.SCHEMA+"."+ProcesarMayorizarConstantesFunciones.TABLENAME;//+" as "+ProcesarMayorizarConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDTIPODOCUMENTO= "id_tipo_documento";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDTIPODOCUMENTO= "Tipo Documento";
		public static final String LABEL_IDTIPODOCUMENTO_LOWER= "Tipo Documento";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProcesarMayorizarLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesarMayorizarConstantesFunciones.IDANIO)) {sLabelColumna=ProcesarMayorizarConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(ProcesarMayorizarConstantesFunciones.IDMES)) {sLabelColumna=ProcesarMayorizarConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(ProcesarMayorizarConstantesFunciones.IDTIPODOCUMENTO)) {sLabelColumna=ProcesarMayorizarConstantesFunciones.LABEL_IDTIPODOCUMENTO;}
		if(sNombreColumna.equals(ProcesarMayorizarConstantesFunciones.CODIGO)) {sLabelColumna=ProcesarMayorizarConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProcesarMayorizarConstantesFunciones.NOMBRE)) {sLabelColumna=ProcesarMayorizarConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getProcesarMayorizarDescripcion(ProcesarMayorizar procesarmayorizar) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesarmayorizar !=null/* && procesarmayorizar.getId()!=0*/) {
			sDescripcion=procesarmayorizar.getcodigo();//procesarmayorizarprocesarmayorizar.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesarMayorizarDescripcionDetallado(ProcesarMayorizar procesarmayorizar) {
		String sDescripcion="";
			
		sDescripcion+=ProcesarMayorizarConstantesFunciones.ID+"=";
		sDescripcion+=procesarmayorizar.getId().toString()+",";
		sDescripcion+=ProcesarMayorizarConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesarmayorizar.getVersionRow().toString()+",";
		sDescripcion+=ProcesarMayorizarConstantesFunciones.IDANIO+"=";
		sDescripcion+=procesarmayorizar.getid_anio().toString()+",";
		sDescripcion+=ProcesarMayorizarConstantesFunciones.IDMES+"=";
		sDescripcion+=procesarmayorizar.getid_mes().toString()+",";
		sDescripcion+=ProcesarMayorizarConstantesFunciones.IDTIPODOCUMENTO+"=";
		sDescripcion+=procesarmayorizar.getid_tipo_documento().toString()+",";
		sDescripcion+=ProcesarMayorizarConstantesFunciones.CODIGO+"=";
		sDescripcion+=procesarmayorizar.getcodigo()+",";
		sDescripcion+=ProcesarMayorizarConstantesFunciones.NOMBRE+"=";
		sDescripcion+=procesarmayorizar.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesarMayorizarDescripcion(ProcesarMayorizar procesarmayorizar,String sValor) throws Exception {			
		if(procesarmayorizar !=null) {
			procesarmayorizar.setcodigo(sValor);;//procesarmayorizarprocesarmayorizar.getcodigo().trim();
		}		
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

	public static String getTipoDocumentoDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesarMayorizar")) {
			sNombreIndice="Tipo=  Por Anio Por Mes Por Tipo Documento";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdTipoDocumento")) {
			sNombreIndice="Tipo=  Por Tipo Documento";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesarMayorizar(Long id_anio,Long id_mes,Long id_tipo_documento) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();}
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();}
		if(id_tipo_documento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Documento="+id_tipo_documento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumento(Long id_tipo_documento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Documento="+id_tipo_documento.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesarMayorizar(ProcesarMayorizar procesarmayorizar,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		procesarmayorizar.setcodigo(procesarmayorizar.getcodigo().trim());
		procesarmayorizar.setnombre(procesarmayorizar.getnombre().trim());
	}
	
	public static void quitarEspaciosProcesarMayorizars(List<ProcesarMayorizar> procesarmayorizars,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesarMayorizar procesarmayorizar: procesarmayorizars) {
			procesarmayorizar.setcodigo(procesarmayorizar.getcodigo().trim());
			procesarmayorizar.setnombre(procesarmayorizar.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesarMayorizar(ProcesarMayorizar procesarmayorizar,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesarmayorizar.getConCambioAuxiliar()) {
			procesarmayorizar.setIsDeleted(procesarmayorizar.getIsDeletedAuxiliar());	
			procesarmayorizar.setIsNew(procesarmayorizar.getIsNewAuxiliar());	
			procesarmayorizar.setIsChanged(procesarmayorizar.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesarmayorizar.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesarmayorizar.setIsDeletedAuxiliar(false);	
			procesarmayorizar.setIsNewAuxiliar(false);	
			procesarmayorizar.setIsChangedAuxiliar(false);
			
			procesarmayorizar.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesarMayorizars(List<ProcesarMayorizar> procesarmayorizars,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesarMayorizar procesarmayorizar : procesarmayorizars) {
			if(conAsignarBase && procesarmayorizar.getConCambioAuxiliar()) {
				procesarmayorizar.setIsDeleted(procesarmayorizar.getIsDeletedAuxiliar());	
				procesarmayorizar.setIsNew(procesarmayorizar.getIsNewAuxiliar());	
				procesarmayorizar.setIsChanged(procesarmayorizar.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesarmayorizar.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesarmayorizar.setIsDeletedAuxiliar(false);	
				procesarmayorizar.setIsNewAuxiliar(false);	
				procesarmayorizar.setIsChangedAuxiliar(false);
				
				procesarmayorizar.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesarMayorizar(ProcesarMayorizar procesarmayorizar,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesarMayorizars(List<ProcesarMayorizar> procesarmayorizars,Boolean conEnteros) throws Exception  {
		
		for(ProcesarMayorizar procesarmayorizar: procesarmayorizars) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesarMayorizar(List<ProcesarMayorizar> procesarmayorizars,ProcesarMayorizar procesarmayorizarAux) throws Exception  {
		ProcesarMayorizarConstantesFunciones.InicializarValoresProcesarMayorizar(procesarmayorizarAux,true);
		
		for(ProcesarMayorizar procesarmayorizar: procesarmayorizars) {
			if(procesarmayorizar.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesarMayorizar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesarMayorizarConstantesFunciones.getArrayColumnasGlobalesProcesarMayorizar(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesarMayorizar(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesarMayorizar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesarMayorizar> procesarmayorizars,ProcesarMayorizar procesarmayorizar,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesarMayorizar procesarmayorizarAux: procesarmayorizars) {
			if(procesarmayorizarAux!=null && procesarmayorizar!=null) {
				if((procesarmayorizarAux.getId()==null && procesarmayorizar.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesarmayorizarAux.getId()!=null && procesarmayorizar.getId()!=null){
					if(procesarmayorizarAux.getId().equals(procesarmayorizar.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesarMayorizar(List<ProcesarMayorizar> procesarmayorizars) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesarMayorizar procesarmayorizar: procesarmayorizars) {			
			if(procesarmayorizar.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesarMayorizar() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesarMayorizar() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesarMayorizar() throws Exception  {
		return ProcesarMayorizarConstantesFunciones.getTiposSeleccionarProcesarMayorizar(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesarMayorizar(Boolean conFk) throws Exception  {
		return ProcesarMayorizarConstantesFunciones.getTiposSeleccionarProcesarMayorizar(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesarMayorizar(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesarMayorizarConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(ProcesarMayorizarConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesarMayorizarConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(ProcesarMayorizarConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesarMayorizarConstantesFunciones.LABEL_IDTIPODOCUMENTO);
			reporte.setsDescripcion(ProcesarMayorizarConstantesFunciones.LABEL_IDTIPODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesarMayorizarConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProcesarMayorizarConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesarMayorizarConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ProcesarMayorizarConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesarMayorizar(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesarMayorizar(ProcesarMayorizar procesarmayorizarAux) throws Exception {
		
			procesarmayorizarAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(procesarmayorizarAux.getAnio()));
			procesarmayorizarAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(procesarmayorizarAux.getMes()));
			procesarmayorizarAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(procesarmayorizarAux.getTipoDocumento()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesarMayorizar(List<ProcesarMayorizar> procesarmayorizarsTemp) throws Exception {
		for(ProcesarMayorizar procesarmayorizarAux:procesarmayorizarsTemp) {
			
			procesarmayorizarAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(procesarmayorizarAux.getAnio()));
			procesarmayorizarAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(procesarmayorizarAux.getMes()));
			procesarmayorizarAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(procesarmayorizarAux.getTipoDocumento()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesarMayorizar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(TipoDocumento.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesarMayorizar(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesarMayorizar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesarMayorizarConstantesFunciones.getClassesRelationshipsOfProcesarMayorizar(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesarMayorizar(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesarMayorizar(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesarMayorizarConstantesFunciones.getClassesRelationshipsFromStringsOfProcesarMayorizar(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesarMayorizar(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesarMayorizar procesarmayorizar,List<ProcesarMayorizar> procesarmayorizars,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesarMayorizar procesarmayorizar,List<ProcesarMayorizar> procesarmayorizars) throws Exception {
		try	{			
			for(ProcesarMayorizar procesarmayorizarLocal:procesarmayorizars) {
				if(procesarmayorizarLocal.getId().equals(procesarmayorizar.getId())) {
					procesarmayorizarLocal.setIsSelected(procesarmayorizar.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesarMayorizar(List<ProcesarMayorizar> procesarmayorizarsAux) throws Exception {
		//this.procesarmayorizarsAux=procesarmayorizarsAux;
		
		for(ProcesarMayorizar procesarmayorizarAux:procesarmayorizarsAux) {
			if(procesarmayorizarAux.getIsChanged()) {
				procesarmayorizarAux.setIsChanged(false);
			}		
			
			if(procesarmayorizarAux.getIsNew()) {
				procesarmayorizarAux.setIsNew(false);
			}	
			
			if(procesarmayorizarAux.getIsDeleted()) {
				procesarmayorizarAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesarMayorizar(ProcesarMayorizar procesarmayorizarAux) throws Exception {
		//this.procesarmayorizarAux=procesarmayorizarAux;
		
			if(procesarmayorizarAux.getIsChanged()) {
				procesarmayorizarAux.setIsChanged(false);
			}		
			
			if(procesarmayorizarAux.getIsNew()) {
				procesarmayorizarAux.setIsNew(false);
			}	
			
			if(procesarmayorizarAux.getIsDeleted()) {
				procesarmayorizarAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesarMayorizar procesarmayorizarAsignar,ProcesarMayorizar procesarmayorizar) throws Exception {
		procesarmayorizarAsignar.setId(procesarmayorizar.getId());	
		procesarmayorizarAsignar.setVersionRow(procesarmayorizar.getVersionRow());	
		procesarmayorizarAsignar.setcodigo(procesarmayorizar.getcodigo());	
		procesarmayorizarAsignar.setnombre(procesarmayorizar.getnombre());	
	}
	
	public static void inicializarProcesarMayorizar(ProcesarMayorizar procesarmayorizar) throws Exception {
		try {
				procesarmayorizar.setId(0L);	
					
				procesarmayorizar.setcodigo("");	
				procesarmayorizar.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesarMayorizar(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesarMayorizarConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesarMayorizarConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesarMayorizarConstantesFunciones.LABEL_IDTIPODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesarMayorizarConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesarMayorizarConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesarMayorizar(String sTipo,Row row,Workbook workbook,ProcesarMayorizar procesarmayorizar,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesarmayorizar.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesarmayorizar.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesarmayorizar.gettipodocumento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesarmayorizar.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesarmayorizar.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesarMayorizar="";
	
	public String getsFinalQueryProcesarMayorizar() {
		return this.sFinalQueryProcesarMayorizar;
	}
	
	public void setsFinalQueryProcesarMayorizar(String sFinalQueryProcesarMayorizar) {
		this.sFinalQueryProcesarMayorizar= sFinalQueryProcesarMayorizar;
	}
	
	public Border resaltarSeleccionarProcesarMayorizar=null;
	
	public Border setResaltarSeleccionarProcesarMayorizar(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarMayorizarBeanSwingJInternalFrame procesarmayorizarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesarmayorizarBeanSwingJInternalFrame.jTtoolBarProcesarMayorizar.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesarMayorizar= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesarMayorizar() {
		return this.resaltarSeleccionarProcesarMayorizar;
	}
	
	public void setResaltarSeleccionarProcesarMayorizar(Border borderResaltarSeleccionarProcesarMayorizar) {
		this.resaltarSeleccionarProcesarMayorizar= borderResaltarSeleccionarProcesarMayorizar;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesarMayorizar=null;
	public Boolean mostraridProcesarMayorizar=true;
	public Boolean activaridProcesarMayorizar=true;

	public Border resaltarid_anioProcesarMayorizar=null;
	public Boolean mostrarid_anioProcesarMayorizar=true;
	public Boolean activarid_anioProcesarMayorizar=true;
	public Boolean cargarid_anioProcesarMayorizar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioProcesarMayorizar=false;//ConEventDepend=true

	public Border resaltarid_mesProcesarMayorizar=null;
	public Boolean mostrarid_mesProcesarMayorizar=true;
	public Boolean activarid_mesProcesarMayorizar=true;
	public Boolean cargarid_mesProcesarMayorizar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesProcesarMayorizar=false;//ConEventDepend=true

	public Border resaltarid_tipo_documentoProcesarMayorizar=null;
	public Boolean mostrarid_tipo_documentoProcesarMayorizar=true;
	public Boolean activarid_tipo_documentoProcesarMayorizar=true;
	public Boolean cargarid_tipo_documentoProcesarMayorizar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documentoProcesarMayorizar=false;//ConEventDepend=true

	public Border resaltarcodigoProcesarMayorizar=null;
	public Boolean mostrarcodigoProcesarMayorizar=true;
	public Boolean activarcodigoProcesarMayorizar=true;

	public Border resaltarnombreProcesarMayorizar=null;
	public Boolean mostrarnombreProcesarMayorizar=true;
	public Boolean activarnombreProcesarMayorizar=true;

	
	

	public Border setResaltaridProcesarMayorizar(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarMayorizarBeanSwingJInternalFrame procesarmayorizarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesarmayorizarBeanSwingJInternalFrame.jTtoolBarProcesarMayorizar.setBorder(borderResaltar);
		
		this.resaltaridProcesarMayorizar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesarMayorizar() {
		return this.resaltaridProcesarMayorizar;
	}

	public void setResaltaridProcesarMayorizar(Border borderResaltar) {
		this.resaltaridProcesarMayorizar= borderResaltar;
	}

	public Boolean getMostraridProcesarMayorizar() {
		return this.mostraridProcesarMayorizar;
	}

	public void setMostraridProcesarMayorizar(Boolean mostraridProcesarMayorizar) {
		this.mostraridProcesarMayorizar= mostraridProcesarMayorizar;
	}

	public Boolean getActivaridProcesarMayorizar() {
		return this.activaridProcesarMayorizar;
	}

	public void setActivaridProcesarMayorizar(Boolean activaridProcesarMayorizar) {
		this.activaridProcesarMayorizar= activaridProcesarMayorizar;
	}

	public Border setResaltarid_anioProcesarMayorizar(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarMayorizarBeanSwingJInternalFrame procesarmayorizarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesarmayorizarBeanSwingJInternalFrame.jTtoolBarProcesarMayorizar.setBorder(borderResaltar);
		
		this.resaltarid_anioProcesarMayorizar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioProcesarMayorizar() {
		return this.resaltarid_anioProcesarMayorizar;
	}

	public void setResaltarid_anioProcesarMayorizar(Border borderResaltar) {
		this.resaltarid_anioProcesarMayorizar= borderResaltar;
	}

	public Boolean getMostrarid_anioProcesarMayorizar() {
		return this.mostrarid_anioProcesarMayorizar;
	}

	public void setMostrarid_anioProcesarMayorizar(Boolean mostrarid_anioProcesarMayorizar) {
		this.mostrarid_anioProcesarMayorizar= mostrarid_anioProcesarMayorizar;
	}

	public Boolean getActivarid_anioProcesarMayorizar() {
		return this.activarid_anioProcesarMayorizar;
	}

	public void setActivarid_anioProcesarMayorizar(Boolean activarid_anioProcesarMayorizar) {
		this.activarid_anioProcesarMayorizar= activarid_anioProcesarMayorizar;
	}

	public Boolean getCargarid_anioProcesarMayorizar() {
		return this.cargarid_anioProcesarMayorizar;
	}

	public void setCargarid_anioProcesarMayorizar(Boolean cargarid_anioProcesarMayorizar) {
		this.cargarid_anioProcesarMayorizar= cargarid_anioProcesarMayorizar;
	}

	public Border setResaltarid_mesProcesarMayorizar(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarMayorizarBeanSwingJInternalFrame procesarmayorizarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesarmayorizarBeanSwingJInternalFrame.jTtoolBarProcesarMayorizar.setBorder(borderResaltar);
		
		this.resaltarid_mesProcesarMayorizar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesProcesarMayorizar() {
		return this.resaltarid_mesProcesarMayorizar;
	}

	public void setResaltarid_mesProcesarMayorizar(Border borderResaltar) {
		this.resaltarid_mesProcesarMayorizar= borderResaltar;
	}

	public Boolean getMostrarid_mesProcesarMayorizar() {
		return this.mostrarid_mesProcesarMayorizar;
	}

	public void setMostrarid_mesProcesarMayorizar(Boolean mostrarid_mesProcesarMayorizar) {
		this.mostrarid_mesProcesarMayorizar= mostrarid_mesProcesarMayorizar;
	}

	public Boolean getActivarid_mesProcesarMayorizar() {
		return this.activarid_mesProcesarMayorizar;
	}

	public void setActivarid_mesProcesarMayorizar(Boolean activarid_mesProcesarMayorizar) {
		this.activarid_mesProcesarMayorizar= activarid_mesProcesarMayorizar;
	}

	public Boolean getCargarid_mesProcesarMayorizar() {
		return this.cargarid_mesProcesarMayorizar;
	}

	public void setCargarid_mesProcesarMayorizar(Boolean cargarid_mesProcesarMayorizar) {
		this.cargarid_mesProcesarMayorizar= cargarid_mesProcesarMayorizar;
	}

	public Border setResaltarid_tipo_documentoProcesarMayorizar(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarMayorizarBeanSwingJInternalFrame procesarmayorizarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesarmayorizarBeanSwingJInternalFrame.jTtoolBarProcesarMayorizar.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documentoProcesarMayorizar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documentoProcesarMayorizar() {
		return this.resaltarid_tipo_documentoProcesarMayorizar;
	}

	public void setResaltarid_tipo_documentoProcesarMayorizar(Border borderResaltar) {
		this.resaltarid_tipo_documentoProcesarMayorizar= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documentoProcesarMayorizar() {
		return this.mostrarid_tipo_documentoProcesarMayorizar;
	}

	public void setMostrarid_tipo_documentoProcesarMayorizar(Boolean mostrarid_tipo_documentoProcesarMayorizar) {
		this.mostrarid_tipo_documentoProcesarMayorizar= mostrarid_tipo_documentoProcesarMayorizar;
	}

	public Boolean getActivarid_tipo_documentoProcesarMayorizar() {
		return this.activarid_tipo_documentoProcesarMayorizar;
	}

	public void setActivarid_tipo_documentoProcesarMayorizar(Boolean activarid_tipo_documentoProcesarMayorizar) {
		this.activarid_tipo_documentoProcesarMayorizar= activarid_tipo_documentoProcesarMayorizar;
	}

	public Boolean getCargarid_tipo_documentoProcesarMayorizar() {
		return this.cargarid_tipo_documentoProcesarMayorizar;
	}

	public void setCargarid_tipo_documentoProcesarMayorizar(Boolean cargarid_tipo_documentoProcesarMayorizar) {
		this.cargarid_tipo_documentoProcesarMayorizar= cargarid_tipo_documentoProcesarMayorizar;
	}

	public Border setResaltarcodigoProcesarMayorizar(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarMayorizarBeanSwingJInternalFrame procesarmayorizarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesarmayorizarBeanSwingJInternalFrame.jTtoolBarProcesarMayorizar.setBorder(borderResaltar);
		
		this.resaltarcodigoProcesarMayorizar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProcesarMayorizar() {
		return this.resaltarcodigoProcesarMayorizar;
	}

	public void setResaltarcodigoProcesarMayorizar(Border borderResaltar) {
		this.resaltarcodigoProcesarMayorizar= borderResaltar;
	}

	public Boolean getMostrarcodigoProcesarMayorizar() {
		return this.mostrarcodigoProcesarMayorizar;
	}

	public void setMostrarcodigoProcesarMayorizar(Boolean mostrarcodigoProcesarMayorizar) {
		this.mostrarcodigoProcesarMayorizar= mostrarcodigoProcesarMayorizar;
	}

	public Boolean getActivarcodigoProcesarMayorizar() {
		return this.activarcodigoProcesarMayorizar;
	}

	public void setActivarcodigoProcesarMayorizar(Boolean activarcodigoProcesarMayorizar) {
		this.activarcodigoProcesarMayorizar= activarcodigoProcesarMayorizar;
	}

	public Border setResaltarnombreProcesarMayorizar(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarMayorizarBeanSwingJInternalFrame procesarmayorizarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesarmayorizarBeanSwingJInternalFrame.jTtoolBarProcesarMayorizar.setBorder(borderResaltar);
		
		this.resaltarnombreProcesarMayorizar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreProcesarMayorizar() {
		return this.resaltarnombreProcesarMayorizar;
	}

	public void setResaltarnombreProcesarMayorizar(Border borderResaltar) {
		this.resaltarnombreProcesarMayorizar= borderResaltar;
	}

	public Boolean getMostrarnombreProcesarMayorizar() {
		return this.mostrarnombreProcesarMayorizar;
	}

	public void setMostrarnombreProcesarMayorizar(Boolean mostrarnombreProcesarMayorizar) {
		this.mostrarnombreProcesarMayorizar= mostrarnombreProcesarMayorizar;
	}

	public Boolean getActivarnombreProcesarMayorizar() {
		return this.activarnombreProcesarMayorizar;
	}

	public void setActivarnombreProcesarMayorizar(Boolean activarnombreProcesarMayorizar) {
		this.activarnombreProcesarMayorizar= activarnombreProcesarMayorizar;
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
		
		
		this.setMostraridProcesarMayorizar(esInicial);
		this.setMostrarid_anioProcesarMayorizar(esInicial);
		this.setMostrarid_mesProcesarMayorizar(esInicial);
		this.setMostrarid_tipo_documentoProcesarMayorizar(esInicial);
		this.setMostrarcodigoProcesarMayorizar(esInicial);
		this.setMostrarnombreProcesarMayorizar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.ID)) {
				this.setMostraridProcesarMayorizar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioProcesarMayorizar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.IDMES)) {
				this.setMostrarid_mesProcesarMayorizar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setMostrarid_tipo_documentoProcesarMayorizar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProcesarMayorizar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreProcesarMayorizar(esAsigna);
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
		
		
		this.setActivaridProcesarMayorizar(esInicial);
		this.setActivarid_anioProcesarMayorizar(esInicial);
		this.setActivarid_mesProcesarMayorizar(esInicial);
		this.setActivarid_tipo_documentoProcesarMayorizar(esInicial);
		this.setActivarcodigoProcesarMayorizar(esInicial);
		this.setActivarnombreProcesarMayorizar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.ID)) {
				this.setActivaridProcesarMayorizar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.IDANIO)) {
				this.setActivarid_anioProcesarMayorizar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.IDMES)) {
				this.setActivarid_mesProcesarMayorizar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setActivarid_tipo_documentoProcesarMayorizar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProcesarMayorizar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.NOMBRE)) {
				this.setActivarnombreProcesarMayorizar(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesarMayorizarBeanSwingJInternalFrame procesarmayorizarBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesarMayorizar(esInicial);
		this.setResaltarid_anioProcesarMayorizar(esInicial);
		this.setResaltarid_mesProcesarMayorizar(esInicial);
		this.setResaltarid_tipo_documentoProcesarMayorizar(esInicial);
		this.setResaltarcodigoProcesarMayorizar(esInicial);
		this.setResaltarnombreProcesarMayorizar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.ID)) {
				this.setResaltaridProcesarMayorizar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioProcesarMayorizar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.IDMES)) {
				this.setResaltarid_mesProcesarMayorizar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setResaltarid_tipo_documentoProcesarMayorizar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProcesarMayorizar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesarMayorizarConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreProcesarMayorizar(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesarMayorizarBeanSwingJInternalFrame procesarmayorizarBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesarMayorizarProcesarMayorizar=true;

	public Boolean getMostrarBusquedaProcesarMayorizarProcesarMayorizar() {
		return this.mostrarBusquedaProcesarMayorizarProcesarMayorizar;
	}

	public void setMostrarBusquedaProcesarMayorizarProcesarMayorizar(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesarMayorizarProcesarMayorizar= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesarMayorizarProcesarMayorizar=true;

	public Boolean getActivarBusquedaProcesarMayorizarProcesarMayorizar() {
		return this.activarBusquedaProcesarMayorizarProcesarMayorizar;
	}

	public void setActivarBusquedaProcesarMayorizarProcesarMayorizar(Boolean habilitarResaltar) {
		this.activarBusquedaProcesarMayorizarProcesarMayorizar= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesarMayorizarProcesarMayorizar=null;

	public Border getResaltarBusquedaProcesarMayorizarProcesarMayorizar() {
		return this.resaltarBusquedaProcesarMayorizarProcesarMayorizar;
	}

	public void setResaltarBusquedaProcesarMayorizarProcesarMayorizar(Border borderResaltar) {
		this.resaltarBusquedaProcesarMayorizarProcesarMayorizar= borderResaltar;
	}

	public void setResaltarBusquedaProcesarMayorizarProcesarMayorizar(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesarMayorizarBeanSwingJInternalFrame procesarmayorizarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesarMayorizarProcesarMayorizar= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}