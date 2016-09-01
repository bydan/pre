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


import com.bydan.erp.cartera.util.ClienteArchivoConstantesFunciones;
import com.bydan.erp.cartera.util.ClienteArchivoParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ClienteArchivoParameterGeneral;

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
final public class ClienteArchivoConstantesFunciones extends ClienteArchivoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ClienteArchivo";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ClienteArchivo"+ClienteArchivoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ClienteArchivoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ClienteArchivoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ClienteArchivoConstantesFunciones.SCHEMA+"_"+ClienteArchivoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ClienteArchivoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ClienteArchivoConstantesFunciones.SCHEMA+"_"+ClienteArchivoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ClienteArchivoConstantesFunciones.SCHEMA+"_"+ClienteArchivoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ClienteArchivoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ClienteArchivoConstantesFunciones.SCHEMA+"_"+ClienteArchivoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteArchivoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ClienteArchivoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteArchivoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteArchivoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ClienteArchivoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteArchivoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ClienteArchivoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ClienteArchivoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ClienteArchivoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ClienteArchivoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cliente Archivos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Cliente Archivo";
	public static final String SCLASSWEBTITULO_LOWER="Cliente Archivo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ClienteArchivo";
	public static final String OBJECTNAME="clientearchivo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cliente_archivo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select clientearchivo from "+ClienteArchivoConstantesFunciones.SPERSISTENCENAME+" clientearchivo";
	public static String QUERYSELECTNATIVE="select "+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+".id,"+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+".version_row,"+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+".id_cliente,"+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+".id_tipo_archivo,"+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+".nombre,"+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+".archivo,"+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+".descripcion from "+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME;//+" as "+ClienteArchivoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ClienteArchivoConstantesFuncionesAdditional clientearchivoConstantesFuncionesAdditional=null;
	
	public ClienteArchivoConstantesFuncionesAdditional getClienteArchivoConstantesFuncionesAdditional() {
		return this.clientearchivoConstantesFuncionesAdditional;
	}
	
	public void setClienteArchivoConstantesFuncionesAdditional(ClienteArchivoConstantesFuncionesAdditional clientearchivoConstantesFuncionesAdditional) {
		try {
			this.clientearchivoConstantesFuncionesAdditional=clientearchivoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDTIPOARCHIVO= "id_tipo_archivo";
    public static final String NOMBRE= "nombre";
    public static final String ARCHIVO= "archivo";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPOARCHIVO= "Tipo Archivo";
		public static final String LABEL_IDTIPOARCHIVO_LOWER= "Tipo Archivo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_ARCHIVO= "Archivo";
		public static final String LABEL_ARCHIVO_LOWER= "Archivo";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getClienteArchivoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ClienteArchivoConstantesFunciones.IDCLIENTE)) {sLabelColumna=ClienteArchivoConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ClienteArchivoConstantesFunciones.IDTIPOARCHIVO)) {sLabelColumna=ClienteArchivoConstantesFunciones.LABEL_IDTIPOARCHIVO;}
		if(sNombreColumna.equals(ClienteArchivoConstantesFunciones.NOMBRE)) {sLabelColumna=ClienteArchivoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ClienteArchivoConstantesFunciones.ARCHIVO)) {sLabelColumna=ClienteArchivoConstantesFunciones.LABEL_ARCHIVO;}
		if(sNombreColumna.equals(ClienteArchivoConstantesFunciones.DESCRIPCION)) {sLabelColumna=ClienteArchivoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getClienteArchivoDescripcion(ClienteArchivo clientearchivo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(clientearchivo !=null/* && clientearchivo.getId()!=0*/) {
			sDescripcion=clientearchivo.getnombre();//clientearchivoclientearchivo.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getClienteArchivoDescripcionDetallado(ClienteArchivo clientearchivo) {
		String sDescripcion="";
			
		sDescripcion+=ClienteArchivoConstantesFunciones.ID+"=";
		sDescripcion+=clientearchivo.getId().toString()+",";
		sDescripcion+=ClienteArchivoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=clientearchivo.getVersionRow().toString()+",";
		sDescripcion+=ClienteArchivoConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=clientearchivo.getid_cliente().toString()+",";
		sDescripcion+=ClienteArchivoConstantesFunciones.IDTIPOARCHIVO+"=";
		sDescripcion+=clientearchivo.getid_tipo_archivo().toString()+",";
		sDescripcion+=ClienteArchivoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=clientearchivo.getnombre()+",";
		sDescripcion+=ClienteArchivoConstantesFunciones.ARCHIVO+"=";
		sDescripcion+=clientearchivo.getarchivo().toString()+",";
		sDescripcion+=ClienteArchivoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=clientearchivo.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setClienteArchivoDescripcion(ClienteArchivo clientearchivo,String sValor) throws Exception {			
		if(clientearchivo !=null) {
			clientearchivo.setnombre(sValor);;//clientearchivoclientearchivo.getnombre().trim();
		}		
	}
	
		

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTipoArchivoDescripcion(TipoArchivo tipoarchivo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoarchivo!=null/*&&tipoarchivo.getId()>0*/) {
			sDescripcion=TipoArchivoConstantesFunciones.getTipoArchivoDescripcion(tipoarchivo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdTipoArchivo")) {
			sNombreIndice="Tipo=  Por Tipo Archivo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoArchivo(Long id_tipo_archivo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_archivo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Archivo="+id_tipo_archivo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosClienteArchivo(ClienteArchivo clientearchivo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		clientearchivo.setnombre(clientearchivo.getnombre().trim());
		clientearchivo.setdescripcion(clientearchivo.getdescripcion().trim());
	}
	
	public static void quitarEspaciosClienteArchivos(List<ClienteArchivo> clientearchivos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ClienteArchivo clientearchivo: clientearchivos) {
			clientearchivo.setnombre(clientearchivo.getnombre().trim());
			clientearchivo.setdescripcion(clientearchivo.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresClienteArchivo(ClienteArchivo clientearchivo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && clientearchivo.getConCambioAuxiliar()) {
			clientearchivo.setIsDeleted(clientearchivo.getIsDeletedAuxiliar());	
			clientearchivo.setIsNew(clientearchivo.getIsNewAuxiliar());	
			clientearchivo.setIsChanged(clientearchivo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			clientearchivo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			clientearchivo.setIsDeletedAuxiliar(false);	
			clientearchivo.setIsNewAuxiliar(false);	
			clientearchivo.setIsChangedAuxiliar(false);
			
			clientearchivo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresClienteArchivos(List<ClienteArchivo> clientearchivos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ClienteArchivo clientearchivo : clientearchivos) {
			if(conAsignarBase && clientearchivo.getConCambioAuxiliar()) {
				clientearchivo.setIsDeleted(clientearchivo.getIsDeletedAuxiliar());	
				clientearchivo.setIsNew(clientearchivo.getIsNewAuxiliar());	
				clientearchivo.setIsChanged(clientearchivo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				clientearchivo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				clientearchivo.setIsDeletedAuxiliar(false);	
				clientearchivo.setIsNewAuxiliar(false);	
				clientearchivo.setIsChangedAuxiliar(false);
				
				clientearchivo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresClienteArchivo(ClienteArchivo clientearchivo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresClienteArchivos(List<ClienteArchivo> clientearchivos,Boolean conEnteros) throws Exception  {
		
		for(ClienteArchivo clientearchivo: clientearchivos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaClienteArchivo(List<ClienteArchivo> clientearchivos,ClienteArchivo clientearchivoAux) throws Exception  {
		ClienteArchivoConstantesFunciones.InicializarValoresClienteArchivo(clientearchivoAux,true);
		
		for(ClienteArchivo clientearchivo: clientearchivos) {
			if(clientearchivo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesClienteArchivo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ClienteArchivoConstantesFunciones.getArrayColumnasGlobalesClienteArchivo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesClienteArchivo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoClienteArchivo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ClienteArchivo> clientearchivos,ClienteArchivo clientearchivo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ClienteArchivo clientearchivoAux: clientearchivos) {
			if(clientearchivoAux!=null && clientearchivo!=null) {
				if((clientearchivoAux.getId()==null && clientearchivo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(clientearchivoAux.getId()!=null && clientearchivo.getId()!=null){
					if(clientearchivoAux.getId().equals(clientearchivo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaClienteArchivo(List<ClienteArchivo> clientearchivos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ClienteArchivo clientearchivo: clientearchivos) {			
			if(clientearchivo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaClienteArchivo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ClienteArchivoConstantesFunciones.LABEL_ID, ClienteArchivoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteArchivoConstantesFunciones.LABEL_VERSIONROW, ClienteArchivoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteArchivoConstantesFunciones.LABEL_IDCLIENTE, ClienteArchivoConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteArchivoConstantesFunciones.LABEL_IDTIPOARCHIVO, ClienteArchivoConstantesFunciones.IDTIPOARCHIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteArchivoConstantesFunciones.LABEL_NOMBRE, ClienteArchivoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteArchivoConstantesFunciones.LABEL_ARCHIVO, ClienteArchivoConstantesFunciones.ARCHIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteArchivoConstantesFunciones.LABEL_DESCRIPCION, ClienteArchivoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasClienteArchivo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ClienteArchivoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteArchivoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteArchivoConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteArchivoConstantesFunciones.IDTIPOARCHIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteArchivoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteArchivoConstantesFunciones.ARCHIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteArchivoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClienteArchivo() throws Exception  {
		return ClienteArchivoConstantesFunciones.getTiposSeleccionarClienteArchivo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClienteArchivo(Boolean conFk) throws Exception  {
		return ClienteArchivoConstantesFunciones.getTiposSeleccionarClienteArchivo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClienteArchivo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteArchivoConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ClienteArchivoConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteArchivoConstantesFunciones.LABEL_IDTIPOARCHIVO);
			reporte.setsDescripcion(ClienteArchivoConstantesFunciones.LABEL_IDTIPOARCHIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteArchivoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ClienteArchivoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(ClienteArchivoConstantesFunciones.LABEL_ARCHIVO);
		reporte.setsDescripcion(ClienteArchivoConstantesFunciones.LABEL_ARCHIVO);

		arrTiposSeleccionarTodos.add(reporte);
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteArchivoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ClienteArchivoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesClienteArchivo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesClienteArchivo(ClienteArchivo clientearchivoAux) throws Exception {
		
			clientearchivoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(clientearchivoAux.getCliente()));
			clientearchivoAux.settipoarchivo_descripcion(TipoArchivoConstantesFunciones.getTipoArchivoDescripcion(clientearchivoAux.getTipoArchivo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesClienteArchivo(List<ClienteArchivo> clientearchivosTemp) throws Exception {
		for(ClienteArchivo clientearchivoAux:clientearchivosTemp) {
			
			clientearchivoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(clientearchivoAux.getCliente()));
			clientearchivoAux.settipoarchivo_descripcion(TipoArchivoConstantesFunciones.getTipoArchivoDescripcion(clientearchivoAux.getTipoArchivo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfClienteArchivo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoArchivo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoArchivo.class)) {
						classes.add(new Classe(TipoArchivo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfClienteArchivo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoArchivo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoArchivo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoArchivo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoArchivo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfClienteArchivo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ClienteArchivoConstantesFunciones.getClassesRelationshipsOfClienteArchivo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfClienteArchivo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfClienteArchivo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ClienteArchivoConstantesFunciones.getClassesRelationshipsFromStringsOfClienteArchivo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfClienteArchivo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ClienteArchivo clientearchivo,List<ClienteArchivo> clientearchivos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ClienteArchivo clientearchivoEncontrado=null;
			
			for(ClienteArchivo clientearchivoLocal:clientearchivos) {
				if(clientearchivoLocal.getId().equals(clientearchivo.getId())) {
					clientearchivoEncontrado=clientearchivoLocal;
					
					clientearchivoLocal.setIsChanged(clientearchivo.getIsChanged());
					clientearchivoLocal.setIsNew(clientearchivo.getIsNew());
					clientearchivoLocal.setIsDeleted(clientearchivo.getIsDeleted());
					
					clientearchivoLocal.setGeneralEntityOriginal(clientearchivo.getGeneralEntityOriginal());
					
					clientearchivoLocal.setId(clientearchivo.getId());	
					clientearchivoLocal.setVersionRow(clientearchivo.getVersionRow());	
					clientearchivoLocal.setid_cliente(clientearchivo.getid_cliente());	
					clientearchivoLocal.setid_tipo_archivo(clientearchivo.getid_tipo_archivo());	
					clientearchivoLocal.setnombre(clientearchivo.getnombre());	
					clientearchivoLocal.setarchivo(clientearchivo.getarchivo());	
					clientearchivoLocal.setdescripcion(clientearchivo.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!clientearchivo.getIsDeleted()) {
				if(!existe) {
					clientearchivos.add(clientearchivo);
				}
			} else {
				if(clientearchivoEncontrado!=null && permiteQuitar)  {
					clientearchivos.remove(clientearchivoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ClienteArchivo clientearchivo,List<ClienteArchivo> clientearchivos) throws Exception {
		try	{			
			for(ClienteArchivo clientearchivoLocal:clientearchivos) {
				if(clientearchivoLocal.getId().equals(clientearchivo.getId())) {
					clientearchivoLocal.setIsSelected(clientearchivo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesClienteArchivo(List<ClienteArchivo> clientearchivosAux) throws Exception {
		//this.clientearchivosAux=clientearchivosAux;
		
		for(ClienteArchivo clientearchivoAux:clientearchivosAux) {
			if(clientearchivoAux.getIsChanged()) {
				clientearchivoAux.setIsChanged(false);
			}		
			
			if(clientearchivoAux.getIsNew()) {
				clientearchivoAux.setIsNew(false);
			}	
			
			if(clientearchivoAux.getIsDeleted()) {
				clientearchivoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesClienteArchivo(ClienteArchivo clientearchivoAux) throws Exception {
		//this.clientearchivoAux=clientearchivoAux;
		
			if(clientearchivoAux.getIsChanged()) {
				clientearchivoAux.setIsChanged(false);
			}		
			
			if(clientearchivoAux.getIsNew()) {
				clientearchivoAux.setIsNew(false);
			}	
			
			if(clientearchivoAux.getIsDeleted()) {
				clientearchivoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ClienteArchivo clientearchivoAsignar,ClienteArchivo clientearchivo) throws Exception {
		clientearchivoAsignar.setId(clientearchivo.getId());	
		clientearchivoAsignar.setVersionRow(clientearchivo.getVersionRow());	
		clientearchivoAsignar.setid_cliente(clientearchivo.getid_cliente());
		clientearchivoAsignar.setcliente_descripcion(clientearchivo.getcliente_descripcion());	
		clientearchivoAsignar.setid_tipo_archivo(clientearchivo.getid_tipo_archivo());
		clientearchivoAsignar.settipoarchivo_descripcion(clientearchivo.gettipoarchivo_descripcion());	
		clientearchivoAsignar.setnombre(clientearchivo.getnombre());	
		clientearchivoAsignar.setarchivo(clientearchivo.getarchivo());	
		clientearchivoAsignar.setdescripcion(clientearchivo.getdescripcion());	
	}
	
	public static void inicializarClienteArchivo(ClienteArchivo clientearchivo) throws Exception {
		try {
				clientearchivo.setId(0L);	
					
				clientearchivo.setid_cliente(-1L);	
				clientearchivo.setid_tipo_archivo(-1L);	
				clientearchivo.setnombre("");	
				clientearchivo.setarchivo(null);	
				clientearchivo.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderClienteArchivo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteArchivoConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteArchivoConstantesFunciones.LABEL_IDTIPOARCHIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteArchivoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteArchivoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataClienteArchivo(String sTipo,Row row,Workbook workbook,ClienteArchivo clientearchivo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(clientearchivo.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clientearchivo.gettipoarchivo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clientearchivo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clientearchivo.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryClienteArchivo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryClienteArchivo() {
		return this.sFinalQueryClienteArchivo;
	}
	
	public void setsFinalQueryClienteArchivo(String sFinalQueryClienteArchivo) {
		this.sFinalQueryClienteArchivo= sFinalQueryClienteArchivo;
	}
	
	public Border resaltarSeleccionarClienteArchivo=null;
	
	public Border setResaltarSeleccionarClienteArchivo(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteArchivoBeanSwingJInternalFrame clientearchivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//clientearchivoBeanSwingJInternalFrame.jTtoolBarClienteArchivo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarClienteArchivo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarClienteArchivo() {
		return this.resaltarSeleccionarClienteArchivo;
	}
	
	public void setResaltarSeleccionarClienteArchivo(Border borderResaltarSeleccionarClienteArchivo) {
		this.resaltarSeleccionarClienteArchivo= borderResaltarSeleccionarClienteArchivo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridClienteArchivo=null;
	public Boolean mostraridClienteArchivo=true;
	public Boolean activaridClienteArchivo=true;

	public Border resaltarid_clienteClienteArchivo=null;
	public Boolean mostrarid_clienteClienteArchivo=true;
	public Boolean activarid_clienteClienteArchivo=true;
	public Boolean cargarid_clienteClienteArchivo=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteClienteArchivo=false;//ConEventDepend=true

	public Border resaltarid_tipo_archivoClienteArchivo=null;
	public Boolean mostrarid_tipo_archivoClienteArchivo=true;
	public Boolean activarid_tipo_archivoClienteArchivo=true;
	public Boolean cargarid_tipo_archivoClienteArchivo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_archivoClienteArchivo=false;//ConEventDepend=true

	public Border resaltarnombreClienteArchivo=null;
	public Boolean mostrarnombreClienteArchivo=true;
	public Boolean activarnombreClienteArchivo=true;

	public Border resaltararchivoClienteArchivo=null;
	public Boolean mostrararchivoClienteArchivo=true;
	public Boolean activararchivoClienteArchivo=true;

	public Border resaltardescripcionClienteArchivo=null;
	public Boolean mostrardescripcionClienteArchivo=true;
	public Boolean activardescripcionClienteArchivo=true;

	
	

	public Border setResaltaridClienteArchivo(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteArchivoBeanSwingJInternalFrame clientearchivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clientearchivoBeanSwingJInternalFrame.jTtoolBarClienteArchivo.setBorder(borderResaltar);
		
		this.resaltaridClienteArchivo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridClienteArchivo() {
		return this.resaltaridClienteArchivo;
	}

	public void setResaltaridClienteArchivo(Border borderResaltar) {
		this.resaltaridClienteArchivo= borderResaltar;
	}

	public Boolean getMostraridClienteArchivo() {
		return this.mostraridClienteArchivo;
	}

	public void setMostraridClienteArchivo(Boolean mostraridClienteArchivo) {
		this.mostraridClienteArchivo= mostraridClienteArchivo;
	}

	public Boolean getActivaridClienteArchivo() {
		return this.activaridClienteArchivo;
	}

	public void setActivaridClienteArchivo(Boolean activaridClienteArchivo) {
		this.activaridClienteArchivo= activaridClienteArchivo;
	}

	public Border setResaltarid_clienteClienteArchivo(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteArchivoBeanSwingJInternalFrame clientearchivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clientearchivoBeanSwingJInternalFrame.jTtoolBarClienteArchivo.setBorder(borderResaltar);
		
		this.resaltarid_clienteClienteArchivo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteClienteArchivo() {
		return this.resaltarid_clienteClienteArchivo;
	}

	public void setResaltarid_clienteClienteArchivo(Border borderResaltar) {
		this.resaltarid_clienteClienteArchivo= borderResaltar;
	}

	public Boolean getMostrarid_clienteClienteArchivo() {
		return this.mostrarid_clienteClienteArchivo;
	}

	public void setMostrarid_clienteClienteArchivo(Boolean mostrarid_clienteClienteArchivo) {
		this.mostrarid_clienteClienteArchivo= mostrarid_clienteClienteArchivo;
	}

	public Boolean getActivarid_clienteClienteArchivo() {
		return this.activarid_clienteClienteArchivo;
	}

	public void setActivarid_clienteClienteArchivo(Boolean activarid_clienteClienteArchivo) {
		this.activarid_clienteClienteArchivo= activarid_clienteClienteArchivo;
	}

	public Boolean getCargarid_clienteClienteArchivo() {
		return this.cargarid_clienteClienteArchivo;
	}

	public void setCargarid_clienteClienteArchivo(Boolean cargarid_clienteClienteArchivo) {
		this.cargarid_clienteClienteArchivo= cargarid_clienteClienteArchivo;
	}

	public Border setResaltarid_tipo_archivoClienteArchivo(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteArchivoBeanSwingJInternalFrame clientearchivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clientearchivoBeanSwingJInternalFrame.jTtoolBarClienteArchivo.setBorder(borderResaltar);
		
		this.resaltarid_tipo_archivoClienteArchivo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_archivoClienteArchivo() {
		return this.resaltarid_tipo_archivoClienteArchivo;
	}

	public void setResaltarid_tipo_archivoClienteArchivo(Border borderResaltar) {
		this.resaltarid_tipo_archivoClienteArchivo= borderResaltar;
	}

	public Boolean getMostrarid_tipo_archivoClienteArchivo() {
		return this.mostrarid_tipo_archivoClienteArchivo;
	}

	public void setMostrarid_tipo_archivoClienteArchivo(Boolean mostrarid_tipo_archivoClienteArchivo) {
		this.mostrarid_tipo_archivoClienteArchivo= mostrarid_tipo_archivoClienteArchivo;
	}

	public Boolean getActivarid_tipo_archivoClienteArchivo() {
		return this.activarid_tipo_archivoClienteArchivo;
	}

	public void setActivarid_tipo_archivoClienteArchivo(Boolean activarid_tipo_archivoClienteArchivo) {
		this.activarid_tipo_archivoClienteArchivo= activarid_tipo_archivoClienteArchivo;
	}

	public Boolean getCargarid_tipo_archivoClienteArchivo() {
		return this.cargarid_tipo_archivoClienteArchivo;
	}

	public void setCargarid_tipo_archivoClienteArchivo(Boolean cargarid_tipo_archivoClienteArchivo) {
		this.cargarid_tipo_archivoClienteArchivo= cargarid_tipo_archivoClienteArchivo;
	}

	public Border setResaltarnombreClienteArchivo(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteArchivoBeanSwingJInternalFrame clientearchivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clientearchivoBeanSwingJInternalFrame.jTtoolBarClienteArchivo.setBorder(borderResaltar);
		
		this.resaltarnombreClienteArchivo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreClienteArchivo() {
		return this.resaltarnombreClienteArchivo;
	}

	public void setResaltarnombreClienteArchivo(Border borderResaltar) {
		this.resaltarnombreClienteArchivo= borderResaltar;
	}

	public Boolean getMostrarnombreClienteArchivo() {
		return this.mostrarnombreClienteArchivo;
	}

	public void setMostrarnombreClienteArchivo(Boolean mostrarnombreClienteArchivo) {
		this.mostrarnombreClienteArchivo= mostrarnombreClienteArchivo;
	}

	public Boolean getActivarnombreClienteArchivo() {
		return this.activarnombreClienteArchivo;
	}

	public void setActivarnombreClienteArchivo(Boolean activarnombreClienteArchivo) {
		this.activarnombreClienteArchivo= activarnombreClienteArchivo;
	}

	public Border setResaltararchivoClienteArchivo(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteArchivoBeanSwingJInternalFrame clientearchivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clientearchivoBeanSwingJInternalFrame.jTtoolBarClienteArchivo.setBorder(borderResaltar);
		
		this.resaltararchivoClienteArchivo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltararchivoClienteArchivo() {
		return this.resaltararchivoClienteArchivo;
	}

	public void setResaltararchivoClienteArchivo(Border borderResaltar) {
		this.resaltararchivoClienteArchivo= borderResaltar;
	}

	public Boolean getMostrararchivoClienteArchivo() {
		return this.mostrararchivoClienteArchivo;
	}

	public void setMostrararchivoClienteArchivo(Boolean mostrararchivoClienteArchivo) {
		this.mostrararchivoClienteArchivo= mostrararchivoClienteArchivo;
	}

	public Boolean getActivararchivoClienteArchivo() {
		return this.activararchivoClienteArchivo;
	}

	public void setActivararchivoClienteArchivo(Boolean activararchivoClienteArchivo) {
		this.activararchivoClienteArchivo= activararchivoClienteArchivo;
	}

	public Border setResaltardescripcionClienteArchivo(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteArchivoBeanSwingJInternalFrame clientearchivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clientearchivoBeanSwingJInternalFrame.jTtoolBarClienteArchivo.setBorder(borderResaltar);
		
		this.resaltardescripcionClienteArchivo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionClienteArchivo() {
		return this.resaltardescripcionClienteArchivo;
	}

	public void setResaltardescripcionClienteArchivo(Border borderResaltar) {
		this.resaltardescripcionClienteArchivo= borderResaltar;
	}

	public Boolean getMostrardescripcionClienteArchivo() {
		return this.mostrardescripcionClienteArchivo;
	}

	public void setMostrardescripcionClienteArchivo(Boolean mostrardescripcionClienteArchivo) {
		this.mostrardescripcionClienteArchivo= mostrardescripcionClienteArchivo;
	}

	public Boolean getActivardescripcionClienteArchivo() {
		return this.activardescripcionClienteArchivo;
	}

	public void setActivardescripcionClienteArchivo(Boolean activardescripcionClienteArchivo) {
		this.activardescripcionClienteArchivo= activardescripcionClienteArchivo;
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
		
		
		this.setMostraridClienteArchivo(esInicial);
		this.setMostrarid_clienteClienteArchivo(esInicial);
		this.setMostrarid_tipo_archivoClienteArchivo(esInicial);
		this.setMostrarnombreClienteArchivo(esInicial);
		this.setMostrararchivoClienteArchivo(esInicial);
		this.setMostrardescripcionClienteArchivo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.ID)) {
				this.setMostraridClienteArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteClienteArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.IDTIPOARCHIVO)) {
				this.setMostrarid_tipo_archivoClienteArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreClienteArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.ARCHIVO)) {
				this.setMostrararchivoClienteArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionClienteArchivo(esAsigna);
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
		
		
		this.setActivaridClienteArchivo(esInicial);
		this.setActivarid_clienteClienteArchivo(esInicial);
		this.setActivarid_tipo_archivoClienteArchivo(esInicial);
		this.setActivarnombreClienteArchivo(esInicial);
		this.setActivararchivoClienteArchivo(esInicial);
		this.setActivardescripcionClienteArchivo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.ID)) {
				this.setActivaridClienteArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteClienteArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.IDTIPOARCHIVO)) {
				this.setActivarid_tipo_archivoClienteArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreClienteArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.ARCHIVO)) {
				this.setActivararchivoClienteArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionClienteArchivo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ClienteArchivoBeanSwingJInternalFrame clientearchivoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridClienteArchivo(esInicial);
		this.setResaltarid_clienteClienteArchivo(esInicial);
		this.setResaltarid_tipo_archivoClienteArchivo(esInicial);
		this.setResaltarnombreClienteArchivo(esInicial);
		this.setResaltararchivoClienteArchivo(esInicial);
		this.setResaltardescripcionClienteArchivo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.ID)) {
				this.setResaltaridClienteArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteClienteArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.IDTIPOARCHIVO)) {
				this.setResaltarid_tipo_archivoClienteArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreClienteArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.ARCHIVO)) {
				this.setResaltararchivoClienteArchivo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteArchivoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionClienteArchivo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ClienteArchivoBeanSwingJInternalFrame clientearchivoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteClienteArchivo=true;

	public Boolean getMostrarFK_IdClienteClienteArchivo() {
		return this.mostrarFK_IdClienteClienteArchivo;
	}

	public void setMostrarFK_IdClienteClienteArchivo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteClienteArchivo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoArchivoClienteArchivo=true;

	public Boolean getMostrarFK_IdTipoArchivoClienteArchivo() {
		return this.mostrarFK_IdTipoArchivoClienteArchivo;
	}

	public void setMostrarFK_IdTipoArchivoClienteArchivo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoArchivoClienteArchivo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteClienteArchivo=true;

	public Boolean getActivarFK_IdClienteClienteArchivo() {
		return this.activarFK_IdClienteClienteArchivo;
	}

	public void setActivarFK_IdClienteClienteArchivo(Boolean habilitarResaltar) {
		this.activarFK_IdClienteClienteArchivo= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoArchivoClienteArchivo=true;

	public Boolean getActivarFK_IdTipoArchivoClienteArchivo() {
		return this.activarFK_IdTipoArchivoClienteArchivo;
	}

	public void setActivarFK_IdTipoArchivoClienteArchivo(Boolean habilitarResaltar) {
		this.activarFK_IdTipoArchivoClienteArchivo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteClienteArchivo=null;

	public Border getResaltarFK_IdClienteClienteArchivo() {
		return this.resaltarFK_IdClienteClienteArchivo;
	}

	public void setResaltarFK_IdClienteClienteArchivo(Border borderResaltar) {
		this.resaltarFK_IdClienteClienteArchivo= borderResaltar;
	}

	public void setResaltarFK_IdClienteClienteArchivo(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteArchivoBeanSwingJInternalFrame clientearchivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteClienteArchivo= borderResaltar;
	}

	public Border resaltarFK_IdTipoArchivoClienteArchivo=null;

	public Border getResaltarFK_IdTipoArchivoClienteArchivo() {
		return this.resaltarFK_IdTipoArchivoClienteArchivo;
	}

	public void setResaltarFK_IdTipoArchivoClienteArchivo(Border borderResaltar) {
		this.resaltarFK_IdTipoArchivoClienteArchivo= borderResaltar;
	}

	public void setResaltarFK_IdTipoArchivoClienteArchivo(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteArchivoBeanSwingJInternalFrame clientearchivoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoArchivoClienteArchivo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}