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


import com.bydan.erp.nomina.util.EstadoNovedadNomiConstantesFunciones;
import com.bydan.erp.nomina.util.EstadoNovedadNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EstadoNovedadNomiParameterGeneral;

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
final public class EstadoNovedadNomiConstantesFunciones extends EstadoNovedadNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoNovedadNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoNovedadNomi"+EstadoNovedadNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoNovedadNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoNovedadNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoNovedadNomiConstantesFunciones.SCHEMA+"_"+EstadoNovedadNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoNovedadNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoNovedadNomiConstantesFunciones.SCHEMA+"_"+EstadoNovedadNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoNovedadNomiConstantesFunciones.SCHEMA+"_"+EstadoNovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoNovedadNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoNovedadNomiConstantesFunciones.SCHEMA+"_"+EstadoNovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoNovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoNovedadNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoNovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoNovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoNovedadNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoNovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoNovedadNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoNovedadNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoNovedadNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoNovedadNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Novedads";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Novedad";
	public static final String SCLASSWEBTITULO_LOWER="Estado Novedad Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoNovedadNomi";
	public static final String OBJECTNAME="estadonovedadnomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="estado_novedad_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadonovedadnomi from "+EstadoNovedadNomiConstantesFunciones.SPERSISTENCENAME+" estadonovedadnomi";
	public static String QUERYSELECTNATIVE="select "+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME+".id,"+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME+".version_row,"+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME+".codigo,"+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME+".nombre from "+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME;//+" as "+EstadoNovedadNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoNovedadNomiConstantesFuncionesAdditional estadonovedadnomiConstantesFuncionesAdditional=null;
	
	public EstadoNovedadNomiConstantesFuncionesAdditional getEstadoNovedadNomiConstantesFuncionesAdditional() {
		return this.estadonovedadnomiConstantesFuncionesAdditional;
	}
	
	public void setEstadoNovedadNomiConstantesFuncionesAdditional(EstadoNovedadNomiConstantesFuncionesAdditional estadonovedadnomiConstantesFuncionesAdditional) {
		try {
			this.estadonovedadnomiConstantesFuncionesAdditional=estadonovedadnomiConstantesFuncionesAdditional;
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
	
	public static String getEstadoNovedadNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoNovedadNomiConstantesFunciones.CODIGO)) {sLabelColumna=EstadoNovedadNomiConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoNovedadNomiConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoNovedadNomiConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoNovedadNomiDescripcion(EstadoNovedadNomi estadonovedadnomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadonovedadnomi !=null/* && estadonovedadnomi.getId()!=0*/) {
			sDescripcion=estadonovedadnomi.getcodigo();//estadonovedadnomiestadonovedadnomi.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoNovedadNomiDescripcionDetallado(EstadoNovedadNomi estadonovedadnomi) {
		String sDescripcion="";
			
		sDescripcion+=EstadoNovedadNomiConstantesFunciones.ID+"=";
		sDescripcion+=estadonovedadnomi.getId().toString()+",";
		sDescripcion+=EstadoNovedadNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadonovedadnomi.getVersionRow().toString()+",";
		sDescripcion+=EstadoNovedadNomiConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadonovedadnomi.getcodigo()+",";
		sDescripcion+=EstadoNovedadNomiConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadonovedadnomi.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoNovedadNomiDescripcion(EstadoNovedadNomi estadonovedadnomi,String sValor) throws Exception {			
		if(estadonovedadnomi !=null) {
			estadonovedadnomi.setcodigo(sValor);;//estadonovedadnomiestadonovedadnomi.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoNovedadNomi(EstadoNovedadNomi estadonovedadnomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadonovedadnomi.setcodigo(estadonovedadnomi.getcodigo().trim());
		estadonovedadnomi.setnombre(estadonovedadnomi.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoNovedadNomis(List<EstadoNovedadNomi> estadonovedadnomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoNovedadNomi estadonovedadnomi: estadonovedadnomis) {
			estadonovedadnomi.setcodigo(estadonovedadnomi.getcodigo().trim());
			estadonovedadnomi.setnombre(estadonovedadnomi.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoNovedadNomi(EstadoNovedadNomi estadonovedadnomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadonovedadnomi.getConCambioAuxiliar()) {
			estadonovedadnomi.setIsDeleted(estadonovedadnomi.getIsDeletedAuxiliar());	
			estadonovedadnomi.setIsNew(estadonovedadnomi.getIsNewAuxiliar());	
			estadonovedadnomi.setIsChanged(estadonovedadnomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadonovedadnomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadonovedadnomi.setIsDeletedAuxiliar(false);	
			estadonovedadnomi.setIsNewAuxiliar(false);	
			estadonovedadnomi.setIsChangedAuxiliar(false);
			
			estadonovedadnomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoNovedadNomis(List<EstadoNovedadNomi> estadonovedadnomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoNovedadNomi estadonovedadnomi : estadonovedadnomis) {
			if(conAsignarBase && estadonovedadnomi.getConCambioAuxiliar()) {
				estadonovedadnomi.setIsDeleted(estadonovedadnomi.getIsDeletedAuxiliar());	
				estadonovedadnomi.setIsNew(estadonovedadnomi.getIsNewAuxiliar());	
				estadonovedadnomi.setIsChanged(estadonovedadnomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadonovedadnomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadonovedadnomi.setIsDeletedAuxiliar(false);	
				estadonovedadnomi.setIsNewAuxiliar(false);	
				estadonovedadnomi.setIsChangedAuxiliar(false);
				
				estadonovedadnomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoNovedadNomi(EstadoNovedadNomi estadonovedadnomi,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoNovedadNomis(List<EstadoNovedadNomi> estadonovedadnomis,Boolean conEnteros) throws Exception  {
		
		for(EstadoNovedadNomi estadonovedadnomi: estadonovedadnomis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoNovedadNomi(List<EstadoNovedadNomi> estadonovedadnomis,EstadoNovedadNomi estadonovedadnomiAux) throws Exception  {
		EstadoNovedadNomiConstantesFunciones.InicializarValoresEstadoNovedadNomi(estadonovedadnomiAux,true);
		
		for(EstadoNovedadNomi estadonovedadnomi: estadonovedadnomis) {
			if(estadonovedadnomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoNovedadNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoNovedadNomiConstantesFunciones.getArrayColumnasGlobalesEstadoNovedadNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoNovedadNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoNovedadNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoNovedadNomi> estadonovedadnomis,EstadoNovedadNomi estadonovedadnomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoNovedadNomi estadonovedadnomiAux: estadonovedadnomis) {
			if(estadonovedadnomiAux!=null && estadonovedadnomi!=null) {
				if((estadonovedadnomiAux.getId()==null && estadonovedadnomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadonovedadnomiAux.getId()!=null && estadonovedadnomi.getId()!=null){
					if(estadonovedadnomiAux.getId().equals(estadonovedadnomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoNovedadNomi(List<EstadoNovedadNomi> estadonovedadnomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoNovedadNomi estadonovedadnomi: estadonovedadnomis) {			
			if(estadonovedadnomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoNovedadNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoNovedadNomiConstantesFunciones.LABEL_ID, EstadoNovedadNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoNovedadNomiConstantesFunciones.LABEL_VERSIONROW, EstadoNovedadNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoNovedadNomiConstantesFunciones.LABEL_CODIGO, EstadoNovedadNomiConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoNovedadNomiConstantesFunciones.LABEL_NOMBRE, EstadoNovedadNomiConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoNovedadNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoNovedadNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoNovedadNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoNovedadNomiConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoNovedadNomiConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoNovedadNomi() throws Exception  {
		return EstadoNovedadNomiConstantesFunciones.getTiposSeleccionarEstadoNovedadNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoNovedadNomi(Boolean conFk) throws Exception  {
		return EstadoNovedadNomiConstantesFunciones.getTiposSeleccionarEstadoNovedadNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoNovedadNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoNovedadNomiConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoNovedadNomiConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoNovedadNomiConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoNovedadNomiConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoNovedadNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoNovedadNomi(EstadoNovedadNomi estadonovedadnomiAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoNovedadNomi(List<EstadoNovedadNomi> estadonovedadnomisTemp) throws Exception {
		for(EstadoNovedadNomi estadonovedadnomiAux:estadonovedadnomisTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoNovedadNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoNovedadNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoNovedadNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoNovedadNomiConstantesFunciones.getClassesRelationshipsOfEstadoNovedadNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoNovedadNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(NovedadNomi.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(NovedadNomi.class)) {
						classes.add(new Classe(NovedadNomi.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoNovedadNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoNovedadNomiConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoNovedadNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoNovedadNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(NovedadNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(NovedadNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadNomi.class)); continue;
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
	public static void actualizarLista(EstadoNovedadNomi estadonovedadnomi,List<EstadoNovedadNomi> estadonovedadnomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoNovedadNomi estadonovedadnomiEncontrado=null;
			
			for(EstadoNovedadNomi estadonovedadnomiLocal:estadonovedadnomis) {
				if(estadonovedadnomiLocal.getId().equals(estadonovedadnomi.getId())) {
					estadonovedadnomiEncontrado=estadonovedadnomiLocal;
					
					estadonovedadnomiLocal.setIsChanged(estadonovedadnomi.getIsChanged());
					estadonovedadnomiLocal.setIsNew(estadonovedadnomi.getIsNew());
					estadonovedadnomiLocal.setIsDeleted(estadonovedadnomi.getIsDeleted());
					
					estadonovedadnomiLocal.setGeneralEntityOriginal(estadonovedadnomi.getGeneralEntityOriginal());
					
					estadonovedadnomiLocal.setId(estadonovedadnomi.getId());	
					estadonovedadnomiLocal.setVersionRow(estadonovedadnomi.getVersionRow());	
					estadonovedadnomiLocal.setcodigo(estadonovedadnomi.getcodigo());	
					estadonovedadnomiLocal.setnombre(estadonovedadnomi.getnombre());	
					
					
					estadonovedadnomiLocal.setNovedadNomis(estadonovedadnomi.getNovedadNomis());
					
					existe=true;
					break;
				}
			}
			
			if(!estadonovedadnomi.getIsDeleted()) {
				if(!existe) {
					estadonovedadnomis.add(estadonovedadnomi);
				}
			} else {
				if(estadonovedadnomiEncontrado!=null && permiteQuitar)  {
					estadonovedadnomis.remove(estadonovedadnomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoNovedadNomi estadonovedadnomi,List<EstadoNovedadNomi> estadonovedadnomis) throws Exception {
		try	{			
			for(EstadoNovedadNomi estadonovedadnomiLocal:estadonovedadnomis) {
				if(estadonovedadnomiLocal.getId().equals(estadonovedadnomi.getId())) {
					estadonovedadnomiLocal.setIsSelected(estadonovedadnomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoNovedadNomi(List<EstadoNovedadNomi> estadonovedadnomisAux) throws Exception {
		//this.estadonovedadnomisAux=estadonovedadnomisAux;
		
		for(EstadoNovedadNomi estadonovedadnomiAux:estadonovedadnomisAux) {
			if(estadonovedadnomiAux.getIsChanged()) {
				estadonovedadnomiAux.setIsChanged(false);
			}		
			
			if(estadonovedadnomiAux.getIsNew()) {
				estadonovedadnomiAux.setIsNew(false);
			}	
			
			if(estadonovedadnomiAux.getIsDeleted()) {
				estadonovedadnomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoNovedadNomi(EstadoNovedadNomi estadonovedadnomiAux) throws Exception {
		//this.estadonovedadnomiAux=estadonovedadnomiAux;
		
			if(estadonovedadnomiAux.getIsChanged()) {
				estadonovedadnomiAux.setIsChanged(false);
			}		
			
			if(estadonovedadnomiAux.getIsNew()) {
				estadonovedadnomiAux.setIsNew(false);
			}	
			
			if(estadonovedadnomiAux.getIsDeleted()) {
				estadonovedadnomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoNovedadNomi estadonovedadnomiAsignar,EstadoNovedadNomi estadonovedadnomi) throws Exception {
		estadonovedadnomiAsignar.setId(estadonovedadnomi.getId());	
		estadonovedadnomiAsignar.setVersionRow(estadonovedadnomi.getVersionRow());	
		estadonovedadnomiAsignar.setcodigo(estadonovedadnomi.getcodigo());	
		estadonovedadnomiAsignar.setnombre(estadonovedadnomi.getnombre());	
	}
	
	public static void inicializarEstadoNovedadNomi(EstadoNovedadNomi estadonovedadnomi) throws Exception {
		try {
				estadonovedadnomi.setId(0L);	
					
				estadonovedadnomi.setcodigo("");	
				estadonovedadnomi.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoNovedadNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoNovedadNomiConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoNovedadNomiConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoNovedadNomi(String sTipo,Row row,Workbook workbook,EstadoNovedadNomi estadonovedadnomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadonovedadnomi.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadonovedadnomi.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoNovedadNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoNovedadNomi() {
		return this.sFinalQueryEstadoNovedadNomi;
	}
	
	public void setsFinalQueryEstadoNovedadNomi(String sFinalQueryEstadoNovedadNomi) {
		this.sFinalQueryEstadoNovedadNomi= sFinalQueryEstadoNovedadNomi;
	}
	
	public Border resaltarSeleccionarEstadoNovedadNomi=null;
	
	public Border setResaltarSeleccionarEstadoNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoNovedadNomiBeanSwingJInternalFrame estadonovedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadonovedadnomiBeanSwingJInternalFrame.jTtoolBarEstadoNovedadNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoNovedadNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoNovedadNomi() {
		return this.resaltarSeleccionarEstadoNovedadNomi;
	}
	
	public void setResaltarSeleccionarEstadoNovedadNomi(Border borderResaltarSeleccionarEstadoNovedadNomi) {
		this.resaltarSeleccionarEstadoNovedadNomi= borderResaltarSeleccionarEstadoNovedadNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoNovedadNomi=null;
	public Boolean mostraridEstadoNovedadNomi=true;
	public Boolean activaridEstadoNovedadNomi=true;

	public Border resaltarcodigoEstadoNovedadNomi=null;
	public Boolean mostrarcodigoEstadoNovedadNomi=true;
	public Boolean activarcodigoEstadoNovedadNomi=true;

	public Border resaltarnombreEstadoNovedadNomi=null;
	public Boolean mostrarnombreEstadoNovedadNomi=true;
	public Boolean activarnombreEstadoNovedadNomi=true;

	
	

	public Border setResaltaridEstadoNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoNovedadNomiBeanSwingJInternalFrame estadonovedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadonovedadnomiBeanSwingJInternalFrame.jTtoolBarEstadoNovedadNomi.setBorder(borderResaltar);
		
		this.resaltaridEstadoNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoNovedadNomi() {
		return this.resaltaridEstadoNovedadNomi;
	}

	public void setResaltaridEstadoNovedadNomi(Border borderResaltar) {
		this.resaltaridEstadoNovedadNomi= borderResaltar;
	}

	public Boolean getMostraridEstadoNovedadNomi() {
		return this.mostraridEstadoNovedadNomi;
	}

	public void setMostraridEstadoNovedadNomi(Boolean mostraridEstadoNovedadNomi) {
		this.mostraridEstadoNovedadNomi= mostraridEstadoNovedadNomi;
	}

	public Boolean getActivaridEstadoNovedadNomi() {
		return this.activaridEstadoNovedadNomi;
	}

	public void setActivaridEstadoNovedadNomi(Boolean activaridEstadoNovedadNomi) {
		this.activaridEstadoNovedadNomi= activaridEstadoNovedadNomi;
	}

	public Border setResaltarcodigoEstadoNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoNovedadNomiBeanSwingJInternalFrame estadonovedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadonovedadnomiBeanSwingJInternalFrame.jTtoolBarEstadoNovedadNomi.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoNovedadNomi() {
		return this.resaltarcodigoEstadoNovedadNomi;
	}

	public void setResaltarcodigoEstadoNovedadNomi(Border borderResaltar) {
		this.resaltarcodigoEstadoNovedadNomi= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoNovedadNomi() {
		return this.mostrarcodigoEstadoNovedadNomi;
	}

	public void setMostrarcodigoEstadoNovedadNomi(Boolean mostrarcodigoEstadoNovedadNomi) {
		this.mostrarcodigoEstadoNovedadNomi= mostrarcodigoEstadoNovedadNomi;
	}

	public Boolean getActivarcodigoEstadoNovedadNomi() {
		return this.activarcodigoEstadoNovedadNomi;
	}

	public void setActivarcodigoEstadoNovedadNomi(Boolean activarcodigoEstadoNovedadNomi) {
		this.activarcodigoEstadoNovedadNomi= activarcodigoEstadoNovedadNomi;
	}

	public Border setResaltarnombreEstadoNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoNovedadNomiBeanSwingJInternalFrame estadonovedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadonovedadnomiBeanSwingJInternalFrame.jTtoolBarEstadoNovedadNomi.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoNovedadNomi() {
		return this.resaltarnombreEstadoNovedadNomi;
	}

	public void setResaltarnombreEstadoNovedadNomi(Border borderResaltar) {
		this.resaltarnombreEstadoNovedadNomi= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoNovedadNomi() {
		return this.mostrarnombreEstadoNovedadNomi;
	}

	public void setMostrarnombreEstadoNovedadNomi(Boolean mostrarnombreEstadoNovedadNomi) {
		this.mostrarnombreEstadoNovedadNomi= mostrarnombreEstadoNovedadNomi;
	}

	public Boolean getActivarnombreEstadoNovedadNomi() {
		return this.activarnombreEstadoNovedadNomi;
	}

	public void setActivarnombreEstadoNovedadNomi(Boolean activarnombreEstadoNovedadNomi) {
		this.activarnombreEstadoNovedadNomi= activarnombreEstadoNovedadNomi;
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
		
		
		this.setMostraridEstadoNovedadNomi(esInicial);
		this.setMostrarcodigoEstadoNovedadNomi(esInicial);
		this.setMostrarnombreEstadoNovedadNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoNovedadNomiConstantesFunciones.ID)) {
				this.setMostraridEstadoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNovedadNomiConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNovedadNomiConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoNovedadNomi(esAsigna);
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
		
		
		this.setActivaridEstadoNovedadNomi(esInicial);
		this.setActivarcodigoEstadoNovedadNomi(esInicial);
		this.setActivarnombreEstadoNovedadNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoNovedadNomiConstantesFunciones.ID)) {
				this.setActivaridEstadoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNovedadNomiConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNovedadNomiConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoNovedadNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoNovedadNomiBeanSwingJInternalFrame estadonovedadnomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoNovedadNomi(esInicial);
		this.setResaltarcodigoEstadoNovedadNomi(esInicial);
		this.setResaltarnombreEstadoNovedadNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoNovedadNomiConstantesFunciones.ID)) {
				this.setResaltaridEstadoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNovedadNomiConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNovedadNomiConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoNovedadNomi(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarNovedadNomiEstadoNovedadNomi=null;

	public Border getResaltarNovedadNomiEstadoNovedadNomi() {
		return this.resaltarNovedadNomiEstadoNovedadNomi;
	}

	public void setResaltarNovedadNomiEstadoNovedadNomi(Border borderResaltarNovedadNomi) {
		if(borderResaltarNovedadNomi!=null) {
			this.resaltarNovedadNomiEstadoNovedadNomi= borderResaltarNovedadNomi;
		}
	}

	public Border setResaltarNovedadNomiEstadoNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoNovedadNomiBeanSwingJInternalFrame estadonovedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltarNovedadNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadonovedadnomiBeanSwingJInternalFrame.jTtoolBarEstadoNovedadNomi.setBorder(borderResaltarNovedadNomi);
			
		this.resaltarNovedadNomiEstadoNovedadNomi= borderResaltarNovedadNomi;

		 return borderResaltarNovedadNomi;
	}



	public Boolean mostrarNovedadNomiEstadoNovedadNomi=true;

	public Boolean getMostrarNovedadNomiEstadoNovedadNomi() {
		return this.mostrarNovedadNomiEstadoNovedadNomi;
	}

	public void setMostrarNovedadNomiEstadoNovedadNomi(Boolean visibilidadResaltarNovedadNomi) {
		this.mostrarNovedadNomiEstadoNovedadNomi= visibilidadResaltarNovedadNomi;
	}



	public Boolean activarNovedadNomiEstadoNovedadNomi=true;

	public Boolean gethabilitarResaltarNovedadNomiEstadoNovedadNomi() {
		return this.activarNovedadNomiEstadoNovedadNomi;
	}

	public void setActivarNovedadNomiEstadoNovedadNomi(Boolean habilitarResaltarNovedadNomi) {
		this.activarNovedadNomiEstadoNovedadNomi= habilitarResaltarNovedadNomi;
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

		this.setMostrarNovedadNomiEstadoNovedadNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NovedadNomi.class)) {
				this.setMostrarNovedadNomiEstadoNovedadNomi(esAsigna);
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

		this.setActivarNovedadNomiEstadoNovedadNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NovedadNomi.class)) {
				this.setActivarNovedadNomiEstadoNovedadNomi(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoNovedadNomiBeanSwingJInternalFrame estadonovedadnomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarNovedadNomiEstadoNovedadNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NovedadNomi.class)) {
				this.setResaltarNovedadNomiEstadoNovedadNomi(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}