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


import com.bydan.erp.cartera.util.EstadoClienteConstantesFunciones;
import com.bydan.erp.cartera.util.EstadoClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.EstadoClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoClienteConstantesFunciones extends EstadoClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoCliente"+EstadoClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoClienteConstantesFunciones.SCHEMA+"_"+EstadoClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoClienteConstantesFunciones.SCHEMA+"_"+EstadoClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoClienteConstantesFunciones.SCHEMA+"_"+EstadoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoClienteConstantesFunciones.SCHEMA+"_"+EstadoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Estado Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoCliente";
	public static final String OBJECTNAME="estadocliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="estado_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadocliente from "+EstadoClienteConstantesFunciones.SPERSISTENCENAME+" estadocliente";
	public static String QUERYSELECTNATIVE="select "+EstadoClienteConstantesFunciones.SCHEMA+"."+EstadoClienteConstantesFunciones.TABLENAME+".id,"+EstadoClienteConstantesFunciones.SCHEMA+"."+EstadoClienteConstantesFunciones.TABLENAME+".version_row,"+EstadoClienteConstantesFunciones.SCHEMA+"."+EstadoClienteConstantesFunciones.TABLENAME+".codigo,"+EstadoClienteConstantesFunciones.SCHEMA+"."+EstadoClienteConstantesFunciones.TABLENAME+".nombre,"+EstadoClienteConstantesFunciones.SCHEMA+"."+EstadoClienteConstantesFunciones.TABLENAME+".es_defecto from "+EstadoClienteConstantesFunciones.SCHEMA+"."+EstadoClienteConstantesFunciones.TABLENAME;//+" as "+EstadoClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoClienteConstantesFuncionesAdditional estadoclienteConstantesFuncionesAdditional=null;
	
	public EstadoClienteConstantesFuncionesAdditional getEstadoClienteConstantesFuncionesAdditional() {
		return this.estadoclienteConstantesFuncionesAdditional;
	}
	
	public void setEstadoClienteConstantesFuncionesAdditional(EstadoClienteConstantesFuncionesAdditional estadoclienteConstantesFuncionesAdditional) {
		try {
			this.estadoclienteConstantesFuncionesAdditional=estadoclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String ESDEFECTO= "es_defecto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_ESDEFECTO= "Es Defecto";
		public static final String LABEL_ESDEFECTO_LOWER= "Es Defecto";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getEstadoClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoClienteConstantesFunciones.CODIGO)) {sLabelColumna=EstadoClienteConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoClienteConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoClienteConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(EstadoClienteConstantesFunciones.ESDEFECTO)) {sLabelColumna=EstadoClienteConstantesFunciones.LABEL_ESDEFECTO;}
		
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
	
	
	
			
			
			
			
		
	public static String getes_defectoDescripcion(EstadoCliente estadocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!estadocliente.getes_defecto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_defectoHtmlDescripcion(EstadoCliente estadocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(estadocliente.getId(),estadocliente.getes_defecto());

		return sDescripcion;
	}	
	
	public static String getEstadoClienteDescripcion(EstadoCliente estadocliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadocliente !=null/* && estadocliente.getId()!=0*/) {
			sDescripcion=estadocliente.getcodigo();//estadoclienteestadocliente.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoClienteDescripcionDetallado(EstadoCliente estadocliente) {
		String sDescripcion="";
			
		sDescripcion+=EstadoClienteConstantesFunciones.ID+"=";
		sDescripcion+=estadocliente.getId().toString()+",";
		sDescripcion+=EstadoClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadocliente.getVersionRow().toString()+",";
		sDescripcion+=EstadoClienteConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadocliente.getcodigo()+",";
		sDescripcion+=EstadoClienteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadocliente.getnombre()+",";
		sDescripcion+=EstadoClienteConstantesFunciones.ESDEFECTO+"=";
		sDescripcion+=estadocliente.getes_defecto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoClienteDescripcion(EstadoCliente estadocliente,String sValor) throws Exception {			
		if(estadocliente !=null) {
			estadocliente.setcodigo(sValor);;//estadoclienteestadocliente.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoCliente(EstadoCliente estadocliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadocliente.setcodigo(estadocliente.getcodigo().trim());
		estadocliente.setnombre(estadocliente.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoClientes(List<EstadoCliente> estadoclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoCliente estadocliente: estadoclientes) {
			estadocliente.setcodigo(estadocliente.getcodigo().trim());
			estadocliente.setnombre(estadocliente.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoCliente(EstadoCliente estadocliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadocliente.getConCambioAuxiliar()) {
			estadocliente.setIsDeleted(estadocliente.getIsDeletedAuxiliar());	
			estadocliente.setIsNew(estadocliente.getIsNewAuxiliar());	
			estadocliente.setIsChanged(estadocliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadocliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadocliente.setIsDeletedAuxiliar(false);	
			estadocliente.setIsNewAuxiliar(false);	
			estadocliente.setIsChangedAuxiliar(false);
			
			estadocliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoClientes(List<EstadoCliente> estadoclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoCliente estadocliente : estadoclientes) {
			if(conAsignarBase && estadocliente.getConCambioAuxiliar()) {
				estadocliente.setIsDeleted(estadocliente.getIsDeletedAuxiliar());	
				estadocliente.setIsNew(estadocliente.getIsNewAuxiliar());	
				estadocliente.setIsChanged(estadocliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadocliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadocliente.setIsDeletedAuxiliar(false);	
				estadocliente.setIsNewAuxiliar(false);	
				estadocliente.setIsChangedAuxiliar(false);
				
				estadocliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoCliente(EstadoCliente estadocliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoClientes(List<EstadoCliente> estadoclientes,Boolean conEnteros) throws Exception  {
		
		for(EstadoCliente estadocliente: estadoclientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoCliente(List<EstadoCliente> estadoclientes,EstadoCliente estadoclienteAux) throws Exception  {
		EstadoClienteConstantesFunciones.InicializarValoresEstadoCliente(estadoclienteAux,true);
		
		for(EstadoCliente estadocliente: estadoclientes) {
			if(estadocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoClienteConstantesFunciones.getArrayColumnasGlobalesEstadoCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoCliente> estadoclientes,EstadoCliente estadocliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoCliente estadoclienteAux: estadoclientes) {
			if(estadoclienteAux!=null && estadocliente!=null) {
				if((estadoclienteAux.getId()==null && estadocliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadoclienteAux.getId()!=null && estadocliente.getId()!=null){
					if(estadoclienteAux.getId().equals(estadocliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoCliente(List<EstadoCliente> estadoclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoCliente estadocliente: estadoclientes) {			
			if(estadocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoClienteConstantesFunciones.LABEL_ID, EstadoClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoClienteConstantesFunciones.LABEL_VERSIONROW, EstadoClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoClienteConstantesFunciones.LABEL_CODIGO, EstadoClienteConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoClienteConstantesFunciones.LABEL_NOMBRE, EstadoClienteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoClienteConstantesFunciones.LABEL_ESDEFECTO, EstadoClienteConstantesFunciones.ESDEFECTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoClienteConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoClienteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoClienteConstantesFunciones.ESDEFECTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoCliente() throws Exception  {
		return EstadoClienteConstantesFunciones.getTiposSeleccionarEstadoCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoCliente(Boolean conFk) throws Exception  {
		return EstadoClienteConstantesFunciones.getTiposSeleccionarEstadoCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoClienteConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoClienteConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoClienteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoClienteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoClienteConstantesFunciones.LABEL_ESDEFECTO);
			reporte.setsDescripcion(EstadoClienteConstantesFunciones.LABEL_ESDEFECTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoCliente(EstadoCliente estadoclienteAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoCliente(List<EstadoCliente> estadoclientesTemp) throws Exception {
		for(EstadoCliente estadoclienteAux:estadoclientesTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoClienteConstantesFunciones.getClassesRelationshipsOfEstadoCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoClienteConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	public static void actualizarLista(EstadoCliente estadocliente,List<EstadoCliente> estadoclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoCliente estadoclienteEncontrado=null;
			
			for(EstadoCliente estadoclienteLocal:estadoclientes) {
				if(estadoclienteLocal.getId().equals(estadocliente.getId())) {
					estadoclienteEncontrado=estadoclienteLocal;
					
					estadoclienteLocal.setIsChanged(estadocliente.getIsChanged());
					estadoclienteLocal.setIsNew(estadocliente.getIsNew());
					estadoclienteLocal.setIsDeleted(estadocliente.getIsDeleted());
					
					estadoclienteLocal.setGeneralEntityOriginal(estadocliente.getGeneralEntityOriginal());
					
					estadoclienteLocal.setId(estadocliente.getId());	
					estadoclienteLocal.setVersionRow(estadocliente.getVersionRow());	
					estadoclienteLocal.setcodigo(estadocliente.getcodigo());	
					estadoclienteLocal.setnombre(estadocliente.getnombre());	
					estadoclienteLocal.setes_defecto(estadocliente.getes_defecto());	
					
					
					estadoclienteLocal.setClientes(estadocliente.getClientes());
					
					existe=true;
					break;
				}
			}
			
			if(!estadocliente.getIsDeleted()) {
				if(!existe) {
					estadoclientes.add(estadocliente);
				}
			} else {
				if(estadoclienteEncontrado!=null && permiteQuitar)  {
					estadoclientes.remove(estadoclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoCliente estadocliente,List<EstadoCliente> estadoclientes) throws Exception {
		try	{			
			for(EstadoCliente estadoclienteLocal:estadoclientes) {
				if(estadoclienteLocal.getId().equals(estadocliente.getId())) {
					estadoclienteLocal.setIsSelected(estadocliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoCliente(List<EstadoCliente> estadoclientesAux) throws Exception {
		//this.estadoclientesAux=estadoclientesAux;
		
		for(EstadoCliente estadoclienteAux:estadoclientesAux) {
			if(estadoclienteAux.getIsChanged()) {
				estadoclienteAux.setIsChanged(false);
			}		
			
			if(estadoclienteAux.getIsNew()) {
				estadoclienteAux.setIsNew(false);
			}	
			
			if(estadoclienteAux.getIsDeleted()) {
				estadoclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoCliente(EstadoCliente estadoclienteAux) throws Exception {
		//this.estadoclienteAux=estadoclienteAux;
		
			if(estadoclienteAux.getIsChanged()) {
				estadoclienteAux.setIsChanged(false);
			}		
			
			if(estadoclienteAux.getIsNew()) {
				estadoclienteAux.setIsNew(false);
			}	
			
			if(estadoclienteAux.getIsDeleted()) {
				estadoclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoCliente estadoclienteAsignar,EstadoCliente estadocliente) throws Exception {
		estadoclienteAsignar.setId(estadocliente.getId());	
		estadoclienteAsignar.setVersionRow(estadocliente.getVersionRow());	
		estadoclienteAsignar.setcodigo(estadocliente.getcodigo());	
		estadoclienteAsignar.setnombre(estadocliente.getnombre());	
		estadoclienteAsignar.setes_defecto(estadocliente.getes_defecto());	
	}
	
	public static void inicializarEstadoCliente(EstadoCliente estadocliente) throws Exception {
		try {
				estadocliente.setId(0L);	
					
				estadocliente.setcodigo("");	
				estadocliente.setnombre("");	
				estadocliente.setes_defecto(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoClienteConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoClienteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoClienteConstantesFunciones.LABEL_ESDEFECTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoCliente(String sTipo,Row row,Workbook workbook,EstadoCliente estadocliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadocliente.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadocliente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(estadocliente.getes_defecto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoCliente() {
		return this.sFinalQueryEstadoCliente;
	}
	
	public void setsFinalQueryEstadoCliente(String sFinalQueryEstadoCliente) {
		this.sFinalQueryEstadoCliente= sFinalQueryEstadoCliente;
	}
	
	public Border resaltarSeleccionarEstadoCliente=null;
	
	public Border setResaltarSeleccionarEstadoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoClienteBeanSwingJInternalFrame estadoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadoclienteBeanSwingJInternalFrame.jTtoolBarEstadoCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoCliente() {
		return this.resaltarSeleccionarEstadoCliente;
	}
	
	public void setResaltarSeleccionarEstadoCliente(Border borderResaltarSeleccionarEstadoCliente) {
		this.resaltarSeleccionarEstadoCliente= borderResaltarSeleccionarEstadoCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoCliente=null;
	public Boolean mostraridEstadoCliente=true;
	public Boolean activaridEstadoCliente=true;

	public Border resaltarcodigoEstadoCliente=null;
	public Boolean mostrarcodigoEstadoCliente=true;
	public Boolean activarcodigoEstadoCliente=true;

	public Border resaltarnombreEstadoCliente=null;
	public Boolean mostrarnombreEstadoCliente=true;
	public Boolean activarnombreEstadoCliente=true;

	public Border resaltares_defectoEstadoCliente=null;
	public Boolean mostrares_defectoEstadoCliente=true;
	public Boolean activares_defectoEstadoCliente=true;

	
	

	public Border setResaltaridEstadoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoClienteBeanSwingJInternalFrame estadoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoclienteBeanSwingJInternalFrame.jTtoolBarEstadoCliente.setBorder(borderResaltar);
		
		this.resaltaridEstadoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoCliente() {
		return this.resaltaridEstadoCliente;
	}

	public void setResaltaridEstadoCliente(Border borderResaltar) {
		this.resaltaridEstadoCliente= borderResaltar;
	}

	public Boolean getMostraridEstadoCliente() {
		return this.mostraridEstadoCliente;
	}

	public void setMostraridEstadoCliente(Boolean mostraridEstadoCliente) {
		this.mostraridEstadoCliente= mostraridEstadoCliente;
	}

	public Boolean getActivaridEstadoCliente() {
		return this.activaridEstadoCliente;
	}

	public void setActivaridEstadoCliente(Boolean activaridEstadoCliente) {
		this.activaridEstadoCliente= activaridEstadoCliente;
	}

	public Border setResaltarcodigoEstadoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoClienteBeanSwingJInternalFrame estadoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoclienteBeanSwingJInternalFrame.jTtoolBarEstadoCliente.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoCliente() {
		return this.resaltarcodigoEstadoCliente;
	}

	public void setResaltarcodigoEstadoCliente(Border borderResaltar) {
		this.resaltarcodigoEstadoCliente= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoCliente() {
		return this.mostrarcodigoEstadoCliente;
	}

	public void setMostrarcodigoEstadoCliente(Boolean mostrarcodigoEstadoCliente) {
		this.mostrarcodigoEstadoCliente= mostrarcodigoEstadoCliente;
	}

	public Boolean getActivarcodigoEstadoCliente() {
		return this.activarcodigoEstadoCliente;
	}

	public void setActivarcodigoEstadoCliente(Boolean activarcodigoEstadoCliente) {
		this.activarcodigoEstadoCliente= activarcodigoEstadoCliente;
	}

	public Border setResaltarnombreEstadoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoClienteBeanSwingJInternalFrame estadoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoclienteBeanSwingJInternalFrame.jTtoolBarEstadoCliente.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoCliente() {
		return this.resaltarnombreEstadoCliente;
	}

	public void setResaltarnombreEstadoCliente(Border borderResaltar) {
		this.resaltarnombreEstadoCliente= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoCliente() {
		return this.mostrarnombreEstadoCliente;
	}

	public void setMostrarnombreEstadoCliente(Boolean mostrarnombreEstadoCliente) {
		this.mostrarnombreEstadoCliente= mostrarnombreEstadoCliente;
	}

	public Boolean getActivarnombreEstadoCliente() {
		return this.activarnombreEstadoCliente;
	}

	public void setActivarnombreEstadoCliente(Boolean activarnombreEstadoCliente) {
		this.activarnombreEstadoCliente= activarnombreEstadoCliente;
	}

	public Border setResaltares_defectoEstadoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoClienteBeanSwingJInternalFrame estadoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadoclienteBeanSwingJInternalFrame.jTtoolBarEstadoCliente.setBorder(borderResaltar);
		
		this.resaltares_defectoEstadoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_defectoEstadoCliente() {
		return this.resaltares_defectoEstadoCliente;
	}

	public void setResaltares_defectoEstadoCliente(Border borderResaltar) {
		this.resaltares_defectoEstadoCliente= borderResaltar;
	}

	public Boolean getMostrares_defectoEstadoCliente() {
		return this.mostrares_defectoEstadoCliente;
	}

	public void setMostrares_defectoEstadoCliente(Boolean mostrares_defectoEstadoCliente) {
		this.mostrares_defectoEstadoCliente= mostrares_defectoEstadoCliente;
	}

	public Boolean getActivares_defectoEstadoCliente() {
		return this.activares_defectoEstadoCliente;
	}

	public void setActivares_defectoEstadoCliente(Boolean activares_defectoEstadoCliente) {
		this.activares_defectoEstadoCliente= activares_defectoEstadoCliente;
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
		
		
		this.setMostraridEstadoCliente(esInicial);
		this.setMostrarcodigoEstadoCliente(esInicial);
		this.setMostrarnombreEstadoCliente(esInicial);
		this.setMostrares_defectoEstadoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoClienteConstantesFunciones.ID)) {
				this.setMostraridEstadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoClienteConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoClienteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoClienteConstantesFunciones.ESDEFECTO)) {
				this.setMostrares_defectoEstadoCliente(esAsigna);
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
		
		
		this.setActivaridEstadoCliente(esInicial);
		this.setActivarcodigoEstadoCliente(esInicial);
		this.setActivarnombreEstadoCliente(esInicial);
		this.setActivares_defectoEstadoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoClienteConstantesFunciones.ID)) {
				this.setActivaridEstadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoClienteConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoClienteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoClienteConstantesFunciones.ESDEFECTO)) {
				this.setActivares_defectoEstadoCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoClienteBeanSwingJInternalFrame estadoclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoCliente(esInicial);
		this.setResaltarcodigoEstadoCliente(esInicial);
		this.setResaltarnombreEstadoCliente(esInicial);
		this.setResaltares_defectoEstadoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoClienteConstantesFunciones.ID)) {
				this.setResaltaridEstadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoClienteConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoClienteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoClienteConstantesFunciones.ESDEFECTO)) {
				this.setResaltares_defectoEstadoCliente(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarClienteEstadoCliente=null;

	public Border getResaltarClienteEstadoCliente() {
		return this.resaltarClienteEstadoCliente;
	}

	public void setResaltarClienteEstadoCliente(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteEstadoCliente= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteEstadoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoClienteBeanSwingJInternalFrame estadoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadoclienteBeanSwingJInternalFrame.jTtoolBarEstadoCliente.setBorder(borderResaltarCliente);
			
		this.resaltarClienteEstadoCliente= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteEstadoCliente=true;

	public Boolean getMostrarClienteEstadoCliente() {
		return this.mostrarClienteEstadoCliente;
	}

	public void setMostrarClienteEstadoCliente(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteEstadoCliente= visibilidadResaltarCliente;
	}



	public Boolean activarClienteEstadoCliente=true;

	public Boolean gethabilitarResaltarClienteEstadoCliente() {
		return this.activarClienteEstadoCliente;
	}

	public void setActivarClienteEstadoCliente(Boolean habilitarResaltarCliente) {
		this.activarClienteEstadoCliente= habilitarResaltarCliente;
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

		this.setMostrarClienteEstadoCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteEstadoCliente(esAsigna);
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

		this.setActivarClienteEstadoCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteEstadoCliente(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoClienteBeanSwingJInternalFrame estadoclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarClienteEstadoCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteEstadoCliente(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}