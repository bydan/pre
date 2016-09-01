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
package com.bydan.erp.produccion.util;

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


import com.bydan.erp.produccion.util.TipoMermaConstantesFunciones;
import com.bydan.erp.produccion.util.TipoMermaParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoMermaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoMermaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoMerma";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoMerma"+TipoMermaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoMermaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoMermaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoMermaConstantesFunciones.SCHEMA+"_"+TipoMermaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoMermaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoMermaConstantesFunciones.SCHEMA+"_"+TipoMermaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoMermaConstantesFunciones.SCHEMA+"_"+TipoMermaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoMermaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoMermaConstantesFunciones.SCHEMA+"_"+TipoMermaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMermaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMermaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMermaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMermaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMermaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMermaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoMermaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoMermaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoMermaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoMermaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Mermas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Merma";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Merma";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoMerma";
	public static final String OBJECTNAME="tipomerma";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="tipo_merma";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipomerma from "+TipoMermaConstantesFunciones.SPERSISTENCENAME+" tipomerma";
	public static String QUERYSELECTNATIVE="select "+TipoMermaConstantesFunciones.SCHEMA+"."+TipoMermaConstantesFunciones.TABLENAME+".id,"+TipoMermaConstantesFunciones.SCHEMA+"."+TipoMermaConstantesFunciones.TABLENAME+".version_row,"+TipoMermaConstantesFunciones.SCHEMA+"."+TipoMermaConstantesFunciones.TABLENAME+".id_pais,"+TipoMermaConstantesFunciones.SCHEMA+"."+TipoMermaConstantesFunciones.TABLENAME+".nombre,"+TipoMermaConstantesFunciones.SCHEMA+"."+TipoMermaConstantesFunciones.TABLENAME+".descripcion from "+TipoMermaConstantesFunciones.SCHEMA+"."+TipoMermaConstantesFunciones.TABLENAME;//+" as "+TipoMermaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPAIS= "id_pais";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoMermaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoMermaConstantesFunciones.IDPAIS)) {sLabelColumna=TipoMermaConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(TipoMermaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoMermaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoMermaConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoMermaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoMermaDescripcion(TipoMerma tipomerma) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipomerma !=null/* && tipomerma.getId()!=0*/) {
			sDescripcion=tipomerma.getnombre();//tipomermatipomerma.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoMermaDescripcionDetallado(TipoMerma tipomerma) {
		String sDescripcion="";
			
		sDescripcion+=TipoMermaConstantesFunciones.ID+"=";
		sDescripcion+=tipomerma.getId().toString()+",";
		sDescripcion+=TipoMermaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipomerma.getVersionRow().toString()+",";
		sDescripcion+=TipoMermaConstantesFunciones.IDPAIS+"=";
		sDescripcion+=tipomerma.getid_pais().toString()+",";
		sDescripcion+=TipoMermaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipomerma.getnombre()+",";
		sDescripcion+=TipoMermaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipomerma.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoMermaDescripcion(TipoMerma tipomerma,String sValor) throws Exception {			
		if(tipomerma !=null) {
			tipomerma.setnombre(sValor);;//tipomermatipomerma.getnombre().trim();
		}		
	}
	
		

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoMerma(TipoMerma tipomerma,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipomerma.setnombre(tipomerma.getnombre().trim());
		tipomerma.setdescripcion(tipomerma.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoMermas(List<TipoMerma> tipomermas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoMerma tipomerma: tipomermas) {
			tipomerma.setnombre(tipomerma.getnombre().trim());
			tipomerma.setdescripcion(tipomerma.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMerma(TipoMerma tipomerma,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipomerma.getConCambioAuxiliar()) {
			tipomerma.setIsDeleted(tipomerma.getIsDeletedAuxiliar());	
			tipomerma.setIsNew(tipomerma.getIsNewAuxiliar());	
			tipomerma.setIsChanged(tipomerma.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipomerma.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipomerma.setIsDeletedAuxiliar(false);	
			tipomerma.setIsNewAuxiliar(false);	
			tipomerma.setIsChangedAuxiliar(false);
			
			tipomerma.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMermas(List<TipoMerma> tipomermas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoMerma tipomerma : tipomermas) {
			if(conAsignarBase && tipomerma.getConCambioAuxiliar()) {
				tipomerma.setIsDeleted(tipomerma.getIsDeletedAuxiliar());	
				tipomerma.setIsNew(tipomerma.getIsNewAuxiliar());	
				tipomerma.setIsChanged(tipomerma.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipomerma.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipomerma.setIsDeletedAuxiliar(false);	
				tipomerma.setIsNewAuxiliar(false);	
				tipomerma.setIsChangedAuxiliar(false);
				
				tipomerma.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoMerma(TipoMerma tipomerma,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoMermas(List<TipoMerma> tipomermas,Boolean conEnteros) throws Exception  {
		
		for(TipoMerma tipomerma: tipomermas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoMerma(List<TipoMerma> tipomermas,TipoMerma tipomermaAux) throws Exception  {
		TipoMermaConstantesFunciones.InicializarValoresTipoMerma(tipomermaAux,true);
		
		for(TipoMerma tipomerma: tipomermas) {
			if(tipomerma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMerma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoMermaConstantesFunciones.getArrayColumnasGlobalesTipoMerma(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMerma(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoMerma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoMerma> tipomermas,TipoMerma tipomerma,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoMerma tipomermaAux: tipomermas) {
			if(tipomermaAux!=null && tipomerma!=null) {
				if((tipomermaAux.getId()==null && tipomerma.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipomermaAux.getId()!=null && tipomerma.getId()!=null){
					if(tipomermaAux.getId().equals(tipomerma.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoMerma(List<TipoMerma> tipomermas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoMerma tipomerma: tipomermas) {			
			if(tipomerma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoMerma() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoMermaConstantesFunciones.LABEL_ID, TipoMermaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMermaConstantesFunciones.LABEL_VERSIONROW, TipoMermaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMermaConstantesFunciones.LABEL_IDPAIS, TipoMermaConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMermaConstantesFunciones.LABEL_NOMBRE, TipoMermaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMermaConstantesFunciones.LABEL_DESCRIPCION, TipoMermaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoMerma() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoMermaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMermaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMermaConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMermaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMermaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMerma() throws Exception  {
		return TipoMermaConstantesFunciones.getTiposSeleccionarTipoMerma(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMerma(Boolean conFk) throws Exception  {
		return TipoMermaConstantesFunciones.getTiposSeleccionarTipoMerma(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMerma(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMermaConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(TipoMermaConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMermaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoMermaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMermaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoMermaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoMerma(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMerma(TipoMerma tipomermaAux) throws Exception {
		
			tipomermaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipomermaAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMerma(List<TipoMerma> tipomermasTemp) throws Exception {
		for(TipoMerma tipomermaAux:tipomermasTemp) {
			
			tipomermaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipomermaAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoMerma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Pais.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoMerma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMerma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMermaConstantesFunciones.getClassesRelationshipsOfTipoMerma(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMerma(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMerma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMermaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoMerma(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMerma(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoMerma tipomerma,List<TipoMerma> tipomermas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoMerma tipomermaEncontrado=null;
			
			for(TipoMerma tipomermaLocal:tipomermas) {
				if(tipomermaLocal.getId().equals(tipomerma.getId())) {
					tipomermaEncontrado=tipomermaLocal;
					
					tipomermaLocal.setIsChanged(tipomerma.getIsChanged());
					tipomermaLocal.setIsNew(tipomerma.getIsNew());
					tipomermaLocal.setIsDeleted(tipomerma.getIsDeleted());
					
					tipomermaLocal.setGeneralEntityOriginal(tipomerma.getGeneralEntityOriginal());
					
					tipomermaLocal.setId(tipomerma.getId());	
					tipomermaLocal.setVersionRow(tipomerma.getVersionRow());	
					tipomermaLocal.setid_pais(tipomerma.getid_pais());	
					tipomermaLocal.setnombre(tipomerma.getnombre());	
					tipomermaLocal.setdescripcion(tipomerma.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipomerma.getIsDeleted()) {
				if(!existe) {
					tipomermas.add(tipomerma);
				}
			} else {
				if(tipomermaEncontrado!=null && permiteQuitar)  {
					tipomermas.remove(tipomermaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoMerma tipomerma,List<TipoMerma> tipomermas) throws Exception {
		try	{			
			for(TipoMerma tipomermaLocal:tipomermas) {
				if(tipomermaLocal.getId().equals(tipomerma.getId())) {
					tipomermaLocal.setIsSelected(tipomerma.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoMerma(List<TipoMerma> tipomermasAux) throws Exception {
		//this.tipomermasAux=tipomermasAux;
		
		for(TipoMerma tipomermaAux:tipomermasAux) {
			if(tipomermaAux.getIsChanged()) {
				tipomermaAux.setIsChanged(false);
			}		
			
			if(tipomermaAux.getIsNew()) {
				tipomermaAux.setIsNew(false);
			}	
			
			if(tipomermaAux.getIsDeleted()) {
				tipomermaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoMerma(TipoMerma tipomermaAux) throws Exception {
		//this.tipomermaAux=tipomermaAux;
		
			if(tipomermaAux.getIsChanged()) {
				tipomermaAux.setIsChanged(false);
			}		
			
			if(tipomermaAux.getIsNew()) {
				tipomermaAux.setIsNew(false);
			}	
			
			if(tipomermaAux.getIsDeleted()) {
				tipomermaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoMerma tipomermaAsignar,TipoMerma tipomerma) throws Exception {
		tipomermaAsignar.setId(tipomerma.getId());	
		tipomermaAsignar.setVersionRow(tipomerma.getVersionRow());	
		tipomermaAsignar.setid_pais(tipomerma.getid_pais());
		tipomermaAsignar.setpais_descripcion(tipomerma.getpais_descripcion());	
		tipomermaAsignar.setnombre(tipomerma.getnombre());	
		tipomermaAsignar.setdescripcion(tipomerma.getdescripcion());	
	}
	
	public static void inicializarTipoMerma(TipoMerma tipomerma) throws Exception {
		try {
				tipomerma.setId(0L);	
					
				tipomerma.setid_pais(-1L);	
				tipomerma.setnombre("");	
				tipomerma.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoMerma(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMermaConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMermaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMermaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoMerma(String sTipo,Row row,Workbook workbook,TipoMerma tipomerma,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomerma.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomerma.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomerma.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoMerma=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoMerma() {
		return this.sFinalQueryTipoMerma;
	}
	
	public void setsFinalQueryTipoMerma(String sFinalQueryTipoMerma) {
		this.sFinalQueryTipoMerma= sFinalQueryTipoMerma;
	}
	
	public Border resaltarSeleccionarTipoMerma=null;
	
	public Border setResaltarSeleccionarTipoMerma(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMermaBeanSwingJInternalFrame tipomermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipomermaBeanSwingJInternalFrame.jTtoolBarTipoMerma.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoMerma= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoMerma() {
		return this.resaltarSeleccionarTipoMerma;
	}
	
	public void setResaltarSeleccionarTipoMerma(Border borderResaltarSeleccionarTipoMerma) {
		this.resaltarSeleccionarTipoMerma= borderResaltarSeleccionarTipoMerma;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoMerma=null;
	public Boolean mostraridTipoMerma=true;
	public Boolean activaridTipoMerma=true;

	public Border resaltarid_paisTipoMerma=null;
	public Boolean mostrarid_paisTipoMerma=true;
	public Boolean activarid_paisTipoMerma=true;
	public Boolean cargarid_paisTipoMerma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisTipoMerma=false;//ConEventDepend=true

	public Border resaltarnombreTipoMerma=null;
	public Boolean mostrarnombreTipoMerma=true;
	public Boolean activarnombreTipoMerma=true;

	public Border resaltardescripcionTipoMerma=null;
	public Boolean mostrardescripcionTipoMerma=true;
	public Boolean activardescripcionTipoMerma=true;

	
	

	public Border setResaltaridTipoMerma(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMermaBeanSwingJInternalFrame tipomermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomermaBeanSwingJInternalFrame.jTtoolBarTipoMerma.setBorder(borderResaltar);
		
		this.resaltaridTipoMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoMerma() {
		return this.resaltaridTipoMerma;
	}

	public void setResaltaridTipoMerma(Border borderResaltar) {
		this.resaltaridTipoMerma= borderResaltar;
	}

	public Boolean getMostraridTipoMerma() {
		return this.mostraridTipoMerma;
	}

	public void setMostraridTipoMerma(Boolean mostraridTipoMerma) {
		this.mostraridTipoMerma= mostraridTipoMerma;
	}

	public Boolean getActivaridTipoMerma() {
		return this.activaridTipoMerma;
	}

	public void setActivaridTipoMerma(Boolean activaridTipoMerma) {
		this.activaridTipoMerma= activaridTipoMerma;
	}

	public Border setResaltarid_paisTipoMerma(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMermaBeanSwingJInternalFrame tipomermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomermaBeanSwingJInternalFrame.jTtoolBarTipoMerma.setBorder(borderResaltar);
		
		this.resaltarid_paisTipoMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisTipoMerma() {
		return this.resaltarid_paisTipoMerma;
	}

	public void setResaltarid_paisTipoMerma(Border borderResaltar) {
		this.resaltarid_paisTipoMerma= borderResaltar;
	}

	public Boolean getMostrarid_paisTipoMerma() {
		return this.mostrarid_paisTipoMerma;
	}

	public void setMostrarid_paisTipoMerma(Boolean mostrarid_paisTipoMerma) {
		this.mostrarid_paisTipoMerma= mostrarid_paisTipoMerma;
	}

	public Boolean getActivarid_paisTipoMerma() {
		return this.activarid_paisTipoMerma;
	}

	public void setActivarid_paisTipoMerma(Boolean activarid_paisTipoMerma) {
		this.activarid_paisTipoMerma= activarid_paisTipoMerma;
	}

	public Boolean getCargarid_paisTipoMerma() {
		return this.cargarid_paisTipoMerma;
	}

	public void setCargarid_paisTipoMerma(Boolean cargarid_paisTipoMerma) {
		this.cargarid_paisTipoMerma= cargarid_paisTipoMerma;
	}

	public Border setResaltarnombreTipoMerma(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMermaBeanSwingJInternalFrame tipomermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomermaBeanSwingJInternalFrame.jTtoolBarTipoMerma.setBorder(borderResaltar);
		
		this.resaltarnombreTipoMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoMerma() {
		return this.resaltarnombreTipoMerma;
	}

	public void setResaltarnombreTipoMerma(Border borderResaltar) {
		this.resaltarnombreTipoMerma= borderResaltar;
	}

	public Boolean getMostrarnombreTipoMerma() {
		return this.mostrarnombreTipoMerma;
	}

	public void setMostrarnombreTipoMerma(Boolean mostrarnombreTipoMerma) {
		this.mostrarnombreTipoMerma= mostrarnombreTipoMerma;
	}

	public Boolean getActivarnombreTipoMerma() {
		return this.activarnombreTipoMerma;
	}

	public void setActivarnombreTipoMerma(Boolean activarnombreTipoMerma) {
		this.activarnombreTipoMerma= activarnombreTipoMerma;
	}

	public Border setResaltardescripcionTipoMerma(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMermaBeanSwingJInternalFrame tipomermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomermaBeanSwingJInternalFrame.jTtoolBarTipoMerma.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoMerma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoMerma() {
		return this.resaltardescripcionTipoMerma;
	}

	public void setResaltardescripcionTipoMerma(Border borderResaltar) {
		this.resaltardescripcionTipoMerma= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoMerma() {
		return this.mostrardescripcionTipoMerma;
	}

	public void setMostrardescripcionTipoMerma(Boolean mostrardescripcionTipoMerma) {
		this.mostrardescripcionTipoMerma= mostrardescripcionTipoMerma;
	}

	public Boolean getActivardescripcionTipoMerma() {
		return this.activardescripcionTipoMerma;
	}

	public void setActivardescripcionTipoMerma(Boolean activardescripcionTipoMerma) {
		this.activardescripcionTipoMerma= activardescripcionTipoMerma;
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
		
		
		this.setMostraridTipoMerma(esInicial);
		this.setMostrarid_paisTipoMerma(esInicial);
		this.setMostrarnombreTipoMerma(esInicial);
		this.setMostrardescripcionTipoMerma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMermaConstantesFunciones.ID)) {
				this.setMostraridTipoMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisTipoMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoMerma(esAsigna);
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
		
		
		this.setActivaridTipoMerma(esInicial);
		this.setActivarid_paisTipoMerma(esInicial);
		this.setActivarnombreTipoMerma(esInicial);
		this.setActivardescripcionTipoMerma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMermaConstantesFunciones.ID)) {
				this.setActivaridTipoMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisTipoMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoMerma(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMermaBeanSwingJInternalFrame tipomermaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoMerma(esInicial);
		this.setResaltarid_paisTipoMerma(esInicial);
		this.setResaltarnombreTipoMerma(esInicial);
		this.setResaltardescripcionTipoMerma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMermaConstantesFunciones.ID)) {
				this.setResaltaridTipoMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisTipoMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoMerma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoMerma(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMermaBeanSwingJInternalFrame tipomermaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdPaisTipoMerma=true;

	public Boolean getMostrarFK_IdPaisTipoMerma() {
		return this.mostrarFK_IdPaisTipoMerma;
	}

	public void setMostrarFK_IdPaisTipoMerma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisTipoMerma= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdPaisTipoMerma=true;

	public Boolean getActivarFK_IdPaisTipoMerma() {
		return this.activarFK_IdPaisTipoMerma;
	}

	public void setActivarFK_IdPaisTipoMerma(Boolean habilitarResaltar) {
		this.activarFK_IdPaisTipoMerma= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdPaisTipoMerma=null;

	public Border getResaltarFK_IdPaisTipoMerma() {
		return this.resaltarFK_IdPaisTipoMerma;
	}

	public void setResaltarFK_IdPaisTipoMerma(Border borderResaltar) {
		this.resaltarFK_IdPaisTipoMerma= borderResaltar;
	}

	public void setResaltarFK_IdPaisTipoMerma(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMermaBeanSwingJInternalFrame tipomermaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisTipoMerma= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}