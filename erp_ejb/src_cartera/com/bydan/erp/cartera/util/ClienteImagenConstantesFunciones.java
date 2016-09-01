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


import com.bydan.erp.cartera.util.ClienteImagenConstantesFunciones;
import com.bydan.erp.cartera.util.ClienteImagenParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ClienteImagenParameterGeneral;

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
final public class ClienteImagenConstantesFunciones extends ClienteImagenConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ClienteImagen";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ClienteImagen"+ClienteImagenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ClienteImagenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ClienteImagenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ClienteImagenConstantesFunciones.SCHEMA+"_"+ClienteImagenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ClienteImagenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ClienteImagenConstantesFunciones.SCHEMA+"_"+ClienteImagenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ClienteImagenConstantesFunciones.SCHEMA+"_"+ClienteImagenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ClienteImagenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ClienteImagenConstantesFunciones.SCHEMA+"_"+ClienteImagenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteImagenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ClienteImagenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteImagenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteImagenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ClienteImagenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteImagenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ClienteImagenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ClienteImagenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ClienteImagenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ClienteImagenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cliente Imagenes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cliente Imagen";
	public static final String SCLASSWEBTITULO_LOWER="Cliente Imagen";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ClienteImagen";
	public static final String OBJECTNAME="clienteimagen";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cliente_imagen";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select clienteimagen from "+ClienteImagenConstantesFunciones.SPERSISTENCENAME+" clienteimagen";
	public static String QUERYSELECTNATIVE="select "+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".id,"+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".version_row,"+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".id_cliente,"+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".id_tipo_imagen_persona,"+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".id_tipo_imagen,"+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".nombre,"+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".imagen,"+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".descripcion from "+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME;//+" as "+ClienteImagenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ClienteImagenConstantesFuncionesAdditional clienteimagenConstantesFuncionesAdditional=null;
	
	public ClienteImagenConstantesFuncionesAdditional getClienteImagenConstantesFuncionesAdditional() {
		return this.clienteimagenConstantesFuncionesAdditional;
	}
	
	public void setClienteImagenConstantesFuncionesAdditional(ClienteImagenConstantesFuncionesAdditional clienteimagenConstantesFuncionesAdditional) {
		try {
			this.clienteimagenConstantesFuncionesAdditional=clienteimagenConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDTIPOIMAGENPERSONA= "id_tipo_imagen_persona";
    public static final String IDTIPOIMAGEN= "id_tipo_imagen";
    public static final String NOMBRE= "nombre";
    public static final String IMAGEN= "imagen";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCLIENTE= "Idcliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPOIMAGENPERSONA= "Tipo Imagen Persona";
		public static final String LABEL_IDTIPOIMAGENPERSONA_LOWER= "Tipo Imagen Persona";
    	public static final String LABEL_IDTIPOIMAGEN= "Tipo Imagen";
		public static final String LABEL_IDTIPOIMAGEN_LOWER= "Tipo Imagen";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IMAGEN= "Imagen";
		public static final String LABEL_IMAGEN_LOWER= "Imagen";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getClienteImagenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ClienteImagenConstantesFunciones.IDCLIENTE)) {sLabelColumna=ClienteImagenConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ClienteImagenConstantesFunciones.IDTIPOIMAGENPERSONA)) {sLabelColumna=ClienteImagenConstantesFunciones.LABEL_IDTIPOIMAGENPERSONA;}
		if(sNombreColumna.equals(ClienteImagenConstantesFunciones.IDTIPOIMAGEN)) {sLabelColumna=ClienteImagenConstantesFunciones.LABEL_IDTIPOIMAGEN;}
		if(sNombreColumna.equals(ClienteImagenConstantesFunciones.NOMBRE)) {sLabelColumna=ClienteImagenConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ClienteImagenConstantesFunciones.IMAGEN)) {sLabelColumna=ClienteImagenConstantesFunciones.LABEL_IMAGEN;}
		if(sNombreColumna.equals(ClienteImagenConstantesFunciones.DESCRIPCION)) {sLabelColumna=ClienteImagenConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getClienteImagenDescripcion(ClienteImagen clienteimagen) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(clienteimagen !=null/* && clienteimagen.getId()!=0*/) {
			sDescripcion=clienteimagen.getnombre();//clienteimagenclienteimagen.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getClienteImagenDescripcionDetallado(ClienteImagen clienteimagen) {
		String sDescripcion="";
			
		sDescripcion+=ClienteImagenConstantesFunciones.ID+"=";
		sDescripcion+=clienteimagen.getId().toString()+",";
		sDescripcion+=ClienteImagenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=clienteimagen.getVersionRow().toString()+",";
		sDescripcion+=ClienteImagenConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=clienteimagen.getid_cliente().toString()+",";
		sDescripcion+=ClienteImagenConstantesFunciones.IDTIPOIMAGENPERSONA+"=";
		sDescripcion+=clienteimagen.getid_tipo_imagen_persona().toString()+",";
		sDescripcion+=ClienteImagenConstantesFunciones.IDTIPOIMAGEN+"=";
		sDescripcion+=clienteimagen.getid_tipo_imagen().toString()+",";
		sDescripcion+=ClienteImagenConstantesFunciones.NOMBRE+"=";
		sDescripcion+=clienteimagen.getnombre()+",";
		sDescripcion+=ClienteImagenConstantesFunciones.IMAGEN+"=";
		sDescripcion+=clienteimagen.getimagen().toString()+",";
		sDescripcion+=ClienteImagenConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=clienteimagen.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setClienteImagenDescripcion(ClienteImagen clienteimagen,String sValor) throws Exception {			
		if(clienteimagen !=null) {
			clienteimagen.setnombre(sValor);;//clienteimagenclienteimagen.getnombre().trim();
		}		
	}
	
		

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTipoImagenPersonaDescripcion(TipoImagenPersona tipoimagenpersona) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoimagenpersona!=null/*&&tipoimagenpersona.getId()>0*/) {
			sDescripcion=TipoImagenPersonaConstantesFunciones.getTipoImagenPersonaDescripcion(tipoimagenpersona);
		}

		return sDescripcion;
	}

	public static String getTipoImagenDescripcion(TipoImagen tipoimagen) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoimagen!=null/*&&tipoimagen.getId()>0*/) {
			sDescripcion=TipoImagenConstantesFunciones.getTipoImagenDescripcion(tipoimagen);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Idcliente";
		} else if(sNombreIndice.equals("FK_IdTipoImagen")) {
			sNombreIndice="Tipo=  Por Tipo Imagen";
		} else if(sNombreIndice.equals("FK_IdTipoImagenPersona")) {
			sNombreIndice="Tipo=  Por Tipo Imagen Persona";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Idcliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoImagen(Long id_tipo_imagen) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_imagen!=null) {sDetalleIndice+=" Codigo Unico De Tipo Imagen="+id_tipo_imagen.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoImagenPersona(Long id_tipo_imagen_persona) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_imagen_persona!=null) {sDetalleIndice+=" Codigo Unico De Tipo Imagen Persona="+id_tipo_imagen_persona.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosClienteImagen(ClienteImagen clienteimagen,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		clienteimagen.setnombre(clienteimagen.getnombre().trim());
		clienteimagen.setdescripcion(clienteimagen.getdescripcion().trim());
	}
	
	public static void quitarEspaciosClienteImagens(List<ClienteImagen> clienteimagens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ClienteImagen clienteimagen: clienteimagens) {
			clienteimagen.setnombre(clienteimagen.getnombre().trim());
			clienteimagen.setdescripcion(clienteimagen.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresClienteImagen(ClienteImagen clienteimagen,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && clienteimagen.getConCambioAuxiliar()) {
			clienteimagen.setIsDeleted(clienteimagen.getIsDeletedAuxiliar());	
			clienteimagen.setIsNew(clienteimagen.getIsNewAuxiliar());	
			clienteimagen.setIsChanged(clienteimagen.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			clienteimagen.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			clienteimagen.setIsDeletedAuxiliar(false);	
			clienteimagen.setIsNewAuxiliar(false);	
			clienteimagen.setIsChangedAuxiliar(false);
			
			clienteimagen.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresClienteImagens(List<ClienteImagen> clienteimagens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ClienteImagen clienteimagen : clienteimagens) {
			if(conAsignarBase && clienteimagen.getConCambioAuxiliar()) {
				clienteimagen.setIsDeleted(clienteimagen.getIsDeletedAuxiliar());	
				clienteimagen.setIsNew(clienteimagen.getIsNewAuxiliar());	
				clienteimagen.setIsChanged(clienteimagen.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				clienteimagen.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				clienteimagen.setIsDeletedAuxiliar(false);	
				clienteimagen.setIsNewAuxiliar(false);	
				clienteimagen.setIsChangedAuxiliar(false);
				
				clienteimagen.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresClienteImagen(ClienteImagen clienteimagen,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresClienteImagens(List<ClienteImagen> clienteimagens,Boolean conEnteros) throws Exception  {
		
		for(ClienteImagen clienteimagen: clienteimagens) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaClienteImagen(List<ClienteImagen> clienteimagens,ClienteImagen clienteimagenAux) throws Exception  {
		ClienteImagenConstantesFunciones.InicializarValoresClienteImagen(clienteimagenAux,true);
		
		for(ClienteImagen clienteimagen: clienteimagens) {
			if(clienteimagen.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesClienteImagen(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ClienteImagenConstantesFunciones.getArrayColumnasGlobalesClienteImagen(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesClienteImagen(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoClienteImagen(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ClienteImagen> clienteimagens,ClienteImagen clienteimagen,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ClienteImagen clienteimagenAux: clienteimagens) {
			if(clienteimagenAux!=null && clienteimagen!=null) {
				if((clienteimagenAux.getId()==null && clienteimagen.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(clienteimagenAux.getId()!=null && clienteimagen.getId()!=null){
					if(clienteimagenAux.getId().equals(clienteimagen.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaClienteImagen(List<ClienteImagen> clienteimagens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ClienteImagen clienteimagen: clienteimagens) {			
			if(clienteimagen.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaClienteImagen() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ClienteImagenConstantesFunciones.LABEL_ID, ClienteImagenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteImagenConstantesFunciones.LABEL_VERSIONROW, ClienteImagenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteImagenConstantesFunciones.LABEL_IDCLIENTE, ClienteImagenConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteImagenConstantesFunciones.LABEL_IDTIPOIMAGENPERSONA, ClienteImagenConstantesFunciones.IDTIPOIMAGENPERSONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteImagenConstantesFunciones.LABEL_IDTIPOIMAGEN, ClienteImagenConstantesFunciones.IDTIPOIMAGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteImagenConstantesFunciones.LABEL_NOMBRE, ClienteImagenConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteImagenConstantesFunciones.LABEL_IMAGEN, ClienteImagenConstantesFunciones.IMAGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteImagenConstantesFunciones.LABEL_DESCRIPCION, ClienteImagenConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasClienteImagen() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ClienteImagenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteImagenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteImagenConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteImagenConstantesFunciones.IDTIPOIMAGENPERSONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteImagenConstantesFunciones.IDTIPOIMAGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteImagenConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteImagenConstantesFunciones.IMAGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteImagenConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClienteImagen() throws Exception  {
		return ClienteImagenConstantesFunciones.getTiposSeleccionarClienteImagen(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClienteImagen(Boolean conFk) throws Exception  {
		return ClienteImagenConstantesFunciones.getTiposSeleccionarClienteImagen(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarClienteImagen(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteImagenConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ClienteImagenConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteImagenConstantesFunciones.LABEL_IDTIPOIMAGENPERSONA);
			reporte.setsDescripcion(ClienteImagenConstantesFunciones.LABEL_IDTIPOIMAGENPERSONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteImagenConstantesFunciones.LABEL_IDTIPOIMAGEN);
			reporte.setsDescripcion(ClienteImagenConstantesFunciones.LABEL_IDTIPOIMAGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteImagenConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ClienteImagenConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(ClienteImagenConstantesFunciones.LABEL_IMAGEN);
		reporte.setsDescripcion(ClienteImagenConstantesFunciones.LABEL_IMAGEN);

		arrTiposSeleccionarTodos.add(reporte);
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteImagenConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ClienteImagenConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesClienteImagen(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesClienteImagen(ClienteImagen clienteimagenAux) throws Exception {
		
			clienteimagenAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(clienteimagenAux.getCliente()));
			clienteimagenAux.settipoimagenpersona_descripcion(TipoImagenPersonaConstantesFunciones.getTipoImagenPersonaDescripcion(clienteimagenAux.getTipoImagenPersona()));
			clienteimagenAux.settipoimagen_descripcion(TipoImagenConstantesFunciones.getTipoImagenDescripcion(clienteimagenAux.getTipoImagen()));		
	}
	
	public static void refrescarForeignKeysDescripcionesClienteImagen(List<ClienteImagen> clienteimagensTemp) throws Exception {
		for(ClienteImagen clienteimagenAux:clienteimagensTemp) {
			
			clienteimagenAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(clienteimagenAux.getCliente()));
			clienteimagenAux.settipoimagenpersona_descripcion(TipoImagenPersonaConstantesFunciones.getTipoImagenPersonaDescripcion(clienteimagenAux.getTipoImagenPersona()));
			clienteimagenAux.settipoimagen_descripcion(TipoImagenConstantesFunciones.getTipoImagenDescripcion(clienteimagenAux.getTipoImagen()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfClienteImagen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoImagenPersona.class));
				classes.add(new Classe(TipoImagen.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoImagenPersona.class)) {
						classes.add(new Classe(TipoImagenPersona.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoImagen.class)) {
						classes.add(new Classe(TipoImagen.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfClienteImagen(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoImagenPersona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoImagenPersona.class)); continue;
					}

					if(TipoImagen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoImagen.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoImagenPersona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoImagenPersona.class)); continue;
					}

					if(TipoImagen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoImagen.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfClienteImagen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ClienteImagenConstantesFunciones.getClassesRelationshipsOfClienteImagen(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfClienteImagen(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfClienteImagen(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ClienteImagenConstantesFunciones.getClassesRelationshipsFromStringsOfClienteImagen(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfClienteImagen(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ClienteImagen clienteimagen,List<ClienteImagen> clienteimagens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ClienteImagen clienteimagenEncontrado=null;
			
			for(ClienteImagen clienteimagenLocal:clienteimagens) {
				if(clienteimagenLocal.getId().equals(clienteimagen.getId())) {
					clienteimagenEncontrado=clienteimagenLocal;
					
					clienteimagenLocal.setIsChanged(clienteimagen.getIsChanged());
					clienteimagenLocal.setIsNew(clienteimagen.getIsNew());
					clienteimagenLocal.setIsDeleted(clienteimagen.getIsDeleted());
					
					clienteimagenLocal.setGeneralEntityOriginal(clienteimagen.getGeneralEntityOriginal());
					
					clienteimagenLocal.setId(clienteimagen.getId());	
					clienteimagenLocal.setVersionRow(clienteimagen.getVersionRow());	
					clienteimagenLocal.setid_cliente(clienteimagen.getid_cliente());	
					clienteimagenLocal.setid_tipo_imagen_persona(clienteimagen.getid_tipo_imagen_persona());	
					clienteimagenLocal.setid_tipo_imagen(clienteimagen.getid_tipo_imagen());	
					clienteimagenLocal.setnombre(clienteimagen.getnombre());	
					clienteimagenLocal.setimagen(clienteimagen.getimagen());	
					clienteimagenLocal.setdescripcion(clienteimagen.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!clienteimagen.getIsDeleted()) {
				if(!existe) {
					clienteimagens.add(clienteimagen);
				}
			} else {
				if(clienteimagenEncontrado!=null && permiteQuitar)  {
					clienteimagens.remove(clienteimagenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ClienteImagen clienteimagen,List<ClienteImagen> clienteimagens) throws Exception {
		try	{			
			for(ClienteImagen clienteimagenLocal:clienteimagens) {
				if(clienteimagenLocal.getId().equals(clienteimagen.getId())) {
					clienteimagenLocal.setIsSelected(clienteimagen.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesClienteImagen(List<ClienteImagen> clienteimagensAux) throws Exception {
		//this.clienteimagensAux=clienteimagensAux;
		
		for(ClienteImagen clienteimagenAux:clienteimagensAux) {
			if(clienteimagenAux.getIsChanged()) {
				clienteimagenAux.setIsChanged(false);
			}		
			
			if(clienteimagenAux.getIsNew()) {
				clienteimagenAux.setIsNew(false);
			}	
			
			if(clienteimagenAux.getIsDeleted()) {
				clienteimagenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesClienteImagen(ClienteImagen clienteimagenAux) throws Exception {
		//this.clienteimagenAux=clienteimagenAux;
		
			if(clienteimagenAux.getIsChanged()) {
				clienteimagenAux.setIsChanged(false);
			}		
			
			if(clienteimagenAux.getIsNew()) {
				clienteimagenAux.setIsNew(false);
			}	
			
			if(clienteimagenAux.getIsDeleted()) {
				clienteimagenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ClienteImagen clienteimagenAsignar,ClienteImagen clienteimagen) throws Exception {
		clienteimagenAsignar.setId(clienteimagen.getId());	
		clienteimagenAsignar.setVersionRow(clienteimagen.getVersionRow());	
		clienteimagenAsignar.setid_cliente(clienteimagen.getid_cliente());
		clienteimagenAsignar.setcliente_descripcion(clienteimagen.getcliente_descripcion());	
		clienteimagenAsignar.setid_tipo_imagen_persona(clienteimagen.getid_tipo_imagen_persona());
		clienteimagenAsignar.settipoimagenpersona_descripcion(clienteimagen.gettipoimagenpersona_descripcion());	
		clienteimagenAsignar.setid_tipo_imagen(clienteimagen.getid_tipo_imagen());
		clienteimagenAsignar.settipoimagen_descripcion(clienteimagen.gettipoimagen_descripcion());	
		clienteimagenAsignar.setnombre(clienteimagen.getnombre());	
		clienteimagenAsignar.setimagen(clienteimagen.getimagen());	
		clienteimagenAsignar.setdescripcion(clienteimagen.getdescripcion());	
	}
	
	public static void inicializarClienteImagen(ClienteImagen clienteimagen) throws Exception {
		try {
				clienteimagen.setId(0L);	
					
				clienteimagen.setid_cliente(-1L);	
				clienteimagen.setid_tipo_imagen_persona(-1L);	
				clienteimagen.setid_tipo_imagen(-1L);	
				clienteimagen.setnombre("");	
				clienteimagen.setimagen(null);	
				clienteimagen.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderClienteImagen(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteImagenConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteImagenConstantesFunciones.LABEL_IDTIPOIMAGENPERSONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteImagenConstantesFunciones.LABEL_IDTIPOIMAGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteImagenConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteImagenConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataClienteImagen(String sTipo,Row row,Workbook workbook,ClienteImagen clienteimagen,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteimagen.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteimagen.gettipoimagenpersona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteimagen.gettipoimagen_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteimagen.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(clienteimagen.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryClienteImagen=Constantes.SFINALQUERY;
	
	public String getsFinalQueryClienteImagen() {
		return this.sFinalQueryClienteImagen;
	}
	
	public void setsFinalQueryClienteImagen(String sFinalQueryClienteImagen) {
		this.sFinalQueryClienteImagen= sFinalQueryClienteImagen;
	}
	
	public Border resaltarSeleccionarClienteImagen=null;
	
	public Border setResaltarSeleccionarClienteImagen(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteImagenBeanSwingJInternalFrame clienteimagenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//clienteimagenBeanSwingJInternalFrame.jTtoolBarClienteImagen.setBorder(borderResaltar);
		
		this.resaltarSeleccionarClienteImagen= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarClienteImagen() {
		return this.resaltarSeleccionarClienteImagen;
	}
	
	public void setResaltarSeleccionarClienteImagen(Border borderResaltarSeleccionarClienteImagen) {
		this.resaltarSeleccionarClienteImagen= borderResaltarSeleccionarClienteImagen;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridClienteImagen=null;
	public Boolean mostraridClienteImagen=true;
	public Boolean activaridClienteImagen=true;

	public Border resaltarid_clienteClienteImagen=null;
	public Boolean mostrarid_clienteClienteImagen=true;
	public Boolean activarid_clienteClienteImagen=true;
	public Boolean cargarid_clienteClienteImagen=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteClienteImagen=false;//ConEventDepend=true

	public Border resaltarid_tipo_imagen_personaClienteImagen=null;
	public Boolean mostrarid_tipo_imagen_personaClienteImagen=true;
	public Boolean activarid_tipo_imagen_personaClienteImagen=true;
	public Boolean cargarid_tipo_imagen_personaClienteImagen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_imagen_personaClienteImagen=false;//ConEventDepend=true

	public Border resaltarid_tipo_imagenClienteImagen=null;
	public Boolean mostrarid_tipo_imagenClienteImagen=true;
	public Boolean activarid_tipo_imagenClienteImagen=true;
	public Boolean cargarid_tipo_imagenClienteImagen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_imagenClienteImagen=false;//ConEventDepend=true

	public Border resaltarnombreClienteImagen=null;
	public Boolean mostrarnombreClienteImagen=true;
	public Boolean activarnombreClienteImagen=true;

	public Border resaltarimagenClienteImagen=null;
	public Boolean mostrarimagenClienteImagen=true;
	public Boolean activarimagenClienteImagen=true;

	public Border resaltardescripcionClienteImagen=null;
	public Boolean mostrardescripcionClienteImagen=true;
	public Boolean activardescripcionClienteImagen=true;

	
	

	public Border setResaltaridClienteImagen(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteImagenBeanSwingJInternalFrame clienteimagenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteimagenBeanSwingJInternalFrame.jTtoolBarClienteImagen.setBorder(borderResaltar);
		
		this.resaltaridClienteImagen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridClienteImagen() {
		return this.resaltaridClienteImagen;
	}

	public void setResaltaridClienteImagen(Border borderResaltar) {
		this.resaltaridClienteImagen= borderResaltar;
	}

	public Boolean getMostraridClienteImagen() {
		return this.mostraridClienteImagen;
	}

	public void setMostraridClienteImagen(Boolean mostraridClienteImagen) {
		this.mostraridClienteImagen= mostraridClienteImagen;
	}

	public Boolean getActivaridClienteImagen() {
		return this.activaridClienteImagen;
	}

	public void setActivaridClienteImagen(Boolean activaridClienteImagen) {
		this.activaridClienteImagen= activaridClienteImagen;
	}

	public Border setResaltarid_clienteClienteImagen(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteImagenBeanSwingJInternalFrame clienteimagenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteimagenBeanSwingJInternalFrame.jTtoolBarClienteImagen.setBorder(borderResaltar);
		
		this.resaltarid_clienteClienteImagen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteClienteImagen() {
		return this.resaltarid_clienteClienteImagen;
	}

	public void setResaltarid_clienteClienteImagen(Border borderResaltar) {
		this.resaltarid_clienteClienteImagen= borderResaltar;
	}

	public Boolean getMostrarid_clienteClienteImagen() {
		return this.mostrarid_clienteClienteImagen;
	}

	public void setMostrarid_clienteClienteImagen(Boolean mostrarid_clienteClienteImagen) {
		this.mostrarid_clienteClienteImagen= mostrarid_clienteClienteImagen;
	}

	public Boolean getActivarid_clienteClienteImagen() {
		return this.activarid_clienteClienteImagen;
	}

	public void setActivarid_clienteClienteImagen(Boolean activarid_clienteClienteImagen) {
		this.activarid_clienteClienteImagen= activarid_clienteClienteImagen;
	}

	public Boolean getCargarid_clienteClienteImagen() {
		return this.cargarid_clienteClienteImagen;
	}

	public void setCargarid_clienteClienteImagen(Boolean cargarid_clienteClienteImagen) {
		this.cargarid_clienteClienteImagen= cargarid_clienteClienteImagen;
	}

	public Border setResaltarid_tipo_imagen_personaClienteImagen(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteImagenBeanSwingJInternalFrame clienteimagenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteimagenBeanSwingJInternalFrame.jTtoolBarClienteImagen.setBorder(borderResaltar);
		
		this.resaltarid_tipo_imagen_personaClienteImagen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_imagen_personaClienteImagen() {
		return this.resaltarid_tipo_imagen_personaClienteImagen;
	}

	public void setResaltarid_tipo_imagen_personaClienteImagen(Border borderResaltar) {
		this.resaltarid_tipo_imagen_personaClienteImagen= borderResaltar;
	}

	public Boolean getMostrarid_tipo_imagen_personaClienteImagen() {
		return this.mostrarid_tipo_imagen_personaClienteImagen;
	}

	public void setMostrarid_tipo_imagen_personaClienteImagen(Boolean mostrarid_tipo_imagen_personaClienteImagen) {
		this.mostrarid_tipo_imagen_personaClienteImagen= mostrarid_tipo_imagen_personaClienteImagen;
	}

	public Boolean getActivarid_tipo_imagen_personaClienteImagen() {
		return this.activarid_tipo_imagen_personaClienteImagen;
	}

	public void setActivarid_tipo_imagen_personaClienteImagen(Boolean activarid_tipo_imagen_personaClienteImagen) {
		this.activarid_tipo_imagen_personaClienteImagen= activarid_tipo_imagen_personaClienteImagen;
	}

	public Boolean getCargarid_tipo_imagen_personaClienteImagen() {
		return this.cargarid_tipo_imagen_personaClienteImagen;
	}

	public void setCargarid_tipo_imagen_personaClienteImagen(Boolean cargarid_tipo_imagen_personaClienteImagen) {
		this.cargarid_tipo_imagen_personaClienteImagen= cargarid_tipo_imagen_personaClienteImagen;
	}

	public Border setResaltarid_tipo_imagenClienteImagen(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteImagenBeanSwingJInternalFrame clienteimagenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteimagenBeanSwingJInternalFrame.jTtoolBarClienteImagen.setBorder(borderResaltar);
		
		this.resaltarid_tipo_imagenClienteImagen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_imagenClienteImagen() {
		return this.resaltarid_tipo_imagenClienteImagen;
	}

	public void setResaltarid_tipo_imagenClienteImagen(Border borderResaltar) {
		this.resaltarid_tipo_imagenClienteImagen= borderResaltar;
	}

	public Boolean getMostrarid_tipo_imagenClienteImagen() {
		return this.mostrarid_tipo_imagenClienteImagen;
	}

	public void setMostrarid_tipo_imagenClienteImagen(Boolean mostrarid_tipo_imagenClienteImagen) {
		this.mostrarid_tipo_imagenClienteImagen= mostrarid_tipo_imagenClienteImagen;
	}

	public Boolean getActivarid_tipo_imagenClienteImagen() {
		return this.activarid_tipo_imagenClienteImagen;
	}

	public void setActivarid_tipo_imagenClienteImagen(Boolean activarid_tipo_imagenClienteImagen) {
		this.activarid_tipo_imagenClienteImagen= activarid_tipo_imagenClienteImagen;
	}

	public Boolean getCargarid_tipo_imagenClienteImagen() {
		return this.cargarid_tipo_imagenClienteImagen;
	}

	public void setCargarid_tipo_imagenClienteImagen(Boolean cargarid_tipo_imagenClienteImagen) {
		this.cargarid_tipo_imagenClienteImagen= cargarid_tipo_imagenClienteImagen;
	}

	public Border setResaltarnombreClienteImagen(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteImagenBeanSwingJInternalFrame clienteimagenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteimagenBeanSwingJInternalFrame.jTtoolBarClienteImagen.setBorder(borderResaltar);
		
		this.resaltarnombreClienteImagen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreClienteImagen() {
		return this.resaltarnombreClienteImagen;
	}

	public void setResaltarnombreClienteImagen(Border borderResaltar) {
		this.resaltarnombreClienteImagen= borderResaltar;
	}

	public Boolean getMostrarnombreClienteImagen() {
		return this.mostrarnombreClienteImagen;
	}

	public void setMostrarnombreClienteImagen(Boolean mostrarnombreClienteImagen) {
		this.mostrarnombreClienteImagen= mostrarnombreClienteImagen;
	}

	public Boolean getActivarnombreClienteImagen() {
		return this.activarnombreClienteImagen;
	}

	public void setActivarnombreClienteImagen(Boolean activarnombreClienteImagen) {
		this.activarnombreClienteImagen= activarnombreClienteImagen;
	}

	public Border setResaltarimagenClienteImagen(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteImagenBeanSwingJInternalFrame clienteimagenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteimagenBeanSwingJInternalFrame.jTtoolBarClienteImagen.setBorder(borderResaltar);
		
		this.resaltarimagenClienteImagen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimagenClienteImagen() {
		return this.resaltarimagenClienteImagen;
	}

	public void setResaltarimagenClienteImagen(Border borderResaltar) {
		this.resaltarimagenClienteImagen= borderResaltar;
	}

	public Boolean getMostrarimagenClienteImagen() {
		return this.mostrarimagenClienteImagen;
	}

	public void setMostrarimagenClienteImagen(Boolean mostrarimagenClienteImagen) {
		this.mostrarimagenClienteImagen= mostrarimagenClienteImagen;
	}

	public Boolean getActivarimagenClienteImagen() {
		return this.activarimagenClienteImagen;
	}

	public void setActivarimagenClienteImagen(Boolean activarimagenClienteImagen) {
		this.activarimagenClienteImagen= activarimagenClienteImagen;
	}

	public Border setResaltardescripcionClienteImagen(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteImagenBeanSwingJInternalFrame clienteimagenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteimagenBeanSwingJInternalFrame.jTtoolBarClienteImagen.setBorder(borderResaltar);
		
		this.resaltardescripcionClienteImagen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionClienteImagen() {
		return this.resaltardescripcionClienteImagen;
	}

	public void setResaltardescripcionClienteImagen(Border borderResaltar) {
		this.resaltardescripcionClienteImagen= borderResaltar;
	}

	public Boolean getMostrardescripcionClienteImagen() {
		return this.mostrardescripcionClienteImagen;
	}

	public void setMostrardescripcionClienteImagen(Boolean mostrardescripcionClienteImagen) {
		this.mostrardescripcionClienteImagen= mostrardescripcionClienteImagen;
	}

	public Boolean getActivardescripcionClienteImagen() {
		return this.activardescripcionClienteImagen;
	}

	public void setActivardescripcionClienteImagen(Boolean activardescripcionClienteImagen) {
		this.activardescripcionClienteImagen= activardescripcionClienteImagen;
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
		
		
		this.setMostraridClienteImagen(esInicial);
		this.setMostrarid_clienteClienteImagen(esInicial);
		this.setMostrarid_tipo_imagen_personaClienteImagen(esInicial);
		this.setMostrarid_tipo_imagenClienteImagen(esInicial);
		this.setMostrarnombreClienteImagen(esInicial);
		this.setMostrarimagenClienteImagen(esInicial);
		this.setMostrardescripcionClienteImagen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClienteImagenConstantesFunciones.ID)) {
				this.setMostraridClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.IDTIPOIMAGENPERSONA)) {
				this.setMostrarid_tipo_imagen_personaClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.IDTIPOIMAGEN)) {
				this.setMostrarid_tipo_imagenClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.IMAGEN)) {
				this.setMostrarimagenClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionClienteImagen(esAsigna);
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
		
		
		this.setActivaridClienteImagen(esInicial);
		this.setActivarid_clienteClienteImagen(esInicial);
		this.setActivarid_tipo_imagen_personaClienteImagen(esInicial);
		this.setActivarid_tipo_imagenClienteImagen(esInicial);
		this.setActivarnombreClienteImagen(esInicial);
		this.setActivarimagenClienteImagen(esInicial);
		this.setActivardescripcionClienteImagen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClienteImagenConstantesFunciones.ID)) {
				this.setActivaridClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.IDTIPOIMAGENPERSONA)) {
				this.setActivarid_tipo_imagen_personaClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.IDTIPOIMAGEN)) {
				this.setActivarid_tipo_imagenClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.NOMBRE)) {
				this.setActivarnombreClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.IMAGEN)) {
				this.setActivarimagenClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionClienteImagen(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ClienteImagenBeanSwingJInternalFrame clienteimagenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridClienteImagen(esInicial);
		this.setResaltarid_clienteClienteImagen(esInicial);
		this.setResaltarid_tipo_imagen_personaClienteImagen(esInicial);
		this.setResaltarid_tipo_imagenClienteImagen(esInicial);
		this.setResaltarnombreClienteImagen(esInicial);
		this.setResaltarimagenClienteImagen(esInicial);
		this.setResaltardescripcionClienteImagen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClienteImagenConstantesFunciones.ID)) {
				this.setResaltaridClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.IDTIPOIMAGENPERSONA)) {
				this.setResaltarid_tipo_imagen_personaClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.IDTIPOIMAGEN)) {
				this.setResaltarid_tipo_imagenClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.IMAGEN)) {
				this.setResaltarimagenClienteImagen(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteImagenConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionClienteImagen(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ClienteImagenBeanSwingJInternalFrame clienteimagenBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteClienteImagen=true;

	public Boolean getMostrarFK_IdClienteClienteImagen() {
		return this.mostrarFK_IdClienteClienteImagen;
	}

	public void setMostrarFK_IdClienteClienteImagen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteClienteImagen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoImagenClienteImagen=true;

	public Boolean getMostrarFK_IdTipoImagenClienteImagen() {
		return this.mostrarFK_IdTipoImagenClienteImagen;
	}

	public void setMostrarFK_IdTipoImagenClienteImagen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoImagenClienteImagen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoImagenPersonaClienteImagen=true;

	public Boolean getMostrarFK_IdTipoImagenPersonaClienteImagen() {
		return this.mostrarFK_IdTipoImagenPersonaClienteImagen;
	}

	public void setMostrarFK_IdTipoImagenPersonaClienteImagen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoImagenPersonaClienteImagen= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteClienteImagen=true;

	public Boolean getActivarFK_IdClienteClienteImagen() {
		return this.activarFK_IdClienteClienteImagen;
	}

	public void setActivarFK_IdClienteClienteImagen(Boolean habilitarResaltar) {
		this.activarFK_IdClienteClienteImagen= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoImagenClienteImagen=true;

	public Boolean getActivarFK_IdTipoImagenClienteImagen() {
		return this.activarFK_IdTipoImagenClienteImagen;
	}

	public void setActivarFK_IdTipoImagenClienteImagen(Boolean habilitarResaltar) {
		this.activarFK_IdTipoImagenClienteImagen= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoImagenPersonaClienteImagen=true;

	public Boolean getActivarFK_IdTipoImagenPersonaClienteImagen() {
		return this.activarFK_IdTipoImagenPersonaClienteImagen;
	}

	public void setActivarFK_IdTipoImagenPersonaClienteImagen(Boolean habilitarResaltar) {
		this.activarFK_IdTipoImagenPersonaClienteImagen= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteClienteImagen=null;

	public Border getResaltarFK_IdClienteClienteImagen() {
		return this.resaltarFK_IdClienteClienteImagen;
	}

	public void setResaltarFK_IdClienteClienteImagen(Border borderResaltar) {
		this.resaltarFK_IdClienteClienteImagen= borderResaltar;
	}

	public void setResaltarFK_IdClienteClienteImagen(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteImagenBeanSwingJInternalFrame clienteimagenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteClienteImagen= borderResaltar;
	}

	public Border resaltarFK_IdTipoImagenClienteImagen=null;

	public Border getResaltarFK_IdTipoImagenClienteImagen() {
		return this.resaltarFK_IdTipoImagenClienteImagen;
	}

	public void setResaltarFK_IdTipoImagenClienteImagen(Border borderResaltar) {
		this.resaltarFK_IdTipoImagenClienteImagen= borderResaltar;
	}

	public void setResaltarFK_IdTipoImagenClienteImagen(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteImagenBeanSwingJInternalFrame clienteimagenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoImagenClienteImagen= borderResaltar;
	}

	public Border resaltarFK_IdTipoImagenPersonaClienteImagen=null;

	public Border getResaltarFK_IdTipoImagenPersonaClienteImagen() {
		return this.resaltarFK_IdTipoImagenPersonaClienteImagen;
	}

	public void setResaltarFK_IdTipoImagenPersonaClienteImagen(Border borderResaltar) {
		this.resaltarFK_IdTipoImagenPersonaClienteImagen= borderResaltar;
	}

	public void setResaltarFK_IdTipoImagenPersonaClienteImagen(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteImagenBeanSwingJInternalFrame clienteimagenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoImagenPersonaClienteImagen= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}