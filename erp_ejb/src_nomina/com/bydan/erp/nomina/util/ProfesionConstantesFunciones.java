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


import com.bydan.erp.nomina.util.ProfesionConstantesFunciones;
import com.bydan.erp.nomina.util.ProfesionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ProfesionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProfesionConstantesFunciones extends ProfesionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Profesion";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Profesion"+ProfesionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProfesionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProfesionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProfesionConstantesFunciones.SCHEMA+"_"+ProfesionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProfesionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProfesionConstantesFunciones.SCHEMA+"_"+ProfesionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProfesionConstantesFunciones.SCHEMA+"_"+ProfesionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProfesionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProfesionConstantesFunciones.SCHEMA+"_"+ProfesionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProfesionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProfesionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProfesionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProfesionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProfesionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProfesionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProfesionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProfesionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProfesionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProfesionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Profesiones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Profesion";
	public static final String SCLASSWEBTITULO_LOWER="Profesion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Profesion";
	public static final String OBJECTNAME="profesion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="profesion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select profesion from "+ProfesionConstantesFunciones.SPERSISTENCENAME+" profesion";
	public static String QUERYSELECTNATIVE="select "+ProfesionConstantesFunciones.SCHEMA+"."+ProfesionConstantesFunciones.TABLENAME+".id,"+ProfesionConstantesFunciones.SCHEMA+"."+ProfesionConstantesFunciones.TABLENAME+".version_row,"+ProfesionConstantesFunciones.SCHEMA+"."+ProfesionConstantesFunciones.TABLENAME+".codigo,"+ProfesionConstantesFunciones.SCHEMA+"."+ProfesionConstantesFunciones.TABLENAME+".nombre from "+ProfesionConstantesFunciones.SCHEMA+"."+ProfesionConstantesFunciones.TABLENAME;//+" as "+ProfesionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProfesionConstantesFuncionesAdditional profesionConstantesFuncionesAdditional=null;
	
	public ProfesionConstantesFuncionesAdditional getProfesionConstantesFuncionesAdditional() {
		return this.profesionConstantesFuncionesAdditional;
	}
	
	public void setProfesionConstantesFuncionesAdditional(ProfesionConstantesFuncionesAdditional profesionConstantesFuncionesAdditional) {
		try {
			this.profesionConstantesFuncionesAdditional=profesionConstantesFuncionesAdditional;
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
	
	public static String getProfesionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProfesionConstantesFunciones.CODIGO)) {sLabelColumna=ProfesionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProfesionConstantesFunciones.NOMBRE)) {sLabelColumna=ProfesionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getProfesionDescripcion(Profesion profesion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(profesion !=null/* && profesion.getId()!=0*/) {
			sDescripcion=profesion.getcodigo();//profesionprofesion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProfesionDescripcionDetallado(Profesion profesion) {
		String sDescripcion="";
			
		sDescripcion+=ProfesionConstantesFunciones.ID+"=";
		sDescripcion+=profesion.getId().toString()+",";
		sDescripcion+=ProfesionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=profesion.getVersionRow().toString()+",";
		sDescripcion+=ProfesionConstantesFunciones.CODIGO+"=";
		sDescripcion+=profesion.getcodigo()+",";
		sDescripcion+=ProfesionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=profesion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setProfesionDescripcion(Profesion profesion,String sValor) throws Exception {			
		if(profesion !=null) {
			profesion.setcodigo(sValor);;//profesionprofesion.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProfesion(Profesion profesion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		profesion.setcodigo(profesion.getcodigo().trim());
		profesion.setnombre(profesion.getnombre().trim());
	}
	
	public static void quitarEspaciosProfesions(List<Profesion> profesions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Profesion profesion: profesions) {
			profesion.setcodigo(profesion.getcodigo().trim());
			profesion.setnombre(profesion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProfesion(Profesion profesion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && profesion.getConCambioAuxiliar()) {
			profesion.setIsDeleted(profesion.getIsDeletedAuxiliar());	
			profesion.setIsNew(profesion.getIsNewAuxiliar());	
			profesion.setIsChanged(profesion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			profesion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			profesion.setIsDeletedAuxiliar(false);	
			profesion.setIsNewAuxiliar(false);	
			profesion.setIsChangedAuxiliar(false);
			
			profesion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProfesions(List<Profesion> profesions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Profesion profesion : profesions) {
			if(conAsignarBase && profesion.getConCambioAuxiliar()) {
				profesion.setIsDeleted(profesion.getIsDeletedAuxiliar());	
				profesion.setIsNew(profesion.getIsNewAuxiliar());	
				profesion.setIsChanged(profesion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				profesion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				profesion.setIsDeletedAuxiliar(false);	
				profesion.setIsNewAuxiliar(false);	
				profesion.setIsChangedAuxiliar(false);
				
				profesion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProfesion(Profesion profesion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProfesions(List<Profesion> profesions,Boolean conEnteros) throws Exception  {
		
		for(Profesion profesion: profesions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProfesion(List<Profesion> profesions,Profesion profesionAux) throws Exception  {
		ProfesionConstantesFunciones.InicializarValoresProfesion(profesionAux,true);
		
		for(Profesion profesion: profesions) {
			if(profesion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProfesion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProfesionConstantesFunciones.getArrayColumnasGlobalesProfesion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProfesion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProfesion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Profesion> profesions,Profesion profesion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Profesion profesionAux: profesions) {
			if(profesionAux!=null && profesion!=null) {
				if((profesionAux.getId()==null && profesion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(profesionAux.getId()!=null && profesion.getId()!=null){
					if(profesionAux.getId().equals(profesion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProfesion(List<Profesion> profesions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Profesion profesion: profesions) {			
			if(profesion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProfesion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProfesionConstantesFunciones.LABEL_ID, ProfesionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProfesionConstantesFunciones.LABEL_VERSIONROW, ProfesionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProfesionConstantesFunciones.LABEL_CODIGO, ProfesionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProfesionConstantesFunciones.LABEL_NOMBRE, ProfesionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProfesion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProfesionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProfesionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProfesionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProfesionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProfesion() throws Exception  {
		return ProfesionConstantesFunciones.getTiposSeleccionarProfesion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProfesion(Boolean conFk) throws Exception  {
		return ProfesionConstantesFunciones.getTiposSeleccionarProfesion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProfesion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProfesionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProfesionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProfesionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ProfesionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProfesion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProfesion(Profesion profesionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesProfesion(List<Profesion> profesionsTemp) throws Exception {
		for(Profesion profesionAux:profesionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProfesion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProfesion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProfesion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProfesionConstantesFunciones.getClassesRelationshipsOfProfesion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProfesion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(ProfesionEmplea.class));
				classes.add(new Classe(Referencia.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProfesionEmplea.class)) {
						classes.add(new Classe(ProfesionEmplea.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Referencia.class)) {
						classes.add(new Classe(Referencia.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProfesion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProfesionConstantesFunciones.getClassesRelationshipsFromStringsOfProfesion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProfesion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(ProfesionEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProfesionEmplea.class)); continue;
					}

					if(Referencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Referencia.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(ProfesionEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProfesionEmplea.class)); continue;
					}

					if(Referencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Referencia.class)); continue;
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
	public static void actualizarLista(Profesion profesion,List<Profesion> profesions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Profesion profesionEncontrado=null;
			
			for(Profesion profesionLocal:profesions) {
				if(profesionLocal.getId().equals(profesion.getId())) {
					profesionEncontrado=profesionLocal;
					
					profesionLocal.setIsChanged(profesion.getIsChanged());
					profesionLocal.setIsNew(profesion.getIsNew());
					profesionLocal.setIsDeleted(profesion.getIsDeleted());
					
					profesionLocal.setGeneralEntityOriginal(profesion.getGeneralEntityOriginal());
					
					profesionLocal.setId(profesion.getId());	
					profesionLocal.setVersionRow(profesion.getVersionRow());	
					profesionLocal.setcodigo(profesion.getcodigo());	
					profesionLocal.setnombre(profesion.getnombre());	
					
					
					profesionLocal.setClientes(profesion.getClientes());
					profesionLocal.setProfesionEmpleas(profesion.getProfesionEmpleas());
					profesionLocal.setReferencias(profesion.getReferencias());
					
					existe=true;
					break;
				}
			}
			
			if(!profesion.getIsDeleted()) {
				if(!existe) {
					profesions.add(profesion);
				}
			} else {
				if(profesionEncontrado!=null && permiteQuitar)  {
					profesions.remove(profesionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Profesion profesion,List<Profesion> profesions) throws Exception {
		try	{			
			for(Profesion profesionLocal:profesions) {
				if(profesionLocal.getId().equals(profesion.getId())) {
					profesionLocal.setIsSelected(profesion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProfesion(List<Profesion> profesionsAux) throws Exception {
		//this.profesionsAux=profesionsAux;
		
		for(Profesion profesionAux:profesionsAux) {
			if(profesionAux.getIsChanged()) {
				profesionAux.setIsChanged(false);
			}		
			
			if(profesionAux.getIsNew()) {
				profesionAux.setIsNew(false);
			}	
			
			if(profesionAux.getIsDeleted()) {
				profesionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProfesion(Profesion profesionAux) throws Exception {
		//this.profesionAux=profesionAux;
		
			if(profesionAux.getIsChanged()) {
				profesionAux.setIsChanged(false);
			}		
			
			if(profesionAux.getIsNew()) {
				profesionAux.setIsNew(false);
			}	
			
			if(profesionAux.getIsDeleted()) {
				profesionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Profesion profesionAsignar,Profesion profesion) throws Exception {
		profesionAsignar.setId(profesion.getId());	
		profesionAsignar.setVersionRow(profesion.getVersionRow());	
		profesionAsignar.setcodigo(profesion.getcodigo());	
		profesionAsignar.setnombre(profesion.getnombre());	
	}
	
	public static void inicializarProfesion(Profesion profesion) throws Exception {
		try {
				profesion.setId(0L);	
					
				profesion.setcodigo("");	
				profesion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProfesion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProfesionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProfesionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProfesion(String sTipo,Row row,Workbook workbook,Profesion profesion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(profesion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(profesion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProfesion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProfesion() {
		return this.sFinalQueryProfesion;
	}
	
	public void setsFinalQueryProfesion(String sFinalQueryProfesion) {
		this.sFinalQueryProfesion= sFinalQueryProfesion;
	}
	
	public Border resaltarSeleccionarProfesion=null;
	
	public Border setResaltarSeleccionarProfesion(ParametroGeneralUsuario parametroGeneralUsuario/*ProfesionBeanSwingJInternalFrame profesionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//profesionBeanSwingJInternalFrame.jTtoolBarProfesion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProfesion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProfesion() {
		return this.resaltarSeleccionarProfesion;
	}
	
	public void setResaltarSeleccionarProfesion(Border borderResaltarSeleccionarProfesion) {
		this.resaltarSeleccionarProfesion= borderResaltarSeleccionarProfesion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProfesion=null;
	public Boolean mostraridProfesion=true;
	public Boolean activaridProfesion=true;

	public Border resaltarcodigoProfesion=null;
	public Boolean mostrarcodigoProfesion=true;
	public Boolean activarcodigoProfesion=true;

	public Border resaltarnombreProfesion=null;
	public Boolean mostrarnombreProfesion=true;
	public Boolean activarnombreProfesion=true;

	
	

	public Border setResaltaridProfesion(ParametroGeneralUsuario parametroGeneralUsuario/*ProfesionBeanSwingJInternalFrame profesionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//profesionBeanSwingJInternalFrame.jTtoolBarProfesion.setBorder(borderResaltar);
		
		this.resaltaridProfesion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProfesion() {
		return this.resaltaridProfesion;
	}

	public void setResaltaridProfesion(Border borderResaltar) {
		this.resaltaridProfesion= borderResaltar;
	}

	public Boolean getMostraridProfesion() {
		return this.mostraridProfesion;
	}

	public void setMostraridProfesion(Boolean mostraridProfesion) {
		this.mostraridProfesion= mostraridProfesion;
	}

	public Boolean getActivaridProfesion() {
		return this.activaridProfesion;
	}

	public void setActivaridProfesion(Boolean activaridProfesion) {
		this.activaridProfesion= activaridProfesion;
	}

	public Border setResaltarcodigoProfesion(ParametroGeneralUsuario parametroGeneralUsuario/*ProfesionBeanSwingJInternalFrame profesionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//profesionBeanSwingJInternalFrame.jTtoolBarProfesion.setBorder(borderResaltar);
		
		this.resaltarcodigoProfesion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProfesion() {
		return this.resaltarcodigoProfesion;
	}

	public void setResaltarcodigoProfesion(Border borderResaltar) {
		this.resaltarcodigoProfesion= borderResaltar;
	}

	public Boolean getMostrarcodigoProfesion() {
		return this.mostrarcodigoProfesion;
	}

	public void setMostrarcodigoProfesion(Boolean mostrarcodigoProfesion) {
		this.mostrarcodigoProfesion= mostrarcodigoProfesion;
	}

	public Boolean getActivarcodigoProfesion() {
		return this.activarcodigoProfesion;
	}

	public void setActivarcodigoProfesion(Boolean activarcodigoProfesion) {
		this.activarcodigoProfesion= activarcodigoProfesion;
	}

	public Border setResaltarnombreProfesion(ParametroGeneralUsuario parametroGeneralUsuario/*ProfesionBeanSwingJInternalFrame profesionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//profesionBeanSwingJInternalFrame.jTtoolBarProfesion.setBorder(borderResaltar);
		
		this.resaltarnombreProfesion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreProfesion() {
		return this.resaltarnombreProfesion;
	}

	public void setResaltarnombreProfesion(Border borderResaltar) {
		this.resaltarnombreProfesion= borderResaltar;
	}

	public Boolean getMostrarnombreProfesion() {
		return this.mostrarnombreProfesion;
	}

	public void setMostrarnombreProfesion(Boolean mostrarnombreProfesion) {
		this.mostrarnombreProfesion= mostrarnombreProfesion;
	}

	public Boolean getActivarnombreProfesion() {
		return this.activarnombreProfesion;
	}

	public void setActivarnombreProfesion(Boolean activarnombreProfesion) {
		this.activarnombreProfesion= activarnombreProfesion;
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
		
		
		this.setMostraridProfesion(esInicial);
		this.setMostrarcodigoProfesion(esInicial);
		this.setMostrarnombreProfesion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProfesionConstantesFunciones.ID)) {
				this.setMostraridProfesion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProfesionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProfesion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProfesionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreProfesion(esAsigna);
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
		
		
		this.setActivaridProfesion(esInicial);
		this.setActivarcodigoProfesion(esInicial);
		this.setActivarnombreProfesion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProfesionConstantesFunciones.ID)) {
				this.setActivaridProfesion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProfesionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProfesion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProfesionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreProfesion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProfesionBeanSwingJInternalFrame profesionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProfesion(esInicial);
		this.setResaltarcodigoProfesion(esInicial);
		this.setResaltarnombreProfesion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProfesionConstantesFunciones.ID)) {
				this.setResaltaridProfesion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProfesionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProfesion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProfesionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreProfesion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarClienteProfesion=null;

	public Border getResaltarClienteProfesion() {
		return this.resaltarClienteProfesion;
	}

	public void setResaltarClienteProfesion(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteProfesion= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteProfesion(ParametroGeneralUsuario parametroGeneralUsuario/*ProfesionBeanSwingJInternalFrame profesionBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//profesionBeanSwingJInternalFrame.jTtoolBarProfesion.setBorder(borderResaltarCliente);
			
		this.resaltarClienteProfesion= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteProfesion=true;

	public Boolean getMostrarClienteProfesion() {
		return this.mostrarClienteProfesion;
	}

	public void setMostrarClienteProfesion(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteProfesion= visibilidadResaltarCliente;
	}



	public Boolean activarClienteProfesion=true;

	public Boolean gethabilitarResaltarClienteProfesion() {
		return this.activarClienteProfesion;
	}

	public void setActivarClienteProfesion(Boolean habilitarResaltarCliente) {
		this.activarClienteProfesion= habilitarResaltarCliente;
	}


	public Border resaltarProfesionEmpleaProfesion=null;

	public Border getResaltarProfesionEmpleaProfesion() {
		return this.resaltarProfesionEmpleaProfesion;
	}

	public void setResaltarProfesionEmpleaProfesion(Border borderResaltarProfesionEmplea) {
		if(borderResaltarProfesionEmplea!=null) {
			this.resaltarProfesionEmpleaProfesion= borderResaltarProfesionEmplea;
		}
	}

	public Border setResaltarProfesionEmpleaProfesion(ParametroGeneralUsuario parametroGeneralUsuario/*ProfesionBeanSwingJInternalFrame profesionBeanSwingJInternalFrame*/) {
		Border borderResaltarProfesionEmplea=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//profesionBeanSwingJInternalFrame.jTtoolBarProfesion.setBorder(borderResaltarProfesionEmplea);
			
		this.resaltarProfesionEmpleaProfesion= borderResaltarProfesionEmplea;

		 return borderResaltarProfesionEmplea;
	}



	public Boolean mostrarProfesionEmpleaProfesion=true;

	public Boolean getMostrarProfesionEmpleaProfesion() {
		return this.mostrarProfesionEmpleaProfesion;
	}

	public void setMostrarProfesionEmpleaProfesion(Boolean visibilidadResaltarProfesionEmplea) {
		this.mostrarProfesionEmpleaProfesion= visibilidadResaltarProfesionEmplea;
	}



	public Boolean activarProfesionEmpleaProfesion=true;

	public Boolean gethabilitarResaltarProfesionEmpleaProfesion() {
		return this.activarProfesionEmpleaProfesion;
	}

	public void setActivarProfesionEmpleaProfesion(Boolean habilitarResaltarProfesionEmplea) {
		this.activarProfesionEmpleaProfesion= habilitarResaltarProfesionEmplea;
	}


	public Border resaltarReferenciaProfesion=null;

	public Border getResaltarReferenciaProfesion() {
		return this.resaltarReferenciaProfesion;
	}

	public void setResaltarReferenciaProfesion(Border borderResaltarReferencia) {
		if(borderResaltarReferencia!=null) {
			this.resaltarReferenciaProfesion= borderResaltarReferencia;
		}
	}

	public Border setResaltarReferenciaProfesion(ParametroGeneralUsuario parametroGeneralUsuario/*ProfesionBeanSwingJInternalFrame profesionBeanSwingJInternalFrame*/) {
		Border borderResaltarReferencia=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//profesionBeanSwingJInternalFrame.jTtoolBarProfesion.setBorder(borderResaltarReferencia);
			
		this.resaltarReferenciaProfesion= borderResaltarReferencia;

		 return borderResaltarReferencia;
	}



	public Boolean mostrarReferenciaProfesion=true;

	public Boolean getMostrarReferenciaProfesion() {
		return this.mostrarReferenciaProfesion;
	}

	public void setMostrarReferenciaProfesion(Boolean visibilidadResaltarReferencia) {
		this.mostrarReferenciaProfesion= visibilidadResaltarReferencia;
	}



	public Boolean activarReferenciaProfesion=true;

	public Boolean gethabilitarResaltarReferenciaProfesion() {
		return this.activarReferenciaProfesion;
	}

	public void setActivarReferenciaProfesion(Boolean habilitarResaltarReferencia) {
		this.activarReferenciaProfesion= habilitarResaltarReferencia;
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

		this.setMostrarClienteProfesion(esInicial);
		this.setMostrarProfesionEmpleaProfesion(esInicial);
		this.setMostrarReferenciaProfesion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteProfesion(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProfesionEmplea.class)) {
				this.setMostrarProfesionEmpleaProfesion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Referencia.class)) {
				this.setMostrarReferenciaProfesion(esAsigna);
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

		this.setActivarClienteProfesion(esInicial);
		this.setActivarProfesionEmpleaProfesion(esInicial);
		this.setActivarReferenciaProfesion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteProfesion(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProfesionEmplea.class)) {
				this.setActivarProfesionEmpleaProfesion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Referencia.class)) {
				this.setActivarReferenciaProfesion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProfesionBeanSwingJInternalFrame profesionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarClienteProfesion(esInicial);
		this.setResaltarProfesionEmpleaProfesion(esInicial);
		this.setResaltarReferenciaProfesion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteProfesion(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProfesionEmplea.class)) {
				this.setResaltarProfesionEmpleaProfesion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Referencia.class)) {
				this.setResaltarReferenciaProfesion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoProfesion=true;

	public Boolean getMostrarBusquedaPorCodigoProfesion() {
		return this.mostrarBusquedaPorCodigoProfesion;
	}

	public void setMostrarBusquedaPorCodigoProfesion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoProfesion= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreProfesion=true;

	public Boolean getMostrarBusquedaPorNombreProfesion() {
		return this.mostrarBusquedaPorNombreProfesion;
	}

	public void setMostrarBusquedaPorNombreProfesion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreProfesion= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoProfesion=true;

	public Boolean getActivarBusquedaPorCodigoProfesion() {
		return this.activarBusquedaPorCodigoProfesion;
	}

	public void setActivarBusquedaPorCodigoProfesion(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoProfesion= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreProfesion=true;

	public Boolean getActivarBusquedaPorNombreProfesion() {
		return this.activarBusquedaPorNombreProfesion;
	}

	public void setActivarBusquedaPorNombreProfesion(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreProfesion= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoProfesion=null;

	public Border getResaltarBusquedaPorCodigoProfesion() {
		return this.resaltarBusquedaPorCodigoProfesion;
	}

	public void setResaltarBusquedaPorCodigoProfesion(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoProfesion= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoProfesion(ParametroGeneralUsuario parametroGeneralUsuario/*ProfesionBeanSwingJInternalFrame profesionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoProfesion= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreProfesion=null;

	public Border getResaltarBusquedaPorNombreProfesion() {
		return this.resaltarBusquedaPorNombreProfesion;
	}

	public void setResaltarBusquedaPorNombreProfesion(Border borderResaltar) {
		this.resaltarBusquedaPorNombreProfesion= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreProfesion(ParametroGeneralUsuario parametroGeneralUsuario/*ProfesionBeanSwingJInternalFrame profesionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreProfesion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}