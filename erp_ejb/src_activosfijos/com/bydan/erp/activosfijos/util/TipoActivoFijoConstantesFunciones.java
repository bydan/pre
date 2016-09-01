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
package com.bydan.erp.activosfijos.util;

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


import com.bydan.erp.activosfijos.util.TipoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.TipoActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.TipoActivoFijoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoActivoFijoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoActivoFijo";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoActivoFijo"+TipoActivoFijoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoActivoFijoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoActivoFijoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoActivoFijoConstantesFunciones.SCHEMA+"_"+TipoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoActivoFijoConstantesFunciones.SCHEMA+"_"+TipoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoActivoFijoConstantesFunciones.SCHEMA+"_"+TipoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoActivoFijoConstantesFunciones.SCHEMA+"_"+TipoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoActivoFijoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoActivoFijoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Activo Fijos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Activo Fijo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Activo Fijo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoActivoFijo";
	public static final String OBJECTNAME="tipoactivofijo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="tipo_activo_fijo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoactivofijo from "+TipoActivoFijoConstantesFunciones.SPERSISTENCENAME+" tipoactivofijo";
	public static String QUERYSELECTNATIVE="select "+TipoActivoFijoConstantesFunciones.SCHEMA+"."+TipoActivoFijoConstantesFunciones.TABLENAME+".id,"+TipoActivoFijoConstantesFunciones.SCHEMA+"."+TipoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+TipoActivoFijoConstantesFunciones.SCHEMA+"."+TipoActivoFijoConstantesFunciones.TABLENAME+".id_pais,"+TipoActivoFijoConstantesFunciones.SCHEMA+"."+TipoActivoFijoConstantesFunciones.TABLENAME+".nombre from "+TipoActivoFijoConstantesFunciones.SCHEMA+"."+TipoActivoFijoConstantesFunciones.TABLENAME;//+" as "+TipoActivoFijoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPAIS= "id_pais";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoActivoFijoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoActivoFijoConstantesFunciones.IDPAIS)) {sLabelColumna=TipoActivoFijoConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(TipoActivoFijoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoActivoFijoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoActivoFijoDescripcion(TipoActivoFijo tipoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoactivofijo !=null/* && tipoactivofijo.getId()!=0*/) {
			sDescripcion=tipoactivofijo.getnombre();//tipoactivofijotipoactivofijo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoActivoFijoDescripcionDetallado(TipoActivoFijo tipoactivofijo) {
		String sDescripcion="";
			
		sDescripcion+=TipoActivoFijoConstantesFunciones.ID+"=";
		sDescripcion+=tipoactivofijo.getId().toString()+",";
		sDescripcion+=TipoActivoFijoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoactivofijo.getVersionRow().toString()+",";
		sDescripcion+=TipoActivoFijoConstantesFunciones.IDPAIS+"=";
		sDescripcion+=tipoactivofijo.getid_pais().toString()+",";
		sDescripcion+=TipoActivoFijoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoactivofijo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoActivoFijoDescripcion(TipoActivoFijo tipoactivofijo,String sValor) throws Exception {			
		if(tipoactivofijo !=null) {
			tipoactivofijo.setnombre(sValor);//tipoactivofijotipoactivofijo.getId().toString();
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
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
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

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoActivoFijo(TipoActivoFijo tipoactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoactivofijo.setnombre(tipoactivofijo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoActivoFijos(List<TipoActivoFijo> tipoactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoActivoFijo tipoactivofijo: tipoactivofijos) {
			tipoactivofijo.setnombre(tipoactivofijo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoActivoFijo(TipoActivoFijo tipoactivofijo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoactivofijo.getConCambioAuxiliar()) {
			tipoactivofijo.setIsDeleted(tipoactivofijo.getIsDeletedAuxiliar());	
			tipoactivofijo.setIsNew(tipoactivofijo.getIsNewAuxiliar());	
			tipoactivofijo.setIsChanged(tipoactivofijo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoactivofijo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoactivofijo.setIsDeletedAuxiliar(false);	
			tipoactivofijo.setIsNewAuxiliar(false);	
			tipoactivofijo.setIsChangedAuxiliar(false);
			
			tipoactivofijo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoActivoFijos(List<TipoActivoFijo> tipoactivofijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoActivoFijo tipoactivofijo : tipoactivofijos) {
			if(conAsignarBase && tipoactivofijo.getConCambioAuxiliar()) {
				tipoactivofijo.setIsDeleted(tipoactivofijo.getIsDeletedAuxiliar());	
				tipoactivofijo.setIsNew(tipoactivofijo.getIsNewAuxiliar());	
				tipoactivofijo.setIsChanged(tipoactivofijo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoactivofijo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoactivofijo.setIsDeletedAuxiliar(false);	
				tipoactivofijo.setIsNewAuxiliar(false);	
				tipoactivofijo.setIsChangedAuxiliar(false);
				
				tipoactivofijo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoActivoFijo(TipoActivoFijo tipoactivofijo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoActivoFijos(List<TipoActivoFijo> tipoactivofijos,Boolean conEnteros) throws Exception  {
		
		for(TipoActivoFijo tipoactivofijo: tipoactivofijos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoActivoFijo(List<TipoActivoFijo> tipoactivofijos,TipoActivoFijo tipoactivofijoAux) throws Exception  {
		TipoActivoFijoConstantesFunciones.InicializarValoresTipoActivoFijo(tipoactivofijoAux,true);
		
		for(TipoActivoFijo tipoactivofijo: tipoactivofijos) {
			if(tipoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoActivoFijoConstantesFunciones.getArrayColumnasGlobalesTipoActivoFijo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoActivoFijo> tipoactivofijos,TipoActivoFijo tipoactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoActivoFijo tipoactivofijoAux: tipoactivofijos) {
			if(tipoactivofijoAux!=null && tipoactivofijo!=null) {
				if((tipoactivofijoAux.getId()==null && tipoactivofijo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoactivofijoAux.getId()!=null && tipoactivofijo.getId()!=null){
					if(tipoactivofijoAux.getId().equals(tipoactivofijo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoActivoFijo(List<TipoActivoFijo> tipoactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoActivoFijo tipoactivofijo: tipoactivofijos) {			
			if(tipoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoActivoFijo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoActivoFijoConstantesFunciones.LABEL_ID, TipoActivoFijoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoActivoFijoConstantesFunciones.LABEL_VERSIONROW, TipoActivoFijoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoActivoFijoConstantesFunciones.LABEL_IDPAIS, TipoActivoFijoConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoActivoFijoConstantesFunciones.LABEL_NOMBRE, TipoActivoFijoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoActivoFijo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoActivoFijoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoActivoFijoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoActivoFijoConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoActivoFijoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoActivoFijo() throws Exception  {
		return TipoActivoFijoConstantesFunciones.getTiposSeleccionarTipoActivoFijo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoActivoFijo(Boolean conFk) throws Exception  {
		return TipoActivoFijoConstantesFunciones.getTiposSeleccionarTipoActivoFijo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoActivoFijo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoActivoFijoConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(TipoActivoFijoConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoActivoFijoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoActivoFijoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoActivoFijo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoActivoFijo(TipoActivoFijo tipoactivofijoAux) throws Exception {
		
			tipoactivofijoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipoactivofijoAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoActivoFijo(List<TipoActivoFijo> tipoactivofijosTemp) throws Exception {
		for(TipoActivoFijo tipoactivofijoAux:tipoactivofijosTemp) {
			
			tipoactivofijoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipoactivofijoAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoActivoFijoConstantesFunciones.getClassesRelationshipsOfTipoActivoFijo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoActivoFijoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoActivoFijo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoActivoFijo tipoactivofijo,List<TipoActivoFijo> tipoactivofijos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoActivoFijo tipoactivofijoEncontrado=null;
			
			for(TipoActivoFijo tipoactivofijoLocal:tipoactivofijos) {
				if(tipoactivofijoLocal.getId().equals(tipoactivofijo.getId())) {
					tipoactivofijoEncontrado=tipoactivofijoLocal;
					
					tipoactivofijoLocal.setIsChanged(tipoactivofijo.getIsChanged());
					tipoactivofijoLocal.setIsNew(tipoactivofijo.getIsNew());
					tipoactivofijoLocal.setIsDeleted(tipoactivofijo.getIsDeleted());
					
					tipoactivofijoLocal.setGeneralEntityOriginal(tipoactivofijo.getGeneralEntityOriginal());
					
					tipoactivofijoLocal.setId(tipoactivofijo.getId());	
					tipoactivofijoLocal.setVersionRow(tipoactivofijo.getVersionRow());	
					tipoactivofijoLocal.setid_pais(tipoactivofijo.getid_pais());	
					tipoactivofijoLocal.setnombre(tipoactivofijo.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoactivofijo.getIsDeleted()) {
				if(!existe) {
					tipoactivofijos.add(tipoactivofijo);
				}
			} else {
				if(tipoactivofijoEncontrado!=null && permiteQuitar)  {
					tipoactivofijos.remove(tipoactivofijoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoActivoFijo tipoactivofijo,List<TipoActivoFijo> tipoactivofijos) throws Exception {
		try	{			
			for(TipoActivoFijo tipoactivofijoLocal:tipoactivofijos) {
				if(tipoactivofijoLocal.getId().equals(tipoactivofijo.getId())) {
					tipoactivofijoLocal.setIsSelected(tipoactivofijo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoActivoFijo(List<TipoActivoFijo> tipoactivofijosAux) throws Exception {
		//this.tipoactivofijosAux=tipoactivofijosAux;
		
		for(TipoActivoFijo tipoactivofijoAux:tipoactivofijosAux) {
			if(tipoactivofijoAux.getIsChanged()) {
				tipoactivofijoAux.setIsChanged(false);
			}		
			
			if(tipoactivofijoAux.getIsNew()) {
				tipoactivofijoAux.setIsNew(false);
			}	
			
			if(tipoactivofijoAux.getIsDeleted()) {
				tipoactivofijoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoActivoFijo(TipoActivoFijo tipoactivofijoAux) throws Exception {
		//this.tipoactivofijoAux=tipoactivofijoAux;
		
			if(tipoactivofijoAux.getIsChanged()) {
				tipoactivofijoAux.setIsChanged(false);
			}		
			
			if(tipoactivofijoAux.getIsNew()) {
				tipoactivofijoAux.setIsNew(false);
			}	
			
			if(tipoactivofijoAux.getIsDeleted()) {
				tipoactivofijoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoActivoFijo tipoactivofijoAsignar,TipoActivoFijo tipoactivofijo) throws Exception {
		tipoactivofijoAsignar.setId(tipoactivofijo.getId());	
		tipoactivofijoAsignar.setVersionRow(tipoactivofijo.getVersionRow());	
		tipoactivofijoAsignar.setid_pais(tipoactivofijo.getid_pais());
		tipoactivofijoAsignar.setpais_descripcion(tipoactivofijo.getpais_descripcion());	
		tipoactivofijoAsignar.setnombre(tipoactivofijo.getnombre());	
	}
	
	public static void inicializarTipoActivoFijo(TipoActivoFijo tipoactivofijo) throws Exception {
		try {
				tipoactivofijo.setId(0L);	
					
				tipoactivofijo.setid_pais(-1L);	
				tipoactivofijo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoActivoFijo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoActivoFijoConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoActivoFijoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoActivoFijo(String sTipo,Row row,Workbook workbook,TipoActivoFijo tipoactivofijo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoactivofijo.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoactivofijo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoActivoFijo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoActivoFijo() {
		return this.sFinalQueryTipoActivoFijo;
	}
	
	public void setsFinalQueryTipoActivoFijo(String sFinalQueryTipoActivoFijo) {
		this.sFinalQueryTipoActivoFijo= sFinalQueryTipoActivoFijo;
	}
	
	public Border resaltarSeleccionarTipoActivoFijo=null;
	
	public Border setResaltarSeleccionarTipoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoActivoFijoBeanSwingJInternalFrame tipoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoactivofijoBeanSwingJInternalFrame.jTtoolBarTipoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoActivoFijo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoActivoFijo() {
		return this.resaltarSeleccionarTipoActivoFijo;
	}
	
	public void setResaltarSeleccionarTipoActivoFijo(Border borderResaltarSeleccionarTipoActivoFijo) {
		this.resaltarSeleccionarTipoActivoFijo= borderResaltarSeleccionarTipoActivoFijo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoActivoFijo=null;
	public Boolean mostraridTipoActivoFijo=true;
	public Boolean activaridTipoActivoFijo=true;

	public Border resaltarid_paisTipoActivoFijo=null;
	public Boolean mostrarid_paisTipoActivoFijo=true;
	public Boolean activarid_paisTipoActivoFijo=true;
	public Boolean cargarid_paisTipoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisTipoActivoFijo=false;//ConEventDepend=true

	public Border resaltarnombreTipoActivoFijo=null;
	public Boolean mostrarnombreTipoActivoFijo=true;
	public Boolean activarnombreTipoActivoFijo=true;

	
	

	public Border setResaltaridTipoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoActivoFijoBeanSwingJInternalFrame tipoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoactivofijoBeanSwingJInternalFrame.jTtoolBarTipoActivoFijo.setBorder(borderResaltar);
		
		this.resaltaridTipoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoActivoFijo() {
		return this.resaltaridTipoActivoFijo;
	}

	public void setResaltaridTipoActivoFijo(Border borderResaltar) {
		this.resaltaridTipoActivoFijo= borderResaltar;
	}

	public Boolean getMostraridTipoActivoFijo() {
		return this.mostraridTipoActivoFijo;
	}

	public void setMostraridTipoActivoFijo(Boolean mostraridTipoActivoFijo) {
		this.mostraridTipoActivoFijo= mostraridTipoActivoFijo;
	}

	public Boolean getActivaridTipoActivoFijo() {
		return this.activaridTipoActivoFijo;
	}

	public void setActivaridTipoActivoFijo(Boolean activaridTipoActivoFijo) {
		this.activaridTipoActivoFijo= activaridTipoActivoFijo;
	}

	public Border setResaltarid_paisTipoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoActivoFijoBeanSwingJInternalFrame tipoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoactivofijoBeanSwingJInternalFrame.jTtoolBarTipoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_paisTipoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisTipoActivoFijo() {
		return this.resaltarid_paisTipoActivoFijo;
	}

	public void setResaltarid_paisTipoActivoFijo(Border borderResaltar) {
		this.resaltarid_paisTipoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_paisTipoActivoFijo() {
		return this.mostrarid_paisTipoActivoFijo;
	}

	public void setMostrarid_paisTipoActivoFijo(Boolean mostrarid_paisTipoActivoFijo) {
		this.mostrarid_paisTipoActivoFijo= mostrarid_paisTipoActivoFijo;
	}

	public Boolean getActivarid_paisTipoActivoFijo() {
		return this.activarid_paisTipoActivoFijo;
	}

	public void setActivarid_paisTipoActivoFijo(Boolean activarid_paisTipoActivoFijo) {
		this.activarid_paisTipoActivoFijo= activarid_paisTipoActivoFijo;
	}

	public Boolean getCargarid_paisTipoActivoFijo() {
		return this.cargarid_paisTipoActivoFijo;
	}

	public void setCargarid_paisTipoActivoFijo(Boolean cargarid_paisTipoActivoFijo) {
		this.cargarid_paisTipoActivoFijo= cargarid_paisTipoActivoFijo;
	}

	public Border setResaltarnombreTipoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoActivoFijoBeanSwingJInternalFrame tipoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoactivofijoBeanSwingJInternalFrame.jTtoolBarTipoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoActivoFijo() {
		return this.resaltarnombreTipoActivoFijo;
	}

	public void setResaltarnombreTipoActivoFijo(Border borderResaltar) {
		this.resaltarnombreTipoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoActivoFijo() {
		return this.mostrarnombreTipoActivoFijo;
	}

	public void setMostrarnombreTipoActivoFijo(Boolean mostrarnombreTipoActivoFijo) {
		this.mostrarnombreTipoActivoFijo= mostrarnombreTipoActivoFijo;
	}

	public Boolean getActivarnombreTipoActivoFijo() {
		return this.activarnombreTipoActivoFijo;
	}

	public void setActivarnombreTipoActivoFijo(Boolean activarnombreTipoActivoFijo) {
		this.activarnombreTipoActivoFijo= activarnombreTipoActivoFijo;
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
		
		
		this.setMostraridTipoActivoFijo(esInicial);
		this.setMostrarid_paisTipoActivoFijo(esInicial);
		this.setMostrarnombreTipoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoActivoFijoConstantesFunciones.ID)) {
				this.setMostraridTipoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoActivoFijoConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisTipoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoActivoFijo(esAsigna);
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
		
		
		this.setActivaridTipoActivoFijo(esInicial);
		this.setActivarid_paisTipoActivoFijo(esInicial);
		this.setActivarnombreTipoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoActivoFijoConstantesFunciones.ID)) {
				this.setActivaridTipoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoActivoFijoConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisTipoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoActivoFijoBeanSwingJInternalFrame tipoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoActivoFijo(esInicial);
		this.setResaltarid_paisTipoActivoFijo(esInicial);
		this.setResaltarnombreTipoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoActivoFijoConstantesFunciones.ID)) {
				this.setResaltaridTipoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoActivoFijoConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisTipoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoActivoFijo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoActivoFijoBeanSwingJInternalFrame tipoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdPaisTipoActivoFijo=true;

	public Boolean getMostrarFK_IdPaisTipoActivoFijo() {
		return this.mostrarFK_IdPaisTipoActivoFijo;
	}

	public void setMostrarFK_IdPaisTipoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisTipoActivoFijo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdPaisTipoActivoFijo=true;

	public Boolean getActivarFK_IdPaisTipoActivoFijo() {
		return this.activarFK_IdPaisTipoActivoFijo;
	}

	public void setActivarFK_IdPaisTipoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdPaisTipoActivoFijo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdPaisTipoActivoFijo=null;

	public Border getResaltarFK_IdPaisTipoActivoFijo() {
		return this.resaltarFK_IdPaisTipoActivoFijo;
	}

	public void setResaltarFK_IdPaisTipoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdPaisTipoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdPaisTipoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoActivoFijoBeanSwingJInternalFrame tipoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisTipoActivoFijo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}