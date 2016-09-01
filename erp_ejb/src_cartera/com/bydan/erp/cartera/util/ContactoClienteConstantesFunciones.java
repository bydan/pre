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


import com.bydan.erp.cartera.util.ContactoClienteConstantesFunciones;
import com.bydan.erp.cartera.util.ContactoClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ContactoClienteParameterGeneral;

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
final public class ContactoClienteConstantesFunciones extends ContactoClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ContactoCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ContactoCliente"+ContactoClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ContactoClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ContactoClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ContactoClienteConstantesFunciones.SCHEMA+"_"+ContactoClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ContactoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ContactoClienteConstantesFunciones.SCHEMA+"_"+ContactoClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ContactoClienteConstantesFunciones.SCHEMA+"_"+ContactoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ContactoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ContactoClienteConstantesFunciones.SCHEMA+"_"+ContactoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ContactoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ContactoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ContactoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ContactoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ContactoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ContactoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ContactoClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ContactoClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ContactoClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ContactoClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Contacto Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Contacto Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Contacto Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ContactoCliente";
	public static final String OBJECTNAME="contactocliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="contacto_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select contactocliente from "+ContactoClienteConstantesFunciones.SPERSISTENCENAME+" contactocliente";
	public static String QUERYSELECTNATIVE="select "+ContactoClienteConstantesFunciones.SCHEMA+"."+ContactoClienteConstantesFunciones.TABLENAME+".id,"+ContactoClienteConstantesFunciones.SCHEMA+"."+ContactoClienteConstantesFunciones.TABLENAME+".version_row,"+ContactoClienteConstantesFunciones.SCHEMA+"."+ContactoClienteConstantesFunciones.TABLENAME+".id_empresa,"+ContactoClienteConstantesFunciones.SCHEMA+"."+ContactoClienteConstantesFunciones.TABLENAME+".id_sucursal,"+ContactoClienteConstantesFunciones.SCHEMA+"."+ContactoClienteConstantesFunciones.TABLENAME+".id_cliente,"+ContactoClienteConstantesFunciones.SCHEMA+"."+ContactoClienteConstantesFunciones.TABLENAME+".nombre_completo,"+ContactoClienteConstantesFunciones.SCHEMA+"."+ContactoClienteConstantesFunciones.TABLENAME+".ruc,"+ContactoClienteConstantesFunciones.SCHEMA+"."+ContactoClienteConstantesFunciones.TABLENAME+".direccion,"+ContactoClienteConstantesFunciones.SCHEMA+"."+ContactoClienteConstantesFunciones.TABLENAME+".telefono,"+ContactoClienteConstantesFunciones.SCHEMA+"."+ContactoClienteConstantesFunciones.TABLENAME+".telefono_celular,"+ContactoClienteConstantesFunciones.SCHEMA+"."+ContactoClienteConstantesFunciones.TABLENAME+".email,"+ContactoClienteConstantesFunciones.SCHEMA+"."+ContactoClienteConstantesFunciones.TABLENAME+".descripcion from "+ContactoClienteConstantesFunciones.SCHEMA+"."+ContactoClienteConstantesFunciones.TABLENAME;//+" as "+ContactoClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ContactoClienteConstantesFuncionesAdditional contactoclienteConstantesFuncionesAdditional=null;
	
	public ContactoClienteConstantesFuncionesAdditional getContactoClienteConstantesFuncionesAdditional() {
		return this.contactoclienteConstantesFuncionesAdditional;
	}
	
	public void setContactoClienteConstantesFuncionesAdditional(ContactoClienteConstantesFuncionesAdditional contactoclienteConstantesFuncionesAdditional) {
		try {
			this.contactoclienteConstantesFuncionesAdditional=contactoclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String RUC= "ruc";
    public static final String DIRECCION= "direccion";
    public static final String TELEFONO= "telefono";
    public static final String TELEFONOCELULAR= "telefono_celular";
    public static final String EMAIL= "email";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_TELEFONOCELULAR= "Telefono Celular";
		public static final String LABEL_TELEFONOCELULAR_LOWER= "Telefono Celular";
    	public static final String LABEL_EMAIL= "Email";
		public static final String LABEL_EMAIL_LOWER= "Email";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO_CELULAR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONO_CELULAR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXEMAIL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXEMAIL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getContactoClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ContactoClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=ContactoClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ContactoClienteConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ContactoClienteConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ContactoClienteConstantesFunciones.IDCLIENTE)) {sLabelColumna=ContactoClienteConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ContactoClienteConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=ContactoClienteConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(ContactoClienteConstantesFunciones.RUC)) {sLabelColumna=ContactoClienteConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(ContactoClienteConstantesFunciones.DIRECCION)) {sLabelColumna=ContactoClienteConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(ContactoClienteConstantesFunciones.TELEFONO)) {sLabelColumna=ContactoClienteConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(ContactoClienteConstantesFunciones.TELEFONOCELULAR)) {sLabelColumna=ContactoClienteConstantesFunciones.LABEL_TELEFONOCELULAR;}
		if(sNombreColumna.equals(ContactoClienteConstantesFunciones.EMAIL)) {sLabelColumna=ContactoClienteConstantesFunciones.LABEL_EMAIL;}
		if(sNombreColumna.equals(ContactoClienteConstantesFunciones.DESCRIPCION)) {sLabelColumna=ContactoClienteConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getContactoClienteDescripcion(ContactoCliente contactocliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(contactocliente !=null/* && contactocliente.getId()!=0*/) {
			if(contactocliente.getId()!=null) {
				sDescripcion=contactocliente.getId().toString();
			}//contactoclientecontactocliente.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getContactoClienteDescripcionDetallado(ContactoCliente contactocliente) {
		String sDescripcion="";
			
		sDescripcion+=ContactoClienteConstantesFunciones.ID+"=";
		sDescripcion+=contactocliente.getId().toString()+",";
		sDescripcion+=ContactoClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=contactocliente.getVersionRow().toString()+",";
		sDescripcion+=ContactoClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=contactocliente.getid_empresa().toString()+",";
		sDescripcion+=ContactoClienteConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=contactocliente.getid_sucursal().toString()+",";
		sDescripcion+=ContactoClienteConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=contactocliente.getid_cliente().toString()+",";
		sDescripcion+=ContactoClienteConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=contactocliente.getnombre_completo()+",";
		sDescripcion+=ContactoClienteConstantesFunciones.RUC+"=";
		sDescripcion+=contactocliente.getruc()+",";
		sDescripcion+=ContactoClienteConstantesFunciones.DIRECCION+"=";
		sDescripcion+=contactocliente.getdireccion()+",";
		sDescripcion+=ContactoClienteConstantesFunciones.TELEFONO+"=";
		sDescripcion+=contactocliente.gettelefono()+",";
		sDescripcion+=ContactoClienteConstantesFunciones.TELEFONOCELULAR+"=";
		sDescripcion+=contactocliente.gettelefono_celular()+",";
		sDescripcion+=ContactoClienteConstantesFunciones.EMAIL+"=";
		sDescripcion+=contactocliente.getemail()+",";
		sDescripcion+=ContactoClienteConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=contactocliente.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setContactoClienteDescripcion(ContactoCliente contactocliente,String sValor) throws Exception {			
		if(contactocliente !=null) {
			//contactoclientecontactocliente.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosContactoCliente(ContactoCliente contactocliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		contactocliente.setnombre_completo(contactocliente.getnombre_completo().trim());
		contactocliente.setruc(contactocliente.getruc().trim());
		contactocliente.setdireccion(contactocliente.getdireccion().trim());
		contactocliente.settelefono(contactocliente.gettelefono().trim());
		contactocliente.settelefono_celular(contactocliente.gettelefono_celular().trim());
		contactocliente.setemail(contactocliente.getemail().trim());
		contactocliente.setdescripcion(contactocliente.getdescripcion().trim());
	}
	
	public static void quitarEspaciosContactoClientes(List<ContactoCliente> contactoclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ContactoCliente contactocliente: contactoclientes) {
			contactocliente.setnombre_completo(contactocliente.getnombre_completo().trim());
			contactocliente.setruc(contactocliente.getruc().trim());
			contactocliente.setdireccion(contactocliente.getdireccion().trim());
			contactocliente.settelefono(contactocliente.gettelefono().trim());
			contactocliente.settelefono_celular(contactocliente.gettelefono_celular().trim());
			contactocliente.setemail(contactocliente.getemail().trim());
			contactocliente.setdescripcion(contactocliente.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresContactoCliente(ContactoCliente contactocliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && contactocliente.getConCambioAuxiliar()) {
			contactocliente.setIsDeleted(contactocliente.getIsDeletedAuxiliar());	
			contactocliente.setIsNew(contactocliente.getIsNewAuxiliar());	
			contactocliente.setIsChanged(contactocliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			contactocliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			contactocliente.setIsDeletedAuxiliar(false);	
			contactocliente.setIsNewAuxiliar(false);	
			contactocliente.setIsChangedAuxiliar(false);
			
			contactocliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresContactoClientes(List<ContactoCliente> contactoclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ContactoCliente contactocliente : contactoclientes) {
			if(conAsignarBase && contactocliente.getConCambioAuxiliar()) {
				contactocliente.setIsDeleted(contactocliente.getIsDeletedAuxiliar());	
				contactocliente.setIsNew(contactocliente.getIsNewAuxiliar());	
				contactocliente.setIsChanged(contactocliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				contactocliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				contactocliente.setIsDeletedAuxiliar(false);	
				contactocliente.setIsNewAuxiliar(false);	
				contactocliente.setIsChangedAuxiliar(false);
				
				contactocliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresContactoCliente(ContactoCliente contactocliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresContactoClientes(List<ContactoCliente> contactoclientes,Boolean conEnteros) throws Exception  {
		
		for(ContactoCliente contactocliente: contactoclientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaContactoCliente(List<ContactoCliente> contactoclientes,ContactoCliente contactoclienteAux) throws Exception  {
		ContactoClienteConstantesFunciones.InicializarValoresContactoCliente(contactoclienteAux,true);
		
		for(ContactoCliente contactocliente: contactoclientes) {
			if(contactocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesContactoCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ContactoClienteConstantesFunciones.getArrayColumnasGlobalesContactoCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesContactoCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ContactoClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ContactoClienteConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ContactoClienteConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ContactoClienteConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoContactoCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ContactoCliente> contactoclientes,ContactoCliente contactocliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ContactoCliente contactoclienteAux: contactoclientes) {
			if(contactoclienteAux!=null && contactocliente!=null) {
				if((contactoclienteAux.getId()==null && contactocliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(contactoclienteAux.getId()!=null && contactocliente.getId()!=null){
					if(contactoclienteAux.getId().equals(contactocliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaContactoCliente(List<ContactoCliente> contactoclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ContactoCliente contactocliente: contactoclientes) {			
			if(contactocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaContactoCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ContactoClienteConstantesFunciones.LABEL_ID, ContactoClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContactoClienteConstantesFunciones.LABEL_VERSIONROW, ContactoClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContactoClienteConstantesFunciones.LABEL_IDEMPRESA, ContactoClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContactoClienteConstantesFunciones.LABEL_IDSUCURSAL, ContactoClienteConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContactoClienteConstantesFunciones.LABEL_IDCLIENTE, ContactoClienteConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContactoClienteConstantesFunciones.LABEL_NOMBRECOMPLETO, ContactoClienteConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContactoClienteConstantesFunciones.LABEL_RUC, ContactoClienteConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContactoClienteConstantesFunciones.LABEL_DIRECCION, ContactoClienteConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContactoClienteConstantesFunciones.LABEL_TELEFONO, ContactoClienteConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContactoClienteConstantesFunciones.LABEL_TELEFONOCELULAR, ContactoClienteConstantesFunciones.TELEFONOCELULAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContactoClienteConstantesFunciones.LABEL_EMAIL, ContactoClienteConstantesFunciones.EMAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContactoClienteConstantesFunciones.LABEL_DESCRIPCION, ContactoClienteConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasContactoCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ContactoClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContactoClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContactoClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContactoClienteConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContactoClienteConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContactoClienteConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContactoClienteConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContactoClienteConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContactoClienteConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContactoClienteConstantesFunciones.TELEFONOCELULAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContactoClienteConstantesFunciones.EMAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContactoClienteConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarContactoCliente() throws Exception  {
		return ContactoClienteConstantesFunciones.getTiposSeleccionarContactoCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarContactoCliente(Boolean conFk) throws Exception  {
		return ContactoClienteConstantesFunciones.getTiposSeleccionarContactoCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarContactoCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ContactoClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ContactoClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ContactoClienteConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ContactoClienteConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ContactoClienteConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ContactoClienteConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ContactoClienteConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(ContactoClienteConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ContactoClienteConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(ContactoClienteConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ContactoClienteConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(ContactoClienteConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ContactoClienteConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(ContactoClienteConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ContactoClienteConstantesFunciones.LABEL_TELEFONOCELULAR);
			reporte.setsDescripcion(ContactoClienteConstantesFunciones.LABEL_TELEFONOCELULAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ContactoClienteConstantesFunciones.LABEL_EMAIL);
			reporte.setsDescripcion(ContactoClienteConstantesFunciones.LABEL_EMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ContactoClienteConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ContactoClienteConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesContactoCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesContactoCliente(ContactoCliente contactoclienteAux) throws Exception {
		
			contactoclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(contactoclienteAux.getEmpresa()));
			contactoclienteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(contactoclienteAux.getSucursal()));
			contactoclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(contactoclienteAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesContactoCliente(List<ContactoCliente> contactoclientesTemp) throws Exception {
		for(ContactoCliente contactoclienteAux:contactoclientesTemp) {
			
			contactoclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(contactoclienteAux.getEmpresa()));
			contactoclienteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(contactoclienteAux.getSucursal()));
			contactoclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(contactoclienteAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfContactoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfContactoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

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
	
	public static ArrayList<Classe> getClassesRelationshipsOfContactoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ContactoClienteConstantesFunciones.getClassesRelationshipsOfContactoCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfContactoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfContactoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ContactoClienteConstantesFunciones.getClassesRelationshipsFromStringsOfContactoCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfContactoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ContactoCliente contactocliente,List<ContactoCliente> contactoclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ContactoCliente contactoclienteEncontrado=null;
			
			for(ContactoCliente contactoclienteLocal:contactoclientes) {
				if(contactoclienteLocal.getId().equals(contactocliente.getId())) {
					contactoclienteEncontrado=contactoclienteLocal;
					
					contactoclienteLocal.setIsChanged(contactocliente.getIsChanged());
					contactoclienteLocal.setIsNew(contactocliente.getIsNew());
					contactoclienteLocal.setIsDeleted(contactocliente.getIsDeleted());
					
					contactoclienteLocal.setGeneralEntityOriginal(contactocliente.getGeneralEntityOriginal());
					
					contactoclienteLocal.setId(contactocliente.getId());	
					contactoclienteLocal.setVersionRow(contactocliente.getVersionRow());	
					contactoclienteLocal.setid_empresa(contactocliente.getid_empresa());	
					contactoclienteLocal.setid_sucursal(contactocliente.getid_sucursal());	
					contactoclienteLocal.setid_cliente(contactocliente.getid_cliente());	
					contactoclienteLocal.setnombre_completo(contactocliente.getnombre_completo());	
					contactoclienteLocal.setruc(contactocliente.getruc());	
					contactoclienteLocal.setdireccion(contactocliente.getdireccion());	
					contactoclienteLocal.settelefono(contactocliente.gettelefono());	
					contactoclienteLocal.settelefono_celular(contactocliente.gettelefono_celular());	
					contactoclienteLocal.setemail(contactocliente.getemail());	
					contactoclienteLocal.setdescripcion(contactocliente.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!contactocliente.getIsDeleted()) {
				if(!existe) {
					contactoclientes.add(contactocliente);
				}
			} else {
				if(contactoclienteEncontrado!=null && permiteQuitar)  {
					contactoclientes.remove(contactoclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ContactoCliente contactocliente,List<ContactoCliente> contactoclientes) throws Exception {
		try	{			
			for(ContactoCliente contactoclienteLocal:contactoclientes) {
				if(contactoclienteLocal.getId().equals(contactocliente.getId())) {
					contactoclienteLocal.setIsSelected(contactocliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesContactoCliente(List<ContactoCliente> contactoclientesAux) throws Exception {
		//this.contactoclientesAux=contactoclientesAux;
		
		for(ContactoCliente contactoclienteAux:contactoclientesAux) {
			if(contactoclienteAux.getIsChanged()) {
				contactoclienteAux.setIsChanged(false);
			}		
			
			if(contactoclienteAux.getIsNew()) {
				contactoclienteAux.setIsNew(false);
			}	
			
			if(contactoclienteAux.getIsDeleted()) {
				contactoclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesContactoCliente(ContactoCliente contactoclienteAux) throws Exception {
		//this.contactoclienteAux=contactoclienteAux;
		
			if(contactoclienteAux.getIsChanged()) {
				contactoclienteAux.setIsChanged(false);
			}		
			
			if(contactoclienteAux.getIsNew()) {
				contactoclienteAux.setIsNew(false);
			}	
			
			if(contactoclienteAux.getIsDeleted()) {
				contactoclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ContactoCliente contactoclienteAsignar,ContactoCliente contactocliente) throws Exception {
		contactoclienteAsignar.setId(contactocliente.getId());	
		contactoclienteAsignar.setVersionRow(contactocliente.getVersionRow());	
		contactoclienteAsignar.setid_empresa(contactocliente.getid_empresa());
		contactoclienteAsignar.setempresa_descripcion(contactocliente.getempresa_descripcion());	
		contactoclienteAsignar.setid_sucursal(contactocliente.getid_sucursal());
		contactoclienteAsignar.setsucursal_descripcion(contactocliente.getsucursal_descripcion());	
		contactoclienteAsignar.setid_cliente(contactocliente.getid_cliente());
		contactoclienteAsignar.setcliente_descripcion(contactocliente.getcliente_descripcion());	
		contactoclienteAsignar.setnombre_completo(contactocliente.getnombre_completo());	
		contactoclienteAsignar.setruc(contactocliente.getruc());	
		contactoclienteAsignar.setdireccion(contactocliente.getdireccion());	
		contactoclienteAsignar.settelefono(contactocliente.gettelefono());	
		contactoclienteAsignar.settelefono_celular(contactocliente.gettelefono_celular());	
		contactoclienteAsignar.setemail(contactocliente.getemail());	
		contactoclienteAsignar.setdescripcion(contactocliente.getdescripcion());	
	}
	
	public static void inicializarContactoCliente(ContactoCliente contactocliente) throws Exception {
		try {
				contactocliente.setId(0L);	
					
				contactocliente.setid_empresa(-1L);	
				contactocliente.setid_sucursal(-1L);	
				contactocliente.setid_cliente(-1L);	
				contactocliente.setnombre_completo("");	
				contactocliente.setruc("");	
				contactocliente.setdireccion("");	
				contactocliente.settelefono("");	
				contactocliente.settelefono_celular("");	
				contactocliente.setemail("");	
				contactocliente.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderContactoCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ContactoClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ContactoClienteConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ContactoClienteConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ContactoClienteConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ContactoClienteConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ContactoClienteConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ContactoClienteConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ContactoClienteConstantesFunciones.LABEL_TELEFONOCELULAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ContactoClienteConstantesFunciones.LABEL_EMAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ContactoClienteConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataContactoCliente(String sTipo,Row row,Workbook workbook,ContactoCliente contactocliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(contactocliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(contactocliente.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(contactocliente.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(contactocliente.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(contactocliente.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(contactocliente.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(contactocliente.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(contactocliente.gettelefono_celular());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(contactocliente.getemail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(contactocliente.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryContactoCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryContactoCliente() {
		return this.sFinalQueryContactoCliente;
	}
	
	public void setsFinalQueryContactoCliente(String sFinalQueryContactoCliente) {
		this.sFinalQueryContactoCliente= sFinalQueryContactoCliente;
	}
	
	public Border resaltarSeleccionarContactoCliente=null;
	
	public Border setResaltarSeleccionarContactoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ContactoClienteBeanSwingJInternalFrame contactoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//contactoclienteBeanSwingJInternalFrame.jTtoolBarContactoCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarContactoCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarContactoCliente() {
		return this.resaltarSeleccionarContactoCliente;
	}
	
	public void setResaltarSeleccionarContactoCliente(Border borderResaltarSeleccionarContactoCliente) {
		this.resaltarSeleccionarContactoCliente= borderResaltarSeleccionarContactoCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridContactoCliente=null;
	public Boolean mostraridContactoCliente=true;
	public Boolean activaridContactoCliente=true;

	public Border resaltarid_empresaContactoCliente=null;
	public Boolean mostrarid_empresaContactoCliente=true;
	public Boolean activarid_empresaContactoCliente=true;
	public Boolean cargarid_empresaContactoCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaContactoCliente=false;//ConEventDepend=true

	public Border resaltarid_sucursalContactoCliente=null;
	public Boolean mostrarid_sucursalContactoCliente=true;
	public Boolean activarid_sucursalContactoCliente=true;
	public Boolean cargarid_sucursalContactoCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalContactoCliente=false;//ConEventDepend=true

	public Border resaltarid_clienteContactoCliente=null;
	public Boolean mostrarid_clienteContactoCliente=true;
	public Boolean activarid_clienteContactoCliente=true;
	public Boolean cargarid_clienteContactoCliente=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteContactoCliente=false;//ConEventDepend=true

	public Border resaltarnombre_completoContactoCliente=null;
	public Boolean mostrarnombre_completoContactoCliente=true;
	public Boolean activarnombre_completoContactoCliente=true;

	public Border resaltarrucContactoCliente=null;
	public Boolean mostrarrucContactoCliente=true;
	public Boolean activarrucContactoCliente=true;

	public Border resaltardireccionContactoCliente=null;
	public Boolean mostrardireccionContactoCliente=true;
	public Boolean activardireccionContactoCliente=true;

	public Border resaltartelefonoContactoCliente=null;
	public Boolean mostrartelefonoContactoCliente=true;
	public Boolean activartelefonoContactoCliente=true;

	public Border resaltartelefono_celularContactoCliente=null;
	public Boolean mostrartelefono_celularContactoCliente=true;
	public Boolean activartelefono_celularContactoCliente=true;

	public Border resaltaremailContactoCliente=null;
	public Boolean mostraremailContactoCliente=true;
	public Boolean activaremailContactoCliente=true;

	public Border resaltardescripcionContactoCliente=null;
	public Boolean mostrardescripcionContactoCliente=true;
	public Boolean activardescripcionContactoCliente=true;

	
	

	public Border setResaltaridContactoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ContactoClienteBeanSwingJInternalFrame contactoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contactoclienteBeanSwingJInternalFrame.jTtoolBarContactoCliente.setBorder(borderResaltar);
		
		this.resaltaridContactoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridContactoCliente() {
		return this.resaltaridContactoCliente;
	}

	public void setResaltaridContactoCliente(Border borderResaltar) {
		this.resaltaridContactoCliente= borderResaltar;
	}

	public Boolean getMostraridContactoCliente() {
		return this.mostraridContactoCliente;
	}

	public void setMostraridContactoCliente(Boolean mostraridContactoCliente) {
		this.mostraridContactoCliente= mostraridContactoCliente;
	}

	public Boolean getActivaridContactoCliente() {
		return this.activaridContactoCliente;
	}

	public void setActivaridContactoCliente(Boolean activaridContactoCliente) {
		this.activaridContactoCliente= activaridContactoCliente;
	}

	public Border setResaltarid_empresaContactoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ContactoClienteBeanSwingJInternalFrame contactoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contactoclienteBeanSwingJInternalFrame.jTtoolBarContactoCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaContactoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaContactoCliente() {
		return this.resaltarid_empresaContactoCliente;
	}

	public void setResaltarid_empresaContactoCliente(Border borderResaltar) {
		this.resaltarid_empresaContactoCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaContactoCliente() {
		return this.mostrarid_empresaContactoCliente;
	}

	public void setMostrarid_empresaContactoCliente(Boolean mostrarid_empresaContactoCliente) {
		this.mostrarid_empresaContactoCliente= mostrarid_empresaContactoCliente;
	}

	public Boolean getActivarid_empresaContactoCliente() {
		return this.activarid_empresaContactoCliente;
	}

	public void setActivarid_empresaContactoCliente(Boolean activarid_empresaContactoCliente) {
		this.activarid_empresaContactoCliente= activarid_empresaContactoCliente;
	}

	public Boolean getCargarid_empresaContactoCliente() {
		return this.cargarid_empresaContactoCliente;
	}

	public void setCargarid_empresaContactoCliente(Boolean cargarid_empresaContactoCliente) {
		this.cargarid_empresaContactoCliente= cargarid_empresaContactoCliente;
	}

	public Border setResaltarid_sucursalContactoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ContactoClienteBeanSwingJInternalFrame contactoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contactoclienteBeanSwingJInternalFrame.jTtoolBarContactoCliente.setBorder(borderResaltar);
		
		this.resaltarid_sucursalContactoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalContactoCliente() {
		return this.resaltarid_sucursalContactoCliente;
	}

	public void setResaltarid_sucursalContactoCliente(Border borderResaltar) {
		this.resaltarid_sucursalContactoCliente= borderResaltar;
	}

	public Boolean getMostrarid_sucursalContactoCliente() {
		return this.mostrarid_sucursalContactoCliente;
	}

	public void setMostrarid_sucursalContactoCliente(Boolean mostrarid_sucursalContactoCliente) {
		this.mostrarid_sucursalContactoCliente= mostrarid_sucursalContactoCliente;
	}

	public Boolean getActivarid_sucursalContactoCliente() {
		return this.activarid_sucursalContactoCliente;
	}

	public void setActivarid_sucursalContactoCliente(Boolean activarid_sucursalContactoCliente) {
		this.activarid_sucursalContactoCliente= activarid_sucursalContactoCliente;
	}

	public Boolean getCargarid_sucursalContactoCliente() {
		return this.cargarid_sucursalContactoCliente;
	}

	public void setCargarid_sucursalContactoCliente(Boolean cargarid_sucursalContactoCliente) {
		this.cargarid_sucursalContactoCliente= cargarid_sucursalContactoCliente;
	}

	public Border setResaltarid_clienteContactoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ContactoClienteBeanSwingJInternalFrame contactoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contactoclienteBeanSwingJInternalFrame.jTtoolBarContactoCliente.setBorder(borderResaltar);
		
		this.resaltarid_clienteContactoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteContactoCliente() {
		return this.resaltarid_clienteContactoCliente;
	}

	public void setResaltarid_clienteContactoCliente(Border borderResaltar) {
		this.resaltarid_clienteContactoCliente= borderResaltar;
	}

	public Boolean getMostrarid_clienteContactoCliente() {
		return this.mostrarid_clienteContactoCliente;
	}

	public void setMostrarid_clienteContactoCliente(Boolean mostrarid_clienteContactoCliente) {
		this.mostrarid_clienteContactoCliente= mostrarid_clienteContactoCliente;
	}

	public Boolean getActivarid_clienteContactoCliente() {
		return this.activarid_clienteContactoCliente;
	}

	public void setActivarid_clienteContactoCliente(Boolean activarid_clienteContactoCliente) {
		this.activarid_clienteContactoCliente= activarid_clienteContactoCliente;
	}

	public Boolean getCargarid_clienteContactoCliente() {
		return this.cargarid_clienteContactoCliente;
	}

	public void setCargarid_clienteContactoCliente(Boolean cargarid_clienteContactoCliente) {
		this.cargarid_clienteContactoCliente= cargarid_clienteContactoCliente;
	}

	public Border setResaltarnombre_completoContactoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ContactoClienteBeanSwingJInternalFrame contactoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contactoclienteBeanSwingJInternalFrame.jTtoolBarContactoCliente.setBorder(borderResaltar);
		
		this.resaltarnombre_completoContactoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoContactoCliente() {
		return this.resaltarnombre_completoContactoCliente;
	}

	public void setResaltarnombre_completoContactoCliente(Border borderResaltar) {
		this.resaltarnombre_completoContactoCliente= borderResaltar;
	}

	public Boolean getMostrarnombre_completoContactoCliente() {
		return this.mostrarnombre_completoContactoCliente;
	}

	public void setMostrarnombre_completoContactoCliente(Boolean mostrarnombre_completoContactoCliente) {
		this.mostrarnombre_completoContactoCliente= mostrarnombre_completoContactoCliente;
	}

	public Boolean getActivarnombre_completoContactoCliente() {
		return this.activarnombre_completoContactoCliente;
	}

	public void setActivarnombre_completoContactoCliente(Boolean activarnombre_completoContactoCliente) {
		this.activarnombre_completoContactoCliente= activarnombre_completoContactoCliente;
	}

	public Border setResaltarrucContactoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ContactoClienteBeanSwingJInternalFrame contactoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contactoclienteBeanSwingJInternalFrame.jTtoolBarContactoCliente.setBorder(borderResaltar);
		
		this.resaltarrucContactoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucContactoCliente() {
		return this.resaltarrucContactoCliente;
	}

	public void setResaltarrucContactoCliente(Border borderResaltar) {
		this.resaltarrucContactoCliente= borderResaltar;
	}

	public Boolean getMostrarrucContactoCliente() {
		return this.mostrarrucContactoCliente;
	}

	public void setMostrarrucContactoCliente(Boolean mostrarrucContactoCliente) {
		this.mostrarrucContactoCliente= mostrarrucContactoCliente;
	}

	public Boolean getActivarrucContactoCliente() {
		return this.activarrucContactoCliente;
	}

	public void setActivarrucContactoCliente(Boolean activarrucContactoCliente) {
		this.activarrucContactoCliente= activarrucContactoCliente;
	}

	public Border setResaltardireccionContactoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ContactoClienteBeanSwingJInternalFrame contactoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contactoclienteBeanSwingJInternalFrame.jTtoolBarContactoCliente.setBorder(borderResaltar);
		
		this.resaltardireccionContactoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionContactoCliente() {
		return this.resaltardireccionContactoCliente;
	}

	public void setResaltardireccionContactoCliente(Border borderResaltar) {
		this.resaltardireccionContactoCliente= borderResaltar;
	}

	public Boolean getMostrardireccionContactoCliente() {
		return this.mostrardireccionContactoCliente;
	}

	public void setMostrardireccionContactoCliente(Boolean mostrardireccionContactoCliente) {
		this.mostrardireccionContactoCliente= mostrardireccionContactoCliente;
	}

	public Boolean getActivardireccionContactoCliente() {
		return this.activardireccionContactoCliente;
	}

	public void setActivardireccionContactoCliente(Boolean activardireccionContactoCliente) {
		this.activardireccionContactoCliente= activardireccionContactoCliente;
	}

	public Border setResaltartelefonoContactoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ContactoClienteBeanSwingJInternalFrame contactoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contactoclienteBeanSwingJInternalFrame.jTtoolBarContactoCliente.setBorder(borderResaltar);
		
		this.resaltartelefonoContactoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoContactoCliente() {
		return this.resaltartelefonoContactoCliente;
	}

	public void setResaltartelefonoContactoCliente(Border borderResaltar) {
		this.resaltartelefonoContactoCliente= borderResaltar;
	}

	public Boolean getMostrartelefonoContactoCliente() {
		return this.mostrartelefonoContactoCliente;
	}

	public void setMostrartelefonoContactoCliente(Boolean mostrartelefonoContactoCliente) {
		this.mostrartelefonoContactoCliente= mostrartelefonoContactoCliente;
	}

	public Boolean getActivartelefonoContactoCliente() {
		return this.activartelefonoContactoCliente;
	}

	public void setActivartelefonoContactoCliente(Boolean activartelefonoContactoCliente) {
		this.activartelefonoContactoCliente= activartelefonoContactoCliente;
	}

	public Border setResaltartelefono_celularContactoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ContactoClienteBeanSwingJInternalFrame contactoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contactoclienteBeanSwingJInternalFrame.jTtoolBarContactoCliente.setBorder(borderResaltar);
		
		this.resaltartelefono_celularContactoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_celularContactoCliente() {
		return this.resaltartelefono_celularContactoCliente;
	}

	public void setResaltartelefono_celularContactoCliente(Border borderResaltar) {
		this.resaltartelefono_celularContactoCliente= borderResaltar;
	}

	public Boolean getMostrartelefono_celularContactoCliente() {
		return this.mostrartelefono_celularContactoCliente;
	}

	public void setMostrartelefono_celularContactoCliente(Boolean mostrartelefono_celularContactoCliente) {
		this.mostrartelefono_celularContactoCliente= mostrartelefono_celularContactoCliente;
	}

	public Boolean getActivartelefono_celularContactoCliente() {
		return this.activartelefono_celularContactoCliente;
	}

	public void setActivartelefono_celularContactoCliente(Boolean activartelefono_celularContactoCliente) {
		this.activartelefono_celularContactoCliente= activartelefono_celularContactoCliente;
	}

	public Border setResaltaremailContactoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ContactoClienteBeanSwingJInternalFrame contactoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contactoclienteBeanSwingJInternalFrame.jTtoolBarContactoCliente.setBorder(borderResaltar);
		
		this.resaltaremailContactoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaremailContactoCliente() {
		return this.resaltaremailContactoCliente;
	}

	public void setResaltaremailContactoCliente(Border borderResaltar) {
		this.resaltaremailContactoCliente= borderResaltar;
	}

	public Boolean getMostraremailContactoCliente() {
		return this.mostraremailContactoCliente;
	}

	public void setMostraremailContactoCliente(Boolean mostraremailContactoCliente) {
		this.mostraremailContactoCliente= mostraremailContactoCliente;
	}

	public Boolean getActivaremailContactoCliente() {
		return this.activaremailContactoCliente;
	}

	public void setActivaremailContactoCliente(Boolean activaremailContactoCliente) {
		this.activaremailContactoCliente= activaremailContactoCliente;
	}

	public Border setResaltardescripcionContactoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ContactoClienteBeanSwingJInternalFrame contactoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//contactoclienteBeanSwingJInternalFrame.jTtoolBarContactoCliente.setBorder(borderResaltar);
		
		this.resaltardescripcionContactoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionContactoCliente() {
		return this.resaltardescripcionContactoCliente;
	}

	public void setResaltardescripcionContactoCliente(Border borderResaltar) {
		this.resaltardescripcionContactoCliente= borderResaltar;
	}

	public Boolean getMostrardescripcionContactoCliente() {
		return this.mostrardescripcionContactoCliente;
	}

	public void setMostrardescripcionContactoCliente(Boolean mostrardescripcionContactoCliente) {
		this.mostrardescripcionContactoCliente= mostrardescripcionContactoCliente;
	}

	public Boolean getActivardescripcionContactoCliente() {
		return this.activardescripcionContactoCliente;
	}

	public void setActivardescripcionContactoCliente(Boolean activardescripcionContactoCliente) {
		this.activardescripcionContactoCliente= activardescripcionContactoCliente;
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
		
		
		this.setMostraridContactoCliente(esInicial);
		this.setMostrarid_empresaContactoCliente(esInicial);
		this.setMostrarid_sucursalContactoCliente(esInicial);
		this.setMostrarid_clienteContactoCliente(esInicial);
		this.setMostrarnombre_completoContactoCliente(esInicial);
		this.setMostrarrucContactoCliente(esInicial);
		this.setMostrardireccionContactoCliente(esInicial);
		this.setMostrartelefonoContactoCliente(esInicial);
		this.setMostrartelefono_celularContactoCliente(esInicial);
		this.setMostraremailContactoCliente(esInicial);
		this.setMostrardescripcionContactoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ContactoClienteConstantesFunciones.ID)) {
				this.setMostraridContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.RUC)) {
				this.setMostrarrucContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.TELEFONOCELULAR)) {
				this.setMostrartelefono_celularContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.EMAIL)) {
				this.setMostraremailContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionContactoCliente(esAsigna);
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
		
		
		this.setActivaridContactoCliente(esInicial);
		this.setActivarid_empresaContactoCliente(esInicial);
		this.setActivarid_sucursalContactoCliente(esInicial);
		this.setActivarid_clienteContactoCliente(esInicial);
		this.setActivarnombre_completoContactoCliente(esInicial);
		this.setActivarrucContactoCliente(esInicial);
		this.setActivardireccionContactoCliente(esInicial);
		this.setActivartelefonoContactoCliente(esInicial);
		this.setActivartelefono_celularContactoCliente(esInicial);
		this.setActivaremailContactoCliente(esInicial);
		this.setActivardescripcionContactoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ContactoClienteConstantesFunciones.ID)) {
				this.setActivaridContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.RUC)) {
				this.setActivarrucContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.DIRECCION)) {
				this.setActivardireccionContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.TELEFONOCELULAR)) {
				this.setActivartelefono_celularContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.EMAIL)) {
				this.setActivaremailContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionContactoCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ContactoClienteBeanSwingJInternalFrame contactoclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridContactoCliente(esInicial);
		this.setResaltarid_empresaContactoCliente(esInicial);
		this.setResaltarid_sucursalContactoCliente(esInicial);
		this.setResaltarid_clienteContactoCliente(esInicial);
		this.setResaltarnombre_completoContactoCliente(esInicial);
		this.setResaltarrucContactoCliente(esInicial);
		this.setResaltardireccionContactoCliente(esInicial);
		this.setResaltartelefonoContactoCliente(esInicial);
		this.setResaltartelefono_celularContactoCliente(esInicial);
		this.setResaltaremailContactoCliente(esInicial);
		this.setResaltardescripcionContactoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ContactoClienteConstantesFunciones.ID)) {
				this.setResaltaridContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.RUC)) {
				this.setResaltarrucContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.TELEFONOCELULAR)) {
				this.setResaltartelefono_celularContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.EMAIL)) {
				this.setResaltaremailContactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContactoClienteConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionContactoCliente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ContactoClienteBeanSwingJInternalFrame contactoclienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteContactoCliente=true;

	public Boolean getMostrarFK_IdClienteContactoCliente() {
		return this.mostrarFK_IdClienteContactoCliente;
	}

	public void setMostrarFK_IdClienteContactoCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteContactoCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaContactoCliente=true;

	public Boolean getMostrarFK_IdEmpresaContactoCliente() {
		return this.mostrarFK_IdEmpresaContactoCliente;
	}

	public void setMostrarFK_IdEmpresaContactoCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaContactoCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalContactoCliente=true;

	public Boolean getMostrarFK_IdSucursalContactoCliente() {
		return this.mostrarFK_IdSucursalContactoCliente;
	}

	public void setMostrarFK_IdSucursalContactoCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalContactoCliente= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteContactoCliente=true;

	public Boolean getActivarFK_IdClienteContactoCliente() {
		return this.activarFK_IdClienteContactoCliente;
	}

	public void setActivarFK_IdClienteContactoCliente(Boolean habilitarResaltar) {
		this.activarFK_IdClienteContactoCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaContactoCliente=true;

	public Boolean getActivarFK_IdEmpresaContactoCliente() {
		return this.activarFK_IdEmpresaContactoCliente;
	}

	public void setActivarFK_IdEmpresaContactoCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaContactoCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalContactoCliente=true;

	public Boolean getActivarFK_IdSucursalContactoCliente() {
		return this.activarFK_IdSucursalContactoCliente;
	}

	public void setActivarFK_IdSucursalContactoCliente(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalContactoCliente= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteContactoCliente=null;

	public Border getResaltarFK_IdClienteContactoCliente() {
		return this.resaltarFK_IdClienteContactoCliente;
	}

	public void setResaltarFK_IdClienteContactoCliente(Border borderResaltar) {
		this.resaltarFK_IdClienteContactoCliente= borderResaltar;
	}

	public void setResaltarFK_IdClienteContactoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ContactoClienteBeanSwingJInternalFrame contactoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteContactoCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaContactoCliente=null;

	public Border getResaltarFK_IdEmpresaContactoCliente() {
		return this.resaltarFK_IdEmpresaContactoCliente;
	}

	public void setResaltarFK_IdEmpresaContactoCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaContactoCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaContactoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ContactoClienteBeanSwingJInternalFrame contactoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaContactoCliente= borderResaltar;
	}

	public Border resaltarFK_IdSucursalContactoCliente=null;

	public Border getResaltarFK_IdSucursalContactoCliente() {
		return this.resaltarFK_IdSucursalContactoCliente;
	}

	public void setResaltarFK_IdSucursalContactoCliente(Border borderResaltar) {
		this.resaltarFK_IdSucursalContactoCliente= borderResaltar;
	}

	public void setResaltarFK_IdSucursalContactoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ContactoClienteBeanSwingJInternalFrame contactoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalContactoCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}