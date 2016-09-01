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


import com.bydan.erp.nomina.util.TipoGrupoRubroEmpleaConstantesFunciones;
import com.bydan.erp.nomina.util.TipoGrupoRubroEmpleaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoGrupoRubroEmpleaParameterGeneral;

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
final public class TipoGrupoRubroEmpleaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoGrupoRubroEmplea";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoGrupoRubroEmplea"+TipoGrupoRubroEmpleaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoGrupoRubroEmpleaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoGrupoRubroEmpleaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"_"+TipoGrupoRubroEmpleaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoGrupoRubroEmpleaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"_"+TipoGrupoRubroEmpleaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"_"+TipoGrupoRubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoGrupoRubroEmpleaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"_"+TipoGrupoRubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGrupoRubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGrupoRubroEmpleaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGrupoRubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGrupoRubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGrupoRubroEmpleaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGrupoRubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoGrupoRubroEmpleaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoGrupoRubroEmpleaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoGrupoRubroEmpleaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoGrupoRubroEmpleaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Grupo Rubro Empleados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Grupo Rubro Empleado";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Grupo Rubro Emplea";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoGrupoRubroEmplea";
	public static final String OBJECTNAME="tipogruporubroemplea";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_grupo_rubro_emplea";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipogruporubroemplea from "+TipoGrupoRubroEmpleaConstantesFunciones.SPERSISTENCENAME+" tipogruporubroemplea";
	public static String QUERYSELECTNATIVE="select "+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME+".id,"+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME+".version_row,"+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME+".codigo,"+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME+".nombre from "+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME;//+" as "+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
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
	
	public static String getTipoGrupoRubroEmpleaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoGrupoRubroEmpleaConstantesFunciones.CODIGO)) {sLabelColumna=TipoGrupoRubroEmpleaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoGrupoRubroEmpleaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoGrupoRubroEmpleaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoGrupoRubroEmpleaDescripcion(TipoGrupoRubroEmplea tipogruporubroemplea) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipogruporubroemplea !=null/* && tipogruporubroemplea.getId()!=0*/) {
			sDescripcion=tipogruporubroemplea.getcodigo();//tipogruporubroempleatipogruporubroemplea.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoGrupoRubroEmpleaDescripcionDetallado(TipoGrupoRubroEmplea tipogruporubroemplea) {
		String sDescripcion="";
			
		sDescripcion+=TipoGrupoRubroEmpleaConstantesFunciones.ID+"=";
		sDescripcion+=tipogruporubroemplea.getId().toString()+",";
		sDescripcion+=TipoGrupoRubroEmpleaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipogruporubroemplea.getVersionRow().toString()+",";
		sDescripcion+=TipoGrupoRubroEmpleaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipogruporubroemplea.getcodigo()+",";
		sDescripcion+=TipoGrupoRubroEmpleaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipogruporubroemplea.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoGrupoRubroEmpleaDescripcion(TipoGrupoRubroEmplea tipogruporubroemplea,String sValor) throws Exception {			
		if(tipogruporubroemplea !=null) {
			tipogruporubroemplea.setcodigo(sValor);;//tipogruporubroempleatipogruporubroemplea.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoGrupoRubroEmplea(TipoGrupoRubroEmplea tipogruporubroemplea,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipogruporubroemplea.setcodigo(tipogruporubroemplea.getcodigo().trim());
		tipogruporubroemplea.setnombre(tipogruporubroemplea.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoGrupoRubroEmpleas(List<TipoGrupoRubroEmplea> tipogruporubroempleas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoGrupoRubroEmplea tipogruporubroemplea: tipogruporubroempleas) {
			tipogruporubroemplea.setcodigo(tipogruporubroemplea.getcodigo().trim());
			tipogruporubroemplea.setnombre(tipogruporubroemplea.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGrupoRubroEmplea(TipoGrupoRubroEmplea tipogruporubroemplea,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipogruporubroemplea.getConCambioAuxiliar()) {
			tipogruporubroemplea.setIsDeleted(tipogruporubroemplea.getIsDeletedAuxiliar());	
			tipogruporubroemplea.setIsNew(tipogruporubroemplea.getIsNewAuxiliar());	
			tipogruporubroemplea.setIsChanged(tipogruporubroemplea.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipogruporubroemplea.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipogruporubroemplea.setIsDeletedAuxiliar(false);	
			tipogruporubroemplea.setIsNewAuxiliar(false);	
			tipogruporubroemplea.setIsChangedAuxiliar(false);
			
			tipogruporubroemplea.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGrupoRubroEmpleas(List<TipoGrupoRubroEmplea> tipogruporubroempleas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoGrupoRubroEmplea tipogruporubroemplea : tipogruporubroempleas) {
			if(conAsignarBase && tipogruporubroemplea.getConCambioAuxiliar()) {
				tipogruporubroemplea.setIsDeleted(tipogruporubroemplea.getIsDeletedAuxiliar());	
				tipogruporubroemplea.setIsNew(tipogruporubroemplea.getIsNewAuxiliar());	
				tipogruporubroemplea.setIsChanged(tipogruporubroemplea.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipogruporubroemplea.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipogruporubroemplea.setIsDeletedAuxiliar(false);	
				tipogruporubroemplea.setIsNewAuxiliar(false);	
				tipogruporubroemplea.setIsChangedAuxiliar(false);
				
				tipogruporubroemplea.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoGrupoRubroEmplea(TipoGrupoRubroEmplea tipogruporubroemplea,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoGrupoRubroEmpleas(List<TipoGrupoRubroEmplea> tipogruporubroempleas,Boolean conEnteros) throws Exception  {
		
		for(TipoGrupoRubroEmplea tipogruporubroemplea: tipogruporubroempleas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoGrupoRubroEmplea(List<TipoGrupoRubroEmplea> tipogruporubroempleas,TipoGrupoRubroEmplea tipogruporubroempleaAux) throws Exception  {
		TipoGrupoRubroEmpleaConstantesFunciones.InicializarValoresTipoGrupoRubroEmplea(tipogruporubroempleaAux,true);
		
		for(TipoGrupoRubroEmplea tipogruporubroemplea: tipogruporubroempleas) {
			if(tipogruporubroemplea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGrupoRubroEmplea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoGrupoRubroEmpleaConstantesFunciones.getArrayColumnasGlobalesTipoGrupoRubroEmplea(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGrupoRubroEmplea(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoGrupoRubroEmplea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoGrupoRubroEmplea> tipogruporubroempleas,TipoGrupoRubroEmplea tipogruporubroemplea,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoGrupoRubroEmplea tipogruporubroempleaAux: tipogruporubroempleas) {
			if(tipogruporubroempleaAux!=null && tipogruporubroemplea!=null) {
				if((tipogruporubroempleaAux.getId()==null && tipogruporubroemplea.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipogruporubroempleaAux.getId()!=null && tipogruporubroemplea.getId()!=null){
					if(tipogruporubroempleaAux.getId().equals(tipogruporubroemplea.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoGrupoRubroEmplea(List<TipoGrupoRubroEmplea> tipogruporubroempleas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoGrupoRubroEmplea tipogruporubroemplea: tipogruporubroempleas) {			
			if(tipogruporubroemplea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoGrupoRubroEmplea() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoGrupoRubroEmpleaConstantesFunciones.LABEL_ID, TipoGrupoRubroEmpleaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGrupoRubroEmpleaConstantesFunciones.LABEL_VERSIONROW, TipoGrupoRubroEmpleaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGrupoRubroEmpleaConstantesFunciones.LABEL_CODIGO, TipoGrupoRubroEmpleaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGrupoRubroEmpleaConstantesFunciones.LABEL_NOMBRE, TipoGrupoRubroEmpleaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoGrupoRubroEmplea() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoGrupoRubroEmpleaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGrupoRubroEmpleaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGrupoRubroEmpleaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGrupoRubroEmpleaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGrupoRubroEmplea() throws Exception  {
		return TipoGrupoRubroEmpleaConstantesFunciones.getTiposSeleccionarTipoGrupoRubroEmplea(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGrupoRubroEmplea(Boolean conFk) throws Exception  {
		return TipoGrupoRubroEmpleaConstantesFunciones.getTiposSeleccionarTipoGrupoRubroEmplea(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGrupoRubroEmplea(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGrupoRubroEmpleaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoGrupoRubroEmpleaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGrupoRubroEmpleaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoGrupoRubroEmpleaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoGrupoRubroEmplea(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(TipoGrupoRubroEmplea tipogruporubroempleaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(List<TipoGrupoRubroEmplea> tipogruporubroempleasTemp) throws Exception {
		for(TipoGrupoRubroEmplea tipogruporubroempleaAux:tipogruporubroempleasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGrupoRubroEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoGrupoRubroEmplea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGrupoRubroEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGrupoRubroEmpleaConstantesFunciones.getClassesRelationshipsOfTipoGrupoRubroEmplea(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGrupoRubroEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGrupoRubroEmplea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGrupoRubroEmpleaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoGrupoRubroEmplea(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGrupoRubroEmplea(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoGrupoRubroEmplea tipogruporubroemplea,List<TipoGrupoRubroEmplea> tipogruporubroempleas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoGrupoRubroEmplea tipogruporubroempleaEncontrado=null;
			
			for(TipoGrupoRubroEmplea tipogruporubroempleaLocal:tipogruporubroempleas) {
				if(tipogruporubroempleaLocal.getId().equals(tipogruporubroemplea.getId())) {
					tipogruporubroempleaEncontrado=tipogruporubroempleaLocal;
					
					tipogruporubroempleaLocal.setIsChanged(tipogruporubroemplea.getIsChanged());
					tipogruporubroempleaLocal.setIsNew(tipogruporubroemplea.getIsNew());
					tipogruporubroempleaLocal.setIsDeleted(tipogruporubroemplea.getIsDeleted());
					
					tipogruporubroempleaLocal.setGeneralEntityOriginal(tipogruporubroemplea.getGeneralEntityOriginal());
					
					tipogruporubroempleaLocal.setId(tipogruporubroemplea.getId());	
					tipogruporubroempleaLocal.setVersionRow(tipogruporubroemplea.getVersionRow());	
					tipogruporubroempleaLocal.setcodigo(tipogruporubroemplea.getcodigo());	
					tipogruporubroempleaLocal.setnombre(tipogruporubroemplea.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipogruporubroemplea.getIsDeleted()) {
				if(!existe) {
					tipogruporubroempleas.add(tipogruporubroemplea);
				}
			} else {
				if(tipogruporubroempleaEncontrado!=null && permiteQuitar)  {
					tipogruporubroempleas.remove(tipogruporubroempleaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoGrupoRubroEmplea tipogruporubroemplea,List<TipoGrupoRubroEmplea> tipogruporubroempleas) throws Exception {
		try	{			
			for(TipoGrupoRubroEmplea tipogruporubroempleaLocal:tipogruporubroempleas) {
				if(tipogruporubroempleaLocal.getId().equals(tipogruporubroemplea.getId())) {
					tipogruporubroempleaLocal.setIsSelected(tipogruporubroemplea.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoGrupoRubroEmplea(List<TipoGrupoRubroEmplea> tipogruporubroempleasAux) throws Exception {
		//this.tipogruporubroempleasAux=tipogruporubroempleasAux;
		
		for(TipoGrupoRubroEmplea tipogruporubroempleaAux:tipogruporubroempleasAux) {
			if(tipogruporubroempleaAux.getIsChanged()) {
				tipogruporubroempleaAux.setIsChanged(false);
			}		
			
			if(tipogruporubroempleaAux.getIsNew()) {
				tipogruporubroempleaAux.setIsNew(false);
			}	
			
			if(tipogruporubroempleaAux.getIsDeleted()) {
				tipogruporubroempleaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoGrupoRubroEmplea(TipoGrupoRubroEmplea tipogruporubroempleaAux) throws Exception {
		//this.tipogruporubroempleaAux=tipogruporubroempleaAux;
		
			if(tipogruporubroempleaAux.getIsChanged()) {
				tipogruporubroempleaAux.setIsChanged(false);
			}		
			
			if(tipogruporubroempleaAux.getIsNew()) {
				tipogruporubroempleaAux.setIsNew(false);
			}	
			
			if(tipogruporubroempleaAux.getIsDeleted()) {
				tipogruporubroempleaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoGrupoRubroEmplea tipogruporubroempleaAsignar,TipoGrupoRubroEmplea tipogruporubroemplea) throws Exception {
		tipogruporubroempleaAsignar.setId(tipogruporubroemplea.getId());	
		tipogruporubroempleaAsignar.setVersionRow(tipogruporubroemplea.getVersionRow());	
		tipogruporubroempleaAsignar.setcodigo(tipogruporubroemplea.getcodigo());	
		tipogruporubroempleaAsignar.setnombre(tipogruporubroemplea.getnombre());	
	}
	
	public static void inicializarTipoGrupoRubroEmplea(TipoGrupoRubroEmplea tipogruporubroemplea) throws Exception {
		try {
				tipogruporubroemplea.setId(0L);	
					
				tipogruporubroemplea.setcodigo("");	
				tipogruporubroemplea.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoGrupoRubroEmplea(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGrupoRubroEmpleaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGrupoRubroEmpleaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoGrupoRubroEmplea(String sTipo,Row row,Workbook workbook,TipoGrupoRubroEmplea tipogruporubroemplea,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogruporubroemplea.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogruporubroemplea.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoGrupoRubroEmplea=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoGrupoRubroEmplea() {
		return this.sFinalQueryTipoGrupoRubroEmplea;
	}
	
	public void setsFinalQueryTipoGrupoRubroEmplea(String sFinalQueryTipoGrupoRubroEmplea) {
		this.sFinalQueryTipoGrupoRubroEmplea= sFinalQueryTipoGrupoRubroEmplea;
	}
	
	public Border resaltarSeleccionarTipoGrupoRubroEmplea=null;
	
	public Border setResaltarSeleccionarTipoGrupoRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoRubroEmpleaBeanSwingJInternalFrame tipogruporubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipogruporubroempleaBeanSwingJInternalFrame.jTtoolBarTipoGrupoRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoGrupoRubroEmplea= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoGrupoRubroEmplea() {
		return this.resaltarSeleccionarTipoGrupoRubroEmplea;
	}
	
	public void setResaltarSeleccionarTipoGrupoRubroEmplea(Border borderResaltarSeleccionarTipoGrupoRubroEmplea) {
		this.resaltarSeleccionarTipoGrupoRubroEmplea= borderResaltarSeleccionarTipoGrupoRubroEmplea;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoGrupoRubroEmplea=null;
	public Boolean mostraridTipoGrupoRubroEmplea=true;
	public Boolean activaridTipoGrupoRubroEmplea=true;

	public Border resaltarcodigoTipoGrupoRubroEmplea=null;
	public Boolean mostrarcodigoTipoGrupoRubroEmplea=true;
	public Boolean activarcodigoTipoGrupoRubroEmplea=true;

	public Border resaltarnombreTipoGrupoRubroEmplea=null;
	public Boolean mostrarnombreTipoGrupoRubroEmplea=true;
	public Boolean activarnombreTipoGrupoRubroEmplea=true;

	
	

	public Border setResaltaridTipoGrupoRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoRubroEmpleaBeanSwingJInternalFrame tipogruporubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogruporubroempleaBeanSwingJInternalFrame.jTtoolBarTipoGrupoRubroEmplea.setBorder(borderResaltar);
		
		this.resaltaridTipoGrupoRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoGrupoRubroEmplea() {
		return this.resaltaridTipoGrupoRubroEmplea;
	}

	public void setResaltaridTipoGrupoRubroEmplea(Border borderResaltar) {
		this.resaltaridTipoGrupoRubroEmplea= borderResaltar;
	}

	public Boolean getMostraridTipoGrupoRubroEmplea() {
		return this.mostraridTipoGrupoRubroEmplea;
	}

	public void setMostraridTipoGrupoRubroEmplea(Boolean mostraridTipoGrupoRubroEmplea) {
		this.mostraridTipoGrupoRubroEmplea= mostraridTipoGrupoRubroEmplea;
	}

	public Boolean getActivaridTipoGrupoRubroEmplea() {
		return this.activaridTipoGrupoRubroEmplea;
	}

	public void setActivaridTipoGrupoRubroEmplea(Boolean activaridTipoGrupoRubroEmplea) {
		this.activaridTipoGrupoRubroEmplea= activaridTipoGrupoRubroEmplea;
	}

	public Border setResaltarcodigoTipoGrupoRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoRubroEmpleaBeanSwingJInternalFrame tipogruporubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogruporubroempleaBeanSwingJInternalFrame.jTtoolBarTipoGrupoRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoGrupoRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoGrupoRubroEmplea() {
		return this.resaltarcodigoTipoGrupoRubroEmplea;
	}

	public void setResaltarcodigoTipoGrupoRubroEmplea(Border borderResaltar) {
		this.resaltarcodigoTipoGrupoRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoGrupoRubroEmplea() {
		return this.mostrarcodigoTipoGrupoRubroEmplea;
	}

	public void setMostrarcodigoTipoGrupoRubroEmplea(Boolean mostrarcodigoTipoGrupoRubroEmplea) {
		this.mostrarcodigoTipoGrupoRubroEmplea= mostrarcodigoTipoGrupoRubroEmplea;
	}

	public Boolean getActivarcodigoTipoGrupoRubroEmplea() {
		return this.activarcodigoTipoGrupoRubroEmplea;
	}

	public void setActivarcodigoTipoGrupoRubroEmplea(Boolean activarcodigoTipoGrupoRubroEmplea) {
		this.activarcodigoTipoGrupoRubroEmplea= activarcodigoTipoGrupoRubroEmplea;
	}

	public Border setResaltarnombreTipoGrupoRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoRubroEmpleaBeanSwingJInternalFrame tipogruporubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogruporubroempleaBeanSwingJInternalFrame.jTtoolBarTipoGrupoRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarnombreTipoGrupoRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoGrupoRubroEmplea() {
		return this.resaltarnombreTipoGrupoRubroEmplea;
	}

	public void setResaltarnombreTipoGrupoRubroEmplea(Border borderResaltar) {
		this.resaltarnombreTipoGrupoRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarnombreTipoGrupoRubroEmplea() {
		return this.mostrarnombreTipoGrupoRubroEmplea;
	}

	public void setMostrarnombreTipoGrupoRubroEmplea(Boolean mostrarnombreTipoGrupoRubroEmplea) {
		this.mostrarnombreTipoGrupoRubroEmplea= mostrarnombreTipoGrupoRubroEmplea;
	}

	public Boolean getActivarnombreTipoGrupoRubroEmplea() {
		return this.activarnombreTipoGrupoRubroEmplea;
	}

	public void setActivarnombreTipoGrupoRubroEmplea(Boolean activarnombreTipoGrupoRubroEmplea) {
		this.activarnombreTipoGrupoRubroEmplea= activarnombreTipoGrupoRubroEmplea;
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
		
		
		this.setMostraridTipoGrupoRubroEmplea(esInicial);
		this.setMostrarcodigoTipoGrupoRubroEmplea(esInicial);
		this.setMostrarnombreTipoGrupoRubroEmplea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGrupoRubroEmpleaConstantesFunciones.ID)) {
				this.setMostraridTipoGrupoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoRubroEmpleaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoGrupoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoRubroEmpleaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoGrupoRubroEmplea(esAsigna);
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
		
		
		this.setActivaridTipoGrupoRubroEmplea(esInicial);
		this.setActivarcodigoTipoGrupoRubroEmplea(esInicial);
		this.setActivarnombreTipoGrupoRubroEmplea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGrupoRubroEmpleaConstantesFunciones.ID)) {
				this.setActivaridTipoGrupoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoRubroEmpleaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoGrupoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoRubroEmpleaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoGrupoRubroEmplea(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGrupoRubroEmpleaBeanSwingJInternalFrame tipogruporubroempleaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoGrupoRubroEmplea(esInicial);
		this.setResaltarcodigoTipoGrupoRubroEmplea(esInicial);
		this.setResaltarnombreTipoGrupoRubroEmplea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGrupoRubroEmpleaConstantesFunciones.ID)) {
				this.setResaltaridTipoGrupoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoRubroEmpleaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoGrupoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoRubroEmpleaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoGrupoRubroEmplea(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGrupoRubroEmpleaBeanSwingJInternalFrame tipogruporubroempleaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	
	//CONTROL_FUNCION2
}