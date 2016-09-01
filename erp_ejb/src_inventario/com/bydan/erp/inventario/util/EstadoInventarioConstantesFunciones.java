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


import com.bydan.erp.inventario.util.EstadoInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoInventarioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoInventarioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoInventarioConstantesFunciones extends EstadoInventarioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoInventario";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoInventario"+EstadoInventarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoInventarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoInventarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoInventarioConstantesFunciones.SCHEMA+"_"+EstadoInventarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoInventarioConstantesFunciones.SCHEMA+"_"+EstadoInventarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoInventarioConstantesFunciones.SCHEMA+"_"+EstadoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoInventarioConstantesFunciones.SCHEMA+"_"+EstadoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoInventarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoInventarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoInventarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoInventarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Inventarios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Inventario";
	public static final String SCLASSWEBTITULO_LOWER="Estado Inventario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoInventario";
	public static final String OBJECTNAME="estadoinventario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="estado_inventario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadoinventario from "+EstadoInventarioConstantesFunciones.SPERSISTENCENAME+" estadoinventario";
	public static String QUERYSELECTNATIVE="select "+EstadoInventarioConstantesFunciones.SCHEMA+"."+EstadoInventarioConstantesFunciones.TABLENAME+".id,"+EstadoInventarioConstantesFunciones.SCHEMA+"."+EstadoInventarioConstantesFunciones.TABLENAME+".version_row,"+EstadoInventarioConstantesFunciones.SCHEMA+"."+EstadoInventarioConstantesFunciones.TABLENAME+".codigo,"+EstadoInventarioConstantesFunciones.SCHEMA+"."+EstadoInventarioConstantesFunciones.TABLENAME+".nombre from "+EstadoInventarioConstantesFunciones.SCHEMA+"."+EstadoInventarioConstantesFunciones.TABLENAME;//+" as "+EstadoInventarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoInventarioConstantesFuncionesAdditional estadoinventarioConstantesFuncionesAdditional=null;
	
	public EstadoInventarioConstantesFuncionesAdditional getEstadoInventarioConstantesFuncionesAdditional() {
		return this.estadoinventarioConstantesFuncionesAdditional;
	}
	
	public void setEstadoInventarioConstantesFuncionesAdditional(EstadoInventarioConstantesFuncionesAdditional estadoinventarioConstantesFuncionesAdditional) {
		try {
			this.estadoinventarioConstantesFuncionesAdditional=estadoinventarioConstantesFuncionesAdditional;
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
	
	public static String getEstadoInventarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoInventarioConstantesFunciones.CODIGO)) {sLabelColumna=EstadoInventarioConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoInventarioConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoInventarioConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoInventarioDescripcion(EstadoInventario estadoinventario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadoinventario !=null/* && estadoinventario.getId()!=0*/) {
			sDescripcion=estadoinventario.getcodigo();//estadoinventarioestadoinventario.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoInventarioDescripcionDetallado(EstadoInventario estadoinventario) {
		String sDescripcion="";
			
		sDescripcion+=EstadoInventarioConstantesFunciones.ID+"=";
		sDescripcion+=estadoinventario.getId().toString()+",";
		sDescripcion+=EstadoInventarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadoinventario.getVersionRow().toString()+",";
		sDescripcion+=EstadoInventarioConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadoinventario.getcodigo()+",";
		sDescripcion+=EstadoInventarioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadoinventario.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoInventarioDescripcion(EstadoInventario estadoinventario,String sValor) throws Exception {			
		if(estadoinventario !=null) {
			estadoinventario.setcodigo(sValor);;//estadoinventarioestadoinventario.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoInventario(EstadoInventario estadoinventario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadoinventario.setcodigo(estadoinventario.getcodigo().trim());
		estadoinventario.setnombre(estadoinventario.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoInventarios(List<EstadoInventario> estadoinventarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoInventario estadoinventario: estadoinventarios) {
			estadoinventario.setcodigo(estadoinventario.getcodigo().trim());
			estadoinventario.setnombre(estadoinventario.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoInventario(EstadoInventario estadoinventario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadoinventario.getConCambioAuxiliar()) {
			estadoinventario.setIsDeleted(estadoinventario.getIsDeletedAuxiliar());	
			estadoinventario.setIsNew(estadoinventario.getIsNewAuxiliar());	
			estadoinventario.setIsChanged(estadoinventario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadoinventario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadoinventario.setIsDeletedAuxiliar(false);	
			estadoinventario.setIsNewAuxiliar(false);	
			estadoinventario.setIsChangedAuxiliar(false);
			
			estadoinventario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoInventarios(List<EstadoInventario> estadoinventarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoInventario estadoinventario : estadoinventarios) {
			if(conAsignarBase && estadoinventario.getConCambioAuxiliar()) {
				estadoinventario.setIsDeleted(estadoinventario.getIsDeletedAuxiliar());	
				estadoinventario.setIsNew(estadoinventario.getIsNewAuxiliar());	
				estadoinventario.setIsChanged(estadoinventario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadoinventario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadoinventario.setIsDeletedAuxiliar(false);	
				estadoinventario.setIsNewAuxiliar(false);	
				estadoinventario.setIsChangedAuxiliar(false);
				
				estadoinventario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoInventario(EstadoInventario estadoinventario,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoInventarios(List<EstadoInventario> estadoinventarios,Boolean conEnteros) throws Exception  {
		
		for(EstadoInventario estadoinventario: estadoinventarios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoInventario(List<EstadoInventario> estadoinventarios,EstadoInventario estadoinventarioAux) throws Exception  {
		EstadoInventarioConstantesFunciones.InicializarValoresEstadoInventario(estadoinventarioAux,true);
		
		for(EstadoInventario estadoinventario: estadoinventarios) {
			if(estadoinventario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoInventarioConstantesFunciones.getArrayColumnasGlobalesEstadoInventario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoInventario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoInventario> estadoinventarios,EstadoInventario estadoinventario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoInventario estadoinventarioAux: estadoinventarios) {
			if(estadoinventarioAux!=null && estadoinventario!=null) {
				if((estadoinventarioAux.getId()==null && estadoinventario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadoinventarioAux.getId()!=null && estadoinventario.getId()!=null){
					if(estadoinventarioAux.getId().equals(estadoinventario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoInventario(List<EstadoInventario> estadoinventarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoInventario estadoinventario: estadoinventarios) {			
			if(estadoinventario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoInventario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoInventarioConstantesFunciones.LABEL_ID, EstadoInventarioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoInventarioConstantesFunciones.LABEL_VERSIONROW, EstadoInventarioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoInventarioConstantesFunciones.LABEL_CODIGO, EstadoInventarioConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoInventarioConstantesFunciones.LABEL_NOMBRE, EstadoInventarioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoInventario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoInventarioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoInventarioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoInventarioConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoInventarioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoInventario() throws Exception  {
		return EstadoInventarioConstantesFunciones.getTiposSeleccionarEstadoInventario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoInventario(Boolean conFk) throws Exception  {
		return EstadoInventarioConstantesFunciones.getTiposSeleccionarEstadoInventario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoInventario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoInventarioConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoInventarioConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoInventarioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoInventarioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoInventario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoInventario(EstadoInventario estadoinventarioAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoInventario(List<EstadoInventario> estadoinventariosTemp) throws Exception {
		for(EstadoInventario estadoinventarioAux:estadoinventariosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoInventarioConstantesFunciones.getClassesRelationshipsOfEstadoInventario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Transferencia.class));
				classes.add(new Classe(Compra.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Transferencia.class)) {
						classes.add(new Classe(Transferencia.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Compra.class)) {
						classes.add(new Classe(Compra.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoInventarioConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoInventario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Transferencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transferencia.class)); continue;
					}

					if(Compra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Compra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Transferencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transferencia.class)); continue;
					}

					if(Compra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Compra.class)); continue;
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
	public static void actualizarLista(EstadoInventario estadoinventario,List<EstadoInventario> estadoinventarios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoInventario estadoinventarioEncontrado=null;
			
			for(EstadoInventario estadoinventarioLocal:estadoinventarios) {
				if(estadoinventarioLocal.getId().equals(estadoinventario.getId())) {
					estadoinventarioEncontrado=estadoinventarioLocal;
					
					estadoinventarioLocal.setIsChanged(estadoinventario.getIsChanged());
					estadoinventarioLocal.setIsNew(estadoinventario.getIsNew());
					estadoinventarioLocal.setIsDeleted(estadoinventario.getIsDeleted());
					
					estadoinventarioLocal.setGeneralEntityOriginal(estadoinventario.getGeneralEntityOriginal());
					
					estadoinventarioLocal.setId(estadoinventario.getId());	
					estadoinventarioLocal.setVersionRow(estadoinventario.getVersionRow());	
					estadoinventarioLocal.setcodigo(estadoinventario.getcodigo());	
					estadoinventarioLocal.setnombre(estadoinventario.getnombre());	
					
					
					estadoinventarioLocal.setTransferencias(estadoinventario.getTransferencias());
					estadoinventarioLocal.setCompras(estadoinventario.getCompras());
					
					existe=true;
					break;
				}
			}
			
			if(!estadoinventario.getIsDeleted()) {
				if(!existe) {
					estadoinventarios.add(estadoinventario);
				}
			} else {
				if(estadoinventarioEncontrado!=null && permiteQuitar)  {
					estadoinventarios.remove(estadoinventarioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoInventario estadoinventario,List<EstadoInventario> estadoinventarios) throws Exception {
		try	{			
			for(EstadoInventario estadoinventarioLocal:estadoinventarios) {
				if(estadoinventarioLocal.getId().equals(estadoinventario.getId())) {
					estadoinventarioLocal.setIsSelected(estadoinventario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoInventario(List<EstadoInventario> estadoinventariosAux) throws Exception {
		//this.estadoinventariosAux=estadoinventariosAux;
		
		for(EstadoInventario estadoinventarioAux:estadoinventariosAux) {
			if(estadoinventarioAux.getIsChanged()) {
				estadoinventarioAux.setIsChanged(false);
			}		
			
			if(estadoinventarioAux.getIsNew()) {
				estadoinventarioAux.setIsNew(false);
			}	
			
			if(estadoinventarioAux.getIsDeleted()) {
				estadoinventarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoInventario(EstadoInventario estadoinventarioAux) throws Exception {
		//this.estadoinventarioAux=estadoinventarioAux;
		
			if(estadoinventarioAux.getIsChanged()) {
				estadoinventarioAux.setIsChanged(false);
			}		
			
			if(estadoinventarioAux.getIsNew()) {
				estadoinventarioAux.setIsNew(false);
			}	
			
			if(estadoinventarioAux.getIsDeleted()) {
				estadoinventarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoInventario estadoinventarioAsignar,EstadoInventario estadoinventario) throws Exception {
		estadoinventarioAsignar.setId(estadoinventario.getId());	
		estadoinventarioAsignar.setVersionRow(estadoinventario.getVersionRow());	
		estadoinventarioAsignar.setcodigo(estadoinventario.getcodigo());	
		estadoinventarioAsignar.setnombre(estadoinventario.getnombre());	
	}
	
	public static void inicializarEstadoInventario(EstadoInventario estadoinventario) throws Exception {
		try {
				estadoinventario.setId(0L);	
					
				estadoinventario.setcodigo("");	
				estadoinventario.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoInventario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoInventarioConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoInventarioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoInventario(String sTipo,Row row,Workbook workbook,EstadoInventario estadoinventario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoinventario.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoinventario.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoInventario=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoInventario() {
		return this.sFinalQueryEstadoInventario;
	}
	
	public void setsFinalQueryEstadoInventario(String sFinalQueryEstadoInventario) {
		this.sFinalQueryEstadoInventario= sFinalQueryEstadoInventario;
	}
	
	public Border resaltarSeleccionarEstadoInventario=null;
	
	public Border setResaltarSeleccionarEstadoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoInventarioBeanSwingJInternalFrame estadoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadoinventarioBeanSwingJInternalFrame.jTtoolBarEstadoInventario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoInventario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoInventario() {
		return this.resaltarSeleccionarEstadoInventario;
	}
	
	public void setResaltarSeleccionarEstadoInventario(Border borderResaltarSeleccionarEstadoInventario) {
		this.resaltarSeleccionarEstadoInventario= borderResaltarSeleccionarEstadoInventario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoInventario=null;
	public Boolean mostraridEstadoInventario=true;
	public Boolean activaridEstadoInventario=true;

	public Border resaltarcodigoEstadoInventario=null;
	public Boolean mostrarcodigoEstadoInventario=true;
	public Boolean activarcodigoEstadoInventario=true;

	public Border resaltarnombreEstadoInventario=null;
	public Boolean mostrarnombreEstadoInventario=true;
	public Boolean activarnombreEstadoInventario=true;

	
	

	public Border setResaltaridEstadoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoInventarioBeanSwingJInternalFrame estadoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoinventarioBeanSwingJInternalFrame.jTtoolBarEstadoInventario.setBorder(borderResaltar);
		
		this.resaltaridEstadoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoInventario() {
		return this.resaltaridEstadoInventario;
	}

	public void setResaltaridEstadoInventario(Border borderResaltar) {
		this.resaltaridEstadoInventario= borderResaltar;
	}

	public Boolean getMostraridEstadoInventario() {
		return this.mostraridEstadoInventario;
	}

	public void setMostraridEstadoInventario(Boolean mostraridEstadoInventario) {
		this.mostraridEstadoInventario= mostraridEstadoInventario;
	}

	public Boolean getActivaridEstadoInventario() {
		return this.activaridEstadoInventario;
	}

	public void setActivaridEstadoInventario(Boolean activaridEstadoInventario) {
		this.activaridEstadoInventario= activaridEstadoInventario;
	}

	public Border setResaltarcodigoEstadoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoInventarioBeanSwingJInternalFrame estadoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoinventarioBeanSwingJInternalFrame.jTtoolBarEstadoInventario.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoInventario() {
		return this.resaltarcodigoEstadoInventario;
	}

	public void setResaltarcodigoEstadoInventario(Border borderResaltar) {
		this.resaltarcodigoEstadoInventario= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoInventario() {
		return this.mostrarcodigoEstadoInventario;
	}

	public void setMostrarcodigoEstadoInventario(Boolean mostrarcodigoEstadoInventario) {
		this.mostrarcodigoEstadoInventario= mostrarcodigoEstadoInventario;
	}

	public Boolean getActivarcodigoEstadoInventario() {
		return this.activarcodigoEstadoInventario;
	}

	public void setActivarcodigoEstadoInventario(Boolean activarcodigoEstadoInventario) {
		this.activarcodigoEstadoInventario= activarcodigoEstadoInventario;
	}

	public Border setResaltarnombreEstadoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoInventarioBeanSwingJInternalFrame estadoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoinventarioBeanSwingJInternalFrame.jTtoolBarEstadoInventario.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoInventario() {
		return this.resaltarnombreEstadoInventario;
	}

	public void setResaltarnombreEstadoInventario(Border borderResaltar) {
		this.resaltarnombreEstadoInventario= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoInventario() {
		return this.mostrarnombreEstadoInventario;
	}

	public void setMostrarnombreEstadoInventario(Boolean mostrarnombreEstadoInventario) {
		this.mostrarnombreEstadoInventario= mostrarnombreEstadoInventario;
	}

	public Boolean getActivarnombreEstadoInventario() {
		return this.activarnombreEstadoInventario;
	}

	public void setActivarnombreEstadoInventario(Boolean activarnombreEstadoInventario) {
		this.activarnombreEstadoInventario= activarnombreEstadoInventario;
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
		
		
		this.setMostraridEstadoInventario(esInicial);
		this.setMostrarcodigoEstadoInventario(esInicial);
		this.setMostrarnombreEstadoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoInventarioConstantesFunciones.ID)) {
				this.setMostraridEstadoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoInventarioConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoInventarioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoInventario(esAsigna);
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
		
		
		this.setActivaridEstadoInventario(esInicial);
		this.setActivarcodigoEstadoInventario(esInicial);
		this.setActivarnombreEstadoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoInventarioConstantesFunciones.ID)) {
				this.setActivaridEstadoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoInventarioConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoInventarioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoInventario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoInventarioBeanSwingJInternalFrame estadoinventarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoInventario(esInicial);
		this.setResaltarcodigoEstadoInventario(esInicial);
		this.setResaltarnombreEstadoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoInventarioConstantesFunciones.ID)) {
				this.setResaltaridEstadoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoInventarioConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoInventarioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoInventario(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarTransferenciaEstadoInventario=null;

	public Border getResaltarTransferenciaEstadoInventario() {
		return this.resaltarTransferenciaEstadoInventario;
	}

	public void setResaltarTransferenciaEstadoInventario(Border borderResaltarTransferencia) {
		if(borderResaltarTransferencia!=null) {
			this.resaltarTransferenciaEstadoInventario= borderResaltarTransferencia;
		}
	}

	public Border setResaltarTransferenciaEstadoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoInventarioBeanSwingJInternalFrame estadoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltarTransferencia=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadoinventarioBeanSwingJInternalFrame.jTtoolBarEstadoInventario.setBorder(borderResaltarTransferencia);
			
		this.resaltarTransferenciaEstadoInventario= borderResaltarTransferencia;

		 return borderResaltarTransferencia;
	}



	public Boolean mostrarTransferenciaEstadoInventario=true;

	public Boolean getMostrarTransferenciaEstadoInventario() {
		return this.mostrarTransferenciaEstadoInventario;
	}

	public void setMostrarTransferenciaEstadoInventario(Boolean visibilidadResaltarTransferencia) {
		this.mostrarTransferenciaEstadoInventario= visibilidadResaltarTransferencia;
	}



	public Boolean activarTransferenciaEstadoInventario=true;

	public Boolean gethabilitarResaltarTransferenciaEstadoInventario() {
		return this.activarTransferenciaEstadoInventario;
	}

	public void setActivarTransferenciaEstadoInventario(Boolean habilitarResaltarTransferencia) {
		this.activarTransferenciaEstadoInventario= habilitarResaltarTransferencia;
	}


	public Border resaltarCompraEstadoInventario=null;

	public Border getResaltarCompraEstadoInventario() {
		return this.resaltarCompraEstadoInventario;
	}

	public void setResaltarCompraEstadoInventario(Border borderResaltarCompra) {
		if(borderResaltarCompra!=null) {
			this.resaltarCompraEstadoInventario= borderResaltarCompra;
		}
	}

	public Border setResaltarCompraEstadoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoInventarioBeanSwingJInternalFrame estadoinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltarCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadoinventarioBeanSwingJInternalFrame.jTtoolBarEstadoInventario.setBorder(borderResaltarCompra);
			
		this.resaltarCompraEstadoInventario= borderResaltarCompra;

		 return borderResaltarCompra;
	}



	public Boolean mostrarCompraEstadoInventario=true;

	public Boolean getMostrarCompraEstadoInventario() {
		return this.mostrarCompraEstadoInventario;
	}

	public void setMostrarCompraEstadoInventario(Boolean visibilidadResaltarCompra) {
		this.mostrarCompraEstadoInventario= visibilidadResaltarCompra;
	}



	public Boolean activarCompraEstadoInventario=true;

	public Boolean gethabilitarResaltarCompraEstadoInventario() {
		return this.activarCompraEstadoInventario;
	}

	public void setActivarCompraEstadoInventario(Boolean habilitarResaltarCompra) {
		this.activarCompraEstadoInventario= habilitarResaltarCompra;
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

		this.setMostrarTransferenciaEstadoInventario(esInicial);
		this.setMostrarCompraEstadoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Transferencia.class)) {
				this.setMostrarTransferenciaEstadoInventario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Compra.class)) {
				this.setMostrarCompraEstadoInventario(esAsigna);
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

		this.setActivarTransferenciaEstadoInventario(esInicial);
		this.setActivarCompraEstadoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Transferencia.class)) {
				this.setActivarTransferenciaEstadoInventario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Compra.class)) {
				this.setActivarCompraEstadoInventario(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoInventarioBeanSwingJInternalFrame estadoinventarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarTransferenciaEstadoInventario(esInicial);
		this.setResaltarCompraEstadoInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Transferencia.class)) {
				this.setResaltarTransferenciaEstadoInventario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Compra.class)) {
				this.setResaltarCompraEstadoInventario(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}