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


import com.bydan.erp.activosfijos.util.TipoEstadoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.TipoEstadoActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.TipoEstadoActivoFijoParameterGeneral;

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
final public class TipoEstadoActivoFijoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoEstadoActivoFijo";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoEstadoActivoFijo"+TipoEstadoActivoFijoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoEstadoActivoFijoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoEstadoActivoFijoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"_"+TipoEstadoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoEstadoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"_"+TipoEstadoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"_"+TipoEstadoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoEstadoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"_"+TipoEstadoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEstadoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoEstadoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEstadoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEstadoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoEstadoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEstadoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoEstadoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoEstadoActivoFijoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoEstadoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoEstadoActivoFijoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Estado Activo Fijos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Estado Activo Fijo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Estado Activo Fijo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoEstadoActivoFijo";
	public static final String OBJECTNAME="tipoestadoactivofijo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="tipo_estado_activo_fijo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoestadoactivofijo from "+TipoEstadoActivoFijoConstantesFunciones.SPERSISTENCENAME+" tipoestadoactivofijo";
	public static String QUERYSELECTNATIVE="select "+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME+".id,"+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME+".id_pais,"+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME+".nombre from "+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME;//+" as "+TipoEstadoActivoFijoConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoEstadoActivoFijoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoEstadoActivoFijoConstantesFunciones.IDPAIS)) {sLabelColumna=TipoEstadoActivoFijoConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(TipoEstadoActivoFijoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoEstadoActivoFijoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoEstadoActivoFijoDescripcion(TipoEstadoActivoFijo tipoestadoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoestadoactivofijo !=null/* && tipoestadoactivofijo.getId()!=0*/) {
			sDescripcion=tipoestadoactivofijo.getnombre();//tipoestadoactivofijotipoestadoactivofijo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoEstadoActivoFijoDescripcionDetallado(TipoEstadoActivoFijo tipoestadoactivofijo) {
		String sDescripcion="";
			
		sDescripcion+=TipoEstadoActivoFijoConstantesFunciones.ID+"=";
		sDescripcion+=tipoestadoactivofijo.getId().toString()+",";
		sDescripcion+=TipoEstadoActivoFijoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoestadoactivofijo.getVersionRow().toString()+",";
		sDescripcion+=TipoEstadoActivoFijoConstantesFunciones.IDPAIS+"=";
		sDescripcion+=tipoestadoactivofijo.getid_pais().toString()+",";
		sDescripcion+=TipoEstadoActivoFijoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoestadoactivofijo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoEstadoActivoFijoDescripcion(TipoEstadoActivoFijo tipoestadoactivofijo,String sValor) throws Exception {			
		if(tipoestadoactivofijo !=null) {
			tipoestadoactivofijo.setnombre(sValor);//tipoestadoactivofijotipoestadoactivofijo.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoEstadoActivoFijo(TipoEstadoActivoFijo tipoestadoactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoestadoactivofijo.setnombre(tipoestadoactivofijo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoEstadoActivoFijos(List<TipoEstadoActivoFijo> tipoestadoactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoEstadoActivoFijo tipoestadoactivofijo: tipoestadoactivofijos) {
			tipoestadoactivofijo.setnombre(tipoestadoactivofijo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoEstadoActivoFijo(TipoEstadoActivoFijo tipoestadoactivofijo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoestadoactivofijo.getConCambioAuxiliar()) {
			tipoestadoactivofijo.setIsDeleted(tipoestadoactivofijo.getIsDeletedAuxiliar());	
			tipoestadoactivofijo.setIsNew(tipoestadoactivofijo.getIsNewAuxiliar());	
			tipoestadoactivofijo.setIsChanged(tipoestadoactivofijo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoestadoactivofijo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoestadoactivofijo.setIsDeletedAuxiliar(false);	
			tipoestadoactivofijo.setIsNewAuxiliar(false);	
			tipoestadoactivofijo.setIsChangedAuxiliar(false);
			
			tipoestadoactivofijo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoEstadoActivoFijos(List<TipoEstadoActivoFijo> tipoestadoactivofijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoEstadoActivoFijo tipoestadoactivofijo : tipoestadoactivofijos) {
			if(conAsignarBase && tipoestadoactivofijo.getConCambioAuxiliar()) {
				tipoestadoactivofijo.setIsDeleted(tipoestadoactivofijo.getIsDeletedAuxiliar());	
				tipoestadoactivofijo.setIsNew(tipoestadoactivofijo.getIsNewAuxiliar());	
				tipoestadoactivofijo.setIsChanged(tipoestadoactivofijo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoestadoactivofijo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoestadoactivofijo.setIsDeletedAuxiliar(false);	
				tipoestadoactivofijo.setIsNewAuxiliar(false);	
				tipoestadoactivofijo.setIsChangedAuxiliar(false);
				
				tipoestadoactivofijo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoEstadoActivoFijo(TipoEstadoActivoFijo tipoestadoactivofijo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoEstadoActivoFijos(List<TipoEstadoActivoFijo> tipoestadoactivofijos,Boolean conEnteros) throws Exception  {
		
		for(TipoEstadoActivoFijo tipoestadoactivofijo: tipoestadoactivofijos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoEstadoActivoFijo(List<TipoEstadoActivoFijo> tipoestadoactivofijos,TipoEstadoActivoFijo tipoestadoactivofijoAux) throws Exception  {
		TipoEstadoActivoFijoConstantesFunciones.InicializarValoresTipoEstadoActivoFijo(tipoestadoactivofijoAux,true);
		
		for(TipoEstadoActivoFijo tipoestadoactivofijo: tipoestadoactivofijos) {
			if(tipoestadoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoEstadoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoEstadoActivoFijoConstantesFunciones.getArrayColumnasGlobalesTipoEstadoActivoFijo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoEstadoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoEstadoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoEstadoActivoFijo> tipoestadoactivofijos,TipoEstadoActivoFijo tipoestadoactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoEstadoActivoFijo tipoestadoactivofijoAux: tipoestadoactivofijos) {
			if(tipoestadoactivofijoAux!=null && tipoestadoactivofijo!=null) {
				if((tipoestadoactivofijoAux.getId()==null && tipoestadoactivofijo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoestadoactivofijoAux.getId()!=null && tipoestadoactivofijo.getId()!=null){
					if(tipoestadoactivofijoAux.getId().equals(tipoestadoactivofijo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoEstadoActivoFijo(List<TipoEstadoActivoFijo> tipoestadoactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoEstadoActivoFijo tipoestadoactivofijo: tipoestadoactivofijos) {			
			if(tipoestadoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoEstadoActivoFijo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoEstadoActivoFijoConstantesFunciones.LABEL_ID, TipoEstadoActivoFijoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEstadoActivoFijoConstantesFunciones.LABEL_VERSIONROW, TipoEstadoActivoFijoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEstadoActivoFijoConstantesFunciones.LABEL_IDPAIS, TipoEstadoActivoFijoConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEstadoActivoFijoConstantesFunciones.LABEL_NOMBRE, TipoEstadoActivoFijoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoEstadoActivoFijo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoEstadoActivoFijoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEstadoActivoFijoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEstadoActivoFijoConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEstadoActivoFijoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEstadoActivoFijo() throws Exception  {
		return TipoEstadoActivoFijoConstantesFunciones.getTiposSeleccionarTipoEstadoActivoFijo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEstadoActivoFijo(Boolean conFk) throws Exception  {
		return TipoEstadoActivoFijoConstantesFunciones.getTiposSeleccionarTipoEstadoActivoFijo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEstadoActivoFijo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoEstadoActivoFijoConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(TipoEstadoActivoFijoConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoEstadoActivoFijoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoEstadoActivoFijoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoEstadoActivoFijo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoEstadoActivoFijo(TipoEstadoActivoFijo tipoestadoactivofijoAux) throws Exception {
		
			tipoestadoactivofijoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipoestadoactivofijoAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoEstadoActivoFijo(List<TipoEstadoActivoFijo> tipoestadoactivofijosTemp) throws Exception {
		for(TipoEstadoActivoFijo tipoestadoactivofijoAux:tipoestadoactivofijosTemp) {
			
			tipoestadoactivofijoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipoestadoactivofijoAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoEstadoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoEstadoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoEstadoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoEstadoActivoFijoConstantesFunciones.getClassesRelationshipsOfTipoEstadoActivoFijo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoEstadoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoEstadoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoEstadoActivoFijoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoEstadoActivoFijo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoEstadoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoEstadoActivoFijo tipoestadoactivofijo,List<TipoEstadoActivoFijo> tipoestadoactivofijos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoEstadoActivoFijo tipoestadoactivofijoEncontrado=null;
			
			for(TipoEstadoActivoFijo tipoestadoactivofijoLocal:tipoestadoactivofijos) {
				if(tipoestadoactivofijoLocal.getId().equals(tipoestadoactivofijo.getId())) {
					tipoestadoactivofijoEncontrado=tipoestadoactivofijoLocal;
					
					tipoestadoactivofijoLocal.setIsChanged(tipoestadoactivofijo.getIsChanged());
					tipoestadoactivofijoLocal.setIsNew(tipoestadoactivofijo.getIsNew());
					tipoestadoactivofijoLocal.setIsDeleted(tipoestadoactivofijo.getIsDeleted());
					
					tipoestadoactivofijoLocal.setGeneralEntityOriginal(tipoestadoactivofijo.getGeneralEntityOriginal());
					
					tipoestadoactivofijoLocal.setId(tipoestadoactivofijo.getId());	
					tipoestadoactivofijoLocal.setVersionRow(tipoestadoactivofijo.getVersionRow());	
					tipoestadoactivofijoLocal.setid_pais(tipoestadoactivofijo.getid_pais());	
					tipoestadoactivofijoLocal.setnombre(tipoestadoactivofijo.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoestadoactivofijo.getIsDeleted()) {
				if(!existe) {
					tipoestadoactivofijos.add(tipoestadoactivofijo);
				}
			} else {
				if(tipoestadoactivofijoEncontrado!=null && permiteQuitar)  {
					tipoestadoactivofijos.remove(tipoestadoactivofijoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoEstadoActivoFijo tipoestadoactivofijo,List<TipoEstadoActivoFijo> tipoestadoactivofijos) throws Exception {
		try	{			
			for(TipoEstadoActivoFijo tipoestadoactivofijoLocal:tipoestadoactivofijos) {
				if(tipoestadoactivofijoLocal.getId().equals(tipoestadoactivofijo.getId())) {
					tipoestadoactivofijoLocal.setIsSelected(tipoestadoactivofijo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoEstadoActivoFijo(List<TipoEstadoActivoFijo> tipoestadoactivofijosAux) throws Exception {
		//this.tipoestadoactivofijosAux=tipoestadoactivofijosAux;
		
		for(TipoEstadoActivoFijo tipoestadoactivofijoAux:tipoestadoactivofijosAux) {
			if(tipoestadoactivofijoAux.getIsChanged()) {
				tipoestadoactivofijoAux.setIsChanged(false);
			}		
			
			if(tipoestadoactivofijoAux.getIsNew()) {
				tipoestadoactivofijoAux.setIsNew(false);
			}	
			
			if(tipoestadoactivofijoAux.getIsDeleted()) {
				tipoestadoactivofijoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoEstadoActivoFijo(TipoEstadoActivoFijo tipoestadoactivofijoAux) throws Exception {
		//this.tipoestadoactivofijoAux=tipoestadoactivofijoAux;
		
			if(tipoestadoactivofijoAux.getIsChanged()) {
				tipoestadoactivofijoAux.setIsChanged(false);
			}		
			
			if(tipoestadoactivofijoAux.getIsNew()) {
				tipoestadoactivofijoAux.setIsNew(false);
			}	
			
			if(tipoestadoactivofijoAux.getIsDeleted()) {
				tipoestadoactivofijoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoEstadoActivoFijo tipoestadoactivofijoAsignar,TipoEstadoActivoFijo tipoestadoactivofijo) throws Exception {
		tipoestadoactivofijoAsignar.setId(tipoestadoactivofijo.getId());	
		tipoestadoactivofijoAsignar.setVersionRow(tipoestadoactivofijo.getVersionRow());	
		tipoestadoactivofijoAsignar.setid_pais(tipoestadoactivofijo.getid_pais());
		tipoestadoactivofijoAsignar.setpais_descripcion(tipoestadoactivofijo.getpais_descripcion());	
		tipoestadoactivofijoAsignar.setnombre(tipoestadoactivofijo.getnombre());	
	}
	
	public static void inicializarTipoEstadoActivoFijo(TipoEstadoActivoFijo tipoestadoactivofijo) throws Exception {
		try {
				tipoestadoactivofijo.setId(0L);	
					
				tipoestadoactivofijo.setid_pais(-1L);	
				tipoestadoactivofijo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoEstadoActivoFijo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoEstadoActivoFijoConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoEstadoActivoFijoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoEstadoActivoFijo(String sTipo,Row row,Workbook workbook,TipoEstadoActivoFijo tipoestadoactivofijo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoestadoactivofijo.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoestadoactivofijo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoEstadoActivoFijo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoEstadoActivoFijo() {
		return this.sFinalQueryTipoEstadoActivoFijo;
	}
	
	public void setsFinalQueryTipoEstadoActivoFijo(String sFinalQueryTipoEstadoActivoFijo) {
		this.sFinalQueryTipoEstadoActivoFijo= sFinalQueryTipoEstadoActivoFijo;
	}
	
	public Border resaltarSeleccionarTipoEstadoActivoFijo=null;
	
	public Border setResaltarSeleccionarTipoEstadoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEstadoActivoFijoBeanSwingJInternalFrame tipoestadoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoestadoactivofijoBeanSwingJInternalFrame.jTtoolBarTipoEstadoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoEstadoActivoFijo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoEstadoActivoFijo() {
		return this.resaltarSeleccionarTipoEstadoActivoFijo;
	}
	
	public void setResaltarSeleccionarTipoEstadoActivoFijo(Border borderResaltarSeleccionarTipoEstadoActivoFijo) {
		this.resaltarSeleccionarTipoEstadoActivoFijo= borderResaltarSeleccionarTipoEstadoActivoFijo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoEstadoActivoFijo=null;
	public Boolean mostraridTipoEstadoActivoFijo=true;
	public Boolean activaridTipoEstadoActivoFijo=true;

	public Border resaltarid_paisTipoEstadoActivoFijo=null;
	public Boolean mostrarid_paisTipoEstadoActivoFijo=true;
	public Boolean activarid_paisTipoEstadoActivoFijo=true;
	public Boolean cargarid_paisTipoEstadoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisTipoEstadoActivoFijo=false;//ConEventDepend=true

	public Border resaltarnombreTipoEstadoActivoFijo=null;
	public Boolean mostrarnombreTipoEstadoActivoFijo=true;
	public Boolean activarnombreTipoEstadoActivoFijo=true;

	
	

	public Border setResaltaridTipoEstadoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEstadoActivoFijoBeanSwingJInternalFrame tipoestadoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoestadoactivofijoBeanSwingJInternalFrame.jTtoolBarTipoEstadoActivoFijo.setBorder(borderResaltar);
		
		this.resaltaridTipoEstadoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoEstadoActivoFijo() {
		return this.resaltaridTipoEstadoActivoFijo;
	}

	public void setResaltaridTipoEstadoActivoFijo(Border borderResaltar) {
		this.resaltaridTipoEstadoActivoFijo= borderResaltar;
	}

	public Boolean getMostraridTipoEstadoActivoFijo() {
		return this.mostraridTipoEstadoActivoFijo;
	}

	public void setMostraridTipoEstadoActivoFijo(Boolean mostraridTipoEstadoActivoFijo) {
		this.mostraridTipoEstadoActivoFijo= mostraridTipoEstadoActivoFijo;
	}

	public Boolean getActivaridTipoEstadoActivoFijo() {
		return this.activaridTipoEstadoActivoFijo;
	}

	public void setActivaridTipoEstadoActivoFijo(Boolean activaridTipoEstadoActivoFijo) {
		this.activaridTipoEstadoActivoFijo= activaridTipoEstadoActivoFijo;
	}

	public Border setResaltarid_paisTipoEstadoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEstadoActivoFijoBeanSwingJInternalFrame tipoestadoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoestadoactivofijoBeanSwingJInternalFrame.jTtoolBarTipoEstadoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_paisTipoEstadoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisTipoEstadoActivoFijo() {
		return this.resaltarid_paisTipoEstadoActivoFijo;
	}

	public void setResaltarid_paisTipoEstadoActivoFijo(Border borderResaltar) {
		this.resaltarid_paisTipoEstadoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_paisTipoEstadoActivoFijo() {
		return this.mostrarid_paisTipoEstadoActivoFijo;
	}

	public void setMostrarid_paisTipoEstadoActivoFijo(Boolean mostrarid_paisTipoEstadoActivoFijo) {
		this.mostrarid_paisTipoEstadoActivoFijo= mostrarid_paisTipoEstadoActivoFijo;
	}

	public Boolean getActivarid_paisTipoEstadoActivoFijo() {
		return this.activarid_paisTipoEstadoActivoFijo;
	}

	public void setActivarid_paisTipoEstadoActivoFijo(Boolean activarid_paisTipoEstadoActivoFijo) {
		this.activarid_paisTipoEstadoActivoFijo= activarid_paisTipoEstadoActivoFijo;
	}

	public Boolean getCargarid_paisTipoEstadoActivoFijo() {
		return this.cargarid_paisTipoEstadoActivoFijo;
	}

	public void setCargarid_paisTipoEstadoActivoFijo(Boolean cargarid_paisTipoEstadoActivoFijo) {
		this.cargarid_paisTipoEstadoActivoFijo= cargarid_paisTipoEstadoActivoFijo;
	}

	public Border setResaltarnombreTipoEstadoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEstadoActivoFijoBeanSwingJInternalFrame tipoestadoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoestadoactivofijoBeanSwingJInternalFrame.jTtoolBarTipoEstadoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoEstadoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoEstadoActivoFijo() {
		return this.resaltarnombreTipoEstadoActivoFijo;
	}

	public void setResaltarnombreTipoEstadoActivoFijo(Border borderResaltar) {
		this.resaltarnombreTipoEstadoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoEstadoActivoFijo() {
		return this.mostrarnombreTipoEstadoActivoFijo;
	}

	public void setMostrarnombreTipoEstadoActivoFijo(Boolean mostrarnombreTipoEstadoActivoFijo) {
		this.mostrarnombreTipoEstadoActivoFijo= mostrarnombreTipoEstadoActivoFijo;
	}

	public Boolean getActivarnombreTipoEstadoActivoFijo() {
		return this.activarnombreTipoEstadoActivoFijo;
	}

	public void setActivarnombreTipoEstadoActivoFijo(Boolean activarnombreTipoEstadoActivoFijo) {
		this.activarnombreTipoEstadoActivoFijo= activarnombreTipoEstadoActivoFijo;
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
		
		
		this.setMostraridTipoEstadoActivoFijo(esInicial);
		this.setMostrarid_paisTipoEstadoActivoFijo(esInicial);
		this.setMostrarnombreTipoEstadoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEstadoActivoFijoConstantesFunciones.ID)) {
				this.setMostraridTipoEstadoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstadoActivoFijoConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisTipoEstadoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstadoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoEstadoActivoFijo(esAsigna);
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
		
		
		this.setActivaridTipoEstadoActivoFijo(esInicial);
		this.setActivarid_paisTipoEstadoActivoFijo(esInicial);
		this.setActivarnombreTipoEstadoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEstadoActivoFijoConstantesFunciones.ID)) {
				this.setActivaridTipoEstadoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstadoActivoFijoConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisTipoEstadoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstadoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoEstadoActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoEstadoActivoFijoBeanSwingJInternalFrame tipoestadoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoEstadoActivoFijo(esInicial);
		this.setResaltarid_paisTipoEstadoActivoFijo(esInicial);
		this.setResaltarnombreTipoEstadoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEstadoActivoFijoConstantesFunciones.ID)) {
				this.setResaltaridTipoEstadoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstadoActivoFijoConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisTipoEstadoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstadoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoEstadoActivoFijo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoEstadoActivoFijoBeanSwingJInternalFrame tipoestadoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdPaisTipoEstadoActivoFijo=true;

	public Boolean getMostrarFK_IdPaisTipoEstadoActivoFijo() {
		return this.mostrarFK_IdPaisTipoEstadoActivoFijo;
	}

	public void setMostrarFK_IdPaisTipoEstadoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisTipoEstadoActivoFijo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdPaisTipoEstadoActivoFijo=true;

	public Boolean getActivarFK_IdPaisTipoEstadoActivoFijo() {
		return this.activarFK_IdPaisTipoEstadoActivoFijo;
	}

	public void setActivarFK_IdPaisTipoEstadoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdPaisTipoEstadoActivoFijo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdPaisTipoEstadoActivoFijo=null;

	public Border getResaltarFK_IdPaisTipoEstadoActivoFijo() {
		return this.resaltarFK_IdPaisTipoEstadoActivoFijo;
	}

	public void setResaltarFK_IdPaisTipoEstadoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdPaisTipoEstadoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdPaisTipoEstadoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEstadoActivoFijoBeanSwingJInternalFrame tipoestadoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisTipoEstadoActivoFijo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}