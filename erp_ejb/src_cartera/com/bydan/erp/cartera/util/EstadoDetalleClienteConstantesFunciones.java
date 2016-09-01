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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.EstadoDetalleClienteConstantesFunciones;
import com.bydan.erp.cartera.util.EstadoDetalleClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.EstadoDetalleClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoDetalleClienteConstantesFunciones extends EstadoDetalleClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoDetalleCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoDetalleCliente"+EstadoDetalleClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoDetalleClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoDetalleClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoDetalleClienteConstantesFunciones.SCHEMA+"_"+EstadoDetalleClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoDetalleClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoDetalleClienteConstantesFunciones.SCHEMA+"_"+EstadoDetalleClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoDetalleClienteConstantesFunciones.SCHEMA+"_"+EstadoDetalleClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoDetalleClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoDetalleClienteConstantesFunciones.SCHEMA+"_"+EstadoDetalleClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoDetalleClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoDetalleClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoDetalleClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoDetalleClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoDetalleClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoDetalleClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Detalle Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Detalle Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Estado Detalle Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoDetalleCliente";
	public static final String OBJECTNAME="estadodetallecliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="estado_detalle_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadodetallecliente from "+EstadoDetalleClienteConstantesFunciones.SPERSISTENCENAME+" estadodetallecliente";
	public static String QUERYSELECTNATIVE="select "+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME+".id,"+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME+".codigo,"+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME+".nombre from "+EstadoDetalleClienteConstantesFunciones.SCHEMA+"."+EstadoDetalleClienteConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoDetalleClienteConstantesFuncionesAdditional estadodetalleclienteConstantesFuncionesAdditional=null;
	
	public EstadoDetalleClienteConstantesFuncionesAdditional getEstadoDetalleClienteConstantesFuncionesAdditional() {
		return this.estadodetalleclienteConstantesFuncionesAdditional;
	}
	
	public void setEstadoDetalleClienteConstantesFuncionesAdditional(EstadoDetalleClienteConstantesFuncionesAdditional estadodetalleclienteConstantesFuncionesAdditional) {
		try {
			this.estadodetalleclienteConstantesFuncionesAdditional=estadodetalleclienteConstantesFuncionesAdditional;
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
	
	public static String getEstadoDetalleClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoDetalleClienteConstantesFunciones.CODIGO)) {sLabelColumna=EstadoDetalleClienteConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoDetalleClienteConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoDetalleClienteConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoDetalleClienteDescripcion(EstadoDetalleCliente estadodetallecliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadodetallecliente !=null/* && estadodetallecliente.getId()!=0*/) {
			sDescripcion=estadodetallecliente.getcodigo();//estadodetalleclienteestadodetallecliente.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoDetalleClienteDescripcionDetallado(EstadoDetalleCliente estadodetallecliente) {
		String sDescripcion="";
			
		sDescripcion+=EstadoDetalleClienteConstantesFunciones.ID+"=";
		sDescripcion+=estadodetallecliente.getId().toString()+",";
		sDescripcion+=EstadoDetalleClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadodetallecliente.getVersionRow().toString()+",";
		sDescripcion+=EstadoDetalleClienteConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadodetallecliente.getcodigo()+",";
		sDescripcion+=EstadoDetalleClienteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadodetallecliente.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoDetalleClienteDescripcion(EstadoDetalleCliente estadodetallecliente,String sValor) throws Exception {			
		if(estadodetallecliente !=null) {
			estadodetallecliente.setcodigo(sValor);;//estadodetalleclienteestadodetallecliente.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoDetalleCliente(EstadoDetalleCliente estadodetallecliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadodetallecliente.setcodigo(estadodetallecliente.getcodigo().trim());
		estadodetallecliente.setnombre(estadodetallecliente.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoDetalleClientes(List<EstadoDetalleCliente> estadodetalleclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoDetalleCliente estadodetallecliente: estadodetalleclientes) {
			estadodetallecliente.setcodigo(estadodetallecliente.getcodigo().trim());
			estadodetallecliente.setnombre(estadodetallecliente.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoDetalleCliente(EstadoDetalleCliente estadodetallecliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadodetallecliente.getConCambioAuxiliar()) {
			estadodetallecliente.setIsDeleted(estadodetallecliente.getIsDeletedAuxiliar());	
			estadodetallecliente.setIsNew(estadodetallecliente.getIsNewAuxiliar());	
			estadodetallecliente.setIsChanged(estadodetallecliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadodetallecliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadodetallecliente.setIsDeletedAuxiliar(false);	
			estadodetallecliente.setIsNewAuxiliar(false);	
			estadodetallecliente.setIsChangedAuxiliar(false);
			
			estadodetallecliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoDetalleClientes(List<EstadoDetalleCliente> estadodetalleclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoDetalleCliente estadodetallecliente : estadodetalleclientes) {
			if(conAsignarBase && estadodetallecliente.getConCambioAuxiliar()) {
				estadodetallecliente.setIsDeleted(estadodetallecliente.getIsDeletedAuxiliar());	
				estadodetallecliente.setIsNew(estadodetallecliente.getIsNewAuxiliar());	
				estadodetallecliente.setIsChanged(estadodetallecliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadodetallecliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadodetallecliente.setIsDeletedAuxiliar(false);	
				estadodetallecliente.setIsNewAuxiliar(false);	
				estadodetallecliente.setIsChangedAuxiliar(false);
				
				estadodetallecliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoDetalleCliente(EstadoDetalleCliente estadodetallecliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoDetalleClientes(List<EstadoDetalleCliente> estadodetalleclientes,Boolean conEnteros) throws Exception  {
		
		for(EstadoDetalleCliente estadodetallecliente: estadodetalleclientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoDetalleCliente(List<EstadoDetalleCliente> estadodetalleclientes,EstadoDetalleCliente estadodetalleclienteAux) throws Exception  {
		EstadoDetalleClienteConstantesFunciones.InicializarValoresEstadoDetalleCliente(estadodetalleclienteAux,true);
		
		for(EstadoDetalleCliente estadodetallecliente: estadodetalleclientes) {
			if(estadodetallecliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoDetalleCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoDetalleClienteConstantesFunciones.getArrayColumnasGlobalesEstadoDetalleCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoDetalleCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoDetalleCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoDetalleCliente> estadodetalleclientes,EstadoDetalleCliente estadodetallecliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoDetalleCliente estadodetalleclienteAux: estadodetalleclientes) {
			if(estadodetalleclienteAux!=null && estadodetallecliente!=null) {
				if((estadodetalleclienteAux.getId()==null && estadodetallecliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadodetalleclienteAux.getId()!=null && estadodetallecliente.getId()!=null){
					if(estadodetalleclienteAux.getId().equals(estadodetallecliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoDetalleCliente(List<EstadoDetalleCliente> estadodetalleclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoDetalleCliente estadodetallecliente: estadodetalleclientes) {			
			if(estadodetallecliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoDetalleCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoDetalleClienteConstantesFunciones.LABEL_ID, EstadoDetalleClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleClienteConstantesFunciones.LABEL_VERSIONROW, EstadoDetalleClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleClienteConstantesFunciones.LABEL_CODIGO, EstadoDetalleClienteConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleClienteConstantesFunciones.LABEL_NOMBRE, EstadoDetalleClienteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoDetalleCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleClienteConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleClienteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleCliente() throws Exception  {
		return EstadoDetalleClienteConstantesFunciones.getTiposSeleccionarEstadoDetalleCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleCliente(Boolean conFk) throws Exception  {
		return EstadoDetalleClienteConstantesFunciones.getTiposSeleccionarEstadoDetalleCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoDetalleClienteConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoDetalleClienteConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoDetalleClienteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoDetalleClienteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoDetalleCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoDetalleCliente(EstadoDetalleCliente estadodetalleclienteAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoDetalleCliente(List<EstadoDetalleCliente> estadodetalleclientesTemp) throws Exception {
		for(EstadoDetalleCliente estadodetalleclienteAux:estadodetalleclientesTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoDetalleCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoDetalleCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoDetalleClienteConstantesFunciones.getClassesRelationshipsOfEstadoDetalleCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleProve.class));
				classes.add(new Classe(DetalleMoviClienProve.class));
				classes.add(new Classe(DetalleCliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleProve.class)) {
						classes.add(new Classe(DetalleProve.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleMoviClienProve.class)) {
						classes.add(new Classe(DetalleMoviClienProve.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleCliente.class)) {
						classes.add(new Classe(DetalleCliente.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoDetalleCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoDetalleClienteConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoDetalleCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoDetalleCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleProve.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleProve.class)); continue;
					}

					if(DetalleMoviClienProve.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMoviClienProve.class)); continue;
					}

					if(DetalleCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleCliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleProve.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleProve.class)); continue;
					}

					if(DetalleMoviClienProve.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMoviClienProve.class)); continue;
					}

					if(DetalleCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleCliente.class)); continue;
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
	public static void actualizarLista(EstadoDetalleCliente estadodetallecliente,List<EstadoDetalleCliente> estadodetalleclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoDetalleCliente estadodetalleclienteEncontrado=null;
			
			for(EstadoDetalleCliente estadodetalleclienteLocal:estadodetalleclientes) {
				if(estadodetalleclienteLocal.getId().equals(estadodetallecliente.getId())) {
					estadodetalleclienteEncontrado=estadodetalleclienteLocal;
					
					estadodetalleclienteLocal.setIsChanged(estadodetallecliente.getIsChanged());
					estadodetalleclienteLocal.setIsNew(estadodetallecliente.getIsNew());
					estadodetalleclienteLocal.setIsDeleted(estadodetallecliente.getIsDeleted());
					
					estadodetalleclienteLocal.setGeneralEntityOriginal(estadodetallecliente.getGeneralEntityOriginal());
					
					estadodetalleclienteLocal.setId(estadodetallecliente.getId());	
					estadodetalleclienteLocal.setVersionRow(estadodetallecliente.getVersionRow());	
					estadodetalleclienteLocal.setcodigo(estadodetallecliente.getcodigo());	
					estadodetalleclienteLocal.setnombre(estadodetallecliente.getnombre());	
					
					
					estadodetalleclienteLocal.setDetalleProves(estadodetallecliente.getDetalleProves());
					estadodetalleclienteLocal.setDetalleMoviClienProves(estadodetallecliente.getDetalleMoviClienProves());
					estadodetalleclienteLocal.setDetalleClientes(estadodetallecliente.getDetalleClientes());
					
					existe=true;
					break;
				}
			}
			
			if(!estadodetallecliente.getIsDeleted()) {
				if(!existe) {
					estadodetalleclientes.add(estadodetallecliente);
				}
			} else {
				if(estadodetalleclienteEncontrado!=null && permiteQuitar)  {
					estadodetalleclientes.remove(estadodetalleclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoDetalleCliente estadodetallecliente,List<EstadoDetalleCliente> estadodetalleclientes) throws Exception {
		try	{			
			for(EstadoDetalleCliente estadodetalleclienteLocal:estadodetalleclientes) {
				if(estadodetalleclienteLocal.getId().equals(estadodetallecliente.getId())) {
					estadodetalleclienteLocal.setIsSelected(estadodetallecliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoDetalleCliente(List<EstadoDetalleCliente> estadodetalleclientesAux) throws Exception {
		//this.estadodetalleclientesAux=estadodetalleclientesAux;
		
		for(EstadoDetalleCliente estadodetalleclienteAux:estadodetalleclientesAux) {
			if(estadodetalleclienteAux.getIsChanged()) {
				estadodetalleclienteAux.setIsChanged(false);
			}		
			
			if(estadodetalleclienteAux.getIsNew()) {
				estadodetalleclienteAux.setIsNew(false);
			}	
			
			if(estadodetalleclienteAux.getIsDeleted()) {
				estadodetalleclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoDetalleCliente(EstadoDetalleCliente estadodetalleclienteAux) throws Exception {
		//this.estadodetalleclienteAux=estadodetalleclienteAux;
		
			if(estadodetalleclienteAux.getIsChanged()) {
				estadodetalleclienteAux.setIsChanged(false);
			}		
			
			if(estadodetalleclienteAux.getIsNew()) {
				estadodetalleclienteAux.setIsNew(false);
			}	
			
			if(estadodetalleclienteAux.getIsDeleted()) {
				estadodetalleclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoDetalleCliente estadodetalleclienteAsignar,EstadoDetalleCliente estadodetallecliente) throws Exception {
		estadodetalleclienteAsignar.setId(estadodetallecliente.getId());	
		estadodetalleclienteAsignar.setVersionRow(estadodetallecliente.getVersionRow());	
		estadodetalleclienteAsignar.setcodigo(estadodetallecliente.getcodigo());	
		estadodetalleclienteAsignar.setnombre(estadodetallecliente.getnombre());	
	}
	
	public static void inicializarEstadoDetalleCliente(EstadoDetalleCliente estadodetallecliente) throws Exception {
		try {
				estadodetallecliente.setId(0L);	
					
				estadodetallecliente.setcodigo("");	
				estadodetallecliente.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoDetalleCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoDetalleClienteConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoDetalleClienteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoDetalleCliente(String sTipo,Row row,Workbook workbook,EstadoDetalleCliente estadodetallecliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadodetallecliente.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadodetallecliente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoDetalleCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoDetalleCliente() {
		return this.sFinalQueryEstadoDetalleCliente;
	}
	
	public void setsFinalQueryEstadoDetalleCliente(String sFinalQueryEstadoDetalleCliente) {
		this.sFinalQueryEstadoDetalleCliente= sFinalQueryEstadoDetalleCliente;
	}
	
	public Border resaltarSeleccionarEstadoDetalleCliente=null;
	
	public Border setResaltarSeleccionarEstadoDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleClienteBeanSwingJInternalFrame estadodetalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadodetalleclienteBeanSwingJInternalFrame.jTtoolBarEstadoDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoDetalleCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoDetalleCliente() {
		return this.resaltarSeleccionarEstadoDetalleCliente;
	}
	
	public void setResaltarSeleccionarEstadoDetalleCliente(Border borderResaltarSeleccionarEstadoDetalleCliente) {
		this.resaltarSeleccionarEstadoDetalleCliente= borderResaltarSeleccionarEstadoDetalleCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoDetalleCliente=null;
	public Boolean mostraridEstadoDetalleCliente=true;
	public Boolean activaridEstadoDetalleCliente=true;

	public Border resaltarcodigoEstadoDetalleCliente=null;
	public Boolean mostrarcodigoEstadoDetalleCliente=true;
	public Boolean activarcodigoEstadoDetalleCliente=true;

	public Border resaltarnombreEstadoDetalleCliente=null;
	public Boolean mostrarnombreEstadoDetalleCliente=true;
	public Boolean activarnombreEstadoDetalleCliente=true;

	
	

	public Border setResaltaridEstadoDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleClienteBeanSwingJInternalFrame estadodetalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetalleclienteBeanSwingJInternalFrame.jTtoolBarEstadoDetalleCliente.setBorder(borderResaltar);
		
		this.resaltaridEstadoDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoDetalleCliente() {
		return this.resaltaridEstadoDetalleCliente;
	}

	public void setResaltaridEstadoDetalleCliente(Border borderResaltar) {
		this.resaltaridEstadoDetalleCliente= borderResaltar;
	}

	public Boolean getMostraridEstadoDetalleCliente() {
		return this.mostraridEstadoDetalleCliente;
	}

	public void setMostraridEstadoDetalleCliente(Boolean mostraridEstadoDetalleCliente) {
		this.mostraridEstadoDetalleCliente= mostraridEstadoDetalleCliente;
	}

	public Boolean getActivaridEstadoDetalleCliente() {
		return this.activaridEstadoDetalleCliente;
	}

	public void setActivaridEstadoDetalleCliente(Boolean activaridEstadoDetalleCliente) {
		this.activaridEstadoDetalleCliente= activaridEstadoDetalleCliente;
	}

	public Border setResaltarcodigoEstadoDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleClienteBeanSwingJInternalFrame estadodetalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetalleclienteBeanSwingJInternalFrame.jTtoolBarEstadoDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoDetalleCliente() {
		return this.resaltarcodigoEstadoDetalleCliente;
	}

	public void setResaltarcodigoEstadoDetalleCliente(Border borderResaltar) {
		this.resaltarcodigoEstadoDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoDetalleCliente() {
		return this.mostrarcodigoEstadoDetalleCliente;
	}

	public void setMostrarcodigoEstadoDetalleCliente(Boolean mostrarcodigoEstadoDetalleCliente) {
		this.mostrarcodigoEstadoDetalleCliente= mostrarcodigoEstadoDetalleCliente;
	}

	public Boolean getActivarcodigoEstadoDetalleCliente() {
		return this.activarcodigoEstadoDetalleCliente;
	}

	public void setActivarcodigoEstadoDetalleCliente(Boolean activarcodigoEstadoDetalleCliente) {
		this.activarcodigoEstadoDetalleCliente= activarcodigoEstadoDetalleCliente;
	}

	public Border setResaltarnombreEstadoDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleClienteBeanSwingJInternalFrame estadodetalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetalleclienteBeanSwingJInternalFrame.jTtoolBarEstadoDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoDetalleCliente() {
		return this.resaltarnombreEstadoDetalleCliente;
	}

	public void setResaltarnombreEstadoDetalleCliente(Border borderResaltar) {
		this.resaltarnombreEstadoDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoDetalleCliente() {
		return this.mostrarnombreEstadoDetalleCliente;
	}

	public void setMostrarnombreEstadoDetalleCliente(Boolean mostrarnombreEstadoDetalleCliente) {
		this.mostrarnombreEstadoDetalleCliente= mostrarnombreEstadoDetalleCliente;
	}

	public Boolean getActivarnombreEstadoDetalleCliente() {
		return this.activarnombreEstadoDetalleCliente;
	}

	public void setActivarnombreEstadoDetalleCliente(Boolean activarnombreEstadoDetalleCliente) {
		this.activarnombreEstadoDetalleCliente= activarnombreEstadoDetalleCliente;
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
		
		
		this.setMostraridEstadoDetalleCliente(esInicial);
		this.setMostrarcodigoEstadoDetalleCliente(esInicial);
		this.setMostrarnombreEstadoDetalleCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleClienteConstantesFunciones.ID)) {
				this.setMostraridEstadoDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleClienteConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleClienteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoDetalleCliente(esAsigna);
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
		
		
		this.setActivaridEstadoDetalleCliente(esInicial);
		this.setActivarcodigoEstadoDetalleCliente(esInicial);
		this.setActivarnombreEstadoDetalleCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleClienteConstantesFunciones.ID)) {
				this.setActivaridEstadoDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleClienteConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleClienteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoDetalleCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoDetalleClienteBeanSwingJInternalFrame estadodetalleclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoDetalleCliente(esInicial);
		this.setResaltarcodigoEstadoDetalleCliente(esInicial);
		this.setResaltarnombreEstadoDetalleCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleClienteConstantesFunciones.ID)) {
				this.setResaltaridEstadoDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleClienteConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleClienteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoDetalleCliente(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleProveEstadoDetalleCliente=null;

	public Border getResaltarDetalleProveEstadoDetalleCliente() {
		return this.resaltarDetalleProveEstadoDetalleCliente;
	}

	public void setResaltarDetalleProveEstadoDetalleCliente(Border borderResaltarDetalleProve) {
		if(borderResaltarDetalleProve!=null) {
			this.resaltarDetalleProveEstadoDetalleCliente= borderResaltarDetalleProve;
		}
	}

	public Border setResaltarDetalleProveEstadoDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleClienteBeanSwingJInternalFrame estadodetalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleProve=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadodetalleclienteBeanSwingJInternalFrame.jTtoolBarEstadoDetalleCliente.setBorder(borderResaltarDetalleProve);
			
		this.resaltarDetalleProveEstadoDetalleCliente= borderResaltarDetalleProve;

		 return borderResaltarDetalleProve;
	}



	public Boolean mostrarDetalleProveEstadoDetalleCliente=true;

	public Boolean getMostrarDetalleProveEstadoDetalleCliente() {
		return this.mostrarDetalleProveEstadoDetalleCliente;
	}

	public void setMostrarDetalleProveEstadoDetalleCliente(Boolean visibilidadResaltarDetalleProve) {
		this.mostrarDetalleProveEstadoDetalleCliente= visibilidadResaltarDetalleProve;
	}



	public Boolean activarDetalleProveEstadoDetalleCliente=true;

	public Boolean gethabilitarResaltarDetalleProveEstadoDetalleCliente() {
		return this.activarDetalleProveEstadoDetalleCliente;
	}

	public void setActivarDetalleProveEstadoDetalleCliente(Boolean habilitarResaltarDetalleProve) {
		this.activarDetalleProveEstadoDetalleCliente= habilitarResaltarDetalleProve;
	}


	public Border resaltarDetalleMoviClienProveEstadoDetalleCliente=null;

	public Border getResaltarDetalleMoviClienProveEstadoDetalleCliente() {
		return this.resaltarDetalleMoviClienProveEstadoDetalleCliente;
	}

	public void setResaltarDetalleMoviClienProveEstadoDetalleCliente(Border borderResaltarDetalleMoviClienProve) {
		if(borderResaltarDetalleMoviClienProve!=null) {
			this.resaltarDetalleMoviClienProveEstadoDetalleCliente= borderResaltarDetalleMoviClienProve;
		}
	}

	public Border setResaltarDetalleMoviClienProveEstadoDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleClienteBeanSwingJInternalFrame estadodetalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleMoviClienProve=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadodetalleclienteBeanSwingJInternalFrame.jTtoolBarEstadoDetalleCliente.setBorder(borderResaltarDetalleMoviClienProve);
			
		this.resaltarDetalleMoviClienProveEstadoDetalleCliente= borderResaltarDetalleMoviClienProve;

		 return borderResaltarDetalleMoviClienProve;
	}



	public Boolean mostrarDetalleMoviClienProveEstadoDetalleCliente=true;

	public Boolean getMostrarDetalleMoviClienProveEstadoDetalleCliente() {
		return this.mostrarDetalleMoviClienProveEstadoDetalleCliente;
	}

	public void setMostrarDetalleMoviClienProveEstadoDetalleCliente(Boolean visibilidadResaltarDetalleMoviClienProve) {
		this.mostrarDetalleMoviClienProveEstadoDetalleCliente= visibilidadResaltarDetalleMoviClienProve;
	}



	public Boolean activarDetalleMoviClienProveEstadoDetalleCliente=true;

	public Boolean gethabilitarResaltarDetalleMoviClienProveEstadoDetalleCliente() {
		return this.activarDetalleMoviClienProveEstadoDetalleCliente;
	}

	public void setActivarDetalleMoviClienProveEstadoDetalleCliente(Boolean habilitarResaltarDetalleMoviClienProve) {
		this.activarDetalleMoviClienProveEstadoDetalleCliente= habilitarResaltarDetalleMoviClienProve;
	}


	public Border resaltarDetalleClienteEstadoDetalleCliente=null;

	public Border getResaltarDetalleClienteEstadoDetalleCliente() {
		return this.resaltarDetalleClienteEstadoDetalleCliente;
	}

	public void setResaltarDetalleClienteEstadoDetalleCliente(Border borderResaltarDetalleCliente) {
		if(borderResaltarDetalleCliente!=null) {
			this.resaltarDetalleClienteEstadoDetalleCliente= borderResaltarDetalleCliente;
		}
	}

	public Border setResaltarDetalleClienteEstadoDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleClienteBeanSwingJInternalFrame estadodetalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadodetalleclienteBeanSwingJInternalFrame.jTtoolBarEstadoDetalleCliente.setBorder(borderResaltarDetalleCliente);
			
		this.resaltarDetalleClienteEstadoDetalleCliente= borderResaltarDetalleCliente;

		 return borderResaltarDetalleCliente;
	}



	public Boolean mostrarDetalleClienteEstadoDetalleCliente=true;

	public Boolean getMostrarDetalleClienteEstadoDetalleCliente() {
		return this.mostrarDetalleClienteEstadoDetalleCliente;
	}

	public void setMostrarDetalleClienteEstadoDetalleCliente(Boolean visibilidadResaltarDetalleCliente) {
		this.mostrarDetalleClienteEstadoDetalleCliente= visibilidadResaltarDetalleCliente;
	}



	public Boolean activarDetalleClienteEstadoDetalleCliente=true;

	public Boolean gethabilitarResaltarDetalleClienteEstadoDetalleCliente() {
		return this.activarDetalleClienteEstadoDetalleCliente;
	}

	public void setActivarDetalleClienteEstadoDetalleCliente(Boolean habilitarResaltarDetalleCliente) {
		this.activarDetalleClienteEstadoDetalleCliente= habilitarResaltarDetalleCliente;
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

		this.setMostrarDetalleProveEstadoDetalleCliente(esInicial);
		this.setMostrarDetalleMoviClienProveEstadoDetalleCliente(esInicial);
		this.setMostrarDetalleClienteEstadoDetalleCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleProve.class)) {
				this.setMostrarDetalleProveEstadoDetalleCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleMoviClienProve.class)) {
				this.setMostrarDetalleMoviClienProveEstadoDetalleCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleCliente.class)) {
				this.setMostrarDetalleClienteEstadoDetalleCliente(esAsigna);
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

		this.setActivarDetalleProveEstadoDetalleCliente(esInicial);
		this.setActivarDetalleMoviClienProveEstadoDetalleCliente(esInicial);
		this.setActivarDetalleClienteEstadoDetalleCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleProve.class)) {
				this.setActivarDetalleProveEstadoDetalleCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleMoviClienProve.class)) {
				this.setActivarDetalleMoviClienProveEstadoDetalleCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleCliente.class)) {
				this.setActivarDetalleClienteEstadoDetalleCliente(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoDetalleClienteBeanSwingJInternalFrame estadodetalleclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleProveEstadoDetalleCliente(esInicial);
		this.setResaltarDetalleMoviClienProveEstadoDetalleCliente(esInicial);
		this.setResaltarDetalleClienteEstadoDetalleCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleProve.class)) {
				this.setResaltarDetalleProveEstadoDetalleCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleMoviClienProve.class)) {
				this.setResaltarDetalleMoviClienProveEstadoDetalleCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleCliente.class)) {
				this.setResaltarDetalleClienteEstadoDetalleCliente(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}