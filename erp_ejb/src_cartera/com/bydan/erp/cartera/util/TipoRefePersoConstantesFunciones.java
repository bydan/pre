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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.TipoRefePersoConstantesFunciones;
import com.bydan.erp.cartera.util.TipoRefePersoParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoRefePersoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoRefePersoConstantesFunciones extends TipoRefePersoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoRefePerso";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoRefePerso"+TipoRefePersoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoRefePersoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoRefePersoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoRefePersoConstantesFunciones.SCHEMA+"_"+TipoRefePersoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoRefePersoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoRefePersoConstantesFunciones.SCHEMA+"_"+TipoRefePersoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoRefePersoConstantesFunciones.SCHEMA+"_"+TipoRefePersoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoRefePersoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoRefePersoConstantesFunciones.SCHEMA+"_"+TipoRefePersoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRefePersoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRefePersoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRefePersoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRefePersoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRefePersoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRefePersoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoRefePersoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoRefePersoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoRefePersoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoRefePersoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Refe Persos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Refe Perso";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Refe Perso";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoRefePerso";
	public static final String OBJECTNAME="tiporefeperso";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_refe_perso";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiporefeperso from "+TipoRefePersoConstantesFunciones.SPERSISTENCENAME+" tiporefeperso";
	public static String QUERYSELECTNATIVE="select "+TipoRefePersoConstantesFunciones.SCHEMA+"."+TipoRefePersoConstantesFunciones.TABLENAME+".id,"+TipoRefePersoConstantesFunciones.SCHEMA+"."+TipoRefePersoConstantesFunciones.TABLENAME+".version_row,"+TipoRefePersoConstantesFunciones.SCHEMA+"."+TipoRefePersoConstantesFunciones.TABLENAME+".codigo,"+TipoRefePersoConstantesFunciones.SCHEMA+"."+TipoRefePersoConstantesFunciones.TABLENAME+".nombre from "+TipoRefePersoConstantesFunciones.SCHEMA+"."+TipoRefePersoConstantesFunciones.TABLENAME;//+" as "+TipoRefePersoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoRefePersoConstantesFuncionesAdditional tiporefepersoConstantesFuncionesAdditional=null;
	
	public TipoRefePersoConstantesFuncionesAdditional getTipoRefePersoConstantesFuncionesAdditional() {
		return this.tiporefepersoConstantesFuncionesAdditional;
	}
	
	public void setTipoRefePersoConstantesFuncionesAdditional(TipoRefePersoConstantesFuncionesAdditional tiporefepersoConstantesFuncionesAdditional) {
		try {
			this.tiporefepersoConstantesFuncionesAdditional=tiporefepersoConstantesFuncionesAdditional;
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
	
	public static String getTipoRefePersoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoRefePersoConstantesFunciones.CODIGO)) {sLabelColumna=TipoRefePersoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoRefePersoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoRefePersoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoRefePersoDescripcion(TipoRefePerso tiporefeperso) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiporefeperso !=null/* && tiporefeperso.getId()!=0*/) {
			sDescripcion=tiporefeperso.getcodigo();//tiporefepersotiporefeperso.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoRefePersoDescripcionDetallado(TipoRefePerso tiporefeperso) {
		String sDescripcion="";
			
		sDescripcion+=TipoRefePersoConstantesFunciones.ID+"=";
		sDescripcion+=tiporefeperso.getId().toString()+",";
		sDescripcion+=TipoRefePersoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiporefeperso.getVersionRow().toString()+",";
		sDescripcion+=TipoRefePersoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiporefeperso.getcodigo()+",";
		sDescripcion+=TipoRefePersoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiporefeperso.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoRefePersoDescripcion(TipoRefePerso tiporefeperso,String sValor) throws Exception {			
		if(tiporefeperso !=null) {
			tiporefeperso.setcodigo(sValor);;//tiporefepersotiporefeperso.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoRefePerso(TipoRefePerso tiporefeperso,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiporefeperso.setcodigo(tiporefeperso.getcodigo().trim());
		tiporefeperso.setnombre(tiporefeperso.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoRefePersos(List<TipoRefePerso> tiporefepersos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoRefePerso tiporefeperso: tiporefepersos) {
			tiporefeperso.setcodigo(tiporefeperso.getcodigo().trim());
			tiporefeperso.setnombre(tiporefeperso.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRefePerso(TipoRefePerso tiporefeperso,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiporefeperso.getConCambioAuxiliar()) {
			tiporefeperso.setIsDeleted(tiporefeperso.getIsDeletedAuxiliar());	
			tiporefeperso.setIsNew(tiporefeperso.getIsNewAuxiliar());	
			tiporefeperso.setIsChanged(tiporefeperso.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiporefeperso.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiporefeperso.setIsDeletedAuxiliar(false);	
			tiporefeperso.setIsNewAuxiliar(false);	
			tiporefeperso.setIsChangedAuxiliar(false);
			
			tiporefeperso.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRefePersos(List<TipoRefePerso> tiporefepersos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoRefePerso tiporefeperso : tiporefepersos) {
			if(conAsignarBase && tiporefeperso.getConCambioAuxiliar()) {
				tiporefeperso.setIsDeleted(tiporefeperso.getIsDeletedAuxiliar());	
				tiporefeperso.setIsNew(tiporefeperso.getIsNewAuxiliar());	
				tiporefeperso.setIsChanged(tiporefeperso.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiporefeperso.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiporefeperso.setIsDeletedAuxiliar(false);	
				tiporefeperso.setIsNewAuxiliar(false);	
				tiporefeperso.setIsChangedAuxiliar(false);
				
				tiporefeperso.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoRefePerso(TipoRefePerso tiporefeperso,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoRefePersos(List<TipoRefePerso> tiporefepersos,Boolean conEnteros) throws Exception  {
		
		for(TipoRefePerso tiporefeperso: tiporefepersos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoRefePerso(List<TipoRefePerso> tiporefepersos,TipoRefePerso tiporefepersoAux) throws Exception  {
		TipoRefePersoConstantesFunciones.InicializarValoresTipoRefePerso(tiporefepersoAux,true);
		
		for(TipoRefePerso tiporefeperso: tiporefepersos) {
			if(tiporefeperso.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRefePerso(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoRefePersoConstantesFunciones.getArrayColumnasGlobalesTipoRefePerso(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRefePerso(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoRefePerso(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoRefePerso> tiporefepersos,TipoRefePerso tiporefeperso,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoRefePerso tiporefepersoAux: tiporefepersos) {
			if(tiporefepersoAux!=null && tiporefeperso!=null) {
				if((tiporefepersoAux.getId()==null && tiporefeperso.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiporefepersoAux.getId()!=null && tiporefeperso.getId()!=null){
					if(tiporefepersoAux.getId().equals(tiporefeperso.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoRefePerso(List<TipoRefePerso> tiporefepersos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoRefePerso tiporefeperso: tiporefepersos) {			
			if(tiporefeperso.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoRefePerso() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoRefePersoConstantesFunciones.LABEL_ID, TipoRefePersoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRefePersoConstantesFunciones.LABEL_VERSIONROW, TipoRefePersoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRefePersoConstantesFunciones.LABEL_CODIGO, TipoRefePersoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRefePersoConstantesFunciones.LABEL_NOMBRE, TipoRefePersoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoRefePerso() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoRefePersoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRefePersoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRefePersoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRefePersoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRefePerso() throws Exception  {
		return TipoRefePersoConstantesFunciones.getTiposSeleccionarTipoRefePerso(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRefePerso(Boolean conFk) throws Exception  {
		return TipoRefePersoConstantesFunciones.getTiposSeleccionarTipoRefePerso(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRefePerso(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRefePersoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoRefePersoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRefePersoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoRefePersoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoRefePerso(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRefePerso(TipoRefePerso tiporefepersoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRefePerso(List<TipoRefePerso> tiporefepersosTemp) throws Exception {
		for(TipoRefePerso tiporefepersoAux:tiporefepersosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRefePerso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoRefePerso(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRefePerso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRefePersoConstantesFunciones.getClassesRelationshipsOfTipoRefePerso(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRefePerso(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ReferenciaPersonal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ReferenciaPersonal.class)) {
						classes.add(new Classe(ReferenciaPersonal.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRefePerso(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRefePersoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoRefePerso(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRefePerso(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ReferenciaPersonal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaPersonal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ReferenciaPersonal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaPersonal.class)); continue;
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
	public static void actualizarLista(TipoRefePerso tiporefeperso,List<TipoRefePerso> tiporefepersos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoRefePerso tiporefepersoEncontrado=null;
			
			for(TipoRefePerso tiporefepersoLocal:tiporefepersos) {
				if(tiporefepersoLocal.getId().equals(tiporefeperso.getId())) {
					tiporefepersoEncontrado=tiporefepersoLocal;
					
					tiporefepersoLocal.setIsChanged(tiporefeperso.getIsChanged());
					tiporefepersoLocal.setIsNew(tiporefeperso.getIsNew());
					tiporefepersoLocal.setIsDeleted(tiporefeperso.getIsDeleted());
					
					tiporefepersoLocal.setGeneralEntityOriginal(tiporefeperso.getGeneralEntityOriginal());
					
					tiporefepersoLocal.setId(tiporefeperso.getId());	
					tiporefepersoLocal.setVersionRow(tiporefeperso.getVersionRow());	
					tiporefepersoLocal.setcodigo(tiporefeperso.getcodigo());	
					tiporefepersoLocal.setnombre(tiporefeperso.getnombre());	
					
					
					tiporefepersoLocal.setReferenciaPersonals(tiporefeperso.getReferenciaPersonals());
					
					existe=true;
					break;
				}
			}
			
			if(!tiporefeperso.getIsDeleted()) {
				if(!existe) {
					tiporefepersos.add(tiporefeperso);
				}
			} else {
				if(tiporefepersoEncontrado!=null && permiteQuitar)  {
					tiporefepersos.remove(tiporefepersoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoRefePerso tiporefeperso,List<TipoRefePerso> tiporefepersos) throws Exception {
		try	{			
			for(TipoRefePerso tiporefepersoLocal:tiporefepersos) {
				if(tiporefepersoLocal.getId().equals(tiporefeperso.getId())) {
					tiporefepersoLocal.setIsSelected(tiporefeperso.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoRefePerso(List<TipoRefePerso> tiporefepersosAux) throws Exception {
		//this.tiporefepersosAux=tiporefepersosAux;
		
		for(TipoRefePerso tiporefepersoAux:tiporefepersosAux) {
			if(tiporefepersoAux.getIsChanged()) {
				tiporefepersoAux.setIsChanged(false);
			}		
			
			if(tiporefepersoAux.getIsNew()) {
				tiporefepersoAux.setIsNew(false);
			}	
			
			if(tiporefepersoAux.getIsDeleted()) {
				tiporefepersoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoRefePerso(TipoRefePerso tiporefepersoAux) throws Exception {
		//this.tiporefepersoAux=tiporefepersoAux;
		
			if(tiporefepersoAux.getIsChanged()) {
				tiporefepersoAux.setIsChanged(false);
			}		
			
			if(tiporefepersoAux.getIsNew()) {
				tiporefepersoAux.setIsNew(false);
			}	
			
			if(tiporefepersoAux.getIsDeleted()) {
				tiporefepersoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoRefePerso tiporefepersoAsignar,TipoRefePerso tiporefeperso) throws Exception {
		tiporefepersoAsignar.setId(tiporefeperso.getId());	
		tiporefepersoAsignar.setVersionRow(tiporefeperso.getVersionRow());	
		tiporefepersoAsignar.setcodigo(tiporefeperso.getcodigo());	
		tiporefepersoAsignar.setnombre(tiporefeperso.getnombre());	
	}
	
	public static void inicializarTipoRefePerso(TipoRefePerso tiporefeperso) throws Exception {
		try {
				tiporefeperso.setId(0L);	
					
				tiporefeperso.setcodigo("");	
				tiporefeperso.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoRefePerso(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRefePersoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRefePersoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoRefePerso(String sTipo,Row row,Workbook workbook,TipoRefePerso tiporefeperso,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporefeperso.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporefeperso.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoRefePerso=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoRefePerso() {
		return this.sFinalQueryTipoRefePerso;
	}
	
	public void setsFinalQueryTipoRefePerso(String sFinalQueryTipoRefePerso) {
		this.sFinalQueryTipoRefePerso= sFinalQueryTipoRefePerso;
	}
	
	public Border resaltarSeleccionarTipoRefePerso=null;
	
	public Border setResaltarSeleccionarTipoRefePerso(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRefePersoBeanSwingJInternalFrame tiporefepersoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiporefepersoBeanSwingJInternalFrame.jTtoolBarTipoRefePerso.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoRefePerso= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoRefePerso() {
		return this.resaltarSeleccionarTipoRefePerso;
	}
	
	public void setResaltarSeleccionarTipoRefePerso(Border borderResaltarSeleccionarTipoRefePerso) {
		this.resaltarSeleccionarTipoRefePerso= borderResaltarSeleccionarTipoRefePerso;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoRefePerso=null;
	public Boolean mostraridTipoRefePerso=true;
	public Boolean activaridTipoRefePerso=true;

	public Border resaltarcodigoTipoRefePerso=null;
	public Boolean mostrarcodigoTipoRefePerso=true;
	public Boolean activarcodigoTipoRefePerso=true;

	public Border resaltarnombreTipoRefePerso=null;
	public Boolean mostrarnombreTipoRefePerso=true;
	public Boolean activarnombreTipoRefePerso=true;

	
	

	public Border setResaltaridTipoRefePerso(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRefePersoBeanSwingJInternalFrame tiporefepersoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporefepersoBeanSwingJInternalFrame.jTtoolBarTipoRefePerso.setBorder(borderResaltar);
		
		this.resaltaridTipoRefePerso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoRefePerso() {
		return this.resaltaridTipoRefePerso;
	}

	public void setResaltaridTipoRefePerso(Border borderResaltar) {
		this.resaltaridTipoRefePerso= borderResaltar;
	}

	public Boolean getMostraridTipoRefePerso() {
		return this.mostraridTipoRefePerso;
	}

	public void setMostraridTipoRefePerso(Boolean mostraridTipoRefePerso) {
		this.mostraridTipoRefePerso= mostraridTipoRefePerso;
	}

	public Boolean getActivaridTipoRefePerso() {
		return this.activaridTipoRefePerso;
	}

	public void setActivaridTipoRefePerso(Boolean activaridTipoRefePerso) {
		this.activaridTipoRefePerso= activaridTipoRefePerso;
	}

	public Border setResaltarcodigoTipoRefePerso(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRefePersoBeanSwingJInternalFrame tiporefepersoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporefepersoBeanSwingJInternalFrame.jTtoolBarTipoRefePerso.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoRefePerso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoRefePerso() {
		return this.resaltarcodigoTipoRefePerso;
	}

	public void setResaltarcodigoTipoRefePerso(Border borderResaltar) {
		this.resaltarcodigoTipoRefePerso= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoRefePerso() {
		return this.mostrarcodigoTipoRefePerso;
	}

	public void setMostrarcodigoTipoRefePerso(Boolean mostrarcodigoTipoRefePerso) {
		this.mostrarcodigoTipoRefePerso= mostrarcodigoTipoRefePerso;
	}

	public Boolean getActivarcodigoTipoRefePerso() {
		return this.activarcodigoTipoRefePerso;
	}

	public void setActivarcodigoTipoRefePerso(Boolean activarcodigoTipoRefePerso) {
		this.activarcodigoTipoRefePerso= activarcodigoTipoRefePerso;
	}

	public Border setResaltarnombreTipoRefePerso(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRefePersoBeanSwingJInternalFrame tiporefepersoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporefepersoBeanSwingJInternalFrame.jTtoolBarTipoRefePerso.setBorder(borderResaltar);
		
		this.resaltarnombreTipoRefePerso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoRefePerso() {
		return this.resaltarnombreTipoRefePerso;
	}

	public void setResaltarnombreTipoRefePerso(Border borderResaltar) {
		this.resaltarnombreTipoRefePerso= borderResaltar;
	}

	public Boolean getMostrarnombreTipoRefePerso() {
		return this.mostrarnombreTipoRefePerso;
	}

	public void setMostrarnombreTipoRefePerso(Boolean mostrarnombreTipoRefePerso) {
		this.mostrarnombreTipoRefePerso= mostrarnombreTipoRefePerso;
	}

	public Boolean getActivarnombreTipoRefePerso() {
		return this.activarnombreTipoRefePerso;
	}

	public void setActivarnombreTipoRefePerso(Boolean activarnombreTipoRefePerso) {
		this.activarnombreTipoRefePerso= activarnombreTipoRefePerso;
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
		
		
		this.setMostraridTipoRefePerso(esInicial);
		this.setMostrarcodigoTipoRefePerso(esInicial);
		this.setMostrarnombreTipoRefePerso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRefePersoConstantesFunciones.ID)) {
				this.setMostraridTipoRefePerso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRefePersoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoRefePerso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRefePersoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoRefePerso(esAsigna);
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
		
		
		this.setActivaridTipoRefePerso(esInicial);
		this.setActivarcodigoTipoRefePerso(esInicial);
		this.setActivarnombreTipoRefePerso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRefePersoConstantesFunciones.ID)) {
				this.setActivaridTipoRefePerso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRefePersoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoRefePerso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRefePersoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoRefePerso(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRefePersoBeanSwingJInternalFrame tiporefepersoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoRefePerso(esInicial);
		this.setResaltarcodigoTipoRefePerso(esInicial);
		this.setResaltarnombreTipoRefePerso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRefePersoConstantesFunciones.ID)) {
				this.setResaltaridTipoRefePerso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRefePersoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoRefePerso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRefePersoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoRefePerso(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarReferenciaPersonalTipoRefePerso=null;

	public Border getResaltarReferenciaPersonalTipoRefePerso() {
		return this.resaltarReferenciaPersonalTipoRefePerso;
	}

	public void setResaltarReferenciaPersonalTipoRefePerso(Border borderResaltarReferenciaPersonal) {
		if(borderResaltarReferenciaPersonal!=null) {
			this.resaltarReferenciaPersonalTipoRefePerso= borderResaltarReferenciaPersonal;
		}
	}

	public Border setResaltarReferenciaPersonalTipoRefePerso(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRefePersoBeanSwingJInternalFrame tiporefepersoBeanSwingJInternalFrame*/) {
		Border borderResaltarReferenciaPersonal=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiporefepersoBeanSwingJInternalFrame.jTtoolBarTipoRefePerso.setBorder(borderResaltarReferenciaPersonal);
			
		this.resaltarReferenciaPersonalTipoRefePerso= borderResaltarReferenciaPersonal;

		 return borderResaltarReferenciaPersonal;
	}



	public Boolean mostrarReferenciaPersonalTipoRefePerso=true;

	public Boolean getMostrarReferenciaPersonalTipoRefePerso() {
		return this.mostrarReferenciaPersonalTipoRefePerso;
	}

	public void setMostrarReferenciaPersonalTipoRefePerso(Boolean visibilidadResaltarReferenciaPersonal) {
		this.mostrarReferenciaPersonalTipoRefePerso= visibilidadResaltarReferenciaPersonal;
	}



	public Boolean activarReferenciaPersonalTipoRefePerso=true;

	public Boolean gethabilitarResaltarReferenciaPersonalTipoRefePerso() {
		return this.activarReferenciaPersonalTipoRefePerso;
	}

	public void setActivarReferenciaPersonalTipoRefePerso(Boolean habilitarResaltarReferenciaPersonal) {
		this.activarReferenciaPersonalTipoRefePerso= habilitarResaltarReferenciaPersonal;
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

		this.setMostrarReferenciaPersonalTipoRefePerso(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ReferenciaPersonal.class)) {
				this.setMostrarReferenciaPersonalTipoRefePerso(esAsigna);
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

		this.setActivarReferenciaPersonalTipoRefePerso(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ReferenciaPersonal.class)) {
				this.setActivarReferenciaPersonalTipoRefePerso(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRefePersoBeanSwingJInternalFrame tiporefepersoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarReferenciaPersonalTipoRefePerso(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ReferenciaPersonal.class)) {
				this.setResaltarReferenciaPersonalTipoRefePerso(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTipoRefePerso=true;

	public Boolean getMostrarBusquedaPorCodigoTipoRefePerso() {
		return this.mostrarBusquedaPorCodigoTipoRefePerso;
	}

	public void setMostrarBusquedaPorCodigoTipoRefePerso(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoRefePerso= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoRefePerso=true;

	public Boolean getMostrarBusquedaPorNombreTipoRefePerso() {
		return this.mostrarBusquedaPorNombreTipoRefePerso;
	}

	public void setMostrarBusquedaPorNombreTipoRefePerso(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoRefePerso= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoRefePerso=true;

	public Boolean getActivarBusquedaPorCodigoTipoRefePerso() {
		return this.activarBusquedaPorCodigoTipoRefePerso;
	}

	public void setActivarBusquedaPorCodigoTipoRefePerso(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoRefePerso= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoRefePerso=true;

	public Boolean getActivarBusquedaPorNombreTipoRefePerso() {
		return this.activarBusquedaPorNombreTipoRefePerso;
	}

	public void setActivarBusquedaPorNombreTipoRefePerso(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoRefePerso= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoRefePerso=null;

	public Border getResaltarBusquedaPorCodigoTipoRefePerso() {
		return this.resaltarBusquedaPorCodigoTipoRefePerso;
	}

	public void setResaltarBusquedaPorCodigoTipoRefePerso(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoRefePerso= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoRefePerso(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRefePersoBeanSwingJInternalFrame tiporefepersoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoRefePerso= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoRefePerso=null;

	public Border getResaltarBusquedaPorNombreTipoRefePerso() {
		return this.resaltarBusquedaPorNombreTipoRefePerso;
	}

	public void setResaltarBusquedaPorNombreTipoRefePerso(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoRefePerso= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoRefePerso(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRefePersoBeanSwingJInternalFrame tiporefepersoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoRefePerso= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}