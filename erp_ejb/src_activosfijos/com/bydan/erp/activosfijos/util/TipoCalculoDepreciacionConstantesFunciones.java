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


import com.bydan.erp.activosfijos.util.TipoCalculoDepreciacionConstantesFunciones;
import com.bydan.erp.activosfijos.util.TipoCalculoDepreciacionParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.TipoCalculoDepreciacionParameterGeneral;

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
final public class TipoCalculoDepreciacionConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCalculoDepreciacion";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCalculoDepreciacion"+TipoCalculoDepreciacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCalculoDepreciacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCalculoDepreciacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCalculoDepreciacionConstantesFunciones.SCHEMA+"_"+TipoCalculoDepreciacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCalculoDepreciacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCalculoDepreciacionConstantesFunciones.SCHEMA+"_"+TipoCalculoDepreciacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCalculoDepreciacionConstantesFunciones.SCHEMA+"_"+TipoCalculoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCalculoDepreciacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCalculoDepreciacionConstantesFunciones.SCHEMA+"_"+TipoCalculoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCalculoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCalculoDepreciacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCalculoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCalculoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCalculoDepreciacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCalculoDepreciacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCalculoDepreciacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCalculoDepreciacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCalculoDepreciacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCalculoDepreciacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Calculo Depreciacions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Calculo Depreciacion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Calculo Depreciacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCalculoDepreciacion";
	public static final String OBJECTNAME="tipocalculodepreciacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="tipo_calculo_depreciacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocalculodepreciacion from "+TipoCalculoDepreciacionConstantesFunciones.SPERSISTENCENAME+" tipocalculodepreciacion";
	public static String QUERYSELECTNATIVE="select "+TipoCalculoDepreciacionConstantesFunciones.SCHEMA+"."+TipoCalculoDepreciacionConstantesFunciones.TABLENAME+".id,"+TipoCalculoDepreciacionConstantesFunciones.SCHEMA+"."+TipoCalculoDepreciacionConstantesFunciones.TABLENAME+".version_row,"+TipoCalculoDepreciacionConstantesFunciones.SCHEMA+"."+TipoCalculoDepreciacionConstantesFunciones.TABLENAME+".id_pais,"+TipoCalculoDepreciacionConstantesFunciones.SCHEMA+"."+TipoCalculoDepreciacionConstantesFunciones.TABLENAME+".nombre from "+TipoCalculoDepreciacionConstantesFunciones.SCHEMA+"."+TipoCalculoDepreciacionConstantesFunciones.TABLENAME;//+" as "+TipoCalculoDepreciacionConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoCalculoDepreciacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCalculoDepreciacionConstantesFunciones.IDPAIS)) {sLabelColumna=TipoCalculoDepreciacionConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(TipoCalculoDepreciacionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCalculoDepreciacionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoCalculoDepreciacionDescripcion(TipoCalculoDepreciacion tipocalculodepreciacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocalculodepreciacion !=null/* && tipocalculodepreciacion.getId()!=0*/) {
			sDescripcion=tipocalculodepreciacion.getnombre();//tipocalculodepreciaciontipocalculodepreciacion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCalculoDepreciacionDescripcionDetallado(TipoCalculoDepreciacion tipocalculodepreciacion) {
		String sDescripcion="";
			
		sDescripcion+=TipoCalculoDepreciacionConstantesFunciones.ID+"=";
		sDescripcion+=tipocalculodepreciacion.getId().toString()+",";
		sDescripcion+=TipoCalculoDepreciacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocalculodepreciacion.getVersionRow().toString()+",";
		sDescripcion+=TipoCalculoDepreciacionConstantesFunciones.IDPAIS+"=";
		sDescripcion+=tipocalculodepreciacion.getid_pais().toString()+",";
		sDescripcion+=TipoCalculoDepreciacionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocalculodepreciacion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCalculoDepreciacionDescripcion(TipoCalculoDepreciacion tipocalculodepreciacion,String sValor) throws Exception {			
		if(tipocalculodepreciacion !=null) {
			tipocalculodepreciacion.setnombre(sValor);//tipocalculodepreciaciontipocalculodepreciacion.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoCalculoDepreciacion(TipoCalculoDepreciacion tipocalculodepreciacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocalculodepreciacion.setnombre(tipocalculodepreciacion.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCalculoDepreciacions(List<TipoCalculoDepreciacion> tipocalculodepreciacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCalculoDepreciacion tipocalculodepreciacion: tipocalculodepreciacions) {
			tipocalculodepreciacion.setnombre(tipocalculodepreciacion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCalculoDepreciacion(TipoCalculoDepreciacion tipocalculodepreciacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocalculodepreciacion.getConCambioAuxiliar()) {
			tipocalculodepreciacion.setIsDeleted(tipocalculodepreciacion.getIsDeletedAuxiliar());	
			tipocalculodepreciacion.setIsNew(tipocalculodepreciacion.getIsNewAuxiliar());	
			tipocalculodepreciacion.setIsChanged(tipocalculodepreciacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocalculodepreciacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocalculodepreciacion.setIsDeletedAuxiliar(false);	
			tipocalculodepreciacion.setIsNewAuxiliar(false);	
			tipocalculodepreciacion.setIsChangedAuxiliar(false);
			
			tipocalculodepreciacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCalculoDepreciacions(List<TipoCalculoDepreciacion> tipocalculodepreciacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCalculoDepreciacion tipocalculodepreciacion : tipocalculodepreciacions) {
			if(conAsignarBase && tipocalculodepreciacion.getConCambioAuxiliar()) {
				tipocalculodepreciacion.setIsDeleted(tipocalculodepreciacion.getIsDeletedAuxiliar());	
				tipocalculodepreciacion.setIsNew(tipocalculodepreciacion.getIsNewAuxiliar());	
				tipocalculodepreciacion.setIsChanged(tipocalculodepreciacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocalculodepreciacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocalculodepreciacion.setIsDeletedAuxiliar(false);	
				tipocalculodepreciacion.setIsNewAuxiliar(false);	
				tipocalculodepreciacion.setIsChangedAuxiliar(false);
				
				tipocalculodepreciacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCalculoDepreciacion(TipoCalculoDepreciacion tipocalculodepreciacion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCalculoDepreciacions(List<TipoCalculoDepreciacion> tipocalculodepreciacions,Boolean conEnteros) throws Exception  {
		
		for(TipoCalculoDepreciacion tipocalculodepreciacion: tipocalculodepreciacions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCalculoDepreciacion(List<TipoCalculoDepreciacion> tipocalculodepreciacions,TipoCalculoDepreciacion tipocalculodepreciacionAux) throws Exception  {
		TipoCalculoDepreciacionConstantesFunciones.InicializarValoresTipoCalculoDepreciacion(tipocalculodepreciacionAux,true);
		
		for(TipoCalculoDepreciacion tipocalculodepreciacion: tipocalculodepreciacions) {
			if(tipocalculodepreciacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCalculoDepreciacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCalculoDepreciacionConstantesFunciones.getArrayColumnasGlobalesTipoCalculoDepreciacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCalculoDepreciacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCalculoDepreciacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCalculoDepreciacion> tipocalculodepreciacions,TipoCalculoDepreciacion tipocalculodepreciacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCalculoDepreciacion tipocalculodepreciacionAux: tipocalculodepreciacions) {
			if(tipocalculodepreciacionAux!=null && tipocalculodepreciacion!=null) {
				if((tipocalculodepreciacionAux.getId()==null && tipocalculodepreciacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocalculodepreciacionAux.getId()!=null && tipocalculodepreciacion.getId()!=null){
					if(tipocalculodepreciacionAux.getId().equals(tipocalculodepreciacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCalculoDepreciacion(List<TipoCalculoDepreciacion> tipocalculodepreciacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCalculoDepreciacion tipocalculodepreciacion: tipocalculodepreciacions) {			
			if(tipocalculodepreciacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCalculoDepreciacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCalculoDepreciacionConstantesFunciones.LABEL_ID, TipoCalculoDepreciacionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCalculoDepreciacionConstantesFunciones.LABEL_VERSIONROW, TipoCalculoDepreciacionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCalculoDepreciacionConstantesFunciones.LABEL_IDPAIS, TipoCalculoDepreciacionConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCalculoDepreciacionConstantesFunciones.LABEL_NOMBRE, TipoCalculoDepreciacionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCalculoDepreciacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCalculoDepreciacionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCalculoDepreciacionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCalculoDepreciacionConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCalculoDepreciacionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCalculoDepreciacion() throws Exception  {
		return TipoCalculoDepreciacionConstantesFunciones.getTiposSeleccionarTipoCalculoDepreciacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCalculoDepreciacion(Boolean conFk) throws Exception  {
		return TipoCalculoDepreciacionConstantesFunciones.getTiposSeleccionarTipoCalculoDepreciacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCalculoDepreciacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCalculoDepreciacionConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(TipoCalculoDepreciacionConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCalculoDepreciacionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCalculoDepreciacionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCalculoDepreciacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(TipoCalculoDepreciacion tipocalculodepreciacionAux) throws Exception {
		
			tipocalculodepreciacionAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipocalculodepreciacionAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(List<TipoCalculoDepreciacion> tipocalculodepreciacionsTemp) throws Exception {
		for(TipoCalculoDepreciacion tipocalculodepreciacionAux:tipocalculodepreciacionsTemp) {
			
			tipocalculodepreciacionAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipocalculodepreciacionAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCalculoDepreciacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCalculoDepreciacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCalculoDepreciacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCalculoDepreciacionConstantesFunciones.getClassesRelationshipsOfTipoCalculoDepreciacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCalculoDepreciacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCalculoDepreciacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCalculoDepreciacionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCalculoDepreciacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCalculoDepreciacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoCalculoDepreciacion tipocalculodepreciacion,List<TipoCalculoDepreciacion> tipocalculodepreciacions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCalculoDepreciacion tipocalculodepreciacionEncontrado=null;
			
			for(TipoCalculoDepreciacion tipocalculodepreciacionLocal:tipocalculodepreciacions) {
				if(tipocalculodepreciacionLocal.getId().equals(tipocalculodepreciacion.getId())) {
					tipocalculodepreciacionEncontrado=tipocalculodepreciacionLocal;
					
					tipocalculodepreciacionLocal.setIsChanged(tipocalculodepreciacion.getIsChanged());
					tipocalculodepreciacionLocal.setIsNew(tipocalculodepreciacion.getIsNew());
					tipocalculodepreciacionLocal.setIsDeleted(tipocalculodepreciacion.getIsDeleted());
					
					tipocalculodepreciacionLocal.setGeneralEntityOriginal(tipocalculodepreciacion.getGeneralEntityOriginal());
					
					tipocalculodepreciacionLocal.setId(tipocalculodepreciacion.getId());	
					tipocalculodepreciacionLocal.setVersionRow(tipocalculodepreciacion.getVersionRow());	
					tipocalculodepreciacionLocal.setid_pais(tipocalculodepreciacion.getid_pais());	
					tipocalculodepreciacionLocal.setnombre(tipocalculodepreciacion.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipocalculodepreciacion.getIsDeleted()) {
				if(!existe) {
					tipocalculodepreciacions.add(tipocalculodepreciacion);
				}
			} else {
				if(tipocalculodepreciacionEncontrado!=null && permiteQuitar)  {
					tipocalculodepreciacions.remove(tipocalculodepreciacionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCalculoDepreciacion tipocalculodepreciacion,List<TipoCalculoDepreciacion> tipocalculodepreciacions) throws Exception {
		try	{			
			for(TipoCalculoDepreciacion tipocalculodepreciacionLocal:tipocalculodepreciacions) {
				if(tipocalculodepreciacionLocal.getId().equals(tipocalculodepreciacion.getId())) {
					tipocalculodepreciacionLocal.setIsSelected(tipocalculodepreciacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCalculoDepreciacion(List<TipoCalculoDepreciacion> tipocalculodepreciacionsAux) throws Exception {
		//this.tipocalculodepreciacionsAux=tipocalculodepreciacionsAux;
		
		for(TipoCalculoDepreciacion tipocalculodepreciacionAux:tipocalculodepreciacionsAux) {
			if(tipocalculodepreciacionAux.getIsChanged()) {
				tipocalculodepreciacionAux.setIsChanged(false);
			}		
			
			if(tipocalculodepreciacionAux.getIsNew()) {
				tipocalculodepreciacionAux.setIsNew(false);
			}	
			
			if(tipocalculodepreciacionAux.getIsDeleted()) {
				tipocalculodepreciacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCalculoDepreciacion(TipoCalculoDepreciacion tipocalculodepreciacionAux) throws Exception {
		//this.tipocalculodepreciacionAux=tipocalculodepreciacionAux;
		
			if(tipocalculodepreciacionAux.getIsChanged()) {
				tipocalculodepreciacionAux.setIsChanged(false);
			}		
			
			if(tipocalculodepreciacionAux.getIsNew()) {
				tipocalculodepreciacionAux.setIsNew(false);
			}	
			
			if(tipocalculodepreciacionAux.getIsDeleted()) {
				tipocalculodepreciacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCalculoDepreciacion tipocalculodepreciacionAsignar,TipoCalculoDepreciacion tipocalculodepreciacion) throws Exception {
		tipocalculodepreciacionAsignar.setId(tipocalculodepreciacion.getId());	
		tipocalculodepreciacionAsignar.setVersionRow(tipocalculodepreciacion.getVersionRow());	
		tipocalculodepreciacionAsignar.setid_pais(tipocalculodepreciacion.getid_pais());
		tipocalculodepreciacionAsignar.setpais_descripcion(tipocalculodepreciacion.getpais_descripcion());	
		tipocalculodepreciacionAsignar.setnombre(tipocalculodepreciacion.getnombre());	
	}
	
	public static void inicializarTipoCalculoDepreciacion(TipoCalculoDepreciacion tipocalculodepreciacion) throws Exception {
		try {
				tipocalculodepreciacion.setId(0L);	
					
				tipocalculodepreciacion.setid_pais(-1L);	
				tipocalculodepreciacion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCalculoDepreciacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCalculoDepreciacionConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCalculoDepreciacionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCalculoDepreciacion(String sTipo,Row row,Workbook workbook,TipoCalculoDepreciacion tipocalculodepreciacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocalculodepreciacion.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocalculodepreciacion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCalculoDepreciacion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCalculoDepreciacion() {
		return this.sFinalQueryTipoCalculoDepreciacion;
	}
	
	public void setsFinalQueryTipoCalculoDepreciacion(String sFinalQueryTipoCalculoDepreciacion) {
		this.sFinalQueryTipoCalculoDepreciacion= sFinalQueryTipoCalculoDepreciacion;
	}
	
	public Border resaltarSeleccionarTipoCalculoDepreciacion=null;
	
	public Border setResaltarSeleccionarTipoCalculoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCalculoDepreciacionBeanSwingJInternalFrame tipocalculodepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocalculodepreciacionBeanSwingJInternalFrame.jTtoolBarTipoCalculoDepreciacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCalculoDepreciacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCalculoDepreciacion() {
		return this.resaltarSeleccionarTipoCalculoDepreciacion;
	}
	
	public void setResaltarSeleccionarTipoCalculoDepreciacion(Border borderResaltarSeleccionarTipoCalculoDepreciacion) {
		this.resaltarSeleccionarTipoCalculoDepreciacion= borderResaltarSeleccionarTipoCalculoDepreciacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCalculoDepreciacion=null;
	public Boolean mostraridTipoCalculoDepreciacion=true;
	public Boolean activaridTipoCalculoDepreciacion=true;

	public Border resaltarid_paisTipoCalculoDepreciacion=null;
	public Boolean mostrarid_paisTipoCalculoDepreciacion=true;
	public Boolean activarid_paisTipoCalculoDepreciacion=true;
	public Boolean cargarid_paisTipoCalculoDepreciacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisTipoCalculoDepreciacion=false;//ConEventDepend=true

	public Border resaltarnombreTipoCalculoDepreciacion=null;
	public Boolean mostrarnombreTipoCalculoDepreciacion=true;
	public Boolean activarnombreTipoCalculoDepreciacion=true;

	
	

	public Border setResaltaridTipoCalculoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCalculoDepreciacionBeanSwingJInternalFrame tipocalculodepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocalculodepreciacionBeanSwingJInternalFrame.jTtoolBarTipoCalculoDepreciacion.setBorder(borderResaltar);
		
		this.resaltaridTipoCalculoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCalculoDepreciacion() {
		return this.resaltaridTipoCalculoDepreciacion;
	}

	public void setResaltaridTipoCalculoDepreciacion(Border borderResaltar) {
		this.resaltaridTipoCalculoDepreciacion= borderResaltar;
	}

	public Boolean getMostraridTipoCalculoDepreciacion() {
		return this.mostraridTipoCalculoDepreciacion;
	}

	public void setMostraridTipoCalculoDepreciacion(Boolean mostraridTipoCalculoDepreciacion) {
		this.mostraridTipoCalculoDepreciacion= mostraridTipoCalculoDepreciacion;
	}

	public Boolean getActivaridTipoCalculoDepreciacion() {
		return this.activaridTipoCalculoDepreciacion;
	}

	public void setActivaridTipoCalculoDepreciacion(Boolean activaridTipoCalculoDepreciacion) {
		this.activaridTipoCalculoDepreciacion= activaridTipoCalculoDepreciacion;
	}

	public Border setResaltarid_paisTipoCalculoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCalculoDepreciacionBeanSwingJInternalFrame tipocalculodepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocalculodepreciacionBeanSwingJInternalFrame.jTtoolBarTipoCalculoDepreciacion.setBorder(borderResaltar);
		
		this.resaltarid_paisTipoCalculoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisTipoCalculoDepreciacion() {
		return this.resaltarid_paisTipoCalculoDepreciacion;
	}

	public void setResaltarid_paisTipoCalculoDepreciacion(Border borderResaltar) {
		this.resaltarid_paisTipoCalculoDepreciacion= borderResaltar;
	}

	public Boolean getMostrarid_paisTipoCalculoDepreciacion() {
		return this.mostrarid_paisTipoCalculoDepreciacion;
	}

	public void setMostrarid_paisTipoCalculoDepreciacion(Boolean mostrarid_paisTipoCalculoDepreciacion) {
		this.mostrarid_paisTipoCalculoDepreciacion= mostrarid_paisTipoCalculoDepreciacion;
	}

	public Boolean getActivarid_paisTipoCalculoDepreciacion() {
		return this.activarid_paisTipoCalculoDepreciacion;
	}

	public void setActivarid_paisTipoCalculoDepreciacion(Boolean activarid_paisTipoCalculoDepreciacion) {
		this.activarid_paisTipoCalculoDepreciacion= activarid_paisTipoCalculoDepreciacion;
	}

	public Boolean getCargarid_paisTipoCalculoDepreciacion() {
		return this.cargarid_paisTipoCalculoDepreciacion;
	}

	public void setCargarid_paisTipoCalculoDepreciacion(Boolean cargarid_paisTipoCalculoDepreciacion) {
		this.cargarid_paisTipoCalculoDepreciacion= cargarid_paisTipoCalculoDepreciacion;
	}

	public Border setResaltarnombreTipoCalculoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCalculoDepreciacionBeanSwingJInternalFrame tipocalculodepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocalculodepreciacionBeanSwingJInternalFrame.jTtoolBarTipoCalculoDepreciacion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCalculoDepreciacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCalculoDepreciacion() {
		return this.resaltarnombreTipoCalculoDepreciacion;
	}

	public void setResaltarnombreTipoCalculoDepreciacion(Border borderResaltar) {
		this.resaltarnombreTipoCalculoDepreciacion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCalculoDepreciacion() {
		return this.mostrarnombreTipoCalculoDepreciacion;
	}

	public void setMostrarnombreTipoCalculoDepreciacion(Boolean mostrarnombreTipoCalculoDepreciacion) {
		this.mostrarnombreTipoCalculoDepreciacion= mostrarnombreTipoCalculoDepreciacion;
	}

	public Boolean getActivarnombreTipoCalculoDepreciacion() {
		return this.activarnombreTipoCalculoDepreciacion;
	}

	public void setActivarnombreTipoCalculoDepreciacion(Boolean activarnombreTipoCalculoDepreciacion) {
		this.activarnombreTipoCalculoDepreciacion= activarnombreTipoCalculoDepreciacion;
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
		
		
		this.setMostraridTipoCalculoDepreciacion(esInicial);
		this.setMostrarid_paisTipoCalculoDepreciacion(esInicial);
		this.setMostrarnombreTipoCalculoDepreciacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCalculoDepreciacionConstantesFunciones.ID)) {
				this.setMostraridTipoCalculoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalculoDepreciacionConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisTipoCalculoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalculoDepreciacionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCalculoDepreciacion(esAsigna);
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
		
		
		this.setActivaridTipoCalculoDepreciacion(esInicial);
		this.setActivarid_paisTipoCalculoDepreciacion(esInicial);
		this.setActivarnombreTipoCalculoDepreciacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCalculoDepreciacionConstantesFunciones.ID)) {
				this.setActivaridTipoCalculoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalculoDepreciacionConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisTipoCalculoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalculoDepreciacionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCalculoDepreciacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCalculoDepreciacionBeanSwingJInternalFrame tipocalculodepreciacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCalculoDepreciacion(esInicial);
		this.setResaltarid_paisTipoCalculoDepreciacion(esInicial);
		this.setResaltarnombreTipoCalculoDepreciacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCalculoDepreciacionConstantesFunciones.ID)) {
				this.setResaltaridTipoCalculoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalculoDepreciacionConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisTipoCalculoDepreciacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCalculoDepreciacionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCalculoDepreciacion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCalculoDepreciacionBeanSwingJInternalFrame tipocalculodepreciacionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdPaisTipoCalculoDepreciacion=true;

	public Boolean getMostrarFK_IdPaisTipoCalculoDepreciacion() {
		return this.mostrarFK_IdPaisTipoCalculoDepreciacion;
	}

	public void setMostrarFK_IdPaisTipoCalculoDepreciacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisTipoCalculoDepreciacion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdPaisTipoCalculoDepreciacion=true;

	public Boolean getActivarFK_IdPaisTipoCalculoDepreciacion() {
		return this.activarFK_IdPaisTipoCalculoDepreciacion;
	}

	public void setActivarFK_IdPaisTipoCalculoDepreciacion(Boolean habilitarResaltar) {
		this.activarFK_IdPaisTipoCalculoDepreciacion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdPaisTipoCalculoDepreciacion=null;

	public Border getResaltarFK_IdPaisTipoCalculoDepreciacion() {
		return this.resaltarFK_IdPaisTipoCalculoDepreciacion;
	}

	public void setResaltarFK_IdPaisTipoCalculoDepreciacion(Border borderResaltar) {
		this.resaltarFK_IdPaisTipoCalculoDepreciacion= borderResaltar;
	}

	public void setResaltarFK_IdPaisTipoCalculoDepreciacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCalculoDepreciacionBeanSwingJInternalFrame tipocalculodepreciacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisTipoCalculoDepreciacion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}