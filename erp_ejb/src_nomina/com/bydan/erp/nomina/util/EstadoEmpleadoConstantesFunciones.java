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


import com.bydan.erp.nomina.util.EstadoEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.EstadoEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EstadoEmpleadoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoEmpleadoConstantesFunciones extends EstadoEmpleadoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoEmpleado";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoEmpleado"+EstadoEmpleadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoEmpleadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoEmpleadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoEmpleadoConstantesFunciones.SCHEMA+"_"+EstadoEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoEmpleadoConstantesFunciones.SCHEMA+"_"+EstadoEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoEmpleadoConstantesFunciones.SCHEMA+"_"+EstadoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoEmpleadoConstantesFunciones.SCHEMA+"_"+EstadoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoEmpleadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoEmpleadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Empleados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Empleado";
	public static final String SCLASSWEBTITULO_LOWER="Estado Empleado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoEmpleado";
	public static final String OBJECTNAME="estadoempleado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="estado_empleado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadoempleado from "+EstadoEmpleadoConstantesFunciones.SPERSISTENCENAME+" estadoempleado";
	public static String QUERYSELECTNATIVE="select "+EstadoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoEmpleadoConstantesFunciones.TABLENAME+".id,"+EstadoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoEmpleadoConstantesFunciones.TABLENAME+".version_row,"+EstadoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoEmpleadoConstantesFunciones.TABLENAME+".codigo,"+EstadoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoEmpleadoConstantesFunciones.TABLENAME+".nombre from "+EstadoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoEmpleadoConstantesFunciones.TABLENAME;//+" as "+EstadoEmpleadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoEmpleadoConstantesFuncionesAdditional estadoempleadoConstantesFuncionesAdditional=null;
	
	public EstadoEmpleadoConstantesFuncionesAdditional getEstadoEmpleadoConstantesFuncionesAdditional() {
		return this.estadoempleadoConstantesFuncionesAdditional;
	}
	
	public void setEstadoEmpleadoConstantesFuncionesAdditional(EstadoEmpleadoConstantesFuncionesAdditional estadoempleadoConstantesFuncionesAdditional) {
		try {
			this.estadoempleadoConstantesFuncionesAdditional=estadoempleadoConstantesFuncionesAdditional;
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
	
	public static String getEstadoEmpleadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoEmpleadoConstantesFunciones.CODIGO)) {sLabelColumna=EstadoEmpleadoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoEmpleadoConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoEmpleadoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoEmpleadoDescripcion(EstadoEmpleado estadoempleado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadoempleado !=null/* && estadoempleado.getId()!=0*/) {
			sDescripcion=estadoempleado.getcodigo();//estadoempleadoestadoempleado.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoEmpleadoDescripcionDetallado(EstadoEmpleado estadoempleado) {
		String sDescripcion="";
			
		sDescripcion+=EstadoEmpleadoConstantesFunciones.ID+"=";
		sDescripcion+=estadoempleado.getId().toString()+",";
		sDescripcion+=EstadoEmpleadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadoempleado.getVersionRow().toString()+",";
		sDescripcion+=EstadoEmpleadoConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadoempleado.getcodigo()+",";
		sDescripcion+=EstadoEmpleadoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadoempleado.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoEmpleadoDescripcion(EstadoEmpleado estadoempleado,String sValor) throws Exception {			
		if(estadoempleado !=null) {
			estadoempleado.setcodigo(sValor);;//estadoempleadoestadoempleado.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("PorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndicePorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEstadoEmpleado(EstadoEmpleado estadoempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadoempleado.setcodigo(estadoempleado.getcodigo().trim());
		estadoempleado.setnombre(estadoempleado.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoEmpleados(List<EstadoEmpleado> estadoempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoEmpleado estadoempleado: estadoempleados) {
			estadoempleado.setcodigo(estadoempleado.getcodigo().trim());
			estadoempleado.setnombre(estadoempleado.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoEmpleado(EstadoEmpleado estadoempleado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadoempleado.getConCambioAuxiliar()) {
			estadoempleado.setIsDeleted(estadoempleado.getIsDeletedAuxiliar());	
			estadoempleado.setIsNew(estadoempleado.getIsNewAuxiliar());	
			estadoempleado.setIsChanged(estadoempleado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadoempleado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadoempleado.setIsDeletedAuxiliar(false);	
			estadoempleado.setIsNewAuxiliar(false);	
			estadoempleado.setIsChangedAuxiliar(false);
			
			estadoempleado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoEmpleados(List<EstadoEmpleado> estadoempleados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoEmpleado estadoempleado : estadoempleados) {
			if(conAsignarBase && estadoempleado.getConCambioAuxiliar()) {
				estadoempleado.setIsDeleted(estadoempleado.getIsDeletedAuxiliar());	
				estadoempleado.setIsNew(estadoempleado.getIsNewAuxiliar());	
				estadoempleado.setIsChanged(estadoempleado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadoempleado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadoempleado.setIsDeletedAuxiliar(false);	
				estadoempleado.setIsNewAuxiliar(false);	
				estadoempleado.setIsChangedAuxiliar(false);
				
				estadoempleado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoEmpleado(EstadoEmpleado estadoempleado,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoEmpleados(List<EstadoEmpleado> estadoempleados,Boolean conEnteros) throws Exception  {
		
		for(EstadoEmpleado estadoempleado: estadoempleados) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoEmpleado(List<EstadoEmpleado> estadoempleados,EstadoEmpleado estadoempleadoAux) throws Exception  {
		EstadoEmpleadoConstantesFunciones.InicializarValoresEstadoEmpleado(estadoempleadoAux,true);
		
		for(EstadoEmpleado estadoempleado: estadoempleados) {
			if(estadoempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoEmpleadoConstantesFunciones.getArrayColumnasGlobalesEstadoEmpleado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoEmpleado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoEmpleado> estadoempleados,EstadoEmpleado estadoempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoEmpleado estadoempleadoAux: estadoempleados) {
			if(estadoempleadoAux!=null && estadoempleado!=null) {
				if((estadoempleadoAux.getId()==null && estadoempleado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadoempleadoAux.getId()!=null && estadoempleado.getId()!=null){
					if(estadoempleadoAux.getId().equals(estadoempleado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoEmpleado(List<EstadoEmpleado> estadoempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoEmpleado estadoempleado: estadoempleados) {			
			if(estadoempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoEmpleado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoEmpleadoConstantesFunciones.LABEL_ID, EstadoEmpleadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoEmpleadoConstantesFunciones.LABEL_VERSIONROW, EstadoEmpleadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoEmpleadoConstantesFunciones.LABEL_CODIGO, EstadoEmpleadoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoEmpleadoConstantesFunciones.LABEL_NOMBRE, EstadoEmpleadoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoEmpleado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoEmpleadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoEmpleadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoEmpleadoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoEmpleadoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoEmpleado() throws Exception  {
		return EstadoEmpleadoConstantesFunciones.getTiposSeleccionarEstadoEmpleado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoEmpleado(Boolean conFk) throws Exception  {
		return EstadoEmpleadoConstantesFunciones.getTiposSeleccionarEstadoEmpleado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoEmpleado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoEmpleadoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoEmpleadoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoEmpleadoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoEmpleadoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoEmpleado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoEmpleado(EstadoEmpleado estadoempleadoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoEmpleado(List<EstadoEmpleado> estadoempleadosTemp) throws Exception {
		for(EstadoEmpleado estadoempleadoAux:estadoempleadosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoEmpleadoConstantesFunciones.getClassesRelationshipsOfEstadoEmpleado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(CierreRolMensual.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CierreRolMensual.class)) {
						classes.add(new Classe(CierreRolMensual.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoEmpleadoConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoEmpleado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(CierreRolMensual.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CierreRolMensual.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(CierreRolMensual.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CierreRolMensual.class)); continue;
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
	public static void actualizarLista(EstadoEmpleado estadoempleado,List<EstadoEmpleado> estadoempleados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoEmpleado estadoempleadoEncontrado=null;
			
			for(EstadoEmpleado estadoempleadoLocal:estadoempleados) {
				if(estadoempleadoLocal.getId().equals(estadoempleado.getId())) {
					estadoempleadoEncontrado=estadoempleadoLocal;
					
					estadoempleadoLocal.setIsChanged(estadoempleado.getIsChanged());
					estadoempleadoLocal.setIsNew(estadoempleado.getIsNew());
					estadoempleadoLocal.setIsDeleted(estadoempleado.getIsDeleted());
					
					estadoempleadoLocal.setGeneralEntityOriginal(estadoempleado.getGeneralEntityOriginal());
					
					estadoempleadoLocal.setId(estadoempleado.getId());	
					estadoempleadoLocal.setVersionRow(estadoempleado.getVersionRow());	
					estadoempleadoLocal.setcodigo(estadoempleado.getcodigo());	
					estadoempleadoLocal.setnombre(estadoempleado.getnombre());	
					
					
					estadoempleadoLocal.setEmpleados(estadoempleado.getEmpleados());
					estadoempleadoLocal.setCierreRolMensuals(estadoempleado.getCierreRolMensuals());
					
					existe=true;
					break;
				}
			}
			
			if(!estadoempleado.getIsDeleted()) {
				if(!existe) {
					estadoempleados.add(estadoempleado);
				}
			} else {
				if(estadoempleadoEncontrado!=null && permiteQuitar)  {
					estadoempleados.remove(estadoempleadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoEmpleado estadoempleado,List<EstadoEmpleado> estadoempleados) throws Exception {
		try	{			
			for(EstadoEmpleado estadoempleadoLocal:estadoempleados) {
				if(estadoempleadoLocal.getId().equals(estadoempleado.getId())) {
					estadoempleadoLocal.setIsSelected(estadoempleado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoEmpleado(List<EstadoEmpleado> estadoempleadosAux) throws Exception {
		//this.estadoempleadosAux=estadoempleadosAux;
		
		for(EstadoEmpleado estadoempleadoAux:estadoempleadosAux) {
			if(estadoempleadoAux.getIsChanged()) {
				estadoempleadoAux.setIsChanged(false);
			}		
			
			if(estadoempleadoAux.getIsNew()) {
				estadoempleadoAux.setIsNew(false);
			}	
			
			if(estadoempleadoAux.getIsDeleted()) {
				estadoempleadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoEmpleado(EstadoEmpleado estadoempleadoAux) throws Exception {
		//this.estadoempleadoAux=estadoempleadoAux;
		
			if(estadoempleadoAux.getIsChanged()) {
				estadoempleadoAux.setIsChanged(false);
			}		
			
			if(estadoempleadoAux.getIsNew()) {
				estadoempleadoAux.setIsNew(false);
			}	
			
			if(estadoempleadoAux.getIsDeleted()) {
				estadoempleadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoEmpleado estadoempleadoAsignar,EstadoEmpleado estadoempleado) throws Exception {
		estadoempleadoAsignar.setId(estadoempleado.getId());	
		estadoempleadoAsignar.setVersionRow(estadoempleado.getVersionRow());	
		estadoempleadoAsignar.setcodigo(estadoempleado.getcodigo());	
		estadoempleadoAsignar.setnombre(estadoempleado.getnombre());	
	}
	
	public static void inicializarEstadoEmpleado(EstadoEmpleado estadoempleado) throws Exception {
		try {
				estadoempleado.setId(0L);	
					
				estadoempleado.setcodigo("");	
				estadoempleado.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoEmpleado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoEmpleadoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoEmpleadoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoEmpleado(String sTipo,Row row,Workbook workbook,EstadoEmpleado estadoempleado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoempleado.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoempleado.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoEmpleado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoEmpleado() {
		return this.sFinalQueryEstadoEmpleado;
	}
	
	public void setsFinalQueryEstadoEmpleado(String sFinalQueryEstadoEmpleado) {
		this.sFinalQueryEstadoEmpleado= sFinalQueryEstadoEmpleado;
	}
	
	public Border resaltarSeleccionarEstadoEmpleado=null;
	
	public Border setResaltarSeleccionarEstadoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoEmpleadoBeanSwingJInternalFrame estadoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadoempleadoBeanSwingJInternalFrame.jTtoolBarEstadoEmpleado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoEmpleado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoEmpleado() {
		return this.resaltarSeleccionarEstadoEmpleado;
	}
	
	public void setResaltarSeleccionarEstadoEmpleado(Border borderResaltarSeleccionarEstadoEmpleado) {
		this.resaltarSeleccionarEstadoEmpleado= borderResaltarSeleccionarEstadoEmpleado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoEmpleado=null;
	public Boolean mostraridEstadoEmpleado=true;
	public Boolean activaridEstadoEmpleado=true;

	public Border resaltarcodigoEstadoEmpleado=null;
	public Boolean mostrarcodigoEstadoEmpleado=true;
	public Boolean activarcodigoEstadoEmpleado=true;

	public Border resaltarnombreEstadoEmpleado=null;
	public Boolean mostrarnombreEstadoEmpleado=true;
	public Boolean activarnombreEstadoEmpleado=true;

	
	

	public Border setResaltaridEstadoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoEmpleadoBeanSwingJInternalFrame estadoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoempleadoBeanSwingJInternalFrame.jTtoolBarEstadoEmpleado.setBorder(borderResaltar);
		
		this.resaltaridEstadoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoEmpleado() {
		return this.resaltaridEstadoEmpleado;
	}

	public void setResaltaridEstadoEmpleado(Border borderResaltar) {
		this.resaltaridEstadoEmpleado= borderResaltar;
	}

	public Boolean getMostraridEstadoEmpleado() {
		return this.mostraridEstadoEmpleado;
	}

	public void setMostraridEstadoEmpleado(Boolean mostraridEstadoEmpleado) {
		this.mostraridEstadoEmpleado= mostraridEstadoEmpleado;
	}

	public Boolean getActivaridEstadoEmpleado() {
		return this.activaridEstadoEmpleado;
	}

	public void setActivaridEstadoEmpleado(Boolean activaridEstadoEmpleado) {
		this.activaridEstadoEmpleado= activaridEstadoEmpleado;
	}

	public Border setResaltarcodigoEstadoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoEmpleadoBeanSwingJInternalFrame estadoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoempleadoBeanSwingJInternalFrame.jTtoolBarEstadoEmpleado.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoEmpleado() {
		return this.resaltarcodigoEstadoEmpleado;
	}

	public void setResaltarcodigoEstadoEmpleado(Border borderResaltar) {
		this.resaltarcodigoEstadoEmpleado= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoEmpleado() {
		return this.mostrarcodigoEstadoEmpleado;
	}

	public void setMostrarcodigoEstadoEmpleado(Boolean mostrarcodigoEstadoEmpleado) {
		this.mostrarcodigoEstadoEmpleado= mostrarcodigoEstadoEmpleado;
	}

	public Boolean getActivarcodigoEstadoEmpleado() {
		return this.activarcodigoEstadoEmpleado;
	}

	public void setActivarcodigoEstadoEmpleado(Boolean activarcodigoEstadoEmpleado) {
		this.activarcodigoEstadoEmpleado= activarcodigoEstadoEmpleado;
	}

	public Border setResaltarnombreEstadoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoEmpleadoBeanSwingJInternalFrame estadoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoempleadoBeanSwingJInternalFrame.jTtoolBarEstadoEmpleado.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoEmpleado() {
		return this.resaltarnombreEstadoEmpleado;
	}

	public void setResaltarnombreEstadoEmpleado(Border borderResaltar) {
		this.resaltarnombreEstadoEmpleado= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoEmpleado() {
		return this.mostrarnombreEstadoEmpleado;
	}

	public void setMostrarnombreEstadoEmpleado(Boolean mostrarnombreEstadoEmpleado) {
		this.mostrarnombreEstadoEmpleado= mostrarnombreEstadoEmpleado;
	}

	public Boolean getActivarnombreEstadoEmpleado() {
		return this.activarnombreEstadoEmpleado;
	}

	public void setActivarnombreEstadoEmpleado(Boolean activarnombreEstadoEmpleado) {
		this.activarnombreEstadoEmpleado= activarnombreEstadoEmpleado;
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
		
		
		this.setMostraridEstadoEmpleado(esInicial);
		this.setMostrarcodigoEstadoEmpleado(esInicial);
		this.setMostrarnombreEstadoEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoEmpleadoConstantesFunciones.ID)) {
				this.setMostraridEstadoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoEmpleadoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoEmpleadoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoEmpleado(esAsigna);
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
		
		
		this.setActivaridEstadoEmpleado(esInicial);
		this.setActivarcodigoEstadoEmpleado(esInicial);
		this.setActivarnombreEstadoEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoEmpleadoConstantesFunciones.ID)) {
				this.setActivaridEstadoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoEmpleadoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoEmpleadoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoEmpleadoBeanSwingJInternalFrame estadoempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoEmpleado(esInicial);
		this.setResaltarcodigoEstadoEmpleado(esInicial);
		this.setResaltarnombreEstadoEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoEmpleadoConstantesFunciones.ID)) {
				this.setResaltaridEstadoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoEmpleadoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoEmpleadoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarEmpleadoEstadoEmpleado=null;

	public Border getResaltarEmpleadoEstadoEmpleado() {
		return this.resaltarEmpleadoEstadoEmpleado;
	}

	public void setResaltarEmpleadoEstadoEmpleado(Border borderResaltarEmpleado) {
		if(borderResaltarEmpleado!=null) {
			this.resaltarEmpleadoEstadoEmpleado= borderResaltarEmpleado;
		}
	}

	public Border setResaltarEmpleadoEstadoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoEmpleadoBeanSwingJInternalFrame estadoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadoempleadoBeanSwingJInternalFrame.jTtoolBarEstadoEmpleado.setBorder(borderResaltarEmpleado);
			
		this.resaltarEmpleadoEstadoEmpleado= borderResaltarEmpleado;

		 return borderResaltarEmpleado;
	}



	public Boolean mostrarEmpleadoEstadoEmpleado=true;

	public Boolean getMostrarEmpleadoEstadoEmpleado() {
		return this.mostrarEmpleadoEstadoEmpleado;
	}

	public void setMostrarEmpleadoEstadoEmpleado(Boolean visibilidadResaltarEmpleado) {
		this.mostrarEmpleadoEstadoEmpleado= visibilidadResaltarEmpleado;
	}



	public Boolean activarEmpleadoEstadoEmpleado=true;

	public Boolean gethabilitarResaltarEmpleadoEstadoEmpleado() {
		return this.activarEmpleadoEstadoEmpleado;
	}

	public void setActivarEmpleadoEstadoEmpleado(Boolean habilitarResaltarEmpleado) {
		this.activarEmpleadoEstadoEmpleado= habilitarResaltarEmpleado;
	}


	public Border resaltarCierreRolMensualEstadoEmpleado=null;

	public Border getResaltarCierreRolMensualEstadoEmpleado() {
		return this.resaltarCierreRolMensualEstadoEmpleado;
	}

	public void setResaltarCierreRolMensualEstadoEmpleado(Border borderResaltarCierreRolMensual) {
		if(borderResaltarCierreRolMensual!=null) {
			this.resaltarCierreRolMensualEstadoEmpleado= borderResaltarCierreRolMensual;
		}
	}

	public Border setResaltarCierreRolMensualEstadoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoEmpleadoBeanSwingJInternalFrame estadoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarCierreRolMensual=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadoempleadoBeanSwingJInternalFrame.jTtoolBarEstadoEmpleado.setBorder(borderResaltarCierreRolMensual);
			
		this.resaltarCierreRolMensualEstadoEmpleado= borderResaltarCierreRolMensual;

		 return borderResaltarCierreRolMensual;
	}



	public Boolean mostrarCierreRolMensualEstadoEmpleado=true;

	public Boolean getMostrarCierreRolMensualEstadoEmpleado() {
		return this.mostrarCierreRolMensualEstadoEmpleado;
	}

	public void setMostrarCierreRolMensualEstadoEmpleado(Boolean visibilidadResaltarCierreRolMensual) {
		this.mostrarCierreRolMensualEstadoEmpleado= visibilidadResaltarCierreRolMensual;
	}



	public Boolean activarCierreRolMensualEstadoEmpleado=true;

	public Boolean gethabilitarResaltarCierreRolMensualEstadoEmpleado() {
		return this.activarCierreRolMensualEstadoEmpleado;
	}

	public void setActivarCierreRolMensualEstadoEmpleado(Boolean habilitarResaltarCierreRolMensual) {
		this.activarCierreRolMensualEstadoEmpleado= habilitarResaltarCierreRolMensual;
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

		this.setMostrarEmpleadoEstadoEmpleado(esInicial);
		this.setMostrarCierreRolMensualEstadoEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Empleado.class)) {
				this.setMostrarEmpleadoEstadoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(CierreRolMensual.class)) {
				this.setMostrarCierreRolMensualEstadoEmpleado(esAsigna);
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

		this.setActivarEmpleadoEstadoEmpleado(esInicial);
		this.setActivarCierreRolMensualEstadoEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Empleado.class)) {
				this.setActivarEmpleadoEstadoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(CierreRolMensual.class)) {
				this.setActivarCierreRolMensualEstadoEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoEmpleadoBeanSwingJInternalFrame estadoempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarEmpleadoEstadoEmpleado(esInicial);
		this.setResaltarCierreRolMensualEstadoEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Empleado.class)) {
				this.setResaltarEmpleadoEstadoEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(CierreRolMensual.class)) {
				this.setResaltarCierreRolMensualEstadoEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}