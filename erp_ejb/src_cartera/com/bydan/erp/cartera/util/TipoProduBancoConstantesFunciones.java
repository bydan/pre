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


import com.bydan.erp.cartera.util.TipoProduBancoConstantesFunciones;
import com.bydan.erp.cartera.util.TipoProduBancoParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoProduBancoParameterGeneral;

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
final public class TipoProduBancoConstantesFunciones extends TipoProduBancoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoProduBanco";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoProduBanco"+TipoProduBancoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoProduBancoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoProduBancoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoProduBancoConstantesFunciones.SCHEMA+"_"+TipoProduBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoProduBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoProduBancoConstantesFunciones.SCHEMA+"_"+TipoProduBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoProduBancoConstantesFunciones.SCHEMA+"_"+TipoProduBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoProduBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoProduBancoConstantesFunciones.SCHEMA+"_"+TipoProduBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProduBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProduBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProduBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProduBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProduBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProduBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoProduBancoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoProduBancoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoProduBancoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoProduBancoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Produ Bancos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Produ Banco";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Produ Banco";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoProduBanco";
	public static final String OBJECTNAME="tipoprodubanco";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_produ_banco";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoprodubanco from "+TipoProduBancoConstantesFunciones.SPERSISTENCENAME+" tipoprodubanco";
	public static String QUERYSELECTNATIVE="select "+TipoProduBancoConstantesFunciones.SCHEMA+"."+TipoProduBancoConstantesFunciones.TABLENAME+".id,"+TipoProduBancoConstantesFunciones.SCHEMA+"."+TipoProduBancoConstantesFunciones.TABLENAME+".version_row,"+TipoProduBancoConstantesFunciones.SCHEMA+"."+TipoProduBancoConstantesFunciones.TABLENAME+".codigo,"+TipoProduBancoConstantesFunciones.SCHEMA+"."+TipoProduBancoConstantesFunciones.TABLENAME+".nombre from "+TipoProduBancoConstantesFunciones.SCHEMA+"."+TipoProduBancoConstantesFunciones.TABLENAME;//+" as "+TipoProduBancoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoProduBancoConstantesFuncionesAdditional tipoprodubancoConstantesFuncionesAdditional=null;
	
	public TipoProduBancoConstantesFuncionesAdditional getTipoProduBancoConstantesFuncionesAdditional() {
		return this.tipoprodubancoConstantesFuncionesAdditional;
	}
	
	public void setTipoProduBancoConstantesFuncionesAdditional(TipoProduBancoConstantesFuncionesAdditional tipoprodubancoConstantesFuncionesAdditional) {
		try {
			this.tipoprodubancoConstantesFuncionesAdditional=tipoprodubancoConstantesFuncionesAdditional;
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
	
	public static String getTipoProduBancoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoProduBancoConstantesFunciones.CODIGO)) {sLabelColumna=TipoProduBancoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoProduBancoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoProduBancoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoProduBancoDescripcion(TipoProduBanco tipoprodubanco) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoprodubanco !=null/* && tipoprodubanco.getId()!=0*/) {
			sDescripcion=tipoprodubanco.getcodigo();//tipoprodubancotipoprodubanco.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoProduBancoDescripcionDetallado(TipoProduBanco tipoprodubanco) {
		String sDescripcion="";
			
		sDescripcion+=TipoProduBancoConstantesFunciones.ID+"=";
		sDescripcion+=tipoprodubanco.getId().toString()+",";
		sDescripcion+=TipoProduBancoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoprodubanco.getVersionRow().toString()+",";
		sDescripcion+=TipoProduBancoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoprodubanco.getcodigo()+",";
		sDescripcion+=TipoProduBancoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoprodubanco.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoProduBancoDescripcion(TipoProduBanco tipoprodubanco,String sValor) throws Exception {			
		if(tipoprodubanco !=null) {
			tipoprodubanco.setcodigo(sValor);;//tipoprodubancotipoprodubanco.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoProduBanco(TipoProduBanco tipoprodubanco,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoprodubanco.setcodigo(tipoprodubanco.getcodigo().trim());
		tipoprodubanco.setnombre(tipoprodubanco.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoProduBancos(List<TipoProduBanco> tipoprodubancos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoProduBanco tipoprodubanco: tipoprodubancos) {
			tipoprodubanco.setcodigo(tipoprodubanco.getcodigo().trim());
			tipoprodubanco.setnombre(tipoprodubanco.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProduBanco(TipoProduBanco tipoprodubanco,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoprodubanco.getConCambioAuxiliar()) {
			tipoprodubanco.setIsDeleted(tipoprodubanco.getIsDeletedAuxiliar());	
			tipoprodubanco.setIsNew(tipoprodubanco.getIsNewAuxiliar());	
			tipoprodubanco.setIsChanged(tipoprodubanco.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoprodubanco.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoprodubanco.setIsDeletedAuxiliar(false);	
			tipoprodubanco.setIsNewAuxiliar(false);	
			tipoprodubanco.setIsChangedAuxiliar(false);
			
			tipoprodubanco.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProduBancos(List<TipoProduBanco> tipoprodubancos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoProduBanco tipoprodubanco : tipoprodubancos) {
			if(conAsignarBase && tipoprodubanco.getConCambioAuxiliar()) {
				tipoprodubanco.setIsDeleted(tipoprodubanco.getIsDeletedAuxiliar());	
				tipoprodubanco.setIsNew(tipoprodubanco.getIsNewAuxiliar());	
				tipoprodubanco.setIsChanged(tipoprodubanco.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoprodubanco.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoprodubanco.setIsDeletedAuxiliar(false);	
				tipoprodubanco.setIsNewAuxiliar(false);	
				tipoprodubanco.setIsChangedAuxiliar(false);
				
				tipoprodubanco.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoProduBanco(TipoProduBanco tipoprodubanco,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoProduBancos(List<TipoProduBanco> tipoprodubancos,Boolean conEnteros) throws Exception  {
		
		for(TipoProduBanco tipoprodubanco: tipoprodubancos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoProduBanco(List<TipoProduBanco> tipoprodubancos,TipoProduBanco tipoprodubancoAux) throws Exception  {
		TipoProduBancoConstantesFunciones.InicializarValoresTipoProduBanco(tipoprodubancoAux,true);
		
		for(TipoProduBanco tipoprodubanco: tipoprodubancos) {
			if(tipoprodubanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProduBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoProduBancoConstantesFunciones.getArrayColumnasGlobalesTipoProduBanco(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProduBanco(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoProduBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoProduBanco> tipoprodubancos,TipoProduBanco tipoprodubanco,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoProduBanco tipoprodubancoAux: tipoprodubancos) {
			if(tipoprodubancoAux!=null && tipoprodubanco!=null) {
				if((tipoprodubancoAux.getId()==null && tipoprodubanco.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoprodubancoAux.getId()!=null && tipoprodubanco.getId()!=null){
					if(tipoprodubancoAux.getId().equals(tipoprodubanco.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoProduBanco(List<TipoProduBanco> tipoprodubancos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoProduBanco tipoprodubanco: tipoprodubancos) {			
			if(tipoprodubanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoProduBanco() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoProduBancoConstantesFunciones.LABEL_ID, TipoProduBancoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProduBancoConstantesFunciones.LABEL_VERSIONROW, TipoProduBancoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProduBancoConstantesFunciones.LABEL_CODIGO, TipoProduBancoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProduBancoConstantesFunciones.LABEL_NOMBRE, TipoProduBancoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoProduBanco() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoProduBancoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProduBancoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProduBancoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProduBancoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProduBanco() throws Exception  {
		return TipoProduBancoConstantesFunciones.getTiposSeleccionarTipoProduBanco(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProduBanco(Boolean conFk) throws Exception  {
		return TipoProduBancoConstantesFunciones.getTiposSeleccionarTipoProduBanco(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProduBanco(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProduBancoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoProduBancoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProduBancoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoProduBancoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoProduBanco(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProduBanco(TipoProduBanco tipoprodubancoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProduBanco(List<TipoProduBanco> tipoprodubancosTemp) throws Exception {
		for(TipoProduBanco tipoprodubancoAux:tipoprodubancosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProduBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoProduBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProduBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProduBancoConstantesFunciones.getClassesRelationshipsOfTipoProduBanco(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProduBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ReferenciaBancaria.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ReferenciaBancaria.class)) {
						classes.add(new Classe(ReferenciaBancaria.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProduBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProduBancoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoProduBanco(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProduBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ReferenciaBancaria.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaBancaria.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ReferenciaBancaria.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaBancaria.class)); continue;
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
	public static void actualizarLista(TipoProduBanco tipoprodubanco,List<TipoProduBanco> tipoprodubancos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoProduBanco tipoprodubancoEncontrado=null;
			
			for(TipoProduBanco tipoprodubancoLocal:tipoprodubancos) {
				if(tipoprodubancoLocal.getId().equals(tipoprodubanco.getId())) {
					tipoprodubancoEncontrado=tipoprodubancoLocal;
					
					tipoprodubancoLocal.setIsChanged(tipoprodubanco.getIsChanged());
					tipoprodubancoLocal.setIsNew(tipoprodubanco.getIsNew());
					tipoprodubancoLocal.setIsDeleted(tipoprodubanco.getIsDeleted());
					
					tipoprodubancoLocal.setGeneralEntityOriginal(tipoprodubanco.getGeneralEntityOriginal());
					
					tipoprodubancoLocal.setId(tipoprodubanco.getId());	
					tipoprodubancoLocal.setVersionRow(tipoprodubanco.getVersionRow());	
					tipoprodubancoLocal.setcodigo(tipoprodubanco.getcodigo());	
					tipoprodubancoLocal.setnombre(tipoprodubanco.getnombre());	
					
					
					tipoprodubancoLocal.setReferenciaBancarias(tipoprodubanco.getReferenciaBancarias());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoprodubanco.getIsDeleted()) {
				if(!existe) {
					tipoprodubancos.add(tipoprodubanco);
				}
			} else {
				if(tipoprodubancoEncontrado!=null && permiteQuitar)  {
					tipoprodubancos.remove(tipoprodubancoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoProduBanco tipoprodubanco,List<TipoProduBanco> tipoprodubancos) throws Exception {
		try	{			
			for(TipoProduBanco tipoprodubancoLocal:tipoprodubancos) {
				if(tipoprodubancoLocal.getId().equals(tipoprodubanco.getId())) {
					tipoprodubancoLocal.setIsSelected(tipoprodubanco.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoProduBanco(List<TipoProduBanco> tipoprodubancosAux) throws Exception {
		//this.tipoprodubancosAux=tipoprodubancosAux;
		
		for(TipoProduBanco tipoprodubancoAux:tipoprodubancosAux) {
			if(tipoprodubancoAux.getIsChanged()) {
				tipoprodubancoAux.setIsChanged(false);
			}		
			
			if(tipoprodubancoAux.getIsNew()) {
				tipoprodubancoAux.setIsNew(false);
			}	
			
			if(tipoprodubancoAux.getIsDeleted()) {
				tipoprodubancoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoProduBanco(TipoProduBanco tipoprodubancoAux) throws Exception {
		//this.tipoprodubancoAux=tipoprodubancoAux;
		
			if(tipoprodubancoAux.getIsChanged()) {
				tipoprodubancoAux.setIsChanged(false);
			}		
			
			if(tipoprodubancoAux.getIsNew()) {
				tipoprodubancoAux.setIsNew(false);
			}	
			
			if(tipoprodubancoAux.getIsDeleted()) {
				tipoprodubancoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoProduBanco tipoprodubancoAsignar,TipoProduBanco tipoprodubanco) throws Exception {
		tipoprodubancoAsignar.setId(tipoprodubanco.getId());	
		tipoprodubancoAsignar.setVersionRow(tipoprodubanco.getVersionRow());	
		tipoprodubancoAsignar.setcodigo(tipoprodubanco.getcodigo());	
		tipoprodubancoAsignar.setnombre(tipoprodubanco.getnombre());	
	}
	
	public static void inicializarTipoProduBanco(TipoProduBanco tipoprodubanco) throws Exception {
		try {
				tipoprodubanco.setId(0L);	
					
				tipoprodubanco.setcodigo("");	
				tipoprodubanco.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoProduBanco(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProduBancoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProduBancoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoProduBanco(String sTipo,Row row,Workbook workbook,TipoProduBanco tipoprodubanco,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprodubanco.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprodubanco.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoProduBanco=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoProduBanco() {
		return this.sFinalQueryTipoProduBanco;
	}
	
	public void setsFinalQueryTipoProduBanco(String sFinalQueryTipoProduBanco) {
		this.sFinalQueryTipoProduBanco= sFinalQueryTipoProduBanco;
	}
	
	public Border resaltarSeleccionarTipoProduBanco=null;
	
	public Border setResaltarSeleccionarTipoProduBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProduBancoBeanSwingJInternalFrame tipoprodubancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoprodubancoBeanSwingJInternalFrame.jTtoolBarTipoProduBanco.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoProduBanco= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoProduBanco() {
		return this.resaltarSeleccionarTipoProduBanco;
	}
	
	public void setResaltarSeleccionarTipoProduBanco(Border borderResaltarSeleccionarTipoProduBanco) {
		this.resaltarSeleccionarTipoProduBanco= borderResaltarSeleccionarTipoProduBanco;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoProduBanco=null;
	public Boolean mostraridTipoProduBanco=true;
	public Boolean activaridTipoProduBanco=true;

	public Border resaltarcodigoTipoProduBanco=null;
	public Boolean mostrarcodigoTipoProduBanco=true;
	public Boolean activarcodigoTipoProduBanco=true;

	public Border resaltarnombreTipoProduBanco=null;
	public Boolean mostrarnombreTipoProduBanco=true;
	public Boolean activarnombreTipoProduBanco=true;

	
	

	public Border setResaltaridTipoProduBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProduBancoBeanSwingJInternalFrame tipoprodubancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprodubancoBeanSwingJInternalFrame.jTtoolBarTipoProduBanco.setBorder(borderResaltar);
		
		this.resaltaridTipoProduBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoProduBanco() {
		return this.resaltaridTipoProduBanco;
	}

	public void setResaltaridTipoProduBanco(Border borderResaltar) {
		this.resaltaridTipoProduBanco= borderResaltar;
	}

	public Boolean getMostraridTipoProduBanco() {
		return this.mostraridTipoProduBanco;
	}

	public void setMostraridTipoProduBanco(Boolean mostraridTipoProduBanco) {
		this.mostraridTipoProduBanco= mostraridTipoProduBanco;
	}

	public Boolean getActivaridTipoProduBanco() {
		return this.activaridTipoProduBanco;
	}

	public void setActivaridTipoProduBanco(Boolean activaridTipoProduBanco) {
		this.activaridTipoProduBanco= activaridTipoProduBanco;
	}

	public Border setResaltarcodigoTipoProduBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProduBancoBeanSwingJInternalFrame tipoprodubancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprodubancoBeanSwingJInternalFrame.jTtoolBarTipoProduBanco.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoProduBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoProduBanco() {
		return this.resaltarcodigoTipoProduBanco;
	}

	public void setResaltarcodigoTipoProduBanco(Border borderResaltar) {
		this.resaltarcodigoTipoProduBanco= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoProduBanco() {
		return this.mostrarcodigoTipoProduBanco;
	}

	public void setMostrarcodigoTipoProduBanco(Boolean mostrarcodigoTipoProduBanco) {
		this.mostrarcodigoTipoProduBanco= mostrarcodigoTipoProduBanco;
	}

	public Boolean getActivarcodigoTipoProduBanco() {
		return this.activarcodigoTipoProduBanco;
	}

	public void setActivarcodigoTipoProduBanco(Boolean activarcodigoTipoProduBanco) {
		this.activarcodigoTipoProduBanco= activarcodigoTipoProduBanco;
	}

	public Border setResaltarnombreTipoProduBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProduBancoBeanSwingJInternalFrame tipoprodubancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprodubancoBeanSwingJInternalFrame.jTtoolBarTipoProduBanco.setBorder(borderResaltar);
		
		this.resaltarnombreTipoProduBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoProduBanco() {
		return this.resaltarnombreTipoProduBanco;
	}

	public void setResaltarnombreTipoProduBanco(Border borderResaltar) {
		this.resaltarnombreTipoProduBanco= borderResaltar;
	}

	public Boolean getMostrarnombreTipoProduBanco() {
		return this.mostrarnombreTipoProduBanco;
	}

	public void setMostrarnombreTipoProduBanco(Boolean mostrarnombreTipoProduBanco) {
		this.mostrarnombreTipoProduBanco= mostrarnombreTipoProduBanco;
	}

	public Boolean getActivarnombreTipoProduBanco() {
		return this.activarnombreTipoProduBanco;
	}

	public void setActivarnombreTipoProduBanco(Boolean activarnombreTipoProduBanco) {
		this.activarnombreTipoProduBanco= activarnombreTipoProduBanco;
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
		
		
		this.setMostraridTipoProduBanco(esInicial);
		this.setMostrarcodigoTipoProduBanco(esInicial);
		this.setMostrarnombreTipoProduBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProduBancoConstantesFunciones.ID)) {
				this.setMostraridTipoProduBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProduBancoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoProduBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProduBancoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoProduBanco(esAsigna);
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
		
		
		this.setActivaridTipoProduBanco(esInicial);
		this.setActivarcodigoTipoProduBanco(esInicial);
		this.setActivarnombreTipoProduBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProduBancoConstantesFunciones.ID)) {
				this.setActivaridTipoProduBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProduBancoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoProduBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProduBancoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoProduBanco(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProduBancoBeanSwingJInternalFrame tipoprodubancoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoProduBanco(esInicial);
		this.setResaltarcodigoTipoProduBanco(esInicial);
		this.setResaltarnombreTipoProduBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProduBancoConstantesFunciones.ID)) {
				this.setResaltaridTipoProduBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProduBancoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoProduBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProduBancoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoProduBanco(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarReferenciaBancariaTipoProduBanco=null;

	public Border getResaltarReferenciaBancariaTipoProduBanco() {
		return this.resaltarReferenciaBancariaTipoProduBanco;
	}

	public void setResaltarReferenciaBancariaTipoProduBanco(Border borderResaltarReferenciaBancaria) {
		if(borderResaltarReferenciaBancaria!=null) {
			this.resaltarReferenciaBancariaTipoProduBanco= borderResaltarReferenciaBancaria;
		}
	}

	public Border setResaltarReferenciaBancariaTipoProduBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProduBancoBeanSwingJInternalFrame tipoprodubancoBeanSwingJInternalFrame*/) {
		Border borderResaltarReferenciaBancaria=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprodubancoBeanSwingJInternalFrame.jTtoolBarTipoProduBanco.setBorder(borderResaltarReferenciaBancaria);
			
		this.resaltarReferenciaBancariaTipoProduBanco= borderResaltarReferenciaBancaria;

		 return borderResaltarReferenciaBancaria;
	}



	public Boolean mostrarReferenciaBancariaTipoProduBanco=true;

	public Boolean getMostrarReferenciaBancariaTipoProduBanco() {
		return this.mostrarReferenciaBancariaTipoProduBanco;
	}

	public void setMostrarReferenciaBancariaTipoProduBanco(Boolean visibilidadResaltarReferenciaBancaria) {
		this.mostrarReferenciaBancariaTipoProduBanco= visibilidadResaltarReferenciaBancaria;
	}



	public Boolean activarReferenciaBancariaTipoProduBanco=true;

	public Boolean gethabilitarResaltarReferenciaBancariaTipoProduBanco() {
		return this.activarReferenciaBancariaTipoProduBanco;
	}

	public void setActivarReferenciaBancariaTipoProduBanco(Boolean habilitarResaltarReferenciaBancaria) {
		this.activarReferenciaBancariaTipoProduBanco= habilitarResaltarReferenciaBancaria;
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

		this.setMostrarReferenciaBancariaTipoProduBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ReferenciaBancaria.class)) {
				this.setMostrarReferenciaBancariaTipoProduBanco(esAsigna);
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

		this.setActivarReferenciaBancariaTipoProduBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ReferenciaBancaria.class)) {
				this.setActivarReferenciaBancariaTipoProduBanco(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProduBancoBeanSwingJInternalFrame tipoprodubancoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarReferenciaBancariaTipoProduBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ReferenciaBancaria.class)) {
				this.setResaltarReferenciaBancariaTipoProduBanco(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}