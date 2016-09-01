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


import com.bydan.erp.contabilidad.util.report.ListadosCentrosActividadesConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.ListadosCentrosActividadesParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ListadosCentrosActividadesParameterGeneral;

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
final public class ListadosCentrosActividadesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ListadosCentrosActividades";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ListadosCentrosActividades"+ListadosCentrosActividadesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ListadosCentrosActividadesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ListadosCentrosActividadesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ListadosCentrosActividadesConstantesFunciones.SCHEMA+"_"+ListadosCentrosActividadesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ListadosCentrosActividadesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ListadosCentrosActividadesConstantesFunciones.SCHEMA+"_"+ListadosCentrosActividadesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ListadosCentrosActividadesConstantesFunciones.SCHEMA+"_"+ListadosCentrosActividadesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ListadosCentrosActividadesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ListadosCentrosActividadesConstantesFunciones.SCHEMA+"_"+ListadosCentrosActividadesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosCentrosActividadesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ListadosCentrosActividadesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosCentrosActividadesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosCentrosActividadesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ListadosCentrosActividadesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosCentrosActividadesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ListadosCentrosActividadesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ListadosCentrosActividadesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ListadosCentrosActividadesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ListadosCentrosActividadesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Listados Centros Actividadeses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Listados Centros Actividades";
	public static final String SCLASSWEBTITULO_LOWER="Listados Centros Actividades";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ListadosCentrosActividades";
	public static final String OBJECTNAME="listadoscentrosactividades";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="listados_centros_actividades";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select listadoscentrosactividades from "+ListadosCentrosActividadesConstantesFunciones.SPERSISTENCENAME+" listadoscentrosactividades";
	public static String QUERYSELECTNATIVE="select "+ListadosCentrosActividadesConstantesFunciones.SCHEMA+"."+ListadosCentrosActividadesConstantesFunciones.TABLENAME+".id,"+ListadosCentrosActividadesConstantesFunciones.SCHEMA+"."+ListadosCentrosActividadesConstantesFunciones.TABLENAME+".version_row,"+ListadosCentrosActividadesConstantesFunciones.SCHEMA+"."+ListadosCentrosActividadesConstantesFunciones.TABLENAME+".id_empresa,"+ListadosCentrosActividadesConstantesFunciones.SCHEMA+"."+ListadosCentrosActividadesConstantesFunciones.TABLENAME+".codigo,"+ListadosCentrosActividadesConstantesFunciones.SCHEMA+"."+ListadosCentrosActividadesConstantesFunciones.TABLENAME+".nombre from "+ListadosCentrosActividadesConstantesFunciones.SCHEMA+"."+ListadosCentrosActividadesConstantesFunciones.TABLENAME;//+" as "+ListadosCentrosActividadesConstantesFunciones.TABLENAME;
	
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
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getListadosCentrosActividadesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ListadosCentrosActividadesConstantesFunciones.IDEMPRESA)) {sLabelColumna=ListadosCentrosActividadesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ListadosCentrosActividadesConstantesFunciones.CODIGO)) {sLabelColumna=ListadosCentrosActividadesConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ListadosCentrosActividadesConstantesFunciones.NOMBRE)) {sLabelColumna=ListadosCentrosActividadesConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getListadosCentrosActividadesDescripcion(ListadosCentrosActividades listadoscentrosactividades) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(listadoscentrosactividades !=null/* && listadoscentrosactividades.getId()!=0*/) {
			sDescripcion=listadoscentrosactividades.getcodigo();//listadoscentrosactividadeslistadoscentrosactividades.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getListadosCentrosActividadesDescripcionDetallado(ListadosCentrosActividades listadoscentrosactividades) {
		String sDescripcion="";
			
		sDescripcion+=ListadosCentrosActividadesConstantesFunciones.ID+"=";
		sDescripcion+=listadoscentrosactividades.getId().toString()+",";
		sDescripcion+=ListadosCentrosActividadesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=listadoscentrosactividades.getVersionRow().toString()+",";
		sDescripcion+=ListadosCentrosActividadesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=listadoscentrosactividades.getid_empresa().toString()+",";
		sDescripcion+=ListadosCentrosActividadesConstantesFunciones.CODIGO+"=";
		sDescripcion+=listadoscentrosactividades.getcodigo()+",";
		sDescripcion+=ListadosCentrosActividadesConstantesFunciones.NOMBRE+"=";
		sDescripcion+=listadoscentrosactividades.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setListadosCentrosActividadesDescripcion(ListadosCentrosActividades listadoscentrosactividades,String sValor) throws Exception {			
		if(listadoscentrosactividades !=null) {
			listadoscentrosactividades.setcodigo(sValor);;//listadoscentrosactividadeslistadoscentrosactividades.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaListadosCentrosActividades")) {
			sNombreIndice="Tipo=  Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaListadosCentrosActividades(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosListadosCentrosActividades(ListadosCentrosActividades listadoscentrosactividades,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		listadoscentrosactividades.setcodigo(listadoscentrosactividades.getcodigo().trim());
		listadoscentrosactividades.setnombre(listadoscentrosactividades.getnombre().trim());
	}
	
	public static void quitarEspaciosListadosCentrosActividadess(List<ListadosCentrosActividades> listadoscentrosactividadess,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ListadosCentrosActividades listadoscentrosactividades: listadoscentrosactividadess) {
			listadoscentrosactividades.setcodigo(listadoscentrosactividades.getcodigo().trim());
			listadoscentrosactividades.setnombre(listadoscentrosactividades.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresListadosCentrosActividades(ListadosCentrosActividades listadoscentrosactividades,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && listadoscentrosactividades.getConCambioAuxiliar()) {
			listadoscentrosactividades.setIsDeleted(listadoscentrosactividades.getIsDeletedAuxiliar());	
			listadoscentrosactividades.setIsNew(listadoscentrosactividades.getIsNewAuxiliar());	
			listadoscentrosactividades.setIsChanged(listadoscentrosactividades.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			listadoscentrosactividades.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			listadoscentrosactividades.setIsDeletedAuxiliar(false);	
			listadoscentrosactividades.setIsNewAuxiliar(false);	
			listadoscentrosactividades.setIsChangedAuxiliar(false);
			
			listadoscentrosactividades.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresListadosCentrosActividadess(List<ListadosCentrosActividades> listadoscentrosactividadess,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ListadosCentrosActividades listadoscentrosactividades : listadoscentrosactividadess) {
			if(conAsignarBase && listadoscentrosactividades.getConCambioAuxiliar()) {
				listadoscentrosactividades.setIsDeleted(listadoscentrosactividades.getIsDeletedAuxiliar());	
				listadoscentrosactividades.setIsNew(listadoscentrosactividades.getIsNewAuxiliar());	
				listadoscentrosactividades.setIsChanged(listadoscentrosactividades.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				listadoscentrosactividades.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				listadoscentrosactividades.setIsDeletedAuxiliar(false);	
				listadoscentrosactividades.setIsNewAuxiliar(false);	
				listadoscentrosactividades.setIsChangedAuxiliar(false);
				
				listadoscentrosactividades.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresListadosCentrosActividades(ListadosCentrosActividades listadoscentrosactividades,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresListadosCentrosActividadess(List<ListadosCentrosActividades> listadoscentrosactividadess,Boolean conEnteros) throws Exception  {
		
		for(ListadosCentrosActividades listadoscentrosactividades: listadoscentrosactividadess) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaListadosCentrosActividades(List<ListadosCentrosActividades> listadoscentrosactividadess,ListadosCentrosActividades listadoscentrosactividadesAux) throws Exception  {
		ListadosCentrosActividadesConstantesFunciones.InicializarValoresListadosCentrosActividades(listadoscentrosactividadesAux,true);
		
		for(ListadosCentrosActividades listadoscentrosactividades: listadoscentrosactividadess) {
			if(listadoscentrosactividades.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesListadosCentrosActividades(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ListadosCentrosActividadesConstantesFunciones.getArrayColumnasGlobalesListadosCentrosActividades(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesListadosCentrosActividades(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ListadosCentrosActividadesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ListadosCentrosActividadesConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoListadosCentrosActividades(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ListadosCentrosActividades> listadoscentrosactividadess,ListadosCentrosActividades listadoscentrosactividades,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ListadosCentrosActividades listadoscentrosactividadesAux: listadoscentrosactividadess) {
			if(listadoscentrosactividadesAux!=null && listadoscentrosactividades!=null) {
				if((listadoscentrosactividadesAux.getId()==null && listadoscentrosactividades.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(listadoscentrosactividadesAux.getId()!=null && listadoscentrosactividades.getId()!=null){
					if(listadoscentrosactividadesAux.getId().equals(listadoscentrosactividades.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaListadosCentrosActividades(List<ListadosCentrosActividades> listadoscentrosactividadess) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ListadosCentrosActividades listadoscentrosactividades: listadoscentrosactividadess) {			
			if(listadoscentrosactividades.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaListadosCentrosActividades() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ListadosCentrosActividadesConstantesFunciones.LABEL_VERSIONROW, ListadosCentrosActividadesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosCentrosActividadesConstantesFunciones.LABEL_CODIGO, ListadosCentrosActividadesConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosCentrosActividadesConstantesFunciones.LABEL_NOMBRE, ListadosCentrosActividadesConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasListadosCentrosActividades() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ListadosCentrosActividadesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosCentrosActividadesConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosCentrosActividadesConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadosCentrosActividades() throws Exception  {
		return ListadosCentrosActividadesConstantesFunciones.getTiposSeleccionarListadosCentrosActividades(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadosCentrosActividades(Boolean conFk) throws Exception  {
		return ListadosCentrosActividadesConstantesFunciones.getTiposSeleccionarListadosCentrosActividades(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadosCentrosActividades(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosCentrosActividadesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ListadosCentrosActividadesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosCentrosActividadesConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ListadosCentrosActividadesConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosCentrosActividadesConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ListadosCentrosActividadesConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesListadosCentrosActividades(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesListadosCentrosActividades(ListadosCentrosActividades listadoscentrosactividadesAux) throws Exception {
		
			listadoscentrosactividadesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(listadoscentrosactividadesAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesListadosCentrosActividades(List<ListadosCentrosActividades> listadoscentrosactividadessTemp) throws Exception {
		for(ListadosCentrosActividades listadoscentrosactividadesAux:listadoscentrosactividadessTemp) {
			
			listadoscentrosactividadesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(listadoscentrosactividadesAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfListadosCentrosActividades(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfListadosCentrosActividades(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfListadosCentrosActividades(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ListadosCentrosActividadesConstantesFunciones.getClassesRelationshipsOfListadosCentrosActividades(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfListadosCentrosActividades(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfListadosCentrosActividades(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ListadosCentrosActividadesConstantesFunciones.getClassesRelationshipsFromStringsOfListadosCentrosActividades(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfListadosCentrosActividades(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ListadosCentrosActividades listadoscentrosactividades,List<ListadosCentrosActividades> listadoscentrosactividadess,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ListadosCentrosActividades listadoscentrosactividades,List<ListadosCentrosActividades> listadoscentrosactividadess) throws Exception {
		try	{			
			for(ListadosCentrosActividades listadoscentrosactividadesLocal:listadoscentrosactividadess) {
				if(listadoscentrosactividadesLocal.getId().equals(listadoscentrosactividades.getId())) {
					listadoscentrosactividadesLocal.setIsSelected(listadoscentrosactividades.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesListadosCentrosActividades(List<ListadosCentrosActividades> listadoscentrosactividadessAux) throws Exception {
		//this.listadoscentrosactividadessAux=listadoscentrosactividadessAux;
		
		for(ListadosCentrosActividades listadoscentrosactividadesAux:listadoscentrosactividadessAux) {
			if(listadoscentrosactividadesAux.getIsChanged()) {
				listadoscentrosactividadesAux.setIsChanged(false);
			}		
			
			if(listadoscentrosactividadesAux.getIsNew()) {
				listadoscentrosactividadesAux.setIsNew(false);
			}	
			
			if(listadoscentrosactividadesAux.getIsDeleted()) {
				listadoscentrosactividadesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesListadosCentrosActividades(ListadosCentrosActividades listadoscentrosactividadesAux) throws Exception {
		//this.listadoscentrosactividadesAux=listadoscentrosactividadesAux;
		
			if(listadoscentrosactividadesAux.getIsChanged()) {
				listadoscentrosactividadesAux.setIsChanged(false);
			}		
			
			if(listadoscentrosactividadesAux.getIsNew()) {
				listadoscentrosactividadesAux.setIsNew(false);
			}	
			
			if(listadoscentrosactividadesAux.getIsDeleted()) {
				listadoscentrosactividadesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ListadosCentrosActividades listadoscentrosactividadesAsignar,ListadosCentrosActividades listadoscentrosactividades) throws Exception {
		listadoscentrosactividadesAsignar.setVersionRow(listadoscentrosactividades.getVersionRow());	
		listadoscentrosactividadesAsignar.setcodigo(listadoscentrosactividades.getcodigo());	
		listadoscentrosactividadesAsignar.setnombre(listadoscentrosactividades.getnombre());	
	}
	
	public static void inicializarListadosCentrosActividades(ListadosCentrosActividades listadoscentrosactividades) throws Exception {
		try {
					
				listadoscentrosactividades.setcodigo("");	
				listadoscentrosactividades.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderListadosCentrosActividades(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosCentrosActividadesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosCentrosActividadesConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosCentrosActividadesConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataListadosCentrosActividades(String sTipo,Row row,Workbook workbook,ListadosCentrosActividades listadoscentrosactividades,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoscentrosactividades.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoscentrosactividades.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoscentrosactividades.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryListadosCentrosActividades="";
	
	public String getsFinalQueryListadosCentrosActividades() {
		return this.sFinalQueryListadosCentrosActividades;
	}
	
	public void setsFinalQueryListadosCentrosActividades(String sFinalQueryListadosCentrosActividades) {
		this.sFinalQueryListadosCentrosActividades= sFinalQueryListadosCentrosActividades;
	}
	
	public Border resaltarSeleccionarListadosCentrosActividades=null;
	
	public Border setResaltarSeleccionarListadosCentrosActividades(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosCentrosActividadesBeanSwingJInternalFrame listadoscentrosactividadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//listadoscentrosactividadesBeanSwingJInternalFrame.jTtoolBarListadosCentrosActividades.setBorder(borderResaltar);
		
		this.resaltarSeleccionarListadosCentrosActividades= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarListadosCentrosActividades() {
		return this.resaltarSeleccionarListadosCentrosActividades;
	}
	
	public void setResaltarSeleccionarListadosCentrosActividades(Border borderResaltarSeleccionarListadosCentrosActividades) {
		this.resaltarSeleccionarListadosCentrosActividades= borderResaltarSeleccionarListadosCentrosActividades;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridListadosCentrosActividades=null;
	public Boolean mostraridListadosCentrosActividades=true;
	public Boolean activaridListadosCentrosActividades=true;

	public Border resaltarid_empresaListadosCentrosActividades=null;
	public Boolean mostrarid_empresaListadosCentrosActividades=true;
	public Boolean activarid_empresaListadosCentrosActividades=true;
	public Boolean cargarid_empresaListadosCentrosActividades=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaListadosCentrosActividades=false;//ConEventDepend=true

	public Border resaltarcodigoListadosCentrosActividades=null;
	public Boolean mostrarcodigoListadosCentrosActividades=true;
	public Boolean activarcodigoListadosCentrosActividades=true;

	public Border resaltarnombreListadosCentrosActividades=null;
	public Boolean mostrarnombreListadosCentrosActividades=true;
	public Boolean activarnombreListadosCentrosActividades=true;

	
	

	public Border setResaltaridListadosCentrosActividades(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosCentrosActividadesBeanSwingJInternalFrame listadoscentrosactividadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoscentrosactividadesBeanSwingJInternalFrame.jTtoolBarListadosCentrosActividades.setBorder(borderResaltar);
		
		this.resaltaridListadosCentrosActividades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridListadosCentrosActividades() {
		return this.resaltaridListadosCentrosActividades;
	}

	public void setResaltaridListadosCentrosActividades(Border borderResaltar) {
		this.resaltaridListadosCentrosActividades= borderResaltar;
	}

	public Boolean getMostraridListadosCentrosActividades() {
		return this.mostraridListadosCentrosActividades;
	}

	public void setMostraridListadosCentrosActividades(Boolean mostraridListadosCentrosActividades) {
		this.mostraridListadosCentrosActividades= mostraridListadosCentrosActividades;
	}

	public Boolean getActivaridListadosCentrosActividades() {
		return this.activaridListadosCentrosActividades;
	}

	public void setActivaridListadosCentrosActividades(Boolean activaridListadosCentrosActividades) {
		this.activaridListadosCentrosActividades= activaridListadosCentrosActividades;
	}

	public Border setResaltarid_empresaListadosCentrosActividades(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosCentrosActividadesBeanSwingJInternalFrame listadoscentrosactividadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoscentrosactividadesBeanSwingJInternalFrame.jTtoolBarListadosCentrosActividades.setBorder(borderResaltar);
		
		this.resaltarid_empresaListadosCentrosActividades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaListadosCentrosActividades() {
		return this.resaltarid_empresaListadosCentrosActividades;
	}

	public void setResaltarid_empresaListadosCentrosActividades(Border borderResaltar) {
		this.resaltarid_empresaListadosCentrosActividades= borderResaltar;
	}

	public Boolean getMostrarid_empresaListadosCentrosActividades() {
		return this.mostrarid_empresaListadosCentrosActividades;
	}

	public void setMostrarid_empresaListadosCentrosActividades(Boolean mostrarid_empresaListadosCentrosActividades) {
		this.mostrarid_empresaListadosCentrosActividades= mostrarid_empresaListadosCentrosActividades;
	}

	public Boolean getActivarid_empresaListadosCentrosActividades() {
		return this.activarid_empresaListadosCentrosActividades;
	}

	public void setActivarid_empresaListadosCentrosActividades(Boolean activarid_empresaListadosCentrosActividades) {
		this.activarid_empresaListadosCentrosActividades= activarid_empresaListadosCentrosActividades;
	}

	public Boolean getCargarid_empresaListadosCentrosActividades() {
		return this.cargarid_empresaListadosCentrosActividades;
	}

	public void setCargarid_empresaListadosCentrosActividades(Boolean cargarid_empresaListadosCentrosActividades) {
		this.cargarid_empresaListadosCentrosActividades= cargarid_empresaListadosCentrosActividades;
	}

	public Border setResaltarcodigoListadosCentrosActividades(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosCentrosActividadesBeanSwingJInternalFrame listadoscentrosactividadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoscentrosactividadesBeanSwingJInternalFrame.jTtoolBarListadosCentrosActividades.setBorder(borderResaltar);
		
		this.resaltarcodigoListadosCentrosActividades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoListadosCentrosActividades() {
		return this.resaltarcodigoListadosCentrosActividades;
	}

	public void setResaltarcodigoListadosCentrosActividades(Border borderResaltar) {
		this.resaltarcodigoListadosCentrosActividades= borderResaltar;
	}

	public Boolean getMostrarcodigoListadosCentrosActividades() {
		return this.mostrarcodigoListadosCentrosActividades;
	}

	public void setMostrarcodigoListadosCentrosActividades(Boolean mostrarcodigoListadosCentrosActividades) {
		this.mostrarcodigoListadosCentrosActividades= mostrarcodigoListadosCentrosActividades;
	}

	public Boolean getActivarcodigoListadosCentrosActividades() {
		return this.activarcodigoListadosCentrosActividades;
	}

	public void setActivarcodigoListadosCentrosActividades(Boolean activarcodigoListadosCentrosActividades) {
		this.activarcodigoListadosCentrosActividades= activarcodigoListadosCentrosActividades;
	}

	public Border setResaltarnombreListadosCentrosActividades(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosCentrosActividadesBeanSwingJInternalFrame listadoscentrosactividadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoscentrosactividadesBeanSwingJInternalFrame.jTtoolBarListadosCentrosActividades.setBorder(borderResaltar);
		
		this.resaltarnombreListadosCentrosActividades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreListadosCentrosActividades() {
		return this.resaltarnombreListadosCentrosActividades;
	}

	public void setResaltarnombreListadosCentrosActividades(Border borderResaltar) {
		this.resaltarnombreListadosCentrosActividades= borderResaltar;
	}

	public Boolean getMostrarnombreListadosCentrosActividades() {
		return this.mostrarnombreListadosCentrosActividades;
	}

	public void setMostrarnombreListadosCentrosActividades(Boolean mostrarnombreListadosCentrosActividades) {
		this.mostrarnombreListadosCentrosActividades= mostrarnombreListadosCentrosActividades;
	}

	public Boolean getActivarnombreListadosCentrosActividades() {
		return this.activarnombreListadosCentrosActividades;
	}

	public void setActivarnombreListadosCentrosActividades(Boolean activarnombreListadosCentrosActividades) {
		this.activarnombreListadosCentrosActividades= activarnombreListadosCentrosActividades;
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
		
		
		this.setMostraridListadosCentrosActividades(esInicial);
		this.setMostrarid_empresaListadosCentrosActividades(esInicial);
		this.setMostrarcodigoListadosCentrosActividades(esInicial);
		this.setMostrarnombreListadosCentrosActividades(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadosCentrosActividadesConstantesFunciones.ID)) {
				this.setMostraridListadosCentrosActividades(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosActividadesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaListadosCentrosActividades(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosActividadesConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoListadosCentrosActividades(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosActividadesConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreListadosCentrosActividades(esAsigna);
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
		
		
		this.setActivaridListadosCentrosActividades(esInicial);
		this.setActivarid_empresaListadosCentrosActividades(esInicial);
		this.setActivarcodigoListadosCentrosActividades(esInicial);
		this.setActivarnombreListadosCentrosActividades(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadosCentrosActividadesConstantesFunciones.ID)) {
				this.setActivaridListadosCentrosActividades(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosActividadesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaListadosCentrosActividades(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosActividadesConstantesFunciones.CODIGO)) {
				this.setActivarcodigoListadosCentrosActividades(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosActividadesConstantesFunciones.NOMBRE)) {
				this.setActivarnombreListadosCentrosActividades(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ListadosCentrosActividadesBeanSwingJInternalFrame listadoscentrosactividadesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridListadosCentrosActividades(esInicial);
		this.setResaltarid_empresaListadosCentrosActividades(esInicial);
		this.setResaltarcodigoListadosCentrosActividades(esInicial);
		this.setResaltarnombreListadosCentrosActividades(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadosCentrosActividadesConstantesFunciones.ID)) {
				this.setResaltaridListadosCentrosActividades(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosActividadesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaListadosCentrosActividades(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosActividadesConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoListadosCentrosActividades(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosCentrosActividadesConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreListadosCentrosActividades(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ListadosCentrosActividadesBeanSwingJInternalFrame listadoscentrosactividadesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaListadosCentrosActividadesListadosCentrosActividades=true;

	public Boolean getMostrarBusquedaListadosCentrosActividadesListadosCentrosActividades() {
		return this.mostrarBusquedaListadosCentrosActividadesListadosCentrosActividades;
	}

	public void setMostrarBusquedaListadosCentrosActividadesListadosCentrosActividades(Boolean visibilidadResaltar) {
		this.mostrarBusquedaListadosCentrosActividadesListadosCentrosActividades= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaListadosCentrosActividadesListadosCentrosActividades=true;

	public Boolean getActivarBusquedaListadosCentrosActividadesListadosCentrosActividades() {
		return this.activarBusquedaListadosCentrosActividadesListadosCentrosActividades;
	}

	public void setActivarBusquedaListadosCentrosActividadesListadosCentrosActividades(Boolean habilitarResaltar) {
		this.activarBusquedaListadosCentrosActividadesListadosCentrosActividades= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaListadosCentrosActividadesListadosCentrosActividades=null;

	public Border getResaltarBusquedaListadosCentrosActividadesListadosCentrosActividades() {
		return this.resaltarBusquedaListadosCentrosActividadesListadosCentrosActividades;
	}

	public void setResaltarBusquedaListadosCentrosActividadesListadosCentrosActividades(Border borderResaltar) {
		this.resaltarBusquedaListadosCentrosActividadesListadosCentrosActividades= borderResaltar;
	}

	public void setResaltarBusquedaListadosCentrosActividadesListadosCentrosActividades(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosCentrosActividadesBeanSwingJInternalFrame listadoscentrosactividadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaListadosCentrosActividadesListadosCentrosActividades= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}