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


import com.bydan.erp.facturacion.util.TransportistaConstantesFunciones;
import com.bydan.erp.facturacion.util.TransportistaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TransportistaParameterGeneral;

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
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TransportistaConstantesFunciones extends TransportistaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Transportista";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Transportista"+TransportistaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TransportistaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TransportistaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TransportistaConstantesFunciones.SCHEMA+"_"+TransportistaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TransportistaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TransportistaConstantesFunciones.SCHEMA+"_"+TransportistaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TransportistaConstantesFunciones.SCHEMA+"_"+TransportistaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TransportistaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TransportistaConstantesFunciones.SCHEMA+"_"+TransportistaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransportistaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransportistaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransportistaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransportistaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransportistaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransportistaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TransportistaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TransportistaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TransportistaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TransportistaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Transportistas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Transportista";
	public static final String SCLASSWEBTITULO_LOWER="Transportista";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Transportista";
	public static final String OBJECTNAME="transportista";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="transportista";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select transportista from "+TransportistaConstantesFunciones.SPERSISTENCENAME+" transportista";
	public static String QUERYSELECTNATIVE="select "+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".id,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".version_row,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".id_empresa,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".id_sucursal,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".id_tipo_via_transporte,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".identificacion,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".ruc,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".nombre,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".apellido,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".nombre_completo,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".telefono,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".direccion,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".id_cliente,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".placa,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".numero,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".observacion from "+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME;//+" as "+TransportistaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TransportistaConstantesFuncionesAdditional transportistaConstantesFuncionesAdditional=null;
	
	public TransportistaConstantesFuncionesAdditional getTransportistaConstantesFuncionesAdditional() {
		return this.transportistaConstantesFuncionesAdditional;
	}
	
	public void setTransportistaConstantesFuncionesAdditional(TransportistaConstantesFuncionesAdditional transportistaConstantesFuncionesAdditional) {
		try {
			this.transportistaConstantesFuncionesAdditional=transportistaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTIPOVIATRANSPORTE= "id_tipo_via_transporte";
    public static final String IDENTIFICACION= "identificacion";
    public static final String RUC= "ruc";
    public static final String NOMBRE= "nombre";
    public static final String APELLIDO= "apellido";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String TELEFONO= "telefono";
    public static final String DIRECCION= "direccion";
    public static final String IDCLIENTE= "id_cliente";
    public static final String PLACA= "placa";
    public static final String NUMERO= "numero";
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
    	public static final String LABEL_IDTIPOVIATRANSPORTE= "Tipo Via Transporte";
		public static final String LABEL_IDTIPOVIATRANSPORTE_LOWER= "Tipo Via Transporte";
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
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_PLACA= "Placa";
		public static final String LABEL_PLACA_LOWER= "Placa";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
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
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXPLACA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPLACA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXOBSERVACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTransportistaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TransportistaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TransportistaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TransportistaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=TransportistaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(TransportistaConstantesFunciones.IDTIPOVIATRANSPORTE)) {sLabelColumna=TransportistaConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE;}
		if(sNombreColumna.equals(TransportistaConstantesFunciones.IDENTIFICACION)) {sLabelColumna=TransportistaConstantesFunciones.LABEL_IDENTIFICACION;}
		if(sNombreColumna.equals(TransportistaConstantesFunciones.RUC)) {sLabelColumna=TransportistaConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(TransportistaConstantesFunciones.NOMBRE)) {sLabelColumna=TransportistaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TransportistaConstantesFunciones.APELLIDO)) {sLabelColumna=TransportistaConstantesFunciones.LABEL_APELLIDO;}
		if(sNombreColumna.equals(TransportistaConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=TransportistaConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(TransportistaConstantesFunciones.TELEFONO)) {sLabelColumna=TransportistaConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(TransportistaConstantesFunciones.DIRECCION)) {sLabelColumna=TransportistaConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(TransportistaConstantesFunciones.IDCLIENTE)) {sLabelColumna=TransportistaConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(TransportistaConstantesFunciones.PLACA)) {sLabelColumna=TransportistaConstantesFunciones.LABEL_PLACA;}
		if(sNombreColumna.equals(TransportistaConstantesFunciones.NUMERO)) {sLabelColumna=TransportistaConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(TransportistaConstantesFunciones.OBSERVACION)) {sLabelColumna=TransportistaConstantesFunciones.LABEL_OBSERVACION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getTransportistaDescripcion(Transportista transportista) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(transportista !=null/* && transportista.getId()!=0*/) {
			sDescripcion=transportista.getnombre();//transportistatransportista.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTransportistaDescripcionDetallado(Transportista transportista) {
		String sDescripcion="";
			
		sDescripcion+=TransportistaConstantesFunciones.ID+"=";
		sDescripcion+=transportista.getId().toString()+",";
		sDescripcion+=TransportistaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=transportista.getVersionRow().toString()+",";
		sDescripcion+=TransportistaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=transportista.getid_empresa().toString()+",";
		sDescripcion+=TransportistaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=transportista.getid_sucursal().toString()+",";
		sDescripcion+=TransportistaConstantesFunciones.IDTIPOVIATRANSPORTE+"=";
		sDescripcion+=transportista.getid_tipo_via_transporte().toString()+",";
		sDescripcion+=TransportistaConstantesFunciones.IDENTIFICACION+"=";
		sDescripcion+=transportista.getidentificacion()+",";
		sDescripcion+=TransportistaConstantesFunciones.RUC+"=";
		sDescripcion+=transportista.getruc()+",";
		sDescripcion+=TransportistaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=transportista.getnombre()+",";
		sDescripcion+=TransportistaConstantesFunciones.APELLIDO+"=";
		sDescripcion+=transportista.getapellido()+",";
		sDescripcion+=TransportistaConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=transportista.getnombre_completo()+",";
		sDescripcion+=TransportistaConstantesFunciones.TELEFONO+"=";
		sDescripcion+=transportista.gettelefono()+",";
		sDescripcion+=TransportistaConstantesFunciones.DIRECCION+"=";
		sDescripcion+=transportista.getdireccion()+",";
		sDescripcion+=TransportistaConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=transportista.getid_cliente().toString()+",";
		sDescripcion+=TransportistaConstantesFunciones.PLACA+"=";
		sDescripcion+=transportista.getplaca()+",";
		sDescripcion+=TransportistaConstantesFunciones.NUMERO+"=";
		sDescripcion+=transportista.getnumero()+",";
		sDescripcion+=TransportistaConstantesFunciones.OBSERVACION+"=";
		sDescripcion+=transportista.getobservacion()+",";
			
		return sDescripcion;
	}
	
	public static void setTransportistaDescripcion(Transportista transportista,String sValor) throws Exception {			
		if(transportista !=null) {
			transportista.setnombre(sValor);//transportistatransportista.getId().toString();
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

	public static String getTipoViaTransporteDescripcion(TipoViaTransporte tipoviatransporte) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoviatransporte!=null/*&&tipoviatransporte.getId()>0*/) {
			sDescripcion=TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(tipoviatransporte);
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
		} else if(sNombreIndice.equals("BusquedaPorIdentificacion")) {
			sNombreIndice="Tipo=  Por Identificacion";
		} else if(sNombreIndice.equals("BusquedaPorNombreCompleto")) {
			sNombreIndice="Tipo=  Por Nombre Completo";
		} else if(sNombreIndice.equals("BusquedaPorPlaca")) {
			sNombreIndice="Tipo=  Por Placa";
		} else if(sNombreIndice.equals("BusquedaPorRuc")) {
			sNombreIndice="Tipo=  Por Ruc";
		} else if(sNombreIndice.equals("BusquedaPorTelefono")) {
			sNombreIndice="Tipo=  Por Telefono";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoViaTransporte")) {
			sNombreIndice="Tipo=  Por Tipo Via Transporte";
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

	public static String getDetalleIndiceBusquedaPorPlaca(String placa) {
		String sDetalleIndice=" Parametros->";
		if(placa!=null) {sDetalleIndice+=" Placa="+placa;} 

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

	public static String getDetalleIndiceFK_IdTipoViaTransporte(Long id_tipo_via_transporte) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_via_transporte!=null) {sDetalleIndice+=" Codigo Unico De Tipo Via Transporte="+id_tipo_via_transporte.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTransportista(Transportista transportista,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		transportista.setidentificacion(transportista.getidentificacion().trim());
		transportista.setruc(transportista.getruc().trim());
		transportista.setnombre(transportista.getnombre().trim());
		transportista.setapellido(transportista.getapellido().trim());
		transportista.setnombre_completo(transportista.getnombre_completo().trim());
		transportista.settelefono(transportista.gettelefono().trim());
		transportista.setdireccion(transportista.getdireccion().trim());
		transportista.setplaca(transportista.getplaca().trim());
		transportista.setnumero(transportista.getnumero().trim());
		transportista.setobservacion(transportista.getobservacion().trim());
	}
	
	public static void quitarEspaciosTransportistas(List<Transportista> transportistas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Transportista transportista: transportistas) {
			transportista.setidentificacion(transportista.getidentificacion().trim());
			transportista.setruc(transportista.getruc().trim());
			transportista.setnombre(transportista.getnombre().trim());
			transportista.setapellido(transportista.getapellido().trim());
			transportista.setnombre_completo(transportista.getnombre_completo().trim());
			transportista.settelefono(transportista.gettelefono().trim());
			transportista.setdireccion(transportista.getdireccion().trim());
			transportista.setplaca(transportista.getplaca().trim());
			transportista.setnumero(transportista.getnumero().trim());
			transportista.setobservacion(transportista.getobservacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransportista(Transportista transportista,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && transportista.getConCambioAuxiliar()) {
			transportista.setIsDeleted(transportista.getIsDeletedAuxiliar());	
			transportista.setIsNew(transportista.getIsNewAuxiliar());	
			transportista.setIsChanged(transportista.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			transportista.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			transportista.setIsDeletedAuxiliar(false);	
			transportista.setIsNewAuxiliar(false);	
			transportista.setIsChangedAuxiliar(false);
			
			transportista.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransportistas(List<Transportista> transportistas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Transportista transportista : transportistas) {
			if(conAsignarBase && transportista.getConCambioAuxiliar()) {
				transportista.setIsDeleted(transportista.getIsDeletedAuxiliar());	
				transportista.setIsNew(transportista.getIsNewAuxiliar());	
				transportista.setIsChanged(transportista.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				transportista.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				transportista.setIsDeletedAuxiliar(false);	
				transportista.setIsNewAuxiliar(false);	
				transportista.setIsChangedAuxiliar(false);
				
				transportista.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTransportista(Transportista transportista,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTransportistas(List<Transportista> transportistas,Boolean conEnteros) throws Exception  {
		
		for(Transportista transportista: transportistas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTransportista(List<Transportista> transportistas,Transportista transportistaAux) throws Exception  {
		TransportistaConstantesFunciones.InicializarValoresTransportista(transportistaAux,true);
		
		for(Transportista transportista: transportistas) {
			if(transportista.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTransportista(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TransportistaConstantesFunciones.getArrayColumnasGlobalesTransportista(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTransportista(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransportistaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransportistaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransportistaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransportistaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTransportista(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Transportista> transportistas,Transportista transportista,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Transportista transportistaAux: transportistas) {
			if(transportistaAux!=null && transportista!=null) {
				if((transportistaAux.getId()==null && transportista.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(transportistaAux.getId()!=null && transportista.getId()!=null){
					if(transportistaAux.getId().equals(transportista.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTransportista(List<Transportista> transportistas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Transportista transportista: transportistas) {			
			if(transportista.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTransportista() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TransportistaConstantesFunciones.LABEL_ID, TransportistaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransportistaConstantesFunciones.LABEL_VERSIONROW, TransportistaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransportistaConstantesFunciones.LABEL_IDEMPRESA, TransportistaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransportistaConstantesFunciones.LABEL_IDSUCURSAL, TransportistaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransportistaConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE, TransportistaConstantesFunciones.IDTIPOVIATRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransportistaConstantesFunciones.LABEL_IDENTIFICACION, TransportistaConstantesFunciones.IDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransportistaConstantesFunciones.LABEL_RUC, TransportistaConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransportistaConstantesFunciones.LABEL_NOMBRE, TransportistaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransportistaConstantesFunciones.LABEL_APELLIDO, TransportistaConstantesFunciones.APELLIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransportistaConstantesFunciones.LABEL_NOMBRECOMPLETO, TransportistaConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransportistaConstantesFunciones.LABEL_TELEFONO, TransportistaConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransportistaConstantesFunciones.LABEL_DIRECCION, TransportistaConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransportistaConstantesFunciones.LABEL_IDCLIENTE, TransportistaConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransportistaConstantesFunciones.LABEL_PLACA, TransportistaConstantesFunciones.PLACA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransportistaConstantesFunciones.LABEL_NUMERO, TransportistaConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransportistaConstantesFunciones.LABEL_OBSERVACION, TransportistaConstantesFunciones.OBSERVACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTransportista() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TransportistaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransportistaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransportistaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransportistaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransportistaConstantesFunciones.IDTIPOVIATRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransportistaConstantesFunciones.IDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransportistaConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransportistaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransportistaConstantesFunciones.APELLIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransportistaConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransportistaConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransportistaConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransportistaConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransportistaConstantesFunciones.PLACA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransportistaConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransportistaConstantesFunciones.OBSERVACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransportista() throws Exception  {
		return TransportistaConstantesFunciones.getTiposSeleccionarTransportista(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransportista(Boolean conFk) throws Exception  {
		return TransportistaConstantesFunciones.getTiposSeleccionarTransportista(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransportista(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransportistaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TransportistaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransportistaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(TransportistaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransportistaConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);
			reporte.setsDescripcion(TransportistaConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransportistaConstantesFunciones.LABEL_IDENTIFICACION);
			reporte.setsDescripcion(TransportistaConstantesFunciones.LABEL_IDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransportistaConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(TransportistaConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransportistaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TransportistaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransportistaConstantesFunciones.LABEL_APELLIDO);
			reporte.setsDescripcion(TransportistaConstantesFunciones.LABEL_APELLIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransportistaConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(TransportistaConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransportistaConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(TransportistaConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransportistaConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(TransportistaConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransportistaConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(TransportistaConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransportistaConstantesFunciones.LABEL_PLACA);
			reporte.setsDescripcion(TransportistaConstantesFunciones.LABEL_PLACA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransportistaConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(TransportistaConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransportistaConstantesFunciones.LABEL_OBSERVACION);
			reporte.setsDescripcion(TransportistaConstantesFunciones.LABEL_OBSERVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTransportista(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTransportista(Transportista transportistaAux) throws Exception {
		
			transportistaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transportistaAux.getEmpresa()));
			transportistaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(transportistaAux.getSucursal()));
			transportistaAux.settipoviatransporte_descripcion(TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(transportistaAux.getTipoViaTransporte()));
			transportistaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(transportistaAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTransportista(List<Transportista> transportistasTemp) throws Exception {
		for(Transportista transportistaAux:transportistasTemp) {
			
			transportistaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transportistaAux.getEmpresa()));
			transportistaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(transportistaAux.getSucursal()));
			transportistaAux.settipoviatransporte_descripcion(TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(transportistaAux.getTipoViaTransporte()));
			transportistaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(transportistaAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTransportista(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TipoViaTransporte.class));
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
					if(clas.clas.equals(TipoViaTransporte.class)) {
						classes.add(new Classe(TipoViaTransporte.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTransportista(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoViaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoViaTransporte.class)); continue;
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

					if(TipoViaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoViaTransporte.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransportista(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransportistaConstantesFunciones.getClassesRelationshipsOfTransportista(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransportista(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransportista(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransportistaConstantesFunciones.getClassesRelationshipsFromStringsOfTransportista(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransportista(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Transportista transportista,List<Transportista> transportistas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Transportista transportistaEncontrado=null;
			
			for(Transportista transportistaLocal:transportistas) {
				if(transportistaLocal.getId().equals(transportista.getId())) {
					transportistaEncontrado=transportistaLocal;
					
					transportistaLocal.setIsChanged(transportista.getIsChanged());
					transportistaLocal.setIsNew(transportista.getIsNew());
					transportistaLocal.setIsDeleted(transportista.getIsDeleted());
					
					transportistaLocal.setGeneralEntityOriginal(transportista.getGeneralEntityOriginal());
					
					transportistaLocal.setId(transportista.getId());	
					transportistaLocal.setVersionRow(transportista.getVersionRow());	
					transportistaLocal.setid_empresa(transportista.getid_empresa());	
					transportistaLocal.setid_sucursal(transportista.getid_sucursal());	
					transportistaLocal.setid_tipo_via_transporte(transportista.getid_tipo_via_transporte());	
					transportistaLocal.setidentificacion(transportista.getidentificacion());	
					transportistaLocal.setruc(transportista.getruc());	
					transportistaLocal.setnombre(transportista.getnombre());	
					transportistaLocal.setapellido(transportista.getapellido());	
					transportistaLocal.setnombre_completo(transportista.getnombre_completo());	
					transportistaLocal.settelefono(transportista.gettelefono());	
					transportistaLocal.setdireccion(transportista.getdireccion());	
					transportistaLocal.setid_cliente(transportista.getid_cliente());	
					transportistaLocal.setplaca(transportista.getplaca());	
					transportistaLocal.setnumero(transportista.getnumero());	
					transportistaLocal.setobservacion(transportista.getobservacion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!transportista.getIsDeleted()) {
				if(!existe) {
					transportistas.add(transportista);
				}
			} else {
				if(transportistaEncontrado!=null && permiteQuitar)  {
					transportistas.remove(transportistaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Transportista transportista,List<Transportista> transportistas) throws Exception {
		try	{			
			for(Transportista transportistaLocal:transportistas) {
				if(transportistaLocal.getId().equals(transportista.getId())) {
					transportistaLocal.setIsSelected(transportista.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTransportista(List<Transportista> transportistasAux) throws Exception {
		//this.transportistasAux=transportistasAux;
		
		for(Transportista transportistaAux:transportistasAux) {
			if(transportistaAux.getIsChanged()) {
				transportistaAux.setIsChanged(false);
			}		
			
			if(transportistaAux.getIsNew()) {
				transportistaAux.setIsNew(false);
			}	
			
			if(transportistaAux.getIsDeleted()) {
				transportistaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTransportista(Transportista transportistaAux) throws Exception {
		//this.transportistaAux=transportistaAux;
		
			if(transportistaAux.getIsChanged()) {
				transportistaAux.setIsChanged(false);
			}		
			
			if(transportistaAux.getIsNew()) {
				transportistaAux.setIsNew(false);
			}	
			
			if(transportistaAux.getIsDeleted()) {
				transportistaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Transportista transportistaAsignar,Transportista transportista) throws Exception {
		transportistaAsignar.setId(transportista.getId());	
		transportistaAsignar.setVersionRow(transportista.getVersionRow());	
		transportistaAsignar.setid_empresa(transportista.getid_empresa());
		transportistaAsignar.setempresa_descripcion(transportista.getempresa_descripcion());	
		transportistaAsignar.setid_sucursal(transportista.getid_sucursal());
		transportistaAsignar.setsucursal_descripcion(transportista.getsucursal_descripcion());	
		transportistaAsignar.setid_tipo_via_transporte(transportista.getid_tipo_via_transporte());
		transportistaAsignar.settipoviatransporte_descripcion(transportista.gettipoviatransporte_descripcion());	
		transportistaAsignar.setidentificacion(transportista.getidentificacion());	
		transportistaAsignar.setruc(transportista.getruc());	
		transportistaAsignar.setnombre(transportista.getnombre());	
		transportistaAsignar.setapellido(transportista.getapellido());	
		transportistaAsignar.setnombre_completo(transportista.getnombre_completo());	
		transportistaAsignar.settelefono(transportista.gettelefono());	
		transportistaAsignar.setdireccion(transportista.getdireccion());	
		transportistaAsignar.setid_cliente(transportista.getid_cliente());
		transportistaAsignar.setcliente_descripcion(transportista.getcliente_descripcion());	
		transportistaAsignar.setplaca(transportista.getplaca());	
		transportistaAsignar.setnumero(transportista.getnumero());	
		transportistaAsignar.setobservacion(transportista.getobservacion());	
	}
	
	public static void inicializarTransportista(Transportista transportista) throws Exception {
		try {
				transportista.setId(0L);	
					
				transportista.setid_empresa(-1L);	
				transportista.setid_sucursal(-1L);	
				transportista.setid_tipo_via_transporte(-1L);	
				transportista.setidentificacion("");	
				transportista.setruc("");	
				transportista.setnombre("");	
				transportista.setapellido("");	
				transportista.setnombre_completo("");	
				transportista.settelefono("");	
				transportista.setdireccion("");	
				transportista.setid_cliente(-1L);	
				transportista.setplaca("");	
				transportista.setnumero("");	
				transportista.setobservacion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTransportista(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TransportistaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransportistaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransportistaConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransportistaConstantesFunciones.LABEL_IDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransportistaConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransportistaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransportistaConstantesFunciones.LABEL_APELLIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransportistaConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransportistaConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransportistaConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransportistaConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransportistaConstantesFunciones.LABEL_PLACA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransportistaConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransportistaConstantesFunciones.LABEL_OBSERVACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTransportista(String sTipo,Row row,Workbook workbook,Transportista transportista,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(transportista.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transportista.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transportista.gettipoviatransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transportista.getidentificacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transportista.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transportista.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transportista.getapellido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transportista.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transportista.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transportista.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transportista.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transportista.getplaca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transportista.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transportista.getobservacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTransportista=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTransportista() {
		return this.sFinalQueryTransportista;
	}
	
	public void setsFinalQueryTransportista(String sFinalQueryTransportista) {
		this.sFinalQueryTransportista= sFinalQueryTransportista;
	}
	
	public Border resaltarSeleccionarTransportista=null;
	
	public Border setResaltarSeleccionarTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//transportistaBeanSwingJInternalFrame.jTtoolBarTransportista.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTransportista= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTransportista() {
		return this.resaltarSeleccionarTransportista;
	}
	
	public void setResaltarSeleccionarTransportista(Border borderResaltarSeleccionarTransportista) {
		this.resaltarSeleccionarTransportista= borderResaltarSeleccionarTransportista;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTransportista=null;
	public Boolean mostraridTransportista=true;
	public Boolean activaridTransportista=true;

	public Border resaltarid_empresaTransportista=null;
	public Boolean mostrarid_empresaTransportista=true;
	public Boolean activarid_empresaTransportista=true;
	public Boolean cargarid_empresaTransportista=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTransportista=false;//ConEventDepend=true

	public Border resaltarid_sucursalTransportista=null;
	public Boolean mostrarid_sucursalTransportista=true;
	public Boolean activarid_sucursalTransportista=true;
	public Boolean cargarid_sucursalTransportista=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalTransportista=false;//ConEventDepend=true

	public Border resaltarid_tipo_via_transporteTransportista=null;
	public Boolean mostrarid_tipo_via_transporteTransportista=true;
	public Boolean activarid_tipo_via_transporteTransportista=true;
	public Boolean cargarid_tipo_via_transporteTransportista=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_via_transporteTransportista=false;//ConEventDepend=true

	public Border resaltaridentificacionTransportista=null;
	public Boolean mostraridentificacionTransportista=true;
	public Boolean activaridentificacionTransportista=true;

	public Border resaltarrucTransportista=null;
	public Boolean mostrarrucTransportista=true;
	public Boolean activarrucTransportista=true;

	public Border resaltarnombreTransportista=null;
	public Boolean mostrarnombreTransportista=true;
	public Boolean activarnombreTransportista=true;

	public Border resaltarapellidoTransportista=null;
	public Boolean mostrarapellidoTransportista=true;
	public Boolean activarapellidoTransportista=true;

	public Border resaltarnombre_completoTransportista=null;
	public Boolean mostrarnombre_completoTransportista=true;
	public Boolean activarnombre_completoTransportista=false;

	public Border resaltartelefonoTransportista=null;
	public Boolean mostrartelefonoTransportista=true;
	public Boolean activartelefonoTransportista=true;

	public Border resaltardireccionTransportista=null;
	public Boolean mostrardireccionTransportista=true;
	public Boolean activardireccionTransportista=true;

	public Border resaltarid_clienteTransportista=null;
	public Boolean mostrarid_clienteTransportista=true;
	public Boolean activarid_clienteTransportista=true;
	public Boolean cargarid_clienteTransportista=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteTransportista=false;//ConEventDepend=true

	public Border resaltarplacaTransportista=null;
	public Boolean mostrarplacaTransportista=true;
	public Boolean activarplacaTransportista=true;

	public Border resaltarnumeroTransportista=null;
	public Boolean mostrarnumeroTransportista=true;
	public Boolean activarnumeroTransportista=true;

	public Border resaltarobservacionTransportista=null;
	public Boolean mostrarobservacionTransportista=true;
	public Boolean activarobservacionTransportista=true;

	
	

	public Border setResaltaridTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transportistaBeanSwingJInternalFrame.jTtoolBarTransportista.setBorder(borderResaltar);
		
		this.resaltaridTransportista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTransportista() {
		return this.resaltaridTransportista;
	}

	public void setResaltaridTransportista(Border borderResaltar) {
		this.resaltaridTransportista= borderResaltar;
	}

	public Boolean getMostraridTransportista() {
		return this.mostraridTransportista;
	}

	public void setMostraridTransportista(Boolean mostraridTransportista) {
		this.mostraridTransportista= mostraridTransportista;
	}

	public Boolean getActivaridTransportista() {
		return this.activaridTransportista;
	}

	public void setActivaridTransportista(Boolean activaridTransportista) {
		this.activaridTransportista= activaridTransportista;
	}

	public Border setResaltarid_empresaTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transportistaBeanSwingJInternalFrame.jTtoolBarTransportista.setBorder(borderResaltar);
		
		this.resaltarid_empresaTransportista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTransportista() {
		return this.resaltarid_empresaTransportista;
	}

	public void setResaltarid_empresaTransportista(Border borderResaltar) {
		this.resaltarid_empresaTransportista= borderResaltar;
	}

	public Boolean getMostrarid_empresaTransportista() {
		return this.mostrarid_empresaTransportista;
	}

	public void setMostrarid_empresaTransportista(Boolean mostrarid_empresaTransportista) {
		this.mostrarid_empresaTransportista= mostrarid_empresaTransportista;
	}

	public Boolean getActivarid_empresaTransportista() {
		return this.activarid_empresaTransportista;
	}

	public void setActivarid_empresaTransportista(Boolean activarid_empresaTransportista) {
		this.activarid_empresaTransportista= activarid_empresaTransportista;
	}

	public Boolean getCargarid_empresaTransportista() {
		return this.cargarid_empresaTransportista;
	}

	public void setCargarid_empresaTransportista(Boolean cargarid_empresaTransportista) {
		this.cargarid_empresaTransportista= cargarid_empresaTransportista;
	}

	public Border setResaltarid_sucursalTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transportistaBeanSwingJInternalFrame.jTtoolBarTransportista.setBorder(borderResaltar);
		
		this.resaltarid_sucursalTransportista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalTransportista() {
		return this.resaltarid_sucursalTransportista;
	}

	public void setResaltarid_sucursalTransportista(Border borderResaltar) {
		this.resaltarid_sucursalTransportista= borderResaltar;
	}

	public Boolean getMostrarid_sucursalTransportista() {
		return this.mostrarid_sucursalTransportista;
	}

	public void setMostrarid_sucursalTransportista(Boolean mostrarid_sucursalTransportista) {
		this.mostrarid_sucursalTransportista= mostrarid_sucursalTransportista;
	}

	public Boolean getActivarid_sucursalTransportista() {
		return this.activarid_sucursalTransportista;
	}

	public void setActivarid_sucursalTransportista(Boolean activarid_sucursalTransportista) {
		this.activarid_sucursalTransportista= activarid_sucursalTransportista;
	}

	public Boolean getCargarid_sucursalTransportista() {
		return this.cargarid_sucursalTransportista;
	}

	public void setCargarid_sucursalTransportista(Boolean cargarid_sucursalTransportista) {
		this.cargarid_sucursalTransportista= cargarid_sucursalTransportista;
	}

	public Border setResaltarid_tipo_via_transporteTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transportistaBeanSwingJInternalFrame.jTtoolBarTransportista.setBorder(borderResaltar);
		
		this.resaltarid_tipo_via_transporteTransportista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_via_transporteTransportista() {
		return this.resaltarid_tipo_via_transporteTransportista;
	}

	public void setResaltarid_tipo_via_transporteTransportista(Border borderResaltar) {
		this.resaltarid_tipo_via_transporteTransportista= borderResaltar;
	}

	public Boolean getMostrarid_tipo_via_transporteTransportista() {
		return this.mostrarid_tipo_via_transporteTransportista;
	}

	public void setMostrarid_tipo_via_transporteTransportista(Boolean mostrarid_tipo_via_transporteTransportista) {
		this.mostrarid_tipo_via_transporteTransportista= mostrarid_tipo_via_transporteTransportista;
	}

	public Boolean getActivarid_tipo_via_transporteTransportista() {
		return this.activarid_tipo_via_transporteTransportista;
	}

	public void setActivarid_tipo_via_transporteTransportista(Boolean activarid_tipo_via_transporteTransportista) {
		this.activarid_tipo_via_transporteTransportista= activarid_tipo_via_transporteTransportista;
	}

	public Boolean getCargarid_tipo_via_transporteTransportista() {
		return this.cargarid_tipo_via_transporteTransportista;
	}

	public void setCargarid_tipo_via_transporteTransportista(Boolean cargarid_tipo_via_transporteTransportista) {
		this.cargarid_tipo_via_transporteTransportista= cargarid_tipo_via_transporteTransportista;
	}

	public Border setResaltaridentificacionTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transportistaBeanSwingJInternalFrame.jTtoolBarTransportista.setBorder(borderResaltar);
		
		this.resaltaridentificacionTransportista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridentificacionTransportista() {
		return this.resaltaridentificacionTransportista;
	}

	public void setResaltaridentificacionTransportista(Border borderResaltar) {
		this.resaltaridentificacionTransportista= borderResaltar;
	}

	public Boolean getMostraridentificacionTransportista() {
		return this.mostraridentificacionTransportista;
	}

	public void setMostraridentificacionTransportista(Boolean mostraridentificacionTransportista) {
		this.mostraridentificacionTransportista= mostraridentificacionTransportista;
	}

	public Boolean getActivaridentificacionTransportista() {
		return this.activaridentificacionTransportista;
	}

	public void setActivaridentificacionTransportista(Boolean activaridentificacionTransportista) {
		this.activaridentificacionTransportista= activaridentificacionTransportista;
	}

	public Border setResaltarrucTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transportistaBeanSwingJInternalFrame.jTtoolBarTransportista.setBorder(borderResaltar);
		
		this.resaltarrucTransportista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucTransportista() {
		return this.resaltarrucTransportista;
	}

	public void setResaltarrucTransportista(Border borderResaltar) {
		this.resaltarrucTransportista= borderResaltar;
	}

	public Boolean getMostrarrucTransportista() {
		return this.mostrarrucTransportista;
	}

	public void setMostrarrucTransportista(Boolean mostrarrucTransportista) {
		this.mostrarrucTransportista= mostrarrucTransportista;
	}

	public Boolean getActivarrucTransportista() {
		return this.activarrucTransportista;
	}

	public void setActivarrucTransportista(Boolean activarrucTransportista) {
		this.activarrucTransportista= activarrucTransportista;
	}

	public Border setResaltarnombreTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transportistaBeanSwingJInternalFrame.jTtoolBarTransportista.setBorder(borderResaltar);
		
		this.resaltarnombreTransportista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTransportista() {
		return this.resaltarnombreTransportista;
	}

	public void setResaltarnombreTransportista(Border borderResaltar) {
		this.resaltarnombreTransportista= borderResaltar;
	}

	public Boolean getMostrarnombreTransportista() {
		return this.mostrarnombreTransportista;
	}

	public void setMostrarnombreTransportista(Boolean mostrarnombreTransportista) {
		this.mostrarnombreTransportista= mostrarnombreTransportista;
	}

	public Boolean getActivarnombreTransportista() {
		return this.activarnombreTransportista;
	}

	public void setActivarnombreTransportista(Boolean activarnombreTransportista) {
		this.activarnombreTransportista= activarnombreTransportista;
	}

	public Border setResaltarapellidoTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transportistaBeanSwingJInternalFrame.jTtoolBarTransportista.setBorder(borderResaltar);
		
		this.resaltarapellidoTransportista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidoTransportista() {
		return this.resaltarapellidoTransportista;
	}

	public void setResaltarapellidoTransportista(Border borderResaltar) {
		this.resaltarapellidoTransportista= borderResaltar;
	}

	public Boolean getMostrarapellidoTransportista() {
		return this.mostrarapellidoTransportista;
	}

	public void setMostrarapellidoTransportista(Boolean mostrarapellidoTransportista) {
		this.mostrarapellidoTransportista= mostrarapellidoTransportista;
	}

	public Boolean getActivarapellidoTransportista() {
		return this.activarapellidoTransportista;
	}

	public void setActivarapellidoTransportista(Boolean activarapellidoTransportista) {
		this.activarapellidoTransportista= activarapellidoTransportista;
	}

	public Border setResaltarnombre_completoTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transportistaBeanSwingJInternalFrame.jTtoolBarTransportista.setBorder(borderResaltar);
		
		this.resaltarnombre_completoTransportista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoTransportista() {
		return this.resaltarnombre_completoTransportista;
	}

	public void setResaltarnombre_completoTransportista(Border borderResaltar) {
		this.resaltarnombre_completoTransportista= borderResaltar;
	}

	public Boolean getMostrarnombre_completoTransportista() {
		return this.mostrarnombre_completoTransportista;
	}

	public void setMostrarnombre_completoTransportista(Boolean mostrarnombre_completoTransportista) {
		this.mostrarnombre_completoTransportista= mostrarnombre_completoTransportista;
	}

	public Boolean getActivarnombre_completoTransportista() {
		return this.activarnombre_completoTransportista;
	}

	public void setActivarnombre_completoTransportista(Boolean activarnombre_completoTransportista) {
		this.activarnombre_completoTransportista= activarnombre_completoTransportista;
	}

	public Border setResaltartelefonoTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transportistaBeanSwingJInternalFrame.jTtoolBarTransportista.setBorder(borderResaltar);
		
		this.resaltartelefonoTransportista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoTransportista() {
		return this.resaltartelefonoTransportista;
	}

	public void setResaltartelefonoTransportista(Border borderResaltar) {
		this.resaltartelefonoTransportista= borderResaltar;
	}

	public Boolean getMostrartelefonoTransportista() {
		return this.mostrartelefonoTransportista;
	}

	public void setMostrartelefonoTransportista(Boolean mostrartelefonoTransportista) {
		this.mostrartelefonoTransportista= mostrartelefonoTransportista;
	}

	public Boolean getActivartelefonoTransportista() {
		return this.activartelefonoTransportista;
	}

	public void setActivartelefonoTransportista(Boolean activartelefonoTransportista) {
		this.activartelefonoTransportista= activartelefonoTransportista;
	}

	public Border setResaltardireccionTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transportistaBeanSwingJInternalFrame.jTtoolBarTransportista.setBorder(borderResaltar);
		
		this.resaltardireccionTransportista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionTransportista() {
		return this.resaltardireccionTransportista;
	}

	public void setResaltardireccionTransportista(Border borderResaltar) {
		this.resaltardireccionTransportista= borderResaltar;
	}

	public Boolean getMostrardireccionTransportista() {
		return this.mostrardireccionTransportista;
	}

	public void setMostrardireccionTransportista(Boolean mostrardireccionTransportista) {
		this.mostrardireccionTransportista= mostrardireccionTransportista;
	}

	public Boolean getActivardireccionTransportista() {
		return this.activardireccionTransportista;
	}

	public void setActivardireccionTransportista(Boolean activardireccionTransportista) {
		this.activardireccionTransportista= activardireccionTransportista;
	}

	public Border setResaltarid_clienteTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transportistaBeanSwingJInternalFrame.jTtoolBarTransportista.setBorder(borderResaltar);
		
		this.resaltarid_clienteTransportista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteTransportista() {
		return this.resaltarid_clienteTransportista;
	}

	public void setResaltarid_clienteTransportista(Border borderResaltar) {
		this.resaltarid_clienteTransportista= borderResaltar;
	}

	public Boolean getMostrarid_clienteTransportista() {
		return this.mostrarid_clienteTransportista;
	}

	public void setMostrarid_clienteTransportista(Boolean mostrarid_clienteTransportista) {
		this.mostrarid_clienteTransportista= mostrarid_clienteTransportista;
	}

	public Boolean getActivarid_clienteTransportista() {
		return this.activarid_clienteTransportista;
	}

	public void setActivarid_clienteTransportista(Boolean activarid_clienteTransportista) {
		this.activarid_clienteTransportista= activarid_clienteTransportista;
	}

	public Boolean getCargarid_clienteTransportista() {
		return this.cargarid_clienteTransportista;
	}

	public void setCargarid_clienteTransportista(Boolean cargarid_clienteTransportista) {
		this.cargarid_clienteTransportista= cargarid_clienteTransportista;
	}

	public Border setResaltarplacaTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transportistaBeanSwingJInternalFrame.jTtoolBarTransportista.setBorder(borderResaltar);
		
		this.resaltarplacaTransportista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarplacaTransportista() {
		return this.resaltarplacaTransportista;
	}

	public void setResaltarplacaTransportista(Border borderResaltar) {
		this.resaltarplacaTransportista= borderResaltar;
	}

	public Boolean getMostrarplacaTransportista() {
		return this.mostrarplacaTransportista;
	}

	public void setMostrarplacaTransportista(Boolean mostrarplacaTransportista) {
		this.mostrarplacaTransportista= mostrarplacaTransportista;
	}

	public Boolean getActivarplacaTransportista() {
		return this.activarplacaTransportista;
	}

	public void setActivarplacaTransportista(Boolean activarplacaTransportista) {
		this.activarplacaTransportista= activarplacaTransportista;
	}

	public Border setResaltarnumeroTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transportistaBeanSwingJInternalFrame.jTtoolBarTransportista.setBorder(borderResaltar);
		
		this.resaltarnumeroTransportista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroTransportista() {
		return this.resaltarnumeroTransportista;
	}

	public void setResaltarnumeroTransportista(Border borderResaltar) {
		this.resaltarnumeroTransportista= borderResaltar;
	}

	public Boolean getMostrarnumeroTransportista() {
		return this.mostrarnumeroTransportista;
	}

	public void setMostrarnumeroTransportista(Boolean mostrarnumeroTransportista) {
		this.mostrarnumeroTransportista= mostrarnumeroTransportista;
	}

	public Boolean getActivarnumeroTransportista() {
		return this.activarnumeroTransportista;
	}

	public void setActivarnumeroTransportista(Boolean activarnumeroTransportista) {
		this.activarnumeroTransportista= activarnumeroTransportista;
	}

	public Border setResaltarobservacionTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transportistaBeanSwingJInternalFrame.jTtoolBarTransportista.setBorder(borderResaltar);
		
		this.resaltarobservacionTransportista= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionTransportista() {
		return this.resaltarobservacionTransportista;
	}

	public void setResaltarobservacionTransportista(Border borderResaltar) {
		this.resaltarobservacionTransportista= borderResaltar;
	}

	public Boolean getMostrarobservacionTransportista() {
		return this.mostrarobservacionTransportista;
	}

	public void setMostrarobservacionTransportista(Boolean mostrarobservacionTransportista) {
		this.mostrarobservacionTransportista= mostrarobservacionTransportista;
	}

	public Boolean getActivarobservacionTransportista() {
		return this.activarobservacionTransportista;
	}

	public void setActivarobservacionTransportista(Boolean activarobservacionTransportista) {
		this.activarobservacionTransportista= activarobservacionTransportista;
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
		
		
		this.setMostraridTransportista(esInicial);
		this.setMostrarid_empresaTransportista(esInicial);
		this.setMostrarid_sucursalTransportista(esInicial);
		this.setMostrarid_tipo_via_transporteTransportista(esInicial);
		this.setMostraridentificacionTransportista(esInicial);
		this.setMostrarrucTransportista(esInicial);
		this.setMostrarnombreTransportista(esInicial);
		this.setMostrarapellidoTransportista(esInicial);
		this.setMostrarnombre_completoTransportista(esInicial);
		this.setMostrartelefonoTransportista(esInicial);
		this.setMostrardireccionTransportista(esInicial);
		this.setMostrarid_clienteTransportista(esInicial);
		this.setMostrarplacaTransportista(esInicial);
		this.setMostrarnumeroTransportista(esInicial);
		this.setMostrarobservacionTransportista(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransportistaConstantesFunciones.ID)) {
				this.setMostraridTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setMostrarid_tipo_via_transporteTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.IDENTIFICACION)) {
				this.setMostraridentificacionTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.RUC)) {
				this.setMostrarrucTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.APELLIDO)) {
				this.setMostrarapellidoTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.PLACA)) {
				this.setMostrarplacaTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.OBSERVACION)) {
				this.setMostrarobservacionTransportista(esAsigna);
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
		
		
		this.setActivaridTransportista(esInicial);
		this.setActivarid_empresaTransportista(esInicial);
		this.setActivarid_sucursalTransportista(esInicial);
		this.setActivarid_tipo_via_transporteTransportista(esInicial);
		this.setActivaridentificacionTransportista(esInicial);
		this.setActivarrucTransportista(esInicial);
		this.setActivarnombreTransportista(esInicial);
		this.setActivarapellidoTransportista(esInicial);
		this.setActivarnombre_completoTransportista(esInicial);
		this.setActivartelefonoTransportista(esInicial);
		this.setActivardireccionTransportista(esInicial);
		this.setActivarid_clienteTransportista(esInicial);
		this.setActivarplacaTransportista(esInicial);
		this.setActivarnumeroTransportista(esInicial);
		this.setActivarobservacionTransportista(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransportistaConstantesFunciones.ID)) {
				this.setActivaridTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setActivarid_tipo_via_transporteTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.IDENTIFICACION)) {
				this.setActivaridentificacionTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.RUC)) {
				this.setActivarrucTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.APELLIDO)) {
				this.setActivarapellidoTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.DIRECCION)) {
				this.setActivardireccionTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.PLACA)) {
				this.setActivarplacaTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.NUMERO)) {
				this.setActivarnumeroTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.OBSERVACION)) {
				this.setActivarobservacionTransportista(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTransportista(esInicial);
		this.setResaltarid_empresaTransportista(esInicial);
		this.setResaltarid_sucursalTransportista(esInicial);
		this.setResaltarid_tipo_via_transporteTransportista(esInicial);
		this.setResaltaridentificacionTransportista(esInicial);
		this.setResaltarrucTransportista(esInicial);
		this.setResaltarnombreTransportista(esInicial);
		this.setResaltarapellidoTransportista(esInicial);
		this.setResaltarnombre_completoTransportista(esInicial);
		this.setResaltartelefonoTransportista(esInicial);
		this.setResaltardireccionTransportista(esInicial);
		this.setResaltarid_clienteTransportista(esInicial);
		this.setResaltarplacaTransportista(esInicial);
		this.setResaltarnumeroTransportista(esInicial);
		this.setResaltarobservacionTransportista(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransportistaConstantesFunciones.ID)) {
				this.setResaltaridTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setResaltarid_tipo_via_transporteTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.IDENTIFICACION)) {
				this.setResaltaridentificacionTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.RUC)) {
				this.setResaltarrucTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.APELLIDO)) {
				this.setResaltarapellidoTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.PLACA)) {
				this.setResaltarplacaTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroTransportista(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransportistaConstantesFunciones.OBSERVACION)) {
				this.setResaltarobservacionTransportista(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorIdentificacionTransportista=true;

	public Boolean getMostrarBusquedaPorIdentificacionTransportista() {
		return this.mostrarBusquedaPorIdentificacionTransportista;
	}

	public void setMostrarBusquedaPorIdentificacionTransportista(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdentificacionTransportista= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreCompletoTransportista=true;

	public Boolean getMostrarBusquedaPorNombreCompletoTransportista() {
		return this.mostrarBusquedaPorNombreCompletoTransportista;
	}

	public void setMostrarBusquedaPorNombreCompletoTransportista(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreCompletoTransportista= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorPlacaTransportista=true;

	public Boolean getMostrarBusquedaPorPlacaTransportista() {
		return this.mostrarBusquedaPorPlacaTransportista;
	}

	public void setMostrarBusquedaPorPlacaTransportista(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorPlacaTransportista= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorRucTransportista=true;

	public Boolean getMostrarBusquedaPorRucTransportista() {
		return this.mostrarBusquedaPorRucTransportista;
	}

	public void setMostrarBusquedaPorRucTransportista(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorRucTransportista= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorTelefonoTransportista=true;

	public Boolean getMostrarBusquedaPorTelefonoTransportista() {
		return this.mostrarBusquedaPorTelefonoTransportista;
	}

	public void setMostrarBusquedaPorTelefonoTransportista(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorTelefonoTransportista= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteTransportista=true;

	public Boolean getMostrarFK_IdClienteTransportista() {
		return this.mostrarFK_IdClienteTransportista;
	}

	public void setMostrarFK_IdClienteTransportista(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteTransportista= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTransportista=true;

	public Boolean getMostrarFK_IdEmpresaTransportista() {
		return this.mostrarFK_IdEmpresaTransportista;
	}

	public void setMostrarFK_IdEmpresaTransportista(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTransportista= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalTransportista=true;

	public Boolean getMostrarFK_IdSucursalTransportista() {
		return this.mostrarFK_IdSucursalTransportista;
	}

	public void setMostrarFK_IdSucursalTransportista(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalTransportista= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoViaTransporteTransportista=true;

	public Boolean getMostrarFK_IdTipoViaTransporteTransportista() {
		return this.mostrarFK_IdTipoViaTransporteTransportista;
	}

	public void setMostrarFK_IdTipoViaTransporteTransportista(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoViaTransporteTransportista= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdentificacionTransportista=true;

	public Boolean getActivarBusquedaPorIdentificacionTransportista() {
		return this.activarBusquedaPorIdentificacionTransportista;
	}

	public void setActivarBusquedaPorIdentificacionTransportista(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdentificacionTransportista= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreCompletoTransportista=true;

	public Boolean getActivarBusquedaPorNombreCompletoTransportista() {
		return this.activarBusquedaPorNombreCompletoTransportista;
	}

	public void setActivarBusquedaPorNombreCompletoTransportista(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreCompletoTransportista= habilitarResaltar;
	}

	public Boolean activarBusquedaPorPlacaTransportista=true;

	public Boolean getActivarBusquedaPorPlacaTransportista() {
		return this.activarBusquedaPorPlacaTransportista;
	}

	public void setActivarBusquedaPorPlacaTransportista(Boolean habilitarResaltar) {
		this.activarBusquedaPorPlacaTransportista= habilitarResaltar;
	}

	public Boolean activarBusquedaPorRucTransportista=true;

	public Boolean getActivarBusquedaPorRucTransportista() {
		return this.activarBusquedaPorRucTransportista;
	}

	public void setActivarBusquedaPorRucTransportista(Boolean habilitarResaltar) {
		this.activarBusquedaPorRucTransportista= habilitarResaltar;
	}

	public Boolean activarBusquedaPorTelefonoTransportista=true;

	public Boolean getActivarBusquedaPorTelefonoTransportista() {
		return this.activarBusquedaPorTelefonoTransportista;
	}

	public void setActivarBusquedaPorTelefonoTransportista(Boolean habilitarResaltar) {
		this.activarBusquedaPorTelefonoTransportista= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteTransportista=true;

	public Boolean getActivarFK_IdClienteTransportista() {
		return this.activarFK_IdClienteTransportista;
	}

	public void setActivarFK_IdClienteTransportista(Boolean habilitarResaltar) {
		this.activarFK_IdClienteTransportista= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTransportista=true;

	public Boolean getActivarFK_IdEmpresaTransportista() {
		return this.activarFK_IdEmpresaTransportista;
	}

	public void setActivarFK_IdEmpresaTransportista(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTransportista= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalTransportista=true;

	public Boolean getActivarFK_IdSucursalTransportista() {
		return this.activarFK_IdSucursalTransportista;
	}

	public void setActivarFK_IdSucursalTransportista(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalTransportista= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoViaTransporteTransportista=true;

	public Boolean getActivarFK_IdTipoViaTransporteTransportista() {
		return this.activarFK_IdTipoViaTransporteTransportista;
	}

	public void setActivarFK_IdTipoViaTransporteTransportista(Boolean habilitarResaltar) {
		this.activarFK_IdTipoViaTransporteTransportista= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdentificacionTransportista=null;

	public Border getResaltarBusquedaPorIdentificacionTransportista() {
		return this.resaltarBusquedaPorIdentificacionTransportista;
	}

	public void setResaltarBusquedaPorIdentificacionTransportista(Border borderResaltar) {
		this.resaltarBusquedaPorIdentificacionTransportista= borderResaltar;
	}

	public void setResaltarBusquedaPorIdentificacionTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdentificacionTransportista= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreCompletoTransportista=null;

	public Border getResaltarBusquedaPorNombreCompletoTransportista() {
		return this.resaltarBusquedaPorNombreCompletoTransportista;
	}

	public void setResaltarBusquedaPorNombreCompletoTransportista(Border borderResaltar) {
		this.resaltarBusquedaPorNombreCompletoTransportista= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreCompletoTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreCompletoTransportista= borderResaltar;
	}

	public Border resaltarBusquedaPorPlacaTransportista=null;

	public Border getResaltarBusquedaPorPlacaTransportista() {
		return this.resaltarBusquedaPorPlacaTransportista;
	}

	public void setResaltarBusquedaPorPlacaTransportista(Border borderResaltar) {
		this.resaltarBusquedaPorPlacaTransportista= borderResaltar;
	}

	public void setResaltarBusquedaPorPlacaTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorPlacaTransportista= borderResaltar;
	}

	public Border resaltarBusquedaPorRucTransportista=null;

	public Border getResaltarBusquedaPorRucTransportista() {
		return this.resaltarBusquedaPorRucTransportista;
	}

	public void setResaltarBusquedaPorRucTransportista(Border borderResaltar) {
		this.resaltarBusquedaPorRucTransportista= borderResaltar;
	}

	public void setResaltarBusquedaPorRucTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorRucTransportista= borderResaltar;
	}

	public Border resaltarBusquedaPorTelefonoTransportista=null;

	public Border getResaltarBusquedaPorTelefonoTransportista() {
		return this.resaltarBusquedaPorTelefonoTransportista;
	}

	public void setResaltarBusquedaPorTelefonoTransportista(Border borderResaltar) {
		this.resaltarBusquedaPorTelefonoTransportista= borderResaltar;
	}

	public void setResaltarBusquedaPorTelefonoTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorTelefonoTransportista= borderResaltar;
	}

	public Border resaltarFK_IdClienteTransportista=null;

	public Border getResaltarFK_IdClienteTransportista() {
		return this.resaltarFK_IdClienteTransportista;
	}

	public void setResaltarFK_IdClienteTransportista(Border borderResaltar) {
		this.resaltarFK_IdClienteTransportista= borderResaltar;
	}

	public void setResaltarFK_IdClienteTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteTransportista= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTransportista=null;

	public Border getResaltarFK_IdEmpresaTransportista() {
		return this.resaltarFK_IdEmpresaTransportista;
	}

	public void setResaltarFK_IdEmpresaTransportista(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTransportista= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTransportista= borderResaltar;
	}

	public Border resaltarFK_IdSucursalTransportista=null;

	public Border getResaltarFK_IdSucursalTransportista() {
		return this.resaltarFK_IdSucursalTransportista;
	}

	public void setResaltarFK_IdSucursalTransportista(Border borderResaltar) {
		this.resaltarFK_IdSucursalTransportista= borderResaltar;
	}

	public void setResaltarFK_IdSucursalTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalTransportista= borderResaltar;
	}

	public Border resaltarFK_IdTipoViaTransporteTransportista=null;

	public Border getResaltarFK_IdTipoViaTransporteTransportista() {
		return this.resaltarFK_IdTipoViaTransporteTransportista;
	}

	public void setResaltarFK_IdTipoViaTransporteTransportista(Border borderResaltar) {
		this.resaltarFK_IdTipoViaTransporteTransportista= borderResaltar;
	}

	public void setResaltarFK_IdTipoViaTransporteTransportista(ParametroGeneralUsuario parametroGeneralUsuario/*TransportistaBeanSwingJInternalFrame transportistaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoViaTransporteTransportista= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}