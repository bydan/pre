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


import com.bydan.erp.inventario.util.EstadoPrecioConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoPrecioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoPrecioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoPrecioConstantesFunciones extends EstadoPrecioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoPrecio";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoPrecio"+EstadoPrecioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoPrecioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoPrecioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoPrecioConstantesFunciones.SCHEMA+"_"+EstadoPrecioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoPrecioConstantesFunciones.SCHEMA+"_"+EstadoPrecioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoPrecioConstantesFunciones.SCHEMA+"_"+EstadoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoPrecioConstantesFunciones.SCHEMA+"_"+EstadoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoPrecioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoPrecioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoPrecioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoPrecioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Precioes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Estado Precio";
	public static final String SCLASSWEBTITULO_LOWER="Estado Precio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoPrecio";
	public static final String OBJECTNAME="estadoprecio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="estado_precio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadoprecio from "+EstadoPrecioConstantesFunciones.SPERSISTENCENAME+" estadoprecio";
	public static String QUERYSELECTNATIVE="select "+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME+".id,"+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME+".version_row,"+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME+".codigo,"+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME+".nombre from "+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME;//+" as "+EstadoPrecioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoPrecioConstantesFuncionesAdditional estadoprecioConstantesFuncionesAdditional=null;
	
	public EstadoPrecioConstantesFuncionesAdditional getEstadoPrecioConstantesFuncionesAdditional() {
		return this.estadoprecioConstantesFuncionesAdditional;
	}
	
	public void setEstadoPrecioConstantesFuncionesAdditional(EstadoPrecioConstantesFuncionesAdditional estadoprecioConstantesFuncionesAdditional) {
		try {
			this.estadoprecioConstantesFuncionesAdditional=estadoprecioConstantesFuncionesAdditional;
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
	
	public static String getEstadoPrecioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoPrecioConstantesFunciones.CODIGO)) {sLabelColumna=EstadoPrecioConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoPrecioConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoPrecioConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoPrecioDescripcion(EstadoPrecio estadoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadoprecio !=null/* && estadoprecio.getId()!=0*/) {
			sDescripcion=estadoprecio.getcodigo();//estadoprecioestadoprecio.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoPrecioDescripcionDetallado(EstadoPrecio estadoprecio) {
		String sDescripcion="";
			
		sDescripcion+=EstadoPrecioConstantesFunciones.ID+"=";
		sDescripcion+=estadoprecio.getId().toString()+",";
		sDescripcion+=EstadoPrecioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadoprecio.getVersionRow().toString()+",";
		sDescripcion+=EstadoPrecioConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadoprecio.getcodigo()+",";
		sDescripcion+=EstadoPrecioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadoprecio.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoPrecioDescripcion(EstadoPrecio estadoprecio,String sValor) throws Exception {			
		if(estadoprecio !=null) {
			estadoprecio.setcodigo(sValor);;//estadoprecioestadoprecio.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoPrecio(EstadoPrecio estadoprecio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadoprecio.setcodigo(estadoprecio.getcodigo().trim());
		estadoprecio.setnombre(estadoprecio.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoPrecios(List<EstadoPrecio> estadoprecios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoPrecio estadoprecio: estadoprecios) {
			estadoprecio.setcodigo(estadoprecio.getcodigo().trim());
			estadoprecio.setnombre(estadoprecio.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoPrecio(EstadoPrecio estadoprecio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadoprecio.getConCambioAuxiliar()) {
			estadoprecio.setIsDeleted(estadoprecio.getIsDeletedAuxiliar());	
			estadoprecio.setIsNew(estadoprecio.getIsNewAuxiliar());	
			estadoprecio.setIsChanged(estadoprecio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadoprecio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadoprecio.setIsDeletedAuxiliar(false);	
			estadoprecio.setIsNewAuxiliar(false);	
			estadoprecio.setIsChangedAuxiliar(false);
			
			estadoprecio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoPrecios(List<EstadoPrecio> estadoprecios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoPrecio estadoprecio : estadoprecios) {
			if(conAsignarBase && estadoprecio.getConCambioAuxiliar()) {
				estadoprecio.setIsDeleted(estadoprecio.getIsDeletedAuxiliar());	
				estadoprecio.setIsNew(estadoprecio.getIsNewAuxiliar());	
				estadoprecio.setIsChanged(estadoprecio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadoprecio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadoprecio.setIsDeletedAuxiliar(false);	
				estadoprecio.setIsNewAuxiliar(false);	
				estadoprecio.setIsChangedAuxiliar(false);
				
				estadoprecio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoPrecio(EstadoPrecio estadoprecio,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoPrecios(List<EstadoPrecio> estadoprecios,Boolean conEnteros) throws Exception  {
		
		for(EstadoPrecio estadoprecio: estadoprecios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoPrecio(List<EstadoPrecio> estadoprecios,EstadoPrecio estadoprecioAux) throws Exception  {
		EstadoPrecioConstantesFunciones.InicializarValoresEstadoPrecio(estadoprecioAux,true);
		
		for(EstadoPrecio estadoprecio: estadoprecios) {
			if(estadoprecio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoPrecio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoPrecioConstantesFunciones.getArrayColumnasGlobalesEstadoPrecio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoPrecio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoPrecio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoPrecio> estadoprecios,EstadoPrecio estadoprecio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoPrecio estadoprecioAux: estadoprecios) {
			if(estadoprecioAux!=null && estadoprecio!=null) {
				if((estadoprecioAux.getId()==null && estadoprecio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadoprecioAux.getId()!=null && estadoprecio.getId()!=null){
					if(estadoprecioAux.getId().equals(estadoprecio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoPrecio(List<EstadoPrecio> estadoprecios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoPrecio estadoprecio: estadoprecios) {			
			if(estadoprecio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoPrecio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoPrecioConstantesFunciones.LABEL_ID, EstadoPrecioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPrecioConstantesFunciones.LABEL_VERSIONROW, EstadoPrecioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPrecioConstantesFunciones.LABEL_CODIGO, EstadoPrecioConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPrecioConstantesFunciones.LABEL_NOMBRE, EstadoPrecioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoPrecio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoPrecioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPrecioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPrecioConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPrecioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPrecio() throws Exception  {
		return EstadoPrecioConstantesFunciones.getTiposSeleccionarEstadoPrecio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPrecio(Boolean conFk) throws Exception  {
		return EstadoPrecioConstantesFunciones.getTiposSeleccionarEstadoPrecio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPrecio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoPrecioConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoPrecioConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoPrecioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoPrecioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoPrecio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoPrecio(EstadoPrecio estadoprecioAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoPrecio(List<EstadoPrecio> estadopreciosTemp) throws Exception {
		for(EstadoPrecio estadoprecioAux:estadopreciosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoPrecioConstantesFunciones.getClassesRelationshipsOfEstadoPrecio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Precio.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Precio.class)) {
						classes.add(new Classe(Precio.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoPrecioConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoPrecio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Precio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Precio.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Precio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Precio.class)); continue;
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
	public static void actualizarLista(EstadoPrecio estadoprecio,List<EstadoPrecio> estadoprecios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoPrecio estadoprecioEncontrado=null;
			
			for(EstadoPrecio estadoprecioLocal:estadoprecios) {
				if(estadoprecioLocal.getId().equals(estadoprecio.getId())) {
					estadoprecioEncontrado=estadoprecioLocal;
					
					estadoprecioLocal.setIsChanged(estadoprecio.getIsChanged());
					estadoprecioLocal.setIsNew(estadoprecio.getIsNew());
					estadoprecioLocal.setIsDeleted(estadoprecio.getIsDeleted());
					
					estadoprecioLocal.setGeneralEntityOriginal(estadoprecio.getGeneralEntityOriginal());
					
					estadoprecioLocal.setId(estadoprecio.getId());	
					estadoprecioLocal.setVersionRow(estadoprecio.getVersionRow());	
					estadoprecioLocal.setcodigo(estadoprecio.getcodigo());	
					estadoprecioLocal.setnombre(estadoprecio.getnombre());	
					
					
					estadoprecioLocal.setPrecios(estadoprecio.getPrecios());
					
					existe=true;
					break;
				}
			}
			
			if(!estadoprecio.getIsDeleted()) {
				if(!existe) {
					estadoprecios.add(estadoprecio);
				}
			} else {
				if(estadoprecioEncontrado!=null && permiteQuitar)  {
					estadoprecios.remove(estadoprecioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoPrecio estadoprecio,List<EstadoPrecio> estadoprecios) throws Exception {
		try	{			
			for(EstadoPrecio estadoprecioLocal:estadoprecios) {
				if(estadoprecioLocal.getId().equals(estadoprecio.getId())) {
					estadoprecioLocal.setIsSelected(estadoprecio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoPrecio(List<EstadoPrecio> estadopreciosAux) throws Exception {
		//this.estadopreciosAux=estadopreciosAux;
		
		for(EstadoPrecio estadoprecioAux:estadopreciosAux) {
			if(estadoprecioAux.getIsChanged()) {
				estadoprecioAux.setIsChanged(false);
			}		
			
			if(estadoprecioAux.getIsNew()) {
				estadoprecioAux.setIsNew(false);
			}	
			
			if(estadoprecioAux.getIsDeleted()) {
				estadoprecioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoPrecio(EstadoPrecio estadoprecioAux) throws Exception {
		//this.estadoprecioAux=estadoprecioAux;
		
			if(estadoprecioAux.getIsChanged()) {
				estadoprecioAux.setIsChanged(false);
			}		
			
			if(estadoprecioAux.getIsNew()) {
				estadoprecioAux.setIsNew(false);
			}	
			
			if(estadoprecioAux.getIsDeleted()) {
				estadoprecioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoPrecio estadoprecioAsignar,EstadoPrecio estadoprecio) throws Exception {
		estadoprecioAsignar.setId(estadoprecio.getId());	
		estadoprecioAsignar.setVersionRow(estadoprecio.getVersionRow());	
		estadoprecioAsignar.setcodigo(estadoprecio.getcodigo());	
		estadoprecioAsignar.setnombre(estadoprecio.getnombre());	
	}
	
	public static void inicializarEstadoPrecio(EstadoPrecio estadoprecio) throws Exception {
		try {
				estadoprecio.setId(0L);	
					
				estadoprecio.setcodigo("");	
				estadoprecio.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoPrecio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoPrecioConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoPrecioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoPrecio(String sTipo,Row row,Workbook workbook,EstadoPrecio estadoprecio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoprecio.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoprecio.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoPrecio=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoPrecio() {
		return this.sFinalQueryEstadoPrecio;
	}
	
	public void setsFinalQueryEstadoPrecio(String sFinalQueryEstadoPrecio) {
		this.sFinalQueryEstadoPrecio= sFinalQueryEstadoPrecio;
	}
	
	public Border resaltarSeleccionarEstadoPrecio=null;
	
	public Border setResaltarSeleccionarEstadoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPrecioBeanSwingJInternalFrame estadoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadoprecioBeanSwingJInternalFrame.jTtoolBarEstadoPrecio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoPrecio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoPrecio() {
		return this.resaltarSeleccionarEstadoPrecio;
	}
	
	public void setResaltarSeleccionarEstadoPrecio(Border borderResaltarSeleccionarEstadoPrecio) {
		this.resaltarSeleccionarEstadoPrecio= borderResaltarSeleccionarEstadoPrecio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoPrecio=null;
	public Boolean mostraridEstadoPrecio=true;
	public Boolean activaridEstadoPrecio=true;

	public Border resaltarcodigoEstadoPrecio=null;
	public Boolean mostrarcodigoEstadoPrecio=true;
	public Boolean activarcodigoEstadoPrecio=true;

	public Border resaltarnombreEstadoPrecio=null;
	public Boolean mostrarnombreEstadoPrecio=true;
	public Boolean activarnombreEstadoPrecio=true;

	
	

	public Border setResaltaridEstadoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPrecioBeanSwingJInternalFrame estadoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoprecioBeanSwingJInternalFrame.jTtoolBarEstadoPrecio.setBorder(borderResaltar);
		
		this.resaltaridEstadoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoPrecio() {
		return this.resaltaridEstadoPrecio;
	}

	public void setResaltaridEstadoPrecio(Border borderResaltar) {
		this.resaltaridEstadoPrecio= borderResaltar;
	}

	public Boolean getMostraridEstadoPrecio() {
		return this.mostraridEstadoPrecio;
	}

	public void setMostraridEstadoPrecio(Boolean mostraridEstadoPrecio) {
		this.mostraridEstadoPrecio= mostraridEstadoPrecio;
	}

	public Boolean getActivaridEstadoPrecio() {
		return this.activaridEstadoPrecio;
	}

	public void setActivaridEstadoPrecio(Boolean activaridEstadoPrecio) {
		this.activaridEstadoPrecio= activaridEstadoPrecio;
	}

	public Border setResaltarcodigoEstadoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPrecioBeanSwingJInternalFrame estadoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoprecioBeanSwingJInternalFrame.jTtoolBarEstadoPrecio.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoPrecio() {
		return this.resaltarcodigoEstadoPrecio;
	}

	public void setResaltarcodigoEstadoPrecio(Border borderResaltar) {
		this.resaltarcodigoEstadoPrecio= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoPrecio() {
		return this.mostrarcodigoEstadoPrecio;
	}

	public void setMostrarcodigoEstadoPrecio(Boolean mostrarcodigoEstadoPrecio) {
		this.mostrarcodigoEstadoPrecio= mostrarcodigoEstadoPrecio;
	}

	public Boolean getActivarcodigoEstadoPrecio() {
		return this.activarcodigoEstadoPrecio;
	}

	public void setActivarcodigoEstadoPrecio(Boolean activarcodigoEstadoPrecio) {
		this.activarcodigoEstadoPrecio= activarcodigoEstadoPrecio;
	}

	public Border setResaltarnombreEstadoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPrecioBeanSwingJInternalFrame estadoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoprecioBeanSwingJInternalFrame.jTtoolBarEstadoPrecio.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoPrecio() {
		return this.resaltarnombreEstadoPrecio;
	}

	public void setResaltarnombreEstadoPrecio(Border borderResaltar) {
		this.resaltarnombreEstadoPrecio= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoPrecio() {
		return this.mostrarnombreEstadoPrecio;
	}

	public void setMostrarnombreEstadoPrecio(Boolean mostrarnombreEstadoPrecio) {
		this.mostrarnombreEstadoPrecio= mostrarnombreEstadoPrecio;
	}

	public Boolean getActivarnombreEstadoPrecio() {
		return this.activarnombreEstadoPrecio;
	}

	public void setActivarnombreEstadoPrecio(Boolean activarnombreEstadoPrecio) {
		this.activarnombreEstadoPrecio= activarnombreEstadoPrecio;
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
		
		
		this.setMostraridEstadoPrecio(esInicial);
		this.setMostrarcodigoEstadoPrecio(esInicial);
		this.setMostrarnombreEstadoPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPrecioConstantesFunciones.ID)) {
				this.setMostraridEstadoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPrecioConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPrecioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoPrecio(esAsigna);
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
		
		
		this.setActivaridEstadoPrecio(esInicial);
		this.setActivarcodigoEstadoPrecio(esInicial);
		this.setActivarnombreEstadoPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPrecioConstantesFunciones.ID)) {
				this.setActivaridEstadoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPrecioConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPrecioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoPrecio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoPrecioBeanSwingJInternalFrame estadoprecioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoPrecio(esInicial);
		this.setResaltarcodigoEstadoPrecio(esInicial);
		this.setResaltarnombreEstadoPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPrecioConstantesFunciones.ID)) {
				this.setResaltaridEstadoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPrecioConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPrecioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoPrecio(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPrecioEstadoPrecio=null;

	public Border getResaltarPrecioEstadoPrecio() {
		return this.resaltarPrecioEstadoPrecio;
	}

	public void setResaltarPrecioEstadoPrecio(Border borderResaltarPrecio) {
		if(borderResaltarPrecio!=null) {
			this.resaltarPrecioEstadoPrecio= borderResaltarPrecio;
		}
	}

	public Border setResaltarPrecioEstadoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPrecioBeanSwingJInternalFrame estadoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarPrecio=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadoprecioBeanSwingJInternalFrame.jTtoolBarEstadoPrecio.setBorder(borderResaltarPrecio);
			
		this.resaltarPrecioEstadoPrecio= borderResaltarPrecio;

		 return borderResaltarPrecio;
	}



	public Boolean mostrarPrecioEstadoPrecio=true;

	public Boolean getMostrarPrecioEstadoPrecio() {
		return this.mostrarPrecioEstadoPrecio;
	}

	public void setMostrarPrecioEstadoPrecio(Boolean visibilidadResaltarPrecio) {
		this.mostrarPrecioEstadoPrecio= visibilidadResaltarPrecio;
	}



	public Boolean activarPrecioEstadoPrecio=true;

	public Boolean gethabilitarResaltarPrecioEstadoPrecio() {
		return this.activarPrecioEstadoPrecio;
	}

	public void setActivarPrecioEstadoPrecio(Boolean habilitarResaltarPrecio) {
		this.activarPrecioEstadoPrecio= habilitarResaltarPrecio;
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

		this.setMostrarPrecioEstadoPrecio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Precio.class)) {
				this.setMostrarPrecioEstadoPrecio(esAsigna);
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

		this.setActivarPrecioEstadoPrecio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Precio.class)) {
				this.setActivarPrecioEstadoPrecio(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoPrecioBeanSwingJInternalFrame estadoprecioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPrecioEstadoPrecio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Precio.class)) {
				this.setResaltarPrecioEstadoPrecio(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}