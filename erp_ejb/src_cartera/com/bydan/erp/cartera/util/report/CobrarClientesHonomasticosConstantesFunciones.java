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


import com.bydan.erp.cartera.util.report.CobrarClientesHonomasticosConstantesFunciones;
import com.bydan.erp.cartera.util.report.CobrarClientesHonomasticosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarClientesHonomasticosParameterGeneral;

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
final public class CobrarClientesHonomasticosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="CobrarClientesHonomasticos";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CobrarClientesHonomasticos"+CobrarClientesHonomasticosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CobrarClientesHonomasticosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CobrarClientesHonomasticosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"_"+CobrarClientesHonomasticosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CobrarClientesHonomasticosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"_"+CobrarClientesHonomasticosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"_"+CobrarClientesHonomasticosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CobrarClientesHonomasticosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"_"+CobrarClientesHonomasticosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesHonomasticosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarClientesHonomasticosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesHonomasticosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesHonomasticosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarClientesHonomasticosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesHonomasticosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CobrarClientesHonomasticosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CobrarClientesHonomasticosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CobrarClientesHonomasticosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CobrarClientesHonomasticosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cobrar Clientes Honomasticoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cobrar Clientes Honomasticos";
	public static final String SCLASSWEBTITULO_LOWER="Cobrar Clientes Honomasticos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CobrarClientesHonomasticos";
	public static final String OBJECTNAME="cobrarclienteshonomasticos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cobrar_clientes_honomasticos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cobrarclienteshonomasticos from "+CobrarClientesHonomasticosConstantesFunciones.SPERSISTENCENAME+" cobrarclienteshonomasticos";
	public static String QUERYSELECTNATIVE="select "+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".id,"+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".version_row,"+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".id_empresa,"+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".id_sucursal,"+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".id_pais,"+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".id_region,"+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".id_provincia,"+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".id_ciudad,"+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".fecha_nacimiento,"+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".nombre_ciudad,"+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".nombre_ruta,"+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".nombre_vendedor,"+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".codigo,"+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".nombre_completo,"+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".nombre_comercial,"+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".fecha_nacimiento_dato,"+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".direccion_direccion,"+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME+".telefono_telefono from "+CobrarClientesHonomasticosConstantesFunciones.SCHEMA+"."+CobrarClientesHonomasticosConstantesFunciones.TABLENAME;//+" as "+CobrarClientesHonomasticosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDPAIS= "id_pais";
    public static final String IDREGION= "id_region";
    public static final String IDPROVINCIA= "id_provincia";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String FECHANACIMIENTO= "fecha_nacimiento";
    public static final String NOMBRECIUDAD= "nombre_ciudad";
    public static final String NOMBRERUTA= "nombre_ruta";
    public static final String NOMBREVENDEDOR= "nombre_vendedor";
    public static final String CODIGO= "codigo";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String NOMBRECOMERCIAL= "nombre_comercial";
    public static final String FECHANACIMIENTODATO= "fecha_nacimiento_dato";
    public static final String DIRECCIONDIRECCION= "direccion_direccion";
    public static final String TELEFONOTELEFONO= "telefono_telefono";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDREGION= "Region";
		public static final String LABEL_IDREGION_LOWER= "Region";
    	public static final String LABEL_IDPROVINCIA= "Provincia";
		public static final String LABEL_IDPROVINCIA_LOWER= "Provincia";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_FECHANACIMIENTO= "Fecha Nacimiento";
		public static final String LABEL_FECHANACIMIENTO_LOWER= "Fecha Nacimiento";
    	public static final String LABEL_NOMBRECIUDAD= "Nombre Ciudad";
		public static final String LABEL_NOMBRECIUDAD_LOWER= "Nombre Ciudad";
    	public static final String LABEL_NOMBRERUTA= "Nombre Ruta";
		public static final String LABEL_NOMBRERUTA_LOWER= "Nombre Ruta";
    	public static final String LABEL_NOMBREVENDEDOR= "Nombre Vendedor";
		public static final String LABEL_NOMBREVENDEDOR_LOWER= "Nombre Vendedor";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_NOMBRECOMERCIAL= "Nombre Comercial";
		public static final String LABEL_NOMBRECOMERCIAL_LOWER= "Nombre Comercial";
    	public static final String LABEL_FECHANACIMIENTODATO= "Fecha Nacimiento Dato";
		public static final String LABEL_FECHANACIMIENTODATO_LOWER= "Fecha Nacimiento Dato";
    	public static final String LABEL_DIRECCIONDIRECCION= "Direccion Direccion";
		public static final String LABEL_DIRECCIONDIRECCION_LOWER= "Direccion Direccion";
    	public static final String LABEL_TELEFONOTELEFONO= "Telefono Telefono";
		public static final String LABEL_TELEFONOTELEFONO_LOWER= "Telefono Telefono";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_CIUDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CIUDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_RUTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_RUTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_VENDEDOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_VENDEDOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMERCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMERCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDIRECCION_DIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION_DIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO_TELEFONO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONO_TELEFONO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCobrarClientesHonomasticosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CobrarClientesHonomasticosConstantesFunciones.IDEMPRESA)) {sLabelColumna=CobrarClientesHonomasticosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CobrarClientesHonomasticosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CobrarClientesHonomasticosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CobrarClientesHonomasticosConstantesFunciones.IDPAIS)) {sLabelColumna=CobrarClientesHonomasticosConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(CobrarClientesHonomasticosConstantesFunciones.IDREGION)) {sLabelColumna=CobrarClientesHonomasticosConstantesFunciones.LABEL_IDREGION;}
		if(sNombreColumna.equals(CobrarClientesHonomasticosConstantesFunciones.IDPROVINCIA)) {sLabelColumna=CobrarClientesHonomasticosConstantesFunciones.LABEL_IDPROVINCIA;}
		if(sNombreColumna.equals(CobrarClientesHonomasticosConstantesFunciones.IDCIUDAD)) {sLabelColumna=CobrarClientesHonomasticosConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(CobrarClientesHonomasticosConstantesFunciones.FECHANACIMIENTO)) {sLabelColumna=CobrarClientesHonomasticosConstantesFunciones.LABEL_FECHANACIMIENTO;}
		if(sNombreColumna.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBRECIUDAD)) {sLabelColumna=CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRECIUDAD;}
		if(sNombreColumna.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBRERUTA)) {sLabelColumna=CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRERUTA;}
		if(sNombreColumna.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBREVENDEDOR)) {sLabelColumna=CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBREVENDEDOR;}
		if(sNombreColumna.equals(CobrarClientesHonomasticosConstantesFunciones.CODIGO)) {sLabelColumna=CobrarClientesHonomasticosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMERCIAL)) {sLabelColumna=CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRECOMERCIAL;}
		if(sNombreColumna.equals(CobrarClientesHonomasticosConstantesFunciones.FECHANACIMIENTODATO)) {sLabelColumna=CobrarClientesHonomasticosConstantesFunciones.LABEL_FECHANACIMIENTODATO;}
		if(sNombreColumna.equals(CobrarClientesHonomasticosConstantesFunciones.DIRECCIONDIRECCION)) {sLabelColumna=CobrarClientesHonomasticosConstantesFunciones.LABEL_DIRECCIONDIRECCION;}
		if(sNombreColumna.equals(CobrarClientesHonomasticosConstantesFunciones.TELEFONOTELEFONO)) {sLabelColumna=CobrarClientesHonomasticosConstantesFunciones.LABEL_TELEFONOTELEFONO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCobrarClientesHonomasticosDescripcion(CobrarClientesHonomasticos cobrarclienteshonomasticos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cobrarclienteshonomasticos !=null/* && cobrarclienteshonomasticos.getId()!=0*/) {
			sDescripcion=cobrarclienteshonomasticos.getcodigo();//cobrarclienteshonomasticoscobrarclienteshonomasticos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCobrarClientesHonomasticosDescripcionDetallado(CobrarClientesHonomasticos cobrarclienteshonomasticos) {
		String sDescripcion="";
			
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.ID+"=";
		sDescripcion+=cobrarclienteshonomasticos.getId().toString()+",";
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cobrarclienteshonomasticos.getVersionRow().toString()+",";
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cobrarclienteshonomasticos.getid_empresa().toString()+",";
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cobrarclienteshonomasticos.getid_sucursal().toString()+",";
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.IDPAIS+"=";
		sDescripcion+=cobrarclienteshonomasticos.getid_pais().toString()+",";
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.IDREGION+"=";
		sDescripcion+=cobrarclienteshonomasticos.getid_region().toString()+",";
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.IDPROVINCIA+"=";
		sDescripcion+=cobrarclienteshonomasticos.getid_provincia().toString()+",";
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=cobrarclienteshonomasticos.getid_ciudad().toString()+",";
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.FECHANACIMIENTO+"=";
		sDescripcion+=cobrarclienteshonomasticos.getfecha_nacimiento().toString()+",";
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.NOMBRECIUDAD+"=";
		sDescripcion+=cobrarclienteshonomasticos.getnombre_ciudad()+",";
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.NOMBRERUTA+"=";
		sDescripcion+=cobrarclienteshonomasticos.getnombre_ruta()+",";
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.NOMBREVENDEDOR+"=";
		sDescripcion+=cobrarclienteshonomasticos.getnombre_vendedor()+",";
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.CODIGO+"=";
		sDescripcion+=cobrarclienteshonomasticos.getcodigo()+",";
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=cobrarclienteshonomasticos.getnombre_completo()+",";
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMERCIAL+"=";
		sDescripcion+=cobrarclienteshonomasticos.getnombre_comercial()+",";
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.FECHANACIMIENTODATO+"=";
		sDescripcion+=cobrarclienteshonomasticos.getfecha_nacimiento_dato().toString()+",";
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.DIRECCIONDIRECCION+"=";
		sDescripcion+=cobrarclienteshonomasticos.getdireccion_direccion()+",";
		sDescripcion+=CobrarClientesHonomasticosConstantesFunciones.TELEFONOTELEFONO+"=";
		sDescripcion+=cobrarclienteshonomasticos.gettelefono_telefono()+",";
			
		return sDescripcion;
	}
	
	public static void setCobrarClientesHonomasticosDescripcion(CobrarClientesHonomasticos cobrarclienteshonomasticos,String sValor) throws Exception {			
		if(cobrarclienteshonomasticos !=null) {
			cobrarclienteshonomasticos.setcodigo(sValor);;//cobrarclienteshonomasticoscobrarclienteshonomasticos.getcodigo().trim();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaCobrarClientesHonomasticos")) {
			sNombreIndice="Tipo=  Por Pais Por Region Por Provincia Por Ciudad Por Fecha Nacimiento";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdProvincia")) {
			sNombreIndice="Tipo=  Por Provincia";
		} else if(sNombreIndice.equals("FK_IdRegion")) {
			sNombreIndice="Tipo=  Por Region";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCobrarClientesHonomasticos(Long id_pais,Long id_region,Long id_provincia,Long id_ciudad,Date fecha_nacimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();}
		if(id_region!=null) {sDetalleIndice+=" Codigo Unico De Region="+id_region.toString();}
		if(id_provincia!=null) {sDetalleIndice+=" Codigo Unico De Provincia="+id_provincia.toString();}
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();}
		if(fecha_nacimiento!=null) {sDetalleIndice+=" Fecha Nacimiento="+fecha_nacimiento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCobrarClientesHonomasticos(CobrarClientesHonomasticos cobrarclienteshonomasticos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarclienteshonomasticos.setnombre_ciudad(cobrarclienteshonomasticos.getnombre_ciudad().trim());
		cobrarclienteshonomasticos.setnombre_ruta(cobrarclienteshonomasticos.getnombre_ruta().trim());
		cobrarclienteshonomasticos.setnombre_vendedor(cobrarclienteshonomasticos.getnombre_vendedor().trim());
		cobrarclienteshonomasticos.setcodigo(cobrarclienteshonomasticos.getcodigo().trim());
		cobrarclienteshonomasticos.setnombre_completo(cobrarclienteshonomasticos.getnombre_completo().trim());
		cobrarclienteshonomasticos.setnombre_comercial(cobrarclienteshonomasticos.getnombre_comercial().trim());
		cobrarclienteshonomasticos.setdireccion_direccion(cobrarclienteshonomasticos.getdireccion_direccion().trim());
		cobrarclienteshonomasticos.settelefono_telefono(cobrarclienteshonomasticos.gettelefono_telefono().trim());
	}
	
	public static void quitarEspaciosCobrarClientesHonomasticoss(List<CobrarClientesHonomasticos> cobrarclienteshonomasticoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarClientesHonomasticos cobrarclienteshonomasticos: cobrarclienteshonomasticoss) {
			cobrarclienteshonomasticos.setnombre_ciudad(cobrarclienteshonomasticos.getnombre_ciudad().trim());
			cobrarclienteshonomasticos.setnombre_ruta(cobrarclienteshonomasticos.getnombre_ruta().trim());
			cobrarclienteshonomasticos.setnombre_vendedor(cobrarclienteshonomasticos.getnombre_vendedor().trim());
			cobrarclienteshonomasticos.setcodigo(cobrarclienteshonomasticos.getcodigo().trim());
			cobrarclienteshonomasticos.setnombre_completo(cobrarclienteshonomasticos.getnombre_completo().trim());
			cobrarclienteshonomasticos.setnombre_comercial(cobrarclienteshonomasticos.getnombre_comercial().trim());
			cobrarclienteshonomasticos.setdireccion_direccion(cobrarclienteshonomasticos.getdireccion_direccion().trim());
			cobrarclienteshonomasticos.settelefono_telefono(cobrarclienteshonomasticos.gettelefono_telefono().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarClientesHonomasticos(CobrarClientesHonomasticos cobrarclienteshonomasticos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cobrarclienteshonomasticos.getConCambioAuxiliar()) {
			cobrarclienteshonomasticos.setIsDeleted(cobrarclienteshonomasticos.getIsDeletedAuxiliar());	
			cobrarclienteshonomasticos.setIsNew(cobrarclienteshonomasticos.getIsNewAuxiliar());	
			cobrarclienteshonomasticos.setIsChanged(cobrarclienteshonomasticos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cobrarclienteshonomasticos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cobrarclienteshonomasticos.setIsDeletedAuxiliar(false);	
			cobrarclienteshonomasticos.setIsNewAuxiliar(false);	
			cobrarclienteshonomasticos.setIsChangedAuxiliar(false);
			
			cobrarclienteshonomasticos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarClientesHonomasticoss(List<CobrarClientesHonomasticos> cobrarclienteshonomasticoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CobrarClientesHonomasticos cobrarclienteshonomasticos : cobrarclienteshonomasticoss) {
			if(conAsignarBase && cobrarclienteshonomasticos.getConCambioAuxiliar()) {
				cobrarclienteshonomasticos.setIsDeleted(cobrarclienteshonomasticos.getIsDeletedAuxiliar());	
				cobrarclienteshonomasticos.setIsNew(cobrarclienteshonomasticos.getIsNewAuxiliar());	
				cobrarclienteshonomasticos.setIsChanged(cobrarclienteshonomasticos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cobrarclienteshonomasticos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cobrarclienteshonomasticos.setIsDeletedAuxiliar(false);	
				cobrarclienteshonomasticos.setIsNewAuxiliar(false);	
				cobrarclienteshonomasticos.setIsChangedAuxiliar(false);
				
				cobrarclienteshonomasticos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCobrarClientesHonomasticos(CobrarClientesHonomasticos cobrarclienteshonomasticos,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCobrarClientesHonomasticoss(List<CobrarClientesHonomasticos> cobrarclienteshonomasticoss,Boolean conEnteros) throws Exception  {
		
		for(CobrarClientesHonomasticos cobrarclienteshonomasticos: cobrarclienteshonomasticoss) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCobrarClientesHonomasticos(List<CobrarClientesHonomasticos> cobrarclienteshonomasticoss,CobrarClientesHonomasticos cobrarclienteshonomasticosAux) throws Exception  {
		CobrarClientesHonomasticosConstantesFunciones.InicializarValoresCobrarClientesHonomasticos(cobrarclienteshonomasticosAux,true);
		
		for(CobrarClientesHonomasticos cobrarclienteshonomasticos: cobrarclienteshonomasticoss) {
			if(cobrarclienteshonomasticos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarClientesHonomasticos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CobrarClientesHonomasticosConstantesFunciones.getArrayColumnasGlobalesCobrarClientesHonomasticos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarClientesHonomasticos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarClientesHonomasticosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarClientesHonomasticosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarClientesHonomasticosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarClientesHonomasticosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCobrarClientesHonomasticos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarClientesHonomasticos> cobrarclienteshonomasticoss,CobrarClientesHonomasticos cobrarclienteshonomasticos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarClientesHonomasticos cobrarclienteshonomasticosAux: cobrarclienteshonomasticoss) {
			if(cobrarclienteshonomasticosAux!=null && cobrarclienteshonomasticos!=null) {
				if((cobrarclienteshonomasticosAux.getId()==null && cobrarclienteshonomasticos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cobrarclienteshonomasticosAux.getId()!=null && cobrarclienteshonomasticos.getId()!=null){
					if(cobrarclienteshonomasticosAux.getId().equals(cobrarclienteshonomasticos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarClientesHonomasticos(List<CobrarClientesHonomasticos> cobrarclienteshonomasticoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CobrarClientesHonomasticos cobrarclienteshonomasticos: cobrarclienteshonomasticoss) {			
			if(cobrarclienteshonomasticos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCobrarClientesHonomasticos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CobrarClientesHonomasticosConstantesFunciones.LABEL_ID, CobrarClientesHonomasticosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesHonomasticosConstantesFunciones.LABEL_VERSIONROW, CobrarClientesHonomasticosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRECIUDAD, CobrarClientesHonomasticosConstantesFunciones.NOMBRECIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRERUTA, CobrarClientesHonomasticosConstantesFunciones.NOMBRERUTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBREVENDEDOR, CobrarClientesHonomasticosConstantesFunciones.NOMBREVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesHonomasticosConstantesFunciones.LABEL_CODIGO, CobrarClientesHonomasticosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRECOMPLETO, CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRECOMERCIAL, CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMERCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesHonomasticosConstantesFunciones.LABEL_FECHANACIMIENTODATO, CobrarClientesHonomasticosConstantesFunciones.FECHANACIMIENTODATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesHonomasticosConstantesFunciones.LABEL_DIRECCIONDIRECCION, CobrarClientesHonomasticosConstantesFunciones.DIRECCIONDIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesHonomasticosConstantesFunciones.LABEL_TELEFONOTELEFONO, CobrarClientesHonomasticosConstantesFunciones.TELEFONOTELEFONO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCobrarClientesHonomasticos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesHonomasticosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesHonomasticosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesHonomasticosConstantesFunciones.NOMBRECIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesHonomasticosConstantesFunciones.NOMBRERUTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesHonomasticosConstantesFunciones.NOMBREVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesHonomasticosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMERCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesHonomasticosConstantesFunciones.FECHANACIMIENTODATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesHonomasticosConstantesFunciones.DIRECCIONDIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesHonomasticosConstantesFunciones.TELEFONOTELEFONO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesHonomasticos() throws Exception  {
		return CobrarClientesHonomasticosConstantesFunciones.getTiposSeleccionarCobrarClientesHonomasticos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesHonomasticos(Boolean conFk) throws Exception  {
		return CobrarClientesHonomasticosConstantesFunciones.getTiposSeleccionarCobrarClientesHonomasticos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesHonomasticos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDREGION);
			reporte.setsDescripcion(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDREGION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDPROVINCIA);
			reporte.setsDescripcion(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDPROVINCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesHonomasticosConstantesFunciones.LABEL_FECHANACIMIENTO);
			reporte.setsDescripcion(CobrarClientesHonomasticosConstantesFunciones.LABEL_FECHANACIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRECIUDAD);
			reporte.setsDescripcion(CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRECIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRERUTA);
			reporte.setsDescripcion(CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRERUTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBREVENDEDOR);
			reporte.setsDescripcion(CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBREVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesHonomasticosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CobrarClientesHonomasticosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRECOMERCIAL);
			reporte.setsDescripcion(CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRECOMERCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesHonomasticosConstantesFunciones.LABEL_FECHANACIMIENTODATO);
			reporte.setsDescripcion(CobrarClientesHonomasticosConstantesFunciones.LABEL_FECHANACIMIENTODATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesHonomasticosConstantesFunciones.LABEL_DIRECCIONDIRECCION);
			reporte.setsDescripcion(CobrarClientesHonomasticosConstantesFunciones.LABEL_DIRECCIONDIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesHonomasticosConstantesFunciones.LABEL_TELEFONOTELEFONO);
			reporte.setsDescripcion(CobrarClientesHonomasticosConstantesFunciones.LABEL_TELEFONOTELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCobrarClientesHonomasticos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarClientesHonomasticos(CobrarClientesHonomasticos cobrarclienteshonomasticosAux) throws Exception {
		
			cobrarclienteshonomasticosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarclienteshonomasticosAux.getEmpresa()));
			cobrarclienteshonomasticosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cobrarclienteshonomasticosAux.getSucursal()));
			cobrarclienteshonomasticosAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(cobrarclienteshonomasticosAux.getPais()));
			cobrarclienteshonomasticosAux.setregion_descripcion(RegionConstantesFunciones.getRegionDescripcion(cobrarclienteshonomasticosAux.getRegion()));
			cobrarclienteshonomasticosAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(cobrarclienteshonomasticosAux.getProvincia()));
			cobrarclienteshonomasticosAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(cobrarclienteshonomasticosAux.getCiudad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarClientesHonomasticos(List<CobrarClientesHonomasticos> cobrarclienteshonomasticossTemp) throws Exception {
		for(CobrarClientesHonomasticos cobrarclienteshonomasticosAux:cobrarclienteshonomasticossTemp) {
			
			cobrarclienteshonomasticosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarclienteshonomasticosAux.getEmpresa()));
			cobrarclienteshonomasticosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cobrarclienteshonomasticosAux.getSucursal()));
			cobrarclienteshonomasticosAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(cobrarclienteshonomasticosAux.getPais()));
			cobrarclienteshonomasticosAux.setregion_descripcion(RegionConstantesFunciones.getRegionDescripcion(cobrarclienteshonomasticosAux.getRegion()));
			cobrarclienteshonomasticosAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(cobrarclienteshonomasticosAux.getProvincia()));
			cobrarclienteshonomasticosAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(cobrarclienteshonomasticosAux.getCiudad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCobrarClientesHonomasticos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Region.class));
				classes.add(new Classe(Provincia.class));
				classes.add(new Classe(Ciudad.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCobrarClientesHonomasticos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarClientesHonomasticos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarClientesHonomasticosConstantesFunciones.getClassesRelationshipsOfCobrarClientesHonomasticos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarClientesHonomasticos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarClientesHonomasticos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarClientesHonomasticosConstantesFunciones.getClassesRelationshipsFromStringsOfCobrarClientesHonomasticos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarClientesHonomasticos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CobrarClientesHonomasticos cobrarclienteshonomasticos,List<CobrarClientesHonomasticos> cobrarclienteshonomasticoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CobrarClientesHonomasticos cobrarclienteshonomasticos,List<CobrarClientesHonomasticos> cobrarclienteshonomasticoss) throws Exception {
		try	{			
			for(CobrarClientesHonomasticos cobrarclienteshonomasticosLocal:cobrarclienteshonomasticoss) {
				if(cobrarclienteshonomasticosLocal.getId().equals(cobrarclienteshonomasticos.getId())) {
					cobrarclienteshonomasticosLocal.setIsSelected(cobrarclienteshonomasticos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCobrarClientesHonomasticos(List<CobrarClientesHonomasticos> cobrarclienteshonomasticossAux) throws Exception {
		//this.cobrarclienteshonomasticossAux=cobrarclienteshonomasticossAux;
		
		for(CobrarClientesHonomasticos cobrarclienteshonomasticosAux:cobrarclienteshonomasticossAux) {
			if(cobrarclienteshonomasticosAux.getIsChanged()) {
				cobrarclienteshonomasticosAux.setIsChanged(false);
			}		
			
			if(cobrarclienteshonomasticosAux.getIsNew()) {
				cobrarclienteshonomasticosAux.setIsNew(false);
			}	
			
			if(cobrarclienteshonomasticosAux.getIsDeleted()) {
				cobrarclienteshonomasticosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCobrarClientesHonomasticos(CobrarClientesHonomasticos cobrarclienteshonomasticosAux) throws Exception {
		//this.cobrarclienteshonomasticosAux=cobrarclienteshonomasticosAux;
		
			if(cobrarclienteshonomasticosAux.getIsChanged()) {
				cobrarclienteshonomasticosAux.setIsChanged(false);
			}		
			
			if(cobrarclienteshonomasticosAux.getIsNew()) {
				cobrarclienteshonomasticosAux.setIsNew(false);
			}	
			
			if(cobrarclienteshonomasticosAux.getIsDeleted()) {
				cobrarclienteshonomasticosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CobrarClientesHonomasticos cobrarclienteshonomasticosAsignar,CobrarClientesHonomasticos cobrarclienteshonomasticos) throws Exception {
		cobrarclienteshonomasticosAsignar.setId(cobrarclienteshonomasticos.getId());	
		cobrarclienteshonomasticosAsignar.setVersionRow(cobrarclienteshonomasticos.getVersionRow());	
		cobrarclienteshonomasticosAsignar.setnombre_ciudad(cobrarclienteshonomasticos.getnombre_ciudad());	
		cobrarclienteshonomasticosAsignar.setnombre_ruta(cobrarclienteshonomasticos.getnombre_ruta());	
		cobrarclienteshonomasticosAsignar.setnombre_vendedor(cobrarclienteshonomasticos.getnombre_vendedor());	
		cobrarclienteshonomasticosAsignar.setcodigo(cobrarclienteshonomasticos.getcodigo());	
		cobrarclienteshonomasticosAsignar.setnombre_completo(cobrarclienteshonomasticos.getnombre_completo());	
		cobrarclienteshonomasticosAsignar.setnombre_comercial(cobrarclienteshonomasticos.getnombre_comercial());	
		cobrarclienteshonomasticosAsignar.setfecha_nacimiento_dato(cobrarclienteshonomasticos.getfecha_nacimiento_dato());	
		cobrarclienteshonomasticosAsignar.setdireccion_direccion(cobrarclienteshonomasticos.getdireccion_direccion());	
		cobrarclienteshonomasticosAsignar.settelefono_telefono(cobrarclienteshonomasticos.gettelefono_telefono());	
	}
	
	public static void inicializarCobrarClientesHonomasticos(CobrarClientesHonomasticos cobrarclienteshonomasticos) throws Exception {
		try {
				cobrarclienteshonomasticos.setId(0L);	
					
				cobrarclienteshonomasticos.setnombre_ciudad("");	
				cobrarclienteshonomasticos.setnombre_ruta("");	
				cobrarclienteshonomasticos.setnombre_vendedor("");	
				cobrarclienteshonomasticos.setcodigo("");	
				cobrarclienteshonomasticos.setnombre_completo("");	
				cobrarclienteshonomasticos.setnombre_comercial("");	
				cobrarclienteshonomasticos.setfecha_nacimiento_dato(new Date());	
				cobrarclienteshonomasticos.setdireccion_direccion("");	
				cobrarclienteshonomasticos.settelefono_telefono("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCobrarClientesHonomasticos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDREGION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDPROVINCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesHonomasticosConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesHonomasticosConstantesFunciones.LABEL_FECHANACIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRECIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRERUTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBREVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesHonomasticosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesHonomasticosConstantesFunciones.LABEL_NOMBRECOMERCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesHonomasticosConstantesFunciones.LABEL_FECHANACIMIENTODATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesHonomasticosConstantesFunciones.LABEL_DIRECCIONDIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesHonomasticosConstantesFunciones.LABEL_TELEFONOTELEFONO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCobrarClientesHonomasticos(String sTipo,Row row,Workbook workbook,CobrarClientesHonomasticos cobrarclienteshonomasticos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclienteshonomasticos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclienteshonomasticos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclienteshonomasticos.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclienteshonomasticos.getregion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclienteshonomasticos.getprovincia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclienteshonomasticos.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclienteshonomasticos.getfecha_nacimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclienteshonomasticos.getnombre_ciudad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclienteshonomasticos.getnombre_ruta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclienteshonomasticos.getnombre_vendedor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclienteshonomasticos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclienteshonomasticos.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclienteshonomasticos.getnombre_comercial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclienteshonomasticos.getfecha_nacimiento_dato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclienteshonomasticos.getdireccion_direccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclienteshonomasticos.gettelefono_telefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCobrarClientesHonomasticos="";
	
	public String getsFinalQueryCobrarClientesHonomasticos() {
		return this.sFinalQueryCobrarClientesHonomasticos;
	}
	
	public void setsFinalQueryCobrarClientesHonomasticos(String sFinalQueryCobrarClientesHonomasticos) {
		this.sFinalQueryCobrarClientesHonomasticos= sFinalQueryCobrarClientesHonomasticos;
	}
	
	public Border resaltarSeleccionarCobrarClientesHonomasticos=null;
	
	public Border setResaltarSeleccionarCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCobrarClientesHonomasticos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCobrarClientesHonomasticos() {
		return this.resaltarSeleccionarCobrarClientesHonomasticos;
	}
	
	public void setResaltarSeleccionarCobrarClientesHonomasticos(Border borderResaltarSeleccionarCobrarClientesHonomasticos) {
		this.resaltarSeleccionarCobrarClientesHonomasticos= borderResaltarSeleccionarCobrarClientesHonomasticos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCobrarClientesHonomasticos=null;
	public Boolean mostraridCobrarClientesHonomasticos=true;
	public Boolean activaridCobrarClientesHonomasticos=true;

	public Border resaltarid_empresaCobrarClientesHonomasticos=null;
	public Boolean mostrarid_empresaCobrarClientesHonomasticos=true;
	public Boolean activarid_empresaCobrarClientesHonomasticos=true;
	public Boolean cargarid_empresaCobrarClientesHonomasticos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCobrarClientesHonomasticos=false;//ConEventDepend=true

	public Border resaltarid_sucursalCobrarClientesHonomasticos=null;
	public Boolean mostrarid_sucursalCobrarClientesHonomasticos=true;
	public Boolean activarid_sucursalCobrarClientesHonomasticos=true;
	public Boolean cargarid_sucursalCobrarClientesHonomasticos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCobrarClientesHonomasticos=false;//ConEventDepend=true

	public Border resaltarid_paisCobrarClientesHonomasticos=null;
	public Boolean mostrarid_paisCobrarClientesHonomasticos=true;
	public Boolean activarid_paisCobrarClientesHonomasticos=true;
	public Boolean cargarid_paisCobrarClientesHonomasticos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisCobrarClientesHonomasticos=false;//ConEventDepend=true

	public Border resaltarid_regionCobrarClientesHonomasticos=null;
	public Boolean mostrarid_regionCobrarClientesHonomasticos=true;
	public Boolean activarid_regionCobrarClientesHonomasticos=true;
	public Boolean cargarid_regionCobrarClientesHonomasticos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_regionCobrarClientesHonomasticos=false;//ConEventDepend=true

	public Border resaltarid_provinciaCobrarClientesHonomasticos=null;
	public Boolean mostrarid_provinciaCobrarClientesHonomasticos=true;
	public Boolean activarid_provinciaCobrarClientesHonomasticos=true;
	public Boolean cargarid_provinciaCobrarClientesHonomasticos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_provinciaCobrarClientesHonomasticos=false;//ConEventDepend=true

	public Border resaltarid_ciudadCobrarClientesHonomasticos=null;
	public Boolean mostrarid_ciudadCobrarClientesHonomasticos=true;
	public Boolean activarid_ciudadCobrarClientesHonomasticos=true;
	public Boolean cargarid_ciudadCobrarClientesHonomasticos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadCobrarClientesHonomasticos=false;//ConEventDepend=true

	public Border resaltarfecha_nacimientoCobrarClientesHonomasticos=null;
	public Boolean mostrarfecha_nacimientoCobrarClientesHonomasticos=true;
	public Boolean activarfecha_nacimientoCobrarClientesHonomasticos=true;

	public Border resaltarnombre_ciudadCobrarClientesHonomasticos=null;
	public Boolean mostrarnombre_ciudadCobrarClientesHonomasticos=true;
	public Boolean activarnombre_ciudadCobrarClientesHonomasticos=true;

	public Border resaltarnombre_rutaCobrarClientesHonomasticos=null;
	public Boolean mostrarnombre_rutaCobrarClientesHonomasticos=true;
	public Boolean activarnombre_rutaCobrarClientesHonomasticos=true;

	public Border resaltarnombre_vendedorCobrarClientesHonomasticos=null;
	public Boolean mostrarnombre_vendedorCobrarClientesHonomasticos=true;
	public Boolean activarnombre_vendedorCobrarClientesHonomasticos=true;

	public Border resaltarcodigoCobrarClientesHonomasticos=null;
	public Boolean mostrarcodigoCobrarClientesHonomasticos=true;
	public Boolean activarcodigoCobrarClientesHonomasticos=true;

	public Border resaltarnombre_completoCobrarClientesHonomasticos=null;
	public Boolean mostrarnombre_completoCobrarClientesHonomasticos=true;
	public Boolean activarnombre_completoCobrarClientesHonomasticos=true;

	public Border resaltarnombre_comercialCobrarClientesHonomasticos=null;
	public Boolean mostrarnombre_comercialCobrarClientesHonomasticos=true;
	public Boolean activarnombre_comercialCobrarClientesHonomasticos=true;

	public Border resaltarfecha_nacimiento_datoCobrarClientesHonomasticos=null;
	public Boolean mostrarfecha_nacimiento_datoCobrarClientesHonomasticos=true;
	public Boolean activarfecha_nacimiento_datoCobrarClientesHonomasticos=true;

	public Border resaltardireccion_direccionCobrarClientesHonomasticos=null;
	public Boolean mostrardireccion_direccionCobrarClientesHonomasticos=true;
	public Boolean activardireccion_direccionCobrarClientesHonomasticos=true;

	public Border resaltartelefono_telefonoCobrarClientesHonomasticos=null;
	public Boolean mostrartelefono_telefonoCobrarClientesHonomasticos=true;
	public Boolean activartelefono_telefonoCobrarClientesHonomasticos=true;

	
	

	public Border setResaltaridCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltaridCobrarClientesHonomasticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCobrarClientesHonomasticos() {
		return this.resaltaridCobrarClientesHonomasticos;
	}

	public void setResaltaridCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltaridCobrarClientesHonomasticos= borderResaltar;
	}

	public Boolean getMostraridCobrarClientesHonomasticos() {
		return this.mostraridCobrarClientesHonomasticos;
	}

	public void setMostraridCobrarClientesHonomasticos(Boolean mostraridCobrarClientesHonomasticos) {
		this.mostraridCobrarClientesHonomasticos= mostraridCobrarClientesHonomasticos;
	}

	public Boolean getActivaridCobrarClientesHonomasticos() {
		return this.activaridCobrarClientesHonomasticos;
	}

	public void setActivaridCobrarClientesHonomasticos(Boolean activaridCobrarClientesHonomasticos) {
		this.activaridCobrarClientesHonomasticos= activaridCobrarClientesHonomasticos;
	}

	public Border setResaltarid_empresaCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltarid_empresaCobrarClientesHonomasticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCobrarClientesHonomasticos() {
		return this.resaltarid_empresaCobrarClientesHonomasticos;
	}

	public void setResaltarid_empresaCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltarid_empresaCobrarClientesHonomasticos= borderResaltar;
	}

	public Boolean getMostrarid_empresaCobrarClientesHonomasticos() {
		return this.mostrarid_empresaCobrarClientesHonomasticos;
	}

	public void setMostrarid_empresaCobrarClientesHonomasticos(Boolean mostrarid_empresaCobrarClientesHonomasticos) {
		this.mostrarid_empresaCobrarClientesHonomasticos= mostrarid_empresaCobrarClientesHonomasticos;
	}

	public Boolean getActivarid_empresaCobrarClientesHonomasticos() {
		return this.activarid_empresaCobrarClientesHonomasticos;
	}

	public void setActivarid_empresaCobrarClientesHonomasticos(Boolean activarid_empresaCobrarClientesHonomasticos) {
		this.activarid_empresaCobrarClientesHonomasticos= activarid_empresaCobrarClientesHonomasticos;
	}

	public Boolean getCargarid_empresaCobrarClientesHonomasticos() {
		return this.cargarid_empresaCobrarClientesHonomasticos;
	}

	public void setCargarid_empresaCobrarClientesHonomasticos(Boolean cargarid_empresaCobrarClientesHonomasticos) {
		this.cargarid_empresaCobrarClientesHonomasticos= cargarid_empresaCobrarClientesHonomasticos;
	}

	public Border setResaltarid_sucursalCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCobrarClientesHonomasticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCobrarClientesHonomasticos() {
		return this.resaltarid_sucursalCobrarClientesHonomasticos;
	}

	public void setResaltarid_sucursalCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltarid_sucursalCobrarClientesHonomasticos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCobrarClientesHonomasticos() {
		return this.mostrarid_sucursalCobrarClientesHonomasticos;
	}

	public void setMostrarid_sucursalCobrarClientesHonomasticos(Boolean mostrarid_sucursalCobrarClientesHonomasticos) {
		this.mostrarid_sucursalCobrarClientesHonomasticos= mostrarid_sucursalCobrarClientesHonomasticos;
	}

	public Boolean getActivarid_sucursalCobrarClientesHonomasticos() {
		return this.activarid_sucursalCobrarClientesHonomasticos;
	}

	public void setActivarid_sucursalCobrarClientesHonomasticos(Boolean activarid_sucursalCobrarClientesHonomasticos) {
		this.activarid_sucursalCobrarClientesHonomasticos= activarid_sucursalCobrarClientesHonomasticos;
	}

	public Boolean getCargarid_sucursalCobrarClientesHonomasticos() {
		return this.cargarid_sucursalCobrarClientesHonomasticos;
	}

	public void setCargarid_sucursalCobrarClientesHonomasticos(Boolean cargarid_sucursalCobrarClientesHonomasticos) {
		this.cargarid_sucursalCobrarClientesHonomasticos= cargarid_sucursalCobrarClientesHonomasticos;
	}

	public Border setResaltarid_paisCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltarid_paisCobrarClientesHonomasticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisCobrarClientesHonomasticos() {
		return this.resaltarid_paisCobrarClientesHonomasticos;
	}

	public void setResaltarid_paisCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltarid_paisCobrarClientesHonomasticos= borderResaltar;
	}

	public Boolean getMostrarid_paisCobrarClientesHonomasticos() {
		return this.mostrarid_paisCobrarClientesHonomasticos;
	}

	public void setMostrarid_paisCobrarClientesHonomasticos(Boolean mostrarid_paisCobrarClientesHonomasticos) {
		this.mostrarid_paisCobrarClientesHonomasticos= mostrarid_paisCobrarClientesHonomasticos;
	}

	public Boolean getActivarid_paisCobrarClientesHonomasticos() {
		return this.activarid_paisCobrarClientesHonomasticos;
	}

	public void setActivarid_paisCobrarClientesHonomasticos(Boolean activarid_paisCobrarClientesHonomasticos) {
		this.activarid_paisCobrarClientesHonomasticos= activarid_paisCobrarClientesHonomasticos;
	}

	public Boolean getCargarid_paisCobrarClientesHonomasticos() {
		return this.cargarid_paisCobrarClientesHonomasticos;
	}

	public void setCargarid_paisCobrarClientesHonomasticos(Boolean cargarid_paisCobrarClientesHonomasticos) {
		this.cargarid_paisCobrarClientesHonomasticos= cargarid_paisCobrarClientesHonomasticos;
	}

	public Border setResaltarid_regionCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltarid_regionCobrarClientesHonomasticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_regionCobrarClientesHonomasticos() {
		return this.resaltarid_regionCobrarClientesHonomasticos;
	}

	public void setResaltarid_regionCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltarid_regionCobrarClientesHonomasticos= borderResaltar;
	}

	public Boolean getMostrarid_regionCobrarClientesHonomasticos() {
		return this.mostrarid_regionCobrarClientesHonomasticos;
	}

	public void setMostrarid_regionCobrarClientesHonomasticos(Boolean mostrarid_regionCobrarClientesHonomasticos) {
		this.mostrarid_regionCobrarClientesHonomasticos= mostrarid_regionCobrarClientesHonomasticos;
	}

	public Boolean getActivarid_regionCobrarClientesHonomasticos() {
		return this.activarid_regionCobrarClientesHonomasticos;
	}

	public void setActivarid_regionCobrarClientesHonomasticos(Boolean activarid_regionCobrarClientesHonomasticos) {
		this.activarid_regionCobrarClientesHonomasticos= activarid_regionCobrarClientesHonomasticos;
	}

	public Boolean getCargarid_regionCobrarClientesHonomasticos() {
		return this.cargarid_regionCobrarClientesHonomasticos;
	}

	public void setCargarid_regionCobrarClientesHonomasticos(Boolean cargarid_regionCobrarClientesHonomasticos) {
		this.cargarid_regionCobrarClientesHonomasticos= cargarid_regionCobrarClientesHonomasticos;
	}

	public Border setResaltarid_provinciaCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltarid_provinciaCobrarClientesHonomasticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_provinciaCobrarClientesHonomasticos() {
		return this.resaltarid_provinciaCobrarClientesHonomasticos;
	}

	public void setResaltarid_provinciaCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltarid_provinciaCobrarClientesHonomasticos= borderResaltar;
	}

	public Boolean getMostrarid_provinciaCobrarClientesHonomasticos() {
		return this.mostrarid_provinciaCobrarClientesHonomasticos;
	}

	public void setMostrarid_provinciaCobrarClientesHonomasticos(Boolean mostrarid_provinciaCobrarClientesHonomasticos) {
		this.mostrarid_provinciaCobrarClientesHonomasticos= mostrarid_provinciaCobrarClientesHonomasticos;
	}

	public Boolean getActivarid_provinciaCobrarClientesHonomasticos() {
		return this.activarid_provinciaCobrarClientesHonomasticos;
	}

	public void setActivarid_provinciaCobrarClientesHonomasticos(Boolean activarid_provinciaCobrarClientesHonomasticos) {
		this.activarid_provinciaCobrarClientesHonomasticos= activarid_provinciaCobrarClientesHonomasticos;
	}

	public Boolean getCargarid_provinciaCobrarClientesHonomasticos() {
		return this.cargarid_provinciaCobrarClientesHonomasticos;
	}

	public void setCargarid_provinciaCobrarClientesHonomasticos(Boolean cargarid_provinciaCobrarClientesHonomasticos) {
		this.cargarid_provinciaCobrarClientesHonomasticos= cargarid_provinciaCobrarClientesHonomasticos;
	}

	public Border setResaltarid_ciudadCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltarid_ciudadCobrarClientesHonomasticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadCobrarClientesHonomasticos() {
		return this.resaltarid_ciudadCobrarClientesHonomasticos;
	}

	public void setResaltarid_ciudadCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltarid_ciudadCobrarClientesHonomasticos= borderResaltar;
	}

	public Boolean getMostrarid_ciudadCobrarClientesHonomasticos() {
		return this.mostrarid_ciudadCobrarClientesHonomasticos;
	}

	public void setMostrarid_ciudadCobrarClientesHonomasticos(Boolean mostrarid_ciudadCobrarClientesHonomasticos) {
		this.mostrarid_ciudadCobrarClientesHonomasticos= mostrarid_ciudadCobrarClientesHonomasticos;
	}

	public Boolean getActivarid_ciudadCobrarClientesHonomasticos() {
		return this.activarid_ciudadCobrarClientesHonomasticos;
	}

	public void setActivarid_ciudadCobrarClientesHonomasticos(Boolean activarid_ciudadCobrarClientesHonomasticos) {
		this.activarid_ciudadCobrarClientesHonomasticos= activarid_ciudadCobrarClientesHonomasticos;
	}

	public Boolean getCargarid_ciudadCobrarClientesHonomasticos() {
		return this.cargarid_ciudadCobrarClientesHonomasticos;
	}

	public void setCargarid_ciudadCobrarClientesHonomasticos(Boolean cargarid_ciudadCobrarClientesHonomasticos) {
		this.cargarid_ciudadCobrarClientesHonomasticos= cargarid_ciudadCobrarClientesHonomasticos;
	}

	public Border setResaltarfecha_nacimientoCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltarfecha_nacimientoCobrarClientesHonomasticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_nacimientoCobrarClientesHonomasticos() {
		return this.resaltarfecha_nacimientoCobrarClientesHonomasticos;
	}

	public void setResaltarfecha_nacimientoCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltarfecha_nacimientoCobrarClientesHonomasticos= borderResaltar;
	}

	public Boolean getMostrarfecha_nacimientoCobrarClientesHonomasticos() {
		return this.mostrarfecha_nacimientoCobrarClientesHonomasticos;
	}

	public void setMostrarfecha_nacimientoCobrarClientesHonomasticos(Boolean mostrarfecha_nacimientoCobrarClientesHonomasticos) {
		this.mostrarfecha_nacimientoCobrarClientesHonomasticos= mostrarfecha_nacimientoCobrarClientesHonomasticos;
	}

	public Boolean getActivarfecha_nacimientoCobrarClientesHonomasticos() {
		return this.activarfecha_nacimientoCobrarClientesHonomasticos;
	}

	public void setActivarfecha_nacimientoCobrarClientesHonomasticos(Boolean activarfecha_nacimientoCobrarClientesHonomasticos) {
		this.activarfecha_nacimientoCobrarClientesHonomasticos= activarfecha_nacimientoCobrarClientesHonomasticos;
	}

	public Border setResaltarnombre_ciudadCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltarnombre_ciudadCobrarClientesHonomasticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_ciudadCobrarClientesHonomasticos() {
		return this.resaltarnombre_ciudadCobrarClientesHonomasticos;
	}

	public void setResaltarnombre_ciudadCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltarnombre_ciudadCobrarClientesHonomasticos= borderResaltar;
	}

	public Boolean getMostrarnombre_ciudadCobrarClientesHonomasticos() {
		return this.mostrarnombre_ciudadCobrarClientesHonomasticos;
	}

	public void setMostrarnombre_ciudadCobrarClientesHonomasticos(Boolean mostrarnombre_ciudadCobrarClientesHonomasticos) {
		this.mostrarnombre_ciudadCobrarClientesHonomasticos= mostrarnombre_ciudadCobrarClientesHonomasticos;
	}

	public Boolean getActivarnombre_ciudadCobrarClientesHonomasticos() {
		return this.activarnombre_ciudadCobrarClientesHonomasticos;
	}

	public void setActivarnombre_ciudadCobrarClientesHonomasticos(Boolean activarnombre_ciudadCobrarClientesHonomasticos) {
		this.activarnombre_ciudadCobrarClientesHonomasticos= activarnombre_ciudadCobrarClientesHonomasticos;
	}

	public Border setResaltarnombre_rutaCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltarnombre_rutaCobrarClientesHonomasticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_rutaCobrarClientesHonomasticos() {
		return this.resaltarnombre_rutaCobrarClientesHonomasticos;
	}

	public void setResaltarnombre_rutaCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltarnombre_rutaCobrarClientesHonomasticos= borderResaltar;
	}

	public Boolean getMostrarnombre_rutaCobrarClientesHonomasticos() {
		return this.mostrarnombre_rutaCobrarClientesHonomasticos;
	}

	public void setMostrarnombre_rutaCobrarClientesHonomasticos(Boolean mostrarnombre_rutaCobrarClientesHonomasticos) {
		this.mostrarnombre_rutaCobrarClientesHonomasticos= mostrarnombre_rutaCobrarClientesHonomasticos;
	}

	public Boolean getActivarnombre_rutaCobrarClientesHonomasticos() {
		return this.activarnombre_rutaCobrarClientesHonomasticos;
	}

	public void setActivarnombre_rutaCobrarClientesHonomasticos(Boolean activarnombre_rutaCobrarClientesHonomasticos) {
		this.activarnombre_rutaCobrarClientesHonomasticos= activarnombre_rutaCobrarClientesHonomasticos;
	}

	public Border setResaltarnombre_vendedorCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltarnombre_vendedorCobrarClientesHonomasticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_vendedorCobrarClientesHonomasticos() {
		return this.resaltarnombre_vendedorCobrarClientesHonomasticos;
	}

	public void setResaltarnombre_vendedorCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltarnombre_vendedorCobrarClientesHonomasticos= borderResaltar;
	}

	public Boolean getMostrarnombre_vendedorCobrarClientesHonomasticos() {
		return this.mostrarnombre_vendedorCobrarClientesHonomasticos;
	}

	public void setMostrarnombre_vendedorCobrarClientesHonomasticos(Boolean mostrarnombre_vendedorCobrarClientesHonomasticos) {
		this.mostrarnombre_vendedorCobrarClientesHonomasticos= mostrarnombre_vendedorCobrarClientesHonomasticos;
	}

	public Boolean getActivarnombre_vendedorCobrarClientesHonomasticos() {
		return this.activarnombre_vendedorCobrarClientesHonomasticos;
	}

	public void setActivarnombre_vendedorCobrarClientesHonomasticos(Boolean activarnombre_vendedorCobrarClientesHonomasticos) {
		this.activarnombre_vendedorCobrarClientesHonomasticos= activarnombre_vendedorCobrarClientesHonomasticos;
	}

	public Border setResaltarcodigoCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltarcodigoCobrarClientesHonomasticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCobrarClientesHonomasticos() {
		return this.resaltarcodigoCobrarClientesHonomasticos;
	}

	public void setResaltarcodigoCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltarcodigoCobrarClientesHonomasticos= borderResaltar;
	}

	public Boolean getMostrarcodigoCobrarClientesHonomasticos() {
		return this.mostrarcodigoCobrarClientesHonomasticos;
	}

	public void setMostrarcodigoCobrarClientesHonomasticos(Boolean mostrarcodigoCobrarClientesHonomasticos) {
		this.mostrarcodigoCobrarClientesHonomasticos= mostrarcodigoCobrarClientesHonomasticos;
	}

	public Boolean getActivarcodigoCobrarClientesHonomasticos() {
		return this.activarcodigoCobrarClientesHonomasticos;
	}

	public void setActivarcodigoCobrarClientesHonomasticos(Boolean activarcodigoCobrarClientesHonomasticos) {
		this.activarcodigoCobrarClientesHonomasticos= activarcodigoCobrarClientesHonomasticos;
	}

	public Border setResaltarnombre_completoCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltarnombre_completoCobrarClientesHonomasticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoCobrarClientesHonomasticos() {
		return this.resaltarnombre_completoCobrarClientesHonomasticos;
	}

	public void setResaltarnombre_completoCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltarnombre_completoCobrarClientesHonomasticos= borderResaltar;
	}

	public Boolean getMostrarnombre_completoCobrarClientesHonomasticos() {
		return this.mostrarnombre_completoCobrarClientesHonomasticos;
	}

	public void setMostrarnombre_completoCobrarClientesHonomasticos(Boolean mostrarnombre_completoCobrarClientesHonomasticos) {
		this.mostrarnombre_completoCobrarClientesHonomasticos= mostrarnombre_completoCobrarClientesHonomasticos;
	}

	public Boolean getActivarnombre_completoCobrarClientesHonomasticos() {
		return this.activarnombre_completoCobrarClientesHonomasticos;
	}

	public void setActivarnombre_completoCobrarClientesHonomasticos(Boolean activarnombre_completoCobrarClientesHonomasticos) {
		this.activarnombre_completoCobrarClientesHonomasticos= activarnombre_completoCobrarClientesHonomasticos;
	}

	public Border setResaltarnombre_comercialCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltarnombre_comercialCobrarClientesHonomasticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_comercialCobrarClientesHonomasticos() {
		return this.resaltarnombre_comercialCobrarClientesHonomasticos;
	}

	public void setResaltarnombre_comercialCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltarnombre_comercialCobrarClientesHonomasticos= borderResaltar;
	}

	public Boolean getMostrarnombre_comercialCobrarClientesHonomasticos() {
		return this.mostrarnombre_comercialCobrarClientesHonomasticos;
	}

	public void setMostrarnombre_comercialCobrarClientesHonomasticos(Boolean mostrarnombre_comercialCobrarClientesHonomasticos) {
		this.mostrarnombre_comercialCobrarClientesHonomasticos= mostrarnombre_comercialCobrarClientesHonomasticos;
	}

	public Boolean getActivarnombre_comercialCobrarClientesHonomasticos() {
		return this.activarnombre_comercialCobrarClientesHonomasticos;
	}

	public void setActivarnombre_comercialCobrarClientesHonomasticos(Boolean activarnombre_comercialCobrarClientesHonomasticos) {
		this.activarnombre_comercialCobrarClientesHonomasticos= activarnombre_comercialCobrarClientesHonomasticos;
	}

	public Border setResaltarfecha_nacimiento_datoCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltarfecha_nacimiento_datoCobrarClientesHonomasticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_nacimiento_datoCobrarClientesHonomasticos() {
		return this.resaltarfecha_nacimiento_datoCobrarClientesHonomasticos;
	}

	public void setResaltarfecha_nacimiento_datoCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltarfecha_nacimiento_datoCobrarClientesHonomasticos= borderResaltar;
	}

	public Boolean getMostrarfecha_nacimiento_datoCobrarClientesHonomasticos() {
		return this.mostrarfecha_nacimiento_datoCobrarClientesHonomasticos;
	}

	public void setMostrarfecha_nacimiento_datoCobrarClientesHonomasticos(Boolean mostrarfecha_nacimiento_datoCobrarClientesHonomasticos) {
		this.mostrarfecha_nacimiento_datoCobrarClientesHonomasticos= mostrarfecha_nacimiento_datoCobrarClientesHonomasticos;
	}

	public Boolean getActivarfecha_nacimiento_datoCobrarClientesHonomasticos() {
		return this.activarfecha_nacimiento_datoCobrarClientesHonomasticos;
	}

	public void setActivarfecha_nacimiento_datoCobrarClientesHonomasticos(Boolean activarfecha_nacimiento_datoCobrarClientesHonomasticos) {
		this.activarfecha_nacimiento_datoCobrarClientesHonomasticos= activarfecha_nacimiento_datoCobrarClientesHonomasticos;
	}

	public Border setResaltardireccion_direccionCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltardireccion_direccionCobrarClientesHonomasticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_direccionCobrarClientesHonomasticos() {
		return this.resaltardireccion_direccionCobrarClientesHonomasticos;
	}

	public void setResaltardireccion_direccionCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltardireccion_direccionCobrarClientesHonomasticos= borderResaltar;
	}

	public Boolean getMostrardireccion_direccionCobrarClientesHonomasticos() {
		return this.mostrardireccion_direccionCobrarClientesHonomasticos;
	}

	public void setMostrardireccion_direccionCobrarClientesHonomasticos(Boolean mostrardireccion_direccionCobrarClientesHonomasticos) {
		this.mostrardireccion_direccionCobrarClientesHonomasticos= mostrardireccion_direccionCobrarClientesHonomasticos;
	}

	public Boolean getActivardireccion_direccionCobrarClientesHonomasticos() {
		return this.activardireccion_direccionCobrarClientesHonomasticos;
	}

	public void setActivardireccion_direccionCobrarClientesHonomasticos(Boolean activardireccion_direccionCobrarClientesHonomasticos) {
		this.activardireccion_direccionCobrarClientesHonomasticos= activardireccion_direccionCobrarClientesHonomasticos;
	}

	public Border setResaltartelefono_telefonoCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclienteshonomasticosBeanSwingJInternalFrame.jTtoolBarCobrarClientesHonomasticos.setBorder(borderResaltar);
		
		this.resaltartelefono_telefonoCobrarClientesHonomasticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_telefonoCobrarClientesHonomasticos() {
		return this.resaltartelefono_telefonoCobrarClientesHonomasticos;
	}

	public void setResaltartelefono_telefonoCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltartelefono_telefonoCobrarClientesHonomasticos= borderResaltar;
	}

	public Boolean getMostrartelefono_telefonoCobrarClientesHonomasticos() {
		return this.mostrartelefono_telefonoCobrarClientesHonomasticos;
	}

	public void setMostrartelefono_telefonoCobrarClientesHonomasticos(Boolean mostrartelefono_telefonoCobrarClientesHonomasticos) {
		this.mostrartelefono_telefonoCobrarClientesHonomasticos= mostrartelefono_telefonoCobrarClientesHonomasticos;
	}

	public Boolean getActivartelefono_telefonoCobrarClientesHonomasticos() {
		return this.activartelefono_telefonoCobrarClientesHonomasticos;
	}

	public void setActivartelefono_telefonoCobrarClientesHonomasticos(Boolean activartelefono_telefonoCobrarClientesHonomasticos) {
		this.activartelefono_telefonoCobrarClientesHonomasticos= activartelefono_telefonoCobrarClientesHonomasticos;
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
		
		
		this.setMostraridCobrarClientesHonomasticos(esInicial);
		this.setMostrarid_empresaCobrarClientesHonomasticos(esInicial);
		this.setMostrarid_sucursalCobrarClientesHonomasticos(esInicial);
		this.setMostrarid_paisCobrarClientesHonomasticos(esInicial);
		this.setMostrarid_regionCobrarClientesHonomasticos(esInicial);
		this.setMostrarid_provinciaCobrarClientesHonomasticos(esInicial);
		this.setMostrarid_ciudadCobrarClientesHonomasticos(esInicial);
		this.setMostrarfecha_nacimientoCobrarClientesHonomasticos(esInicial);
		this.setMostrarnombre_ciudadCobrarClientesHonomasticos(esInicial);
		this.setMostrarnombre_rutaCobrarClientesHonomasticos(esInicial);
		this.setMostrarnombre_vendedorCobrarClientesHonomasticos(esInicial);
		this.setMostrarcodigoCobrarClientesHonomasticos(esInicial);
		this.setMostrarnombre_completoCobrarClientesHonomasticos(esInicial);
		this.setMostrarnombre_comercialCobrarClientesHonomasticos(esInicial);
		this.setMostrarfecha_nacimiento_datoCobrarClientesHonomasticos(esInicial);
		this.setMostrardireccion_direccionCobrarClientesHonomasticos(esInicial);
		this.setMostrartelefono_telefonoCobrarClientesHonomasticos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.ID)) {
				this.setMostraridCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDREGION)) {
				this.setMostrarid_regionCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDPROVINCIA)) {
				this.setMostrarid_provinciaCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.FECHANACIMIENTO)) {
				this.setMostrarfecha_nacimientoCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBRECIUDAD)) {
				this.setMostrarnombre_ciudadCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBRERUTA)) {
				this.setMostrarnombre_rutaCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBREVENDEDOR)) {
				this.setMostrarnombre_vendedorCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMERCIAL)) {
				this.setMostrarnombre_comercialCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.FECHANACIMIENTODATO)) {
				this.setMostrarfecha_nacimiento_datoCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setMostrardireccion_direccionCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.TELEFONOTELEFONO)) {
				this.setMostrartelefono_telefonoCobrarClientesHonomasticos(esAsigna);
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
		
		
		this.setActivaridCobrarClientesHonomasticos(esInicial);
		this.setActivarid_empresaCobrarClientesHonomasticos(esInicial);
		this.setActivarid_sucursalCobrarClientesHonomasticos(esInicial);
		this.setActivarid_paisCobrarClientesHonomasticos(esInicial);
		this.setActivarid_regionCobrarClientesHonomasticos(esInicial);
		this.setActivarid_provinciaCobrarClientesHonomasticos(esInicial);
		this.setActivarid_ciudadCobrarClientesHonomasticos(esInicial);
		this.setActivarfecha_nacimientoCobrarClientesHonomasticos(esInicial);
		this.setActivarnombre_ciudadCobrarClientesHonomasticos(esInicial);
		this.setActivarnombre_rutaCobrarClientesHonomasticos(esInicial);
		this.setActivarnombre_vendedorCobrarClientesHonomasticos(esInicial);
		this.setActivarcodigoCobrarClientesHonomasticos(esInicial);
		this.setActivarnombre_completoCobrarClientesHonomasticos(esInicial);
		this.setActivarnombre_comercialCobrarClientesHonomasticos(esInicial);
		this.setActivarfecha_nacimiento_datoCobrarClientesHonomasticos(esInicial);
		this.setActivardireccion_direccionCobrarClientesHonomasticos(esInicial);
		this.setActivartelefono_telefonoCobrarClientesHonomasticos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.ID)) {
				this.setActivaridCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDREGION)) {
				this.setActivarid_regionCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDPROVINCIA)) {
				this.setActivarid_provinciaCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.FECHANACIMIENTO)) {
				this.setActivarfecha_nacimientoCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBRECIUDAD)) {
				this.setActivarnombre_ciudadCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBRERUTA)) {
				this.setActivarnombre_rutaCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBREVENDEDOR)) {
				this.setActivarnombre_vendedorCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMERCIAL)) {
				this.setActivarnombre_comercialCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.FECHANACIMIENTODATO)) {
				this.setActivarfecha_nacimiento_datoCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setActivardireccion_direccionCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.TELEFONOTELEFONO)) {
				this.setActivartelefono_telefonoCobrarClientesHonomasticos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCobrarClientesHonomasticos(esInicial);
		this.setResaltarid_empresaCobrarClientesHonomasticos(esInicial);
		this.setResaltarid_sucursalCobrarClientesHonomasticos(esInicial);
		this.setResaltarid_paisCobrarClientesHonomasticos(esInicial);
		this.setResaltarid_regionCobrarClientesHonomasticos(esInicial);
		this.setResaltarid_provinciaCobrarClientesHonomasticos(esInicial);
		this.setResaltarid_ciudadCobrarClientesHonomasticos(esInicial);
		this.setResaltarfecha_nacimientoCobrarClientesHonomasticos(esInicial);
		this.setResaltarnombre_ciudadCobrarClientesHonomasticos(esInicial);
		this.setResaltarnombre_rutaCobrarClientesHonomasticos(esInicial);
		this.setResaltarnombre_vendedorCobrarClientesHonomasticos(esInicial);
		this.setResaltarcodigoCobrarClientesHonomasticos(esInicial);
		this.setResaltarnombre_completoCobrarClientesHonomasticos(esInicial);
		this.setResaltarnombre_comercialCobrarClientesHonomasticos(esInicial);
		this.setResaltarfecha_nacimiento_datoCobrarClientesHonomasticos(esInicial);
		this.setResaltardireccion_direccionCobrarClientesHonomasticos(esInicial);
		this.setResaltartelefono_telefonoCobrarClientesHonomasticos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.ID)) {
				this.setResaltaridCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDREGION)) {
				this.setResaltarid_regionCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDPROVINCIA)) {
				this.setResaltarid_provinciaCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.FECHANACIMIENTO)) {
				this.setResaltarfecha_nacimientoCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBRECIUDAD)) {
				this.setResaltarnombre_ciudadCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBRERUTA)) {
				this.setResaltarnombre_rutaCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBREVENDEDOR)) {
				this.setResaltarnombre_vendedorCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.NOMBRECOMERCIAL)) {
				this.setResaltarnombre_comercialCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.FECHANACIMIENTODATO)) {
				this.setResaltarfecha_nacimiento_datoCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setResaltardireccion_direccionCobrarClientesHonomasticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesHonomasticosConstantesFunciones.TELEFONOTELEFONO)) {
				this.setResaltartelefono_telefonoCobrarClientesHonomasticos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaCobrarClientesHonomasticosCobrarClientesHonomasticos=true;

	public Boolean getMostrarBusquedaCobrarClientesHonomasticosCobrarClientesHonomasticos() {
		return this.mostrarBusquedaCobrarClientesHonomasticosCobrarClientesHonomasticos;
	}

	public void setMostrarBusquedaCobrarClientesHonomasticosCobrarClientesHonomasticos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCobrarClientesHonomasticosCobrarClientesHonomasticos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCobrarClientesHonomasticosCobrarClientesHonomasticos=true;

	public Boolean getActivarBusquedaCobrarClientesHonomasticosCobrarClientesHonomasticos() {
		return this.activarBusquedaCobrarClientesHonomasticosCobrarClientesHonomasticos;
	}

	public void setActivarBusquedaCobrarClientesHonomasticosCobrarClientesHonomasticos(Boolean habilitarResaltar) {
		this.activarBusquedaCobrarClientesHonomasticosCobrarClientesHonomasticos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCobrarClientesHonomasticosCobrarClientesHonomasticos=null;

	public Border getResaltarBusquedaCobrarClientesHonomasticosCobrarClientesHonomasticos() {
		return this.resaltarBusquedaCobrarClientesHonomasticosCobrarClientesHonomasticos;
	}

	public void setResaltarBusquedaCobrarClientesHonomasticosCobrarClientesHonomasticos(Border borderResaltar) {
		this.resaltarBusquedaCobrarClientesHonomasticosCobrarClientesHonomasticos= borderResaltar;
	}

	public void setResaltarBusquedaCobrarClientesHonomasticosCobrarClientesHonomasticos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesHonomasticosBeanSwingJInternalFrame cobrarclienteshonomasticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCobrarClientesHonomasticosCobrarClientesHonomasticos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}