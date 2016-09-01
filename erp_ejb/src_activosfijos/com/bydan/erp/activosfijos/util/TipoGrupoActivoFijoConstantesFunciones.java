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


import com.bydan.erp.activosfijos.util.TipoGrupoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.TipoGrupoActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.TipoGrupoActivoFijoParameterGeneral;

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
final public class TipoGrupoActivoFijoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoGrupoActivoFijo";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoGrupoActivoFijo"+TipoGrupoActivoFijoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoGrupoActivoFijoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoGrupoActivoFijoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoGrupoActivoFijoConstantesFunciones.SCHEMA+"_"+TipoGrupoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoGrupoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoGrupoActivoFijoConstantesFunciones.SCHEMA+"_"+TipoGrupoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoGrupoActivoFijoConstantesFunciones.SCHEMA+"_"+TipoGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoGrupoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoGrupoActivoFijoConstantesFunciones.SCHEMA+"_"+TipoGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGrupoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGrupoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoGrupoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoGrupoActivoFijoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoGrupoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoGrupoActivoFijoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Grupo Activo Fijos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Grupo Activo Fijo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Grupo Activo Fijo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoGrupoActivoFijo";
	public static final String OBJECTNAME="tipogrupoactivofijo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="tipo_grupo_activo_fijo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipogrupoactivofijo from "+TipoGrupoActivoFijoConstantesFunciones.SPERSISTENCENAME+" tipogrupoactivofijo";
	public static String QUERYSELECTNATIVE="select "+TipoGrupoActivoFijoConstantesFunciones.SCHEMA+"."+TipoGrupoActivoFijoConstantesFunciones.TABLENAME+".id,"+TipoGrupoActivoFijoConstantesFunciones.SCHEMA+"."+TipoGrupoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+TipoGrupoActivoFijoConstantesFunciones.SCHEMA+"."+TipoGrupoActivoFijoConstantesFunciones.TABLENAME+".id_pais,"+TipoGrupoActivoFijoConstantesFunciones.SCHEMA+"."+TipoGrupoActivoFijoConstantesFunciones.TABLENAME+".nombre from "+TipoGrupoActivoFijoConstantesFunciones.SCHEMA+"."+TipoGrupoActivoFijoConstantesFunciones.TABLENAME;//+" as "+TipoGrupoActivoFijoConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoGrupoActivoFijoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoGrupoActivoFijoConstantesFunciones.IDPAIS)) {sLabelColumna=TipoGrupoActivoFijoConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(TipoGrupoActivoFijoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoGrupoActivoFijoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoGrupoActivoFijoDescripcion(TipoGrupoActivoFijo tipogrupoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipogrupoactivofijo !=null/* && tipogrupoactivofijo.getId()!=0*/) {
			sDescripcion=tipogrupoactivofijo.getnombre();//tipogrupoactivofijotipogrupoactivofijo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoGrupoActivoFijoDescripcionDetallado(TipoGrupoActivoFijo tipogrupoactivofijo) {
		String sDescripcion="";
			
		sDescripcion+=TipoGrupoActivoFijoConstantesFunciones.ID+"=";
		sDescripcion+=tipogrupoactivofijo.getId().toString()+",";
		sDescripcion+=TipoGrupoActivoFijoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipogrupoactivofijo.getVersionRow().toString()+",";
		sDescripcion+=TipoGrupoActivoFijoConstantesFunciones.IDPAIS+"=";
		sDescripcion+=tipogrupoactivofijo.getid_pais().toString()+",";
		sDescripcion+=TipoGrupoActivoFijoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipogrupoactivofijo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoGrupoActivoFijoDescripcion(TipoGrupoActivoFijo tipogrupoactivofijo,String sValor) throws Exception {			
		if(tipogrupoactivofijo !=null) {
			tipogrupoactivofijo.setnombre(sValor);//tipogrupoactivofijotipogrupoactivofijo.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoGrupoActivoFijo(TipoGrupoActivoFijo tipogrupoactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipogrupoactivofijo.setnombre(tipogrupoactivofijo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoGrupoActivoFijos(List<TipoGrupoActivoFijo> tipogrupoactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoGrupoActivoFijo tipogrupoactivofijo: tipogrupoactivofijos) {
			tipogrupoactivofijo.setnombre(tipogrupoactivofijo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGrupoActivoFijo(TipoGrupoActivoFijo tipogrupoactivofijo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipogrupoactivofijo.getConCambioAuxiliar()) {
			tipogrupoactivofijo.setIsDeleted(tipogrupoactivofijo.getIsDeletedAuxiliar());	
			tipogrupoactivofijo.setIsNew(tipogrupoactivofijo.getIsNewAuxiliar());	
			tipogrupoactivofijo.setIsChanged(tipogrupoactivofijo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipogrupoactivofijo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipogrupoactivofijo.setIsDeletedAuxiliar(false);	
			tipogrupoactivofijo.setIsNewAuxiliar(false);	
			tipogrupoactivofijo.setIsChangedAuxiliar(false);
			
			tipogrupoactivofijo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGrupoActivoFijos(List<TipoGrupoActivoFijo> tipogrupoactivofijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoGrupoActivoFijo tipogrupoactivofijo : tipogrupoactivofijos) {
			if(conAsignarBase && tipogrupoactivofijo.getConCambioAuxiliar()) {
				tipogrupoactivofijo.setIsDeleted(tipogrupoactivofijo.getIsDeletedAuxiliar());	
				tipogrupoactivofijo.setIsNew(tipogrupoactivofijo.getIsNewAuxiliar());	
				tipogrupoactivofijo.setIsChanged(tipogrupoactivofijo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipogrupoactivofijo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipogrupoactivofijo.setIsDeletedAuxiliar(false);	
				tipogrupoactivofijo.setIsNewAuxiliar(false);	
				tipogrupoactivofijo.setIsChangedAuxiliar(false);
				
				tipogrupoactivofijo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoGrupoActivoFijo(TipoGrupoActivoFijo tipogrupoactivofijo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoGrupoActivoFijos(List<TipoGrupoActivoFijo> tipogrupoactivofijos,Boolean conEnteros) throws Exception  {
		
		for(TipoGrupoActivoFijo tipogrupoactivofijo: tipogrupoactivofijos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoGrupoActivoFijo(List<TipoGrupoActivoFijo> tipogrupoactivofijos,TipoGrupoActivoFijo tipogrupoactivofijoAux) throws Exception  {
		TipoGrupoActivoFijoConstantesFunciones.InicializarValoresTipoGrupoActivoFijo(tipogrupoactivofijoAux,true);
		
		for(TipoGrupoActivoFijo tipogrupoactivofijo: tipogrupoactivofijos) {
			if(tipogrupoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGrupoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoGrupoActivoFijoConstantesFunciones.getArrayColumnasGlobalesTipoGrupoActivoFijo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGrupoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoGrupoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoGrupoActivoFijo> tipogrupoactivofijos,TipoGrupoActivoFijo tipogrupoactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoGrupoActivoFijo tipogrupoactivofijoAux: tipogrupoactivofijos) {
			if(tipogrupoactivofijoAux!=null && tipogrupoactivofijo!=null) {
				if((tipogrupoactivofijoAux.getId()==null && tipogrupoactivofijo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipogrupoactivofijoAux.getId()!=null && tipogrupoactivofijo.getId()!=null){
					if(tipogrupoactivofijoAux.getId().equals(tipogrupoactivofijo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoGrupoActivoFijo(List<TipoGrupoActivoFijo> tipogrupoactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoGrupoActivoFijo tipogrupoactivofijo: tipogrupoactivofijos) {			
			if(tipogrupoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoGrupoActivoFijo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoGrupoActivoFijoConstantesFunciones.LABEL_ID, TipoGrupoActivoFijoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGrupoActivoFijoConstantesFunciones.LABEL_VERSIONROW, TipoGrupoActivoFijoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGrupoActivoFijoConstantesFunciones.LABEL_IDPAIS, TipoGrupoActivoFijoConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGrupoActivoFijoConstantesFunciones.LABEL_NOMBRE, TipoGrupoActivoFijoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoGrupoActivoFijo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoGrupoActivoFijoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGrupoActivoFijoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGrupoActivoFijoConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGrupoActivoFijoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGrupoActivoFijo() throws Exception  {
		return TipoGrupoActivoFijoConstantesFunciones.getTiposSeleccionarTipoGrupoActivoFijo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGrupoActivoFijo(Boolean conFk) throws Exception  {
		return TipoGrupoActivoFijoConstantesFunciones.getTiposSeleccionarTipoGrupoActivoFijo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGrupoActivoFijo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGrupoActivoFijoConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(TipoGrupoActivoFijoConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGrupoActivoFijoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoGrupoActivoFijoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoGrupoActivoFijo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(TipoGrupoActivoFijo tipogrupoactivofijoAux) throws Exception {
		
			tipogrupoactivofijoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipogrupoactivofijoAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(List<TipoGrupoActivoFijo> tipogrupoactivofijosTemp) throws Exception {
		for(TipoGrupoActivoFijo tipogrupoactivofijoAux:tipogrupoactivofijosTemp) {
			
			tipogrupoactivofijoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipogrupoactivofijoAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGrupoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoGrupoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGrupoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGrupoActivoFijoConstantesFunciones.getClassesRelationshipsOfTipoGrupoActivoFijo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGrupoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGrupoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGrupoActivoFijoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoGrupoActivoFijo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGrupoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoGrupoActivoFijo tipogrupoactivofijo,List<TipoGrupoActivoFijo> tipogrupoactivofijos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoGrupoActivoFijo tipogrupoactivofijoEncontrado=null;
			
			for(TipoGrupoActivoFijo tipogrupoactivofijoLocal:tipogrupoactivofijos) {
				if(tipogrupoactivofijoLocal.getId().equals(tipogrupoactivofijo.getId())) {
					tipogrupoactivofijoEncontrado=tipogrupoactivofijoLocal;
					
					tipogrupoactivofijoLocal.setIsChanged(tipogrupoactivofijo.getIsChanged());
					tipogrupoactivofijoLocal.setIsNew(tipogrupoactivofijo.getIsNew());
					tipogrupoactivofijoLocal.setIsDeleted(tipogrupoactivofijo.getIsDeleted());
					
					tipogrupoactivofijoLocal.setGeneralEntityOriginal(tipogrupoactivofijo.getGeneralEntityOriginal());
					
					tipogrupoactivofijoLocal.setId(tipogrupoactivofijo.getId());	
					tipogrupoactivofijoLocal.setVersionRow(tipogrupoactivofijo.getVersionRow());	
					tipogrupoactivofijoLocal.setid_pais(tipogrupoactivofijo.getid_pais());	
					tipogrupoactivofijoLocal.setnombre(tipogrupoactivofijo.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipogrupoactivofijo.getIsDeleted()) {
				if(!existe) {
					tipogrupoactivofijos.add(tipogrupoactivofijo);
				}
			} else {
				if(tipogrupoactivofijoEncontrado!=null && permiteQuitar)  {
					tipogrupoactivofijos.remove(tipogrupoactivofijoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoGrupoActivoFijo tipogrupoactivofijo,List<TipoGrupoActivoFijo> tipogrupoactivofijos) throws Exception {
		try	{			
			for(TipoGrupoActivoFijo tipogrupoactivofijoLocal:tipogrupoactivofijos) {
				if(tipogrupoactivofijoLocal.getId().equals(tipogrupoactivofijo.getId())) {
					tipogrupoactivofijoLocal.setIsSelected(tipogrupoactivofijo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoGrupoActivoFijo(List<TipoGrupoActivoFijo> tipogrupoactivofijosAux) throws Exception {
		//this.tipogrupoactivofijosAux=tipogrupoactivofijosAux;
		
		for(TipoGrupoActivoFijo tipogrupoactivofijoAux:tipogrupoactivofijosAux) {
			if(tipogrupoactivofijoAux.getIsChanged()) {
				tipogrupoactivofijoAux.setIsChanged(false);
			}		
			
			if(tipogrupoactivofijoAux.getIsNew()) {
				tipogrupoactivofijoAux.setIsNew(false);
			}	
			
			if(tipogrupoactivofijoAux.getIsDeleted()) {
				tipogrupoactivofijoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoGrupoActivoFijo(TipoGrupoActivoFijo tipogrupoactivofijoAux) throws Exception {
		//this.tipogrupoactivofijoAux=tipogrupoactivofijoAux;
		
			if(tipogrupoactivofijoAux.getIsChanged()) {
				tipogrupoactivofijoAux.setIsChanged(false);
			}		
			
			if(tipogrupoactivofijoAux.getIsNew()) {
				tipogrupoactivofijoAux.setIsNew(false);
			}	
			
			if(tipogrupoactivofijoAux.getIsDeleted()) {
				tipogrupoactivofijoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoGrupoActivoFijo tipogrupoactivofijoAsignar,TipoGrupoActivoFijo tipogrupoactivofijo) throws Exception {
		tipogrupoactivofijoAsignar.setId(tipogrupoactivofijo.getId());	
		tipogrupoactivofijoAsignar.setVersionRow(tipogrupoactivofijo.getVersionRow());	
		tipogrupoactivofijoAsignar.setid_pais(tipogrupoactivofijo.getid_pais());
		tipogrupoactivofijoAsignar.setpais_descripcion(tipogrupoactivofijo.getpais_descripcion());	
		tipogrupoactivofijoAsignar.setnombre(tipogrupoactivofijo.getnombre());	
	}
	
	public static void inicializarTipoGrupoActivoFijo(TipoGrupoActivoFijo tipogrupoactivofijo) throws Exception {
		try {
				tipogrupoactivofijo.setId(0L);	
					
				tipogrupoactivofijo.setid_pais(-1L);	
				tipogrupoactivofijo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoGrupoActivoFijo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGrupoActivoFijoConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGrupoActivoFijoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoGrupoActivoFijo(String sTipo,Row row,Workbook workbook,TipoGrupoActivoFijo tipogrupoactivofijo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogrupoactivofijo.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogrupoactivofijo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoGrupoActivoFijo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoGrupoActivoFijo() {
		return this.sFinalQueryTipoGrupoActivoFijo;
	}
	
	public void setsFinalQueryTipoGrupoActivoFijo(String sFinalQueryTipoGrupoActivoFijo) {
		this.sFinalQueryTipoGrupoActivoFijo= sFinalQueryTipoGrupoActivoFijo;
	}
	
	public Border resaltarSeleccionarTipoGrupoActivoFijo=null;
	
	public Border setResaltarSeleccionarTipoGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoActivoFijoBeanSwingJInternalFrame tipogrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipogrupoactivofijoBeanSwingJInternalFrame.jTtoolBarTipoGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoGrupoActivoFijo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoGrupoActivoFijo() {
		return this.resaltarSeleccionarTipoGrupoActivoFijo;
	}
	
	public void setResaltarSeleccionarTipoGrupoActivoFijo(Border borderResaltarSeleccionarTipoGrupoActivoFijo) {
		this.resaltarSeleccionarTipoGrupoActivoFijo= borderResaltarSeleccionarTipoGrupoActivoFijo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoGrupoActivoFijo=null;
	public Boolean mostraridTipoGrupoActivoFijo=true;
	public Boolean activaridTipoGrupoActivoFijo=true;

	public Border resaltarid_paisTipoGrupoActivoFijo=null;
	public Boolean mostrarid_paisTipoGrupoActivoFijo=true;
	public Boolean activarid_paisTipoGrupoActivoFijo=true;
	public Boolean cargarid_paisTipoGrupoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisTipoGrupoActivoFijo=false;//ConEventDepend=true

	public Border resaltarnombreTipoGrupoActivoFijo=null;
	public Boolean mostrarnombreTipoGrupoActivoFijo=true;
	public Boolean activarnombreTipoGrupoActivoFijo=true;

	
	

	public Border setResaltaridTipoGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoActivoFijoBeanSwingJInternalFrame tipogrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogrupoactivofijoBeanSwingJInternalFrame.jTtoolBarTipoGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltaridTipoGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoGrupoActivoFijo() {
		return this.resaltaridTipoGrupoActivoFijo;
	}

	public void setResaltaridTipoGrupoActivoFijo(Border borderResaltar) {
		this.resaltaridTipoGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostraridTipoGrupoActivoFijo() {
		return this.mostraridTipoGrupoActivoFijo;
	}

	public void setMostraridTipoGrupoActivoFijo(Boolean mostraridTipoGrupoActivoFijo) {
		this.mostraridTipoGrupoActivoFijo= mostraridTipoGrupoActivoFijo;
	}

	public Boolean getActivaridTipoGrupoActivoFijo() {
		return this.activaridTipoGrupoActivoFijo;
	}

	public void setActivaridTipoGrupoActivoFijo(Boolean activaridTipoGrupoActivoFijo) {
		this.activaridTipoGrupoActivoFijo= activaridTipoGrupoActivoFijo;
	}

	public Border setResaltarid_paisTipoGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoActivoFijoBeanSwingJInternalFrame tipogrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogrupoactivofijoBeanSwingJInternalFrame.jTtoolBarTipoGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_paisTipoGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisTipoGrupoActivoFijo() {
		return this.resaltarid_paisTipoGrupoActivoFijo;
	}

	public void setResaltarid_paisTipoGrupoActivoFijo(Border borderResaltar) {
		this.resaltarid_paisTipoGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_paisTipoGrupoActivoFijo() {
		return this.mostrarid_paisTipoGrupoActivoFijo;
	}

	public void setMostrarid_paisTipoGrupoActivoFijo(Boolean mostrarid_paisTipoGrupoActivoFijo) {
		this.mostrarid_paisTipoGrupoActivoFijo= mostrarid_paisTipoGrupoActivoFijo;
	}

	public Boolean getActivarid_paisTipoGrupoActivoFijo() {
		return this.activarid_paisTipoGrupoActivoFijo;
	}

	public void setActivarid_paisTipoGrupoActivoFijo(Boolean activarid_paisTipoGrupoActivoFijo) {
		this.activarid_paisTipoGrupoActivoFijo= activarid_paisTipoGrupoActivoFijo;
	}

	public Boolean getCargarid_paisTipoGrupoActivoFijo() {
		return this.cargarid_paisTipoGrupoActivoFijo;
	}

	public void setCargarid_paisTipoGrupoActivoFijo(Boolean cargarid_paisTipoGrupoActivoFijo) {
		this.cargarid_paisTipoGrupoActivoFijo= cargarid_paisTipoGrupoActivoFijo;
	}

	public Border setResaltarnombreTipoGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoActivoFijoBeanSwingJInternalFrame tipogrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogrupoactivofijoBeanSwingJInternalFrame.jTtoolBarTipoGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoGrupoActivoFijo() {
		return this.resaltarnombreTipoGrupoActivoFijo;
	}

	public void setResaltarnombreTipoGrupoActivoFijo(Border borderResaltar) {
		this.resaltarnombreTipoGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoGrupoActivoFijo() {
		return this.mostrarnombreTipoGrupoActivoFijo;
	}

	public void setMostrarnombreTipoGrupoActivoFijo(Boolean mostrarnombreTipoGrupoActivoFijo) {
		this.mostrarnombreTipoGrupoActivoFijo= mostrarnombreTipoGrupoActivoFijo;
	}

	public Boolean getActivarnombreTipoGrupoActivoFijo() {
		return this.activarnombreTipoGrupoActivoFijo;
	}

	public void setActivarnombreTipoGrupoActivoFijo(Boolean activarnombreTipoGrupoActivoFijo) {
		this.activarnombreTipoGrupoActivoFijo= activarnombreTipoGrupoActivoFijo;
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
		
		
		this.setMostraridTipoGrupoActivoFijo(esInicial);
		this.setMostrarid_paisTipoGrupoActivoFijo(esInicial);
		this.setMostrarnombreTipoGrupoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGrupoActivoFijoConstantesFunciones.ID)) {
				this.setMostraridTipoGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoActivoFijoConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisTipoGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoGrupoActivoFijo(esAsigna);
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
		
		
		this.setActivaridTipoGrupoActivoFijo(esInicial);
		this.setActivarid_paisTipoGrupoActivoFijo(esInicial);
		this.setActivarnombreTipoGrupoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGrupoActivoFijoConstantesFunciones.ID)) {
				this.setActivaridTipoGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoActivoFijoConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisTipoGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoGrupoActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGrupoActivoFijoBeanSwingJInternalFrame tipogrupoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoGrupoActivoFijo(esInicial);
		this.setResaltarid_paisTipoGrupoActivoFijo(esInicial);
		this.setResaltarnombreTipoGrupoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGrupoActivoFijoConstantesFunciones.ID)) {
				this.setResaltaridTipoGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoActivoFijoConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisTipoGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGrupoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoGrupoActivoFijo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGrupoActivoFijoBeanSwingJInternalFrame tipogrupoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdPaisTipoGrupoActivoFijo=true;

	public Boolean getMostrarFK_IdPaisTipoGrupoActivoFijo() {
		return this.mostrarFK_IdPaisTipoGrupoActivoFijo;
	}

	public void setMostrarFK_IdPaisTipoGrupoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisTipoGrupoActivoFijo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdPaisTipoGrupoActivoFijo=true;

	public Boolean getActivarFK_IdPaisTipoGrupoActivoFijo() {
		return this.activarFK_IdPaisTipoGrupoActivoFijo;
	}

	public void setActivarFK_IdPaisTipoGrupoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdPaisTipoGrupoActivoFijo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdPaisTipoGrupoActivoFijo=null;

	public Border getResaltarFK_IdPaisTipoGrupoActivoFijo() {
		return this.resaltarFK_IdPaisTipoGrupoActivoFijo;
	}

	public void setResaltarFK_IdPaisTipoGrupoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdPaisTipoGrupoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdPaisTipoGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGrupoActivoFijoBeanSwingJInternalFrame tipogrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisTipoGrupoActivoFijo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}