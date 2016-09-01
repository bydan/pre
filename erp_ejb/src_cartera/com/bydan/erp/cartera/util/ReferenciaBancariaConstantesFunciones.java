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


import com.bydan.erp.cartera.util.ReferenciaBancariaConstantesFunciones;
import com.bydan.erp.cartera.util.ReferenciaBancariaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ReferenciaBancariaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ReferenciaBancariaConstantesFunciones extends ReferenciaBancariaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ReferenciaBancaria";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ReferenciaBancaria"+ReferenciaBancariaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ReferenciaBancariaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ReferenciaBancariaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ReferenciaBancariaConstantesFunciones.SCHEMA+"_"+ReferenciaBancariaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ReferenciaBancariaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ReferenciaBancariaConstantesFunciones.SCHEMA+"_"+ReferenciaBancariaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ReferenciaBancariaConstantesFunciones.SCHEMA+"_"+ReferenciaBancariaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ReferenciaBancariaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ReferenciaBancariaConstantesFunciones.SCHEMA+"_"+ReferenciaBancariaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReferenciaBancariaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ReferenciaBancariaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReferenciaBancariaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReferenciaBancariaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ReferenciaBancariaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReferenciaBancariaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ReferenciaBancariaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ReferenciaBancariaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ReferenciaBancariaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ReferenciaBancariaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Referencia Bancarias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Referencia Bancaria";
	public static final String SCLASSWEBTITULO_LOWER="Referencia Bancaria";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ReferenciaBancaria";
	public static final String OBJECTNAME="referenciabancaria";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="referenciabancaria";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select referenciabancaria from "+ReferenciaBancariaConstantesFunciones.SPERSISTENCENAME+" referenciabancaria";
	public static String QUERYSELECTNATIVE="select "+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".id,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".version_row,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".id_empresa,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".idcliente,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".idvalorclientebanco,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".idvalorclienteproductobanco,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".idvalorclientecuentabanco,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".numero_cuenta_tarjeta,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".fecha_emision,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".fecha_vencimiento,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".cupo,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".tiene_credito,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".numero_creditos,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".tiene_protestos,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".numero_protestos,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".saldos_promedios,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".propietario_cuenta,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".id_tipo_valoracion,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".esactivo from "+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME;//+" as "+ReferenciaBancariaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ReferenciaBancariaConstantesFuncionesAdditional referenciabancariaConstantesFuncionesAdditional=null;
	
	public ReferenciaBancariaConstantesFuncionesAdditional getReferenciaBancariaConstantesFuncionesAdditional() {
		return this.referenciabancariaConstantesFuncionesAdditional;
	}
	
	public void setReferenciaBancariaConstantesFuncionesAdditional(ReferenciaBancariaConstantesFuncionesAdditional referenciabancariaConstantesFuncionesAdditional) {
		try {
			this.referenciabancariaConstantesFuncionesAdditional=referenciabancariaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "idcliente";
    public static final String IDBANCO= "idvalorclientebanco";
    public static final String IDTIPOPRODUBANCO= "idvalorclienteproductobanco";
    public static final String IDTIPOCUENTABANCO= "idvalorclientecuentabanco";
    public static final String NUMEROCUENTATARJETA= "numero_cuenta_tarjeta";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String CUPO= "cupo";
    public static final String TIENECREDITO= "tiene_credito";
    public static final String NUMEROCREDITOS= "numero_creditos";
    public static final String TIENEPROTESTOS= "tiene_protestos";
    public static final String NUMEROPROTESTOS= "numero_protestos";
    public static final String SALDOSPROMEDIOS= "saldos_promedios";
    public static final String PROPIETARIOCUENTA= "propietario_cuenta";
    public static final String IDTIPOVALORACION= "id_tipo_valoracion";
    public static final String ESACTIVO= "esactivo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Idempresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDBANCO= "Banco";
		public static final String LABEL_IDBANCO_LOWER= "Banco";
    	public static final String LABEL_IDTIPOPRODUBANCO= "Tipo Produ Banco";
		public static final String LABEL_IDTIPOPRODUBANCO_LOWER= "Tipo Produ Banco";
    	public static final String LABEL_IDTIPOCUENTABANCO= "Tipo Cuenta Banco";
		public static final String LABEL_IDTIPOCUENTABANCO_LOWER= "Tipo Cuenta Banco";
    	public static final String LABEL_NUMEROCUENTATARJETA= "Numero Cuenta/tarjeta";
		public static final String LABEL_NUMEROCUENTATARJETA_LOWER= "Numero Cuenta Tarjeta";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_CUPO= "Cupo";
		public static final String LABEL_CUPO_LOWER= "Cupo";
    	public static final String LABEL_TIENECREDITO= "Tiene Credito";
		public static final String LABEL_TIENECREDITO_LOWER= "Tiene Credito";
    	public static final String LABEL_NUMEROCREDITOS= "Numero Creditos";
		public static final String LABEL_NUMEROCREDITOS_LOWER= "Numero Creditos";
    	public static final String LABEL_TIENEPROTESTOS= "Tiene Protestos";
		public static final String LABEL_TIENEPROTESTOS_LOWER= "Tiene Protestos";
    	public static final String LABEL_NUMEROPROTESTOS= "Numero Protestos";
		public static final String LABEL_NUMEROPROTESTOS_LOWER= "Numero Protestos";
    	public static final String LABEL_SALDOSPROMEDIOS= "Saldos Promedios";
		public static final String LABEL_SALDOSPROMEDIOS_LOWER= "Saldos Promedios";
    	public static final String LABEL_PROPIETARIOCUENTA= "Propietario Cuenta";
		public static final String LABEL_PROPIETARIOCUENTA_LOWER= "Propietario Cuenta";
    	public static final String LABEL_IDTIPOVALORACION= "Tipo Valoracion";
		public static final String LABEL_IDTIPOVALORACION_LOWER= "Tipo Valoracion";
    	public static final String LABEL_ESACTIVO= "Es Activo";
		public static final String LABEL_ESACTIVO_LOWER= "Es Activo";
	
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_CUENTA_TARJETA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CUENTA_TARJETA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXSALDOS_PROMEDIOS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSALDOS_PROMEDIOS=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPROPIETARIO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPROPIETARIO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getReferenciaBancariaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ReferenciaBancariaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ReferenciaBancariaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ReferenciaBancariaConstantesFunciones.IDCLIENTE)) {sLabelColumna=ReferenciaBancariaConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ReferenciaBancariaConstantesFunciones.IDBANCO)) {sLabelColumna=ReferenciaBancariaConstantesFunciones.LABEL_IDBANCO;}
		if(sNombreColumna.equals(ReferenciaBancariaConstantesFunciones.IDTIPOPRODUBANCO)) {sLabelColumna=ReferenciaBancariaConstantesFunciones.LABEL_IDTIPOPRODUBANCO;}
		if(sNombreColumna.equals(ReferenciaBancariaConstantesFunciones.IDTIPOCUENTABANCO)) {sLabelColumna=ReferenciaBancariaConstantesFunciones.LABEL_IDTIPOCUENTABANCO;}
		if(sNombreColumna.equals(ReferenciaBancariaConstantesFunciones.NUMEROCUENTATARJETA)) {sLabelColumna=ReferenciaBancariaConstantesFunciones.LABEL_NUMEROCUENTATARJETA;}
		if(sNombreColumna.equals(ReferenciaBancariaConstantesFunciones.FECHAEMISION)) {sLabelColumna=ReferenciaBancariaConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(ReferenciaBancariaConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=ReferenciaBancariaConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(ReferenciaBancariaConstantesFunciones.CUPO)) {sLabelColumna=ReferenciaBancariaConstantesFunciones.LABEL_CUPO;}
		if(sNombreColumna.equals(ReferenciaBancariaConstantesFunciones.TIENECREDITO)) {sLabelColumna=ReferenciaBancariaConstantesFunciones.LABEL_TIENECREDITO;}
		if(sNombreColumna.equals(ReferenciaBancariaConstantesFunciones.NUMEROCREDITOS)) {sLabelColumna=ReferenciaBancariaConstantesFunciones.LABEL_NUMEROCREDITOS;}
		if(sNombreColumna.equals(ReferenciaBancariaConstantesFunciones.TIENEPROTESTOS)) {sLabelColumna=ReferenciaBancariaConstantesFunciones.LABEL_TIENEPROTESTOS;}
		if(sNombreColumna.equals(ReferenciaBancariaConstantesFunciones.NUMEROPROTESTOS)) {sLabelColumna=ReferenciaBancariaConstantesFunciones.LABEL_NUMEROPROTESTOS;}
		if(sNombreColumna.equals(ReferenciaBancariaConstantesFunciones.SALDOSPROMEDIOS)) {sLabelColumna=ReferenciaBancariaConstantesFunciones.LABEL_SALDOSPROMEDIOS;}
		if(sNombreColumna.equals(ReferenciaBancariaConstantesFunciones.PROPIETARIOCUENTA)) {sLabelColumna=ReferenciaBancariaConstantesFunciones.LABEL_PROPIETARIOCUENTA;}
		if(sNombreColumna.equals(ReferenciaBancariaConstantesFunciones.IDTIPOVALORACION)) {sLabelColumna=ReferenciaBancariaConstantesFunciones.LABEL_IDTIPOVALORACION;}
		if(sNombreColumna.equals(ReferenciaBancariaConstantesFunciones.ESACTIVO)) {sLabelColumna=ReferenciaBancariaConstantesFunciones.LABEL_ESACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
		
	public static String gettiene_creditoDescripcion(ReferenciaBancaria referenciabancaria) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!referenciabancaria.gettiene_credito()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String gettiene_creditoHtmlDescripcion(ReferenciaBancaria referenciabancaria) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(referenciabancaria.getId(),referenciabancaria.gettiene_credito());

		return sDescripcion;
	}	
			
		
	public static String gettiene_protestosDescripcion(ReferenciaBancaria referenciabancaria) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!referenciabancaria.gettiene_protestos()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String gettiene_protestosHtmlDescripcion(ReferenciaBancaria referenciabancaria) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(referenciabancaria.getId(),referenciabancaria.gettiene_protestos());

		return sDescripcion;
	}	
			
			
			
			
		
	public static String getesactivoDescripcion(ReferenciaBancaria referenciabancaria) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!referenciabancaria.getesactivo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesactivoHtmlDescripcion(ReferenciaBancaria referenciabancaria) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(referenciabancaria.getId(),referenciabancaria.getesactivo());

		return sDescripcion;
	}	
	
	public static String getReferenciaBancariaDescripcion(ReferenciaBancaria referenciabancaria) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(referenciabancaria !=null/* && referenciabancaria.getId()!=0*/) {
			if(referenciabancaria.getId()!=null) {
				sDescripcion=referenciabancaria.getId().toString();
			}//referenciabancariareferenciabancaria.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getReferenciaBancariaDescripcionDetallado(ReferenciaBancaria referenciabancaria) {
		String sDescripcion="";
			
		sDescripcion+=ReferenciaBancariaConstantesFunciones.ID+"=";
		sDescripcion+=referenciabancaria.getId().toString()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=referenciabancaria.getVersionRow().toString()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=referenciabancaria.getid_empresa().toString()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=referenciabancaria.getidcliente().toString()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.IDBANCO+"=";
		sDescripcion+=referenciabancaria.getidvalorclientebanco().toString()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.IDTIPOPRODUBANCO+"=";
		sDescripcion+=referenciabancaria.getidvalorclienteproductobanco().toString()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.IDTIPOCUENTABANCO+"=";
		sDescripcion+=referenciabancaria.getidvalorclientecuentabanco().toString()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.NUMEROCUENTATARJETA+"=";
		sDescripcion+=referenciabancaria.getnumero_cuenta_tarjeta()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=referenciabancaria.getfecha_emision().toString()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=referenciabancaria.getfecha_vencimiento().toString()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.CUPO+"=";
		sDescripcion+=referenciabancaria.getcupo().toString()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.TIENECREDITO+"=";
		sDescripcion+=referenciabancaria.gettiene_credito().toString()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.NUMEROCREDITOS+"=";
		sDescripcion+=referenciabancaria.getnumero_creditos().toString()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.TIENEPROTESTOS+"=";
		sDescripcion+=referenciabancaria.gettiene_protestos().toString()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.NUMEROPROTESTOS+"=";
		sDescripcion+=referenciabancaria.getnumero_protestos().toString()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.SALDOSPROMEDIOS+"=";
		sDescripcion+=referenciabancaria.getsaldos_promedios()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.PROPIETARIOCUENTA+"=";
		sDescripcion+=referenciabancaria.getpropietario_cuenta()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.IDTIPOVALORACION+"=";
		sDescripcion+=referenciabancaria.getid_tipo_valoracion().toString()+",";
		sDescripcion+=ReferenciaBancariaConstantesFunciones.ESACTIVO+"=";
		sDescripcion+=referenciabancaria.getesactivo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setReferenciaBancariaDescripcion(ReferenciaBancaria referenciabancaria,String sValor) throws Exception {			
		if(referenciabancaria !=null) {
			//referenciabancariareferenciabancaria.getId().toString();
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

	public static String getBancoDescripcion(Banco banco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(banco!=null/*&&banco.getId()>0*/) {
			sDescripcion=BancoConstantesFunciones.getBancoDescripcion(banco);
		}

		return sDescripcion;
	}

	public static String getTipoProduBancoDescripcion(TipoProduBanco tipoprodubanco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprodubanco!=null/*&&tipoprodubanco.getId()>0*/) {
			sDescripcion=TipoProduBancoConstantesFunciones.getTipoProduBancoDescripcion(tipoprodubanco);
		}

		return sDescripcion;
	}

	public static String getTipoCuentaBancoDescripcion(TipoCuentaBanco tipocuentabanco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocuentabanco!=null/*&&tipocuentabanco.getId()>0*/) {
			sDescripcion=TipoCuentaBancoConstantesFunciones.getTipoCuentaBancoDescripcion(tipocuentabanco);
		}

		return sDescripcion;
	}

	public static String getTipoValoracionDescripcion(TipoValoracion tipovaloracion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipovaloracion!=null/*&&tipovaloracion.getId()>0*/) {
			sDescripcion=TipoValoracionConstantesFunciones.getTipoValoracionDescripcion(tipovaloracion);
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
			sNombreIndice="Tipo=  Por Idempresa";
		} else if(sNombreIndice.equals("FK_IdTipoBanco")) {
			sNombreIndice="Tipo=  Por Banco";
		} else if(sNombreIndice.equals("FK_IdTipoCuentaBanco")) {
			sNombreIndice="Tipo=  Por Tipo Cuenta Banco";
		} else if(sNombreIndice.equals("FK_IdTipoProductoBanco")) {
			sNombreIndice="Tipo=  Por Tipo Produ Banco";
		} else if(sNombreIndice.equals("FK_IdTipoValoracion")) {
			sNombreIndice="Tipo=  Por Tipo Valoracion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long idcliente) {
		String sDetalleIndice=" Parametros->";
		if(idcliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+idcliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Idempresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoBanco(Long idvalorclientebanco) {
		String sDetalleIndice=" Parametros->";
		if(idvalorclientebanco!=null) {sDetalleIndice+=" Codigo Unico De Banco="+idvalorclientebanco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCuentaBanco(Long idvalorclientecuentabanco) {
		String sDetalleIndice=" Parametros->";
		if(idvalorclientecuentabanco!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cuenta Banco="+idvalorclientecuentabanco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoProductoBanco(Long idvalorclienteproductobanco) {
		String sDetalleIndice=" Parametros->";
		if(idvalorclienteproductobanco!=null) {sDetalleIndice+=" Codigo Unico De Tipo Produ Banco="+idvalorclienteproductobanco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoValoracion(Long id_tipo_valoracion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_valoracion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Valoracion="+id_tipo_valoracion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosReferenciaBancaria(ReferenciaBancaria referenciabancaria,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		referenciabancaria.setnumero_cuenta_tarjeta(referenciabancaria.getnumero_cuenta_tarjeta().trim());
		referenciabancaria.setsaldos_promedios(referenciabancaria.getsaldos_promedios().trim());
		referenciabancaria.setpropietario_cuenta(referenciabancaria.getpropietario_cuenta().trim());
	}
	
	public static void quitarEspaciosReferenciaBancarias(List<ReferenciaBancaria> referenciabancarias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ReferenciaBancaria referenciabancaria: referenciabancarias) {
			referenciabancaria.setnumero_cuenta_tarjeta(referenciabancaria.getnumero_cuenta_tarjeta().trim());
			referenciabancaria.setsaldos_promedios(referenciabancaria.getsaldos_promedios().trim());
			referenciabancaria.setpropietario_cuenta(referenciabancaria.getpropietario_cuenta().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresReferenciaBancaria(ReferenciaBancaria referenciabancaria,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && referenciabancaria.getConCambioAuxiliar()) {
			referenciabancaria.setIsDeleted(referenciabancaria.getIsDeletedAuxiliar());	
			referenciabancaria.setIsNew(referenciabancaria.getIsNewAuxiliar());	
			referenciabancaria.setIsChanged(referenciabancaria.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			referenciabancaria.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			referenciabancaria.setIsDeletedAuxiliar(false);	
			referenciabancaria.setIsNewAuxiliar(false);	
			referenciabancaria.setIsChangedAuxiliar(false);
			
			referenciabancaria.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresReferenciaBancarias(List<ReferenciaBancaria> referenciabancarias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ReferenciaBancaria referenciabancaria : referenciabancarias) {
			if(conAsignarBase && referenciabancaria.getConCambioAuxiliar()) {
				referenciabancaria.setIsDeleted(referenciabancaria.getIsDeletedAuxiliar());	
				referenciabancaria.setIsNew(referenciabancaria.getIsNewAuxiliar());	
				referenciabancaria.setIsChanged(referenciabancaria.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				referenciabancaria.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				referenciabancaria.setIsDeletedAuxiliar(false);	
				referenciabancaria.setIsNewAuxiliar(false);	
				referenciabancaria.setIsChangedAuxiliar(false);
				
				referenciabancaria.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresReferenciaBancaria(ReferenciaBancaria referenciabancaria,Boolean conEnteros) throws Exception  {
		referenciabancaria.setcupo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			referenciabancaria.setnumero_creditos(0);
			referenciabancaria.setnumero_protestos(0);
		}
	}		
	
	public static void InicializarValoresReferenciaBancarias(List<ReferenciaBancaria> referenciabancarias,Boolean conEnteros) throws Exception  {
		
		for(ReferenciaBancaria referenciabancaria: referenciabancarias) {
			referenciabancaria.setcupo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				referenciabancaria.setnumero_creditos(0);
				referenciabancaria.setnumero_protestos(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaReferenciaBancaria(List<ReferenciaBancaria> referenciabancarias,ReferenciaBancaria referenciabancariaAux) throws Exception  {
		ReferenciaBancariaConstantesFunciones.InicializarValoresReferenciaBancaria(referenciabancariaAux,true);
		
		for(ReferenciaBancaria referenciabancaria: referenciabancarias) {
			if(referenciabancaria.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			referenciabancariaAux.setcupo(referenciabancariaAux.getcupo()+referenciabancaria.getcupo());			
			referenciabancariaAux.setnumero_creditos(referenciabancariaAux.getnumero_creditos()+referenciabancaria.getnumero_creditos());			
			referenciabancariaAux.setnumero_protestos(referenciabancariaAux.getnumero_protestos()+referenciabancaria.getnumero_protestos());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesReferenciaBancaria(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ReferenciaBancariaConstantesFunciones.getArrayColumnasGlobalesReferenciaBancaria(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesReferenciaBancaria(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ReferenciaBancariaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ReferenciaBancariaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoReferenciaBancaria(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ReferenciaBancaria> referenciabancarias,ReferenciaBancaria referenciabancaria,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ReferenciaBancaria referenciabancariaAux: referenciabancarias) {
			if(referenciabancariaAux!=null && referenciabancaria!=null) {
				if((referenciabancariaAux.getId()==null && referenciabancaria.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(referenciabancariaAux.getId()!=null && referenciabancaria.getId()!=null){
					if(referenciabancariaAux.getId().equals(referenciabancaria.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaReferenciaBancaria(List<ReferenciaBancaria> referenciabancarias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cupoTotal=0.0;
	
		for(ReferenciaBancaria referenciabancaria: referenciabancarias) {			
			if(referenciabancaria.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cupoTotal+=referenciabancaria.getcupo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ReferenciaBancariaConstantesFunciones.CUPO);
		datoGeneral.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_CUPO);
		datoGeneral.setdValorDouble(cupoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaReferenciaBancaria() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_ID, ReferenciaBancariaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_VERSIONROW, ReferenciaBancariaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_IDEMPRESA, ReferenciaBancariaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_IDCLIENTE, ReferenciaBancariaConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_IDBANCO, ReferenciaBancariaConstantesFunciones.IDBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_IDTIPOPRODUBANCO, ReferenciaBancariaConstantesFunciones.IDTIPOPRODUBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_IDTIPOCUENTABANCO, ReferenciaBancariaConstantesFunciones.IDTIPOCUENTABANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_NUMEROCUENTATARJETA, ReferenciaBancariaConstantesFunciones.NUMEROCUENTATARJETA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_FECHAEMISION, ReferenciaBancariaConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_FECHAVENCIMIENTO, ReferenciaBancariaConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_CUPO, ReferenciaBancariaConstantesFunciones.CUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_TIENECREDITO, ReferenciaBancariaConstantesFunciones.TIENECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_NUMEROCREDITOS, ReferenciaBancariaConstantesFunciones.NUMEROCREDITOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_TIENEPROTESTOS, ReferenciaBancariaConstantesFunciones.TIENEPROTESTOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_NUMEROPROTESTOS, ReferenciaBancariaConstantesFunciones.NUMEROPROTESTOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_SALDOSPROMEDIOS, ReferenciaBancariaConstantesFunciones.SALDOSPROMEDIOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_PROPIETARIOCUENTA, ReferenciaBancariaConstantesFunciones.PROPIETARIOCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_IDTIPOVALORACION, ReferenciaBancariaConstantesFunciones.IDTIPOVALORACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaBancariaConstantesFunciones.LABEL_ESACTIVO, ReferenciaBancariaConstantesFunciones.ESACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasReferenciaBancaria() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.IDBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.IDTIPOPRODUBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.IDTIPOCUENTABANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.NUMEROCUENTATARJETA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.CUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.TIENECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.NUMEROCREDITOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.TIENEPROTESTOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.NUMEROPROTESTOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.SALDOSPROMEDIOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.PROPIETARIOCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.IDTIPOVALORACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaBancariaConstantesFunciones.ESACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReferenciaBancaria() throws Exception  {
		return ReferenciaBancariaConstantesFunciones.getTiposSeleccionarReferenciaBancaria(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReferenciaBancaria(Boolean conFk) throws Exception  {
		return ReferenciaBancariaConstantesFunciones.getTiposSeleccionarReferenciaBancaria(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReferenciaBancaria(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaBancariaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaBancariaConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaBancariaConstantesFunciones.LABEL_IDBANCO);
			reporte.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_IDBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaBancariaConstantesFunciones.LABEL_IDTIPOPRODUBANCO);
			reporte.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_IDTIPOPRODUBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaBancariaConstantesFunciones.LABEL_IDTIPOCUENTABANCO);
			reporte.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_IDTIPOCUENTABANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaBancariaConstantesFunciones.LABEL_NUMEROCUENTATARJETA);
			reporte.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_NUMEROCUENTATARJETA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaBancariaConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaBancariaConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaBancariaConstantesFunciones.LABEL_CUPO);
			reporte.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_CUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaBancariaConstantesFunciones.LABEL_TIENECREDITO);
			reporte.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_TIENECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaBancariaConstantesFunciones.LABEL_NUMEROCREDITOS);
			reporte.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_NUMEROCREDITOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaBancariaConstantesFunciones.LABEL_TIENEPROTESTOS);
			reporte.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_TIENEPROTESTOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaBancariaConstantesFunciones.LABEL_NUMEROPROTESTOS);
			reporte.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_NUMEROPROTESTOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaBancariaConstantesFunciones.LABEL_SALDOSPROMEDIOS);
			reporte.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_SALDOSPROMEDIOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaBancariaConstantesFunciones.LABEL_PROPIETARIOCUENTA);
			reporte.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_PROPIETARIOCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaBancariaConstantesFunciones.LABEL_IDTIPOVALORACION);
			reporte.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_IDTIPOVALORACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaBancariaConstantesFunciones.LABEL_ESACTIVO);
			reporte.setsDescripcion(ReferenciaBancariaConstantesFunciones.LABEL_ESACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesReferenciaBancaria(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesReferenciaBancaria(ReferenciaBancaria referenciabancariaAux) throws Exception {
		
			referenciabancariaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(referenciabancariaAux.getEmpresa()));
			referenciabancariaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(referenciabancariaAux.getCliente()));
			referenciabancariaAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(referenciabancariaAux.getBanco()));
			referenciabancariaAux.settipoprodubanco_descripcion(TipoProduBancoConstantesFunciones.getTipoProduBancoDescripcion(referenciabancariaAux.getTipoProduBanco()));
			referenciabancariaAux.settipocuentabanco_descripcion(TipoCuentaBancoConstantesFunciones.getTipoCuentaBancoDescripcion(referenciabancariaAux.getTipoCuentaBanco()));
			referenciabancariaAux.settipovaloracion_descripcion(TipoValoracionConstantesFunciones.getTipoValoracionDescripcion(referenciabancariaAux.getTipoValoracion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesReferenciaBancaria(List<ReferenciaBancaria> referenciabancariasTemp) throws Exception {
		for(ReferenciaBancaria referenciabancariaAux:referenciabancariasTemp) {
			
			referenciabancariaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(referenciabancariaAux.getEmpresa()));
			referenciabancariaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(referenciabancariaAux.getCliente()));
			referenciabancariaAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(referenciabancariaAux.getBanco()));
			referenciabancariaAux.settipoprodubanco_descripcion(TipoProduBancoConstantesFunciones.getTipoProduBancoDescripcion(referenciabancariaAux.getTipoProduBanco()));
			referenciabancariaAux.settipocuentabanco_descripcion(TipoCuentaBancoConstantesFunciones.getTipoCuentaBancoDescripcion(referenciabancariaAux.getTipoCuentaBanco()));
			referenciabancariaAux.settipovaloracion_descripcion(TipoValoracionConstantesFunciones.getTipoValoracionDescripcion(referenciabancariaAux.getTipoValoracion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfReferenciaBancaria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Banco.class));
				classes.add(new Classe(TipoProduBanco.class));
				classes.add(new Classe(TipoCuentaBanco.class));
				classes.add(new Classe(TipoValoracion.class));
				
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
					if(clas.clas.equals(Banco.class)) {
						classes.add(new Classe(Banco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProduBanco.class)) {
						classes.add(new Classe(TipoProduBanco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCuentaBanco.class)) {
						classes.add(new Classe(TipoCuentaBanco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoValoracion.class)) {
						classes.add(new Classe(TipoValoracion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfReferenciaBancaria(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(TipoProduBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProduBanco.class)); continue;
					}

					if(TipoCuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBanco.class)); continue;
					}

					if(TipoValoracion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoValoracion.class)); continue;
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

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(TipoProduBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProduBanco.class)); continue;
					}

					if(TipoCuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBanco.class)); continue;
					}

					if(TipoValoracion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoValoracion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfReferenciaBancaria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ReferenciaBancariaConstantesFunciones.getClassesRelationshipsOfReferenciaBancaria(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfReferenciaBancaria(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfReferenciaBancaria(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ReferenciaBancariaConstantesFunciones.getClassesRelationshipsFromStringsOfReferenciaBancaria(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfReferenciaBancaria(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ReferenciaBancaria referenciabancaria,List<ReferenciaBancaria> referenciabancarias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ReferenciaBancaria referenciabancariaEncontrado=null;
			
			for(ReferenciaBancaria referenciabancariaLocal:referenciabancarias) {
				if(referenciabancariaLocal.getId().equals(referenciabancaria.getId())) {
					referenciabancariaEncontrado=referenciabancariaLocal;
					
					referenciabancariaLocal.setIsChanged(referenciabancaria.getIsChanged());
					referenciabancariaLocal.setIsNew(referenciabancaria.getIsNew());
					referenciabancariaLocal.setIsDeleted(referenciabancaria.getIsDeleted());
					
					referenciabancariaLocal.setGeneralEntityOriginal(referenciabancaria.getGeneralEntityOriginal());
					
					referenciabancariaLocal.setId(referenciabancaria.getId());	
					referenciabancariaLocal.setVersionRow(referenciabancaria.getVersionRow());	
					referenciabancariaLocal.setid_empresa(referenciabancaria.getid_empresa());	
					referenciabancariaLocal.setidcliente(referenciabancaria.getidcliente());	
					referenciabancariaLocal.setidvalorclientebanco(referenciabancaria.getidvalorclientebanco());	
					referenciabancariaLocal.setidvalorclienteproductobanco(referenciabancaria.getidvalorclienteproductobanco());	
					referenciabancariaLocal.setidvalorclientecuentabanco(referenciabancaria.getidvalorclientecuentabanco());	
					referenciabancariaLocal.setnumero_cuenta_tarjeta(referenciabancaria.getnumero_cuenta_tarjeta());	
					referenciabancariaLocal.setfecha_emision(referenciabancaria.getfecha_emision());	
					referenciabancariaLocal.setfecha_vencimiento(referenciabancaria.getfecha_vencimiento());	
					referenciabancariaLocal.setcupo(referenciabancaria.getcupo());	
					referenciabancariaLocal.settiene_credito(referenciabancaria.gettiene_credito());	
					referenciabancariaLocal.setnumero_creditos(referenciabancaria.getnumero_creditos());	
					referenciabancariaLocal.settiene_protestos(referenciabancaria.gettiene_protestos());	
					referenciabancariaLocal.setnumero_protestos(referenciabancaria.getnumero_protestos());	
					referenciabancariaLocal.setsaldos_promedios(referenciabancaria.getsaldos_promedios());	
					referenciabancariaLocal.setpropietario_cuenta(referenciabancaria.getpropietario_cuenta());	
					referenciabancariaLocal.setid_tipo_valoracion(referenciabancaria.getid_tipo_valoracion());	
					referenciabancariaLocal.setesactivo(referenciabancaria.getesactivo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!referenciabancaria.getIsDeleted()) {
				if(!existe) {
					referenciabancarias.add(referenciabancaria);
				}
			} else {
				if(referenciabancariaEncontrado!=null && permiteQuitar)  {
					referenciabancarias.remove(referenciabancariaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ReferenciaBancaria referenciabancaria,List<ReferenciaBancaria> referenciabancarias) throws Exception {
		try	{			
			for(ReferenciaBancaria referenciabancariaLocal:referenciabancarias) {
				if(referenciabancariaLocal.getId().equals(referenciabancaria.getId())) {
					referenciabancariaLocal.setIsSelected(referenciabancaria.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesReferenciaBancaria(List<ReferenciaBancaria> referenciabancariasAux) throws Exception {
		//this.referenciabancariasAux=referenciabancariasAux;
		
		for(ReferenciaBancaria referenciabancariaAux:referenciabancariasAux) {
			if(referenciabancariaAux.getIsChanged()) {
				referenciabancariaAux.setIsChanged(false);
			}		
			
			if(referenciabancariaAux.getIsNew()) {
				referenciabancariaAux.setIsNew(false);
			}	
			
			if(referenciabancariaAux.getIsDeleted()) {
				referenciabancariaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesReferenciaBancaria(ReferenciaBancaria referenciabancariaAux) throws Exception {
		//this.referenciabancariaAux=referenciabancariaAux;
		
			if(referenciabancariaAux.getIsChanged()) {
				referenciabancariaAux.setIsChanged(false);
			}		
			
			if(referenciabancariaAux.getIsNew()) {
				referenciabancariaAux.setIsNew(false);
			}	
			
			if(referenciabancariaAux.getIsDeleted()) {
				referenciabancariaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ReferenciaBancaria referenciabancariaAsignar,ReferenciaBancaria referenciabancaria) throws Exception {
		referenciabancariaAsignar.setId(referenciabancaria.getId());	
		referenciabancariaAsignar.setVersionRow(referenciabancaria.getVersionRow());	
		referenciabancariaAsignar.setid_empresa(referenciabancaria.getid_empresa());
		referenciabancariaAsignar.setempresa_descripcion(referenciabancaria.getempresa_descripcion());	
		referenciabancariaAsignar.setidcliente(referenciabancaria.getidcliente());
		referenciabancariaAsignar.setcliente_descripcion(referenciabancaria.getcliente_descripcion());	
		referenciabancariaAsignar.setidvalorclientebanco(referenciabancaria.getidvalorclientebanco());
		referenciabancariaAsignar.setbanco_descripcion(referenciabancaria.getbanco_descripcion());	
		referenciabancariaAsignar.setidvalorclienteproductobanco(referenciabancaria.getidvalorclienteproductobanco());
		referenciabancariaAsignar.settipoprodubanco_descripcion(referenciabancaria.gettipoprodubanco_descripcion());	
		referenciabancariaAsignar.setidvalorclientecuentabanco(referenciabancaria.getidvalorclientecuentabanco());
		referenciabancariaAsignar.settipocuentabanco_descripcion(referenciabancaria.gettipocuentabanco_descripcion());	
		referenciabancariaAsignar.setnumero_cuenta_tarjeta(referenciabancaria.getnumero_cuenta_tarjeta());	
		referenciabancariaAsignar.setfecha_emision(referenciabancaria.getfecha_emision());	
		referenciabancariaAsignar.setfecha_vencimiento(referenciabancaria.getfecha_vencimiento());	
		referenciabancariaAsignar.setcupo(referenciabancaria.getcupo());	
		referenciabancariaAsignar.settiene_credito(referenciabancaria.gettiene_credito());	
		referenciabancariaAsignar.setnumero_creditos(referenciabancaria.getnumero_creditos());	
		referenciabancariaAsignar.settiene_protestos(referenciabancaria.gettiene_protestos());	
		referenciabancariaAsignar.setnumero_protestos(referenciabancaria.getnumero_protestos());	
		referenciabancariaAsignar.setsaldos_promedios(referenciabancaria.getsaldos_promedios());	
		referenciabancariaAsignar.setpropietario_cuenta(referenciabancaria.getpropietario_cuenta());	
		referenciabancariaAsignar.setid_tipo_valoracion(referenciabancaria.getid_tipo_valoracion());
		referenciabancariaAsignar.settipovaloracion_descripcion(referenciabancaria.gettipovaloracion_descripcion());	
		referenciabancariaAsignar.setesactivo(referenciabancaria.getesactivo());	
	}
	
	public static void inicializarReferenciaBancaria(ReferenciaBancaria referenciabancaria) throws Exception {
		try {
				referenciabancaria.setId(0L);	
					
				referenciabancaria.setid_empresa(-1L);	
				referenciabancaria.setidcliente(-1L);	
				referenciabancaria.setidvalorclientebanco(-1L);	
				referenciabancaria.setidvalorclienteproductobanco(-1L);	
				referenciabancaria.setidvalorclientecuentabanco(-1L);	
				referenciabancaria.setnumero_cuenta_tarjeta("");	
				referenciabancaria.setfecha_emision(new Date());	
				referenciabancaria.setfecha_vencimiento(new Date());	
				referenciabancaria.setcupo(0.0);	
				referenciabancaria.settiene_credito(false);	
				referenciabancaria.setnumero_creditos(0);	
				referenciabancaria.settiene_protestos(false);	
				referenciabancaria.setnumero_protestos(0);	
				referenciabancaria.setsaldos_promedios("");	
				referenciabancaria.setpropietario_cuenta("");	
				referenciabancaria.setid_tipo_valoracion(-1L);	
				referenciabancaria.setesactivo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderReferenciaBancaria(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaBancariaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaBancariaConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaBancariaConstantesFunciones.LABEL_IDBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaBancariaConstantesFunciones.LABEL_IDTIPOPRODUBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaBancariaConstantesFunciones.LABEL_IDTIPOCUENTABANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaBancariaConstantesFunciones.LABEL_NUMEROCUENTATARJETA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaBancariaConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaBancariaConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaBancariaConstantesFunciones.LABEL_CUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaBancariaConstantesFunciones.LABEL_TIENECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaBancariaConstantesFunciones.LABEL_NUMEROCREDITOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaBancariaConstantesFunciones.LABEL_TIENEPROTESTOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaBancariaConstantesFunciones.LABEL_NUMEROPROTESTOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaBancariaConstantesFunciones.LABEL_SALDOSPROMEDIOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaBancariaConstantesFunciones.LABEL_PROPIETARIOCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaBancariaConstantesFunciones.LABEL_IDTIPOVALORACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaBancariaConstantesFunciones.LABEL_ESACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataReferenciaBancaria(String sTipo,Row row,Workbook workbook,ReferenciaBancaria referenciabancaria,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciabancaria.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciabancaria.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciabancaria.getbanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciabancaria.gettipoprodubanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciabancaria.gettipocuentabanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciabancaria.getnumero_cuenta_tarjeta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciabancaria.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciabancaria.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciabancaria.getcupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(referenciabancaria.gettiene_credito()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciabancaria.getnumero_creditos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(referenciabancaria.gettiene_protestos()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciabancaria.getnumero_protestos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciabancaria.getsaldos_promedios());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciabancaria.getpropietario_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciabancaria.gettipovaloracion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(referenciabancaria.getesactivo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryReferenciaBancaria=Constantes.SFINALQUERY;
	
	public String getsFinalQueryReferenciaBancaria() {
		return this.sFinalQueryReferenciaBancaria;
	}
	
	public void setsFinalQueryReferenciaBancaria(String sFinalQueryReferenciaBancaria) {
		this.sFinalQueryReferenciaBancaria= sFinalQueryReferenciaBancaria;
	}
	
	public Border resaltarSeleccionarReferenciaBancaria=null;
	
	public Border setResaltarSeleccionarReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltarSeleccionarReferenciaBancaria= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarReferenciaBancaria() {
		return this.resaltarSeleccionarReferenciaBancaria;
	}
	
	public void setResaltarSeleccionarReferenciaBancaria(Border borderResaltarSeleccionarReferenciaBancaria) {
		this.resaltarSeleccionarReferenciaBancaria= borderResaltarSeleccionarReferenciaBancaria;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridReferenciaBancaria=null;
	public Boolean mostraridReferenciaBancaria=true;
	public Boolean activaridReferenciaBancaria=true;

	public Border resaltarid_empresaReferenciaBancaria=null;
	public Boolean mostrarid_empresaReferenciaBancaria=true;
	public Boolean activarid_empresaReferenciaBancaria=true;
	public Boolean cargarid_empresaReferenciaBancaria=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaReferenciaBancaria=false;//ConEventDepend=true

	public Border resaltaridclienteReferenciaBancaria=null;
	public Boolean mostraridclienteReferenciaBancaria=true;
	public Boolean activaridclienteReferenciaBancaria=true;
	public Boolean cargaridclienteReferenciaBancaria=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidclienteReferenciaBancaria=false;//ConEventDepend=true

	public Border resaltaridvalorclientebancoReferenciaBancaria=null;
	public Boolean mostraridvalorclientebancoReferenciaBancaria=true;
	public Boolean activaridvalorclientebancoReferenciaBancaria=true;
	public Boolean cargaridvalorclientebancoReferenciaBancaria=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidvalorclientebancoReferenciaBancaria=false;//ConEventDepend=true

	public Border resaltaridvalorclienteproductobancoReferenciaBancaria=null;
	public Boolean mostraridvalorclienteproductobancoReferenciaBancaria=true;
	public Boolean activaridvalorclienteproductobancoReferenciaBancaria=true;
	public Boolean cargaridvalorclienteproductobancoReferenciaBancaria=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidvalorclienteproductobancoReferenciaBancaria=false;//ConEventDepend=true

	public Border resaltaridvalorclientecuentabancoReferenciaBancaria=null;
	public Boolean mostraridvalorclientecuentabancoReferenciaBancaria=true;
	public Boolean activaridvalorclientecuentabancoReferenciaBancaria=true;
	public Boolean cargaridvalorclientecuentabancoReferenciaBancaria=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidvalorclientecuentabancoReferenciaBancaria=false;//ConEventDepend=true

	public Border resaltarnumero_cuenta_tarjetaReferenciaBancaria=null;
	public Boolean mostrarnumero_cuenta_tarjetaReferenciaBancaria=true;
	public Boolean activarnumero_cuenta_tarjetaReferenciaBancaria=true;

	public Border resaltarfecha_emisionReferenciaBancaria=null;
	public Boolean mostrarfecha_emisionReferenciaBancaria=true;
	public Boolean activarfecha_emisionReferenciaBancaria=false;

	public Border resaltarfecha_vencimientoReferenciaBancaria=null;
	public Boolean mostrarfecha_vencimientoReferenciaBancaria=true;
	public Boolean activarfecha_vencimientoReferenciaBancaria=false;

	public Border resaltarcupoReferenciaBancaria=null;
	public Boolean mostrarcupoReferenciaBancaria=true;
	public Boolean activarcupoReferenciaBancaria=true;

	public Border resaltartiene_creditoReferenciaBancaria=null;
	public Boolean mostrartiene_creditoReferenciaBancaria=true;
	public Boolean activartiene_creditoReferenciaBancaria=true;

	public Border resaltarnumero_creditosReferenciaBancaria=null;
	public Boolean mostrarnumero_creditosReferenciaBancaria=true;
	public Boolean activarnumero_creditosReferenciaBancaria=true;

	public Border resaltartiene_protestosReferenciaBancaria=null;
	public Boolean mostrartiene_protestosReferenciaBancaria=true;
	public Boolean activartiene_protestosReferenciaBancaria=true;

	public Border resaltarnumero_protestosReferenciaBancaria=null;
	public Boolean mostrarnumero_protestosReferenciaBancaria=true;
	public Boolean activarnumero_protestosReferenciaBancaria=true;

	public Border resaltarsaldos_promediosReferenciaBancaria=null;
	public Boolean mostrarsaldos_promediosReferenciaBancaria=true;
	public Boolean activarsaldos_promediosReferenciaBancaria=true;

	public Border resaltarpropietario_cuentaReferenciaBancaria=null;
	public Boolean mostrarpropietario_cuentaReferenciaBancaria=true;
	public Boolean activarpropietario_cuentaReferenciaBancaria=true;

	public Border resaltarid_tipo_valoracionReferenciaBancaria=null;
	public Boolean mostrarid_tipo_valoracionReferenciaBancaria=true;
	public Boolean activarid_tipo_valoracionReferenciaBancaria=true;
	public Boolean cargarid_tipo_valoracionReferenciaBancaria=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_valoracionReferenciaBancaria=false;//ConEventDepend=true

	public Border resaltaresactivoReferenciaBancaria=null;
	public Boolean mostraresactivoReferenciaBancaria=true;
	public Boolean activaresactivoReferenciaBancaria=true;

	
	

	public Border setResaltaridReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltaridReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridReferenciaBancaria() {
		return this.resaltaridReferenciaBancaria;
	}

	public void setResaltaridReferenciaBancaria(Border borderResaltar) {
		this.resaltaridReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostraridReferenciaBancaria() {
		return this.mostraridReferenciaBancaria;
	}

	public void setMostraridReferenciaBancaria(Boolean mostraridReferenciaBancaria) {
		this.mostraridReferenciaBancaria= mostraridReferenciaBancaria;
	}

	public Boolean getActivaridReferenciaBancaria() {
		return this.activaridReferenciaBancaria;
	}

	public void setActivaridReferenciaBancaria(Boolean activaridReferenciaBancaria) {
		this.activaridReferenciaBancaria= activaridReferenciaBancaria;
	}

	public Border setResaltarid_empresaReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltarid_empresaReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaReferenciaBancaria() {
		return this.resaltarid_empresaReferenciaBancaria;
	}

	public void setResaltarid_empresaReferenciaBancaria(Border borderResaltar) {
		this.resaltarid_empresaReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostrarid_empresaReferenciaBancaria() {
		return this.mostrarid_empresaReferenciaBancaria;
	}

	public void setMostrarid_empresaReferenciaBancaria(Boolean mostrarid_empresaReferenciaBancaria) {
		this.mostrarid_empresaReferenciaBancaria= mostrarid_empresaReferenciaBancaria;
	}

	public Boolean getActivarid_empresaReferenciaBancaria() {
		return this.activarid_empresaReferenciaBancaria;
	}

	public void setActivarid_empresaReferenciaBancaria(Boolean activarid_empresaReferenciaBancaria) {
		this.activarid_empresaReferenciaBancaria= activarid_empresaReferenciaBancaria;
	}

	public Boolean getCargarid_empresaReferenciaBancaria() {
		return this.cargarid_empresaReferenciaBancaria;
	}

	public void setCargarid_empresaReferenciaBancaria(Boolean cargarid_empresaReferenciaBancaria) {
		this.cargarid_empresaReferenciaBancaria= cargarid_empresaReferenciaBancaria;
	}

	public Border setResaltaridclienteReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltaridclienteReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridclienteReferenciaBancaria() {
		return this.resaltaridclienteReferenciaBancaria;
	}

	public void setResaltaridclienteReferenciaBancaria(Border borderResaltar) {
		this.resaltaridclienteReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostraridclienteReferenciaBancaria() {
		return this.mostraridclienteReferenciaBancaria;
	}

	public void setMostraridclienteReferenciaBancaria(Boolean mostraridclienteReferenciaBancaria) {
		this.mostraridclienteReferenciaBancaria= mostraridclienteReferenciaBancaria;
	}

	public Boolean getActivaridclienteReferenciaBancaria() {
		return this.activaridclienteReferenciaBancaria;
	}

	public void setActivaridclienteReferenciaBancaria(Boolean activaridclienteReferenciaBancaria) {
		this.activaridclienteReferenciaBancaria= activaridclienteReferenciaBancaria;
	}

	public Boolean getCargaridclienteReferenciaBancaria() {
		return this.cargaridclienteReferenciaBancaria;
	}

	public void setCargaridclienteReferenciaBancaria(Boolean cargaridclienteReferenciaBancaria) {
		this.cargaridclienteReferenciaBancaria= cargaridclienteReferenciaBancaria;
	}

	public Border setResaltaridvalorclientebancoReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltaridvalorclientebancoReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridvalorclientebancoReferenciaBancaria() {
		return this.resaltaridvalorclientebancoReferenciaBancaria;
	}

	public void setResaltaridvalorclientebancoReferenciaBancaria(Border borderResaltar) {
		this.resaltaridvalorclientebancoReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostraridvalorclientebancoReferenciaBancaria() {
		return this.mostraridvalorclientebancoReferenciaBancaria;
	}

	public void setMostraridvalorclientebancoReferenciaBancaria(Boolean mostraridvalorclientebancoReferenciaBancaria) {
		this.mostraridvalorclientebancoReferenciaBancaria= mostraridvalorclientebancoReferenciaBancaria;
	}

	public Boolean getActivaridvalorclientebancoReferenciaBancaria() {
		return this.activaridvalorclientebancoReferenciaBancaria;
	}

	public void setActivaridvalorclientebancoReferenciaBancaria(Boolean activaridvalorclientebancoReferenciaBancaria) {
		this.activaridvalorclientebancoReferenciaBancaria= activaridvalorclientebancoReferenciaBancaria;
	}

	public Boolean getCargaridvalorclientebancoReferenciaBancaria() {
		return this.cargaridvalorclientebancoReferenciaBancaria;
	}

	public void setCargaridvalorclientebancoReferenciaBancaria(Boolean cargaridvalorclientebancoReferenciaBancaria) {
		this.cargaridvalorclientebancoReferenciaBancaria= cargaridvalorclientebancoReferenciaBancaria;
	}

	public Border setResaltaridvalorclienteproductobancoReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltaridvalorclienteproductobancoReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridvalorclienteproductobancoReferenciaBancaria() {
		return this.resaltaridvalorclienteproductobancoReferenciaBancaria;
	}

	public void setResaltaridvalorclienteproductobancoReferenciaBancaria(Border borderResaltar) {
		this.resaltaridvalorclienteproductobancoReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostraridvalorclienteproductobancoReferenciaBancaria() {
		return this.mostraridvalorclienteproductobancoReferenciaBancaria;
	}

	public void setMostraridvalorclienteproductobancoReferenciaBancaria(Boolean mostraridvalorclienteproductobancoReferenciaBancaria) {
		this.mostraridvalorclienteproductobancoReferenciaBancaria= mostraridvalorclienteproductobancoReferenciaBancaria;
	}

	public Boolean getActivaridvalorclienteproductobancoReferenciaBancaria() {
		return this.activaridvalorclienteproductobancoReferenciaBancaria;
	}

	public void setActivaridvalorclienteproductobancoReferenciaBancaria(Boolean activaridvalorclienteproductobancoReferenciaBancaria) {
		this.activaridvalorclienteproductobancoReferenciaBancaria= activaridvalorclienteproductobancoReferenciaBancaria;
	}

	public Boolean getCargaridvalorclienteproductobancoReferenciaBancaria() {
		return this.cargaridvalorclienteproductobancoReferenciaBancaria;
	}

	public void setCargaridvalorclienteproductobancoReferenciaBancaria(Boolean cargaridvalorclienteproductobancoReferenciaBancaria) {
		this.cargaridvalorclienteproductobancoReferenciaBancaria= cargaridvalorclienteproductobancoReferenciaBancaria;
	}

	public Border setResaltaridvalorclientecuentabancoReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltaridvalorclientecuentabancoReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridvalorclientecuentabancoReferenciaBancaria() {
		return this.resaltaridvalorclientecuentabancoReferenciaBancaria;
	}

	public void setResaltaridvalorclientecuentabancoReferenciaBancaria(Border borderResaltar) {
		this.resaltaridvalorclientecuentabancoReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostraridvalorclientecuentabancoReferenciaBancaria() {
		return this.mostraridvalorclientecuentabancoReferenciaBancaria;
	}

	public void setMostraridvalorclientecuentabancoReferenciaBancaria(Boolean mostraridvalorclientecuentabancoReferenciaBancaria) {
		this.mostraridvalorclientecuentabancoReferenciaBancaria= mostraridvalorclientecuentabancoReferenciaBancaria;
	}

	public Boolean getActivaridvalorclientecuentabancoReferenciaBancaria() {
		return this.activaridvalorclientecuentabancoReferenciaBancaria;
	}

	public void setActivaridvalorclientecuentabancoReferenciaBancaria(Boolean activaridvalorclientecuentabancoReferenciaBancaria) {
		this.activaridvalorclientecuentabancoReferenciaBancaria= activaridvalorclientecuentabancoReferenciaBancaria;
	}

	public Boolean getCargaridvalorclientecuentabancoReferenciaBancaria() {
		return this.cargaridvalorclientecuentabancoReferenciaBancaria;
	}

	public void setCargaridvalorclientecuentabancoReferenciaBancaria(Boolean cargaridvalorclientecuentabancoReferenciaBancaria) {
		this.cargaridvalorclientecuentabancoReferenciaBancaria= cargaridvalorclientecuentabancoReferenciaBancaria;
	}

	public Border setResaltarnumero_cuenta_tarjetaReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltarnumero_cuenta_tarjetaReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuenta_tarjetaReferenciaBancaria() {
		return this.resaltarnumero_cuenta_tarjetaReferenciaBancaria;
	}

	public void setResaltarnumero_cuenta_tarjetaReferenciaBancaria(Border borderResaltar) {
		this.resaltarnumero_cuenta_tarjetaReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostrarnumero_cuenta_tarjetaReferenciaBancaria() {
		return this.mostrarnumero_cuenta_tarjetaReferenciaBancaria;
	}

	public void setMostrarnumero_cuenta_tarjetaReferenciaBancaria(Boolean mostrarnumero_cuenta_tarjetaReferenciaBancaria) {
		this.mostrarnumero_cuenta_tarjetaReferenciaBancaria= mostrarnumero_cuenta_tarjetaReferenciaBancaria;
	}

	public Boolean getActivarnumero_cuenta_tarjetaReferenciaBancaria() {
		return this.activarnumero_cuenta_tarjetaReferenciaBancaria;
	}

	public void setActivarnumero_cuenta_tarjetaReferenciaBancaria(Boolean activarnumero_cuenta_tarjetaReferenciaBancaria) {
		this.activarnumero_cuenta_tarjetaReferenciaBancaria= activarnumero_cuenta_tarjetaReferenciaBancaria;
	}

	public Border setResaltarfecha_emisionReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionReferenciaBancaria() {
		return this.resaltarfecha_emisionReferenciaBancaria;
	}

	public void setResaltarfecha_emisionReferenciaBancaria(Border borderResaltar) {
		this.resaltarfecha_emisionReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionReferenciaBancaria() {
		return this.mostrarfecha_emisionReferenciaBancaria;
	}

	public void setMostrarfecha_emisionReferenciaBancaria(Boolean mostrarfecha_emisionReferenciaBancaria) {
		this.mostrarfecha_emisionReferenciaBancaria= mostrarfecha_emisionReferenciaBancaria;
	}

	public Boolean getActivarfecha_emisionReferenciaBancaria() {
		return this.activarfecha_emisionReferenciaBancaria;
	}

	public void setActivarfecha_emisionReferenciaBancaria(Boolean activarfecha_emisionReferenciaBancaria) {
		this.activarfecha_emisionReferenciaBancaria= activarfecha_emisionReferenciaBancaria;
	}

	public Border setResaltarfecha_vencimientoReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoReferenciaBancaria() {
		return this.resaltarfecha_vencimientoReferenciaBancaria;
	}

	public void setResaltarfecha_vencimientoReferenciaBancaria(Border borderResaltar) {
		this.resaltarfecha_vencimientoReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoReferenciaBancaria() {
		return this.mostrarfecha_vencimientoReferenciaBancaria;
	}

	public void setMostrarfecha_vencimientoReferenciaBancaria(Boolean mostrarfecha_vencimientoReferenciaBancaria) {
		this.mostrarfecha_vencimientoReferenciaBancaria= mostrarfecha_vencimientoReferenciaBancaria;
	}

	public Boolean getActivarfecha_vencimientoReferenciaBancaria() {
		return this.activarfecha_vencimientoReferenciaBancaria;
	}

	public void setActivarfecha_vencimientoReferenciaBancaria(Boolean activarfecha_vencimientoReferenciaBancaria) {
		this.activarfecha_vencimientoReferenciaBancaria= activarfecha_vencimientoReferenciaBancaria;
	}

	public Border setResaltarcupoReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltarcupoReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcupoReferenciaBancaria() {
		return this.resaltarcupoReferenciaBancaria;
	}

	public void setResaltarcupoReferenciaBancaria(Border borderResaltar) {
		this.resaltarcupoReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostrarcupoReferenciaBancaria() {
		return this.mostrarcupoReferenciaBancaria;
	}

	public void setMostrarcupoReferenciaBancaria(Boolean mostrarcupoReferenciaBancaria) {
		this.mostrarcupoReferenciaBancaria= mostrarcupoReferenciaBancaria;
	}

	public Boolean getActivarcupoReferenciaBancaria() {
		return this.activarcupoReferenciaBancaria;
	}

	public void setActivarcupoReferenciaBancaria(Boolean activarcupoReferenciaBancaria) {
		this.activarcupoReferenciaBancaria= activarcupoReferenciaBancaria;
	}

	public Border setResaltartiene_creditoReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltartiene_creditoReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartiene_creditoReferenciaBancaria() {
		return this.resaltartiene_creditoReferenciaBancaria;
	}

	public void setResaltartiene_creditoReferenciaBancaria(Border borderResaltar) {
		this.resaltartiene_creditoReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostrartiene_creditoReferenciaBancaria() {
		return this.mostrartiene_creditoReferenciaBancaria;
	}

	public void setMostrartiene_creditoReferenciaBancaria(Boolean mostrartiene_creditoReferenciaBancaria) {
		this.mostrartiene_creditoReferenciaBancaria= mostrartiene_creditoReferenciaBancaria;
	}

	public Boolean getActivartiene_creditoReferenciaBancaria() {
		return this.activartiene_creditoReferenciaBancaria;
	}

	public void setActivartiene_creditoReferenciaBancaria(Boolean activartiene_creditoReferenciaBancaria) {
		this.activartiene_creditoReferenciaBancaria= activartiene_creditoReferenciaBancaria;
	}

	public Border setResaltarnumero_creditosReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltarnumero_creditosReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_creditosReferenciaBancaria() {
		return this.resaltarnumero_creditosReferenciaBancaria;
	}

	public void setResaltarnumero_creditosReferenciaBancaria(Border borderResaltar) {
		this.resaltarnumero_creditosReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostrarnumero_creditosReferenciaBancaria() {
		return this.mostrarnumero_creditosReferenciaBancaria;
	}

	public void setMostrarnumero_creditosReferenciaBancaria(Boolean mostrarnumero_creditosReferenciaBancaria) {
		this.mostrarnumero_creditosReferenciaBancaria= mostrarnumero_creditosReferenciaBancaria;
	}

	public Boolean getActivarnumero_creditosReferenciaBancaria() {
		return this.activarnumero_creditosReferenciaBancaria;
	}

	public void setActivarnumero_creditosReferenciaBancaria(Boolean activarnumero_creditosReferenciaBancaria) {
		this.activarnumero_creditosReferenciaBancaria= activarnumero_creditosReferenciaBancaria;
	}

	public Border setResaltartiene_protestosReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltartiene_protestosReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartiene_protestosReferenciaBancaria() {
		return this.resaltartiene_protestosReferenciaBancaria;
	}

	public void setResaltartiene_protestosReferenciaBancaria(Border borderResaltar) {
		this.resaltartiene_protestosReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostrartiene_protestosReferenciaBancaria() {
		return this.mostrartiene_protestosReferenciaBancaria;
	}

	public void setMostrartiene_protestosReferenciaBancaria(Boolean mostrartiene_protestosReferenciaBancaria) {
		this.mostrartiene_protestosReferenciaBancaria= mostrartiene_protestosReferenciaBancaria;
	}

	public Boolean getActivartiene_protestosReferenciaBancaria() {
		return this.activartiene_protestosReferenciaBancaria;
	}

	public void setActivartiene_protestosReferenciaBancaria(Boolean activartiene_protestosReferenciaBancaria) {
		this.activartiene_protestosReferenciaBancaria= activartiene_protestosReferenciaBancaria;
	}

	public Border setResaltarnumero_protestosReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltarnumero_protestosReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_protestosReferenciaBancaria() {
		return this.resaltarnumero_protestosReferenciaBancaria;
	}

	public void setResaltarnumero_protestosReferenciaBancaria(Border borderResaltar) {
		this.resaltarnumero_protestosReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostrarnumero_protestosReferenciaBancaria() {
		return this.mostrarnumero_protestosReferenciaBancaria;
	}

	public void setMostrarnumero_protestosReferenciaBancaria(Boolean mostrarnumero_protestosReferenciaBancaria) {
		this.mostrarnumero_protestosReferenciaBancaria= mostrarnumero_protestosReferenciaBancaria;
	}

	public Boolean getActivarnumero_protestosReferenciaBancaria() {
		return this.activarnumero_protestosReferenciaBancaria;
	}

	public void setActivarnumero_protestosReferenciaBancaria(Boolean activarnumero_protestosReferenciaBancaria) {
		this.activarnumero_protestosReferenciaBancaria= activarnumero_protestosReferenciaBancaria;
	}

	public Border setResaltarsaldos_promediosReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltarsaldos_promediosReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldos_promediosReferenciaBancaria() {
		return this.resaltarsaldos_promediosReferenciaBancaria;
	}

	public void setResaltarsaldos_promediosReferenciaBancaria(Border borderResaltar) {
		this.resaltarsaldos_promediosReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostrarsaldos_promediosReferenciaBancaria() {
		return this.mostrarsaldos_promediosReferenciaBancaria;
	}

	public void setMostrarsaldos_promediosReferenciaBancaria(Boolean mostrarsaldos_promediosReferenciaBancaria) {
		this.mostrarsaldos_promediosReferenciaBancaria= mostrarsaldos_promediosReferenciaBancaria;
	}

	public Boolean getActivarsaldos_promediosReferenciaBancaria() {
		return this.activarsaldos_promediosReferenciaBancaria;
	}

	public void setActivarsaldos_promediosReferenciaBancaria(Boolean activarsaldos_promediosReferenciaBancaria) {
		this.activarsaldos_promediosReferenciaBancaria= activarsaldos_promediosReferenciaBancaria;
	}

	public Border setResaltarpropietario_cuentaReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltarpropietario_cuentaReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpropietario_cuentaReferenciaBancaria() {
		return this.resaltarpropietario_cuentaReferenciaBancaria;
	}

	public void setResaltarpropietario_cuentaReferenciaBancaria(Border borderResaltar) {
		this.resaltarpropietario_cuentaReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostrarpropietario_cuentaReferenciaBancaria() {
		return this.mostrarpropietario_cuentaReferenciaBancaria;
	}

	public void setMostrarpropietario_cuentaReferenciaBancaria(Boolean mostrarpropietario_cuentaReferenciaBancaria) {
		this.mostrarpropietario_cuentaReferenciaBancaria= mostrarpropietario_cuentaReferenciaBancaria;
	}

	public Boolean getActivarpropietario_cuentaReferenciaBancaria() {
		return this.activarpropietario_cuentaReferenciaBancaria;
	}

	public void setActivarpropietario_cuentaReferenciaBancaria(Boolean activarpropietario_cuentaReferenciaBancaria) {
		this.activarpropietario_cuentaReferenciaBancaria= activarpropietario_cuentaReferenciaBancaria;
	}

	public Border setResaltarid_tipo_valoracionReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltarid_tipo_valoracionReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_valoracionReferenciaBancaria() {
		return this.resaltarid_tipo_valoracionReferenciaBancaria;
	}

	public void setResaltarid_tipo_valoracionReferenciaBancaria(Border borderResaltar) {
		this.resaltarid_tipo_valoracionReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostrarid_tipo_valoracionReferenciaBancaria() {
		return this.mostrarid_tipo_valoracionReferenciaBancaria;
	}

	public void setMostrarid_tipo_valoracionReferenciaBancaria(Boolean mostrarid_tipo_valoracionReferenciaBancaria) {
		this.mostrarid_tipo_valoracionReferenciaBancaria= mostrarid_tipo_valoracionReferenciaBancaria;
	}

	public Boolean getActivarid_tipo_valoracionReferenciaBancaria() {
		return this.activarid_tipo_valoracionReferenciaBancaria;
	}

	public void setActivarid_tipo_valoracionReferenciaBancaria(Boolean activarid_tipo_valoracionReferenciaBancaria) {
		this.activarid_tipo_valoracionReferenciaBancaria= activarid_tipo_valoracionReferenciaBancaria;
	}

	public Boolean getCargarid_tipo_valoracionReferenciaBancaria() {
		return this.cargarid_tipo_valoracionReferenciaBancaria;
	}

	public void setCargarid_tipo_valoracionReferenciaBancaria(Boolean cargarid_tipo_valoracionReferenciaBancaria) {
		this.cargarid_tipo_valoracionReferenciaBancaria= cargarid_tipo_valoracionReferenciaBancaria;
	}

	public Border setResaltaresactivoReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciabancariaBeanSwingJInternalFrame.jTtoolBarReferenciaBancaria.setBorder(borderResaltar);
		
		this.resaltaresactivoReferenciaBancaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresactivoReferenciaBancaria() {
		return this.resaltaresactivoReferenciaBancaria;
	}

	public void setResaltaresactivoReferenciaBancaria(Border borderResaltar) {
		this.resaltaresactivoReferenciaBancaria= borderResaltar;
	}

	public Boolean getMostraresactivoReferenciaBancaria() {
		return this.mostraresactivoReferenciaBancaria;
	}

	public void setMostraresactivoReferenciaBancaria(Boolean mostraresactivoReferenciaBancaria) {
		this.mostraresactivoReferenciaBancaria= mostraresactivoReferenciaBancaria;
	}

	public Boolean getActivaresactivoReferenciaBancaria() {
		return this.activaresactivoReferenciaBancaria;
	}

	public void setActivaresactivoReferenciaBancaria(Boolean activaresactivoReferenciaBancaria) {
		this.activaresactivoReferenciaBancaria= activaresactivoReferenciaBancaria;
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
		
		
		this.setMostraridReferenciaBancaria(esInicial);
		this.setMostrarid_empresaReferenciaBancaria(esInicial);
		this.setMostraridclienteReferenciaBancaria(esInicial);
		this.setMostraridvalorclientebancoReferenciaBancaria(esInicial);
		this.setMostraridvalorclienteproductobancoReferenciaBancaria(esInicial);
		this.setMostraridvalorclientecuentabancoReferenciaBancaria(esInicial);
		this.setMostrarnumero_cuenta_tarjetaReferenciaBancaria(esInicial);
		this.setMostrarfecha_emisionReferenciaBancaria(esInicial);
		this.setMostrarfecha_vencimientoReferenciaBancaria(esInicial);
		this.setMostrarcupoReferenciaBancaria(esInicial);
		this.setMostrartiene_creditoReferenciaBancaria(esInicial);
		this.setMostrarnumero_creditosReferenciaBancaria(esInicial);
		this.setMostrartiene_protestosReferenciaBancaria(esInicial);
		this.setMostrarnumero_protestosReferenciaBancaria(esInicial);
		this.setMostrarsaldos_promediosReferenciaBancaria(esInicial);
		this.setMostrarpropietario_cuentaReferenciaBancaria(esInicial);
		this.setMostrarid_tipo_valoracionReferenciaBancaria(esInicial);
		this.setMostraresactivoReferenciaBancaria(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.ID)) {
				this.setMostraridReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDCLIENTE)) {
				this.setMostraridclienteReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDBANCO)) {
				this.setMostraridvalorclientebancoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDTIPOPRODUBANCO)) {
				this.setMostraridvalorclienteproductobancoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDTIPOCUENTABANCO)) {
				this.setMostraridvalorclientecuentabancoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.NUMEROCUENTATARJETA)) {
				this.setMostrarnumero_cuenta_tarjetaReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.CUPO)) {
				this.setMostrarcupoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.TIENECREDITO)) {
				this.setMostrartiene_creditoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.NUMEROCREDITOS)) {
				this.setMostrarnumero_creditosReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.TIENEPROTESTOS)) {
				this.setMostrartiene_protestosReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.NUMEROPROTESTOS)) {
				this.setMostrarnumero_protestosReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.SALDOSPROMEDIOS)) {
				this.setMostrarsaldos_promediosReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.PROPIETARIOCUENTA)) {
				this.setMostrarpropietario_cuentaReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDTIPOVALORACION)) {
				this.setMostrarid_tipo_valoracionReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.ESACTIVO)) {
				this.setMostraresactivoReferenciaBancaria(esAsigna);
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
		
		
		this.setActivaridReferenciaBancaria(esInicial);
		this.setActivarid_empresaReferenciaBancaria(esInicial);
		this.setActivaridclienteReferenciaBancaria(esInicial);
		this.setActivaridvalorclientebancoReferenciaBancaria(esInicial);
		this.setActivaridvalorclienteproductobancoReferenciaBancaria(esInicial);
		this.setActivaridvalorclientecuentabancoReferenciaBancaria(esInicial);
		this.setActivarnumero_cuenta_tarjetaReferenciaBancaria(esInicial);
		this.setActivarfecha_emisionReferenciaBancaria(esInicial);
		this.setActivarfecha_vencimientoReferenciaBancaria(esInicial);
		this.setActivarcupoReferenciaBancaria(esInicial);
		this.setActivartiene_creditoReferenciaBancaria(esInicial);
		this.setActivarnumero_creditosReferenciaBancaria(esInicial);
		this.setActivartiene_protestosReferenciaBancaria(esInicial);
		this.setActivarnumero_protestosReferenciaBancaria(esInicial);
		this.setActivarsaldos_promediosReferenciaBancaria(esInicial);
		this.setActivarpropietario_cuentaReferenciaBancaria(esInicial);
		this.setActivarid_tipo_valoracionReferenciaBancaria(esInicial);
		this.setActivaresactivoReferenciaBancaria(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.ID)) {
				this.setActivaridReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDCLIENTE)) {
				this.setActivaridclienteReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDBANCO)) {
				this.setActivaridvalorclientebancoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDTIPOPRODUBANCO)) {
				this.setActivaridvalorclienteproductobancoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDTIPOCUENTABANCO)) {
				this.setActivaridvalorclientecuentabancoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.NUMEROCUENTATARJETA)) {
				this.setActivarnumero_cuenta_tarjetaReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.CUPO)) {
				this.setActivarcupoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.TIENECREDITO)) {
				this.setActivartiene_creditoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.NUMEROCREDITOS)) {
				this.setActivarnumero_creditosReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.TIENEPROTESTOS)) {
				this.setActivartiene_protestosReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.NUMEROPROTESTOS)) {
				this.setActivarnumero_protestosReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.SALDOSPROMEDIOS)) {
				this.setActivarsaldos_promediosReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.PROPIETARIOCUENTA)) {
				this.setActivarpropietario_cuentaReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDTIPOVALORACION)) {
				this.setActivarid_tipo_valoracionReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.ESACTIVO)) {
				this.setActivaresactivoReferenciaBancaria(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridReferenciaBancaria(esInicial);
		this.setResaltarid_empresaReferenciaBancaria(esInicial);
		this.setResaltaridclienteReferenciaBancaria(esInicial);
		this.setResaltaridvalorclientebancoReferenciaBancaria(esInicial);
		this.setResaltaridvalorclienteproductobancoReferenciaBancaria(esInicial);
		this.setResaltaridvalorclientecuentabancoReferenciaBancaria(esInicial);
		this.setResaltarnumero_cuenta_tarjetaReferenciaBancaria(esInicial);
		this.setResaltarfecha_emisionReferenciaBancaria(esInicial);
		this.setResaltarfecha_vencimientoReferenciaBancaria(esInicial);
		this.setResaltarcupoReferenciaBancaria(esInicial);
		this.setResaltartiene_creditoReferenciaBancaria(esInicial);
		this.setResaltarnumero_creditosReferenciaBancaria(esInicial);
		this.setResaltartiene_protestosReferenciaBancaria(esInicial);
		this.setResaltarnumero_protestosReferenciaBancaria(esInicial);
		this.setResaltarsaldos_promediosReferenciaBancaria(esInicial);
		this.setResaltarpropietario_cuentaReferenciaBancaria(esInicial);
		this.setResaltarid_tipo_valoracionReferenciaBancaria(esInicial);
		this.setResaltaresactivoReferenciaBancaria(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.ID)) {
				this.setResaltaridReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDCLIENTE)) {
				this.setResaltaridclienteReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDBANCO)) {
				this.setResaltaridvalorclientebancoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDTIPOPRODUBANCO)) {
				this.setResaltaridvalorclienteproductobancoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDTIPOCUENTABANCO)) {
				this.setResaltaridvalorclientecuentabancoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.NUMEROCUENTATARJETA)) {
				this.setResaltarnumero_cuenta_tarjetaReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.CUPO)) {
				this.setResaltarcupoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.TIENECREDITO)) {
				this.setResaltartiene_creditoReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.NUMEROCREDITOS)) {
				this.setResaltarnumero_creditosReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.TIENEPROTESTOS)) {
				this.setResaltartiene_protestosReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.NUMEROPROTESTOS)) {
				this.setResaltarnumero_protestosReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.SALDOSPROMEDIOS)) {
				this.setResaltarsaldos_promediosReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.PROPIETARIOCUENTA)) {
				this.setResaltarpropietario_cuentaReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.IDTIPOVALORACION)) {
				this.setResaltarid_tipo_valoracionReferenciaBancaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaBancariaConstantesFunciones.ESACTIVO)) {
				this.setResaltaresactivoReferenciaBancaria(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteReferenciaBancaria=true;

	public Boolean getMostrarFK_IdClienteReferenciaBancaria() {
		return this.mostrarFK_IdClienteReferenciaBancaria;
	}

	public void setMostrarFK_IdClienteReferenciaBancaria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteReferenciaBancaria= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaReferenciaBancaria=true;

	public Boolean getMostrarFK_IdEmpresaReferenciaBancaria() {
		return this.mostrarFK_IdEmpresaReferenciaBancaria;
	}

	public void setMostrarFK_IdEmpresaReferenciaBancaria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaReferenciaBancaria= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoBancoReferenciaBancaria=true;

	public Boolean getMostrarFK_IdTipoBancoReferenciaBancaria() {
		return this.mostrarFK_IdTipoBancoReferenciaBancaria;
	}

	public void setMostrarFK_IdTipoBancoReferenciaBancaria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoBancoReferenciaBancaria= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCuentaBancoReferenciaBancaria=true;

	public Boolean getMostrarFK_IdTipoCuentaBancoReferenciaBancaria() {
		return this.mostrarFK_IdTipoCuentaBancoReferenciaBancaria;
	}

	public void setMostrarFK_IdTipoCuentaBancoReferenciaBancaria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCuentaBancoReferenciaBancaria= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProductoBancoReferenciaBancaria=true;

	public Boolean getMostrarFK_IdTipoProductoBancoReferenciaBancaria() {
		return this.mostrarFK_IdTipoProductoBancoReferenciaBancaria;
	}

	public void setMostrarFK_IdTipoProductoBancoReferenciaBancaria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProductoBancoReferenciaBancaria= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoValoracionReferenciaBancaria=true;

	public Boolean getMostrarFK_IdTipoValoracionReferenciaBancaria() {
		return this.mostrarFK_IdTipoValoracionReferenciaBancaria;
	}

	public void setMostrarFK_IdTipoValoracionReferenciaBancaria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoValoracionReferenciaBancaria= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteReferenciaBancaria=true;

	public Boolean getActivarFK_IdClienteReferenciaBancaria() {
		return this.activarFK_IdClienteReferenciaBancaria;
	}

	public void setActivarFK_IdClienteReferenciaBancaria(Boolean habilitarResaltar) {
		this.activarFK_IdClienteReferenciaBancaria= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaReferenciaBancaria=true;

	public Boolean getActivarFK_IdEmpresaReferenciaBancaria() {
		return this.activarFK_IdEmpresaReferenciaBancaria;
	}

	public void setActivarFK_IdEmpresaReferenciaBancaria(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaReferenciaBancaria= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoBancoReferenciaBancaria=true;

	public Boolean getActivarFK_IdTipoBancoReferenciaBancaria() {
		return this.activarFK_IdTipoBancoReferenciaBancaria;
	}

	public void setActivarFK_IdTipoBancoReferenciaBancaria(Boolean habilitarResaltar) {
		this.activarFK_IdTipoBancoReferenciaBancaria= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCuentaBancoReferenciaBancaria=true;

	public Boolean getActivarFK_IdTipoCuentaBancoReferenciaBancaria() {
		return this.activarFK_IdTipoCuentaBancoReferenciaBancaria;
	}

	public void setActivarFK_IdTipoCuentaBancoReferenciaBancaria(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCuentaBancoReferenciaBancaria= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProductoBancoReferenciaBancaria=true;

	public Boolean getActivarFK_IdTipoProductoBancoReferenciaBancaria() {
		return this.activarFK_IdTipoProductoBancoReferenciaBancaria;
	}

	public void setActivarFK_IdTipoProductoBancoReferenciaBancaria(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProductoBancoReferenciaBancaria= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoValoracionReferenciaBancaria=true;

	public Boolean getActivarFK_IdTipoValoracionReferenciaBancaria() {
		return this.activarFK_IdTipoValoracionReferenciaBancaria;
	}

	public void setActivarFK_IdTipoValoracionReferenciaBancaria(Boolean habilitarResaltar) {
		this.activarFK_IdTipoValoracionReferenciaBancaria= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteReferenciaBancaria=null;

	public Border getResaltarFK_IdClienteReferenciaBancaria() {
		return this.resaltarFK_IdClienteReferenciaBancaria;
	}

	public void setResaltarFK_IdClienteReferenciaBancaria(Border borderResaltar) {
		this.resaltarFK_IdClienteReferenciaBancaria= borderResaltar;
	}

	public void setResaltarFK_IdClienteReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteReferenciaBancaria= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaReferenciaBancaria=null;

	public Border getResaltarFK_IdEmpresaReferenciaBancaria() {
		return this.resaltarFK_IdEmpresaReferenciaBancaria;
	}

	public void setResaltarFK_IdEmpresaReferenciaBancaria(Border borderResaltar) {
		this.resaltarFK_IdEmpresaReferenciaBancaria= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaReferenciaBancaria= borderResaltar;
	}

	public Border resaltarFK_IdTipoBancoReferenciaBancaria=null;

	public Border getResaltarFK_IdTipoBancoReferenciaBancaria() {
		return this.resaltarFK_IdTipoBancoReferenciaBancaria;
	}

	public void setResaltarFK_IdTipoBancoReferenciaBancaria(Border borderResaltar) {
		this.resaltarFK_IdTipoBancoReferenciaBancaria= borderResaltar;
	}

	public void setResaltarFK_IdTipoBancoReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoBancoReferenciaBancaria= borderResaltar;
	}

	public Border resaltarFK_IdTipoCuentaBancoReferenciaBancaria=null;

	public Border getResaltarFK_IdTipoCuentaBancoReferenciaBancaria() {
		return this.resaltarFK_IdTipoCuentaBancoReferenciaBancaria;
	}

	public void setResaltarFK_IdTipoCuentaBancoReferenciaBancaria(Border borderResaltar) {
		this.resaltarFK_IdTipoCuentaBancoReferenciaBancaria= borderResaltar;
	}

	public void setResaltarFK_IdTipoCuentaBancoReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCuentaBancoReferenciaBancaria= borderResaltar;
	}

	public Border resaltarFK_IdTipoProductoBancoReferenciaBancaria=null;

	public Border getResaltarFK_IdTipoProductoBancoReferenciaBancaria() {
		return this.resaltarFK_IdTipoProductoBancoReferenciaBancaria;
	}

	public void setResaltarFK_IdTipoProductoBancoReferenciaBancaria(Border borderResaltar) {
		this.resaltarFK_IdTipoProductoBancoReferenciaBancaria= borderResaltar;
	}

	public void setResaltarFK_IdTipoProductoBancoReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProductoBancoReferenciaBancaria= borderResaltar;
	}

	public Border resaltarFK_IdTipoValoracionReferenciaBancaria=null;

	public Border getResaltarFK_IdTipoValoracionReferenciaBancaria() {
		return this.resaltarFK_IdTipoValoracionReferenciaBancaria;
	}

	public void setResaltarFK_IdTipoValoracionReferenciaBancaria(Border borderResaltar) {
		this.resaltarFK_IdTipoValoracionReferenciaBancaria= borderResaltar;
	}

	public void setResaltarFK_IdTipoValoracionReferenciaBancaria(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaBancariaBeanSwingJInternalFrame referenciabancariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoValoracionReferenciaBancaria= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}