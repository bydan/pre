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


import com.bydan.erp.cartera.util.NovedadConstantesFunciones;
import com.bydan.erp.cartera.util.NovedadParameterReturnGeneral;
//import com.bydan.erp.cartera.util.NovedadParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class NovedadConstantesFunciones extends NovedadConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Novedad";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Novedad"+NovedadConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="NovedadHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="NovedadHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=NovedadConstantesFunciones.SCHEMA+"_"+NovedadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/NovedadHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=NovedadConstantesFunciones.SCHEMA+"_"+NovedadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=NovedadConstantesFunciones.SCHEMA+"_"+NovedadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/NovedadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=NovedadConstantesFunciones.SCHEMA+"_"+NovedadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NovedadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NovedadHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NovedadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NovedadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NovedadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NovedadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=NovedadConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+NovedadConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=NovedadConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+NovedadConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Novedades";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Novedad";
	public static final String SCLASSWEBTITULO_LOWER="Novedad";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Novedad";
	public static final String OBJECTNAME="novedad";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="novedad";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select novedad from "+NovedadConstantesFunciones.SPERSISTENCENAME+" novedad";
	public static String QUERYSELECTNATIVE="select "+NovedadConstantesFunciones.SCHEMA+"."+NovedadConstantesFunciones.TABLENAME+".id,"+NovedadConstantesFunciones.SCHEMA+"."+NovedadConstantesFunciones.TABLENAME+".version_row,"+NovedadConstantesFunciones.SCHEMA+"."+NovedadConstantesFunciones.TABLENAME+".id_empresa,"+NovedadConstantesFunciones.SCHEMA+"."+NovedadConstantesFunciones.TABLENAME+".id_sucursal,"+NovedadConstantesFunciones.SCHEMA+"."+NovedadConstantesFunciones.TABLENAME+".id_usuario,"+NovedadConstantesFunciones.SCHEMA+"."+NovedadConstantesFunciones.TABLENAME+".id_cliente,"+NovedadConstantesFunciones.SCHEMA+"."+NovedadConstantesFunciones.TABLENAME+".descripcion,"+NovedadConstantesFunciones.SCHEMA+"."+NovedadConstantesFunciones.TABLENAME+".accion_tomada,"+NovedadConstantesFunciones.SCHEMA+"."+NovedadConstantesFunciones.TABLENAME+".feha_atencion,"+NovedadConstantesFunciones.SCHEMA+"."+NovedadConstantesFunciones.TABLENAME+".hora_atencion,"+NovedadConstantesFunciones.SCHEMA+"."+NovedadConstantesFunciones.TABLENAME+".id_empleado,"+NovedadConstantesFunciones.SCHEMA+"."+NovedadConstantesFunciones.TABLENAME+".email,"+NovedadConstantesFunciones.SCHEMA+"."+NovedadConstantesFunciones.TABLENAME+".esta_activo from "+NovedadConstantesFunciones.SCHEMA+"."+NovedadConstantesFunciones.TABLENAME;//+" as "+NovedadConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected NovedadConstantesFuncionesAdditional novedadConstantesFuncionesAdditional=null;
	
	public NovedadConstantesFuncionesAdditional getNovedadConstantesFuncionesAdditional() {
		return this.novedadConstantesFuncionesAdditional;
	}
	
	public void setNovedadConstantesFuncionesAdditional(NovedadConstantesFuncionesAdditional novedadConstantesFuncionesAdditional) {
		try {
			this.novedadConstantesFuncionesAdditional=novedadConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDCLIENTE= "id_cliente";
    public static final String DESCRIPCION= "descripcion";
    public static final String ACCIONTOMADA= "accion_tomada";
    public static final String FEHAATENCION= "feha_atencion";
    public static final String HORAATENCION= "hora_atencion";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String EMAIL= "email";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_ACCIONTOMADA= "Accion Tomada";
		public static final String LABEL_ACCIONTOMADA_LOWER= "Accion Tomada";
    	public static final String LABEL_FEHAATENCION= "Feha Atencion";
		public static final String LABEL_FEHAATENCION_LOWER= "Feha Atencion";
    	public static final String LABEL_HORAATENCION= "Hora Atencion";
		public static final String LABEL_HORAATENCION_LOWER= "Hora Atencion";
    	public static final String LABEL_IDEMPLEADO= "Responsable";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_EMAIL= "Email";
		public static final String LABEL_EMAIL_LOWER= "Email";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXACCION_TOMADA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXACCION_TOMADA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXEMAIL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXEMAIL=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getNovedadLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(NovedadConstantesFunciones.IDEMPRESA)) {sLabelColumna=NovedadConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(NovedadConstantesFunciones.IDSUCURSAL)) {sLabelColumna=NovedadConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(NovedadConstantesFunciones.IDUSUARIO)) {sLabelColumna=NovedadConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(NovedadConstantesFunciones.IDCLIENTE)) {sLabelColumna=NovedadConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(NovedadConstantesFunciones.DESCRIPCION)) {sLabelColumna=NovedadConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(NovedadConstantesFunciones.ACCIONTOMADA)) {sLabelColumna=NovedadConstantesFunciones.LABEL_ACCIONTOMADA;}
		if(sNombreColumna.equals(NovedadConstantesFunciones.FEHAATENCION)) {sLabelColumna=NovedadConstantesFunciones.LABEL_FEHAATENCION;}
		if(sNombreColumna.equals(NovedadConstantesFunciones.HORAATENCION)) {sLabelColumna=NovedadConstantesFunciones.LABEL_HORAATENCION;}
		if(sNombreColumna.equals(NovedadConstantesFunciones.IDEMPLEADO)) {sLabelColumna=NovedadConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(NovedadConstantesFunciones.EMAIL)) {sLabelColumna=NovedadConstantesFunciones.LABEL_EMAIL;}
		if(sNombreColumna.equals(NovedadConstantesFunciones.ESTAACTIVO)) {sLabelColumna=NovedadConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(Novedad novedad) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!novedad.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(Novedad novedad) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(novedad.getId(),novedad.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getNovedadDescripcion(Novedad novedad) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(novedad !=null/* && novedad.getId()!=0*/) {
			if(novedad.getId()!=null) {
				sDescripcion=novedad.getId().toString();
			}//novedadnovedad.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getNovedadDescripcionDetallado(Novedad novedad) {
		String sDescripcion="";
			
		sDescripcion+=NovedadConstantesFunciones.ID+"=";
		sDescripcion+=novedad.getId().toString()+",";
		sDescripcion+=NovedadConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=novedad.getVersionRow().toString()+",";
		sDescripcion+=NovedadConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=novedad.getid_empresa().toString()+",";
		sDescripcion+=NovedadConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=novedad.getid_sucursal().toString()+",";
		sDescripcion+=NovedadConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=novedad.getid_usuario().toString()+",";
		sDescripcion+=NovedadConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=novedad.getid_cliente().toString()+",";
		sDescripcion+=NovedadConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=novedad.getdescripcion()+",";
		sDescripcion+=NovedadConstantesFunciones.ACCIONTOMADA+"=";
		sDescripcion+=novedad.getaccion_tomada()+",";
		sDescripcion+=NovedadConstantesFunciones.FEHAATENCION+"=";
		sDescripcion+=novedad.getfeha_atencion().toString()+",";
		sDescripcion+=NovedadConstantesFunciones.HORAATENCION+"=";
		sDescripcion+=novedad.gethora_atencion().toString()+",";
		sDescripcion+=NovedadConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=novedad.getid_empleado().toString()+",";
		sDescripcion+=NovedadConstantesFunciones.EMAIL+"=";
		sDescripcion+=novedad.getemail()+",";
		sDescripcion+=NovedadConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=novedad.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setNovedadDescripcion(Novedad novedad,String sValor) throws Exception {			
		if(novedad !=null) {
			//novedadnovedad.getId().toString();
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
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
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Responsable";
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

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Responsable="+id_empleado.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosNovedad(Novedad novedad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		novedad.setdescripcion(novedad.getdescripcion().trim());
		novedad.setaccion_tomada(novedad.getaccion_tomada().trim());
		novedad.setemail(novedad.getemail().trim());
	}
	
	public static void quitarEspaciosNovedads(List<Novedad> novedads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Novedad novedad: novedads) {
			novedad.setdescripcion(novedad.getdescripcion().trim());
			novedad.setaccion_tomada(novedad.getaccion_tomada().trim());
			novedad.setemail(novedad.getemail().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNovedad(Novedad novedad,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && novedad.getConCambioAuxiliar()) {
			novedad.setIsDeleted(novedad.getIsDeletedAuxiliar());	
			novedad.setIsNew(novedad.getIsNewAuxiliar());	
			novedad.setIsChanged(novedad.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			novedad.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			novedad.setIsDeletedAuxiliar(false);	
			novedad.setIsNewAuxiliar(false);	
			novedad.setIsChangedAuxiliar(false);
			
			novedad.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNovedads(List<Novedad> novedads,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Novedad novedad : novedads) {
			if(conAsignarBase && novedad.getConCambioAuxiliar()) {
				novedad.setIsDeleted(novedad.getIsDeletedAuxiliar());	
				novedad.setIsNew(novedad.getIsNewAuxiliar());	
				novedad.setIsChanged(novedad.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				novedad.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				novedad.setIsDeletedAuxiliar(false);	
				novedad.setIsNewAuxiliar(false);	
				novedad.setIsChangedAuxiliar(false);
				
				novedad.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresNovedad(Novedad novedad,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresNovedads(List<Novedad> novedads,Boolean conEnteros) throws Exception  {
		
		for(Novedad novedad: novedads) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaNovedad(List<Novedad> novedads,Novedad novedadAux) throws Exception  {
		NovedadConstantesFunciones.InicializarValoresNovedad(novedadAux,true);
		
		for(Novedad novedad: novedads) {
			if(novedad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNovedad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=NovedadConstantesFunciones.getArrayColumnasGlobalesNovedad(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesNovedad(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NovedadConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NovedadConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NovedadConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NovedadConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NovedadConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NovedadConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoNovedad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Novedad> novedads,Novedad novedad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Novedad novedadAux: novedads) {
			if(novedadAux!=null && novedad!=null) {
				if((novedadAux.getId()==null && novedad.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(novedadAux.getId()!=null && novedad.getId()!=null){
					if(novedadAux.getId().equals(novedad.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaNovedad(List<Novedad> novedads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Novedad novedad: novedads) {			
			if(novedad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaNovedad() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,NovedadConstantesFunciones.LABEL_ID, NovedadConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadConstantesFunciones.LABEL_VERSIONROW, NovedadConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadConstantesFunciones.LABEL_IDEMPRESA, NovedadConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadConstantesFunciones.LABEL_IDSUCURSAL, NovedadConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadConstantesFunciones.LABEL_IDUSUARIO, NovedadConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadConstantesFunciones.LABEL_IDCLIENTE, NovedadConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadConstantesFunciones.LABEL_DESCRIPCION, NovedadConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadConstantesFunciones.LABEL_ACCIONTOMADA, NovedadConstantesFunciones.ACCIONTOMADA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadConstantesFunciones.LABEL_FEHAATENCION, NovedadConstantesFunciones.FEHAATENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadConstantesFunciones.LABEL_HORAATENCION, NovedadConstantesFunciones.HORAATENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadConstantesFunciones.LABEL_IDEMPLEADO, NovedadConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadConstantesFunciones.LABEL_EMAIL, NovedadConstantesFunciones.EMAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadConstantesFunciones.LABEL_ESTAACTIVO, NovedadConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasNovedad() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=NovedadConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadConstantesFunciones.ACCIONTOMADA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadConstantesFunciones.FEHAATENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadConstantesFunciones.HORAATENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadConstantesFunciones.EMAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNovedad() throws Exception  {
		return NovedadConstantesFunciones.getTiposSeleccionarNovedad(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNovedad(Boolean conFk) throws Exception  {
		return NovedadConstantesFunciones.getTiposSeleccionarNovedad(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNovedad(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(NovedadConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(NovedadConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(NovedadConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(NovedadConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(NovedadConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadConstantesFunciones.LABEL_ACCIONTOMADA);
			reporte.setsDescripcion(NovedadConstantesFunciones.LABEL_ACCIONTOMADA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadConstantesFunciones.LABEL_FEHAATENCION);
			reporte.setsDescripcion(NovedadConstantesFunciones.LABEL_FEHAATENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(NovedadConstantesFunciones.LABEL_HORAATENCION);
		reporte.setsDescripcion(NovedadConstantesFunciones.LABEL_HORAATENCION);

		arrTiposSeleccionarTodos.add(reporte);
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(NovedadConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadConstantesFunciones.LABEL_EMAIL);
			reporte.setsDescripcion(NovedadConstantesFunciones.LABEL_EMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(NovedadConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesNovedad(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesNovedad(Novedad novedadAux) throws Exception {
		
			novedadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(novedadAux.getEmpresa()));
			novedadAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(novedadAux.getSucursal()));
			novedadAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(novedadAux.getUsuario()));
			novedadAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(novedadAux.getCliente()));
			novedadAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(novedadAux.getEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesNovedad(List<Novedad> novedadsTemp) throws Exception {
		for(Novedad novedadAux:novedadsTemp) {
			
			novedadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(novedadAux.getEmpresa()));
			novedadAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(novedadAux.getSucursal()));
			novedadAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(novedadAux.getUsuario()));
			novedadAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(novedadAux.getCliente()));
			novedadAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(novedadAux.getEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfNovedad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Empleado.class));
				
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
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfNovedad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfNovedad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return NovedadConstantesFunciones.getClassesRelationshipsOfNovedad(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNovedad(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNovedad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return NovedadConstantesFunciones.getClassesRelationshipsFromStringsOfNovedad(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNovedad(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Novedad novedad,List<Novedad> novedads,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Novedad novedadEncontrado=null;
			
			for(Novedad novedadLocal:novedads) {
				if(novedadLocal.getId().equals(novedad.getId())) {
					novedadEncontrado=novedadLocal;
					
					novedadLocal.setIsChanged(novedad.getIsChanged());
					novedadLocal.setIsNew(novedad.getIsNew());
					novedadLocal.setIsDeleted(novedad.getIsDeleted());
					
					novedadLocal.setGeneralEntityOriginal(novedad.getGeneralEntityOriginal());
					
					novedadLocal.setId(novedad.getId());	
					novedadLocal.setVersionRow(novedad.getVersionRow());	
					novedadLocal.setid_empresa(novedad.getid_empresa());	
					novedadLocal.setid_sucursal(novedad.getid_sucursal());	
					novedadLocal.setid_usuario(novedad.getid_usuario());	
					novedadLocal.setid_cliente(novedad.getid_cliente());	
					novedadLocal.setdescripcion(novedad.getdescripcion());	
					novedadLocal.setaccion_tomada(novedad.getaccion_tomada());	
					novedadLocal.setfeha_atencion(novedad.getfeha_atencion());	
					novedadLocal.sethora_atencion(novedad.gethora_atencion());	
					novedadLocal.setid_empleado(novedad.getid_empleado());	
					novedadLocal.setemail(novedad.getemail());	
					novedadLocal.setesta_activo(novedad.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!novedad.getIsDeleted()) {
				if(!existe) {
					novedads.add(novedad);
				}
			} else {
				if(novedadEncontrado!=null && permiteQuitar)  {
					novedads.remove(novedadEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Novedad novedad,List<Novedad> novedads) throws Exception {
		try	{			
			for(Novedad novedadLocal:novedads) {
				if(novedadLocal.getId().equals(novedad.getId())) {
					novedadLocal.setIsSelected(novedad.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesNovedad(List<Novedad> novedadsAux) throws Exception {
		//this.novedadsAux=novedadsAux;
		
		for(Novedad novedadAux:novedadsAux) {
			if(novedadAux.getIsChanged()) {
				novedadAux.setIsChanged(false);
			}		
			
			if(novedadAux.getIsNew()) {
				novedadAux.setIsNew(false);
			}	
			
			if(novedadAux.getIsDeleted()) {
				novedadAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesNovedad(Novedad novedadAux) throws Exception {
		//this.novedadAux=novedadAux;
		
			if(novedadAux.getIsChanged()) {
				novedadAux.setIsChanged(false);
			}		
			
			if(novedadAux.getIsNew()) {
				novedadAux.setIsNew(false);
			}	
			
			if(novedadAux.getIsDeleted()) {
				novedadAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Novedad novedadAsignar,Novedad novedad) throws Exception {
		novedadAsignar.setId(novedad.getId());	
		novedadAsignar.setVersionRow(novedad.getVersionRow());	
		novedadAsignar.setid_empresa(novedad.getid_empresa());
		novedadAsignar.setempresa_descripcion(novedad.getempresa_descripcion());	
		novedadAsignar.setid_sucursal(novedad.getid_sucursal());
		novedadAsignar.setsucursal_descripcion(novedad.getsucursal_descripcion());	
		novedadAsignar.setid_usuario(novedad.getid_usuario());
		novedadAsignar.setusuario_descripcion(novedad.getusuario_descripcion());	
		novedadAsignar.setid_cliente(novedad.getid_cliente());
		novedadAsignar.setcliente_descripcion(novedad.getcliente_descripcion());	
		novedadAsignar.setdescripcion(novedad.getdescripcion());	
		novedadAsignar.setaccion_tomada(novedad.getaccion_tomada());	
		novedadAsignar.setfeha_atencion(novedad.getfeha_atencion());	
		novedadAsignar.sethora_atencion(novedad.gethora_atencion());	
		novedadAsignar.setid_empleado(novedad.getid_empleado());
		novedadAsignar.setempleado_descripcion(novedad.getempleado_descripcion());	
		novedadAsignar.setemail(novedad.getemail());	
		novedadAsignar.setesta_activo(novedad.getesta_activo());	
	}
	
	public static void inicializarNovedad(Novedad novedad) throws Exception {
		try {
				novedad.setId(0L);	
					
				novedad.setid_empresa(-1L);	
				novedad.setid_sucursal(-1L);	
				novedad.setid_usuario(-1L);	
				novedad.setid_cliente(-1L);	
				novedad.setdescripcion("");	
				novedad.setaccion_tomada("");	
				novedad.setfeha_atencion(new Date());	
				novedad.sethora_atencion(new Time((new Date()).getTime()));	
				novedad.setid_empleado(-1L);	
				novedad.setemail("");	
				novedad.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderNovedad(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadConstantesFunciones.LABEL_ACCIONTOMADA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadConstantesFunciones.LABEL_FEHAATENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadConstantesFunciones.LABEL_HORAATENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadConstantesFunciones.LABEL_EMAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataNovedad(String sTipo,Row row,Workbook workbook,Novedad novedad,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(novedad.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedad.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedad.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedad.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedad.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedad.getaccion_tomada());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedad.getfeha_atencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedad.gethora_atencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedad.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedad.getemail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(novedad.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryNovedad=Constantes.SFINALQUERY;
	
	public String getsFinalQueryNovedad() {
		return this.sFinalQueryNovedad;
	}
	
	public void setsFinalQueryNovedad(String sFinalQueryNovedad) {
		this.sFinalQueryNovedad= sFinalQueryNovedad;
	}
	
	public Border resaltarSeleccionarNovedad=null;
	
	public Border setResaltarSeleccionarNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//novedadBeanSwingJInternalFrame.jTtoolBarNovedad.setBorder(borderResaltar);
		
		this.resaltarSeleccionarNovedad= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarNovedad() {
		return this.resaltarSeleccionarNovedad;
	}
	
	public void setResaltarSeleccionarNovedad(Border borderResaltarSeleccionarNovedad) {
		this.resaltarSeleccionarNovedad= borderResaltarSeleccionarNovedad;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridNovedad=null;
	public Boolean mostraridNovedad=true;
	public Boolean activaridNovedad=true;

	public Border resaltarid_empresaNovedad=null;
	public Boolean mostrarid_empresaNovedad=true;
	public Boolean activarid_empresaNovedad=true;
	public Boolean cargarid_empresaNovedad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaNovedad=false;//ConEventDepend=true

	public Border resaltarid_sucursalNovedad=null;
	public Boolean mostrarid_sucursalNovedad=true;
	public Boolean activarid_sucursalNovedad=true;
	public Boolean cargarid_sucursalNovedad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalNovedad=false;//ConEventDepend=true

	public Border resaltarid_usuarioNovedad=null;
	public Boolean mostrarid_usuarioNovedad=true;
	public Boolean activarid_usuarioNovedad=true;
	public Boolean cargarid_usuarioNovedad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioNovedad=false;//ConEventDepend=true

	public Border resaltarid_clienteNovedad=null;
	public Boolean mostrarid_clienteNovedad=true;
	public Boolean activarid_clienteNovedad=true;
	public Boolean cargarid_clienteNovedad=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteNovedad=false;//ConEventDepend=true

	public Border resaltardescripcionNovedad=null;
	public Boolean mostrardescripcionNovedad=true;
	public Boolean activardescripcionNovedad=true;

	public Border resaltaraccion_tomadaNovedad=null;
	public Boolean mostraraccion_tomadaNovedad=true;
	public Boolean activaraccion_tomadaNovedad=true;

	public Border resaltarfeha_atencionNovedad=null;
	public Boolean mostrarfeha_atencionNovedad=true;
	public Boolean activarfeha_atencionNovedad=false;

	public Border resaltarhora_atencionNovedad=null;
	public Boolean mostrarhora_atencionNovedad=true;
	public Boolean activarhora_atencionNovedad=true;

	public Border resaltarid_empleadoNovedad=null;
	public Boolean mostrarid_empleadoNovedad=true;
	public Boolean activarid_empleadoNovedad=true;
	public Boolean cargarid_empleadoNovedad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoNovedad=false;//ConEventDepend=true

	public Border resaltaremailNovedad=null;
	public Boolean mostraremailNovedad=true;
	public Boolean activaremailNovedad=true;

	public Border resaltaresta_activoNovedad=null;
	public Boolean mostraresta_activoNovedad=true;
	public Boolean activaresta_activoNovedad=true;

	
	

	public Border setResaltaridNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadBeanSwingJInternalFrame.jTtoolBarNovedad.setBorder(borderResaltar);
		
		this.resaltaridNovedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridNovedad() {
		return this.resaltaridNovedad;
	}

	public void setResaltaridNovedad(Border borderResaltar) {
		this.resaltaridNovedad= borderResaltar;
	}

	public Boolean getMostraridNovedad() {
		return this.mostraridNovedad;
	}

	public void setMostraridNovedad(Boolean mostraridNovedad) {
		this.mostraridNovedad= mostraridNovedad;
	}

	public Boolean getActivaridNovedad() {
		return this.activaridNovedad;
	}

	public void setActivaridNovedad(Boolean activaridNovedad) {
		this.activaridNovedad= activaridNovedad;
	}

	public Border setResaltarid_empresaNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadBeanSwingJInternalFrame.jTtoolBarNovedad.setBorder(borderResaltar);
		
		this.resaltarid_empresaNovedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaNovedad() {
		return this.resaltarid_empresaNovedad;
	}

	public void setResaltarid_empresaNovedad(Border borderResaltar) {
		this.resaltarid_empresaNovedad= borderResaltar;
	}

	public Boolean getMostrarid_empresaNovedad() {
		return this.mostrarid_empresaNovedad;
	}

	public void setMostrarid_empresaNovedad(Boolean mostrarid_empresaNovedad) {
		this.mostrarid_empresaNovedad= mostrarid_empresaNovedad;
	}

	public Boolean getActivarid_empresaNovedad() {
		return this.activarid_empresaNovedad;
	}

	public void setActivarid_empresaNovedad(Boolean activarid_empresaNovedad) {
		this.activarid_empresaNovedad= activarid_empresaNovedad;
	}

	public Boolean getCargarid_empresaNovedad() {
		return this.cargarid_empresaNovedad;
	}

	public void setCargarid_empresaNovedad(Boolean cargarid_empresaNovedad) {
		this.cargarid_empresaNovedad= cargarid_empresaNovedad;
	}

	public Border setResaltarid_sucursalNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadBeanSwingJInternalFrame.jTtoolBarNovedad.setBorder(borderResaltar);
		
		this.resaltarid_sucursalNovedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalNovedad() {
		return this.resaltarid_sucursalNovedad;
	}

	public void setResaltarid_sucursalNovedad(Border borderResaltar) {
		this.resaltarid_sucursalNovedad= borderResaltar;
	}

	public Boolean getMostrarid_sucursalNovedad() {
		return this.mostrarid_sucursalNovedad;
	}

	public void setMostrarid_sucursalNovedad(Boolean mostrarid_sucursalNovedad) {
		this.mostrarid_sucursalNovedad= mostrarid_sucursalNovedad;
	}

	public Boolean getActivarid_sucursalNovedad() {
		return this.activarid_sucursalNovedad;
	}

	public void setActivarid_sucursalNovedad(Boolean activarid_sucursalNovedad) {
		this.activarid_sucursalNovedad= activarid_sucursalNovedad;
	}

	public Boolean getCargarid_sucursalNovedad() {
		return this.cargarid_sucursalNovedad;
	}

	public void setCargarid_sucursalNovedad(Boolean cargarid_sucursalNovedad) {
		this.cargarid_sucursalNovedad= cargarid_sucursalNovedad;
	}

	public Border setResaltarid_usuarioNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadBeanSwingJInternalFrame.jTtoolBarNovedad.setBorder(borderResaltar);
		
		this.resaltarid_usuarioNovedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioNovedad() {
		return this.resaltarid_usuarioNovedad;
	}

	public void setResaltarid_usuarioNovedad(Border borderResaltar) {
		this.resaltarid_usuarioNovedad= borderResaltar;
	}

	public Boolean getMostrarid_usuarioNovedad() {
		return this.mostrarid_usuarioNovedad;
	}

	public void setMostrarid_usuarioNovedad(Boolean mostrarid_usuarioNovedad) {
		this.mostrarid_usuarioNovedad= mostrarid_usuarioNovedad;
	}

	public Boolean getActivarid_usuarioNovedad() {
		return this.activarid_usuarioNovedad;
	}

	public void setActivarid_usuarioNovedad(Boolean activarid_usuarioNovedad) {
		this.activarid_usuarioNovedad= activarid_usuarioNovedad;
	}

	public Boolean getCargarid_usuarioNovedad() {
		return this.cargarid_usuarioNovedad;
	}

	public void setCargarid_usuarioNovedad(Boolean cargarid_usuarioNovedad) {
		this.cargarid_usuarioNovedad= cargarid_usuarioNovedad;
	}

	public Border setResaltarid_clienteNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadBeanSwingJInternalFrame.jTtoolBarNovedad.setBorder(borderResaltar);
		
		this.resaltarid_clienteNovedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteNovedad() {
		return this.resaltarid_clienteNovedad;
	}

	public void setResaltarid_clienteNovedad(Border borderResaltar) {
		this.resaltarid_clienteNovedad= borderResaltar;
	}

	public Boolean getMostrarid_clienteNovedad() {
		return this.mostrarid_clienteNovedad;
	}

	public void setMostrarid_clienteNovedad(Boolean mostrarid_clienteNovedad) {
		this.mostrarid_clienteNovedad= mostrarid_clienteNovedad;
	}

	public Boolean getActivarid_clienteNovedad() {
		return this.activarid_clienteNovedad;
	}

	public void setActivarid_clienteNovedad(Boolean activarid_clienteNovedad) {
		this.activarid_clienteNovedad= activarid_clienteNovedad;
	}

	public Boolean getCargarid_clienteNovedad() {
		return this.cargarid_clienteNovedad;
	}

	public void setCargarid_clienteNovedad(Boolean cargarid_clienteNovedad) {
		this.cargarid_clienteNovedad= cargarid_clienteNovedad;
	}

	public Border setResaltardescripcionNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadBeanSwingJInternalFrame.jTtoolBarNovedad.setBorder(borderResaltar);
		
		this.resaltardescripcionNovedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionNovedad() {
		return this.resaltardescripcionNovedad;
	}

	public void setResaltardescripcionNovedad(Border borderResaltar) {
		this.resaltardescripcionNovedad= borderResaltar;
	}

	public Boolean getMostrardescripcionNovedad() {
		return this.mostrardescripcionNovedad;
	}

	public void setMostrardescripcionNovedad(Boolean mostrardescripcionNovedad) {
		this.mostrardescripcionNovedad= mostrardescripcionNovedad;
	}

	public Boolean getActivardescripcionNovedad() {
		return this.activardescripcionNovedad;
	}

	public void setActivardescripcionNovedad(Boolean activardescripcionNovedad) {
		this.activardescripcionNovedad= activardescripcionNovedad;
	}

	public Border setResaltaraccion_tomadaNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadBeanSwingJInternalFrame.jTtoolBarNovedad.setBorder(borderResaltar);
		
		this.resaltaraccion_tomadaNovedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaraccion_tomadaNovedad() {
		return this.resaltaraccion_tomadaNovedad;
	}

	public void setResaltaraccion_tomadaNovedad(Border borderResaltar) {
		this.resaltaraccion_tomadaNovedad= borderResaltar;
	}

	public Boolean getMostraraccion_tomadaNovedad() {
		return this.mostraraccion_tomadaNovedad;
	}

	public void setMostraraccion_tomadaNovedad(Boolean mostraraccion_tomadaNovedad) {
		this.mostraraccion_tomadaNovedad= mostraraccion_tomadaNovedad;
	}

	public Boolean getActivaraccion_tomadaNovedad() {
		return this.activaraccion_tomadaNovedad;
	}

	public void setActivaraccion_tomadaNovedad(Boolean activaraccion_tomadaNovedad) {
		this.activaraccion_tomadaNovedad= activaraccion_tomadaNovedad;
	}

	public Border setResaltarfeha_atencionNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadBeanSwingJInternalFrame.jTtoolBarNovedad.setBorder(borderResaltar);
		
		this.resaltarfeha_atencionNovedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfeha_atencionNovedad() {
		return this.resaltarfeha_atencionNovedad;
	}

	public void setResaltarfeha_atencionNovedad(Border borderResaltar) {
		this.resaltarfeha_atencionNovedad= borderResaltar;
	}

	public Boolean getMostrarfeha_atencionNovedad() {
		return this.mostrarfeha_atencionNovedad;
	}

	public void setMostrarfeha_atencionNovedad(Boolean mostrarfeha_atencionNovedad) {
		this.mostrarfeha_atencionNovedad= mostrarfeha_atencionNovedad;
	}

	public Boolean getActivarfeha_atencionNovedad() {
		return this.activarfeha_atencionNovedad;
	}

	public void setActivarfeha_atencionNovedad(Boolean activarfeha_atencionNovedad) {
		this.activarfeha_atencionNovedad= activarfeha_atencionNovedad;
	}

	public Border setResaltarhora_atencionNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadBeanSwingJInternalFrame.jTtoolBarNovedad.setBorder(borderResaltar);
		
		this.resaltarhora_atencionNovedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_atencionNovedad() {
		return this.resaltarhora_atencionNovedad;
	}

	public void setResaltarhora_atencionNovedad(Border borderResaltar) {
		this.resaltarhora_atencionNovedad= borderResaltar;
	}

	public Boolean getMostrarhora_atencionNovedad() {
		return this.mostrarhora_atencionNovedad;
	}

	public void setMostrarhora_atencionNovedad(Boolean mostrarhora_atencionNovedad) {
		this.mostrarhora_atencionNovedad= mostrarhora_atencionNovedad;
	}

	public Boolean getActivarhora_atencionNovedad() {
		return this.activarhora_atencionNovedad;
	}

	public void setActivarhora_atencionNovedad(Boolean activarhora_atencionNovedad) {
		this.activarhora_atencionNovedad= activarhora_atencionNovedad;
	}

	public Border setResaltarid_empleadoNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadBeanSwingJInternalFrame.jTtoolBarNovedad.setBorder(borderResaltar);
		
		this.resaltarid_empleadoNovedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoNovedad() {
		return this.resaltarid_empleadoNovedad;
	}

	public void setResaltarid_empleadoNovedad(Border borderResaltar) {
		this.resaltarid_empleadoNovedad= borderResaltar;
	}

	public Boolean getMostrarid_empleadoNovedad() {
		return this.mostrarid_empleadoNovedad;
	}

	public void setMostrarid_empleadoNovedad(Boolean mostrarid_empleadoNovedad) {
		this.mostrarid_empleadoNovedad= mostrarid_empleadoNovedad;
	}

	public Boolean getActivarid_empleadoNovedad() {
		return this.activarid_empleadoNovedad;
	}

	public void setActivarid_empleadoNovedad(Boolean activarid_empleadoNovedad) {
		this.activarid_empleadoNovedad= activarid_empleadoNovedad;
	}

	public Boolean getCargarid_empleadoNovedad() {
		return this.cargarid_empleadoNovedad;
	}

	public void setCargarid_empleadoNovedad(Boolean cargarid_empleadoNovedad) {
		this.cargarid_empleadoNovedad= cargarid_empleadoNovedad;
	}

	public Border setResaltaremailNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadBeanSwingJInternalFrame.jTtoolBarNovedad.setBorder(borderResaltar);
		
		this.resaltaremailNovedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaremailNovedad() {
		return this.resaltaremailNovedad;
	}

	public void setResaltaremailNovedad(Border borderResaltar) {
		this.resaltaremailNovedad= borderResaltar;
	}

	public Boolean getMostraremailNovedad() {
		return this.mostraremailNovedad;
	}

	public void setMostraremailNovedad(Boolean mostraremailNovedad) {
		this.mostraremailNovedad= mostraremailNovedad;
	}

	public Boolean getActivaremailNovedad() {
		return this.activaremailNovedad;
	}

	public void setActivaremailNovedad(Boolean activaremailNovedad) {
		this.activaremailNovedad= activaremailNovedad;
	}

	public Border setResaltaresta_activoNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadBeanSwingJInternalFrame.jTtoolBarNovedad.setBorder(borderResaltar);
		
		this.resaltaresta_activoNovedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoNovedad() {
		return this.resaltaresta_activoNovedad;
	}

	public void setResaltaresta_activoNovedad(Border borderResaltar) {
		this.resaltaresta_activoNovedad= borderResaltar;
	}

	public Boolean getMostraresta_activoNovedad() {
		return this.mostraresta_activoNovedad;
	}

	public void setMostraresta_activoNovedad(Boolean mostraresta_activoNovedad) {
		this.mostraresta_activoNovedad= mostraresta_activoNovedad;
	}

	public Boolean getActivaresta_activoNovedad() {
		return this.activaresta_activoNovedad;
	}

	public void setActivaresta_activoNovedad(Boolean activaresta_activoNovedad) {
		this.activaresta_activoNovedad= activaresta_activoNovedad;
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
		
		
		this.setMostraridNovedad(esInicial);
		this.setMostrarid_empresaNovedad(esInicial);
		this.setMostrarid_sucursalNovedad(esInicial);
		this.setMostrarid_usuarioNovedad(esInicial);
		this.setMostrarid_clienteNovedad(esInicial);
		this.setMostrardescripcionNovedad(esInicial);
		this.setMostraraccion_tomadaNovedad(esInicial);
		this.setMostrarfeha_atencionNovedad(esInicial);
		this.setMostrarhora_atencionNovedad(esInicial);
		this.setMostrarid_empleadoNovedad(esInicial);
		this.setMostraremailNovedad(esInicial);
		this.setMostraresta_activoNovedad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NovedadConstantesFunciones.ID)) {
				this.setMostraridNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.ACCIONTOMADA)) {
				this.setMostraraccion_tomadaNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.FEHAATENCION)) {
				this.setMostrarfeha_atencionNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.HORAATENCION)) {
				this.setMostrarhora_atencionNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.EMAIL)) {
				this.setMostraremailNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoNovedad(esAsigna);
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
		
		
		this.setActivaridNovedad(esInicial);
		this.setActivarid_empresaNovedad(esInicial);
		this.setActivarid_sucursalNovedad(esInicial);
		this.setActivarid_usuarioNovedad(esInicial);
		this.setActivarid_clienteNovedad(esInicial);
		this.setActivardescripcionNovedad(esInicial);
		this.setActivaraccion_tomadaNovedad(esInicial);
		this.setActivarfeha_atencionNovedad(esInicial);
		this.setActivarhora_atencionNovedad(esInicial);
		this.setActivarid_empleadoNovedad(esInicial);
		this.setActivaremailNovedad(esInicial);
		this.setActivaresta_activoNovedad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NovedadConstantesFunciones.ID)) {
				this.setActivaridNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.ACCIONTOMADA)) {
				this.setActivaraccion_tomadaNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.FEHAATENCION)) {
				this.setActivarfeha_atencionNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.HORAATENCION)) {
				this.setActivarhora_atencionNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.EMAIL)) {
				this.setActivaremailNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoNovedad(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridNovedad(esInicial);
		this.setResaltarid_empresaNovedad(esInicial);
		this.setResaltarid_sucursalNovedad(esInicial);
		this.setResaltarid_usuarioNovedad(esInicial);
		this.setResaltarid_clienteNovedad(esInicial);
		this.setResaltardescripcionNovedad(esInicial);
		this.setResaltaraccion_tomadaNovedad(esInicial);
		this.setResaltarfeha_atencionNovedad(esInicial);
		this.setResaltarhora_atencionNovedad(esInicial);
		this.setResaltarid_empleadoNovedad(esInicial);
		this.setResaltaremailNovedad(esInicial);
		this.setResaltaresta_activoNovedad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NovedadConstantesFunciones.ID)) {
				this.setResaltaridNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.ACCIONTOMADA)) {
				this.setResaltaraccion_tomadaNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.FEHAATENCION)) {
				this.setResaltarfeha_atencionNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.HORAATENCION)) {
				this.setResaltarhora_atencionNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.EMAIL)) {
				this.setResaltaremailNovedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoNovedad(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteNovedad=true;

	public Boolean getMostrarFK_IdClienteNovedad() {
		return this.mostrarFK_IdClienteNovedad;
	}

	public void setMostrarFK_IdClienteNovedad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteNovedad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoNovedad=true;

	public Boolean getMostrarFK_IdEmpleadoNovedad() {
		return this.mostrarFK_IdEmpleadoNovedad;
	}

	public void setMostrarFK_IdEmpleadoNovedad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoNovedad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaNovedad=true;

	public Boolean getMostrarFK_IdEmpresaNovedad() {
		return this.mostrarFK_IdEmpresaNovedad;
	}

	public void setMostrarFK_IdEmpresaNovedad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaNovedad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalNovedad=true;

	public Boolean getMostrarFK_IdSucursalNovedad() {
		return this.mostrarFK_IdSucursalNovedad;
	}

	public void setMostrarFK_IdSucursalNovedad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalNovedad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioNovedad=true;

	public Boolean getMostrarFK_IdUsuarioNovedad() {
		return this.mostrarFK_IdUsuarioNovedad;
	}

	public void setMostrarFK_IdUsuarioNovedad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioNovedad= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteNovedad=true;

	public Boolean getActivarFK_IdClienteNovedad() {
		return this.activarFK_IdClienteNovedad;
	}

	public void setActivarFK_IdClienteNovedad(Boolean habilitarResaltar) {
		this.activarFK_IdClienteNovedad= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoNovedad=true;

	public Boolean getActivarFK_IdEmpleadoNovedad() {
		return this.activarFK_IdEmpleadoNovedad;
	}

	public void setActivarFK_IdEmpleadoNovedad(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoNovedad= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaNovedad=true;

	public Boolean getActivarFK_IdEmpresaNovedad() {
		return this.activarFK_IdEmpresaNovedad;
	}

	public void setActivarFK_IdEmpresaNovedad(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaNovedad= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalNovedad=true;

	public Boolean getActivarFK_IdSucursalNovedad() {
		return this.activarFK_IdSucursalNovedad;
	}

	public void setActivarFK_IdSucursalNovedad(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalNovedad= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioNovedad=true;

	public Boolean getActivarFK_IdUsuarioNovedad() {
		return this.activarFK_IdUsuarioNovedad;
	}

	public void setActivarFK_IdUsuarioNovedad(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioNovedad= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteNovedad=null;

	public Border getResaltarFK_IdClienteNovedad() {
		return this.resaltarFK_IdClienteNovedad;
	}

	public void setResaltarFK_IdClienteNovedad(Border borderResaltar) {
		this.resaltarFK_IdClienteNovedad= borderResaltar;
	}

	public void setResaltarFK_IdClienteNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteNovedad= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoNovedad=null;

	public Border getResaltarFK_IdEmpleadoNovedad() {
		return this.resaltarFK_IdEmpleadoNovedad;
	}

	public void setResaltarFK_IdEmpleadoNovedad(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoNovedad= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoNovedad= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaNovedad=null;

	public Border getResaltarFK_IdEmpresaNovedad() {
		return this.resaltarFK_IdEmpresaNovedad;
	}

	public void setResaltarFK_IdEmpresaNovedad(Border borderResaltar) {
		this.resaltarFK_IdEmpresaNovedad= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaNovedad= borderResaltar;
	}

	public Border resaltarFK_IdSucursalNovedad=null;

	public Border getResaltarFK_IdSucursalNovedad() {
		return this.resaltarFK_IdSucursalNovedad;
	}

	public void setResaltarFK_IdSucursalNovedad(Border borderResaltar) {
		this.resaltarFK_IdSucursalNovedad= borderResaltar;
	}

	public void setResaltarFK_IdSucursalNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalNovedad= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioNovedad=null;

	public Border getResaltarFK_IdUsuarioNovedad() {
		return this.resaltarFK_IdUsuarioNovedad;
	}

	public void setResaltarFK_IdUsuarioNovedad(Border borderResaltar) {
		this.resaltarFK_IdUsuarioNovedad= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioNovedad(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadBeanSwingJInternalFrame novedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioNovedad= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}