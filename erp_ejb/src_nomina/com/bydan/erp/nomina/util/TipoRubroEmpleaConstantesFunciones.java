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


import com.bydan.erp.nomina.util.TipoRubroEmpleaConstantesFunciones;
import com.bydan.erp.nomina.util.TipoRubroEmpleaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoRubroEmpleaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoRubroEmpleaConstantesFunciones extends TipoRubroEmpleaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoRubroEmplea";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoRubroEmplea"+TipoRubroEmpleaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoRubroEmpleaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoRubroEmpleaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoRubroEmpleaConstantesFunciones.SCHEMA+"_"+TipoRubroEmpleaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoRubroEmpleaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoRubroEmpleaConstantesFunciones.SCHEMA+"_"+TipoRubroEmpleaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoRubroEmpleaConstantesFunciones.SCHEMA+"_"+TipoRubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoRubroEmpleaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoRubroEmpleaConstantesFunciones.SCHEMA+"_"+TipoRubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRubroEmpleaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRubroEmpleaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoRubroEmpleaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoRubroEmpleaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoRubroEmpleaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoRubroEmpleaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Rubros";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Rubro";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Rubro Emplea";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoRubroEmplea";
	public static final String OBJECTNAME="tiporubroemplea";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_rubro_emplea";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiporubroemplea from "+TipoRubroEmpleaConstantesFunciones.SPERSISTENCENAME+" tiporubroemplea";
	public static String QUERYSELECTNATIVE="select "+TipoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoRubroEmpleaConstantesFunciones.TABLENAME+".id,"+TipoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoRubroEmpleaConstantesFunciones.TABLENAME+".version_row,"+TipoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoRubroEmpleaConstantesFunciones.TABLENAME+".codigo,"+TipoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoRubroEmpleaConstantesFunciones.TABLENAME+".nombre from "+TipoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoRubroEmpleaConstantesFunciones.TABLENAME;//+" as "+TipoRubroEmpleaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoRubroEmpleaConstantesFuncionesAdditional tiporubroempleaConstantesFuncionesAdditional=null;
	
	public TipoRubroEmpleaConstantesFuncionesAdditional getTipoRubroEmpleaConstantesFuncionesAdditional() {
		return this.tiporubroempleaConstantesFuncionesAdditional;
	}
	
	public void setTipoRubroEmpleaConstantesFuncionesAdditional(TipoRubroEmpleaConstantesFuncionesAdditional tiporubroempleaConstantesFuncionesAdditional) {
		try {
			this.tiporubroempleaConstantesFuncionesAdditional=tiporubroempleaConstantesFuncionesAdditional;
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
	
	public static String getTipoRubroEmpleaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoRubroEmpleaConstantesFunciones.CODIGO)) {sLabelColumna=TipoRubroEmpleaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoRubroEmpleaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoRubroEmpleaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoRubroEmpleaDescripcion(TipoRubroEmplea tiporubroemplea) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiporubroemplea !=null/* && tiporubroemplea.getId()!=0*/) {
			sDescripcion=tiporubroemplea.getcodigo()+"-"+tiporubroemplea.getnombre();//tiporubroempleatiporubroemplea.getcodigo().trim()+"-"+tiporubroemplea.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoRubroEmpleaDescripcionDetallado(TipoRubroEmplea tiporubroemplea) {
		String sDescripcion="";
			
		sDescripcion+=TipoRubroEmpleaConstantesFunciones.ID+"=";
		sDescripcion+=tiporubroemplea.getId().toString()+",";
		sDescripcion+=TipoRubroEmpleaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiporubroemplea.getVersionRow().toString()+",";
		sDescripcion+=TipoRubroEmpleaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiporubroemplea.getcodigo()+",";
		sDescripcion+=TipoRubroEmpleaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiporubroemplea.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoRubroEmpleaDescripcion(TipoRubroEmplea tiporubroemplea,String sValor) throws Exception {			
		if(tiporubroemplea !=null) {
			tiporubroemplea.setcodigo(sValor);
tiporubroemplea.setnombre(sValor);;//tiporubroempleatiporubroemplea.getcodigo().trim()+"-"+tiporubroemplea.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoRubroEmplea(TipoRubroEmplea tiporubroemplea,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiporubroemplea.setcodigo(tiporubroemplea.getcodigo().trim());
		tiporubroemplea.setnombre(tiporubroemplea.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoRubroEmpleas(List<TipoRubroEmplea> tiporubroempleas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoRubroEmplea tiporubroemplea: tiporubroempleas) {
			tiporubroemplea.setcodigo(tiporubroemplea.getcodigo().trim());
			tiporubroemplea.setnombre(tiporubroemplea.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRubroEmplea(TipoRubroEmplea tiporubroemplea,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiporubroemplea.getConCambioAuxiliar()) {
			tiporubroemplea.setIsDeleted(tiporubroemplea.getIsDeletedAuxiliar());	
			tiporubroemplea.setIsNew(tiporubroemplea.getIsNewAuxiliar());	
			tiporubroemplea.setIsChanged(tiporubroemplea.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiporubroemplea.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiporubroemplea.setIsDeletedAuxiliar(false);	
			tiporubroemplea.setIsNewAuxiliar(false);	
			tiporubroemplea.setIsChangedAuxiliar(false);
			
			tiporubroemplea.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRubroEmpleas(List<TipoRubroEmplea> tiporubroempleas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoRubroEmplea tiporubroemplea : tiporubroempleas) {
			if(conAsignarBase && tiporubroemplea.getConCambioAuxiliar()) {
				tiporubroemplea.setIsDeleted(tiporubroemplea.getIsDeletedAuxiliar());	
				tiporubroemplea.setIsNew(tiporubroemplea.getIsNewAuxiliar());	
				tiporubroemplea.setIsChanged(tiporubroemplea.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiporubroemplea.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiporubroemplea.setIsDeletedAuxiliar(false);	
				tiporubroemplea.setIsNewAuxiliar(false);	
				tiporubroemplea.setIsChangedAuxiliar(false);
				
				tiporubroemplea.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoRubroEmplea(TipoRubroEmplea tiporubroemplea,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoRubroEmpleas(List<TipoRubroEmplea> tiporubroempleas,Boolean conEnteros) throws Exception  {
		
		for(TipoRubroEmplea tiporubroemplea: tiporubroempleas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoRubroEmplea(List<TipoRubroEmplea> tiporubroempleas,TipoRubroEmplea tiporubroempleaAux) throws Exception  {
		TipoRubroEmpleaConstantesFunciones.InicializarValoresTipoRubroEmplea(tiporubroempleaAux,true);
		
		for(TipoRubroEmplea tiporubroemplea: tiporubroempleas) {
			if(tiporubroemplea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRubroEmplea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoRubroEmpleaConstantesFunciones.getArrayColumnasGlobalesTipoRubroEmplea(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRubroEmplea(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoRubroEmplea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoRubroEmplea> tiporubroempleas,TipoRubroEmplea tiporubroemplea,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoRubroEmplea tiporubroempleaAux: tiporubroempleas) {
			if(tiporubroempleaAux!=null && tiporubroemplea!=null) {
				if((tiporubroempleaAux.getId()==null && tiporubroemplea.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiporubroempleaAux.getId()!=null && tiporubroemplea.getId()!=null){
					if(tiporubroempleaAux.getId().equals(tiporubroemplea.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoRubroEmplea(List<TipoRubroEmplea> tiporubroempleas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoRubroEmplea tiporubroemplea: tiporubroempleas) {			
			if(tiporubroemplea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoRubroEmplea() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoRubroEmpleaConstantesFunciones.LABEL_ID, TipoRubroEmpleaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRubroEmpleaConstantesFunciones.LABEL_VERSIONROW, TipoRubroEmpleaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRubroEmpleaConstantesFunciones.LABEL_CODIGO, TipoRubroEmpleaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRubroEmpleaConstantesFunciones.LABEL_NOMBRE, TipoRubroEmpleaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoRubroEmplea() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoRubroEmpleaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRubroEmpleaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRubroEmpleaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRubroEmpleaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRubroEmplea() throws Exception  {
		return TipoRubroEmpleaConstantesFunciones.getTiposSeleccionarTipoRubroEmplea(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRubroEmplea(Boolean conFk) throws Exception  {
		return TipoRubroEmpleaConstantesFunciones.getTiposSeleccionarTipoRubroEmplea(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRubroEmplea(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRubroEmpleaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoRubroEmpleaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRubroEmpleaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoRubroEmpleaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoRubroEmplea(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRubroEmplea(TipoRubroEmplea tiporubroempleaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRubroEmplea(List<TipoRubroEmplea> tiporubroempleasTemp) throws Exception {
		for(TipoRubroEmplea tiporubroempleaAux:tiporubroempleasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRubroEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoRubroEmplea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRubroEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRubroEmpleaConstantesFunciones.getClassesRelationshipsOfTipoRubroEmplea(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRubroEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(RubroEmplea.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(RubroEmplea.class)) {
						classes.add(new Classe(RubroEmplea.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRubroEmplea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRubroEmpleaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoRubroEmplea(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRubroEmplea(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
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
	public static void actualizarLista(TipoRubroEmplea tiporubroemplea,List<TipoRubroEmplea> tiporubroempleas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoRubroEmplea tiporubroempleaEncontrado=null;
			
			for(TipoRubroEmplea tiporubroempleaLocal:tiporubroempleas) {
				if(tiporubroempleaLocal.getId().equals(tiporubroemplea.getId())) {
					tiporubroempleaEncontrado=tiporubroempleaLocal;
					
					tiporubroempleaLocal.setIsChanged(tiporubroemplea.getIsChanged());
					tiporubroempleaLocal.setIsNew(tiporubroemplea.getIsNew());
					tiporubroempleaLocal.setIsDeleted(tiporubroemplea.getIsDeleted());
					
					tiporubroempleaLocal.setGeneralEntityOriginal(tiporubroemplea.getGeneralEntityOriginal());
					
					tiporubroempleaLocal.setId(tiporubroemplea.getId());	
					tiporubroempleaLocal.setVersionRow(tiporubroemplea.getVersionRow());	
					tiporubroempleaLocal.setcodigo(tiporubroemplea.getcodigo());	
					tiporubroempleaLocal.setnombre(tiporubroemplea.getnombre());	
					
					
					tiporubroempleaLocal.setRubroEmpleas(tiporubroemplea.getRubroEmpleas());
					
					existe=true;
					break;
				}
			}
			
			if(!tiporubroemplea.getIsDeleted()) {
				if(!existe) {
					tiporubroempleas.add(tiporubroemplea);
				}
			} else {
				if(tiporubroempleaEncontrado!=null && permiteQuitar)  {
					tiporubroempleas.remove(tiporubroempleaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoRubroEmplea tiporubroemplea,List<TipoRubroEmplea> tiporubroempleas) throws Exception {
		try	{			
			for(TipoRubroEmplea tiporubroempleaLocal:tiporubroempleas) {
				if(tiporubroempleaLocal.getId().equals(tiporubroemplea.getId())) {
					tiporubroempleaLocal.setIsSelected(tiporubroemplea.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoRubroEmplea(List<TipoRubroEmplea> tiporubroempleasAux) throws Exception {
		//this.tiporubroempleasAux=tiporubroempleasAux;
		
		for(TipoRubroEmplea tiporubroempleaAux:tiporubroempleasAux) {
			if(tiporubroempleaAux.getIsChanged()) {
				tiporubroempleaAux.setIsChanged(false);
			}		
			
			if(tiporubroempleaAux.getIsNew()) {
				tiporubroempleaAux.setIsNew(false);
			}	
			
			if(tiporubroempleaAux.getIsDeleted()) {
				tiporubroempleaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoRubroEmplea(TipoRubroEmplea tiporubroempleaAux) throws Exception {
		//this.tiporubroempleaAux=tiporubroempleaAux;
		
			if(tiporubroempleaAux.getIsChanged()) {
				tiporubroempleaAux.setIsChanged(false);
			}		
			
			if(tiporubroempleaAux.getIsNew()) {
				tiporubroempleaAux.setIsNew(false);
			}	
			
			if(tiporubroempleaAux.getIsDeleted()) {
				tiporubroempleaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoRubroEmplea tiporubroempleaAsignar,TipoRubroEmplea tiporubroemplea) throws Exception {
		tiporubroempleaAsignar.setId(tiporubroemplea.getId());	
		tiporubroempleaAsignar.setVersionRow(tiporubroemplea.getVersionRow());	
		tiporubroempleaAsignar.setcodigo(tiporubroemplea.getcodigo());	
		tiporubroempleaAsignar.setnombre(tiporubroemplea.getnombre());	
	}
	
	public static void inicializarTipoRubroEmplea(TipoRubroEmplea tiporubroemplea) throws Exception {
		try {
				tiporubroemplea.setId(0L);	
					
				tiporubroemplea.setcodigo("");	
				tiporubroemplea.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoRubroEmplea(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRubroEmpleaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRubroEmpleaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoRubroEmplea(String sTipo,Row row,Workbook workbook,TipoRubroEmplea tiporubroemplea,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporubroemplea.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporubroemplea.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoRubroEmplea=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoRubroEmplea() {
		return this.sFinalQueryTipoRubroEmplea;
	}
	
	public void setsFinalQueryTipoRubroEmplea(String sFinalQueryTipoRubroEmplea) {
		this.sFinalQueryTipoRubroEmplea= sFinalQueryTipoRubroEmplea;
	}
	
	public Border resaltarSeleccionarTipoRubroEmplea=null;
	
	public Border setResaltarSeleccionarTipoRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRubroEmpleaBeanSwingJInternalFrame tiporubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiporubroempleaBeanSwingJInternalFrame.jTtoolBarTipoRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoRubroEmplea= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoRubroEmplea() {
		return this.resaltarSeleccionarTipoRubroEmplea;
	}
	
	public void setResaltarSeleccionarTipoRubroEmplea(Border borderResaltarSeleccionarTipoRubroEmplea) {
		this.resaltarSeleccionarTipoRubroEmplea= borderResaltarSeleccionarTipoRubroEmplea;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoRubroEmplea=null;
	public Boolean mostraridTipoRubroEmplea=true;
	public Boolean activaridTipoRubroEmplea=true;

	public Border resaltarcodigoTipoRubroEmplea=null;
	public Boolean mostrarcodigoTipoRubroEmplea=true;
	public Boolean activarcodigoTipoRubroEmplea=true;

	public Border resaltarnombreTipoRubroEmplea=null;
	public Boolean mostrarnombreTipoRubroEmplea=true;
	public Boolean activarnombreTipoRubroEmplea=true;

	
	

	public Border setResaltaridTipoRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRubroEmpleaBeanSwingJInternalFrame tiporubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporubroempleaBeanSwingJInternalFrame.jTtoolBarTipoRubroEmplea.setBorder(borderResaltar);
		
		this.resaltaridTipoRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoRubroEmplea() {
		return this.resaltaridTipoRubroEmplea;
	}

	public void setResaltaridTipoRubroEmplea(Border borderResaltar) {
		this.resaltaridTipoRubroEmplea= borderResaltar;
	}

	public Boolean getMostraridTipoRubroEmplea() {
		return this.mostraridTipoRubroEmplea;
	}

	public void setMostraridTipoRubroEmplea(Boolean mostraridTipoRubroEmplea) {
		this.mostraridTipoRubroEmplea= mostraridTipoRubroEmplea;
	}

	public Boolean getActivaridTipoRubroEmplea() {
		return this.activaridTipoRubroEmplea;
	}

	public void setActivaridTipoRubroEmplea(Boolean activaridTipoRubroEmplea) {
		this.activaridTipoRubroEmplea= activaridTipoRubroEmplea;
	}

	public Border setResaltarcodigoTipoRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRubroEmpleaBeanSwingJInternalFrame tiporubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporubroempleaBeanSwingJInternalFrame.jTtoolBarTipoRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoRubroEmplea() {
		return this.resaltarcodigoTipoRubroEmplea;
	}

	public void setResaltarcodigoTipoRubroEmplea(Border borderResaltar) {
		this.resaltarcodigoTipoRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoRubroEmplea() {
		return this.mostrarcodigoTipoRubroEmplea;
	}

	public void setMostrarcodigoTipoRubroEmplea(Boolean mostrarcodigoTipoRubroEmplea) {
		this.mostrarcodigoTipoRubroEmplea= mostrarcodigoTipoRubroEmplea;
	}

	public Boolean getActivarcodigoTipoRubroEmplea() {
		return this.activarcodigoTipoRubroEmplea;
	}

	public void setActivarcodigoTipoRubroEmplea(Boolean activarcodigoTipoRubroEmplea) {
		this.activarcodigoTipoRubroEmplea= activarcodigoTipoRubroEmplea;
	}

	public Border setResaltarnombreTipoRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRubroEmpleaBeanSwingJInternalFrame tiporubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporubroempleaBeanSwingJInternalFrame.jTtoolBarTipoRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarnombreTipoRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoRubroEmplea() {
		return this.resaltarnombreTipoRubroEmplea;
	}

	public void setResaltarnombreTipoRubroEmplea(Border borderResaltar) {
		this.resaltarnombreTipoRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarnombreTipoRubroEmplea() {
		return this.mostrarnombreTipoRubroEmplea;
	}

	public void setMostrarnombreTipoRubroEmplea(Boolean mostrarnombreTipoRubroEmplea) {
		this.mostrarnombreTipoRubroEmplea= mostrarnombreTipoRubroEmplea;
	}

	public Boolean getActivarnombreTipoRubroEmplea() {
		return this.activarnombreTipoRubroEmplea;
	}

	public void setActivarnombreTipoRubroEmplea(Boolean activarnombreTipoRubroEmplea) {
		this.activarnombreTipoRubroEmplea= activarnombreTipoRubroEmplea;
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
		
		
		this.setMostraridTipoRubroEmplea(esInicial);
		this.setMostrarcodigoTipoRubroEmplea(esInicial);
		this.setMostrarnombreTipoRubroEmplea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRubroEmpleaConstantesFunciones.ID)) {
				this.setMostraridTipoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRubroEmpleaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRubroEmpleaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoRubroEmplea(esAsigna);
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
		
		
		this.setActivaridTipoRubroEmplea(esInicial);
		this.setActivarcodigoTipoRubroEmplea(esInicial);
		this.setActivarnombreTipoRubroEmplea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRubroEmpleaConstantesFunciones.ID)) {
				this.setActivaridTipoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRubroEmpleaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRubroEmpleaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoRubroEmplea(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRubroEmpleaBeanSwingJInternalFrame tiporubroempleaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoRubroEmplea(esInicial);
		this.setResaltarcodigoTipoRubroEmplea(esInicial);
		this.setResaltarnombreTipoRubroEmplea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRubroEmpleaConstantesFunciones.ID)) {
				this.setResaltaridTipoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRubroEmpleaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRubroEmpleaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoRubroEmplea(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarRubroEmpleaTipoRubroEmplea=null;

	public Border getResaltarRubroEmpleaTipoRubroEmplea() {
		return this.resaltarRubroEmpleaTipoRubroEmplea;
	}

	public void setResaltarRubroEmpleaTipoRubroEmplea(Border borderResaltarRubroEmplea) {
		if(borderResaltarRubroEmplea!=null) {
			this.resaltarRubroEmpleaTipoRubroEmplea= borderResaltarRubroEmplea;
		}
	}

	public Border setResaltarRubroEmpleaTipoRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRubroEmpleaBeanSwingJInternalFrame tiporubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltarRubroEmplea=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiporubroempleaBeanSwingJInternalFrame.jTtoolBarTipoRubroEmplea.setBorder(borderResaltarRubroEmplea);
			
		this.resaltarRubroEmpleaTipoRubroEmplea= borderResaltarRubroEmplea;

		 return borderResaltarRubroEmplea;
	}



	public Boolean mostrarRubroEmpleaTipoRubroEmplea=true;

	public Boolean getMostrarRubroEmpleaTipoRubroEmplea() {
		return this.mostrarRubroEmpleaTipoRubroEmplea;
	}

	public void setMostrarRubroEmpleaTipoRubroEmplea(Boolean visibilidadResaltarRubroEmplea) {
		this.mostrarRubroEmpleaTipoRubroEmplea= visibilidadResaltarRubroEmplea;
	}



	public Boolean activarRubroEmpleaTipoRubroEmplea=true;

	public Boolean gethabilitarResaltarRubroEmpleaTipoRubroEmplea() {
		return this.activarRubroEmpleaTipoRubroEmplea;
	}

	public void setActivarRubroEmpleaTipoRubroEmplea(Boolean habilitarResaltarRubroEmplea) {
		this.activarRubroEmpleaTipoRubroEmplea= habilitarResaltarRubroEmplea;
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

		this.setMostrarRubroEmpleaTipoRubroEmplea(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RubroEmplea.class)) {
				this.setMostrarRubroEmpleaTipoRubroEmplea(esAsigna);
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

		this.setActivarRubroEmpleaTipoRubroEmplea(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RubroEmplea.class)) {
				this.setActivarRubroEmpleaTipoRubroEmplea(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRubroEmpleaBeanSwingJInternalFrame tiporubroempleaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarRubroEmpleaTipoRubroEmplea(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RubroEmplea.class)) {
				this.setResaltarRubroEmpleaTipoRubroEmplea(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}