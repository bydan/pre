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


import com.bydan.erp.inventario.util.AutoriConsepConstantesFunciones;
import com.bydan.erp.inventario.util.AutoriConsepParameterReturnGeneral;
//import com.bydan.erp.inventario.util.AutoriConsepParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AutoriConsepConstantesFunciones extends AutoriConsepConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="AutoriConsep";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AutoriConsep"+AutoriConsepConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AutoriConsepHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AutoriConsepHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AutoriConsepConstantesFunciones.SCHEMA+"_"+AutoriConsepConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AutoriConsepHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AutoriConsepConstantesFunciones.SCHEMA+"_"+AutoriConsepConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AutoriConsepConstantesFunciones.SCHEMA+"_"+AutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AutoriConsepHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AutoriConsepConstantesFunciones.SCHEMA+"_"+AutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AutoriConsepHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AutoriConsepHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AutoriConsepConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AutoriConsepConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AutoriConsepConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AutoriConsepConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Autorizaciones Consepes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Autorizaciones Consep";
	public static final String SCLASSWEBTITULO_LOWER="Autori Consep";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AutoriConsep";
	public static final String OBJECTNAME="autoriconsep";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="autori_consep";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select autoriconsep from "+AutoriConsepConstantesFunciones.SPERSISTENCENAME+" autoriconsep";
	public static String QUERYSELECTNATIVE="select "+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".id,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".version_row,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".id_empresa,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".id_usuario,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".es_empresa,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".id_cliente,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".numero_autorizacion,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".id_tipo_autori_consep,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".id_empleado,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".fecha_emision,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".fecha_vencimiento,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".fecha_ultima,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".fecha,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".descripcion,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".nombre from "+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME;//+" as "+AutoriConsepConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected AutoriConsepConstantesFuncionesAdditional autoriconsepConstantesFuncionesAdditional=null;
	
	public AutoriConsepConstantesFuncionesAdditional getAutoriConsepConstantesFuncionesAdditional() {
		return this.autoriconsepConstantesFuncionesAdditional;
	}
	
	public void setAutoriConsepConstantesFuncionesAdditional(AutoriConsepConstantesFuncionesAdditional autoriconsepConstantesFuncionesAdditional) {
		try {
			this.autoriconsepConstantesFuncionesAdditional=autoriconsepConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDUSUARIO= "id_usuario";
    public static final String ESEMPRESA= "es_empresa";
    public static final String IDCLIENTE= "id_cliente";
    public static final String NUMEROAUTORIZACION= "numero_autorizacion";
    public static final String IDTIPOAUTORICONSEP= "id_tipo_autori_consep";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String FECHAULTIMA= "fecha_ultima";
    public static final String FECHA= "fecha";
    public static final String DESCRIPCION= "descripcion";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_ESEMPRESA= "Es Empresa";
		public static final String LABEL_ESEMPRESA_LOWER= "Es Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_NUMEROAUTORIZACION= "Nro Autorizacion";
		public static final String LABEL_NUMEROAUTORIZACION_LOWER= "Numero Autorizacion";
    	public static final String LABEL_IDTIPOAUTORICONSEP= "Tipo";
		public static final String LABEL_IDTIPOAUTORICONSEP_LOWER= "Tipo Autori Consep";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_FECHAULTIMA= "Fecha Ult Modificacion";
		public static final String LABEL_FECHAULTIMA_LOWER= "Fecha Ultima";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
		
		
	public static final String SREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getAutoriConsepLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AutoriConsepConstantesFunciones.IDEMPRESA)) {sLabelColumna=AutoriConsepConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AutoriConsepConstantesFunciones.IDUSUARIO)) {sLabelColumna=AutoriConsepConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(AutoriConsepConstantesFunciones.ESEMPRESA)) {sLabelColumna=AutoriConsepConstantesFunciones.LABEL_ESEMPRESA;}
		if(sNombreColumna.equals(AutoriConsepConstantesFunciones.IDCLIENTE)) {sLabelColumna=AutoriConsepConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(AutoriConsepConstantesFunciones.NUMEROAUTORIZACION)) {sLabelColumna=AutoriConsepConstantesFunciones.LABEL_NUMEROAUTORIZACION;}
		if(sNombreColumna.equals(AutoriConsepConstantesFunciones.IDTIPOAUTORICONSEP)) {sLabelColumna=AutoriConsepConstantesFunciones.LABEL_IDTIPOAUTORICONSEP;}
		if(sNombreColumna.equals(AutoriConsepConstantesFunciones.IDEMPLEADO)) {sLabelColumna=AutoriConsepConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(AutoriConsepConstantesFunciones.FECHAEMISION)) {sLabelColumna=AutoriConsepConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(AutoriConsepConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=AutoriConsepConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(AutoriConsepConstantesFunciones.FECHAULTIMA)) {sLabelColumna=AutoriConsepConstantesFunciones.LABEL_FECHAULTIMA;}
		if(sNombreColumna.equals(AutoriConsepConstantesFunciones.FECHA)) {sLabelColumna=AutoriConsepConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(AutoriConsepConstantesFunciones.DESCRIPCION)) {sLabelColumna=AutoriConsepConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(AutoriConsepConstantesFunciones.NOMBRE)) {sLabelColumna=AutoriConsepConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
		
	public static String getes_empresaDescripcion(AutoriConsep autoriconsep) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!autoriconsep.getes_empresa()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_empresaHtmlDescripcion(AutoriConsep autoriconsep) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(autoriconsep.getId(),autoriconsep.getes_empresa());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
	
	public static String getAutoriConsepDescripcion(AutoriConsep autoriconsep) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(autoriconsep !=null/* && autoriconsep.getId()!=0*/) {
			sDescripcion=autoriconsep.getnombre();//autoriconsepautoriconsep.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getAutoriConsepDescripcionDetallado(AutoriConsep autoriconsep) {
		String sDescripcion="";
			
		sDescripcion+=AutoriConsepConstantesFunciones.ID+"=";
		sDescripcion+=autoriconsep.getId().toString()+",";
		sDescripcion+=AutoriConsepConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=autoriconsep.getVersionRow().toString()+",";
		sDescripcion+=AutoriConsepConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=autoriconsep.getid_empresa().toString()+",";
		sDescripcion+=AutoriConsepConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=autoriconsep.getid_usuario().toString()+",";
		sDescripcion+=AutoriConsepConstantesFunciones.ESEMPRESA+"=";
		sDescripcion+=autoriconsep.getes_empresa().toString()+",";
		sDescripcion+=AutoriConsepConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=autoriconsep.getid_cliente().toString()+",";
		sDescripcion+=AutoriConsepConstantesFunciones.NUMEROAUTORIZACION+"=";
		sDescripcion+=autoriconsep.getnumero_autorizacion()+",";
		sDescripcion+=AutoriConsepConstantesFunciones.IDTIPOAUTORICONSEP+"=";
		sDescripcion+=autoriconsep.getid_tipo_autori_consep().toString()+",";
		sDescripcion+=AutoriConsepConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=autoriconsep.getid_empleado().toString()+",";
		sDescripcion+=AutoriConsepConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=autoriconsep.getfecha_emision().toString()+",";
		sDescripcion+=AutoriConsepConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=autoriconsep.getfecha_vencimiento().toString()+",";
		sDescripcion+=AutoriConsepConstantesFunciones.FECHAULTIMA+"=";
		sDescripcion+=autoriconsep.getfecha_ultima().toString()+",";
		sDescripcion+=AutoriConsepConstantesFunciones.FECHA+"=";
		sDescripcion+=autoriconsep.getfecha().toString()+",";
		sDescripcion+=AutoriConsepConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=autoriconsep.getdescripcion()+",";
		sDescripcion+=AutoriConsepConstantesFunciones.NOMBRE+"=";
		sDescripcion+=autoriconsep.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setAutoriConsepDescripcion(AutoriConsep autoriconsep,String sValor) throws Exception {			
		if(autoriconsep !=null) {
			autoriconsep.setnombre(sValor);//autoriconsepautoriconsep.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getTipoAutoriConsepDescripcion(TipoAutoriConsep tipoautoriconsep) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoautoriconsep!=null/*&&tipoautoriconsep.getId()>0*/) {
			sDescripcion=TipoAutoriConsepConstantesFunciones.getTipoAutoriConsepDescripcion(tipoautoriconsep);
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
		} else if(sNombreIndice.equals("BusquedaPorNumeroAutorizacion")) {
			sNombreIndice="Tipo=  Por Nro Autorizacion";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoAutoriConsep")) {
			sNombreIndice="Tipo=  Por Tipo";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNumeroAutorizacion(String numero_autorizacion) {
		String sDetalleIndice=" Parametros->";
		if(numero_autorizacion!=null) {sDetalleIndice+=" Nro Autorizacion="+numero_autorizacion;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
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

	public static String getDetalleIndiceFK_IdTipoAutoriConsep(Long id_tipo_autori_consep) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_autori_consep!=null) {sDetalleIndice+=" Codigo Unico De Tipo="+id_tipo_autori_consep.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAutoriConsep(AutoriConsep autoriconsep,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		autoriconsep.setnumero_autorizacion(autoriconsep.getnumero_autorizacion().trim());
		autoriconsep.setdescripcion(autoriconsep.getdescripcion().trim());
		autoriconsep.setnombre(autoriconsep.getnombre().trim());
	}
	
	public static void quitarEspaciosAutoriConseps(List<AutoriConsep> autoriconseps,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AutoriConsep autoriconsep: autoriconseps) {
			autoriconsep.setnumero_autorizacion(autoriconsep.getnumero_autorizacion().trim());
			autoriconsep.setdescripcion(autoriconsep.getdescripcion().trim());
			autoriconsep.setnombre(autoriconsep.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAutoriConsep(AutoriConsep autoriconsep,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && autoriconsep.getConCambioAuxiliar()) {
			autoriconsep.setIsDeleted(autoriconsep.getIsDeletedAuxiliar());	
			autoriconsep.setIsNew(autoriconsep.getIsNewAuxiliar());	
			autoriconsep.setIsChanged(autoriconsep.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			autoriconsep.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			autoriconsep.setIsDeletedAuxiliar(false);	
			autoriconsep.setIsNewAuxiliar(false);	
			autoriconsep.setIsChangedAuxiliar(false);
			
			autoriconsep.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAutoriConseps(List<AutoriConsep> autoriconseps,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AutoriConsep autoriconsep : autoriconseps) {
			if(conAsignarBase && autoriconsep.getConCambioAuxiliar()) {
				autoriconsep.setIsDeleted(autoriconsep.getIsDeletedAuxiliar());	
				autoriconsep.setIsNew(autoriconsep.getIsNewAuxiliar());	
				autoriconsep.setIsChanged(autoriconsep.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				autoriconsep.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				autoriconsep.setIsDeletedAuxiliar(false);	
				autoriconsep.setIsNewAuxiliar(false);	
				autoriconsep.setIsChangedAuxiliar(false);
				
				autoriconsep.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAutoriConsep(AutoriConsep autoriconsep,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAutoriConseps(List<AutoriConsep> autoriconseps,Boolean conEnteros) throws Exception  {
		
		for(AutoriConsep autoriconsep: autoriconseps) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaAutoriConsep(List<AutoriConsep> autoriconseps,AutoriConsep autoriconsepAux) throws Exception  {
		AutoriConsepConstantesFunciones.InicializarValoresAutoriConsep(autoriconsepAux,true);
		
		for(AutoriConsep autoriconsep: autoriconseps) {
			if(autoriconsep.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAutoriConsep(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AutoriConsepConstantesFunciones.getArrayColumnasGlobalesAutoriConsep(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAutoriConsep(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutoriConsepConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutoriConsepConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutoriConsepConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutoriConsepConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAutoriConsep(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AutoriConsep> autoriconseps,AutoriConsep autoriconsep,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AutoriConsep autoriconsepAux: autoriconseps) {
			if(autoriconsepAux!=null && autoriconsep!=null) {
				if((autoriconsepAux.getId()==null && autoriconsep.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(autoriconsepAux.getId()!=null && autoriconsep.getId()!=null){
					if(autoriconsepAux.getId().equals(autoriconsep.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAutoriConsep(List<AutoriConsep> autoriconseps) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(AutoriConsep autoriconsep: autoriconseps) {			
			if(autoriconsep.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAutoriConsep() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AutoriConsepConstantesFunciones.LABEL_ID, AutoriConsepConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriConsepConstantesFunciones.LABEL_VERSIONROW, AutoriConsepConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriConsepConstantesFunciones.LABEL_IDEMPRESA, AutoriConsepConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriConsepConstantesFunciones.LABEL_IDUSUARIO, AutoriConsepConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriConsepConstantesFunciones.LABEL_ESEMPRESA, AutoriConsepConstantesFunciones.ESEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriConsepConstantesFunciones.LABEL_IDCLIENTE, AutoriConsepConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriConsepConstantesFunciones.LABEL_NUMEROAUTORIZACION, AutoriConsepConstantesFunciones.NUMEROAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriConsepConstantesFunciones.LABEL_IDTIPOAUTORICONSEP, AutoriConsepConstantesFunciones.IDTIPOAUTORICONSEP,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriConsepConstantesFunciones.LABEL_IDEMPLEADO, AutoriConsepConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriConsepConstantesFunciones.LABEL_FECHAEMISION, AutoriConsepConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriConsepConstantesFunciones.LABEL_FECHAVENCIMIENTO, AutoriConsepConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriConsepConstantesFunciones.LABEL_FECHAULTIMA, AutoriConsepConstantesFunciones.FECHAULTIMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriConsepConstantesFunciones.LABEL_FECHA, AutoriConsepConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriConsepConstantesFunciones.LABEL_DESCRIPCION, AutoriConsepConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriConsepConstantesFunciones.LABEL_NOMBRE, AutoriConsepConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAutoriConsep() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AutoriConsepConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriConsepConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriConsepConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriConsepConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriConsepConstantesFunciones.ESEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriConsepConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriConsepConstantesFunciones.NUMEROAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriConsepConstantesFunciones.IDTIPOAUTORICONSEP;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriConsepConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriConsepConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriConsepConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriConsepConstantesFunciones.FECHAULTIMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriConsepConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriConsepConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriConsepConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutoriConsep() throws Exception  {
		return AutoriConsepConstantesFunciones.getTiposSeleccionarAutoriConsep(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutoriConsep(Boolean conFk) throws Exception  {
		return AutoriConsepConstantesFunciones.getTiposSeleccionarAutoriConsep(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutoriConsep(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriConsepConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AutoriConsepConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriConsepConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(AutoriConsepConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriConsepConstantesFunciones.LABEL_ESEMPRESA);
			reporte.setsDescripcion(AutoriConsepConstantesFunciones.LABEL_ESEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriConsepConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(AutoriConsepConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriConsepConstantesFunciones.LABEL_NUMEROAUTORIZACION);
			reporte.setsDescripcion(AutoriConsepConstantesFunciones.LABEL_NUMEROAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriConsepConstantesFunciones.LABEL_IDTIPOAUTORICONSEP);
			reporte.setsDescripcion(AutoriConsepConstantesFunciones.LABEL_IDTIPOAUTORICONSEP);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriConsepConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(AutoriConsepConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriConsepConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(AutoriConsepConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriConsepConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(AutoriConsepConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriConsepConstantesFunciones.LABEL_FECHAULTIMA);
			reporte.setsDescripcion(AutoriConsepConstantesFunciones.LABEL_FECHAULTIMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriConsepConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(AutoriConsepConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriConsepConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(AutoriConsepConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriConsepConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(AutoriConsepConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAutoriConsep(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAutoriConsep(AutoriConsep autoriconsepAux) throws Exception {
		
			autoriconsepAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(autoriconsepAux.getEmpresa()));
			autoriconsepAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(autoriconsepAux.getUsuario()));
			autoriconsepAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(autoriconsepAux.getCliente()));
			autoriconsepAux.settipoautoriconsep_descripcion(TipoAutoriConsepConstantesFunciones.getTipoAutoriConsepDescripcion(autoriconsepAux.getTipoAutoriConsep()));
			autoriconsepAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(autoriconsepAux.getEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAutoriConsep(List<AutoriConsep> autoriconsepsTemp) throws Exception {
		for(AutoriConsep autoriconsepAux:autoriconsepsTemp) {
			
			autoriconsepAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(autoriconsepAux.getEmpresa()));
			autoriconsepAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(autoriconsepAux.getUsuario()));
			autoriconsepAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(autoriconsepAux.getCliente()));
			autoriconsepAux.settipoautoriconsep_descripcion(TipoAutoriConsepConstantesFunciones.getTipoAutoriConsepDescripcion(autoriconsepAux.getTipoAutoriConsep()));
			autoriconsepAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(autoriconsepAux.getEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoAutoriConsep.class));
				classes.add(new Classe(Empleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
					if(clas.clas.equals(TipoAutoriConsep.class)) {
						classes.add(new Classe(TipoAutoriConsep.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAutoriConsep(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoAutoriConsep.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoAutoriConsep.class)); continue;
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoAutoriConsep.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoAutoriConsep.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AutoriConsepConstantesFunciones.getClassesRelationshipsOfAutoriConsep(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleAutoriConsep.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleAutoriConsep.class)) {
						classes.add(new Classe(DetalleAutoriConsep.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAutoriConsep(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AutoriConsepConstantesFunciones.getClassesRelationshipsFromStringsOfAutoriConsep(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAutoriConsep(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleAutoriConsep.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleAutoriConsep.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleAutoriConsep.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleAutoriConsep.class)); continue;
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
	public static void actualizarLista(AutoriConsep autoriconsep,List<AutoriConsep> autoriconseps,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			AutoriConsep autoriconsepEncontrado=null;
			
			for(AutoriConsep autoriconsepLocal:autoriconseps) {
				if(autoriconsepLocal.getId().equals(autoriconsep.getId())) {
					autoriconsepEncontrado=autoriconsepLocal;
					
					autoriconsepLocal.setIsChanged(autoriconsep.getIsChanged());
					autoriconsepLocal.setIsNew(autoriconsep.getIsNew());
					autoriconsepLocal.setIsDeleted(autoriconsep.getIsDeleted());
					
					autoriconsepLocal.setGeneralEntityOriginal(autoriconsep.getGeneralEntityOriginal());
					
					autoriconsepLocal.setId(autoriconsep.getId());	
					autoriconsepLocal.setVersionRow(autoriconsep.getVersionRow());	
					autoriconsepLocal.setid_empresa(autoriconsep.getid_empresa());	
					autoriconsepLocal.setid_usuario(autoriconsep.getid_usuario());	
					autoriconsepLocal.setes_empresa(autoriconsep.getes_empresa());	
					autoriconsepLocal.setid_cliente(autoriconsep.getid_cliente());	
					autoriconsepLocal.setnumero_autorizacion(autoriconsep.getnumero_autorizacion());	
					autoriconsepLocal.setid_tipo_autori_consep(autoriconsep.getid_tipo_autori_consep());	
					autoriconsepLocal.setid_empleado(autoriconsep.getid_empleado());	
					autoriconsepLocal.setfecha_emision(autoriconsep.getfecha_emision());	
					autoriconsepLocal.setfecha_vencimiento(autoriconsep.getfecha_vencimiento());	
					autoriconsepLocal.setfecha_ultima(autoriconsep.getfecha_ultima());	
					autoriconsepLocal.setfecha(autoriconsep.getfecha());	
					autoriconsepLocal.setdescripcion(autoriconsep.getdescripcion());	
					autoriconsepLocal.setnombre(autoriconsep.getnombre());	
					
					
					autoriconsepLocal.setDetalleAutoriConseps(autoriconsep.getDetalleAutoriConseps());
					
					existe=true;
					break;
				}
			}
			
			if(!autoriconsep.getIsDeleted()) {
				if(!existe) {
					autoriconseps.add(autoriconsep);
				}
			} else {
				if(autoriconsepEncontrado!=null && permiteQuitar)  {
					autoriconseps.remove(autoriconsepEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(AutoriConsep autoriconsep,List<AutoriConsep> autoriconseps) throws Exception {
		try	{			
			for(AutoriConsep autoriconsepLocal:autoriconseps) {
				if(autoriconsepLocal.getId().equals(autoriconsep.getId())) {
					autoriconsepLocal.setIsSelected(autoriconsep.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAutoriConsep(List<AutoriConsep> autoriconsepsAux) throws Exception {
		//this.autoriconsepsAux=autoriconsepsAux;
		
		for(AutoriConsep autoriconsepAux:autoriconsepsAux) {
			if(autoriconsepAux.getIsChanged()) {
				autoriconsepAux.setIsChanged(false);
			}		
			
			if(autoriconsepAux.getIsNew()) {
				autoriconsepAux.setIsNew(false);
			}	
			
			if(autoriconsepAux.getIsDeleted()) {
				autoriconsepAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAutoriConsep(AutoriConsep autoriconsepAux) throws Exception {
		//this.autoriconsepAux=autoriconsepAux;
		
			if(autoriconsepAux.getIsChanged()) {
				autoriconsepAux.setIsChanged(false);
			}		
			
			if(autoriconsepAux.getIsNew()) {
				autoriconsepAux.setIsNew(false);
			}	
			
			if(autoriconsepAux.getIsDeleted()) {
				autoriconsepAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AutoriConsep autoriconsepAsignar,AutoriConsep autoriconsep) throws Exception {
		autoriconsepAsignar.setId(autoriconsep.getId());	
		autoriconsepAsignar.setVersionRow(autoriconsep.getVersionRow());	
		autoriconsepAsignar.setid_empresa(autoriconsep.getid_empresa());
		autoriconsepAsignar.setempresa_descripcion(autoriconsep.getempresa_descripcion());	
		autoriconsepAsignar.setid_usuario(autoriconsep.getid_usuario());
		autoriconsepAsignar.setusuario_descripcion(autoriconsep.getusuario_descripcion());	
		autoriconsepAsignar.setes_empresa(autoriconsep.getes_empresa());	
		autoriconsepAsignar.setid_cliente(autoriconsep.getid_cliente());
		autoriconsepAsignar.setcliente_descripcion(autoriconsep.getcliente_descripcion());	
		autoriconsepAsignar.setnumero_autorizacion(autoriconsep.getnumero_autorizacion());	
		autoriconsepAsignar.setid_tipo_autori_consep(autoriconsep.getid_tipo_autori_consep());
		autoriconsepAsignar.settipoautoriconsep_descripcion(autoriconsep.gettipoautoriconsep_descripcion());	
		autoriconsepAsignar.setid_empleado(autoriconsep.getid_empleado());
		autoriconsepAsignar.setempleado_descripcion(autoriconsep.getempleado_descripcion());	
		autoriconsepAsignar.setfecha_emision(autoriconsep.getfecha_emision());	
		autoriconsepAsignar.setfecha_vencimiento(autoriconsep.getfecha_vencimiento());	
		autoriconsepAsignar.setfecha_ultima(autoriconsep.getfecha_ultima());	
		autoriconsepAsignar.setfecha(autoriconsep.getfecha());	
		autoriconsepAsignar.setdescripcion(autoriconsep.getdescripcion());	
		autoriconsepAsignar.setnombre(autoriconsep.getnombre());	
	}
	
	public static void inicializarAutoriConsep(AutoriConsep autoriconsep) throws Exception {
		try {
				autoriconsep.setId(0L);	
					
				autoriconsep.setid_empresa(-1L);	
				autoriconsep.setid_usuario(-1L);	
				autoriconsep.setes_empresa(false);	
				autoriconsep.setid_cliente(-1L);	
				autoriconsep.setnumero_autorizacion("");	
				autoriconsep.setid_tipo_autori_consep(-1L);	
				autoriconsep.setid_empleado(-1L);	
				autoriconsep.setfecha_emision(new Date());	
				autoriconsep.setfecha_vencimiento(new Date());	
				autoriconsep.setfecha_ultima(new Date());	
				autoriconsep.setfecha(new Date());	
				autoriconsep.setdescripcion("");	
				autoriconsep.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAutoriConsep(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriConsepConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriConsepConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriConsepConstantesFunciones.LABEL_ESEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriConsepConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriConsepConstantesFunciones.LABEL_NUMEROAUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriConsepConstantesFunciones.LABEL_IDTIPOAUTORICONSEP);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriConsepConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriConsepConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriConsepConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriConsepConstantesFunciones.LABEL_FECHAULTIMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriConsepConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriConsepConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriConsepConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAutoriConsep(String sTipo,Row row,Workbook workbook,AutoriConsep autoriconsep,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriconsep.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriconsep.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(autoriconsep.getes_empresa()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriconsep.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriconsep.getnumero_autorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriconsep.gettipoautoriconsep_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriconsep.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriconsep.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriconsep.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriconsep.getfecha_ultima());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriconsep.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriconsep.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoriconsep.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAutoriConsep=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAutoriConsep() {
		return this.sFinalQueryAutoriConsep;
	}
	
	public void setsFinalQueryAutoriConsep(String sFinalQueryAutoriConsep) {
		this.sFinalQueryAutoriConsep= sFinalQueryAutoriConsep;
	}
	
	public Border resaltarSeleccionarAutoriConsep=null;
	
	public Border setResaltarSeleccionarAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//autoriconsepBeanSwingJInternalFrame.jTtoolBarAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAutoriConsep= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAutoriConsep() {
		return this.resaltarSeleccionarAutoriConsep;
	}
	
	public void setResaltarSeleccionarAutoriConsep(Border borderResaltarSeleccionarAutoriConsep) {
		this.resaltarSeleccionarAutoriConsep= borderResaltarSeleccionarAutoriConsep;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAutoriConsep=null;
	public Boolean mostraridAutoriConsep=true;
	public Boolean activaridAutoriConsep=true;

	public Border resaltarid_empresaAutoriConsep=null;
	public Boolean mostrarid_empresaAutoriConsep=true;
	public Boolean activarid_empresaAutoriConsep=true;
	public Boolean cargarid_empresaAutoriConsep=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAutoriConsep=false;//ConEventDepend=true

	public Border resaltarid_usuarioAutoriConsep=null;
	public Boolean mostrarid_usuarioAutoriConsep=true;
	public Boolean activarid_usuarioAutoriConsep=true;
	public Boolean cargarid_usuarioAutoriConsep=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioAutoriConsep=false;//ConEventDepend=true

	public Border resaltares_empresaAutoriConsep=null;
	public Boolean mostrares_empresaAutoriConsep=true;
	public Boolean activares_empresaAutoriConsep=true;

	public Border resaltarid_clienteAutoriConsep=null;
	public Boolean mostrarid_clienteAutoriConsep=true;
	public Boolean activarid_clienteAutoriConsep=true;
	public Boolean cargarid_clienteAutoriConsep=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteAutoriConsep=false;//ConEventDepend=true

	public Border resaltarnumero_autorizacionAutoriConsep=null;
	public Boolean mostrarnumero_autorizacionAutoriConsep=true;
	public Boolean activarnumero_autorizacionAutoriConsep=true;

	public Border resaltarid_tipo_autori_consepAutoriConsep=null;
	public Boolean mostrarid_tipo_autori_consepAutoriConsep=true;
	public Boolean activarid_tipo_autori_consepAutoriConsep=true;
	public Boolean cargarid_tipo_autori_consepAutoriConsep=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_autori_consepAutoriConsep=false;//ConEventDepend=true

	public Border resaltarid_empleadoAutoriConsep=null;
	public Boolean mostrarid_empleadoAutoriConsep=true;
	public Boolean activarid_empleadoAutoriConsep=true;
	public Boolean cargarid_empleadoAutoriConsep=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoAutoriConsep=false;//ConEventDepend=true

	public Border resaltarfecha_emisionAutoriConsep=null;
	public Boolean mostrarfecha_emisionAutoriConsep=true;
	public Boolean activarfecha_emisionAutoriConsep=true;

	public Border resaltarfecha_vencimientoAutoriConsep=null;
	public Boolean mostrarfecha_vencimientoAutoriConsep=true;
	public Boolean activarfecha_vencimientoAutoriConsep=true;

	public Border resaltarfecha_ultimaAutoriConsep=null;
	public Boolean mostrarfecha_ultimaAutoriConsep=true;
	public Boolean activarfecha_ultimaAutoriConsep=true;

	public Border resaltarfechaAutoriConsep=null;
	public Boolean mostrarfechaAutoriConsep=true;
	public Boolean activarfechaAutoriConsep=false;

	public Border resaltardescripcionAutoriConsep=null;
	public Boolean mostrardescripcionAutoriConsep=true;
	public Boolean activardescripcionAutoriConsep=true;

	public Border resaltarnombreAutoriConsep=null;
	public Boolean mostrarnombreAutoriConsep=true;
	public Boolean activarnombreAutoriConsep=false;

	
	

	public Border setResaltaridAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriconsepBeanSwingJInternalFrame.jTtoolBarAutoriConsep.setBorder(borderResaltar);
		
		this.resaltaridAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAutoriConsep() {
		return this.resaltaridAutoriConsep;
	}

	public void setResaltaridAutoriConsep(Border borderResaltar) {
		this.resaltaridAutoriConsep= borderResaltar;
	}

	public Boolean getMostraridAutoriConsep() {
		return this.mostraridAutoriConsep;
	}

	public void setMostraridAutoriConsep(Boolean mostraridAutoriConsep) {
		this.mostraridAutoriConsep= mostraridAutoriConsep;
	}

	public Boolean getActivaridAutoriConsep() {
		return this.activaridAutoriConsep;
	}

	public void setActivaridAutoriConsep(Boolean activaridAutoriConsep) {
		this.activaridAutoriConsep= activaridAutoriConsep;
	}

	public Border setResaltarid_empresaAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriconsepBeanSwingJInternalFrame.jTtoolBarAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarid_empresaAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAutoriConsep() {
		return this.resaltarid_empresaAutoriConsep;
	}

	public void setResaltarid_empresaAutoriConsep(Border borderResaltar) {
		this.resaltarid_empresaAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarid_empresaAutoriConsep() {
		return this.mostrarid_empresaAutoriConsep;
	}

	public void setMostrarid_empresaAutoriConsep(Boolean mostrarid_empresaAutoriConsep) {
		this.mostrarid_empresaAutoriConsep= mostrarid_empresaAutoriConsep;
	}

	public Boolean getActivarid_empresaAutoriConsep() {
		return this.activarid_empresaAutoriConsep;
	}

	public void setActivarid_empresaAutoriConsep(Boolean activarid_empresaAutoriConsep) {
		this.activarid_empresaAutoriConsep= activarid_empresaAutoriConsep;
	}

	public Boolean getCargarid_empresaAutoriConsep() {
		return this.cargarid_empresaAutoriConsep;
	}

	public void setCargarid_empresaAutoriConsep(Boolean cargarid_empresaAutoriConsep) {
		this.cargarid_empresaAutoriConsep= cargarid_empresaAutoriConsep;
	}

	public Border setResaltarid_usuarioAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriconsepBeanSwingJInternalFrame.jTtoolBarAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarid_usuarioAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioAutoriConsep() {
		return this.resaltarid_usuarioAutoriConsep;
	}

	public void setResaltarid_usuarioAutoriConsep(Border borderResaltar) {
		this.resaltarid_usuarioAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarid_usuarioAutoriConsep() {
		return this.mostrarid_usuarioAutoriConsep;
	}

	public void setMostrarid_usuarioAutoriConsep(Boolean mostrarid_usuarioAutoriConsep) {
		this.mostrarid_usuarioAutoriConsep= mostrarid_usuarioAutoriConsep;
	}

	public Boolean getActivarid_usuarioAutoriConsep() {
		return this.activarid_usuarioAutoriConsep;
	}

	public void setActivarid_usuarioAutoriConsep(Boolean activarid_usuarioAutoriConsep) {
		this.activarid_usuarioAutoriConsep= activarid_usuarioAutoriConsep;
	}

	public Boolean getCargarid_usuarioAutoriConsep() {
		return this.cargarid_usuarioAutoriConsep;
	}

	public void setCargarid_usuarioAutoriConsep(Boolean cargarid_usuarioAutoriConsep) {
		this.cargarid_usuarioAutoriConsep= cargarid_usuarioAutoriConsep;
	}

	public Border setResaltares_empresaAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriconsepBeanSwingJInternalFrame.jTtoolBarAutoriConsep.setBorder(borderResaltar);
		
		this.resaltares_empresaAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_empresaAutoriConsep() {
		return this.resaltares_empresaAutoriConsep;
	}

	public void setResaltares_empresaAutoriConsep(Border borderResaltar) {
		this.resaltares_empresaAutoriConsep= borderResaltar;
	}

	public Boolean getMostrares_empresaAutoriConsep() {
		return this.mostrares_empresaAutoriConsep;
	}

	public void setMostrares_empresaAutoriConsep(Boolean mostrares_empresaAutoriConsep) {
		this.mostrares_empresaAutoriConsep= mostrares_empresaAutoriConsep;
	}

	public Boolean getActivares_empresaAutoriConsep() {
		return this.activares_empresaAutoriConsep;
	}

	public void setActivares_empresaAutoriConsep(Boolean activares_empresaAutoriConsep) {
		this.activares_empresaAutoriConsep= activares_empresaAutoriConsep;
	}

	public Border setResaltarid_clienteAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriconsepBeanSwingJInternalFrame.jTtoolBarAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarid_clienteAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteAutoriConsep() {
		return this.resaltarid_clienteAutoriConsep;
	}

	public void setResaltarid_clienteAutoriConsep(Border borderResaltar) {
		this.resaltarid_clienteAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarid_clienteAutoriConsep() {
		return this.mostrarid_clienteAutoriConsep;
	}

	public void setMostrarid_clienteAutoriConsep(Boolean mostrarid_clienteAutoriConsep) {
		this.mostrarid_clienteAutoriConsep= mostrarid_clienteAutoriConsep;
	}

	public Boolean getActivarid_clienteAutoriConsep() {
		return this.activarid_clienteAutoriConsep;
	}

	public void setActivarid_clienteAutoriConsep(Boolean activarid_clienteAutoriConsep) {
		this.activarid_clienteAutoriConsep= activarid_clienteAutoriConsep;
	}

	public Boolean getCargarid_clienteAutoriConsep() {
		return this.cargarid_clienteAutoriConsep;
	}

	public void setCargarid_clienteAutoriConsep(Boolean cargarid_clienteAutoriConsep) {
		this.cargarid_clienteAutoriConsep= cargarid_clienteAutoriConsep;
	}

	public Border setResaltarnumero_autorizacionAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriconsepBeanSwingJInternalFrame.jTtoolBarAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarnumero_autorizacionAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_autorizacionAutoriConsep() {
		return this.resaltarnumero_autorizacionAutoriConsep;
	}

	public void setResaltarnumero_autorizacionAutoriConsep(Border borderResaltar) {
		this.resaltarnumero_autorizacionAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarnumero_autorizacionAutoriConsep() {
		return this.mostrarnumero_autorizacionAutoriConsep;
	}

	public void setMostrarnumero_autorizacionAutoriConsep(Boolean mostrarnumero_autorizacionAutoriConsep) {
		this.mostrarnumero_autorizacionAutoriConsep= mostrarnumero_autorizacionAutoriConsep;
	}

	public Boolean getActivarnumero_autorizacionAutoriConsep() {
		return this.activarnumero_autorizacionAutoriConsep;
	}

	public void setActivarnumero_autorizacionAutoriConsep(Boolean activarnumero_autorizacionAutoriConsep) {
		this.activarnumero_autorizacionAutoriConsep= activarnumero_autorizacionAutoriConsep;
	}

	public Border setResaltarid_tipo_autori_consepAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriconsepBeanSwingJInternalFrame.jTtoolBarAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarid_tipo_autori_consepAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_autori_consepAutoriConsep() {
		return this.resaltarid_tipo_autori_consepAutoriConsep;
	}

	public void setResaltarid_tipo_autori_consepAutoriConsep(Border borderResaltar) {
		this.resaltarid_tipo_autori_consepAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarid_tipo_autori_consepAutoriConsep() {
		return this.mostrarid_tipo_autori_consepAutoriConsep;
	}

	public void setMostrarid_tipo_autori_consepAutoriConsep(Boolean mostrarid_tipo_autori_consepAutoriConsep) {
		this.mostrarid_tipo_autori_consepAutoriConsep= mostrarid_tipo_autori_consepAutoriConsep;
	}

	public Boolean getActivarid_tipo_autori_consepAutoriConsep() {
		return this.activarid_tipo_autori_consepAutoriConsep;
	}

	public void setActivarid_tipo_autori_consepAutoriConsep(Boolean activarid_tipo_autori_consepAutoriConsep) {
		this.activarid_tipo_autori_consepAutoriConsep= activarid_tipo_autori_consepAutoriConsep;
	}

	public Boolean getCargarid_tipo_autori_consepAutoriConsep() {
		return this.cargarid_tipo_autori_consepAutoriConsep;
	}

	public void setCargarid_tipo_autori_consepAutoriConsep(Boolean cargarid_tipo_autori_consepAutoriConsep) {
		this.cargarid_tipo_autori_consepAutoriConsep= cargarid_tipo_autori_consepAutoriConsep;
	}

	public Border setResaltarid_empleadoAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriconsepBeanSwingJInternalFrame.jTtoolBarAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarid_empleadoAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoAutoriConsep() {
		return this.resaltarid_empleadoAutoriConsep;
	}

	public void setResaltarid_empleadoAutoriConsep(Border borderResaltar) {
		this.resaltarid_empleadoAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarid_empleadoAutoriConsep() {
		return this.mostrarid_empleadoAutoriConsep;
	}

	public void setMostrarid_empleadoAutoriConsep(Boolean mostrarid_empleadoAutoriConsep) {
		this.mostrarid_empleadoAutoriConsep= mostrarid_empleadoAutoriConsep;
	}

	public Boolean getActivarid_empleadoAutoriConsep() {
		return this.activarid_empleadoAutoriConsep;
	}

	public void setActivarid_empleadoAutoriConsep(Boolean activarid_empleadoAutoriConsep) {
		this.activarid_empleadoAutoriConsep= activarid_empleadoAutoriConsep;
	}

	public Boolean getCargarid_empleadoAutoriConsep() {
		return this.cargarid_empleadoAutoriConsep;
	}

	public void setCargarid_empleadoAutoriConsep(Boolean cargarid_empleadoAutoriConsep) {
		this.cargarid_empleadoAutoriConsep= cargarid_empleadoAutoriConsep;
	}

	public Border setResaltarfecha_emisionAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriconsepBeanSwingJInternalFrame.jTtoolBarAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionAutoriConsep() {
		return this.resaltarfecha_emisionAutoriConsep;
	}

	public void setResaltarfecha_emisionAutoriConsep(Border borderResaltar) {
		this.resaltarfecha_emisionAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionAutoriConsep() {
		return this.mostrarfecha_emisionAutoriConsep;
	}

	public void setMostrarfecha_emisionAutoriConsep(Boolean mostrarfecha_emisionAutoriConsep) {
		this.mostrarfecha_emisionAutoriConsep= mostrarfecha_emisionAutoriConsep;
	}

	public Boolean getActivarfecha_emisionAutoriConsep() {
		return this.activarfecha_emisionAutoriConsep;
	}

	public void setActivarfecha_emisionAutoriConsep(Boolean activarfecha_emisionAutoriConsep) {
		this.activarfecha_emisionAutoriConsep= activarfecha_emisionAutoriConsep;
	}

	public Border setResaltarfecha_vencimientoAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriconsepBeanSwingJInternalFrame.jTtoolBarAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoAutoriConsep() {
		return this.resaltarfecha_vencimientoAutoriConsep;
	}

	public void setResaltarfecha_vencimientoAutoriConsep(Border borderResaltar) {
		this.resaltarfecha_vencimientoAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoAutoriConsep() {
		return this.mostrarfecha_vencimientoAutoriConsep;
	}

	public void setMostrarfecha_vencimientoAutoriConsep(Boolean mostrarfecha_vencimientoAutoriConsep) {
		this.mostrarfecha_vencimientoAutoriConsep= mostrarfecha_vencimientoAutoriConsep;
	}

	public Boolean getActivarfecha_vencimientoAutoriConsep() {
		return this.activarfecha_vencimientoAutoriConsep;
	}

	public void setActivarfecha_vencimientoAutoriConsep(Boolean activarfecha_vencimientoAutoriConsep) {
		this.activarfecha_vencimientoAutoriConsep= activarfecha_vencimientoAutoriConsep;
	}

	public Border setResaltarfecha_ultimaAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriconsepBeanSwingJInternalFrame.jTtoolBarAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarfecha_ultimaAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultimaAutoriConsep() {
		return this.resaltarfecha_ultimaAutoriConsep;
	}

	public void setResaltarfecha_ultimaAutoriConsep(Border borderResaltar) {
		this.resaltarfecha_ultimaAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarfecha_ultimaAutoriConsep() {
		return this.mostrarfecha_ultimaAutoriConsep;
	}

	public void setMostrarfecha_ultimaAutoriConsep(Boolean mostrarfecha_ultimaAutoriConsep) {
		this.mostrarfecha_ultimaAutoriConsep= mostrarfecha_ultimaAutoriConsep;
	}

	public Boolean getActivarfecha_ultimaAutoriConsep() {
		return this.activarfecha_ultimaAutoriConsep;
	}

	public void setActivarfecha_ultimaAutoriConsep(Boolean activarfecha_ultimaAutoriConsep) {
		this.activarfecha_ultimaAutoriConsep= activarfecha_ultimaAutoriConsep;
	}

	public Border setResaltarfechaAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriconsepBeanSwingJInternalFrame.jTtoolBarAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarfechaAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaAutoriConsep() {
		return this.resaltarfechaAutoriConsep;
	}

	public void setResaltarfechaAutoriConsep(Border borderResaltar) {
		this.resaltarfechaAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarfechaAutoriConsep() {
		return this.mostrarfechaAutoriConsep;
	}

	public void setMostrarfechaAutoriConsep(Boolean mostrarfechaAutoriConsep) {
		this.mostrarfechaAutoriConsep= mostrarfechaAutoriConsep;
	}

	public Boolean getActivarfechaAutoriConsep() {
		return this.activarfechaAutoriConsep;
	}

	public void setActivarfechaAutoriConsep(Boolean activarfechaAutoriConsep) {
		this.activarfechaAutoriConsep= activarfechaAutoriConsep;
	}

	public Border setResaltardescripcionAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriconsepBeanSwingJInternalFrame.jTtoolBarAutoriConsep.setBorder(borderResaltar);
		
		this.resaltardescripcionAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionAutoriConsep() {
		return this.resaltardescripcionAutoriConsep;
	}

	public void setResaltardescripcionAutoriConsep(Border borderResaltar) {
		this.resaltardescripcionAutoriConsep= borderResaltar;
	}

	public Boolean getMostrardescripcionAutoriConsep() {
		return this.mostrardescripcionAutoriConsep;
	}

	public void setMostrardescripcionAutoriConsep(Boolean mostrardescripcionAutoriConsep) {
		this.mostrardescripcionAutoriConsep= mostrardescripcionAutoriConsep;
	}

	public Boolean getActivardescripcionAutoriConsep() {
		return this.activardescripcionAutoriConsep;
	}

	public void setActivardescripcionAutoriConsep(Boolean activardescripcionAutoriConsep) {
		this.activardescripcionAutoriConsep= activardescripcionAutoriConsep;
	}

	public Border setResaltarnombreAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoriconsepBeanSwingJInternalFrame.jTtoolBarAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarnombreAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreAutoriConsep() {
		return this.resaltarnombreAutoriConsep;
	}

	public void setResaltarnombreAutoriConsep(Border borderResaltar) {
		this.resaltarnombreAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarnombreAutoriConsep() {
		return this.mostrarnombreAutoriConsep;
	}

	public void setMostrarnombreAutoriConsep(Boolean mostrarnombreAutoriConsep) {
		this.mostrarnombreAutoriConsep= mostrarnombreAutoriConsep;
	}

	public Boolean getActivarnombreAutoriConsep() {
		return this.activarnombreAutoriConsep;
	}

	public void setActivarnombreAutoriConsep(Boolean activarnombreAutoriConsep) {
		this.activarnombreAutoriConsep= activarnombreAutoriConsep;
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
		
		
		this.setMostraridAutoriConsep(esInicial);
		this.setMostrarid_empresaAutoriConsep(esInicial);
		this.setMostrarid_usuarioAutoriConsep(esInicial);
		this.setMostrares_empresaAutoriConsep(esInicial);
		this.setMostrarid_clienteAutoriConsep(esInicial);
		this.setMostrarnumero_autorizacionAutoriConsep(esInicial);
		this.setMostrarid_tipo_autori_consepAutoriConsep(esInicial);
		this.setMostrarid_empleadoAutoriConsep(esInicial);
		this.setMostrarfecha_emisionAutoriConsep(esInicial);
		this.setMostrarfecha_vencimientoAutoriConsep(esInicial);
		this.setMostrarfecha_ultimaAutoriConsep(esInicial);
		this.setMostrarfechaAutoriConsep(esInicial);
		this.setMostrardescripcionAutoriConsep(esInicial);
		this.setMostrarnombreAutoriConsep(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutoriConsepConstantesFunciones.ID)) {
				this.setMostraridAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.ESEMPRESA)) {
				this.setMostrares_empresaAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setMostrarnumero_autorizacionAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.IDTIPOAUTORICONSEP)) {
				this.setMostrarid_tipo_autori_consepAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.FECHAULTIMA)) {
				this.setMostrarfecha_ultimaAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.FECHA)) {
				this.setMostrarfechaAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreAutoriConsep(esAsigna);
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
		
		
		this.setActivaridAutoriConsep(esInicial);
		this.setActivarid_empresaAutoriConsep(esInicial);
		this.setActivarid_usuarioAutoriConsep(esInicial);
		this.setActivares_empresaAutoriConsep(esInicial);
		this.setActivarid_clienteAutoriConsep(esInicial);
		this.setActivarnumero_autorizacionAutoriConsep(esInicial);
		this.setActivarid_tipo_autori_consepAutoriConsep(esInicial);
		this.setActivarid_empleadoAutoriConsep(esInicial);
		this.setActivarfecha_emisionAutoriConsep(esInicial);
		this.setActivarfecha_vencimientoAutoriConsep(esInicial);
		this.setActivarfecha_ultimaAutoriConsep(esInicial);
		this.setActivarfechaAutoriConsep(esInicial);
		this.setActivardescripcionAutoriConsep(esInicial);
		this.setActivarnombreAutoriConsep(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutoriConsepConstantesFunciones.ID)) {
				this.setActivaridAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.ESEMPRESA)) {
				this.setActivares_empresaAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setActivarnumero_autorizacionAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.IDTIPOAUTORICONSEP)) {
				this.setActivarid_tipo_autori_consepAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.FECHAULTIMA)) {
				this.setActivarfecha_ultimaAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.FECHA)) {
				this.setActivarfechaAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.NOMBRE)) {
				this.setActivarnombreAutoriConsep(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAutoriConsep(esInicial);
		this.setResaltarid_empresaAutoriConsep(esInicial);
		this.setResaltarid_usuarioAutoriConsep(esInicial);
		this.setResaltares_empresaAutoriConsep(esInicial);
		this.setResaltarid_clienteAutoriConsep(esInicial);
		this.setResaltarnumero_autorizacionAutoriConsep(esInicial);
		this.setResaltarid_tipo_autori_consepAutoriConsep(esInicial);
		this.setResaltarid_empleadoAutoriConsep(esInicial);
		this.setResaltarfecha_emisionAutoriConsep(esInicial);
		this.setResaltarfecha_vencimientoAutoriConsep(esInicial);
		this.setResaltarfecha_ultimaAutoriConsep(esInicial);
		this.setResaltarfechaAutoriConsep(esInicial);
		this.setResaltardescripcionAutoriConsep(esInicial);
		this.setResaltarnombreAutoriConsep(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutoriConsepConstantesFunciones.ID)) {
				this.setResaltaridAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.ESEMPRESA)) {
				this.setResaltares_empresaAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setResaltarnumero_autorizacionAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.IDTIPOAUTORICONSEP)) {
				this.setResaltarid_tipo_autori_consepAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.FECHAULTIMA)) {
				this.setResaltarfecha_ultimaAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.FECHA)) {
				this.setResaltarfechaAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriConsepConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreAutoriConsep(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleAutoriConsepAutoriConsep=null;

	public Border getResaltarDetalleAutoriConsepAutoriConsep() {
		return this.resaltarDetalleAutoriConsepAutoriConsep;
	}

	public void setResaltarDetalleAutoriConsepAutoriConsep(Border borderResaltarDetalleAutoriConsep) {
		if(borderResaltarDetalleAutoriConsep!=null) {
			this.resaltarDetalleAutoriConsepAutoriConsep= borderResaltarDetalleAutoriConsep;
		}
	}

	public Border setResaltarDetalleAutoriConsepAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleAutoriConsep=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//autoriconsepBeanSwingJInternalFrame.jTtoolBarAutoriConsep.setBorder(borderResaltarDetalleAutoriConsep);
			
		this.resaltarDetalleAutoriConsepAutoriConsep= borderResaltarDetalleAutoriConsep;

		 return borderResaltarDetalleAutoriConsep;
	}



	public Boolean mostrarDetalleAutoriConsepAutoriConsep=true;

	public Boolean getMostrarDetalleAutoriConsepAutoriConsep() {
		return this.mostrarDetalleAutoriConsepAutoriConsep;
	}

	public void setMostrarDetalleAutoriConsepAutoriConsep(Boolean visibilidadResaltarDetalleAutoriConsep) {
		this.mostrarDetalleAutoriConsepAutoriConsep= visibilidadResaltarDetalleAutoriConsep;
	}



	public Boolean activarDetalleAutoriConsepAutoriConsep=true;

	public Boolean gethabilitarResaltarDetalleAutoriConsepAutoriConsep() {
		return this.activarDetalleAutoriConsepAutoriConsep;
	}

	public void setActivarDetalleAutoriConsepAutoriConsep(Boolean habilitarResaltarDetalleAutoriConsep) {
		this.activarDetalleAutoriConsepAutoriConsep= habilitarResaltarDetalleAutoriConsep;
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

		this.setMostrarDetalleAutoriConsepAutoriConsep(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleAutoriConsep.class)) {
				this.setMostrarDetalleAutoriConsepAutoriConsep(esAsigna);
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

		this.setActivarDetalleAutoriConsepAutoriConsep(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleAutoriConsep.class)) {
				this.setActivarDetalleAutoriConsepAutoriConsep(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleAutoriConsepAutoriConsep(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleAutoriConsep.class)) {
				this.setResaltarDetalleAutoriConsepAutoriConsep(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNumeroAutorizacionAutoriConsep=true;

	public Boolean getMostrarBusquedaPorNumeroAutorizacionAutoriConsep() {
		return this.mostrarBusquedaPorNumeroAutorizacionAutoriConsep;
	}

	public void setMostrarBusquedaPorNumeroAutorizacionAutoriConsep(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNumeroAutorizacionAutoriConsep= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteAutoriConsep=true;

	public Boolean getMostrarFK_IdClienteAutoriConsep() {
		return this.mostrarFK_IdClienteAutoriConsep;
	}

	public void setMostrarFK_IdClienteAutoriConsep(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteAutoriConsep= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoAutoriConsep=true;

	public Boolean getMostrarFK_IdEmpleadoAutoriConsep() {
		return this.mostrarFK_IdEmpleadoAutoriConsep;
	}

	public void setMostrarFK_IdEmpleadoAutoriConsep(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoAutoriConsep= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaAutoriConsep=true;

	public Boolean getMostrarFK_IdEmpresaAutoriConsep() {
		return this.mostrarFK_IdEmpresaAutoriConsep;
	}

	public void setMostrarFK_IdEmpresaAutoriConsep(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaAutoriConsep= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoAutoriConsepAutoriConsep=true;

	public Boolean getMostrarFK_IdTipoAutoriConsepAutoriConsep() {
		return this.mostrarFK_IdTipoAutoriConsepAutoriConsep;
	}

	public void setMostrarFK_IdTipoAutoriConsepAutoriConsep(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoAutoriConsepAutoriConsep= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioAutoriConsep=true;

	public Boolean getMostrarFK_IdUsuarioAutoriConsep() {
		return this.mostrarFK_IdUsuarioAutoriConsep;
	}

	public void setMostrarFK_IdUsuarioAutoriConsep(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioAutoriConsep= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNumeroAutorizacionAutoriConsep=true;

	public Boolean getActivarBusquedaPorNumeroAutorizacionAutoriConsep() {
		return this.activarBusquedaPorNumeroAutorizacionAutoriConsep;
	}

	public void setActivarBusquedaPorNumeroAutorizacionAutoriConsep(Boolean habilitarResaltar) {
		this.activarBusquedaPorNumeroAutorizacionAutoriConsep= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteAutoriConsep=true;

	public Boolean getActivarFK_IdClienteAutoriConsep() {
		return this.activarFK_IdClienteAutoriConsep;
	}

	public void setActivarFK_IdClienteAutoriConsep(Boolean habilitarResaltar) {
		this.activarFK_IdClienteAutoriConsep= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoAutoriConsep=true;

	public Boolean getActivarFK_IdEmpleadoAutoriConsep() {
		return this.activarFK_IdEmpleadoAutoriConsep;
	}

	public void setActivarFK_IdEmpleadoAutoriConsep(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoAutoriConsep= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaAutoriConsep=true;

	public Boolean getActivarFK_IdEmpresaAutoriConsep() {
		return this.activarFK_IdEmpresaAutoriConsep;
	}

	public void setActivarFK_IdEmpresaAutoriConsep(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaAutoriConsep= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoAutoriConsepAutoriConsep=true;

	public Boolean getActivarFK_IdTipoAutoriConsepAutoriConsep() {
		return this.activarFK_IdTipoAutoriConsepAutoriConsep;
	}

	public void setActivarFK_IdTipoAutoriConsepAutoriConsep(Boolean habilitarResaltar) {
		this.activarFK_IdTipoAutoriConsepAutoriConsep= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioAutoriConsep=true;

	public Boolean getActivarFK_IdUsuarioAutoriConsep() {
		return this.activarFK_IdUsuarioAutoriConsep;
	}

	public void setActivarFK_IdUsuarioAutoriConsep(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioAutoriConsep= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNumeroAutorizacionAutoriConsep=null;

	public Border getResaltarBusquedaPorNumeroAutorizacionAutoriConsep() {
		return this.resaltarBusquedaPorNumeroAutorizacionAutoriConsep;
	}

	public void setResaltarBusquedaPorNumeroAutorizacionAutoriConsep(Border borderResaltar) {
		this.resaltarBusquedaPorNumeroAutorizacionAutoriConsep= borderResaltar;
	}

	public void setResaltarBusquedaPorNumeroAutorizacionAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNumeroAutorizacionAutoriConsep= borderResaltar;
	}

	public Border resaltarFK_IdClienteAutoriConsep=null;

	public Border getResaltarFK_IdClienteAutoriConsep() {
		return this.resaltarFK_IdClienteAutoriConsep;
	}

	public void setResaltarFK_IdClienteAutoriConsep(Border borderResaltar) {
		this.resaltarFK_IdClienteAutoriConsep= borderResaltar;
	}

	public void setResaltarFK_IdClienteAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteAutoriConsep= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoAutoriConsep=null;

	public Border getResaltarFK_IdEmpleadoAutoriConsep() {
		return this.resaltarFK_IdEmpleadoAutoriConsep;
	}

	public void setResaltarFK_IdEmpleadoAutoriConsep(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoAutoriConsep= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoAutoriConsep= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaAutoriConsep=null;

	public Border getResaltarFK_IdEmpresaAutoriConsep() {
		return this.resaltarFK_IdEmpresaAutoriConsep;
	}

	public void setResaltarFK_IdEmpresaAutoriConsep(Border borderResaltar) {
		this.resaltarFK_IdEmpresaAutoriConsep= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaAutoriConsep= borderResaltar;
	}

	public Border resaltarFK_IdTipoAutoriConsepAutoriConsep=null;

	public Border getResaltarFK_IdTipoAutoriConsepAutoriConsep() {
		return this.resaltarFK_IdTipoAutoriConsepAutoriConsep;
	}

	public void setResaltarFK_IdTipoAutoriConsepAutoriConsep(Border borderResaltar) {
		this.resaltarFK_IdTipoAutoriConsepAutoriConsep= borderResaltar;
	}

	public void setResaltarFK_IdTipoAutoriConsepAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoAutoriConsepAutoriConsep= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioAutoriConsep=null;

	public Border getResaltarFK_IdUsuarioAutoriConsep() {
		return this.resaltarFK_IdUsuarioAutoriConsep;
	}

	public void setResaltarFK_IdUsuarioAutoriConsep(Border borderResaltar) {
		this.resaltarFK_IdUsuarioAutoriConsep= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriConsepBeanSwingJInternalFrame autoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioAutoriConsep= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}