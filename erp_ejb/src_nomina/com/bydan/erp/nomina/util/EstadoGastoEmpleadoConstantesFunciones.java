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


import com.bydan.erp.nomina.util.EstadoGastoEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.EstadoGastoEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EstadoGastoEmpleadoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoGastoEmpleadoConstantesFunciones extends EstadoGastoEmpleadoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoGastoEmpleado";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoGastoEmpleado"+EstadoGastoEmpleadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoGastoEmpleadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoGastoEmpleadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"_"+EstadoGastoEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoGastoEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"_"+EstadoGastoEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"_"+EstadoGastoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoGastoEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"_"+EstadoGastoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoGastoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoGastoEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoGastoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoGastoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoGastoEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoGastoEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoGastoEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoGastoEmpleadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoGastoEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoGastoEmpleadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Gasto Empleados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Gasto Empleado";
	public static final String SCLASSWEBTITULO_LOWER="Estado Gasto Empleado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoGastoEmpleado";
	public static final String OBJECTNAME="estadogastoempleado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="estado_gasto_empleado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadogastoempleado from "+EstadoGastoEmpleadoConstantesFunciones.SPERSISTENCENAME+" estadogastoempleado";
	public static String QUERYSELECTNATIVE="select "+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME+".id,"+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME+".version_row,"+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME+".codigo,"+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME+".nombre from "+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME;//+" as "+EstadoGastoEmpleadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoGastoEmpleadoConstantesFuncionesAdditional estadogastoempleadoConstantesFuncionesAdditional=null;
	
	public EstadoGastoEmpleadoConstantesFuncionesAdditional getEstadoGastoEmpleadoConstantesFuncionesAdditional() {
		return this.estadogastoempleadoConstantesFuncionesAdditional;
	}
	
	public void setEstadoGastoEmpleadoConstantesFuncionesAdditional(EstadoGastoEmpleadoConstantesFuncionesAdditional estadogastoempleadoConstantesFuncionesAdditional) {
		try {
			this.estadogastoempleadoConstantesFuncionesAdditional=estadogastoempleadoConstantesFuncionesAdditional;
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
	
	public static String getEstadoGastoEmpleadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoGastoEmpleadoConstantesFunciones.CODIGO)) {sLabelColumna=EstadoGastoEmpleadoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoGastoEmpleadoConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoGastoEmpleadoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoGastoEmpleadoDescripcion(EstadoGastoEmpleado estadogastoempleado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadogastoempleado !=null/* && estadogastoempleado.getId()!=0*/) {
			sDescripcion=estadogastoempleado.getcodigo();//estadogastoempleadoestadogastoempleado.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoGastoEmpleadoDescripcionDetallado(EstadoGastoEmpleado estadogastoempleado) {
		String sDescripcion="";
			
		sDescripcion+=EstadoGastoEmpleadoConstantesFunciones.ID+"=";
		sDescripcion+=estadogastoempleado.getId().toString()+",";
		sDescripcion+=EstadoGastoEmpleadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadogastoempleado.getVersionRow().toString()+",";
		sDescripcion+=EstadoGastoEmpleadoConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadogastoempleado.getcodigo()+",";
		sDescripcion+=EstadoGastoEmpleadoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadogastoempleado.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoGastoEmpleadoDescripcion(EstadoGastoEmpleado estadogastoempleado,String sValor) throws Exception {			
		if(estadogastoempleado !=null) {
			estadogastoempleado.setcodigo(sValor);;//estadogastoempleadoestadogastoempleado.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoGastoEmpleado(EstadoGastoEmpleado estadogastoempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadogastoempleado.setcodigo(estadogastoempleado.getcodigo().trim());
		estadogastoempleado.setnombre(estadogastoempleado.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoGastoEmpleados(List<EstadoGastoEmpleado> estadogastoempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoGastoEmpleado estadogastoempleado: estadogastoempleados) {
			estadogastoempleado.setcodigo(estadogastoempleado.getcodigo().trim());
			estadogastoempleado.setnombre(estadogastoempleado.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoGastoEmpleado(EstadoGastoEmpleado estadogastoempleado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadogastoempleado.getConCambioAuxiliar()) {
			estadogastoempleado.setIsDeleted(estadogastoempleado.getIsDeletedAuxiliar());	
			estadogastoempleado.setIsNew(estadogastoempleado.getIsNewAuxiliar());	
			estadogastoempleado.setIsChanged(estadogastoempleado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadogastoempleado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadogastoempleado.setIsDeletedAuxiliar(false);	
			estadogastoempleado.setIsNewAuxiliar(false);	
			estadogastoempleado.setIsChangedAuxiliar(false);
			
			estadogastoempleado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoGastoEmpleados(List<EstadoGastoEmpleado> estadogastoempleados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoGastoEmpleado estadogastoempleado : estadogastoempleados) {
			if(conAsignarBase && estadogastoempleado.getConCambioAuxiliar()) {
				estadogastoempleado.setIsDeleted(estadogastoempleado.getIsDeletedAuxiliar());	
				estadogastoempleado.setIsNew(estadogastoempleado.getIsNewAuxiliar());	
				estadogastoempleado.setIsChanged(estadogastoempleado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadogastoempleado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadogastoempleado.setIsDeletedAuxiliar(false);	
				estadogastoempleado.setIsNewAuxiliar(false);	
				estadogastoempleado.setIsChangedAuxiliar(false);
				
				estadogastoempleado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoGastoEmpleado(EstadoGastoEmpleado estadogastoempleado,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoGastoEmpleados(List<EstadoGastoEmpleado> estadogastoempleados,Boolean conEnteros) throws Exception  {
		
		for(EstadoGastoEmpleado estadogastoempleado: estadogastoempleados) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoGastoEmpleado(List<EstadoGastoEmpleado> estadogastoempleados,EstadoGastoEmpleado estadogastoempleadoAux) throws Exception  {
		EstadoGastoEmpleadoConstantesFunciones.InicializarValoresEstadoGastoEmpleado(estadogastoempleadoAux,true);
		
		for(EstadoGastoEmpleado estadogastoempleado: estadogastoempleados) {
			if(estadogastoempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoGastoEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoGastoEmpleadoConstantesFunciones.getArrayColumnasGlobalesEstadoGastoEmpleado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoGastoEmpleado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoGastoEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoGastoEmpleado> estadogastoempleados,EstadoGastoEmpleado estadogastoempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoGastoEmpleado estadogastoempleadoAux: estadogastoempleados) {
			if(estadogastoempleadoAux!=null && estadogastoempleado!=null) {
				if((estadogastoempleadoAux.getId()==null && estadogastoempleado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadogastoempleadoAux.getId()!=null && estadogastoempleado.getId()!=null){
					if(estadogastoempleadoAux.getId().equals(estadogastoempleado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoGastoEmpleado(List<EstadoGastoEmpleado> estadogastoempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoGastoEmpleado estadogastoempleado: estadogastoempleados) {			
			if(estadogastoempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoGastoEmpleado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoGastoEmpleadoConstantesFunciones.LABEL_ID, EstadoGastoEmpleadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoGastoEmpleadoConstantesFunciones.LABEL_VERSIONROW, EstadoGastoEmpleadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoGastoEmpleadoConstantesFunciones.LABEL_CODIGO, EstadoGastoEmpleadoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoGastoEmpleadoConstantesFunciones.LABEL_NOMBRE, EstadoGastoEmpleadoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoGastoEmpleado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoGastoEmpleadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoGastoEmpleadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoGastoEmpleadoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoGastoEmpleadoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoGastoEmpleado() throws Exception  {
		return EstadoGastoEmpleadoConstantesFunciones.getTiposSeleccionarEstadoGastoEmpleado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoGastoEmpleado(Boolean conFk) throws Exception  {
		return EstadoGastoEmpleadoConstantesFunciones.getTiposSeleccionarEstadoGastoEmpleado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoGastoEmpleado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoGastoEmpleadoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoGastoEmpleadoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoGastoEmpleadoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoGastoEmpleadoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoGastoEmpleado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoGastoEmpleado(EstadoGastoEmpleado estadogastoempleadoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoGastoEmpleado(List<EstadoGastoEmpleado> estadogastoempleadosTemp) throws Exception {
		for(EstadoGastoEmpleado estadogastoempleadoAux:estadogastoempleadosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoGastoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoGastoEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoGastoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoGastoEmpleadoConstantesFunciones.getClassesRelationshipsOfEstadoGastoEmpleado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoGastoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(GastoEmpleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(GastoEmpleado.class)) {
						classes.add(new Classe(GastoEmpleado.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoGastoEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoGastoEmpleadoConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoGastoEmpleado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoGastoEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(GastoEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GastoEmpleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(GastoEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GastoEmpleado.class)); continue;
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
	public static void actualizarLista(EstadoGastoEmpleado estadogastoempleado,List<EstadoGastoEmpleado> estadogastoempleados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoGastoEmpleado estadogastoempleadoEncontrado=null;
			
			for(EstadoGastoEmpleado estadogastoempleadoLocal:estadogastoempleados) {
				if(estadogastoempleadoLocal.getId().equals(estadogastoempleado.getId())) {
					estadogastoempleadoEncontrado=estadogastoempleadoLocal;
					
					estadogastoempleadoLocal.setIsChanged(estadogastoempleado.getIsChanged());
					estadogastoempleadoLocal.setIsNew(estadogastoempleado.getIsNew());
					estadogastoempleadoLocal.setIsDeleted(estadogastoempleado.getIsDeleted());
					
					estadogastoempleadoLocal.setGeneralEntityOriginal(estadogastoempleado.getGeneralEntityOriginal());
					
					estadogastoempleadoLocal.setId(estadogastoempleado.getId());	
					estadogastoempleadoLocal.setVersionRow(estadogastoempleado.getVersionRow());	
					estadogastoempleadoLocal.setcodigo(estadogastoempleado.getcodigo());	
					estadogastoempleadoLocal.setnombre(estadogastoempleado.getnombre());	
					
					
					estadogastoempleadoLocal.setGastoEmpleados(estadogastoempleado.getGastoEmpleados());
					
					existe=true;
					break;
				}
			}
			
			if(!estadogastoempleado.getIsDeleted()) {
				if(!existe) {
					estadogastoempleados.add(estadogastoempleado);
				}
			} else {
				if(estadogastoempleadoEncontrado!=null && permiteQuitar)  {
					estadogastoempleados.remove(estadogastoempleadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoGastoEmpleado estadogastoempleado,List<EstadoGastoEmpleado> estadogastoempleados) throws Exception {
		try	{			
			for(EstadoGastoEmpleado estadogastoempleadoLocal:estadogastoempleados) {
				if(estadogastoempleadoLocal.getId().equals(estadogastoempleado.getId())) {
					estadogastoempleadoLocal.setIsSelected(estadogastoempleado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoGastoEmpleado(List<EstadoGastoEmpleado> estadogastoempleadosAux) throws Exception {
		//this.estadogastoempleadosAux=estadogastoempleadosAux;
		
		for(EstadoGastoEmpleado estadogastoempleadoAux:estadogastoempleadosAux) {
			if(estadogastoempleadoAux.getIsChanged()) {
				estadogastoempleadoAux.setIsChanged(false);
			}		
			
			if(estadogastoempleadoAux.getIsNew()) {
				estadogastoempleadoAux.setIsNew(false);
			}	
			
			if(estadogastoempleadoAux.getIsDeleted()) {
				estadogastoempleadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoGastoEmpleado(EstadoGastoEmpleado estadogastoempleadoAux) throws Exception {
		//this.estadogastoempleadoAux=estadogastoempleadoAux;
		
			if(estadogastoempleadoAux.getIsChanged()) {
				estadogastoempleadoAux.setIsChanged(false);
			}		
			
			if(estadogastoempleadoAux.getIsNew()) {
				estadogastoempleadoAux.setIsNew(false);
			}	
			
			if(estadogastoempleadoAux.getIsDeleted()) {
				estadogastoempleadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoGastoEmpleado estadogastoempleadoAsignar,EstadoGastoEmpleado estadogastoempleado) throws Exception {
		estadogastoempleadoAsignar.setId(estadogastoempleado.getId());	
		estadogastoempleadoAsignar.setVersionRow(estadogastoempleado.getVersionRow());	
		estadogastoempleadoAsignar.setcodigo(estadogastoempleado.getcodigo());	
		estadogastoempleadoAsignar.setnombre(estadogastoempleado.getnombre());	
	}
	
	public static void inicializarEstadoGastoEmpleado(EstadoGastoEmpleado estadogastoempleado) throws Exception {
		try {
				estadogastoempleado.setId(0L);	
					
				estadogastoempleado.setcodigo("");	
				estadogastoempleado.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoGastoEmpleado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoGastoEmpleadoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoGastoEmpleadoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoGastoEmpleado(String sTipo,Row row,Workbook workbook,EstadoGastoEmpleado estadogastoempleado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadogastoempleado.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadogastoempleado.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoGastoEmpleado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoGastoEmpleado() {
		return this.sFinalQueryEstadoGastoEmpleado;
	}
	
	public void setsFinalQueryEstadoGastoEmpleado(String sFinalQueryEstadoGastoEmpleado) {
		this.sFinalQueryEstadoGastoEmpleado= sFinalQueryEstadoGastoEmpleado;
	}
	
	public Border resaltarSeleccionarEstadoGastoEmpleado=null;
	
	public Border setResaltarSeleccionarEstadoGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoGastoEmpleadoBeanSwingJInternalFrame estadogastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadogastoempleadoBeanSwingJInternalFrame.jTtoolBarEstadoGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoGastoEmpleado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoGastoEmpleado() {
		return this.resaltarSeleccionarEstadoGastoEmpleado;
	}
	
	public void setResaltarSeleccionarEstadoGastoEmpleado(Border borderResaltarSeleccionarEstadoGastoEmpleado) {
		this.resaltarSeleccionarEstadoGastoEmpleado= borderResaltarSeleccionarEstadoGastoEmpleado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoGastoEmpleado=null;
	public Boolean mostraridEstadoGastoEmpleado=true;
	public Boolean activaridEstadoGastoEmpleado=true;

	public Border resaltarcodigoEstadoGastoEmpleado=null;
	public Boolean mostrarcodigoEstadoGastoEmpleado=true;
	public Boolean activarcodigoEstadoGastoEmpleado=true;

	public Border resaltarnombreEstadoGastoEmpleado=null;
	public Boolean mostrarnombreEstadoGastoEmpleado=true;
	public Boolean activarnombreEstadoGastoEmpleado=true;

	
	

	public Border setResaltaridEstadoGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoGastoEmpleadoBeanSwingJInternalFrame estadogastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadogastoempleadoBeanSwingJInternalFrame.jTtoolBarEstadoGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltaridEstadoGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoGastoEmpleado() {
		return this.resaltaridEstadoGastoEmpleado;
	}

	public void setResaltaridEstadoGastoEmpleado(Border borderResaltar) {
		this.resaltaridEstadoGastoEmpleado= borderResaltar;
	}

	public Boolean getMostraridEstadoGastoEmpleado() {
		return this.mostraridEstadoGastoEmpleado;
	}

	public void setMostraridEstadoGastoEmpleado(Boolean mostraridEstadoGastoEmpleado) {
		this.mostraridEstadoGastoEmpleado= mostraridEstadoGastoEmpleado;
	}

	public Boolean getActivaridEstadoGastoEmpleado() {
		return this.activaridEstadoGastoEmpleado;
	}

	public void setActivaridEstadoGastoEmpleado(Boolean activaridEstadoGastoEmpleado) {
		this.activaridEstadoGastoEmpleado= activaridEstadoGastoEmpleado;
	}

	public Border setResaltarcodigoEstadoGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoGastoEmpleadoBeanSwingJInternalFrame estadogastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadogastoempleadoBeanSwingJInternalFrame.jTtoolBarEstadoGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoGastoEmpleado() {
		return this.resaltarcodigoEstadoGastoEmpleado;
	}

	public void setResaltarcodigoEstadoGastoEmpleado(Border borderResaltar) {
		this.resaltarcodigoEstadoGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoGastoEmpleado() {
		return this.mostrarcodigoEstadoGastoEmpleado;
	}

	public void setMostrarcodigoEstadoGastoEmpleado(Boolean mostrarcodigoEstadoGastoEmpleado) {
		this.mostrarcodigoEstadoGastoEmpleado= mostrarcodigoEstadoGastoEmpleado;
	}

	public Boolean getActivarcodigoEstadoGastoEmpleado() {
		return this.activarcodigoEstadoGastoEmpleado;
	}

	public void setActivarcodigoEstadoGastoEmpleado(Boolean activarcodigoEstadoGastoEmpleado) {
		this.activarcodigoEstadoGastoEmpleado= activarcodigoEstadoGastoEmpleado;
	}

	public Border setResaltarnombreEstadoGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoGastoEmpleadoBeanSwingJInternalFrame estadogastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadogastoempleadoBeanSwingJInternalFrame.jTtoolBarEstadoGastoEmpleado.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoGastoEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoGastoEmpleado() {
		return this.resaltarnombreEstadoGastoEmpleado;
	}

	public void setResaltarnombreEstadoGastoEmpleado(Border borderResaltar) {
		this.resaltarnombreEstadoGastoEmpleado= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoGastoEmpleado() {
		return this.mostrarnombreEstadoGastoEmpleado;
	}

	public void setMostrarnombreEstadoGastoEmpleado(Boolean mostrarnombreEstadoGastoEmpleado) {
		this.mostrarnombreEstadoGastoEmpleado= mostrarnombreEstadoGastoEmpleado;
	}

	public Boolean getActivarnombreEstadoGastoEmpleado() {
		return this.activarnombreEstadoGastoEmpleado;
	}

	public void setActivarnombreEstadoGastoEmpleado(Boolean activarnombreEstadoGastoEmpleado) {
		this.activarnombreEstadoGastoEmpleado= activarnombreEstadoGastoEmpleado;
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
		
		
		this.setMostraridEstadoGastoEmpleado(esInicial);
		this.setMostrarcodigoEstadoGastoEmpleado(esInicial);
		this.setMostrarnombreEstadoGastoEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoGastoEmpleadoConstantesFunciones.ID)) {
				this.setMostraridEstadoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoGastoEmpleadoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoGastoEmpleadoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoGastoEmpleado(esAsigna);
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
		
		
		this.setActivaridEstadoGastoEmpleado(esInicial);
		this.setActivarcodigoEstadoGastoEmpleado(esInicial);
		this.setActivarnombreEstadoGastoEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoGastoEmpleadoConstantesFunciones.ID)) {
				this.setActivaridEstadoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoGastoEmpleadoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoGastoEmpleadoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoGastoEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoGastoEmpleadoBeanSwingJInternalFrame estadogastoempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoGastoEmpleado(esInicial);
		this.setResaltarcodigoEstadoGastoEmpleado(esInicial);
		this.setResaltarnombreEstadoGastoEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoGastoEmpleadoConstantesFunciones.ID)) {
				this.setResaltaridEstadoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoGastoEmpleadoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoGastoEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoGastoEmpleadoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoGastoEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarGastoEmpleadoEstadoGastoEmpleado=null;

	public Border getResaltarGastoEmpleadoEstadoGastoEmpleado() {
		return this.resaltarGastoEmpleadoEstadoGastoEmpleado;
	}

	public void setResaltarGastoEmpleadoEstadoGastoEmpleado(Border borderResaltarGastoEmpleado) {
		if(borderResaltarGastoEmpleado!=null) {
			this.resaltarGastoEmpleadoEstadoGastoEmpleado= borderResaltarGastoEmpleado;
		}
	}

	public Border setResaltarGastoEmpleadoEstadoGastoEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoGastoEmpleadoBeanSwingJInternalFrame estadogastoempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarGastoEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadogastoempleadoBeanSwingJInternalFrame.jTtoolBarEstadoGastoEmpleado.setBorder(borderResaltarGastoEmpleado);
			
		this.resaltarGastoEmpleadoEstadoGastoEmpleado= borderResaltarGastoEmpleado;

		 return borderResaltarGastoEmpleado;
	}



	public Boolean mostrarGastoEmpleadoEstadoGastoEmpleado=true;

	public Boolean getMostrarGastoEmpleadoEstadoGastoEmpleado() {
		return this.mostrarGastoEmpleadoEstadoGastoEmpleado;
	}

	public void setMostrarGastoEmpleadoEstadoGastoEmpleado(Boolean visibilidadResaltarGastoEmpleado) {
		this.mostrarGastoEmpleadoEstadoGastoEmpleado= visibilidadResaltarGastoEmpleado;
	}



	public Boolean activarGastoEmpleadoEstadoGastoEmpleado=true;

	public Boolean gethabilitarResaltarGastoEmpleadoEstadoGastoEmpleado() {
		return this.activarGastoEmpleadoEstadoGastoEmpleado;
	}

	public void setActivarGastoEmpleadoEstadoGastoEmpleado(Boolean habilitarResaltarGastoEmpleado) {
		this.activarGastoEmpleadoEstadoGastoEmpleado= habilitarResaltarGastoEmpleado;
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

		this.setMostrarGastoEmpleadoEstadoGastoEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(GastoEmpleado.class)) {
				this.setMostrarGastoEmpleadoEstadoGastoEmpleado(esAsigna);
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

		this.setActivarGastoEmpleadoEstadoGastoEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(GastoEmpleado.class)) {
				this.setActivarGastoEmpleadoEstadoGastoEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoGastoEmpleadoBeanSwingJInternalFrame estadogastoempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarGastoEmpleadoEstadoGastoEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(GastoEmpleado.class)) {
				this.setResaltarGastoEmpleadoEstadoGastoEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}