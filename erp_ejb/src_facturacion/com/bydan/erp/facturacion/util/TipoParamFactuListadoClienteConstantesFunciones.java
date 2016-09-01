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


import com.bydan.erp.facturacion.util.TipoParamFactuListadoClienteConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoParamFactuListadoClienteParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoParamFactuListadoClienteParameterGeneral;

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
final public class TipoParamFactuListadoClienteConstantesFunciones extends TipoParamFactuListadoClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoParamFactuListadoCliente";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoParamFactuListadoCliente"+TipoParamFactuListadoClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoParamFactuListadoClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoParamFactuListadoClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"_"+TipoParamFactuListadoClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoParamFactuListadoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"_"+TipoParamFactuListadoClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"_"+TipoParamFactuListadoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoParamFactuListadoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"_"+TipoParamFactuListadoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParamFactuListadoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoParamFactuListadoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParamFactuListadoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParamFactuListadoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoParamFactuListadoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParamFactuListadoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoParamFactuListadoClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoParamFactuListadoClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoParamFactuListadoClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoParamFactuListadoClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Listado Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Listado Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Param Factu Listado Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoParamFactuListadoCliente";
	public static final String OBJECTNAME="tipoparamfactulistadocliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_param_factu_listado_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoparamfactulistadocliente from "+TipoParamFactuListadoClienteConstantesFunciones.SPERSISTENCENAME+" tipoparamfactulistadocliente";
	public static String QUERYSELECTNATIVE="select "+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"."+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME+".id,"+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"."+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME+".version_row,"+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"."+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME+".nombre from "+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"."+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME;//+" as "+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoParamFactuListadoClienteConstantesFuncionesAdditional tipoparamfactulistadoclienteConstantesFuncionesAdditional=null;
	
	public TipoParamFactuListadoClienteConstantesFuncionesAdditional getTipoParamFactuListadoClienteConstantesFuncionesAdditional() {
		return this.tipoparamfactulistadoclienteConstantesFuncionesAdditional;
	}
	
	public void setTipoParamFactuListadoClienteConstantesFuncionesAdditional(TipoParamFactuListadoClienteConstantesFuncionesAdditional tipoparamfactulistadoclienteConstantesFuncionesAdditional) {
		try {
			this.tipoparamfactulistadoclienteConstantesFuncionesAdditional=tipoparamfactulistadoclienteConstantesFuncionesAdditional;
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
	
	public static String getTipoParamFactuListadoClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoParamFactuListadoClienteConstantesFunciones.NOMBRE)) {sLabelColumna=TipoParamFactuListadoClienteConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getTipoParamFactuListadoClienteDescripcion(TipoParamFactuListadoCliente tipoparamfactulistadocliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoparamfactulistadocliente !=null/* && tipoparamfactulistadocliente.getId()!=0*/) {
			sDescripcion=tipoparamfactulistadocliente.getnombre();//tipoparamfactulistadoclientetipoparamfactulistadocliente.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoParamFactuListadoClienteDescripcionDetallado(TipoParamFactuListadoCliente tipoparamfactulistadocliente) {
		String sDescripcion="";
			
		sDescripcion+=TipoParamFactuListadoClienteConstantesFunciones.ID+"=";
		sDescripcion+=tipoparamfactulistadocliente.getId().toString()+",";
		sDescripcion+=TipoParamFactuListadoClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoparamfactulistadocliente.getVersionRow().toString()+",";
		sDescripcion+=TipoParamFactuListadoClienteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoparamfactulistadocliente.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoParamFactuListadoClienteDescripcion(TipoParamFactuListadoCliente tipoparamfactulistadocliente,String sValor) throws Exception {			
		if(tipoparamfactulistadocliente !=null) {
			tipoparamfactulistadocliente.setnombre(sValor);//tipoparamfactulistadoclientetipoparamfactulistadocliente.getId().toString();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoParamFactuListadoCliente(TipoParamFactuListadoCliente tipoparamfactulistadocliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoparamfactulistadocliente.setnombre(tipoparamfactulistadocliente.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoParamFactuListadoClientes(List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoParamFactuListadoCliente tipoparamfactulistadocliente: tipoparamfactulistadoclientes) {
			tipoparamfactulistadocliente.setnombre(tipoparamfactulistadocliente.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoParamFactuListadoCliente(TipoParamFactuListadoCliente tipoparamfactulistadocliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoparamfactulistadocliente.getConCambioAuxiliar()) {
			tipoparamfactulistadocliente.setIsDeleted(tipoparamfactulistadocliente.getIsDeletedAuxiliar());	
			tipoparamfactulistadocliente.setIsNew(tipoparamfactulistadocliente.getIsNewAuxiliar());	
			tipoparamfactulistadocliente.setIsChanged(tipoparamfactulistadocliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoparamfactulistadocliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoparamfactulistadocliente.setIsDeletedAuxiliar(false);	
			tipoparamfactulistadocliente.setIsNewAuxiliar(false);	
			tipoparamfactulistadocliente.setIsChangedAuxiliar(false);
			
			tipoparamfactulistadocliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoParamFactuListadoClientes(List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoParamFactuListadoCliente tipoparamfactulistadocliente : tipoparamfactulistadoclientes) {
			if(conAsignarBase && tipoparamfactulistadocliente.getConCambioAuxiliar()) {
				tipoparamfactulistadocliente.setIsDeleted(tipoparamfactulistadocliente.getIsDeletedAuxiliar());	
				tipoparamfactulistadocliente.setIsNew(tipoparamfactulistadocliente.getIsNewAuxiliar());	
				tipoparamfactulistadocliente.setIsChanged(tipoparamfactulistadocliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoparamfactulistadocliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoparamfactulistadocliente.setIsDeletedAuxiliar(false);	
				tipoparamfactulistadocliente.setIsNewAuxiliar(false);	
				tipoparamfactulistadocliente.setIsChangedAuxiliar(false);
				
				tipoparamfactulistadocliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoParamFactuListadoCliente(TipoParamFactuListadoCliente tipoparamfactulistadocliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoParamFactuListadoClientes(List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientes,Boolean conEnteros) throws Exception  {
		
		for(TipoParamFactuListadoCliente tipoparamfactulistadocliente: tipoparamfactulistadoclientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoParamFactuListadoCliente(List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientes,TipoParamFactuListadoCliente tipoparamfactulistadoclienteAux) throws Exception  {
		TipoParamFactuListadoClienteConstantesFunciones.InicializarValoresTipoParamFactuListadoCliente(tipoparamfactulistadoclienteAux,true);
		
		for(TipoParamFactuListadoCliente tipoparamfactulistadocliente: tipoparamfactulistadoclientes) {
			if(tipoparamfactulistadocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoParamFactuListadoCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoParamFactuListadoClienteConstantesFunciones.getArrayColumnasGlobalesTipoParamFactuListadoCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoParamFactuListadoCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoParamFactuListadoCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientes,TipoParamFactuListadoCliente tipoparamfactulistadocliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoParamFactuListadoCliente tipoparamfactulistadoclienteAux: tipoparamfactulistadoclientes) {
			if(tipoparamfactulistadoclienteAux!=null && tipoparamfactulistadocliente!=null) {
				if((tipoparamfactulistadoclienteAux.getId()==null && tipoparamfactulistadocliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoparamfactulistadoclienteAux.getId()!=null && tipoparamfactulistadocliente.getId()!=null){
					if(tipoparamfactulistadoclienteAux.getId().equals(tipoparamfactulistadocliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoParamFactuListadoCliente(List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoParamFactuListadoCliente tipoparamfactulistadocliente: tipoparamfactulistadoclientes) {			
			if(tipoparamfactulistadocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoParamFactuListadoCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoParamFactuListadoClienteConstantesFunciones.LABEL_ID, TipoParamFactuListadoClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoParamFactuListadoClienteConstantesFunciones.LABEL_VERSIONROW, TipoParamFactuListadoClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoParamFactuListadoClienteConstantesFunciones.LABEL_NOMBRE, TipoParamFactuListadoClienteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoParamFactuListadoCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoParamFactuListadoClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoParamFactuListadoClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoParamFactuListadoClienteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParamFactuListadoCliente() throws Exception  {
		return TipoParamFactuListadoClienteConstantesFunciones.getTiposSeleccionarTipoParamFactuListadoCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParamFactuListadoCliente(Boolean conFk) throws Exception  {
		return TipoParamFactuListadoClienteConstantesFunciones.getTiposSeleccionarTipoParamFactuListadoCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParamFactuListadoCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoParamFactuListadoClienteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoParamFactuListadoClienteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoParamFactuListadoCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(TipoParamFactuListadoCliente tipoparamfactulistadoclienteAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoParamFactuListadoCliente(List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientesTemp) throws Exception {
		for(TipoParamFactuListadoCliente tipoparamfactulistadoclienteAux:tipoparamfactulistadoclientesTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoParamFactuListadoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoParamFactuListadoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParamFactuListadoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoParamFactuListadoClienteConstantesFunciones.getClassesRelationshipsOfTipoParamFactuListadoCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParamFactuListadoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroFactuPrincipal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroFactuPrincipal.class)) {
						classes.add(new Classe(ParametroFactuPrincipal.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoParamFactuListadoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoParamFactuListadoClienteConstantesFunciones.getClassesRelationshipsFromStringsOfTipoParamFactuListadoCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoParamFactuListadoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroFactuPrincipal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFactuPrincipal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroFactuPrincipal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFactuPrincipal.class)); continue;
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
	public static void actualizarLista(TipoParamFactuListadoCliente tipoparamfactulistadocliente,List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoParamFactuListadoCliente tipoparamfactulistadoclienteEncontrado=null;
			
			for(TipoParamFactuListadoCliente tipoparamfactulistadoclienteLocal:tipoparamfactulistadoclientes) {
				if(tipoparamfactulistadoclienteLocal.getId().equals(tipoparamfactulistadocliente.getId())) {
					tipoparamfactulistadoclienteEncontrado=tipoparamfactulistadoclienteLocal;
					
					tipoparamfactulistadoclienteLocal.setIsChanged(tipoparamfactulistadocliente.getIsChanged());
					tipoparamfactulistadoclienteLocal.setIsNew(tipoparamfactulistadocliente.getIsNew());
					tipoparamfactulistadoclienteLocal.setIsDeleted(tipoparamfactulistadocliente.getIsDeleted());
					
					tipoparamfactulistadoclienteLocal.setGeneralEntityOriginal(tipoparamfactulistadocliente.getGeneralEntityOriginal());
					
					tipoparamfactulistadoclienteLocal.setId(tipoparamfactulistadocliente.getId());	
					tipoparamfactulistadoclienteLocal.setVersionRow(tipoparamfactulistadocliente.getVersionRow());	
					tipoparamfactulistadoclienteLocal.setnombre(tipoparamfactulistadocliente.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoparamfactulistadocliente.getIsDeleted()) {
				if(!existe) {
					tipoparamfactulistadoclientes.add(tipoparamfactulistadocliente);
				}
			} else {
				if(tipoparamfactulistadoclienteEncontrado!=null && permiteQuitar)  {
					tipoparamfactulistadoclientes.remove(tipoparamfactulistadoclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoParamFactuListadoCliente tipoparamfactulistadocliente,List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientes) throws Exception {
		try	{			
			for(TipoParamFactuListadoCliente tipoparamfactulistadoclienteLocal:tipoparamfactulistadoclientes) {
				if(tipoparamfactulistadoclienteLocal.getId().equals(tipoparamfactulistadocliente.getId())) {
					tipoparamfactulistadoclienteLocal.setIsSelected(tipoparamfactulistadocliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoParamFactuListadoCliente(List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientesAux) throws Exception {
		//this.tipoparamfactulistadoclientesAux=tipoparamfactulistadoclientesAux;
		
		for(TipoParamFactuListadoCliente tipoparamfactulistadoclienteAux:tipoparamfactulistadoclientesAux) {
			if(tipoparamfactulistadoclienteAux.getIsChanged()) {
				tipoparamfactulistadoclienteAux.setIsChanged(false);
			}		
			
			if(tipoparamfactulistadoclienteAux.getIsNew()) {
				tipoparamfactulistadoclienteAux.setIsNew(false);
			}	
			
			if(tipoparamfactulistadoclienteAux.getIsDeleted()) {
				tipoparamfactulistadoclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoParamFactuListadoCliente(TipoParamFactuListadoCliente tipoparamfactulistadoclienteAux) throws Exception {
		//this.tipoparamfactulistadoclienteAux=tipoparamfactulistadoclienteAux;
		
			if(tipoparamfactulistadoclienteAux.getIsChanged()) {
				tipoparamfactulistadoclienteAux.setIsChanged(false);
			}		
			
			if(tipoparamfactulistadoclienteAux.getIsNew()) {
				tipoparamfactulistadoclienteAux.setIsNew(false);
			}	
			
			if(tipoparamfactulistadoclienteAux.getIsDeleted()) {
				tipoparamfactulistadoclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoParamFactuListadoCliente tipoparamfactulistadoclienteAsignar,TipoParamFactuListadoCliente tipoparamfactulistadocliente) throws Exception {
		tipoparamfactulistadoclienteAsignar.setId(tipoparamfactulistadocliente.getId());	
		tipoparamfactulistadoclienteAsignar.setVersionRow(tipoparamfactulistadocliente.getVersionRow());	
		tipoparamfactulistadoclienteAsignar.setnombre(tipoparamfactulistadocliente.getnombre());	
	}
	
	public static void inicializarTipoParamFactuListadoCliente(TipoParamFactuListadoCliente tipoparamfactulistadocliente) throws Exception {
		try {
				tipoparamfactulistadocliente.setId(0L);	
					
				tipoparamfactulistadocliente.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoParamFactuListadoCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoParamFactuListadoClienteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoParamFactuListadoCliente(String sTipo,Row row,Workbook workbook,TipoParamFactuListadoCliente tipoparamfactulistadocliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoparamfactulistadocliente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoParamFactuListadoCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoParamFactuListadoCliente() {
		return this.sFinalQueryTipoParamFactuListadoCliente;
	}
	
	public void setsFinalQueryTipoParamFactuListadoCliente(String sFinalQueryTipoParamFactuListadoCliente) {
		this.sFinalQueryTipoParamFactuListadoCliente= sFinalQueryTipoParamFactuListadoCliente;
	}
	
	public Border resaltarSeleccionarTipoParamFactuListadoCliente=null;
	
	public Border setResaltarSeleccionarTipoParamFactuListadoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParamFactuListadoClienteBeanSwingJInternalFrame tipoparamfactulistadoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoparamfactulistadoclienteBeanSwingJInternalFrame.jTtoolBarTipoParamFactuListadoCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoParamFactuListadoCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoParamFactuListadoCliente() {
		return this.resaltarSeleccionarTipoParamFactuListadoCliente;
	}
	
	public void setResaltarSeleccionarTipoParamFactuListadoCliente(Border borderResaltarSeleccionarTipoParamFactuListadoCliente) {
		this.resaltarSeleccionarTipoParamFactuListadoCliente= borderResaltarSeleccionarTipoParamFactuListadoCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoParamFactuListadoCliente=null;
	public Boolean mostraridTipoParamFactuListadoCliente=true;
	public Boolean activaridTipoParamFactuListadoCliente=true;

	public Border resaltarnombreTipoParamFactuListadoCliente=null;
	public Boolean mostrarnombreTipoParamFactuListadoCliente=true;
	public Boolean activarnombreTipoParamFactuListadoCliente=true;

	
	

	public Border setResaltaridTipoParamFactuListadoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParamFactuListadoClienteBeanSwingJInternalFrame tipoparamfactulistadoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoparamfactulistadoclienteBeanSwingJInternalFrame.jTtoolBarTipoParamFactuListadoCliente.setBorder(borderResaltar);
		
		this.resaltaridTipoParamFactuListadoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoParamFactuListadoCliente() {
		return this.resaltaridTipoParamFactuListadoCliente;
	}

	public void setResaltaridTipoParamFactuListadoCliente(Border borderResaltar) {
		this.resaltaridTipoParamFactuListadoCliente= borderResaltar;
	}

	public Boolean getMostraridTipoParamFactuListadoCliente() {
		return this.mostraridTipoParamFactuListadoCliente;
	}

	public void setMostraridTipoParamFactuListadoCliente(Boolean mostraridTipoParamFactuListadoCliente) {
		this.mostraridTipoParamFactuListadoCliente= mostraridTipoParamFactuListadoCliente;
	}

	public Boolean getActivaridTipoParamFactuListadoCliente() {
		return this.activaridTipoParamFactuListadoCliente;
	}

	public void setActivaridTipoParamFactuListadoCliente(Boolean activaridTipoParamFactuListadoCliente) {
		this.activaridTipoParamFactuListadoCliente= activaridTipoParamFactuListadoCliente;
	}

	public Border setResaltarnombreTipoParamFactuListadoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParamFactuListadoClienteBeanSwingJInternalFrame tipoparamfactulistadoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoparamfactulistadoclienteBeanSwingJInternalFrame.jTtoolBarTipoParamFactuListadoCliente.setBorder(borderResaltar);
		
		this.resaltarnombreTipoParamFactuListadoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoParamFactuListadoCliente() {
		return this.resaltarnombreTipoParamFactuListadoCliente;
	}

	public void setResaltarnombreTipoParamFactuListadoCliente(Border borderResaltar) {
		this.resaltarnombreTipoParamFactuListadoCliente= borderResaltar;
	}

	public Boolean getMostrarnombreTipoParamFactuListadoCliente() {
		return this.mostrarnombreTipoParamFactuListadoCliente;
	}

	public void setMostrarnombreTipoParamFactuListadoCliente(Boolean mostrarnombreTipoParamFactuListadoCliente) {
		this.mostrarnombreTipoParamFactuListadoCliente= mostrarnombreTipoParamFactuListadoCliente;
	}

	public Boolean getActivarnombreTipoParamFactuListadoCliente() {
		return this.activarnombreTipoParamFactuListadoCliente;
	}

	public void setActivarnombreTipoParamFactuListadoCliente(Boolean activarnombreTipoParamFactuListadoCliente) {
		this.activarnombreTipoParamFactuListadoCliente= activarnombreTipoParamFactuListadoCliente;
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
		
		
		this.setMostraridTipoParamFactuListadoCliente(esInicial);
		this.setMostrarnombreTipoParamFactuListadoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParamFactuListadoClienteConstantesFunciones.ID)) {
				this.setMostraridTipoParamFactuListadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParamFactuListadoClienteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoParamFactuListadoCliente(esAsigna);
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
		
		
		this.setActivaridTipoParamFactuListadoCliente(esInicial);
		this.setActivarnombreTipoParamFactuListadoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParamFactuListadoClienteConstantesFunciones.ID)) {
				this.setActivaridTipoParamFactuListadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParamFactuListadoClienteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoParamFactuListadoCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoParamFactuListadoClienteBeanSwingJInternalFrame tipoparamfactulistadoclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoParamFactuListadoCliente(esInicial);
		this.setResaltarnombreTipoParamFactuListadoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParamFactuListadoClienteConstantesFunciones.ID)) {
				this.setResaltaridTipoParamFactuListadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParamFactuListadoClienteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoParamFactuListadoCliente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoParamFactuListadoClienteBeanSwingJInternalFrame tipoparamfactulistadoclienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreTipoParamFactuListadoCliente=true;

	public Boolean getMostrarBusquedaPorNombreTipoParamFactuListadoCliente() {
		return this.mostrarBusquedaPorNombreTipoParamFactuListadoCliente;
	}

	public void setMostrarBusquedaPorNombreTipoParamFactuListadoCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoParamFactuListadoCliente= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTipoParamFactuListadoCliente=true;

	public Boolean getActivarBusquedaPorNombreTipoParamFactuListadoCliente() {
		return this.activarBusquedaPorNombreTipoParamFactuListadoCliente;
	}

	public void setActivarBusquedaPorNombreTipoParamFactuListadoCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoParamFactuListadoCliente= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTipoParamFactuListadoCliente=null;

	public Border getResaltarBusquedaPorNombreTipoParamFactuListadoCliente() {
		return this.resaltarBusquedaPorNombreTipoParamFactuListadoCliente;
	}

	public void setResaltarBusquedaPorNombreTipoParamFactuListadoCliente(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoParamFactuListadoCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoParamFactuListadoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParamFactuListadoClienteBeanSwingJInternalFrame tipoparamfactulistadoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoParamFactuListadoCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}