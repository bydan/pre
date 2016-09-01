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


import com.bydan.erp.nomina.util.TipoValorVariableNomiConstantesFunciones;
import com.bydan.erp.nomina.util.TipoValorVariableNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoValorVariableNomiParameterGeneral;

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
final public class TipoValorVariableNomiConstantesFunciones extends TipoValorVariableNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoValorVariableNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoValorVariableNomi"+TipoValorVariableNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoValorVariableNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoValorVariableNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoValorVariableNomiConstantesFunciones.SCHEMA+"_"+TipoValorVariableNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoValorVariableNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoValorVariableNomiConstantesFunciones.SCHEMA+"_"+TipoValorVariableNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoValorVariableNomiConstantesFunciones.SCHEMA+"_"+TipoValorVariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoValorVariableNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoValorVariableNomiConstantesFunciones.SCHEMA+"_"+TipoValorVariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoValorVariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoValorVariableNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoValorVariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoValorVariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoValorVariableNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoValorVariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoValorVariableNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoValorVariableNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoValorVariableNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoValorVariableNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Valor Variables";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Valor Variable";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Valor Variable Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoValorVariableNomi";
	public static final String OBJECTNAME="tipovalorvariablenomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_valor_variable_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipovalorvariablenomi from "+TipoValorVariableNomiConstantesFunciones.SPERSISTENCENAME+" tipovalorvariablenomi";
	public static String QUERYSELECTNATIVE="select "+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME+".id,"+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME+".version_row,"+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME+".codigo,"+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME+".nombre from "+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME;//+" as "+TipoValorVariableNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoValorVariableNomiConstantesFuncionesAdditional tipovalorvariablenomiConstantesFuncionesAdditional=null;
	
	public TipoValorVariableNomiConstantesFuncionesAdditional getTipoValorVariableNomiConstantesFuncionesAdditional() {
		return this.tipovalorvariablenomiConstantesFuncionesAdditional;
	}
	
	public void setTipoValorVariableNomiConstantesFuncionesAdditional(TipoValorVariableNomiConstantesFuncionesAdditional tipovalorvariablenomiConstantesFuncionesAdditional) {
		try {
			this.tipovalorvariablenomiConstantesFuncionesAdditional=tipovalorvariablenomiConstantesFuncionesAdditional;
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
	
	public static String getTipoValorVariableNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoValorVariableNomiConstantesFunciones.CODIGO)) {sLabelColumna=TipoValorVariableNomiConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoValorVariableNomiConstantesFunciones.NOMBRE)) {sLabelColumna=TipoValorVariableNomiConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoValorVariableNomiDescripcion(TipoValorVariableNomi tipovalorvariablenomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipovalorvariablenomi !=null/* && tipovalorvariablenomi.getId()!=0*/) {
			sDescripcion=tipovalorvariablenomi.getcodigo();//tipovalorvariablenomitipovalorvariablenomi.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoValorVariableNomiDescripcionDetallado(TipoValorVariableNomi tipovalorvariablenomi) {
		String sDescripcion="";
			
		sDescripcion+=TipoValorVariableNomiConstantesFunciones.ID+"=";
		sDescripcion+=tipovalorvariablenomi.getId().toString()+",";
		sDescripcion+=TipoValorVariableNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipovalorvariablenomi.getVersionRow().toString()+",";
		sDescripcion+=TipoValorVariableNomiConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipovalorvariablenomi.getcodigo()+",";
		sDescripcion+=TipoValorVariableNomiConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipovalorvariablenomi.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoValorVariableNomiDescripcion(TipoValorVariableNomi tipovalorvariablenomi,String sValor) throws Exception {			
		if(tipovalorvariablenomi !=null) {
			tipovalorvariablenomi.setcodigo(sValor);;//tipovalorvariablenomitipovalorvariablenomi.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoValorVariableNomi(TipoValorVariableNomi tipovalorvariablenomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipovalorvariablenomi.setcodigo(tipovalorvariablenomi.getcodigo().trim());
		tipovalorvariablenomi.setnombre(tipovalorvariablenomi.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoValorVariableNomis(List<TipoValorVariableNomi> tipovalorvariablenomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoValorVariableNomi tipovalorvariablenomi: tipovalorvariablenomis) {
			tipovalorvariablenomi.setcodigo(tipovalorvariablenomi.getcodigo().trim());
			tipovalorvariablenomi.setnombre(tipovalorvariablenomi.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoValorVariableNomi(TipoValorVariableNomi tipovalorvariablenomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipovalorvariablenomi.getConCambioAuxiliar()) {
			tipovalorvariablenomi.setIsDeleted(tipovalorvariablenomi.getIsDeletedAuxiliar());	
			tipovalorvariablenomi.setIsNew(tipovalorvariablenomi.getIsNewAuxiliar());	
			tipovalorvariablenomi.setIsChanged(tipovalorvariablenomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipovalorvariablenomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipovalorvariablenomi.setIsDeletedAuxiliar(false);	
			tipovalorvariablenomi.setIsNewAuxiliar(false);	
			tipovalorvariablenomi.setIsChangedAuxiliar(false);
			
			tipovalorvariablenomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoValorVariableNomis(List<TipoValorVariableNomi> tipovalorvariablenomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoValorVariableNomi tipovalorvariablenomi : tipovalorvariablenomis) {
			if(conAsignarBase && tipovalorvariablenomi.getConCambioAuxiliar()) {
				tipovalorvariablenomi.setIsDeleted(tipovalorvariablenomi.getIsDeletedAuxiliar());	
				tipovalorvariablenomi.setIsNew(tipovalorvariablenomi.getIsNewAuxiliar());	
				tipovalorvariablenomi.setIsChanged(tipovalorvariablenomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipovalorvariablenomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipovalorvariablenomi.setIsDeletedAuxiliar(false);	
				tipovalorvariablenomi.setIsNewAuxiliar(false);	
				tipovalorvariablenomi.setIsChangedAuxiliar(false);
				
				tipovalorvariablenomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoValorVariableNomi(TipoValorVariableNomi tipovalorvariablenomi,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoValorVariableNomis(List<TipoValorVariableNomi> tipovalorvariablenomis,Boolean conEnteros) throws Exception  {
		
		for(TipoValorVariableNomi tipovalorvariablenomi: tipovalorvariablenomis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoValorVariableNomi(List<TipoValorVariableNomi> tipovalorvariablenomis,TipoValorVariableNomi tipovalorvariablenomiAux) throws Exception  {
		TipoValorVariableNomiConstantesFunciones.InicializarValoresTipoValorVariableNomi(tipovalorvariablenomiAux,true);
		
		for(TipoValorVariableNomi tipovalorvariablenomi: tipovalorvariablenomis) {
			if(tipovalorvariablenomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoValorVariableNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoValorVariableNomiConstantesFunciones.getArrayColumnasGlobalesTipoValorVariableNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoValorVariableNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoValorVariableNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoValorVariableNomi> tipovalorvariablenomis,TipoValorVariableNomi tipovalorvariablenomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoValorVariableNomi tipovalorvariablenomiAux: tipovalorvariablenomis) {
			if(tipovalorvariablenomiAux!=null && tipovalorvariablenomi!=null) {
				if((tipovalorvariablenomiAux.getId()==null && tipovalorvariablenomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipovalorvariablenomiAux.getId()!=null && tipovalorvariablenomi.getId()!=null){
					if(tipovalorvariablenomiAux.getId().equals(tipovalorvariablenomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoValorVariableNomi(List<TipoValorVariableNomi> tipovalorvariablenomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoValorVariableNomi tipovalorvariablenomi: tipovalorvariablenomis) {			
			if(tipovalorvariablenomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoValorVariableNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoValorVariableNomiConstantesFunciones.LABEL_ID, TipoValorVariableNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoValorVariableNomiConstantesFunciones.LABEL_VERSIONROW, TipoValorVariableNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoValorVariableNomiConstantesFunciones.LABEL_CODIGO, TipoValorVariableNomiConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoValorVariableNomiConstantesFunciones.LABEL_NOMBRE, TipoValorVariableNomiConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoValorVariableNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoValorVariableNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoValorVariableNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoValorVariableNomiConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoValorVariableNomiConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoValorVariableNomi() throws Exception  {
		return TipoValorVariableNomiConstantesFunciones.getTiposSeleccionarTipoValorVariableNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoValorVariableNomi(Boolean conFk) throws Exception  {
		return TipoValorVariableNomiConstantesFunciones.getTiposSeleccionarTipoValorVariableNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoValorVariableNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoValorVariableNomiConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoValorVariableNomiConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoValorVariableNomiConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoValorVariableNomiConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoValorVariableNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoValorVariableNomi(TipoValorVariableNomi tipovalorvariablenomiAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoValorVariableNomi(List<TipoValorVariableNomi> tipovalorvariablenomisTemp) throws Exception {
		for(TipoValorVariableNomi tipovalorvariablenomiAux:tipovalorvariablenomisTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoValorVariableNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoValorVariableNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoValorVariableNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoValorVariableNomiConstantesFunciones.getClassesRelationshipsOfTipoValorVariableNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoValorVariableNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(VariableNomi.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(VariableNomi.class)) {
						classes.add(new Classe(VariableNomi.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoValorVariableNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoValorVariableNomiConstantesFunciones.getClassesRelationshipsFromStringsOfTipoValorVariableNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoValorVariableNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(VariableNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(VariableNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(VariableNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(VariableNomi.class)); continue;
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
	public static void actualizarLista(TipoValorVariableNomi tipovalorvariablenomi,List<TipoValorVariableNomi> tipovalorvariablenomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoValorVariableNomi tipovalorvariablenomiEncontrado=null;
			
			for(TipoValorVariableNomi tipovalorvariablenomiLocal:tipovalorvariablenomis) {
				if(tipovalorvariablenomiLocal.getId().equals(tipovalorvariablenomi.getId())) {
					tipovalorvariablenomiEncontrado=tipovalorvariablenomiLocal;
					
					tipovalorvariablenomiLocal.setIsChanged(tipovalorvariablenomi.getIsChanged());
					tipovalorvariablenomiLocal.setIsNew(tipovalorvariablenomi.getIsNew());
					tipovalorvariablenomiLocal.setIsDeleted(tipovalorvariablenomi.getIsDeleted());
					
					tipovalorvariablenomiLocal.setGeneralEntityOriginal(tipovalorvariablenomi.getGeneralEntityOriginal());
					
					tipovalorvariablenomiLocal.setId(tipovalorvariablenomi.getId());	
					tipovalorvariablenomiLocal.setVersionRow(tipovalorvariablenomi.getVersionRow());	
					tipovalorvariablenomiLocal.setcodigo(tipovalorvariablenomi.getcodigo());	
					tipovalorvariablenomiLocal.setnombre(tipovalorvariablenomi.getnombre());	
					
					
					tipovalorvariablenomiLocal.setVariableNomis(tipovalorvariablenomi.getVariableNomis());
					
					existe=true;
					break;
				}
			}
			
			if(!tipovalorvariablenomi.getIsDeleted()) {
				if(!existe) {
					tipovalorvariablenomis.add(tipovalorvariablenomi);
				}
			} else {
				if(tipovalorvariablenomiEncontrado!=null && permiteQuitar)  {
					tipovalorvariablenomis.remove(tipovalorvariablenomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoValorVariableNomi tipovalorvariablenomi,List<TipoValorVariableNomi> tipovalorvariablenomis) throws Exception {
		try	{			
			for(TipoValorVariableNomi tipovalorvariablenomiLocal:tipovalorvariablenomis) {
				if(tipovalorvariablenomiLocal.getId().equals(tipovalorvariablenomi.getId())) {
					tipovalorvariablenomiLocal.setIsSelected(tipovalorvariablenomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoValorVariableNomi(List<TipoValorVariableNomi> tipovalorvariablenomisAux) throws Exception {
		//this.tipovalorvariablenomisAux=tipovalorvariablenomisAux;
		
		for(TipoValorVariableNomi tipovalorvariablenomiAux:tipovalorvariablenomisAux) {
			if(tipovalorvariablenomiAux.getIsChanged()) {
				tipovalorvariablenomiAux.setIsChanged(false);
			}		
			
			if(tipovalorvariablenomiAux.getIsNew()) {
				tipovalorvariablenomiAux.setIsNew(false);
			}	
			
			if(tipovalorvariablenomiAux.getIsDeleted()) {
				tipovalorvariablenomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoValorVariableNomi(TipoValorVariableNomi tipovalorvariablenomiAux) throws Exception {
		//this.tipovalorvariablenomiAux=tipovalorvariablenomiAux;
		
			if(tipovalorvariablenomiAux.getIsChanged()) {
				tipovalorvariablenomiAux.setIsChanged(false);
			}		
			
			if(tipovalorvariablenomiAux.getIsNew()) {
				tipovalorvariablenomiAux.setIsNew(false);
			}	
			
			if(tipovalorvariablenomiAux.getIsDeleted()) {
				tipovalorvariablenomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoValorVariableNomi tipovalorvariablenomiAsignar,TipoValorVariableNomi tipovalorvariablenomi) throws Exception {
		tipovalorvariablenomiAsignar.setId(tipovalorvariablenomi.getId());	
		tipovalorvariablenomiAsignar.setVersionRow(tipovalorvariablenomi.getVersionRow());	
		tipovalorvariablenomiAsignar.setcodigo(tipovalorvariablenomi.getcodigo());	
		tipovalorvariablenomiAsignar.setnombre(tipovalorvariablenomi.getnombre());	
	}
	
	public static void inicializarTipoValorVariableNomi(TipoValorVariableNomi tipovalorvariablenomi) throws Exception {
		try {
				tipovalorvariablenomi.setId(0L);	
					
				tipovalorvariablenomi.setcodigo("");	
				tipovalorvariablenomi.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoValorVariableNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoValorVariableNomiConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoValorVariableNomiConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoValorVariableNomi(String sTipo,Row row,Workbook workbook,TipoValorVariableNomi tipovalorvariablenomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipovalorvariablenomi.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipovalorvariablenomi.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoValorVariableNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoValorVariableNomi() {
		return this.sFinalQueryTipoValorVariableNomi;
	}
	
	public void setsFinalQueryTipoValorVariableNomi(String sFinalQueryTipoValorVariableNomi) {
		this.sFinalQueryTipoValorVariableNomi= sFinalQueryTipoValorVariableNomi;
	}
	
	public Border resaltarSeleccionarTipoValorVariableNomi=null;
	
	public Border setResaltarSeleccionarTipoValorVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoValorVariableNomiBeanSwingJInternalFrame tipovalorvariablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipovalorvariablenomiBeanSwingJInternalFrame.jTtoolBarTipoValorVariableNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoValorVariableNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoValorVariableNomi() {
		return this.resaltarSeleccionarTipoValorVariableNomi;
	}
	
	public void setResaltarSeleccionarTipoValorVariableNomi(Border borderResaltarSeleccionarTipoValorVariableNomi) {
		this.resaltarSeleccionarTipoValorVariableNomi= borderResaltarSeleccionarTipoValorVariableNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoValorVariableNomi=null;
	public Boolean mostraridTipoValorVariableNomi=true;
	public Boolean activaridTipoValorVariableNomi=true;

	public Border resaltarcodigoTipoValorVariableNomi=null;
	public Boolean mostrarcodigoTipoValorVariableNomi=true;
	public Boolean activarcodigoTipoValorVariableNomi=true;

	public Border resaltarnombreTipoValorVariableNomi=null;
	public Boolean mostrarnombreTipoValorVariableNomi=true;
	public Boolean activarnombreTipoValorVariableNomi=true;

	
	

	public Border setResaltaridTipoValorVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoValorVariableNomiBeanSwingJInternalFrame tipovalorvariablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipovalorvariablenomiBeanSwingJInternalFrame.jTtoolBarTipoValorVariableNomi.setBorder(borderResaltar);
		
		this.resaltaridTipoValorVariableNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoValorVariableNomi() {
		return this.resaltaridTipoValorVariableNomi;
	}

	public void setResaltaridTipoValorVariableNomi(Border borderResaltar) {
		this.resaltaridTipoValorVariableNomi= borderResaltar;
	}

	public Boolean getMostraridTipoValorVariableNomi() {
		return this.mostraridTipoValorVariableNomi;
	}

	public void setMostraridTipoValorVariableNomi(Boolean mostraridTipoValorVariableNomi) {
		this.mostraridTipoValorVariableNomi= mostraridTipoValorVariableNomi;
	}

	public Boolean getActivaridTipoValorVariableNomi() {
		return this.activaridTipoValorVariableNomi;
	}

	public void setActivaridTipoValorVariableNomi(Boolean activaridTipoValorVariableNomi) {
		this.activaridTipoValorVariableNomi= activaridTipoValorVariableNomi;
	}

	public Border setResaltarcodigoTipoValorVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoValorVariableNomiBeanSwingJInternalFrame tipovalorvariablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipovalorvariablenomiBeanSwingJInternalFrame.jTtoolBarTipoValorVariableNomi.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoValorVariableNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoValorVariableNomi() {
		return this.resaltarcodigoTipoValorVariableNomi;
	}

	public void setResaltarcodigoTipoValorVariableNomi(Border borderResaltar) {
		this.resaltarcodigoTipoValorVariableNomi= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoValorVariableNomi() {
		return this.mostrarcodigoTipoValorVariableNomi;
	}

	public void setMostrarcodigoTipoValorVariableNomi(Boolean mostrarcodigoTipoValorVariableNomi) {
		this.mostrarcodigoTipoValorVariableNomi= mostrarcodigoTipoValorVariableNomi;
	}

	public Boolean getActivarcodigoTipoValorVariableNomi() {
		return this.activarcodigoTipoValorVariableNomi;
	}

	public void setActivarcodigoTipoValorVariableNomi(Boolean activarcodigoTipoValorVariableNomi) {
		this.activarcodigoTipoValorVariableNomi= activarcodigoTipoValorVariableNomi;
	}

	public Border setResaltarnombreTipoValorVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoValorVariableNomiBeanSwingJInternalFrame tipovalorvariablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipovalorvariablenomiBeanSwingJInternalFrame.jTtoolBarTipoValorVariableNomi.setBorder(borderResaltar);
		
		this.resaltarnombreTipoValorVariableNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoValorVariableNomi() {
		return this.resaltarnombreTipoValorVariableNomi;
	}

	public void setResaltarnombreTipoValorVariableNomi(Border borderResaltar) {
		this.resaltarnombreTipoValorVariableNomi= borderResaltar;
	}

	public Boolean getMostrarnombreTipoValorVariableNomi() {
		return this.mostrarnombreTipoValorVariableNomi;
	}

	public void setMostrarnombreTipoValorVariableNomi(Boolean mostrarnombreTipoValorVariableNomi) {
		this.mostrarnombreTipoValorVariableNomi= mostrarnombreTipoValorVariableNomi;
	}

	public Boolean getActivarnombreTipoValorVariableNomi() {
		return this.activarnombreTipoValorVariableNomi;
	}

	public void setActivarnombreTipoValorVariableNomi(Boolean activarnombreTipoValorVariableNomi) {
		this.activarnombreTipoValorVariableNomi= activarnombreTipoValorVariableNomi;
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
		
		
		this.setMostraridTipoValorVariableNomi(esInicial);
		this.setMostrarcodigoTipoValorVariableNomi(esInicial);
		this.setMostrarnombreTipoValorVariableNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoValorVariableNomiConstantesFunciones.ID)) {
				this.setMostraridTipoValorVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoValorVariableNomiConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoValorVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoValorVariableNomiConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoValorVariableNomi(esAsigna);
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
		
		
		this.setActivaridTipoValorVariableNomi(esInicial);
		this.setActivarcodigoTipoValorVariableNomi(esInicial);
		this.setActivarnombreTipoValorVariableNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoValorVariableNomiConstantesFunciones.ID)) {
				this.setActivaridTipoValorVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoValorVariableNomiConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoValorVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoValorVariableNomiConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoValorVariableNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoValorVariableNomiBeanSwingJInternalFrame tipovalorvariablenomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoValorVariableNomi(esInicial);
		this.setResaltarcodigoTipoValorVariableNomi(esInicial);
		this.setResaltarnombreTipoValorVariableNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoValorVariableNomiConstantesFunciones.ID)) {
				this.setResaltaridTipoValorVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoValorVariableNomiConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoValorVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoValorVariableNomiConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoValorVariableNomi(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarVariableNomiTipoValorVariableNomi=null;

	public Border getResaltarVariableNomiTipoValorVariableNomi() {
		return this.resaltarVariableNomiTipoValorVariableNomi;
	}

	public void setResaltarVariableNomiTipoValorVariableNomi(Border borderResaltarVariableNomi) {
		if(borderResaltarVariableNomi!=null) {
			this.resaltarVariableNomiTipoValorVariableNomi= borderResaltarVariableNomi;
		}
	}

	public Border setResaltarVariableNomiTipoValorVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoValorVariableNomiBeanSwingJInternalFrame tipovalorvariablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltarVariableNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipovalorvariablenomiBeanSwingJInternalFrame.jTtoolBarTipoValorVariableNomi.setBorder(borderResaltarVariableNomi);
			
		this.resaltarVariableNomiTipoValorVariableNomi= borderResaltarVariableNomi;

		 return borderResaltarVariableNomi;
	}



	public Boolean mostrarVariableNomiTipoValorVariableNomi=true;

	public Boolean getMostrarVariableNomiTipoValorVariableNomi() {
		return this.mostrarVariableNomiTipoValorVariableNomi;
	}

	public void setMostrarVariableNomiTipoValorVariableNomi(Boolean visibilidadResaltarVariableNomi) {
		this.mostrarVariableNomiTipoValorVariableNomi= visibilidadResaltarVariableNomi;
	}



	public Boolean activarVariableNomiTipoValorVariableNomi=true;

	public Boolean gethabilitarResaltarVariableNomiTipoValorVariableNomi() {
		return this.activarVariableNomiTipoValorVariableNomi;
	}

	public void setActivarVariableNomiTipoValorVariableNomi(Boolean habilitarResaltarVariableNomi) {
		this.activarVariableNomiTipoValorVariableNomi= habilitarResaltarVariableNomi;
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

		this.setMostrarVariableNomiTipoValorVariableNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(VariableNomi.class)) {
				this.setMostrarVariableNomiTipoValorVariableNomi(esAsigna);
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

		this.setActivarVariableNomiTipoValorVariableNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(VariableNomi.class)) {
				this.setActivarVariableNomiTipoValorVariableNomi(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoValorVariableNomiBeanSwingJInternalFrame tipovalorvariablenomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarVariableNomiTipoValorVariableNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(VariableNomi.class)) {
				this.setResaltarVariableNomiTipoValorVariableNomi(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}