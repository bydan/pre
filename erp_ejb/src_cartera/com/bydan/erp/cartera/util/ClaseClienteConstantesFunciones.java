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


import com.bydan.erp.cartera.util.ClaseClienteConstantesFunciones;
import com.bydan.erp.cartera.util.ClaseClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ClaseClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ClaseClienteConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ClaseCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ClaseCliente"+ClaseClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ClaseClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ClaseClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ClaseClienteConstantesFunciones.SCHEMA+"_"+ClaseClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ClaseClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ClaseClienteConstantesFunciones.SCHEMA+"_"+ClaseClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ClaseClienteConstantesFunciones.SCHEMA+"_"+ClaseClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ClaseClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ClaseClienteConstantesFunciones.SCHEMA+"_"+ClaseClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClaseClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ClaseClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClaseClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClaseClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ClaseClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClaseClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ClaseClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ClaseClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ClaseClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ClaseClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Clase Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Clase Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Clase Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ClaseCliente";
	public static final String OBJECTNAME="clasecliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="clase_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select clasecliente from "+ClaseClienteConstantesFunciones.SPERSISTENCENAME+" clasecliente";
	public static String QUERYSELECTNATIVE="select "+ClaseClienteConstantesFunciones.SCHEMA+"."+ClaseClienteConstantesFunciones.TABLENAME+".id,"+ClaseClienteConstantesFunciones.SCHEMA+"."+ClaseClienteConstantesFunciones.TABLENAME+".version_row,"+ClaseClienteConstantesFunciones.SCHEMA+"."+ClaseClienteConstantesFunciones.TABLENAME+".id_empresa,"+ClaseClienteConstantesFunciones.SCHEMA+"."+ClaseClienteConstantesFunciones.TABLENAME+".codigo,"+ClaseClienteConstantesFunciones.SCHEMA+"."+ClaseClienteConstantesFunciones.TABLENAME+".nombre from "+ClaseClienteConstantesFunciones.SCHEMA+"."+ClaseClienteConstantesFunciones.TABLENAME;//+" as "+ClaseClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getClaseClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ClaseClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=ClaseClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ClaseClienteConstantesFunciones.CODIGO)) {sLabelColumna=ClaseClienteConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ClaseClienteConstantesFunciones.NOMBRE)) {sLabelColumna=ClaseClienteConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getClaseClienteDescripcion(ClaseCliente clasecliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(clasecliente !=null/* && clasecliente.getId()!=0*/) {
			sDescripcion=clasecliente.getcodigo();//claseclienteclasecliente.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getClaseClienteDescripcionDetallado(ClaseCliente clasecliente) {
		String sDescripcion="";
			
		sDescripcion+=ClaseClienteConstantesFunciones.ID+"=";
		sDescripcion+=clasecliente.getId().toString()+",";
		sDescripcion+=ClaseClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=clasecliente.getVersionRow().toString()+",";
		sDescripcion+=ClaseClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=clasecliente.getid_empresa().toString()+",";
		sDescripcion+=ClaseClienteConstantesFunciones.CODIGO+"=";
		sDescripcion+=clasecliente.getcodigo()+",";
		sDescripcion+=ClaseClienteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=clasecliente.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setClaseClienteDescripcion(ClaseCliente clasecliente,String sValor) throws Exception {			
		if(clasecliente !=null) {
			clasecliente.setcodigo(sValor);;//claseclienteclasecliente.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosClaseCliente(ClaseCliente clasecliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		clasecliente.setcodigo(clasecliente.getcodigo().trim());
		clasecliente.setnombre(clasecliente.getnombre().trim());
	}
	
	public static void quitarEspaciosClaseClientes(List<ClaseCliente> claseclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ClaseCliente clasecliente: claseclientes) {
			clasecliente.setcodigo(clasecliente.getcodigo().trim());
			clasecliente.setnombre(clasecliente.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresClaseCliente(ClaseCliente clasecliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && clasecliente.getConCambioAuxiliar()) {
			clasecliente.setIsDeleted(clasecliente.getIsDeletedAuxiliar());	
			clasecliente.setIsNew(clasecliente.getIsNewAuxiliar());	
			clasecliente.setIsChanged(clasecliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			clasecliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			clasecliente.setIsDeletedAuxiliar(false);	
			clasecliente.setIsNewAuxiliar(false);	
			clasecliente.setIsChangedAuxiliar(false);
			
			clasecliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresClaseClientes(List<ClaseCliente> claseclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ClaseCliente clasecliente : claseclientes) {
			if(conAsignarBase && clasecliente.getConCambioAuxiliar()) {
				clasecliente.setIsDeleted(clasecliente.getIsDeletedAuxiliar());	
				clasecliente.setIsNew(clasecliente.getIsNewAuxiliar());	
				clasecliente.setIsChanged(clasecliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				clasecliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				clasecliente.setIsDeletedAuxiliar(false);	
				clasecliente.setIsNewAuxiliar(false);	
				clasecliente.setIsChangedAuxiliar(false);
				
				clasecliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresClaseCliente(ClaseCliente clasecliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresClaseClientes(List<ClaseCliente> claseclientes,Boolean conEnteros) throws Exception  {
		
		for(ClaseCliente clasecliente: claseclientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaClaseCliente(List<ClaseCliente> claseclientes,ClaseCliente claseclienteAux) throws Exception  {
		ClaseClienteConstantesFunciones.InicializarValoresClaseCliente(claseclienteAux,true);
		
		for(ClaseCliente clasecliente: claseclientes) {
			if(clasecliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesClaseCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ClaseClienteConstantesFunciones.getArrayColumnasGlobalesClaseCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesClaseCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ClaseClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ClaseClienteConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoClaseCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ClaseCliente> claseclientes,ClaseCliente clasecliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ClaseCliente claseclienteAux: claseclientes) {
			if(claseclienteAux!=null && clasecliente!=null) {
				if((claseclienteAux.getId()==null && clasecliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(claseclienteAux.getId()!=null && clasecliente.getId()!=null){
					if(claseclienteAux.getId().equals(clasecliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaClaseCliente(List<ClaseCliente> claseclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ClaseCliente clasecliente: claseclientes) {			
			if(clasecliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaClaseCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ClaseClienteConstantesFunciones.LABEL_ID, ClaseClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClaseClienteConstantesFunciones.LABEL_VERSIONROW, ClaseClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClaseClienteConstantesFunciones.LABEL_IDEMPRESA, ClaseClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClaseClienteConstantesFunciones.LABEL_CODIGO, ClaseClienteConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClaseClienteConstantesFunciones.LABEL_NOMBRE, ClaseClienteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasClaseCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ClaseClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClaseClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClaseClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClaseClienteConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClaseClienteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClaseCliente() throws Exception  {
		return ClaseClienteConstantesFunciones.getTiposSeleccionarClaseCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClaseCliente(Boolean conFk) throws Exception  {
		return ClaseClienteConstantesFunciones.getTiposSeleccionarClaseCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClaseCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClaseClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ClaseClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClaseClienteConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ClaseClienteConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClaseClienteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ClaseClienteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesClaseCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesClaseCliente(ClaseCliente claseclienteAux) throws Exception {
		
			claseclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(claseclienteAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesClaseCliente(List<ClaseCliente> claseclientesTemp) throws Exception {
		for(ClaseCliente claseclienteAux:claseclientesTemp) {
			
			claseclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(claseclienteAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfClaseCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfClaseCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfClaseCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ClaseClienteConstantesFunciones.getClassesRelationshipsOfClaseCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfClaseCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfClaseCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ClaseClienteConstantesFunciones.getClassesRelationshipsFromStringsOfClaseCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfClaseCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ClaseCliente clasecliente,List<ClaseCliente> claseclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ClaseCliente claseclienteEncontrado=null;
			
			for(ClaseCliente claseclienteLocal:claseclientes) {
				if(claseclienteLocal.getId().equals(clasecliente.getId())) {
					claseclienteEncontrado=claseclienteLocal;
					
					claseclienteLocal.setIsChanged(clasecliente.getIsChanged());
					claseclienteLocal.setIsNew(clasecliente.getIsNew());
					claseclienteLocal.setIsDeleted(clasecliente.getIsDeleted());
					
					claseclienteLocal.setGeneralEntityOriginal(clasecliente.getGeneralEntityOriginal());
					
					claseclienteLocal.setId(clasecliente.getId());	
					claseclienteLocal.setVersionRow(clasecliente.getVersionRow());	
					claseclienteLocal.setid_empresa(clasecliente.getid_empresa());	
					claseclienteLocal.setcodigo(clasecliente.getcodigo());	
					claseclienteLocal.setnombre(clasecliente.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!clasecliente.getIsDeleted()) {
				if(!existe) {
					claseclientes.add(clasecliente);
				}
			} else {
				if(claseclienteEncontrado!=null && permiteQuitar)  {
					claseclientes.remove(claseclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ClaseCliente clasecliente,List<ClaseCliente> claseclientes) throws Exception {
		try	{			
			for(ClaseCliente claseclienteLocal:claseclientes) {
				if(claseclienteLocal.getId().equals(clasecliente.getId())) {
					claseclienteLocal.setIsSelected(clasecliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesClaseCliente(List<ClaseCliente> claseclientesAux) throws Exception {
		//this.claseclientesAux=claseclientesAux;
		
		for(ClaseCliente claseclienteAux:claseclientesAux) {
			if(claseclienteAux.getIsChanged()) {
				claseclienteAux.setIsChanged(false);
			}		
			
			if(claseclienteAux.getIsNew()) {
				claseclienteAux.setIsNew(false);
			}	
			
			if(claseclienteAux.getIsDeleted()) {
				claseclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesClaseCliente(ClaseCliente claseclienteAux) throws Exception {
		//this.claseclienteAux=claseclienteAux;
		
			if(claseclienteAux.getIsChanged()) {
				claseclienteAux.setIsChanged(false);
			}		
			
			if(claseclienteAux.getIsNew()) {
				claseclienteAux.setIsNew(false);
			}	
			
			if(claseclienteAux.getIsDeleted()) {
				claseclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ClaseCliente claseclienteAsignar,ClaseCliente clasecliente) throws Exception {
		claseclienteAsignar.setId(clasecliente.getId());	
		claseclienteAsignar.setVersionRow(clasecliente.getVersionRow());	
		claseclienteAsignar.setid_empresa(clasecliente.getid_empresa());
		claseclienteAsignar.setempresa_descripcion(clasecliente.getempresa_descripcion());	
		claseclienteAsignar.setcodigo(clasecliente.getcodigo());	
		claseclienteAsignar.setnombre(clasecliente.getnombre());	
	}
	
	public static void inicializarClaseCliente(ClaseCliente clasecliente) throws Exception {
		try {
				clasecliente.setId(0L);	
					
				clasecliente.setid_empresa(-1L);	
				clasecliente.setcodigo("");	
				clasecliente.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderClaseCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ClaseClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClaseClienteConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClaseClienteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataClaseCliente(String sTipo,Row row,Workbook workbook,ClaseCliente clasecliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(clasecliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clasecliente.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clasecliente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryClaseCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryClaseCliente() {
		return this.sFinalQueryClaseCliente;
	}
	
	public void setsFinalQueryClaseCliente(String sFinalQueryClaseCliente) {
		this.sFinalQueryClaseCliente= sFinalQueryClaseCliente;
	}
	
	public Border resaltarSeleccionarClaseCliente=null;
	
	public Border setResaltarSeleccionarClaseCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseClienteBeanSwingJInternalFrame claseclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//claseclienteBeanSwingJInternalFrame.jTtoolBarClaseCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarClaseCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarClaseCliente() {
		return this.resaltarSeleccionarClaseCliente;
	}
	
	public void setResaltarSeleccionarClaseCliente(Border borderResaltarSeleccionarClaseCliente) {
		this.resaltarSeleccionarClaseCliente= borderResaltarSeleccionarClaseCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridClaseCliente=null;
	public Boolean mostraridClaseCliente=true;
	public Boolean activaridClaseCliente=true;

	public Border resaltarid_empresaClaseCliente=null;
	public Boolean mostrarid_empresaClaseCliente=true;
	public Boolean activarid_empresaClaseCliente=true;
	public Boolean cargarid_empresaClaseCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaClaseCliente=false;//ConEventDepend=true

	public Border resaltarcodigoClaseCliente=null;
	public Boolean mostrarcodigoClaseCliente=true;
	public Boolean activarcodigoClaseCliente=true;

	public Border resaltarnombreClaseCliente=null;
	public Boolean mostrarnombreClaseCliente=true;
	public Boolean activarnombreClaseCliente=true;

	
	

	public Border setResaltaridClaseCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseClienteBeanSwingJInternalFrame claseclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//claseclienteBeanSwingJInternalFrame.jTtoolBarClaseCliente.setBorder(borderResaltar);
		
		this.resaltaridClaseCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridClaseCliente() {
		return this.resaltaridClaseCliente;
	}

	public void setResaltaridClaseCliente(Border borderResaltar) {
		this.resaltaridClaseCliente= borderResaltar;
	}

	public Boolean getMostraridClaseCliente() {
		return this.mostraridClaseCliente;
	}

	public void setMostraridClaseCliente(Boolean mostraridClaseCliente) {
		this.mostraridClaseCliente= mostraridClaseCliente;
	}

	public Boolean getActivaridClaseCliente() {
		return this.activaridClaseCliente;
	}

	public void setActivaridClaseCliente(Boolean activaridClaseCliente) {
		this.activaridClaseCliente= activaridClaseCliente;
	}

	public Border setResaltarid_empresaClaseCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseClienteBeanSwingJInternalFrame claseclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//claseclienteBeanSwingJInternalFrame.jTtoolBarClaseCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaClaseCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaClaseCliente() {
		return this.resaltarid_empresaClaseCliente;
	}

	public void setResaltarid_empresaClaseCliente(Border borderResaltar) {
		this.resaltarid_empresaClaseCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaClaseCliente() {
		return this.mostrarid_empresaClaseCliente;
	}

	public void setMostrarid_empresaClaseCliente(Boolean mostrarid_empresaClaseCliente) {
		this.mostrarid_empresaClaseCliente= mostrarid_empresaClaseCliente;
	}

	public Boolean getActivarid_empresaClaseCliente() {
		return this.activarid_empresaClaseCliente;
	}

	public void setActivarid_empresaClaseCliente(Boolean activarid_empresaClaseCliente) {
		this.activarid_empresaClaseCliente= activarid_empresaClaseCliente;
	}

	public Boolean getCargarid_empresaClaseCliente() {
		return this.cargarid_empresaClaseCliente;
	}

	public void setCargarid_empresaClaseCliente(Boolean cargarid_empresaClaseCliente) {
		this.cargarid_empresaClaseCliente= cargarid_empresaClaseCliente;
	}

	public Border setResaltarcodigoClaseCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseClienteBeanSwingJInternalFrame claseclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//claseclienteBeanSwingJInternalFrame.jTtoolBarClaseCliente.setBorder(borderResaltar);
		
		this.resaltarcodigoClaseCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoClaseCliente() {
		return this.resaltarcodigoClaseCliente;
	}

	public void setResaltarcodigoClaseCliente(Border borderResaltar) {
		this.resaltarcodigoClaseCliente= borderResaltar;
	}

	public Boolean getMostrarcodigoClaseCliente() {
		return this.mostrarcodigoClaseCliente;
	}

	public void setMostrarcodigoClaseCliente(Boolean mostrarcodigoClaseCliente) {
		this.mostrarcodigoClaseCliente= mostrarcodigoClaseCliente;
	}

	public Boolean getActivarcodigoClaseCliente() {
		return this.activarcodigoClaseCliente;
	}

	public void setActivarcodigoClaseCliente(Boolean activarcodigoClaseCliente) {
		this.activarcodigoClaseCliente= activarcodigoClaseCliente;
	}

	public Border setResaltarnombreClaseCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseClienteBeanSwingJInternalFrame claseclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//claseclienteBeanSwingJInternalFrame.jTtoolBarClaseCliente.setBorder(borderResaltar);
		
		this.resaltarnombreClaseCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreClaseCliente() {
		return this.resaltarnombreClaseCliente;
	}

	public void setResaltarnombreClaseCliente(Border borderResaltar) {
		this.resaltarnombreClaseCliente= borderResaltar;
	}

	public Boolean getMostrarnombreClaseCliente() {
		return this.mostrarnombreClaseCliente;
	}

	public void setMostrarnombreClaseCliente(Boolean mostrarnombreClaseCliente) {
		this.mostrarnombreClaseCliente= mostrarnombreClaseCliente;
	}

	public Boolean getActivarnombreClaseCliente() {
		return this.activarnombreClaseCliente;
	}

	public void setActivarnombreClaseCliente(Boolean activarnombreClaseCliente) {
		this.activarnombreClaseCliente= activarnombreClaseCliente;
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
		
		
		this.setMostraridClaseCliente(esInicial);
		this.setMostrarid_empresaClaseCliente(esInicial);
		this.setMostrarcodigoClaseCliente(esInicial);
		this.setMostrarnombreClaseCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClaseClienteConstantesFunciones.ID)) {
				this.setMostraridClaseCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaClaseCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseClienteConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoClaseCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseClienteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreClaseCliente(esAsigna);
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
		
		
		this.setActivaridClaseCliente(esInicial);
		this.setActivarid_empresaClaseCliente(esInicial);
		this.setActivarcodigoClaseCliente(esInicial);
		this.setActivarnombreClaseCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClaseClienteConstantesFunciones.ID)) {
				this.setActivaridClaseCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaClaseCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseClienteConstantesFunciones.CODIGO)) {
				this.setActivarcodigoClaseCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseClienteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreClaseCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ClaseClienteBeanSwingJInternalFrame claseclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridClaseCliente(esInicial);
		this.setResaltarid_empresaClaseCliente(esInicial);
		this.setResaltarcodigoClaseCliente(esInicial);
		this.setResaltarnombreClaseCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClaseClienteConstantesFunciones.ID)) {
				this.setResaltaridClaseCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaClaseCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseClienteConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoClaseCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClaseClienteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreClaseCliente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ClaseClienteBeanSwingJInternalFrame claseclienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoClaseCliente=true;

	public Boolean getMostrarBusquedaPorCodigoClaseCliente() {
		return this.mostrarBusquedaPorCodigoClaseCliente;
	}

	public void setMostrarBusquedaPorCodigoClaseCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoClaseCliente= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreClaseCliente=true;

	public Boolean getMostrarBusquedaPorNombreClaseCliente() {
		return this.mostrarBusquedaPorNombreClaseCliente;
	}

	public void setMostrarBusquedaPorNombreClaseCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreClaseCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaClaseCliente=true;

	public Boolean getMostrarFK_IdEmpresaClaseCliente() {
		return this.mostrarFK_IdEmpresaClaseCliente;
	}

	public void setMostrarFK_IdEmpresaClaseCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaClaseCliente= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoClaseCliente=true;

	public Boolean getActivarBusquedaPorCodigoClaseCliente() {
		return this.activarBusquedaPorCodigoClaseCliente;
	}

	public void setActivarBusquedaPorCodigoClaseCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoClaseCliente= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreClaseCliente=true;

	public Boolean getActivarBusquedaPorNombreClaseCliente() {
		return this.activarBusquedaPorNombreClaseCliente;
	}

	public void setActivarBusquedaPorNombreClaseCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreClaseCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaClaseCliente=true;

	public Boolean getActivarFK_IdEmpresaClaseCliente() {
		return this.activarFK_IdEmpresaClaseCliente;
	}

	public void setActivarFK_IdEmpresaClaseCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaClaseCliente= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoClaseCliente=null;

	public Border getResaltarBusquedaPorCodigoClaseCliente() {
		return this.resaltarBusquedaPorCodigoClaseCliente;
	}

	public void setResaltarBusquedaPorCodigoClaseCliente(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoClaseCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoClaseCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseClienteBeanSwingJInternalFrame claseclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoClaseCliente= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreClaseCliente=null;

	public Border getResaltarBusquedaPorNombreClaseCliente() {
		return this.resaltarBusquedaPorNombreClaseCliente;
	}

	public void setResaltarBusquedaPorNombreClaseCliente(Border borderResaltar) {
		this.resaltarBusquedaPorNombreClaseCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreClaseCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseClienteBeanSwingJInternalFrame claseclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreClaseCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaClaseCliente=null;

	public Border getResaltarFK_IdEmpresaClaseCliente() {
		return this.resaltarFK_IdEmpresaClaseCliente;
	}

	public void setResaltarFK_IdEmpresaClaseCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaClaseCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaClaseCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClaseClienteBeanSwingJInternalFrame claseclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaClaseCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}