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


import com.bydan.erp.cartera.util.ClienteConstantesFunciones;
import com.bydan.erp.cartera.util.ClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ClienteParameterGeneral;

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
final public class ClienteConstantesFunciones extends ClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Cliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Cliente"+ClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ClienteConstantesFunciones.SCHEMA+"_"+ClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ClienteConstantesFunciones.SCHEMA+"_"+ClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ClienteConstantesFunciones.SCHEMA+"_"+ClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ClienteConstantesFunciones.SCHEMA+"_"+ClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Cliente";
	public static final String OBJECTNAME="cliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cliente from "+ClienteConstantesFunciones.SPERSISTENCENAME+" cliente";
	public static String QUERYSELECTNATIVE="select "+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".version_row,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_empresa,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_sucursal,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".codigo,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_tipo_identificacion,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".identificacion,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".ruc,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".nombre,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".apellido,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".nombre_completo,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".nombre_comercial,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".telefono,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".direccion,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".es_prove,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_grupo_cliente,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_titulo_cliente,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_area_cr,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_estado_cliente,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".observacion,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_pais,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_region,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_provincia,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_ciudad,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_zona,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_pais_nacionalidad,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_tipo_cargo_labo,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_tipo_nivel_edu,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_profesion,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_tipo_genero,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_estado_civil,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_estado_legal,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".fecha_nacimiento,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".path_imagen_firma,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".contacto,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_cuenta_contable,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_ruta,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_vendedor,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_centro_actividad,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".representante,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_tipo_garantia_empresa,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".nombre_garantia,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".valor_garantia,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_cate_tipo_afiliacion,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".numero_carga,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".credito_usado,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".limite_credito,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".credito_disponible,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".total_documentos,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".fecha_ultima_factura,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".descuento,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_dia,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".hora_pago,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_empleado,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".cobranzas,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".motivo,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".preferencia,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".con_separacion_bienes,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_tipo_precio,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_tipo_lista_precio,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".detalle_estado,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".es_contribuyente_especial from "+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME;//+" as "+ClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ClienteConstantesFuncionesAdditional clienteConstantesFuncionesAdditional=null;
	
	public ClienteConstantesFuncionesAdditional getClienteConstantesFuncionesAdditional() {
		return this.clienteConstantesFuncionesAdditional;
	}
	
	public void setClienteConstantesFuncionesAdditional(ClienteConstantesFuncionesAdditional clienteConstantesFuncionesAdditional) {
		try {
			this.clienteConstantesFuncionesAdditional=clienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String CODIGO= "codigo";
    public static final String IDTIPOIDENTIFICACION= "id_tipo_identificacion";
    public static final String IDENTIFICACION= "identificacion";
    public static final String RUC= "ruc";
    public static final String NOMBRE= "nombre";
    public static final String APELLIDO= "apellido";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String NOMBRECOMERCIAL= "nombre_comercial";
    public static final String TELEFONO= "telefono";
    public static final String DIRECCION= "direccion";
    public static final String ESPROVE= "es_prove";
    public static final String IDGRUPOCLIENTE= "id_grupo_cliente";
    public static final String IDTITULOCLIENTE= "id_titulo_cliente";
    public static final String IDAREACR= "id_area_cr";
    public static final String IDESTADOCLIENTE= "id_estado_cliente";
    public static final String OBSERVACION= "observacion";
    public static final String IDPAIS= "id_pais";
    public static final String IDREGION= "id_region";
    public static final String IDPROVINCIA= "id_provincia";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String IDZONA= "id_zona";
    public static final String IDPAISNACIONALIDAD= "id_pais_nacionalidad";
    public static final String IDTIPOCARGOLABO= "id_tipo_cargo_labo";
    public static final String IDTIPONIVELEDU= "id_tipo_nivel_edu";
    public static final String IDPROFESION= "id_profesion";
    public static final String IDTIPOGENERO= "id_tipo_genero";
    public static final String IDESTADOCIVIL= "id_estado_civil";
    public static final String IDESTADOLEGAL= "id_estado_legal";
    public static final String FECHANACIMIENTO= "fecha_nacimiento";
    public static final String PATHIMAGENFIRMA= "path_imagen_firma";
    public static final String CONTACTO= "contacto";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDRUTA= "id_ruta";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDCENTROACTIVIDAD= "id_centro_actividad";
    public static final String REPRESENTANTE= "representante";
    public static final String IDTIPOGARANTIAEMPRESA= "id_tipo_garantia_empresa";
    public static final String NOMBREGARANTIA= "nombre_garantia";
    public static final String VALORGARANTIA= "valor_garantia";
    public static final String IDCATETIPOAFILIACION= "id_cate_tipo_afiliacion";
    public static final String NUMEROCARGA= "numero_carga";
    public static final String CREDITOUSADO= "credito_usado";
    public static final String LIMITECREDITO= "limite_credito";
    public static final String CREDITODISPONIBLE= "credito_disponible";
    public static final String TOTALDOCUMENTOS= "total_documentos";
    public static final String FECHAULTIMAFACTURA= "fecha_ultima_factura";
    public static final String DESCUENTO= "descuento";
    public static final String IDDIA= "id_dia";
    public static final String HORAPAGO= "hora_pago";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String COBRANZAS= "cobranzas";
    public static final String MOTIVO= "motivo";
    public static final String PREFERENCIA= "preferencia";
    public static final String CONSEPARACIONBIENES= "con_separacion_bienes";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String IDTIPOLISTAPRECIO= "id_tipo_lista_precio";
    public static final String DETALLEESTADO= "detalle_estado";
    public static final String ESCONTRIBUYENTEESPECIAL= "es_contribuyente_especial";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
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
    	public static final String LABEL_NOMBRECOMERCIAL= "Nombre Comercial";
		public static final String LABEL_NOMBRECOMERCIAL_LOWER= "Nombre Comercial";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_ESPROVE= "Es Proveedor";
		public static final String LABEL_ESPROVE_LOWER= "Es Prove";
    	public static final String LABEL_IDGRUPOCLIENTE= "Grupo Cliente";
		public static final String LABEL_IDGRUPOCLIENTE_LOWER= "Grupo Cliente";
    	public static final String LABEL_IDTITULOCLIENTE= "Titulo Cliente";
		public static final String LABEL_IDTITULOCLIENTE_LOWER= "Titulo Cliente";
    	public static final String LABEL_IDAREACR= "Area";
		public static final String LABEL_IDAREACR_LOWER= "Area Cr";
    	public static final String LABEL_IDESTADOCLIENTE= "Estado Cliente";
		public static final String LABEL_IDESTADOCLIENTE_LOWER= "Estado Cliente";
    	public static final String LABEL_OBSERVACION= "Observacion";
		public static final String LABEL_OBSERVACION_LOWER= "Observacion";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDREGION= "Region";
		public static final String LABEL_IDREGION_LOWER= "Region";
    	public static final String LABEL_IDPROVINCIA= "Provincia";
		public static final String LABEL_IDPROVINCIA_LOWER= "Provincia";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_IDZONA= "Zona";
		public static final String LABEL_IDZONA_LOWER= "Zona";
    	public static final String LABEL_IDPAISNACIONALIDAD= "Pais Nacionalidad";
		public static final String LABEL_IDPAISNACIONALIDAD_LOWER= "Pais Nacionalidad";
    	public static final String LABEL_IDTIPOCARGOLABO= "Tipo Cargo Laboral";
		public static final String LABEL_IDTIPOCARGOLABO_LOWER= "Tipo Cargo Labo";
    	public static final String LABEL_IDTIPONIVELEDU= "Tipo Nivel Educativo";
		public static final String LABEL_IDTIPONIVELEDU_LOWER= "Tipo Nivel Edu";
    	public static final String LABEL_IDPROFESION= "Profesion";
		public static final String LABEL_IDPROFESION_LOWER= "Profesion";
    	public static final String LABEL_IDTIPOGENERO= "Tipo Genero";
		public static final String LABEL_IDTIPOGENERO_LOWER= "Tipo Genero";
    	public static final String LABEL_IDESTADOCIVIL= "Estado Civil";
		public static final String LABEL_IDESTADOCIVIL_LOWER= "Estado Civil";
    	public static final String LABEL_IDESTADOLEGAL= "Estado Legal";
		public static final String LABEL_IDESTADOLEGAL_LOWER= "Estado Legal";
    	public static final String LABEL_FECHANACIMIENTO= "Fecha Nacimiento";
		public static final String LABEL_FECHANACIMIENTO_LOWER= "Fecha Nacimiento";
    	public static final String LABEL_PATHIMAGENFIRMA= "Path Imagen Firma";
		public static final String LABEL_PATHIMAGENFIRMA_LOWER= "Path Imagen Firma";
    	public static final String LABEL_CONTACTO= "Contacto";
		public static final String LABEL_CONTACTO_LOWER= "Contacto";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDRUTA= "Ruta";
		public static final String LABEL_IDRUTA_LOWER= "Ruta";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDCENTROACTIVIDAD= "Centro Activad";
		public static final String LABEL_IDCENTROACTIVIDAD_LOWER= "Centro Actividad";
    	public static final String LABEL_REPRESENTANTE= "Representante";
		public static final String LABEL_REPRESENTANTE_LOWER= "Representante";
    	public static final String LABEL_IDTIPOGARANTIAEMPRESA= "Tipo Garantia";
		public static final String LABEL_IDTIPOGARANTIAEMPRESA_LOWER= "Tipo Garantia Empresa";
    	public static final String LABEL_NOMBREGARANTIA= "Nombre Garantia";
		public static final String LABEL_NOMBREGARANTIA_LOWER= "Nombre Garantia";
    	public static final String LABEL_VALORGARANTIA= "Valor Garantia";
		public static final String LABEL_VALORGARANTIA_LOWER= "Valor Garantia";
    	public static final String LABEL_IDCATETIPOAFILIACION= "Categoria Afiliacion";
		public static final String LABEL_IDCATETIPOAFILIACION_LOWER= "Cate Tipo Afiliacion";
    	public static final String LABEL_NUMEROCARGA= "Numero Carga";
		public static final String LABEL_NUMEROCARGA_LOWER= "Numero Carga";
    	public static final String LABEL_CREDITOUSADO= "Credito Usado";
		public static final String LABEL_CREDITOUSADO_LOWER= "Credito Usado";
    	public static final String LABEL_LIMITECREDITO= "Limite Credito";
		public static final String LABEL_LIMITECREDITO_LOWER= "Limite Credito";
    	public static final String LABEL_CREDITODISPONIBLE= "Credito Disponible";
		public static final String LABEL_CREDITODISPONIBLE_LOWER= "Credito Disponible";
    	public static final String LABEL_TOTALDOCUMENTOS= "Total Documentos";
		public static final String LABEL_TOTALDOCUMENTOS_LOWER= "Total Documentos";
    	public static final String LABEL_FECHAULTIMAFACTURA= "Fecha Ultima Factura";
		public static final String LABEL_FECHAULTIMAFACTURA_LOWER= "Fecha Ultima Factura";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_IDDIA= "Dia Pago";
		public static final String LABEL_IDDIA_LOWER= "Dia";
    	public static final String LABEL_HORAPAGO= "Hora Pago";
		public static final String LABEL_HORAPAGO_LOWER= "Hora Pago";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_COBRANZAS= "Cobranzas";
		public static final String LABEL_COBRANZAS_LOWER= "Cobranzas";
    	public static final String LABEL_MOTIVO= "Motivo";
		public static final String LABEL_MOTIVO_LOWER= "Motivo";
    	public static final String LABEL_PREFERENCIA= "Preferencia";
		public static final String LABEL_PREFERENCIA_LOWER= "Preferencia";
    	public static final String LABEL_CONSEPARACIONBIENES= "Con Separacion Bienes";
		public static final String LABEL_CONSEPARACIONBIENES_LOWER= "Con Separacion Bienes";
    	public static final String LABEL_IDTIPOPRECIO= "Tipo Precio";
		public static final String LABEL_IDTIPOPRECIO_LOWER= "Tipo Precio";
    	public static final String LABEL_IDTIPOLISTAPRECIO= "Tipo Lista Precio";
		public static final String LABEL_IDTIPOLISTAPRECIO_LOWER= "Tipo Lista Precio";
    	public static final String LABEL_DETALLEESTADO= "Detalle Estado";
		public static final String LABEL_DETALLEESTADO_LOWER= "Detalle Estado";
    	public static final String LABEL_ESCONTRIBUYENTEESPECIAL= "Es Contribuyente Especial";
		public static final String LABEL_ESCONTRIBUYENTEESPECIAL_LOWER= "Es Contribuyente Especial";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
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
	public static final String SREGEXNOMBRE_COMERCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMERCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXOBSERVACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXPATH_IMAGEN_FIRMA=ConstantesValidacion.SREGEXCADENATODOS;
	public static final String SMENSAJEREGEXPATH_IMAGEN_FIRMA=ConstantesValidacion.SVALIDACIONTODOS;	
	public static final String SREGEXCONTACTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCONTACTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXREPRESENTANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXREPRESENTANTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNOMBRE_GARANTIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_GARANTIA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCOBRANZAS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCOBRANZAS=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMOTIVO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMOTIVO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPREFERENCIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPREFERENCIA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXDETALLE_ESTADO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE_ESTADO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.CODIGO)) {sLabelColumna=ClienteConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDTIPOIDENTIFICACION)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDTIPOIDENTIFICACION;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDENTIFICACION)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDENTIFICACION;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.RUC)) {sLabelColumna=ClienteConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.NOMBRE)) {sLabelColumna=ClienteConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.APELLIDO)) {sLabelColumna=ClienteConstantesFunciones.LABEL_APELLIDO;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=ClienteConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.NOMBRECOMERCIAL)) {sLabelColumna=ClienteConstantesFunciones.LABEL_NOMBRECOMERCIAL;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.TELEFONO)) {sLabelColumna=ClienteConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.DIRECCION)) {sLabelColumna=ClienteConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.ESPROVE)) {sLabelColumna=ClienteConstantesFunciones.LABEL_ESPROVE;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDGRUPOCLIENTE)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDGRUPOCLIENTE;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDTITULOCLIENTE)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDTITULOCLIENTE;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDAREACR)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDAREACR;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDESTADOCLIENTE)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDESTADOCLIENTE;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.OBSERVACION)) {sLabelColumna=ClienteConstantesFunciones.LABEL_OBSERVACION;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDPAIS)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDREGION)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDREGION;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDPROVINCIA)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDPROVINCIA;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDCIUDAD)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDZONA)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDZONA;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDPAISNACIONALIDAD)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDPAISNACIONALIDAD;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDTIPOCARGOLABO)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDTIPOCARGOLABO;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDTIPONIVELEDU)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDTIPONIVELEDU;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDPROFESION)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDPROFESION;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDTIPOGENERO)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDTIPOGENERO;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDESTADOCIVIL)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDESTADOCIVIL;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDESTADOLEGAL)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDESTADOLEGAL;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.FECHANACIMIENTO)) {sLabelColumna=ClienteConstantesFunciones.LABEL_FECHANACIMIENTO;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.PATHIMAGENFIRMA)) {sLabelColumna=ClienteConstantesFunciones.LABEL_PATHIMAGENFIRMA;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.CONTACTO)) {sLabelColumna=ClienteConstantesFunciones.LABEL_CONTACTO;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDRUTA)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDRUTA;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDVENDEDOR)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDCENTROACTIVIDAD)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDCENTROACTIVIDAD;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.REPRESENTANTE)) {sLabelColumna=ClienteConstantesFunciones.LABEL_REPRESENTANTE;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDTIPOGARANTIAEMPRESA;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.NOMBREGARANTIA)) {sLabelColumna=ClienteConstantesFunciones.LABEL_NOMBREGARANTIA;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.VALORGARANTIA)) {sLabelColumna=ClienteConstantesFunciones.LABEL_VALORGARANTIA;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDCATETIPOAFILIACION)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDCATETIPOAFILIACION;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.NUMEROCARGA)) {sLabelColumna=ClienteConstantesFunciones.LABEL_NUMEROCARGA;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.CREDITOUSADO)) {sLabelColumna=ClienteConstantesFunciones.LABEL_CREDITOUSADO;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.LIMITECREDITO)) {sLabelColumna=ClienteConstantesFunciones.LABEL_LIMITECREDITO;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.CREDITODISPONIBLE)) {sLabelColumna=ClienteConstantesFunciones.LABEL_CREDITODISPONIBLE;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.TOTALDOCUMENTOS)) {sLabelColumna=ClienteConstantesFunciones.LABEL_TOTALDOCUMENTOS;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.FECHAULTIMAFACTURA)) {sLabelColumna=ClienteConstantesFunciones.LABEL_FECHAULTIMAFACTURA;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.DESCUENTO)) {sLabelColumna=ClienteConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDDIA)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDDIA;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.HORAPAGO)) {sLabelColumna=ClienteConstantesFunciones.LABEL_HORAPAGO;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDEMPLEADO)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.COBRANZAS)) {sLabelColumna=ClienteConstantesFunciones.LABEL_COBRANZAS;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.MOTIVO)) {sLabelColumna=ClienteConstantesFunciones.LABEL_MOTIVO;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.PREFERENCIA)) {sLabelColumna=ClienteConstantesFunciones.LABEL_PREFERENCIA;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.CONSEPARACIONBIENES)) {sLabelColumna=ClienteConstantesFunciones.LABEL_CONSEPARACIONBIENES;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.IDTIPOLISTAPRECIO)) {sLabelColumna=ClienteConstantesFunciones.LABEL_IDTIPOLISTAPRECIO;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.DETALLEESTADO)) {sLabelColumna=ClienteConstantesFunciones.LABEL_DETALLEESTADO;}
		if(sNombreColumna.equals(ClienteConstantesFunciones.ESCONTRIBUYENTEESPECIAL)) {sLabelColumna=ClienteConstantesFunciones.LABEL_ESCONTRIBUYENTEESPECIAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_proveDescripcion(Cliente cliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cliente.getes_prove()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_proveHtmlDescripcion(Cliente cliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cliente.getId(),cliente.getes_prove());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_separacion_bienesDescripcion(Cliente cliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cliente.getcon_separacion_bienes()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_separacion_bienesHtmlDescripcion(Cliente cliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cliente.getId(),cliente.getcon_separacion_bienes());

		return sDescripcion;
	}	
			
			
			
		
	public static String getes_contribuyente_especialDescripcion(Cliente cliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cliente.getes_contribuyente_especial()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_contribuyente_especialHtmlDescripcion(Cliente cliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cliente.getId(),cliente.getes_contribuyente_especial());

		return sDescripcion;
	}	
	
	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cliente !=null/* && cliente.getId()!=0*/) {
			sDescripcion=cliente.getnombre_completo();//clientecliente.getnombre_completo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getClienteDescripcionDetallado(Cliente cliente) {
		String sDescripcion="";
			
		sDescripcion+=ClienteConstantesFunciones.ID+"=";
		sDescripcion+=cliente.getId().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cliente.getVersionRow().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cliente.getid_empresa().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cliente.getid_sucursal().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.CODIGO+"=";
		sDescripcion+=cliente.getcodigo()+",";
		sDescripcion+=ClienteConstantesFunciones.IDTIPOIDENTIFICACION+"=";
		sDescripcion+=cliente.getid_tipo_identificacion().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDENTIFICACION+"=";
		sDescripcion+=cliente.getidentificacion()+",";
		sDescripcion+=ClienteConstantesFunciones.RUC+"=";
		sDescripcion+=cliente.getruc()+",";
		sDescripcion+=ClienteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=cliente.getnombre()+",";
		sDescripcion+=ClienteConstantesFunciones.APELLIDO+"=";
		sDescripcion+=cliente.getapellido()+",";
		sDescripcion+=ClienteConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=cliente.getnombre_completo()+",";
		sDescripcion+=ClienteConstantesFunciones.NOMBRECOMERCIAL+"=";
		sDescripcion+=cliente.getnombre_comercial()+",";
		sDescripcion+=ClienteConstantesFunciones.TELEFONO+"=";
		sDescripcion+=cliente.gettelefono()+",";
		sDescripcion+=ClienteConstantesFunciones.DIRECCION+"=";
		sDescripcion+=cliente.getdireccion()+",";
		sDescripcion+=ClienteConstantesFunciones.ESPROVE+"=";
		sDescripcion+=cliente.getes_prove().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDGRUPOCLIENTE+"=";
		sDescripcion+=cliente.getid_grupo_cliente().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDTITULOCLIENTE+"=";
		sDescripcion+=cliente.getid_titulo_cliente().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDAREACR+"=";
		sDescripcion+=cliente.getid_area_cr().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDESTADOCLIENTE+"=";
		sDescripcion+=cliente.getid_estado_cliente().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.OBSERVACION+"=";
		sDescripcion+=cliente.getobservacion()+",";
		sDescripcion+=ClienteConstantesFunciones.IDPAIS+"=";
		sDescripcion+=cliente.getid_pais().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDREGION+"=";
		sDescripcion+=cliente.getid_region().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDPROVINCIA+"=";
		sDescripcion+=cliente.getid_provincia().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=cliente.getid_ciudad().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDZONA+"=";
		sDescripcion+=cliente.getid_zona().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDPAISNACIONALIDAD+"=";
		sDescripcion+=cliente.getid_pais_nacionalidad().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDTIPOCARGOLABO+"=";
		sDescripcion+=cliente.getid_tipo_cargo_labo().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDTIPONIVELEDU+"=";
		sDescripcion+=cliente.getid_tipo_nivel_edu().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDPROFESION+"=";
		sDescripcion+=cliente.getid_profesion().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDTIPOGENERO+"=";
		sDescripcion+=cliente.getid_tipo_genero().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDESTADOCIVIL+"=";
		sDescripcion+=cliente.getid_estado_civil().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDESTADOLEGAL+"=";
		sDescripcion+=cliente.getid_estado_legal().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.FECHANACIMIENTO+"=";
		sDescripcion+=cliente.getfecha_nacimiento().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.PATHIMAGENFIRMA+"=";
		sDescripcion+=cliente.getpath_imagen_firma()+",";
		sDescripcion+=ClienteConstantesFunciones.CONTACTO+"=";
		sDescripcion+=cliente.getcontacto()+",";
		sDescripcion+=ClienteConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=cliente.getid_cuenta_contable().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDRUTA+"=";
		sDescripcion+=cliente.getid_ruta().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=cliente.getid_vendedor().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDCENTROACTIVIDAD+"=";
		sDescripcion+=cliente.getid_centro_actividad().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.REPRESENTANTE+"=";
		sDescripcion+=cliente.getrepresentante()+",";
		sDescripcion+=ClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA+"=";
		sDescripcion+=cliente.getid_tipo_garantia_empresa().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.NOMBREGARANTIA+"=";
		sDescripcion+=cliente.getnombre_garantia()+",";
		sDescripcion+=ClienteConstantesFunciones.VALORGARANTIA+"=";
		sDescripcion+=cliente.getvalor_garantia().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDCATETIPOAFILIACION+"=";
		sDescripcion+=cliente.getid_cate_tipo_afiliacion().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.NUMEROCARGA+"=";
		sDescripcion+=cliente.getnumero_carga().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.CREDITOUSADO+"=";
		sDescripcion+=cliente.getcredito_usado().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.LIMITECREDITO+"=";
		sDescripcion+=cliente.getlimite_credito().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.CREDITODISPONIBLE+"=";
		sDescripcion+=cliente.getcredito_disponible().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.TOTALDOCUMENTOS+"=";
		sDescripcion+=cliente.gettotal_documentos().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.FECHAULTIMAFACTURA+"=";
		sDescripcion+=cliente.getfecha_ultima_factura().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=cliente.getdescuento().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDDIA+"=";
		sDescripcion+=cliente.getid_dia().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.HORAPAGO+"=";
		sDescripcion+=cliente.gethora_pago().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=cliente.getid_empleado().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.COBRANZAS+"=";
		sDescripcion+=cliente.getcobranzas()+",";
		sDescripcion+=ClienteConstantesFunciones.MOTIVO+"=";
		sDescripcion+=cliente.getmotivo()+",";
		sDescripcion+=ClienteConstantesFunciones.PREFERENCIA+"=";
		sDescripcion+=cliente.getpreferencia()+",";
		sDescripcion+=ClienteConstantesFunciones.CONSEPARACIONBIENES+"=";
		sDescripcion+=cliente.getcon_separacion_bienes().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=cliente.getid_tipo_precio().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.IDTIPOLISTAPRECIO+"=";
		sDescripcion+=cliente.getid_tipo_lista_precio().toString()+",";
		sDescripcion+=ClienteConstantesFunciones.DETALLEESTADO+"=";
		sDescripcion+=cliente.getdetalle_estado()+",";
		sDescripcion+=ClienteConstantesFunciones.ESCONTRIBUYENTEESPECIAL+"=";
		sDescripcion+=cliente.getes_contribuyente_especial().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setClienteDescripcion(Cliente cliente,String sValor) throws Exception {			
		if(cliente !=null) {
			cliente.setnombre_completo(sValor);;//clientecliente.getnombre_completo().trim();
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

	public static String getTipoIdentificacionDescripcion(TipoIdentificacion tipoidentificacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoidentificacion!=null/*&&tipoidentificacion.getId()>0*/) {
			sDescripcion=TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(tipoidentificacion);
		}

		return sDescripcion;
	}

	public static String getGrupoClienteDescripcion(GrupoCliente grupocliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(grupocliente!=null/*&&grupocliente.getId()>0*/) {
			sDescripcion=GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(grupocliente);
		}

		return sDescripcion;
	}

	public static String getTituloClienteDescripcion(TituloCliente titulocliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(titulocliente!=null/*&&titulocliente.getId()>0*/) {
			sDescripcion=TituloClienteConstantesFunciones.getTituloClienteDescripcion(titulocliente);
		}

		return sDescripcion;
	}

	public static String getAreaCrDescripcion(AreaCr areacr) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(areacr!=null/*&&areacr.getId()>0*/) {
			sDescripcion=AreaCrConstantesFunciones.getAreaCrDescripcion(areacr);
		}

		return sDescripcion;
	}

	public static String getEstadoClienteDescripcion(EstadoCliente estadocliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadocliente!=null/*&&estadocliente.getId()>0*/) {
			sDescripcion=EstadoClienteConstantesFunciones.getEstadoClienteDescripcion(estadocliente);
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

	public static String getRegionDescripcion(Region region) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(region!=null/*&&region.getId()>0*/) {
			sDescripcion=RegionConstantesFunciones.getRegionDescripcion(region);
		}

		return sDescripcion;
	}

	public static String getProvinciaDescripcion(Provincia provincia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(provincia!=null/*&&provincia.getId()>0*/) {
			sDescripcion=ProvinciaConstantesFunciones.getProvinciaDescripcion(provincia);
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

	public static String getTipoCargoLaboDescripcion(TipoCargoLabo tipocargolabo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocargolabo!=null/*&&tipocargolabo.getId()>0*/) {
			sDescripcion=TipoCargoLaboConstantesFunciones.getTipoCargoLaboDescripcion(tipocargolabo);
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

	public static String getProfesionDescripcion(Profesion profesion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(profesion!=null/*&&profesion.getId()>0*/) {
			sDescripcion=ProfesionConstantesFunciones.getProfesionDescripcion(profesion);
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

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getRutaDescripcion(Ruta ruta) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ruta!=null/*&&ruta.getId()>0*/) {
			sDescripcion=RutaConstantesFunciones.getRutaDescripcion(ruta);
		}

		return sDescripcion;
	}

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}

	public static String getCentroActividadDescripcion(CentroActividad centroactividad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centroactividad!=null/*&&centroactividad.getId()>0*/) {
			sDescripcion=CentroActividadConstantesFunciones.getCentroActividadDescripcion(centroactividad);
		}

		return sDescripcion;
	}

	public static String getTipoGarantiaEmpresaDescripcion(TipoGarantiaEmpresa tipogarantiaempresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipogarantiaempresa!=null/*&&tipogarantiaempresa.getId()>0*/) {
			sDescripcion=TipoGarantiaEmpresaConstantesFunciones.getTipoGarantiaEmpresaDescripcion(tipogarantiaempresa);
		}

		return sDescripcion;
	}

	public static String getCateTipoAfiliacionDescripcion(CateTipoAfiliacion catetipoafiliacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(catetipoafiliacion!=null/*&&catetipoafiliacion.getId()>0*/) {
			sDescripcion=CateTipoAfiliacionConstantesFunciones.getCateTipoAfiliacionDescripcion(catetipoafiliacion);
		}

		return sDescripcion;
	}

	public static String getDiaDescripcion(Dia dia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(dia!=null/*&&dia.getId()>0*/) {
			sDescripcion=DiaConstantesFunciones.getDiaDescripcion(dia);
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

	public static String getTipoPrecioDescripcion(TipoPrecio tipoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprecio!=null/*&&tipoprecio.getId()>0*/) {
			sDescripcion=TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(tipoprecio);
		}

		return sDescripcion;
	}

	public static String getTipoListaPrecioDescripcion(TipoListaPrecio tipolistaprecio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipolistaprecio!=null/*&&tipolistaprecio.getId()>0*/) {
			sDescripcion=TipoListaPrecioConstantesFunciones.getTipoListaPrecioDescripcion(tipolistaprecio);
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
		} else if(sNombreIndice.equals("BusquedaPorNombreComercial")) {
			sNombreIndice="Tipo=  Por Nombre Comercial";
		} else if(sNombreIndice.equals("BusquedaPorNombreCompleto")) {
			sNombreIndice="Tipo=  Por Nombre Completo";
		} else if(sNombreIndice.equals("FK_IdAreaCr")) {
			sNombreIndice="Tipo=  Por Area";
		} else if(sNombreIndice.equals("FK_IdCateTipoAfiliacion")) {
			sNombreIndice="Tipo=  Por Categoria Afiliacion";
		} else if(sNombreIndice.equals("FK_IdCentroActividad")) {
			sNombreIndice="Tipo=  Por Centro Activad";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdDia")) {
			sNombreIndice="Tipo=  Por Dia Pago";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoCivil")) {
			sNombreIndice="Tipo=  Por Estado Civil";
		} else if(sNombreIndice.equals("FK_IdEstadoCliente")) {
			sNombreIndice="Tipo=  Por Estado Cliente";
		} else if(sNombreIndice.equals("FK_IdEstadoLegal")) {
			sNombreIndice="Tipo=  Por Estado Legal";
		} else if(sNombreIndice.equals("FK_IdGrupoCliente")) {
			sNombreIndice="Tipo=  Por Grupo Cliente";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdPaisNacionalad")) {
			sNombreIndice="Tipo=  Por Pais Nacionalidad";
		} else if(sNombreIndice.equals("FK_IdProfesion")) {
			sNombreIndice="Tipo=  Por Profesion";
		} else if(sNombreIndice.equals("FK_IdProvincia")) {
			sNombreIndice="Tipo=  Por Provincia";
		} else if(sNombreIndice.equals("FK_IdRegion")) {
			sNombreIndice="Tipo=  Por Region";
		} else if(sNombreIndice.equals("FK_IdRuta")) {
			sNombreIndice="Tipo=  Por Ruta";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCargoLabo")) {
			sNombreIndice="Tipo=  Por Tipo Cargo Laboral";
		} else if(sNombreIndice.equals("FK_IdTipoGarantiaEmpresa")) {
			sNombreIndice="Tipo=  Por Tipo Garantia";
		} else if(sNombreIndice.equals("FK_IdTipoGenero")) {
			sNombreIndice="Tipo=  Por Tipo Genero";
		} else if(sNombreIndice.equals("FK_IdTipoIdentificacion")) {
			sNombreIndice="Tipo=  Por Tipo Identificacion";
		} else if(sNombreIndice.equals("FK_IdTipoListaPrecio")) {
			sNombreIndice="Tipo=  Por Tipo Lista Precio";
		} else if(sNombreIndice.equals("FK_IdTipoNivelEdu")) {
			sNombreIndice="Tipo=  Por Tipo Nivel Educativo";
		} else if(sNombreIndice.equals("FK_IdTipoPrecio")) {
			sNombreIndice="Tipo=  Por Tipo Precio";
		} else if(sNombreIndice.equals("FK_IdTituloCliente")) {
			sNombreIndice="Tipo=  Por Titulo Cliente";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
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

	public static String getDetalleIndiceBusquedaPorNombreComercial(String nombre_comercial) {
		String sDetalleIndice=" Parametros->";
		if(nombre_comercial!=null) {sDetalleIndice+=" Nombre Comercial="+nombre_comercial;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombreCompleto(String nombre_completo) {
		String sDetalleIndice=" Parametros->";
		if(nombre_completo!=null) {sDetalleIndice+=" Nombre Completo="+nombre_completo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAreaCr(Long id_area_cr) {
		String sDetalleIndice=" Parametros->";
		if(id_area_cr!=null) {sDetalleIndice+=" Codigo Unico De Area="+id_area_cr.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCateTipoAfiliacion(Long id_cate_tipo_afiliacion) {
		String sDetalleIndice=" Parametros->";
		if(id_cate_tipo_afiliacion!=null) {sDetalleIndice+=" Codigo Unico De Categoria Afiliacion="+id_cate_tipo_afiliacion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroActividad(Long id_centro_actividad) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_actividad!=null) {sDetalleIndice+=" Codigo Unico De Centro Activad="+id_centro_actividad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDia(Long id_dia) {
		String sDetalleIndice=" Parametros->";
		if(id_dia!=null) {sDetalleIndice+=" Codigo Unico De Dia Pago="+id_dia.toString();} 

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

	public static String getDetalleIndiceFK_IdEstadoCivil(Long id_estado_civil) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_civil!=null) {sDetalleIndice+=" Codigo Unico De Estado Civil="+id_estado_civil.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoCliente(Long id_estado_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_cliente!=null) {sDetalleIndice+=" Codigo Unico De Estado Cliente="+id_estado_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoLegal(Long id_estado_legal) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_legal!=null) {sDetalleIndice+=" Codigo Unico De Estado Legal="+id_estado_legal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdGrupoCliente(Long id_grupo_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Grupo Cliente="+id_grupo_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPaisNacionalad(Long id_pais_nacionalidad) {
		String sDetalleIndice=" Parametros->";
		if(id_pais_nacionalidad!=null) {sDetalleIndice+=" Codigo Unico De Pais Nacionalidad="+id_pais_nacionalidad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProfesion(Long id_profesion) {
		String sDetalleIndice=" Parametros->";
		if(id_profesion!=null) {sDetalleIndice+=" Codigo Unico De Profesion="+id_profesion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProvincia(Long id_provincia) {
		String sDetalleIndice=" Parametros->";
		if(id_provincia!=null) {sDetalleIndice+=" Codigo Unico De Provincia="+id_provincia.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRegion(Long id_region) {
		String sDetalleIndice=" Parametros->";
		if(id_region!=null) {sDetalleIndice+=" Codigo Unico De Region="+id_region.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRuta(Long id_ruta) {
		String sDetalleIndice=" Parametros->";
		if(id_ruta!=null) {sDetalleIndice+=" Codigo Unico De Ruta="+id_ruta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCargoLabo(Long id_tipo_cargo_labo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cargo_labo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cargo Laboral="+id_tipo_cargo_labo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoGarantiaEmpresa(Long id_tipo_garantia_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_garantia_empresa!=null) {sDetalleIndice+=" Codigo Unico De Tipo Garantia="+id_tipo_garantia_empresa.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoListaPrecio(Long id_tipo_lista_precio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_lista_precio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Lista Precio="+id_tipo_lista_precio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoNivelEdu(Long id_tipo_nivel_edu) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_nivel_edu!=null) {sDetalleIndice+=" Codigo Unico De Tipo Nivel Educativo="+id_tipo_nivel_edu.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPrecio(Long id_tipo_precio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_precio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Precio="+id_tipo_precio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTituloCliente(Long id_titulo_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_titulo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Titulo Cliente="+id_titulo_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdZona(Long id_zona) {
		String sDetalleIndice=" Parametros->";
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCliente(Cliente cliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cliente.setcodigo(cliente.getcodigo().trim());
		cliente.setidentificacion(cliente.getidentificacion().trim());
		cliente.setruc(cliente.getruc().trim());
		cliente.setnombre(cliente.getnombre().trim());
		cliente.setapellido(cliente.getapellido().trim());
		cliente.setnombre_completo(cliente.getnombre_completo().trim());
		cliente.setnombre_comercial(cliente.getnombre_comercial().trim());
		cliente.settelefono(cliente.gettelefono().trim());
		cliente.setdireccion(cliente.getdireccion().trim());
		cliente.setobservacion(cliente.getobservacion().trim());
		cliente.setpath_imagen_firma(cliente.getpath_imagen_firma().trim());
		cliente.setcontacto(cliente.getcontacto().trim());
		cliente.setrepresentante(cliente.getrepresentante().trim());
		cliente.setnombre_garantia(cliente.getnombre_garantia().trim());
		cliente.setcobranzas(cliente.getcobranzas().trim());
		cliente.setmotivo(cliente.getmotivo().trim());
		cliente.setpreferencia(cliente.getpreferencia().trim());
		cliente.setdetalle_estado(cliente.getdetalle_estado().trim());
	}
	
	public static void quitarEspaciosClientes(List<Cliente> clientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Cliente cliente: clientes) {
			cliente.setcodigo(cliente.getcodigo().trim());
			cliente.setidentificacion(cliente.getidentificacion().trim());
			cliente.setruc(cliente.getruc().trim());
			cliente.setnombre(cliente.getnombre().trim());
			cliente.setapellido(cliente.getapellido().trim());
			cliente.setnombre_completo(cliente.getnombre_completo().trim());
			cliente.setnombre_comercial(cliente.getnombre_comercial().trim());
			cliente.settelefono(cliente.gettelefono().trim());
			cliente.setdireccion(cliente.getdireccion().trim());
			cliente.setobservacion(cliente.getobservacion().trim());
			cliente.setpath_imagen_firma(cliente.getpath_imagen_firma().trim());
			cliente.setcontacto(cliente.getcontacto().trim());
			cliente.setrepresentante(cliente.getrepresentante().trim());
			cliente.setnombre_garantia(cliente.getnombre_garantia().trim());
			cliente.setcobranzas(cliente.getcobranzas().trim());
			cliente.setmotivo(cliente.getmotivo().trim());
			cliente.setpreferencia(cliente.getpreferencia().trim());
			cliente.setdetalle_estado(cliente.getdetalle_estado().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCliente(Cliente cliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cliente.getConCambioAuxiliar()) {
			cliente.setIsDeleted(cliente.getIsDeletedAuxiliar());	
			cliente.setIsNew(cliente.getIsNewAuxiliar());	
			cliente.setIsChanged(cliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cliente.setIsDeletedAuxiliar(false);	
			cliente.setIsNewAuxiliar(false);	
			cliente.setIsChangedAuxiliar(false);
			
			cliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresClientes(List<Cliente> clientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Cliente cliente : clientes) {
			if(conAsignarBase && cliente.getConCambioAuxiliar()) {
				cliente.setIsDeleted(cliente.getIsDeletedAuxiliar());	
				cliente.setIsNew(cliente.getIsNewAuxiliar());	
				cliente.setIsChanged(cliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cliente.setIsDeletedAuxiliar(false);	
				cliente.setIsNewAuxiliar(false);	
				cliente.setIsChangedAuxiliar(false);
				
				cliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCliente(Cliente cliente,Boolean conEnteros) throws Exception  {
		cliente.setvalor_garantia(0.0);
		cliente.setcredito_usado(0.0);
		cliente.setlimite_credito(0.0);
		cliente.setcredito_disponible(0.0);
		cliente.settotal_documentos(0.0);
		cliente.setdescuento(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			cliente.setnumero_carga(0);
		}
	}		
	
	public static void InicializarValoresClientes(List<Cliente> clientes,Boolean conEnteros) throws Exception  {
		
		for(Cliente cliente: clientes) {
			cliente.setvalor_garantia(0.0);
			cliente.setcredito_usado(0.0);
			cliente.setlimite_credito(0.0);
			cliente.setcredito_disponible(0.0);
			cliente.settotal_documentos(0.0);
			cliente.setdescuento(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				cliente.setnumero_carga(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaCliente(List<Cliente> clientes,Cliente clienteAux) throws Exception  {
		ClienteConstantesFunciones.InicializarValoresCliente(clienteAux,true);
		
		for(Cliente cliente: clientes) {
			if(cliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			clienteAux.setvalor_garantia(clienteAux.getvalor_garantia()+cliente.getvalor_garantia());			
			clienteAux.setnumero_carga(clienteAux.getnumero_carga()+cliente.getnumero_carga());			
			clienteAux.setcredito_usado(clienteAux.getcredito_usado()+cliente.getcredito_usado());			
			clienteAux.setlimite_credito(clienteAux.getlimite_credito()+cliente.getlimite_credito());			
			clienteAux.setcredito_disponible(clienteAux.getcredito_disponible()+cliente.getcredito_disponible());			
			clienteAux.settotal_documentos(clienteAux.gettotal_documentos()+cliente.gettotal_documentos());			
			clienteAux.setdescuento(clienteAux.getdescuento()+cliente.getdescuento());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ClienteConstantesFunciones.getArrayColumnasGlobalesCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ClienteConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ClienteConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ClienteConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Cliente> clientes,Cliente cliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Cliente clienteAux: clientes) {
			if(clienteAux!=null && cliente!=null) {
				if((clienteAux.getId()==null && cliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(clienteAux.getId()!=null && cliente.getId()!=null){
					if(clienteAux.getId().equals(cliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCliente(List<Cliente> clientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_garantiaTotal=0.0;
		Double credito_usadoTotal=0.0;
		Double limite_creditoTotal=0.0;
		Double credito_disponibleTotal=0.0;
		Double total_documentosTotal=0.0;
		Double descuentoTotal=0.0;
	
		for(Cliente cliente: clientes) {			
			if(cliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_garantiaTotal+=cliente.getvalor_garantia();
			credito_usadoTotal+=cliente.getcredito_usado();
			limite_creditoTotal+=cliente.getlimite_credito();
			credito_disponibleTotal+=cliente.getcredito_disponible();
			total_documentosTotal+=cliente.gettotal_documentos();
			descuentoTotal+=cliente.getdescuento();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ClienteConstantesFunciones.VALORGARANTIA);
		datoGeneral.setsDescripcion(ClienteConstantesFunciones.LABEL_VALORGARANTIA);
		datoGeneral.setdValorDouble(valor_garantiaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ClienteConstantesFunciones.CREDITOUSADO);
		datoGeneral.setsDescripcion(ClienteConstantesFunciones.LABEL_CREDITOUSADO);
		datoGeneral.setdValorDouble(credito_usadoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ClienteConstantesFunciones.LIMITECREDITO);
		datoGeneral.setsDescripcion(ClienteConstantesFunciones.LABEL_LIMITECREDITO);
		datoGeneral.setdValorDouble(limite_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ClienteConstantesFunciones.CREDITODISPONIBLE);
		datoGeneral.setsDescripcion(ClienteConstantesFunciones.LABEL_CREDITODISPONIBLE);
		datoGeneral.setdValorDouble(credito_disponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ClienteConstantesFunciones.TOTALDOCUMENTOS);
		datoGeneral.setsDescripcion(ClienteConstantesFunciones.LABEL_TOTALDOCUMENTOS);
		datoGeneral.setdValorDouble(total_documentosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ClienteConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(ClienteConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_ID, ClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_VERSIONROW, ClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDEMPRESA, ClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDSUCURSAL, ClienteConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_CODIGO, ClienteConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDTIPOIDENTIFICACION, ClienteConstantesFunciones.IDTIPOIDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDENTIFICACION, ClienteConstantesFunciones.IDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_RUC, ClienteConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_NOMBRE, ClienteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_APELLIDO, ClienteConstantesFunciones.APELLIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_NOMBRECOMPLETO, ClienteConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_NOMBRECOMERCIAL, ClienteConstantesFunciones.NOMBRECOMERCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_TELEFONO, ClienteConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_DIRECCION, ClienteConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_ESPROVE, ClienteConstantesFunciones.ESPROVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDGRUPOCLIENTE, ClienteConstantesFunciones.IDGRUPOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDTITULOCLIENTE, ClienteConstantesFunciones.IDTITULOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDAREACR, ClienteConstantesFunciones.IDAREACR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDESTADOCLIENTE, ClienteConstantesFunciones.IDESTADOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_OBSERVACION, ClienteConstantesFunciones.OBSERVACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDPAIS, ClienteConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDREGION, ClienteConstantesFunciones.IDREGION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDPROVINCIA, ClienteConstantesFunciones.IDPROVINCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDCIUDAD, ClienteConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDZONA, ClienteConstantesFunciones.IDZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDPAISNACIONALIDAD, ClienteConstantesFunciones.IDPAISNACIONALIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDTIPOCARGOLABO, ClienteConstantesFunciones.IDTIPOCARGOLABO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDTIPONIVELEDU, ClienteConstantesFunciones.IDTIPONIVELEDU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDPROFESION, ClienteConstantesFunciones.IDPROFESION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDTIPOGENERO, ClienteConstantesFunciones.IDTIPOGENERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDESTADOCIVIL, ClienteConstantesFunciones.IDESTADOCIVIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDESTADOLEGAL, ClienteConstantesFunciones.IDESTADOLEGAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_FECHANACIMIENTO, ClienteConstantesFunciones.FECHANACIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_PATHIMAGENFIRMA, ClienteConstantesFunciones.PATHIMAGENFIRMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_CONTACTO, ClienteConstantesFunciones.CONTACTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDCUENTACONTABLE, ClienteConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDRUTA, ClienteConstantesFunciones.IDRUTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDVENDEDOR, ClienteConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDCENTROACTIVIDAD, ClienteConstantesFunciones.IDCENTROACTIVIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_REPRESENTANTE, ClienteConstantesFunciones.REPRESENTANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDTIPOGARANTIAEMPRESA, ClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_NOMBREGARANTIA, ClienteConstantesFunciones.NOMBREGARANTIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_VALORGARANTIA, ClienteConstantesFunciones.VALORGARANTIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDCATETIPOAFILIACION, ClienteConstantesFunciones.IDCATETIPOAFILIACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_NUMEROCARGA, ClienteConstantesFunciones.NUMEROCARGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_CREDITOUSADO, ClienteConstantesFunciones.CREDITOUSADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_LIMITECREDITO, ClienteConstantesFunciones.LIMITECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_CREDITODISPONIBLE, ClienteConstantesFunciones.CREDITODISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_TOTALDOCUMENTOS, ClienteConstantesFunciones.TOTALDOCUMENTOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_FECHAULTIMAFACTURA, ClienteConstantesFunciones.FECHAULTIMAFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_DESCUENTO, ClienteConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDDIA, ClienteConstantesFunciones.IDDIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_HORAPAGO, ClienteConstantesFunciones.HORAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDEMPLEADO, ClienteConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_COBRANZAS, ClienteConstantesFunciones.COBRANZAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_MOTIVO, ClienteConstantesFunciones.MOTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_PREFERENCIA, ClienteConstantesFunciones.PREFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_CONSEPARACIONBIENES, ClienteConstantesFunciones.CONSEPARACIONBIENES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDTIPOPRECIO, ClienteConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_IDTIPOLISTAPRECIO, ClienteConstantesFunciones.IDTIPOLISTAPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_DETALLEESTADO, ClienteConstantesFunciones.DETALLEESTADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ClienteConstantesFunciones.LABEL_ESCONTRIBUYENTEESPECIAL, ClienteConstantesFunciones.ESCONTRIBUYENTEESPECIAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDTIPOIDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.APELLIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.NOMBRECOMERCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.ESPROVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDGRUPOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDTITULOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDAREACR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDESTADOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.OBSERVACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDREGION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDPROVINCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDPAISNACIONALIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDTIPOCARGOLABO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDTIPONIVELEDU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDPROFESION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDTIPOGENERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDESTADOCIVIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDESTADOLEGAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.FECHANACIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.PATHIMAGENFIRMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.CONTACTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDRUTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDCENTROACTIVIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.REPRESENTANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.NOMBREGARANTIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.VALORGARANTIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDCATETIPOAFILIACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.NUMEROCARGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.CREDITOUSADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.LIMITECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.CREDITODISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.TOTALDOCUMENTOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.FECHAULTIMAFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDDIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.HORAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.COBRANZAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.MOTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.PREFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.CONSEPARACIONBIENES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.IDTIPOLISTAPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.DETALLEESTADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ClienteConstantesFunciones.ESCONTRIBUYENTEESPECIAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCliente() throws Exception  {
		return ClienteConstantesFunciones.getTiposSeleccionarCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCliente(Boolean conFk) throws Exception  {
		return ClienteConstantesFunciones.getTiposSeleccionarCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDENTIFICACION);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_APELLIDO);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_APELLIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_NOMBRECOMERCIAL);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_NOMBRECOMERCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_ESPROVE);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_ESPROVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDGRUPOCLIENTE);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDTITULOCLIENTE);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDTITULOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDAREACR);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDAREACR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDESTADOCLIENTE);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDESTADOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_OBSERVACION);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_OBSERVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDREGION);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDREGION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDPROVINCIA);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDPROVINCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDZONA);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDPAISNACIONALIDAD);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDPAISNACIONALIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDTIPOCARGOLABO);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDTIPOCARGOLABO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDTIPONIVELEDU);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDTIPONIVELEDU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDPROFESION);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDPROFESION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDTIPOGENERO);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDTIPOGENERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDESTADOCIVIL);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDESTADOCIVIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDESTADOLEGAL);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDESTADOLEGAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_FECHANACIMIENTO);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_FECHANACIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_PATHIMAGENFIRMA);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_PATHIMAGENFIRMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_CONTACTO);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_CONTACTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDRUTA);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDRUTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDCENTROACTIVIDAD);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDCENTROACTIVIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_REPRESENTANTE);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_REPRESENTANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDTIPOGARANTIAEMPRESA);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDTIPOGARANTIAEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_NOMBREGARANTIA);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_NOMBREGARANTIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_VALORGARANTIA);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_VALORGARANTIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDCATETIPOAFILIACION);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDCATETIPOAFILIACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_NUMEROCARGA);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_NUMEROCARGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_CREDITOUSADO);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_CREDITOUSADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_LIMITECREDITO);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_LIMITECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_CREDITODISPONIBLE);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_CREDITODISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_TOTALDOCUMENTOS);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_TOTALDOCUMENTOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_FECHAULTIMAFACTURA);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_FECHAULTIMAFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDDIA);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDDIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(ClienteConstantesFunciones.LABEL_HORAPAGO);
		reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_HORAPAGO);

		arrTiposSeleccionarTodos.add(reporte);
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_COBRANZAS);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_COBRANZAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_MOTIVO);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_MOTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_PREFERENCIA);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_PREFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_CONSEPARACIONBIENES);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_CONSEPARACIONBIENES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_IDTIPOLISTAPRECIO);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_IDTIPOLISTAPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_DETALLEESTADO);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_DETALLEESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ClienteConstantesFunciones.LABEL_ESCONTRIBUYENTEESPECIAL);
			reporte.setsDescripcion(ClienteConstantesFunciones.LABEL_ESCONTRIBUYENTEESPECIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCliente(Cliente clienteAux) throws Exception {
		
			clienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(clienteAux.getEmpresa()));
			clienteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(clienteAux.getSucursal()));
			clienteAux.settipoidentificacion_descripcion(TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(clienteAux.getTipoIdentificacion()));
			clienteAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(clienteAux.getGrupoCliente()));
			clienteAux.settitulocliente_descripcion(TituloClienteConstantesFunciones.getTituloClienteDescripcion(clienteAux.getTituloCliente()));
			clienteAux.setareacr_descripcion(AreaCrConstantesFunciones.getAreaCrDescripcion(clienteAux.getAreaCr()));
			clienteAux.setestadocliente_descripcion(EstadoClienteConstantesFunciones.getEstadoClienteDescripcion(clienteAux.getEstadoCliente()));
			clienteAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(clienteAux.getPais()));
			clienteAux.setregion_descripcion(RegionConstantesFunciones.getRegionDescripcion(clienteAux.getRegion()));
			clienteAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(clienteAux.getProvincia()));
			clienteAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(clienteAux.getCiudad()));
			clienteAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(clienteAux.getZona()));
			clienteAux.setpaisnacionalidad_descripcion(PaisConstantesFunciones.getPaisDescripcion(clienteAux.getPaisNacionalidad()));
			clienteAux.settipocargolabo_descripcion(TipoCargoLaboConstantesFunciones.getTipoCargoLaboDescripcion(clienteAux.getTipoCargoLabo()));
			clienteAux.settiponiveledu_descripcion(TipoNivelEduConstantesFunciones.getTipoNivelEduDescripcion(clienteAux.getTipoNivelEdu()));
			clienteAux.setprofesion_descripcion(ProfesionConstantesFunciones.getProfesionDescripcion(clienteAux.getProfesion()));
			clienteAux.settipogenero_descripcion(TipoGeneroConstantesFunciones.getTipoGeneroDescripcion(clienteAux.getTipoGenero()));
			clienteAux.setestadocivil_descripcion(EstadoCivilConstantesFunciones.getEstadoCivilDescripcion(clienteAux.getEstadoCivil()));
			clienteAux.setestadolegal_descripcion(EstadoLegalConstantesFunciones.getEstadoLegalDescripcion(clienteAux.getEstadoLegal()));
			clienteAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(clienteAux.getCuentaContable()));
			clienteAux.setruta_descripcion(RutaConstantesFunciones.getRutaDescripcion(clienteAux.getRuta()));
			clienteAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(clienteAux.getVendedor()));
			clienteAux.setcentroactividad_descripcion(CentroActividadConstantesFunciones.getCentroActividadDescripcion(clienteAux.getCentroActividad()));
			clienteAux.settipogarantiaempresa_descripcion(TipoGarantiaEmpresaConstantesFunciones.getTipoGarantiaEmpresaDescripcion(clienteAux.getTipoGarantiaEmpresa()));
			clienteAux.setcatetipoafiliacion_descripcion(CateTipoAfiliacionConstantesFunciones.getCateTipoAfiliacionDescripcion(clienteAux.getCateTipoAfiliacion()));
			clienteAux.setdia_descripcion(DiaConstantesFunciones.getDiaDescripcion(clienteAux.getDia()));
			clienteAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(clienteAux.getEmpleado()));
			clienteAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(clienteAux.getTipoPrecio()));
			clienteAux.settipolistaprecio_descripcion(TipoListaPrecioConstantesFunciones.getTipoListaPrecioDescripcion(clienteAux.getTipoListaPrecio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCliente(List<Cliente> clientesTemp) throws Exception {
		for(Cliente clienteAux:clientesTemp) {
			
			clienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(clienteAux.getEmpresa()));
			clienteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(clienteAux.getSucursal()));
			clienteAux.settipoidentificacion_descripcion(TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(clienteAux.getTipoIdentificacion()));
			clienteAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(clienteAux.getGrupoCliente()));
			clienteAux.settitulocliente_descripcion(TituloClienteConstantesFunciones.getTituloClienteDescripcion(clienteAux.getTituloCliente()));
			clienteAux.setareacr_descripcion(AreaCrConstantesFunciones.getAreaCrDescripcion(clienteAux.getAreaCr()));
			clienteAux.setestadocliente_descripcion(EstadoClienteConstantesFunciones.getEstadoClienteDescripcion(clienteAux.getEstadoCliente()));
			clienteAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(clienteAux.getPais()));
			clienteAux.setregion_descripcion(RegionConstantesFunciones.getRegionDescripcion(clienteAux.getRegion()));
			clienteAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(clienteAux.getProvincia()));
			clienteAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(clienteAux.getCiudad()));
			clienteAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(clienteAux.getZona()));
			clienteAux.setpaisnacionalidad_descripcion(PaisConstantesFunciones.getPaisDescripcion(clienteAux.getPaisNacionalidad()));
			clienteAux.settipocargolabo_descripcion(TipoCargoLaboConstantesFunciones.getTipoCargoLaboDescripcion(clienteAux.getTipoCargoLabo()));
			clienteAux.settiponiveledu_descripcion(TipoNivelEduConstantesFunciones.getTipoNivelEduDescripcion(clienteAux.getTipoNivelEdu()));
			clienteAux.setprofesion_descripcion(ProfesionConstantesFunciones.getProfesionDescripcion(clienteAux.getProfesion()));
			clienteAux.settipogenero_descripcion(TipoGeneroConstantesFunciones.getTipoGeneroDescripcion(clienteAux.getTipoGenero()));
			clienteAux.setestadocivil_descripcion(EstadoCivilConstantesFunciones.getEstadoCivilDescripcion(clienteAux.getEstadoCivil()));
			clienteAux.setestadolegal_descripcion(EstadoLegalConstantesFunciones.getEstadoLegalDescripcion(clienteAux.getEstadoLegal()));
			clienteAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(clienteAux.getCuentaContable()));
			clienteAux.setruta_descripcion(RutaConstantesFunciones.getRutaDescripcion(clienteAux.getRuta()));
			clienteAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(clienteAux.getVendedor()));
			clienteAux.setcentroactividad_descripcion(CentroActividadConstantesFunciones.getCentroActividadDescripcion(clienteAux.getCentroActividad()));
			clienteAux.settipogarantiaempresa_descripcion(TipoGarantiaEmpresaConstantesFunciones.getTipoGarantiaEmpresaDescripcion(clienteAux.getTipoGarantiaEmpresa()));
			clienteAux.setcatetipoafiliacion_descripcion(CateTipoAfiliacionConstantesFunciones.getCateTipoAfiliacionDescripcion(clienteAux.getCateTipoAfiliacion()));
			clienteAux.setdia_descripcion(DiaConstantesFunciones.getDiaDescripcion(clienteAux.getDia()));
			clienteAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(clienteAux.getEmpleado()));
			clienteAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(clienteAux.getTipoPrecio()));
			clienteAux.settipolistaprecio_descripcion(TipoListaPrecioConstantesFunciones.getTipoListaPrecioDescripcion(clienteAux.getTipoListaPrecio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TipoIdentificacion.class));
				classes.add(new Classe(GrupoCliente.class));
				classes.add(new Classe(TituloCliente.class));
				classes.add(new Classe(AreaCr.class));
				classes.add(new Classe(EstadoCliente.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Region.class));
				classes.add(new Classe(Provincia.class));
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(Zona.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(TipoCargoLabo.class));
				classes.add(new Classe(TipoNivelEdu.class));
				classes.add(new Classe(Profesion.class));
				classes.add(new Classe(TipoGenero.class));
				classes.add(new Classe(EstadoCivil.class));
				classes.add(new Classe(EstadoLegal.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Ruta.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(CentroActividad.class));
				classes.add(new Classe(TipoGarantiaEmpresa.class));
				classes.add(new Classe(CateTipoAfiliacion.class));
				classes.add(new Classe(Dia.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(TipoPrecio.class));
				classes.add(new Classe(TipoListaPrecio.class));
				
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
					if(clas.clas.equals(TipoIdentificacion.class)) {
						classes.add(new Classe(TipoIdentificacion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GrupoCliente.class)) {
						classes.add(new Classe(GrupoCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TituloCliente.class)) {
						classes.add(new Classe(TituloCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AreaCr.class)) {
						classes.add(new Classe(AreaCr.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoCliente.class)) {
						classes.add(new Classe(EstadoCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Region.class)) {
						classes.add(new Classe(Region.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Provincia.class)) {
						classes.add(new Classe(Provincia.class));
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
					if(clas.clas.equals(TipoCargoLabo.class)) {
						classes.add(new Classe(TipoCargoLabo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoNivelEdu.class)) {
						classes.add(new Classe(TipoNivelEdu.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Profesion.class)) {
						classes.add(new Classe(Profesion.class));
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
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ruta.class)) {
						classes.add(new Classe(Ruta.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroActividad.class)) {
						classes.add(new Classe(CentroActividad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoGarantiaEmpresa.class)) {
						classes.add(new Classe(TipoGarantiaEmpresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CateTipoAfiliacion.class)) {
						classes.add(new Classe(CateTipoAfiliacion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Dia.class)) {
						classes.add(new Classe(Dia.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrecio.class)) {
						classes.add(new Classe(TipoPrecio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoListaPrecio.class)) {
						classes.add(new Classe(TipoListaPrecio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoIdentificacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIdentificacion.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(TituloCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TituloCliente.class)); continue;
					}

					if(AreaCr.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AreaCr.class)); continue;
					}

					if(EstadoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoCliente.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Region.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Region.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
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

					if(TipoCargoLabo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCargoLabo.class)); continue;
					}

					if(TipoNivelEdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoNivelEdu.class)); continue;
					}

					if(Profesion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Profesion.class)); continue;
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

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Ruta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ruta.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(CentroActividad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroActividad.class)); continue;
					}

					if(TipoGarantiaEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGarantiaEmpresa.class)); continue;
					}

					if(CateTipoAfiliacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CateTipoAfiliacion.class)); continue;
					}

					if(Dia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Dia.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(TipoListaPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoListaPrecio.class)); continue;
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

					if(TipoIdentificacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIdentificacion.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(TituloCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TituloCliente.class)); continue;
					}

					if(AreaCr.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AreaCr.class)); continue;
					}

					if(EstadoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoCliente.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Region.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Region.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
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

					if(TipoCargoLabo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCargoLabo.class)); continue;
					}

					if(TipoNivelEdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoNivelEdu.class)); continue;
					}

					if(Profesion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Profesion.class)); continue;
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

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Ruta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ruta.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(CentroActividad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroActividad.class)); continue;
					}

					if(TipoGarantiaEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGarantiaEmpresa.class)); continue;
					}

					if(CateTipoAfiliacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CateTipoAfiliacion.class)); continue;
					}

					if(Dia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Dia.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(TipoListaPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoListaPrecio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ClienteConstantesFunciones.getClassesRelationshipsOfCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(InformacionLaboral.class));
				classes.add(new Classe(Transportista.class));
				classes.add(new Classe(Novedad.class));
				classes.add(new Classe(PoliticasCliente.class));
				classes.add(new Classe(ReferenciaPersonal.class));
				classes.add(new Classe(BalanceGeneralCliente.class));
				classes.add(new Classe(PoliticaCliente.class));
				classes.add(new Classe(VehiculoCliente.class));
				classes.add(new Classe(Responsable.class));
				classes.add(new Classe(InformacionFinanciera.class));
				classes.add(new Classe(Consignatario.class));
				classes.add(new Classe(ClienteImagen.class));
				classes.add(new Classe(GarantiaCliente.class));
				classes.add(new Classe(InformacionEconomica.class));
				classes.add(new Classe(ReferenciaComercial.class));
				classes.add(new Classe(Bien.class));
				classes.add(new Classe(ProveedorProducto.class));
				classes.add(new Classe(ServicioCliente.class));
				classes.add(new Classe(ContactoCliente.class));
				classes.add(new Classe(DatoConstitucion.class));
				classes.add(new Classe(ClienteCoa.class));
				classes.add(new Classe(HobbyCliente.class));
				classes.add(new Classe(CargaFamiliar.class));
				classes.add(new Classe(EMail.class));
				classes.add(new Classe(Conyuge.class));
				classes.add(new Classe(CuentaPorCobrar.class));
				classes.add(new Classe(FirmaCliente.class));
				classes.add(new Classe(RepresentanteLegal.class));
				classes.add(new Classe(Telefono.class));
				classes.add(new Classe(NegocioCliente.class));
				classes.add(new Classe(ReferenciaBancaria.class));
				classes.add(new Classe(Monto.class));
				classes.add(new Classe(ClienteArchivo.class));
				classes.add(new Classe(ActividadEconomica.class));
				classes.add(new Classe(Direccion.class));
				classes.add(new Classe(ChequePostFechado.class));
				classes.add(new Classe(SubCliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(InformacionLaboral.class)) {
						classes.add(new Classe(InformacionLaboral.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transportista.class)) {
						classes.add(new Classe(Transportista.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Novedad.class)) {
						classes.add(new Classe(Novedad.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PoliticasCliente.class)) {
						classes.add(new Classe(PoliticasCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ReferenciaPersonal.class)) {
						classes.add(new Classe(ReferenciaPersonal.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(BalanceGeneralCliente.class)) {
						classes.add(new Classe(BalanceGeneralCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PoliticaCliente.class)) {
						classes.add(new Classe(PoliticaCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(VehiculoCliente.class)) {
						classes.add(new Classe(VehiculoCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Responsable.class)) {
						classes.add(new Classe(Responsable.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(InformacionFinanciera.class)) {
						classes.add(new Classe(InformacionFinanciera.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Consignatario.class)) {
						classes.add(new Classe(Consignatario.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ClienteImagen.class)) {
						classes.add(new Classe(ClienteImagen.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GarantiaCliente.class)) {
						classes.add(new Classe(GarantiaCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(InformacionEconomica.class)) {
						classes.add(new Classe(InformacionEconomica.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ReferenciaComercial.class)) {
						classes.add(new Classe(ReferenciaComercial.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bien.class)) {
						classes.add(new Classe(Bien.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProveedorProducto.class)) {
						classes.add(new Classe(ProveedorProducto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ServicioCliente.class)) {
						classes.add(new Classe(ServicioCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ContactoCliente.class)) {
						classes.add(new Classe(ContactoCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DatoConstitucion.class)) {
						classes.add(new Classe(DatoConstitucion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ClienteCoa.class)) {
						classes.add(new Classe(ClienteCoa.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(HobbyCliente.class)) {
						classes.add(new Classe(HobbyCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CargaFamiliar.class)) {
						classes.add(new Classe(CargaFamiliar.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EMail.class)) {
						classes.add(new Classe(EMail.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Conyuge.class)) {
						classes.add(new Classe(Conyuge.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaPorCobrar.class)) {
						classes.add(new Classe(CuentaPorCobrar.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FirmaCliente.class)) {
						classes.add(new Classe(FirmaCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RepresentanteLegal.class)) {
						classes.add(new Classe(RepresentanteLegal.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Telefono.class)) {
						classes.add(new Classe(Telefono.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NegocioCliente.class)) {
						classes.add(new Classe(NegocioCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ReferenciaBancaria.class)) {
						classes.add(new Classe(ReferenciaBancaria.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Monto.class)) {
						classes.add(new Classe(Monto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ClienteArchivo.class)) {
						classes.add(new Classe(ClienteArchivo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ActividadEconomica.class)) {
						classes.add(new Classe(ActividadEconomica.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Direccion.class)) {
						classes.add(new Classe(Direccion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ChequePostFechado.class)) {
						classes.add(new Classe(ChequePostFechado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubCliente.class)) {
						classes.add(new Classe(SubCliente.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ClienteConstantesFunciones.getClassesRelationshipsFromStringsOfCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(InformacionLaboral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(InformacionLaboral.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(Novedad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Novedad.class)); continue;
					}

					if(PoliticasCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticasCliente.class)); continue;
					}

					if(ReferenciaPersonal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaPersonal.class)); continue;
					}

					if(BalanceGeneralCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(BalanceGeneralCliente.class)); continue;
					}

					if(PoliticaCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticaCliente.class)); continue;
					}

					if(VehiculoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(VehiculoCliente.class)); continue;
					}

					if(Responsable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Responsable.class)); continue;
					}

					if(InformacionFinanciera.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(InformacionFinanciera.class)); continue;
					}

					if(Consignatario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignatario.class)); continue;
					}

					if(ClienteImagen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ClienteImagen.class)); continue;
					}

					if(GarantiaCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GarantiaCliente.class)); continue;
					}

					if(InformacionEconomica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(InformacionEconomica.class)); continue;
					}

					if(ReferenciaComercial.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaComercial.class)); continue;
					}

					if(Bien.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bien.class)); continue;
					}

					if(ProveedorProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProveedorProducto.class)); continue;
					}

					if(ServicioCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ServicioCliente.class)); continue;
					}

					if(ContactoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ContactoCliente.class)); continue;
					}

					if(DatoConstitucion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoConstitucion.class)); continue;
					}

					if(ClienteCoa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ClienteCoa.class)); continue;
					}

					if(HobbyCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HobbyCliente.class)); continue;
					}

					if(CargaFamiliar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargaFamiliar.class)); continue;
					}

					if(EMail.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EMail.class)); continue;
					}

					if(Conyuge.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Conyuge.class)); continue;
					}

					if(CuentaPorCobrar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaPorCobrar.class)); continue;
					}

					if(FirmaCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FirmaCliente.class)); continue;
					}

					if(RepresentanteLegal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RepresentanteLegal.class)); continue;
					}

					if(Telefono.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Telefono.class)); continue;
					}

					if(NegocioCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NegocioCliente.class)); continue;
					}

					if(ReferenciaBancaria.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaBancaria.class)); continue;
					}

					if(Monto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Monto.class)); continue;
					}

					if(ClienteArchivo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ClienteArchivo.class)); continue;
					}

					if(ActividadEconomica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ActividadEconomica.class)); continue;
					}

					if(Direccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Direccion.class)); continue;
					}

					if(ChequePostFechado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ChequePostFechado.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(InformacionLaboral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(InformacionLaboral.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(Novedad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Novedad.class)); continue;
					}

					if(PoliticasCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticasCliente.class)); continue;
					}

					if(ReferenciaPersonal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaPersonal.class)); continue;
					}

					if(BalanceGeneralCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(BalanceGeneralCliente.class)); continue;
					}

					if(PoliticaCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticaCliente.class)); continue;
					}

					if(VehiculoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(VehiculoCliente.class)); continue;
					}

					if(Responsable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Responsable.class)); continue;
					}

					if(InformacionFinanciera.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(InformacionFinanciera.class)); continue;
					}

					if(Consignatario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignatario.class)); continue;
					}

					if(ClienteImagen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ClienteImagen.class)); continue;
					}

					if(GarantiaCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GarantiaCliente.class)); continue;
					}

					if(InformacionEconomica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(InformacionEconomica.class)); continue;
					}

					if(ReferenciaComercial.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaComercial.class)); continue;
					}

					if(Bien.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bien.class)); continue;
					}

					if(ProveedorProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProveedorProducto.class)); continue;
					}

					if(ServicioCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ServicioCliente.class)); continue;
					}

					if(ContactoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ContactoCliente.class)); continue;
					}

					if(DatoConstitucion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoConstitucion.class)); continue;
					}

					if(ClienteCoa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ClienteCoa.class)); continue;
					}

					if(HobbyCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HobbyCliente.class)); continue;
					}

					if(CargaFamiliar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargaFamiliar.class)); continue;
					}

					if(EMail.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EMail.class)); continue;
					}

					if(Conyuge.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Conyuge.class)); continue;
					}

					if(CuentaPorCobrar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaPorCobrar.class)); continue;
					}

					if(FirmaCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FirmaCliente.class)); continue;
					}

					if(RepresentanteLegal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RepresentanteLegal.class)); continue;
					}

					if(Telefono.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Telefono.class)); continue;
					}

					if(NegocioCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NegocioCliente.class)); continue;
					}

					if(ReferenciaBancaria.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ReferenciaBancaria.class)); continue;
					}

					if(Monto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Monto.class)); continue;
					}

					if(ClienteArchivo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ClienteArchivo.class)); continue;
					}

					if(ActividadEconomica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ActividadEconomica.class)); continue;
					}

					if(Direccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Direccion.class)); continue;
					}

					if(ChequePostFechado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ChequePostFechado.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
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
	public static void actualizarLista(Cliente cliente,List<Cliente> clientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Cliente clienteEncontrado=null;
			
			for(Cliente clienteLocal:clientes) {
				if(clienteLocal.getId().equals(cliente.getId())) {
					clienteEncontrado=clienteLocal;
					
					clienteLocal.setIsChanged(cliente.getIsChanged());
					clienteLocal.setIsNew(cliente.getIsNew());
					clienteLocal.setIsDeleted(cliente.getIsDeleted());
					
					clienteLocal.setGeneralEntityOriginal(cliente.getGeneralEntityOriginal());
					
					clienteLocal.setId(cliente.getId());	
					clienteLocal.setVersionRow(cliente.getVersionRow());	
					clienteLocal.setid_empresa(cliente.getid_empresa());	
					clienteLocal.setid_sucursal(cliente.getid_sucursal());	
					clienteLocal.setcodigo(cliente.getcodigo());	
					clienteLocal.setid_tipo_identificacion(cliente.getid_tipo_identificacion());	
					clienteLocal.setidentificacion(cliente.getidentificacion());	
					clienteLocal.setruc(cliente.getruc());	
					clienteLocal.setnombre(cliente.getnombre());	
					clienteLocal.setapellido(cliente.getapellido());	
					clienteLocal.setnombre_completo(cliente.getnombre_completo());	
					clienteLocal.setnombre_comercial(cliente.getnombre_comercial());	
					clienteLocal.settelefono(cliente.gettelefono());	
					clienteLocal.setdireccion(cliente.getdireccion());	
					clienteLocal.setes_prove(cliente.getes_prove());	
					clienteLocal.setid_grupo_cliente(cliente.getid_grupo_cliente());	
					clienteLocal.setid_titulo_cliente(cliente.getid_titulo_cliente());	
					clienteLocal.setid_area_cr(cliente.getid_area_cr());	
					clienteLocal.setid_estado_cliente(cliente.getid_estado_cliente());	
					clienteLocal.setobservacion(cliente.getobservacion());	
					clienteLocal.setid_pais(cliente.getid_pais());	
					clienteLocal.setid_region(cliente.getid_region());	
					clienteLocal.setid_provincia(cliente.getid_provincia());	
					clienteLocal.setid_ciudad(cliente.getid_ciudad());	
					clienteLocal.setid_zona(cliente.getid_zona());	
					clienteLocal.setid_pais_nacionalidad(cliente.getid_pais_nacionalidad());	
					clienteLocal.setid_tipo_cargo_labo(cliente.getid_tipo_cargo_labo());	
					clienteLocal.setid_tipo_nivel_edu(cliente.getid_tipo_nivel_edu());	
					clienteLocal.setid_profesion(cliente.getid_profesion());	
					clienteLocal.setid_tipo_genero(cliente.getid_tipo_genero());	
					clienteLocal.setid_estado_civil(cliente.getid_estado_civil());	
					clienteLocal.setid_estado_legal(cliente.getid_estado_legal());	
					clienteLocal.setfecha_nacimiento(cliente.getfecha_nacimiento());	
					clienteLocal.setpath_imagen_firma(cliente.getpath_imagen_firma());	
					clienteLocal.setcontacto(cliente.getcontacto());	
					clienteLocal.setid_cuenta_contable(cliente.getid_cuenta_contable());	
					clienteLocal.setid_ruta(cliente.getid_ruta());	
					clienteLocal.setid_vendedor(cliente.getid_vendedor());	
					clienteLocal.setid_centro_actividad(cliente.getid_centro_actividad());	
					clienteLocal.setrepresentante(cliente.getrepresentante());	
					clienteLocal.setid_tipo_garantia_empresa(cliente.getid_tipo_garantia_empresa());	
					clienteLocal.setnombre_garantia(cliente.getnombre_garantia());	
					clienteLocal.setvalor_garantia(cliente.getvalor_garantia());	
					clienteLocal.setid_cate_tipo_afiliacion(cliente.getid_cate_tipo_afiliacion());	
					clienteLocal.setnumero_carga(cliente.getnumero_carga());	
					clienteLocal.setcredito_usado(cliente.getcredito_usado());	
					clienteLocal.setlimite_credito(cliente.getlimite_credito());	
					clienteLocal.setcredito_disponible(cliente.getcredito_disponible());	
					clienteLocal.settotal_documentos(cliente.gettotal_documentos());	
					clienteLocal.setfecha_ultima_factura(cliente.getfecha_ultima_factura());	
					clienteLocal.setdescuento(cliente.getdescuento());	
					clienteLocal.setid_dia(cliente.getid_dia());	
					clienteLocal.sethora_pago(cliente.gethora_pago());	
					clienteLocal.setid_empleado(cliente.getid_empleado());	
					clienteLocal.setcobranzas(cliente.getcobranzas());	
					clienteLocal.setmotivo(cliente.getmotivo());	
					clienteLocal.setpreferencia(cliente.getpreferencia());	
					clienteLocal.setcon_separacion_bienes(cliente.getcon_separacion_bienes());	
					clienteLocal.setid_tipo_precio(cliente.getid_tipo_precio());	
					clienteLocal.setid_tipo_lista_precio(cliente.getid_tipo_lista_precio());	
					clienteLocal.setdetalle_estado(cliente.getdetalle_estado());	
					clienteLocal.setes_contribuyente_especial(cliente.getes_contribuyente_especial());	
					
					
					clienteLocal.setContactoClientes(cliente.getContactoClientes());
					clienteLocal.setBiens(cliente.getBiens());
					clienteLocal.setCargaFamiliars(cliente.getCargaFamiliars());
					clienteLocal.setChequePostFechados(cliente.getChequePostFechados());
					clienteLocal.setEMails(cliente.getEMails());
					clienteLocal.setReferenciaPersonals(cliente.getReferenciaPersonals());
					clienteLocal.setGarantiaClientes(cliente.getGarantiaClientes());
					clienteLocal.setClienteArchivos(cliente.getClienteArchivos());
					clienteLocal.setPoliticasCliente(cliente.getPoliticasCliente());
					clienteLocal.setFirmaClientes(cliente.getFirmaClientes());
					clienteLocal.setReferenciaComercials(cliente.getReferenciaComercials());
					clienteLocal.setNovedads(cliente.getNovedads());
					clienteLocal.setInformacionLaborals(cliente.getInformacionLaborals());
					clienteLocal.setInformacionFinancieras(cliente.getInformacionFinancieras());
					clienteLocal.setTelefonos(cliente.getTelefonos());
					clienteLocal.setCuentaPorCobrars(cliente.getCuentaPorCobrars());
					clienteLocal.setResponsables(cliente.getResponsables());
					clienteLocal.setTransportistas(cliente.getTransportistas());
					clienteLocal.setPoliticaClientes(cliente.getPoliticaClientes());
					clienteLocal.setConyuge(cliente.getConyuge());
					clienteLocal.setReferenciaBancarias(cliente.getReferenciaBancarias());
					clienteLocal.setBalanceGeneralClientes(cliente.getBalanceGeneralClientes());
					clienteLocal.setDatoConstitucions(cliente.getDatoConstitucions());
					clienteLocal.setActividadEconomicas(cliente.getActividadEconomicas());
					clienteLocal.setProveedorProductos(cliente.getProveedorProductos());
					clienteLocal.setConsignatarios(cliente.getConsignatarios());
					clienteLocal.setHobbyClientes(cliente.getHobbyClientes());
					clienteLocal.setRepresentanteLegals(cliente.getRepresentanteLegals());
					clienteLocal.setClienteCoas(cliente.getClienteCoas());
					clienteLocal.setDireccions(cliente.getDireccions());
					clienteLocal.setClienteImagens(cliente.getClienteImagens());
					clienteLocal.setSubClientes(cliente.getSubClientes());
					clienteLocal.setServicioClientes(cliente.getServicioClientes());
					clienteLocal.setInformacionEconomicas(cliente.getInformacionEconomicas());
					clienteLocal.setVehiculoClientes(cliente.getVehiculoClientes());
					clienteLocal.setNegocioClientes(cliente.getNegocioClientes());
					clienteLocal.setMontos(cliente.getMontos());
					
					existe=true;
					break;
				}
			}
			
			if(!cliente.getIsDeleted()) {
				if(!existe) {
					clientes.add(cliente);
				}
			} else {
				if(clienteEncontrado!=null && permiteQuitar)  {
					clientes.remove(clienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Cliente cliente,List<Cliente> clientes) throws Exception {
		try	{			
			for(Cliente clienteLocal:clientes) {
				if(clienteLocal.getId().equals(cliente.getId())) {
					clienteLocal.setIsSelected(cliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCliente(List<Cliente> clientesAux) throws Exception {
		//this.clientesAux=clientesAux;
		
		for(Cliente clienteAux:clientesAux) {
			if(clienteAux.getIsChanged()) {
				clienteAux.setIsChanged(false);
			}		
			
			if(clienteAux.getIsNew()) {
				clienteAux.setIsNew(false);
			}	
			
			if(clienteAux.getIsDeleted()) {
				clienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCliente(Cliente clienteAux) throws Exception {
		//this.clienteAux=clienteAux;
		
			if(clienteAux.getIsChanged()) {
				clienteAux.setIsChanged(false);
			}		
			
			if(clienteAux.getIsNew()) {
				clienteAux.setIsNew(false);
			}	
			
			if(clienteAux.getIsDeleted()) {
				clienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Cliente clienteAsignar,Cliente cliente) throws Exception {
		clienteAsignar.setId(cliente.getId());	
		clienteAsignar.setVersionRow(cliente.getVersionRow());	
		clienteAsignar.setid_empresa(cliente.getid_empresa());
		clienteAsignar.setempresa_descripcion(cliente.getempresa_descripcion());	
		clienteAsignar.setid_sucursal(cliente.getid_sucursal());
		clienteAsignar.setsucursal_descripcion(cliente.getsucursal_descripcion());	
		clienteAsignar.setcodigo(cliente.getcodigo());	
		clienteAsignar.setid_tipo_identificacion(cliente.getid_tipo_identificacion());
		clienteAsignar.settipoidentificacion_descripcion(cliente.gettipoidentificacion_descripcion());	
		clienteAsignar.setidentificacion(cliente.getidentificacion());	
		clienteAsignar.setruc(cliente.getruc());	
		clienteAsignar.setnombre(cliente.getnombre());	
		clienteAsignar.setapellido(cliente.getapellido());	
		clienteAsignar.setnombre_completo(cliente.getnombre_completo());	
		clienteAsignar.setnombre_comercial(cliente.getnombre_comercial());	
		clienteAsignar.settelefono(cliente.gettelefono());	
		clienteAsignar.setdireccion(cliente.getdireccion());	
		clienteAsignar.setes_prove(cliente.getes_prove());	
		clienteAsignar.setid_grupo_cliente(cliente.getid_grupo_cliente());
		clienteAsignar.setgrupocliente_descripcion(cliente.getgrupocliente_descripcion());	
		clienteAsignar.setid_titulo_cliente(cliente.getid_titulo_cliente());
		clienteAsignar.settitulocliente_descripcion(cliente.gettitulocliente_descripcion());	
		clienteAsignar.setid_area_cr(cliente.getid_area_cr());
		clienteAsignar.setareacr_descripcion(cliente.getareacr_descripcion());	
		clienteAsignar.setid_estado_cliente(cliente.getid_estado_cliente());
		clienteAsignar.setestadocliente_descripcion(cliente.getestadocliente_descripcion());	
		clienteAsignar.setobservacion(cliente.getobservacion());	
		clienteAsignar.setid_pais(cliente.getid_pais());
		clienteAsignar.setpais_descripcion(cliente.getpais_descripcion());	
		clienteAsignar.setid_region(cliente.getid_region());
		clienteAsignar.setregion_descripcion(cliente.getregion_descripcion());	
		clienteAsignar.setid_provincia(cliente.getid_provincia());
		clienteAsignar.setprovincia_descripcion(cliente.getprovincia_descripcion());	
		clienteAsignar.setid_ciudad(cliente.getid_ciudad());
		clienteAsignar.setciudad_descripcion(cliente.getciudad_descripcion());	
		clienteAsignar.setid_zona(cliente.getid_zona());
		clienteAsignar.setzona_descripcion(cliente.getzona_descripcion());	
		clienteAsignar.setid_pais_nacionalidad(cliente.getid_pais_nacionalidad());
		clienteAsignar.setpaisnacionalidad_descripcion(cliente.getpaisnacionalidad_descripcion());	
		clienteAsignar.setid_tipo_cargo_labo(cliente.getid_tipo_cargo_labo());
		clienteAsignar.settipocargolabo_descripcion(cliente.gettipocargolabo_descripcion());	
		clienteAsignar.setid_tipo_nivel_edu(cliente.getid_tipo_nivel_edu());
		clienteAsignar.settiponiveledu_descripcion(cliente.gettiponiveledu_descripcion());	
		clienteAsignar.setid_profesion(cliente.getid_profesion());
		clienteAsignar.setprofesion_descripcion(cliente.getprofesion_descripcion());	
		clienteAsignar.setid_tipo_genero(cliente.getid_tipo_genero());
		clienteAsignar.settipogenero_descripcion(cliente.gettipogenero_descripcion());	
		clienteAsignar.setid_estado_civil(cliente.getid_estado_civil());
		clienteAsignar.setestadocivil_descripcion(cliente.getestadocivil_descripcion());	
		clienteAsignar.setid_estado_legal(cliente.getid_estado_legal());
		clienteAsignar.setestadolegal_descripcion(cliente.getestadolegal_descripcion());	
		clienteAsignar.setfecha_nacimiento(cliente.getfecha_nacimiento());	
		clienteAsignar.setpath_imagen_firma(cliente.getpath_imagen_firma());	
		clienteAsignar.setcontacto(cliente.getcontacto());	
		clienteAsignar.setid_cuenta_contable(cliente.getid_cuenta_contable());
		clienteAsignar.setcuentacontable_descripcion(cliente.getcuentacontable_descripcion());	
		clienteAsignar.setid_ruta(cliente.getid_ruta());
		clienteAsignar.setruta_descripcion(cliente.getruta_descripcion());	
		clienteAsignar.setid_vendedor(cliente.getid_vendedor());
		clienteAsignar.setvendedor_descripcion(cliente.getvendedor_descripcion());	
		clienteAsignar.setid_centro_actividad(cliente.getid_centro_actividad());
		clienteAsignar.setcentroactividad_descripcion(cliente.getcentroactividad_descripcion());	
		clienteAsignar.setrepresentante(cliente.getrepresentante());	
		clienteAsignar.setid_tipo_garantia_empresa(cliente.getid_tipo_garantia_empresa());
		clienteAsignar.settipogarantiaempresa_descripcion(cliente.gettipogarantiaempresa_descripcion());	
		clienteAsignar.setnombre_garantia(cliente.getnombre_garantia());	
		clienteAsignar.setvalor_garantia(cliente.getvalor_garantia());	
		clienteAsignar.setid_cate_tipo_afiliacion(cliente.getid_cate_tipo_afiliacion());
		clienteAsignar.setcatetipoafiliacion_descripcion(cliente.getcatetipoafiliacion_descripcion());	
		clienteAsignar.setnumero_carga(cliente.getnumero_carga());	
		clienteAsignar.setcredito_usado(cliente.getcredito_usado());	
		clienteAsignar.setlimite_credito(cliente.getlimite_credito());	
		clienteAsignar.setcredito_disponible(cliente.getcredito_disponible());	
		clienteAsignar.settotal_documentos(cliente.gettotal_documentos());	
		clienteAsignar.setfecha_ultima_factura(cliente.getfecha_ultima_factura());	
		clienteAsignar.setdescuento(cliente.getdescuento());	
		clienteAsignar.setid_dia(cliente.getid_dia());
		clienteAsignar.setdia_descripcion(cliente.getdia_descripcion());	
		clienteAsignar.sethora_pago(cliente.gethora_pago());	
		clienteAsignar.setid_empleado(cliente.getid_empleado());
		clienteAsignar.setempleado_descripcion(cliente.getempleado_descripcion());	
		clienteAsignar.setcobranzas(cliente.getcobranzas());	
		clienteAsignar.setmotivo(cliente.getmotivo());	
		clienteAsignar.setpreferencia(cliente.getpreferencia());	
		clienteAsignar.setcon_separacion_bienes(cliente.getcon_separacion_bienes());	
		clienteAsignar.setid_tipo_precio(cliente.getid_tipo_precio());
		clienteAsignar.settipoprecio_descripcion(cliente.gettipoprecio_descripcion());	
		clienteAsignar.setid_tipo_lista_precio(cliente.getid_tipo_lista_precio());
		clienteAsignar.settipolistaprecio_descripcion(cliente.gettipolistaprecio_descripcion());	
		clienteAsignar.setdetalle_estado(cliente.getdetalle_estado());	
		clienteAsignar.setes_contribuyente_especial(cliente.getes_contribuyente_especial());	
	}
	
	public static void inicializarCliente(Cliente cliente) throws Exception {
		try {
				cliente.setId(0L);	
					
				cliente.setid_empresa(-1L);	
				cliente.setid_sucursal(-1L);	
				cliente.setcodigo("");	
				cliente.setid_tipo_identificacion(-1L);	
				cliente.setidentificacion("");	
				cliente.setruc("");	
				cliente.setnombre("");	
				cliente.setapellido("");	
				cliente.setnombre_completo("");	
				cliente.setnombre_comercial("");	
				cliente.settelefono("");	
				cliente.setdireccion("");	
				cliente.setes_prove(false);	
				cliente.setid_grupo_cliente(-1L);	
				cliente.setid_titulo_cliente(-1L);	
				cliente.setid_area_cr(-1L);	
				cliente.setid_estado_cliente(-1L);	
				cliente.setobservacion("");	
				cliente.setid_pais(-1L);	
				cliente.setid_region(-1L);	
				cliente.setid_provincia(-1L);	
				cliente.setid_ciudad(-1L);	
				cliente.setid_zona(-1L);	
				cliente.setid_pais_nacionalidad(-1L);	
				cliente.setid_tipo_cargo_labo(-1L);	
				cliente.setid_tipo_nivel_edu(-1L);	
				cliente.setid_profesion(-1L);	
				cliente.setid_tipo_genero(-1L);	
				cliente.setid_estado_civil(-1L);	
				cliente.setid_estado_legal(-1L);	
				cliente.setfecha_nacimiento(new Date());	
				cliente.setpath_imagen_firma("");	
				cliente.setcontacto("");	
				cliente.setid_cuenta_contable(-1L);	
				cliente.setid_ruta(-1L);	
				cliente.setid_vendedor(-1L);	
				cliente.setid_centro_actividad(null);	
				cliente.setrepresentante("");	
				cliente.setid_tipo_garantia_empresa(-1L);	
				cliente.setnombre_garantia("");	
				cliente.setvalor_garantia(0.0);	
				cliente.setid_cate_tipo_afiliacion(-1L);	
				cliente.setnumero_carga(0);	
				cliente.setcredito_usado(0.0);	
				cliente.setlimite_credito(0.0);	
				cliente.setcredito_disponible(0.0);	
				cliente.settotal_documentos(0.0);	
				cliente.setfecha_ultima_factura(new Date());	
				cliente.setdescuento(0.0);	
				cliente.setid_dia(-1L);	
				cliente.sethora_pago(new Time((new Date()).getTime()));	
				cliente.setid_empleado(-1L);	
				cliente.setcobranzas("");	
				cliente.setmotivo("");	
				cliente.setpreferencia("");	
				cliente.setcon_separacion_bienes(false);	
				cliente.setid_tipo_precio(-1L);	
				cliente.setid_tipo_lista_precio(-1L);	
				cliente.setdetalle_estado("");	
				cliente.setes_contribuyente_especial(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDTIPOIDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_APELLIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_NOMBRECOMERCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_ESPROVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDTITULOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDAREACR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDESTADOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_OBSERVACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDREGION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDPROVINCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDPAISNACIONALIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDTIPOCARGOLABO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDTIPONIVELEDU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDPROFESION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDTIPOGENERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDESTADOCIVIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDESTADOLEGAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_FECHANACIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_PATHIMAGENFIRMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_CONTACTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDRUTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDCENTROACTIVIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_REPRESENTANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDTIPOGARANTIAEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_NOMBREGARANTIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_VALORGARANTIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDCATETIPOAFILIACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_NUMEROCARGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_CREDITOUSADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_LIMITECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_CREDITODISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_TOTALDOCUMENTOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_FECHAULTIMAFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDDIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_HORAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_COBRANZAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_MOTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_PREFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_CONSEPARACIONBIENES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_IDTIPOLISTAPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_DETALLEESTADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ClienteConstantesFunciones.LABEL_ESCONTRIBUYENTEESPECIAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCliente(String sTipo,Row row,Workbook workbook,Cliente cliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.gettipoidentificacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getidentificacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getapellido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getnombre_comercial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cliente.getes_prove()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getgrupocliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.gettitulocliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getareacr_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getestadocliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getobservacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getregion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getprovincia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getzona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getpaisnacionalidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.gettipocargolabo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.gettiponiveledu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getprofesion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.gettipogenero_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getestadocivil_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getestadolegal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getfecha_nacimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getpath_imagen_firma());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getcontacto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getruta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getcentroactividad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getrepresentante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.gettipogarantiaempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getnombre_garantia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getvalor_garantia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getcatetipoafiliacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getnumero_carga());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getcredito_usado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getlimite_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getcredito_disponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.gettotal_documentos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getfecha_ultima_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getdia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.gethora_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getcobranzas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getmotivo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getpreferencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cliente.getcon_separacion_bienes()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.gettipolistaprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cliente.getdetalle_estado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cliente.getes_contribuyente_especial()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCliente() {
		return this.sFinalQueryCliente;
	}
	
	public void setsFinalQueryCliente(String sFinalQueryCliente) {
		this.sFinalQueryCliente= sFinalQueryCliente;
	}
	
	public Border resaltarSeleccionarCliente=null;
	
	public Border setResaltarSeleccionarCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCliente() {
		return this.resaltarSeleccionarCliente;
	}
	
	public void setResaltarSeleccionarCliente(Border borderResaltarSeleccionarCliente) {
		this.resaltarSeleccionarCliente= borderResaltarSeleccionarCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCliente=null;
	public Boolean mostraridCliente=true;
	public Boolean activaridCliente=true;

	public Border resaltarid_empresaCliente=null;
	public Boolean mostrarid_empresaCliente=true;
	public Boolean activarid_empresaCliente=true;
	public Boolean cargarid_empresaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCliente=false;//ConEventDepend=true

	public Border resaltarid_sucursalCliente=null;
	public Boolean mostrarid_sucursalCliente=true;
	public Boolean activarid_sucursalCliente=true;
	public Boolean cargarid_sucursalCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCliente=false;//ConEventDepend=true

	public Border resaltarcodigoCliente=null;
	public Boolean mostrarcodigoCliente=true;
	public Boolean activarcodigoCliente=true;

	public Border resaltarid_tipo_identificacionCliente=null;
	public Boolean mostrarid_tipo_identificacionCliente=true;
	public Boolean activarid_tipo_identificacionCliente=true;
	public Boolean cargarid_tipo_identificacionCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_identificacionCliente=false;//ConEventDepend=true

	public Border resaltaridentificacionCliente=null;
	public Boolean mostraridentificacionCliente=true;
	public Boolean activaridentificacionCliente=true;

	public Border resaltarrucCliente=null;
	public Boolean mostrarrucCliente=true;
	public Boolean activarrucCliente=true;

	public Border resaltarnombreCliente=null;
	public Boolean mostrarnombreCliente=true;
	public Boolean activarnombreCliente=true;

	public Border resaltarapellidoCliente=null;
	public Boolean mostrarapellidoCliente=true;
	public Boolean activarapellidoCliente=true;

	public Border resaltarnombre_completoCliente=null;
	public Boolean mostrarnombre_completoCliente=true;
	public Boolean activarnombre_completoCliente=false;

	public Border resaltarnombre_comercialCliente=null;
	public Boolean mostrarnombre_comercialCliente=true;
	public Boolean activarnombre_comercialCliente=true;

	public Border resaltartelefonoCliente=null;
	public Boolean mostrartelefonoCliente=true;
	public Boolean activartelefonoCliente=true;

	public Border resaltardireccionCliente=null;
	public Boolean mostrardireccionCliente=true;
	public Boolean activardireccionCliente=true;

	public Border resaltares_proveCliente=null;
	public Boolean mostrares_proveCliente=true;
	public Boolean activares_proveCliente=true;

	public Border resaltarid_grupo_clienteCliente=null;
	public Boolean mostrarid_grupo_clienteCliente=true;
	public Boolean activarid_grupo_clienteCliente=true;
	public Boolean cargarid_grupo_clienteCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_clienteCliente=false;//ConEventDepend=true

	public Border resaltarid_titulo_clienteCliente=null;
	public Boolean mostrarid_titulo_clienteCliente=true;
	public Boolean activarid_titulo_clienteCliente=true;
	public Boolean cargarid_titulo_clienteCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_titulo_clienteCliente=false;//ConEventDepend=true

	public Border resaltarid_area_crCliente=null;
	public Boolean mostrarid_area_crCliente=true;
	public Boolean activarid_area_crCliente=true;
	public Boolean cargarid_area_crCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_area_crCliente=false;//ConEventDepend=true

	public Border resaltarid_estado_clienteCliente=null;
	public Boolean mostrarid_estado_clienteCliente=true;
	public Boolean activarid_estado_clienteCliente=true;
	public Boolean cargarid_estado_clienteCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_clienteCliente=false;//ConEventDepend=true

	public Border resaltarobservacionCliente=null;
	public Boolean mostrarobservacionCliente=true;
	public Boolean activarobservacionCliente=true;

	public Border resaltarid_paisCliente=null;
	public Boolean mostrarid_paisCliente=true;
	public Boolean activarid_paisCliente=true;
	public Boolean cargarid_paisCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisCliente=false;//ConEventDepend=true

	public Border resaltarid_regionCliente=null;
	public Boolean mostrarid_regionCliente=true;
	public Boolean activarid_regionCliente=true;
	public Boolean cargarid_regionCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_regionCliente=true;//ConEventDepend=true

	public Border resaltarid_provinciaCliente=null;
	public Boolean mostrarid_provinciaCliente=true;
	public Boolean activarid_provinciaCliente=true;
	public Boolean cargarid_provinciaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_provinciaCliente=true;//ConEventDepend=true

	public Border resaltarid_ciudadCliente=null;
	public Boolean mostrarid_ciudadCliente=true;
	public Boolean activarid_ciudadCliente=true;
	public Boolean cargarid_ciudadCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadCliente=true;//ConEventDepend=true

	public Border resaltarid_zonaCliente=null;
	public Boolean mostrarid_zonaCliente=true;
	public Boolean activarid_zonaCliente=true;
	public Boolean cargarid_zonaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_zonaCliente=false;//ConEventDepend=true

	public Border resaltarid_pais_nacionalidadCliente=null;
	public Boolean mostrarid_pais_nacionalidadCliente=true;
	public Boolean activarid_pais_nacionalidadCliente=true;
	public Boolean cargarid_pais_nacionalidadCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_pais_nacionalidadCliente=false;//ConEventDepend=true

	public Border resaltarid_tipo_cargo_laboCliente=null;
	public Boolean mostrarid_tipo_cargo_laboCliente=true;
	public Boolean activarid_tipo_cargo_laboCliente=true;
	public Boolean cargarid_tipo_cargo_laboCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cargo_laboCliente=false;//ConEventDepend=true

	public Border resaltarid_tipo_nivel_eduCliente=null;
	public Boolean mostrarid_tipo_nivel_eduCliente=true;
	public Boolean activarid_tipo_nivel_eduCliente=true;
	public Boolean cargarid_tipo_nivel_eduCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_nivel_eduCliente=false;//ConEventDepend=true

	public Border resaltarid_profesionCliente=null;
	public Boolean mostrarid_profesionCliente=true;
	public Boolean activarid_profesionCliente=true;
	public Boolean cargarid_profesionCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_profesionCliente=false;//ConEventDepend=true

	public Border resaltarid_tipo_generoCliente=null;
	public Boolean mostrarid_tipo_generoCliente=true;
	public Boolean activarid_tipo_generoCliente=true;
	public Boolean cargarid_tipo_generoCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_generoCliente=false;//ConEventDepend=true

	public Border resaltarid_estado_civilCliente=null;
	public Boolean mostrarid_estado_civilCliente=true;
	public Boolean activarid_estado_civilCliente=true;
	public Boolean cargarid_estado_civilCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_civilCliente=false;//ConEventDepend=true

	public Border resaltarid_estado_legalCliente=null;
	public Boolean mostrarid_estado_legalCliente=true;
	public Boolean activarid_estado_legalCliente=true;
	public Boolean cargarid_estado_legalCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_legalCliente=false;//ConEventDepend=true

	public Border resaltarfecha_nacimientoCliente=null;
	public Boolean mostrarfecha_nacimientoCliente=true;
	public Boolean activarfecha_nacimientoCliente=false;

	public Border resaltarpath_imagen_firmaCliente=null;
	public Boolean mostrarpath_imagen_firmaCliente=true;
	public Boolean activarpath_imagen_firmaCliente=true;

	public Border resaltarcontactoCliente=null;
	public Boolean mostrarcontactoCliente=true;
	public Boolean activarcontactoCliente=true;

	public Border resaltarid_cuenta_contableCliente=null;
	public Boolean mostrarid_cuenta_contableCliente=true;
	public Boolean activarid_cuenta_contableCliente=true;
	public Boolean cargarid_cuenta_contableCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableCliente=false;//ConEventDepend=true

	public Border resaltarid_rutaCliente=null;
	public Boolean mostrarid_rutaCliente=true;
	public Boolean activarid_rutaCliente=true;
	public Boolean cargarid_rutaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_rutaCliente=false;//ConEventDepend=true

	public Border resaltarid_vendedorCliente=null;
	public Boolean mostrarid_vendedorCliente=true;
	public Boolean activarid_vendedorCliente=true;
	public Boolean cargarid_vendedorCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorCliente=false;//ConEventDepend=true

	public Border resaltarid_centro_actividadCliente=null;
	public Boolean mostrarid_centro_actividadCliente=true;
	public Boolean activarid_centro_actividadCliente=true;
	public Boolean cargarid_centro_actividadCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_actividadCliente=false;//ConEventDepend=true

	public Border resaltarrepresentanteCliente=null;
	public Boolean mostrarrepresentanteCliente=true;
	public Boolean activarrepresentanteCliente=true;

	public Border resaltarid_tipo_garantia_empresaCliente=null;
	public Boolean mostrarid_tipo_garantia_empresaCliente=true;
	public Boolean activarid_tipo_garantia_empresaCliente=true;
	public Boolean cargarid_tipo_garantia_empresaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_garantia_empresaCliente=false;//ConEventDepend=true

	public Border resaltarnombre_garantiaCliente=null;
	public Boolean mostrarnombre_garantiaCliente=true;
	public Boolean activarnombre_garantiaCliente=true;

	public Border resaltarvalor_garantiaCliente=null;
	public Boolean mostrarvalor_garantiaCliente=true;
	public Boolean activarvalor_garantiaCliente=true;

	public Border resaltarid_cate_tipo_afiliacionCliente=null;
	public Boolean mostrarid_cate_tipo_afiliacionCliente=true;
	public Boolean activarid_cate_tipo_afiliacionCliente=true;
	public Boolean cargarid_cate_tipo_afiliacionCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cate_tipo_afiliacionCliente=false;//ConEventDepend=true

	public Border resaltarnumero_cargaCliente=null;
	public Boolean mostrarnumero_cargaCliente=true;
	public Boolean activarnumero_cargaCliente=true;

	public Border resaltarcredito_usadoCliente=null;
	public Boolean mostrarcredito_usadoCliente=true;
	public Boolean activarcredito_usadoCliente=true;

	public Border resaltarlimite_creditoCliente=null;
	public Boolean mostrarlimite_creditoCliente=true;
	public Boolean activarlimite_creditoCliente=true;

	public Border resaltarcredito_disponibleCliente=null;
	public Boolean mostrarcredito_disponibleCliente=true;
	public Boolean activarcredito_disponibleCliente=true;

	public Border resaltartotal_documentosCliente=null;
	public Boolean mostrartotal_documentosCliente=true;
	public Boolean activartotal_documentosCliente=true;

	public Border resaltarfecha_ultima_facturaCliente=null;
	public Boolean mostrarfecha_ultima_facturaCliente=true;
	public Boolean activarfecha_ultima_facturaCliente=false;

	public Border resaltardescuentoCliente=null;
	public Boolean mostrardescuentoCliente=true;
	public Boolean activardescuentoCliente=true;

	public Border resaltarid_diaCliente=null;
	public Boolean mostrarid_diaCliente=true;
	public Boolean activarid_diaCliente=true;
	public Boolean cargarid_diaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_diaCliente=false;//ConEventDepend=true

	public Border resaltarhora_pagoCliente=null;
	public Boolean mostrarhora_pagoCliente=true;
	public Boolean activarhora_pagoCliente=true;

	public Border resaltarid_empleadoCliente=null;
	public Boolean mostrarid_empleadoCliente=true;
	public Boolean activarid_empleadoCliente=true;
	public Boolean cargarid_empleadoCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoCliente=false;//ConEventDepend=true

	public Border resaltarcobranzasCliente=null;
	public Boolean mostrarcobranzasCliente=true;
	public Boolean activarcobranzasCliente=true;

	public Border resaltarmotivoCliente=null;
	public Boolean mostrarmotivoCliente=true;
	public Boolean activarmotivoCliente=true;

	public Border resaltarpreferenciaCliente=null;
	public Boolean mostrarpreferenciaCliente=true;
	public Boolean activarpreferenciaCliente=true;

	public Border resaltarcon_separacion_bienesCliente=null;
	public Boolean mostrarcon_separacion_bienesCliente=true;
	public Boolean activarcon_separacion_bienesCliente=true;

	public Border resaltarid_tipo_precioCliente=null;
	public Boolean mostrarid_tipo_precioCliente=true;
	public Boolean activarid_tipo_precioCliente=true;
	public Boolean cargarid_tipo_precioCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioCliente=false;//ConEventDepend=true

	public Border resaltarid_tipo_lista_precioCliente=null;
	public Boolean mostrarid_tipo_lista_precioCliente=true;
	public Boolean activarid_tipo_lista_precioCliente=true;
	public Boolean cargarid_tipo_lista_precioCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_lista_precioCliente=false;//ConEventDepend=true

	public Border resaltardetalle_estadoCliente=null;
	public Boolean mostrardetalle_estadoCliente=true;
	public Boolean activardetalle_estadoCliente=true;

	public Border resaltares_contribuyente_especialCliente=null;
	public Boolean mostrares_contribuyente_especialCliente=true;
	public Boolean activares_contribuyente_especialCliente=true;

	
	

	public Border setResaltaridCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltaridCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCliente() {
		return this.resaltaridCliente;
	}

	public void setResaltaridCliente(Border borderResaltar) {
		this.resaltaridCliente= borderResaltar;
	}

	public Boolean getMostraridCliente() {
		return this.mostraridCliente;
	}

	public void setMostraridCliente(Boolean mostraridCliente) {
		this.mostraridCliente= mostraridCliente;
	}

	public Boolean getActivaridCliente() {
		return this.activaridCliente;
	}

	public void setActivaridCliente(Boolean activaridCliente) {
		this.activaridCliente= activaridCliente;
	}

	public Border setResaltarid_empresaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCliente() {
		return this.resaltarid_empresaCliente;
	}

	public void setResaltarid_empresaCliente(Border borderResaltar) {
		this.resaltarid_empresaCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaCliente() {
		return this.mostrarid_empresaCliente;
	}

	public void setMostrarid_empresaCliente(Boolean mostrarid_empresaCliente) {
		this.mostrarid_empresaCliente= mostrarid_empresaCliente;
	}

	public Boolean getActivarid_empresaCliente() {
		return this.activarid_empresaCliente;
	}

	public void setActivarid_empresaCliente(Boolean activarid_empresaCliente) {
		this.activarid_empresaCliente= activarid_empresaCliente;
	}

	public Boolean getCargarid_empresaCliente() {
		return this.cargarid_empresaCliente;
	}

	public void setCargarid_empresaCliente(Boolean cargarid_empresaCliente) {
		this.cargarid_empresaCliente= cargarid_empresaCliente;
	}

	public Border setResaltarid_sucursalCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCliente() {
		return this.resaltarid_sucursalCliente;
	}

	public void setResaltarid_sucursalCliente(Border borderResaltar) {
		this.resaltarid_sucursalCliente= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCliente() {
		return this.mostrarid_sucursalCliente;
	}

	public void setMostrarid_sucursalCliente(Boolean mostrarid_sucursalCliente) {
		this.mostrarid_sucursalCliente= mostrarid_sucursalCliente;
	}

	public Boolean getActivarid_sucursalCliente() {
		return this.activarid_sucursalCliente;
	}

	public void setActivarid_sucursalCliente(Boolean activarid_sucursalCliente) {
		this.activarid_sucursalCliente= activarid_sucursalCliente;
	}

	public Boolean getCargarid_sucursalCliente() {
		return this.cargarid_sucursalCliente;
	}

	public void setCargarid_sucursalCliente(Boolean cargarid_sucursalCliente) {
		this.cargarid_sucursalCliente= cargarid_sucursalCliente;
	}

	public Border setResaltarcodigoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarcodigoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCliente() {
		return this.resaltarcodigoCliente;
	}

	public void setResaltarcodigoCliente(Border borderResaltar) {
		this.resaltarcodigoCliente= borderResaltar;
	}

	public Boolean getMostrarcodigoCliente() {
		return this.mostrarcodigoCliente;
	}

	public void setMostrarcodigoCliente(Boolean mostrarcodigoCliente) {
		this.mostrarcodigoCliente= mostrarcodigoCliente;
	}

	public Boolean getActivarcodigoCliente() {
		return this.activarcodigoCliente;
	}

	public void setActivarcodigoCliente(Boolean activarcodigoCliente) {
		this.activarcodigoCliente= activarcodigoCliente;
	}

	public Border setResaltarid_tipo_identificacionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_identificacionCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_identificacionCliente() {
		return this.resaltarid_tipo_identificacionCliente;
	}

	public void setResaltarid_tipo_identificacionCliente(Border borderResaltar) {
		this.resaltarid_tipo_identificacionCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_identificacionCliente() {
		return this.mostrarid_tipo_identificacionCliente;
	}

	public void setMostrarid_tipo_identificacionCliente(Boolean mostrarid_tipo_identificacionCliente) {
		this.mostrarid_tipo_identificacionCliente= mostrarid_tipo_identificacionCliente;
	}

	public Boolean getActivarid_tipo_identificacionCliente() {
		return this.activarid_tipo_identificacionCliente;
	}

	public void setActivarid_tipo_identificacionCliente(Boolean activarid_tipo_identificacionCliente) {
		this.activarid_tipo_identificacionCliente= activarid_tipo_identificacionCliente;
	}

	public Boolean getCargarid_tipo_identificacionCliente() {
		return this.cargarid_tipo_identificacionCliente;
	}

	public void setCargarid_tipo_identificacionCliente(Boolean cargarid_tipo_identificacionCliente) {
		this.cargarid_tipo_identificacionCliente= cargarid_tipo_identificacionCliente;
	}

	public Border setResaltaridentificacionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltaridentificacionCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridentificacionCliente() {
		return this.resaltaridentificacionCliente;
	}

	public void setResaltaridentificacionCliente(Border borderResaltar) {
		this.resaltaridentificacionCliente= borderResaltar;
	}

	public Boolean getMostraridentificacionCliente() {
		return this.mostraridentificacionCliente;
	}

	public void setMostraridentificacionCliente(Boolean mostraridentificacionCliente) {
		this.mostraridentificacionCliente= mostraridentificacionCliente;
	}

	public Boolean getActivaridentificacionCliente() {
		return this.activaridentificacionCliente;
	}

	public void setActivaridentificacionCliente(Boolean activaridentificacionCliente) {
		this.activaridentificacionCliente= activaridentificacionCliente;
	}

	public Border setResaltarrucCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarrucCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucCliente() {
		return this.resaltarrucCliente;
	}

	public void setResaltarrucCliente(Border borderResaltar) {
		this.resaltarrucCliente= borderResaltar;
	}

	public Boolean getMostrarrucCliente() {
		return this.mostrarrucCliente;
	}

	public void setMostrarrucCliente(Boolean mostrarrucCliente) {
		this.mostrarrucCliente= mostrarrucCliente;
	}

	public Boolean getActivarrucCliente() {
		return this.activarrucCliente;
	}

	public void setActivarrucCliente(Boolean activarrucCliente) {
		this.activarrucCliente= activarrucCliente;
	}

	public Border setResaltarnombreCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarnombreCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCliente() {
		return this.resaltarnombreCliente;
	}

	public void setResaltarnombreCliente(Border borderResaltar) {
		this.resaltarnombreCliente= borderResaltar;
	}

	public Boolean getMostrarnombreCliente() {
		return this.mostrarnombreCliente;
	}

	public void setMostrarnombreCliente(Boolean mostrarnombreCliente) {
		this.mostrarnombreCliente= mostrarnombreCliente;
	}

	public Boolean getActivarnombreCliente() {
		return this.activarnombreCliente;
	}

	public void setActivarnombreCliente(Boolean activarnombreCliente) {
		this.activarnombreCliente= activarnombreCliente;
	}

	public Border setResaltarapellidoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarapellidoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidoCliente() {
		return this.resaltarapellidoCliente;
	}

	public void setResaltarapellidoCliente(Border borderResaltar) {
		this.resaltarapellidoCliente= borderResaltar;
	}

	public Boolean getMostrarapellidoCliente() {
		return this.mostrarapellidoCliente;
	}

	public void setMostrarapellidoCliente(Boolean mostrarapellidoCliente) {
		this.mostrarapellidoCliente= mostrarapellidoCliente;
	}

	public Boolean getActivarapellidoCliente() {
		return this.activarapellidoCliente;
	}

	public void setActivarapellidoCliente(Boolean activarapellidoCliente) {
		this.activarapellidoCliente= activarapellidoCliente;
	}

	public Border setResaltarnombre_completoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarnombre_completoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoCliente() {
		return this.resaltarnombre_completoCliente;
	}

	public void setResaltarnombre_completoCliente(Border borderResaltar) {
		this.resaltarnombre_completoCliente= borderResaltar;
	}

	public Boolean getMostrarnombre_completoCliente() {
		return this.mostrarnombre_completoCliente;
	}

	public void setMostrarnombre_completoCliente(Boolean mostrarnombre_completoCliente) {
		this.mostrarnombre_completoCliente= mostrarnombre_completoCliente;
	}

	public Boolean getActivarnombre_completoCliente() {
		return this.activarnombre_completoCliente;
	}

	public void setActivarnombre_completoCliente(Boolean activarnombre_completoCliente) {
		this.activarnombre_completoCliente= activarnombre_completoCliente;
	}

	public Border setResaltarnombre_comercialCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarnombre_comercialCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_comercialCliente() {
		return this.resaltarnombre_comercialCliente;
	}

	public void setResaltarnombre_comercialCliente(Border borderResaltar) {
		this.resaltarnombre_comercialCliente= borderResaltar;
	}

	public Boolean getMostrarnombre_comercialCliente() {
		return this.mostrarnombre_comercialCliente;
	}

	public void setMostrarnombre_comercialCliente(Boolean mostrarnombre_comercialCliente) {
		this.mostrarnombre_comercialCliente= mostrarnombre_comercialCliente;
	}

	public Boolean getActivarnombre_comercialCliente() {
		return this.activarnombre_comercialCliente;
	}

	public void setActivarnombre_comercialCliente(Boolean activarnombre_comercialCliente) {
		this.activarnombre_comercialCliente= activarnombre_comercialCliente;
	}

	public Border setResaltartelefonoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltartelefonoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoCliente() {
		return this.resaltartelefonoCliente;
	}

	public void setResaltartelefonoCliente(Border borderResaltar) {
		this.resaltartelefonoCliente= borderResaltar;
	}

	public Boolean getMostrartelefonoCliente() {
		return this.mostrartelefonoCliente;
	}

	public void setMostrartelefonoCliente(Boolean mostrartelefonoCliente) {
		this.mostrartelefonoCliente= mostrartelefonoCliente;
	}

	public Boolean getActivartelefonoCliente() {
		return this.activartelefonoCliente;
	}

	public void setActivartelefonoCliente(Boolean activartelefonoCliente) {
		this.activartelefonoCliente= activartelefonoCliente;
	}

	public Border setResaltardireccionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltardireccionCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionCliente() {
		return this.resaltardireccionCliente;
	}

	public void setResaltardireccionCliente(Border borderResaltar) {
		this.resaltardireccionCliente= borderResaltar;
	}

	public Boolean getMostrardireccionCliente() {
		return this.mostrardireccionCliente;
	}

	public void setMostrardireccionCliente(Boolean mostrardireccionCliente) {
		this.mostrardireccionCliente= mostrardireccionCliente;
	}

	public Boolean getActivardireccionCliente() {
		return this.activardireccionCliente;
	}

	public void setActivardireccionCliente(Boolean activardireccionCliente) {
		this.activardireccionCliente= activardireccionCliente;
	}

	public Border setResaltares_proveCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltares_proveCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_proveCliente() {
		return this.resaltares_proveCliente;
	}

	public void setResaltares_proveCliente(Border borderResaltar) {
		this.resaltares_proveCliente= borderResaltar;
	}

	public Boolean getMostrares_proveCliente() {
		return this.mostrares_proveCliente;
	}

	public void setMostrares_proveCliente(Boolean mostrares_proveCliente) {
		this.mostrares_proveCliente= mostrares_proveCliente;
	}

	public Boolean getActivares_proveCliente() {
		return this.activares_proveCliente;
	}

	public void setActivares_proveCliente(Boolean activares_proveCliente) {
		this.activares_proveCliente= activares_proveCliente;
	}

	public Border setResaltarid_grupo_clienteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_grupo_clienteCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_clienteCliente() {
		return this.resaltarid_grupo_clienteCliente;
	}

	public void setResaltarid_grupo_clienteCliente(Border borderResaltar) {
		this.resaltarid_grupo_clienteCliente= borderResaltar;
	}

	public Boolean getMostrarid_grupo_clienteCliente() {
		return this.mostrarid_grupo_clienteCliente;
	}

	public void setMostrarid_grupo_clienteCliente(Boolean mostrarid_grupo_clienteCliente) {
		this.mostrarid_grupo_clienteCliente= mostrarid_grupo_clienteCliente;
	}

	public Boolean getActivarid_grupo_clienteCliente() {
		return this.activarid_grupo_clienteCliente;
	}

	public void setActivarid_grupo_clienteCliente(Boolean activarid_grupo_clienteCliente) {
		this.activarid_grupo_clienteCliente= activarid_grupo_clienteCliente;
	}

	public Boolean getCargarid_grupo_clienteCliente() {
		return this.cargarid_grupo_clienteCliente;
	}

	public void setCargarid_grupo_clienteCliente(Boolean cargarid_grupo_clienteCliente) {
		this.cargarid_grupo_clienteCliente= cargarid_grupo_clienteCliente;
	}

	public Border setResaltarid_titulo_clienteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_titulo_clienteCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_titulo_clienteCliente() {
		return this.resaltarid_titulo_clienteCliente;
	}

	public void setResaltarid_titulo_clienteCliente(Border borderResaltar) {
		this.resaltarid_titulo_clienteCliente= borderResaltar;
	}

	public Boolean getMostrarid_titulo_clienteCliente() {
		return this.mostrarid_titulo_clienteCliente;
	}

	public void setMostrarid_titulo_clienteCliente(Boolean mostrarid_titulo_clienteCliente) {
		this.mostrarid_titulo_clienteCliente= mostrarid_titulo_clienteCliente;
	}

	public Boolean getActivarid_titulo_clienteCliente() {
		return this.activarid_titulo_clienteCliente;
	}

	public void setActivarid_titulo_clienteCliente(Boolean activarid_titulo_clienteCliente) {
		this.activarid_titulo_clienteCliente= activarid_titulo_clienteCliente;
	}

	public Boolean getCargarid_titulo_clienteCliente() {
		return this.cargarid_titulo_clienteCliente;
	}

	public void setCargarid_titulo_clienteCliente(Boolean cargarid_titulo_clienteCliente) {
		this.cargarid_titulo_clienteCliente= cargarid_titulo_clienteCliente;
	}

	public Border setResaltarid_area_crCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_area_crCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_area_crCliente() {
		return this.resaltarid_area_crCliente;
	}

	public void setResaltarid_area_crCliente(Border borderResaltar) {
		this.resaltarid_area_crCliente= borderResaltar;
	}

	public Boolean getMostrarid_area_crCliente() {
		return this.mostrarid_area_crCliente;
	}

	public void setMostrarid_area_crCliente(Boolean mostrarid_area_crCliente) {
		this.mostrarid_area_crCliente= mostrarid_area_crCliente;
	}

	public Boolean getActivarid_area_crCliente() {
		return this.activarid_area_crCliente;
	}

	public void setActivarid_area_crCliente(Boolean activarid_area_crCliente) {
		this.activarid_area_crCliente= activarid_area_crCliente;
	}

	public Boolean getCargarid_area_crCliente() {
		return this.cargarid_area_crCliente;
	}

	public void setCargarid_area_crCliente(Boolean cargarid_area_crCliente) {
		this.cargarid_area_crCliente= cargarid_area_crCliente;
	}

	public Border setResaltarid_estado_clienteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_estado_clienteCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_clienteCliente() {
		return this.resaltarid_estado_clienteCliente;
	}

	public void setResaltarid_estado_clienteCliente(Border borderResaltar) {
		this.resaltarid_estado_clienteCliente= borderResaltar;
	}

	public Boolean getMostrarid_estado_clienteCliente() {
		return this.mostrarid_estado_clienteCliente;
	}

	public void setMostrarid_estado_clienteCliente(Boolean mostrarid_estado_clienteCliente) {
		this.mostrarid_estado_clienteCliente= mostrarid_estado_clienteCliente;
	}

	public Boolean getActivarid_estado_clienteCliente() {
		return this.activarid_estado_clienteCliente;
	}

	public void setActivarid_estado_clienteCliente(Boolean activarid_estado_clienteCliente) {
		this.activarid_estado_clienteCliente= activarid_estado_clienteCliente;
	}

	public Boolean getCargarid_estado_clienteCliente() {
		return this.cargarid_estado_clienteCliente;
	}

	public void setCargarid_estado_clienteCliente(Boolean cargarid_estado_clienteCliente) {
		this.cargarid_estado_clienteCliente= cargarid_estado_clienteCliente;
	}

	public Border setResaltarobservacionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarobservacionCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionCliente() {
		return this.resaltarobservacionCliente;
	}

	public void setResaltarobservacionCliente(Border borderResaltar) {
		this.resaltarobservacionCliente= borderResaltar;
	}

	public Boolean getMostrarobservacionCliente() {
		return this.mostrarobservacionCliente;
	}

	public void setMostrarobservacionCliente(Boolean mostrarobservacionCliente) {
		this.mostrarobservacionCliente= mostrarobservacionCliente;
	}

	public Boolean getActivarobservacionCliente() {
		return this.activarobservacionCliente;
	}

	public void setActivarobservacionCliente(Boolean activarobservacionCliente) {
		this.activarobservacionCliente= activarobservacionCliente;
	}

	public Border setResaltarid_paisCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_paisCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisCliente() {
		return this.resaltarid_paisCliente;
	}

	public void setResaltarid_paisCliente(Border borderResaltar) {
		this.resaltarid_paisCliente= borderResaltar;
	}

	public Boolean getMostrarid_paisCliente() {
		return this.mostrarid_paisCliente;
	}

	public void setMostrarid_paisCliente(Boolean mostrarid_paisCliente) {
		this.mostrarid_paisCliente= mostrarid_paisCliente;
	}

	public Boolean getActivarid_paisCliente() {
		return this.activarid_paisCliente;
	}

	public void setActivarid_paisCliente(Boolean activarid_paisCliente) {
		this.activarid_paisCliente= activarid_paisCliente;
	}

	public Boolean getCargarid_paisCliente() {
		return this.cargarid_paisCliente;
	}

	public void setCargarid_paisCliente(Boolean cargarid_paisCliente) {
		this.cargarid_paisCliente= cargarid_paisCliente;
	}

	public Border setResaltarid_regionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_regionCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_regionCliente() {
		return this.resaltarid_regionCliente;
	}

	public void setResaltarid_regionCliente(Border borderResaltar) {
		this.resaltarid_regionCliente= borderResaltar;
	}

	public Boolean getMostrarid_regionCliente() {
		return this.mostrarid_regionCliente;
	}

	public void setMostrarid_regionCliente(Boolean mostrarid_regionCliente) {
		this.mostrarid_regionCliente= mostrarid_regionCliente;
	}

	public Boolean getActivarid_regionCliente() {
		return this.activarid_regionCliente;
	}

	public void setActivarid_regionCliente(Boolean activarid_regionCliente) {
		this.activarid_regionCliente= activarid_regionCliente;
	}

	public Boolean getCargarid_regionCliente() {
		return this.cargarid_regionCliente;
	}

	public void setCargarid_regionCliente(Boolean cargarid_regionCliente) {
		this.cargarid_regionCliente= cargarid_regionCliente;
	}

	public Border setResaltarid_provinciaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_provinciaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_provinciaCliente() {
		return this.resaltarid_provinciaCliente;
	}

	public void setResaltarid_provinciaCliente(Border borderResaltar) {
		this.resaltarid_provinciaCliente= borderResaltar;
	}

	public Boolean getMostrarid_provinciaCliente() {
		return this.mostrarid_provinciaCliente;
	}

	public void setMostrarid_provinciaCliente(Boolean mostrarid_provinciaCliente) {
		this.mostrarid_provinciaCliente= mostrarid_provinciaCliente;
	}

	public Boolean getActivarid_provinciaCliente() {
		return this.activarid_provinciaCliente;
	}

	public void setActivarid_provinciaCliente(Boolean activarid_provinciaCliente) {
		this.activarid_provinciaCliente= activarid_provinciaCliente;
	}

	public Boolean getCargarid_provinciaCliente() {
		return this.cargarid_provinciaCliente;
	}

	public void setCargarid_provinciaCliente(Boolean cargarid_provinciaCliente) {
		this.cargarid_provinciaCliente= cargarid_provinciaCliente;
	}

	public Border setResaltarid_ciudadCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_ciudadCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadCliente() {
		return this.resaltarid_ciudadCliente;
	}

	public void setResaltarid_ciudadCliente(Border borderResaltar) {
		this.resaltarid_ciudadCliente= borderResaltar;
	}

	public Boolean getMostrarid_ciudadCliente() {
		return this.mostrarid_ciudadCliente;
	}

	public void setMostrarid_ciudadCliente(Boolean mostrarid_ciudadCliente) {
		this.mostrarid_ciudadCliente= mostrarid_ciudadCliente;
	}

	public Boolean getActivarid_ciudadCliente() {
		return this.activarid_ciudadCliente;
	}

	public void setActivarid_ciudadCliente(Boolean activarid_ciudadCliente) {
		this.activarid_ciudadCliente= activarid_ciudadCliente;
	}

	public Boolean getCargarid_ciudadCliente() {
		return this.cargarid_ciudadCliente;
	}

	public void setCargarid_ciudadCliente(Boolean cargarid_ciudadCliente) {
		this.cargarid_ciudadCliente= cargarid_ciudadCliente;
	}

	public Border setResaltarid_zonaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_zonaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_zonaCliente() {
		return this.resaltarid_zonaCliente;
	}

	public void setResaltarid_zonaCliente(Border borderResaltar) {
		this.resaltarid_zonaCliente= borderResaltar;
	}

	public Boolean getMostrarid_zonaCliente() {
		return this.mostrarid_zonaCliente;
	}

	public void setMostrarid_zonaCliente(Boolean mostrarid_zonaCliente) {
		this.mostrarid_zonaCliente= mostrarid_zonaCliente;
	}

	public Boolean getActivarid_zonaCliente() {
		return this.activarid_zonaCliente;
	}

	public void setActivarid_zonaCliente(Boolean activarid_zonaCliente) {
		this.activarid_zonaCliente= activarid_zonaCliente;
	}

	public Boolean getCargarid_zonaCliente() {
		return this.cargarid_zonaCliente;
	}

	public void setCargarid_zonaCliente(Boolean cargarid_zonaCliente) {
		this.cargarid_zonaCliente= cargarid_zonaCliente;
	}

	public Border setResaltarid_pais_nacionalidadCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_pais_nacionalidadCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_pais_nacionalidadCliente() {
		return this.resaltarid_pais_nacionalidadCliente;
	}

	public void setResaltarid_pais_nacionalidadCliente(Border borderResaltar) {
		this.resaltarid_pais_nacionalidadCliente= borderResaltar;
	}

	public Boolean getMostrarid_pais_nacionalidadCliente() {
		return this.mostrarid_pais_nacionalidadCliente;
	}

	public void setMostrarid_pais_nacionalidadCliente(Boolean mostrarid_pais_nacionalidadCliente) {
		this.mostrarid_pais_nacionalidadCliente= mostrarid_pais_nacionalidadCliente;
	}

	public Boolean getActivarid_pais_nacionalidadCliente() {
		return this.activarid_pais_nacionalidadCliente;
	}

	public void setActivarid_pais_nacionalidadCliente(Boolean activarid_pais_nacionalidadCliente) {
		this.activarid_pais_nacionalidadCliente= activarid_pais_nacionalidadCliente;
	}

	public Boolean getCargarid_pais_nacionalidadCliente() {
		return this.cargarid_pais_nacionalidadCliente;
	}

	public void setCargarid_pais_nacionalidadCliente(Boolean cargarid_pais_nacionalidadCliente) {
		this.cargarid_pais_nacionalidadCliente= cargarid_pais_nacionalidadCliente;
	}

	public Border setResaltarid_tipo_cargo_laboCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cargo_laboCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cargo_laboCliente() {
		return this.resaltarid_tipo_cargo_laboCliente;
	}

	public void setResaltarid_tipo_cargo_laboCliente(Border borderResaltar) {
		this.resaltarid_tipo_cargo_laboCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cargo_laboCliente() {
		return this.mostrarid_tipo_cargo_laboCliente;
	}

	public void setMostrarid_tipo_cargo_laboCliente(Boolean mostrarid_tipo_cargo_laboCliente) {
		this.mostrarid_tipo_cargo_laboCliente= mostrarid_tipo_cargo_laboCliente;
	}

	public Boolean getActivarid_tipo_cargo_laboCliente() {
		return this.activarid_tipo_cargo_laboCliente;
	}

	public void setActivarid_tipo_cargo_laboCliente(Boolean activarid_tipo_cargo_laboCliente) {
		this.activarid_tipo_cargo_laboCliente= activarid_tipo_cargo_laboCliente;
	}

	public Boolean getCargarid_tipo_cargo_laboCliente() {
		return this.cargarid_tipo_cargo_laboCliente;
	}

	public void setCargarid_tipo_cargo_laboCliente(Boolean cargarid_tipo_cargo_laboCliente) {
		this.cargarid_tipo_cargo_laboCliente= cargarid_tipo_cargo_laboCliente;
	}

	public Border setResaltarid_tipo_nivel_eduCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_nivel_eduCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_nivel_eduCliente() {
		return this.resaltarid_tipo_nivel_eduCliente;
	}

	public void setResaltarid_tipo_nivel_eduCliente(Border borderResaltar) {
		this.resaltarid_tipo_nivel_eduCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_nivel_eduCliente() {
		return this.mostrarid_tipo_nivel_eduCliente;
	}

	public void setMostrarid_tipo_nivel_eduCliente(Boolean mostrarid_tipo_nivel_eduCliente) {
		this.mostrarid_tipo_nivel_eduCliente= mostrarid_tipo_nivel_eduCliente;
	}

	public Boolean getActivarid_tipo_nivel_eduCliente() {
		return this.activarid_tipo_nivel_eduCliente;
	}

	public void setActivarid_tipo_nivel_eduCliente(Boolean activarid_tipo_nivel_eduCliente) {
		this.activarid_tipo_nivel_eduCliente= activarid_tipo_nivel_eduCliente;
	}

	public Boolean getCargarid_tipo_nivel_eduCliente() {
		return this.cargarid_tipo_nivel_eduCliente;
	}

	public void setCargarid_tipo_nivel_eduCliente(Boolean cargarid_tipo_nivel_eduCliente) {
		this.cargarid_tipo_nivel_eduCliente= cargarid_tipo_nivel_eduCliente;
	}

	public Border setResaltarid_profesionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_profesionCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_profesionCliente() {
		return this.resaltarid_profesionCliente;
	}

	public void setResaltarid_profesionCliente(Border borderResaltar) {
		this.resaltarid_profesionCliente= borderResaltar;
	}

	public Boolean getMostrarid_profesionCliente() {
		return this.mostrarid_profesionCliente;
	}

	public void setMostrarid_profesionCliente(Boolean mostrarid_profesionCliente) {
		this.mostrarid_profesionCliente= mostrarid_profesionCliente;
	}

	public Boolean getActivarid_profesionCliente() {
		return this.activarid_profesionCliente;
	}

	public void setActivarid_profesionCliente(Boolean activarid_profesionCliente) {
		this.activarid_profesionCliente= activarid_profesionCliente;
	}

	public Boolean getCargarid_profesionCliente() {
		return this.cargarid_profesionCliente;
	}

	public void setCargarid_profesionCliente(Boolean cargarid_profesionCliente) {
		this.cargarid_profesionCliente= cargarid_profesionCliente;
	}

	public Border setResaltarid_tipo_generoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_generoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_generoCliente() {
		return this.resaltarid_tipo_generoCliente;
	}

	public void setResaltarid_tipo_generoCliente(Border borderResaltar) {
		this.resaltarid_tipo_generoCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_generoCliente() {
		return this.mostrarid_tipo_generoCliente;
	}

	public void setMostrarid_tipo_generoCliente(Boolean mostrarid_tipo_generoCliente) {
		this.mostrarid_tipo_generoCliente= mostrarid_tipo_generoCliente;
	}

	public Boolean getActivarid_tipo_generoCliente() {
		return this.activarid_tipo_generoCliente;
	}

	public void setActivarid_tipo_generoCliente(Boolean activarid_tipo_generoCliente) {
		this.activarid_tipo_generoCliente= activarid_tipo_generoCliente;
	}

	public Boolean getCargarid_tipo_generoCliente() {
		return this.cargarid_tipo_generoCliente;
	}

	public void setCargarid_tipo_generoCliente(Boolean cargarid_tipo_generoCliente) {
		this.cargarid_tipo_generoCliente= cargarid_tipo_generoCliente;
	}

	public Border setResaltarid_estado_civilCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_estado_civilCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_civilCliente() {
		return this.resaltarid_estado_civilCliente;
	}

	public void setResaltarid_estado_civilCliente(Border borderResaltar) {
		this.resaltarid_estado_civilCliente= borderResaltar;
	}

	public Boolean getMostrarid_estado_civilCliente() {
		return this.mostrarid_estado_civilCliente;
	}

	public void setMostrarid_estado_civilCliente(Boolean mostrarid_estado_civilCliente) {
		this.mostrarid_estado_civilCliente= mostrarid_estado_civilCliente;
	}

	public Boolean getActivarid_estado_civilCliente() {
		return this.activarid_estado_civilCliente;
	}

	public void setActivarid_estado_civilCliente(Boolean activarid_estado_civilCliente) {
		this.activarid_estado_civilCliente= activarid_estado_civilCliente;
	}

	public Boolean getCargarid_estado_civilCliente() {
		return this.cargarid_estado_civilCliente;
	}

	public void setCargarid_estado_civilCliente(Boolean cargarid_estado_civilCliente) {
		this.cargarid_estado_civilCliente= cargarid_estado_civilCliente;
	}

	public Border setResaltarid_estado_legalCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_estado_legalCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_legalCliente() {
		return this.resaltarid_estado_legalCliente;
	}

	public void setResaltarid_estado_legalCliente(Border borderResaltar) {
		this.resaltarid_estado_legalCliente= borderResaltar;
	}

	public Boolean getMostrarid_estado_legalCliente() {
		return this.mostrarid_estado_legalCliente;
	}

	public void setMostrarid_estado_legalCliente(Boolean mostrarid_estado_legalCliente) {
		this.mostrarid_estado_legalCliente= mostrarid_estado_legalCliente;
	}

	public Boolean getActivarid_estado_legalCliente() {
		return this.activarid_estado_legalCliente;
	}

	public void setActivarid_estado_legalCliente(Boolean activarid_estado_legalCliente) {
		this.activarid_estado_legalCliente= activarid_estado_legalCliente;
	}

	public Boolean getCargarid_estado_legalCliente() {
		return this.cargarid_estado_legalCliente;
	}

	public void setCargarid_estado_legalCliente(Boolean cargarid_estado_legalCliente) {
		this.cargarid_estado_legalCliente= cargarid_estado_legalCliente;
	}

	public Border setResaltarfecha_nacimientoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarfecha_nacimientoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_nacimientoCliente() {
		return this.resaltarfecha_nacimientoCliente;
	}

	public void setResaltarfecha_nacimientoCliente(Border borderResaltar) {
		this.resaltarfecha_nacimientoCliente= borderResaltar;
	}

	public Boolean getMostrarfecha_nacimientoCliente() {
		return this.mostrarfecha_nacimientoCliente;
	}

	public void setMostrarfecha_nacimientoCliente(Boolean mostrarfecha_nacimientoCliente) {
		this.mostrarfecha_nacimientoCliente= mostrarfecha_nacimientoCliente;
	}

	public Boolean getActivarfecha_nacimientoCliente() {
		return this.activarfecha_nacimientoCliente;
	}

	public void setActivarfecha_nacimientoCliente(Boolean activarfecha_nacimientoCliente) {
		this.activarfecha_nacimientoCliente= activarfecha_nacimientoCliente;
	}

	public Border setResaltarpath_imagen_firmaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarpath_imagen_firmaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpath_imagen_firmaCliente() {
		return this.resaltarpath_imagen_firmaCliente;
	}

	public void setResaltarpath_imagen_firmaCliente(Border borderResaltar) {
		this.resaltarpath_imagen_firmaCliente= borderResaltar;
	}

	public Boolean getMostrarpath_imagen_firmaCliente() {
		return this.mostrarpath_imagen_firmaCliente;
	}

	public void setMostrarpath_imagen_firmaCliente(Boolean mostrarpath_imagen_firmaCliente) {
		this.mostrarpath_imagen_firmaCliente= mostrarpath_imagen_firmaCliente;
	}

	public Boolean getActivarpath_imagen_firmaCliente() {
		return this.activarpath_imagen_firmaCliente;
	}

	public void setActivarpath_imagen_firmaCliente(Boolean activarpath_imagen_firmaCliente) {
		this.activarpath_imagen_firmaCliente= activarpath_imagen_firmaCliente;
	}

	public Border setResaltarcontactoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarcontactoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcontactoCliente() {
		return this.resaltarcontactoCliente;
	}

	public void setResaltarcontactoCliente(Border borderResaltar) {
		this.resaltarcontactoCliente= borderResaltar;
	}

	public Boolean getMostrarcontactoCliente() {
		return this.mostrarcontactoCliente;
	}

	public void setMostrarcontactoCliente(Boolean mostrarcontactoCliente) {
		this.mostrarcontactoCliente= mostrarcontactoCliente;
	}

	public Boolean getActivarcontactoCliente() {
		return this.activarcontactoCliente;
	}

	public void setActivarcontactoCliente(Boolean activarcontactoCliente) {
		this.activarcontactoCliente= activarcontactoCliente;
	}

	public Border setResaltarid_cuenta_contableCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableCliente() {
		return this.resaltarid_cuenta_contableCliente;
	}

	public void setResaltarid_cuenta_contableCliente(Border borderResaltar) {
		this.resaltarid_cuenta_contableCliente= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableCliente() {
		return this.mostrarid_cuenta_contableCliente;
	}

	public void setMostrarid_cuenta_contableCliente(Boolean mostrarid_cuenta_contableCliente) {
		this.mostrarid_cuenta_contableCliente= mostrarid_cuenta_contableCliente;
	}

	public Boolean getActivarid_cuenta_contableCliente() {
		return this.activarid_cuenta_contableCliente;
	}

	public void setActivarid_cuenta_contableCliente(Boolean activarid_cuenta_contableCliente) {
		this.activarid_cuenta_contableCliente= activarid_cuenta_contableCliente;
	}

	public Boolean getCargarid_cuenta_contableCliente() {
		return this.cargarid_cuenta_contableCliente;
	}

	public void setCargarid_cuenta_contableCliente(Boolean cargarid_cuenta_contableCliente) {
		this.cargarid_cuenta_contableCliente= cargarid_cuenta_contableCliente;
	}

	public Border setResaltarid_rutaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_rutaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_rutaCliente() {
		return this.resaltarid_rutaCliente;
	}

	public void setResaltarid_rutaCliente(Border borderResaltar) {
		this.resaltarid_rutaCliente= borderResaltar;
	}

	public Boolean getMostrarid_rutaCliente() {
		return this.mostrarid_rutaCliente;
	}

	public void setMostrarid_rutaCliente(Boolean mostrarid_rutaCliente) {
		this.mostrarid_rutaCliente= mostrarid_rutaCliente;
	}

	public Boolean getActivarid_rutaCliente() {
		return this.activarid_rutaCliente;
	}

	public void setActivarid_rutaCliente(Boolean activarid_rutaCliente) {
		this.activarid_rutaCliente= activarid_rutaCliente;
	}

	public Boolean getCargarid_rutaCliente() {
		return this.cargarid_rutaCliente;
	}

	public void setCargarid_rutaCliente(Boolean cargarid_rutaCliente) {
		this.cargarid_rutaCliente= cargarid_rutaCliente;
	}

	public Border setResaltarid_vendedorCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_vendedorCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorCliente() {
		return this.resaltarid_vendedorCliente;
	}

	public void setResaltarid_vendedorCliente(Border borderResaltar) {
		this.resaltarid_vendedorCliente= borderResaltar;
	}

	public Boolean getMostrarid_vendedorCliente() {
		return this.mostrarid_vendedorCliente;
	}

	public void setMostrarid_vendedorCliente(Boolean mostrarid_vendedorCliente) {
		this.mostrarid_vendedorCliente= mostrarid_vendedorCliente;
	}

	public Boolean getActivarid_vendedorCliente() {
		return this.activarid_vendedorCliente;
	}

	public void setActivarid_vendedorCliente(Boolean activarid_vendedorCliente) {
		this.activarid_vendedorCliente= activarid_vendedorCliente;
	}

	public Boolean getCargarid_vendedorCliente() {
		return this.cargarid_vendedorCliente;
	}

	public void setCargarid_vendedorCliente(Boolean cargarid_vendedorCliente) {
		this.cargarid_vendedorCliente= cargarid_vendedorCliente;
	}

	public Border setResaltarid_centro_actividadCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_centro_actividadCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_actividadCliente() {
		return this.resaltarid_centro_actividadCliente;
	}

	public void setResaltarid_centro_actividadCliente(Border borderResaltar) {
		this.resaltarid_centro_actividadCliente= borderResaltar;
	}

	public Boolean getMostrarid_centro_actividadCliente() {
		return this.mostrarid_centro_actividadCliente;
	}

	public void setMostrarid_centro_actividadCliente(Boolean mostrarid_centro_actividadCliente) {
		this.mostrarid_centro_actividadCliente= mostrarid_centro_actividadCliente;
	}

	public Boolean getActivarid_centro_actividadCliente() {
		return this.activarid_centro_actividadCliente;
	}

	public void setActivarid_centro_actividadCliente(Boolean activarid_centro_actividadCliente) {
		this.activarid_centro_actividadCliente= activarid_centro_actividadCliente;
	}

	public Boolean getCargarid_centro_actividadCliente() {
		return this.cargarid_centro_actividadCliente;
	}

	public void setCargarid_centro_actividadCliente(Boolean cargarid_centro_actividadCliente) {
		this.cargarid_centro_actividadCliente= cargarid_centro_actividadCliente;
	}

	public Border setResaltarrepresentanteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarrepresentanteCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrepresentanteCliente() {
		return this.resaltarrepresentanteCliente;
	}

	public void setResaltarrepresentanteCliente(Border borderResaltar) {
		this.resaltarrepresentanteCliente= borderResaltar;
	}

	public Boolean getMostrarrepresentanteCliente() {
		return this.mostrarrepresentanteCliente;
	}

	public void setMostrarrepresentanteCliente(Boolean mostrarrepresentanteCliente) {
		this.mostrarrepresentanteCliente= mostrarrepresentanteCliente;
	}

	public Boolean getActivarrepresentanteCliente() {
		return this.activarrepresentanteCliente;
	}

	public void setActivarrepresentanteCliente(Boolean activarrepresentanteCliente) {
		this.activarrepresentanteCliente= activarrepresentanteCliente;
	}

	public Border setResaltarid_tipo_garantia_empresaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_garantia_empresaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_garantia_empresaCliente() {
		return this.resaltarid_tipo_garantia_empresaCliente;
	}

	public void setResaltarid_tipo_garantia_empresaCliente(Border borderResaltar) {
		this.resaltarid_tipo_garantia_empresaCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_garantia_empresaCliente() {
		return this.mostrarid_tipo_garantia_empresaCliente;
	}

	public void setMostrarid_tipo_garantia_empresaCliente(Boolean mostrarid_tipo_garantia_empresaCliente) {
		this.mostrarid_tipo_garantia_empresaCliente= mostrarid_tipo_garantia_empresaCliente;
	}

	public Boolean getActivarid_tipo_garantia_empresaCliente() {
		return this.activarid_tipo_garantia_empresaCliente;
	}

	public void setActivarid_tipo_garantia_empresaCliente(Boolean activarid_tipo_garantia_empresaCliente) {
		this.activarid_tipo_garantia_empresaCliente= activarid_tipo_garantia_empresaCliente;
	}

	public Boolean getCargarid_tipo_garantia_empresaCliente() {
		return this.cargarid_tipo_garantia_empresaCliente;
	}

	public void setCargarid_tipo_garantia_empresaCliente(Boolean cargarid_tipo_garantia_empresaCliente) {
		this.cargarid_tipo_garantia_empresaCliente= cargarid_tipo_garantia_empresaCliente;
	}

	public Border setResaltarnombre_garantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarnombre_garantiaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_garantiaCliente() {
		return this.resaltarnombre_garantiaCliente;
	}

	public void setResaltarnombre_garantiaCliente(Border borderResaltar) {
		this.resaltarnombre_garantiaCliente= borderResaltar;
	}

	public Boolean getMostrarnombre_garantiaCliente() {
		return this.mostrarnombre_garantiaCliente;
	}

	public void setMostrarnombre_garantiaCliente(Boolean mostrarnombre_garantiaCliente) {
		this.mostrarnombre_garantiaCliente= mostrarnombre_garantiaCliente;
	}

	public Boolean getActivarnombre_garantiaCliente() {
		return this.activarnombre_garantiaCliente;
	}

	public void setActivarnombre_garantiaCliente(Boolean activarnombre_garantiaCliente) {
		this.activarnombre_garantiaCliente= activarnombre_garantiaCliente;
	}

	public Border setResaltarvalor_garantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarvalor_garantiaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_garantiaCliente() {
		return this.resaltarvalor_garantiaCliente;
	}

	public void setResaltarvalor_garantiaCliente(Border borderResaltar) {
		this.resaltarvalor_garantiaCliente= borderResaltar;
	}

	public Boolean getMostrarvalor_garantiaCliente() {
		return this.mostrarvalor_garantiaCliente;
	}

	public void setMostrarvalor_garantiaCliente(Boolean mostrarvalor_garantiaCliente) {
		this.mostrarvalor_garantiaCliente= mostrarvalor_garantiaCliente;
	}

	public Boolean getActivarvalor_garantiaCliente() {
		return this.activarvalor_garantiaCliente;
	}

	public void setActivarvalor_garantiaCliente(Boolean activarvalor_garantiaCliente) {
		this.activarvalor_garantiaCliente= activarvalor_garantiaCliente;
	}

	public Border setResaltarid_cate_tipo_afiliacionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_cate_tipo_afiliacionCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cate_tipo_afiliacionCliente() {
		return this.resaltarid_cate_tipo_afiliacionCliente;
	}

	public void setResaltarid_cate_tipo_afiliacionCliente(Border borderResaltar) {
		this.resaltarid_cate_tipo_afiliacionCliente= borderResaltar;
	}

	public Boolean getMostrarid_cate_tipo_afiliacionCliente() {
		return this.mostrarid_cate_tipo_afiliacionCliente;
	}

	public void setMostrarid_cate_tipo_afiliacionCliente(Boolean mostrarid_cate_tipo_afiliacionCliente) {
		this.mostrarid_cate_tipo_afiliacionCliente= mostrarid_cate_tipo_afiliacionCliente;
	}

	public Boolean getActivarid_cate_tipo_afiliacionCliente() {
		return this.activarid_cate_tipo_afiliacionCliente;
	}

	public void setActivarid_cate_tipo_afiliacionCliente(Boolean activarid_cate_tipo_afiliacionCliente) {
		this.activarid_cate_tipo_afiliacionCliente= activarid_cate_tipo_afiliacionCliente;
	}

	public Boolean getCargarid_cate_tipo_afiliacionCliente() {
		return this.cargarid_cate_tipo_afiliacionCliente;
	}

	public void setCargarid_cate_tipo_afiliacionCliente(Boolean cargarid_cate_tipo_afiliacionCliente) {
		this.cargarid_cate_tipo_afiliacionCliente= cargarid_cate_tipo_afiliacionCliente;
	}

	public Border setResaltarnumero_cargaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarnumero_cargaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cargaCliente() {
		return this.resaltarnumero_cargaCliente;
	}

	public void setResaltarnumero_cargaCliente(Border borderResaltar) {
		this.resaltarnumero_cargaCliente= borderResaltar;
	}

	public Boolean getMostrarnumero_cargaCliente() {
		return this.mostrarnumero_cargaCliente;
	}

	public void setMostrarnumero_cargaCliente(Boolean mostrarnumero_cargaCliente) {
		this.mostrarnumero_cargaCliente= mostrarnumero_cargaCliente;
	}

	public Boolean getActivarnumero_cargaCliente() {
		return this.activarnumero_cargaCliente;
	}

	public void setActivarnumero_cargaCliente(Boolean activarnumero_cargaCliente) {
		this.activarnumero_cargaCliente= activarnumero_cargaCliente;
	}

	public Border setResaltarcredito_usadoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarcredito_usadoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_usadoCliente() {
		return this.resaltarcredito_usadoCliente;
	}

	public void setResaltarcredito_usadoCliente(Border borderResaltar) {
		this.resaltarcredito_usadoCliente= borderResaltar;
	}

	public Boolean getMostrarcredito_usadoCliente() {
		return this.mostrarcredito_usadoCliente;
	}

	public void setMostrarcredito_usadoCliente(Boolean mostrarcredito_usadoCliente) {
		this.mostrarcredito_usadoCliente= mostrarcredito_usadoCliente;
	}

	public Boolean getActivarcredito_usadoCliente() {
		return this.activarcredito_usadoCliente;
	}

	public void setActivarcredito_usadoCliente(Boolean activarcredito_usadoCliente) {
		this.activarcredito_usadoCliente= activarcredito_usadoCliente;
	}

	public Border setResaltarlimite_creditoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarlimite_creditoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlimite_creditoCliente() {
		return this.resaltarlimite_creditoCliente;
	}

	public void setResaltarlimite_creditoCliente(Border borderResaltar) {
		this.resaltarlimite_creditoCliente= borderResaltar;
	}

	public Boolean getMostrarlimite_creditoCliente() {
		return this.mostrarlimite_creditoCliente;
	}

	public void setMostrarlimite_creditoCliente(Boolean mostrarlimite_creditoCliente) {
		this.mostrarlimite_creditoCliente= mostrarlimite_creditoCliente;
	}

	public Boolean getActivarlimite_creditoCliente() {
		return this.activarlimite_creditoCliente;
	}

	public void setActivarlimite_creditoCliente(Boolean activarlimite_creditoCliente) {
		this.activarlimite_creditoCliente= activarlimite_creditoCliente;
	}

	public Border setResaltarcredito_disponibleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarcredito_disponibleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_disponibleCliente() {
		return this.resaltarcredito_disponibleCliente;
	}

	public void setResaltarcredito_disponibleCliente(Border borderResaltar) {
		this.resaltarcredito_disponibleCliente= borderResaltar;
	}

	public Boolean getMostrarcredito_disponibleCliente() {
		return this.mostrarcredito_disponibleCliente;
	}

	public void setMostrarcredito_disponibleCliente(Boolean mostrarcredito_disponibleCliente) {
		this.mostrarcredito_disponibleCliente= mostrarcredito_disponibleCliente;
	}

	public Boolean getActivarcredito_disponibleCliente() {
		return this.activarcredito_disponibleCliente;
	}

	public void setActivarcredito_disponibleCliente(Boolean activarcredito_disponibleCliente) {
		this.activarcredito_disponibleCliente= activarcredito_disponibleCliente;
	}

	public Border setResaltartotal_documentosCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltartotal_documentosCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_documentosCliente() {
		return this.resaltartotal_documentosCliente;
	}

	public void setResaltartotal_documentosCliente(Border borderResaltar) {
		this.resaltartotal_documentosCliente= borderResaltar;
	}

	public Boolean getMostrartotal_documentosCliente() {
		return this.mostrartotal_documentosCliente;
	}

	public void setMostrartotal_documentosCliente(Boolean mostrartotal_documentosCliente) {
		this.mostrartotal_documentosCliente= mostrartotal_documentosCliente;
	}

	public Boolean getActivartotal_documentosCliente() {
		return this.activartotal_documentosCliente;
	}

	public void setActivartotal_documentosCliente(Boolean activartotal_documentosCliente) {
		this.activartotal_documentosCliente= activartotal_documentosCliente;
	}

	public Border setResaltarfecha_ultima_facturaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_facturaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_facturaCliente() {
		return this.resaltarfecha_ultima_facturaCliente;
	}

	public void setResaltarfecha_ultima_facturaCliente(Border borderResaltar) {
		this.resaltarfecha_ultima_facturaCliente= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_facturaCliente() {
		return this.mostrarfecha_ultima_facturaCliente;
	}

	public void setMostrarfecha_ultima_facturaCliente(Boolean mostrarfecha_ultima_facturaCliente) {
		this.mostrarfecha_ultima_facturaCliente= mostrarfecha_ultima_facturaCliente;
	}

	public Boolean getActivarfecha_ultima_facturaCliente() {
		return this.activarfecha_ultima_facturaCliente;
	}

	public void setActivarfecha_ultima_facturaCliente(Boolean activarfecha_ultima_facturaCliente) {
		this.activarfecha_ultima_facturaCliente= activarfecha_ultima_facturaCliente;
	}

	public Border setResaltardescuentoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltardescuentoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoCliente() {
		return this.resaltardescuentoCliente;
	}

	public void setResaltardescuentoCliente(Border borderResaltar) {
		this.resaltardescuentoCliente= borderResaltar;
	}

	public Boolean getMostrardescuentoCliente() {
		return this.mostrardescuentoCliente;
	}

	public void setMostrardescuentoCliente(Boolean mostrardescuentoCliente) {
		this.mostrardescuentoCliente= mostrardescuentoCliente;
	}

	public Boolean getActivardescuentoCliente() {
		return this.activardescuentoCliente;
	}

	public void setActivardescuentoCliente(Boolean activardescuentoCliente) {
		this.activardescuentoCliente= activardescuentoCliente;
	}

	public Border setResaltarid_diaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_diaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_diaCliente() {
		return this.resaltarid_diaCliente;
	}

	public void setResaltarid_diaCliente(Border borderResaltar) {
		this.resaltarid_diaCliente= borderResaltar;
	}

	public Boolean getMostrarid_diaCliente() {
		return this.mostrarid_diaCliente;
	}

	public void setMostrarid_diaCliente(Boolean mostrarid_diaCliente) {
		this.mostrarid_diaCliente= mostrarid_diaCliente;
	}

	public Boolean getActivarid_diaCliente() {
		return this.activarid_diaCliente;
	}

	public void setActivarid_diaCliente(Boolean activarid_diaCliente) {
		this.activarid_diaCliente= activarid_diaCliente;
	}

	public Boolean getCargarid_diaCliente() {
		return this.cargarid_diaCliente;
	}

	public void setCargarid_diaCliente(Boolean cargarid_diaCliente) {
		this.cargarid_diaCliente= cargarid_diaCliente;
	}

	public Border setResaltarhora_pagoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarhora_pagoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_pagoCliente() {
		return this.resaltarhora_pagoCliente;
	}

	public void setResaltarhora_pagoCliente(Border borderResaltar) {
		this.resaltarhora_pagoCliente= borderResaltar;
	}

	public Boolean getMostrarhora_pagoCliente() {
		return this.mostrarhora_pagoCliente;
	}

	public void setMostrarhora_pagoCliente(Boolean mostrarhora_pagoCliente) {
		this.mostrarhora_pagoCliente= mostrarhora_pagoCliente;
	}

	public Boolean getActivarhora_pagoCliente() {
		return this.activarhora_pagoCliente;
	}

	public void setActivarhora_pagoCliente(Boolean activarhora_pagoCliente) {
		this.activarhora_pagoCliente= activarhora_pagoCliente;
	}

	public Border setResaltarid_empleadoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_empleadoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoCliente() {
		return this.resaltarid_empleadoCliente;
	}

	public void setResaltarid_empleadoCliente(Border borderResaltar) {
		this.resaltarid_empleadoCliente= borderResaltar;
	}

	public Boolean getMostrarid_empleadoCliente() {
		return this.mostrarid_empleadoCliente;
	}

	public void setMostrarid_empleadoCliente(Boolean mostrarid_empleadoCliente) {
		this.mostrarid_empleadoCliente= mostrarid_empleadoCliente;
	}

	public Boolean getActivarid_empleadoCliente() {
		return this.activarid_empleadoCliente;
	}

	public void setActivarid_empleadoCliente(Boolean activarid_empleadoCliente) {
		this.activarid_empleadoCliente= activarid_empleadoCliente;
	}

	public Boolean getCargarid_empleadoCliente() {
		return this.cargarid_empleadoCliente;
	}

	public void setCargarid_empleadoCliente(Boolean cargarid_empleadoCliente) {
		this.cargarid_empleadoCliente= cargarid_empleadoCliente;
	}

	public Border setResaltarcobranzasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarcobranzasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcobranzasCliente() {
		return this.resaltarcobranzasCliente;
	}

	public void setResaltarcobranzasCliente(Border borderResaltar) {
		this.resaltarcobranzasCliente= borderResaltar;
	}

	public Boolean getMostrarcobranzasCliente() {
		return this.mostrarcobranzasCliente;
	}

	public void setMostrarcobranzasCliente(Boolean mostrarcobranzasCliente) {
		this.mostrarcobranzasCliente= mostrarcobranzasCliente;
	}

	public Boolean getActivarcobranzasCliente() {
		return this.activarcobranzasCliente;
	}

	public void setActivarcobranzasCliente(Boolean activarcobranzasCliente) {
		this.activarcobranzasCliente= activarcobranzasCliente;
	}

	public Border setResaltarmotivoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarmotivoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmotivoCliente() {
		return this.resaltarmotivoCliente;
	}

	public void setResaltarmotivoCliente(Border borderResaltar) {
		this.resaltarmotivoCliente= borderResaltar;
	}

	public Boolean getMostrarmotivoCliente() {
		return this.mostrarmotivoCliente;
	}

	public void setMostrarmotivoCliente(Boolean mostrarmotivoCliente) {
		this.mostrarmotivoCliente= mostrarmotivoCliente;
	}

	public Boolean getActivarmotivoCliente() {
		return this.activarmotivoCliente;
	}

	public void setActivarmotivoCliente(Boolean activarmotivoCliente) {
		this.activarmotivoCliente= activarmotivoCliente;
	}

	public Border setResaltarpreferenciaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarpreferenciaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpreferenciaCliente() {
		return this.resaltarpreferenciaCliente;
	}

	public void setResaltarpreferenciaCliente(Border borderResaltar) {
		this.resaltarpreferenciaCliente= borderResaltar;
	}

	public Boolean getMostrarpreferenciaCliente() {
		return this.mostrarpreferenciaCliente;
	}

	public void setMostrarpreferenciaCliente(Boolean mostrarpreferenciaCliente) {
		this.mostrarpreferenciaCliente= mostrarpreferenciaCliente;
	}

	public Boolean getActivarpreferenciaCliente() {
		return this.activarpreferenciaCliente;
	}

	public void setActivarpreferenciaCliente(Boolean activarpreferenciaCliente) {
		this.activarpreferenciaCliente= activarpreferenciaCliente;
	}

	public Border setResaltarcon_separacion_bienesCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarcon_separacion_bienesCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_separacion_bienesCliente() {
		return this.resaltarcon_separacion_bienesCliente;
	}

	public void setResaltarcon_separacion_bienesCliente(Border borderResaltar) {
		this.resaltarcon_separacion_bienesCliente= borderResaltar;
	}

	public Boolean getMostrarcon_separacion_bienesCliente() {
		return this.mostrarcon_separacion_bienesCliente;
	}

	public void setMostrarcon_separacion_bienesCliente(Boolean mostrarcon_separacion_bienesCliente) {
		this.mostrarcon_separacion_bienesCliente= mostrarcon_separacion_bienesCliente;
	}

	public Boolean getActivarcon_separacion_bienesCliente() {
		return this.activarcon_separacion_bienesCliente;
	}

	public void setActivarcon_separacion_bienesCliente(Boolean activarcon_separacion_bienesCliente) {
		this.activarcon_separacion_bienesCliente= activarcon_separacion_bienesCliente;
	}

	public Border setResaltarid_tipo_precioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioCliente() {
		return this.resaltarid_tipo_precioCliente;
	}

	public void setResaltarid_tipo_precioCliente(Border borderResaltar) {
		this.resaltarid_tipo_precioCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioCliente() {
		return this.mostrarid_tipo_precioCliente;
	}

	public void setMostrarid_tipo_precioCliente(Boolean mostrarid_tipo_precioCliente) {
		this.mostrarid_tipo_precioCliente= mostrarid_tipo_precioCliente;
	}

	public Boolean getActivarid_tipo_precioCliente() {
		return this.activarid_tipo_precioCliente;
	}

	public void setActivarid_tipo_precioCliente(Boolean activarid_tipo_precioCliente) {
		this.activarid_tipo_precioCliente= activarid_tipo_precioCliente;
	}

	public Boolean getCargarid_tipo_precioCliente() {
		return this.cargarid_tipo_precioCliente;
	}

	public void setCargarid_tipo_precioCliente(Boolean cargarid_tipo_precioCliente) {
		this.cargarid_tipo_precioCliente= cargarid_tipo_precioCliente;
	}

	public Border setResaltarid_tipo_lista_precioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_lista_precioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_lista_precioCliente() {
		return this.resaltarid_tipo_lista_precioCliente;
	}

	public void setResaltarid_tipo_lista_precioCliente(Border borderResaltar) {
		this.resaltarid_tipo_lista_precioCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_lista_precioCliente() {
		return this.mostrarid_tipo_lista_precioCliente;
	}

	public void setMostrarid_tipo_lista_precioCliente(Boolean mostrarid_tipo_lista_precioCliente) {
		this.mostrarid_tipo_lista_precioCliente= mostrarid_tipo_lista_precioCliente;
	}

	public Boolean getActivarid_tipo_lista_precioCliente() {
		return this.activarid_tipo_lista_precioCliente;
	}

	public void setActivarid_tipo_lista_precioCliente(Boolean activarid_tipo_lista_precioCliente) {
		this.activarid_tipo_lista_precioCliente= activarid_tipo_lista_precioCliente;
	}

	public Boolean getCargarid_tipo_lista_precioCliente() {
		return this.cargarid_tipo_lista_precioCliente;
	}

	public void setCargarid_tipo_lista_precioCliente(Boolean cargarid_tipo_lista_precioCliente) {
		this.cargarid_tipo_lista_precioCliente= cargarid_tipo_lista_precioCliente;
	}

	public Border setResaltardetalle_estadoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltardetalle_estadoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalle_estadoCliente() {
		return this.resaltardetalle_estadoCliente;
	}

	public void setResaltardetalle_estadoCliente(Border borderResaltar) {
		this.resaltardetalle_estadoCliente= borderResaltar;
	}

	public Boolean getMostrardetalle_estadoCliente() {
		return this.mostrardetalle_estadoCliente;
	}

	public void setMostrardetalle_estadoCliente(Boolean mostrardetalle_estadoCliente) {
		this.mostrardetalle_estadoCliente= mostrardetalle_estadoCliente;
	}

	public Boolean getActivardetalle_estadoCliente() {
		return this.activardetalle_estadoCliente;
	}

	public void setActivardetalle_estadoCliente(Boolean activardetalle_estadoCliente) {
		this.activardetalle_estadoCliente= activardetalle_estadoCliente;
	}

	public Border setResaltares_contribuyente_especialCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltar);
		
		this.resaltares_contribuyente_especialCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_contribuyente_especialCliente() {
		return this.resaltares_contribuyente_especialCliente;
	}

	public void setResaltares_contribuyente_especialCliente(Border borderResaltar) {
		this.resaltares_contribuyente_especialCliente= borderResaltar;
	}

	public Boolean getMostrares_contribuyente_especialCliente() {
		return this.mostrares_contribuyente_especialCliente;
	}

	public void setMostrares_contribuyente_especialCliente(Boolean mostrares_contribuyente_especialCliente) {
		this.mostrares_contribuyente_especialCliente= mostrares_contribuyente_especialCliente;
	}

	public Boolean getActivares_contribuyente_especialCliente() {
		return this.activares_contribuyente_especialCliente;
	}

	public void setActivares_contribuyente_especialCliente(Boolean activares_contribuyente_especialCliente) {
		this.activares_contribuyente_especialCliente= activares_contribuyente_especialCliente;
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
		
		
		this.setMostraridCliente(esInicial);
		this.setMostrarid_empresaCliente(esInicial);
		this.setMostrarid_sucursalCliente(esInicial);
		this.setMostrarcodigoCliente(esInicial);
		this.setMostrarid_tipo_identificacionCliente(esInicial);
		this.setMostraridentificacionCliente(esInicial);
		this.setMostrarrucCliente(esInicial);
		this.setMostrarnombreCliente(esInicial);
		this.setMostrarapellidoCliente(esInicial);
		this.setMostrarnombre_completoCliente(esInicial);
		this.setMostrarnombre_comercialCliente(esInicial);
		this.setMostrartelefonoCliente(esInicial);
		this.setMostrardireccionCliente(esInicial);
		this.setMostrares_proveCliente(esInicial);
		this.setMostrarid_grupo_clienteCliente(esInicial);
		this.setMostrarid_titulo_clienteCliente(esInicial);
		this.setMostrarid_area_crCliente(esInicial);
		this.setMostrarid_estado_clienteCliente(esInicial);
		this.setMostrarobservacionCliente(esInicial);
		this.setMostrarid_paisCliente(esInicial);
		this.setMostrarid_regionCliente(esInicial);
		this.setMostrarid_provinciaCliente(esInicial);
		this.setMostrarid_ciudadCliente(esInicial);
		this.setMostrarid_zonaCliente(esInicial);
		this.setMostrarid_pais_nacionalidadCliente(esInicial);
		this.setMostrarid_tipo_cargo_laboCliente(esInicial);
		this.setMostrarid_tipo_nivel_eduCliente(esInicial);
		this.setMostrarid_profesionCliente(esInicial);
		this.setMostrarid_tipo_generoCliente(esInicial);
		this.setMostrarid_estado_civilCliente(esInicial);
		this.setMostrarid_estado_legalCliente(esInicial);
		this.setMostrarfecha_nacimientoCliente(esInicial);
		this.setMostrarpath_imagen_firmaCliente(esInicial);
		this.setMostrarcontactoCliente(esInicial);
		this.setMostrarid_cuenta_contableCliente(esInicial);
		this.setMostrarid_rutaCliente(esInicial);
		this.setMostrarid_vendedorCliente(esInicial);
		this.setMostrarid_centro_actividadCliente(esInicial);
		this.setMostrarrepresentanteCliente(esInicial);
		this.setMostrarid_tipo_garantia_empresaCliente(esInicial);
		this.setMostrarnombre_garantiaCliente(esInicial);
		this.setMostrarvalor_garantiaCliente(esInicial);
		this.setMostrarid_cate_tipo_afiliacionCliente(esInicial);
		this.setMostrarnumero_cargaCliente(esInicial);
		this.setMostrarcredito_usadoCliente(esInicial);
		this.setMostrarlimite_creditoCliente(esInicial);
		this.setMostrarcredito_disponibleCliente(esInicial);
		this.setMostrartotal_documentosCliente(esInicial);
		this.setMostrarfecha_ultima_facturaCliente(esInicial);
		this.setMostrardescuentoCliente(esInicial);
		this.setMostrarid_diaCliente(esInicial);
		this.setMostrarhora_pagoCliente(esInicial);
		this.setMostrarid_empleadoCliente(esInicial);
		this.setMostrarcobranzasCliente(esInicial);
		this.setMostrarmotivoCliente(esInicial);
		this.setMostrarpreferenciaCliente(esInicial);
		this.setMostrarcon_separacion_bienesCliente(esInicial);
		this.setMostrarid_tipo_precioCliente(esInicial);
		this.setMostrarid_tipo_lista_precioCliente(esInicial);
		this.setMostrardetalle_estadoCliente(esInicial);
		this.setMostrares_contribuyente_especialCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClienteConstantesFunciones.ID)) {
				this.setMostraridCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setMostrarid_tipo_identificacionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDENTIFICACION)) {
				this.setMostraridentificacionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.RUC)) {
				this.setMostrarrucCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.APELLIDO)) {
				this.setMostrarapellidoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.NOMBRECOMERCIAL)) {
				this.setMostrarnombre_comercialCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.ESPROVE)) {
				this.setMostrares_proveCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setMostrarid_grupo_clienteCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTITULOCLIENTE)) {
				this.setMostrarid_titulo_clienteCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDAREACR)) {
				this.setMostrarid_area_crCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDESTADOCLIENTE)) {
				this.setMostrarid_estado_clienteCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.OBSERVACION)) {
				this.setMostrarobservacionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDREGION)) {
				this.setMostrarid_regionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDPROVINCIA)) {
				this.setMostrarid_provinciaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDZONA)) {
				this.setMostrarid_zonaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDPAISNACIONALIDAD)) {
				this.setMostrarid_pais_nacionalidadCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOCARGOLABO)) {
				this.setMostrarid_tipo_cargo_laboCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPONIVELEDU)) {
				this.setMostrarid_tipo_nivel_eduCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDPROFESION)) {
				this.setMostrarid_profesionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOGENERO)) {
				this.setMostrarid_tipo_generoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDESTADOCIVIL)) {
				this.setMostrarid_estado_civilCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDESTADOLEGAL)) {
				this.setMostrarid_estado_legalCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.FECHANACIMIENTO)) {
				this.setMostrarfecha_nacimientoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.PATHIMAGENFIRMA)) {
				this.setMostrarpath_imagen_firmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.CONTACTO)) {
				this.setMostrarcontactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDRUTA)) {
				this.setMostrarid_rutaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setMostrarid_centro_actividadCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.REPRESENTANTE)) {
				this.setMostrarrepresentanteCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA)) {
				this.setMostrarid_tipo_garantia_empresaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.NOMBREGARANTIA)) {
				this.setMostrarnombre_garantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.VALORGARANTIA)) {
				this.setMostrarvalor_garantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDCATETIPOAFILIACION)) {
				this.setMostrarid_cate_tipo_afiliacionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.NUMEROCARGA)) {
				this.setMostrarnumero_cargaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.CREDITOUSADO)) {
				this.setMostrarcredito_usadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.LIMITECREDITO)) {
				this.setMostrarlimite_creditoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.CREDITODISPONIBLE)) {
				this.setMostrarcredito_disponibleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.TOTALDOCUMENTOS)) {
				this.setMostrartotal_documentosCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.FECHAULTIMAFACTURA)) {
				this.setMostrarfecha_ultima_facturaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDDIA)) {
				this.setMostrarid_diaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.HORAPAGO)) {
				this.setMostrarhora_pagoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.COBRANZAS)) {
				this.setMostrarcobranzasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.MOTIVO)) {
				this.setMostrarmotivoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.PREFERENCIA)) {
				this.setMostrarpreferenciaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.CONSEPARACIONBIENES)) {
				this.setMostrarcon_separacion_bienesCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOLISTAPRECIO)) {
				this.setMostrarid_tipo_lista_precioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.DETALLEESTADO)) {
				this.setMostrardetalle_estadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.ESCONTRIBUYENTEESPECIAL)) {
				this.setMostrares_contribuyente_especialCliente(esAsigna);
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
		
		
		this.setActivaridCliente(esInicial);
		this.setActivarid_empresaCliente(esInicial);
		this.setActivarid_sucursalCliente(esInicial);
		this.setActivarcodigoCliente(esInicial);
		this.setActivarid_tipo_identificacionCliente(esInicial);
		this.setActivaridentificacionCliente(esInicial);
		this.setActivarrucCliente(esInicial);
		this.setActivarnombreCliente(esInicial);
		this.setActivarapellidoCliente(esInicial);
		this.setActivarnombre_completoCliente(esInicial);
		this.setActivarnombre_comercialCliente(esInicial);
		this.setActivartelefonoCliente(esInicial);
		this.setActivardireccionCliente(esInicial);
		this.setActivares_proveCliente(esInicial);
		this.setActivarid_grupo_clienteCliente(esInicial);
		this.setActivarid_titulo_clienteCliente(esInicial);
		this.setActivarid_area_crCliente(esInicial);
		this.setActivarid_estado_clienteCliente(esInicial);
		this.setActivarobservacionCliente(esInicial);
		this.setActivarid_paisCliente(esInicial);
		this.setActivarid_regionCliente(esInicial);
		this.setActivarid_provinciaCliente(esInicial);
		this.setActivarid_ciudadCliente(esInicial);
		this.setActivarid_zonaCliente(esInicial);
		this.setActivarid_pais_nacionalidadCliente(esInicial);
		this.setActivarid_tipo_cargo_laboCliente(esInicial);
		this.setActivarid_tipo_nivel_eduCliente(esInicial);
		this.setActivarid_profesionCliente(esInicial);
		this.setActivarid_tipo_generoCliente(esInicial);
		this.setActivarid_estado_civilCliente(esInicial);
		this.setActivarid_estado_legalCliente(esInicial);
		this.setActivarfecha_nacimientoCliente(esInicial);
		this.setActivarpath_imagen_firmaCliente(esInicial);
		this.setActivarcontactoCliente(esInicial);
		this.setActivarid_cuenta_contableCliente(esInicial);
		this.setActivarid_rutaCliente(esInicial);
		this.setActivarid_vendedorCliente(esInicial);
		this.setActivarid_centro_actividadCliente(esInicial);
		this.setActivarrepresentanteCliente(esInicial);
		this.setActivarid_tipo_garantia_empresaCliente(esInicial);
		this.setActivarnombre_garantiaCliente(esInicial);
		this.setActivarvalor_garantiaCliente(esInicial);
		this.setActivarid_cate_tipo_afiliacionCliente(esInicial);
		this.setActivarnumero_cargaCliente(esInicial);
		this.setActivarcredito_usadoCliente(esInicial);
		this.setActivarlimite_creditoCliente(esInicial);
		this.setActivarcredito_disponibleCliente(esInicial);
		this.setActivartotal_documentosCliente(esInicial);
		this.setActivarfecha_ultima_facturaCliente(esInicial);
		this.setActivardescuentoCliente(esInicial);
		this.setActivarid_diaCliente(esInicial);
		this.setActivarhora_pagoCliente(esInicial);
		this.setActivarid_empleadoCliente(esInicial);
		this.setActivarcobranzasCliente(esInicial);
		this.setActivarmotivoCliente(esInicial);
		this.setActivarpreferenciaCliente(esInicial);
		this.setActivarcon_separacion_bienesCliente(esInicial);
		this.setActivarid_tipo_precioCliente(esInicial);
		this.setActivarid_tipo_lista_precioCliente(esInicial);
		this.setActivardetalle_estadoCliente(esInicial);
		this.setActivares_contribuyente_especialCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClienteConstantesFunciones.ID)) {
				this.setActivaridCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setActivarid_tipo_identificacionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDENTIFICACION)) {
				this.setActivaridentificacionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.RUC)) {
				this.setActivarrucCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.APELLIDO)) {
				this.setActivarapellidoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.NOMBRECOMERCIAL)) {
				this.setActivarnombre_comercialCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.DIRECCION)) {
				this.setActivardireccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.ESPROVE)) {
				this.setActivares_proveCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setActivarid_grupo_clienteCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTITULOCLIENTE)) {
				this.setActivarid_titulo_clienteCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDAREACR)) {
				this.setActivarid_area_crCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDESTADOCLIENTE)) {
				this.setActivarid_estado_clienteCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.OBSERVACION)) {
				this.setActivarobservacionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDREGION)) {
				this.setActivarid_regionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDPROVINCIA)) {
				this.setActivarid_provinciaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDZONA)) {
				this.setActivarid_zonaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDPAISNACIONALIDAD)) {
				this.setActivarid_pais_nacionalidadCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOCARGOLABO)) {
				this.setActivarid_tipo_cargo_laboCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPONIVELEDU)) {
				this.setActivarid_tipo_nivel_eduCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDPROFESION)) {
				this.setActivarid_profesionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOGENERO)) {
				this.setActivarid_tipo_generoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDESTADOCIVIL)) {
				this.setActivarid_estado_civilCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDESTADOLEGAL)) {
				this.setActivarid_estado_legalCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.FECHANACIMIENTO)) {
				this.setActivarfecha_nacimientoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.PATHIMAGENFIRMA)) {
				this.setActivarpath_imagen_firmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.CONTACTO)) {
				this.setActivarcontactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDRUTA)) {
				this.setActivarid_rutaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setActivarid_centro_actividadCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.REPRESENTANTE)) {
				this.setActivarrepresentanteCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA)) {
				this.setActivarid_tipo_garantia_empresaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.NOMBREGARANTIA)) {
				this.setActivarnombre_garantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.VALORGARANTIA)) {
				this.setActivarvalor_garantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDCATETIPOAFILIACION)) {
				this.setActivarid_cate_tipo_afiliacionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.NUMEROCARGA)) {
				this.setActivarnumero_cargaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.CREDITOUSADO)) {
				this.setActivarcredito_usadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.LIMITECREDITO)) {
				this.setActivarlimite_creditoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.CREDITODISPONIBLE)) {
				this.setActivarcredito_disponibleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.TOTALDOCUMENTOS)) {
				this.setActivartotal_documentosCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.FECHAULTIMAFACTURA)) {
				this.setActivarfecha_ultima_facturaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDDIA)) {
				this.setActivarid_diaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.HORAPAGO)) {
				this.setActivarhora_pagoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.COBRANZAS)) {
				this.setActivarcobranzasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.MOTIVO)) {
				this.setActivarmotivoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.PREFERENCIA)) {
				this.setActivarpreferenciaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.CONSEPARACIONBIENES)) {
				this.setActivarcon_separacion_bienesCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOLISTAPRECIO)) {
				this.setActivarid_tipo_lista_precioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.DETALLEESTADO)) {
				this.setActivardetalle_estadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.ESCONTRIBUYENTEESPECIAL)) {
				this.setActivares_contribuyente_especialCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCliente(esInicial);
		this.setResaltarid_empresaCliente(esInicial);
		this.setResaltarid_sucursalCliente(esInicial);
		this.setResaltarcodigoCliente(esInicial);
		this.setResaltarid_tipo_identificacionCliente(esInicial);
		this.setResaltaridentificacionCliente(esInicial);
		this.setResaltarrucCliente(esInicial);
		this.setResaltarnombreCliente(esInicial);
		this.setResaltarapellidoCliente(esInicial);
		this.setResaltarnombre_completoCliente(esInicial);
		this.setResaltarnombre_comercialCliente(esInicial);
		this.setResaltartelefonoCliente(esInicial);
		this.setResaltardireccionCliente(esInicial);
		this.setResaltares_proveCliente(esInicial);
		this.setResaltarid_grupo_clienteCliente(esInicial);
		this.setResaltarid_titulo_clienteCliente(esInicial);
		this.setResaltarid_area_crCliente(esInicial);
		this.setResaltarid_estado_clienteCliente(esInicial);
		this.setResaltarobservacionCliente(esInicial);
		this.setResaltarid_paisCliente(esInicial);
		this.setResaltarid_regionCliente(esInicial);
		this.setResaltarid_provinciaCliente(esInicial);
		this.setResaltarid_ciudadCliente(esInicial);
		this.setResaltarid_zonaCliente(esInicial);
		this.setResaltarid_pais_nacionalidadCliente(esInicial);
		this.setResaltarid_tipo_cargo_laboCliente(esInicial);
		this.setResaltarid_tipo_nivel_eduCliente(esInicial);
		this.setResaltarid_profesionCliente(esInicial);
		this.setResaltarid_tipo_generoCliente(esInicial);
		this.setResaltarid_estado_civilCliente(esInicial);
		this.setResaltarid_estado_legalCliente(esInicial);
		this.setResaltarfecha_nacimientoCliente(esInicial);
		this.setResaltarpath_imagen_firmaCliente(esInicial);
		this.setResaltarcontactoCliente(esInicial);
		this.setResaltarid_cuenta_contableCliente(esInicial);
		this.setResaltarid_rutaCliente(esInicial);
		this.setResaltarid_vendedorCliente(esInicial);
		this.setResaltarid_centro_actividadCliente(esInicial);
		this.setResaltarrepresentanteCliente(esInicial);
		this.setResaltarid_tipo_garantia_empresaCliente(esInicial);
		this.setResaltarnombre_garantiaCliente(esInicial);
		this.setResaltarvalor_garantiaCliente(esInicial);
		this.setResaltarid_cate_tipo_afiliacionCliente(esInicial);
		this.setResaltarnumero_cargaCliente(esInicial);
		this.setResaltarcredito_usadoCliente(esInicial);
		this.setResaltarlimite_creditoCliente(esInicial);
		this.setResaltarcredito_disponibleCliente(esInicial);
		this.setResaltartotal_documentosCliente(esInicial);
		this.setResaltarfecha_ultima_facturaCliente(esInicial);
		this.setResaltardescuentoCliente(esInicial);
		this.setResaltarid_diaCliente(esInicial);
		this.setResaltarhora_pagoCliente(esInicial);
		this.setResaltarid_empleadoCliente(esInicial);
		this.setResaltarcobranzasCliente(esInicial);
		this.setResaltarmotivoCliente(esInicial);
		this.setResaltarpreferenciaCliente(esInicial);
		this.setResaltarcon_separacion_bienesCliente(esInicial);
		this.setResaltarid_tipo_precioCliente(esInicial);
		this.setResaltarid_tipo_lista_precioCliente(esInicial);
		this.setResaltardetalle_estadoCliente(esInicial);
		this.setResaltares_contribuyente_especialCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ClienteConstantesFunciones.ID)) {
				this.setResaltaridCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOIDENTIFICACION)) {
				this.setResaltarid_tipo_identificacionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDENTIFICACION)) {
				this.setResaltaridentificacionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.RUC)) {
				this.setResaltarrucCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.APELLIDO)) {
				this.setResaltarapellidoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.NOMBRECOMERCIAL)) {
				this.setResaltarnombre_comercialCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.ESPROVE)) {
				this.setResaltares_proveCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setResaltarid_grupo_clienteCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTITULOCLIENTE)) {
				this.setResaltarid_titulo_clienteCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDAREACR)) {
				this.setResaltarid_area_crCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDESTADOCLIENTE)) {
				this.setResaltarid_estado_clienteCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.OBSERVACION)) {
				this.setResaltarobservacionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDREGION)) {
				this.setResaltarid_regionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDPROVINCIA)) {
				this.setResaltarid_provinciaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDZONA)) {
				this.setResaltarid_zonaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDPAISNACIONALIDAD)) {
				this.setResaltarid_pais_nacionalidadCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOCARGOLABO)) {
				this.setResaltarid_tipo_cargo_laboCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPONIVELEDU)) {
				this.setResaltarid_tipo_nivel_eduCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDPROFESION)) {
				this.setResaltarid_profesionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOGENERO)) {
				this.setResaltarid_tipo_generoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDESTADOCIVIL)) {
				this.setResaltarid_estado_civilCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDESTADOLEGAL)) {
				this.setResaltarid_estado_legalCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.FECHANACIMIENTO)) {
				this.setResaltarfecha_nacimientoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.PATHIMAGENFIRMA)) {
				this.setResaltarpath_imagen_firmaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.CONTACTO)) {
				this.setResaltarcontactoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDRUTA)) {
				this.setResaltarid_rutaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setResaltarid_centro_actividadCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.REPRESENTANTE)) {
				this.setResaltarrepresentanteCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA)) {
				this.setResaltarid_tipo_garantia_empresaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.NOMBREGARANTIA)) {
				this.setResaltarnombre_garantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.VALORGARANTIA)) {
				this.setResaltarvalor_garantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDCATETIPOAFILIACION)) {
				this.setResaltarid_cate_tipo_afiliacionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.NUMEROCARGA)) {
				this.setResaltarnumero_cargaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.CREDITOUSADO)) {
				this.setResaltarcredito_usadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.LIMITECREDITO)) {
				this.setResaltarlimite_creditoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.CREDITODISPONIBLE)) {
				this.setResaltarcredito_disponibleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.TOTALDOCUMENTOS)) {
				this.setResaltartotal_documentosCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.FECHAULTIMAFACTURA)) {
				this.setResaltarfecha_ultima_facturaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDDIA)) {
				this.setResaltarid_diaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.HORAPAGO)) {
				this.setResaltarhora_pagoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.COBRANZAS)) {
				this.setResaltarcobranzasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.MOTIVO)) {
				this.setResaltarmotivoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.PREFERENCIA)) {
				this.setResaltarpreferenciaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.CONSEPARACIONBIENES)) {
				this.setResaltarcon_separacion_bienesCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.IDTIPOLISTAPRECIO)) {
				this.setResaltarid_tipo_lista_precioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.DETALLEESTADO)) {
				this.setResaltardetalle_estadoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ClienteConstantesFunciones.ESCONTRIBUYENTEESPECIAL)) {
				this.setResaltares_contribuyente_especialCliente(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarInformacionLaboralCliente=null;

	public Border getResaltarInformacionLaboralCliente() {
		return this.resaltarInformacionLaboralCliente;
	}

	public void setResaltarInformacionLaboralCliente(Border borderResaltarInformacionLaboral) {
		if(borderResaltarInformacionLaboral!=null) {
			this.resaltarInformacionLaboralCliente= borderResaltarInformacionLaboral;
		}
	}

	public Border setResaltarInformacionLaboralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarInformacionLaboral=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarInformacionLaboral);
			
		this.resaltarInformacionLaboralCliente= borderResaltarInformacionLaboral;

		 return borderResaltarInformacionLaboral;
	}



	public Boolean mostrarInformacionLaboralCliente=true;

	public Boolean getMostrarInformacionLaboralCliente() {
		return this.mostrarInformacionLaboralCliente;
	}

	public void setMostrarInformacionLaboralCliente(Boolean visibilidadResaltarInformacionLaboral) {
		this.mostrarInformacionLaboralCliente= visibilidadResaltarInformacionLaboral;
	}



	public Boolean activarInformacionLaboralCliente=true;

	public Boolean gethabilitarResaltarInformacionLaboralCliente() {
		return this.activarInformacionLaboralCliente;
	}

	public void setActivarInformacionLaboralCliente(Boolean habilitarResaltarInformacionLaboral) {
		this.activarInformacionLaboralCliente= habilitarResaltarInformacionLaboral;
	}


	public Border resaltarTransportistaCliente=null;

	public Border getResaltarTransportistaCliente() {
		return this.resaltarTransportistaCliente;
	}

	public void setResaltarTransportistaCliente(Border borderResaltarTransportista) {
		if(borderResaltarTransportista!=null) {
			this.resaltarTransportistaCliente= borderResaltarTransportista;
		}
	}

	public Border setResaltarTransportistaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarTransportista=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarTransportista);
			
		this.resaltarTransportistaCliente= borderResaltarTransportista;

		 return borderResaltarTransportista;
	}



	public Boolean mostrarTransportistaCliente=true;

	public Boolean getMostrarTransportistaCliente() {
		return this.mostrarTransportistaCliente;
	}

	public void setMostrarTransportistaCliente(Boolean visibilidadResaltarTransportista) {
		this.mostrarTransportistaCliente= visibilidadResaltarTransportista;
	}



	public Boolean activarTransportistaCliente=true;

	public Boolean gethabilitarResaltarTransportistaCliente() {
		return this.activarTransportistaCliente;
	}

	public void setActivarTransportistaCliente(Boolean habilitarResaltarTransportista) {
		this.activarTransportistaCliente= habilitarResaltarTransportista;
	}


	public Border resaltarNovedadCliente=null;

	public Border getResaltarNovedadCliente() {
		return this.resaltarNovedadCliente;
	}

	public void setResaltarNovedadCliente(Border borderResaltarNovedad) {
		if(borderResaltarNovedad!=null) {
			this.resaltarNovedadCliente= borderResaltarNovedad;
		}
	}

	public Border setResaltarNovedadCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarNovedad=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarNovedad);
			
		this.resaltarNovedadCliente= borderResaltarNovedad;

		 return borderResaltarNovedad;
	}



	public Boolean mostrarNovedadCliente=true;

	public Boolean getMostrarNovedadCliente() {
		return this.mostrarNovedadCliente;
	}

	public void setMostrarNovedadCliente(Boolean visibilidadResaltarNovedad) {
		this.mostrarNovedadCliente= visibilidadResaltarNovedad;
	}



	public Boolean activarNovedadCliente=true;

	public Boolean gethabilitarResaltarNovedadCliente() {
		return this.activarNovedadCliente;
	}

	public void setActivarNovedadCliente(Boolean habilitarResaltarNovedad) {
		this.activarNovedadCliente= habilitarResaltarNovedad;
	}


	public Border resaltarPoliticasClienteCliente=null;

	public Border getResaltarPoliticasClienteCliente() {
		return this.resaltarPoliticasClienteCliente;
	}

	public void setResaltarPoliticasClienteCliente(Border borderResaltarPoliticasCliente) {
		if(borderResaltarPoliticasCliente!=null) {
			this.resaltarPoliticasClienteCliente= borderResaltarPoliticasCliente;
		}
	}

	public Border setResaltarPoliticasClienteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarPoliticasCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarPoliticasCliente);
			
		this.resaltarPoliticasClienteCliente= borderResaltarPoliticasCliente;

		 return borderResaltarPoliticasCliente;
	}



	public Boolean mostrarPoliticasClienteCliente=true;

	public Boolean getMostrarPoliticasClienteCliente() {
		return this.mostrarPoliticasClienteCliente;
	}

	public void setMostrarPoliticasClienteCliente(Boolean visibilidadResaltarPoliticasCliente) {
		this.mostrarPoliticasClienteCliente= visibilidadResaltarPoliticasCliente;
	}



	public Boolean activarPoliticasClienteCliente=true;

	public Boolean gethabilitarResaltarPoliticasClienteCliente() {
		return this.activarPoliticasClienteCliente;
	}

	public void setActivarPoliticasClienteCliente(Boolean habilitarResaltarPoliticasCliente) {
		this.activarPoliticasClienteCliente= habilitarResaltarPoliticasCliente;
	}


	public Border resaltarReferenciaPersonalCliente=null;

	public Border getResaltarReferenciaPersonalCliente() {
		return this.resaltarReferenciaPersonalCliente;
	}

	public void setResaltarReferenciaPersonalCliente(Border borderResaltarReferenciaPersonal) {
		if(borderResaltarReferenciaPersonal!=null) {
			this.resaltarReferenciaPersonalCliente= borderResaltarReferenciaPersonal;
		}
	}

	public Border setResaltarReferenciaPersonalCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarReferenciaPersonal=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarReferenciaPersonal);
			
		this.resaltarReferenciaPersonalCliente= borderResaltarReferenciaPersonal;

		 return borderResaltarReferenciaPersonal;
	}



	public Boolean mostrarReferenciaPersonalCliente=true;

	public Boolean getMostrarReferenciaPersonalCliente() {
		return this.mostrarReferenciaPersonalCliente;
	}

	public void setMostrarReferenciaPersonalCliente(Boolean visibilidadResaltarReferenciaPersonal) {
		this.mostrarReferenciaPersonalCliente= visibilidadResaltarReferenciaPersonal;
	}



	public Boolean activarReferenciaPersonalCliente=true;

	public Boolean gethabilitarResaltarReferenciaPersonalCliente() {
		return this.activarReferenciaPersonalCliente;
	}

	public void setActivarReferenciaPersonalCliente(Boolean habilitarResaltarReferenciaPersonal) {
		this.activarReferenciaPersonalCliente= habilitarResaltarReferenciaPersonal;
	}


	public Border resaltarBalanceGeneralClienteCliente=null;

	public Border getResaltarBalanceGeneralClienteCliente() {
		return this.resaltarBalanceGeneralClienteCliente;
	}

	public void setResaltarBalanceGeneralClienteCliente(Border borderResaltarBalanceGeneralCliente) {
		if(borderResaltarBalanceGeneralCliente!=null) {
			this.resaltarBalanceGeneralClienteCliente= borderResaltarBalanceGeneralCliente;
		}
	}

	public Border setResaltarBalanceGeneralClienteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarBalanceGeneralCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarBalanceGeneralCliente);
			
		this.resaltarBalanceGeneralClienteCliente= borderResaltarBalanceGeneralCliente;

		 return borderResaltarBalanceGeneralCliente;
	}



	public Boolean mostrarBalanceGeneralClienteCliente=true;

	public Boolean getMostrarBalanceGeneralClienteCliente() {
		return this.mostrarBalanceGeneralClienteCliente;
	}

	public void setMostrarBalanceGeneralClienteCliente(Boolean visibilidadResaltarBalanceGeneralCliente) {
		this.mostrarBalanceGeneralClienteCliente= visibilidadResaltarBalanceGeneralCliente;
	}



	public Boolean activarBalanceGeneralClienteCliente=true;

	public Boolean gethabilitarResaltarBalanceGeneralClienteCliente() {
		return this.activarBalanceGeneralClienteCliente;
	}

	public void setActivarBalanceGeneralClienteCliente(Boolean habilitarResaltarBalanceGeneralCliente) {
		this.activarBalanceGeneralClienteCliente= habilitarResaltarBalanceGeneralCliente;
	}


	public Border resaltarPoliticaClienteCliente=null;

	public Border getResaltarPoliticaClienteCliente() {
		return this.resaltarPoliticaClienteCliente;
	}

	public void setResaltarPoliticaClienteCliente(Border borderResaltarPoliticaCliente) {
		if(borderResaltarPoliticaCliente!=null) {
			this.resaltarPoliticaClienteCliente= borderResaltarPoliticaCliente;
		}
	}

	public Border setResaltarPoliticaClienteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarPoliticaCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarPoliticaCliente);
			
		this.resaltarPoliticaClienteCliente= borderResaltarPoliticaCliente;

		 return borderResaltarPoliticaCliente;
	}



	public Boolean mostrarPoliticaClienteCliente=true;

	public Boolean getMostrarPoliticaClienteCliente() {
		return this.mostrarPoliticaClienteCliente;
	}

	public void setMostrarPoliticaClienteCliente(Boolean visibilidadResaltarPoliticaCliente) {
		this.mostrarPoliticaClienteCliente= visibilidadResaltarPoliticaCliente;
	}



	public Boolean activarPoliticaClienteCliente=true;

	public Boolean gethabilitarResaltarPoliticaClienteCliente() {
		return this.activarPoliticaClienteCliente;
	}

	public void setActivarPoliticaClienteCliente(Boolean habilitarResaltarPoliticaCliente) {
		this.activarPoliticaClienteCliente= habilitarResaltarPoliticaCliente;
	}


	public Border resaltarVehiculoClienteCliente=null;

	public Border getResaltarVehiculoClienteCliente() {
		return this.resaltarVehiculoClienteCliente;
	}

	public void setResaltarVehiculoClienteCliente(Border borderResaltarVehiculoCliente) {
		if(borderResaltarVehiculoCliente!=null) {
			this.resaltarVehiculoClienteCliente= borderResaltarVehiculoCliente;
		}
	}

	public Border setResaltarVehiculoClienteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarVehiculoCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarVehiculoCliente);
			
		this.resaltarVehiculoClienteCliente= borderResaltarVehiculoCliente;

		 return borderResaltarVehiculoCliente;
	}



	public Boolean mostrarVehiculoClienteCliente=true;

	public Boolean getMostrarVehiculoClienteCliente() {
		return this.mostrarVehiculoClienteCliente;
	}

	public void setMostrarVehiculoClienteCliente(Boolean visibilidadResaltarVehiculoCliente) {
		this.mostrarVehiculoClienteCliente= visibilidadResaltarVehiculoCliente;
	}



	public Boolean activarVehiculoClienteCliente=true;

	public Boolean gethabilitarResaltarVehiculoClienteCliente() {
		return this.activarVehiculoClienteCliente;
	}

	public void setActivarVehiculoClienteCliente(Boolean habilitarResaltarVehiculoCliente) {
		this.activarVehiculoClienteCliente= habilitarResaltarVehiculoCliente;
	}


	public Border resaltarResponsableCliente=null;

	public Border getResaltarResponsableCliente() {
		return this.resaltarResponsableCliente;
	}

	public void setResaltarResponsableCliente(Border borderResaltarResponsable) {
		if(borderResaltarResponsable!=null) {
			this.resaltarResponsableCliente= borderResaltarResponsable;
		}
	}

	public Border setResaltarResponsableCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarResponsable=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarResponsable);
			
		this.resaltarResponsableCliente= borderResaltarResponsable;

		 return borderResaltarResponsable;
	}



	public Boolean mostrarResponsableCliente=true;

	public Boolean getMostrarResponsableCliente() {
		return this.mostrarResponsableCliente;
	}

	public void setMostrarResponsableCliente(Boolean visibilidadResaltarResponsable) {
		this.mostrarResponsableCliente= visibilidadResaltarResponsable;
	}



	public Boolean activarResponsableCliente=true;

	public Boolean gethabilitarResaltarResponsableCliente() {
		return this.activarResponsableCliente;
	}

	public void setActivarResponsableCliente(Boolean habilitarResaltarResponsable) {
		this.activarResponsableCliente= habilitarResaltarResponsable;
	}


	public Border resaltarInformacionFinancieraCliente=null;

	public Border getResaltarInformacionFinancieraCliente() {
		return this.resaltarInformacionFinancieraCliente;
	}

	public void setResaltarInformacionFinancieraCliente(Border borderResaltarInformacionFinanciera) {
		if(borderResaltarInformacionFinanciera!=null) {
			this.resaltarInformacionFinancieraCliente= borderResaltarInformacionFinanciera;
		}
	}

	public Border setResaltarInformacionFinancieraCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarInformacionFinanciera=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarInformacionFinanciera);
			
		this.resaltarInformacionFinancieraCliente= borderResaltarInformacionFinanciera;

		 return borderResaltarInformacionFinanciera;
	}



	public Boolean mostrarInformacionFinancieraCliente=true;

	public Boolean getMostrarInformacionFinancieraCliente() {
		return this.mostrarInformacionFinancieraCliente;
	}

	public void setMostrarInformacionFinancieraCliente(Boolean visibilidadResaltarInformacionFinanciera) {
		this.mostrarInformacionFinancieraCliente= visibilidadResaltarInformacionFinanciera;
	}



	public Boolean activarInformacionFinancieraCliente=true;

	public Boolean gethabilitarResaltarInformacionFinancieraCliente() {
		return this.activarInformacionFinancieraCliente;
	}

	public void setActivarInformacionFinancieraCliente(Boolean habilitarResaltarInformacionFinanciera) {
		this.activarInformacionFinancieraCliente= habilitarResaltarInformacionFinanciera;
	}


	public Border resaltarConsignatarioCliente=null;

	public Border getResaltarConsignatarioCliente() {
		return this.resaltarConsignatarioCliente;
	}

	public void setResaltarConsignatarioCliente(Border borderResaltarConsignatario) {
		if(borderResaltarConsignatario!=null) {
			this.resaltarConsignatarioCliente= borderResaltarConsignatario;
		}
	}

	public Border setResaltarConsignatarioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarConsignatario=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarConsignatario);
			
		this.resaltarConsignatarioCliente= borderResaltarConsignatario;

		 return borderResaltarConsignatario;
	}



	public Boolean mostrarConsignatarioCliente=true;

	public Boolean getMostrarConsignatarioCliente() {
		return this.mostrarConsignatarioCliente;
	}

	public void setMostrarConsignatarioCliente(Boolean visibilidadResaltarConsignatario) {
		this.mostrarConsignatarioCliente= visibilidadResaltarConsignatario;
	}



	public Boolean activarConsignatarioCliente=true;

	public Boolean gethabilitarResaltarConsignatarioCliente() {
		return this.activarConsignatarioCliente;
	}

	public void setActivarConsignatarioCliente(Boolean habilitarResaltarConsignatario) {
		this.activarConsignatarioCliente= habilitarResaltarConsignatario;
	}


	public Border resaltarClienteImagenCliente=null;

	public Border getResaltarClienteImagenCliente() {
		return this.resaltarClienteImagenCliente;
	}

	public void setResaltarClienteImagenCliente(Border borderResaltarClienteImagen) {
		if(borderResaltarClienteImagen!=null) {
			this.resaltarClienteImagenCliente= borderResaltarClienteImagen;
		}
	}

	public Border setResaltarClienteImagenCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarClienteImagen=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarClienteImagen);
			
		this.resaltarClienteImagenCliente= borderResaltarClienteImagen;

		 return borderResaltarClienteImagen;
	}



	public Boolean mostrarClienteImagenCliente=true;

	public Boolean getMostrarClienteImagenCliente() {
		return this.mostrarClienteImagenCliente;
	}

	public void setMostrarClienteImagenCliente(Boolean visibilidadResaltarClienteImagen) {
		this.mostrarClienteImagenCliente= visibilidadResaltarClienteImagen;
	}



	public Boolean activarClienteImagenCliente=true;

	public Boolean gethabilitarResaltarClienteImagenCliente() {
		return this.activarClienteImagenCliente;
	}

	public void setActivarClienteImagenCliente(Boolean habilitarResaltarClienteImagen) {
		this.activarClienteImagenCliente= habilitarResaltarClienteImagen;
	}


	public Border resaltarGarantiaClienteCliente=null;

	public Border getResaltarGarantiaClienteCliente() {
		return this.resaltarGarantiaClienteCliente;
	}

	public void setResaltarGarantiaClienteCliente(Border borderResaltarGarantiaCliente) {
		if(borderResaltarGarantiaCliente!=null) {
			this.resaltarGarantiaClienteCliente= borderResaltarGarantiaCliente;
		}
	}

	public Border setResaltarGarantiaClienteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarGarantiaCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarGarantiaCliente);
			
		this.resaltarGarantiaClienteCliente= borderResaltarGarantiaCliente;

		 return borderResaltarGarantiaCliente;
	}



	public Boolean mostrarGarantiaClienteCliente=true;

	public Boolean getMostrarGarantiaClienteCliente() {
		return this.mostrarGarantiaClienteCliente;
	}

	public void setMostrarGarantiaClienteCliente(Boolean visibilidadResaltarGarantiaCliente) {
		this.mostrarGarantiaClienteCliente= visibilidadResaltarGarantiaCliente;
	}



	public Boolean activarGarantiaClienteCliente=true;

	public Boolean gethabilitarResaltarGarantiaClienteCliente() {
		return this.activarGarantiaClienteCliente;
	}

	public void setActivarGarantiaClienteCliente(Boolean habilitarResaltarGarantiaCliente) {
		this.activarGarantiaClienteCliente= habilitarResaltarGarantiaCliente;
	}


	public Border resaltarInformacionEconomicaCliente=null;

	public Border getResaltarInformacionEconomicaCliente() {
		return this.resaltarInformacionEconomicaCliente;
	}

	public void setResaltarInformacionEconomicaCliente(Border borderResaltarInformacionEconomica) {
		if(borderResaltarInformacionEconomica!=null) {
			this.resaltarInformacionEconomicaCliente= borderResaltarInformacionEconomica;
		}
	}

	public Border setResaltarInformacionEconomicaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarInformacionEconomica=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarInformacionEconomica);
			
		this.resaltarInformacionEconomicaCliente= borderResaltarInformacionEconomica;

		 return borderResaltarInformacionEconomica;
	}



	public Boolean mostrarInformacionEconomicaCliente=true;

	public Boolean getMostrarInformacionEconomicaCliente() {
		return this.mostrarInformacionEconomicaCliente;
	}

	public void setMostrarInformacionEconomicaCliente(Boolean visibilidadResaltarInformacionEconomica) {
		this.mostrarInformacionEconomicaCliente= visibilidadResaltarInformacionEconomica;
	}



	public Boolean activarInformacionEconomicaCliente=true;

	public Boolean gethabilitarResaltarInformacionEconomicaCliente() {
		return this.activarInformacionEconomicaCliente;
	}

	public void setActivarInformacionEconomicaCliente(Boolean habilitarResaltarInformacionEconomica) {
		this.activarInformacionEconomicaCliente= habilitarResaltarInformacionEconomica;
	}


	public Border resaltarReferenciaComercialCliente=null;

	public Border getResaltarReferenciaComercialCliente() {
		return this.resaltarReferenciaComercialCliente;
	}

	public void setResaltarReferenciaComercialCliente(Border borderResaltarReferenciaComercial) {
		if(borderResaltarReferenciaComercial!=null) {
			this.resaltarReferenciaComercialCliente= borderResaltarReferenciaComercial;
		}
	}

	public Border setResaltarReferenciaComercialCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarReferenciaComercial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarReferenciaComercial);
			
		this.resaltarReferenciaComercialCliente= borderResaltarReferenciaComercial;

		 return borderResaltarReferenciaComercial;
	}



	public Boolean mostrarReferenciaComercialCliente=true;

	public Boolean getMostrarReferenciaComercialCliente() {
		return this.mostrarReferenciaComercialCliente;
	}

	public void setMostrarReferenciaComercialCliente(Boolean visibilidadResaltarReferenciaComercial) {
		this.mostrarReferenciaComercialCliente= visibilidadResaltarReferenciaComercial;
	}



	public Boolean activarReferenciaComercialCliente=true;

	public Boolean gethabilitarResaltarReferenciaComercialCliente() {
		return this.activarReferenciaComercialCliente;
	}

	public void setActivarReferenciaComercialCliente(Boolean habilitarResaltarReferenciaComercial) {
		this.activarReferenciaComercialCliente= habilitarResaltarReferenciaComercial;
	}


	public Border resaltarBienCliente=null;

	public Border getResaltarBienCliente() {
		return this.resaltarBienCliente;
	}

	public void setResaltarBienCliente(Border borderResaltarBien) {
		if(borderResaltarBien!=null) {
			this.resaltarBienCliente= borderResaltarBien;
		}
	}

	public Border setResaltarBienCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarBien=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarBien);
			
		this.resaltarBienCliente= borderResaltarBien;

		 return borderResaltarBien;
	}



	public Boolean mostrarBienCliente=true;

	public Boolean getMostrarBienCliente() {
		return this.mostrarBienCliente;
	}

	public void setMostrarBienCliente(Boolean visibilidadResaltarBien) {
		this.mostrarBienCliente= visibilidadResaltarBien;
	}



	public Boolean activarBienCliente=true;

	public Boolean gethabilitarResaltarBienCliente() {
		return this.activarBienCliente;
	}

	public void setActivarBienCliente(Boolean habilitarResaltarBien) {
		this.activarBienCliente= habilitarResaltarBien;
	}


	public Border resaltarProveedorProductoCliente=null;

	public Border getResaltarProveedorProductoCliente() {
		return this.resaltarProveedorProductoCliente;
	}

	public void setResaltarProveedorProductoCliente(Border borderResaltarProveedorProducto) {
		if(borderResaltarProveedorProducto!=null) {
			this.resaltarProveedorProductoCliente= borderResaltarProveedorProducto;
		}
	}

	public Border setResaltarProveedorProductoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarProveedorProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarProveedorProducto);
			
		this.resaltarProveedorProductoCliente= borderResaltarProveedorProducto;

		 return borderResaltarProveedorProducto;
	}



	public Boolean mostrarProveedorProductoCliente=true;

	public Boolean getMostrarProveedorProductoCliente() {
		return this.mostrarProveedorProductoCliente;
	}

	public void setMostrarProveedorProductoCliente(Boolean visibilidadResaltarProveedorProducto) {
		this.mostrarProveedorProductoCliente= visibilidadResaltarProveedorProducto;
	}



	public Boolean activarProveedorProductoCliente=true;

	public Boolean gethabilitarResaltarProveedorProductoCliente() {
		return this.activarProveedorProductoCliente;
	}

	public void setActivarProveedorProductoCliente(Boolean habilitarResaltarProveedorProducto) {
		this.activarProveedorProductoCliente= habilitarResaltarProveedorProducto;
	}


	public Border resaltarServicioClienteCliente=null;

	public Border getResaltarServicioClienteCliente() {
		return this.resaltarServicioClienteCliente;
	}

	public void setResaltarServicioClienteCliente(Border borderResaltarServicioCliente) {
		if(borderResaltarServicioCliente!=null) {
			this.resaltarServicioClienteCliente= borderResaltarServicioCliente;
		}
	}

	public Border setResaltarServicioClienteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarServicioCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarServicioCliente);
			
		this.resaltarServicioClienteCliente= borderResaltarServicioCliente;

		 return borderResaltarServicioCliente;
	}



	public Boolean mostrarServicioClienteCliente=true;

	public Boolean getMostrarServicioClienteCliente() {
		return this.mostrarServicioClienteCliente;
	}

	public void setMostrarServicioClienteCliente(Boolean visibilidadResaltarServicioCliente) {
		this.mostrarServicioClienteCliente= visibilidadResaltarServicioCliente;
	}



	public Boolean activarServicioClienteCliente=true;

	public Boolean gethabilitarResaltarServicioClienteCliente() {
		return this.activarServicioClienteCliente;
	}

	public void setActivarServicioClienteCliente(Boolean habilitarResaltarServicioCliente) {
		this.activarServicioClienteCliente= habilitarResaltarServicioCliente;
	}


	public Border resaltarContactoClienteCliente=null;

	public Border getResaltarContactoClienteCliente() {
		return this.resaltarContactoClienteCliente;
	}

	public void setResaltarContactoClienteCliente(Border borderResaltarContactoCliente) {
		if(borderResaltarContactoCliente!=null) {
			this.resaltarContactoClienteCliente= borderResaltarContactoCliente;
		}
	}

	public Border setResaltarContactoClienteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarContactoCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarContactoCliente);
			
		this.resaltarContactoClienteCliente= borderResaltarContactoCliente;

		 return borderResaltarContactoCliente;
	}



	public Boolean mostrarContactoClienteCliente=true;

	public Boolean getMostrarContactoClienteCliente() {
		return this.mostrarContactoClienteCliente;
	}

	public void setMostrarContactoClienteCliente(Boolean visibilidadResaltarContactoCliente) {
		this.mostrarContactoClienteCliente= visibilidadResaltarContactoCliente;
	}



	public Boolean activarContactoClienteCliente=true;

	public Boolean gethabilitarResaltarContactoClienteCliente() {
		return this.activarContactoClienteCliente;
	}

	public void setActivarContactoClienteCliente(Boolean habilitarResaltarContactoCliente) {
		this.activarContactoClienteCliente= habilitarResaltarContactoCliente;
	}


	public Border resaltarDatoConstitucionCliente=null;

	public Border getResaltarDatoConstitucionCliente() {
		return this.resaltarDatoConstitucionCliente;
	}

	public void setResaltarDatoConstitucionCliente(Border borderResaltarDatoConstitucion) {
		if(borderResaltarDatoConstitucion!=null) {
			this.resaltarDatoConstitucionCliente= borderResaltarDatoConstitucion;
		}
	}

	public Border setResaltarDatoConstitucionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarDatoConstitucion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarDatoConstitucion);
			
		this.resaltarDatoConstitucionCliente= borderResaltarDatoConstitucion;

		 return borderResaltarDatoConstitucion;
	}



	public Boolean mostrarDatoConstitucionCliente=true;

	public Boolean getMostrarDatoConstitucionCliente() {
		return this.mostrarDatoConstitucionCliente;
	}

	public void setMostrarDatoConstitucionCliente(Boolean visibilidadResaltarDatoConstitucion) {
		this.mostrarDatoConstitucionCliente= visibilidadResaltarDatoConstitucion;
	}



	public Boolean activarDatoConstitucionCliente=true;

	public Boolean gethabilitarResaltarDatoConstitucionCliente() {
		return this.activarDatoConstitucionCliente;
	}

	public void setActivarDatoConstitucionCliente(Boolean habilitarResaltarDatoConstitucion) {
		this.activarDatoConstitucionCliente= habilitarResaltarDatoConstitucion;
	}


	public Border resaltarClienteCoaCliente=null;

	public Border getResaltarClienteCoaCliente() {
		return this.resaltarClienteCoaCliente;
	}

	public void setResaltarClienteCoaCliente(Border borderResaltarClienteCoa) {
		if(borderResaltarClienteCoa!=null) {
			this.resaltarClienteCoaCliente= borderResaltarClienteCoa;
		}
	}

	public Border setResaltarClienteCoaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarClienteCoa=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarClienteCoa);
			
		this.resaltarClienteCoaCliente= borderResaltarClienteCoa;

		 return borderResaltarClienteCoa;
	}



	public Boolean mostrarClienteCoaCliente=true;

	public Boolean getMostrarClienteCoaCliente() {
		return this.mostrarClienteCoaCliente;
	}

	public void setMostrarClienteCoaCliente(Boolean visibilidadResaltarClienteCoa) {
		this.mostrarClienteCoaCliente= visibilidadResaltarClienteCoa;
	}



	public Boolean activarClienteCoaCliente=true;

	public Boolean gethabilitarResaltarClienteCoaCliente() {
		return this.activarClienteCoaCliente;
	}

	public void setActivarClienteCoaCliente(Boolean habilitarResaltarClienteCoa) {
		this.activarClienteCoaCliente= habilitarResaltarClienteCoa;
	}


	public Border resaltarHobbyClienteCliente=null;

	public Border getResaltarHobbyClienteCliente() {
		return this.resaltarHobbyClienteCliente;
	}

	public void setResaltarHobbyClienteCliente(Border borderResaltarHobbyCliente) {
		if(borderResaltarHobbyCliente!=null) {
			this.resaltarHobbyClienteCliente= borderResaltarHobbyCliente;
		}
	}

	public Border setResaltarHobbyClienteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarHobbyCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarHobbyCliente);
			
		this.resaltarHobbyClienteCliente= borderResaltarHobbyCliente;

		 return borderResaltarHobbyCliente;
	}



	public Boolean mostrarHobbyClienteCliente=true;

	public Boolean getMostrarHobbyClienteCliente() {
		return this.mostrarHobbyClienteCliente;
	}

	public void setMostrarHobbyClienteCliente(Boolean visibilidadResaltarHobbyCliente) {
		this.mostrarHobbyClienteCliente= visibilidadResaltarHobbyCliente;
	}



	public Boolean activarHobbyClienteCliente=true;

	public Boolean gethabilitarResaltarHobbyClienteCliente() {
		return this.activarHobbyClienteCliente;
	}

	public void setActivarHobbyClienteCliente(Boolean habilitarResaltarHobbyCliente) {
		this.activarHobbyClienteCliente= habilitarResaltarHobbyCliente;
	}


	public Border resaltarCargaFamiliarCliente=null;

	public Border getResaltarCargaFamiliarCliente() {
		return this.resaltarCargaFamiliarCliente;
	}

	public void setResaltarCargaFamiliarCliente(Border borderResaltarCargaFamiliar) {
		if(borderResaltarCargaFamiliar!=null) {
			this.resaltarCargaFamiliarCliente= borderResaltarCargaFamiliar;
		}
	}

	public Border setResaltarCargaFamiliarCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarCargaFamiliar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarCargaFamiliar);
			
		this.resaltarCargaFamiliarCliente= borderResaltarCargaFamiliar;

		 return borderResaltarCargaFamiliar;
	}



	public Boolean mostrarCargaFamiliarCliente=true;

	public Boolean getMostrarCargaFamiliarCliente() {
		return this.mostrarCargaFamiliarCliente;
	}

	public void setMostrarCargaFamiliarCliente(Boolean visibilidadResaltarCargaFamiliar) {
		this.mostrarCargaFamiliarCliente= visibilidadResaltarCargaFamiliar;
	}



	public Boolean activarCargaFamiliarCliente=true;

	public Boolean gethabilitarResaltarCargaFamiliarCliente() {
		return this.activarCargaFamiliarCliente;
	}

	public void setActivarCargaFamiliarCliente(Boolean habilitarResaltarCargaFamiliar) {
		this.activarCargaFamiliarCliente= habilitarResaltarCargaFamiliar;
	}


	public Border resaltarEMailCliente=null;

	public Border getResaltarEMailCliente() {
		return this.resaltarEMailCliente;
	}

	public void setResaltarEMailCliente(Border borderResaltarEMail) {
		if(borderResaltarEMail!=null) {
			this.resaltarEMailCliente= borderResaltarEMail;
		}
	}

	public Border setResaltarEMailCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarEMail=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarEMail);
			
		this.resaltarEMailCliente= borderResaltarEMail;

		 return borderResaltarEMail;
	}



	public Boolean mostrarEMailCliente=true;

	public Boolean getMostrarEMailCliente() {
		return this.mostrarEMailCliente;
	}

	public void setMostrarEMailCliente(Boolean visibilidadResaltarEMail) {
		this.mostrarEMailCliente= visibilidadResaltarEMail;
	}



	public Boolean activarEMailCliente=true;

	public Boolean gethabilitarResaltarEMailCliente() {
		return this.activarEMailCliente;
	}

	public void setActivarEMailCliente(Boolean habilitarResaltarEMail) {
		this.activarEMailCliente= habilitarResaltarEMail;
	}


	public Border resaltarConyugeCliente=null;

	public Border getResaltarConyugeCliente() {
		return this.resaltarConyugeCliente;
	}

	public void setResaltarConyugeCliente(Border borderResaltarConyuge) {
		if(borderResaltarConyuge!=null) {
			this.resaltarConyugeCliente= borderResaltarConyuge;
		}
	}

	public Border setResaltarConyugeCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarConyuge=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarConyuge);
			
		this.resaltarConyugeCliente= borderResaltarConyuge;

		 return borderResaltarConyuge;
	}



	public Boolean mostrarConyugeCliente=true;

	public Boolean getMostrarConyugeCliente() {
		return this.mostrarConyugeCliente;
	}

	public void setMostrarConyugeCliente(Boolean visibilidadResaltarConyuge) {
		this.mostrarConyugeCliente= visibilidadResaltarConyuge;
	}



	public Boolean activarConyugeCliente=true;

	public Boolean gethabilitarResaltarConyugeCliente() {
		return this.activarConyugeCliente;
	}

	public void setActivarConyugeCliente(Boolean habilitarResaltarConyuge) {
		this.activarConyugeCliente= habilitarResaltarConyuge;
	}


	public Border resaltarCuentaPorCobrarCliente=null;

	public Border getResaltarCuentaPorCobrarCliente() {
		return this.resaltarCuentaPorCobrarCliente;
	}

	public void setResaltarCuentaPorCobrarCliente(Border borderResaltarCuentaPorCobrar) {
		if(borderResaltarCuentaPorCobrar!=null) {
			this.resaltarCuentaPorCobrarCliente= borderResaltarCuentaPorCobrar;
		}
	}

	public Border setResaltarCuentaPorCobrarCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarCuentaPorCobrar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarCuentaPorCobrar);
			
		this.resaltarCuentaPorCobrarCliente= borderResaltarCuentaPorCobrar;

		 return borderResaltarCuentaPorCobrar;
	}



	public Boolean mostrarCuentaPorCobrarCliente=true;

	public Boolean getMostrarCuentaPorCobrarCliente() {
		return this.mostrarCuentaPorCobrarCliente;
	}

	public void setMostrarCuentaPorCobrarCliente(Boolean visibilidadResaltarCuentaPorCobrar) {
		this.mostrarCuentaPorCobrarCliente= visibilidadResaltarCuentaPorCobrar;
	}



	public Boolean activarCuentaPorCobrarCliente=true;

	public Boolean gethabilitarResaltarCuentaPorCobrarCliente() {
		return this.activarCuentaPorCobrarCliente;
	}

	public void setActivarCuentaPorCobrarCliente(Boolean habilitarResaltarCuentaPorCobrar) {
		this.activarCuentaPorCobrarCliente= habilitarResaltarCuentaPorCobrar;
	}


	public Border resaltarFirmaClienteCliente=null;

	public Border getResaltarFirmaClienteCliente() {
		return this.resaltarFirmaClienteCliente;
	}

	public void setResaltarFirmaClienteCliente(Border borderResaltarFirmaCliente) {
		if(borderResaltarFirmaCliente!=null) {
			this.resaltarFirmaClienteCliente= borderResaltarFirmaCliente;
		}
	}

	public Border setResaltarFirmaClienteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarFirmaCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarFirmaCliente);
			
		this.resaltarFirmaClienteCliente= borderResaltarFirmaCliente;

		 return borderResaltarFirmaCliente;
	}



	public Boolean mostrarFirmaClienteCliente=true;

	public Boolean getMostrarFirmaClienteCliente() {
		return this.mostrarFirmaClienteCliente;
	}

	public void setMostrarFirmaClienteCliente(Boolean visibilidadResaltarFirmaCliente) {
		this.mostrarFirmaClienteCliente= visibilidadResaltarFirmaCliente;
	}



	public Boolean activarFirmaClienteCliente=true;

	public Boolean gethabilitarResaltarFirmaClienteCliente() {
		return this.activarFirmaClienteCliente;
	}

	public void setActivarFirmaClienteCliente(Boolean habilitarResaltarFirmaCliente) {
		this.activarFirmaClienteCliente= habilitarResaltarFirmaCliente;
	}


	public Border resaltarRepresentanteLegalCliente=null;

	public Border getResaltarRepresentanteLegalCliente() {
		return this.resaltarRepresentanteLegalCliente;
	}

	public void setResaltarRepresentanteLegalCliente(Border borderResaltarRepresentanteLegal) {
		if(borderResaltarRepresentanteLegal!=null) {
			this.resaltarRepresentanteLegalCliente= borderResaltarRepresentanteLegal;
		}
	}

	public Border setResaltarRepresentanteLegalCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarRepresentanteLegal=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarRepresentanteLegal);
			
		this.resaltarRepresentanteLegalCliente= borderResaltarRepresentanteLegal;

		 return borderResaltarRepresentanteLegal;
	}



	public Boolean mostrarRepresentanteLegalCliente=true;

	public Boolean getMostrarRepresentanteLegalCliente() {
		return this.mostrarRepresentanteLegalCliente;
	}

	public void setMostrarRepresentanteLegalCliente(Boolean visibilidadResaltarRepresentanteLegal) {
		this.mostrarRepresentanteLegalCliente= visibilidadResaltarRepresentanteLegal;
	}



	public Boolean activarRepresentanteLegalCliente=true;

	public Boolean gethabilitarResaltarRepresentanteLegalCliente() {
		return this.activarRepresentanteLegalCliente;
	}

	public void setActivarRepresentanteLegalCliente(Boolean habilitarResaltarRepresentanteLegal) {
		this.activarRepresentanteLegalCliente= habilitarResaltarRepresentanteLegal;
	}


	public Border resaltarTelefonoCliente=null;

	public Border getResaltarTelefonoCliente() {
		return this.resaltarTelefonoCliente;
	}

	public void setResaltarTelefonoCliente(Border borderResaltarTelefono) {
		if(borderResaltarTelefono!=null) {
			this.resaltarTelefonoCliente= borderResaltarTelefono;
		}
	}

	public Border setResaltarTelefonoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarTelefono=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarTelefono);
			
		this.resaltarTelefonoCliente= borderResaltarTelefono;

		 return borderResaltarTelefono;
	}



	public Boolean mostrarTelefonoCliente=true;

	public Boolean getMostrarTelefonoCliente() {
		return this.mostrarTelefonoCliente;
	}

	public void setMostrarTelefonoCliente(Boolean visibilidadResaltarTelefono) {
		this.mostrarTelefonoCliente= visibilidadResaltarTelefono;
	}



	public Boolean activarTelefonoCliente=true;

	public Boolean gethabilitarResaltarTelefonoCliente() {
		return this.activarTelefonoCliente;
	}

	public void setActivarTelefonoCliente(Boolean habilitarResaltarTelefono) {
		this.activarTelefonoCliente= habilitarResaltarTelefono;
	}


	public Border resaltarNegocioClienteCliente=null;

	public Border getResaltarNegocioClienteCliente() {
		return this.resaltarNegocioClienteCliente;
	}

	public void setResaltarNegocioClienteCliente(Border borderResaltarNegocioCliente) {
		if(borderResaltarNegocioCliente!=null) {
			this.resaltarNegocioClienteCliente= borderResaltarNegocioCliente;
		}
	}

	public Border setResaltarNegocioClienteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarNegocioCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarNegocioCliente);
			
		this.resaltarNegocioClienteCliente= borderResaltarNegocioCliente;

		 return borderResaltarNegocioCliente;
	}



	public Boolean mostrarNegocioClienteCliente=true;

	public Boolean getMostrarNegocioClienteCliente() {
		return this.mostrarNegocioClienteCliente;
	}

	public void setMostrarNegocioClienteCliente(Boolean visibilidadResaltarNegocioCliente) {
		this.mostrarNegocioClienteCliente= visibilidadResaltarNegocioCliente;
	}



	public Boolean activarNegocioClienteCliente=true;

	public Boolean gethabilitarResaltarNegocioClienteCliente() {
		return this.activarNegocioClienteCliente;
	}

	public void setActivarNegocioClienteCliente(Boolean habilitarResaltarNegocioCliente) {
		this.activarNegocioClienteCliente= habilitarResaltarNegocioCliente;
	}


	public Border resaltarReferenciaBancariaCliente=null;

	public Border getResaltarReferenciaBancariaCliente() {
		return this.resaltarReferenciaBancariaCliente;
	}

	public void setResaltarReferenciaBancariaCliente(Border borderResaltarReferenciaBancaria) {
		if(borderResaltarReferenciaBancaria!=null) {
			this.resaltarReferenciaBancariaCliente= borderResaltarReferenciaBancaria;
		}
	}

	public Border setResaltarReferenciaBancariaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarReferenciaBancaria=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarReferenciaBancaria);
			
		this.resaltarReferenciaBancariaCliente= borderResaltarReferenciaBancaria;

		 return borderResaltarReferenciaBancaria;
	}



	public Boolean mostrarReferenciaBancariaCliente=true;

	public Boolean getMostrarReferenciaBancariaCliente() {
		return this.mostrarReferenciaBancariaCliente;
	}

	public void setMostrarReferenciaBancariaCliente(Boolean visibilidadResaltarReferenciaBancaria) {
		this.mostrarReferenciaBancariaCliente= visibilidadResaltarReferenciaBancaria;
	}



	public Boolean activarReferenciaBancariaCliente=true;

	public Boolean gethabilitarResaltarReferenciaBancariaCliente() {
		return this.activarReferenciaBancariaCliente;
	}

	public void setActivarReferenciaBancariaCliente(Boolean habilitarResaltarReferenciaBancaria) {
		this.activarReferenciaBancariaCliente= habilitarResaltarReferenciaBancaria;
	}


	public Border resaltarMontoCliente=null;

	public Border getResaltarMontoCliente() {
		return this.resaltarMontoCliente;
	}

	public void setResaltarMontoCliente(Border borderResaltarMonto) {
		if(borderResaltarMonto!=null) {
			this.resaltarMontoCliente= borderResaltarMonto;
		}
	}

	public Border setResaltarMontoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarMonto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarMonto);
			
		this.resaltarMontoCliente= borderResaltarMonto;

		 return borderResaltarMonto;
	}



	public Boolean mostrarMontoCliente=true;

	public Boolean getMostrarMontoCliente() {
		return this.mostrarMontoCliente;
	}

	public void setMostrarMontoCliente(Boolean visibilidadResaltarMonto) {
		this.mostrarMontoCliente= visibilidadResaltarMonto;
	}



	public Boolean activarMontoCliente=true;

	public Boolean gethabilitarResaltarMontoCliente() {
		return this.activarMontoCliente;
	}

	public void setActivarMontoCliente(Boolean habilitarResaltarMonto) {
		this.activarMontoCliente= habilitarResaltarMonto;
	}


	public Border resaltarClienteArchivoCliente=null;

	public Border getResaltarClienteArchivoCliente() {
		return this.resaltarClienteArchivoCliente;
	}

	public void setResaltarClienteArchivoCliente(Border borderResaltarClienteArchivo) {
		if(borderResaltarClienteArchivo!=null) {
			this.resaltarClienteArchivoCliente= borderResaltarClienteArchivo;
		}
	}

	public Border setResaltarClienteArchivoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarClienteArchivo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarClienteArchivo);
			
		this.resaltarClienteArchivoCliente= borderResaltarClienteArchivo;

		 return borderResaltarClienteArchivo;
	}



	public Boolean mostrarClienteArchivoCliente=true;

	public Boolean getMostrarClienteArchivoCliente() {
		return this.mostrarClienteArchivoCliente;
	}

	public void setMostrarClienteArchivoCliente(Boolean visibilidadResaltarClienteArchivo) {
		this.mostrarClienteArchivoCliente= visibilidadResaltarClienteArchivo;
	}



	public Boolean activarClienteArchivoCliente=true;

	public Boolean gethabilitarResaltarClienteArchivoCliente() {
		return this.activarClienteArchivoCliente;
	}

	public void setActivarClienteArchivoCliente(Boolean habilitarResaltarClienteArchivo) {
		this.activarClienteArchivoCliente= habilitarResaltarClienteArchivo;
	}


	public Border resaltarActividadEconomicaCliente=null;

	public Border getResaltarActividadEconomicaCliente() {
		return this.resaltarActividadEconomicaCliente;
	}

	public void setResaltarActividadEconomicaCliente(Border borderResaltarActividadEconomica) {
		if(borderResaltarActividadEconomica!=null) {
			this.resaltarActividadEconomicaCliente= borderResaltarActividadEconomica;
		}
	}

	public Border setResaltarActividadEconomicaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarActividadEconomica=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarActividadEconomica);
			
		this.resaltarActividadEconomicaCliente= borderResaltarActividadEconomica;

		 return borderResaltarActividadEconomica;
	}



	public Boolean mostrarActividadEconomicaCliente=true;

	public Boolean getMostrarActividadEconomicaCliente() {
		return this.mostrarActividadEconomicaCliente;
	}

	public void setMostrarActividadEconomicaCliente(Boolean visibilidadResaltarActividadEconomica) {
		this.mostrarActividadEconomicaCliente= visibilidadResaltarActividadEconomica;
	}



	public Boolean activarActividadEconomicaCliente=true;

	public Boolean gethabilitarResaltarActividadEconomicaCliente() {
		return this.activarActividadEconomicaCliente;
	}

	public void setActivarActividadEconomicaCliente(Boolean habilitarResaltarActividadEconomica) {
		this.activarActividadEconomicaCliente= habilitarResaltarActividadEconomica;
	}


	public Border resaltarDireccionCliente=null;

	public Border getResaltarDireccionCliente() {
		return this.resaltarDireccionCliente;
	}

	public void setResaltarDireccionCliente(Border borderResaltarDireccion) {
		if(borderResaltarDireccion!=null) {
			this.resaltarDireccionCliente= borderResaltarDireccion;
		}
	}

	public Border setResaltarDireccionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarDireccion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarDireccion);
			
		this.resaltarDireccionCliente= borderResaltarDireccion;

		 return borderResaltarDireccion;
	}



	public Boolean mostrarDireccionCliente=true;

	public Boolean getMostrarDireccionCliente() {
		return this.mostrarDireccionCliente;
	}

	public void setMostrarDireccionCliente(Boolean visibilidadResaltarDireccion) {
		this.mostrarDireccionCliente= visibilidadResaltarDireccion;
	}



	public Boolean activarDireccionCliente=true;

	public Boolean gethabilitarResaltarDireccionCliente() {
		return this.activarDireccionCliente;
	}

	public void setActivarDireccionCliente(Boolean habilitarResaltarDireccion) {
		this.activarDireccionCliente= habilitarResaltarDireccion;
	}


	public Border resaltarChequePostFechadoCliente=null;

	public Border getResaltarChequePostFechadoCliente() {
		return this.resaltarChequePostFechadoCliente;
	}

	public void setResaltarChequePostFechadoCliente(Border borderResaltarChequePostFechado) {
		if(borderResaltarChequePostFechado!=null) {
			this.resaltarChequePostFechadoCliente= borderResaltarChequePostFechado;
		}
	}

	public Border setResaltarChequePostFechadoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarChequePostFechado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarChequePostFechado);
			
		this.resaltarChequePostFechadoCliente= borderResaltarChequePostFechado;

		 return borderResaltarChequePostFechado;
	}



	public Boolean mostrarChequePostFechadoCliente=true;

	public Boolean getMostrarChequePostFechadoCliente() {
		return this.mostrarChequePostFechadoCliente;
	}

	public void setMostrarChequePostFechadoCliente(Boolean visibilidadResaltarChequePostFechado) {
		this.mostrarChequePostFechadoCliente= visibilidadResaltarChequePostFechado;
	}



	public Boolean activarChequePostFechadoCliente=true;

	public Boolean gethabilitarResaltarChequePostFechadoCliente() {
		return this.activarChequePostFechadoCliente;
	}

	public void setActivarChequePostFechadoCliente(Boolean habilitarResaltarChequePostFechado) {
		this.activarChequePostFechadoCliente= habilitarResaltarChequePostFechado;
	}


	public Border resaltarSubClienteCliente=null;

	public Border getResaltarSubClienteCliente() {
		return this.resaltarSubClienteCliente;
	}

	public void setResaltarSubClienteCliente(Border borderResaltarSubCliente) {
		if(borderResaltarSubCliente!=null) {
			this.resaltarSubClienteCliente= borderResaltarSubCliente;
		}
	}

	public Border setResaltarSubClienteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltarSubCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//clienteBeanSwingJInternalFrame.jTtoolBarCliente.setBorder(borderResaltarSubCliente);
			
		this.resaltarSubClienteCliente= borderResaltarSubCliente;

		 return borderResaltarSubCliente;
	}



	public Boolean mostrarSubClienteCliente=true;

	public Boolean getMostrarSubClienteCliente() {
		return this.mostrarSubClienteCliente;
	}

	public void setMostrarSubClienteCliente(Boolean visibilidadResaltarSubCliente) {
		this.mostrarSubClienteCliente= visibilidadResaltarSubCliente;
	}



	public Boolean activarSubClienteCliente=true;

	public Boolean gethabilitarResaltarSubClienteCliente() {
		return this.activarSubClienteCliente;
	}

	public void setActivarSubClienteCliente(Boolean habilitarResaltarSubCliente) {
		this.activarSubClienteCliente= habilitarResaltarSubCliente;
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

		this.setMostrarInformacionLaboralCliente(esInicial);
		this.setMostrarTransportistaCliente(esInicial);
		this.setMostrarNovedadCliente(esInicial);
		this.setMostrarPoliticasClienteCliente(esInicial);
		this.setMostrarReferenciaPersonalCliente(esInicial);
		this.setMostrarBalanceGeneralClienteCliente(esInicial);
		this.setMostrarPoliticaClienteCliente(esInicial);
		this.setMostrarVehiculoClienteCliente(esInicial);
		this.setMostrarResponsableCliente(esInicial);
		this.setMostrarInformacionFinancieraCliente(esInicial);
		this.setMostrarConsignatarioCliente(esInicial);
		this.setMostrarClienteImagenCliente(esInicial);
		this.setMostrarGarantiaClienteCliente(esInicial);
		this.setMostrarInformacionEconomicaCliente(esInicial);
		this.setMostrarReferenciaComercialCliente(esInicial);
		this.setMostrarBienCliente(esInicial);
		this.setMostrarProveedorProductoCliente(esInicial);
		this.setMostrarServicioClienteCliente(esInicial);
		this.setMostrarContactoClienteCliente(esInicial);
		this.setMostrarDatoConstitucionCliente(esInicial);
		this.setMostrarClienteCoaCliente(esInicial);
		this.setMostrarHobbyClienteCliente(esInicial);
		this.setMostrarCargaFamiliarCliente(esInicial);
		this.setMostrarEMailCliente(esInicial);
		this.setMostrarConyugeCliente(esInicial);
		this.setMostrarCuentaPorCobrarCliente(esInicial);
		this.setMostrarFirmaClienteCliente(esInicial);
		this.setMostrarRepresentanteLegalCliente(esInicial);
		this.setMostrarTelefonoCliente(esInicial);
		this.setMostrarNegocioClienteCliente(esInicial);
		this.setMostrarReferenciaBancariaCliente(esInicial);
		this.setMostrarMontoCliente(esInicial);
		this.setMostrarClienteArchivoCliente(esInicial);
		this.setMostrarActividadEconomicaCliente(esInicial);
		this.setMostrarDireccionCliente(esInicial);
		this.setMostrarChequePostFechadoCliente(esInicial);
		this.setMostrarSubClienteCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(InformacionLaboral.class)) {
				this.setMostrarInformacionLaboralCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Transportista.class)) {
				this.setMostrarTransportistaCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Novedad.class)) {
				this.setMostrarNovedadCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setMostrarPoliticasClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ReferenciaPersonal.class)) {
				this.setMostrarReferenciaPersonalCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(BalanceGeneralCliente.class)) {
				this.setMostrarBalanceGeneralClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticaCliente.class)) {
				this.setMostrarPoliticaClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(VehiculoCliente.class)) {
				this.setMostrarVehiculoClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Responsable.class)) {
				this.setMostrarResponsableCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(InformacionFinanciera.class)) {
				this.setMostrarInformacionFinancieraCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignatario.class)) {
				this.setMostrarConsignatarioCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ClienteImagen.class)) {
				this.setMostrarClienteImagenCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(GarantiaCliente.class)) {
				this.setMostrarGarantiaClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(InformacionEconomica.class)) {
				this.setMostrarInformacionEconomicaCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ReferenciaComercial.class)) {
				this.setMostrarReferenciaComercialCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Bien.class)) {
				this.setMostrarBienCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProveedorProducto.class)) {
				this.setMostrarProveedorProductoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ServicioCliente.class)) {
				this.setMostrarServicioClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ContactoCliente.class)) {
				this.setMostrarContactoClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoConstitucion.class)) {
				this.setMostrarDatoConstitucionCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ClienteCoa.class)) {
				this.setMostrarClienteCoaCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(HobbyCliente.class)) {
				this.setMostrarHobbyClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar.class)) {
				this.setMostrarCargaFamiliarCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(EMail.class)) {
				this.setMostrarEMailCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Conyuge.class)) {
				this.setMostrarConyugeCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(CuentaPorCobrar.class)) {
				this.setMostrarCuentaPorCobrarCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(FirmaCliente.class)) {
				this.setMostrarFirmaClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(RepresentanteLegal.class)) {
				this.setMostrarRepresentanteLegalCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Telefono.class)) {
				this.setMostrarTelefonoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(NegocioCliente.class)) {
				this.setMostrarNegocioClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ReferenciaBancaria.class)) {
				this.setMostrarReferenciaBancariaCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Monto.class)) {
				this.setMostrarMontoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ClienteArchivo.class)) {
				this.setMostrarClienteArchivoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ActividadEconomica.class)) {
				this.setMostrarActividadEconomicaCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Direccion.class)) {
				this.setMostrarDireccionCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ChequePostFechado.class)) {
				this.setMostrarChequePostFechadoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setMostrarSubClienteCliente(esAsigna);
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

		this.setActivarInformacionLaboralCliente(esInicial);
		this.setActivarTransportistaCliente(esInicial);
		this.setActivarNovedadCliente(esInicial);
		this.setActivarPoliticasClienteCliente(esInicial);
		this.setActivarReferenciaPersonalCliente(esInicial);
		this.setActivarBalanceGeneralClienteCliente(esInicial);
		this.setActivarPoliticaClienteCliente(esInicial);
		this.setActivarVehiculoClienteCliente(esInicial);
		this.setActivarResponsableCliente(esInicial);
		this.setActivarInformacionFinancieraCliente(esInicial);
		this.setActivarConsignatarioCliente(esInicial);
		this.setActivarClienteImagenCliente(esInicial);
		this.setActivarGarantiaClienteCliente(esInicial);
		this.setActivarInformacionEconomicaCliente(esInicial);
		this.setActivarReferenciaComercialCliente(esInicial);
		this.setActivarBienCliente(esInicial);
		this.setActivarProveedorProductoCliente(esInicial);
		this.setActivarServicioClienteCliente(esInicial);
		this.setActivarContactoClienteCliente(esInicial);
		this.setActivarDatoConstitucionCliente(esInicial);
		this.setActivarClienteCoaCliente(esInicial);
		this.setActivarHobbyClienteCliente(esInicial);
		this.setActivarCargaFamiliarCliente(esInicial);
		this.setActivarEMailCliente(esInicial);
		this.setActivarConyugeCliente(esInicial);
		this.setActivarCuentaPorCobrarCliente(esInicial);
		this.setActivarFirmaClienteCliente(esInicial);
		this.setActivarRepresentanteLegalCliente(esInicial);
		this.setActivarTelefonoCliente(esInicial);
		this.setActivarNegocioClienteCliente(esInicial);
		this.setActivarReferenciaBancariaCliente(esInicial);
		this.setActivarMontoCliente(esInicial);
		this.setActivarClienteArchivoCliente(esInicial);
		this.setActivarActividadEconomicaCliente(esInicial);
		this.setActivarDireccionCliente(esInicial);
		this.setActivarChequePostFechadoCliente(esInicial);
		this.setActivarSubClienteCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(InformacionLaboral.class)) {
				this.setActivarInformacionLaboralCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Transportista.class)) {
				this.setActivarTransportistaCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Novedad.class)) {
				this.setActivarNovedadCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setActivarPoliticasClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ReferenciaPersonal.class)) {
				this.setActivarReferenciaPersonalCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(BalanceGeneralCliente.class)) {
				this.setActivarBalanceGeneralClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticaCliente.class)) {
				this.setActivarPoliticaClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(VehiculoCliente.class)) {
				this.setActivarVehiculoClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Responsable.class)) {
				this.setActivarResponsableCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(InformacionFinanciera.class)) {
				this.setActivarInformacionFinancieraCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignatario.class)) {
				this.setActivarConsignatarioCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ClienteImagen.class)) {
				this.setActivarClienteImagenCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(GarantiaCliente.class)) {
				this.setActivarGarantiaClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(InformacionEconomica.class)) {
				this.setActivarInformacionEconomicaCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ReferenciaComercial.class)) {
				this.setActivarReferenciaComercialCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Bien.class)) {
				this.setActivarBienCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProveedorProducto.class)) {
				this.setActivarProveedorProductoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ServicioCliente.class)) {
				this.setActivarServicioClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ContactoCliente.class)) {
				this.setActivarContactoClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoConstitucion.class)) {
				this.setActivarDatoConstitucionCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ClienteCoa.class)) {
				this.setActivarClienteCoaCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(HobbyCliente.class)) {
				this.setActivarHobbyClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar.class)) {
				this.setActivarCargaFamiliarCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(EMail.class)) {
				this.setActivarEMailCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Conyuge.class)) {
				this.setActivarConyugeCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(CuentaPorCobrar.class)) {
				this.setActivarCuentaPorCobrarCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(FirmaCliente.class)) {
				this.setActivarFirmaClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(RepresentanteLegal.class)) {
				this.setActivarRepresentanteLegalCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Telefono.class)) {
				this.setActivarTelefonoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(NegocioCliente.class)) {
				this.setActivarNegocioClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ReferenciaBancaria.class)) {
				this.setActivarReferenciaBancariaCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Monto.class)) {
				this.setActivarMontoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ClienteArchivo.class)) {
				this.setActivarClienteArchivoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ActividadEconomica.class)) {
				this.setActivarActividadEconomicaCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Direccion.class)) {
				this.setActivarDireccionCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ChequePostFechado.class)) {
				this.setActivarChequePostFechadoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setActivarSubClienteCliente(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarInformacionLaboralCliente(esInicial);
		this.setResaltarTransportistaCliente(esInicial);
		this.setResaltarNovedadCliente(esInicial);
		this.setResaltarPoliticasClienteCliente(esInicial);
		this.setResaltarReferenciaPersonalCliente(esInicial);
		this.setResaltarBalanceGeneralClienteCliente(esInicial);
		this.setResaltarPoliticaClienteCliente(esInicial);
		this.setResaltarVehiculoClienteCliente(esInicial);
		this.setResaltarResponsableCliente(esInicial);
		this.setResaltarInformacionFinancieraCliente(esInicial);
		this.setResaltarConsignatarioCliente(esInicial);
		this.setResaltarClienteImagenCliente(esInicial);
		this.setResaltarGarantiaClienteCliente(esInicial);
		this.setResaltarInformacionEconomicaCliente(esInicial);
		this.setResaltarReferenciaComercialCliente(esInicial);
		this.setResaltarBienCliente(esInicial);
		this.setResaltarProveedorProductoCliente(esInicial);
		this.setResaltarServicioClienteCliente(esInicial);
		this.setResaltarContactoClienteCliente(esInicial);
		this.setResaltarDatoConstitucionCliente(esInicial);
		this.setResaltarClienteCoaCliente(esInicial);
		this.setResaltarHobbyClienteCliente(esInicial);
		this.setResaltarCargaFamiliarCliente(esInicial);
		this.setResaltarEMailCliente(esInicial);
		this.setResaltarConyugeCliente(esInicial);
		this.setResaltarCuentaPorCobrarCliente(esInicial);
		this.setResaltarFirmaClienteCliente(esInicial);
		this.setResaltarRepresentanteLegalCliente(esInicial);
		this.setResaltarTelefonoCliente(esInicial);
		this.setResaltarNegocioClienteCliente(esInicial);
		this.setResaltarReferenciaBancariaCliente(esInicial);
		this.setResaltarMontoCliente(esInicial);
		this.setResaltarClienteArchivoCliente(esInicial);
		this.setResaltarActividadEconomicaCliente(esInicial);
		this.setResaltarDireccionCliente(esInicial);
		this.setResaltarChequePostFechadoCliente(esInicial);
		this.setResaltarSubClienteCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(InformacionLaboral.class)) {
				this.setResaltarInformacionLaboralCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Transportista.class)) {
				this.setResaltarTransportistaCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Novedad.class)) {
				this.setResaltarNovedadCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setResaltarPoliticasClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ReferenciaPersonal.class)) {
				this.setResaltarReferenciaPersonalCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(BalanceGeneralCliente.class)) {
				this.setResaltarBalanceGeneralClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticaCliente.class)) {
				this.setResaltarPoliticaClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(VehiculoCliente.class)) {
				this.setResaltarVehiculoClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Responsable.class)) {
				this.setResaltarResponsableCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(InformacionFinanciera.class)) {
				this.setResaltarInformacionFinancieraCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Consignatario.class)) {
				this.setResaltarConsignatarioCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ClienteImagen.class)) {
				this.setResaltarClienteImagenCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(GarantiaCliente.class)) {
				this.setResaltarGarantiaClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(InformacionEconomica.class)) {
				this.setResaltarInformacionEconomicaCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ReferenciaComercial.class)) {
				this.setResaltarReferenciaComercialCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Bien.class)) {
				this.setResaltarBienCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProveedorProducto.class)) {
				this.setResaltarProveedorProductoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ServicioCliente.class)) {
				this.setResaltarServicioClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ContactoCliente.class)) {
				this.setResaltarContactoClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoConstitucion.class)) {
				this.setResaltarDatoConstitucionCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ClienteCoa.class)) {
				this.setResaltarClienteCoaCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(HobbyCliente.class)) {
				this.setResaltarHobbyClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar.class)) {
				this.setResaltarCargaFamiliarCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(EMail.class)) {
				this.setResaltarEMailCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Conyuge.class)) {
				this.setResaltarConyugeCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(CuentaPorCobrar.class)) {
				this.setResaltarCuentaPorCobrarCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(FirmaCliente.class)) {
				this.setResaltarFirmaClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(RepresentanteLegal.class)) {
				this.setResaltarRepresentanteLegalCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Telefono.class)) {
				this.setResaltarTelefonoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(NegocioCliente.class)) {
				this.setResaltarNegocioClienteCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ReferenciaBancaria.class)) {
				this.setResaltarReferenciaBancariaCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Monto.class)) {
				this.setResaltarMontoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ClienteArchivo.class)) {
				this.setResaltarClienteArchivoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ActividadEconomica.class)) {
				this.setResaltarActividadEconomicaCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(Direccion.class)) {
				this.setResaltarDireccionCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(ChequePostFechado.class)) {
				this.setResaltarChequePostFechadoCliente(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setResaltarSubClienteCliente(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorIdentificacionCliente=true;

	public Boolean getMostrarBusquedaPorIdentificacionCliente() {
		return this.mostrarBusquedaPorIdentificacionCliente;
	}

	public void setMostrarBusquedaPorIdentificacionCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdentificacionCliente= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreComercialCliente=true;

	public Boolean getMostrarBusquedaPorNombreComercialCliente() {
		return this.mostrarBusquedaPorNombreComercialCliente;
	}

	public void setMostrarBusquedaPorNombreComercialCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreComercialCliente= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreCompletoCliente=true;

	public Boolean getMostrarBusquedaPorNombreCompletoCliente() {
		return this.mostrarBusquedaPorNombreCompletoCliente;
	}

	public void setMostrarBusquedaPorNombreCompletoCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreCompletoCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCliente=true;

	public Boolean getMostrarFK_IdEmpresaCliente() {
		return this.mostrarFK_IdEmpresaCliente;
	}

	public void setMostrarFK_IdEmpresaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoClienteCliente=true;

	public Boolean getMostrarFK_IdEstadoClienteCliente() {
		return this.mostrarFK_IdEstadoClienteCliente;
	}

	public void setMostrarFK_IdEstadoClienteCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoClienteCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoLegalCliente=true;

	public Boolean getMostrarFK_IdEstadoLegalCliente() {
		return this.mostrarFK_IdEstadoLegalCliente;
	}

	public void setMostrarFK_IdEstadoLegalCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoLegalCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdGrupoClienteCliente=true;

	public Boolean getMostrarFK_IdGrupoClienteCliente() {
		return this.mostrarFK_IdGrupoClienteCliente;
	}

	public void setMostrarFK_IdGrupoClienteCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdGrupoClienteCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRutaCliente=true;

	public Boolean getMostrarFK_IdRutaCliente() {
		return this.mostrarFK_IdRutaCliente;
	}

	public void setMostrarFK_IdRutaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRutaCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCliente=true;

	public Boolean getMostrarFK_IdSucursalCliente() {
		return this.mostrarFK_IdSucursalCliente;
	}

	public void setMostrarFK_IdSucursalCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrecioCliente=true;

	public Boolean getMostrarFK_IdTipoPrecioCliente() {
		return this.mostrarFK_IdTipoPrecioCliente;
	}

	public void setMostrarFK_IdTipoPrecioCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrecioCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTituloClienteCliente=true;

	public Boolean getMostrarFK_IdTituloClienteCliente() {
		return this.mostrarFK_IdTituloClienteCliente;
	}

	public void setMostrarFK_IdTituloClienteCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTituloClienteCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorCliente=true;

	public Boolean getMostrarFK_IdVendedorCliente() {
		return this.mostrarFK_IdVendedorCliente;
	}

	public void setMostrarFK_IdVendedorCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdZonaCliente=true;

	public Boolean getMostrarFK_IdZonaCliente() {
		return this.mostrarFK_IdZonaCliente;
	}

	public void setMostrarFK_IdZonaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdZonaCliente= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdentificacionCliente=true;

	public Boolean getActivarBusquedaPorIdentificacionCliente() {
		return this.activarBusquedaPorIdentificacionCliente;
	}

	public void setActivarBusquedaPorIdentificacionCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdentificacionCliente= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreComercialCliente=true;

	public Boolean getActivarBusquedaPorNombreComercialCliente() {
		return this.activarBusquedaPorNombreComercialCliente;
	}

	public void setActivarBusquedaPorNombreComercialCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreComercialCliente= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreCompletoCliente=true;

	public Boolean getActivarBusquedaPorNombreCompletoCliente() {
		return this.activarBusquedaPorNombreCompletoCliente;
	}

	public void setActivarBusquedaPorNombreCompletoCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreCompletoCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCliente=true;

	public Boolean getActivarFK_IdEmpresaCliente() {
		return this.activarFK_IdEmpresaCliente;
	}

	public void setActivarFK_IdEmpresaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoClienteCliente=true;

	public Boolean getActivarFK_IdEstadoClienteCliente() {
		return this.activarFK_IdEstadoClienteCliente;
	}

	public void setActivarFK_IdEstadoClienteCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoClienteCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoLegalCliente=true;

	public Boolean getActivarFK_IdEstadoLegalCliente() {
		return this.activarFK_IdEstadoLegalCliente;
	}

	public void setActivarFK_IdEstadoLegalCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoLegalCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdGrupoClienteCliente=true;

	public Boolean getActivarFK_IdGrupoClienteCliente() {
		return this.activarFK_IdGrupoClienteCliente;
	}

	public void setActivarFK_IdGrupoClienteCliente(Boolean habilitarResaltar) {
		this.activarFK_IdGrupoClienteCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdRutaCliente=true;

	public Boolean getActivarFK_IdRutaCliente() {
		return this.activarFK_IdRutaCliente;
	}

	public void setActivarFK_IdRutaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdRutaCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCliente=true;

	public Boolean getActivarFK_IdSucursalCliente() {
		return this.activarFK_IdSucursalCliente;
	}

	public void setActivarFK_IdSucursalCliente(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrecioCliente=true;

	public Boolean getActivarFK_IdTipoPrecioCliente() {
		return this.activarFK_IdTipoPrecioCliente;
	}

	public void setActivarFK_IdTipoPrecioCliente(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrecioCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdTituloClienteCliente=true;

	public Boolean getActivarFK_IdTituloClienteCliente() {
		return this.activarFK_IdTituloClienteCliente;
	}

	public void setActivarFK_IdTituloClienteCliente(Boolean habilitarResaltar) {
		this.activarFK_IdTituloClienteCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorCliente=true;

	public Boolean getActivarFK_IdVendedorCliente() {
		return this.activarFK_IdVendedorCliente;
	}

	public void setActivarFK_IdVendedorCliente(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdZonaCliente=true;

	public Boolean getActivarFK_IdZonaCliente() {
		return this.activarFK_IdZonaCliente;
	}

	public void setActivarFK_IdZonaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdZonaCliente= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdentificacionCliente=null;

	public Border getResaltarBusquedaPorIdentificacionCliente() {
		return this.resaltarBusquedaPorIdentificacionCliente;
	}

	public void setResaltarBusquedaPorIdentificacionCliente(Border borderResaltar) {
		this.resaltarBusquedaPorIdentificacionCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorIdentificacionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdentificacionCliente= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreComercialCliente=null;

	public Border getResaltarBusquedaPorNombreComercialCliente() {
		return this.resaltarBusquedaPorNombreComercialCliente;
	}

	public void setResaltarBusquedaPorNombreComercialCliente(Border borderResaltar) {
		this.resaltarBusquedaPorNombreComercialCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreComercialCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreComercialCliente= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreCompletoCliente=null;

	public Border getResaltarBusquedaPorNombreCompletoCliente() {
		return this.resaltarBusquedaPorNombreCompletoCliente;
	}

	public void setResaltarBusquedaPorNombreCompletoCliente(Border borderResaltar) {
		this.resaltarBusquedaPorNombreCompletoCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreCompletoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreCompletoCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCliente=null;

	public Border getResaltarFK_IdEmpresaCliente() {
		return this.resaltarFK_IdEmpresaCliente;
	}

	public void setResaltarFK_IdEmpresaCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCliente= borderResaltar;
	}

	public Border resaltarFK_IdEstadoClienteCliente=null;

	public Border getResaltarFK_IdEstadoClienteCliente() {
		return this.resaltarFK_IdEstadoClienteCliente;
	}

	public void setResaltarFK_IdEstadoClienteCliente(Border borderResaltar) {
		this.resaltarFK_IdEstadoClienteCliente= borderResaltar;
	}

	public void setResaltarFK_IdEstadoClienteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoClienteCliente= borderResaltar;
	}

	public Border resaltarFK_IdEstadoLegalCliente=null;

	public Border getResaltarFK_IdEstadoLegalCliente() {
		return this.resaltarFK_IdEstadoLegalCliente;
	}

	public void setResaltarFK_IdEstadoLegalCliente(Border borderResaltar) {
		this.resaltarFK_IdEstadoLegalCliente= borderResaltar;
	}

	public void setResaltarFK_IdEstadoLegalCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoLegalCliente= borderResaltar;
	}

	public Border resaltarFK_IdGrupoClienteCliente=null;

	public Border getResaltarFK_IdGrupoClienteCliente() {
		return this.resaltarFK_IdGrupoClienteCliente;
	}

	public void setResaltarFK_IdGrupoClienteCliente(Border borderResaltar) {
		this.resaltarFK_IdGrupoClienteCliente= borderResaltar;
	}

	public void setResaltarFK_IdGrupoClienteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdGrupoClienteCliente= borderResaltar;
	}

	public Border resaltarFK_IdRutaCliente=null;

	public Border getResaltarFK_IdRutaCliente() {
		return this.resaltarFK_IdRutaCliente;
	}

	public void setResaltarFK_IdRutaCliente(Border borderResaltar) {
		this.resaltarFK_IdRutaCliente= borderResaltar;
	}

	public void setResaltarFK_IdRutaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRutaCliente= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCliente=null;

	public Border getResaltarFK_IdSucursalCliente() {
		return this.resaltarFK_IdSucursalCliente;
	}

	public void setResaltarFK_IdSucursalCliente(Border borderResaltar) {
		this.resaltarFK_IdSucursalCliente= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCliente= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrecioCliente=null;

	public Border getResaltarFK_IdTipoPrecioCliente() {
		return this.resaltarFK_IdTipoPrecioCliente;
	}

	public void setResaltarFK_IdTipoPrecioCliente(Border borderResaltar) {
		this.resaltarFK_IdTipoPrecioCliente= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrecioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrecioCliente= borderResaltar;
	}

	public Border resaltarFK_IdTituloClienteCliente=null;

	public Border getResaltarFK_IdTituloClienteCliente() {
		return this.resaltarFK_IdTituloClienteCliente;
	}

	public void setResaltarFK_IdTituloClienteCliente(Border borderResaltar) {
		this.resaltarFK_IdTituloClienteCliente= borderResaltar;
	}

	public void setResaltarFK_IdTituloClienteCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTituloClienteCliente= borderResaltar;
	}

	public Border resaltarFK_IdVendedorCliente=null;

	public Border getResaltarFK_IdVendedorCliente() {
		return this.resaltarFK_IdVendedorCliente;
	}

	public void setResaltarFK_IdVendedorCliente(Border borderResaltar) {
		this.resaltarFK_IdVendedorCliente= borderResaltar;
	}

	public void setResaltarFK_IdVendedorCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorCliente= borderResaltar;
	}

	public Border resaltarFK_IdZonaCliente=null;

	public Border getResaltarFK_IdZonaCliente() {
		return this.resaltarFK_IdZonaCliente;
	}

	public void setResaltarFK_IdZonaCliente(Border borderResaltar) {
		this.resaltarFK_IdZonaCliente= borderResaltar;
	}

	public void setResaltarFK_IdZonaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ClienteBeanSwingJInternalFrame clienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdZonaCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}