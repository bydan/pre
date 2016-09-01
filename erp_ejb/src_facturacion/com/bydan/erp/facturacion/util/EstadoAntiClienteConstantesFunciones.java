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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.EstadoAntiClienteConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoAntiClienteParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoAntiClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoAntiClienteConstantesFunciones extends EstadoAntiClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoAntiCliente";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoAntiCliente"+EstadoAntiClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoAntiClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoAntiClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoAntiClienteConstantesFunciones.SCHEMA+"_"+EstadoAntiClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoAntiClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoAntiClienteConstantesFunciones.SCHEMA+"_"+EstadoAntiClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoAntiClienteConstantesFunciones.SCHEMA+"_"+EstadoAntiClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoAntiClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoAntiClienteConstantesFunciones.SCHEMA+"_"+EstadoAntiClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoAntiClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoAntiClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoAntiClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoAntiClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoAntiClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoAntiClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoAntiClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoAntiClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoAntiClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoAntiClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Anti Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Anti Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Estado Anti Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoAntiCliente";
	public static final String OBJECTNAME="estadoanticliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="estado_anti_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadoanticliente from "+EstadoAntiClienteConstantesFunciones.SPERSISTENCENAME+" estadoanticliente";
	public static String QUERYSELECTNATIVE="select "+EstadoAntiClienteConstantesFunciones.SCHEMA+"."+EstadoAntiClienteConstantesFunciones.TABLENAME+".id,"+EstadoAntiClienteConstantesFunciones.SCHEMA+"."+EstadoAntiClienteConstantesFunciones.TABLENAME+".version_row,"+EstadoAntiClienteConstantesFunciones.SCHEMA+"."+EstadoAntiClienteConstantesFunciones.TABLENAME+".codigo,"+EstadoAntiClienteConstantesFunciones.SCHEMA+"."+EstadoAntiClienteConstantesFunciones.TABLENAME+".nombre from "+EstadoAntiClienteConstantesFunciones.SCHEMA+"."+EstadoAntiClienteConstantesFunciones.TABLENAME;//+" as "+EstadoAntiClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoAntiClienteConstantesFuncionesAdditional estadoanticlienteConstantesFuncionesAdditional=null;
	
	public EstadoAntiClienteConstantesFuncionesAdditional getEstadoAntiClienteConstantesFuncionesAdditional() {
		return this.estadoanticlienteConstantesFuncionesAdditional;
	}
	
	public void setEstadoAntiClienteConstantesFuncionesAdditional(EstadoAntiClienteConstantesFuncionesAdditional estadoanticlienteConstantesFuncionesAdditional) {
		try {
			this.estadoanticlienteConstantesFuncionesAdditional=estadoanticlienteConstantesFuncionesAdditional;
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
	
	public static String getEstadoAntiClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoAntiClienteConstantesFunciones.CODIGO)) {sLabelColumna=EstadoAntiClienteConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoAntiClienteConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoAntiClienteConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoAntiClienteDescripcion(EstadoAntiCliente estadoanticliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadoanticliente !=null/* && estadoanticliente.getId()!=0*/) {
			sDescripcion=estadoanticliente.getcodigo();//estadoanticlienteestadoanticliente.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoAntiClienteDescripcionDetallado(EstadoAntiCliente estadoanticliente) {
		String sDescripcion="";
			
		sDescripcion+=EstadoAntiClienteConstantesFunciones.ID+"=";
		sDescripcion+=estadoanticliente.getId().toString()+",";
		sDescripcion+=EstadoAntiClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadoanticliente.getVersionRow().toString()+",";
		sDescripcion+=EstadoAntiClienteConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadoanticliente.getcodigo()+",";
		sDescripcion+=EstadoAntiClienteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadoanticliente.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoAntiClienteDescripcion(EstadoAntiCliente estadoanticliente,String sValor) throws Exception {			
		if(estadoanticliente !=null) {
			estadoanticliente.setcodigo(sValor);;//estadoanticlienteestadoanticliente.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoAntiCliente(EstadoAntiCliente estadoanticliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadoanticliente.setcodigo(estadoanticliente.getcodigo().trim());
		estadoanticliente.setnombre(estadoanticliente.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoAntiClientes(List<EstadoAntiCliente> estadoanticlientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoAntiCliente estadoanticliente: estadoanticlientes) {
			estadoanticliente.setcodigo(estadoanticliente.getcodigo().trim());
			estadoanticliente.setnombre(estadoanticliente.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoAntiCliente(EstadoAntiCliente estadoanticliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadoanticliente.getConCambioAuxiliar()) {
			estadoanticliente.setIsDeleted(estadoanticliente.getIsDeletedAuxiliar());	
			estadoanticliente.setIsNew(estadoanticliente.getIsNewAuxiliar());	
			estadoanticliente.setIsChanged(estadoanticliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadoanticliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadoanticliente.setIsDeletedAuxiliar(false);	
			estadoanticliente.setIsNewAuxiliar(false);	
			estadoanticliente.setIsChangedAuxiliar(false);
			
			estadoanticliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoAntiClientes(List<EstadoAntiCliente> estadoanticlientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoAntiCliente estadoanticliente : estadoanticlientes) {
			if(conAsignarBase && estadoanticliente.getConCambioAuxiliar()) {
				estadoanticliente.setIsDeleted(estadoanticliente.getIsDeletedAuxiliar());	
				estadoanticliente.setIsNew(estadoanticliente.getIsNewAuxiliar());	
				estadoanticliente.setIsChanged(estadoanticliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadoanticliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadoanticliente.setIsDeletedAuxiliar(false);	
				estadoanticliente.setIsNewAuxiliar(false);	
				estadoanticliente.setIsChangedAuxiliar(false);
				
				estadoanticliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoAntiCliente(EstadoAntiCliente estadoanticliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoAntiClientes(List<EstadoAntiCliente> estadoanticlientes,Boolean conEnteros) throws Exception  {
		
		for(EstadoAntiCliente estadoanticliente: estadoanticlientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoAntiCliente(List<EstadoAntiCliente> estadoanticlientes,EstadoAntiCliente estadoanticlienteAux) throws Exception  {
		EstadoAntiClienteConstantesFunciones.InicializarValoresEstadoAntiCliente(estadoanticlienteAux,true);
		
		for(EstadoAntiCliente estadoanticliente: estadoanticlientes) {
			if(estadoanticliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoAntiCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoAntiClienteConstantesFunciones.getArrayColumnasGlobalesEstadoAntiCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoAntiCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoAntiCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoAntiCliente> estadoanticlientes,EstadoAntiCliente estadoanticliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoAntiCliente estadoanticlienteAux: estadoanticlientes) {
			if(estadoanticlienteAux!=null && estadoanticliente!=null) {
				if((estadoanticlienteAux.getId()==null && estadoanticliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadoanticlienteAux.getId()!=null && estadoanticliente.getId()!=null){
					if(estadoanticlienteAux.getId().equals(estadoanticliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoAntiCliente(List<EstadoAntiCliente> estadoanticlientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoAntiCliente estadoanticliente: estadoanticlientes) {			
			if(estadoanticliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoAntiCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoAntiClienteConstantesFunciones.LABEL_ID, EstadoAntiClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoAntiClienteConstantesFunciones.LABEL_VERSIONROW, EstadoAntiClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoAntiClienteConstantesFunciones.LABEL_CODIGO, EstadoAntiClienteConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoAntiClienteConstantesFunciones.LABEL_NOMBRE, EstadoAntiClienteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoAntiCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoAntiClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoAntiClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoAntiClienteConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoAntiClienteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoAntiCliente() throws Exception  {
		return EstadoAntiClienteConstantesFunciones.getTiposSeleccionarEstadoAntiCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoAntiCliente(Boolean conFk) throws Exception  {
		return EstadoAntiClienteConstantesFunciones.getTiposSeleccionarEstadoAntiCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoAntiCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoAntiClienteConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoAntiClienteConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoAntiClienteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoAntiClienteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoAntiCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoAntiCliente(EstadoAntiCliente estadoanticlienteAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoAntiCliente(List<EstadoAntiCliente> estadoanticlientesTemp) throws Exception {
		for(EstadoAntiCliente estadoanticlienteAux:estadoanticlientesTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoAntiCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoAntiCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoAntiCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoAntiClienteConstantesFunciones.getClassesRelationshipsOfEstadoAntiCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoAntiCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(AnticipoCliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(AnticipoCliente.class)) {
						classes.add(new Classe(AnticipoCliente.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoAntiCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoAntiClienteConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoAntiCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoAntiCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(AnticipoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AnticipoCliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(AnticipoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AnticipoCliente.class)); continue;
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
	public static void actualizarLista(EstadoAntiCliente estadoanticliente,List<EstadoAntiCliente> estadoanticlientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoAntiCliente estadoanticlienteEncontrado=null;
			
			for(EstadoAntiCliente estadoanticlienteLocal:estadoanticlientes) {
				if(estadoanticlienteLocal.getId().equals(estadoanticliente.getId())) {
					estadoanticlienteEncontrado=estadoanticlienteLocal;
					
					estadoanticlienteLocal.setIsChanged(estadoanticliente.getIsChanged());
					estadoanticlienteLocal.setIsNew(estadoanticliente.getIsNew());
					estadoanticlienteLocal.setIsDeleted(estadoanticliente.getIsDeleted());
					
					estadoanticlienteLocal.setGeneralEntityOriginal(estadoanticliente.getGeneralEntityOriginal());
					
					estadoanticlienteLocal.setId(estadoanticliente.getId());	
					estadoanticlienteLocal.setVersionRow(estadoanticliente.getVersionRow());	
					estadoanticlienteLocal.setcodigo(estadoanticliente.getcodigo());	
					estadoanticlienteLocal.setnombre(estadoanticliente.getnombre());	
					
					
					estadoanticlienteLocal.setAnticipoClientes(estadoanticliente.getAnticipoClientes());
					
					existe=true;
					break;
				}
			}
			
			if(!estadoanticliente.getIsDeleted()) {
				if(!existe) {
					estadoanticlientes.add(estadoanticliente);
				}
			} else {
				if(estadoanticlienteEncontrado!=null && permiteQuitar)  {
					estadoanticlientes.remove(estadoanticlienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoAntiCliente estadoanticliente,List<EstadoAntiCliente> estadoanticlientes) throws Exception {
		try	{			
			for(EstadoAntiCliente estadoanticlienteLocal:estadoanticlientes) {
				if(estadoanticlienteLocal.getId().equals(estadoanticliente.getId())) {
					estadoanticlienteLocal.setIsSelected(estadoanticliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoAntiCliente(List<EstadoAntiCliente> estadoanticlientesAux) throws Exception {
		//this.estadoanticlientesAux=estadoanticlientesAux;
		
		for(EstadoAntiCliente estadoanticlienteAux:estadoanticlientesAux) {
			if(estadoanticlienteAux.getIsChanged()) {
				estadoanticlienteAux.setIsChanged(false);
			}		
			
			if(estadoanticlienteAux.getIsNew()) {
				estadoanticlienteAux.setIsNew(false);
			}	
			
			if(estadoanticlienteAux.getIsDeleted()) {
				estadoanticlienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoAntiCliente(EstadoAntiCliente estadoanticlienteAux) throws Exception {
		//this.estadoanticlienteAux=estadoanticlienteAux;
		
			if(estadoanticlienteAux.getIsChanged()) {
				estadoanticlienteAux.setIsChanged(false);
			}		
			
			if(estadoanticlienteAux.getIsNew()) {
				estadoanticlienteAux.setIsNew(false);
			}	
			
			if(estadoanticlienteAux.getIsDeleted()) {
				estadoanticlienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoAntiCliente estadoanticlienteAsignar,EstadoAntiCliente estadoanticliente) throws Exception {
		estadoanticlienteAsignar.setId(estadoanticliente.getId());	
		estadoanticlienteAsignar.setVersionRow(estadoanticliente.getVersionRow());	
		estadoanticlienteAsignar.setcodigo(estadoanticliente.getcodigo());	
		estadoanticlienteAsignar.setnombre(estadoanticliente.getnombre());	
	}
	
	public static void inicializarEstadoAntiCliente(EstadoAntiCliente estadoanticliente) throws Exception {
		try {
				estadoanticliente.setId(0L);	
					
				estadoanticliente.setcodigo("");	
				estadoanticliente.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoAntiCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoAntiClienteConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoAntiClienteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoAntiCliente(String sTipo,Row row,Workbook workbook,EstadoAntiCliente estadoanticliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoanticliente.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadoanticliente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoAntiCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoAntiCliente() {
		return this.sFinalQueryEstadoAntiCliente;
	}
	
	public void setsFinalQueryEstadoAntiCliente(String sFinalQueryEstadoAntiCliente) {
		this.sFinalQueryEstadoAntiCliente= sFinalQueryEstadoAntiCliente;
	}
	
	public Border resaltarSeleccionarEstadoAntiCliente=null;
	
	public Border setResaltarSeleccionarEstadoAntiCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoAntiClienteBeanSwingJInternalFrame estadoanticlienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadoanticlienteBeanSwingJInternalFrame.jTtoolBarEstadoAntiCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoAntiCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoAntiCliente() {
		return this.resaltarSeleccionarEstadoAntiCliente;
	}
	
	public void setResaltarSeleccionarEstadoAntiCliente(Border borderResaltarSeleccionarEstadoAntiCliente) {
		this.resaltarSeleccionarEstadoAntiCliente= borderResaltarSeleccionarEstadoAntiCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoAntiCliente=null;
	public Boolean mostraridEstadoAntiCliente=true;
	public Boolean activaridEstadoAntiCliente=true;

	public Border resaltarcodigoEstadoAntiCliente=null;
	public Boolean mostrarcodigoEstadoAntiCliente=true;
	public Boolean activarcodigoEstadoAntiCliente=true;

	public Border resaltarnombreEstadoAntiCliente=null;
	public Boolean mostrarnombreEstadoAntiCliente=true;
	public Boolean activarnombreEstadoAntiCliente=true;

	
	

	public Border setResaltaridEstadoAntiCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoAntiClienteBeanSwingJInternalFrame estadoanticlienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoanticlienteBeanSwingJInternalFrame.jTtoolBarEstadoAntiCliente.setBorder(borderResaltar);
		
		this.resaltaridEstadoAntiCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoAntiCliente() {
		return this.resaltaridEstadoAntiCliente;
	}

	public void setResaltaridEstadoAntiCliente(Border borderResaltar) {
		this.resaltaridEstadoAntiCliente= borderResaltar;
	}

	public Boolean getMostraridEstadoAntiCliente() {
		return this.mostraridEstadoAntiCliente;
	}

	public void setMostraridEstadoAntiCliente(Boolean mostraridEstadoAntiCliente) {
		this.mostraridEstadoAntiCliente= mostraridEstadoAntiCliente;
	}

	public Boolean getActivaridEstadoAntiCliente() {
		return this.activaridEstadoAntiCliente;
	}

	public void setActivaridEstadoAntiCliente(Boolean activaridEstadoAntiCliente) {
		this.activaridEstadoAntiCliente= activaridEstadoAntiCliente;
	}

	public Border setResaltarcodigoEstadoAntiCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoAntiClienteBeanSwingJInternalFrame estadoanticlienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoanticlienteBeanSwingJInternalFrame.jTtoolBarEstadoAntiCliente.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoAntiCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoAntiCliente() {
		return this.resaltarcodigoEstadoAntiCliente;
	}

	public void setResaltarcodigoEstadoAntiCliente(Border borderResaltar) {
		this.resaltarcodigoEstadoAntiCliente= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoAntiCliente() {
		return this.mostrarcodigoEstadoAntiCliente;
	}

	public void setMostrarcodigoEstadoAntiCliente(Boolean mostrarcodigoEstadoAntiCliente) {
		this.mostrarcodigoEstadoAntiCliente= mostrarcodigoEstadoAntiCliente;
	}

	public Boolean getActivarcodigoEstadoAntiCliente() {
		return this.activarcodigoEstadoAntiCliente;
	}

	public void setActivarcodigoEstadoAntiCliente(Boolean activarcodigoEstadoAntiCliente) {
		this.activarcodigoEstadoAntiCliente= activarcodigoEstadoAntiCliente;
	}

	public Border setResaltarnombreEstadoAntiCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoAntiClienteBeanSwingJInternalFrame estadoanticlienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoanticlienteBeanSwingJInternalFrame.jTtoolBarEstadoAntiCliente.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoAntiCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoAntiCliente() {
		return this.resaltarnombreEstadoAntiCliente;
	}

	public void setResaltarnombreEstadoAntiCliente(Border borderResaltar) {
		this.resaltarnombreEstadoAntiCliente= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoAntiCliente() {
		return this.mostrarnombreEstadoAntiCliente;
	}

	public void setMostrarnombreEstadoAntiCliente(Boolean mostrarnombreEstadoAntiCliente) {
		this.mostrarnombreEstadoAntiCliente= mostrarnombreEstadoAntiCliente;
	}

	public Boolean getActivarnombreEstadoAntiCliente() {
		return this.activarnombreEstadoAntiCliente;
	}

	public void setActivarnombreEstadoAntiCliente(Boolean activarnombreEstadoAntiCliente) {
		this.activarnombreEstadoAntiCliente= activarnombreEstadoAntiCliente;
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
		
		
		this.setMostraridEstadoAntiCliente(esInicial);
		this.setMostrarcodigoEstadoAntiCliente(esInicial);
		this.setMostrarnombreEstadoAntiCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoAntiClienteConstantesFunciones.ID)) {
				this.setMostraridEstadoAntiCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAntiClienteConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoAntiCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAntiClienteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoAntiCliente(esAsigna);
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
		
		
		this.setActivaridEstadoAntiCliente(esInicial);
		this.setActivarcodigoEstadoAntiCliente(esInicial);
		this.setActivarnombreEstadoAntiCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoAntiClienteConstantesFunciones.ID)) {
				this.setActivaridEstadoAntiCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAntiClienteConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoAntiCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAntiClienteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoAntiCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoAntiClienteBeanSwingJInternalFrame estadoanticlienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoAntiCliente(esInicial);
		this.setResaltarcodigoEstadoAntiCliente(esInicial);
		this.setResaltarnombreEstadoAntiCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoAntiClienteConstantesFunciones.ID)) {
				this.setResaltaridEstadoAntiCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAntiClienteConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoAntiCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoAntiClienteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoAntiCliente(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarAnticipoClienteEstadoAntiCliente=null;

	public Border getResaltarAnticipoClienteEstadoAntiCliente() {
		return this.resaltarAnticipoClienteEstadoAntiCliente;
	}

	public void setResaltarAnticipoClienteEstadoAntiCliente(Border borderResaltarAnticipoCliente) {
		if(borderResaltarAnticipoCliente!=null) {
			this.resaltarAnticipoClienteEstadoAntiCliente= borderResaltarAnticipoCliente;
		}
	}

	public Border setResaltarAnticipoClienteEstadoAntiCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoAntiClienteBeanSwingJInternalFrame estadoanticlienteBeanSwingJInternalFrame*/) {
		Border borderResaltarAnticipoCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadoanticlienteBeanSwingJInternalFrame.jTtoolBarEstadoAntiCliente.setBorder(borderResaltarAnticipoCliente);
			
		this.resaltarAnticipoClienteEstadoAntiCliente= borderResaltarAnticipoCliente;

		 return borderResaltarAnticipoCliente;
	}



	public Boolean mostrarAnticipoClienteEstadoAntiCliente=true;

	public Boolean getMostrarAnticipoClienteEstadoAntiCliente() {
		return this.mostrarAnticipoClienteEstadoAntiCliente;
	}

	public void setMostrarAnticipoClienteEstadoAntiCliente(Boolean visibilidadResaltarAnticipoCliente) {
		this.mostrarAnticipoClienteEstadoAntiCliente= visibilidadResaltarAnticipoCliente;
	}



	public Boolean activarAnticipoClienteEstadoAntiCliente=true;

	public Boolean gethabilitarResaltarAnticipoClienteEstadoAntiCliente() {
		return this.activarAnticipoClienteEstadoAntiCliente;
	}

	public void setActivarAnticipoClienteEstadoAntiCliente(Boolean habilitarResaltarAnticipoCliente) {
		this.activarAnticipoClienteEstadoAntiCliente= habilitarResaltarAnticipoCliente;
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

		this.setMostrarAnticipoClienteEstadoAntiCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(AnticipoCliente.class)) {
				this.setMostrarAnticipoClienteEstadoAntiCliente(esAsigna);
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

		this.setActivarAnticipoClienteEstadoAntiCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(AnticipoCliente.class)) {
				this.setActivarAnticipoClienteEstadoAntiCliente(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoAntiClienteBeanSwingJInternalFrame estadoanticlienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarAnticipoClienteEstadoAntiCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(AnticipoCliente.class)) {
				this.setResaltarAnticipoClienteEstadoAntiCliente(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}