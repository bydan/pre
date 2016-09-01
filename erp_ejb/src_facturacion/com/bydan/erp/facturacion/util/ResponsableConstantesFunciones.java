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


import com.bydan.erp.facturacion.util.ResponsableConstantesFunciones;
import com.bydan.erp.facturacion.util.ResponsableParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ResponsableParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ResponsableConstantesFunciones extends ResponsableConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Responsable";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Responsable"+ResponsableConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ResponsableHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ResponsableHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ResponsableConstantesFunciones.SCHEMA+"_"+ResponsableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ResponsableHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ResponsableConstantesFunciones.SCHEMA+"_"+ResponsableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ResponsableConstantesFunciones.SCHEMA+"_"+ResponsableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ResponsableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ResponsableConstantesFunciones.SCHEMA+"_"+ResponsableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResponsableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ResponsableHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResponsableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResponsableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ResponsableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ResponsableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ResponsableConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ResponsableConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ResponsableConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ResponsableConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Responsables";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Responsable";
	public static final String SCLASSWEBTITULO_LOWER="Responsable";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Responsable";
	public static final String OBJECTNAME="responsable";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="responsable";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select responsable from "+ResponsableConstantesFunciones.SPERSISTENCENAME+" responsable";
	public static String QUERYSELECTNATIVE="select "+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME+".id,"+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME+".version_row,"+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME+".id_empresa,"+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME+".id_sucursal,"+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME+".id_cliente,"+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME+".id_usuario,"+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME+".identificacion,"+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME+".ruc,"+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME+".nombre,"+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME+".apellido,"+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME+".nombre_completo,"+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME+".email,"+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME+".telefono,"+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME+".telefono_celular,"+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME+".direccion,"+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME+".fax,"+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME+".observacion from "+ResponsableConstantesFunciones.SCHEMA+"."+ResponsableConstantesFunciones.TABLENAME;//+" as "+ResponsableConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ResponsableConstantesFuncionesAdditional responsableConstantesFuncionesAdditional=null;
	
	public ResponsableConstantesFuncionesAdditional getResponsableConstantesFuncionesAdditional() {
		return this.responsableConstantesFuncionesAdditional;
	}
	
	public void setResponsableConstantesFuncionesAdditional(ResponsableConstantesFuncionesAdditional responsableConstantesFuncionesAdditional) {
		try {
			this.responsableConstantesFuncionesAdditional=responsableConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDENTIFICACION= "identificacion";
    public static final String RUC= "ruc";
    public static final String NOMBRE= "nombre";
    public static final String APELLIDO= "apellido";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String EMAIL= "email";
    public static final String TELEFONO= "telefono";
    public static final String TELEFONOCELULAR= "telefono_celular";
    public static final String DIRECCION= "direccion";
    public static final String FAX= "fax";
    public static final String OBSERVACION= "observacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDENTIFICACION= "Identificacion";
		public static final String LABEL_IDENTIFICACION_LOWER= "Identificacion";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_APELLIDO= "Apellido";
		public static final String LABEL_APELLIDO_LOWER= "Apellido";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_EMAIL= "Email";
		public static final String LABEL_EMAIL_LOWER= "Email";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_TELEFONOCELULAR= "Telefono Celular";
		public static final String LABEL_TELEFONOCELULAR_LOWER= "Telefono Celular";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_FAX= "Fax";
		public static final String LABEL_FAX_LOWER= "Fax";
    	public static final String LABEL_OBSERVACION= "Observacion";
		public static final String LABEL_OBSERVACION_LOWER= "Observacion";
	
		
		
		
		
		
		
	public static final String SREGEXIDENTIFICACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXIDENTIFICACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXEMAIL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXEMAIL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXTELEFONO_CELULAR=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO_CELULAR=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXFAX=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFAX=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXOBSERVACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getResponsableLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ResponsableConstantesFunciones.IDEMPRESA)) {sLabelColumna=ResponsableConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ResponsableConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ResponsableConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ResponsableConstantesFunciones.IDCLIENTE)) {sLabelColumna=ResponsableConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ResponsableConstantesFunciones.IDUSUARIO)) {sLabelColumna=ResponsableConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(ResponsableConstantesFunciones.IDENTIFICACION)) {sLabelColumna=ResponsableConstantesFunciones.LABEL_IDENTIFICACION;}
		if(sNombreColumna.equals(ResponsableConstantesFunciones.RUC)) {sLabelColumna=ResponsableConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(ResponsableConstantesFunciones.NOMBRE)) {sLabelColumna=ResponsableConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ResponsableConstantesFunciones.APELLIDO)) {sLabelColumna=ResponsableConstantesFunciones.LABEL_APELLIDO;}
		if(sNombreColumna.equals(ResponsableConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=ResponsableConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(ResponsableConstantesFunciones.EMAIL)) {sLabelColumna=ResponsableConstantesFunciones.LABEL_EMAIL;}
		if(sNombreColumna.equals(ResponsableConstantesFunciones.TELEFONO)) {sLabelColumna=ResponsableConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(ResponsableConstantesFunciones.TELEFONOCELULAR)) {sLabelColumna=ResponsableConstantesFunciones.LABEL_TELEFONOCELULAR;}
		if(sNombreColumna.equals(ResponsableConstantesFunciones.DIRECCION)) {sLabelColumna=ResponsableConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(ResponsableConstantesFunciones.FAX)) {sLabelColumna=ResponsableConstantesFunciones.LABEL_FAX;}
		if(sNombreColumna.equals(ResponsableConstantesFunciones.OBSERVACION)) {sLabelColumna=ResponsableConstantesFunciones.LABEL_OBSERVACION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getResponsableDescripcion(Responsable responsable) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(responsable !=null/* && responsable.getId()!=0*/) {
			sDescripcion=responsable.getnombre();//responsableresponsable.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getResponsableDescripcionDetallado(Responsable responsable) {
		String sDescripcion="";
			
		sDescripcion+=ResponsableConstantesFunciones.ID+"=";
		sDescripcion+=responsable.getId().toString()+",";
		sDescripcion+=ResponsableConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=responsable.getVersionRow().toString()+",";
		sDescripcion+=ResponsableConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=responsable.getid_empresa().toString()+",";
		sDescripcion+=ResponsableConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=responsable.getid_sucursal().toString()+",";
		sDescripcion+=ResponsableConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=responsable.getid_cliente().toString()+",";
		sDescripcion+=ResponsableConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=responsable.getid_usuario().toString()+",";
		sDescripcion+=ResponsableConstantesFunciones.IDENTIFICACION+"=";
		sDescripcion+=responsable.getidentificacion()+",";
		sDescripcion+=ResponsableConstantesFunciones.RUC+"=";
		sDescripcion+=responsable.getruc()+",";
		sDescripcion+=ResponsableConstantesFunciones.NOMBRE+"=";
		sDescripcion+=responsable.getnombre()+",";
		sDescripcion+=ResponsableConstantesFunciones.APELLIDO+"=";
		sDescripcion+=responsable.getapellido()+",";
		sDescripcion+=ResponsableConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=responsable.getnombre_completo()+",";
		sDescripcion+=ResponsableConstantesFunciones.EMAIL+"=";
		sDescripcion+=responsable.getemail()+",";
		sDescripcion+=ResponsableConstantesFunciones.TELEFONO+"=";
		sDescripcion+=responsable.gettelefono()+",";
		sDescripcion+=ResponsableConstantesFunciones.TELEFONOCELULAR+"=";
		sDescripcion+=responsable.gettelefono_celular()+",";
		sDescripcion+=ResponsableConstantesFunciones.DIRECCION+"=";
		sDescripcion+=responsable.getdireccion()+",";
		sDescripcion+=ResponsableConstantesFunciones.FAX+"=";
		sDescripcion+=responsable.getfax()+",";
		sDescripcion+=ResponsableConstantesFunciones.OBSERVACION+"=";
		sDescripcion+=responsable.getobservacion()+",";
			
		return sDescripcion;
	}
	
	public static void setResponsableDescripcion(Responsable responsable,String sValor) throws Exception {			
		if(responsable !=null) {
			responsable.setnombre(sValor);//responsableresponsable.getId().toString();
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdentificacion")) {
			sNombreIndice="Tipo=  Por Identificacion";
		} else if(sNombreIndice.equals("BusquedaPorNombreCompleto")) {
			sNombreIndice="Tipo=  Por Nombre Completo";
		} else if(sNombreIndice.equals("BusquedaPorRuc")) {
			sNombreIndice="Tipo=  Por Ruc";
		} else if(sNombreIndice.equals("BusquedaPorTelefono")) {
			sNombreIndice="Tipo=  Por Telefono";
		} else if(sNombreIndice.equals("BusquedaPorTelefonoCelular")) {
			sNombreIndice="Tipo=  Por Telefono Celular";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdentificacion(String identificacion) {
		String sDetalleIndice=" Parametros->";
		if(identificacion!=null) {sDetalleIndice+=" Identificacion="+identificacion;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombreCompleto(String nombre_completo) {
		String sDetalleIndice=" Parametros->";
		if(nombre_completo!=null) {sDetalleIndice+=" Nombre Completo="+nombre_completo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorRuc(String ruc) {
		String sDetalleIndice=" Parametros->";
		if(ruc!=null) {sDetalleIndice+=" Ruc="+ruc;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorTelefono(String telefono) {
		String sDetalleIndice=" Parametros->";
		if(telefono!=null) {sDetalleIndice+=" Telefono="+telefono;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorTelefonoCelular(String telefono_celular) {
		String sDetalleIndice=" Parametros->";
		if(telefono_celular!=null) {sDetalleIndice+=" Telefono Celular="+telefono_celular;} 

		return sDetalleIndice;
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

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosResponsable(Responsable responsable,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		responsable.setidentificacion(responsable.getidentificacion().trim());
		responsable.setruc(responsable.getruc().trim());
		responsable.setnombre(responsable.getnombre().trim());
		responsable.setapellido(responsable.getapellido().trim());
		responsable.setnombre_completo(responsable.getnombre_completo().trim());
		responsable.setemail(responsable.getemail().trim());
		responsable.settelefono(responsable.gettelefono().trim());
		responsable.settelefono_celular(responsable.gettelefono_celular().trim());
		responsable.setdireccion(responsable.getdireccion().trim());
		responsable.setfax(responsable.getfax().trim());
		responsable.setobservacion(responsable.getobservacion().trim());
	}
	
	public static void quitarEspaciosResponsables(List<Responsable> responsables,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Responsable responsable: responsables) {
			responsable.setidentificacion(responsable.getidentificacion().trim());
			responsable.setruc(responsable.getruc().trim());
			responsable.setnombre(responsable.getnombre().trim());
			responsable.setapellido(responsable.getapellido().trim());
			responsable.setnombre_completo(responsable.getnombre_completo().trim());
			responsable.setemail(responsable.getemail().trim());
			responsable.settelefono(responsable.gettelefono().trim());
			responsable.settelefono_celular(responsable.gettelefono_celular().trim());
			responsable.setdireccion(responsable.getdireccion().trim());
			responsable.setfax(responsable.getfax().trim());
			responsable.setobservacion(responsable.getobservacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresResponsable(Responsable responsable,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && responsable.getConCambioAuxiliar()) {
			responsable.setIsDeleted(responsable.getIsDeletedAuxiliar());	
			responsable.setIsNew(responsable.getIsNewAuxiliar());	
			responsable.setIsChanged(responsable.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			responsable.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			responsable.setIsDeletedAuxiliar(false);	
			responsable.setIsNewAuxiliar(false);	
			responsable.setIsChangedAuxiliar(false);
			
			responsable.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresResponsables(List<Responsable> responsables,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Responsable responsable : responsables) {
			if(conAsignarBase && responsable.getConCambioAuxiliar()) {
				responsable.setIsDeleted(responsable.getIsDeletedAuxiliar());	
				responsable.setIsNew(responsable.getIsNewAuxiliar());	
				responsable.setIsChanged(responsable.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				responsable.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				responsable.setIsDeletedAuxiliar(false);	
				responsable.setIsNewAuxiliar(false);	
				responsable.setIsChangedAuxiliar(false);
				
				responsable.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresResponsable(Responsable responsable,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresResponsables(List<Responsable> responsables,Boolean conEnteros) throws Exception  {
		
		for(Responsable responsable: responsables) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaResponsable(List<Responsable> responsables,Responsable responsableAux) throws Exception  {
		ResponsableConstantesFunciones.InicializarValoresResponsable(responsableAux,true);
		
		for(Responsable responsable: responsables) {
			if(responsable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesResponsable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ResponsableConstantesFunciones.getArrayColumnasGlobalesResponsable(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesResponsable(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ResponsableConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ResponsableConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ResponsableConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ResponsableConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ResponsableConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ResponsableConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoResponsable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Responsable> responsables,Responsable responsable,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Responsable responsableAux: responsables) {
			if(responsableAux!=null && responsable!=null) {
				if((responsableAux.getId()==null && responsable.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(responsableAux.getId()!=null && responsable.getId()!=null){
					if(responsableAux.getId().equals(responsable.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaResponsable(List<Responsable> responsables) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Responsable responsable: responsables) {			
			if(responsable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaResponsable() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ResponsableConstantesFunciones.LABEL_ID, ResponsableConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableConstantesFunciones.LABEL_VERSIONROW, ResponsableConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableConstantesFunciones.LABEL_IDEMPRESA, ResponsableConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableConstantesFunciones.LABEL_IDSUCURSAL, ResponsableConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableConstantesFunciones.LABEL_IDCLIENTE, ResponsableConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableConstantesFunciones.LABEL_IDUSUARIO, ResponsableConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableConstantesFunciones.LABEL_IDENTIFICACION, ResponsableConstantesFunciones.IDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableConstantesFunciones.LABEL_RUC, ResponsableConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableConstantesFunciones.LABEL_NOMBRE, ResponsableConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableConstantesFunciones.LABEL_APELLIDO, ResponsableConstantesFunciones.APELLIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableConstantesFunciones.LABEL_NOMBRECOMPLETO, ResponsableConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableConstantesFunciones.LABEL_EMAIL, ResponsableConstantesFunciones.EMAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableConstantesFunciones.LABEL_TELEFONO, ResponsableConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableConstantesFunciones.LABEL_TELEFONOCELULAR, ResponsableConstantesFunciones.TELEFONOCELULAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableConstantesFunciones.LABEL_DIRECCION, ResponsableConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableConstantesFunciones.LABEL_FAX, ResponsableConstantesFunciones.FAX,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ResponsableConstantesFunciones.LABEL_OBSERVACION, ResponsableConstantesFunciones.OBSERVACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasResponsable() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ResponsableConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableConstantesFunciones.IDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableConstantesFunciones.APELLIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableConstantesFunciones.EMAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableConstantesFunciones.TELEFONOCELULAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableConstantesFunciones.FAX;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ResponsableConstantesFunciones.OBSERVACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResponsable() throws Exception  {
		return ResponsableConstantesFunciones.getTiposSeleccionarResponsable(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResponsable(Boolean conFk) throws Exception  {
		return ResponsableConstantesFunciones.getTiposSeleccionarResponsable(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarResponsable(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ResponsableConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ResponsableConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ResponsableConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(ResponsableConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableConstantesFunciones.LABEL_IDENTIFICACION);
			reporte.setsDescripcion(ResponsableConstantesFunciones.LABEL_IDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(ResponsableConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ResponsableConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableConstantesFunciones.LABEL_APELLIDO);
			reporte.setsDescripcion(ResponsableConstantesFunciones.LABEL_APELLIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(ResponsableConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableConstantesFunciones.LABEL_EMAIL);
			reporte.setsDescripcion(ResponsableConstantesFunciones.LABEL_EMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(ResponsableConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableConstantesFunciones.LABEL_TELEFONOCELULAR);
			reporte.setsDescripcion(ResponsableConstantesFunciones.LABEL_TELEFONOCELULAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(ResponsableConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableConstantesFunciones.LABEL_FAX);
			reporte.setsDescripcion(ResponsableConstantesFunciones.LABEL_FAX);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ResponsableConstantesFunciones.LABEL_OBSERVACION);
			reporte.setsDescripcion(ResponsableConstantesFunciones.LABEL_OBSERVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesResponsable(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesResponsable(Responsable responsableAux) throws Exception {
		
			responsableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(responsableAux.getEmpresa()));
			responsableAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(responsableAux.getSucursal()));
			responsableAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(responsableAux.getCliente()));
			responsableAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(responsableAux.getUsuario()));		
	}
	
	public static void refrescarForeignKeysDescripcionesResponsable(List<Responsable> responsablesTemp) throws Exception {
		for(Responsable responsableAux:responsablesTemp) {
			
			responsableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(responsableAux.getEmpresa()));
			responsableAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(responsableAux.getSucursal()));
			responsableAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(responsableAux.getCliente()));
			responsableAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(responsableAux.getUsuario()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfResponsable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Usuario.class));
				
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfResponsable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfResponsable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ResponsableConstantesFunciones.getClassesRelationshipsOfResponsable(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfResponsable(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(Consignacion.class));
				classes.add(new Classe(NotaCredito.class));
				classes.add(new Classe(PedidoExpor.class));
				classes.add(new Classe(Pedido.class));
				classes.add(new Classe(NotaCreditoSoli.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Consignacion.class)) {
						classes.add(new Classe(Consignacion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NotaCredito.class)) {
						classes.add(new Classe(NotaCredito.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoExpor.class)) {
						classes.add(new Classe(PedidoExpor.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pedido.class)) {
						classes.add(new Classe(Pedido.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NotaCreditoSoli.class)) {
						classes.add(new Classe(NotaCreditoSoli.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfResponsable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ResponsableConstantesFunciones.getClassesRelationshipsFromStringsOfResponsable(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfResponsable(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Consignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignacion.class)); continue;
					}

					if(NotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCredito.class)); continue;
					}

					if(PedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoExpor.class)); continue;
					}

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
					}

					if(NotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoSoli.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Consignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignacion.class)); continue;
					}

					if(NotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCredito.class)); continue;
					}

					if(PedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoExpor.class)); continue;
					}

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
					}

					if(NotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoSoli.class)); continue;
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
	public static void actualizarLista(Responsable responsable,List<Responsable> responsables,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Responsable responsableEncontrado=null;
			
			for(Responsable responsableLocal:responsables) {
				if(responsableLocal.getId().equals(responsable.getId())) {
					responsableEncontrado=responsableLocal;
					
					responsableLocal.setIsChanged(responsable.getIsChanged());
					responsableLocal.setIsNew(responsable.getIsNew());
					responsableLocal.setIsDeleted(responsable.getIsDeleted());
					
					responsableLocal.setGeneralEntityOriginal(responsable.getGeneralEntityOriginal());
					
					responsableLocal.setId(responsable.getId());	
					responsableLocal.setVersionRow(responsable.getVersionRow());	
					responsableLocal.setid_empresa(responsable.getid_empresa());	
					responsableLocal.setid_sucursal(responsable.getid_sucursal());	
					responsableLocal.setid_cliente(responsable.getid_cliente());	
					responsableLocal.setid_usuario(responsable.getid_usuario());	
					responsableLocal.setidentificacion(responsable.getidentificacion());	
					responsableLocal.setruc(responsable.getruc());	
					responsableLocal.setnombre(responsable.getnombre());	
					responsableLocal.setapellido(responsable.getapellido());	
					responsableLocal.setnombre_completo(responsable.getnombre_completo());	
					responsableLocal.setemail(responsable.getemail());	
					responsableLocal.settelefono(responsable.gettelefono());	
					responsableLocal.settelefono_celular(responsable.gettelefono_celular());	
					responsableLocal.setdireccion(responsable.getdireccion());	
					responsableLocal.setfax(responsable.getfax());	
					responsableLocal.setobservacion(responsable.getobservacion());	
					
					
					responsableLocal.setFacturas(responsable.getFacturas());
					responsableLocal.setConsignacions(responsable.getConsignacions());
					responsableLocal.setPedidos(responsable.getPedidos());
					responsableLocal.setPedidoExpors(responsable.getPedidoExpors());
					responsableLocal.setNotaCreditoSolis(responsable.getNotaCreditoSolis());
					
					existe=true;
					break;
				}
			}
			
			if(!responsable.getIsDeleted()) {
				if(!existe) {
					responsables.add(responsable);
				}
			} else {
				if(responsableEncontrado!=null && permiteQuitar)  {
					responsables.remove(responsableEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Responsable responsable,List<Responsable> responsables) throws Exception {
		try	{			
			for(Responsable responsableLocal:responsables) {
				if(responsableLocal.getId().equals(responsable.getId())) {
					responsableLocal.setIsSelected(responsable.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesResponsable(List<Responsable> responsablesAux) throws Exception {
		//this.responsablesAux=responsablesAux;
		
		for(Responsable responsableAux:responsablesAux) {
			if(responsableAux.getIsChanged()) {
				responsableAux.setIsChanged(false);
			}		
			
			if(responsableAux.getIsNew()) {
				responsableAux.setIsNew(false);
			}	
			
			if(responsableAux.getIsDeleted()) {
				responsableAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesResponsable(Responsable responsableAux) throws Exception {
		//this.responsableAux=responsableAux;
		
			if(responsableAux.getIsChanged()) {
				responsableAux.setIsChanged(false);
			}		
			
			if(responsableAux.getIsNew()) {
				responsableAux.setIsNew(false);
			}	
			
			if(responsableAux.getIsDeleted()) {
				responsableAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Responsable responsableAsignar,Responsable responsable) throws Exception {
		responsableAsignar.setId(responsable.getId());	
		responsableAsignar.setVersionRow(responsable.getVersionRow());	
		responsableAsignar.setid_empresa(responsable.getid_empresa());
		responsableAsignar.setempresa_descripcion(responsable.getempresa_descripcion());	
		responsableAsignar.setid_sucursal(responsable.getid_sucursal());
		responsableAsignar.setsucursal_descripcion(responsable.getsucursal_descripcion());	
		responsableAsignar.setid_cliente(responsable.getid_cliente());
		responsableAsignar.setcliente_descripcion(responsable.getcliente_descripcion());	
		responsableAsignar.setid_usuario(responsable.getid_usuario());
		responsableAsignar.setusuario_descripcion(responsable.getusuario_descripcion());	
		responsableAsignar.setidentificacion(responsable.getidentificacion());	
		responsableAsignar.setruc(responsable.getruc());	
		responsableAsignar.setnombre(responsable.getnombre());	
		responsableAsignar.setapellido(responsable.getapellido());	
		responsableAsignar.setnombre_completo(responsable.getnombre_completo());	
		responsableAsignar.setemail(responsable.getemail());	
		responsableAsignar.settelefono(responsable.gettelefono());	
		responsableAsignar.settelefono_celular(responsable.gettelefono_celular());	
		responsableAsignar.setdireccion(responsable.getdireccion());	
		responsableAsignar.setfax(responsable.getfax());	
		responsableAsignar.setobservacion(responsable.getobservacion());	
	}
	
	public static void inicializarResponsable(Responsable responsable) throws Exception {
		try {
				responsable.setId(0L);	
					
				responsable.setid_empresa(-1L);	
				responsable.setid_sucursal(-1L);	
				responsable.setid_cliente(-1L);	
				responsable.setid_usuario(-1L);	
				responsable.setidentificacion("");	
				responsable.setruc("");	
				responsable.setnombre("");	
				responsable.setapellido("");	
				responsable.setnombre_completo("");	
				responsable.setemail("");	
				responsable.settelefono("");	
				responsable.settelefono_celular("");	
				responsable.setdireccion("");	
				responsable.setfax("");	
				responsable.setobservacion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderResponsable(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableConstantesFunciones.LABEL_IDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableConstantesFunciones.LABEL_APELLIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableConstantesFunciones.LABEL_EMAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableConstantesFunciones.LABEL_TELEFONOCELULAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableConstantesFunciones.LABEL_FAX);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ResponsableConstantesFunciones.LABEL_OBSERVACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataResponsable(String sTipo,Row row,Workbook workbook,Responsable responsable,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(responsable.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsable.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsable.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsable.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsable.getidentificacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsable.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsable.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsable.getapellido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsable.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsable.getemail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsable.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsable.gettelefono_celular());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsable.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsable.getfax());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(responsable.getobservacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryResponsable=Constantes.SFINALQUERY;
	
	public String getsFinalQueryResponsable() {
		return this.sFinalQueryResponsable;
	}
	
	public void setsFinalQueryResponsable(String sFinalQueryResponsable) {
		this.sFinalQueryResponsable= sFinalQueryResponsable;
	}
	
	public Border resaltarSeleccionarResponsable=null;
	
	public Border setResaltarSeleccionarResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltar);
		
		this.resaltarSeleccionarResponsable= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarResponsable() {
		return this.resaltarSeleccionarResponsable;
	}
	
	public void setResaltarSeleccionarResponsable(Border borderResaltarSeleccionarResponsable) {
		this.resaltarSeleccionarResponsable= borderResaltarSeleccionarResponsable;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridResponsable=null;
	public Boolean mostraridResponsable=true;
	public Boolean activaridResponsable=true;

	public Border resaltarid_empresaResponsable=null;
	public Boolean mostrarid_empresaResponsable=true;
	public Boolean activarid_empresaResponsable=true;
	public Boolean cargarid_empresaResponsable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaResponsable=false;//ConEventDepend=true

	public Border resaltarid_sucursalResponsable=null;
	public Boolean mostrarid_sucursalResponsable=true;
	public Boolean activarid_sucursalResponsable=true;
	public Boolean cargarid_sucursalResponsable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalResponsable=false;//ConEventDepend=true

	public Border resaltarid_clienteResponsable=null;
	public Boolean mostrarid_clienteResponsable=true;
	public Boolean activarid_clienteResponsable=true;
	public Boolean cargarid_clienteResponsable=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteResponsable=false;//ConEventDepend=true

	public Border resaltarid_usuarioResponsable=null;
	public Boolean mostrarid_usuarioResponsable=true;
	public Boolean activarid_usuarioResponsable=true;
	public Boolean cargarid_usuarioResponsable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioResponsable=false;//ConEventDepend=true

	public Border resaltaridentificacionResponsable=null;
	public Boolean mostraridentificacionResponsable=true;
	public Boolean activaridentificacionResponsable=true;

	public Border resaltarrucResponsable=null;
	public Boolean mostrarrucResponsable=true;
	public Boolean activarrucResponsable=true;

	public Border resaltarnombreResponsable=null;
	public Boolean mostrarnombreResponsable=true;
	public Boolean activarnombreResponsable=true;

	public Border resaltarapellidoResponsable=null;
	public Boolean mostrarapellidoResponsable=true;
	public Boolean activarapellidoResponsable=true;

	public Border resaltarnombre_completoResponsable=null;
	public Boolean mostrarnombre_completoResponsable=true;
	public Boolean activarnombre_completoResponsable=false;

	public Border resaltaremailResponsable=null;
	public Boolean mostraremailResponsable=true;
	public Boolean activaremailResponsable=true;

	public Border resaltartelefonoResponsable=null;
	public Boolean mostrartelefonoResponsable=true;
	public Boolean activartelefonoResponsable=true;

	public Border resaltartelefono_celularResponsable=null;
	public Boolean mostrartelefono_celularResponsable=true;
	public Boolean activartelefono_celularResponsable=true;

	public Border resaltardireccionResponsable=null;
	public Boolean mostrardireccionResponsable=true;
	public Boolean activardireccionResponsable=true;

	public Border resaltarfaxResponsable=null;
	public Boolean mostrarfaxResponsable=true;
	public Boolean activarfaxResponsable=true;

	public Border resaltarobservacionResponsable=null;
	public Boolean mostrarobservacionResponsable=true;
	public Boolean activarobservacionResponsable=true;

	
	

	public Border setResaltaridResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltar);
		
		this.resaltaridResponsable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridResponsable() {
		return this.resaltaridResponsable;
	}

	public void setResaltaridResponsable(Border borderResaltar) {
		this.resaltaridResponsable= borderResaltar;
	}

	public Boolean getMostraridResponsable() {
		return this.mostraridResponsable;
	}

	public void setMostraridResponsable(Boolean mostraridResponsable) {
		this.mostraridResponsable= mostraridResponsable;
	}

	public Boolean getActivaridResponsable() {
		return this.activaridResponsable;
	}

	public void setActivaridResponsable(Boolean activaridResponsable) {
		this.activaridResponsable= activaridResponsable;
	}

	public Border setResaltarid_empresaResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltar);
		
		this.resaltarid_empresaResponsable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaResponsable() {
		return this.resaltarid_empresaResponsable;
	}

	public void setResaltarid_empresaResponsable(Border borderResaltar) {
		this.resaltarid_empresaResponsable= borderResaltar;
	}

	public Boolean getMostrarid_empresaResponsable() {
		return this.mostrarid_empresaResponsable;
	}

	public void setMostrarid_empresaResponsable(Boolean mostrarid_empresaResponsable) {
		this.mostrarid_empresaResponsable= mostrarid_empresaResponsable;
	}

	public Boolean getActivarid_empresaResponsable() {
		return this.activarid_empresaResponsable;
	}

	public void setActivarid_empresaResponsable(Boolean activarid_empresaResponsable) {
		this.activarid_empresaResponsable= activarid_empresaResponsable;
	}

	public Boolean getCargarid_empresaResponsable() {
		return this.cargarid_empresaResponsable;
	}

	public void setCargarid_empresaResponsable(Boolean cargarid_empresaResponsable) {
		this.cargarid_empresaResponsable= cargarid_empresaResponsable;
	}

	public Border setResaltarid_sucursalResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltar);
		
		this.resaltarid_sucursalResponsable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalResponsable() {
		return this.resaltarid_sucursalResponsable;
	}

	public void setResaltarid_sucursalResponsable(Border borderResaltar) {
		this.resaltarid_sucursalResponsable= borderResaltar;
	}

	public Boolean getMostrarid_sucursalResponsable() {
		return this.mostrarid_sucursalResponsable;
	}

	public void setMostrarid_sucursalResponsable(Boolean mostrarid_sucursalResponsable) {
		this.mostrarid_sucursalResponsable= mostrarid_sucursalResponsable;
	}

	public Boolean getActivarid_sucursalResponsable() {
		return this.activarid_sucursalResponsable;
	}

	public void setActivarid_sucursalResponsable(Boolean activarid_sucursalResponsable) {
		this.activarid_sucursalResponsable= activarid_sucursalResponsable;
	}

	public Boolean getCargarid_sucursalResponsable() {
		return this.cargarid_sucursalResponsable;
	}

	public void setCargarid_sucursalResponsable(Boolean cargarid_sucursalResponsable) {
		this.cargarid_sucursalResponsable= cargarid_sucursalResponsable;
	}

	public Border setResaltarid_clienteResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltar);
		
		this.resaltarid_clienteResponsable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteResponsable() {
		return this.resaltarid_clienteResponsable;
	}

	public void setResaltarid_clienteResponsable(Border borderResaltar) {
		this.resaltarid_clienteResponsable= borderResaltar;
	}

	public Boolean getMostrarid_clienteResponsable() {
		return this.mostrarid_clienteResponsable;
	}

	public void setMostrarid_clienteResponsable(Boolean mostrarid_clienteResponsable) {
		this.mostrarid_clienteResponsable= mostrarid_clienteResponsable;
	}

	public Boolean getActivarid_clienteResponsable() {
		return this.activarid_clienteResponsable;
	}

	public void setActivarid_clienteResponsable(Boolean activarid_clienteResponsable) {
		this.activarid_clienteResponsable= activarid_clienteResponsable;
	}

	public Boolean getCargarid_clienteResponsable() {
		return this.cargarid_clienteResponsable;
	}

	public void setCargarid_clienteResponsable(Boolean cargarid_clienteResponsable) {
		this.cargarid_clienteResponsable= cargarid_clienteResponsable;
	}

	public Border setResaltarid_usuarioResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltar);
		
		this.resaltarid_usuarioResponsable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioResponsable() {
		return this.resaltarid_usuarioResponsable;
	}

	public void setResaltarid_usuarioResponsable(Border borderResaltar) {
		this.resaltarid_usuarioResponsable= borderResaltar;
	}

	public Boolean getMostrarid_usuarioResponsable() {
		return this.mostrarid_usuarioResponsable;
	}

	public void setMostrarid_usuarioResponsable(Boolean mostrarid_usuarioResponsable) {
		this.mostrarid_usuarioResponsable= mostrarid_usuarioResponsable;
	}

	public Boolean getActivarid_usuarioResponsable() {
		return this.activarid_usuarioResponsable;
	}

	public void setActivarid_usuarioResponsable(Boolean activarid_usuarioResponsable) {
		this.activarid_usuarioResponsable= activarid_usuarioResponsable;
	}

	public Boolean getCargarid_usuarioResponsable() {
		return this.cargarid_usuarioResponsable;
	}

	public void setCargarid_usuarioResponsable(Boolean cargarid_usuarioResponsable) {
		this.cargarid_usuarioResponsable= cargarid_usuarioResponsable;
	}

	public Border setResaltaridentificacionResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltar);
		
		this.resaltaridentificacionResponsable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridentificacionResponsable() {
		return this.resaltaridentificacionResponsable;
	}

	public void setResaltaridentificacionResponsable(Border borderResaltar) {
		this.resaltaridentificacionResponsable= borderResaltar;
	}

	public Boolean getMostraridentificacionResponsable() {
		return this.mostraridentificacionResponsable;
	}

	public void setMostraridentificacionResponsable(Boolean mostraridentificacionResponsable) {
		this.mostraridentificacionResponsable= mostraridentificacionResponsable;
	}

	public Boolean getActivaridentificacionResponsable() {
		return this.activaridentificacionResponsable;
	}

	public void setActivaridentificacionResponsable(Boolean activaridentificacionResponsable) {
		this.activaridentificacionResponsable= activaridentificacionResponsable;
	}

	public Border setResaltarrucResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltar);
		
		this.resaltarrucResponsable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucResponsable() {
		return this.resaltarrucResponsable;
	}

	public void setResaltarrucResponsable(Border borderResaltar) {
		this.resaltarrucResponsable= borderResaltar;
	}

	public Boolean getMostrarrucResponsable() {
		return this.mostrarrucResponsable;
	}

	public void setMostrarrucResponsable(Boolean mostrarrucResponsable) {
		this.mostrarrucResponsable= mostrarrucResponsable;
	}

	public Boolean getActivarrucResponsable() {
		return this.activarrucResponsable;
	}

	public void setActivarrucResponsable(Boolean activarrucResponsable) {
		this.activarrucResponsable= activarrucResponsable;
	}

	public Border setResaltarnombreResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltar);
		
		this.resaltarnombreResponsable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreResponsable() {
		return this.resaltarnombreResponsable;
	}

	public void setResaltarnombreResponsable(Border borderResaltar) {
		this.resaltarnombreResponsable= borderResaltar;
	}

	public Boolean getMostrarnombreResponsable() {
		return this.mostrarnombreResponsable;
	}

	public void setMostrarnombreResponsable(Boolean mostrarnombreResponsable) {
		this.mostrarnombreResponsable= mostrarnombreResponsable;
	}

	public Boolean getActivarnombreResponsable() {
		return this.activarnombreResponsable;
	}

	public void setActivarnombreResponsable(Boolean activarnombreResponsable) {
		this.activarnombreResponsable= activarnombreResponsable;
	}

	public Border setResaltarapellidoResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltar);
		
		this.resaltarapellidoResponsable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidoResponsable() {
		return this.resaltarapellidoResponsable;
	}

	public void setResaltarapellidoResponsable(Border borderResaltar) {
		this.resaltarapellidoResponsable= borderResaltar;
	}

	public Boolean getMostrarapellidoResponsable() {
		return this.mostrarapellidoResponsable;
	}

	public void setMostrarapellidoResponsable(Boolean mostrarapellidoResponsable) {
		this.mostrarapellidoResponsable= mostrarapellidoResponsable;
	}

	public Boolean getActivarapellidoResponsable() {
		return this.activarapellidoResponsable;
	}

	public void setActivarapellidoResponsable(Boolean activarapellidoResponsable) {
		this.activarapellidoResponsable= activarapellidoResponsable;
	}

	public Border setResaltarnombre_completoResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltar);
		
		this.resaltarnombre_completoResponsable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoResponsable() {
		return this.resaltarnombre_completoResponsable;
	}

	public void setResaltarnombre_completoResponsable(Border borderResaltar) {
		this.resaltarnombre_completoResponsable= borderResaltar;
	}

	public Boolean getMostrarnombre_completoResponsable() {
		return this.mostrarnombre_completoResponsable;
	}

	public void setMostrarnombre_completoResponsable(Boolean mostrarnombre_completoResponsable) {
		this.mostrarnombre_completoResponsable= mostrarnombre_completoResponsable;
	}

	public Boolean getActivarnombre_completoResponsable() {
		return this.activarnombre_completoResponsable;
	}

	public void setActivarnombre_completoResponsable(Boolean activarnombre_completoResponsable) {
		this.activarnombre_completoResponsable= activarnombre_completoResponsable;
	}

	public Border setResaltaremailResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltar);
		
		this.resaltaremailResponsable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaremailResponsable() {
		return this.resaltaremailResponsable;
	}

	public void setResaltaremailResponsable(Border borderResaltar) {
		this.resaltaremailResponsable= borderResaltar;
	}

	public Boolean getMostraremailResponsable() {
		return this.mostraremailResponsable;
	}

	public void setMostraremailResponsable(Boolean mostraremailResponsable) {
		this.mostraremailResponsable= mostraremailResponsable;
	}

	public Boolean getActivaremailResponsable() {
		return this.activaremailResponsable;
	}

	public void setActivaremailResponsable(Boolean activaremailResponsable) {
		this.activaremailResponsable= activaremailResponsable;
	}

	public Border setResaltartelefonoResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltar);
		
		this.resaltartelefonoResponsable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoResponsable() {
		return this.resaltartelefonoResponsable;
	}

	public void setResaltartelefonoResponsable(Border borderResaltar) {
		this.resaltartelefonoResponsable= borderResaltar;
	}

	public Boolean getMostrartelefonoResponsable() {
		return this.mostrartelefonoResponsable;
	}

	public void setMostrartelefonoResponsable(Boolean mostrartelefonoResponsable) {
		this.mostrartelefonoResponsable= mostrartelefonoResponsable;
	}

	public Boolean getActivartelefonoResponsable() {
		return this.activartelefonoResponsable;
	}

	public void setActivartelefonoResponsable(Boolean activartelefonoResponsable) {
		this.activartelefonoResponsable= activartelefonoResponsable;
	}

	public Border setResaltartelefono_celularResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltar);
		
		this.resaltartelefono_celularResponsable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_celularResponsable() {
		return this.resaltartelefono_celularResponsable;
	}

	public void setResaltartelefono_celularResponsable(Border borderResaltar) {
		this.resaltartelefono_celularResponsable= borderResaltar;
	}

	public Boolean getMostrartelefono_celularResponsable() {
		return this.mostrartelefono_celularResponsable;
	}

	public void setMostrartelefono_celularResponsable(Boolean mostrartelefono_celularResponsable) {
		this.mostrartelefono_celularResponsable= mostrartelefono_celularResponsable;
	}

	public Boolean getActivartelefono_celularResponsable() {
		return this.activartelefono_celularResponsable;
	}

	public void setActivartelefono_celularResponsable(Boolean activartelefono_celularResponsable) {
		this.activartelefono_celularResponsable= activartelefono_celularResponsable;
	}

	public Border setResaltardireccionResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltar);
		
		this.resaltardireccionResponsable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionResponsable() {
		return this.resaltardireccionResponsable;
	}

	public void setResaltardireccionResponsable(Border borderResaltar) {
		this.resaltardireccionResponsable= borderResaltar;
	}

	public Boolean getMostrardireccionResponsable() {
		return this.mostrardireccionResponsable;
	}

	public void setMostrardireccionResponsable(Boolean mostrardireccionResponsable) {
		this.mostrardireccionResponsable= mostrardireccionResponsable;
	}

	public Boolean getActivardireccionResponsable() {
		return this.activardireccionResponsable;
	}

	public void setActivardireccionResponsable(Boolean activardireccionResponsable) {
		this.activardireccionResponsable= activardireccionResponsable;
	}

	public Border setResaltarfaxResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltar);
		
		this.resaltarfaxResponsable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfaxResponsable() {
		return this.resaltarfaxResponsable;
	}

	public void setResaltarfaxResponsable(Border borderResaltar) {
		this.resaltarfaxResponsable= borderResaltar;
	}

	public Boolean getMostrarfaxResponsable() {
		return this.mostrarfaxResponsable;
	}

	public void setMostrarfaxResponsable(Boolean mostrarfaxResponsable) {
		this.mostrarfaxResponsable= mostrarfaxResponsable;
	}

	public Boolean getActivarfaxResponsable() {
		return this.activarfaxResponsable;
	}

	public void setActivarfaxResponsable(Boolean activarfaxResponsable) {
		this.activarfaxResponsable= activarfaxResponsable;
	}

	public Border setResaltarobservacionResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltar);
		
		this.resaltarobservacionResponsable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionResponsable() {
		return this.resaltarobservacionResponsable;
	}

	public void setResaltarobservacionResponsable(Border borderResaltar) {
		this.resaltarobservacionResponsable= borderResaltar;
	}

	public Boolean getMostrarobservacionResponsable() {
		return this.mostrarobservacionResponsable;
	}

	public void setMostrarobservacionResponsable(Boolean mostrarobservacionResponsable) {
		this.mostrarobservacionResponsable= mostrarobservacionResponsable;
	}

	public Boolean getActivarobservacionResponsable() {
		return this.activarobservacionResponsable;
	}

	public void setActivarobservacionResponsable(Boolean activarobservacionResponsable) {
		this.activarobservacionResponsable= activarobservacionResponsable;
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
		
		
		this.setMostraridResponsable(esInicial);
		this.setMostrarid_empresaResponsable(esInicial);
		this.setMostrarid_sucursalResponsable(esInicial);
		this.setMostrarid_clienteResponsable(esInicial);
		this.setMostrarid_usuarioResponsable(esInicial);
		this.setMostraridentificacionResponsable(esInicial);
		this.setMostrarrucResponsable(esInicial);
		this.setMostrarnombreResponsable(esInicial);
		this.setMostrarapellidoResponsable(esInicial);
		this.setMostrarnombre_completoResponsable(esInicial);
		this.setMostraremailResponsable(esInicial);
		this.setMostrartelefonoResponsable(esInicial);
		this.setMostrartelefono_celularResponsable(esInicial);
		this.setMostrardireccionResponsable(esInicial);
		this.setMostrarfaxResponsable(esInicial);
		this.setMostrarobservacionResponsable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResponsableConstantesFunciones.ID)) {
				this.setMostraridResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.IDENTIFICACION)) {
				this.setMostraridentificacionResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.RUC)) {
				this.setMostrarrucResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.APELLIDO)) {
				this.setMostrarapellidoResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.EMAIL)) {
				this.setMostraremailResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.TELEFONOCELULAR)) {
				this.setMostrartelefono_celularResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.FAX)) {
				this.setMostrarfaxResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.OBSERVACION)) {
				this.setMostrarobservacionResponsable(esAsigna);
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
		
		
		this.setActivaridResponsable(esInicial);
		this.setActivarid_empresaResponsable(esInicial);
		this.setActivarid_sucursalResponsable(esInicial);
		this.setActivarid_clienteResponsable(esInicial);
		this.setActivarid_usuarioResponsable(esInicial);
		this.setActivaridentificacionResponsable(esInicial);
		this.setActivarrucResponsable(esInicial);
		this.setActivarnombreResponsable(esInicial);
		this.setActivarapellidoResponsable(esInicial);
		this.setActivarnombre_completoResponsable(esInicial);
		this.setActivaremailResponsable(esInicial);
		this.setActivartelefonoResponsable(esInicial);
		this.setActivartelefono_celularResponsable(esInicial);
		this.setActivardireccionResponsable(esInicial);
		this.setActivarfaxResponsable(esInicial);
		this.setActivarobservacionResponsable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResponsableConstantesFunciones.ID)) {
				this.setActivaridResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.IDENTIFICACION)) {
				this.setActivaridentificacionResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.RUC)) {
				this.setActivarrucResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.NOMBRE)) {
				this.setActivarnombreResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.APELLIDO)) {
				this.setActivarapellidoResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.EMAIL)) {
				this.setActivaremailResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.TELEFONOCELULAR)) {
				this.setActivartelefono_celularResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.DIRECCION)) {
				this.setActivardireccionResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.FAX)) {
				this.setActivarfaxResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.OBSERVACION)) {
				this.setActivarobservacionResponsable(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridResponsable(esInicial);
		this.setResaltarid_empresaResponsable(esInicial);
		this.setResaltarid_sucursalResponsable(esInicial);
		this.setResaltarid_clienteResponsable(esInicial);
		this.setResaltarid_usuarioResponsable(esInicial);
		this.setResaltaridentificacionResponsable(esInicial);
		this.setResaltarrucResponsable(esInicial);
		this.setResaltarnombreResponsable(esInicial);
		this.setResaltarapellidoResponsable(esInicial);
		this.setResaltarnombre_completoResponsable(esInicial);
		this.setResaltaremailResponsable(esInicial);
		this.setResaltartelefonoResponsable(esInicial);
		this.setResaltartelefono_celularResponsable(esInicial);
		this.setResaltardireccionResponsable(esInicial);
		this.setResaltarfaxResponsable(esInicial);
		this.setResaltarobservacionResponsable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ResponsableConstantesFunciones.ID)) {
				this.setResaltaridResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.IDENTIFICACION)) {
				this.setResaltaridentificacionResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.RUC)) {
				this.setResaltarrucResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.APELLIDO)) {
				this.setResaltarapellidoResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.EMAIL)) {
				this.setResaltaremailResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.TELEFONOCELULAR)) {
				this.setResaltartelefono_celularResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.FAX)) {
				this.setResaltarfaxResponsable(esAsigna);
				continue;
			}

			if(campo.clase.equals(ResponsableConstantesFunciones.OBSERVACION)) {
				this.setResaltarobservacionResponsable(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFacturaResponsable=null;

	public Border getResaltarFacturaResponsable() {
		return this.resaltarFacturaResponsable;
	}

	public void setResaltarFacturaResponsable(Border borderResaltarFactura) {
		if(borderResaltarFactura!=null) {
			this.resaltarFacturaResponsable= borderResaltarFactura;
		}
	}

	public Border setResaltarFacturaResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltarFactura=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltarFactura);
			
		this.resaltarFacturaResponsable= borderResaltarFactura;

		 return borderResaltarFactura;
	}



	public Boolean mostrarFacturaResponsable=true;

	public Boolean getMostrarFacturaResponsable() {
		return this.mostrarFacturaResponsable;
	}

	public void setMostrarFacturaResponsable(Boolean visibilidadResaltarFactura) {
		this.mostrarFacturaResponsable= visibilidadResaltarFactura;
	}



	public Boolean activarFacturaResponsable=true;

	public Boolean gethabilitarResaltarFacturaResponsable() {
		return this.activarFacturaResponsable;
	}

	public void setActivarFacturaResponsable(Boolean habilitarResaltarFactura) {
		this.activarFacturaResponsable= habilitarResaltarFactura;
	}


	public Border resaltarConsignacionResponsable=null;

	public Border getResaltarConsignacionResponsable() {
		return this.resaltarConsignacionResponsable;
	}

	public void setResaltarConsignacionResponsable(Border borderResaltarConsignacion) {
		if(borderResaltarConsignacion!=null) {
			this.resaltarConsignacionResponsable= borderResaltarConsignacion;
		}
	}

	public Border setResaltarConsignacionResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltarConsignacion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltarConsignacion);
			
		this.resaltarConsignacionResponsable= borderResaltarConsignacion;

		 return borderResaltarConsignacion;
	}



	public Boolean mostrarConsignacionResponsable=true;

	public Boolean getMostrarConsignacionResponsable() {
		return this.mostrarConsignacionResponsable;
	}

	public void setMostrarConsignacionResponsable(Boolean visibilidadResaltarConsignacion) {
		this.mostrarConsignacionResponsable= visibilidadResaltarConsignacion;
	}



	public Boolean activarConsignacionResponsable=true;

	public Boolean gethabilitarResaltarConsignacionResponsable() {
		return this.activarConsignacionResponsable;
	}

	public void setActivarConsignacionResponsable(Boolean habilitarResaltarConsignacion) {
		this.activarConsignacionResponsable= habilitarResaltarConsignacion;
	}


	public Border resaltarPedidoExporResponsable=null;

	public Border getResaltarPedidoExporResponsable() {
		return this.resaltarPedidoExporResponsable;
	}

	public void setResaltarPedidoExporResponsable(Border borderResaltarPedidoExpor) {
		if(borderResaltarPedidoExpor!=null) {
			this.resaltarPedidoExporResponsable= borderResaltarPedidoExpor;
		}
	}

	public Border setResaltarPedidoExporResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoExpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltarPedidoExpor);
			
		this.resaltarPedidoExporResponsable= borderResaltarPedidoExpor;

		 return borderResaltarPedidoExpor;
	}



	public Boolean mostrarPedidoExporResponsable=true;

	public Boolean getMostrarPedidoExporResponsable() {
		return this.mostrarPedidoExporResponsable;
	}

	public void setMostrarPedidoExporResponsable(Boolean visibilidadResaltarPedidoExpor) {
		this.mostrarPedidoExporResponsable= visibilidadResaltarPedidoExpor;
	}



	public Boolean activarPedidoExporResponsable=true;

	public Boolean gethabilitarResaltarPedidoExporResponsable() {
		return this.activarPedidoExporResponsable;
	}

	public void setActivarPedidoExporResponsable(Boolean habilitarResaltarPedidoExpor) {
		this.activarPedidoExporResponsable= habilitarResaltarPedidoExpor;
	}


	public Border resaltarPedidoResponsable=null;

	public Border getResaltarPedidoResponsable() {
		return this.resaltarPedidoResponsable;
	}

	public void setResaltarPedidoResponsable(Border borderResaltarPedido) {
		if(borderResaltarPedido!=null) {
			this.resaltarPedidoResponsable= borderResaltarPedido;
		}
	}

	public Border setResaltarPedidoResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltarPedido=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltarPedido);
			
		this.resaltarPedidoResponsable= borderResaltarPedido;

		 return borderResaltarPedido;
	}



	public Boolean mostrarPedidoResponsable=true;

	public Boolean getMostrarPedidoResponsable() {
		return this.mostrarPedidoResponsable;
	}

	public void setMostrarPedidoResponsable(Boolean visibilidadResaltarPedido) {
		this.mostrarPedidoResponsable= visibilidadResaltarPedido;
	}



	public Boolean activarPedidoResponsable=true;

	public Boolean gethabilitarResaltarPedidoResponsable() {
		return this.activarPedidoResponsable;
	}

	public void setActivarPedidoResponsable(Boolean habilitarResaltarPedido) {
		this.activarPedidoResponsable= habilitarResaltarPedido;
	}


	public Border resaltarNotaCreditoSoliResponsable=null;

	public Border getResaltarNotaCreditoSoliResponsable() {
		return this.resaltarNotaCreditoSoliResponsable;
	}

	public void setResaltarNotaCreditoSoliResponsable(Border borderResaltarNotaCreditoSoli) {
		if(borderResaltarNotaCreditoSoli!=null) {
			this.resaltarNotaCreditoSoliResponsable= borderResaltarNotaCreditoSoli;
		}
	}

	public Border setResaltarNotaCreditoSoliResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltarNotaCreditoSoli=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//responsableBeanSwingJInternalFrame.jTtoolBarResponsable.setBorder(borderResaltarNotaCreditoSoli);
			
		this.resaltarNotaCreditoSoliResponsable= borderResaltarNotaCreditoSoli;

		 return borderResaltarNotaCreditoSoli;
	}



	public Boolean mostrarNotaCreditoSoliResponsable=true;

	public Boolean getMostrarNotaCreditoSoliResponsable() {
		return this.mostrarNotaCreditoSoliResponsable;
	}

	public void setMostrarNotaCreditoSoliResponsable(Boolean visibilidadResaltarNotaCreditoSoli) {
		this.mostrarNotaCreditoSoliResponsable= visibilidadResaltarNotaCreditoSoli;
	}



	public Boolean activarNotaCreditoSoliResponsable=true;

	public Boolean gethabilitarResaltarNotaCreditoSoliResponsable() {
		return this.activarNotaCreditoSoliResponsable;
	}

	public void setActivarNotaCreditoSoliResponsable(Boolean habilitarResaltarNotaCreditoSoli) {
		this.activarNotaCreditoSoliResponsable= habilitarResaltarNotaCreditoSoli;
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

		this.setMostrarFacturaResponsable(esInicial);
		this.setMostrarConsignacionResponsable(esInicial);
		this.setMostrarPedidoExporResponsable(esInicial);
		this.setMostrarPedidoResponsable(esInicial);
		this.setMostrarNotaCreditoSoliResponsable(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Factura.class)) {
				this.setMostrarFacturaResponsable(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignacion.class)) {
				this.setMostrarConsignacionResponsable(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setMostrarPedidoExporResponsable(esAsigna);
				continue;
			}

			if(clase.clas.equals(Pedido.class)) {
				this.setMostrarPedidoResponsable(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setMostrarNotaCreditoSoliResponsable(esAsigna);
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

		this.setActivarFacturaResponsable(esInicial);
		this.setActivarConsignacionResponsable(esInicial);
		this.setActivarPedidoExporResponsable(esInicial);
		this.setActivarPedidoResponsable(esInicial);
		this.setActivarNotaCreditoSoliResponsable(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Factura.class)) {
				this.setActivarFacturaResponsable(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignacion.class)) {
				this.setActivarConsignacionResponsable(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setActivarPedidoExporResponsable(esAsigna);
				continue;
			}

			if(clase.clas.equals(Pedido.class)) {
				this.setActivarPedidoResponsable(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setActivarNotaCreditoSoliResponsable(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFacturaResponsable(esInicial);
		this.setResaltarConsignacionResponsable(esInicial);
		this.setResaltarPedidoExporResponsable(esInicial);
		this.setResaltarPedidoResponsable(esInicial);
		this.setResaltarNotaCreditoSoliResponsable(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Factura.class)) {
				this.setResaltarFacturaResponsable(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignacion.class)) {
				this.setResaltarConsignacionResponsable(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setResaltarPedidoExporResponsable(esAsigna);
				continue;
			}

			if(clase.clas.equals(Pedido.class)) {
				this.setResaltarPedidoResponsable(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoSoli.class)) {
				this.setResaltarNotaCreditoSoliResponsable(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorIdentificacionResponsable=true;

	public Boolean getMostrarBusquedaPorIdentificacionResponsable() {
		return this.mostrarBusquedaPorIdentificacionResponsable;
	}

	public void setMostrarBusquedaPorIdentificacionResponsable(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdentificacionResponsable= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreCompletoResponsable=true;

	public Boolean getMostrarBusquedaPorNombreCompletoResponsable() {
		return this.mostrarBusquedaPorNombreCompletoResponsable;
	}

	public void setMostrarBusquedaPorNombreCompletoResponsable(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreCompletoResponsable= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorRucResponsable=true;

	public Boolean getMostrarBusquedaPorRucResponsable() {
		return this.mostrarBusquedaPorRucResponsable;
	}

	public void setMostrarBusquedaPorRucResponsable(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorRucResponsable= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorTelefonoResponsable=true;

	public Boolean getMostrarBusquedaPorTelefonoResponsable() {
		return this.mostrarBusquedaPorTelefonoResponsable;
	}

	public void setMostrarBusquedaPorTelefonoResponsable(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorTelefonoResponsable= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorTelefonoCelularResponsable=true;

	public Boolean getMostrarBusquedaPorTelefonoCelularResponsable() {
		return this.mostrarBusquedaPorTelefonoCelularResponsable;
	}

	public void setMostrarBusquedaPorTelefonoCelularResponsable(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorTelefonoCelularResponsable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteResponsable=true;

	public Boolean getMostrarFK_IdClienteResponsable() {
		return this.mostrarFK_IdClienteResponsable;
	}

	public void setMostrarFK_IdClienteResponsable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteResponsable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaResponsable=true;

	public Boolean getMostrarFK_IdEmpresaResponsable() {
		return this.mostrarFK_IdEmpresaResponsable;
	}

	public void setMostrarFK_IdEmpresaResponsable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaResponsable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalResponsable=true;

	public Boolean getMostrarFK_IdSucursalResponsable() {
		return this.mostrarFK_IdSucursalResponsable;
	}

	public void setMostrarFK_IdSucursalResponsable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalResponsable= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdentificacionResponsable=true;

	public Boolean getActivarBusquedaPorIdentificacionResponsable() {
		return this.activarBusquedaPorIdentificacionResponsable;
	}

	public void setActivarBusquedaPorIdentificacionResponsable(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdentificacionResponsable= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreCompletoResponsable=true;

	public Boolean getActivarBusquedaPorNombreCompletoResponsable() {
		return this.activarBusquedaPorNombreCompletoResponsable;
	}

	public void setActivarBusquedaPorNombreCompletoResponsable(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreCompletoResponsable= habilitarResaltar;
	}

	public Boolean activarBusquedaPorRucResponsable=true;

	public Boolean getActivarBusquedaPorRucResponsable() {
		return this.activarBusquedaPorRucResponsable;
	}

	public void setActivarBusquedaPorRucResponsable(Boolean habilitarResaltar) {
		this.activarBusquedaPorRucResponsable= habilitarResaltar;
	}

	public Boolean activarBusquedaPorTelefonoResponsable=true;

	public Boolean getActivarBusquedaPorTelefonoResponsable() {
		return this.activarBusquedaPorTelefonoResponsable;
	}

	public void setActivarBusquedaPorTelefonoResponsable(Boolean habilitarResaltar) {
		this.activarBusquedaPorTelefonoResponsable= habilitarResaltar;
	}

	public Boolean activarBusquedaPorTelefonoCelularResponsable=true;

	public Boolean getActivarBusquedaPorTelefonoCelularResponsable() {
		return this.activarBusquedaPorTelefonoCelularResponsable;
	}

	public void setActivarBusquedaPorTelefonoCelularResponsable(Boolean habilitarResaltar) {
		this.activarBusquedaPorTelefonoCelularResponsable= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteResponsable=true;

	public Boolean getActivarFK_IdClienteResponsable() {
		return this.activarFK_IdClienteResponsable;
	}

	public void setActivarFK_IdClienteResponsable(Boolean habilitarResaltar) {
		this.activarFK_IdClienteResponsable= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaResponsable=true;

	public Boolean getActivarFK_IdEmpresaResponsable() {
		return this.activarFK_IdEmpresaResponsable;
	}

	public void setActivarFK_IdEmpresaResponsable(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaResponsable= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalResponsable=true;

	public Boolean getActivarFK_IdSucursalResponsable() {
		return this.activarFK_IdSucursalResponsable;
	}

	public void setActivarFK_IdSucursalResponsable(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalResponsable= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdentificacionResponsable=null;

	public Border getResaltarBusquedaPorIdentificacionResponsable() {
		return this.resaltarBusquedaPorIdentificacionResponsable;
	}

	public void setResaltarBusquedaPorIdentificacionResponsable(Border borderResaltar) {
		this.resaltarBusquedaPorIdentificacionResponsable= borderResaltar;
	}

	public void setResaltarBusquedaPorIdentificacionResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdentificacionResponsable= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreCompletoResponsable=null;

	public Border getResaltarBusquedaPorNombreCompletoResponsable() {
		return this.resaltarBusquedaPorNombreCompletoResponsable;
	}

	public void setResaltarBusquedaPorNombreCompletoResponsable(Border borderResaltar) {
		this.resaltarBusquedaPorNombreCompletoResponsable= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreCompletoResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreCompletoResponsable= borderResaltar;
	}

	public Border resaltarBusquedaPorRucResponsable=null;

	public Border getResaltarBusquedaPorRucResponsable() {
		return this.resaltarBusquedaPorRucResponsable;
	}

	public void setResaltarBusquedaPorRucResponsable(Border borderResaltar) {
		this.resaltarBusquedaPorRucResponsable= borderResaltar;
	}

	public void setResaltarBusquedaPorRucResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorRucResponsable= borderResaltar;
	}

	public Border resaltarBusquedaPorTelefonoResponsable=null;

	public Border getResaltarBusquedaPorTelefonoResponsable() {
		return this.resaltarBusquedaPorTelefonoResponsable;
	}

	public void setResaltarBusquedaPorTelefonoResponsable(Border borderResaltar) {
		this.resaltarBusquedaPorTelefonoResponsable= borderResaltar;
	}

	public void setResaltarBusquedaPorTelefonoResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorTelefonoResponsable= borderResaltar;
	}

	public Border resaltarBusquedaPorTelefonoCelularResponsable=null;

	public Border getResaltarBusquedaPorTelefonoCelularResponsable() {
		return this.resaltarBusquedaPorTelefonoCelularResponsable;
	}

	public void setResaltarBusquedaPorTelefonoCelularResponsable(Border borderResaltar) {
		this.resaltarBusquedaPorTelefonoCelularResponsable= borderResaltar;
	}

	public void setResaltarBusquedaPorTelefonoCelularResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorTelefonoCelularResponsable= borderResaltar;
	}

	public Border resaltarFK_IdClienteResponsable=null;

	public Border getResaltarFK_IdClienteResponsable() {
		return this.resaltarFK_IdClienteResponsable;
	}

	public void setResaltarFK_IdClienteResponsable(Border borderResaltar) {
		this.resaltarFK_IdClienteResponsable= borderResaltar;
	}

	public void setResaltarFK_IdClienteResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteResponsable= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaResponsable=null;

	public Border getResaltarFK_IdEmpresaResponsable() {
		return this.resaltarFK_IdEmpresaResponsable;
	}

	public void setResaltarFK_IdEmpresaResponsable(Border borderResaltar) {
		this.resaltarFK_IdEmpresaResponsable= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaResponsable= borderResaltar;
	}

	public Border resaltarFK_IdSucursalResponsable=null;

	public Border getResaltarFK_IdSucursalResponsable() {
		return this.resaltarFK_IdSucursalResponsable;
	}

	public void setResaltarFK_IdSucursalResponsable(Border borderResaltar) {
		this.resaltarFK_IdSucursalResponsable= borderResaltar;
	}

	public void setResaltarFK_IdSucursalResponsable(ParametroGeneralUsuario parametroGeneralUsuario/*ResponsableBeanSwingJInternalFrame responsableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalResponsable= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}