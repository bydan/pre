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


import com.bydan.erp.cartera.util.SubClienteConstantesFunciones;
import com.bydan.erp.cartera.util.SubClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.SubClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SubClienteConstantesFunciones extends SubClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="SubCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SubCliente"+SubClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SubClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SubClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SubClienteConstantesFunciones.SCHEMA+"_"+SubClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SubClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SubClienteConstantesFunciones.SCHEMA+"_"+SubClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SubClienteConstantesFunciones.SCHEMA+"_"+SubClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SubClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SubClienteConstantesFunciones.SCHEMA+"_"+SubClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SubClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SubClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SubClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SubClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SubClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SubClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Sub Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Sub Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Sub Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SubCliente";
	public static final String OBJECTNAME="subcliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="sub_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select subcliente from "+SubClienteConstantesFunciones.SPERSISTENCENAME+" subcliente";
	public static String QUERYSELECTNATIVE="select "+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".version_row,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_empresa,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_cliente,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_sucursal,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_tipo_identificacion,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".identificacion,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".ruc,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".nombre,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".apellido,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".nombre_completo,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".direccion,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".telefono,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".numero_celular,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".mail,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".fecha_nacimiento,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".fechao,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".observacion,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_pais,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_ciudad,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_zona,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_pais_nacionalidad,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_tipo_genero,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_estado_civil,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_estado_legal,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_tipo_nivel_edu,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".path_imagen_firma,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_cuenta_contable,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".numero_carga,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".limite_credito,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".descuento,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".codigo_contrato,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".valor_contrato,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".fecha_inicio,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".fecha_fin,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".plazo from "+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME;//+" as "+SubClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SubClienteConstantesFuncionesAdditional subclienteConstantesFuncionesAdditional=null;
	
	public SubClienteConstantesFuncionesAdditional getSubClienteConstantesFuncionesAdditional() {
		return this.subclienteConstantesFuncionesAdditional;
	}
	
	public void setSubClienteConstantesFuncionesAdditional(SubClienteConstantesFuncionesAdditional subclienteConstantesFuncionesAdditional) {
		try {
			this.subclienteConstantesFuncionesAdditional=subclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTIPOIDENTIFICACION= "id_tipo_identificacion";
    public static final String IDENTIFICACION= "identificacion";
    public static final String RUC= "ruc";
    public static final String NOMBRE= "nombre";
    public static final String APELLIDO= "apellido";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String DIRECCION= "direccion";
    public static final String TELEFONO= "telefono";
    public static final String NUMEROCELULAR= "numero_celular";
    public static final String MAIL= "mail";
    public static final String FECHANACIMIENTO= "fecha_nacimiento";
    public static final String FECHA= "fechao";
    public static final String OBSERVACION= "observacion";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String IDZONA= "id_zona";
    public static final String IDPAISNACIONALIDAD= "id_pais_nacionalidad";
    public static final String IDTIPOGENERO= "id_tipo_genero";
    public static final String IDESTADOCIVIL= "id_estado_civil";
    public static final String IDESTADOLEGAL= "id_estado_legal";
    public static final String IDTIPONIVELEDU= "id_tipo_nivel_edu";
    public static final String PATHIMAGENFIRMA= "path_imagen_firma";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String NUMEROCARGA= "numero_carga";
    public static final String LIMITECREDITO= "limite_credito";
    public static final String DESCUENTO= "descuento";
    public static final String CODIGOCONTRATO= "codigo_contrato";
    public static final String VALORCONTRATO= "valor_contrato";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String PLAZO= "plazo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDTIPOIDENTIFICACION= "Tipo Identificacion";
		public static final String LABEL_IDTIPOIDENTIFICACION_LOWER= "Tipo Identificacion";
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
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_NUMEROCELULAR= "Numero Celular";
		public static final String LABEL_NUMEROCELULAR_LOWER= "Numero Celular";
    	public static final String LABEL_MAIL= "Mail";
		public static final String LABEL_MAIL_LOWER= "Mail";
    	public static final String LABEL_FECHANACIMIENTO= "Fecha Nacimiento";
		public static final String LABEL_FECHANACIMIENTO_LOWER= "Fecha Nacimiento";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_OBSERVACION= "Observacion";
		public static final String LABEL_OBSERVACION_LOWER= "Observacion";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_IDZONA= "Zona";
		public static final String LABEL_IDZONA_LOWER= "Zona";
    	public static final String LABEL_IDPAISNACIONALIDAD= "Pais Nacionalad";
		public static final String LABEL_IDPAISNACIONALIDAD_LOWER= "Pais Nacionalidad";
    	public static final String LABEL_IDTIPOGENERO= "Tipo Genero";
		public static final String LABEL_IDTIPOGENERO_LOWER= "Tipo Genero";
    	public static final String LABEL_IDESTADOCIVIL= "Estado Civil";
		public static final String LABEL_IDESTADOCIVIL_LOWER= "Estado Civil";
    	public static final String LABEL_IDESTADOLEGAL= "Estado Legal";
		public static final String LABEL_IDESTADOLEGAL_LOWER= "Estado Legal";
    	public static final String LABEL_IDTIPONIVELEDU= "Tipo Nivel Educativo";
		public static final String LABEL_IDTIPONIVELEDU_LOWER= "Tipo Nivel Edu";
    	public static final String LABEL_PATHIMAGENFIRMA= "Path Imagen Firma";
		public static final String LABEL_PATHIMAGENFIRMA_LOWER= "Path Imagen Firma";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_NUMEROCARGA= "Numero Carga";
		public static final String LABEL_NUMEROCARGA_LOWER= "Numero Carga";
    	public static final String LABEL_LIMITECREDITO= "Limite Credito";
		public static final String LABEL_LIMITECREDITO_LOWER= "Limite Credito";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_CODIGOCONTRATO= "Codigo Contrato";
		public static final String LABEL_CODIGOCONTRATO_LOWER= "Codigo Contrato";
    	public static final String LABEL_VALORCONTRATO= "Valor Contrato";
		public static final String LABEL_VALORCONTRATO_LOWER= "Valor Contrato";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_PLAZO= "Plazo";
		public static final String LABEL_PLAZO_LOWER= "Plazo";
	
		
		
		
		
		
		
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
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXNUMERO_CELULAR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CELULAR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMAIL=ConstantesValidacion.SREGEXCADENA_MAIL;
	public static final String SMENSAJEREGEXMAIL=ConstantesValidacion.SVALIDACIONCADENA_MAIL;	
		
		
	public static final String SREGEXOBSERVACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
	public static final String SREGEXPATH_IMAGEN_FIRMA=ConstantesValidacion.SREGEXCADENATODOS;
	public static final String SMENSAJEREGEXPATH_IMAGEN_FIRMA=ConstantesValidacion.SVALIDACIONTODOS;	
		
		
		
		
	public static final String SREGEXCODIGO_CONTRATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CONTRATO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getSubClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SubClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.IDCLIENTE)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.IDSUCURSAL)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.IDTIPOIDENTIFICACION)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_IDTIPOIDENTIFICACION;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.IDENTIFICACION)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_IDENTIFICACION;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.RUC)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.NOMBRE)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.APELLIDO)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_APELLIDO;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.DIRECCION)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.TELEFONO)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.NUMEROCELULAR)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_NUMEROCELULAR;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.MAIL)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_MAIL;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.FECHANACIMIENTO)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_FECHANACIMIENTO;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.FECHA)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.OBSERVACION)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_OBSERVACION;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.IDPAIS)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.IDCIUDAD)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.IDZONA)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_IDZONA;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.IDPAISNACIONALIDAD)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_IDPAISNACIONALIDAD;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.IDTIPOGENERO)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_IDTIPOGENERO;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.IDESTADOCIVIL)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_IDESTADOCIVIL;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.IDESTADOLEGAL)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_IDESTADOLEGAL;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.IDTIPONIVELEDU)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_IDTIPONIVELEDU;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.PATHIMAGENFIRMA)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_PATHIMAGENFIRMA;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.NUMEROCARGA)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_NUMEROCARGA;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.LIMITECREDITO)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_LIMITECREDITO;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.DESCUENTO)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.CODIGOCONTRATO)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_CODIGOCONTRATO;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.VALORCONTRATO)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_VALORCONTRATO;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.FECHAINICIO)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.FECHAFIN)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(SubClienteConstantesFunciones.PLAZO)) {sLabelColumna=SubClienteConstantesFunciones.LABEL_PLAZO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getSubClienteDescripcion(SubCliente subcliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(subcliente !=null/* && subcliente.getId()!=0*/) {
			sDescripcion=subcliente.getnombre();//subclientesubcliente.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getSubClienteDescripcionDetallado(SubCliente subcliente) {
		String sDescripcion="";
			
		sDescripcion+=SubClienteConstantesFunciones.ID+"=";
		sDescripcion+=subcliente.getId().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=subcliente.getVersionRow().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=subcliente.getid_empresa().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=subcliente.getid_cliente().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=subcliente.getid_sucursal().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.IDTIPOIDENTIFICACION+"=";
		sDescripcion+=subcliente.getid_tipo_identificacion().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.IDENTIFICACION+"=";
		sDescripcion+=subcliente.getidentificacion()+",";
		sDescripcion+=SubClienteConstantesFunciones.RUC+"=";
		sDescripcion+=subcliente.getruc()+",";
		sDescripcion+=SubClienteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=subcliente.getnombre()+",";
		sDescripcion+=SubClienteConstantesFunciones.APELLIDO+"=";
		sDescripcion+=subcliente.getapellido()+",";
		sDescripcion+=SubClienteConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=subcliente.getnombre_completo()+",";
		sDescripcion+=SubClienteConstantesFunciones.DIRECCION+"=";
		sDescripcion+=subcliente.getdireccion()+",";
		sDescripcion+=SubClienteConstantesFunciones.TELEFONO+"=";
		sDescripcion+=subcliente.gettelefono()+",";
		sDescripcion+=SubClienteConstantesFunciones.NUMEROCELULAR+"=";
		sDescripcion+=subcliente.getnumero_celular()+",";
		sDescripcion+=SubClienteConstantesFunciones.MAIL+"=";
		sDescripcion+=subcliente.getmail()+",";
		sDescripcion+=SubClienteConstantesFunciones.FECHANACIMIENTO+"=";
		sDescripcion+=subcliente.getfecha_nacimiento().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.FECHA+"=";
		sDescripcion+=subcliente.getfechao().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.OBSERVACION+"=";
		sDescripcion+=subcliente.getobservacion()+",";
		sDescripcion+=SubClienteConstantesFunciones.IDPAIS+"=";
		sDescripcion+=subcliente.getid_pais().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=subcliente.getid_ciudad().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.IDZONA+"=";
		sDescripcion+=subcliente.getid_zona().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.IDPAISNACIONALIDAD+"=";
		sDescripcion+=subcliente.getid_pais_nacionalidad().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.IDTIPOGENERO+"=";
		sDescripcion+=subcliente.getid_tipo_genero().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.IDESTADOCIVIL+"=";
		sDescripcion+=subcliente.getid_estado_civil().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.IDESTADOLEGAL+"=";
		sDescripcion+=subcliente.getid_estado_legal().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.IDTIPONIVELEDU+"=";
		sDescripcion+=subcliente.getid_tipo_nivel_edu().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.PATHIMAGENFIRMA+"=";
		sDescripcion+=subcliente.getpath_imagen_firma()+",";
		sDescripcion+=SubClienteConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=subcliente.getid_cuenta_contable().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.NUMEROCARGA+"=";
		sDescripcion+=subcliente.getnumero_carga().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.LIMITECREDITO+"=";
		sDescripcion+=subcliente.getlimite_credito().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=subcliente.getdescuento().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.CODIGOCONTRATO+"=";
		sDescripcion+=subcliente.getcodigo_contrato()+",";
		sDescripcion+=SubClienteConstantesFunciones.VALORCONTRATO+"=";
		sDescripcion+=subcliente.getvalor_contrato().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=subcliente.getfecha_inicio().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=subcliente.getfecha_fin().toString()+",";
		sDescripcion+=SubClienteConstantesFunciones.PLAZO+"=";
		sDescripcion+=subcliente.getplazo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setSubClienteDescripcion(SubCliente subcliente,String sValor) throws Exception {			
		if(subcliente !=null) {
			subcliente.setnombre(sValor);//subclientesubcliente.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getTipoIdentificacionDescripcion(TipoIdentificacion tipoidentificacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoidentificacion!=null/*&&tipoidentificacion.getId()>0*/) {
			sDescripcion=TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(tipoidentificacion);
		}

		return sDescripcion;
	}

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}

	public static String getCiudadDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ciudad!=null/*&&ciudad.getId()>0*/) {
			sDescripcion=CiudadConstantesFunciones.getCiudadDescripcion(ciudad);
		}

		return sDescripcion;
	}

	public static String getZonaDescripcion(Zona zona) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(zona!=null/*&&zona.getId()>0*/) {
			sDescripcion=ZonaConstantesFunciones.getZonaDescripcion(zona);
		}

		return sDescripcion;
	}

	public static String getPaisNacionalidadDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}

	public static String getTipoGeneroDescripcion(TipoGenero tipogenero) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipogenero!=null/*&&tipogenero.getId()>0*/) {
			sDescripcion=TipoGeneroConstantesFunciones.getTipoGeneroDescripcion(tipogenero);
		}

		return sDescripcion;
	}

	public static String getEstadoCivilDescripcion(EstadoCivil estadocivil) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadocivil!=null/*&&estadocivil.getId()>0*/) {
			sDescripcion=EstadoCivilConstantesFunciones.getEstadoCivilDescripcion(estadocivil);
		}

		return sDescripcion;
	}

	public static String getEstadoLegalDescripcion(EstadoLegal estadolegal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadolegal!=null/*&&estadolegal.getId()>0*/) {
			sDescripcion=EstadoLegalConstantesFunciones.getEstadoLegalDescripcion(estadolegal);
		}

		return sDescripcion;
	}

	public static String getTipoNivelEduDescripcion(TipoNivelEdu tiponiveledu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiponiveledu!=null/*&&tiponiveledu.getId()>0*/) {
			sDescripcion=TipoNivelEduConstantesFunciones.getTipoNivelEduDescripcion(tiponiveledu);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
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
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoCivil")) {
			sNombreIndice="Tipo=  Por Estado Civil";
		} else if(sNombreIndice.equals("FK_IdEstadoLegal")) {
			sNombreIndice="Tipo=  Por Estado Legal";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdPaisNacionalidad")) {
			sNombreIndice="Tipo=  Por Pais Nacionalad";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoGenero")) {
			sNombreIndice="Tipo=  Por Tipo Genero";
		} else if(sNombreIndice.equals("FK_IdTipoIdentificacion")) {
			sNombreIndice="Tipo=  Por Tipo Identificacion";
		} else if(sNombreIndice.equals("FK_IdTipoNivelEdu")) {
			sNombreIndice="Tipo=  Por Tipo Nivel Educativo";
		} else if(sNombreIndice.equals("FK_IdZona")) {
			sNombreIndice="Tipo=  Por Zona";
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

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoCivil(Long id_estado_civil) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_civil!=null) {sDetalleIndice+=" Codigo Unico De Estado Civil="+id_estado_civil.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoLegal(Long id_estado_legal) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_legal!=null) {sDetalleIndice+=" Codigo Unico De Estado Legal="+id_estado_legal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPaisNacionalidad(Long id_pais_nacionalidad) {
		String sDetalleIndice=" Parametros->";
		if(id_pais_nacionalidad!=null) {sDetalleIndice+=" Codigo Unico De Pais Nacionalad="+id_pais_nacionalidad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoGenero(Long id_tipo_genero) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_genero!=null) {sDetalleIndice+=" Codigo Unico De Tipo Genero="+id_tipo_genero.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoIdentificacion(Long id_tipo_identificacion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_identificacion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Identificacion="+id_tipo_identificacion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoNivelEdu(Long id_tipo_nivel_edu) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_nivel_edu!=null) {sDetalleIndice+=" Codigo Unico De Tipo Nivel Educativo="+id_tipo_nivel_edu.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdZona(Long id_zona) {
		String sDetalleIndice=" Parametros->";
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSubCliente(SubCliente subcliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		subcliente.setidentificacion(subcliente.getidentificacion().trim());
		subcliente.setruc(subcliente.getruc().trim());
		subcliente.setnombre(subcliente.getnombre().trim());
		subcliente.setapellido(subcliente.getapellido().trim());
		subcliente.setnombre_completo(subcliente.getnombre_completo().trim());
		subcliente.setdireccion(subcliente.getdireccion().trim());
		subcliente.settelefono(subcliente.gettelefono().trim());
		subcliente.setnumero_celular(subcliente.getnumero_celular().trim());
		subcliente.setmail(subcliente.getmail().trim());
		subcliente.setobservacion(subcliente.getobservacion().trim());
		subcliente.setpath_imagen_firma(subcliente.getpath_imagen_firma().trim());
		subcliente.setcodigo_contrato(subcliente.getcodigo_contrato().trim());
	}
	
	public static void quitarEspaciosSubClientes(List<SubCliente> subclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SubCliente subcliente: subclientes) {
			subcliente.setidentificacion(subcliente.getidentificacion().trim());
			subcliente.setruc(subcliente.getruc().trim());
			subcliente.setnombre(subcliente.getnombre().trim());
			subcliente.setapellido(subcliente.getapellido().trim());
			subcliente.setnombre_completo(subcliente.getnombre_completo().trim());
			subcliente.setdireccion(subcliente.getdireccion().trim());
			subcliente.settelefono(subcliente.gettelefono().trim());
			subcliente.setnumero_celular(subcliente.getnumero_celular().trim());
			subcliente.setmail(subcliente.getmail().trim());
			subcliente.setobservacion(subcliente.getobservacion().trim());
			subcliente.setpath_imagen_firma(subcliente.getpath_imagen_firma().trim());
			subcliente.setcodigo_contrato(subcliente.getcodigo_contrato().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSubCliente(SubCliente subcliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && subcliente.getConCambioAuxiliar()) {
			subcliente.setIsDeleted(subcliente.getIsDeletedAuxiliar());	
			subcliente.setIsNew(subcliente.getIsNewAuxiliar());	
			subcliente.setIsChanged(subcliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			subcliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			subcliente.setIsDeletedAuxiliar(false);	
			subcliente.setIsNewAuxiliar(false);	
			subcliente.setIsChangedAuxiliar(false);
			
			subcliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSubClientes(List<SubCliente> subclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SubCliente subcliente : subclientes) {
			if(conAsignarBase && subcliente.getConCambioAuxiliar()) {
				subcliente.setIsDeleted(subcliente.getIsDeletedAuxiliar());	
				subcliente.setIsNew(subcliente.getIsNewAuxiliar());	
				subcliente.setIsChanged(subcliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				subcliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				subcliente.setIsDeletedAuxiliar(false);	
				subcliente.setIsNewAuxiliar(false);	
				subcliente.setIsChangedAuxiliar(false);
				
				subcliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSubCliente(SubCliente subcliente,Boolean conEnteros) throws Exception  {
		subcliente.setlimite_credito(0.0);
		subcliente.setdescuento(0.0);
		subcliente.setvalor_contrato(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			subcliente.setnumero_carga(0);
			subcliente.setplazo(0);
		}
	}		
	
	public static void InicializarValoresSubClientes(List<SubCliente> subclientes,Boolean conEnteros) throws Exception  {
		
		for(SubCliente subcliente: subclientes) {
			subcliente.setlimite_credito(0.0);
			subcliente.setdescuento(0.0);
			subcliente.setvalor_contrato(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				subcliente.setnumero_carga(0);
				subcliente.setplazo(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaSubCliente(List<SubCliente> subclientes,SubCliente subclienteAux) throws Exception  {
		SubClienteConstantesFunciones.InicializarValoresSubCliente(subclienteAux,true);
		
		for(SubCliente subcliente: subclientes) {
			if(subcliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			subclienteAux.setnumero_carga(subclienteAux.getnumero_carga()+subcliente.getnumero_carga());			
			subclienteAux.setlimite_credito(subclienteAux.getlimite_credito()+subcliente.getlimite_credito());			
			subclienteAux.setdescuento(subclienteAux.getdescuento()+subcliente.getdescuento());			
			subclienteAux.setvalor_contrato(subclienteAux.getvalor_contrato()+subcliente.getvalor_contrato());			
			subclienteAux.setplazo(subclienteAux.getplazo()+subcliente.getplazo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSubCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SubClienteConstantesFunciones.getArrayColumnasGlobalesSubCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSubCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SubClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SubClienteConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SubClienteConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SubClienteConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSubCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SubCliente> subclientes,SubCliente subcliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SubCliente subclienteAux: subclientes) {
			if(subclienteAux!=null && subcliente!=null) {
				if((subclienteAux.getId()==null && subcliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(subclienteAux.getId()!=null && subcliente.getId()!=null){
					if(subclienteAux.getId().equals(subcliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSubCliente(List<SubCliente> subclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double limite_creditoTotal=0.0;
		Double descuentoTotal=0.0;
		Double valor_contratoTotal=0.0;
	
		for(SubCliente subcliente: subclientes) {			
			if(subcliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			limite_creditoTotal+=subcliente.getlimite_credito();
			descuentoTotal+=subcliente.getdescuento();
			valor_contratoTotal+=subcliente.getvalor_contrato();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SubClienteConstantesFunciones.LIMITECREDITO);
		datoGeneral.setsDescripcion(SubClienteConstantesFunciones.LABEL_LIMITECREDITO);
		datoGeneral.setdValorDouble(limite_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SubClienteConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(SubClienteConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SubClienteConstantesFunciones.VALORCONTRATO);
		datoGeneral.setsDescripcion(SubClienteConstantesFunciones.LABEL_VALORCONTRATO);
		datoGeneral.setdValorDouble(valor_contratoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSubCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_ID, SubClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_VERSIONROW, SubClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_IDEMPRESA, SubClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_IDCLIENTE, SubClienteConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_IDSUCURSAL, SubClienteConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_IDTIPOIDENTIFICACION, SubClienteConstantesFunciones.IDTIPOIDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_IDENTIFICACION, SubClienteConstantesFunciones.IDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_RUC, SubClienteConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_NOMBRE, SubClienteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_APELLIDO, SubClienteConstantesFunciones.APELLIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_NOMBRECOMPLETO, SubClienteConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_DIRECCION, SubClienteConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_TELEFONO, SubClienteConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_NUMEROCELULAR, SubClienteConstantesFunciones.NUMEROCELULAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_MAIL, SubClienteConstantesFunciones.MAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_FECHANACIMIENTO, SubClienteConstantesFunciones.FECHANACIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_FECHA, SubClienteConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_OBSERVACION, SubClienteConstantesFunciones.OBSERVACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_IDPAIS, SubClienteConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_IDCIUDAD, SubClienteConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_IDZONA, SubClienteConstantesFunciones.IDZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_IDPAISNACIONALIDAD, SubClienteConstantesFunciones.IDPAISNACIONALIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_IDTIPOGENERO, SubClienteConstantesFunciones.IDTIPOGENERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_IDESTADOCIVIL, SubClienteConstantesFunciones.IDESTADOCIVIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_IDESTADOLEGAL, SubClienteConstantesFunciones.IDESTADOLEGAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_IDTIPONIVELEDU, SubClienteConstantesFunciones.IDTIPONIVELEDU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_PATHIMAGENFIRMA, SubClienteConstantesFunciones.PATHIMAGENFIRMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_IDCUENTACONTABLE, SubClienteConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_NUMEROCARGA, SubClienteConstantesFunciones.NUMEROCARGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_LIMITECREDITO, SubClienteConstantesFunciones.LIMITECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_DESCUENTO, SubClienteConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_CODIGOCONTRATO, SubClienteConstantesFunciones.CODIGOCONTRATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_VALORCONTRATO, SubClienteConstantesFunciones.VALORCONTRATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_FECHAINICIO, SubClienteConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_FECHAFIN, SubClienteConstantesFunciones.FECHAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubClienteConstantesFunciones.LABEL_PLAZO, SubClienteConstantesFunciones.PLAZO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSubCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.IDTIPOIDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.IDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.APELLIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.NUMEROCELULAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.MAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.FECHANACIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.OBSERVACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.IDZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.IDPAISNACIONALIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.IDTIPOGENERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.IDESTADOCIVIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.IDESTADOLEGAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.IDTIPONIVELEDU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.PATHIMAGENFIRMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.NUMEROCARGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.LIMITECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.CODIGOCONTRATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.VALORCONTRATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.FECHAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubClienteConstantesFunciones.PLAZO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSubCliente() throws Exception  {
		return SubClienteConstantesFunciones.getTiposSeleccionarSubCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSubCliente(Boolean conFk) throws Exception  {
		return SubClienteConstantesFunciones.getTiposSeleccionarSubCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSubCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_IDENTIFICACION);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_IDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_APELLIDO);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_APELLIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_NUMEROCELULAR);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_NUMEROCELULAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_MAIL);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_MAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_FECHANACIMIENTO);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_FECHANACIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_OBSERVACION);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_OBSERVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_IDZONA);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_IDZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_IDPAISNACIONALIDAD);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_IDPAISNACIONALIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_IDTIPOGENERO);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_IDTIPOGENERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_IDESTADOCIVIL);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_IDESTADOCIVIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_IDESTADOLEGAL);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_IDESTADOLEGAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_IDTIPONIVELEDU);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_IDTIPONIVELEDU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_PATHIMAGENFIRMA);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_PATHIMAGENFIRMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_NUMEROCARGA);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_NUMEROCARGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_LIMITECREDITO);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_LIMITECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_CODIGOCONTRATO);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_CODIGOCONTRATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_VALORCONTRATO);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_VALORCONTRATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubClienteConstantesFunciones.LABEL_PLAZO);
			reporte.setsDescripcion(SubClienteConstantesFunciones.LABEL_PLAZO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSubCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSubCliente(SubCliente subclienteAux) throws Exception {
		
			subclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(subclienteAux.getEmpresa()));
			subclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(subclienteAux.getCliente()));
			subclienteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(subclienteAux.getSucursal()));
			subclienteAux.settipoidentificacion_descripcion(TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(subclienteAux.getTipoIdentificacion()));
			subclienteAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(subclienteAux.getPais()));
			subclienteAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(subclienteAux.getCiudad()));
			subclienteAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(subclienteAux.getZona()));
			subclienteAux.setpaisnacionalidad_descripcion(PaisConstantesFunciones.getPaisDescripcion(subclienteAux.getPaisNacionalidad()));
			subclienteAux.settipogenero_descripcion(TipoGeneroConstantesFunciones.getTipoGeneroDescripcion(subclienteAux.getTipoGenero()));
			subclienteAux.setestadocivil_descripcion(EstadoCivilConstantesFunciones.getEstadoCivilDescripcion(subclienteAux.getEstadoCivil()));
			subclienteAux.setestadolegal_descripcion(EstadoLegalConstantesFunciones.getEstadoLegalDescripcion(subclienteAux.getEstadoLegal()));
			subclienteAux.settiponiveledu_descripcion(TipoNivelEduConstantesFunciones.getTipoNivelEduDescripcion(subclienteAux.getTipoNivelEdu()));
			subclienteAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(subclienteAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSubCliente(List<SubCliente> subclientesTemp) throws Exception {
		for(SubCliente subclienteAux:subclientesTemp) {
			
			subclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(subclienteAux.getEmpresa()));
			subclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(subclienteAux.getCliente()));
			subclienteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(subclienteAux.getSucursal()));
			subclienteAux.settipoidentificacion_descripcion(TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(subclienteAux.getTipoIdentificacion()));
			subclienteAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(subclienteAux.getPais()));
			subclienteAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(subclienteAux.getCiudad()));
			subclienteAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(subclienteAux.getZona()));
			subclienteAux.setpaisnacionalidad_descripcion(PaisConstantesFunciones.getPaisDescripcion(subclienteAux.getPaisNacionalidad()));
			subclienteAux.settipogenero_descripcion(TipoGeneroConstantesFunciones.getTipoGeneroDescripcion(subclienteAux.getTipoGenero()));
			subclienteAux.setestadocivil_descripcion(EstadoCivilConstantesFunciones.getEstadoCivilDescripcion(subclienteAux.getEstadoCivil()));
			subclienteAux.setestadolegal_descripcion(EstadoLegalConstantesFunciones.getEstadoLegalDescripcion(subclienteAux.getEstadoLegal()));
			subclienteAux.settiponiveledu_descripcion(TipoNivelEduConstantesFunciones.getTipoNivelEduDescripcion(subclienteAux.getTipoNivelEdu()));
			subclienteAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(subclienteAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSubCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TipoIdentificacion.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(Zona.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(TipoGenero.class));
				classes.add(new Classe(EstadoCivil.class));
				classes.add(new Classe(EstadoLegal.class));
				classes.add(new Classe(TipoNivelEdu.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoIdentificacion.class)) {
						classes.add(new Classe(TipoIdentificacion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Zona.class)) {
						classes.add(new Classe(Zona.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoGenero.class)) {
						classes.add(new Classe(TipoGenero.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoCivil.class)) {
						classes.add(new Classe(EstadoCivil.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoLegal.class)) {
						classes.add(new Classe(EstadoLegal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoNivelEdu.class)) {
						classes.add(new Classe(TipoNivelEdu.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSubCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(TipoIdentificacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIdentificacion.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(TipoGenero.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGenero.class)); continue;
					}

					if(EstadoCivil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoCivil.class)); continue;
					}

					if(EstadoLegal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoLegal.class)); continue;
					}

					if(TipoNivelEdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoNivelEdu.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(TipoIdentificacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIdentificacion.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(TipoGenero.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGenero.class)); continue;
					}

					if(EstadoCivil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoCivil.class)); continue;
					}

					if(EstadoLegal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoLegal.class)); continue;
					}

					if(TipoNivelEdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoNivelEdu.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSubCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SubClienteConstantesFunciones.getClassesRelationshipsOfSubCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSubCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(Consignacion.class));
				classes.add(new Classe(GuiaRemision.class));
				classes.add(new Classe(Proforma.class));
				classes.add(new Classe(PedidoExpor.class));
				classes.add(new Classe(Pedido.class));
				
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
					if(clas.clas.equals(GuiaRemision.class)) {
						classes.add(new Classe(GuiaRemision.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Proforma.class)) {
						classes.add(new Classe(Proforma.class)); break;
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSubCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SubClienteConstantesFunciones.getClassesRelationshipsFromStringsOfSubCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSubCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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

					if(GuiaRemision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GuiaRemision.class)); continue;
					}

					if(Proforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Proforma.class)); continue;
					}

					if(PedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoExpor.class)); continue;
					}

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
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

					if(GuiaRemision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GuiaRemision.class)); continue;
					}

					if(Proforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Proforma.class)); continue;
					}

					if(PedidoExpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoExpor.class)); continue;
					}

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
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
	public static void actualizarLista(SubCliente subcliente,List<SubCliente> subclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			SubCliente subclienteEncontrado=null;
			
			for(SubCliente subclienteLocal:subclientes) {
				if(subclienteLocal.getId().equals(subcliente.getId())) {
					subclienteEncontrado=subclienteLocal;
					
					subclienteLocal.setIsChanged(subcliente.getIsChanged());
					subclienteLocal.setIsNew(subcliente.getIsNew());
					subclienteLocal.setIsDeleted(subcliente.getIsDeleted());
					
					subclienteLocal.setGeneralEntityOriginal(subcliente.getGeneralEntityOriginal());
					
					subclienteLocal.setId(subcliente.getId());	
					subclienteLocal.setVersionRow(subcliente.getVersionRow());	
					subclienteLocal.setid_empresa(subcliente.getid_empresa());	
					subclienteLocal.setid_cliente(subcliente.getid_cliente());	
					subclienteLocal.setid_sucursal(subcliente.getid_sucursal());	
					subclienteLocal.setid_tipo_identificacion(subcliente.getid_tipo_identificacion());	
					subclienteLocal.setidentificacion(subcliente.getidentificacion());	
					subclienteLocal.setruc(subcliente.getruc());	
					subclienteLocal.setnombre(subcliente.getnombre());	
					subclienteLocal.setapellido(subcliente.getapellido());	
					subclienteLocal.setnombre_completo(subcliente.getnombre_completo());	
					subclienteLocal.setdireccion(subcliente.getdireccion());	
					subclienteLocal.settelefono(subcliente.gettelefono());	
					subclienteLocal.setnumero_celular(subcliente.getnumero_celular());	
					subclienteLocal.setmail(subcliente.getmail());	
					subclienteLocal.setfecha_nacimiento(subcliente.getfecha_nacimiento());	
					subclienteLocal.setfechao(subcliente.getfechao());	
					subclienteLocal.setobservacion(subcliente.getobservacion());	
					subclienteLocal.setid_pais(subcliente.getid_pais());	
					subclienteLocal.setid_ciudad(subcliente.getid_ciudad());	
					subclienteLocal.setid_zona(subcliente.getid_zona());	
					subclienteLocal.setid_pais_nacionalidad(subcliente.getid_pais_nacionalidad());	
					subclienteLocal.setid_tipo_genero(subcliente.getid_tipo_genero());	
					subclienteLocal.setid_estado_civil(subcliente.getid_estado_civil());	
					subclienteLocal.setid_estado_legal(subcliente.getid_estado_legal());	
					subclienteLocal.setid_tipo_nivel_edu(subcliente.getid_tipo_nivel_edu());	
					subclienteLocal.setpath_imagen_firma(subcliente.getpath_imagen_firma());	
					subclienteLocal.setid_cuenta_contable(subcliente.getid_cuenta_contable());	
					subclienteLocal.setnumero_carga(subcliente.getnumero_carga());	
					subclienteLocal.setlimite_credito(subcliente.getlimite_credito());	
					subclienteLocal.setdescuento(subcliente.getdescuento());	
					subclienteLocal.setcodigo_contrato(subcliente.getcodigo_contrato());	
					subclienteLocal.setvalor_contrato(subcliente.getvalor_contrato());	
					subclienteLocal.setfecha_inicio(subcliente.getfecha_inicio());	
					subclienteLocal.setfecha_fin(subcliente.getfecha_fin());	
					subclienteLocal.setplazo(subcliente.getplazo());	
					
					
					subclienteLocal.setFacturas(subcliente.getFacturas());
					subclienteLocal.setConsignacions(subcliente.getConsignacions());
					subclienteLocal.setGuiaRemisions(subcliente.getGuiaRemisions());
					subclienteLocal.setProformas(subcliente.getProformas());
					subclienteLocal.setPedidoExpors(subcliente.getPedidoExpors());
					subclienteLocal.setPedidos(subcliente.getPedidos());
					
					existe=true;
					break;
				}
			}
			
			if(!subcliente.getIsDeleted()) {
				if(!existe) {
					subclientes.add(subcliente);
				}
			} else {
				if(subclienteEncontrado!=null && permiteQuitar)  {
					subclientes.remove(subclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(SubCliente subcliente,List<SubCliente> subclientes) throws Exception {
		try	{			
			for(SubCliente subclienteLocal:subclientes) {
				if(subclienteLocal.getId().equals(subcliente.getId())) {
					subclienteLocal.setIsSelected(subcliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSubCliente(List<SubCliente> subclientesAux) throws Exception {
		//this.subclientesAux=subclientesAux;
		
		for(SubCliente subclienteAux:subclientesAux) {
			if(subclienteAux.getIsChanged()) {
				subclienteAux.setIsChanged(false);
			}		
			
			if(subclienteAux.getIsNew()) {
				subclienteAux.setIsNew(false);
			}	
			
			if(subclienteAux.getIsDeleted()) {
				subclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSubCliente(SubCliente subclienteAux) throws Exception {
		//this.subclienteAux=subclienteAux;
		
			if(subclienteAux.getIsChanged()) {
				subclienteAux.setIsChanged(false);
			}		
			
			if(subclienteAux.getIsNew()) {
				subclienteAux.setIsNew(false);
			}	
			
			if(subclienteAux.getIsDeleted()) {
				subclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SubCliente subclienteAsignar,SubCliente subcliente) throws Exception {
		subclienteAsignar.setId(subcliente.getId());	
		subclienteAsignar.setVersionRow(subcliente.getVersionRow());	
		subclienteAsignar.setid_empresa(subcliente.getid_empresa());
		subclienteAsignar.setempresa_descripcion(subcliente.getempresa_descripcion());	
		subclienteAsignar.setid_cliente(subcliente.getid_cliente());
		subclienteAsignar.setcliente_descripcion(subcliente.getcliente_descripcion());	
		subclienteAsignar.setid_sucursal(subcliente.getid_sucursal());
		subclienteAsignar.setsucursal_descripcion(subcliente.getsucursal_descripcion());	
		subclienteAsignar.setid_tipo_identificacion(subcliente.getid_tipo_identificacion());
		subclienteAsignar.settipoidentificacion_descripcion(subcliente.gettipoidentificacion_descripcion());	
		subclienteAsignar.setidentificacion(subcliente.getidentificacion());	
		subclienteAsignar.setruc(subcliente.getruc());	
		subclienteAsignar.setnombre(subcliente.getnombre());	
		subclienteAsignar.setapellido(subcliente.getapellido());	
		subclienteAsignar.setnombre_completo(subcliente.getnombre_completo());	
		subclienteAsignar.setdireccion(subcliente.getdireccion());	
		subclienteAsignar.settelefono(subcliente.gettelefono());	
		subclienteAsignar.setnumero_celular(subcliente.getnumero_celular());	
		subclienteAsignar.setmail(subcliente.getmail());	
		subclienteAsignar.setfecha_nacimiento(subcliente.getfecha_nacimiento());	
		subclienteAsignar.setfechao(subcliente.getfechao());	
		subclienteAsignar.setobservacion(subcliente.getobservacion());	
		subclienteAsignar.setid_pais(subcliente.getid_pais());
		subclienteAsignar.setpais_descripcion(subcliente.getpais_descripcion());	
		subclienteAsignar.setid_ciudad(subcliente.getid_ciudad());
		subclienteAsignar.setciudad_descripcion(subcliente.getciudad_descripcion());	
		subclienteAsignar.setid_zona(subcliente.getid_zona());
		subclienteAsignar.setzona_descripcion(subcliente.getzona_descripcion());	
		subclienteAsignar.setid_pais_nacionalidad(subcliente.getid_pais_nacionalidad());
		subclienteAsignar.setpaisnacionalidad_descripcion(subcliente.getpaisnacionalidad_descripcion());	
		subclienteAsignar.setid_tipo_genero(subcliente.getid_tipo_genero());
		subclienteAsignar.settipogenero_descripcion(subcliente.gettipogenero_descripcion());	
		subclienteAsignar.setid_estado_civil(subcliente.getid_estado_civil());
		subclienteAsignar.setestadocivil_descripcion(subcliente.getestadocivil_descripcion());	
		subclienteAsignar.setid_estado_legal(subcliente.getid_estado_legal());
		subclienteAsignar.setestadolegal_descripcion(subcliente.getestadolegal_descripcion());	
		subclienteAsignar.setid_tipo_nivel_edu(subcliente.getid_tipo_nivel_edu());
		subclienteAsignar.settiponiveledu_descripcion(subcliente.gettiponiveledu_descripcion());	
		subclienteAsignar.setpath_imagen_firma(subcliente.getpath_imagen_firma());	
		subclienteAsignar.setid_cuenta_contable(subcliente.getid_cuenta_contable());
		subclienteAsignar.setcuentacontable_descripcion(subcliente.getcuentacontable_descripcion());	
		subclienteAsignar.setnumero_carga(subcliente.getnumero_carga());	
		subclienteAsignar.setlimite_credito(subcliente.getlimite_credito());	
		subclienteAsignar.setdescuento(subcliente.getdescuento());	
		subclienteAsignar.setcodigo_contrato(subcliente.getcodigo_contrato());	
		subclienteAsignar.setvalor_contrato(subcliente.getvalor_contrato());	
		subclienteAsignar.setfecha_inicio(subcliente.getfecha_inicio());	
		subclienteAsignar.setfecha_fin(subcliente.getfecha_fin());	
		subclienteAsignar.setplazo(subcliente.getplazo());	
	}
	
	public static void inicializarSubCliente(SubCliente subcliente) throws Exception {
		try {
				subcliente.setId(0L);	
					
				subcliente.setid_empresa(-1L);	
				subcliente.setid_cliente(-1L);	
				subcliente.setid_sucursal(-1L);	
				subcliente.setid_tipo_identificacion(-1L);	
				subcliente.setidentificacion("");	
				subcliente.setruc("");	
				subcliente.setnombre("");	
				subcliente.setapellido("");	
				subcliente.setnombre_completo("");	
				subcliente.setdireccion("");	
				subcliente.settelefono("");	
				subcliente.setnumero_celular("");	
				subcliente.setmail("");	
				subcliente.setfecha_nacimiento(new Date());	
				subcliente.setfechao(new Date());	
				subcliente.setobservacion("");	
				subcliente.setid_pais(-1L);	
				subcliente.setid_ciudad(-1L);	
				subcliente.setid_zona(-1L);	
				subcliente.setid_pais_nacionalidad(-1L);	
				subcliente.setid_tipo_genero(-1L);	
				subcliente.setid_estado_civil(-1L);	
				subcliente.setid_estado_legal(-1L);	
				subcliente.setid_tipo_nivel_edu(-1L);	
				subcliente.setpath_imagen_firma("");	
				subcliente.setid_cuenta_contable(-1L);	
				subcliente.setnumero_carga(0);	
				subcliente.setlimite_credito(0.0);	
				subcliente.setdescuento(0.0);	
				subcliente.setcodigo_contrato("");	
				subcliente.setvalor_contrato(0.0);	
				subcliente.setfecha_inicio(new Date());	
				subcliente.setfecha_fin(new Date());	
				subcliente.setplazo(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSubCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_IDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_APELLIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_NUMEROCELULAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_MAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_FECHANACIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_OBSERVACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_IDZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_IDPAISNACIONALIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_IDTIPOGENERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_IDESTADOCIVIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_IDESTADOLEGAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_IDTIPONIVELEDU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_PATHIMAGENFIRMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_NUMEROCARGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_LIMITECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_CODIGOCONTRATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_VALORCONTRATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubClienteConstantesFunciones.LABEL_PLAZO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSubCliente(String sTipo,Row row,Workbook workbook,SubCliente subcliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.gettipoidentificacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getidentificacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getapellido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getnumero_celular());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getmail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getfecha_nacimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getfechao());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getobservacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getzona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getpaisnacionalidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.gettipogenero_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getestadocivil_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getestadolegal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.gettiponiveledu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getpath_imagen_firma());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getnumero_carga());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getlimite_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getcodigo_contrato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getvalor_contrato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subcliente.getplazo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySubCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySubCliente() {
		return this.sFinalQuerySubCliente;
	}
	
	public void setsFinalQuerySubCliente(String sFinalQuerySubCliente) {
		this.sFinalQuerySubCliente= sFinalQuerySubCliente;
	}
	
	public Border resaltarSeleccionarSubCliente=null;
	
	public Border setResaltarSeleccionarSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSubCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSubCliente() {
		return this.resaltarSeleccionarSubCliente;
	}
	
	public void setResaltarSeleccionarSubCliente(Border borderResaltarSeleccionarSubCliente) {
		this.resaltarSeleccionarSubCliente= borderResaltarSeleccionarSubCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSubCliente=null;
	public Boolean mostraridSubCliente=true;
	public Boolean activaridSubCliente=true;

	public Border resaltarid_empresaSubCliente=null;
	public Boolean mostrarid_empresaSubCliente=true;
	public Boolean activarid_empresaSubCliente=true;
	public Boolean cargarid_empresaSubCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSubCliente=false;//ConEventDepend=true

	public Border resaltarid_clienteSubCliente=null;
	public Boolean mostrarid_clienteSubCliente=true;
	public Boolean activarid_clienteSubCliente=true;
	public Boolean cargarid_clienteSubCliente=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteSubCliente=false;//ConEventDepend=true

	public Border resaltarid_sucursalSubCliente=null;
	public Boolean mostrarid_sucursalSubCliente=true;
	public Boolean activarid_sucursalSubCliente=true;
	public Boolean cargarid_sucursalSubCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalSubCliente=false;//ConEventDepend=true

	public Border resaltarid_tipo_identificacionSubCliente=null;
	public Boolean mostrarid_tipo_identificacionSubCliente=true;
	public Boolean activarid_tipo_identificacionSubCliente=true;
	public Boolean cargarid_tipo_identificacionSubCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_identificacionSubCliente=false;//ConEventDepend=true

	public Border resaltaridentificacionSubCliente=null;
	public Boolean mostraridentificacionSubCliente=true;
	public Boolean activaridentificacionSubCliente=true;

	public Border resaltarrucSubCliente=null;
	public Boolean mostrarrucSubCliente=true;
	public Boolean activarrucSubCliente=true;

	public Border resaltarnombreSubCliente=null;
	public Boolean mostrarnombreSubCliente=true;
	public Boolean activarnombreSubCliente=true;

	public Border resaltarapellidoSubCliente=null;
	public Boolean mostrarapellidoSubCliente=true;
	public Boolean activarapellidoSubCliente=true;

	public Border resaltarnombre_completoSubCliente=null;
	public Boolean mostrarnombre_completoSubCliente=true;
	public Boolean activarnombre_completoSubCliente=false;

	public Border resaltardireccionSubCliente=null;
	public Boolean mostrardireccionSubCliente=true;
	public Boolean activardireccionSubCliente=true;

	public Border resaltartelefonoSubCliente=null;
	public Boolean mostrartelefonoSubCliente=true;
	public Boolean activartelefonoSubCliente=true;

	public Border resaltarnumero_celularSubCliente=null;
	public Boolean mostrarnumero_celularSubCliente=true;
	public Boolean activarnumero_celularSubCliente=true;

	public Border resaltarmailSubCliente=null;
	public Boolean mostrarmailSubCliente=true;
	public Boolean activarmailSubCliente=true;

	public Border resaltarfecha_nacimientoSubCliente=null;
	public Boolean mostrarfecha_nacimientoSubCliente=true;
	public Boolean activarfecha_nacimientoSubCliente=true;

	public Border resaltarfechaoSubCliente=null;
	public Boolean mostrarfechaoSubCliente=true;
	public Boolean activarfechaoSubCliente=false;

	public Border resaltarobservacionSubCliente=null;
	public Boolean mostrarobservacionSubCliente=true;
	public Boolean activarobservacionSubCliente=true;

	public Border resaltarid_paisSubCliente=null;
	public Boolean mostrarid_paisSubCliente=true;
	public Boolean activarid_paisSubCliente=true;
	public Boolean cargarid_paisSubCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisSubCliente=false;//ConEventDepend=true

	public Border resaltarid_ciudadSubCliente=null;
	public Boolean mostrarid_ciudadSubCliente=true;
	public Boolean activarid_ciudadSubCliente=true;
	public Boolean cargarid_ciudadSubCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadSubCliente=true;//ConEventDepend=true

	public Border resaltarid_zonaSubCliente=null;
	public Boolean mostrarid_zonaSubCliente=true;
	public Boolean activarid_zonaSubCliente=true;
	public Boolean cargarid_zonaSubCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_zonaSubCliente=false;//ConEventDepend=true

	public Border resaltarid_pais_nacionalidadSubCliente=null;
	public Boolean mostrarid_pais_nacionalidadSubCliente=true;
	public Boolean activarid_pais_nacionalidadSubCliente=true;
	public Boolean cargarid_pais_nacionalidadSubCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_pais_nacionalidadSubCliente=false;//ConEventDepend=true

	public Border resaltarid_tipo_generoSubCliente=null;
	public Boolean mostrarid_tipo_generoSubCliente=true;
	public Boolean activarid_tipo_generoSubCliente=true;
	public Boolean cargarid_tipo_generoSubCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_generoSubCliente=false;//ConEventDepend=true

	public Border resaltarid_estado_civilSubCliente=null;
	public Boolean mostrarid_estado_civilSubCliente=true;
	public Boolean activarid_estado_civilSubCliente=true;
	public Boolean cargarid_estado_civilSubCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_civilSubCliente=false;//ConEventDepend=true

	public Border resaltarid_estado_legalSubCliente=null;
	public Boolean mostrarid_estado_legalSubCliente=true;
	public Boolean activarid_estado_legalSubCliente=true;
	public Boolean cargarid_estado_legalSubCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_legalSubCliente=false;//ConEventDepend=true

	public Border resaltarid_tipo_nivel_eduSubCliente=null;
	public Boolean mostrarid_tipo_nivel_eduSubCliente=true;
	public Boolean activarid_tipo_nivel_eduSubCliente=true;
	public Boolean cargarid_tipo_nivel_eduSubCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_nivel_eduSubCliente=false;//ConEventDepend=true

	public Border resaltarpath_imagen_firmaSubCliente=null;
	public Boolean mostrarpath_imagen_firmaSubCliente=true;
	public Boolean activarpath_imagen_firmaSubCliente=true;

	public Border resaltarid_cuenta_contableSubCliente=null;
	public Boolean mostrarid_cuenta_contableSubCliente=true;
	public Boolean activarid_cuenta_contableSubCliente=true;
	public Boolean cargarid_cuenta_contableSubCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableSubCliente=false;//ConEventDepend=true

	public Border resaltarnumero_cargaSubCliente=null;
	public Boolean mostrarnumero_cargaSubCliente=true;
	public Boolean activarnumero_cargaSubCliente=true;

	public Border resaltarlimite_creditoSubCliente=null;
	public Boolean mostrarlimite_creditoSubCliente=true;
	public Boolean activarlimite_creditoSubCliente=true;

	public Border resaltardescuentoSubCliente=null;
	public Boolean mostrardescuentoSubCliente=true;
	public Boolean activardescuentoSubCliente=true;

	public Border resaltarcodigo_contratoSubCliente=null;
	public Boolean mostrarcodigo_contratoSubCliente=true;
	public Boolean activarcodigo_contratoSubCliente=true;

	public Border resaltarvalor_contratoSubCliente=null;
	public Boolean mostrarvalor_contratoSubCliente=true;
	public Boolean activarvalor_contratoSubCliente=true;

	public Border resaltarfecha_inicioSubCliente=null;
	public Boolean mostrarfecha_inicioSubCliente=true;
	public Boolean activarfecha_inicioSubCliente=true;

	public Border resaltarfecha_finSubCliente=null;
	public Boolean mostrarfecha_finSubCliente=true;
	public Boolean activarfecha_finSubCliente=true;

	public Border resaltarplazoSubCliente=null;
	public Boolean mostrarplazoSubCliente=true;
	public Boolean activarplazoSubCliente=true;

	
	

	public Border setResaltaridSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltaridSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSubCliente() {
		return this.resaltaridSubCliente;
	}

	public void setResaltaridSubCliente(Border borderResaltar) {
		this.resaltaridSubCliente= borderResaltar;
	}

	public Boolean getMostraridSubCliente() {
		return this.mostraridSubCliente;
	}

	public void setMostraridSubCliente(Boolean mostraridSubCliente) {
		this.mostraridSubCliente= mostraridSubCliente;
	}

	public Boolean getActivaridSubCliente() {
		return this.activaridSubCliente;
	}

	public void setActivaridSubCliente(Boolean activaridSubCliente) {
		this.activaridSubCliente= activaridSubCliente;
	}

	public Border setResaltarid_empresaSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSubCliente() {
		return this.resaltarid_empresaSubCliente;
	}

	public void setResaltarid_empresaSubCliente(Border borderResaltar) {
		this.resaltarid_empresaSubCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaSubCliente() {
		return this.mostrarid_empresaSubCliente;
	}

	public void setMostrarid_empresaSubCliente(Boolean mostrarid_empresaSubCliente) {
		this.mostrarid_empresaSubCliente= mostrarid_empresaSubCliente;
	}

	public Boolean getActivarid_empresaSubCliente() {
		return this.activarid_empresaSubCliente;
	}

	public void setActivarid_empresaSubCliente(Boolean activarid_empresaSubCliente) {
		this.activarid_empresaSubCliente= activarid_empresaSubCliente;
	}

	public Boolean getCargarid_empresaSubCliente() {
		return this.cargarid_empresaSubCliente;
	}

	public void setCargarid_empresaSubCliente(Boolean cargarid_empresaSubCliente) {
		this.cargarid_empresaSubCliente= cargarid_empresaSubCliente;
	}

	public Border setResaltarid_clienteSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarid_clienteSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteSubCliente() {
		return this.resaltarid_clienteSubCliente;
	}

	public void setResaltarid_clienteSubCliente(Border borderResaltar) {
		this.resaltarid_clienteSubCliente= borderResaltar;
	}

	public Boolean getMostrarid_clienteSubCliente() {
		return this.mostrarid_clienteSubCliente;
	}

	public void setMostrarid_clienteSubCliente(Boolean mostrarid_clienteSubCliente) {
		this.mostrarid_clienteSubCliente= mostrarid_clienteSubCliente;
	}

	public Boolean getActivarid_clienteSubCliente() {
		return this.activarid_clienteSubCliente;
	}

	public void setActivarid_clienteSubCliente(Boolean activarid_clienteSubCliente) {
		this.activarid_clienteSubCliente= activarid_clienteSubCliente;
	}

	public Boolean getCargarid_clienteSubCliente() {
		return this.cargarid_clienteSubCliente;
	}

	public void setCargarid_clienteSubCliente(Boolean cargarid_clienteSubCliente) {
		this.cargarid_clienteSubCliente= cargarid_clienteSubCliente;
	}

	public Border setResaltarid_sucursalSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarid_sucursalSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalSubCliente() {
		return this.resaltarid_sucursalSubCliente;
	}

	public void setResaltarid_sucursalSubCliente(Border borderResaltar) {
		this.resaltarid_sucursalSubCliente= borderResaltar;
	}

	public Boolean getMostrarid_sucursalSubCliente() {
		return this.mostrarid_sucursalSubCliente;
	}

	public void setMostrarid_sucursalSubCliente(Boolean mostrarid_sucursalSubCliente) {
		this.mostrarid_sucursalSubCliente= mostrarid_sucursalSubCliente;
	}

	public Boolean getActivarid_sucursalSubCliente() {
		return this.activarid_sucursalSubCliente;
	}

	public void setActivarid_sucursalSubCliente(Boolean activarid_sucursalSubCliente) {
		this.activarid_sucursalSubCliente= activarid_sucursalSubCliente;
	}

	public Boolean getCargarid_sucursalSubCliente() {
		return this.cargarid_sucursalSubCliente;
	}

	public void setCargarid_sucursalSubCliente(Boolean cargarid_sucursalSubCliente) {
		this.cargarid_sucursalSubCliente= cargarid_sucursalSubCliente;
	}

	public Border setResaltarid_tipo_identificacionSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_identificacionSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_identificacionSubCliente() {
		return this.resaltarid_tipo_identificacionSubCliente;
	}

	public void setResaltarid_tipo_identificacionSubCliente(Border borderResaltar) {
		this.resaltarid_tipo_identificacionSubCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_identificacionSubCliente() {
		return this.mostrarid_tipo_identificacionSubCliente;
	}

	public void setMostrarid_tipo_identificacionSubCliente(Boolean mostrarid_tipo_identificacionSubCliente) {
		this.mostrarid_tipo_identificacionSubCliente= mostrarid_tipo_identificacionSubCliente;
	}

	public Boolean getActivarid_tipo_identificacionSubCliente() {
		return this.activarid_tipo_identificacionSubCliente;
	}

	public void setActivarid_tipo_identificacionSubCliente(Boolean activarid_tipo_identificacionSubCliente) {
		this.activarid_tipo_identificacionSubCliente= activarid_tipo_identificacionSubCliente;
	}

	public Boolean getCargarid_tipo_identificacionSubCliente() {
		return this.cargarid_tipo_identificacionSubCliente;
	}

	public void setCargarid_tipo_identificacionSubCliente(Boolean cargarid_tipo_identificacionSubCliente) {
		this.cargarid_tipo_identificacionSubCliente= cargarid_tipo_identificacionSubCliente;
	}

	public Border setResaltaridentificacionSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltaridentificacionSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridentificacionSubCliente() {
		return this.resaltaridentificacionSubCliente;
	}

	public void setResaltaridentificacionSubCliente(Border borderResaltar) {
		this.resaltaridentificacionSubCliente= borderResaltar;
	}

	public Boolean getMostraridentificacionSubCliente() {
		return this.mostraridentificacionSubCliente;
	}

	public void setMostraridentificacionSubCliente(Boolean mostraridentificacionSubCliente) {
		this.mostraridentificacionSubCliente= mostraridentificacionSubCliente;
	}

	public Boolean getActivaridentificacionSubCliente() {
		return this.activaridentificacionSubCliente;
	}

	public void setActivaridentificacionSubCliente(Boolean activaridentificacionSubCliente) {
		this.activaridentificacionSubCliente= activaridentificacionSubCliente;
	}

	public Border setResaltarrucSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarrucSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucSubCliente() {
		return this.resaltarrucSubCliente;
	}

	public void setResaltarrucSubCliente(Border borderResaltar) {
		this.resaltarrucSubCliente= borderResaltar;
	}

	public Boolean getMostrarrucSubCliente() {
		return this.mostrarrucSubCliente;
	}

	public void setMostrarrucSubCliente(Boolean mostrarrucSubCliente) {
		this.mostrarrucSubCliente= mostrarrucSubCliente;
	}

	public Boolean getActivarrucSubCliente() {
		return this.activarrucSubCliente;
	}

	public void setActivarrucSubCliente(Boolean activarrucSubCliente) {
		this.activarrucSubCliente= activarrucSubCliente;
	}

	public Border setResaltarnombreSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarnombreSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreSubCliente() {
		return this.resaltarnombreSubCliente;
	}

	public void setResaltarnombreSubCliente(Border borderResaltar) {
		this.resaltarnombreSubCliente= borderResaltar;
	}

	public Boolean getMostrarnombreSubCliente() {
		return this.mostrarnombreSubCliente;
	}

	public void setMostrarnombreSubCliente(Boolean mostrarnombreSubCliente) {
		this.mostrarnombreSubCliente= mostrarnombreSubCliente;
	}

	public Boolean getActivarnombreSubCliente() {
		return this.activarnombreSubCliente;
	}

	public void setActivarnombreSubCliente(Boolean activarnombreSubCliente) {
		this.activarnombreSubCliente= activarnombreSubCliente;
	}

	public Border setResaltarapellidoSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarapellidoSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidoSubCliente() {
		return this.resaltarapellidoSubCliente;
	}

	public void setResaltarapellidoSubCliente(Border borderResaltar) {
		this.resaltarapellidoSubCliente= borderResaltar;
	}

	public Boolean getMostrarapellidoSubCliente() {
		return this.mostrarapellidoSubCliente;
	}

	public void setMostrarapellidoSubCliente(Boolean mostrarapellidoSubCliente) {
		this.mostrarapellidoSubCliente= mostrarapellidoSubCliente;
	}

	public Boolean getActivarapellidoSubCliente() {
		return this.activarapellidoSubCliente;
	}

	public void setActivarapellidoSubCliente(Boolean activarapellidoSubCliente) {
		this.activarapellidoSubCliente= activarapellidoSubCliente;
	}

	public Border setResaltarnombre_completoSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarnombre_completoSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoSubCliente() {
		return this.resaltarnombre_completoSubCliente;
	}

	public void setResaltarnombre_completoSubCliente(Border borderResaltar) {
		this.resaltarnombre_completoSubCliente= borderResaltar;
	}

	public Boolean getMostrarnombre_completoSubCliente() {
		return this.mostrarnombre_completoSubCliente;
	}

	public void setMostrarnombre_completoSubCliente(Boolean mostrarnombre_completoSubCliente) {
		this.mostrarnombre_completoSubCliente= mostrarnombre_completoSubCliente;
	}

	public Boolean getActivarnombre_completoSubCliente() {
		return this.activarnombre_completoSubCliente;
	}

	public void setActivarnombre_completoSubCliente(Boolean activarnombre_completoSubCliente) {
		this.activarnombre_completoSubCliente= activarnombre_completoSubCliente;
	}

	public Border setResaltardireccionSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltardireccionSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionSubCliente() {
		return this.resaltardireccionSubCliente;
	}

	public void setResaltardireccionSubCliente(Border borderResaltar) {
		this.resaltardireccionSubCliente= borderResaltar;
	}

	public Boolean getMostrardireccionSubCliente() {
		return this.mostrardireccionSubCliente;
	}

	public void setMostrardireccionSubCliente(Boolean mostrardireccionSubCliente) {
		this.mostrardireccionSubCliente= mostrardireccionSubCliente;
	}

	public Boolean getActivardireccionSubCliente() {
		return this.activardireccionSubCliente;
	}

	public void setActivardireccionSubCliente(Boolean activardireccionSubCliente) {
		this.activardireccionSubCliente= activardireccionSubCliente;
	}

	public Border setResaltartelefonoSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltartelefonoSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoSubCliente() {
		return this.resaltartelefonoSubCliente;
	}

	public void setResaltartelefonoSubCliente(Border borderResaltar) {
		this.resaltartelefonoSubCliente= borderResaltar;
	}

	public Boolean getMostrartelefonoSubCliente() {
		return this.mostrartelefonoSubCliente;
	}

	public void setMostrartelefonoSubCliente(Boolean mostrartelefonoSubCliente) {
		this.mostrartelefonoSubCliente= mostrartelefonoSubCliente;
	}

	public Boolean getActivartelefonoSubCliente() {
		return this.activartelefonoSubCliente;
	}

	public void setActivartelefonoSubCliente(Boolean activartelefonoSubCliente) {
		this.activartelefonoSubCliente= activartelefonoSubCliente;
	}

	public Border setResaltarnumero_celularSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarnumero_celularSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_celularSubCliente() {
		return this.resaltarnumero_celularSubCliente;
	}

	public void setResaltarnumero_celularSubCliente(Border borderResaltar) {
		this.resaltarnumero_celularSubCliente= borderResaltar;
	}

	public Boolean getMostrarnumero_celularSubCliente() {
		return this.mostrarnumero_celularSubCliente;
	}

	public void setMostrarnumero_celularSubCliente(Boolean mostrarnumero_celularSubCliente) {
		this.mostrarnumero_celularSubCliente= mostrarnumero_celularSubCliente;
	}

	public Boolean getActivarnumero_celularSubCliente() {
		return this.activarnumero_celularSubCliente;
	}

	public void setActivarnumero_celularSubCliente(Boolean activarnumero_celularSubCliente) {
		this.activarnumero_celularSubCliente= activarnumero_celularSubCliente;
	}

	public Border setResaltarmailSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarmailSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmailSubCliente() {
		return this.resaltarmailSubCliente;
	}

	public void setResaltarmailSubCliente(Border borderResaltar) {
		this.resaltarmailSubCliente= borderResaltar;
	}

	public Boolean getMostrarmailSubCliente() {
		return this.mostrarmailSubCliente;
	}

	public void setMostrarmailSubCliente(Boolean mostrarmailSubCliente) {
		this.mostrarmailSubCliente= mostrarmailSubCliente;
	}

	public Boolean getActivarmailSubCliente() {
		return this.activarmailSubCliente;
	}

	public void setActivarmailSubCliente(Boolean activarmailSubCliente) {
		this.activarmailSubCliente= activarmailSubCliente;
	}

	public Border setResaltarfecha_nacimientoSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarfecha_nacimientoSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_nacimientoSubCliente() {
		return this.resaltarfecha_nacimientoSubCliente;
	}

	public void setResaltarfecha_nacimientoSubCliente(Border borderResaltar) {
		this.resaltarfecha_nacimientoSubCliente= borderResaltar;
	}

	public Boolean getMostrarfecha_nacimientoSubCliente() {
		return this.mostrarfecha_nacimientoSubCliente;
	}

	public void setMostrarfecha_nacimientoSubCliente(Boolean mostrarfecha_nacimientoSubCliente) {
		this.mostrarfecha_nacimientoSubCliente= mostrarfecha_nacimientoSubCliente;
	}

	public Boolean getActivarfecha_nacimientoSubCliente() {
		return this.activarfecha_nacimientoSubCliente;
	}

	public void setActivarfecha_nacimientoSubCliente(Boolean activarfecha_nacimientoSubCliente) {
		this.activarfecha_nacimientoSubCliente= activarfecha_nacimientoSubCliente;
	}

	public Border setResaltarfechaoSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarfechaoSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaoSubCliente() {
		return this.resaltarfechaoSubCliente;
	}

	public void setResaltarfechaoSubCliente(Border borderResaltar) {
		this.resaltarfechaoSubCliente= borderResaltar;
	}

	public Boolean getMostrarfechaoSubCliente() {
		return this.mostrarfechaoSubCliente;
	}

	public void setMostrarfechaoSubCliente(Boolean mostrarfechaoSubCliente) {
		this.mostrarfechaoSubCliente= mostrarfechaoSubCliente;
	}

	public Boolean getActivarfechaoSubCliente() {
		return this.activarfechaoSubCliente;
	}

	public void setActivarfechaoSubCliente(Boolean activarfechaoSubCliente) {
		this.activarfechaoSubCliente= activarfechaoSubCliente;
	}

	public Border setResaltarobservacionSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarobservacionSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionSubCliente() {
		return this.resaltarobservacionSubCliente;
	}

	public void setResaltarobservacionSubCliente(Border borderResaltar) {
		this.resaltarobservacionSubCliente= borderResaltar;
	}

	public Boolean getMostrarobservacionSubCliente() {
		return this.mostrarobservacionSubCliente;
	}

	public void setMostrarobservacionSubCliente(Boolean mostrarobservacionSubCliente) {
		this.mostrarobservacionSubCliente= mostrarobservacionSubCliente;
	}

	public Boolean getActivarobservacionSubCliente() {
		return this.activarobservacionSubCliente;
	}

	public void setActivarobservacionSubCliente(Boolean activarobservacionSubCliente) {
		this.activarobservacionSubCliente= activarobservacionSubCliente;
	}

	public Border setResaltarid_paisSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarid_paisSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisSubCliente() {
		return this.resaltarid_paisSubCliente;
	}

	public void setResaltarid_paisSubCliente(Border borderResaltar) {
		this.resaltarid_paisSubCliente= borderResaltar;
	}

	public Boolean getMostrarid_paisSubCliente() {
		return this.mostrarid_paisSubCliente;
	}

	public void setMostrarid_paisSubCliente(Boolean mostrarid_paisSubCliente) {
		this.mostrarid_paisSubCliente= mostrarid_paisSubCliente;
	}

	public Boolean getActivarid_paisSubCliente() {
		return this.activarid_paisSubCliente;
	}

	public void setActivarid_paisSubCliente(Boolean activarid_paisSubCliente) {
		this.activarid_paisSubCliente= activarid_paisSubCliente;
	}

	public Boolean getCargarid_paisSubCliente() {
		return this.cargarid_paisSubCliente;
	}

	public void setCargarid_paisSubCliente(Boolean cargarid_paisSubCliente) {
		this.cargarid_paisSubCliente= cargarid_paisSubCliente;
	}

	public Border setResaltarid_ciudadSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarid_ciudadSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadSubCliente() {
		return this.resaltarid_ciudadSubCliente;
	}

	public void setResaltarid_ciudadSubCliente(Border borderResaltar) {
		this.resaltarid_ciudadSubCliente= borderResaltar;
	}

	public Boolean getMostrarid_ciudadSubCliente() {
		return this.mostrarid_ciudadSubCliente;
	}

	public void setMostrarid_ciudadSubCliente(Boolean mostrarid_ciudadSubCliente) {
		this.mostrarid_ciudadSubCliente= mostrarid_ciudadSubCliente;
	}

	public Boolean getActivarid_ciudadSubCliente() {
		return this.activarid_ciudadSubCliente;
	}

	public void setActivarid_ciudadSubCliente(Boolean activarid_ciudadSubCliente) {
		this.activarid_ciudadSubCliente= activarid_ciudadSubCliente;
	}

	public Boolean getCargarid_ciudadSubCliente() {
		return this.cargarid_ciudadSubCliente;
	}

	public void setCargarid_ciudadSubCliente(Boolean cargarid_ciudadSubCliente) {
		this.cargarid_ciudadSubCliente= cargarid_ciudadSubCliente;
	}

	public Border setResaltarid_zonaSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarid_zonaSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_zonaSubCliente() {
		return this.resaltarid_zonaSubCliente;
	}

	public void setResaltarid_zonaSubCliente(Border borderResaltar) {
		this.resaltarid_zonaSubCliente= borderResaltar;
	}

	public Boolean getMostrarid_zonaSubCliente() {
		return this.mostrarid_zonaSubCliente;
	}

	public void setMostrarid_zonaSubCliente(Boolean mostrarid_zonaSubCliente) {
		this.mostrarid_zonaSubCliente= mostrarid_zonaSubCliente;
	}

	public Boolean getActivarid_zonaSubCliente() {
		return this.activarid_zonaSubCliente;
	}

	public void setActivarid_zonaSubCliente(Boolean activarid_zonaSubCliente) {
		this.activarid_zonaSubCliente= activarid_zonaSubCliente;
	}

	public Boolean getCargarid_zonaSubCliente() {
		return this.cargarid_zonaSubCliente;
	}

	public void setCargarid_zonaSubCliente(Boolean cargarid_zonaSubCliente) {
		this.cargarid_zonaSubCliente= cargarid_zonaSubCliente;
	}

	public Border setResaltarid_pais_nacionalidadSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarid_pais_nacionalidadSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_pais_nacionalidadSubCliente() {
		return this.resaltarid_pais_nacionalidadSubCliente;
	}

	public void setResaltarid_pais_nacionalidadSubCliente(Border borderResaltar) {
		this.resaltarid_pais_nacionalidadSubCliente= borderResaltar;
	}

	public Boolean getMostrarid_pais_nacionalidadSubCliente() {
		return this.mostrarid_pais_nacionalidadSubCliente;
	}

	public void setMostrarid_pais_nacionalidadSubCliente(Boolean mostrarid_pais_nacionalidadSubCliente) {
		this.mostrarid_pais_nacionalidadSubCliente= mostrarid_pais_nacionalidadSubCliente;
	}

	public Boolean getActivarid_pais_nacionalidadSubCliente() {
		return this.activarid_pais_nacionalidadSubCliente;
	}

	public void setActivarid_pais_nacionalidadSubCliente(Boolean activarid_pais_nacionalidadSubCliente) {
		this.activarid_pais_nacionalidadSubCliente= activarid_pais_nacionalidadSubCliente;
	}

	public Boolean getCargarid_pais_nacionalidadSubCliente() {
		return this.cargarid_pais_nacionalidadSubCliente;
	}

	public void setCargarid_pais_nacionalidadSubCliente(Boolean cargarid_pais_nacionalidadSubCliente) {
		this.cargarid_pais_nacionalidadSubCliente= cargarid_pais_nacionalidadSubCliente;
	}

	public Border setResaltarid_tipo_generoSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_generoSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_generoSubCliente() {
		return this.resaltarid_tipo_generoSubCliente;
	}

	public void setResaltarid_tipo_generoSubCliente(Border borderResaltar) {
		this.resaltarid_tipo_generoSubCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_generoSubCliente() {
		return this.mostrarid_tipo_generoSubCliente;
	}

	public void setMostrarid_tipo_generoSubCliente(Boolean mostrarid_tipo_generoSubCliente) {
		this.mostrarid_tipo_generoSubCliente= mostrarid_tipo_generoSubCliente;
	}

	public Boolean getActivarid_tipo_generoSubCliente() {
		return this.activarid_tipo_generoSubCliente;
	}

	public void setActivarid_tipo_generoSubCliente(Boolean activarid_tipo_generoSubCliente) {
		this.activarid_tipo_generoSubCliente= activarid_tipo_generoSubCliente;
	}

	public Boolean getCargarid_tipo_generoSubCliente() {
		return this.cargarid_tipo_generoSubCliente;
	}

	public void setCargarid_tipo_generoSubCliente(Boolean cargarid_tipo_generoSubCliente) {
		this.cargarid_tipo_generoSubCliente= cargarid_tipo_generoSubCliente;
	}

	public Border setResaltarid_estado_civilSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarid_estado_civilSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_civilSubCliente() {
		return this.resaltarid_estado_civilSubCliente;
	}

	public void setResaltarid_estado_civilSubCliente(Border borderResaltar) {
		this.resaltarid_estado_civilSubCliente= borderResaltar;
	}

	public Boolean getMostrarid_estado_civilSubCliente() {
		return this.mostrarid_estado_civilSubCliente;
	}

	public void setMostrarid_estado_civilSubCliente(Boolean mostrarid_estado_civilSubCliente) {
		this.mostrarid_estado_civilSubCliente= mostrarid_estado_civilSubCliente;
	}

	public Boolean getActivarid_estado_civilSubCliente() {
		return this.activarid_estado_civilSubCliente;
	}

	public void setActivarid_estado_civilSubCliente(Boolean activarid_estado_civilSubCliente) {
		this.activarid_estado_civilSubCliente= activarid_estado_civilSubCliente;
	}

	public Boolean getCargarid_estado_civilSubCliente() {
		return this.cargarid_estado_civilSubCliente;
	}

	public void setCargarid_estado_civilSubCliente(Boolean cargarid_estado_civilSubCliente) {
		this.cargarid_estado_civilSubCliente= cargarid_estado_civilSubCliente;
	}

	public Border setResaltarid_estado_legalSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarid_estado_legalSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_legalSubCliente() {
		return this.resaltarid_estado_legalSubCliente;
	}

	public void setResaltarid_estado_legalSubCliente(Border borderResaltar) {
		this.resaltarid_estado_legalSubCliente= borderResaltar;
	}

	public Boolean getMostrarid_estado_legalSubCliente() {
		return this.mostrarid_estado_legalSubCliente;
	}

	public void setMostrarid_estado_legalSubCliente(Boolean mostrarid_estado_legalSubCliente) {
		this.mostrarid_estado_legalSubCliente= mostrarid_estado_legalSubCliente;
	}

	public Boolean getActivarid_estado_legalSubCliente() {
		return this.activarid_estado_legalSubCliente;
	}

	public void setActivarid_estado_legalSubCliente(Boolean activarid_estado_legalSubCliente) {
		this.activarid_estado_legalSubCliente= activarid_estado_legalSubCliente;
	}

	public Boolean getCargarid_estado_legalSubCliente() {
		return this.cargarid_estado_legalSubCliente;
	}

	public void setCargarid_estado_legalSubCliente(Boolean cargarid_estado_legalSubCliente) {
		this.cargarid_estado_legalSubCliente= cargarid_estado_legalSubCliente;
	}

	public Border setResaltarid_tipo_nivel_eduSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_nivel_eduSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_nivel_eduSubCliente() {
		return this.resaltarid_tipo_nivel_eduSubCliente;
	}

	public void setResaltarid_tipo_nivel_eduSubCliente(Border borderResaltar) {
		this.resaltarid_tipo_nivel_eduSubCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_nivel_eduSubCliente() {
		return this.mostrarid_tipo_nivel_eduSubCliente;
	}

	public void setMostrarid_tipo_nivel_eduSubCliente(Boolean mostrarid_tipo_nivel_eduSubCliente) {
		this.mostrarid_tipo_nivel_eduSubCliente= mostrarid_tipo_nivel_eduSubCliente;
	}

	public Boolean getActivarid_tipo_nivel_eduSubCliente() {
		return this.activarid_tipo_nivel_eduSubCliente;
	}

	public void setActivarid_tipo_nivel_eduSubCliente(Boolean activarid_tipo_nivel_eduSubCliente) {
		this.activarid_tipo_nivel_eduSubCliente= activarid_tipo_nivel_eduSubCliente;
	}

	public Boolean getCargarid_tipo_nivel_eduSubCliente() {
		return this.cargarid_tipo_nivel_eduSubCliente;
	}

	public void setCargarid_tipo_nivel_eduSubCliente(Boolean cargarid_tipo_nivel_eduSubCliente) {
		this.cargarid_tipo_nivel_eduSubCliente= cargarid_tipo_nivel_eduSubCliente;
	}

	public Border setResaltarpath_imagen_firmaSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarpath_imagen_firmaSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpath_imagen_firmaSubCliente() {
		return this.resaltarpath_imagen_firmaSubCliente;
	}

	public void setResaltarpath_imagen_firmaSubCliente(Border borderResaltar) {
		this.resaltarpath_imagen_firmaSubCliente= borderResaltar;
	}

	public Boolean getMostrarpath_imagen_firmaSubCliente() {
		return this.mostrarpath_imagen_firmaSubCliente;
	}

	public void setMostrarpath_imagen_firmaSubCliente(Boolean mostrarpath_imagen_firmaSubCliente) {
		this.mostrarpath_imagen_firmaSubCliente= mostrarpath_imagen_firmaSubCliente;
	}

	public Boolean getActivarpath_imagen_firmaSubCliente() {
		return this.activarpath_imagen_firmaSubCliente;
	}

	public void setActivarpath_imagen_firmaSubCliente(Boolean activarpath_imagen_firmaSubCliente) {
		this.activarpath_imagen_firmaSubCliente= activarpath_imagen_firmaSubCliente;
	}

	public Border setResaltarid_cuenta_contableSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableSubCliente() {
		return this.resaltarid_cuenta_contableSubCliente;
	}

	public void setResaltarid_cuenta_contableSubCliente(Border borderResaltar) {
		this.resaltarid_cuenta_contableSubCliente= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableSubCliente() {
		return this.mostrarid_cuenta_contableSubCliente;
	}

	public void setMostrarid_cuenta_contableSubCliente(Boolean mostrarid_cuenta_contableSubCliente) {
		this.mostrarid_cuenta_contableSubCliente= mostrarid_cuenta_contableSubCliente;
	}

	public Boolean getActivarid_cuenta_contableSubCliente() {
		return this.activarid_cuenta_contableSubCliente;
	}

	public void setActivarid_cuenta_contableSubCliente(Boolean activarid_cuenta_contableSubCliente) {
		this.activarid_cuenta_contableSubCliente= activarid_cuenta_contableSubCliente;
	}

	public Boolean getCargarid_cuenta_contableSubCliente() {
		return this.cargarid_cuenta_contableSubCliente;
	}

	public void setCargarid_cuenta_contableSubCliente(Boolean cargarid_cuenta_contableSubCliente) {
		this.cargarid_cuenta_contableSubCliente= cargarid_cuenta_contableSubCliente;
	}

	public Border setResaltarnumero_cargaSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarnumero_cargaSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cargaSubCliente() {
		return this.resaltarnumero_cargaSubCliente;
	}

	public void setResaltarnumero_cargaSubCliente(Border borderResaltar) {
		this.resaltarnumero_cargaSubCliente= borderResaltar;
	}

	public Boolean getMostrarnumero_cargaSubCliente() {
		return this.mostrarnumero_cargaSubCliente;
	}

	public void setMostrarnumero_cargaSubCliente(Boolean mostrarnumero_cargaSubCliente) {
		this.mostrarnumero_cargaSubCliente= mostrarnumero_cargaSubCliente;
	}

	public Boolean getActivarnumero_cargaSubCliente() {
		return this.activarnumero_cargaSubCliente;
	}

	public void setActivarnumero_cargaSubCliente(Boolean activarnumero_cargaSubCliente) {
		this.activarnumero_cargaSubCliente= activarnumero_cargaSubCliente;
	}

	public Border setResaltarlimite_creditoSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarlimite_creditoSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlimite_creditoSubCliente() {
		return this.resaltarlimite_creditoSubCliente;
	}

	public void setResaltarlimite_creditoSubCliente(Border borderResaltar) {
		this.resaltarlimite_creditoSubCliente= borderResaltar;
	}

	public Boolean getMostrarlimite_creditoSubCliente() {
		return this.mostrarlimite_creditoSubCliente;
	}

	public void setMostrarlimite_creditoSubCliente(Boolean mostrarlimite_creditoSubCliente) {
		this.mostrarlimite_creditoSubCliente= mostrarlimite_creditoSubCliente;
	}

	public Boolean getActivarlimite_creditoSubCliente() {
		return this.activarlimite_creditoSubCliente;
	}

	public void setActivarlimite_creditoSubCliente(Boolean activarlimite_creditoSubCliente) {
		this.activarlimite_creditoSubCliente= activarlimite_creditoSubCliente;
	}

	public Border setResaltardescuentoSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltardescuentoSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoSubCliente() {
		return this.resaltardescuentoSubCliente;
	}

	public void setResaltardescuentoSubCliente(Border borderResaltar) {
		this.resaltardescuentoSubCliente= borderResaltar;
	}

	public Boolean getMostrardescuentoSubCliente() {
		return this.mostrardescuentoSubCliente;
	}

	public void setMostrardescuentoSubCliente(Boolean mostrardescuentoSubCliente) {
		this.mostrardescuentoSubCliente= mostrardescuentoSubCliente;
	}

	public Boolean getActivardescuentoSubCliente() {
		return this.activardescuentoSubCliente;
	}

	public void setActivardescuentoSubCliente(Boolean activardescuentoSubCliente) {
		this.activardescuentoSubCliente= activardescuentoSubCliente;
	}

	public Border setResaltarcodigo_contratoSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarcodigo_contratoSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_contratoSubCliente() {
		return this.resaltarcodigo_contratoSubCliente;
	}

	public void setResaltarcodigo_contratoSubCliente(Border borderResaltar) {
		this.resaltarcodigo_contratoSubCliente= borderResaltar;
	}

	public Boolean getMostrarcodigo_contratoSubCliente() {
		return this.mostrarcodigo_contratoSubCliente;
	}

	public void setMostrarcodigo_contratoSubCliente(Boolean mostrarcodigo_contratoSubCliente) {
		this.mostrarcodigo_contratoSubCliente= mostrarcodigo_contratoSubCliente;
	}

	public Boolean getActivarcodigo_contratoSubCliente() {
		return this.activarcodigo_contratoSubCliente;
	}

	public void setActivarcodigo_contratoSubCliente(Boolean activarcodigo_contratoSubCliente) {
		this.activarcodigo_contratoSubCliente= activarcodigo_contratoSubCliente;
	}

	public Border setResaltarvalor_contratoSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarvalor_contratoSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_contratoSubCliente() {
		return this.resaltarvalor_contratoSubCliente;
	}

	public void setResaltarvalor_contratoSubCliente(Border borderResaltar) {
		this.resaltarvalor_contratoSubCliente= borderResaltar;
	}

	public Boolean getMostrarvalor_contratoSubCliente() {
		return this.mostrarvalor_contratoSubCliente;
	}

	public void setMostrarvalor_contratoSubCliente(Boolean mostrarvalor_contratoSubCliente) {
		this.mostrarvalor_contratoSubCliente= mostrarvalor_contratoSubCliente;
	}

	public Boolean getActivarvalor_contratoSubCliente() {
		return this.activarvalor_contratoSubCliente;
	}

	public void setActivarvalor_contratoSubCliente(Boolean activarvalor_contratoSubCliente) {
		this.activarvalor_contratoSubCliente= activarvalor_contratoSubCliente;
	}

	public Border setResaltarfecha_inicioSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioSubCliente() {
		return this.resaltarfecha_inicioSubCliente;
	}

	public void setResaltarfecha_inicioSubCliente(Border borderResaltar) {
		this.resaltarfecha_inicioSubCliente= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioSubCliente() {
		return this.mostrarfecha_inicioSubCliente;
	}

	public void setMostrarfecha_inicioSubCliente(Boolean mostrarfecha_inicioSubCliente) {
		this.mostrarfecha_inicioSubCliente= mostrarfecha_inicioSubCliente;
	}

	public Boolean getActivarfecha_inicioSubCliente() {
		return this.activarfecha_inicioSubCliente;
	}

	public void setActivarfecha_inicioSubCliente(Boolean activarfecha_inicioSubCliente) {
		this.activarfecha_inicioSubCliente= activarfecha_inicioSubCliente;
	}

	public Border setResaltarfecha_finSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarfecha_finSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finSubCliente() {
		return this.resaltarfecha_finSubCliente;
	}

	public void setResaltarfecha_finSubCliente(Border borderResaltar) {
		this.resaltarfecha_finSubCliente= borderResaltar;
	}

	public Boolean getMostrarfecha_finSubCliente() {
		return this.mostrarfecha_finSubCliente;
	}

	public void setMostrarfecha_finSubCliente(Boolean mostrarfecha_finSubCliente) {
		this.mostrarfecha_finSubCliente= mostrarfecha_finSubCliente;
	}

	public Boolean getActivarfecha_finSubCliente() {
		return this.activarfecha_finSubCliente;
	}

	public void setActivarfecha_finSubCliente(Boolean activarfecha_finSubCliente) {
		this.activarfecha_finSubCliente= activarfecha_finSubCliente;
	}

	public Border setResaltarplazoSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltar);
		
		this.resaltarplazoSubCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarplazoSubCliente() {
		return this.resaltarplazoSubCliente;
	}

	public void setResaltarplazoSubCliente(Border borderResaltar) {
		this.resaltarplazoSubCliente= borderResaltar;
	}

	public Boolean getMostrarplazoSubCliente() {
		return this.mostrarplazoSubCliente;
	}

	public void setMostrarplazoSubCliente(Boolean mostrarplazoSubCliente) {
		this.mostrarplazoSubCliente= mostrarplazoSubCliente;
	}

	public Boolean getActivarplazoSubCliente() {
		return this.activarplazoSubCliente;
	}

	public void setActivarplazoSubCliente(Boolean activarplazoSubCliente) {
		this.activarplazoSubCliente= activarplazoSubCliente;
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
		
		
		this.setMostraridSubCliente(esInicial);
		this.setMostrarid_empresaSubCliente(esInicial);
		this.setMostrarid_clienteSubCliente(esInicial);
		this.setMostrarid_sucursalSubCliente(esInicial);
		this.setMostrarid_tipo_identificacionSubCliente(esInicial);
		this.setMostraridentificacionSubCliente(esInicial);
		this.setMostrarrucSubCliente(esInicial);
		this.setMostrarnombreSubCliente(esInicial);
		this.setMostrarapellidoSubCliente(esInicial);
		this.setMostrarnombre_completoSubCliente(esInicial);
		this.setMostrardireccionSubCliente(esInicial);
		this.setMostrartelefonoSubCliente(esInicial);
		this.setMostrarnumero_celularSubCliente(esInicial);
		this.setMostrarmailSubCliente(esInicial);
		this.setMostrarfecha_nacimientoSubCliente(esInicial);
		this.setMostrarfechaoSubCliente(esInicial);
		this.setMostrarobservacionSubCliente(esInicial);
		this.setMostrarid_paisSubCliente(esInicial);
		this.setMostrarid_ciudadSubCliente(esInicial);
		this.setMostrarid_zonaSubCliente(esInicial);
		this.setMostrarid_pais_nacionalidadSubCliente(esInicial);
		this.setMostrarid_tipo_generoSubCliente(esInicial);
		this.setMostrarid_estado_civilSubCliente(esInicial);
		this.setMostrarid_estado_legalSubCliente(esInicial);
		this.setMostrarid_tipo_nivel_eduSubCliente(esInicial);
		this.setMostrarpath_imagen_firmaSubCliente(esInicial);
		this.setMostrarid_cuenta_contableSubCliente(esInicial);
		this.setMostrarnumero_cargaSubCliente(esInicial);
		this.setMostrarlimite_creditoSubCliente(esInicial);
		this.setMostrardescuentoSubCliente(esInicial);
		this.setMostrarcodigo_contratoSubCliente(esInicial);
		this.setMostrarvalor_contratoSubCliente(esInicial);
		this.setMostrarfecha_inicioSubCliente(esInicial);
		this.setMostrarfecha_finSubCliente(esInicial);
		this.setMostrarplazoSubCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SubClienteConstantesFunciones.ID)) {
				this.setMostraridSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setMostrarid_tipo_identificacionSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDENTIFICACION)) {
				this.setMostraridentificacionSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.RUC)) {
				this.setMostrarrucSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.APELLIDO)) {
				this.setMostrarapellidoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.NUMEROCELULAR)) {
				this.setMostrarnumero_celularSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.MAIL)) {
				this.setMostrarmailSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.FECHANACIMIENTO)) {
				this.setMostrarfecha_nacimientoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.FECHA)) {
				this.setMostrarfechaoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.OBSERVACION)) {
				this.setMostrarobservacionSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDZONA)) {
				this.setMostrarid_zonaSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDPAISNACIONALIDAD)) {
				this.setMostrarid_pais_nacionalidadSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDTIPOGENERO)) {
				this.setMostrarid_tipo_generoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDESTADOCIVIL)) {
				this.setMostrarid_estado_civilSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDESTADOLEGAL)) {
				this.setMostrarid_estado_legalSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDTIPONIVELEDU)) {
				this.setMostrarid_tipo_nivel_eduSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.PATHIMAGENFIRMA)) {
				this.setMostrarpath_imagen_firmaSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.NUMEROCARGA)) {
				this.setMostrarnumero_cargaSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.LIMITECREDITO)) {
				this.setMostrarlimite_creditoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.CODIGOCONTRATO)) {
				this.setMostrarcodigo_contratoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.VALORCONTRATO)) {
				this.setMostrarvalor_contratoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.PLAZO)) {
				this.setMostrarplazoSubCliente(esAsigna);
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
		
		
		this.setActivaridSubCliente(esInicial);
		this.setActivarid_empresaSubCliente(esInicial);
		this.setActivarid_clienteSubCliente(esInicial);
		this.setActivarid_sucursalSubCliente(esInicial);
		this.setActivarid_tipo_identificacionSubCliente(esInicial);
		this.setActivaridentificacionSubCliente(esInicial);
		this.setActivarrucSubCliente(esInicial);
		this.setActivarnombreSubCliente(esInicial);
		this.setActivarapellidoSubCliente(esInicial);
		this.setActivarnombre_completoSubCliente(esInicial);
		this.setActivardireccionSubCliente(esInicial);
		this.setActivartelefonoSubCliente(esInicial);
		this.setActivarnumero_celularSubCliente(esInicial);
		this.setActivarmailSubCliente(esInicial);
		this.setActivarfecha_nacimientoSubCliente(esInicial);
		this.setActivarfechaoSubCliente(esInicial);
		this.setActivarobservacionSubCliente(esInicial);
		this.setActivarid_paisSubCliente(esInicial);
		this.setActivarid_ciudadSubCliente(esInicial);
		this.setActivarid_zonaSubCliente(esInicial);
		this.setActivarid_pais_nacionalidadSubCliente(esInicial);
		this.setActivarid_tipo_generoSubCliente(esInicial);
		this.setActivarid_estado_civilSubCliente(esInicial);
		this.setActivarid_estado_legalSubCliente(esInicial);
		this.setActivarid_tipo_nivel_eduSubCliente(esInicial);
		this.setActivarpath_imagen_firmaSubCliente(esInicial);
		this.setActivarid_cuenta_contableSubCliente(esInicial);
		this.setActivarnumero_cargaSubCliente(esInicial);
		this.setActivarlimite_creditoSubCliente(esInicial);
		this.setActivardescuentoSubCliente(esInicial);
		this.setActivarcodigo_contratoSubCliente(esInicial);
		this.setActivarvalor_contratoSubCliente(esInicial);
		this.setActivarfecha_inicioSubCliente(esInicial);
		this.setActivarfecha_finSubCliente(esInicial);
		this.setActivarplazoSubCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SubClienteConstantesFunciones.ID)) {
				this.setActivaridSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setActivarid_tipo_identificacionSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDENTIFICACION)) {
				this.setActivaridentificacionSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.RUC)) {
				this.setActivarrucSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.APELLIDO)) {
				this.setActivarapellidoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.DIRECCION)) {
				this.setActivardireccionSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.NUMEROCELULAR)) {
				this.setActivarnumero_celularSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.MAIL)) {
				this.setActivarmailSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.FECHANACIMIENTO)) {
				this.setActivarfecha_nacimientoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.FECHA)) {
				this.setActivarfechaoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.OBSERVACION)) {
				this.setActivarobservacionSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDZONA)) {
				this.setActivarid_zonaSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDPAISNACIONALIDAD)) {
				this.setActivarid_pais_nacionalidadSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDTIPOGENERO)) {
				this.setActivarid_tipo_generoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDESTADOCIVIL)) {
				this.setActivarid_estado_civilSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDESTADOLEGAL)) {
				this.setActivarid_estado_legalSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDTIPONIVELEDU)) {
				this.setActivarid_tipo_nivel_eduSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.PATHIMAGENFIRMA)) {
				this.setActivarpath_imagen_firmaSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.NUMEROCARGA)) {
				this.setActivarnumero_cargaSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.LIMITECREDITO)) {
				this.setActivarlimite_creditoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.CODIGOCONTRATO)) {
				this.setActivarcodigo_contratoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.VALORCONTRATO)) {
				this.setActivarvalor_contratoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.PLAZO)) {
				this.setActivarplazoSubCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSubCliente(esInicial);
		this.setResaltarid_empresaSubCliente(esInicial);
		this.setResaltarid_clienteSubCliente(esInicial);
		this.setResaltarid_sucursalSubCliente(esInicial);
		this.setResaltarid_tipo_identificacionSubCliente(esInicial);
		this.setResaltaridentificacionSubCliente(esInicial);
		this.setResaltarrucSubCliente(esInicial);
		this.setResaltarnombreSubCliente(esInicial);
		this.setResaltarapellidoSubCliente(esInicial);
		this.setResaltarnombre_completoSubCliente(esInicial);
		this.setResaltardireccionSubCliente(esInicial);
		this.setResaltartelefonoSubCliente(esInicial);
		this.setResaltarnumero_celularSubCliente(esInicial);
		this.setResaltarmailSubCliente(esInicial);
		this.setResaltarfecha_nacimientoSubCliente(esInicial);
		this.setResaltarfechaoSubCliente(esInicial);
		this.setResaltarobservacionSubCliente(esInicial);
		this.setResaltarid_paisSubCliente(esInicial);
		this.setResaltarid_ciudadSubCliente(esInicial);
		this.setResaltarid_zonaSubCliente(esInicial);
		this.setResaltarid_pais_nacionalidadSubCliente(esInicial);
		this.setResaltarid_tipo_generoSubCliente(esInicial);
		this.setResaltarid_estado_civilSubCliente(esInicial);
		this.setResaltarid_estado_legalSubCliente(esInicial);
		this.setResaltarid_tipo_nivel_eduSubCliente(esInicial);
		this.setResaltarpath_imagen_firmaSubCliente(esInicial);
		this.setResaltarid_cuenta_contableSubCliente(esInicial);
		this.setResaltarnumero_cargaSubCliente(esInicial);
		this.setResaltarlimite_creditoSubCliente(esInicial);
		this.setResaltardescuentoSubCliente(esInicial);
		this.setResaltarcodigo_contratoSubCliente(esInicial);
		this.setResaltarvalor_contratoSubCliente(esInicial);
		this.setResaltarfecha_inicioSubCliente(esInicial);
		this.setResaltarfecha_finSubCliente(esInicial);
		this.setResaltarplazoSubCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SubClienteConstantesFunciones.ID)) {
				this.setResaltaridSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setResaltarid_tipo_identificacionSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDENTIFICACION)) {
				this.setResaltaridentificacionSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.RUC)) {
				this.setResaltarrucSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.APELLIDO)) {
				this.setResaltarapellidoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.NUMEROCELULAR)) {
				this.setResaltarnumero_celularSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.MAIL)) {
				this.setResaltarmailSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.FECHANACIMIENTO)) {
				this.setResaltarfecha_nacimientoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.FECHA)) {
				this.setResaltarfechaoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.OBSERVACION)) {
				this.setResaltarobservacionSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDZONA)) {
				this.setResaltarid_zonaSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDPAISNACIONALIDAD)) {
				this.setResaltarid_pais_nacionalidadSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDTIPOGENERO)) {
				this.setResaltarid_tipo_generoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDESTADOCIVIL)) {
				this.setResaltarid_estado_civilSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDESTADOLEGAL)) {
				this.setResaltarid_estado_legalSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDTIPONIVELEDU)) {
				this.setResaltarid_tipo_nivel_eduSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.PATHIMAGENFIRMA)) {
				this.setResaltarpath_imagen_firmaSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.NUMEROCARGA)) {
				this.setResaltarnumero_cargaSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.LIMITECREDITO)) {
				this.setResaltarlimite_creditoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.CODIGOCONTRATO)) {
				this.setResaltarcodigo_contratoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.VALORCONTRATO)) {
				this.setResaltarvalor_contratoSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finSubCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubClienteConstantesFunciones.PLAZO)) {
				this.setResaltarplazoSubCliente(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFacturaSubCliente=null;

	public Border getResaltarFacturaSubCliente() {
		return this.resaltarFacturaSubCliente;
	}

	public void setResaltarFacturaSubCliente(Border borderResaltarFactura) {
		if(borderResaltarFactura!=null) {
			this.resaltarFacturaSubCliente= borderResaltarFactura;
		}
	}

	public Border setResaltarFacturaSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltarFactura=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltarFactura);
			
		this.resaltarFacturaSubCliente= borderResaltarFactura;

		 return borderResaltarFactura;
	}



	public Boolean mostrarFacturaSubCliente=true;

	public Boolean getMostrarFacturaSubCliente() {
		return this.mostrarFacturaSubCliente;
	}

	public void setMostrarFacturaSubCliente(Boolean visibilidadResaltarFactura) {
		this.mostrarFacturaSubCliente= visibilidadResaltarFactura;
	}



	public Boolean activarFacturaSubCliente=true;

	public Boolean gethabilitarResaltarFacturaSubCliente() {
		return this.activarFacturaSubCliente;
	}

	public void setActivarFacturaSubCliente(Boolean habilitarResaltarFactura) {
		this.activarFacturaSubCliente= habilitarResaltarFactura;
	}


	public Border resaltarConsignacionSubCliente=null;

	public Border getResaltarConsignacionSubCliente() {
		return this.resaltarConsignacionSubCliente;
	}

	public void setResaltarConsignacionSubCliente(Border borderResaltarConsignacion) {
		if(borderResaltarConsignacion!=null) {
			this.resaltarConsignacionSubCliente= borderResaltarConsignacion;
		}
	}

	public Border setResaltarConsignacionSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltarConsignacion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltarConsignacion);
			
		this.resaltarConsignacionSubCliente= borderResaltarConsignacion;

		 return borderResaltarConsignacion;
	}



	public Boolean mostrarConsignacionSubCliente=true;

	public Boolean getMostrarConsignacionSubCliente() {
		return this.mostrarConsignacionSubCliente;
	}

	public void setMostrarConsignacionSubCliente(Boolean visibilidadResaltarConsignacion) {
		this.mostrarConsignacionSubCliente= visibilidadResaltarConsignacion;
	}



	public Boolean activarConsignacionSubCliente=true;

	public Boolean gethabilitarResaltarConsignacionSubCliente() {
		return this.activarConsignacionSubCliente;
	}

	public void setActivarConsignacionSubCliente(Boolean habilitarResaltarConsignacion) {
		this.activarConsignacionSubCliente= habilitarResaltarConsignacion;
	}


	public Border resaltarGuiaRemisionSubCliente=null;

	public Border getResaltarGuiaRemisionSubCliente() {
		return this.resaltarGuiaRemisionSubCliente;
	}

	public void setResaltarGuiaRemisionSubCliente(Border borderResaltarGuiaRemision) {
		if(borderResaltarGuiaRemision!=null) {
			this.resaltarGuiaRemisionSubCliente= borderResaltarGuiaRemision;
		}
	}

	public Border setResaltarGuiaRemisionSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltarGuiaRemision=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltarGuiaRemision);
			
		this.resaltarGuiaRemisionSubCliente= borderResaltarGuiaRemision;

		 return borderResaltarGuiaRemision;
	}



	public Boolean mostrarGuiaRemisionSubCliente=true;

	public Boolean getMostrarGuiaRemisionSubCliente() {
		return this.mostrarGuiaRemisionSubCliente;
	}

	public void setMostrarGuiaRemisionSubCliente(Boolean visibilidadResaltarGuiaRemision) {
		this.mostrarGuiaRemisionSubCliente= visibilidadResaltarGuiaRemision;
	}



	public Boolean activarGuiaRemisionSubCliente=true;

	public Boolean gethabilitarResaltarGuiaRemisionSubCliente() {
		return this.activarGuiaRemisionSubCliente;
	}

	public void setActivarGuiaRemisionSubCliente(Boolean habilitarResaltarGuiaRemision) {
		this.activarGuiaRemisionSubCliente= habilitarResaltarGuiaRemision;
	}


	public Border resaltarProformaSubCliente=null;

	public Border getResaltarProformaSubCliente() {
		return this.resaltarProformaSubCliente;
	}

	public void setResaltarProformaSubCliente(Border borderResaltarProforma) {
		if(borderResaltarProforma!=null) {
			this.resaltarProformaSubCliente= borderResaltarProforma;
		}
	}

	public Border setResaltarProformaSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltarProforma=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltarProforma);
			
		this.resaltarProformaSubCliente= borderResaltarProforma;

		 return borderResaltarProforma;
	}



	public Boolean mostrarProformaSubCliente=true;

	public Boolean getMostrarProformaSubCliente() {
		return this.mostrarProformaSubCliente;
	}

	public void setMostrarProformaSubCliente(Boolean visibilidadResaltarProforma) {
		this.mostrarProformaSubCliente= visibilidadResaltarProforma;
	}



	public Boolean activarProformaSubCliente=true;

	public Boolean gethabilitarResaltarProformaSubCliente() {
		return this.activarProformaSubCliente;
	}

	public void setActivarProformaSubCliente(Boolean habilitarResaltarProforma) {
		this.activarProformaSubCliente= habilitarResaltarProforma;
	}


	public Border resaltarPedidoExporSubCliente=null;

	public Border getResaltarPedidoExporSubCliente() {
		return this.resaltarPedidoExporSubCliente;
	}

	public void setResaltarPedidoExporSubCliente(Border borderResaltarPedidoExpor) {
		if(borderResaltarPedidoExpor!=null) {
			this.resaltarPedidoExporSubCliente= borderResaltarPedidoExpor;
		}
	}

	public Border setResaltarPedidoExporSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoExpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltarPedidoExpor);
			
		this.resaltarPedidoExporSubCliente= borderResaltarPedidoExpor;

		 return borderResaltarPedidoExpor;
	}



	public Boolean mostrarPedidoExporSubCliente=true;

	public Boolean getMostrarPedidoExporSubCliente() {
		return this.mostrarPedidoExporSubCliente;
	}

	public void setMostrarPedidoExporSubCliente(Boolean visibilidadResaltarPedidoExpor) {
		this.mostrarPedidoExporSubCliente= visibilidadResaltarPedidoExpor;
	}



	public Boolean activarPedidoExporSubCliente=true;

	public Boolean gethabilitarResaltarPedidoExporSubCliente() {
		return this.activarPedidoExporSubCliente;
	}

	public void setActivarPedidoExporSubCliente(Boolean habilitarResaltarPedidoExpor) {
		this.activarPedidoExporSubCliente= habilitarResaltarPedidoExpor;
	}


	public Border resaltarPedidoSubCliente=null;

	public Border getResaltarPedidoSubCliente() {
		return this.resaltarPedidoSubCliente;
	}

	public void setResaltarPedidoSubCliente(Border borderResaltarPedido) {
		if(borderResaltarPedido!=null) {
			this.resaltarPedidoSubCliente= borderResaltarPedido;
		}
	}

	public Border setResaltarPedidoSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltarPedido=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//subclienteBeanSwingJInternalFrame.jTtoolBarSubCliente.setBorder(borderResaltarPedido);
			
		this.resaltarPedidoSubCliente= borderResaltarPedido;

		 return borderResaltarPedido;
	}



	public Boolean mostrarPedidoSubCliente=true;

	public Boolean getMostrarPedidoSubCliente() {
		return this.mostrarPedidoSubCliente;
	}

	public void setMostrarPedidoSubCliente(Boolean visibilidadResaltarPedido) {
		this.mostrarPedidoSubCliente= visibilidadResaltarPedido;
	}



	public Boolean activarPedidoSubCliente=true;

	public Boolean gethabilitarResaltarPedidoSubCliente() {
		return this.activarPedidoSubCliente;
	}

	public void setActivarPedidoSubCliente(Boolean habilitarResaltarPedido) {
		this.activarPedidoSubCliente= habilitarResaltarPedido;
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

		this.setMostrarFacturaSubCliente(esInicial);
		this.setMostrarConsignacionSubCliente(esInicial);
		this.setMostrarGuiaRemisionSubCliente(esInicial);
		this.setMostrarProformaSubCliente(esInicial);
		this.setMostrarPedidoExporSubCliente(esInicial);
		this.setMostrarPedidoSubCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Factura.class)) {
				this.setMostrarFacturaSubCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignacion.class)) {
				this.setMostrarConsignacionSubCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(GuiaRemision.class)) {
				this.setMostrarGuiaRemisionSubCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Proforma.class)) {
				this.setMostrarProformaSubCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setMostrarPedidoExporSubCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Pedido.class)) {
				this.setMostrarPedidoSubCliente(esAsigna);
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

		this.setActivarFacturaSubCliente(esInicial);
		this.setActivarConsignacionSubCliente(esInicial);
		this.setActivarGuiaRemisionSubCliente(esInicial);
		this.setActivarProformaSubCliente(esInicial);
		this.setActivarPedidoExporSubCliente(esInicial);
		this.setActivarPedidoSubCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Factura.class)) {
				this.setActivarFacturaSubCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignacion.class)) {
				this.setActivarConsignacionSubCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(GuiaRemision.class)) {
				this.setActivarGuiaRemisionSubCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Proforma.class)) {
				this.setActivarProformaSubCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setActivarPedidoExporSubCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Pedido.class)) {
				this.setActivarPedidoSubCliente(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFacturaSubCliente(esInicial);
		this.setResaltarConsignacionSubCliente(esInicial);
		this.setResaltarGuiaRemisionSubCliente(esInicial);
		this.setResaltarProformaSubCliente(esInicial);
		this.setResaltarPedidoExporSubCliente(esInicial);
		this.setResaltarPedidoSubCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Factura.class)) {
				this.setResaltarFacturaSubCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignacion.class)) {
				this.setResaltarConsignacionSubCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(GuiaRemision.class)) {
				this.setResaltarGuiaRemisionSubCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Proforma.class)) {
				this.setResaltarProformaSubCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(PedidoExpor.class)) {
				this.setResaltarPedidoExporSubCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Pedido.class)) {
				this.setResaltarPedidoSubCliente(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorIdentificacionSubCliente=true;

	public Boolean getMostrarBusquedaPorIdentificacionSubCliente() {
		return this.mostrarBusquedaPorIdentificacionSubCliente;
	}

	public void setMostrarBusquedaPorIdentificacionSubCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdentificacionSubCliente= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreCompletoSubCliente=true;

	public Boolean getMostrarBusquedaPorNombreCompletoSubCliente() {
		return this.mostrarBusquedaPorNombreCompletoSubCliente;
	}

	public void setMostrarBusquedaPorNombreCompletoSubCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreCompletoSubCliente= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorRucSubCliente=true;

	public Boolean getMostrarBusquedaPorRucSubCliente() {
		return this.mostrarBusquedaPorRucSubCliente;
	}

	public void setMostrarBusquedaPorRucSubCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorRucSubCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteSubCliente=true;

	public Boolean getMostrarFK_IdClienteSubCliente() {
		return this.mostrarFK_IdClienteSubCliente;
	}

	public void setMostrarFK_IdClienteSubCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteSubCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaSubCliente=true;

	public Boolean getMostrarFK_IdEmpresaSubCliente() {
		return this.mostrarFK_IdEmpresaSubCliente;
	}

	public void setMostrarFK_IdEmpresaSubCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaSubCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoCivilSubCliente=true;

	public Boolean getMostrarFK_IdEstadoCivilSubCliente() {
		return this.mostrarFK_IdEstadoCivilSubCliente;
	}

	public void setMostrarFK_IdEstadoCivilSubCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoCivilSubCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoLegalSubCliente=true;

	public Boolean getMostrarFK_IdEstadoLegalSubCliente() {
		return this.mostrarFK_IdEstadoLegalSubCliente;
	}

	public void setMostrarFK_IdEstadoLegalSubCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoLegalSubCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalSubCliente=true;

	public Boolean getMostrarFK_IdSucursalSubCliente() {
		return this.mostrarFK_IdSucursalSubCliente;
	}

	public void setMostrarFK_IdSucursalSubCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalSubCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoIdentificacionSubCliente=true;

	public Boolean getMostrarFK_IdTipoIdentificacionSubCliente() {
		return this.mostrarFK_IdTipoIdentificacionSubCliente;
	}

	public void setMostrarFK_IdTipoIdentificacionSubCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoIdentificacionSubCliente= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdentificacionSubCliente=true;

	public Boolean getActivarBusquedaPorIdentificacionSubCliente() {
		return this.activarBusquedaPorIdentificacionSubCliente;
	}

	public void setActivarBusquedaPorIdentificacionSubCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdentificacionSubCliente= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreCompletoSubCliente=true;

	public Boolean getActivarBusquedaPorNombreCompletoSubCliente() {
		return this.activarBusquedaPorNombreCompletoSubCliente;
	}

	public void setActivarBusquedaPorNombreCompletoSubCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreCompletoSubCliente= habilitarResaltar;
	}

	public Boolean activarBusquedaPorRucSubCliente=true;

	public Boolean getActivarBusquedaPorRucSubCliente() {
		return this.activarBusquedaPorRucSubCliente;
	}

	public void setActivarBusquedaPorRucSubCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorRucSubCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteSubCliente=true;

	public Boolean getActivarFK_IdClienteSubCliente() {
		return this.activarFK_IdClienteSubCliente;
	}

	public void setActivarFK_IdClienteSubCliente(Boolean habilitarResaltar) {
		this.activarFK_IdClienteSubCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaSubCliente=true;

	public Boolean getActivarFK_IdEmpresaSubCliente() {
		return this.activarFK_IdEmpresaSubCliente;
	}

	public void setActivarFK_IdEmpresaSubCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaSubCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoCivilSubCliente=true;

	public Boolean getActivarFK_IdEstadoCivilSubCliente() {
		return this.activarFK_IdEstadoCivilSubCliente;
	}

	public void setActivarFK_IdEstadoCivilSubCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoCivilSubCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoLegalSubCliente=true;

	public Boolean getActivarFK_IdEstadoLegalSubCliente() {
		return this.activarFK_IdEstadoLegalSubCliente;
	}

	public void setActivarFK_IdEstadoLegalSubCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoLegalSubCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalSubCliente=true;

	public Boolean getActivarFK_IdSucursalSubCliente() {
		return this.activarFK_IdSucursalSubCliente;
	}

	public void setActivarFK_IdSucursalSubCliente(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalSubCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoIdentificacionSubCliente=true;

	public Boolean getActivarFK_IdTipoIdentificacionSubCliente() {
		return this.activarFK_IdTipoIdentificacionSubCliente;
	}

	public void setActivarFK_IdTipoIdentificacionSubCliente(Boolean habilitarResaltar) {
		this.activarFK_IdTipoIdentificacionSubCliente= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdentificacionSubCliente=null;

	public Border getResaltarBusquedaPorIdentificacionSubCliente() {
		return this.resaltarBusquedaPorIdentificacionSubCliente;
	}

	public void setResaltarBusquedaPorIdentificacionSubCliente(Border borderResaltar) {
		this.resaltarBusquedaPorIdentificacionSubCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorIdentificacionSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdentificacionSubCliente= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreCompletoSubCliente=null;

	public Border getResaltarBusquedaPorNombreCompletoSubCliente() {
		return this.resaltarBusquedaPorNombreCompletoSubCliente;
	}

	public void setResaltarBusquedaPorNombreCompletoSubCliente(Border borderResaltar) {
		this.resaltarBusquedaPorNombreCompletoSubCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreCompletoSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreCompletoSubCliente= borderResaltar;
	}

	public Border resaltarBusquedaPorRucSubCliente=null;

	public Border getResaltarBusquedaPorRucSubCliente() {
		return this.resaltarBusquedaPorRucSubCliente;
	}

	public void setResaltarBusquedaPorRucSubCliente(Border borderResaltar) {
		this.resaltarBusquedaPorRucSubCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorRucSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorRucSubCliente= borderResaltar;
	}

	public Border resaltarFK_IdClienteSubCliente=null;

	public Border getResaltarFK_IdClienteSubCliente() {
		return this.resaltarFK_IdClienteSubCliente;
	}

	public void setResaltarFK_IdClienteSubCliente(Border borderResaltar) {
		this.resaltarFK_IdClienteSubCliente= borderResaltar;
	}

	public void setResaltarFK_IdClienteSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteSubCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaSubCliente=null;

	public Border getResaltarFK_IdEmpresaSubCliente() {
		return this.resaltarFK_IdEmpresaSubCliente;
	}

	public void setResaltarFK_IdEmpresaSubCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaSubCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaSubCliente= borderResaltar;
	}

	public Border resaltarFK_IdEstadoCivilSubCliente=null;

	public Border getResaltarFK_IdEstadoCivilSubCliente() {
		return this.resaltarFK_IdEstadoCivilSubCliente;
	}

	public void setResaltarFK_IdEstadoCivilSubCliente(Border borderResaltar) {
		this.resaltarFK_IdEstadoCivilSubCliente= borderResaltar;
	}

	public void setResaltarFK_IdEstadoCivilSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoCivilSubCliente= borderResaltar;
	}

	public Border resaltarFK_IdEstadoLegalSubCliente=null;

	public Border getResaltarFK_IdEstadoLegalSubCliente() {
		return this.resaltarFK_IdEstadoLegalSubCliente;
	}

	public void setResaltarFK_IdEstadoLegalSubCliente(Border borderResaltar) {
		this.resaltarFK_IdEstadoLegalSubCliente= borderResaltar;
	}

	public void setResaltarFK_IdEstadoLegalSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoLegalSubCliente= borderResaltar;
	}

	public Border resaltarFK_IdSucursalSubCliente=null;

	public Border getResaltarFK_IdSucursalSubCliente() {
		return this.resaltarFK_IdSucursalSubCliente;
	}

	public void setResaltarFK_IdSucursalSubCliente(Border borderResaltar) {
		this.resaltarFK_IdSucursalSubCliente= borderResaltar;
	}

	public void setResaltarFK_IdSucursalSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalSubCliente= borderResaltar;
	}

	public Border resaltarFK_IdTipoIdentificacionSubCliente=null;

	public Border getResaltarFK_IdTipoIdentificacionSubCliente() {
		return this.resaltarFK_IdTipoIdentificacionSubCliente;
	}

	public void setResaltarFK_IdTipoIdentificacionSubCliente(Border borderResaltar) {
		this.resaltarFK_IdTipoIdentificacionSubCliente= borderResaltar;
	}

	public void setResaltarFK_IdTipoIdentificacionSubCliente(ParametroGeneralUsuario parametroGeneralUsuario/*SubClienteBeanSwingJInternalFrame subclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoIdentificacionSubCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}