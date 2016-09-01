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
package com.bydan.erp.cartera.util.report;

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


import com.bydan.erp.cartera.util.report.ListadoClientesConstantesFunciones;
import com.bydan.erp.cartera.util.report.ListadoClientesParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.ListadoClientesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



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
final public class ListadoClientesConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="ListadoClientes";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ListadoClientes"+ListadoClientesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ListadoClientesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ListadoClientesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ListadoClientesConstantesFunciones.SCHEMA+"_"+ListadoClientesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ListadoClientesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ListadoClientesConstantesFunciones.SCHEMA+"_"+ListadoClientesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ListadoClientesConstantesFunciones.SCHEMA+"_"+ListadoClientesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ListadoClientesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ListadoClientesConstantesFunciones.SCHEMA+"_"+ListadoClientesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadoClientesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ListadoClientesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadoClientesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadoClientesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ListadoClientesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadoClientesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ListadoClientesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ListadoClientesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ListadoClientesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ListadoClientesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Listado Clienteses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Listado Clientes";
	public static final String SCLASSWEBTITULO_LOWER="Listado Clientes";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ListadoClientes";
	public static final String OBJECTNAME="listadoclientes";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="listado_clientes";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select listadoclientes from "+ListadoClientesConstantesFunciones.SPERSISTENCENAME+" listadoclientes";
	public static String QUERYSELECTNATIVE="select "+ListadoClientesConstantesFunciones.SCHEMA+"."+ListadoClientesConstantesFunciones.TABLENAME+".id,"+ListadoClientesConstantesFunciones.SCHEMA+"."+ListadoClientesConstantesFunciones.TABLENAME+".version_row,"+ListadoClientesConstantesFunciones.SCHEMA+"."+ListadoClientesConstantesFunciones.TABLENAME+".id_empresa,"+ListadoClientesConstantesFunciones.SCHEMA+"."+ListadoClientesConstantesFunciones.TABLENAME+".nombre_zona,"+ListadoClientesConstantesFunciones.SCHEMA+"."+ListadoClientesConstantesFunciones.TABLENAME+".nombre_ciudad,"+ListadoClientesConstantesFunciones.SCHEMA+"."+ListadoClientesConstantesFunciones.TABLENAME+".nombre_grupo_cliente,"+ListadoClientesConstantesFunciones.SCHEMA+"."+ListadoClientesConstantesFunciones.TABLENAME+".codigo,"+ListadoClientesConstantesFunciones.SCHEMA+"."+ListadoClientesConstantesFunciones.TABLENAME+".nombre,"+ListadoClientesConstantesFunciones.SCHEMA+"."+ListadoClientesConstantesFunciones.TABLENAME+".apellido,"+ListadoClientesConstantesFunciones.SCHEMA+"."+ListadoClientesConstantesFunciones.TABLENAME+".ruc,"+ListadoClientesConstantesFunciones.SCHEMA+"."+ListadoClientesConstantesFunciones.TABLENAME+".telefonos,"+ListadoClientesConstantesFunciones.SCHEMA+"."+ListadoClientesConstantesFunciones.TABLENAME+".direcciones,"+ListadoClientesConstantesFunciones.SCHEMA+"."+ListadoClientesConstantesFunciones.TABLENAME+".emails from "+ListadoClientesConstantesFunciones.SCHEMA+"."+ListadoClientesConstantesFunciones.TABLENAME;//+" as "+ListadoClientesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBREZONA= "nombre_zona";
    public static final String NOMBRECIUDAD= "nombre_ciudad";
    public static final String NOMBREGRUPOCLIENTE= "nombre_grupo_cliente";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String APELLIDO= "apellido";
    public static final String RUC= "ruc";
    public static final String TELEFONOS= "telefonos";
    public static final String DIRECCIONES= "direcciones";
    public static final String EMAILS= "emails";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBREZONA= "Nombre Zona";
		public static final String LABEL_NOMBREZONA_LOWER= "Nombre Zona";
    	public static final String LABEL_NOMBRECIUDAD= "Nombre Ciudad";
		public static final String LABEL_NOMBRECIUDAD_LOWER= "Nombre Ciudad";
    	public static final String LABEL_NOMBREGRUPOCLIENTE= "Nombre Grupo Cliente";
		public static final String LABEL_NOMBREGRUPOCLIENTE_LOWER= "Nombre Grupo Cliente";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_APELLIDO= "Apello";
		public static final String LABEL_APELLIDO_LOWER= "Apellido";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_TELEFONOS= "Telefonos";
		public static final String LABEL_TELEFONOS_LOWER= "Telefonos";
    	public static final String LABEL_DIRECCIONES= "Direcciones";
		public static final String LABEL_DIRECCIONES_LOWER= "Direcciones";
    	public static final String LABEL_EMAILS= "Emails";
		public static final String LABEL_EMAILS_LOWER= "Emails";
	
		
		
		
	public static final String SREGEXNOMBRE_ZONA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_ZONA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CIUDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CIUDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_GRUPO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_GRUPO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONOS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONOS=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCIONES=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCIONES=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXEMAILS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXEMAILS=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getListadoClientesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ListadoClientesConstantesFunciones.IDEMPRESA)) {sLabelColumna=ListadoClientesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ListadoClientesConstantesFunciones.NOMBREZONA)) {sLabelColumna=ListadoClientesConstantesFunciones.LABEL_NOMBREZONA;}
		if(sNombreColumna.equals(ListadoClientesConstantesFunciones.NOMBRECIUDAD)) {sLabelColumna=ListadoClientesConstantesFunciones.LABEL_NOMBRECIUDAD;}
		if(sNombreColumna.equals(ListadoClientesConstantesFunciones.NOMBREGRUPOCLIENTE)) {sLabelColumna=ListadoClientesConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE;}
		if(sNombreColumna.equals(ListadoClientesConstantesFunciones.CODIGO)) {sLabelColumna=ListadoClientesConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ListadoClientesConstantesFunciones.NOMBRE)) {sLabelColumna=ListadoClientesConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ListadoClientesConstantesFunciones.APELLIDO)) {sLabelColumna=ListadoClientesConstantesFunciones.LABEL_APELLIDO;}
		if(sNombreColumna.equals(ListadoClientesConstantesFunciones.RUC)) {sLabelColumna=ListadoClientesConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(ListadoClientesConstantesFunciones.TELEFONOS)) {sLabelColumna=ListadoClientesConstantesFunciones.LABEL_TELEFONOS;}
		if(sNombreColumna.equals(ListadoClientesConstantesFunciones.DIRECCIONES)) {sLabelColumna=ListadoClientesConstantesFunciones.LABEL_DIRECCIONES;}
		if(sNombreColumna.equals(ListadoClientesConstantesFunciones.EMAILS)) {sLabelColumna=ListadoClientesConstantesFunciones.LABEL_EMAILS;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getListadoClientesDescripcion(ListadoClientes listadoclientes) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(listadoclientes !=null/* && listadoclientes.getId()!=0*/) {
			sDescripcion=listadoclientes.getcodigo();//listadoclienteslistadoclientes.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getListadoClientesDescripcionDetallado(ListadoClientes listadoclientes) {
		String sDescripcion="";
			
		sDescripcion+=ListadoClientesConstantesFunciones.ID+"=";
		sDescripcion+=listadoclientes.getId().toString()+",";
		sDescripcion+=ListadoClientesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=listadoclientes.getVersionRow().toString()+",";
		sDescripcion+=ListadoClientesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=listadoclientes.getid_empresa().toString()+",";
		sDescripcion+=ListadoClientesConstantesFunciones.NOMBREZONA+"=";
		sDescripcion+=listadoclientes.getnombre_zona()+",";
		sDescripcion+=ListadoClientesConstantesFunciones.NOMBRECIUDAD+"=";
		sDescripcion+=listadoclientes.getnombre_ciudad()+",";
		sDescripcion+=ListadoClientesConstantesFunciones.NOMBREGRUPOCLIENTE+"=";
		sDescripcion+=listadoclientes.getnombre_grupo_cliente()+",";
		sDescripcion+=ListadoClientesConstantesFunciones.CODIGO+"=";
		sDescripcion+=listadoclientes.getcodigo()+",";
		sDescripcion+=ListadoClientesConstantesFunciones.NOMBRE+"=";
		sDescripcion+=listadoclientes.getnombre()+",";
		sDescripcion+=ListadoClientesConstantesFunciones.APELLIDO+"=";
		sDescripcion+=listadoclientes.getapellido()+",";
		sDescripcion+=ListadoClientesConstantesFunciones.RUC+"=";
		sDescripcion+=listadoclientes.getruc()+",";
		sDescripcion+=ListadoClientesConstantesFunciones.TELEFONOS+"=";
		sDescripcion+=listadoclientes.gettelefonos()+",";
		sDescripcion+=ListadoClientesConstantesFunciones.DIRECCIONES+"=";
		sDescripcion+=listadoclientes.getdirecciones()+",";
		sDescripcion+=ListadoClientesConstantesFunciones.EMAILS+"=";
		sDescripcion+=listadoclientes.getemails()+",";
			
		return sDescripcion;
	}
	
	public static void setListadoClientesDescripcion(ListadoClientes listadoclientes,String sValor) throws Exception {			
		if(listadoclientes !=null) {
			listadoclientes.setcodigo(sValor);;//listadoclienteslistadoclientes.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaListadoClientes")) {
			sNombreIndice="Tipo=  Por ";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaListadoClientes(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" ="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosListadoClientes(ListadoClientes listadoclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		listadoclientes.setnombre_zona(listadoclientes.getnombre_zona().trim());
		listadoclientes.setnombre_ciudad(listadoclientes.getnombre_ciudad().trim());
		listadoclientes.setnombre_grupo_cliente(listadoclientes.getnombre_grupo_cliente().trim());
		listadoclientes.setcodigo(listadoclientes.getcodigo().trim());
		listadoclientes.setnombre(listadoclientes.getnombre().trim());
		listadoclientes.setapellido(listadoclientes.getapellido().trim());
		listadoclientes.setruc(listadoclientes.getruc().trim());
		listadoclientes.settelefonos(listadoclientes.gettelefonos().trim());
		listadoclientes.setdirecciones(listadoclientes.getdirecciones().trim());
		listadoclientes.setemails(listadoclientes.getemails().trim());
	}
	
	public static void quitarEspaciosListadoClientess(List<ListadoClientes> listadoclientess,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ListadoClientes listadoclientes: listadoclientess) {
			listadoclientes.setnombre_zona(listadoclientes.getnombre_zona().trim());
			listadoclientes.setnombre_ciudad(listadoclientes.getnombre_ciudad().trim());
			listadoclientes.setnombre_grupo_cliente(listadoclientes.getnombre_grupo_cliente().trim());
			listadoclientes.setcodigo(listadoclientes.getcodigo().trim());
			listadoclientes.setnombre(listadoclientes.getnombre().trim());
			listadoclientes.setapellido(listadoclientes.getapellido().trim());
			listadoclientes.setruc(listadoclientes.getruc().trim());
			listadoclientes.settelefonos(listadoclientes.gettelefonos().trim());
			listadoclientes.setdirecciones(listadoclientes.getdirecciones().trim());
			listadoclientes.setemails(listadoclientes.getemails().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresListadoClientes(ListadoClientes listadoclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && listadoclientes.getConCambioAuxiliar()) {
			listadoclientes.setIsDeleted(listadoclientes.getIsDeletedAuxiliar());	
			listadoclientes.setIsNew(listadoclientes.getIsNewAuxiliar());	
			listadoclientes.setIsChanged(listadoclientes.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			listadoclientes.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			listadoclientes.setIsDeletedAuxiliar(false);	
			listadoclientes.setIsNewAuxiliar(false);	
			listadoclientes.setIsChangedAuxiliar(false);
			
			listadoclientes.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresListadoClientess(List<ListadoClientes> listadoclientess,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ListadoClientes listadoclientes : listadoclientess) {
			if(conAsignarBase && listadoclientes.getConCambioAuxiliar()) {
				listadoclientes.setIsDeleted(listadoclientes.getIsDeletedAuxiliar());	
				listadoclientes.setIsNew(listadoclientes.getIsNewAuxiliar());	
				listadoclientes.setIsChanged(listadoclientes.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				listadoclientes.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				listadoclientes.setIsDeletedAuxiliar(false);	
				listadoclientes.setIsNewAuxiliar(false);	
				listadoclientes.setIsChangedAuxiliar(false);
				
				listadoclientes.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresListadoClientes(ListadoClientes listadoclientes,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresListadoClientess(List<ListadoClientes> listadoclientess,Boolean conEnteros) throws Exception  {
		
		for(ListadoClientes listadoclientes: listadoclientess) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaListadoClientes(List<ListadoClientes> listadoclientess,ListadoClientes listadoclientesAux) throws Exception  {
		ListadoClientesConstantesFunciones.InicializarValoresListadoClientes(listadoclientesAux,true);
		
		for(ListadoClientes listadoclientes: listadoclientess) {
			if(listadoclientes.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesListadoClientes(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ListadoClientesConstantesFunciones.getArrayColumnasGlobalesListadoClientes(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesListadoClientes(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ListadoClientesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ListadoClientesConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoListadoClientes(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ListadoClientes> listadoclientess,ListadoClientes listadoclientes,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ListadoClientes listadoclientesAux: listadoclientess) {
			if(listadoclientesAux!=null && listadoclientes!=null) {
				if((listadoclientesAux.getId()==null && listadoclientes.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(listadoclientesAux.getId()!=null && listadoclientes.getId()!=null){
					if(listadoclientesAux.getId().equals(listadoclientes.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaListadoClientes(List<ListadoClientes> listadoclientess) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ListadoClientes listadoclientes: listadoclientess) {			
			if(listadoclientes.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaListadoClientes() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ListadoClientesConstantesFunciones.LABEL_ID, ListadoClientesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoClientesConstantesFunciones.LABEL_VERSIONROW, ListadoClientesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoClientesConstantesFunciones.LABEL_NOMBREZONA, ListadoClientesConstantesFunciones.NOMBREZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoClientesConstantesFunciones.LABEL_NOMBRECIUDAD, ListadoClientesConstantesFunciones.NOMBRECIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoClientesConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE, ListadoClientesConstantesFunciones.NOMBREGRUPOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoClientesConstantesFunciones.LABEL_CODIGO, ListadoClientesConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoClientesConstantesFunciones.LABEL_NOMBRE, ListadoClientesConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoClientesConstantesFunciones.LABEL_APELLIDO, ListadoClientesConstantesFunciones.APELLIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoClientesConstantesFunciones.LABEL_RUC, ListadoClientesConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoClientesConstantesFunciones.LABEL_TELEFONOS, ListadoClientesConstantesFunciones.TELEFONOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoClientesConstantesFunciones.LABEL_DIRECCIONES, ListadoClientesConstantesFunciones.DIRECCIONES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoClientesConstantesFunciones.LABEL_EMAILS, ListadoClientesConstantesFunciones.EMAILS,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasListadoClientes() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ListadoClientesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoClientesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoClientesConstantesFunciones.NOMBREZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoClientesConstantesFunciones.NOMBRECIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoClientesConstantesFunciones.NOMBREGRUPOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoClientesConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoClientesConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoClientesConstantesFunciones.APELLIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoClientesConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoClientesConstantesFunciones.TELEFONOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoClientesConstantesFunciones.DIRECCIONES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoClientesConstantesFunciones.EMAILS;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadoClientes() throws Exception  {
		return ListadoClientesConstantesFunciones.getTiposSeleccionarListadoClientes(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadoClientes(Boolean conFk) throws Exception  {
		return ListadoClientesConstantesFunciones.getTiposSeleccionarListadoClientes(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadoClientes(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoClientesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ListadoClientesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoClientesConstantesFunciones.LABEL_NOMBREZONA);
			reporte.setsDescripcion(ListadoClientesConstantesFunciones.LABEL_NOMBREZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoClientesConstantesFunciones.LABEL_NOMBRECIUDAD);
			reporte.setsDescripcion(ListadoClientesConstantesFunciones.LABEL_NOMBRECIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoClientesConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);
			reporte.setsDescripcion(ListadoClientesConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoClientesConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ListadoClientesConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoClientesConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ListadoClientesConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoClientesConstantesFunciones.LABEL_APELLIDO);
			reporte.setsDescripcion(ListadoClientesConstantesFunciones.LABEL_APELLIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoClientesConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(ListadoClientesConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoClientesConstantesFunciones.LABEL_TELEFONOS);
			reporte.setsDescripcion(ListadoClientesConstantesFunciones.LABEL_TELEFONOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoClientesConstantesFunciones.LABEL_DIRECCIONES);
			reporte.setsDescripcion(ListadoClientesConstantesFunciones.LABEL_DIRECCIONES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoClientesConstantesFunciones.LABEL_EMAILS);
			reporte.setsDescripcion(ListadoClientesConstantesFunciones.LABEL_EMAILS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesListadoClientes(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesListadoClientes(ListadoClientes listadoclientesAux) throws Exception {
		
			listadoclientesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(listadoclientesAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesListadoClientes(List<ListadoClientes> listadoclientessTemp) throws Exception {
		for(ListadoClientes listadoclientesAux:listadoclientessTemp) {
			
			listadoclientesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(listadoclientesAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfListadoClientes(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfListadoClientes(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfListadoClientes(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ListadoClientesConstantesFunciones.getClassesRelationshipsOfListadoClientes(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfListadoClientes(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfListadoClientes(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ListadoClientesConstantesFunciones.getClassesRelationshipsFromStringsOfListadoClientes(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfListadoClientes(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ListadoClientes listadoclientes,List<ListadoClientes> listadoclientess,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ListadoClientes listadoclientes,List<ListadoClientes> listadoclientess) throws Exception {
		try	{			
			for(ListadoClientes listadoclientesLocal:listadoclientess) {
				if(listadoclientesLocal.getId().equals(listadoclientes.getId())) {
					listadoclientesLocal.setIsSelected(listadoclientes.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesListadoClientes(List<ListadoClientes> listadoclientessAux) throws Exception {
		//this.listadoclientessAux=listadoclientessAux;
		
		for(ListadoClientes listadoclientesAux:listadoclientessAux) {
			if(listadoclientesAux.getIsChanged()) {
				listadoclientesAux.setIsChanged(false);
			}		
			
			if(listadoclientesAux.getIsNew()) {
				listadoclientesAux.setIsNew(false);
			}	
			
			if(listadoclientesAux.getIsDeleted()) {
				listadoclientesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesListadoClientes(ListadoClientes listadoclientesAux) throws Exception {
		//this.listadoclientesAux=listadoclientesAux;
		
			if(listadoclientesAux.getIsChanged()) {
				listadoclientesAux.setIsChanged(false);
			}		
			
			if(listadoclientesAux.getIsNew()) {
				listadoclientesAux.setIsNew(false);
			}	
			
			if(listadoclientesAux.getIsDeleted()) {
				listadoclientesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ListadoClientes listadoclientesAsignar,ListadoClientes listadoclientes) throws Exception {
		listadoclientesAsignar.setId(listadoclientes.getId());	
		listadoclientesAsignar.setVersionRow(listadoclientes.getVersionRow());	
		listadoclientesAsignar.setnombre_zona(listadoclientes.getnombre_zona());	
		listadoclientesAsignar.setnombre_ciudad(listadoclientes.getnombre_ciudad());	
		listadoclientesAsignar.setnombre_grupo_cliente(listadoclientes.getnombre_grupo_cliente());	
		listadoclientesAsignar.setcodigo(listadoclientes.getcodigo());	
		listadoclientesAsignar.setnombre(listadoclientes.getnombre());	
		listadoclientesAsignar.setapellido(listadoclientes.getapellido());	
		listadoclientesAsignar.setruc(listadoclientes.getruc());	
		listadoclientesAsignar.settelefonos(listadoclientes.gettelefonos());	
		listadoclientesAsignar.setdirecciones(listadoclientes.getdirecciones());	
		listadoclientesAsignar.setemails(listadoclientes.getemails());	
	}
	
	public static void inicializarListadoClientes(ListadoClientes listadoclientes) throws Exception {
		try {
				listadoclientes.setId(0L);	
					
				listadoclientes.setnombre_zona("");	
				listadoclientes.setnombre_ciudad("");	
				listadoclientes.setnombre_grupo_cliente("");	
				listadoclientes.setcodigo("");	
				listadoclientes.setnombre("");	
				listadoclientes.setapellido("");	
				listadoclientes.setruc("");	
				listadoclientes.settelefonos("");	
				listadoclientes.setdirecciones("");	
				listadoclientes.setemails("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderListadoClientes(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoClientesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoClientesConstantesFunciones.LABEL_NOMBREZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoClientesConstantesFunciones.LABEL_NOMBRECIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoClientesConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoClientesConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoClientesConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoClientesConstantesFunciones.LABEL_APELLIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoClientesConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoClientesConstantesFunciones.LABEL_TELEFONOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoClientesConstantesFunciones.LABEL_DIRECCIONES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoClientesConstantesFunciones.LABEL_EMAILS);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataListadoClientes(String sTipo,Row row,Workbook workbook,ListadoClientes listadoclientes,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoclientes.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoclientes.getnombre_zona());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoclientes.getnombre_ciudad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoclientes.getnombre_grupo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoclientes.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoclientes.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoclientes.getapellido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoclientes.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoclientes.gettelefonos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoclientes.getdirecciones());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadoclientes.getemails());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryListadoClientes="";
	
	public String getsFinalQueryListadoClientes() {
		return this.sFinalQueryListadoClientes;
	}
	
	public void setsFinalQueryListadoClientes(String sFinalQueryListadoClientes) {
		this.sFinalQueryListadoClientes= sFinalQueryListadoClientes;
	}
	
	public Border resaltarSeleccionarListadoClientes=null;
	
	public Border setResaltarSeleccionarListadoClientes(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoClientesBeanSwingJInternalFrame listadoclientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//listadoclientesBeanSwingJInternalFrame.jTtoolBarListadoClientes.setBorder(borderResaltar);
		
		this.resaltarSeleccionarListadoClientes= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarListadoClientes() {
		return this.resaltarSeleccionarListadoClientes;
	}
	
	public void setResaltarSeleccionarListadoClientes(Border borderResaltarSeleccionarListadoClientes) {
		this.resaltarSeleccionarListadoClientes= borderResaltarSeleccionarListadoClientes;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridListadoClientes=null;
	public Boolean mostraridListadoClientes=true;
	public Boolean activaridListadoClientes=true;

	public Border resaltarid_empresaListadoClientes=null;
	public Boolean mostrarid_empresaListadoClientes=true;
	public Boolean activarid_empresaListadoClientes=true;
	public Boolean cargarid_empresaListadoClientes=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaListadoClientes=false;//ConEventDepend=true

	public Border resaltarnombre_zonaListadoClientes=null;
	public Boolean mostrarnombre_zonaListadoClientes=true;
	public Boolean activarnombre_zonaListadoClientes=true;

	public Border resaltarnombre_ciudadListadoClientes=null;
	public Boolean mostrarnombre_ciudadListadoClientes=true;
	public Boolean activarnombre_ciudadListadoClientes=true;

	public Border resaltarnombre_grupo_clienteListadoClientes=null;
	public Boolean mostrarnombre_grupo_clienteListadoClientes=true;
	public Boolean activarnombre_grupo_clienteListadoClientes=true;

	public Border resaltarcodigoListadoClientes=null;
	public Boolean mostrarcodigoListadoClientes=true;
	public Boolean activarcodigoListadoClientes=true;

	public Border resaltarnombreListadoClientes=null;
	public Boolean mostrarnombreListadoClientes=true;
	public Boolean activarnombreListadoClientes=true;

	public Border resaltarapellidoListadoClientes=null;
	public Boolean mostrarapellidoListadoClientes=true;
	public Boolean activarapellidoListadoClientes=true;

	public Border resaltarrucListadoClientes=null;
	public Boolean mostrarrucListadoClientes=true;
	public Boolean activarrucListadoClientes=true;

	public Border resaltartelefonosListadoClientes=null;
	public Boolean mostrartelefonosListadoClientes=true;
	public Boolean activartelefonosListadoClientes=true;

	public Border resaltardireccionesListadoClientes=null;
	public Boolean mostrardireccionesListadoClientes=true;
	public Boolean activardireccionesListadoClientes=true;

	public Border resaltaremailsListadoClientes=null;
	public Boolean mostraremailsListadoClientes=true;
	public Boolean activaremailsListadoClientes=true;

	
	

	public Border setResaltaridListadoClientes(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoClientesBeanSwingJInternalFrame listadoclientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoclientesBeanSwingJInternalFrame.jTtoolBarListadoClientes.setBorder(borderResaltar);
		
		this.resaltaridListadoClientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridListadoClientes() {
		return this.resaltaridListadoClientes;
	}

	public void setResaltaridListadoClientes(Border borderResaltar) {
		this.resaltaridListadoClientes= borderResaltar;
	}

	public Boolean getMostraridListadoClientes() {
		return this.mostraridListadoClientes;
	}

	public void setMostraridListadoClientes(Boolean mostraridListadoClientes) {
		this.mostraridListadoClientes= mostraridListadoClientes;
	}

	public Boolean getActivaridListadoClientes() {
		return this.activaridListadoClientes;
	}

	public void setActivaridListadoClientes(Boolean activaridListadoClientes) {
		this.activaridListadoClientes= activaridListadoClientes;
	}

	public Border setResaltarid_empresaListadoClientes(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoClientesBeanSwingJInternalFrame listadoclientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoclientesBeanSwingJInternalFrame.jTtoolBarListadoClientes.setBorder(borderResaltar);
		
		this.resaltarid_empresaListadoClientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaListadoClientes() {
		return this.resaltarid_empresaListadoClientes;
	}

	public void setResaltarid_empresaListadoClientes(Border borderResaltar) {
		this.resaltarid_empresaListadoClientes= borderResaltar;
	}

	public Boolean getMostrarid_empresaListadoClientes() {
		return this.mostrarid_empresaListadoClientes;
	}

	public void setMostrarid_empresaListadoClientes(Boolean mostrarid_empresaListadoClientes) {
		this.mostrarid_empresaListadoClientes= mostrarid_empresaListadoClientes;
	}

	public Boolean getActivarid_empresaListadoClientes() {
		return this.activarid_empresaListadoClientes;
	}

	public void setActivarid_empresaListadoClientes(Boolean activarid_empresaListadoClientes) {
		this.activarid_empresaListadoClientes= activarid_empresaListadoClientes;
	}

	public Boolean getCargarid_empresaListadoClientes() {
		return this.cargarid_empresaListadoClientes;
	}

	public void setCargarid_empresaListadoClientes(Boolean cargarid_empresaListadoClientes) {
		this.cargarid_empresaListadoClientes= cargarid_empresaListadoClientes;
	}

	public Border setResaltarnombre_zonaListadoClientes(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoClientesBeanSwingJInternalFrame listadoclientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoclientesBeanSwingJInternalFrame.jTtoolBarListadoClientes.setBorder(borderResaltar);
		
		this.resaltarnombre_zonaListadoClientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_zonaListadoClientes() {
		return this.resaltarnombre_zonaListadoClientes;
	}

	public void setResaltarnombre_zonaListadoClientes(Border borderResaltar) {
		this.resaltarnombre_zonaListadoClientes= borderResaltar;
	}

	public Boolean getMostrarnombre_zonaListadoClientes() {
		return this.mostrarnombre_zonaListadoClientes;
	}

	public void setMostrarnombre_zonaListadoClientes(Boolean mostrarnombre_zonaListadoClientes) {
		this.mostrarnombre_zonaListadoClientes= mostrarnombre_zonaListadoClientes;
	}

	public Boolean getActivarnombre_zonaListadoClientes() {
		return this.activarnombre_zonaListadoClientes;
	}

	public void setActivarnombre_zonaListadoClientes(Boolean activarnombre_zonaListadoClientes) {
		this.activarnombre_zonaListadoClientes= activarnombre_zonaListadoClientes;
	}

	public Border setResaltarnombre_ciudadListadoClientes(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoClientesBeanSwingJInternalFrame listadoclientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoclientesBeanSwingJInternalFrame.jTtoolBarListadoClientes.setBorder(borderResaltar);
		
		this.resaltarnombre_ciudadListadoClientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_ciudadListadoClientes() {
		return this.resaltarnombre_ciudadListadoClientes;
	}

	public void setResaltarnombre_ciudadListadoClientes(Border borderResaltar) {
		this.resaltarnombre_ciudadListadoClientes= borderResaltar;
	}

	public Boolean getMostrarnombre_ciudadListadoClientes() {
		return this.mostrarnombre_ciudadListadoClientes;
	}

	public void setMostrarnombre_ciudadListadoClientes(Boolean mostrarnombre_ciudadListadoClientes) {
		this.mostrarnombre_ciudadListadoClientes= mostrarnombre_ciudadListadoClientes;
	}

	public Boolean getActivarnombre_ciudadListadoClientes() {
		return this.activarnombre_ciudadListadoClientes;
	}

	public void setActivarnombre_ciudadListadoClientes(Boolean activarnombre_ciudadListadoClientes) {
		this.activarnombre_ciudadListadoClientes= activarnombre_ciudadListadoClientes;
	}

	public Border setResaltarnombre_grupo_clienteListadoClientes(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoClientesBeanSwingJInternalFrame listadoclientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoclientesBeanSwingJInternalFrame.jTtoolBarListadoClientes.setBorder(borderResaltar);
		
		this.resaltarnombre_grupo_clienteListadoClientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_grupo_clienteListadoClientes() {
		return this.resaltarnombre_grupo_clienteListadoClientes;
	}

	public void setResaltarnombre_grupo_clienteListadoClientes(Border borderResaltar) {
		this.resaltarnombre_grupo_clienteListadoClientes= borderResaltar;
	}

	public Boolean getMostrarnombre_grupo_clienteListadoClientes() {
		return this.mostrarnombre_grupo_clienteListadoClientes;
	}

	public void setMostrarnombre_grupo_clienteListadoClientes(Boolean mostrarnombre_grupo_clienteListadoClientes) {
		this.mostrarnombre_grupo_clienteListadoClientes= mostrarnombre_grupo_clienteListadoClientes;
	}

	public Boolean getActivarnombre_grupo_clienteListadoClientes() {
		return this.activarnombre_grupo_clienteListadoClientes;
	}

	public void setActivarnombre_grupo_clienteListadoClientes(Boolean activarnombre_grupo_clienteListadoClientes) {
		this.activarnombre_grupo_clienteListadoClientes= activarnombre_grupo_clienteListadoClientes;
	}

	public Border setResaltarcodigoListadoClientes(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoClientesBeanSwingJInternalFrame listadoclientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoclientesBeanSwingJInternalFrame.jTtoolBarListadoClientes.setBorder(borderResaltar);
		
		this.resaltarcodigoListadoClientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoListadoClientes() {
		return this.resaltarcodigoListadoClientes;
	}

	public void setResaltarcodigoListadoClientes(Border borderResaltar) {
		this.resaltarcodigoListadoClientes= borderResaltar;
	}

	public Boolean getMostrarcodigoListadoClientes() {
		return this.mostrarcodigoListadoClientes;
	}

	public void setMostrarcodigoListadoClientes(Boolean mostrarcodigoListadoClientes) {
		this.mostrarcodigoListadoClientes= mostrarcodigoListadoClientes;
	}

	public Boolean getActivarcodigoListadoClientes() {
		return this.activarcodigoListadoClientes;
	}

	public void setActivarcodigoListadoClientes(Boolean activarcodigoListadoClientes) {
		this.activarcodigoListadoClientes= activarcodigoListadoClientes;
	}

	public Border setResaltarnombreListadoClientes(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoClientesBeanSwingJInternalFrame listadoclientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoclientesBeanSwingJInternalFrame.jTtoolBarListadoClientes.setBorder(borderResaltar);
		
		this.resaltarnombreListadoClientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreListadoClientes() {
		return this.resaltarnombreListadoClientes;
	}

	public void setResaltarnombreListadoClientes(Border borderResaltar) {
		this.resaltarnombreListadoClientes= borderResaltar;
	}

	public Boolean getMostrarnombreListadoClientes() {
		return this.mostrarnombreListadoClientes;
	}

	public void setMostrarnombreListadoClientes(Boolean mostrarnombreListadoClientes) {
		this.mostrarnombreListadoClientes= mostrarnombreListadoClientes;
	}

	public Boolean getActivarnombreListadoClientes() {
		return this.activarnombreListadoClientes;
	}

	public void setActivarnombreListadoClientes(Boolean activarnombreListadoClientes) {
		this.activarnombreListadoClientes= activarnombreListadoClientes;
	}

	public Border setResaltarapellidoListadoClientes(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoClientesBeanSwingJInternalFrame listadoclientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoclientesBeanSwingJInternalFrame.jTtoolBarListadoClientes.setBorder(borderResaltar);
		
		this.resaltarapellidoListadoClientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidoListadoClientes() {
		return this.resaltarapellidoListadoClientes;
	}

	public void setResaltarapellidoListadoClientes(Border borderResaltar) {
		this.resaltarapellidoListadoClientes= borderResaltar;
	}

	public Boolean getMostrarapellidoListadoClientes() {
		return this.mostrarapellidoListadoClientes;
	}

	public void setMostrarapellidoListadoClientes(Boolean mostrarapellidoListadoClientes) {
		this.mostrarapellidoListadoClientes= mostrarapellidoListadoClientes;
	}

	public Boolean getActivarapellidoListadoClientes() {
		return this.activarapellidoListadoClientes;
	}

	public void setActivarapellidoListadoClientes(Boolean activarapellidoListadoClientes) {
		this.activarapellidoListadoClientes= activarapellidoListadoClientes;
	}

	public Border setResaltarrucListadoClientes(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoClientesBeanSwingJInternalFrame listadoclientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoclientesBeanSwingJInternalFrame.jTtoolBarListadoClientes.setBorder(borderResaltar);
		
		this.resaltarrucListadoClientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucListadoClientes() {
		return this.resaltarrucListadoClientes;
	}

	public void setResaltarrucListadoClientes(Border borderResaltar) {
		this.resaltarrucListadoClientes= borderResaltar;
	}

	public Boolean getMostrarrucListadoClientes() {
		return this.mostrarrucListadoClientes;
	}

	public void setMostrarrucListadoClientes(Boolean mostrarrucListadoClientes) {
		this.mostrarrucListadoClientes= mostrarrucListadoClientes;
	}

	public Boolean getActivarrucListadoClientes() {
		return this.activarrucListadoClientes;
	}

	public void setActivarrucListadoClientes(Boolean activarrucListadoClientes) {
		this.activarrucListadoClientes= activarrucListadoClientes;
	}

	public Border setResaltartelefonosListadoClientes(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoClientesBeanSwingJInternalFrame listadoclientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoclientesBeanSwingJInternalFrame.jTtoolBarListadoClientes.setBorder(borderResaltar);
		
		this.resaltartelefonosListadoClientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonosListadoClientes() {
		return this.resaltartelefonosListadoClientes;
	}

	public void setResaltartelefonosListadoClientes(Border borderResaltar) {
		this.resaltartelefonosListadoClientes= borderResaltar;
	}

	public Boolean getMostrartelefonosListadoClientes() {
		return this.mostrartelefonosListadoClientes;
	}

	public void setMostrartelefonosListadoClientes(Boolean mostrartelefonosListadoClientes) {
		this.mostrartelefonosListadoClientes= mostrartelefonosListadoClientes;
	}

	public Boolean getActivartelefonosListadoClientes() {
		return this.activartelefonosListadoClientes;
	}

	public void setActivartelefonosListadoClientes(Boolean activartelefonosListadoClientes) {
		this.activartelefonosListadoClientes= activartelefonosListadoClientes;
	}

	public Border setResaltardireccionesListadoClientes(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoClientesBeanSwingJInternalFrame listadoclientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoclientesBeanSwingJInternalFrame.jTtoolBarListadoClientes.setBorder(borderResaltar);
		
		this.resaltardireccionesListadoClientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionesListadoClientes() {
		return this.resaltardireccionesListadoClientes;
	}

	public void setResaltardireccionesListadoClientes(Border borderResaltar) {
		this.resaltardireccionesListadoClientes= borderResaltar;
	}

	public Boolean getMostrardireccionesListadoClientes() {
		return this.mostrardireccionesListadoClientes;
	}

	public void setMostrardireccionesListadoClientes(Boolean mostrardireccionesListadoClientes) {
		this.mostrardireccionesListadoClientes= mostrardireccionesListadoClientes;
	}

	public Boolean getActivardireccionesListadoClientes() {
		return this.activardireccionesListadoClientes;
	}

	public void setActivardireccionesListadoClientes(Boolean activardireccionesListadoClientes) {
		this.activardireccionesListadoClientes= activardireccionesListadoClientes;
	}

	public Border setResaltaremailsListadoClientes(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoClientesBeanSwingJInternalFrame listadoclientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadoclientesBeanSwingJInternalFrame.jTtoolBarListadoClientes.setBorder(borderResaltar);
		
		this.resaltaremailsListadoClientes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaremailsListadoClientes() {
		return this.resaltaremailsListadoClientes;
	}

	public void setResaltaremailsListadoClientes(Border borderResaltar) {
		this.resaltaremailsListadoClientes= borderResaltar;
	}

	public Boolean getMostraremailsListadoClientes() {
		return this.mostraremailsListadoClientes;
	}

	public void setMostraremailsListadoClientes(Boolean mostraremailsListadoClientes) {
		this.mostraremailsListadoClientes= mostraremailsListadoClientes;
	}

	public Boolean getActivaremailsListadoClientes() {
		return this.activaremailsListadoClientes;
	}

	public void setActivaremailsListadoClientes(Boolean activaremailsListadoClientes) {
		this.activaremailsListadoClientes= activaremailsListadoClientes;
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
		
		
		this.setMostraridListadoClientes(esInicial);
		this.setMostrarid_empresaListadoClientes(esInicial);
		this.setMostrarnombre_zonaListadoClientes(esInicial);
		this.setMostrarnombre_ciudadListadoClientes(esInicial);
		this.setMostrarnombre_grupo_clienteListadoClientes(esInicial);
		this.setMostrarcodigoListadoClientes(esInicial);
		this.setMostrarnombreListadoClientes(esInicial);
		this.setMostrarapellidoListadoClientes(esInicial);
		this.setMostrarrucListadoClientes(esInicial);
		this.setMostrartelefonosListadoClientes(esInicial);
		this.setMostrardireccionesListadoClientes(esInicial);
		this.setMostraremailsListadoClientes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadoClientesConstantesFunciones.ID)) {
				this.setMostraridListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.NOMBREZONA)) {
				this.setMostrarnombre_zonaListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.NOMBRECIUDAD)) {
				this.setMostrarnombre_ciudadListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setMostrarnombre_grupo_clienteListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.APELLIDO)) {
				this.setMostrarapellidoListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.RUC)) {
				this.setMostrarrucListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.TELEFONOS)) {
				this.setMostrartelefonosListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.DIRECCIONES)) {
				this.setMostrardireccionesListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.EMAILS)) {
				this.setMostraremailsListadoClientes(esAsigna);
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
		
		
		this.setActivaridListadoClientes(esInicial);
		this.setActivarid_empresaListadoClientes(esInicial);
		this.setActivarnombre_zonaListadoClientes(esInicial);
		this.setActivarnombre_ciudadListadoClientes(esInicial);
		this.setActivarnombre_grupo_clienteListadoClientes(esInicial);
		this.setActivarcodigoListadoClientes(esInicial);
		this.setActivarnombreListadoClientes(esInicial);
		this.setActivarapellidoListadoClientes(esInicial);
		this.setActivarrucListadoClientes(esInicial);
		this.setActivartelefonosListadoClientes(esInicial);
		this.setActivardireccionesListadoClientes(esInicial);
		this.setActivaremailsListadoClientes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadoClientesConstantesFunciones.ID)) {
				this.setActivaridListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.NOMBREZONA)) {
				this.setActivarnombre_zonaListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.NOMBRECIUDAD)) {
				this.setActivarnombre_ciudadListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setActivarnombre_grupo_clienteListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.CODIGO)) {
				this.setActivarcodigoListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.NOMBRE)) {
				this.setActivarnombreListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.APELLIDO)) {
				this.setActivarapellidoListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.RUC)) {
				this.setActivarrucListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.TELEFONOS)) {
				this.setActivartelefonosListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.DIRECCIONES)) {
				this.setActivardireccionesListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.EMAILS)) {
				this.setActivaremailsListadoClientes(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ListadoClientesBeanSwingJInternalFrame listadoclientesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridListadoClientes(esInicial);
		this.setResaltarid_empresaListadoClientes(esInicial);
		this.setResaltarnombre_zonaListadoClientes(esInicial);
		this.setResaltarnombre_ciudadListadoClientes(esInicial);
		this.setResaltarnombre_grupo_clienteListadoClientes(esInicial);
		this.setResaltarcodigoListadoClientes(esInicial);
		this.setResaltarnombreListadoClientes(esInicial);
		this.setResaltarapellidoListadoClientes(esInicial);
		this.setResaltarrucListadoClientes(esInicial);
		this.setResaltartelefonosListadoClientes(esInicial);
		this.setResaltardireccionesListadoClientes(esInicial);
		this.setResaltaremailsListadoClientes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadoClientesConstantesFunciones.ID)) {
				this.setResaltaridListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.NOMBREZONA)) {
				this.setResaltarnombre_zonaListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.NOMBRECIUDAD)) {
				this.setResaltarnombre_ciudadListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setResaltarnombre_grupo_clienteListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.APELLIDO)) {
				this.setResaltarapellidoListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.RUC)) {
				this.setResaltarrucListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.TELEFONOS)) {
				this.setResaltartelefonosListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.DIRECCIONES)) {
				this.setResaltardireccionesListadoClientes(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoClientesConstantesFunciones.EMAILS)) {
				this.setResaltaremailsListadoClientes(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ListadoClientesBeanSwingJInternalFrame listadoclientesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaListadoClientesListadoClientes=true;

	public Boolean getMostrarBusquedaListadoClientesListadoClientes() {
		return this.mostrarBusquedaListadoClientesListadoClientes;
	}

	public void setMostrarBusquedaListadoClientesListadoClientes(Boolean visibilidadResaltar) {
		this.mostrarBusquedaListadoClientesListadoClientes= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaListadoClientesListadoClientes=true;

	public Boolean getActivarBusquedaListadoClientesListadoClientes() {
		return this.activarBusquedaListadoClientesListadoClientes;
	}

	public void setActivarBusquedaListadoClientesListadoClientes(Boolean habilitarResaltar) {
		this.activarBusquedaListadoClientesListadoClientes= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaListadoClientesListadoClientes=null;

	public Border getResaltarBusquedaListadoClientesListadoClientes() {
		return this.resaltarBusquedaListadoClientesListadoClientes;
	}

	public void setResaltarBusquedaListadoClientesListadoClientes(Border borderResaltar) {
		this.resaltarBusquedaListadoClientesListadoClientes= borderResaltar;
	}

	public void setResaltarBusquedaListadoClientesListadoClientes(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoClientesBeanSwingJInternalFrame listadoclientesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaListadoClientesListadoClientes= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}