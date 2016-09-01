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


import com.bydan.erp.nomina.util.TipoNovedadNomiConstantesFunciones;
import com.bydan.erp.nomina.util.TipoNovedadNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoNovedadNomiParameterGeneral;

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
final public class TipoNovedadNomiConstantesFunciones extends TipoNovedadNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoNovedadNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoNovedadNomi"+TipoNovedadNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoNovedadNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoNovedadNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoNovedadNomiConstantesFunciones.SCHEMA+"_"+TipoNovedadNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoNovedadNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoNovedadNomiConstantesFunciones.SCHEMA+"_"+TipoNovedadNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoNovedadNomiConstantesFunciones.SCHEMA+"_"+TipoNovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoNovedadNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoNovedadNomiConstantesFunciones.SCHEMA+"_"+TipoNovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoNovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoNovedadNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoNovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoNovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoNovedadNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoNovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoNovedadNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoNovedadNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoNovedadNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoNovedadNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Novedads";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Novedad";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Novedad Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoNovedadNomi";
	public static final String OBJECTNAME="tiponovedadnomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_novedad_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiponovedadnomi from "+TipoNovedadNomiConstantesFunciones.SPERSISTENCENAME+" tiponovedadnomi";
	public static String QUERYSELECTNATIVE="select "+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME+".id,"+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME+".version_row,"+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME+".codigo,"+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME+".nombre from "+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME;//+" as "+TipoNovedadNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoNovedadNomiConstantesFuncionesAdditional tiponovedadnomiConstantesFuncionesAdditional=null;
	
	public TipoNovedadNomiConstantesFuncionesAdditional getTipoNovedadNomiConstantesFuncionesAdditional() {
		return this.tiponovedadnomiConstantesFuncionesAdditional;
	}
	
	public void setTipoNovedadNomiConstantesFuncionesAdditional(TipoNovedadNomiConstantesFuncionesAdditional tiponovedadnomiConstantesFuncionesAdditional) {
		try {
			this.tiponovedadnomiConstantesFuncionesAdditional=tiponovedadnomiConstantesFuncionesAdditional;
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
	
	public static String getTipoNovedadNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoNovedadNomiConstantesFunciones.CODIGO)) {sLabelColumna=TipoNovedadNomiConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoNovedadNomiConstantesFunciones.NOMBRE)) {sLabelColumna=TipoNovedadNomiConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoNovedadNomiDescripcion(TipoNovedadNomi tiponovedadnomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiponovedadnomi !=null/* && tiponovedadnomi.getId()!=0*/) {
			sDescripcion=tiponovedadnomi.getcodigo();//tiponovedadnomitiponovedadnomi.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoNovedadNomiDescripcionDetallado(TipoNovedadNomi tiponovedadnomi) {
		String sDescripcion="";
			
		sDescripcion+=TipoNovedadNomiConstantesFunciones.ID+"=";
		sDescripcion+=tiponovedadnomi.getId().toString()+",";
		sDescripcion+=TipoNovedadNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiponovedadnomi.getVersionRow().toString()+",";
		sDescripcion+=TipoNovedadNomiConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiponovedadnomi.getcodigo()+",";
		sDescripcion+=TipoNovedadNomiConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiponovedadnomi.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoNovedadNomiDescripcion(TipoNovedadNomi tiponovedadnomi,String sValor) throws Exception {			
		if(tiponovedadnomi !=null) {
			tiponovedadnomi.setcodigo(sValor);;//tiponovedadnomitiponovedadnomi.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoNovedadNomi(TipoNovedadNomi tiponovedadnomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiponovedadnomi.setcodigo(tiponovedadnomi.getcodigo().trim());
		tiponovedadnomi.setnombre(tiponovedadnomi.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoNovedadNomis(List<TipoNovedadNomi> tiponovedadnomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoNovedadNomi tiponovedadnomi: tiponovedadnomis) {
			tiponovedadnomi.setcodigo(tiponovedadnomi.getcodigo().trim());
			tiponovedadnomi.setnombre(tiponovedadnomi.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoNovedadNomi(TipoNovedadNomi tiponovedadnomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiponovedadnomi.getConCambioAuxiliar()) {
			tiponovedadnomi.setIsDeleted(tiponovedadnomi.getIsDeletedAuxiliar());	
			tiponovedadnomi.setIsNew(tiponovedadnomi.getIsNewAuxiliar());	
			tiponovedadnomi.setIsChanged(tiponovedadnomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiponovedadnomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiponovedadnomi.setIsDeletedAuxiliar(false);	
			tiponovedadnomi.setIsNewAuxiliar(false);	
			tiponovedadnomi.setIsChangedAuxiliar(false);
			
			tiponovedadnomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoNovedadNomis(List<TipoNovedadNomi> tiponovedadnomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoNovedadNomi tiponovedadnomi : tiponovedadnomis) {
			if(conAsignarBase && tiponovedadnomi.getConCambioAuxiliar()) {
				tiponovedadnomi.setIsDeleted(tiponovedadnomi.getIsDeletedAuxiliar());	
				tiponovedadnomi.setIsNew(tiponovedadnomi.getIsNewAuxiliar());	
				tiponovedadnomi.setIsChanged(tiponovedadnomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiponovedadnomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiponovedadnomi.setIsDeletedAuxiliar(false);	
				tiponovedadnomi.setIsNewAuxiliar(false);	
				tiponovedadnomi.setIsChangedAuxiliar(false);
				
				tiponovedadnomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoNovedadNomi(TipoNovedadNomi tiponovedadnomi,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoNovedadNomis(List<TipoNovedadNomi> tiponovedadnomis,Boolean conEnteros) throws Exception  {
		
		for(TipoNovedadNomi tiponovedadnomi: tiponovedadnomis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoNovedadNomi(List<TipoNovedadNomi> tiponovedadnomis,TipoNovedadNomi tiponovedadnomiAux) throws Exception  {
		TipoNovedadNomiConstantesFunciones.InicializarValoresTipoNovedadNomi(tiponovedadnomiAux,true);
		
		for(TipoNovedadNomi tiponovedadnomi: tiponovedadnomis) {
			if(tiponovedadnomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoNovedadNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoNovedadNomiConstantesFunciones.getArrayColumnasGlobalesTipoNovedadNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoNovedadNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoNovedadNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoNovedadNomi> tiponovedadnomis,TipoNovedadNomi tiponovedadnomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoNovedadNomi tiponovedadnomiAux: tiponovedadnomis) {
			if(tiponovedadnomiAux!=null && tiponovedadnomi!=null) {
				if((tiponovedadnomiAux.getId()==null && tiponovedadnomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiponovedadnomiAux.getId()!=null && tiponovedadnomi.getId()!=null){
					if(tiponovedadnomiAux.getId().equals(tiponovedadnomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoNovedadNomi(List<TipoNovedadNomi> tiponovedadnomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoNovedadNomi tiponovedadnomi: tiponovedadnomis) {			
			if(tiponovedadnomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoNovedadNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoNovedadNomiConstantesFunciones.LABEL_ID, TipoNovedadNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoNovedadNomiConstantesFunciones.LABEL_VERSIONROW, TipoNovedadNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoNovedadNomiConstantesFunciones.LABEL_CODIGO, TipoNovedadNomiConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoNovedadNomiConstantesFunciones.LABEL_NOMBRE, TipoNovedadNomiConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoNovedadNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoNovedadNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoNovedadNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoNovedadNomiConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoNovedadNomiConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoNovedadNomi() throws Exception  {
		return TipoNovedadNomiConstantesFunciones.getTiposSeleccionarTipoNovedadNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoNovedadNomi(Boolean conFk) throws Exception  {
		return TipoNovedadNomiConstantesFunciones.getTiposSeleccionarTipoNovedadNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoNovedadNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoNovedadNomiConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoNovedadNomiConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoNovedadNomiConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoNovedadNomiConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoNovedadNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoNovedadNomi(TipoNovedadNomi tiponovedadnomiAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoNovedadNomi(List<TipoNovedadNomi> tiponovedadnomisTemp) throws Exception {
		for(TipoNovedadNomi tiponovedadnomiAux:tiponovedadnomisTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoNovedadNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoNovedadNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoNovedadNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoNovedadNomiConstantesFunciones.getClassesRelationshipsOfTipoNovedadNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoNovedadNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoNovedadNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoNovedadNomiConstantesFunciones.getClassesRelationshipsFromStringsOfTipoNovedadNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoNovedadNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoNovedadNomi tiponovedadnomi,List<TipoNovedadNomi> tiponovedadnomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoNovedadNomi tiponovedadnomiEncontrado=null;
			
			for(TipoNovedadNomi tiponovedadnomiLocal:tiponovedadnomis) {
				if(tiponovedadnomiLocal.getId().equals(tiponovedadnomi.getId())) {
					tiponovedadnomiEncontrado=tiponovedadnomiLocal;
					
					tiponovedadnomiLocal.setIsChanged(tiponovedadnomi.getIsChanged());
					tiponovedadnomiLocal.setIsNew(tiponovedadnomi.getIsNew());
					tiponovedadnomiLocal.setIsDeleted(tiponovedadnomi.getIsDeleted());
					
					tiponovedadnomiLocal.setGeneralEntityOriginal(tiponovedadnomi.getGeneralEntityOriginal());
					
					tiponovedadnomiLocal.setId(tiponovedadnomi.getId());	
					tiponovedadnomiLocal.setVersionRow(tiponovedadnomi.getVersionRow());	
					tiponovedadnomiLocal.setcodigo(tiponovedadnomi.getcodigo());	
					tiponovedadnomiLocal.setnombre(tiponovedadnomi.getnombre());	
					
					
					tiponovedadnomiLocal.setNovedadNomis(tiponovedadnomi.getNovedadNomis());
					
					existe=true;
					break;
				}
			}
			
			if(!tiponovedadnomi.getIsDeleted()) {
				if(!existe) {
					tiponovedadnomis.add(tiponovedadnomi);
				}
			} else {
				if(tiponovedadnomiEncontrado!=null && permiteQuitar)  {
					tiponovedadnomis.remove(tiponovedadnomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoNovedadNomi tiponovedadnomi,List<TipoNovedadNomi> tiponovedadnomis) throws Exception {
		try	{			
			for(TipoNovedadNomi tiponovedadnomiLocal:tiponovedadnomis) {
				if(tiponovedadnomiLocal.getId().equals(tiponovedadnomi.getId())) {
					tiponovedadnomiLocal.setIsSelected(tiponovedadnomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoNovedadNomi(List<TipoNovedadNomi> tiponovedadnomisAux) throws Exception {
		//this.tiponovedadnomisAux=tiponovedadnomisAux;
		
		for(TipoNovedadNomi tiponovedadnomiAux:tiponovedadnomisAux) {
			if(tiponovedadnomiAux.getIsChanged()) {
				tiponovedadnomiAux.setIsChanged(false);
			}		
			
			if(tiponovedadnomiAux.getIsNew()) {
				tiponovedadnomiAux.setIsNew(false);
			}	
			
			if(tiponovedadnomiAux.getIsDeleted()) {
				tiponovedadnomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoNovedadNomi(TipoNovedadNomi tiponovedadnomiAux) throws Exception {
		//this.tiponovedadnomiAux=tiponovedadnomiAux;
		
			if(tiponovedadnomiAux.getIsChanged()) {
				tiponovedadnomiAux.setIsChanged(false);
			}		
			
			if(tiponovedadnomiAux.getIsNew()) {
				tiponovedadnomiAux.setIsNew(false);
			}	
			
			if(tiponovedadnomiAux.getIsDeleted()) {
				tiponovedadnomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoNovedadNomi tiponovedadnomiAsignar,TipoNovedadNomi tiponovedadnomi) throws Exception {
		tiponovedadnomiAsignar.setId(tiponovedadnomi.getId());	
		tiponovedadnomiAsignar.setVersionRow(tiponovedadnomi.getVersionRow());	
		tiponovedadnomiAsignar.setcodigo(tiponovedadnomi.getcodigo());	
		tiponovedadnomiAsignar.setnombre(tiponovedadnomi.getnombre());	
	}
	
	public static void inicializarTipoNovedadNomi(TipoNovedadNomi tiponovedadnomi) throws Exception {
		try {
				tiponovedadnomi.setId(0L);	
					
				tiponovedadnomi.setcodigo("");	
				tiponovedadnomi.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoNovedadNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoNovedadNomiConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoNovedadNomiConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoNovedadNomi(String sTipo,Row row,Workbook workbook,TipoNovedadNomi tiponovedadnomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiponovedadnomi.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiponovedadnomi.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoNovedadNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoNovedadNomi() {
		return this.sFinalQueryTipoNovedadNomi;
	}
	
	public void setsFinalQueryTipoNovedadNomi(String sFinalQueryTipoNovedadNomi) {
		this.sFinalQueryTipoNovedadNomi= sFinalQueryTipoNovedadNomi;
	}
	
	public Border resaltarSeleccionarTipoNovedadNomi=null;
	
	public Border setResaltarSeleccionarTipoNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNovedadNomiBeanSwingJInternalFrame tiponovedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiponovedadnomiBeanSwingJInternalFrame.jTtoolBarTipoNovedadNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoNovedadNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoNovedadNomi() {
		return this.resaltarSeleccionarTipoNovedadNomi;
	}
	
	public void setResaltarSeleccionarTipoNovedadNomi(Border borderResaltarSeleccionarTipoNovedadNomi) {
		this.resaltarSeleccionarTipoNovedadNomi= borderResaltarSeleccionarTipoNovedadNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoNovedadNomi=null;
	public Boolean mostraridTipoNovedadNomi=true;
	public Boolean activaridTipoNovedadNomi=true;

	public Border resaltarcodigoTipoNovedadNomi=null;
	public Boolean mostrarcodigoTipoNovedadNomi=true;
	public Boolean activarcodigoTipoNovedadNomi=true;

	public Border resaltarnombreTipoNovedadNomi=null;
	public Boolean mostrarnombreTipoNovedadNomi=true;
	public Boolean activarnombreTipoNovedadNomi=true;

	
	

	public Border setResaltaridTipoNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNovedadNomiBeanSwingJInternalFrame tiponovedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiponovedadnomiBeanSwingJInternalFrame.jTtoolBarTipoNovedadNomi.setBorder(borderResaltar);
		
		this.resaltaridTipoNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoNovedadNomi() {
		return this.resaltaridTipoNovedadNomi;
	}

	public void setResaltaridTipoNovedadNomi(Border borderResaltar) {
		this.resaltaridTipoNovedadNomi= borderResaltar;
	}

	public Boolean getMostraridTipoNovedadNomi() {
		return this.mostraridTipoNovedadNomi;
	}

	public void setMostraridTipoNovedadNomi(Boolean mostraridTipoNovedadNomi) {
		this.mostraridTipoNovedadNomi= mostraridTipoNovedadNomi;
	}

	public Boolean getActivaridTipoNovedadNomi() {
		return this.activaridTipoNovedadNomi;
	}

	public void setActivaridTipoNovedadNomi(Boolean activaridTipoNovedadNomi) {
		this.activaridTipoNovedadNomi= activaridTipoNovedadNomi;
	}

	public Border setResaltarcodigoTipoNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNovedadNomiBeanSwingJInternalFrame tiponovedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiponovedadnomiBeanSwingJInternalFrame.jTtoolBarTipoNovedadNomi.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoNovedadNomi() {
		return this.resaltarcodigoTipoNovedadNomi;
	}

	public void setResaltarcodigoTipoNovedadNomi(Border borderResaltar) {
		this.resaltarcodigoTipoNovedadNomi= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoNovedadNomi() {
		return this.mostrarcodigoTipoNovedadNomi;
	}

	public void setMostrarcodigoTipoNovedadNomi(Boolean mostrarcodigoTipoNovedadNomi) {
		this.mostrarcodigoTipoNovedadNomi= mostrarcodigoTipoNovedadNomi;
	}

	public Boolean getActivarcodigoTipoNovedadNomi() {
		return this.activarcodigoTipoNovedadNomi;
	}

	public void setActivarcodigoTipoNovedadNomi(Boolean activarcodigoTipoNovedadNomi) {
		this.activarcodigoTipoNovedadNomi= activarcodigoTipoNovedadNomi;
	}

	public Border setResaltarnombreTipoNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNovedadNomiBeanSwingJInternalFrame tiponovedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiponovedadnomiBeanSwingJInternalFrame.jTtoolBarTipoNovedadNomi.setBorder(borderResaltar);
		
		this.resaltarnombreTipoNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoNovedadNomi() {
		return this.resaltarnombreTipoNovedadNomi;
	}

	public void setResaltarnombreTipoNovedadNomi(Border borderResaltar) {
		this.resaltarnombreTipoNovedadNomi= borderResaltar;
	}

	public Boolean getMostrarnombreTipoNovedadNomi() {
		return this.mostrarnombreTipoNovedadNomi;
	}

	public void setMostrarnombreTipoNovedadNomi(Boolean mostrarnombreTipoNovedadNomi) {
		this.mostrarnombreTipoNovedadNomi= mostrarnombreTipoNovedadNomi;
	}

	public Boolean getActivarnombreTipoNovedadNomi() {
		return this.activarnombreTipoNovedadNomi;
	}

	public void setActivarnombreTipoNovedadNomi(Boolean activarnombreTipoNovedadNomi) {
		this.activarnombreTipoNovedadNomi= activarnombreTipoNovedadNomi;
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
		
		
		this.setMostraridTipoNovedadNomi(esInicial);
		this.setMostrarcodigoTipoNovedadNomi(esInicial);
		this.setMostrarnombreTipoNovedadNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoNovedadNomiConstantesFunciones.ID)) {
				this.setMostraridTipoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNovedadNomiConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNovedadNomiConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoNovedadNomi(esAsigna);
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
		
		
		this.setActivaridTipoNovedadNomi(esInicial);
		this.setActivarcodigoTipoNovedadNomi(esInicial);
		this.setActivarnombreTipoNovedadNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoNovedadNomiConstantesFunciones.ID)) {
				this.setActivaridTipoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNovedadNomiConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNovedadNomiConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoNovedadNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoNovedadNomiBeanSwingJInternalFrame tiponovedadnomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoNovedadNomi(esInicial);
		this.setResaltarcodigoTipoNovedadNomi(esInicial);
		this.setResaltarnombreTipoNovedadNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoNovedadNomiConstantesFunciones.ID)) {
				this.setResaltaridTipoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNovedadNomiConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNovedadNomiConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoNovedadNomi(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarNovedadNomiTipoNovedadNomi=null;

	public Border getResaltarNovedadNomiTipoNovedadNomi() {
		return this.resaltarNovedadNomiTipoNovedadNomi;
	}

	public void setResaltarNovedadNomiTipoNovedadNomi(Border borderResaltarNovedadNomi) {
		if(borderResaltarNovedadNomi!=null) {
			this.resaltarNovedadNomiTipoNovedadNomi= borderResaltarNovedadNomi;
		}
	}

	public Border setResaltarNovedadNomiTipoNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNovedadNomiBeanSwingJInternalFrame tiponovedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltarNovedadNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiponovedadnomiBeanSwingJInternalFrame.jTtoolBarTipoNovedadNomi.setBorder(borderResaltarNovedadNomi);
			
		this.resaltarNovedadNomiTipoNovedadNomi= borderResaltarNovedadNomi;

		 return borderResaltarNovedadNomi;
	}



	public Boolean mostrarNovedadNomiTipoNovedadNomi=true;

	public Boolean getMostrarNovedadNomiTipoNovedadNomi() {
		return this.mostrarNovedadNomiTipoNovedadNomi;
	}

	public void setMostrarNovedadNomiTipoNovedadNomi(Boolean visibilidadResaltarNovedadNomi) {
		this.mostrarNovedadNomiTipoNovedadNomi= visibilidadResaltarNovedadNomi;
	}



	public Boolean activarNovedadNomiTipoNovedadNomi=true;

	public Boolean gethabilitarResaltarNovedadNomiTipoNovedadNomi() {
		return this.activarNovedadNomiTipoNovedadNomi;
	}

	public void setActivarNovedadNomiTipoNovedadNomi(Boolean habilitarResaltarNovedadNomi) {
		this.activarNovedadNomiTipoNovedadNomi= habilitarResaltarNovedadNomi;
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

		this.setMostrarNovedadNomiTipoNovedadNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NovedadNomi.class)) {
				this.setMostrarNovedadNomiTipoNovedadNomi(esAsigna);
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

		this.setActivarNovedadNomiTipoNovedadNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NovedadNomi.class)) {
				this.setActivarNovedadNomiTipoNovedadNomi(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoNovedadNomiBeanSwingJInternalFrame tiponovedadnomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarNovedadNomiTipoNovedadNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(NovedadNomi.class)) {
				this.setResaltarNovedadNomiTipoNovedadNomi(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}