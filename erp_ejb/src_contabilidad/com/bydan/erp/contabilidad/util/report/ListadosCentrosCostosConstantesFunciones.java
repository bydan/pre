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
package com.bydan.erp.contabilidad.util.report;

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


import com.bydan.erp.contabilidad.util.report.ListadosCentrosCostosConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.ListadosCentrosCostosParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ListadosCentrosCostosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ListadosCentrosCostosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ListadosCentrosCostos";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ListadosCentrosCostos"+ListadosCentrosCostosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ListadosCentrosCostosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ListadosCentrosCostosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ListadosCentrosCostosConstantesFunciones.SCHEMA+"_"+ListadosCentrosCostosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ListadosCentrosCostosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ListadosCentrosCostosConstantesFunciones.SCHEMA+"_"+ListadosCentrosCostosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ListadosCentrosCostosConstantesFunciones.SCHEMA+"_"+ListadosCentrosCostosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ListadosCentrosCostosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ListadosCentrosCostosConstantesFunciones.SCHEMA+"_"+ListadosCentrosCostosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosCentrosCostosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ListadosCentrosCostosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosCentrosCostosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosCentrosCostosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ListadosCentrosCostosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosCentrosCostosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ListadosCentrosCostosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ListadosCentrosCostosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ListadosCentrosCostosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ListadosCentrosCostosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Listados Centros Costoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Listados Centros Costos";
	public static final String SCLASSWEBTITULO_LOWER="Listados Centros Costos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ListadosCentrosCostos";
	public static final String OBJECTNAME="listadoscentroscostos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="listados_centros_costos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select listadoscentroscostos from "+ListadosCentrosCostosConstantesFunciones.SPERSISTENCENAME+" listadoscentroscostos";
	public static String QUERYSELECTNATIVE="select "+ListadosCentrosCostosConstantesFunciones.SCHEMA+"."+ListadosCentrosCostosConstantesFunciones.TABLENAME+".id,"+ListadosCentrosCostosConstantesFunciones.SCHEMA+"."+ListadosCentrosCostosConstantesFunciones.TABLENAME+".version_row,"+ListadosCentrosCostosConstantesFunciones.SCHEMA+"."+ListadosCentrosCostosConstantesFunciones.TABLENAME+".id_empresa,"+ListadosCentrosCostosConstantesFunciones.SCHEMA+"."+ListadosCentrosCostosConstantesFunciones.TABLENAME+".codigo,"+ListadosCentrosCostosConstantesFunciones.SCHEMA+"."+ListadosCentrosCostosConstantesFunciones.TABLENAME+".nombre,"+ListadosCentrosCostosConstantesFunciones.SCHEMA+"."+ListadosCentrosCostosConstantesFunciones.TABLENAME+".porcentaje,"+ListadosCentrosCostosConstantesFunciones.SCHEMA+"."+ListadosCentrosCostosConstantesFunciones.TABLENAME+".valor from "+ListadosCentrosCostosConstantesFunciones.SCHEMA+"."+ListadosCentrosCostosConstantesFunciones.TABLENAME;//+" as "+ListadosCentrosCostosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String PORCENTAJE= "porcentaje";
    public static final String VALOR= "valor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getListadosCentrosCostosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ListadosCentrosCostosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ListadosCentrosCostosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ListadosCentrosCostosConstantesFunciones.CODIGO)) {sLabelColumna=ListadosCentrosCostosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ListadosCentrosCostosConstantesFunciones.NOMBRE)) {sLabelColumna=ListadosCentrosCostosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ListadosCentrosCostosConstantesFunciones.PORCENTAJE)) {sLabelColumna=ListadosCentrosCostosConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(ListadosCentrosCostosConstantesFunciones.VALOR)) {sLabelColumna=ListadosCentrosCostosConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getListadosCentrosCostosDescripcion(ListadosCentrosCostos listadoscentroscostos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(listadoscentroscostos !=null/* && listadoscentroscostos.getId()!=0*/) {
			sDescripcion=listadoscentroscostos.getcodigo();//listadoscentroscostoslistadoscentroscostos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getListadosCentrosCostosDescripcionDetallado(ListadosCentrosCostos listadoscentroscostos) {
		String sDescripcion="";
			
		sDescripcion+=ListadosCentrosCostosConstantesFunciones.ID+"=";
		sDescripcion+=listadoscentroscostos.getId().toString()+",";
		sDescripcion+=ListadosCentrosCostosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=listadoscentroscostos.getVersionRow().toString()+",";
		sDescripcion+=ListadosCentrosCostosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=listadoscentroscostos.getid_empresa().toString()+",";
		sDescripcion+=ListadosCentrosCostosConstantesFunciones.CODIGO+"=";
		sDescripcion+=listadoscentroscostos.getcodigo()+",";
		sDescripcion+=ListadosCentrosCostosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=listadoscentroscostos.getnombre()+",";
		sDescripcion+=ListadosCentrosCostosConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=listadoscentroscostos.getporcentaje().toString()+",";
		sDescripcion+=ListadosCentrosCostosConstantesFunciones.VALOR+"=";
		sDescripcion+=listadoscentroscostos.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setListadosCentrosCostosDescripcion(ListadosCentrosCostos listadoscentroscostos,String sValor) throws Exception {			
		if(listadoscentroscostos !=null) {
			listadoscentroscostos.setcodigo(sValor);;//listadoscentroscostoslistadoscentroscostos.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaListadosCentrosCostos")) {
			sNombreIndice="Tipo=  Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaListadosCentrosCostos(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosListadosCentrosCostos(ListadosCentrosCostos listadoscentroscostos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		listadoscentroscostos.setcodigo(listadoscentroscostos.getcodigo().trim());
		listadoscentroscostos.setnombre(listadoscentroscostos.getnombre().trim());
	}
	
	public static void quitarEspaciosListadosCentrosCostoss(List<ListadosCentrosCostos> listadoscentroscostoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ListadosCentrosCostos listadoscentroscostos: listadoscentroscostoss) {
			listadoscentroscostos.setcodigo(listadoscentroscostos.getcodigo().trim());
			listadoscentroscostos.setnombre(listadoscentroscostos.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresListadosCentrosCostos(ListadosCentrosCostos listadoscentroscostos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && listadoscentroscostos.getConCambioAuxiliar()) {
			listadoscentroscostos.setIsDeleted(listadoscentroscostos.getIsDeletedAuxiliar());	
			listadoscentroscostos.setIsNew(listadoscentroscostos.getIsNewAuxiliar());	
			listadoscentroscostos.setIsChanged(listadoscentroscostos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			listadoscentroscostos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			listadoscentroscostos.setIsDeletedAuxiliar(false);	
			listadoscentroscostos.setIsNewAuxiliar(false);	
			listadoscentroscostos.setIsChangedAuxiliar(false);
			
			listadoscentroscostos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresListadosCentrosCostoss(List<ListadosCentrosCostos> listadoscentroscostoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ListadosCentrosCostos listadoscentroscostos : listadoscentroscostoss) {
			if(conAsignarBase && listadoscentroscostos.getConCambioAuxiliar()) {
				listadoscentroscostos.setIsDeleted(listadoscentroscostos.getIsDeletedAuxiliar());	
				listadoscentroscostos.setIsNew(listadoscentroscostos.getIsNewAuxiliar());	
				listadoscentroscostos.setIsChanged(listadoscentroscostos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				listadoscentroscostos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				listadoscentroscostos.setIsDeletedAuxiliar(false);	
				listadoscentroscostos.setIsNewAuxiliar(false);	
				listadoscentroscostos.setIsChangedAuxiliar(false);
				
				listadoscentroscostos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresListadosCentrosCostos(ListadosCentrosCostos listadoscentroscostos,Boolean conEnteros) throws Exception  {
		listadoscentroscostos.setporcentaje(0.0);
		listadoscentroscostos.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresListadosCentrosCostoss(List<ListadosCentrosCostos> listadoscentroscostoss,Boolean conEnteros) throws Exception  {
		
		for(ListadosCentrosCostos listadoscentroscostos: listadoscentroscostoss) {
			listadoscentroscostos.setporcentaje(0.0);
			listadoscentroscostos.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaListadosCentrosCostos(List<ListadosCentrosCostos> listadoscentroscostoss,ListadosCentrosCostos listadoscentroscostosAux) throws Exception  {
		ListadosCentrosCostosConstantesFunciones.InicializarValoresListadosCentrosCostos(listadoscentroscostosAux,true);
		
		for(ListadosCentrosCostos listadoscentroscostos: listadoscentroscostoss) {
			if(listadoscentroscostos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			listadoscentroscostosAux.setporcentaje(listadoscentroscostosAux.getporcentaje()+listadoscentroscostos.getporcentaje());			
			listadoscentroscostosAux.setvalor(listadoscentroscostosAux.getvalor()+listadoscentroscostos.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesListadosCentrosCostos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ListadosCentrosCostosConstantesFunciones.getArrayColumnasGlobalesListadosCentrosCostos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesListadosCentrosCostos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ListadosCentrosCostosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ListadosCentrosCostosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoListadosCentrosCostos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ListadosCentrosCostos> listadoscentroscostoss,ListadosCentrosCostos listadoscentroscostos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ListadosCentrosCostos listadoscentroscostosAux: listadoscentroscostoss) {
			if(listadoscentroscostosAux!=null && listadoscentroscostos!=null) {
				if((listadoscentroscostosAux.getId()==null && listadoscentroscostos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(listadoscentroscostosAux.getId()!=null && listadoscentroscostos.getId()!=null){
					if(listadoscentroscostosAux.getId().equals(listadoscentroscostos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaListadosCentrosCostos(List<ListadosCentrosCostos> listadoscentroscostoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double valorTotal=0.0;
	
		for(ListadosCentrosCostos listadoscentroscostos: listadoscentroscostoss) {			
			if(listadoscentroscostos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=listadoscentroscostos.getporcentaje();
			valorTotal+=listadoscentroscostos.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadosCentrosCostosConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ListadosCentrosCostosConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadosCentrosCostosConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ListadosCentrosCostosConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaListadosCentrosCostos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ListadosCentrosCostosConstantesFunciones.LABEL_VERSIONROW, ListadosCentrosCostosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosCentrosCostosConstantesFunciones.LABEL_CODIGO, ListadosCentrosCostosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosCentrosCostosConstantesFunciones.LABEL_NOMBRE, ListadosCentrosCostosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosCentrosCostosConstantesFunciones.LABEL_PORCENTAJE, ListadosCentrosCostosConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosCentrosCostosConstantesFunciones.LABEL_VALOR, ListadosCentrosCostosConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasListadosCentrosCostos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ListadosCentrosCostosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosCentrosCostosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosCentrosCostosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosCentrosCostosConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosCentrosCostosConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadosCentrosCostos() throws Exception  {
		return ListadosCentrosCostosConstantesFunciones.getTiposSeleccionarListadosCentrosCostos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadosCentrosCostos(Boolean conFk) throws Exception  {
		return ListadosCentrosCostosConstantesFunciones.getTiposSeleccionarListadosCentrosCostos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadosCentrosCostos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosCentrosCostosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ListadosCentrosCostosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosCentrosCostosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ListadosCentrosCostosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosCentrosCostosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ListadosCentrosCostosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosCentrosCostosConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(ListadosCentrosCostosConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosCentrosCostosConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ListadosCentrosCostosConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesListadosCentrosCostos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesListadosCentrosCostos(ListadosCentrosCostos listadoscentroscostosAux) throws Exception {
		
			listadoscentroscostosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(listadoscentroscostosAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesListadosCentrosCostos(List<ListadosCentrosCostos> listadoscentroscostossTemp) throws Exception {
		for(ListadosCentrosCostos listadoscentroscostosAux:listadoscentroscostossTemp) {
			
			listadoscentroscostosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(listadoscentroscostosAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfListadosCentrosCostos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfListadosCentrosCostos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfListadosCentrosCostos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ListadosCentrosCostosConstantesFunciones.getClassesRelationshipsOfListadosCentrosCostos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfListadosCentrosCostos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfListadosCentrosCostos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ListadosCentrosCostosConstantesFunciones.getClassesRelationshipsFromStringsOfListadosCentrosCostos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfListadosCentrosCostos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ListadosCentrosCostos listadoscentroscostos,List<ListadosCentrosCostos> listadoscentroscostoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ListadosCentrosCostos listadoscentroscostos,List<ListadosCentrosCostos> listadoscentroscostoss) throws Exception {
		try	{			
			for(ListadosCentrosCostos listadoscentroscostosLocal:listadoscentroscostoss) {
				if(listadoscentroscostosLocal.getId().equals(listadoscentroscostos.getId())) {
					listadoscentroscostosLocal.setIsSelected(listadoscentroscostos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesListadosCentrosCostos(List<ListadosCentrosCostos> listadoscentroscostossAux) throws Exception {
		//this.listadoscentroscostossAux=listadoscentroscostossAux;
		
		for(ListadosCentrosCostos listadoscentroscostosAux:listadoscentroscostossAux) {
			if(listadoscentroscostosAux.getIsChanged()) {
				listadoscentroscostosAux.setIsChanged(false);
			}		
			
			if(listadoscentroscostosAux.getIsNew()) {
				listadoscentroscostosAux.setIsNew(false);
			}	
			
			if(listadoscentroscostosAux.getIsDeleted()) {
				listadoscentroscostosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesListadosCentrosCostos(ListadosCentrosCostos listadoscentroscostosAux) throws Exception {
		//this.listadoscentroscostosAux=listadoscentroscostosAux;
		
			if(listadoscentroscostosAux.getIsChanged()) {
				listadoscentroscostosAux.setIsChanged(false);
			}		
			
			if(listadoscentroscostosAux.getIsNew()) {
				listadoscentroscostosAux.setIsNew(false);
			}	
			
			if(listadoscentroscostosAux.getIsDeleted()) {
				listadoscentroscostosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ListadosCentrosCostos listadoscentroscostosAsignar,ListadosCentrosCostos listadoscentroscostos) throws Exception {
		listadoscentroscostosAsignar.setVersionRow(listadoscentroscostos.getVersionRow());	
		listadoscentroscostosAsignar.setcodigo(listadoscentroscostos.getcodigo());	
		listadoscentroscostosAsignar.setnombre(listadoscentroscostos.getnombre());	
		listadoscentroscostosAsignar.setporcentaje(listadoscentroscostos.getporcentaje());	
		listadoscentroscostosAsignar.setvalor(listadoscentroscostos.getvalor());	
	}
	
	public static void inicializarListadosCentrosCostos(ListadosCentrosCostos listadoscentroscostos) throws Exception {
		try {
					
				listadoscentroscostos.setcodigo("");	
				listadoscentroscostos.setnombre("");	
				listadoscentroscostos.setporcentaje(0.0);	
				listadoscentroscostos.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderListadosCentrosCostos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosCentrosCostosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosCentrosCostosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosCentrosCostosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosCentrosCostosConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosCentrosCostosConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataListadosCentrosCostos(String sTipo,Row row,Workbook workbook,ListadosCentrosCostos listadoscentroscostos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoscentroscostos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoscentroscostos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoscentroscostos.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoscentroscostos.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoscentroscostos.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryListadosCentrosCostos="";
	
	public String getsFinalQueryListadosCentrosCostos() {
		return this.sFinalQueryListadosCentrosCostos;
	}
	
	public void setsFinalQueryListadosCentrosCostos(String sFinalQueryListadosCentrosCostos) {
		this.sFinalQueryListadosCentrosCostos= sFinalQueryListadosCentrosCostos;
	}
	
	public Border resaltarSeleccionarListadosCentrosCostos=null;
	
	public Border setResaltarSeleccionarListadosCentrosCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosCentrosCostosBeanSwingJInternalFrame listadoscentroscostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//listadoscentroscostosBeanSwingJInternalFrame.jTtoolBarListadosCentrosCostos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarListadosCentrosCostos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarListadosCentrosCostos() {
		return this.resaltarSeleccionarListadosCentrosCostos;
	}
	
	public void setResaltarSeleccionarListadosCentrosCostos(Border borderResaltarSeleccionarListadosCentrosCostos) {
		this.resaltarSeleccionarListadosCentrosCostos= borderResaltarSeleccionarListadosCentrosCostos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridListadosCentrosCostos=null;
	public Boolean mostraridListadosCentrosCostos=true;
	public Boolean activaridListadosCentrosCostos=true;

	public Border resaltarid_empresaListadosCentrosCostos=null;
	public Boolean mostrarid_empresaListadosCentrosCostos=true;
	public Boolean activarid_empresaListadosCentrosCostos=true;
	public Boolean cargarid_empresaListadosCentrosCostos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaListadosCentrosCostos=false;//ConEventDepend=true

	public Border resaltarcodigoListadosCentrosCostos=null;
	public Boolean mostrarcodigoListadosCentrosCostos=true;
	public Boolean activarcodigoListadosCentrosCostos=true;

	public Border resaltarnombreListadosCentrosCostos=null;
	public Boolean mostrarnombreListadosCentrosCostos=true;
	public Boolean activarnombreListadosCentrosCostos=true;

	public Border resaltarporcentajeListadosCentrosCostos=null;
	public Boolean mostrarporcentajeListadosCentrosCostos=true;
	public Boolean activarporcentajeListadosCentrosCostos=true;

	public Border resaltarvalorListadosCentrosCostos=null;
	public Boolean mostrarvalorListadosCentrosCostos=true;
	public Boolean activarvalorListadosCentrosCostos=true;

	
	

	public Border setResaltaridListadosCentrosCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosCentrosCostosBeanSwingJInternalFrame listadoscentroscostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoscentroscostosBeanSwingJInternalFrame.jTtoolBarListadosCentrosCostos.setBorder(borderResaltar);
		
		this.resaltaridListadosCentrosCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridListadosCentrosCostos() {
		return this.resaltaridListadosCentrosCostos;
	}

	public void setResaltaridListadosCentrosCostos(Border borderResaltar) {
		this.resaltaridListadosCentrosCostos= borderResaltar;
	}

	public Boolean getMostraridListadosCentrosCostos() {
		return this.mostraridListadosCentrosCostos;
	}

	public void setMostraridListadosCentrosCostos(Boolean mostraridListadosCentrosCostos) {
		this.mostraridListadosCentrosCostos= mostraridListadosCentrosCostos;
	}

	public Boolean getActivaridListadosCentrosCostos() {
		return this.activaridListadosCentrosCostos;
	}

	public void setActivaridListadosCentrosCostos(Boolean activaridListadosCentrosCostos) {
		this.activaridListadosCentrosCostos= activaridListadosCentrosCostos;
	}

	public Border setResaltarid_empresaListadosCentrosCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosCentrosCostosBeanSwingJInternalFrame listadoscentroscostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoscentroscostosBeanSwingJInternalFrame.jTtoolBarListadosCentrosCostos.setBorder(borderResaltar);
		
		this.resaltarid_empresaListadosCentrosCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaListadosCentrosCostos() {
		return this.resaltarid_empresaListadosCentrosCostos;
	}

	public void setResaltarid_empresaListadosCentrosCostos(Border borderResaltar) {
		this.resaltarid_empresaListadosCentrosCostos= borderResaltar;
	}

	public Boolean getMostrarid_empresaListadosCentrosCostos() {
		return this.mostrarid_empresaListadosCentrosCostos;
	}

	public void setMostrarid_empresaListadosCentrosCostos(Boolean mostrarid_empresaListadosCentrosCostos) {
		this.mostrarid_empresaListadosCentrosCostos= mostrarid_empresaListadosCentrosCostos;
	}

	public Boolean getActivarid_empresaListadosCentrosCostos() {
		return this.activarid_empresaListadosCentrosCostos;
	}

	public void setActivarid_empresaListadosCentrosCostos(Boolean activarid_empresaListadosCentrosCostos) {
		this.activarid_empresaListadosCentrosCostos= activarid_empresaListadosCentrosCostos;
	}

	public Boolean getCargarid_empresaListadosCentrosCostos() {
		return this.cargarid_empresaListadosCentrosCostos;
	}

	public void setCargarid_empresaListadosCentrosCostos(Boolean cargarid_empresaListadosCentrosCostos) {
		this.cargarid_empresaListadosCentrosCostos= cargarid_empresaListadosCentrosCostos;
	}

	public Border setResaltarcodigoListadosCentrosCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosCentrosCostosBeanSwingJInternalFrame listadoscentroscostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoscentroscostosBeanSwingJInternalFrame.jTtoolBarListadosCentrosCostos.setBorder(borderResaltar);
		
		this.resaltarcodigoListadosCentrosCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoListadosCentrosCostos() {
		return this.resaltarcodigoListadosCentrosCostos;
	}

	public void setResaltarcodigoListadosCentrosCostos(Border borderResaltar) {
		this.resaltarcodigoListadosCentrosCostos= borderResaltar;
	}

	public Boolean getMostrarcodigoListadosCentrosCostos() {
		return this.mostrarcodigoListadosCentrosCostos;
	}

	public void setMostrarcodigoListadosCentrosCostos(Boolean mostrarcodigoListadosCentrosCostos) {
		this.mostrarcodigoListadosCentrosCostos= mostrarcodigoListadosCentrosCostos;
	}

	public Boolean getActivarcodigoListadosCentrosCostos() {
		return this.activarcodigoListadosCentrosCostos;
	}

	public void setActivarcodigoListadosCentrosCostos(Boolean activarcodigoListadosCentrosCostos) {
		this.activarcodigoListadosCentrosCostos= activarcodigoListadosCentrosCostos;
	}

	public Border setResaltarnombreListadosCentrosCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosCentrosCostosBeanSwingJInternalFrame listadoscentroscostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoscentroscostosBeanSwingJInternalFrame.jTtoolBarListadosCentrosCostos.setBorder(borderResaltar);
		
		this.resaltarnombreListadosCentrosCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreListadosCentrosCostos() {
		return this.resaltarnombreListadosCentrosCostos;
	}

	public void setResaltarnombreListadosCentrosCostos(Border borderResaltar) {
		this.resaltarnombreListadosCentrosCostos= borderResaltar;
	}

	public Boolean getMostrarnombreListadosCentrosCostos() {
		return this.mostrarnombreListadosCentrosCostos;
	}

	public void setMostrarnombreListadosCentrosCostos(Boolean mostrarnombreListadosCentrosCostos) {
		this.mostrarnombreListadosCentrosCostos= mostrarnombreListadosCentrosCostos;
	}

	public Boolean getActivarnombreListadosCentrosCostos() {
		return this.activarnombreListadosCentrosCostos;
	}

	public void setActivarnombreListadosCentrosCostos(Boolean activarnombreListadosCentrosCostos) {
		this.activarnombreListadosCentrosCostos= activarnombreListadosCentrosCostos;
	}

	public Border setResaltarporcentajeListadosCentrosCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosCentrosCostosBeanSwingJInternalFrame listadoscentroscostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoscentroscostosBeanSwingJInternalFrame.jTtoolBarListadosCentrosCostos.setBorder(borderResaltar);
		
		this.resaltarporcentajeListadosCentrosCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeListadosCentrosCostos() {
		return this.resaltarporcentajeListadosCentrosCostos;
	}

	public void setResaltarporcentajeListadosCentrosCostos(Border borderResaltar) {
		this.resaltarporcentajeListadosCentrosCostos= borderResaltar;
	}

	public Boolean getMostrarporcentajeListadosCentrosCostos() {
		return this.mostrarporcentajeListadosCentrosCostos;
	}

	public void setMostrarporcentajeListadosCentrosCostos(Boolean mostrarporcentajeListadosCentrosCostos) {
		this.mostrarporcentajeListadosCentrosCostos= mostrarporcentajeListadosCentrosCostos;
	}

	public Boolean getActivarporcentajeListadosCentrosCostos() {
		return this.activarporcentajeListadosCentrosCostos;
	}

	public void setActivarporcentajeListadosCentrosCostos(Boolean activarporcentajeListadosCentrosCostos) {
		this.activarporcentajeListadosCentrosCostos= activarporcentajeListadosCentrosCostos;
	}

	public Border setResaltarvalorListadosCentrosCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosCentrosCostosBeanSwingJInternalFrame listadoscentroscostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoscentroscostosBeanSwingJInternalFrame.jTtoolBarListadosCentrosCostos.setBorder(borderResaltar);
		
		this.resaltarvalorListadosCentrosCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorListadosCentrosCostos() {
		return this.resaltarvalorListadosCentrosCostos;
	}

	public void setResaltarvalorListadosCentrosCostos(Border borderResaltar) {
		this.resaltarvalorListadosCentrosCostos= borderResaltar;
	}

	public Boolean getMostrarvalorListadosCentrosCostos() {
		return this.mostrarvalorListadosCentrosCostos;
	}

	public void setMostrarvalorListadosCentrosCostos(Boolean mostrarvalorListadosCentrosCostos) {
		this.mostrarvalorListadosCentrosCostos= mostrarvalorListadosCentrosCostos;
	}

	public Boolean getActivarvalorListadosCentrosCostos() {
		return this.activarvalorListadosCentrosCostos;
	}

	public void setActivarvalorListadosCentrosCostos(Boolean activarvalorListadosCentrosCostos) {
		this.activarvalorListadosCentrosCostos= activarvalorListadosCentrosCostos;
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
		
		
		this.setMostraridListadosCentrosCostos(esInicial);
		this.setMostrarid_empresaListadosCentrosCostos(esInicial);
		this.setMostrarcodigoListadosCentrosCostos(esInicial);
		this.setMostrarnombreListadosCentrosCostos(esInicial);
		this.setMostrarporcentajeListadosCentrosCostos(esInicial);
		this.setMostrarvalorListadosCentrosCostos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.ID)) {
				this.setMostraridListadosCentrosCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaListadosCentrosCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoListadosCentrosCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreListadosCentrosCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeListadosCentrosCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.VALOR)) {
				this.setMostrarvalorListadosCentrosCostos(esAsigna);
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
		
		
		this.setActivaridListadosCentrosCostos(esInicial);
		this.setActivarid_empresaListadosCentrosCostos(esInicial);
		this.setActivarcodigoListadosCentrosCostos(esInicial);
		this.setActivarnombreListadosCentrosCostos(esInicial);
		this.setActivarporcentajeListadosCentrosCostos(esInicial);
		this.setActivarvalorListadosCentrosCostos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.ID)) {
				this.setActivaridListadosCentrosCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaListadosCentrosCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoListadosCentrosCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreListadosCentrosCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeListadosCentrosCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.VALOR)) {
				this.setActivarvalorListadosCentrosCostos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ListadosCentrosCostosBeanSwingJInternalFrame listadoscentroscostosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridListadosCentrosCostos(esInicial);
		this.setResaltarid_empresaListadosCentrosCostos(esInicial);
		this.setResaltarcodigoListadosCentrosCostos(esInicial);
		this.setResaltarnombreListadosCentrosCostos(esInicial);
		this.setResaltarporcentajeListadosCentrosCostos(esInicial);
		this.setResaltarvalorListadosCentrosCostos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.ID)) {
				this.setResaltaridListadosCentrosCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaListadosCentrosCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoListadosCentrosCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreListadosCentrosCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeListadosCentrosCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosCostosConstantesFunciones.VALOR)) {
				this.setResaltarvalorListadosCentrosCostos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ListadosCentrosCostosBeanSwingJInternalFrame listadoscentroscostosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaListadosCentrosCostosListadosCentrosCostos=true;

	public Boolean getMostrarBusquedaListadosCentrosCostosListadosCentrosCostos() {
		return this.mostrarBusquedaListadosCentrosCostosListadosCentrosCostos;
	}

	public void setMostrarBusquedaListadosCentrosCostosListadosCentrosCostos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaListadosCentrosCostosListadosCentrosCostos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaListadosCentrosCostosListadosCentrosCostos=true;

	public Boolean getActivarBusquedaListadosCentrosCostosListadosCentrosCostos() {
		return this.activarBusquedaListadosCentrosCostosListadosCentrosCostos;
	}

	public void setActivarBusquedaListadosCentrosCostosListadosCentrosCostos(Boolean habilitarResaltar) {
		this.activarBusquedaListadosCentrosCostosListadosCentrosCostos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaListadosCentrosCostosListadosCentrosCostos=null;

	public Border getResaltarBusquedaListadosCentrosCostosListadosCentrosCostos() {
		return this.resaltarBusquedaListadosCentrosCostosListadosCentrosCostos;
	}

	public void setResaltarBusquedaListadosCentrosCostosListadosCentrosCostos(Border borderResaltar) {
		this.resaltarBusquedaListadosCentrosCostosListadosCentrosCostos= borderResaltar;
	}

	public void setResaltarBusquedaListadosCentrosCostosListadosCentrosCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosCentrosCostosBeanSwingJInternalFrame listadoscentroscostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaListadosCentrosCostosListadosCentrosCostos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}