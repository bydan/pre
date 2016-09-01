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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.EstadoSolicitudNomiConstantesFunciones;
import com.bydan.erp.nomina.util.EstadoSolicitudNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EstadoSolicitudNomiParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoSolicitudNomiConstantesFunciones extends EstadoSolicitudNomiConstantesFuncionesAdditional {		
	
	
	
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
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="EstadoSolicitudNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoSolicitudNomi"+EstadoSolicitudNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoSolicitudNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoSolicitudNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoSolicitudNomiConstantesFunciones.SCHEMA+"_"+EstadoSolicitudNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoSolicitudNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoSolicitudNomiConstantesFunciones.SCHEMA+"_"+EstadoSolicitudNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoSolicitudNomiConstantesFunciones.SCHEMA+"_"+EstadoSolicitudNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoSolicitudNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoSolicitudNomiConstantesFunciones.SCHEMA+"_"+EstadoSolicitudNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoSolicitudNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoSolicitudNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoSolicitudNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoSolicitudNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoSolicitudNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoSolicitudNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoSolicitudNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoSolicitudNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoSolicitudNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoSolicitudNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Solicituds";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Solicitud";
	public static final String SCLASSWEBTITULO_LOWER="Estado Solicitud Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoSolicitudNomi";
	public static final String OBJECTNAME="estadosolicitudnomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="estado_solicitud_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadosolicitudnomi from "+EstadoSolicitudNomiConstantesFunciones.SPERSISTENCENAME+" estadosolicitudnomi";
	public static String QUERYSELECTNATIVE="select "+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME+".id,"+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME+".version_row,"+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME+".codigo,"+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME+".nombre from "+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME;//+" as "+EstadoSolicitudNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoSolicitudNomiConstantesFuncionesAdditional estadosolicitudnomiConstantesFuncionesAdditional=null;
	
	public EstadoSolicitudNomiConstantesFuncionesAdditional getEstadoSolicitudNomiConstantesFuncionesAdditional() {
		return this.estadosolicitudnomiConstantesFuncionesAdditional;
	}
	
	public void setEstadoSolicitudNomiConstantesFuncionesAdditional(EstadoSolicitudNomiConstantesFuncionesAdditional estadosolicitudnomiConstantesFuncionesAdditional) {
		try {
			this.estadosolicitudnomiConstantesFuncionesAdditional=estadosolicitudnomiConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEstadoSolicitudNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoSolicitudNomiConstantesFunciones.CODIGO)) {sLabelColumna=EstadoSolicitudNomiConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoSolicitudNomiConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoSolicitudNomiConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoSolicitudNomiDescripcion(EstadoSolicitudNomi estadosolicitudnomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadosolicitudnomi !=null/* && estadosolicitudnomi.getId()!=0*/) {
			sDescripcion=estadosolicitudnomi.getcodigo();//estadosolicitudnomiestadosolicitudnomi.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoSolicitudNomiDescripcionDetallado(EstadoSolicitudNomi estadosolicitudnomi) {
		String sDescripcion="";
			
		sDescripcion+=EstadoSolicitudNomiConstantesFunciones.ID+"=";
		sDescripcion+=estadosolicitudnomi.getId().toString()+",";
		sDescripcion+=EstadoSolicitudNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadosolicitudnomi.getVersionRow().toString()+",";
		sDescripcion+=EstadoSolicitudNomiConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadosolicitudnomi.getcodigo()+",";
		sDescripcion+=EstadoSolicitudNomiConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadosolicitudnomi.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoSolicitudNomiDescripcion(EstadoSolicitudNomi estadosolicitudnomi,String sValor) throws Exception {			
		if(estadosolicitudnomi !=null) {
			estadosolicitudnomi.setcodigo(sValor);;//estadosolicitudnomiestadosolicitudnomi.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}
	
	
	
	
	
	
	public static void quitarEspaciosEstadoSolicitudNomi(EstadoSolicitudNomi estadosolicitudnomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadosolicitudnomi.setcodigo(estadosolicitudnomi.getcodigo().trim());
		estadosolicitudnomi.setnombre(estadosolicitudnomi.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoSolicitudNomis(List<EstadoSolicitudNomi> estadosolicitudnomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoSolicitudNomi estadosolicitudnomi: estadosolicitudnomis) {
			estadosolicitudnomi.setcodigo(estadosolicitudnomi.getcodigo().trim());
			estadosolicitudnomi.setnombre(estadosolicitudnomi.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoSolicitudNomi(EstadoSolicitudNomi estadosolicitudnomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadosolicitudnomi.getConCambioAuxiliar()) {
			estadosolicitudnomi.setIsDeleted(estadosolicitudnomi.getIsDeletedAuxiliar());	
			estadosolicitudnomi.setIsNew(estadosolicitudnomi.getIsNewAuxiliar());	
			estadosolicitudnomi.setIsChanged(estadosolicitudnomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadosolicitudnomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadosolicitudnomi.setIsDeletedAuxiliar(false);	
			estadosolicitudnomi.setIsNewAuxiliar(false);	
			estadosolicitudnomi.setIsChangedAuxiliar(false);
			
			estadosolicitudnomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoSolicitudNomis(List<EstadoSolicitudNomi> estadosolicitudnomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoSolicitudNomi estadosolicitudnomi : estadosolicitudnomis) {
			if(conAsignarBase && estadosolicitudnomi.getConCambioAuxiliar()) {
				estadosolicitudnomi.setIsDeleted(estadosolicitudnomi.getIsDeletedAuxiliar());	
				estadosolicitudnomi.setIsNew(estadosolicitudnomi.getIsNewAuxiliar());	
				estadosolicitudnomi.setIsChanged(estadosolicitudnomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadosolicitudnomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadosolicitudnomi.setIsDeletedAuxiliar(false);	
				estadosolicitudnomi.setIsNewAuxiliar(false);	
				estadosolicitudnomi.setIsChangedAuxiliar(false);
				
				estadosolicitudnomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoSolicitudNomi(EstadoSolicitudNomi estadosolicitudnomi,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoSolicitudNomis(List<EstadoSolicitudNomi> estadosolicitudnomis,Boolean conEnteros) throws Exception  {
		
		for(EstadoSolicitudNomi estadosolicitudnomi: estadosolicitudnomis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoSolicitudNomi(List<EstadoSolicitudNomi> estadosolicitudnomis,EstadoSolicitudNomi estadosolicitudnomiAux) throws Exception  {
		EstadoSolicitudNomiConstantesFunciones.InicializarValoresEstadoSolicitudNomi(estadosolicitudnomiAux,true);
		
		for(EstadoSolicitudNomi estadosolicitudnomi: estadosolicitudnomis) {
			if(estadosolicitudnomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoSolicitudNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoSolicitudNomiConstantesFunciones.getArrayColumnasGlobalesEstadoSolicitudNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoSolicitudNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoSolicitudNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoSolicitudNomi> estadosolicitudnomis,EstadoSolicitudNomi estadosolicitudnomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoSolicitudNomi estadosolicitudnomiAux: estadosolicitudnomis) {
			if(estadosolicitudnomiAux!=null && estadosolicitudnomi!=null) {
				if((estadosolicitudnomiAux.getId()==null && estadosolicitudnomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadosolicitudnomiAux.getId()!=null && estadosolicitudnomi.getId()!=null){
					if(estadosolicitudnomiAux.getId().equals(estadosolicitudnomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoSolicitudNomi(List<EstadoSolicitudNomi> estadosolicitudnomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoSolicitudNomi estadosolicitudnomi: estadosolicitudnomis) {			
			if(estadosolicitudnomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoSolicitudNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoSolicitudNomiConstantesFunciones.LABEL_ID, EstadoSolicitudNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoSolicitudNomiConstantesFunciones.LABEL_VERSIONROW, EstadoSolicitudNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoSolicitudNomiConstantesFunciones.LABEL_CODIGO, EstadoSolicitudNomiConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoSolicitudNomiConstantesFunciones.LABEL_NOMBRE, EstadoSolicitudNomiConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoSolicitudNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoSolicitudNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoSolicitudNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoSolicitudNomiConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoSolicitudNomiConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoSolicitudNomi() throws Exception  {
		return EstadoSolicitudNomiConstantesFunciones.getTiposSeleccionarEstadoSolicitudNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoSolicitudNomi(Boolean conFk) throws Exception  {
		return EstadoSolicitudNomiConstantesFunciones.getTiposSeleccionarEstadoSolicitudNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoSolicitudNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoSolicitudNomiConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoSolicitudNomiConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoSolicitudNomiConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoSolicitudNomiConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoSolicitudNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoSolicitudNomi(EstadoSolicitudNomi estadosolicitudnomiAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoSolicitudNomi(List<EstadoSolicitudNomi> estadosolicitudnomisTemp) throws Exception {
		for(EstadoSolicitudNomi estadosolicitudnomiAux:estadosolicitudnomisTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoSolicitudNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoSolicitudNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoSolicitudNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoSolicitudNomiConstantesFunciones.getClassesRelationshipsOfEstadoSolicitudNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoSolicitudNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(SolicitudReemplazo.class));
				classes.add(new Classe(SolicitudHoraExtra.class));
				classes.add(new Classe(SolicitudVacacion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(SolicitudReemplazo.class)) {
						classes.add(new Classe(SolicitudReemplazo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SolicitudHoraExtra.class)) {
						classes.add(new Classe(SolicitudHoraExtra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SolicitudVacacion.class)) {
						classes.add(new Classe(SolicitudVacacion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoSolicitudNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoSolicitudNomiConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoSolicitudNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoSolicitudNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(SolicitudReemplazo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SolicitudReemplazo.class)); continue;
					}

					if(SolicitudHoraExtra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SolicitudHoraExtra.class)); continue;
					}

					if(SolicitudVacacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SolicitudVacacion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(SolicitudReemplazo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SolicitudReemplazo.class)); continue;
					}

					if(SolicitudHoraExtra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SolicitudHoraExtra.class)); continue;
					}

					if(SolicitudVacacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SolicitudVacacion.class)); continue;
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
	public static void actualizarLista(EstadoSolicitudNomi estadosolicitudnomi,List<EstadoSolicitudNomi> estadosolicitudnomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoSolicitudNomi estadosolicitudnomiEncontrado=null;
			
			for(EstadoSolicitudNomi estadosolicitudnomiLocal:estadosolicitudnomis) {
				if(estadosolicitudnomiLocal.getId().equals(estadosolicitudnomi.getId())) {
					estadosolicitudnomiEncontrado=estadosolicitudnomiLocal;
					
					estadosolicitudnomiLocal.setIsChanged(estadosolicitudnomi.getIsChanged());
					estadosolicitudnomiLocal.setIsNew(estadosolicitudnomi.getIsNew());
					estadosolicitudnomiLocal.setIsDeleted(estadosolicitudnomi.getIsDeleted());
					
					estadosolicitudnomiLocal.setGeneralEntityOriginal(estadosolicitudnomi.getGeneralEntityOriginal());
					
					estadosolicitudnomiLocal.setId(estadosolicitudnomi.getId());	
					estadosolicitudnomiLocal.setVersionRow(estadosolicitudnomi.getVersionRow());	
					estadosolicitudnomiLocal.setcodigo(estadosolicitudnomi.getcodigo());	
					estadosolicitudnomiLocal.setnombre(estadosolicitudnomi.getnombre());	
					
					
					estadosolicitudnomiLocal.setSolicitudReemplazos(estadosolicitudnomi.getSolicitudReemplazos());
					estadosolicitudnomiLocal.setSolicitudHoraExtras(estadosolicitudnomi.getSolicitudHoraExtras());
					estadosolicitudnomiLocal.setSolicitudVacacions(estadosolicitudnomi.getSolicitudVacacions());
					
					existe=true;
					break;
				}
			}
			
			if(!estadosolicitudnomi.getIsDeleted()) {
				if(!existe) {
					estadosolicitudnomis.add(estadosolicitudnomi);
				}
			} else {
				if(estadosolicitudnomiEncontrado!=null && permiteQuitar)  {
					estadosolicitudnomis.remove(estadosolicitudnomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoSolicitudNomi estadosolicitudnomi,List<EstadoSolicitudNomi> estadosolicitudnomis) throws Exception {
		try	{			
			for(EstadoSolicitudNomi estadosolicitudnomiLocal:estadosolicitudnomis) {
				if(estadosolicitudnomiLocal.getId().equals(estadosolicitudnomi.getId())) {
					estadosolicitudnomiLocal.setIsSelected(estadosolicitudnomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoSolicitudNomi(List<EstadoSolicitudNomi> estadosolicitudnomisAux) throws Exception {
		//this.estadosolicitudnomisAux=estadosolicitudnomisAux;
		
		for(EstadoSolicitudNomi estadosolicitudnomiAux:estadosolicitudnomisAux) {
			if(estadosolicitudnomiAux.getIsChanged()) {
				estadosolicitudnomiAux.setIsChanged(false);
			}		
			
			if(estadosolicitudnomiAux.getIsNew()) {
				estadosolicitudnomiAux.setIsNew(false);
			}	
			
			if(estadosolicitudnomiAux.getIsDeleted()) {
				estadosolicitudnomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoSolicitudNomi(EstadoSolicitudNomi estadosolicitudnomiAux) throws Exception {
		//this.estadosolicitudnomiAux=estadosolicitudnomiAux;
		
			if(estadosolicitudnomiAux.getIsChanged()) {
				estadosolicitudnomiAux.setIsChanged(false);
			}		
			
			if(estadosolicitudnomiAux.getIsNew()) {
				estadosolicitudnomiAux.setIsNew(false);
			}	
			
			if(estadosolicitudnomiAux.getIsDeleted()) {
				estadosolicitudnomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoSolicitudNomi estadosolicitudnomiAsignar,EstadoSolicitudNomi estadosolicitudnomi) throws Exception {
		estadosolicitudnomiAsignar.setId(estadosolicitudnomi.getId());	
		estadosolicitudnomiAsignar.setVersionRow(estadosolicitudnomi.getVersionRow());	
		estadosolicitudnomiAsignar.setcodigo(estadosolicitudnomi.getcodigo());	
		estadosolicitudnomiAsignar.setnombre(estadosolicitudnomi.getnombre());	
	}
	
	public static void inicializarEstadoSolicitudNomi(EstadoSolicitudNomi estadosolicitudnomi) throws Exception {
		try {
				estadosolicitudnomi.setId(0L);	
					
				estadosolicitudnomi.setcodigo("");	
				estadosolicitudnomi.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoSolicitudNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoSolicitudNomiConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoSolicitudNomiConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoSolicitudNomi(String sTipo,Row row,Workbook workbook,EstadoSolicitudNomi estadosolicitudnomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosolicitudnomi.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosolicitudnomi.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoSolicitudNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoSolicitudNomi() {
		return this.sFinalQueryEstadoSolicitudNomi;
	}
	
	public void setsFinalQueryEstadoSolicitudNomi(String sFinalQueryEstadoSolicitudNomi) {
		this.sFinalQueryEstadoSolicitudNomi= sFinalQueryEstadoSolicitudNomi;
	}
	
	public Border resaltarSeleccionarEstadoSolicitudNomi=null;
	
	public Border setResaltarSeleccionarEstadoSolicitudNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoSolicitudNomiBeanSwingJInternalFrame estadosolicitudnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadosolicitudnomiBeanSwingJInternalFrame.jTtoolBarEstadoSolicitudNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoSolicitudNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoSolicitudNomi() {
		return this.resaltarSeleccionarEstadoSolicitudNomi;
	}
	
	public void setResaltarSeleccionarEstadoSolicitudNomi(Border borderResaltarSeleccionarEstadoSolicitudNomi) {
		this.resaltarSeleccionarEstadoSolicitudNomi= borderResaltarSeleccionarEstadoSolicitudNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoSolicitudNomi=null;
	public Boolean mostraridEstadoSolicitudNomi=true;
	public Boolean activaridEstadoSolicitudNomi=true;

	public Border resaltarcodigoEstadoSolicitudNomi=null;
	public Boolean mostrarcodigoEstadoSolicitudNomi=true;
	public Boolean activarcodigoEstadoSolicitudNomi=true;

	public Border resaltarnombreEstadoSolicitudNomi=null;
	public Boolean mostrarnombreEstadoSolicitudNomi=true;
	public Boolean activarnombreEstadoSolicitudNomi=true;

	
	

	public Border setResaltaridEstadoSolicitudNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoSolicitudNomiBeanSwingJInternalFrame estadosolicitudnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosolicitudnomiBeanSwingJInternalFrame.jTtoolBarEstadoSolicitudNomi.setBorder(borderResaltar);
		
		this.resaltaridEstadoSolicitudNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoSolicitudNomi() {
		return this.resaltaridEstadoSolicitudNomi;
	}

	public void setResaltaridEstadoSolicitudNomi(Border borderResaltar) {
		this.resaltaridEstadoSolicitudNomi= borderResaltar;
	}

	public Boolean getMostraridEstadoSolicitudNomi() {
		return this.mostraridEstadoSolicitudNomi;
	}

	public void setMostraridEstadoSolicitudNomi(Boolean mostraridEstadoSolicitudNomi) {
		this.mostraridEstadoSolicitudNomi= mostraridEstadoSolicitudNomi;
	}

	public Boolean getActivaridEstadoSolicitudNomi() {
		return this.activaridEstadoSolicitudNomi;
	}

	public void setActivaridEstadoSolicitudNomi(Boolean activaridEstadoSolicitudNomi) {
		this.activaridEstadoSolicitudNomi= activaridEstadoSolicitudNomi;
	}

	public Border setResaltarcodigoEstadoSolicitudNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoSolicitudNomiBeanSwingJInternalFrame estadosolicitudnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosolicitudnomiBeanSwingJInternalFrame.jTtoolBarEstadoSolicitudNomi.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoSolicitudNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoSolicitudNomi() {
		return this.resaltarcodigoEstadoSolicitudNomi;
	}

	public void setResaltarcodigoEstadoSolicitudNomi(Border borderResaltar) {
		this.resaltarcodigoEstadoSolicitudNomi= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoSolicitudNomi() {
		return this.mostrarcodigoEstadoSolicitudNomi;
	}

	public void setMostrarcodigoEstadoSolicitudNomi(Boolean mostrarcodigoEstadoSolicitudNomi) {
		this.mostrarcodigoEstadoSolicitudNomi= mostrarcodigoEstadoSolicitudNomi;
	}

	public Boolean getActivarcodigoEstadoSolicitudNomi() {
		return this.activarcodigoEstadoSolicitudNomi;
	}

	public void setActivarcodigoEstadoSolicitudNomi(Boolean activarcodigoEstadoSolicitudNomi) {
		this.activarcodigoEstadoSolicitudNomi= activarcodigoEstadoSolicitudNomi;
	}

	public Border setResaltarnombreEstadoSolicitudNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoSolicitudNomiBeanSwingJInternalFrame estadosolicitudnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosolicitudnomiBeanSwingJInternalFrame.jTtoolBarEstadoSolicitudNomi.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoSolicitudNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoSolicitudNomi() {
		return this.resaltarnombreEstadoSolicitudNomi;
	}

	public void setResaltarnombreEstadoSolicitudNomi(Border borderResaltar) {
		this.resaltarnombreEstadoSolicitudNomi= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoSolicitudNomi() {
		return this.mostrarnombreEstadoSolicitudNomi;
	}

	public void setMostrarnombreEstadoSolicitudNomi(Boolean mostrarnombreEstadoSolicitudNomi) {
		this.mostrarnombreEstadoSolicitudNomi= mostrarnombreEstadoSolicitudNomi;
	}

	public Boolean getActivarnombreEstadoSolicitudNomi() {
		return this.activarnombreEstadoSolicitudNomi;
	}

	public void setActivarnombreEstadoSolicitudNomi(Boolean activarnombreEstadoSolicitudNomi) {
		this.activarnombreEstadoSolicitudNomi= activarnombreEstadoSolicitudNomi;
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
		
		
		this.setMostraridEstadoSolicitudNomi(esInicial);
		this.setMostrarcodigoEstadoSolicitudNomi(esInicial);
		this.setMostrarnombreEstadoSolicitudNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoSolicitudNomiConstantesFunciones.ID)) {
				this.setMostraridEstadoSolicitudNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoSolicitudNomiConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoSolicitudNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoSolicitudNomiConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoSolicitudNomi(esAsigna);
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
		
		
		this.setActivaridEstadoSolicitudNomi(esInicial);
		this.setActivarcodigoEstadoSolicitudNomi(esInicial);
		this.setActivarnombreEstadoSolicitudNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoSolicitudNomiConstantesFunciones.ID)) {
				this.setActivaridEstadoSolicitudNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoSolicitudNomiConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoSolicitudNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoSolicitudNomiConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoSolicitudNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoSolicitudNomiBeanSwingJInternalFrame estadosolicitudnomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoSolicitudNomi(esInicial);
		this.setResaltarcodigoEstadoSolicitudNomi(esInicial);
		this.setResaltarnombreEstadoSolicitudNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoSolicitudNomiConstantesFunciones.ID)) {
				this.setResaltaridEstadoSolicitudNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoSolicitudNomiConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoSolicitudNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoSolicitudNomiConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoSolicitudNomi(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarSolicitudReemplazoEstadoSolicitudNomi=null;

	public Border getResaltarSolicitudReemplazoEstadoSolicitudNomi() {
		return this.resaltarSolicitudReemplazoEstadoSolicitudNomi;
	}

	public void setResaltarSolicitudReemplazoEstadoSolicitudNomi(Border borderResaltarSolicitudReemplazo) {
		if(borderResaltarSolicitudReemplazo!=null) {
			this.resaltarSolicitudReemplazoEstadoSolicitudNomi= borderResaltarSolicitudReemplazo;
		}
	}

	public Border setResaltarSolicitudReemplazoEstadoSolicitudNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoSolicitudNomiBeanSwingJInternalFrame estadosolicitudnomiBeanSwingJInternalFrame*/) {
		Border borderResaltarSolicitudReemplazo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadosolicitudnomiBeanSwingJInternalFrame.jTtoolBarEstadoSolicitudNomi.setBorder(borderResaltarSolicitudReemplazo);
			
		this.resaltarSolicitudReemplazoEstadoSolicitudNomi= borderResaltarSolicitudReemplazo;

		 return borderResaltarSolicitudReemplazo;
	}



	public Boolean mostrarSolicitudReemplazoEstadoSolicitudNomi=true;

	public Boolean getMostrarSolicitudReemplazoEstadoSolicitudNomi() {
		return this.mostrarSolicitudReemplazoEstadoSolicitudNomi;
	}

	public void setMostrarSolicitudReemplazoEstadoSolicitudNomi(Boolean visibilidadResaltarSolicitudReemplazo) {
		this.mostrarSolicitudReemplazoEstadoSolicitudNomi= visibilidadResaltarSolicitudReemplazo;
	}



	public Boolean activarSolicitudReemplazoEstadoSolicitudNomi=true;

	public Boolean gethabilitarResaltarSolicitudReemplazoEstadoSolicitudNomi() {
		return this.activarSolicitudReemplazoEstadoSolicitudNomi;
	}

	public void setActivarSolicitudReemplazoEstadoSolicitudNomi(Boolean habilitarResaltarSolicitudReemplazo) {
		this.activarSolicitudReemplazoEstadoSolicitudNomi= habilitarResaltarSolicitudReemplazo;
	}


	public Border resaltarSolicitudHoraExtraEstadoSolicitudNomi=null;

	public Border getResaltarSolicitudHoraExtraEstadoSolicitudNomi() {
		return this.resaltarSolicitudHoraExtraEstadoSolicitudNomi;
	}

	public void setResaltarSolicitudHoraExtraEstadoSolicitudNomi(Border borderResaltarSolicitudHoraExtra) {
		if(borderResaltarSolicitudHoraExtra!=null) {
			this.resaltarSolicitudHoraExtraEstadoSolicitudNomi= borderResaltarSolicitudHoraExtra;
		}
	}

	public Border setResaltarSolicitudHoraExtraEstadoSolicitudNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoSolicitudNomiBeanSwingJInternalFrame estadosolicitudnomiBeanSwingJInternalFrame*/) {
		Border borderResaltarSolicitudHoraExtra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadosolicitudnomiBeanSwingJInternalFrame.jTtoolBarEstadoSolicitudNomi.setBorder(borderResaltarSolicitudHoraExtra);
			
		this.resaltarSolicitudHoraExtraEstadoSolicitudNomi= borderResaltarSolicitudHoraExtra;

		 return borderResaltarSolicitudHoraExtra;
	}



	public Boolean mostrarSolicitudHoraExtraEstadoSolicitudNomi=true;

	public Boolean getMostrarSolicitudHoraExtraEstadoSolicitudNomi() {
		return this.mostrarSolicitudHoraExtraEstadoSolicitudNomi;
	}

	public void setMostrarSolicitudHoraExtraEstadoSolicitudNomi(Boolean visibilidadResaltarSolicitudHoraExtra) {
		this.mostrarSolicitudHoraExtraEstadoSolicitudNomi= visibilidadResaltarSolicitudHoraExtra;
	}



	public Boolean activarSolicitudHoraExtraEstadoSolicitudNomi=true;

	public Boolean gethabilitarResaltarSolicitudHoraExtraEstadoSolicitudNomi() {
		return this.activarSolicitudHoraExtraEstadoSolicitudNomi;
	}

	public void setActivarSolicitudHoraExtraEstadoSolicitudNomi(Boolean habilitarResaltarSolicitudHoraExtra) {
		this.activarSolicitudHoraExtraEstadoSolicitudNomi= habilitarResaltarSolicitudHoraExtra;
	}


	public Border resaltarSolicitudVacacionEstadoSolicitudNomi=null;

	public Border getResaltarSolicitudVacacionEstadoSolicitudNomi() {
		return this.resaltarSolicitudVacacionEstadoSolicitudNomi;
	}

	public void setResaltarSolicitudVacacionEstadoSolicitudNomi(Border borderResaltarSolicitudVacacion) {
		if(borderResaltarSolicitudVacacion!=null) {
			this.resaltarSolicitudVacacionEstadoSolicitudNomi= borderResaltarSolicitudVacacion;
		}
	}

	public Border setResaltarSolicitudVacacionEstadoSolicitudNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoSolicitudNomiBeanSwingJInternalFrame estadosolicitudnomiBeanSwingJInternalFrame*/) {
		Border borderResaltarSolicitudVacacion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadosolicitudnomiBeanSwingJInternalFrame.jTtoolBarEstadoSolicitudNomi.setBorder(borderResaltarSolicitudVacacion);
			
		this.resaltarSolicitudVacacionEstadoSolicitudNomi= borderResaltarSolicitudVacacion;

		 return borderResaltarSolicitudVacacion;
	}



	public Boolean mostrarSolicitudVacacionEstadoSolicitudNomi=true;

	public Boolean getMostrarSolicitudVacacionEstadoSolicitudNomi() {
		return this.mostrarSolicitudVacacionEstadoSolicitudNomi;
	}

	public void setMostrarSolicitudVacacionEstadoSolicitudNomi(Boolean visibilidadResaltarSolicitudVacacion) {
		this.mostrarSolicitudVacacionEstadoSolicitudNomi= visibilidadResaltarSolicitudVacacion;
	}



	public Boolean activarSolicitudVacacionEstadoSolicitudNomi=true;

	public Boolean gethabilitarResaltarSolicitudVacacionEstadoSolicitudNomi() {
		return this.activarSolicitudVacacionEstadoSolicitudNomi;
	}

	public void setActivarSolicitudVacacionEstadoSolicitudNomi(Boolean habilitarResaltarSolicitudVacacion) {
		this.activarSolicitudVacacionEstadoSolicitudNomi= habilitarResaltarSolicitudVacacion;
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

		this.setMostrarSolicitudReemplazoEstadoSolicitudNomi(esInicial);
		this.setMostrarSolicitudHoraExtraEstadoSolicitudNomi(esInicial);
		this.setMostrarSolicitudVacacionEstadoSolicitudNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(SolicitudReemplazo.class)) {
				this.setMostrarSolicitudReemplazoEstadoSolicitudNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(SolicitudHoraExtra.class)) {
				this.setMostrarSolicitudHoraExtraEstadoSolicitudNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(SolicitudVacacion.class)) {
				this.setMostrarSolicitudVacacionEstadoSolicitudNomi(esAsigna);
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

		this.setActivarSolicitudReemplazoEstadoSolicitudNomi(esInicial);
		this.setActivarSolicitudHoraExtraEstadoSolicitudNomi(esInicial);
		this.setActivarSolicitudVacacionEstadoSolicitudNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(SolicitudReemplazo.class)) {
				this.setActivarSolicitudReemplazoEstadoSolicitudNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(SolicitudHoraExtra.class)) {
				this.setActivarSolicitudHoraExtraEstadoSolicitudNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(SolicitudVacacion.class)) {
				this.setActivarSolicitudVacacionEstadoSolicitudNomi(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoSolicitudNomiBeanSwingJInternalFrame estadosolicitudnomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarSolicitudReemplazoEstadoSolicitudNomi(esInicial);
		this.setResaltarSolicitudHoraExtraEstadoSolicitudNomi(esInicial);
		this.setResaltarSolicitudVacacionEstadoSolicitudNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(SolicitudReemplazo.class)) {
				this.setResaltarSolicitudReemplazoEstadoSolicitudNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(SolicitudHoraExtra.class)) {
				this.setResaltarSolicitudHoraExtraEstadoSolicitudNomi(esAsigna);
				continue;
			}

			if(clase.clas.equals(SolicitudVacacion.class)) {
				this.setResaltarSolicitudVacacionEstadoSolicitudNomi(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}