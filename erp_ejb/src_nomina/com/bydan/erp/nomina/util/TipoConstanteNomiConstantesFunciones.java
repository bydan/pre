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


import com.bydan.erp.nomina.util.TipoConstanteNomiConstantesFunciones;
import com.bydan.erp.nomina.util.TipoConstanteNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoConstanteNomiParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoConstanteNomiConstantesFunciones extends TipoConstanteNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoConstanteNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoConstanteNomi"+TipoConstanteNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoConstanteNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoConstanteNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoConstanteNomiConstantesFunciones.SCHEMA+"_"+TipoConstanteNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoConstanteNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoConstanteNomiConstantesFunciones.SCHEMA+"_"+TipoConstanteNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoConstanteNomiConstantesFunciones.SCHEMA+"_"+TipoConstanteNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoConstanteNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoConstanteNomiConstantesFunciones.SCHEMA+"_"+TipoConstanteNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoConstanteNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoConstanteNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoConstanteNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoConstanteNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoConstanteNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoConstanteNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoConstanteNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoConstanteNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoConstanteNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoConstanteNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Constantes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Constante";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Constante Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoConstanteNomi";
	public static final String OBJECTNAME="tipoconstantenomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_constante_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoconstantenomi from "+TipoConstanteNomiConstantesFunciones.SPERSISTENCENAME+" tipoconstantenomi";
	public static String QUERYSELECTNATIVE="select "+TipoConstanteNomiConstantesFunciones.SCHEMA+"."+TipoConstanteNomiConstantesFunciones.TABLENAME+".id,"+TipoConstanteNomiConstantesFunciones.SCHEMA+"."+TipoConstanteNomiConstantesFunciones.TABLENAME+".version_row,"+TipoConstanteNomiConstantesFunciones.SCHEMA+"."+TipoConstanteNomiConstantesFunciones.TABLENAME+".codigo,"+TipoConstanteNomiConstantesFunciones.SCHEMA+"."+TipoConstanteNomiConstantesFunciones.TABLENAME+".nombre from "+TipoConstanteNomiConstantesFunciones.SCHEMA+"."+TipoConstanteNomiConstantesFunciones.TABLENAME;//+" as "+TipoConstanteNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoConstanteNomiConstantesFuncionesAdditional tipoconstantenomiConstantesFuncionesAdditional=null;
	
	public TipoConstanteNomiConstantesFuncionesAdditional getTipoConstanteNomiConstantesFuncionesAdditional() {
		return this.tipoconstantenomiConstantesFuncionesAdditional;
	}
	
	public void setTipoConstanteNomiConstantesFuncionesAdditional(TipoConstanteNomiConstantesFuncionesAdditional tipoconstantenomiConstantesFuncionesAdditional) {
		try {
			this.tipoconstantenomiConstantesFuncionesAdditional=tipoconstantenomiConstantesFuncionesAdditional;
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
	
	public static String getTipoConstanteNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoConstanteNomiConstantesFunciones.CODIGO)) {sLabelColumna=TipoConstanteNomiConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoConstanteNomiConstantesFunciones.NOMBRE)) {sLabelColumna=TipoConstanteNomiConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoConstanteNomiDescripcion(TipoConstanteNomi tipoconstantenomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoconstantenomi !=null/* && tipoconstantenomi.getId()!=0*/) {
			sDescripcion=tipoconstantenomi.getcodigo();//tipoconstantenomitipoconstantenomi.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoConstanteNomiDescripcionDetallado(TipoConstanteNomi tipoconstantenomi) {
		String sDescripcion="";
			
		sDescripcion+=TipoConstanteNomiConstantesFunciones.ID+"=";
		sDescripcion+=tipoconstantenomi.getId().toString()+",";
		sDescripcion+=TipoConstanteNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoconstantenomi.getVersionRow().toString()+",";
		sDescripcion+=TipoConstanteNomiConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoconstantenomi.getcodigo()+",";
		sDescripcion+=TipoConstanteNomiConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoconstantenomi.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoConstanteNomiDescripcion(TipoConstanteNomi tipoconstantenomi,String sValor) throws Exception {			
		if(tipoconstantenomi !=null) {
			tipoconstantenomi.setcodigo(sValor);;//tipoconstantenomitipoconstantenomi.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoConstanteNomi(TipoConstanteNomi tipoconstantenomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoconstantenomi.setcodigo(tipoconstantenomi.getcodigo().trim());
		tipoconstantenomi.setnombre(tipoconstantenomi.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoConstanteNomis(List<TipoConstanteNomi> tipoconstantenomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoConstanteNomi tipoconstantenomi: tipoconstantenomis) {
			tipoconstantenomi.setcodigo(tipoconstantenomi.getcodigo().trim());
			tipoconstantenomi.setnombre(tipoconstantenomi.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoConstanteNomi(TipoConstanteNomi tipoconstantenomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoconstantenomi.getConCambioAuxiliar()) {
			tipoconstantenomi.setIsDeleted(tipoconstantenomi.getIsDeletedAuxiliar());	
			tipoconstantenomi.setIsNew(tipoconstantenomi.getIsNewAuxiliar());	
			tipoconstantenomi.setIsChanged(tipoconstantenomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoconstantenomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoconstantenomi.setIsDeletedAuxiliar(false);	
			tipoconstantenomi.setIsNewAuxiliar(false);	
			tipoconstantenomi.setIsChangedAuxiliar(false);
			
			tipoconstantenomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoConstanteNomis(List<TipoConstanteNomi> tipoconstantenomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoConstanteNomi tipoconstantenomi : tipoconstantenomis) {
			if(conAsignarBase && tipoconstantenomi.getConCambioAuxiliar()) {
				tipoconstantenomi.setIsDeleted(tipoconstantenomi.getIsDeletedAuxiliar());	
				tipoconstantenomi.setIsNew(tipoconstantenomi.getIsNewAuxiliar());	
				tipoconstantenomi.setIsChanged(tipoconstantenomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoconstantenomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoconstantenomi.setIsDeletedAuxiliar(false);	
				tipoconstantenomi.setIsNewAuxiliar(false);	
				tipoconstantenomi.setIsChangedAuxiliar(false);
				
				tipoconstantenomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoConstanteNomi(TipoConstanteNomi tipoconstantenomi,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoConstanteNomis(List<TipoConstanteNomi> tipoconstantenomis,Boolean conEnteros) throws Exception  {
		
		for(TipoConstanteNomi tipoconstantenomi: tipoconstantenomis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoConstanteNomi(List<TipoConstanteNomi> tipoconstantenomis,TipoConstanteNomi tipoconstantenomiAux) throws Exception  {
		TipoConstanteNomiConstantesFunciones.InicializarValoresTipoConstanteNomi(tipoconstantenomiAux,true);
		
		for(TipoConstanteNomi tipoconstantenomi: tipoconstantenomis) {
			if(tipoconstantenomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoConstanteNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoConstanteNomiConstantesFunciones.getArrayColumnasGlobalesTipoConstanteNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoConstanteNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoConstanteNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoConstanteNomi> tipoconstantenomis,TipoConstanteNomi tipoconstantenomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoConstanteNomi tipoconstantenomiAux: tipoconstantenomis) {
			if(tipoconstantenomiAux!=null && tipoconstantenomi!=null) {
				if((tipoconstantenomiAux.getId()==null && tipoconstantenomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoconstantenomiAux.getId()!=null && tipoconstantenomi.getId()!=null){
					if(tipoconstantenomiAux.getId().equals(tipoconstantenomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoConstanteNomi(List<TipoConstanteNomi> tipoconstantenomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoConstanteNomi tipoconstantenomi: tipoconstantenomis) {			
			if(tipoconstantenomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoConstanteNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoConstanteNomiConstantesFunciones.LABEL_ID, TipoConstanteNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoConstanteNomiConstantesFunciones.LABEL_VERSIONROW, TipoConstanteNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoConstanteNomiConstantesFunciones.LABEL_CODIGO, TipoConstanteNomiConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoConstanteNomiConstantesFunciones.LABEL_NOMBRE, TipoConstanteNomiConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoConstanteNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoConstanteNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoConstanteNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoConstanteNomiConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoConstanteNomiConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoConstanteNomi() throws Exception  {
		return TipoConstanteNomiConstantesFunciones.getTiposSeleccionarTipoConstanteNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoConstanteNomi(Boolean conFk) throws Exception  {
		return TipoConstanteNomiConstantesFunciones.getTiposSeleccionarTipoConstanteNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoConstanteNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoConstanteNomiConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoConstanteNomiConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoConstanteNomiConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoConstanteNomiConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoConstanteNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoConstanteNomi(TipoConstanteNomi tipoconstantenomiAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoConstanteNomi(List<TipoConstanteNomi> tipoconstantenomisTemp) throws Exception {
		for(TipoConstanteNomi tipoconstantenomiAux:tipoconstantenomisTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoConstanteNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoConstanteNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoConstanteNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoConstanteNomiConstantesFunciones.getClassesRelationshipsOfTipoConstanteNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoConstanteNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ConstanteNomi.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ConstanteNomi.class)) {
						classes.add(new Classe(ConstanteNomi.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoConstanteNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoConstanteNomiConstantesFunciones.getClassesRelationshipsFromStringsOfTipoConstanteNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoConstanteNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ConstanteNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ConstanteNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ConstanteNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ConstanteNomi.class)); continue;
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
	public static void actualizarLista(TipoConstanteNomi tipoconstantenomi,List<TipoConstanteNomi> tipoconstantenomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoConstanteNomi tipoconstantenomiEncontrado=null;
			
			for(TipoConstanteNomi tipoconstantenomiLocal:tipoconstantenomis) {
				if(tipoconstantenomiLocal.getId().equals(tipoconstantenomi.getId())) {
					tipoconstantenomiEncontrado=tipoconstantenomiLocal;
					
					tipoconstantenomiLocal.setIsChanged(tipoconstantenomi.getIsChanged());
					tipoconstantenomiLocal.setIsNew(tipoconstantenomi.getIsNew());
					tipoconstantenomiLocal.setIsDeleted(tipoconstantenomi.getIsDeleted());
					
					tipoconstantenomiLocal.setGeneralEntityOriginal(tipoconstantenomi.getGeneralEntityOriginal());
					
					tipoconstantenomiLocal.setId(tipoconstantenomi.getId());	
					tipoconstantenomiLocal.setVersionRow(tipoconstantenomi.getVersionRow());	
					tipoconstantenomiLocal.setcodigo(tipoconstantenomi.getcodigo());	
					tipoconstantenomiLocal.setnombre(tipoconstantenomi.getnombre());	
					
					
					tipoconstantenomiLocal.setConstanteNomis(tipoconstantenomi.getConstanteNomis());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoconstantenomi.getIsDeleted()) {
				if(!existe) {
					tipoconstantenomis.add(tipoconstantenomi);
				}
			} else {
				if(tipoconstantenomiEncontrado!=null && permiteQuitar)  {
					tipoconstantenomis.remove(tipoconstantenomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoConstanteNomi tipoconstantenomi,List<TipoConstanteNomi> tipoconstantenomis) throws Exception {
		try	{			
			for(TipoConstanteNomi tipoconstantenomiLocal:tipoconstantenomis) {
				if(tipoconstantenomiLocal.getId().equals(tipoconstantenomi.getId())) {
					tipoconstantenomiLocal.setIsSelected(tipoconstantenomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoConstanteNomi(List<TipoConstanteNomi> tipoconstantenomisAux) throws Exception {
		//this.tipoconstantenomisAux=tipoconstantenomisAux;
		
		for(TipoConstanteNomi tipoconstantenomiAux:tipoconstantenomisAux) {
			if(tipoconstantenomiAux.getIsChanged()) {
				tipoconstantenomiAux.setIsChanged(false);
			}		
			
			if(tipoconstantenomiAux.getIsNew()) {
				tipoconstantenomiAux.setIsNew(false);
			}	
			
			if(tipoconstantenomiAux.getIsDeleted()) {
				tipoconstantenomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoConstanteNomi(TipoConstanteNomi tipoconstantenomiAux) throws Exception {
		//this.tipoconstantenomiAux=tipoconstantenomiAux;
		
			if(tipoconstantenomiAux.getIsChanged()) {
				tipoconstantenomiAux.setIsChanged(false);
			}		
			
			if(tipoconstantenomiAux.getIsNew()) {
				tipoconstantenomiAux.setIsNew(false);
			}	
			
			if(tipoconstantenomiAux.getIsDeleted()) {
				tipoconstantenomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoConstanteNomi tipoconstantenomiAsignar,TipoConstanteNomi tipoconstantenomi) throws Exception {
		tipoconstantenomiAsignar.setId(tipoconstantenomi.getId());	
		tipoconstantenomiAsignar.setVersionRow(tipoconstantenomi.getVersionRow());	
		tipoconstantenomiAsignar.setcodigo(tipoconstantenomi.getcodigo());	
		tipoconstantenomiAsignar.setnombre(tipoconstantenomi.getnombre());	
	}
	
	public static void inicializarTipoConstanteNomi(TipoConstanteNomi tipoconstantenomi) throws Exception {
		try {
				tipoconstantenomi.setId(0L);	
					
				tipoconstantenomi.setcodigo("");	
				tipoconstantenomi.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoConstanteNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoConstanteNomiConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoConstanteNomiConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoConstanteNomi(String sTipo,Row row,Workbook workbook,TipoConstanteNomi tipoconstantenomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoconstantenomi.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoconstantenomi.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoConstanteNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoConstanteNomi() {
		return this.sFinalQueryTipoConstanteNomi;
	}
	
	public void setsFinalQueryTipoConstanteNomi(String sFinalQueryTipoConstanteNomi) {
		this.sFinalQueryTipoConstanteNomi= sFinalQueryTipoConstanteNomi;
	}
	
	public Border resaltarSeleccionarTipoConstanteNomi=null;
	
	public Border setResaltarSeleccionarTipoConstanteNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConstanteNomiBeanSwingJInternalFrame tipoconstantenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoconstantenomiBeanSwingJInternalFrame.jTtoolBarTipoConstanteNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoConstanteNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoConstanteNomi() {
		return this.resaltarSeleccionarTipoConstanteNomi;
	}
	
	public void setResaltarSeleccionarTipoConstanteNomi(Border borderResaltarSeleccionarTipoConstanteNomi) {
		this.resaltarSeleccionarTipoConstanteNomi= borderResaltarSeleccionarTipoConstanteNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoConstanteNomi=null;
	public Boolean mostraridTipoConstanteNomi=true;
	public Boolean activaridTipoConstanteNomi=true;

	public Border resaltarcodigoTipoConstanteNomi=null;
	public Boolean mostrarcodigoTipoConstanteNomi=true;
	public Boolean activarcodigoTipoConstanteNomi=true;

	public Border resaltarnombreTipoConstanteNomi=null;
	public Boolean mostrarnombreTipoConstanteNomi=true;
	public Boolean activarnombreTipoConstanteNomi=true;

	
	

	public Border setResaltaridTipoConstanteNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConstanteNomiBeanSwingJInternalFrame tipoconstantenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoconstantenomiBeanSwingJInternalFrame.jTtoolBarTipoConstanteNomi.setBorder(borderResaltar);
		
		this.resaltaridTipoConstanteNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoConstanteNomi() {
		return this.resaltaridTipoConstanteNomi;
	}

	public void setResaltaridTipoConstanteNomi(Border borderResaltar) {
		this.resaltaridTipoConstanteNomi= borderResaltar;
	}

	public Boolean getMostraridTipoConstanteNomi() {
		return this.mostraridTipoConstanteNomi;
	}

	public void setMostraridTipoConstanteNomi(Boolean mostraridTipoConstanteNomi) {
		this.mostraridTipoConstanteNomi= mostraridTipoConstanteNomi;
	}

	public Boolean getActivaridTipoConstanteNomi() {
		return this.activaridTipoConstanteNomi;
	}

	public void setActivaridTipoConstanteNomi(Boolean activaridTipoConstanteNomi) {
		this.activaridTipoConstanteNomi= activaridTipoConstanteNomi;
	}

	public Border setResaltarcodigoTipoConstanteNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConstanteNomiBeanSwingJInternalFrame tipoconstantenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoconstantenomiBeanSwingJInternalFrame.jTtoolBarTipoConstanteNomi.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoConstanteNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoConstanteNomi() {
		return this.resaltarcodigoTipoConstanteNomi;
	}

	public void setResaltarcodigoTipoConstanteNomi(Border borderResaltar) {
		this.resaltarcodigoTipoConstanteNomi= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoConstanteNomi() {
		return this.mostrarcodigoTipoConstanteNomi;
	}

	public void setMostrarcodigoTipoConstanteNomi(Boolean mostrarcodigoTipoConstanteNomi) {
		this.mostrarcodigoTipoConstanteNomi= mostrarcodigoTipoConstanteNomi;
	}

	public Boolean getActivarcodigoTipoConstanteNomi() {
		return this.activarcodigoTipoConstanteNomi;
	}

	public void setActivarcodigoTipoConstanteNomi(Boolean activarcodigoTipoConstanteNomi) {
		this.activarcodigoTipoConstanteNomi= activarcodigoTipoConstanteNomi;
	}

	public Border setResaltarnombreTipoConstanteNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConstanteNomiBeanSwingJInternalFrame tipoconstantenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoconstantenomiBeanSwingJInternalFrame.jTtoolBarTipoConstanteNomi.setBorder(borderResaltar);
		
		this.resaltarnombreTipoConstanteNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoConstanteNomi() {
		return this.resaltarnombreTipoConstanteNomi;
	}

	public void setResaltarnombreTipoConstanteNomi(Border borderResaltar) {
		this.resaltarnombreTipoConstanteNomi= borderResaltar;
	}

	public Boolean getMostrarnombreTipoConstanteNomi() {
		return this.mostrarnombreTipoConstanteNomi;
	}

	public void setMostrarnombreTipoConstanteNomi(Boolean mostrarnombreTipoConstanteNomi) {
		this.mostrarnombreTipoConstanteNomi= mostrarnombreTipoConstanteNomi;
	}

	public Boolean getActivarnombreTipoConstanteNomi() {
		return this.activarnombreTipoConstanteNomi;
	}

	public void setActivarnombreTipoConstanteNomi(Boolean activarnombreTipoConstanteNomi) {
		this.activarnombreTipoConstanteNomi= activarnombreTipoConstanteNomi;
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
		
		
		this.setMostraridTipoConstanteNomi(esInicial);
		this.setMostrarcodigoTipoConstanteNomi(esInicial);
		this.setMostrarnombreTipoConstanteNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoConstanteNomiConstantesFunciones.ID)) {
				this.setMostraridTipoConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConstanteNomiConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConstanteNomiConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoConstanteNomi(esAsigna);
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
		
		
		this.setActivaridTipoConstanteNomi(esInicial);
		this.setActivarcodigoTipoConstanteNomi(esInicial);
		this.setActivarnombreTipoConstanteNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoConstanteNomiConstantesFunciones.ID)) {
				this.setActivaridTipoConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConstanteNomiConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConstanteNomiConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoConstanteNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoConstanteNomiBeanSwingJInternalFrame tipoconstantenomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoConstanteNomi(esInicial);
		this.setResaltarcodigoTipoConstanteNomi(esInicial);
		this.setResaltarnombreTipoConstanteNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoConstanteNomiConstantesFunciones.ID)) {
				this.setResaltaridTipoConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConstanteNomiConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoConstanteNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoConstanteNomiConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoConstanteNomi(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarConstanteNomiTipoConstanteNomi=null;

	public Border getResaltarConstanteNomiTipoConstanteNomi() {
		return this.resaltarConstanteNomiTipoConstanteNomi;
	}

	public void setResaltarConstanteNomiTipoConstanteNomi(Border borderResaltarConstanteNomi) {
		if(borderResaltarConstanteNomi!=null) {
			this.resaltarConstanteNomiTipoConstanteNomi= borderResaltarConstanteNomi;
		}
	}

	public Border setResaltarConstanteNomiTipoConstanteNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoConstanteNomiBeanSwingJInternalFrame tipoconstantenomiBeanSwingJInternalFrame*/) {
		Border borderResaltarConstanteNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoconstantenomiBeanSwingJInternalFrame.jTtoolBarTipoConstanteNomi.setBorder(borderResaltarConstanteNomi);
			
		this.resaltarConstanteNomiTipoConstanteNomi= borderResaltarConstanteNomi;

		 return borderResaltarConstanteNomi;
	}



	public Boolean mostrarConstanteNomiTipoConstanteNomi=true;

	public Boolean getMostrarConstanteNomiTipoConstanteNomi() {
		return this.mostrarConstanteNomiTipoConstanteNomi;
	}

	public void setMostrarConstanteNomiTipoConstanteNomi(Boolean visibilidadResaltarConstanteNomi) {
		this.mostrarConstanteNomiTipoConstanteNomi= visibilidadResaltarConstanteNomi;
	}



	public Boolean activarConstanteNomiTipoConstanteNomi=true;

	public Boolean gethabilitarResaltarConstanteNomiTipoConstanteNomi() {
		return this.activarConstanteNomiTipoConstanteNomi;
	}

	public void setActivarConstanteNomiTipoConstanteNomi(Boolean habilitarResaltarConstanteNomi) {
		this.activarConstanteNomiTipoConstanteNomi= habilitarResaltarConstanteNomi;
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

		this.setMostrarConstanteNomiTipoConstanteNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ConstanteNomi.class)) {
				this.setMostrarConstanteNomiTipoConstanteNomi(esAsigna);
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

		this.setActivarConstanteNomiTipoConstanteNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ConstanteNomi.class)) {
				this.setActivarConstanteNomiTipoConstanteNomi(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoConstanteNomiBeanSwingJInternalFrame tipoconstantenomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarConstanteNomiTipoConstanteNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ConstanteNomi.class)) {
				this.setResaltarConstanteNomiTipoConstanteNomi(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}