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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.NivelLineaConstantesFunciones;
import com.bydan.erp.inventario.util.NivelLineaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.NivelLineaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class NivelLineaConstantesFunciones extends NivelLineaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="NivelLinea";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="NivelLinea"+NivelLineaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="NivelLineaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="NivelLineaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=NivelLineaConstantesFunciones.SCHEMA+"_"+NivelLineaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/NivelLineaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=NivelLineaConstantesFunciones.SCHEMA+"_"+NivelLineaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=NivelLineaConstantesFunciones.SCHEMA+"_"+NivelLineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/NivelLineaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=NivelLineaConstantesFunciones.SCHEMA+"_"+NivelLineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NivelLineaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NivelLineaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NivelLineaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NivelLineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NivelLineaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NivelLineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=NivelLineaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+NivelLineaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=NivelLineaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+NivelLineaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Nivel Lineas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Nivel Linea";
	public static final String SCLASSWEBTITULO_LOWER="Nivel Linea";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="NivelLinea";
	public static final String OBJECTNAME="nivellinea";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="nivel_linea";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select nivellinea from "+NivelLineaConstantesFunciones.SPERSISTENCENAME+" nivellinea";
	public static String QUERYSELECTNATIVE="select "+NivelLineaConstantesFunciones.SCHEMA+"."+NivelLineaConstantesFunciones.TABLENAME+".id,"+NivelLineaConstantesFunciones.SCHEMA+"."+NivelLineaConstantesFunciones.TABLENAME+".version_row,"+NivelLineaConstantesFunciones.SCHEMA+"."+NivelLineaConstantesFunciones.TABLENAME+".nombre from "+NivelLineaConstantesFunciones.SCHEMA+"."+NivelLineaConstantesFunciones.TABLENAME;//+" as "+NivelLineaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected NivelLineaConstantesFuncionesAdditional nivellineaConstantesFuncionesAdditional=null;
	
	public NivelLineaConstantesFuncionesAdditional getNivelLineaConstantesFuncionesAdditional() {
		return this.nivellineaConstantesFuncionesAdditional;
	}
	
	public void setNivelLineaConstantesFuncionesAdditional(NivelLineaConstantesFuncionesAdditional nivellineaConstantesFuncionesAdditional) {
		try {
			this.nivellineaConstantesFuncionesAdditional=nivellineaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getNivelLineaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(NivelLineaConstantesFunciones.NOMBRE)) {sLabelColumna=NivelLineaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getNivelLineaDescripcion(NivelLinea nivellinea) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(nivellinea !=null/* && nivellinea.getId()!=0*/) {
			sDescripcion=nivellinea.getnombre();//nivellineanivellinea.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getNivelLineaDescripcionDetallado(NivelLinea nivellinea) {
		String sDescripcion="";
			
		sDescripcion+=NivelLineaConstantesFunciones.ID+"=";
		sDescripcion+=nivellinea.getId().toString()+",";
		sDescripcion+=NivelLineaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=nivellinea.getVersionRow().toString()+",";
		sDescripcion+=NivelLineaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=nivellinea.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setNivelLineaDescripcion(NivelLinea nivellinea,String sValor) throws Exception {			
		if(nivellinea !=null) {
			nivellinea.setnombre(sValor);//nivellineanivellinea.getId().toString();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosNivelLinea(NivelLinea nivellinea,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		nivellinea.setnombre(nivellinea.getnombre().trim());
	}
	
	public static void quitarEspaciosNivelLineas(List<NivelLinea> nivellineas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(NivelLinea nivellinea: nivellineas) {
			nivellinea.setnombre(nivellinea.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNivelLinea(NivelLinea nivellinea,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && nivellinea.getConCambioAuxiliar()) {
			nivellinea.setIsDeleted(nivellinea.getIsDeletedAuxiliar());	
			nivellinea.setIsNew(nivellinea.getIsNewAuxiliar());	
			nivellinea.setIsChanged(nivellinea.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			nivellinea.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			nivellinea.setIsDeletedAuxiliar(false);	
			nivellinea.setIsNewAuxiliar(false);	
			nivellinea.setIsChangedAuxiliar(false);
			
			nivellinea.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNivelLineas(List<NivelLinea> nivellineas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(NivelLinea nivellinea : nivellineas) {
			if(conAsignarBase && nivellinea.getConCambioAuxiliar()) {
				nivellinea.setIsDeleted(nivellinea.getIsDeletedAuxiliar());	
				nivellinea.setIsNew(nivellinea.getIsNewAuxiliar());	
				nivellinea.setIsChanged(nivellinea.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				nivellinea.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				nivellinea.setIsDeletedAuxiliar(false);	
				nivellinea.setIsNewAuxiliar(false);	
				nivellinea.setIsChangedAuxiliar(false);
				
				nivellinea.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresNivelLinea(NivelLinea nivellinea,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresNivelLineas(List<NivelLinea> nivellineas,Boolean conEnteros) throws Exception  {
		
		for(NivelLinea nivellinea: nivellineas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaNivelLinea(List<NivelLinea> nivellineas,NivelLinea nivellineaAux) throws Exception  {
		NivelLineaConstantesFunciones.InicializarValoresNivelLinea(nivellineaAux,true);
		
		for(NivelLinea nivellinea: nivellineas) {
			if(nivellinea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNivelLinea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=NivelLineaConstantesFunciones.getArrayColumnasGlobalesNivelLinea(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesNivelLinea(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoNivelLinea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<NivelLinea> nivellineas,NivelLinea nivellinea,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(NivelLinea nivellineaAux: nivellineas) {
			if(nivellineaAux!=null && nivellinea!=null) {
				if((nivellineaAux.getId()==null && nivellinea.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(nivellineaAux.getId()!=null && nivellinea.getId()!=null){
					if(nivellineaAux.getId().equals(nivellinea.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaNivelLinea(List<NivelLinea> nivellineas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(NivelLinea nivellinea: nivellineas) {			
			if(nivellinea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaNivelLinea() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,NivelLineaConstantesFunciones.LABEL_ID, NivelLineaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NivelLineaConstantesFunciones.LABEL_VERSIONROW, NivelLineaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NivelLineaConstantesFunciones.LABEL_NOMBRE, NivelLineaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasNivelLinea() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=NivelLineaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NivelLineaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NivelLineaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNivelLinea() throws Exception  {
		return NivelLineaConstantesFunciones.getTiposSeleccionarNivelLinea(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNivelLinea(Boolean conFk) throws Exception  {
		return NivelLineaConstantesFunciones.getTiposSeleccionarNivelLinea(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNivelLinea(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NivelLineaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(NivelLineaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesNivelLinea(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesNivelLinea(NivelLinea nivellineaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesNivelLinea(List<NivelLinea> nivellineasTemp) throws Exception {
		for(NivelLinea nivellineaAux:nivellineasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfNivelLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfNivelLinea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfNivelLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return NivelLineaConstantesFunciones.getClassesRelationshipsOfNivelLinea(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNivelLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(ComisionConfig.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionConfig.class)) {
						classes.add(new Classe(ComisionConfig.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNivelLinea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return NivelLineaConstantesFunciones.getClassesRelationshipsFromStringsOfNivelLinea(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNivelLinea(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(ComisionConfig.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionConfig.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(ComisionConfig.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionConfig.class)); continue;
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
	public static void actualizarLista(NivelLinea nivellinea,List<NivelLinea> nivellineas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			NivelLinea nivellineaEncontrado=null;
			
			for(NivelLinea nivellineaLocal:nivellineas) {
				if(nivellineaLocal.getId().equals(nivellinea.getId())) {
					nivellineaEncontrado=nivellineaLocal;
					
					nivellineaLocal.setIsChanged(nivellinea.getIsChanged());
					nivellineaLocal.setIsNew(nivellinea.getIsNew());
					nivellineaLocal.setIsDeleted(nivellinea.getIsDeleted());
					
					nivellineaLocal.setGeneralEntityOriginal(nivellinea.getGeneralEntityOriginal());
					
					nivellineaLocal.setId(nivellinea.getId());	
					nivellineaLocal.setVersionRow(nivellinea.getVersionRow());	
					nivellineaLocal.setnombre(nivellinea.getnombre());	
					
					
					nivellineaLocal.setLineas(nivellinea.getLineas());
					nivellineaLocal.setComisionConfigs(nivellinea.getComisionConfigs());
					
					existe=true;
					break;
				}
			}
			
			if(!nivellinea.getIsDeleted()) {
				if(!existe) {
					nivellineas.add(nivellinea);
				}
			} else {
				if(nivellineaEncontrado!=null && permiteQuitar)  {
					nivellineas.remove(nivellineaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(NivelLinea nivellinea,List<NivelLinea> nivellineas) throws Exception {
		try	{			
			for(NivelLinea nivellineaLocal:nivellineas) {
				if(nivellineaLocal.getId().equals(nivellinea.getId())) {
					nivellineaLocal.setIsSelected(nivellinea.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesNivelLinea(List<NivelLinea> nivellineasAux) throws Exception {
		//this.nivellineasAux=nivellineasAux;
		
		for(NivelLinea nivellineaAux:nivellineasAux) {
			if(nivellineaAux.getIsChanged()) {
				nivellineaAux.setIsChanged(false);
			}		
			
			if(nivellineaAux.getIsNew()) {
				nivellineaAux.setIsNew(false);
			}	
			
			if(nivellineaAux.getIsDeleted()) {
				nivellineaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesNivelLinea(NivelLinea nivellineaAux) throws Exception {
		//this.nivellineaAux=nivellineaAux;
		
			if(nivellineaAux.getIsChanged()) {
				nivellineaAux.setIsChanged(false);
			}		
			
			if(nivellineaAux.getIsNew()) {
				nivellineaAux.setIsNew(false);
			}	
			
			if(nivellineaAux.getIsDeleted()) {
				nivellineaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(NivelLinea nivellineaAsignar,NivelLinea nivellinea) throws Exception {
		nivellineaAsignar.setId(nivellinea.getId());	
		nivellineaAsignar.setVersionRow(nivellinea.getVersionRow());	
		nivellineaAsignar.setnombre(nivellinea.getnombre());	
	}
	
	public static void inicializarNivelLinea(NivelLinea nivellinea) throws Exception {
		try {
				nivellinea.setId(0L);	
					
				nivellinea.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderNivelLinea(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(NivelLineaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataNivelLinea(String sTipo,Row row,Workbook workbook,NivelLinea nivellinea,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(nivellinea.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryNivelLinea=Constantes.SFINALQUERY;
	
	public String getsFinalQueryNivelLinea() {
		return this.sFinalQueryNivelLinea;
	}
	
	public void setsFinalQueryNivelLinea(String sFinalQueryNivelLinea) {
		this.sFinalQueryNivelLinea= sFinalQueryNivelLinea;
	}
	
	public Border resaltarSeleccionarNivelLinea=null;
	
	public Border setResaltarSeleccionarNivelLinea(ParametroGeneralUsuario parametroGeneralUsuario/*NivelLineaBeanSwingJInternalFrame nivellineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//nivellineaBeanSwingJInternalFrame.jTtoolBarNivelLinea.setBorder(borderResaltar);
		
		this.resaltarSeleccionarNivelLinea= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarNivelLinea() {
		return this.resaltarSeleccionarNivelLinea;
	}
	
	public void setResaltarSeleccionarNivelLinea(Border borderResaltarSeleccionarNivelLinea) {
		this.resaltarSeleccionarNivelLinea= borderResaltarSeleccionarNivelLinea;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridNivelLinea=null;
	public Boolean mostraridNivelLinea=true;
	public Boolean activaridNivelLinea=true;

	public Border resaltarnombreNivelLinea=null;
	public Boolean mostrarnombreNivelLinea=true;
	public Boolean activarnombreNivelLinea=true;

	
	

	public Border setResaltaridNivelLinea(ParametroGeneralUsuario parametroGeneralUsuario/*NivelLineaBeanSwingJInternalFrame nivellineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//nivellineaBeanSwingJInternalFrame.jTtoolBarNivelLinea.setBorder(borderResaltar);
		
		this.resaltaridNivelLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridNivelLinea() {
		return this.resaltaridNivelLinea;
	}

	public void setResaltaridNivelLinea(Border borderResaltar) {
		this.resaltaridNivelLinea= borderResaltar;
	}

	public Boolean getMostraridNivelLinea() {
		return this.mostraridNivelLinea;
	}

	public void setMostraridNivelLinea(Boolean mostraridNivelLinea) {
		this.mostraridNivelLinea= mostraridNivelLinea;
	}

	public Boolean getActivaridNivelLinea() {
		return this.activaridNivelLinea;
	}

	public void setActivaridNivelLinea(Boolean activaridNivelLinea) {
		this.activaridNivelLinea= activaridNivelLinea;
	}

	public Border setResaltarnombreNivelLinea(ParametroGeneralUsuario parametroGeneralUsuario/*NivelLineaBeanSwingJInternalFrame nivellineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//nivellineaBeanSwingJInternalFrame.jTtoolBarNivelLinea.setBorder(borderResaltar);
		
		this.resaltarnombreNivelLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreNivelLinea() {
		return this.resaltarnombreNivelLinea;
	}

	public void setResaltarnombreNivelLinea(Border borderResaltar) {
		this.resaltarnombreNivelLinea= borderResaltar;
	}

	public Boolean getMostrarnombreNivelLinea() {
		return this.mostrarnombreNivelLinea;
	}

	public void setMostrarnombreNivelLinea(Boolean mostrarnombreNivelLinea) {
		this.mostrarnombreNivelLinea= mostrarnombreNivelLinea;
	}

	public Boolean getActivarnombreNivelLinea() {
		return this.activarnombreNivelLinea;
	}

	public void setActivarnombreNivelLinea(Boolean activarnombreNivelLinea) {
		this.activarnombreNivelLinea= activarnombreNivelLinea;
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
		
		
		this.setMostraridNivelLinea(esInicial);
		this.setMostrarnombreNivelLinea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NivelLineaConstantesFunciones.ID)) {
				this.setMostraridNivelLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelLineaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreNivelLinea(esAsigna);
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
		
		
		this.setActivaridNivelLinea(esInicial);
		this.setActivarnombreNivelLinea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NivelLineaConstantesFunciones.ID)) {
				this.setActivaridNivelLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelLineaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreNivelLinea(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,NivelLineaBeanSwingJInternalFrame nivellineaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridNivelLinea(esInicial);
		this.setResaltarnombreNivelLinea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NivelLineaConstantesFunciones.ID)) {
				this.setResaltaridNivelLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(NivelLineaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreNivelLinea(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarLineaNivelLinea=null;

	public Border getResaltarLineaNivelLinea() {
		return this.resaltarLineaNivelLinea;
	}

	public void setResaltarLineaNivelLinea(Border borderResaltarLinea) {
		if(borderResaltarLinea!=null) {
			this.resaltarLineaNivelLinea= borderResaltarLinea;
		}
	}

	public Border setResaltarLineaNivelLinea(ParametroGeneralUsuario parametroGeneralUsuario/*NivelLineaBeanSwingJInternalFrame nivellineaBeanSwingJInternalFrame*/) {
		Border borderResaltarLinea=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//nivellineaBeanSwingJInternalFrame.jTtoolBarNivelLinea.setBorder(borderResaltarLinea);
			
		this.resaltarLineaNivelLinea= borderResaltarLinea;

		 return borderResaltarLinea;
	}



	public Boolean mostrarLineaNivelLinea=true;

	public Boolean getMostrarLineaNivelLinea() {
		return this.mostrarLineaNivelLinea;
	}

	public void setMostrarLineaNivelLinea(Boolean visibilidadResaltarLinea) {
		this.mostrarLineaNivelLinea= visibilidadResaltarLinea;
	}



	public Boolean activarLineaNivelLinea=true;

	public Boolean gethabilitarResaltarLineaNivelLinea() {
		return this.activarLineaNivelLinea;
	}

	public void setActivarLineaNivelLinea(Boolean habilitarResaltarLinea) {
		this.activarLineaNivelLinea= habilitarResaltarLinea;
	}


	public Border resaltarComisionConfigNivelLinea=null;

	public Border getResaltarComisionConfigNivelLinea() {
		return this.resaltarComisionConfigNivelLinea;
	}

	public void setResaltarComisionConfigNivelLinea(Border borderResaltarComisionConfig) {
		if(borderResaltarComisionConfig!=null) {
			this.resaltarComisionConfigNivelLinea= borderResaltarComisionConfig;
		}
	}

	public Border setResaltarComisionConfigNivelLinea(ParametroGeneralUsuario parametroGeneralUsuario/*NivelLineaBeanSwingJInternalFrame nivellineaBeanSwingJInternalFrame*/) {
		Border borderResaltarComisionConfig=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//nivellineaBeanSwingJInternalFrame.jTtoolBarNivelLinea.setBorder(borderResaltarComisionConfig);
			
		this.resaltarComisionConfigNivelLinea= borderResaltarComisionConfig;

		 return borderResaltarComisionConfig;
	}



	public Boolean mostrarComisionConfigNivelLinea=true;

	public Boolean getMostrarComisionConfigNivelLinea() {
		return this.mostrarComisionConfigNivelLinea;
	}

	public void setMostrarComisionConfigNivelLinea(Boolean visibilidadResaltarComisionConfig) {
		this.mostrarComisionConfigNivelLinea= visibilidadResaltarComisionConfig;
	}



	public Boolean activarComisionConfigNivelLinea=true;

	public Boolean gethabilitarResaltarComisionConfigNivelLinea() {
		return this.activarComisionConfigNivelLinea;
	}

	public void setActivarComisionConfigNivelLinea(Boolean habilitarResaltarComisionConfig) {
		this.activarComisionConfigNivelLinea= habilitarResaltarComisionConfig;
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

		this.setMostrarLineaNivelLinea(esInicial);
		this.setMostrarComisionConfigNivelLinea(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Linea.class)) {
				this.setMostrarLineaNivelLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionConfig.class)) {
				this.setMostrarComisionConfigNivelLinea(esAsigna);
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

		this.setActivarLineaNivelLinea(esInicial);
		this.setActivarComisionConfigNivelLinea(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Linea.class)) {
				this.setActivarLineaNivelLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionConfig.class)) {
				this.setActivarComisionConfigNivelLinea(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,NivelLineaBeanSwingJInternalFrame nivellineaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarLineaNivelLinea(esInicial);
		this.setResaltarComisionConfigNivelLinea(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Linea.class)) {
				this.setResaltarLineaNivelLinea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ComisionConfig.class)) {
				this.setResaltarComisionConfigNivelLinea(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}