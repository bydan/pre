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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.TipoTamanioControlConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoTamanioControlParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoTamanioControlParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoTamanioControlConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoTamanioControl";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoTamanioControl"+TipoTamanioControlConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoTamanioControlHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoTamanioControlHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoTamanioControlConstantesFunciones.SCHEMA+"_"+TipoTamanioControlConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoTamanioControlHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoTamanioControlConstantesFunciones.SCHEMA+"_"+TipoTamanioControlConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoTamanioControlConstantesFunciones.SCHEMA+"_"+TipoTamanioControlConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoTamanioControlHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoTamanioControlConstantesFunciones.SCHEMA+"_"+TipoTamanioControlConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTamanioControlConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoTamanioControlHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTamanioControlConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTamanioControlConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoTamanioControlHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTamanioControlConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoTamanioControlConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoTamanioControlConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoTamanioControlConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoTamanioControlConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Tamanio Controls";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Tamanio Control";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Tamanio Control";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoTamanioControl";
	public static final String OBJECTNAME="tipotamaniocontrol";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="tipo_tamanio_control";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipotamaniocontrol from "+TipoTamanioControlConstantesFunciones.SPERSISTENCENAME+" tipotamaniocontrol";
	public static String QUERYSELECTNATIVE="select "+TipoTamanioControlConstantesFunciones.SCHEMA+"."+TipoTamanioControlConstantesFunciones.TABLENAME+".id,"+TipoTamanioControlConstantesFunciones.SCHEMA+"."+TipoTamanioControlConstantesFunciones.TABLENAME+".version_row,"+TipoTamanioControlConstantesFunciones.SCHEMA+"."+TipoTamanioControlConstantesFunciones.TABLENAME+".codigo,"+TipoTamanioControlConstantesFunciones.SCHEMA+"."+TipoTamanioControlConstantesFunciones.TABLENAME+".nombre,"+TipoTamanioControlConstantesFunciones.SCHEMA+"."+TipoTamanioControlConstantesFunciones.TABLENAME+".descripcion from "+TipoTamanioControlConstantesFunciones.SCHEMA+"."+TipoTamanioControlConstantesFunciones.TABLENAME;//+" as "+TipoTamanioControlConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoTamanioControlLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoTamanioControlConstantesFunciones.CODIGO)) {sLabelColumna=TipoTamanioControlConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoTamanioControlConstantesFunciones.NOMBRE)) {sLabelColumna=TipoTamanioControlConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoTamanioControlConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoTamanioControlConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoTamanioControlDescripcion(TipoTamanioControl tipotamaniocontrol) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipotamaniocontrol !=null/* && tipotamaniocontrol.getId()!=0*/) {
			sDescripcion=tipotamaniocontrol.getcodigo();//tipotamaniocontroltipotamaniocontrol.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoTamanioControlDescripcionDetallado(TipoTamanioControl tipotamaniocontrol) {
		String sDescripcion="";
			
		sDescripcion+=TipoTamanioControlConstantesFunciones.ID+"=";
		sDescripcion+=tipotamaniocontrol.getId().toString()+",";
		sDescripcion+=TipoTamanioControlConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipotamaniocontrol.getVersionRow().toString()+",";
		sDescripcion+=TipoTamanioControlConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipotamaniocontrol.getcodigo()+",";
		sDescripcion+=TipoTamanioControlConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipotamaniocontrol.getnombre()+",";
		sDescripcion+=TipoTamanioControlConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipotamaniocontrol.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoTamanioControlDescripcion(TipoTamanioControl tipotamaniocontrol,String sValor) throws Exception {			
		if(tipotamaniocontrol !=null) {
			tipotamaniocontrol.setcodigo(sValor);;//tipotamaniocontroltipotamaniocontrol.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoTamanioControl(TipoTamanioControl tipotamaniocontrol,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipotamaniocontrol.setcodigo(tipotamaniocontrol.getcodigo().trim());
		tipotamaniocontrol.setnombre(tipotamaniocontrol.getnombre().trim());
		tipotamaniocontrol.setdescripcion(tipotamaniocontrol.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoTamanioControls(List<TipoTamanioControl> tipotamaniocontrols,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoTamanioControl tipotamaniocontrol: tipotamaniocontrols) {
			tipotamaniocontrol.setcodigo(tipotamaniocontrol.getcodigo().trim());
			tipotamaniocontrol.setnombre(tipotamaniocontrol.getnombre().trim());
			tipotamaniocontrol.setdescripcion(tipotamaniocontrol.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoTamanioControl(TipoTamanioControl tipotamaniocontrol,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipotamaniocontrol.getConCambioAuxiliar()) {
			tipotamaniocontrol.setIsDeleted(tipotamaniocontrol.getIsDeletedAuxiliar());	
			tipotamaniocontrol.setIsNew(tipotamaniocontrol.getIsNewAuxiliar());	
			tipotamaniocontrol.setIsChanged(tipotamaniocontrol.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipotamaniocontrol.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipotamaniocontrol.setIsDeletedAuxiliar(false);	
			tipotamaniocontrol.setIsNewAuxiliar(false);	
			tipotamaniocontrol.setIsChangedAuxiliar(false);
			
			tipotamaniocontrol.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoTamanioControls(List<TipoTamanioControl> tipotamaniocontrols,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoTamanioControl tipotamaniocontrol : tipotamaniocontrols) {
			if(conAsignarBase && tipotamaniocontrol.getConCambioAuxiliar()) {
				tipotamaniocontrol.setIsDeleted(tipotamaniocontrol.getIsDeletedAuxiliar());	
				tipotamaniocontrol.setIsNew(tipotamaniocontrol.getIsNewAuxiliar());	
				tipotamaniocontrol.setIsChanged(tipotamaniocontrol.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipotamaniocontrol.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipotamaniocontrol.setIsDeletedAuxiliar(false);	
				tipotamaniocontrol.setIsNewAuxiliar(false);	
				tipotamaniocontrol.setIsChangedAuxiliar(false);
				
				tipotamaniocontrol.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoTamanioControl(TipoTamanioControl tipotamaniocontrol,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoTamanioControls(List<TipoTamanioControl> tipotamaniocontrols,Boolean conEnteros) throws Exception  {
		
		for(TipoTamanioControl tipotamaniocontrol: tipotamaniocontrols) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoTamanioControl(List<TipoTamanioControl> tipotamaniocontrols,TipoTamanioControl tipotamaniocontrolAux) throws Exception  {
		TipoTamanioControlConstantesFunciones.InicializarValoresTipoTamanioControl(tipotamaniocontrolAux,true);
		
		for(TipoTamanioControl tipotamaniocontrol: tipotamaniocontrols) {
			if(tipotamaniocontrol.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoTamanioControl(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoTamanioControlConstantesFunciones.getArrayColumnasGlobalesTipoTamanioControl(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoTamanioControl(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoTamanioControl(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoTamanioControl> tipotamaniocontrols,TipoTamanioControl tipotamaniocontrol,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoTamanioControl tipotamaniocontrolAux: tipotamaniocontrols) {
			if(tipotamaniocontrolAux!=null && tipotamaniocontrol!=null) {
				if((tipotamaniocontrolAux.getId()==null && tipotamaniocontrol.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipotamaniocontrolAux.getId()!=null && tipotamaniocontrol.getId()!=null){
					if(tipotamaniocontrolAux.getId().equals(tipotamaniocontrol.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoTamanioControl(List<TipoTamanioControl> tipotamaniocontrols) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoTamanioControl tipotamaniocontrol: tipotamaniocontrols) {			
			if(tipotamaniocontrol.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoTamanioControl() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoTamanioControlConstantesFunciones.LABEL_ID, TipoTamanioControlConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTamanioControlConstantesFunciones.LABEL_VERSIONROW, TipoTamanioControlConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTamanioControlConstantesFunciones.LABEL_CODIGO, TipoTamanioControlConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTamanioControlConstantesFunciones.LABEL_NOMBRE, TipoTamanioControlConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTamanioControlConstantesFunciones.LABEL_DESCRIPCION, TipoTamanioControlConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoTamanioControl() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoTamanioControlConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTamanioControlConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTamanioControlConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTamanioControlConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTamanioControlConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTamanioControl() throws Exception  {
		return TipoTamanioControlConstantesFunciones.getTiposSeleccionarTipoTamanioControl(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTamanioControl(Boolean conFk) throws Exception  {
		return TipoTamanioControlConstantesFunciones.getTiposSeleccionarTipoTamanioControl(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTamanioControl(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTamanioControlConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoTamanioControlConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTamanioControlConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoTamanioControlConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTamanioControlConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoTamanioControlConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoTamanioControl(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoTamanioControl(TipoTamanioControl tipotamaniocontrolAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoTamanioControl(List<TipoTamanioControl> tipotamaniocontrolsTemp) throws Exception {
		for(TipoTamanioControl tipotamaniocontrolAux:tipotamaniocontrolsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoTamanioControl(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoTamanioControl(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTamanioControl(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoTamanioControlConstantesFunciones.getClassesRelationshipsOfTipoTamanioControl(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTamanioControl(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoTamanioControl(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoTamanioControlConstantesFunciones.getClassesRelationshipsFromStringsOfTipoTamanioControl(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoTamanioControl(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoTamanioControl tipotamaniocontrol,List<TipoTamanioControl> tipotamaniocontrols,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoTamanioControl tipotamaniocontrolEncontrado=null;
			
			for(TipoTamanioControl tipotamaniocontrolLocal:tipotamaniocontrols) {
				if(tipotamaniocontrolLocal.getId().equals(tipotamaniocontrol.getId())) {
					tipotamaniocontrolEncontrado=tipotamaniocontrolLocal;
					
					tipotamaniocontrolLocal.setIsChanged(tipotamaniocontrol.getIsChanged());
					tipotamaniocontrolLocal.setIsNew(tipotamaniocontrol.getIsNew());
					tipotamaniocontrolLocal.setIsDeleted(tipotamaniocontrol.getIsDeleted());
					
					tipotamaniocontrolLocal.setGeneralEntityOriginal(tipotamaniocontrol.getGeneralEntityOriginal());
					
					tipotamaniocontrolLocal.setId(tipotamaniocontrol.getId());	
					tipotamaniocontrolLocal.setVersionRow(tipotamaniocontrol.getVersionRow());	
					tipotamaniocontrolLocal.setcodigo(tipotamaniocontrol.getcodigo());	
					tipotamaniocontrolLocal.setnombre(tipotamaniocontrol.getnombre());	
					tipotamaniocontrolLocal.setdescripcion(tipotamaniocontrol.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipotamaniocontrol.getIsDeleted()) {
				if(!existe) {
					tipotamaniocontrols.add(tipotamaniocontrol);
				}
			} else {
				if(tipotamaniocontrolEncontrado!=null && permiteQuitar)  {
					tipotamaniocontrols.remove(tipotamaniocontrolEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoTamanioControl tipotamaniocontrol,List<TipoTamanioControl> tipotamaniocontrols) throws Exception {
		try	{			
			for(TipoTamanioControl tipotamaniocontrolLocal:tipotamaniocontrols) {
				if(tipotamaniocontrolLocal.getId().equals(tipotamaniocontrol.getId())) {
					tipotamaniocontrolLocal.setIsSelected(tipotamaniocontrol.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoTamanioControl(List<TipoTamanioControl> tipotamaniocontrolsAux) throws Exception {
		//this.tipotamaniocontrolsAux=tipotamaniocontrolsAux;
		
		for(TipoTamanioControl tipotamaniocontrolAux:tipotamaniocontrolsAux) {
			if(tipotamaniocontrolAux.getIsChanged()) {
				tipotamaniocontrolAux.setIsChanged(false);
			}		
			
			if(tipotamaniocontrolAux.getIsNew()) {
				tipotamaniocontrolAux.setIsNew(false);
			}	
			
			if(tipotamaniocontrolAux.getIsDeleted()) {
				tipotamaniocontrolAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoTamanioControl(TipoTamanioControl tipotamaniocontrolAux) throws Exception {
		//this.tipotamaniocontrolAux=tipotamaniocontrolAux;
		
			if(tipotamaniocontrolAux.getIsChanged()) {
				tipotamaniocontrolAux.setIsChanged(false);
			}		
			
			if(tipotamaniocontrolAux.getIsNew()) {
				tipotamaniocontrolAux.setIsNew(false);
			}	
			
			if(tipotamaniocontrolAux.getIsDeleted()) {
				tipotamaniocontrolAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoTamanioControl tipotamaniocontrolAsignar,TipoTamanioControl tipotamaniocontrol) throws Exception {
		tipotamaniocontrolAsignar.setId(tipotamaniocontrol.getId());	
		tipotamaniocontrolAsignar.setVersionRow(tipotamaniocontrol.getVersionRow());	
		tipotamaniocontrolAsignar.setcodigo(tipotamaniocontrol.getcodigo());	
		tipotamaniocontrolAsignar.setnombre(tipotamaniocontrol.getnombre());	
		tipotamaniocontrolAsignar.setdescripcion(tipotamaniocontrol.getdescripcion());	
	}
	
	public static void inicializarTipoTamanioControl(TipoTamanioControl tipotamaniocontrol) throws Exception {
		try {
				tipotamaniocontrol.setId(0L);	
					
				tipotamaniocontrol.setcodigo("");	
				tipotamaniocontrol.setnombre("");	
				tipotamaniocontrol.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoTamanioControl(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTamanioControlConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTamanioControlConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTamanioControlConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoTamanioControl(String sTipo,Row row,Workbook workbook,TipoTamanioControl tipotamaniocontrol,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipotamaniocontrol.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipotamaniocontrol.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipotamaniocontrol.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoTamanioControl=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoTamanioControl() {
		return this.sFinalQueryTipoTamanioControl;
	}
	
	public void setsFinalQueryTipoTamanioControl(String sFinalQueryTipoTamanioControl) {
		this.sFinalQueryTipoTamanioControl= sFinalQueryTipoTamanioControl;
	}
	
	public Border resaltarSeleccionarTipoTamanioControl=null;
	
	public Border setResaltarSeleccionarTipoTamanioControl(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTamanioControlBeanSwingJInternalFrame tipotamaniocontrolBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipotamaniocontrolBeanSwingJInternalFrame.jTtoolBarTipoTamanioControl.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoTamanioControl= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoTamanioControl() {
		return this.resaltarSeleccionarTipoTamanioControl;
	}
	
	public void setResaltarSeleccionarTipoTamanioControl(Border borderResaltarSeleccionarTipoTamanioControl) {
		this.resaltarSeleccionarTipoTamanioControl= borderResaltarSeleccionarTipoTamanioControl;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoTamanioControl=null;
	public Boolean mostraridTipoTamanioControl=true;
	public Boolean activaridTipoTamanioControl=true;

	public Border resaltarcodigoTipoTamanioControl=null;
	public Boolean mostrarcodigoTipoTamanioControl=true;
	public Boolean activarcodigoTipoTamanioControl=true;

	public Border resaltarnombreTipoTamanioControl=null;
	public Boolean mostrarnombreTipoTamanioControl=true;
	public Boolean activarnombreTipoTamanioControl=true;

	public Border resaltardescripcionTipoTamanioControl=null;
	public Boolean mostrardescripcionTipoTamanioControl=true;
	public Boolean activardescripcionTipoTamanioControl=true;

	
	

	public Border setResaltaridTipoTamanioControl(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTamanioControlBeanSwingJInternalFrame tipotamaniocontrolBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotamaniocontrolBeanSwingJInternalFrame.jTtoolBarTipoTamanioControl.setBorder(borderResaltar);
		
		this.resaltaridTipoTamanioControl= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoTamanioControl() {
		return this.resaltaridTipoTamanioControl;
	}

	public void setResaltaridTipoTamanioControl(Border borderResaltar) {
		this.resaltaridTipoTamanioControl= borderResaltar;
	}

	public Boolean getMostraridTipoTamanioControl() {
		return this.mostraridTipoTamanioControl;
	}

	public void setMostraridTipoTamanioControl(Boolean mostraridTipoTamanioControl) {
		this.mostraridTipoTamanioControl= mostraridTipoTamanioControl;
	}

	public Boolean getActivaridTipoTamanioControl() {
		return this.activaridTipoTamanioControl;
	}

	public void setActivaridTipoTamanioControl(Boolean activaridTipoTamanioControl) {
		this.activaridTipoTamanioControl= activaridTipoTamanioControl;
	}

	public Border setResaltarcodigoTipoTamanioControl(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTamanioControlBeanSwingJInternalFrame tipotamaniocontrolBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotamaniocontrolBeanSwingJInternalFrame.jTtoolBarTipoTamanioControl.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoTamanioControl= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoTamanioControl() {
		return this.resaltarcodigoTipoTamanioControl;
	}

	public void setResaltarcodigoTipoTamanioControl(Border borderResaltar) {
		this.resaltarcodigoTipoTamanioControl= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoTamanioControl() {
		return this.mostrarcodigoTipoTamanioControl;
	}

	public void setMostrarcodigoTipoTamanioControl(Boolean mostrarcodigoTipoTamanioControl) {
		this.mostrarcodigoTipoTamanioControl= mostrarcodigoTipoTamanioControl;
	}

	public Boolean getActivarcodigoTipoTamanioControl() {
		return this.activarcodigoTipoTamanioControl;
	}

	public void setActivarcodigoTipoTamanioControl(Boolean activarcodigoTipoTamanioControl) {
		this.activarcodigoTipoTamanioControl= activarcodigoTipoTamanioControl;
	}

	public Border setResaltarnombreTipoTamanioControl(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTamanioControlBeanSwingJInternalFrame tipotamaniocontrolBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotamaniocontrolBeanSwingJInternalFrame.jTtoolBarTipoTamanioControl.setBorder(borderResaltar);
		
		this.resaltarnombreTipoTamanioControl= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoTamanioControl() {
		return this.resaltarnombreTipoTamanioControl;
	}

	public void setResaltarnombreTipoTamanioControl(Border borderResaltar) {
		this.resaltarnombreTipoTamanioControl= borderResaltar;
	}

	public Boolean getMostrarnombreTipoTamanioControl() {
		return this.mostrarnombreTipoTamanioControl;
	}

	public void setMostrarnombreTipoTamanioControl(Boolean mostrarnombreTipoTamanioControl) {
		this.mostrarnombreTipoTamanioControl= mostrarnombreTipoTamanioControl;
	}

	public Boolean getActivarnombreTipoTamanioControl() {
		return this.activarnombreTipoTamanioControl;
	}

	public void setActivarnombreTipoTamanioControl(Boolean activarnombreTipoTamanioControl) {
		this.activarnombreTipoTamanioControl= activarnombreTipoTamanioControl;
	}

	public Border setResaltardescripcionTipoTamanioControl(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTamanioControlBeanSwingJInternalFrame tipotamaniocontrolBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotamaniocontrolBeanSwingJInternalFrame.jTtoolBarTipoTamanioControl.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoTamanioControl= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoTamanioControl() {
		return this.resaltardescripcionTipoTamanioControl;
	}

	public void setResaltardescripcionTipoTamanioControl(Border borderResaltar) {
		this.resaltardescripcionTipoTamanioControl= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoTamanioControl() {
		return this.mostrardescripcionTipoTamanioControl;
	}

	public void setMostrardescripcionTipoTamanioControl(Boolean mostrardescripcionTipoTamanioControl) {
		this.mostrardescripcionTipoTamanioControl= mostrardescripcionTipoTamanioControl;
	}

	public Boolean getActivardescripcionTipoTamanioControl() {
		return this.activardescripcionTipoTamanioControl;
	}

	public void setActivardescripcionTipoTamanioControl(Boolean activardescripcionTipoTamanioControl) {
		this.activardescripcionTipoTamanioControl= activardescripcionTipoTamanioControl;
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
		
		
		this.setMostraridTipoTamanioControl(esInicial);
		this.setMostrarcodigoTipoTamanioControl(esInicial);
		this.setMostrarnombreTipoTamanioControl(esInicial);
		this.setMostrardescripcionTipoTamanioControl(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTamanioControlConstantesFunciones.ID)) {
				this.setMostraridTipoTamanioControl(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTamanioControlConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoTamanioControl(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTamanioControlConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoTamanioControl(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTamanioControlConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoTamanioControl(esAsigna);
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
		
		
		this.setActivaridTipoTamanioControl(esInicial);
		this.setActivarcodigoTipoTamanioControl(esInicial);
		this.setActivarnombreTipoTamanioControl(esInicial);
		this.setActivardescripcionTipoTamanioControl(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTamanioControlConstantesFunciones.ID)) {
				this.setActivaridTipoTamanioControl(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTamanioControlConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoTamanioControl(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTamanioControlConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoTamanioControl(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTamanioControlConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoTamanioControl(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoTamanioControlBeanSwingJInternalFrame tipotamaniocontrolBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoTamanioControl(esInicial);
		this.setResaltarcodigoTipoTamanioControl(esInicial);
		this.setResaltarnombreTipoTamanioControl(esInicial);
		this.setResaltardescripcionTipoTamanioControl(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTamanioControlConstantesFunciones.ID)) {
				this.setResaltaridTipoTamanioControl(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTamanioControlConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoTamanioControl(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTamanioControlConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoTamanioControl(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTamanioControlConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoTamanioControl(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoTamanioControlBeanSwingJInternalFrame tipotamaniocontrolBeanSwingJInternalFrame*/)throws Exception {	
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