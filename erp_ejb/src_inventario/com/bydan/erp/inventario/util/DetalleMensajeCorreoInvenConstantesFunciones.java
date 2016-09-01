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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.DetalleMensajeCorreoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleMensajeCorreoInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleMensajeCorreoInvenParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleMensajeCorreoInvenConstantesFunciones extends DetalleMensajeCorreoInvenConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleMensajeCorreoInven";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleMensajeCorreoInven"+DetalleMensajeCorreoInvenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleMensajeCorreoInvenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleMensajeCorreoInvenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"_"+DetalleMensajeCorreoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleMensajeCorreoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"_"+DetalleMensajeCorreoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"_"+DetalleMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleMensajeCorreoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"_"+DetalleMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleMensajeCorreoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleMensajeCorreoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleMensajeCorreoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleMensajeCorreoInvenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleMensajeCorreoInvenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleMensajeCorreoInvenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleMensajeCorreoInvenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Mensaje Correo Invenes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Detalle Mensaje Correo Inven";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Mensaje Correo Inven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleMensajeCorreoInven";
	public static final String OBJECTNAME="detallemensajecorreoinven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="detalle_mensaje_correo_inven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallemensajecorreoinven from "+DetalleMensajeCorreoInvenConstantesFunciones.SPERSISTENCENAME+" detallemensajecorreoinven";
	public static String QUERYSELECTNATIVE="select "+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".id,"+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".version_row,"+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_mensaje_correo_inven,"+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_empresa,"+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_modulo,"+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_usuario,"+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_empleado,"+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".esta_activo from "+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME;//+" as "+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleMensajeCorreoInvenConstantesFuncionesAdditional detallemensajecorreoinvenConstantesFuncionesAdditional=null;
	
	public DetalleMensajeCorreoInvenConstantesFuncionesAdditional getDetalleMensajeCorreoInvenConstantesFuncionesAdditional() {
		return this.detallemensajecorreoinvenConstantesFuncionesAdditional;
	}
	
	public void setDetalleMensajeCorreoInvenConstantesFuncionesAdditional(DetalleMensajeCorreoInvenConstantesFuncionesAdditional detallemensajecorreoinvenConstantesFuncionesAdditional) {
		try {
			this.detallemensajecorreoinvenConstantesFuncionesAdditional=detallemensajecorreoinvenConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDMENSAJECORREOINVEN= "id_mensaje_correo_inven";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDMODULO= "id_modulo";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDMENSAJECORREOINVEN= "Mensaje Correo Inven";
		public static final String LABEL_IDMENSAJECORREOINVEN_LOWER= "Mensaje Correo Inven";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
		
		
		
	
	public static String getDetalleMensajeCorreoInvenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN)) {sLabelColumna=DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDMENSAJECORREOINVEN;}
		if(sNombreColumna.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDMODULO)) {sLabelColumna=DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDUSUARIO)) {sLabelColumna=DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDEMPLEADO)) {sLabelColumna=DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(DetalleMensajeCorreoInvenConstantesFunciones.ESTAACTIVO)) {sLabelColumna=DetalleMensajeCorreoInvenConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(DetalleMensajeCorreoInven detallemensajecorreoinven) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detallemensajecorreoinven.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(DetalleMensajeCorreoInven detallemensajecorreoinven) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detallemensajecorreoinven.getId(),detallemensajecorreoinven.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getDetalleMensajeCorreoInvenDescripcion(DetalleMensajeCorreoInven detallemensajecorreoinven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallemensajecorreoinven !=null/* && detallemensajecorreoinven.getId()!=0*/) {
			if(detallemensajecorreoinven.getId()!=null) {
				sDescripcion=detallemensajecorreoinven.getId().toString();
			}//detallemensajecorreoinvendetallemensajecorreoinven.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleMensajeCorreoInvenDescripcionDetallado(DetalleMensajeCorreoInven detallemensajecorreoinven) {
		String sDescripcion="";
			
		sDescripcion+=DetalleMensajeCorreoInvenConstantesFunciones.ID+"=";
		sDescripcion+=detallemensajecorreoinven.getId().toString()+",";
		sDescripcion+=DetalleMensajeCorreoInvenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallemensajecorreoinven.getVersionRow().toString()+",";
		sDescripcion+=DetalleMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN+"=";
		sDescripcion+=detallemensajecorreoinven.getid_mensaje_correo_inven().toString()+",";
		sDescripcion+=DetalleMensajeCorreoInvenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallemensajecorreoinven.getid_empresa().toString()+",";
		sDescripcion+=DetalleMensajeCorreoInvenConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallemensajecorreoinven.getid_sucursal().toString()+",";
		sDescripcion+=DetalleMensajeCorreoInvenConstantesFunciones.IDMODULO+"=";
		sDescripcion+=detallemensajecorreoinven.getid_modulo().toString()+",";
		sDescripcion+=DetalleMensajeCorreoInvenConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=detallemensajecorreoinven.getid_usuario().toString()+",";
		sDescripcion+=DetalleMensajeCorreoInvenConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=detallemensajecorreoinven.getid_empleado().toString()+",";
		sDescripcion+=DetalleMensajeCorreoInvenConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=detallemensajecorreoinven.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleMensajeCorreoInvenDescripcion(DetalleMensajeCorreoInven detallemensajecorreoinven,String sValor) throws Exception {			
		if(detallemensajecorreoinven !=null) {
			//detallemensajecorreoinvendetallemensajecorreoinven.getId().toString();
		}		
	}
	
		

	public static String getMensajeCorreoInvenDescripcion(MensajeCorreoInven mensajecorreoinven) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mensajecorreoinven!=null/*&&mensajecorreoinven.getId()>0*/) {
			sDescripcion=MensajeCorreoInvenConstantesFunciones.getMensajeCorreoInvenDescripcion(mensajecorreoinven);
		}

		return sDescripcion;
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
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

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMensajeCorreoInven")) {
			sNombreIndice="Tipo=  Por Mensaje Correo Inven";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
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

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMensajeCorreoInven(Long id_mensaje_correo_inven) {
		String sDetalleIndice=" Parametros->";
		if(id_mensaje_correo_inven!=null) {sDetalleIndice+=" Codigo Unico De Mensaje Correo Inven="+id_mensaje_correo_inven.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDetalleMensajeCorreoInven(DetalleMensajeCorreoInven detallemensajecorreoinven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosDetalleMensajeCorreoInvens(List<DetalleMensajeCorreoInven> detallemensajecorreoinvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleMensajeCorreoInven detallemensajecorreoinven: detallemensajecorreoinvens) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleMensajeCorreoInven(DetalleMensajeCorreoInven detallemensajecorreoinven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallemensajecorreoinven.getConCambioAuxiliar()) {
			detallemensajecorreoinven.setIsDeleted(detallemensajecorreoinven.getIsDeletedAuxiliar());	
			detallemensajecorreoinven.setIsNew(detallemensajecorreoinven.getIsNewAuxiliar());	
			detallemensajecorreoinven.setIsChanged(detallemensajecorreoinven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallemensajecorreoinven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallemensajecorreoinven.setIsDeletedAuxiliar(false);	
			detallemensajecorreoinven.setIsNewAuxiliar(false);	
			detallemensajecorreoinven.setIsChangedAuxiliar(false);
			
			detallemensajecorreoinven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleMensajeCorreoInvens(List<DetalleMensajeCorreoInven> detallemensajecorreoinvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleMensajeCorreoInven detallemensajecorreoinven : detallemensajecorreoinvens) {
			if(conAsignarBase && detallemensajecorreoinven.getConCambioAuxiliar()) {
				detallemensajecorreoinven.setIsDeleted(detallemensajecorreoinven.getIsDeletedAuxiliar());	
				detallemensajecorreoinven.setIsNew(detallemensajecorreoinven.getIsNewAuxiliar());	
				detallemensajecorreoinven.setIsChanged(detallemensajecorreoinven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallemensajecorreoinven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallemensajecorreoinven.setIsDeletedAuxiliar(false);	
				detallemensajecorreoinven.setIsNewAuxiliar(false);	
				detallemensajecorreoinven.setIsChangedAuxiliar(false);
				
				detallemensajecorreoinven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleMensajeCorreoInven(DetalleMensajeCorreoInven detallemensajecorreoinven,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleMensajeCorreoInvens(List<DetalleMensajeCorreoInven> detallemensajecorreoinvens,Boolean conEnteros) throws Exception  {
		
		for(DetalleMensajeCorreoInven detallemensajecorreoinven: detallemensajecorreoinvens) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleMensajeCorreoInven(List<DetalleMensajeCorreoInven> detallemensajecorreoinvens,DetalleMensajeCorreoInven detallemensajecorreoinvenAux) throws Exception  {
		DetalleMensajeCorreoInvenConstantesFunciones.InicializarValoresDetalleMensajeCorreoInven(detallemensajecorreoinvenAux,true);
		
		for(DetalleMensajeCorreoInven detallemensajecorreoinven: detallemensajecorreoinvens) {
			if(detallemensajecorreoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleMensajeCorreoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleMensajeCorreoInvenConstantesFunciones.getArrayColumnasGlobalesDetalleMensajeCorreoInven(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleMensajeCorreoInven(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleMensajeCorreoInvenConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleMensajeCorreoInvenConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleMensajeCorreoInvenConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleMensajeCorreoInvenConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleMensajeCorreoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetalleMensajeCorreoInvenConstantesFunciones.IDUSUARIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleMensajeCorreoInven> detallemensajecorreoinvens,DetalleMensajeCorreoInven detallemensajecorreoinven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleMensajeCorreoInven detallemensajecorreoinvenAux: detallemensajecorreoinvens) {
			if(detallemensajecorreoinvenAux!=null && detallemensajecorreoinven!=null) {
				if((detallemensajecorreoinvenAux.getId()==null && detallemensajecorreoinven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallemensajecorreoinvenAux.getId()!=null && detallemensajecorreoinven.getId()!=null){
					if(detallemensajecorreoinvenAux.getId().equals(detallemensajecorreoinven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleMensajeCorreoInven(List<DetalleMensajeCorreoInven> detallemensajecorreoinvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(DetalleMensajeCorreoInven detallemensajecorreoinven: detallemensajecorreoinvens) {			
			if(detallemensajecorreoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleMensajeCorreoInven() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleMensajeCorreoInvenConstantesFunciones.LABEL_ID, DetalleMensajeCorreoInvenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMensajeCorreoInvenConstantesFunciones.LABEL_VERSIONROW, DetalleMensajeCorreoInvenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDMENSAJECORREOINVEN, DetalleMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDEMPRESA, DetalleMensajeCorreoInvenConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDSUCURSAL, DetalleMensajeCorreoInvenConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO, DetalleMensajeCorreoInvenConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDUSUARIO, DetalleMensajeCorreoInvenConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDEMPLEADO, DetalleMensajeCorreoInvenConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMensajeCorreoInvenConstantesFunciones.LABEL_ESTAACTIVO, DetalleMensajeCorreoInvenConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleMensajeCorreoInven() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleMensajeCorreoInvenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMensajeCorreoInvenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMensajeCorreoInvenConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMensajeCorreoInvenConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMensajeCorreoInvenConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMensajeCorreoInvenConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMensajeCorreoInvenConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMensajeCorreoInvenConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleMensajeCorreoInven() throws Exception  {
		return DetalleMensajeCorreoInvenConstantesFunciones.getTiposSeleccionarDetalleMensajeCorreoInven(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleMensajeCorreoInven(Boolean conFk) throws Exception  {
		return DetalleMensajeCorreoInvenConstantesFunciones.getTiposSeleccionarDetalleMensajeCorreoInven(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleMensajeCorreoInven(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDMENSAJECORREOINVEN);
			reporte.setsDescripcion(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDMENSAJECORREOINVEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleMensajeCorreoInven(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(DetalleMensajeCorreoInven detallemensajecorreoinvenAux) throws Exception {
		
			detallemensajecorreoinvenAux.setmensajecorreoinven_descripcion(MensajeCorreoInvenConstantesFunciones.getMensajeCorreoInvenDescripcion(detallemensajecorreoinvenAux.getMensajeCorreoInven()));
			detallemensajecorreoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallemensajecorreoinvenAux.getEmpresa()));
			detallemensajecorreoinvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallemensajecorreoinvenAux.getSucursal()));
			detallemensajecorreoinvenAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(detallemensajecorreoinvenAux.getModulo()));
			detallemensajecorreoinvenAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(detallemensajecorreoinvenAux.getUsuario()));
			detallemensajecorreoinvenAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(detallemensajecorreoinvenAux.getEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(List<DetalleMensajeCorreoInven> detallemensajecorreoinvensTemp) throws Exception {
		for(DetalleMensajeCorreoInven detallemensajecorreoinvenAux:detallemensajecorreoinvensTemp) {
			
			detallemensajecorreoinvenAux.setmensajecorreoinven_descripcion(MensajeCorreoInvenConstantesFunciones.getMensajeCorreoInvenDescripcion(detallemensajecorreoinvenAux.getMensajeCorreoInven()));
			detallemensajecorreoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallemensajecorreoinvenAux.getEmpresa()));
			detallemensajecorreoinvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallemensajecorreoinvenAux.getSucursal()));
			detallemensajecorreoinvenAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(detallemensajecorreoinvenAux.getModulo()));
			detallemensajecorreoinvenAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(detallemensajecorreoinvenAux.getUsuario()));
			detallemensajecorreoinvenAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(detallemensajecorreoinvenAux.getEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(MensajeCorreoInven.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Empleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(MensajeCorreoInven.class)) {
						classes.add(new Classe(MensajeCorreoInven.class));
					}
				}

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
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleMensajeCorreoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(MensajeCorreoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MensajeCorreoInven.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(MensajeCorreoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MensajeCorreoInven.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleMensajeCorreoInvenConstantesFunciones.getClassesRelationshipsOfDetalleMensajeCorreoInven(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleMensajeCorreoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleMensajeCorreoInvenConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleMensajeCorreoInven(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleMensajeCorreoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleMensajeCorreoInven detallemensajecorreoinven,List<DetalleMensajeCorreoInven> detallemensajecorreoinvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleMensajeCorreoInven detallemensajecorreoinvenEncontrado=null;
			
			for(DetalleMensajeCorreoInven detallemensajecorreoinvenLocal:detallemensajecorreoinvens) {
				if(detallemensajecorreoinvenLocal.getId().equals(detallemensajecorreoinven.getId())) {
					detallemensajecorreoinvenEncontrado=detallemensajecorreoinvenLocal;
					
					detallemensajecorreoinvenLocal.setIsChanged(detallemensajecorreoinven.getIsChanged());
					detallemensajecorreoinvenLocal.setIsNew(detallemensajecorreoinven.getIsNew());
					detallemensajecorreoinvenLocal.setIsDeleted(detallemensajecorreoinven.getIsDeleted());
					
					detallemensajecorreoinvenLocal.setGeneralEntityOriginal(detallemensajecorreoinven.getGeneralEntityOriginal());
					
					detallemensajecorreoinvenLocal.setId(detallemensajecorreoinven.getId());	
					detallemensajecorreoinvenLocal.setVersionRow(detallemensajecorreoinven.getVersionRow());	
					detallemensajecorreoinvenLocal.setid_mensaje_correo_inven(detallemensajecorreoinven.getid_mensaje_correo_inven());	
					detallemensajecorreoinvenLocal.setid_empresa(detallemensajecorreoinven.getid_empresa());	
					detallemensajecorreoinvenLocal.setid_sucursal(detallemensajecorreoinven.getid_sucursal());	
					detallemensajecorreoinvenLocal.setid_modulo(detallemensajecorreoinven.getid_modulo());	
					detallemensajecorreoinvenLocal.setid_usuario(detallemensajecorreoinven.getid_usuario());	
					detallemensajecorreoinvenLocal.setid_empleado(detallemensajecorreoinven.getid_empleado());	
					detallemensajecorreoinvenLocal.setesta_activo(detallemensajecorreoinven.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallemensajecorreoinven.getIsDeleted()) {
				if(!existe) {
					detallemensajecorreoinvens.add(detallemensajecorreoinven);
				}
			} else {
				if(detallemensajecorreoinvenEncontrado!=null && permiteQuitar)  {
					detallemensajecorreoinvens.remove(detallemensajecorreoinvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleMensajeCorreoInven detallemensajecorreoinven,List<DetalleMensajeCorreoInven> detallemensajecorreoinvens) throws Exception {
		try	{			
			for(DetalleMensajeCorreoInven detallemensajecorreoinvenLocal:detallemensajecorreoinvens) {
				if(detallemensajecorreoinvenLocal.getId().equals(detallemensajecorreoinven.getId())) {
					detallemensajecorreoinvenLocal.setIsSelected(detallemensajecorreoinven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleMensajeCorreoInven(List<DetalleMensajeCorreoInven> detallemensajecorreoinvensAux) throws Exception {
		//this.detallemensajecorreoinvensAux=detallemensajecorreoinvensAux;
		
		for(DetalleMensajeCorreoInven detallemensajecorreoinvenAux:detallemensajecorreoinvensAux) {
			if(detallemensajecorreoinvenAux.getIsChanged()) {
				detallemensajecorreoinvenAux.setIsChanged(false);
			}		
			
			if(detallemensajecorreoinvenAux.getIsNew()) {
				detallemensajecorreoinvenAux.setIsNew(false);
			}	
			
			if(detallemensajecorreoinvenAux.getIsDeleted()) {
				detallemensajecorreoinvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleMensajeCorreoInven(DetalleMensajeCorreoInven detallemensajecorreoinvenAux) throws Exception {
		//this.detallemensajecorreoinvenAux=detallemensajecorreoinvenAux;
		
			if(detallemensajecorreoinvenAux.getIsChanged()) {
				detallemensajecorreoinvenAux.setIsChanged(false);
			}		
			
			if(detallemensajecorreoinvenAux.getIsNew()) {
				detallemensajecorreoinvenAux.setIsNew(false);
			}	
			
			if(detallemensajecorreoinvenAux.getIsDeleted()) {
				detallemensajecorreoinvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleMensajeCorreoInven detallemensajecorreoinvenAsignar,DetalleMensajeCorreoInven detallemensajecorreoinven) throws Exception {
		detallemensajecorreoinvenAsignar.setId(detallemensajecorreoinven.getId());	
		detallemensajecorreoinvenAsignar.setVersionRow(detallemensajecorreoinven.getVersionRow());	
		detallemensajecorreoinvenAsignar.setid_mensaje_correo_inven(detallemensajecorreoinven.getid_mensaje_correo_inven());
		detallemensajecorreoinvenAsignar.setmensajecorreoinven_descripcion(detallemensajecorreoinven.getmensajecorreoinven_descripcion());	
		detallemensajecorreoinvenAsignar.setid_empresa(detallemensajecorreoinven.getid_empresa());
		detallemensajecorreoinvenAsignar.setempresa_descripcion(detallemensajecorreoinven.getempresa_descripcion());	
		detallemensajecorreoinvenAsignar.setid_sucursal(detallemensajecorreoinven.getid_sucursal());
		detallemensajecorreoinvenAsignar.setsucursal_descripcion(detallemensajecorreoinven.getsucursal_descripcion());	
		detallemensajecorreoinvenAsignar.setid_modulo(detallemensajecorreoinven.getid_modulo());
		detallemensajecorreoinvenAsignar.setmodulo_descripcion(detallemensajecorreoinven.getmodulo_descripcion());	
		detallemensajecorreoinvenAsignar.setid_usuario(detallemensajecorreoinven.getid_usuario());
		detallemensajecorreoinvenAsignar.setusuario_descripcion(detallemensajecorreoinven.getusuario_descripcion());	
		detallemensajecorreoinvenAsignar.setid_empleado(detallemensajecorreoinven.getid_empleado());
		detallemensajecorreoinvenAsignar.setempleado_descripcion(detallemensajecorreoinven.getempleado_descripcion());	
		detallemensajecorreoinvenAsignar.setesta_activo(detallemensajecorreoinven.getesta_activo());	
	}
	
	public static void inicializarDetalleMensajeCorreoInven(DetalleMensajeCorreoInven detallemensajecorreoinven) throws Exception {
		try {
				detallemensajecorreoinven.setId(0L);	
					
				detallemensajecorreoinven.setid_mensaje_correo_inven(-1L);	
				detallemensajecorreoinven.setid_empresa(-1L);	
				detallemensajecorreoinven.setid_sucursal(-1L);	
				detallemensajecorreoinven.setid_modulo(-1L);	
				detallemensajecorreoinven.setid_usuario(-1L);	
				detallemensajecorreoinven.setid_empleado(-1L);	
				detallemensajecorreoinven.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleMensajeCorreoInven(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDMENSAJECORREOINVEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMensajeCorreoInvenConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleMensajeCorreoInven(String sTipo,Row row,Workbook workbook,DetalleMensajeCorreoInven detallemensajecorreoinven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemensajecorreoinven.getmensajecorreoinven_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemensajecorreoinven.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemensajecorreoinven.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemensajecorreoinven.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemensajecorreoinven.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemensajecorreoinven.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detallemensajecorreoinven.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleMensajeCorreoInven=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleMensajeCorreoInven() {
		return this.sFinalQueryDetalleMensajeCorreoInven;
	}
	
	public void setsFinalQueryDetalleMensajeCorreoInven(String sFinalQueryDetalleMensajeCorreoInven) {
		this.sFinalQueryDetalleMensajeCorreoInven= sFinalQueryDetalleMensajeCorreoInven;
	}
	
	public Border resaltarSeleccionarDetalleMensajeCorreoInven=null;
	
	public Border setResaltarSeleccionarDetalleMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMensajeCorreoInvenBeanSwingJInternalFrame detallemensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallemensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarDetalleMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleMensajeCorreoInven= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleMensajeCorreoInven() {
		return this.resaltarSeleccionarDetalleMensajeCorreoInven;
	}
	
	public void setResaltarSeleccionarDetalleMensajeCorreoInven(Border borderResaltarSeleccionarDetalleMensajeCorreoInven) {
		this.resaltarSeleccionarDetalleMensajeCorreoInven= borderResaltarSeleccionarDetalleMensajeCorreoInven;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleMensajeCorreoInven=null;
	public Boolean mostraridDetalleMensajeCorreoInven=true;
	public Boolean activaridDetalleMensajeCorreoInven=true;

	public Border resaltarid_mensaje_correo_invenDetalleMensajeCorreoInven=null;
	public Boolean mostrarid_mensaje_correo_invenDetalleMensajeCorreoInven=true;
	public Boolean activarid_mensaje_correo_invenDetalleMensajeCorreoInven=true;
	public Boolean cargarid_mensaje_correo_invenDetalleMensajeCorreoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mensaje_correo_invenDetalleMensajeCorreoInven=false;//ConEventDepend=true

	public Border resaltarid_empresaDetalleMensajeCorreoInven=null;
	public Boolean mostrarid_empresaDetalleMensajeCorreoInven=true;
	public Boolean activarid_empresaDetalleMensajeCorreoInven=true;
	public Boolean cargarid_empresaDetalleMensajeCorreoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleMensajeCorreoInven=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleMensajeCorreoInven=null;
	public Boolean mostrarid_sucursalDetalleMensajeCorreoInven=true;
	public Boolean activarid_sucursalDetalleMensajeCorreoInven=true;
	public Boolean cargarid_sucursalDetalleMensajeCorreoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleMensajeCorreoInven=false;//ConEventDepend=true

	public Border resaltarid_moduloDetalleMensajeCorreoInven=null;
	public Boolean mostrarid_moduloDetalleMensajeCorreoInven=true;
	public Boolean activarid_moduloDetalleMensajeCorreoInven=true;
	public Boolean cargarid_moduloDetalleMensajeCorreoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloDetalleMensajeCorreoInven=false;//ConEventDepend=true

	public Border resaltarid_usuarioDetalleMensajeCorreoInven=null;
	public Boolean mostrarid_usuarioDetalleMensajeCorreoInven=true;
	public Boolean activarid_usuarioDetalleMensajeCorreoInven=true;
	public Boolean cargarid_usuarioDetalleMensajeCorreoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioDetalleMensajeCorreoInven=false;//ConEventDepend=true

	public Border resaltarid_empleadoDetalleMensajeCorreoInven=null;
	public Boolean mostrarid_empleadoDetalleMensajeCorreoInven=true;
	public Boolean activarid_empleadoDetalleMensajeCorreoInven=true;
	public Boolean cargarid_empleadoDetalleMensajeCorreoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoDetalleMensajeCorreoInven=false;//ConEventDepend=true

	public Border resaltaresta_activoDetalleMensajeCorreoInven=null;
	public Boolean mostraresta_activoDetalleMensajeCorreoInven=true;
	public Boolean activaresta_activoDetalleMensajeCorreoInven=true;

	
	

	public Border setResaltaridDetalleMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMensajeCorreoInvenBeanSwingJInternalFrame detallemensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallemensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarDetalleMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltaridDetalleMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleMensajeCorreoInven() {
		return this.resaltaridDetalleMensajeCorreoInven;
	}

	public void setResaltaridDetalleMensajeCorreoInven(Border borderResaltar) {
		this.resaltaridDetalleMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostraridDetalleMensajeCorreoInven() {
		return this.mostraridDetalleMensajeCorreoInven;
	}

	public void setMostraridDetalleMensajeCorreoInven(Boolean mostraridDetalleMensajeCorreoInven) {
		this.mostraridDetalleMensajeCorreoInven= mostraridDetalleMensajeCorreoInven;
	}

	public Boolean getActivaridDetalleMensajeCorreoInven() {
		return this.activaridDetalleMensajeCorreoInven;
	}

	public void setActivaridDetalleMensajeCorreoInven(Boolean activaridDetalleMensajeCorreoInven) {
		this.activaridDetalleMensajeCorreoInven= activaridDetalleMensajeCorreoInven;
	}

	public Border setResaltarid_mensaje_correo_invenDetalleMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMensajeCorreoInvenBeanSwingJInternalFrame detallemensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallemensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarDetalleMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarid_mensaje_correo_invenDetalleMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mensaje_correo_invenDetalleMensajeCorreoInven() {
		return this.resaltarid_mensaje_correo_invenDetalleMensajeCorreoInven;
	}

	public void setResaltarid_mensaje_correo_invenDetalleMensajeCorreoInven(Border borderResaltar) {
		this.resaltarid_mensaje_correo_invenDetalleMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarid_mensaje_correo_invenDetalleMensajeCorreoInven() {
		return this.mostrarid_mensaje_correo_invenDetalleMensajeCorreoInven;
	}

	public void setMostrarid_mensaje_correo_invenDetalleMensajeCorreoInven(Boolean mostrarid_mensaje_correo_invenDetalleMensajeCorreoInven) {
		this.mostrarid_mensaje_correo_invenDetalleMensajeCorreoInven= mostrarid_mensaje_correo_invenDetalleMensajeCorreoInven;
	}

	public Boolean getActivarid_mensaje_correo_invenDetalleMensajeCorreoInven() {
		return this.activarid_mensaje_correo_invenDetalleMensajeCorreoInven;
	}

	public void setActivarid_mensaje_correo_invenDetalleMensajeCorreoInven(Boolean activarid_mensaje_correo_invenDetalleMensajeCorreoInven) {
		this.activarid_mensaje_correo_invenDetalleMensajeCorreoInven= activarid_mensaje_correo_invenDetalleMensajeCorreoInven;
	}

	public Boolean getCargarid_mensaje_correo_invenDetalleMensajeCorreoInven() {
		return this.cargarid_mensaje_correo_invenDetalleMensajeCorreoInven;
	}

	public void setCargarid_mensaje_correo_invenDetalleMensajeCorreoInven(Boolean cargarid_mensaje_correo_invenDetalleMensajeCorreoInven) {
		this.cargarid_mensaje_correo_invenDetalleMensajeCorreoInven= cargarid_mensaje_correo_invenDetalleMensajeCorreoInven;
	}

	public Border setResaltarid_empresaDetalleMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMensajeCorreoInvenBeanSwingJInternalFrame detallemensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallemensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarDetalleMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleMensajeCorreoInven() {
		return this.resaltarid_empresaDetalleMensajeCorreoInven;
	}

	public void setResaltarid_empresaDetalleMensajeCorreoInven(Border borderResaltar) {
		this.resaltarid_empresaDetalleMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleMensajeCorreoInven() {
		return this.mostrarid_empresaDetalleMensajeCorreoInven;
	}

	public void setMostrarid_empresaDetalleMensajeCorreoInven(Boolean mostrarid_empresaDetalleMensajeCorreoInven) {
		this.mostrarid_empresaDetalleMensajeCorreoInven= mostrarid_empresaDetalleMensajeCorreoInven;
	}

	public Boolean getActivarid_empresaDetalleMensajeCorreoInven() {
		return this.activarid_empresaDetalleMensajeCorreoInven;
	}

	public void setActivarid_empresaDetalleMensajeCorreoInven(Boolean activarid_empresaDetalleMensajeCorreoInven) {
		this.activarid_empresaDetalleMensajeCorreoInven= activarid_empresaDetalleMensajeCorreoInven;
	}

	public Boolean getCargarid_empresaDetalleMensajeCorreoInven() {
		return this.cargarid_empresaDetalleMensajeCorreoInven;
	}

	public void setCargarid_empresaDetalleMensajeCorreoInven(Boolean cargarid_empresaDetalleMensajeCorreoInven) {
		this.cargarid_empresaDetalleMensajeCorreoInven= cargarid_empresaDetalleMensajeCorreoInven;
	}

	public Border setResaltarid_sucursalDetalleMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMensajeCorreoInvenBeanSwingJInternalFrame detallemensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallemensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarDetalleMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleMensajeCorreoInven() {
		return this.resaltarid_sucursalDetalleMensajeCorreoInven;
	}

	public void setResaltarid_sucursalDetalleMensajeCorreoInven(Border borderResaltar) {
		this.resaltarid_sucursalDetalleMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleMensajeCorreoInven() {
		return this.mostrarid_sucursalDetalleMensajeCorreoInven;
	}

	public void setMostrarid_sucursalDetalleMensajeCorreoInven(Boolean mostrarid_sucursalDetalleMensajeCorreoInven) {
		this.mostrarid_sucursalDetalleMensajeCorreoInven= mostrarid_sucursalDetalleMensajeCorreoInven;
	}

	public Boolean getActivarid_sucursalDetalleMensajeCorreoInven() {
		return this.activarid_sucursalDetalleMensajeCorreoInven;
	}

	public void setActivarid_sucursalDetalleMensajeCorreoInven(Boolean activarid_sucursalDetalleMensajeCorreoInven) {
		this.activarid_sucursalDetalleMensajeCorreoInven= activarid_sucursalDetalleMensajeCorreoInven;
	}

	public Boolean getCargarid_sucursalDetalleMensajeCorreoInven() {
		return this.cargarid_sucursalDetalleMensajeCorreoInven;
	}

	public void setCargarid_sucursalDetalleMensajeCorreoInven(Boolean cargarid_sucursalDetalleMensajeCorreoInven) {
		this.cargarid_sucursalDetalleMensajeCorreoInven= cargarid_sucursalDetalleMensajeCorreoInven;
	}

	public Border setResaltarid_moduloDetalleMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMensajeCorreoInvenBeanSwingJInternalFrame detallemensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallemensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarDetalleMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarid_moduloDetalleMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloDetalleMensajeCorreoInven() {
		return this.resaltarid_moduloDetalleMensajeCorreoInven;
	}

	public void setResaltarid_moduloDetalleMensajeCorreoInven(Border borderResaltar) {
		this.resaltarid_moduloDetalleMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarid_moduloDetalleMensajeCorreoInven() {
		return this.mostrarid_moduloDetalleMensajeCorreoInven;
	}

	public void setMostrarid_moduloDetalleMensajeCorreoInven(Boolean mostrarid_moduloDetalleMensajeCorreoInven) {
		this.mostrarid_moduloDetalleMensajeCorreoInven= mostrarid_moduloDetalleMensajeCorreoInven;
	}

	public Boolean getActivarid_moduloDetalleMensajeCorreoInven() {
		return this.activarid_moduloDetalleMensajeCorreoInven;
	}

	public void setActivarid_moduloDetalleMensajeCorreoInven(Boolean activarid_moduloDetalleMensajeCorreoInven) {
		this.activarid_moduloDetalleMensajeCorreoInven= activarid_moduloDetalleMensajeCorreoInven;
	}

	public Boolean getCargarid_moduloDetalleMensajeCorreoInven() {
		return this.cargarid_moduloDetalleMensajeCorreoInven;
	}

	public void setCargarid_moduloDetalleMensajeCorreoInven(Boolean cargarid_moduloDetalleMensajeCorreoInven) {
		this.cargarid_moduloDetalleMensajeCorreoInven= cargarid_moduloDetalleMensajeCorreoInven;
	}

	public Border setResaltarid_usuarioDetalleMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMensajeCorreoInvenBeanSwingJInternalFrame detallemensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallemensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarDetalleMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarid_usuarioDetalleMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioDetalleMensajeCorreoInven() {
		return this.resaltarid_usuarioDetalleMensajeCorreoInven;
	}

	public void setResaltarid_usuarioDetalleMensajeCorreoInven(Border borderResaltar) {
		this.resaltarid_usuarioDetalleMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarid_usuarioDetalleMensajeCorreoInven() {
		return this.mostrarid_usuarioDetalleMensajeCorreoInven;
	}

	public void setMostrarid_usuarioDetalleMensajeCorreoInven(Boolean mostrarid_usuarioDetalleMensajeCorreoInven) {
		this.mostrarid_usuarioDetalleMensajeCorreoInven= mostrarid_usuarioDetalleMensajeCorreoInven;
	}

	public Boolean getActivarid_usuarioDetalleMensajeCorreoInven() {
		return this.activarid_usuarioDetalleMensajeCorreoInven;
	}

	public void setActivarid_usuarioDetalleMensajeCorreoInven(Boolean activarid_usuarioDetalleMensajeCorreoInven) {
		this.activarid_usuarioDetalleMensajeCorreoInven= activarid_usuarioDetalleMensajeCorreoInven;
	}

	public Boolean getCargarid_usuarioDetalleMensajeCorreoInven() {
		return this.cargarid_usuarioDetalleMensajeCorreoInven;
	}

	public void setCargarid_usuarioDetalleMensajeCorreoInven(Boolean cargarid_usuarioDetalleMensajeCorreoInven) {
		this.cargarid_usuarioDetalleMensajeCorreoInven= cargarid_usuarioDetalleMensajeCorreoInven;
	}

	public Border setResaltarid_empleadoDetalleMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMensajeCorreoInvenBeanSwingJInternalFrame detallemensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallemensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarDetalleMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltarid_empleadoDetalleMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoDetalleMensajeCorreoInven() {
		return this.resaltarid_empleadoDetalleMensajeCorreoInven;
	}

	public void setResaltarid_empleadoDetalleMensajeCorreoInven(Border borderResaltar) {
		this.resaltarid_empleadoDetalleMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostrarid_empleadoDetalleMensajeCorreoInven() {
		return this.mostrarid_empleadoDetalleMensajeCorreoInven;
	}

	public void setMostrarid_empleadoDetalleMensajeCorreoInven(Boolean mostrarid_empleadoDetalleMensajeCorreoInven) {
		this.mostrarid_empleadoDetalleMensajeCorreoInven= mostrarid_empleadoDetalleMensajeCorreoInven;
	}

	public Boolean getActivarid_empleadoDetalleMensajeCorreoInven() {
		return this.activarid_empleadoDetalleMensajeCorreoInven;
	}

	public void setActivarid_empleadoDetalleMensajeCorreoInven(Boolean activarid_empleadoDetalleMensajeCorreoInven) {
		this.activarid_empleadoDetalleMensajeCorreoInven= activarid_empleadoDetalleMensajeCorreoInven;
	}

	public Boolean getCargarid_empleadoDetalleMensajeCorreoInven() {
		return this.cargarid_empleadoDetalleMensajeCorreoInven;
	}

	public void setCargarid_empleadoDetalleMensajeCorreoInven(Boolean cargarid_empleadoDetalleMensajeCorreoInven) {
		this.cargarid_empleadoDetalleMensajeCorreoInven= cargarid_empleadoDetalleMensajeCorreoInven;
	}

	public Border setResaltaresta_activoDetalleMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMensajeCorreoInvenBeanSwingJInternalFrame detallemensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallemensajecorreoinvenBeanSwingJInternalFrame.jTtoolBarDetalleMensajeCorreoInven.setBorder(borderResaltar);
		
		this.resaltaresta_activoDetalleMensajeCorreoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoDetalleMensajeCorreoInven() {
		return this.resaltaresta_activoDetalleMensajeCorreoInven;
	}

	public void setResaltaresta_activoDetalleMensajeCorreoInven(Border borderResaltar) {
		this.resaltaresta_activoDetalleMensajeCorreoInven= borderResaltar;
	}

	public Boolean getMostraresta_activoDetalleMensajeCorreoInven() {
		return this.mostraresta_activoDetalleMensajeCorreoInven;
	}

	public void setMostraresta_activoDetalleMensajeCorreoInven(Boolean mostraresta_activoDetalleMensajeCorreoInven) {
		this.mostraresta_activoDetalleMensajeCorreoInven= mostraresta_activoDetalleMensajeCorreoInven;
	}

	public Boolean getActivaresta_activoDetalleMensajeCorreoInven() {
		return this.activaresta_activoDetalleMensajeCorreoInven;
	}

	public void setActivaresta_activoDetalleMensajeCorreoInven(Boolean activaresta_activoDetalleMensajeCorreoInven) {
		this.activaresta_activoDetalleMensajeCorreoInven= activaresta_activoDetalleMensajeCorreoInven;
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
		
		
		this.setMostraridDetalleMensajeCorreoInven(esInicial);
		this.setMostrarid_mensaje_correo_invenDetalleMensajeCorreoInven(esInicial);
		this.setMostrarid_empresaDetalleMensajeCorreoInven(esInicial);
		this.setMostrarid_sucursalDetalleMensajeCorreoInven(esInicial);
		this.setMostrarid_moduloDetalleMensajeCorreoInven(esInicial);
		this.setMostrarid_usuarioDetalleMensajeCorreoInven(esInicial);
		this.setMostrarid_empleadoDetalleMensajeCorreoInven(esInicial);
		this.setMostraresta_activoDetalleMensajeCorreoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.ID)) {
				this.setMostraridDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN)) {
				this.setMostrarid_mensaje_correo_invenDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoDetalleMensajeCorreoInven(esAsigna);
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
		
		
		this.setActivaridDetalleMensajeCorreoInven(esInicial);
		this.setActivarid_mensaje_correo_invenDetalleMensajeCorreoInven(esInicial);
		this.setActivarid_empresaDetalleMensajeCorreoInven(esInicial);
		this.setActivarid_sucursalDetalleMensajeCorreoInven(esInicial);
		this.setActivarid_moduloDetalleMensajeCorreoInven(esInicial);
		this.setActivarid_usuarioDetalleMensajeCorreoInven(esInicial);
		this.setActivarid_empleadoDetalleMensajeCorreoInven(esInicial);
		this.setActivaresta_activoDetalleMensajeCorreoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.ID)) {
				this.setActivaridDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN)) {
				this.setActivarid_mensaje_correo_invenDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoDetalleMensajeCorreoInven(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleMensajeCorreoInvenBeanSwingJInternalFrame detallemensajecorreoinvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleMensajeCorreoInven(esInicial);
		this.setResaltarid_mensaje_correo_invenDetalleMensajeCorreoInven(esInicial);
		this.setResaltarid_empresaDetalleMensajeCorreoInven(esInicial);
		this.setResaltarid_sucursalDetalleMensajeCorreoInven(esInicial);
		this.setResaltarid_moduloDetalleMensajeCorreoInven(esInicial);
		this.setResaltarid_usuarioDetalleMensajeCorreoInven(esInicial);
		this.setResaltarid_empleadoDetalleMensajeCorreoInven(esInicial);
		this.setResaltaresta_activoDetalleMensajeCorreoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.ID)) {
				this.setResaltaridDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN)) {
				this.setResaltarid_mensaje_correo_invenDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoDetalleMensajeCorreoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMensajeCorreoInvenConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoDetalleMensajeCorreoInven(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleMensajeCorreoInvenBeanSwingJInternalFrame detallemensajecorreoinvenBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoDetalleMensajeCorreoInven=true;

	public Boolean getMostrarFK_IdEmpleadoDetalleMensajeCorreoInven() {
		return this.mostrarFK_IdEmpleadoDetalleMensajeCorreoInven;
	}

	public void setMostrarFK_IdEmpleadoDetalleMensajeCorreoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoDetalleMensajeCorreoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleMensajeCorreoInven=true;

	public Boolean getMostrarFK_IdEmpresaDetalleMensajeCorreoInven() {
		return this.mostrarFK_IdEmpresaDetalleMensajeCorreoInven;
	}

	public void setMostrarFK_IdEmpresaDetalleMensajeCorreoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleMensajeCorreoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMensajeCorreoInvenDetalleMensajeCorreoInven=true;

	public Boolean getMostrarFK_IdMensajeCorreoInvenDetalleMensajeCorreoInven() {
		return this.mostrarFK_IdMensajeCorreoInvenDetalleMensajeCorreoInven;
	}

	public void setMostrarFK_IdMensajeCorreoInvenDetalleMensajeCorreoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMensajeCorreoInvenDetalleMensajeCorreoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloDetalleMensajeCorreoInven=true;

	public Boolean getMostrarFK_IdModuloDetalleMensajeCorreoInven() {
		return this.mostrarFK_IdModuloDetalleMensajeCorreoInven;
	}

	public void setMostrarFK_IdModuloDetalleMensajeCorreoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloDetalleMensajeCorreoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleMensajeCorreoInven=true;

	public Boolean getMostrarFK_IdSucursalDetalleMensajeCorreoInven() {
		return this.mostrarFK_IdSucursalDetalleMensajeCorreoInven;
	}

	public void setMostrarFK_IdSucursalDetalleMensajeCorreoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleMensajeCorreoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioDetalleMensajeCorreoInven=true;

	public Boolean getMostrarFK_IdUsuarioDetalleMensajeCorreoInven() {
		return this.mostrarFK_IdUsuarioDetalleMensajeCorreoInven;
	}

	public void setMostrarFK_IdUsuarioDetalleMensajeCorreoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioDetalleMensajeCorreoInven= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoDetalleMensajeCorreoInven=true;

	public Boolean getActivarFK_IdEmpleadoDetalleMensajeCorreoInven() {
		return this.activarFK_IdEmpleadoDetalleMensajeCorreoInven;
	}

	public void setActivarFK_IdEmpleadoDetalleMensajeCorreoInven(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoDetalleMensajeCorreoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleMensajeCorreoInven=true;

	public Boolean getActivarFK_IdEmpresaDetalleMensajeCorreoInven() {
		return this.activarFK_IdEmpresaDetalleMensajeCorreoInven;
	}

	public void setActivarFK_IdEmpresaDetalleMensajeCorreoInven(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleMensajeCorreoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdMensajeCorreoInvenDetalleMensajeCorreoInven=true;

	public Boolean getActivarFK_IdMensajeCorreoInvenDetalleMensajeCorreoInven() {
		return this.activarFK_IdMensajeCorreoInvenDetalleMensajeCorreoInven;
	}

	public void setActivarFK_IdMensajeCorreoInvenDetalleMensajeCorreoInven(Boolean habilitarResaltar) {
		this.activarFK_IdMensajeCorreoInvenDetalleMensajeCorreoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloDetalleMensajeCorreoInven=true;

	public Boolean getActivarFK_IdModuloDetalleMensajeCorreoInven() {
		return this.activarFK_IdModuloDetalleMensajeCorreoInven;
	}

	public void setActivarFK_IdModuloDetalleMensajeCorreoInven(Boolean habilitarResaltar) {
		this.activarFK_IdModuloDetalleMensajeCorreoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleMensajeCorreoInven=true;

	public Boolean getActivarFK_IdSucursalDetalleMensajeCorreoInven() {
		return this.activarFK_IdSucursalDetalleMensajeCorreoInven;
	}

	public void setActivarFK_IdSucursalDetalleMensajeCorreoInven(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleMensajeCorreoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioDetalleMensajeCorreoInven=true;

	public Boolean getActivarFK_IdUsuarioDetalleMensajeCorreoInven() {
		return this.activarFK_IdUsuarioDetalleMensajeCorreoInven;
	}

	public void setActivarFK_IdUsuarioDetalleMensajeCorreoInven(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioDetalleMensajeCorreoInven= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoDetalleMensajeCorreoInven=null;

	public Border getResaltarFK_IdEmpleadoDetalleMensajeCorreoInven() {
		return this.resaltarFK_IdEmpleadoDetalleMensajeCorreoInven;
	}

	public void setResaltarFK_IdEmpleadoDetalleMensajeCorreoInven(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoDetalleMensajeCorreoInven= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoDetalleMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMensajeCorreoInvenBeanSwingJInternalFrame detallemensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoDetalleMensajeCorreoInven= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleMensajeCorreoInven=null;

	public Border getResaltarFK_IdEmpresaDetalleMensajeCorreoInven() {
		return this.resaltarFK_IdEmpresaDetalleMensajeCorreoInven;
	}

	public void setResaltarFK_IdEmpresaDetalleMensajeCorreoInven(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleMensajeCorreoInven= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMensajeCorreoInvenBeanSwingJInternalFrame detallemensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleMensajeCorreoInven= borderResaltar;
	}

	public Border resaltarFK_IdMensajeCorreoInvenDetalleMensajeCorreoInven=null;

	public Border getResaltarFK_IdMensajeCorreoInvenDetalleMensajeCorreoInven() {
		return this.resaltarFK_IdMensajeCorreoInvenDetalleMensajeCorreoInven;
	}

	public void setResaltarFK_IdMensajeCorreoInvenDetalleMensajeCorreoInven(Border borderResaltar) {
		this.resaltarFK_IdMensajeCorreoInvenDetalleMensajeCorreoInven= borderResaltar;
	}

	public void setResaltarFK_IdMensajeCorreoInvenDetalleMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMensajeCorreoInvenBeanSwingJInternalFrame detallemensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMensajeCorreoInvenDetalleMensajeCorreoInven= borderResaltar;
	}

	public Border resaltarFK_IdModuloDetalleMensajeCorreoInven=null;

	public Border getResaltarFK_IdModuloDetalleMensajeCorreoInven() {
		return this.resaltarFK_IdModuloDetalleMensajeCorreoInven;
	}

	public void setResaltarFK_IdModuloDetalleMensajeCorreoInven(Border borderResaltar) {
		this.resaltarFK_IdModuloDetalleMensajeCorreoInven= borderResaltar;
	}

	public void setResaltarFK_IdModuloDetalleMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMensajeCorreoInvenBeanSwingJInternalFrame detallemensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloDetalleMensajeCorreoInven= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleMensajeCorreoInven=null;

	public Border getResaltarFK_IdSucursalDetalleMensajeCorreoInven() {
		return this.resaltarFK_IdSucursalDetalleMensajeCorreoInven;
	}

	public void setResaltarFK_IdSucursalDetalleMensajeCorreoInven(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleMensajeCorreoInven= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMensajeCorreoInvenBeanSwingJInternalFrame detallemensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleMensajeCorreoInven= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioDetalleMensajeCorreoInven=null;

	public Border getResaltarFK_IdUsuarioDetalleMensajeCorreoInven() {
		return this.resaltarFK_IdUsuarioDetalleMensajeCorreoInven;
	}

	public void setResaltarFK_IdUsuarioDetalleMensajeCorreoInven(Border borderResaltar) {
		this.resaltarFK_IdUsuarioDetalleMensajeCorreoInven= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioDetalleMensajeCorreoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMensajeCorreoInvenBeanSwingJInternalFrame detallemensajecorreoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioDetalleMensajeCorreoInven= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}