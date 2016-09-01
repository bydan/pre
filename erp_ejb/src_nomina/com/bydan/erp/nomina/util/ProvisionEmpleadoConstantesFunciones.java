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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.ProvisionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.ProvisionEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ProvisionEmpleadoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProvisionEmpleadoConstantesFunciones extends ProvisionEmpleadoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProvisionEmpleado";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProvisionEmpleado"+ProvisionEmpleadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProvisionEmpleadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProvisionEmpleadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProvisionEmpleadoConstantesFunciones.SCHEMA+"_"+ProvisionEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProvisionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProvisionEmpleadoConstantesFunciones.SCHEMA+"_"+ProvisionEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProvisionEmpleadoConstantesFunciones.SCHEMA+"_"+ProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProvisionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProvisionEmpleadoConstantesFunciones.SCHEMA+"_"+ProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProvisionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProvisionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProvisionEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProvisionEmpleadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProvisionEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProvisionEmpleadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Provision Empleados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Provision Empleado";
	public static final String SCLASSWEBTITULO_LOWER="Provision Empleado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProvisionEmpleado";
	public static final String OBJECTNAME="provisionempleado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="provision_empleado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select provisionempleado from "+ProvisionEmpleadoConstantesFunciones.SPERSISTENCENAME+" provisionempleado";
	public static String QUERYSELECTNATIVE="select "+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".id,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".id_empleado,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".id_estructura,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".id_tipo_provision_empleado,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".id_defi_provision_empleado,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".id_anio,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".id_mes,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".fecha,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".fecha_liquidacion,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".valor_mes,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".valor_paga,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".valor_vacacion,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".valor_liquidacion from "+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME;//+" as "+ProvisionEmpleadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProvisionEmpleadoConstantesFuncionesAdditional provisionempleadoConstantesFuncionesAdditional=null;
	
	public ProvisionEmpleadoConstantesFuncionesAdditional getProvisionEmpleadoConstantesFuncionesAdditional() {
		return this.provisionempleadoConstantesFuncionesAdditional;
	}
	
	public void setProvisionEmpleadoConstantesFuncionesAdditional(ProvisionEmpleadoConstantesFuncionesAdditional provisionempleadoConstantesFuncionesAdditional) {
		try {
			this.provisionempleadoConstantesFuncionesAdditional=provisionempleadoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDTIPOPROVISIONEMPLEADO= "id_tipo_provision_empleado";
    public static final String IDDEFIPROVISIONEMPLEADO= "id_defi_provision_empleado";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String FECHA= "fecha";
    public static final String FECHALIQUIDACION= "fecha_liquidacion";
    public static final String VALORMES= "valor_mes";
    public static final String VALORPAGA= "valor_paga";
    public static final String VALORVACACION= "valor_vacacion";
    public static final String VALORLIQUIDACION= "valor_liquidacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDTIPOPROVISIONEMPLEADO= "Tipo Provision Empleado";
		public static final String LABEL_IDTIPOPROVISIONEMPLEADO_LOWER= "Tipo Provision Empleado";
    	public static final String LABEL_IDDEFIPROVISIONEMPLEADO= "Defi Provision Empleado";
		public static final String LABEL_IDDEFIPROVISIONEMPLEADO_LOWER= "Defi Provision Empleado";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_FECHALIQUIDACION= "Fecha Liquacion";
		public static final String LABEL_FECHALIQUIDACION_LOWER= "Fecha Liquidacion";
    	public static final String LABEL_VALORMES= "Valor Mes";
		public static final String LABEL_VALORMES_LOWER= "Valor Mes";
    	public static final String LABEL_VALORPAGA= "Valor Paga";
		public static final String LABEL_VALORPAGA_LOWER= "Valor Paga";
    	public static final String LABEL_VALORVACACION= "Valor Vacacion";
		public static final String LABEL_VALORVACACION_LOWER= "Valor Vacacion";
    	public static final String LABEL_VALORLIQUIDACION= "Valor Liquacion";
		public static final String LABEL_VALORLIQUIDACION_LOWER= "Valor Liquidacion";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getProvisionEmpleadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProvisionEmpleadoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProvisionEmpleadoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProvisionEmpleadoConstantesFunciones.IDEMPLEADO)) {sLabelColumna=ProvisionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(ProvisionEmpleadoConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=ProvisionEmpleadoConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(ProvisionEmpleadoConstantesFunciones.IDTIPOPROVISIONEMPLEADO)) {sLabelColumna=ProvisionEmpleadoConstantesFunciones.LABEL_IDTIPOPROVISIONEMPLEADO;}
		if(sNombreColumna.equals(ProvisionEmpleadoConstantesFunciones.IDDEFIPROVISIONEMPLEADO)) {sLabelColumna=ProvisionEmpleadoConstantesFunciones.LABEL_IDDEFIPROVISIONEMPLEADO;}
		if(sNombreColumna.equals(ProvisionEmpleadoConstantesFunciones.IDANIO)) {sLabelColumna=ProvisionEmpleadoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(ProvisionEmpleadoConstantesFunciones.IDMES)) {sLabelColumna=ProvisionEmpleadoConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(ProvisionEmpleadoConstantesFunciones.FECHA)) {sLabelColumna=ProvisionEmpleadoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ProvisionEmpleadoConstantesFunciones.FECHALIQUIDACION)) {sLabelColumna=ProvisionEmpleadoConstantesFunciones.LABEL_FECHALIQUIDACION;}
		if(sNombreColumna.equals(ProvisionEmpleadoConstantesFunciones.VALORMES)) {sLabelColumna=ProvisionEmpleadoConstantesFunciones.LABEL_VALORMES;}
		if(sNombreColumna.equals(ProvisionEmpleadoConstantesFunciones.VALORPAGA)) {sLabelColumna=ProvisionEmpleadoConstantesFunciones.LABEL_VALORPAGA;}
		if(sNombreColumna.equals(ProvisionEmpleadoConstantesFunciones.VALORVACACION)) {sLabelColumna=ProvisionEmpleadoConstantesFunciones.LABEL_VALORVACACION;}
		if(sNombreColumna.equals(ProvisionEmpleadoConstantesFunciones.VALORLIQUIDACION)) {sLabelColumna=ProvisionEmpleadoConstantesFunciones.LABEL_VALORLIQUIDACION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProvisionEmpleadoDescripcion(ProvisionEmpleado provisionempleado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(provisionempleado !=null/* && provisionempleado.getId()!=0*/) {
			if(provisionempleado.getId()!=null) {
				sDescripcion=provisionempleado.getId().toString();
			}//provisionempleadoprovisionempleado.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProvisionEmpleadoDescripcionDetallado(ProvisionEmpleado provisionempleado) {
		String sDescripcion="";
			
		sDescripcion+=ProvisionEmpleadoConstantesFunciones.ID+"=";
		sDescripcion+=provisionempleado.getId().toString()+",";
		sDescripcion+=ProvisionEmpleadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=provisionempleado.getVersionRow().toString()+",";
		sDescripcion+=ProvisionEmpleadoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=provisionempleado.getid_empresa().toString()+",";
		sDescripcion+=ProvisionEmpleadoConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=provisionempleado.getid_empleado().toString()+",";
		sDescripcion+=ProvisionEmpleadoConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=provisionempleado.getid_estructura().toString()+",";
		sDescripcion+=ProvisionEmpleadoConstantesFunciones.IDTIPOPROVISIONEMPLEADO+"=";
		sDescripcion+=provisionempleado.getid_tipo_provision_empleado().toString()+",";
		sDescripcion+=ProvisionEmpleadoConstantesFunciones.IDDEFIPROVISIONEMPLEADO+"=";
		sDescripcion+=provisionempleado.getid_defi_provision_empleado().toString()+",";
		sDescripcion+=ProvisionEmpleadoConstantesFunciones.IDANIO+"=";
		sDescripcion+=provisionempleado.getid_anio().toString()+",";
		sDescripcion+=ProvisionEmpleadoConstantesFunciones.IDMES+"=";
		sDescripcion+=provisionempleado.getid_mes().toString()+",";
		sDescripcion+=ProvisionEmpleadoConstantesFunciones.FECHA+"=";
		sDescripcion+=provisionempleado.getfecha().toString()+",";
		sDescripcion+=ProvisionEmpleadoConstantesFunciones.FECHALIQUIDACION+"=";
		sDescripcion+=provisionempleado.getfecha_liquidacion().toString()+",";
		sDescripcion+=ProvisionEmpleadoConstantesFunciones.VALORMES+"=";
		sDescripcion+=provisionempleado.getvalor_mes().toString()+",";
		sDescripcion+=ProvisionEmpleadoConstantesFunciones.VALORPAGA+"=";
		sDescripcion+=provisionempleado.getvalor_paga().toString()+",";
		sDescripcion+=ProvisionEmpleadoConstantesFunciones.VALORVACACION+"=";
		sDescripcion+=provisionempleado.getvalor_vacacion().toString()+",";
		sDescripcion+=ProvisionEmpleadoConstantesFunciones.VALORLIQUIDACION+"=";
		sDescripcion+=provisionempleado.getvalor_liquidacion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProvisionEmpleadoDescripcion(ProvisionEmpleado provisionempleado,String sValor) throws Exception {			
		if(provisionempleado !=null) {
			//provisionempleadoprovisionempleado.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
		}

		return sDescripcion;
	}

	public static String getTipoProvisionEmpleadoDescripcion(TipoProvisionEmpleado tipoprovisionempleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprovisionempleado!=null/*&&tipoprovisionempleado.getId()>0*/) {
			sDescripcion=TipoProvisionEmpleadoConstantesFunciones.getTipoProvisionEmpleadoDescripcion(tipoprovisionempleado);
		}

		return sDescripcion;
	}

	public static String getDefiProvisionEmpleadoDescripcion(DefiProvisionEmpleado defiprovisionempleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(defiprovisionempleado!=null/*&&defiprovisionempleado.getId()>0*/) {
			sDescripcion=DefiProvisionEmpleadoConstantesFunciones.getDefiProvisionEmpleadoDescripcion(defiprovisionempleado);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdDefiProvisionEmpleado")) {
			sNombreIndice="Tipo=  Por Defi Provision Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdTipoProvisionEmpleado")) {
			sNombreIndice="Tipo=  Por Tipo Provision Empleado";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDefiProvisionEmpleado(Long id_defi_provision_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_defi_provision_empleado!=null) {sDetalleIndice+=" Codigo Unico De Defi Provision Empleado="+id_defi_provision_empleado.toString();} 

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

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoProvisionEmpleado(Long id_tipo_provision_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_provision_empleado!=null) {sDetalleIndice+=" Codigo Unico De Tipo Provision Empleado="+id_tipo_provision_empleado.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProvisionEmpleado(ProvisionEmpleado provisionempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProvisionEmpleados(List<ProvisionEmpleado> provisionempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProvisionEmpleado provisionempleado: provisionempleados) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProvisionEmpleado(ProvisionEmpleado provisionempleado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && provisionempleado.getConCambioAuxiliar()) {
			provisionempleado.setIsDeleted(provisionempleado.getIsDeletedAuxiliar());	
			provisionempleado.setIsNew(provisionempleado.getIsNewAuxiliar());	
			provisionempleado.setIsChanged(provisionempleado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			provisionempleado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			provisionempleado.setIsDeletedAuxiliar(false);	
			provisionempleado.setIsNewAuxiliar(false);	
			provisionempleado.setIsChangedAuxiliar(false);
			
			provisionempleado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProvisionEmpleados(List<ProvisionEmpleado> provisionempleados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProvisionEmpleado provisionempleado : provisionempleados) {
			if(conAsignarBase && provisionempleado.getConCambioAuxiliar()) {
				provisionempleado.setIsDeleted(provisionempleado.getIsDeletedAuxiliar());	
				provisionempleado.setIsNew(provisionempleado.getIsNewAuxiliar());	
				provisionempleado.setIsChanged(provisionempleado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				provisionempleado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				provisionempleado.setIsDeletedAuxiliar(false);	
				provisionempleado.setIsNewAuxiliar(false);	
				provisionempleado.setIsChangedAuxiliar(false);
				
				provisionempleado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProvisionEmpleado(ProvisionEmpleado provisionempleado,Boolean conEnteros) throws Exception  {
		provisionempleado.setvalor_mes(0.0);
		provisionempleado.setvalor_paga(0.0);
		provisionempleado.setvalor_vacacion(0.0);
		provisionempleado.setvalor_liquidacion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProvisionEmpleados(List<ProvisionEmpleado> provisionempleados,Boolean conEnteros) throws Exception  {
		
		for(ProvisionEmpleado provisionempleado: provisionempleados) {
			provisionempleado.setvalor_mes(0.0);
			provisionempleado.setvalor_paga(0.0);
			provisionempleado.setvalor_vacacion(0.0);
			provisionempleado.setvalor_liquidacion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProvisionEmpleado(List<ProvisionEmpleado> provisionempleados,ProvisionEmpleado provisionempleadoAux) throws Exception  {
		ProvisionEmpleadoConstantesFunciones.InicializarValoresProvisionEmpleado(provisionempleadoAux,true);
		
		for(ProvisionEmpleado provisionempleado: provisionempleados) {
			if(provisionempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			provisionempleadoAux.setvalor_mes(provisionempleadoAux.getvalor_mes()+provisionempleado.getvalor_mes());			
			provisionempleadoAux.setvalor_paga(provisionempleadoAux.getvalor_paga()+provisionempleado.getvalor_paga());			
			provisionempleadoAux.setvalor_vacacion(provisionempleadoAux.getvalor_vacacion()+provisionempleado.getvalor_vacacion());			
			provisionempleadoAux.setvalor_liquidacion(provisionempleadoAux.getvalor_liquidacion()+provisionempleado.getvalor_liquidacion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProvisionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProvisionEmpleadoConstantesFunciones.getArrayColumnasGlobalesProvisionEmpleado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProvisionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProvisionEmpleadoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProvisionEmpleadoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProvisionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProvisionEmpleado> provisionempleados,ProvisionEmpleado provisionempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProvisionEmpleado provisionempleadoAux: provisionempleados) {
			if(provisionempleadoAux!=null && provisionempleado!=null) {
				if((provisionempleadoAux.getId()==null && provisionempleado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(provisionempleadoAux.getId()!=null && provisionempleado.getId()!=null){
					if(provisionempleadoAux.getId().equals(provisionempleado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProvisionEmpleado(List<ProvisionEmpleado> provisionempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_mesTotal=0.0;
		Double valor_pagaTotal=0.0;
		Double valor_vacacionTotal=0.0;
		Double valor_liquidacionTotal=0.0;
	
		for(ProvisionEmpleado provisionempleado: provisionempleados) {			
			if(provisionempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_mesTotal+=provisionempleado.getvalor_mes();
			valor_pagaTotal+=provisionempleado.getvalor_paga();
			valor_vacacionTotal+=provisionempleado.getvalor_vacacion();
			valor_liquidacionTotal+=provisionempleado.getvalor_liquidacion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProvisionEmpleadoConstantesFunciones.VALORMES);
		datoGeneral.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_VALORMES);
		datoGeneral.setdValorDouble(valor_mesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProvisionEmpleadoConstantesFunciones.VALORPAGA);
		datoGeneral.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_VALORPAGA);
		datoGeneral.setdValorDouble(valor_pagaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProvisionEmpleadoConstantesFunciones.VALORVACACION);
		datoGeneral.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_VALORVACACION);
		datoGeneral.setdValorDouble(valor_vacacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProvisionEmpleadoConstantesFunciones.VALORLIQUIDACION);
		datoGeneral.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_VALORLIQUIDACION);
		datoGeneral.setdValorDouble(valor_liquidacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProvisionEmpleado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProvisionEmpleadoConstantesFunciones.LABEL_ID, ProvisionEmpleadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvisionEmpleadoConstantesFunciones.LABEL_VERSIONROW, ProvisionEmpleadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvisionEmpleadoConstantesFunciones.LABEL_IDEMPRESA, ProvisionEmpleadoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvisionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO, ProvisionEmpleadoConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvisionEmpleadoConstantesFunciones.LABEL_IDESTRUCTURA, ProvisionEmpleadoConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvisionEmpleadoConstantesFunciones.LABEL_IDTIPOPROVISIONEMPLEADO, ProvisionEmpleadoConstantesFunciones.IDTIPOPROVISIONEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvisionEmpleadoConstantesFunciones.LABEL_IDDEFIPROVISIONEMPLEADO, ProvisionEmpleadoConstantesFunciones.IDDEFIPROVISIONEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvisionEmpleadoConstantesFunciones.LABEL_IDANIO, ProvisionEmpleadoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvisionEmpleadoConstantesFunciones.LABEL_IDMES, ProvisionEmpleadoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvisionEmpleadoConstantesFunciones.LABEL_FECHA, ProvisionEmpleadoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvisionEmpleadoConstantesFunciones.LABEL_FECHALIQUIDACION, ProvisionEmpleadoConstantesFunciones.FECHALIQUIDACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvisionEmpleadoConstantesFunciones.LABEL_VALORMES, ProvisionEmpleadoConstantesFunciones.VALORMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvisionEmpleadoConstantesFunciones.LABEL_VALORPAGA, ProvisionEmpleadoConstantesFunciones.VALORPAGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvisionEmpleadoConstantesFunciones.LABEL_VALORVACACION, ProvisionEmpleadoConstantesFunciones.VALORVACACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvisionEmpleadoConstantesFunciones.LABEL_VALORLIQUIDACION, ProvisionEmpleadoConstantesFunciones.VALORLIQUIDACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProvisionEmpleado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProvisionEmpleadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvisionEmpleadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvisionEmpleadoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvisionEmpleadoConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvisionEmpleadoConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvisionEmpleadoConstantesFunciones.IDTIPOPROVISIONEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvisionEmpleadoConstantesFunciones.IDDEFIPROVISIONEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvisionEmpleadoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvisionEmpleadoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvisionEmpleadoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvisionEmpleadoConstantesFunciones.FECHALIQUIDACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvisionEmpleadoConstantesFunciones.VALORMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvisionEmpleadoConstantesFunciones.VALORPAGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvisionEmpleadoConstantesFunciones.VALORVACACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvisionEmpleadoConstantesFunciones.VALORLIQUIDACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProvisionEmpleado() throws Exception  {
		return ProvisionEmpleadoConstantesFunciones.getTiposSeleccionarProvisionEmpleado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProvisionEmpleado(Boolean conFk) throws Exception  {
		return ProvisionEmpleadoConstantesFunciones.getTiposSeleccionarProvisionEmpleado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProvisionEmpleado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProvisionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProvisionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProvisionEmpleadoConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProvisionEmpleadoConstantesFunciones.LABEL_IDTIPOPROVISIONEMPLEADO);
			reporte.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_IDTIPOPROVISIONEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProvisionEmpleadoConstantesFunciones.LABEL_IDDEFIPROVISIONEMPLEADO);
			reporte.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_IDDEFIPROVISIONEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProvisionEmpleadoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProvisionEmpleadoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProvisionEmpleadoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProvisionEmpleadoConstantesFunciones.LABEL_FECHALIQUIDACION);
			reporte.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_FECHALIQUIDACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProvisionEmpleadoConstantesFunciones.LABEL_VALORMES);
			reporte.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_VALORMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProvisionEmpleadoConstantesFunciones.LABEL_VALORPAGA);
			reporte.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_VALORPAGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProvisionEmpleadoConstantesFunciones.LABEL_VALORVACACION);
			reporte.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_VALORVACACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProvisionEmpleadoConstantesFunciones.LABEL_VALORLIQUIDACION);
			reporte.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_VALORLIQUIDACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProvisionEmpleado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProvisionEmpleado(ProvisionEmpleado provisionempleadoAux) throws Exception {
		
			provisionempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(provisionempleadoAux.getEmpresa()));
			provisionempleadoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(provisionempleadoAux.getEmpleado()));
			provisionempleadoAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(provisionempleadoAux.getEstructura()));
			provisionempleadoAux.settipoprovisionempleado_descripcion(TipoProvisionEmpleadoConstantesFunciones.getTipoProvisionEmpleadoDescripcion(provisionempleadoAux.getTipoProvisionEmpleado()));
			provisionempleadoAux.setdefiprovisionempleado_descripcion(DefiProvisionEmpleadoConstantesFunciones.getDefiProvisionEmpleadoDescripcion(provisionempleadoAux.getDefiProvisionEmpleado()));
			provisionempleadoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(provisionempleadoAux.getAnio()));
			provisionempleadoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(provisionempleadoAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProvisionEmpleado(List<ProvisionEmpleado> provisionempleadosTemp) throws Exception {
		for(ProvisionEmpleado provisionempleadoAux:provisionempleadosTemp) {
			
			provisionempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(provisionempleadoAux.getEmpresa()));
			provisionempleadoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(provisionempleadoAux.getEmpleado()));
			provisionempleadoAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(provisionempleadoAux.getEstructura()));
			provisionempleadoAux.settipoprovisionempleado_descripcion(TipoProvisionEmpleadoConstantesFunciones.getTipoProvisionEmpleadoDescripcion(provisionempleadoAux.getTipoProvisionEmpleado()));
			provisionempleadoAux.setdefiprovisionempleado_descripcion(DefiProvisionEmpleadoConstantesFunciones.getDefiProvisionEmpleadoDescripcion(provisionempleadoAux.getDefiProvisionEmpleado()));
			provisionempleadoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(provisionempleadoAux.getAnio()));
			provisionempleadoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(provisionempleadoAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProvisionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(TipoProvisionEmpleado.class));
				classes.add(new Classe(DefiProvisionEmpleado.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProvisionEmpleado.class)) {
						classes.add(new Classe(TipoProvisionEmpleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DefiProvisionEmpleado.class)) {
						classes.add(new Classe(DefiProvisionEmpleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProvisionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(TipoProvisionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProvisionEmpleado.class)); continue;
					}

					if(DefiProvisionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DefiProvisionEmpleado.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(TipoProvisionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProvisionEmpleado.class)); continue;
					}

					if(DefiProvisionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DefiProvisionEmpleado.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProvisionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProvisionEmpleadoConstantesFunciones.getClassesRelationshipsOfProvisionEmpleado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProvisionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProvisionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProvisionEmpleadoConstantesFunciones.getClassesRelationshipsFromStringsOfProvisionEmpleado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProvisionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProvisionEmpleado provisionempleado,List<ProvisionEmpleado> provisionempleados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProvisionEmpleado provisionempleadoEncontrado=null;
			
			for(ProvisionEmpleado provisionempleadoLocal:provisionempleados) {
				if(provisionempleadoLocal.getId().equals(provisionempleado.getId())) {
					provisionempleadoEncontrado=provisionempleadoLocal;
					
					provisionempleadoLocal.setIsChanged(provisionempleado.getIsChanged());
					provisionempleadoLocal.setIsNew(provisionempleado.getIsNew());
					provisionempleadoLocal.setIsDeleted(provisionempleado.getIsDeleted());
					
					provisionempleadoLocal.setGeneralEntityOriginal(provisionempleado.getGeneralEntityOriginal());
					
					provisionempleadoLocal.setId(provisionempleado.getId());	
					provisionempleadoLocal.setVersionRow(provisionempleado.getVersionRow());	
					provisionempleadoLocal.setid_empresa(provisionempleado.getid_empresa());	
					provisionempleadoLocal.setid_empleado(provisionempleado.getid_empleado());	
					provisionempleadoLocal.setid_estructura(provisionempleado.getid_estructura());	
					provisionempleadoLocal.setid_tipo_provision_empleado(provisionempleado.getid_tipo_provision_empleado());	
					provisionempleadoLocal.setid_defi_provision_empleado(provisionempleado.getid_defi_provision_empleado());	
					provisionempleadoLocal.setid_anio(provisionempleado.getid_anio());	
					provisionempleadoLocal.setid_mes(provisionempleado.getid_mes());	
					provisionempleadoLocal.setfecha(provisionempleado.getfecha());	
					provisionempleadoLocal.setfecha_liquidacion(provisionempleado.getfecha_liquidacion());	
					provisionempleadoLocal.setvalor_mes(provisionempleado.getvalor_mes());	
					provisionempleadoLocal.setvalor_paga(provisionempleado.getvalor_paga());	
					provisionempleadoLocal.setvalor_vacacion(provisionempleado.getvalor_vacacion());	
					provisionempleadoLocal.setvalor_liquidacion(provisionempleado.getvalor_liquidacion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!provisionempleado.getIsDeleted()) {
				if(!existe) {
					provisionempleados.add(provisionempleado);
				}
			} else {
				if(provisionempleadoEncontrado!=null && permiteQuitar)  {
					provisionempleados.remove(provisionempleadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProvisionEmpleado provisionempleado,List<ProvisionEmpleado> provisionempleados) throws Exception {
		try	{			
			for(ProvisionEmpleado provisionempleadoLocal:provisionempleados) {
				if(provisionempleadoLocal.getId().equals(provisionempleado.getId())) {
					provisionempleadoLocal.setIsSelected(provisionempleado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProvisionEmpleado(List<ProvisionEmpleado> provisionempleadosAux) throws Exception {
		//this.provisionempleadosAux=provisionempleadosAux;
		
		for(ProvisionEmpleado provisionempleadoAux:provisionempleadosAux) {
			if(provisionempleadoAux.getIsChanged()) {
				provisionempleadoAux.setIsChanged(false);
			}		
			
			if(provisionempleadoAux.getIsNew()) {
				provisionempleadoAux.setIsNew(false);
			}	
			
			if(provisionempleadoAux.getIsDeleted()) {
				provisionempleadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProvisionEmpleado(ProvisionEmpleado provisionempleadoAux) throws Exception {
		//this.provisionempleadoAux=provisionempleadoAux;
		
			if(provisionempleadoAux.getIsChanged()) {
				provisionempleadoAux.setIsChanged(false);
			}		
			
			if(provisionempleadoAux.getIsNew()) {
				provisionempleadoAux.setIsNew(false);
			}	
			
			if(provisionempleadoAux.getIsDeleted()) {
				provisionempleadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProvisionEmpleado provisionempleadoAsignar,ProvisionEmpleado provisionempleado) throws Exception {
		provisionempleadoAsignar.setId(provisionempleado.getId());	
		provisionempleadoAsignar.setVersionRow(provisionempleado.getVersionRow());	
		provisionempleadoAsignar.setid_empresa(provisionempleado.getid_empresa());
		provisionempleadoAsignar.setempresa_descripcion(provisionempleado.getempresa_descripcion());	
		provisionempleadoAsignar.setid_empleado(provisionempleado.getid_empleado());
		provisionempleadoAsignar.setempleado_descripcion(provisionempleado.getempleado_descripcion());	
		provisionempleadoAsignar.setid_estructura(provisionempleado.getid_estructura());
		provisionempleadoAsignar.setestructura_descripcion(provisionempleado.getestructura_descripcion());	
		provisionempleadoAsignar.setid_tipo_provision_empleado(provisionempleado.getid_tipo_provision_empleado());
		provisionempleadoAsignar.settipoprovisionempleado_descripcion(provisionempleado.gettipoprovisionempleado_descripcion());	
		provisionempleadoAsignar.setid_defi_provision_empleado(provisionempleado.getid_defi_provision_empleado());
		provisionempleadoAsignar.setdefiprovisionempleado_descripcion(provisionempleado.getdefiprovisionempleado_descripcion());	
		provisionempleadoAsignar.setid_anio(provisionempleado.getid_anio());
		provisionempleadoAsignar.setanio_descripcion(provisionempleado.getanio_descripcion());	
		provisionempleadoAsignar.setid_mes(provisionempleado.getid_mes());
		provisionempleadoAsignar.setmes_descripcion(provisionempleado.getmes_descripcion());	
		provisionempleadoAsignar.setfecha(provisionempleado.getfecha());	
		provisionempleadoAsignar.setfecha_liquidacion(provisionempleado.getfecha_liquidacion());	
		provisionempleadoAsignar.setvalor_mes(provisionempleado.getvalor_mes());	
		provisionempleadoAsignar.setvalor_paga(provisionempleado.getvalor_paga());	
		provisionempleadoAsignar.setvalor_vacacion(provisionempleado.getvalor_vacacion());	
		provisionempleadoAsignar.setvalor_liquidacion(provisionempleado.getvalor_liquidacion());	
	}
	
	public static void inicializarProvisionEmpleado(ProvisionEmpleado provisionempleado) throws Exception {
		try {
				provisionempleado.setId(0L);	
					
				provisionempleado.setid_empresa(-1L);	
				provisionempleado.setid_empleado(-1L);	
				provisionempleado.setid_estructura(-1L);	
				provisionempleado.setid_tipo_provision_empleado(-1L);	
				provisionempleado.setid_defi_provision_empleado(-1L);	
				provisionempleado.setid_anio(null);	
				provisionempleado.setid_mes(null);	
				provisionempleado.setfecha(new Date());	
				provisionempleado.setfecha_liquidacion(new Date());	
				provisionempleado.setvalor_mes(0.0);	
				provisionempleado.setvalor_paga(0.0);	
				provisionempleado.setvalor_vacacion(0.0);	
				provisionempleado.setvalor_liquidacion(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProvisionEmpleado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProvisionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProvisionEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProvisionEmpleadoConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProvisionEmpleadoConstantesFunciones.LABEL_IDTIPOPROVISIONEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProvisionEmpleadoConstantesFunciones.LABEL_IDDEFIPROVISIONEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProvisionEmpleadoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProvisionEmpleadoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProvisionEmpleadoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProvisionEmpleadoConstantesFunciones.LABEL_FECHALIQUIDACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProvisionEmpleadoConstantesFunciones.LABEL_VALORMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProvisionEmpleadoConstantesFunciones.LABEL_VALORPAGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProvisionEmpleadoConstantesFunciones.LABEL_VALORVACACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProvisionEmpleadoConstantesFunciones.LABEL_VALORLIQUIDACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProvisionEmpleado(String sTipo,Row row,Workbook workbook,ProvisionEmpleado provisionempleado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(provisionempleado.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(provisionempleado.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(provisionempleado.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(provisionempleado.gettipoprovisionempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(provisionempleado.getdefiprovisionempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(provisionempleado.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(provisionempleado.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(provisionempleado.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(provisionempleado.getfecha_liquidacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(provisionempleado.getvalor_mes());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(provisionempleado.getvalor_paga());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(provisionempleado.getvalor_vacacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(provisionempleado.getvalor_liquidacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProvisionEmpleado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProvisionEmpleado() {
		return this.sFinalQueryProvisionEmpleado;
	}
	
	public void setsFinalQueryProvisionEmpleado(String sFinalQueryProvisionEmpleado) {
		this.sFinalQueryProvisionEmpleado= sFinalQueryProvisionEmpleado;
	}
	
	public Border resaltarSeleccionarProvisionEmpleado=null;
	
	public Border setResaltarSeleccionarProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//provisionempleadoBeanSwingJInternalFrame.jTtoolBarProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProvisionEmpleado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProvisionEmpleado() {
		return this.resaltarSeleccionarProvisionEmpleado;
	}
	
	public void setResaltarSeleccionarProvisionEmpleado(Border borderResaltarSeleccionarProvisionEmpleado) {
		this.resaltarSeleccionarProvisionEmpleado= borderResaltarSeleccionarProvisionEmpleado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProvisionEmpleado=null;
	public Boolean mostraridProvisionEmpleado=true;
	public Boolean activaridProvisionEmpleado=true;

	public Border resaltarid_empresaProvisionEmpleado=null;
	public Boolean mostrarid_empresaProvisionEmpleado=true;
	public Boolean activarid_empresaProvisionEmpleado=true;
	public Boolean cargarid_empresaProvisionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProvisionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_empleadoProvisionEmpleado=null;
	public Boolean mostrarid_empleadoProvisionEmpleado=true;
	public Boolean activarid_empleadoProvisionEmpleado=true;
	public Boolean cargarid_empleadoProvisionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoProvisionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_estructuraProvisionEmpleado=null;
	public Boolean mostrarid_estructuraProvisionEmpleado=true;
	public Boolean activarid_estructuraProvisionEmpleado=true;
	public Boolean cargarid_estructuraProvisionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraProvisionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_tipo_provision_empleadoProvisionEmpleado=null;
	public Boolean mostrarid_tipo_provision_empleadoProvisionEmpleado=true;
	public Boolean activarid_tipo_provision_empleadoProvisionEmpleado=true;
	public Boolean cargarid_tipo_provision_empleadoProvisionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_provision_empleadoProvisionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_defi_provision_empleadoProvisionEmpleado=null;
	public Boolean mostrarid_defi_provision_empleadoProvisionEmpleado=true;
	public Boolean activarid_defi_provision_empleadoProvisionEmpleado=true;
	public Boolean cargarid_defi_provision_empleadoProvisionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_defi_provision_empleadoProvisionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_anioProvisionEmpleado=null;
	public Boolean mostrarid_anioProvisionEmpleado=true;
	public Boolean activarid_anioProvisionEmpleado=true;
	public Boolean cargarid_anioProvisionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioProvisionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_mesProvisionEmpleado=null;
	public Boolean mostrarid_mesProvisionEmpleado=true;
	public Boolean activarid_mesProvisionEmpleado=true;
	public Boolean cargarid_mesProvisionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesProvisionEmpleado=false;//ConEventDepend=true

	public Border resaltarfechaProvisionEmpleado=null;
	public Boolean mostrarfechaProvisionEmpleado=true;
	public Boolean activarfechaProvisionEmpleado=false;

	public Border resaltarfecha_liquidacionProvisionEmpleado=null;
	public Boolean mostrarfecha_liquidacionProvisionEmpleado=true;
	public Boolean activarfecha_liquidacionProvisionEmpleado=false;

	public Border resaltarvalor_mesProvisionEmpleado=null;
	public Boolean mostrarvalor_mesProvisionEmpleado=true;
	public Boolean activarvalor_mesProvisionEmpleado=true;

	public Border resaltarvalor_pagaProvisionEmpleado=null;
	public Boolean mostrarvalor_pagaProvisionEmpleado=true;
	public Boolean activarvalor_pagaProvisionEmpleado=true;

	public Border resaltarvalor_vacacionProvisionEmpleado=null;
	public Boolean mostrarvalor_vacacionProvisionEmpleado=true;
	public Boolean activarvalor_vacacionProvisionEmpleado=true;

	public Border resaltarvalor_liquidacionProvisionEmpleado=null;
	public Boolean mostrarvalor_liquidacionProvisionEmpleado=true;
	public Boolean activarvalor_liquidacionProvisionEmpleado=true;

	
	

	public Border setResaltaridProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provisionempleadoBeanSwingJInternalFrame.jTtoolBarProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltaridProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProvisionEmpleado() {
		return this.resaltaridProvisionEmpleado;
	}

	public void setResaltaridProvisionEmpleado(Border borderResaltar) {
		this.resaltaridProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostraridProvisionEmpleado() {
		return this.mostraridProvisionEmpleado;
	}

	public void setMostraridProvisionEmpleado(Boolean mostraridProvisionEmpleado) {
		this.mostraridProvisionEmpleado= mostraridProvisionEmpleado;
	}

	public Boolean getActivaridProvisionEmpleado() {
		return this.activaridProvisionEmpleado;
	}

	public void setActivaridProvisionEmpleado(Boolean activaridProvisionEmpleado) {
		this.activaridProvisionEmpleado= activaridProvisionEmpleado;
	}

	public Border setResaltarid_empresaProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provisionempleadoBeanSwingJInternalFrame.jTtoolBarProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empresaProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProvisionEmpleado() {
		return this.resaltarid_empresaProvisionEmpleado;
	}

	public void setResaltarid_empresaProvisionEmpleado(Border borderResaltar) {
		this.resaltarid_empresaProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empresaProvisionEmpleado() {
		return this.mostrarid_empresaProvisionEmpleado;
	}

	public void setMostrarid_empresaProvisionEmpleado(Boolean mostrarid_empresaProvisionEmpleado) {
		this.mostrarid_empresaProvisionEmpleado= mostrarid_empresaProvisionEmpleado;
	}

	public Boolean getActivarid_empresaProvisionEmpleado() {
		return this.activarid_empresaProvisionEmpleado;
	}

	public void setActivarid_empresaProvisionEmpleado(Boolean activarid_empresaProvisionEmpleado) {
		this.activarid_empresaProvisionEmpleado= activarid_empresaProvisionEmpleado;
	}

	public Boolean getCargarid_empresaProvisionEmpleado() {
		return this.cargarid_empresaProvisionEmpleado;
	}

	public void setCargarid_empresaProvisionEmpleado(Boolean cargarid_empresaProvisionEmpleado) {
		this.cargarid_empresaProvisionEmpleado= cargarid_empresaProvisionEmpleado;
	}

	public Border setResaltarid_empleadoProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provisionempleadoBeanSwingJInternalFrame.jTtoolBarProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empleadoProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoProvisionEmpleado() {
		return this.resaltarid_empleadoProvisionEmpleado;
	}

	public void setResaltarid_empleadoProvisionEmpleado(Border borderResaltar) {
		this.resaltarid_empleadoProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empleadoProvisionEmpleado() {
		return this.mostrarid_empleadoProvisionEmpleado;
	}

	public void setMostrarid_empleadoProvisionEmpleado(Boolean mostrarid_empleadoProvisionEmpleado) {
		this.mostrarid_empleadoProvisionEmpleado= mostrarid_empleadoProvisionEmpleado;
	}

	public Boolean getActivarid_empleadoProvisionEmpleado() {
		return this.activarid_empleadoProvisionEmpleado;
	}

	public void setActivarid_empleadoProvisionEmpleado(Boolean activarid_empleadoProvisionEmpleado) {
		this.activarid_empleadoProvisionEmpleado= activarid_empleadoProvisionEmpleado;
	}

	public Boolean getCargarid_empleadoProvisionEmpleado() {
		return this.cargarid_empleadoProvisionEmpleado;
	}

	public void setCargarid_empleadoProvisionEmpleado(Boolean cargarid_empleadoProvisionEmpleado) {
		this.cargarid_empleadoProvisionEmpleado= cargarid_empleadoProvisionEmpleado;
	}

	public Border setResaltarid_estructuraProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provisionempleadoBeanSwingJInternalFrame.jTtoolBarProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_estructuraProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraProvisionEmpleado() {
		return this.resaltarid_estructuraProvisionEmpleado;
	}

	public void setResaltarid_estructuraProvisionEmpleado(Border borderResaltar) {
		this.resaltarid_estructuraProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_estructuraProvisionEmpleado() {
		return this.mostrarid_estructuraProvisionEmpleado;
	}

	public void setMostrarid_estructuraProvisionEmpleado(Boolean mostrarid_estructuraProvisionEmpleado) {
		this.mostrarid_estructuraProvisionEmpleado= mostrarid_estructuraProvisionEmpleado;
	}

	public Boolean getActivarid_estructuraProvisionEmpleado() {
		return this.activarid_estructuraProvisionEmpleado;
	}

	public void setActivarid_estructuraProvisionEmpleado(Boolean activarid_estructuraProvisionEmpleado) {
		this.activarid_estructuraProvisionEmpleado= activarid_estructuraProvisionEmpleado;
	}

	public Boolean getCargarid_estructuraProvisionEmpleado() {
		return this.cargarid_estructuraProvisionEmpleado;
	}

	public void setCargarid_estructuraProvisionEmpleado(Boolean cargarid_estructuraProvisionEmpleado) {
		this.cargarid_estructuraProvisionEmpleado= cargarid_estructuraProvisionEmpleado;
	}

	public Border setResaltarid_tipo_provision_empleadoProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provisionempleadoBeanSwingJInternalFrame.jTtoolBarProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_tipo_provision_empleadoProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_provision_empleadoProvisionEmpleado() {
		return this.resaltarid_tipo_provision_empleadoProvisionEmpleado;
	}

	public void setResaltarid_tipo_provision_empleadoProvisionEmpleado(Border borderResaltar) {
		this.resaltarid_tipo_provision_empleadoProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_tipo_provision_empleadoProvisionEmpleado() {
		return this.mostrarid_tipo_provision_empleadoProvisionEmpleado;
	}

	public void setMostrarid_tipo_provision_empleadoProvisionEmpleado(Boolean mostrarid_tipo_provision_empleadoProvisionEmpleado) {
		this.mostrarid_tipo_provision_empleadoProvisionEmpleado= mostrarid_tipo_provision_empleadoProvisionEmpleado;
	}

	public Boolean getActivarid_tipo_provision_empleadoProvisionEmpleado() {
		return this.activarid_tipo_provision_empleadoProvisionEmpleado;
	}

	public void setActivarid_tipo_provision_empleadoProvisionEmpleado(Boolean activarid_tipo_provision_empleadoProvisionEmpleado) {
		this.activarid_tipo_provision_empleadoProvisionEmpleado= activarid_tipo_provision_empleadoProvisionEmpleado;
	}

	public Boolean getCargarid_tipo_provision_empleadoProvisionEmpleado() {
		return this.cargarid_tipo_provision_empleadoProvisionEmpleado;
	}

	public void setCargarid_tipo_provision_empleadoProvisionEmpleado(Boolean cargarid_tipo_provision_empleadoProvisionEmpleado) {
		this.cargarid_tipo_provision_empleadoProvisionEmpleado= cargarid_tipo_provision_empleadoProvisionEmpleado;
	}

	public Border setResaltarid_defi_provision_empleadoProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provisionempleadoBeanSwingJInternalFrame.jTtoolBarProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_defi_provision_empleadoProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_defi_provision_empleadoProvisionEmpleado() {
		return this.resaltarid_defi_provision_empleadoProvisionEmpleado;
	}

	public void setResaltarid_defi_provision_empleadoProvisionEmpleado(Border borderResaltar) {
		this.resaltarid_defi_provision_empleadoProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_defi_provision_empleadoProvisionEmpleado() {
		return this.mostrarid_defi_provision_empleadoProvisionEmpleado;
	}

	public void setMostrarid_defi_provision_empleadoProvisionEmpleado(Boolean mostrarid_defi_provision_empleadoProvisionEmpleado) {
		this.mostrarid_defi_provision_empleadoProvisionEmpleado= mostrarid_defi_provision_empleadoProvisionEmpleado;
	}

	public Boolean getActivarid_defi_provision_empleadoProvisionEmpleado() {
		return this.activarid_defi_provision_empleadoProvisionEmpleado;
	}

	public void setActivarid_defi_provision_empleadoProvisionEmpleado(Boolean activarid_defi_provision_empleadoProvisionEmpleado) {
		this.activarid_defi_provision_empleadoProvisionEmpleado= activarid_defi_provision_empleadoProvisionEmpleado;
	}

	public Boolean getCargarid_defi_provision_empleadoProvisionEmpleado() {
		return this.cargarid_defi_provision_empleadoProvisionEmpleado;
	}

	public void setCargarid_defi_provision_empleadoProvisionEmpleado(Boolean cargarid_defi_provision_empleadoProvisionEmpleado) {
		this.cargarid_defi_provision_empleadoProvisionEmpleado= cargarid_defi_provision_empleadoProvisionEmpleado;
	}

	public Border setResaltarid_anioProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provisionempleadoBeanSwingJInternalFrame.jTtoolBarProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_anioProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioProvisionEmpleado() {
		return this.resaltarid_anioProvisionEmpleado;
	}

	public void setResaltarid_anioProvisionEmpleado(Border borderResaltar) {
		this.resaltarid_anioProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_anioProvisionEmpleado() {
		return this.mostrarid_anioProvisionEmpleado;
	}

	public void setMostrarid_anioProvisionEmpleado(Boolean mostrarid_anioProvisionEmpleado) {
		this.mostrarid_anioProvisionEmpleado= mostrarid_anioProvisionEmpleado;
	}

	public Boolean getActivarid_anioProvisionEmpleado() {
		return this.activarid_anioProvisionEmpleado;
	}

	public void setActivarid_anioProvisionEmpleado(Boolean activarid_anioProvisionEmpleado) {
		this.activarid_anioProvisionEmpleado= activarid_anioProvisionEmpleado;
	}

	public Boolean getCargarid_anioProvisionEmpleado() {
		return this.cargarid_anioProvisionEmpleado;
	}

	public void setCargarid_anioProvisionEmpleado(Boolean cargarid_anioProvisionEmpleado) {
		this.cargarid_anioProvisionEmpleado= cargarid_anioProvisionEmpleado;
	}

	public Border setResaltarid_mesProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provisionempleadoBeanSwingJInternalFrame.jTtoolBarProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_mesProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesProvisionEmpleado() {
		return this.resaltarid_mesProvisionEmpleado;
	}

	public void setResaltarid_mesProvisionEmpleado(Border borderResaltar) {
		this.resaltarid_mesProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_mesProvisionEmpleado() {
		return this.mostrarid_mesProvisionEmpleado;
	}

	public void setMostrarid_mesProvisionEmpleado(Boolean mostrarid_mesProvisionEmpleado) {
		this.mostrarid_mesProvisionEmpleado= mostrarid_mesProvisionEmpleado;
	}

	public Boolean getActivarid_mesProvisionEmpleado() {
		return this.activarid_mesProvisionEmpleado;
	}

	public void setActivarid_mesProvisionEmpleado(Boolean activarid_mesProvisionEmpleado) {
		this.activarid_mesProvisionEmpleado= activarid_mesProvisionEmpleado;
	}

	public Boolean getCargarid_mesProvisionEmpleado() {
		return this.cargarid_mesProvisionEmpleado;
	}

	public void setCargarid_mesProvisionEmpleado(Boolean cargarid_mesProvisionEmpleado) {
		this.cargarid_mesProvisionEmpleado= cargarid_mesProvisionEmpleado;
	}

	public Border setResaltarfechaProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provisionempleadoBeanSwingJInternalFrame.jTtoolBarProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarfechaProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaProvisionEmpleado() {
		return this.resaltarfechaProvisionEmpleado;
	}

	public void setResaltarfechaProvisionEmpleado(Border borderResaltar) {
		this.resaltarfechaProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarfechaProvisionEmpleado() {
		return this.mostrarfechaProvisionEmpleado;
	}

	public void setMostrarfechaProvisionEmpleado(Boolean mostrarfechaProvisionEmpleado) {
		this.mostrarfechaProvisionEmpleado= mostrarfechaProvisionEmpleado;
	}

	public Boolean getActivarfechaProvisionEmpleado() {
		return this.activarfechaProvisionEmpleado;
	}

	public void setActivarfechaProvisionEmpleado(Boolean activarfechaProvisionEmpleado) {
		this.activarfechaProvisionEmpleado= activarfechaProvisionEmpleado;
	}

	public Border setResaltarfecha_liquidacionProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provisionempleadoBeanSwingJInternalFrame.jTtoolBarProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarfecha_liquidacionProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_liquidacionProvisionEmpleado() {
		return this.resaltarfecha_liquidacionProvisionEmpleado;
	}

	public void setResaltarfecha_liquidacionProvisionEmpleado(Border borderResaltar) {
		this.resaltarfecha_liquidacionProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarfecha_liquidacionProvisionEmpleado() {
		return this.mostrarfecha_liquidacionProvisionEmpleado;
	}

	public void setMostrarfecha_liquidacionProvisionEmpleado(Boolean mostrarfecha_liquidacionProvisionEmpleado) {
		this.mostrarfecha_liquidacionProvisionEmpleado= mostrarfecha_liquidacionProvisionEmpleado;
	}

	public Boolean getActivarfecha_liquidacionProvisionEmpleado() {
		return this.activarfecha_liquidacionProvisionEmpleado;
	}

	public void setActivarfecha_liquidacionProvisionEmpleado(Boolean activarfecha_liquidacionProvisionEmpleado) {
		this.activarfecha_liquidacionProvisionEmpleado= activarfecha_liquidacionProvisionEmpleado;
	}

	public Border setResaltarvalor_mesProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provisionempleadoBeanSwingJInternalFrame.jTtoolBarProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor_mesProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_mesProvisionEmpleado() {
		return this.resaltarvalor_mesProvisionEmpleado;
	}

	public void setResaltarvalor_mesProvisionEmpleado(Border borderResaltar) {
		this.resaltarvalor_mesProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor_mesProvisionEmpleado() {
		return this.mostrarvalor_mesProvisionEmpleado;
	}

	public void setMostrarvalor_mesProvisionEmpleado(Boolean mostrarvalor_mesProvisionEmpleado) {
		this.mostrarvalor_mesProvisionEmpleado= mostrarvalor_mesProvisionEmpleado;
	}

	public Boolean getActivarvalor_mesProvisionEmpleado() {
		return this.activarvalor_mesProvisionEmpleado;
	}

	public void setActivarvalor_mesProvisionEmpleado(Boolean activarvalor_mesProvisionEmpleado) {
		this.activarvalor_mesProvisionEmpleado= activarvalor_mesProvisionEmpleado;
	}

	public Border setResaltarvalor_pagaProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provisionempleadoBeanSwingJInternalFrame.jTtoolBarProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor_pagaProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_pagaProvisionEmpleado() {
		return this.resaltarvalor_pagaProvisionEmpleado;
	}

	public void setResaltarvalor_pagaProvisionEmpleado(Border borderResaltar) {
		this.resaltarvalor_pagaProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor_pagaProvisionEmpleado() {
		return this.mostrarvalor_pagaProvisionEmpleado;
	}

	public void setMostrarvalor_pagaProvisionEmpleado(Boolean mostrarvalor_pagaProvisionEmpleado) {
		this.mostrarvalor_pagaProvisionEmpleado= mostrarvalor_pagaProvisionEmpleado;
	}

	public Boolean getActivarvalor_pagaProvisionEmpleado() {
		return this.activarvalor_pagaProvisionEmpleado;
	}

	public void setActivarvalor_pagaProvisionEmpleado(Boolean activarvalor_pagaProvisionEmpleado) {
		this.activarvalor_pagaProvisionEmpleado= activarvalor_pagaProvisionEmpleado;
	}

	public Border setResaltarvalor_vacacionProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provisionempleadoBeanSwingJInternalFrame.jTtoolBarProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor_vacacionProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_vacacionProvisionEmpleado() {
		return this.resaltarvalor_vacacionProvisionEmpleado;
	}

	public void setResaltarvalor_vacacionProvisionEmpleado(Border borderResaltar) {
		this.resaltarvalor_vacacionProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor_vacacionProvisionEmpleado() {
		return this.mostrarvalor_vacacionProvisionEmpleado;
	}

	public void setMostrarvalor_vacacionProvisionEmpleado(Boolean mostrarvalor_vacacionProvisionEmpleado) {
		this.mostrarvalor_vacacionProvisionEmpleado= mostrarvalor_vacacionProvisionEmpleado;
	}

	public Boolean getActivarvalor_vacacionProvisionEmpleado() {
		return this.activarvalor_vacacionProvisionEmpleado;
	}

	public void setActivarvalor_vacacionProvisionEmpleado(Boolean activarvalor_vacacionProvisionEmpleado) {
		this.activarvalor_vacacionProvisionEmpleado= activarvalor_vacacionProvisionEmpleado;
	}

	public Border setResaltarvalor_liquidacionProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provisionempleadoBeanSwingJInternalFrame.jTtoolBarProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor_liquidacionProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_liquidacionProvisionEmpleado() {
		return this.resaltarvalor_liquidacionProvisionEmpleado;
	}

	public void setResaltarvalor_liquidacionProvisionEmpleado(Border borderResaltar) {
		this.resaltarvalor_liquidacionProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor_liquidacionProvisionEmpleado() {
		return this.mostrarvalor_liquidacionProvisionEmpleado;
	}

	public void setMostrarvalor_liquidacionProvisionEmpleado(Boolean mostrarvalor_liquidacionProvisionEmpleado) {
		this.mostrarvalor_liquidacionProvisionEmpleado= mostrarvalor_liquidacionProvisionEmpleado;
	}

	public Boolean getActivarvalor_liquidacionProvisionEmpleado() {
		return this.activarvalor_liquidacionProvisionEmpleado;
	}

	public void setActivarvalor_liquidacionProvisionEmpleado(Boolean activarvalor_liquidacionProvisionEmpleado) {
		this.activarvalor_liquidacionProvisionEmpleado= activarvalor_liquidacionProvisionEmpleado;
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
		
		
		this.setMostraridProvisionEmpleado(esInicial);
		this.setMostrarid_empresaProvisionEmpleado(esInicial);
		this.setMostrarid_empleadoProvisionEmpleado(esInicial);
		this.setMostrarid_estructuraProvisionEmpleado(esInicial);
		this.setMostrarid_tipo_provision_empleadoProvisionEmpleado(esInicial);
		this.setMostrarid_defi_provision_empleadoProvisionEmpleado(esInicial);
		this.setMostrarid_anioProvisionEmpleado(esInicial);
		this.setMostrarid_mesProvisionEmpleado(esInicial);
		this.setMostrarfechaProvisionEmpleado(esInicial);
		this.setMostrarfecha_liquidacionProvisionEmpleado(esInicial);
		this.setMostrarvalor_mesProvisionEmpleado(esInicial);
		this.setMostrarvalor_pagaProvisionEmpleado(esInicial);
		this.setMostrarvalor_vacacionProvisionEmpleado(esInicial);
		this.setMostrarvalor_liquidacionProvisionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.ID)) {
				this.setMostraridProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDTIPOPROVISIONEMPLEADO)) {
				this.setMostrarid_tipo_provision_empleadoProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDDEFIPROVISIONEMPLEADO)) {
				this.setMostrarid_defi_provision_empleadoProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.FECHA)) {
				this.setMostrarfechaProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.FECHALIQUIDACION)) {
				this.setMostrarfecha_liquidacionProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.VALORMES)) {
				this.setMostrarvalor_mesProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.VALORPAGA)) {
				this.setMostrarvalor_pagaProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.VALORVACACION)) {
				this.setMostrarvalor_vacacionProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.VALORLIQUIDACION)) {
				this.setMostrarvalor_liquidacionProvisionEmpleado(esAsigna);
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
		
		
		this.setActivaridProvisionEmpleado(esInicial);
		this.setActivarid_empresaProvisionEmpleado(esInicial);
		this.setActivarid_empleadoProvisionEmpleado(esInicial);
		this.setActivarid_estructuraProvisionEmpleado(esInicial);
		this.setActivarid_tipo_provision_empleadoProvisionEmpleado(esInicial);
		this.setActivarid_defi_provision_empleadoProvisionEmpleado(esInicial);
		this.setActivarid_anioProvisionEmpleado(esInicial);
		this.setActivarid_mesProvisionEmpleado(esInicial);
		this.setActivarfechaProvisionEmpleado(esInicial);
		this.setActivarfecha_liquidacionProvisionEmpleado(esInicial);
		this.setActivarvalor_mesProvisionEmpleado(esInicial);
		this.setActivarvalor_pagaProvisionEmpleado(esInicial);
		this.setActivarvalor_vacacionProvisionEmpleado(esInicial);
		this.setActivarvalor_liquidacionProvisionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.ID)) {
				this.setActivaridProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDTIPOPROVISIONEMPLEADO)) {
				this.setActivarid_tipo_provision_empleadoProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDDEFIPROVISIONEMPLEADO)) {
				this.setActivarid_defi_provision_empleadoProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDMES)) {
				this.setActivarid_mesProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.FECHA)) {
				this.setActivarfechaProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.FECHALIQUIDACION)) {
				this.setActivarfecha_liquidacionProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.VALORMES)) {
				this.setActivarvalor_mesProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.VALORPAGA)) {
				this.setActivarvalor_pagaProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.VALORVACACION)) {
				this.setActivarvalor_vacacionProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.VALORLIQUIDACION)) {
				this.setActivarvalor_liquidacionProvisionEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProvisionEmpleado(esInicial);
		this.setResaltarid_empresaProvisionEmpleado(esInicial);
		this.setResaltarid_empleadoProvisionEmpleado(esInicial);
		this.setResaltarid_estructuraProvisionEmpleado(esInicial);
		this.setResaltarid_tipo_provision_empleadoProvisionEmpleado(esInicial);
		this.setResaltarid_defi_provision_empleadoProvisionEmpleado(esInicial);
		this.setResaltarid_anioProvisionEmpleado(esInicial);
		this.setResaltarid_mesProvisionEmpleado(esInicial);
		this.setResaltarfechaProvisionEmpleado(esInicial);
		this.setResaltarfecha_liquidacionProvisionEmpleado(esInicial);
		this.setResaltarvalor_mesProvisionEmpleado(esInicial);
		this.setResaltarvalor_pagaProvisionEmpleado(esInicial);
		this.setResaltarvalor_vacacionProvisionEmpleado(esInicial);
		this.setResaltarvalor_liquidacionProvisionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.ID)) {
				this.setResaltaridProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDTIPOPROVISIONEMPLEADO)) {
				this.setResaltarid_tipo_provision_empleadoProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDDEFIPROVISIONEMPLEADO)) {
				this.setResaltarid_defi_provision_empleadoProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.FECHA)) {
				this.setResaltarfechaProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.FECHALIQUIDACION)) {
				this.setResaltarfecha_liquidacionProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.VALORMES)) {
				this.setResaltarvalor_mesProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.VALORPAGA)) {
				this.setResaltarvalor_pagaProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.VALORVACACION)) {
				this.setResaltarvalor_vacacionProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvisionEmpleadoConstantesFunciones.VALORLIQUIDACION)) {
				this.setResaltarvalor_liquidacionProvisionEmpleado(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAnioProvisionEmpleado=true;

	public Boolean getMostrarFK_IdAnioProvisionEmpleado() {
		return this.mostrarFK_IdAnioProvisionEmpleado;
	}

	public void setMostrarFK_IdAnioProvisionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioProvisionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDefiProvisionEmpleadoProvisionEmpleado=true;

	public Boolean getMostrarFK_IdDefiProvisionEmpleadoProvisionEmpleado() {
		return this.mostrarFK_IdDefiProvisionEmpleadoProvisionEmpleado;
	}

	public void setMostrarFK_IdDefiProvisionEmpleadoProvisionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDefiProvisionEmpleadoProvisionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoProvisionEmpleado=true;

	public Boolean getMostrarFK_IdEmpleadoProvisionEmpleado() {
		return this.mostrarFK_IdEmpleadoProvisionEmpleado;
	}

	public void setMostrarFK_IdEmpleadoProvisionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoProvisionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaProvisionEmpleado=true;

	public Boolean getMostrarFK_IdEmpresaProvisionEmpleado() {
		return this.mostrarFK_IdEmpresaProvisionEmpleado;
	}

	public void setMostrarFK_IdEmpresaProvisionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaProvisionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraProvisionEmpleado=true;

	public Boolean getMostrarFK_IdEstructuraProvisionEmpleado() {
		return this.mostrarFK_IdEstructuraProvisionEmpleado;
	}

	public void setMostrarFK_IdEstructuraProvisionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraProvisionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesProvisionEmpleado=true;

	public Boolean getMostrarFK_IdMesProvisionEmpleado() {
		return this.mostrarFK_IdMesProvisionEmpleado;
	}

	public void setMostrarFK_IdMesProvisionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesProvisionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProvisionEmpleadoProvisionEmpleado=true;

	public Boolean getMostrarFK_IdTipoProvisionEmpleadoProvisionEmpleado() {
		return this.mostrarFK_IdTipoProvisionEmpleadoProvisionEmpleado;
	}

	public void setMostrarFK_IdTipoProvisionEmpleadoProvisionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProvisionEmpleadoProvisionEmpleado= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioProvisionEmpleado=true;

	public Boolean getActivarFK_IdAnioProvisionEmpleado() {
		return this.activarFK_IdAnioProvisionEmpleado;
	}

	public void setActivarFK_IdAnioProvisionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdAnioProvisionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdDefiProvisionEmpleadoProvisionEmpleado=true;

	public Boolean getActivarFK_IdDefiProvisionEmpleadoProvisionEmpleado() {
		return this.activarFK_IdDefiProvisionEmpleadoProvisionEmpleado;
	}

	public void setActivarFK_IdDefiProvisionEmpleadoProvisionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdDefiProvisionEmpleadoProvisionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoProvisionEmpleado=true;

	public Boolean getActivarFK_IdEmpleadoProvisionEmpleado() {
		return this.activarFK_IdEmpleadoProvisionEmpleado;
	}

	public void setActivarFK_IdEmpleadoProvisionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoProvisionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaProvisionEmpleado=true;

	public Boolean getActivarFK_IdEmpresaProvisionEmpleado() {
		return this.activarFK_IdEmpresaProvisionEmpleado;
	}

	public void setActivarFK_IdEmpresaProvisionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaProvisionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraProvisionEmpleado=true;

	public Boolean getActivarFK_IdEstructuraProvisionEmpleado() {
		return this.activarFK_IdEstructuraProvisionEmpleado;
	}

	public void setActivarFK_IdEstructuraProvisionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraProvisionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdMesProvisionEmpleado=true;

	public Boolean getActivarFK_IdMesProvisionEmpleado() {
		return this.activarFK_IdMesProvisionEmpleado;
	}

	public void setActivarFK_IdMesProvisionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdMesProvisionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProvisionEmpleadoProvisionEmpleado=true;

	public Boolean getActivarFK_IdTipoProvisionEmpleadoProvisionEmpleado() {
		return this.activarFK_IdTipoProvisionEmpleadoProvisionEmpleado;
	}

	public void setActivarFK_IdTipoProvisionEmpleadoProvisionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProvisionEmpleadoProvisionEmpleado= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioProvisionEmpleado=null;

	public Border getResaltarFK_IdAnioProvisionEmpleado() {
		return this.resaltarFK_IdAnioProvisionEmpleado;
	}

	public void setResaltarFK_IdAnioProvisionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdAnioProvisionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdAnioProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioProvisionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdDefiProvisionEmpleadoProvisionEmpleado=null;

	public Border getResaltarFK_IdDefiProvisionEmpleadoProvisionEmpleado() {
		return this.resaltarFK_IdDefiProvisionEmpleadoProvisionEmpleado;
	}

	public void setResaltarFK_IdDefiProvisionEmpleadoProvisionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdDefiProvisionEmpleadoProvisionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdDefiProvisionEmpleadoProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDefiProvisionEmpleadoProvisionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoProvisionEmpleado=null;

	public Border getResaltarFK_IdEmpleadoProvisionEmpleado() {
		return this.resaltarFK_IdEmpleadoProvisionEmpleado;
	}

	public void setResaltarFK_IdEmpleadoProvisionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoProvisionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoProvisionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaProvisionEmpleado=null;

	public Border getResaltarFK_IdEmpresaProvisionEmpleado() {
		return this.resaltarFK_IdEmpresaProvisionEmpleado;
	}

	public void setResaltarFK_IdEmpresaProvisionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpresaProvisionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaProvisionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraProvisionEmpleado=null;

	public Border getResaltarFK_IdEstructuraProvisionEmpleado() {
		return this.resaltarFK_IdEstructuraProvisionEmpleado;
	}

	public void setResaltarFK_IdEstructuraProvisionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEstructuraProvisionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraProvisionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdMesProvisionEmpleado=null;

	public Border getResaltarFK_IdMesProvisionEmpleado() {
		return this.resaltarFK_IdMesProvisionEmpleado;
	}

	public void setResaltarFK_IdMesProvisionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdMesProvisionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdMesProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesProvisionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdTipoProvisionEmpleadoProvisionEmpleado=null;

	public Border getResaltarFK_IdTipoProvisionEmpleadoProvisionEmpleado() {
		return this.resaltarFK_IdTipoProvisionEmpleadoProvisionEmpleado;
	}

	public void setResaltarFK_IdTipoProvisionEmpleadoProvisionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdTipoProvisionEmpleadoProvisionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdTipoProvisionEmpleadoProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*ProvisionEmpleadoBeanSwingJInternalFrame provisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProvisionEmpleadoProvisionEmpleado= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}