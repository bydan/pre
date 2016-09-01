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


import com.bydan.erp.nomina.util.CargoConstantesFunciones;
import com.bydan.erp.nomina.util.CargoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CargoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CargoConstantesFunciones extends CargoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Cargo";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Cargo"+CargoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CargoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CargoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CargoConstantesFunciones.SCHEMA+"_"+CargoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CargoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CargoConstantesFunciones.SCHEMA+"_"+CargoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CargoConstantesFunciones.SCHEMA+"_"+CargoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CargoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CargoConstantesFunciones.SCHEMA+"_"+CargoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CargoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CargoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CargoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CargoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CargoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CargoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cargos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Cargo";
	public static final String SCLASSWEBTITULO_LOWER="Cargo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Cargo";
	public static final String OBJECTNAME="cargo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="cargo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cargo from "+CargoConstantesFunciones.SPERSISTENCENAME+" cargo";
	public static String QUERYSELECTNATIVE="select "+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".id,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".version_row,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".id_empresa,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".id_cargo,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".id_numero_patronal,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".id_tipo_pago__n_m,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".id_cargo_grupo,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".codigo,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".nombre,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".valor_anticipo,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".porcentaje_anticipo,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".es_jefe,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".es_anual,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".porcentaje,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".valor from "+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME;//+" as "+CargoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CargoConstantesFuncionesAdditional cargoConstantesFuncionesAdditional=null;
	
	public CargoConstantesFuncionesAdditional getCargoConstantesFuncionesAdditional() {
		return this.cargoConstantesFuncionesAdditional;
	}
	
	public void setCargoConstantesFuncionesAdditional(CargoConstantesFuncionesAdditional cargoConstantesFuncionesAdditional) {
		try {
			this.cargoConstantesFuncionesAdditional=cargoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCARGO= "id_cargo";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDNUMEROPATRONAL= "id_numero_patronal";
    public static final String IDTIPOPAGO_NM= "id_tipo_pago__n_m";
    public static final String IDCARGOGRUPO= "id_cargo_grupo";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String VALORANTICIPO= "valor_anticipo";
    public static final String PORCENTAJEANTICIPO= "porcentaje_anticipo";
    public static final String ESJEFE= "es_jefe";
    public static final String ESANUAL= "es_anual";
    public static final String PORCENTAJE= "porcentaje";
    public static final String VALOR= "valor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCARGO= "Cargo";
		public static final String LABEL_IDCARGO_LOWER= "Cargo";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDNUMEROPATRONAL= "Numero Patronal";
		public static final String LABEL_IDNUMEROPATRONAL_LOWER= "Numero Patronal";
    	public static final String LABEL_IDTIPOPAGO_NM= "Tipo Pago_ N M";
		public static final String LABEL_IDTIPOPAGO_NM_LOWER= "Tipo Pago_ N M";
    	public static final String LABEL_IDCARGOGRUPO= "Cargo Grupo";
		public static final String LABEL_IDCARGOGRUPO_LOWER= "Cargo Grupo";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_VALORANTICIPO= "Valor Anticipo";
		public static final String LABEL_VALORANTICIPO_LOWER= "Valor Anticipo";
    	public static final String LABEL_PORCENTAJEANTICIPO= "Porcentaje Anticipo";
		public static final String LABEL_PORCENTAJEANTICIPO_LOWER= "Porcentaje Anticipo";
    	public static final String LABEL_ESJEFE= "Es Jefe";
		public static final String LABEL_ESJEFE_LOWER= "Es Jefe";
    	public static final String LABEL_ESANUAL= "Es Anual";
		public static final String LABEL_ESANUAL_LOWER= "Es Anual";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	
	public static String getCargoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CargoConstantesFunciones.IDEMPRESA)) {sLabelColumna=CargoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CargoConstantesFunciones.IDCARGO)) {sLabelColumna=CargoConstantesFunciones.LABEL_IDCARGO;}
		if(sNombreColumna.equals(CargoConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=CargoConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(CargoConstantesFunciones.IDNUMEROPATRONAL)) {sLabelColumna=CargoConstantesFunciones.LABEL_IDNUMEROPATRONAL;}
		if(sNombreColumna.equals(CargoConstantesFunciones.IDTIPOPAGO_NM)) {sLabelColumna=CargoConstantesFunciones.LABEL_IDTIPOPAGO_NM;}
		if(sNombreColumna.equals(CargoConstantesFunciones.IDCARGOGRUPO)) {sLabelColumna=CargoConstantesFunciones.LABEL_IDCARGOGRUPO;}
		if(sNombreColumna.equals(CargoConstantesFunciones.CODIGO)) {sLabelColumna=CargoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CargoConstantesFunciones.NOMBRE)) {sLabelColumna=CargoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CargoConstantesFunciones.VALORANTICIPO)) {sLabelColumna=CargoConstantesFunciones.LABEL_VALORANTICIPO;}
		if(sNombreColumna.equals(CargoConstantesFunciones.PORCENTAJEANTICIPO)) {sLabelColumna=CargoConstantesFunciones.LABEL_PORCENTAJEANTICIPO;}
		if(sNombreColumna.equals(CargoConstantesFunciones.ESJEFE)) {sLabelColumna=CargoConstantesFunciones.LABEL_ESJEFE;}
		if(sNombreColumna.equals(CargoConstantesFunciones.ESANUAL)) {sLabelColumna=CargoConstantesFunciones.LABEL_ESANUAL;}
		if(sNombreColumna.equals(CargoConstantesFunciones.PORCENTAJE)) {sLabelColumna=CargoConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(CargoConstantesFunciones.VALOR)) {sLabelColumna=CargoConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_jefeDescripcion(Cargo cargo) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cargo.getes_jefe()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_jefeHtmlDescripcion(Cargo cargo) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cargo.getId(),cargo.getes_jefe());

		return sDescripcion;
	}	
		
	public static String getes_anualDescripcion(Cargo cargo) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cargo.getes_anual()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_anualHtmlDescripcion(Cargo cargo) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cargo.getId(),cargo.getes_anual());

		return sDescripcion;
	}	
			
			
	
	public static String getCargoDescripcion(Cargo cargo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cargo !=null/* && cargo.getId()!=0*/) {
			sDescripcion=cargo.getcodigo();//cargocargo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCargoDescripcionDetallado(Cargo cargo) {
		String sDescripcion="";
			
		sDescripcion+=CargoConstantesFunciones.ID+"=";
		sDescripcion+=cargo.getId().toString()+",";
		sDescripcion+=CargoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cargo.getVersionRow().toString()+",";
		sDescripcion+=CargoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cargo.getid_empresa().toString()+",";
		sDescripcion+=CargoConstantesFunciones.IDCARGO+"=";
		sDescripcion+=cargo.getid_cargo().toString()+",";
		sDescripcion+=CargoConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=cargo.getid_cuenta_contable().toString()+",";
		sDescripcion+=CargoConstantesFunciones.IDNUMEROPATRONAL+"=";
		sDescripcion+=cargo.getid_numero_patronal().toString()+",";
		sDescripcion+=CargoConstantesFunciones.IDTIPOPAGO_NM+"=";
		sDescripcion+=cargo.getid_tipo_pago__n_m().toString()+",";
		sDescripcion+=CargoConstantesFunciones.IDCARGOGRUPO+"=";
		sDescripcion+=cargo.getid_cargo_grupo().toString()+",";
		sDescripcion+=CargoConstantesFunciones.CODIGO+"=";
		sDescripcion+=cargo.getcodigo()+",";
		sDescripcion+=CargoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=cargo.getnombre()+",";
		sDescripcion+=CargoConstantesFunciones.VALORANTICIPO+"=";
		sDescripcion+=cargo.getvalor_anticipo().toString()+",";
		sDescripcion+=CargoConstantesFunciones.PORCENTAJEANTICIPO+"=";
		sDescripcion+=cargo.getporcentaje_anticipo().toString()+",";
		sDescripcion+=CargoConstantesFunciones.ESJEFE+"=";
		sDescripcion+=cargo.getes_jefe().toString()+",";
		sDescripcion+=CargoConstantesFunciones.ESANUAL+"=";
		sDescripcion+=cargo.getes_anual().toString()+",";
		sDescripcion+=CargoConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=cargo.getporcentaje().toString()+",";
		sDescripcion+=CargoConstantesFunciones.VALOR+"=";
		sDescripcion+=cargo.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCargoDescripcion(Cargo cargo,String sValor) throws Exception {			
		if(cargo !=null) {
			cargo.setcodigo(sValor);;//cargocargo.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getNumeroPatronalDescripcion(NumeroPatronal numeropatronal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(numeropatronal!=null/*&&numeropatronal.getId()>0*/) {
			sDescripcion=NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(numeropatronal);
		}

		return sDescripcion;
	}

	public static String getTipoPago_NMDescripcion(TipoPago_NM tipopago_nm) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipopago_nm!=null/*&&tipopago_nm.getId()>0*/) {
			sDescripcion=TipoPago_NMConstantesFunciones.getTipoPago_NMDescripcion(tipopago_nm);
		}

		return sDescripcion;
	}

	public static String getCargoGrupoDescripcion(CargoGrupo cargogrupo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cargogrupo!=null/*&&cargogrupo.getId()>0*/) {
			sDescripcion=CargoGrupoConstantesFunciones.getCargoGrupoDescripcion(cargogrupo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCargo")) {
			sNombreIndice="Tipo=  Por Cargo";
		} else if(sNombreIndice.equals("FK_IdCargoGrupo")) {
			sNombreIndice="Tipo=  Por Cargo Grupo";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdNumeroPatronal")) {
			sNombreIndice="Tipo=  Por Numero Patronal";
		} else if(sNombreIndice.equals("FK_IdTipoPago_NM")) {
			sNombreIndice="Tipo=  Por Tipo Pago_ N M";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCargo(Long id_cargo) {
		String sDetalleIndice=" Parametros->";
		if(id_cargo!=null) {sDetalleIndice+=" Codigo Unico De Cargo="+id_cargo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCargoGrupo(Long id_cargo_grupo) {
		String sDetalleIndice=" Parametros->";
		if(id_cargo_grupo!=null) {sDetalleIndice+=" Codigo Unico De Cargo Grupo="+id_cargo_grupo.toString();} 

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

	public static String getDetalleIndiceFK_IdNumeroPatronal(Long id_numero_patronal) {
		String sDetalleIndice=" Parametros->";
		if(id_numero_patronal!=null) {sDetalleIndice+=" Codigo Unico De Numero Patronal="+id_numero_patronal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPago_NM(Long id_tipo_pago__n_m) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_pago__n_m!=null) {sDetalleIndice+=" Codigo Unico De Tipo Pago_ N M="+id_tipo_pago__n_m.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCargo(Cargo cargo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cargo.setcodigo(cargo.getcodigo().trim());
		cargo.setnombre(cargo.getnombre().trim());
	}
	
	public static void quitarEspaciosCargos(List<Cargo> cargos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Cargo cargo: cargos) {
			cargo.setcodigo(cargo.getcodigo().trim());
			cargo.setnombre(cargo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCargo(Cargo cargo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cargo.getConCambioAuxiliar()) {
			cargo.setIsDeleted(cargo.getIsDeletedAuxiliar());	
			cargo.setIsNew(cargo.getIsNewAuxiliar());	
			cargo.setIsChanged(cargo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cargo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cargo.setIsDeletedAuxiliar(false);	
			cargo.setIsNewAuxiliar(false);	
			cargo.setIsChangedAuxiliar(false);
			
			cargo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCargos(List<Cargo> cargos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Cargo cargo : cargos) {
			if(conAsignarBase && cargo.getConCambioAuxiliar()) {
				cargo.setIsDeleted(cargo.getIsDeletedAuxiliar());	
				cargo.setIsNew(cargo.getIsNewAuxiliar());	
				cargo.setIsChanged(cargo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cargo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cargo.setIsDeletedAuxiliar(false);	
				cargo.setIsNewAuxiliar(false);	
				cargo.setIsChangedAuxiliar(false);
				
				cargo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCargo(Cargo cargo,Boolean conEnteros) throws Exception  {
		cargo.setvalor_anticipo(0.0);
		cargo.setporcentaje_anticipo(0.0);
		cargo.setporcentaje(0.0);
		cargo.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCargos(List<Cargo> cargos,Boolean conEnteros) throws Exception  {
		
		for(Cargo cargo: cargos) {
			cargo.setvalor_anticipo(0.0);
			cargo.setporcentaje_anticipo(0.0);
			cargo.setporcentaje(0.0);
			cargo.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCargo(List<Cargo> cargos,Cargo cargoAux) throws Exception  {
		CargoConstantesFunciones.InicializarValoresCargo(cargoAux,true);
		
		for(Cargo cargo: cargos) {
			if(cargo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cargoAux.setvalor_anticipo(cargoAux.getvalor_anticipo()+cargo.getvalor_anticipo());			
			cargoAux.setporcentaje_anticipo(cargoAux.getporcentaje_anticipo()+cargo.getporcentaje_anticipo());			
			cargoAux.setporcentaje(cargoAux.getporcentaje()+cargo.getporcentaje());			
			cargoAux.setvalor(cargoAux.getvalor()+cargo.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCargo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CargoConstantesFunciones.getArrayColumnasGlobalesCargo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCargo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CargoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CargoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCargo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Cargo> cargos,Cargo cargo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Cargo cargoAux: cargos) {
			if(cargoAux!=null && cargo!=null) {
				if((cargoAux.getId()==null && cargo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cargoAux.getId()!=null && cargo.getId()!=null){
					if(cargoAux.getId().equals(cargo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCargo(List<Cargo> cargos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_anticipoTotal=0.0;
		Double porcentaje_anticipoTotal=0.0;
		Double porcentajeTotal=0.0;
		Double valorTotal=0.0;
	
		for(Cargo cargo: cargos) {			
			if(cargo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_anticipoTotal+=cargo.getvalor_anticipo();
			porcentaje_anticipoTotal+=cargo.getporcentaje_anticipo();
			porcentajeTotal+=cargo.getporcentaje();
			valorTotal+=cargo.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CargoConstantesFunciones.VALORANTICIPO);
		datoGeneral.setsDescripcion(CargoConstantesFunciones.LABEL_VALORANTICIPO);
		datoGeneral.setdValorDouble(valor_anticipoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CargoConstantesFunciones.PORCENTAJEANTICIPO);
		datoGeneral.setsDescripcion(CargoConstantesFunciones.LABEL_PORCENTAJEANTICIPO);
		datoGeneral.setdValorDouble(porcentaje_anticipoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CargoConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(CargoConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CargoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(CargoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCargo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CargoConstantesFunciones.LABEL_ID, CargoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoConstantesFunciones.LABEL_VERSIONROW, CargoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoConstantesFunciones.LABEL_IDEMPRESA, CargoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoConstantesFunciones.LABEL_IDCARGO, CargoConstantesFunciones.IDCARGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoConstantesFunciones.LABEL_IDCUENTACONTABLE, CargoConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoConstantesFunciones.LABEL_IDNUMEROPATRONAL, CargoConstantesFunciones.IDNUMEROPATRONAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoConstantesFunciones.LABEL_IDTIPOPAGO_NM, CargoConstantesFunciones.IDTIPOPAGO_NM,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoConstantesFunciones.LABEL_IDCARGOGRUPO, CargoConstantesFunciones.IDCARGOGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoConstantesFunciones.LABEL_CODIGO, CargoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoConstantesFunciones.LABEL_NOMBRE, CargoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoConstantesFunciones.LABEL_VALORANTICIPO, CargoConstantesFunciones.VALORANTICIPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoConstantesFunciones.LABEL_PORCENTAJEANTICIPO, CargoConstantesFunciones.PORCENTAJEANTICIPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoConstantesFunciones.LABEL_ESJEFE, CargoConstantesFunciones.ESJEFE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoConstantesFunciones.LABEL_ESANUAL, CargoConstantesFunciones.ESANUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoConstantesFunciones.LABEL_PORCENTAJE, CargoConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoConstantesFunciones.LABEL_VALOR, CargoConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCargo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CargoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoConstantesFunciones.IDCARGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoConstantesFunciones.IDNUMEROPATRONAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoConstantesFunciones.IDTIPOPAGO_NM;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoConstantesFunciones.IDCARGOGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoConstantesFunciones.VALORANTICIPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoConstantesFunciones.PORCENTAJEANTICIPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoConstantesFunciones.ESJEFE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoConstantesFunciones.ESANUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCargo() throws Exception  {
		return CargoConstantesFunciones.getTiposSeleccionarCargo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCargo(Boolean conFk) throws Exception  {
		return CargoConstantesFunciones.getTiposSeleccionarCargo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCargo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CargoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoConstantesFunciones.LABEL_IDCARGO);
			reporte.setsDescripcion(CargoConstantesFunciones.LABEL_IDCARGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(CargoConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoConstantesFunciones.LABEL_IDNUMEROPATRONAL);
			reporte.setsDescripcion(CargoConstantesFunciones.LABEL_IDNUMEROPATRONAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoConstantesFunciones.LABEL_IDTIPOPAGO_NM);
			reporte.setsDescripcion(CargoConstantesFunciones.LABEL_IDTIPOPAGO_NM);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoConstantesFunciones.LABEL_IDCARGOGRUPO);
			reporte.setsDescripcion(CargoConstantesFunciones.LABEL_IDCARGOGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CargoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CargoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoConstantesFunciones.LABEL_VALORANTICIPO);
			reporte.setsDescripcion(CargoConstantesFunciones.LABEL_VALORANTICIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoConstantesFunciones.LABEL_PORCENTAJEANTICIPO);
			reporte.setsDescripcion(CargoConstantesFunciones.LABEL_PORCENTAJEANTICIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoConstantesFunciones.LABEL_ESJEFE);
			reporte.setsDescripcion(CargoConstantesFunciones.LABEL_ESJEFE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoConstantesFunciones.LABEL_ESANUAL);
			reporte.setsDescripcion(CargoConstantesFunciones.LABEL_ESANUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(CargoConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(CargoConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCargo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCargo(Cargo cargoAux) throws Exception {
		
			cargoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cargoAux.getEmpresa()));
			cargoAux.setcargo_descripcion(CargoConstantesFunciones.getCargoDescripcion(cargoAux.getCargo()));
			cargoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cargoAux.getCuentaContable()));
			cargoAux.setnumeropatronal_descripcion(NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(cargoAux.getNumeroPatronal()));
			cargoAux.settipopago_nm_descripcion(TipoPago_NMConstantesFunciones.getTipoPago_NMDescripcion(cargoAux.getTipoPago_NM()));
			cargoAux.setcargogrupo_descripcion(CargoGrupoConstantesFunciones.getCargoGrupoDescripcion(cargoAux.getCargoGrupo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCargo(List<Cargo> cargosTemp) throws Exception {
		for(Cargo cargoAux:cargosTemp) {
			
			cargoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cargoAux.getEmpresa()));
			cargoAux.setcargo_descripcion(CargoConstantesFunciones.getCargoDescripcion(cargoAux.getCargo()));
			cargoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cargoAux.getCuentaContable()));
			cargoAux.setnumeropatronal_descripcion(NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(cargoAux.getNumeroPatronal()));
			cargoAux.settipopago_nm_descripcion(TipoPago_NMConstantesFunciones.getTipoPago_NMDescripcion(cargoAux.getTipoPago_NM()));
			cargoAux.setcargogrupo_descripcion(CargoGrupoConstantesFunciones.getCargoGrupoDescripcion(cargoAux.getCargoGrupo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCargo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cargo.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(NumeroPatronal.class));
				classes.add(new Classe(TipoPago_NM.class));
				classes.add(new Classe(CargoGrupo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cargo.class)) {
						classes.add(new Classe(Cargo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NumeroPatronal.class)) {
						classes.add(new Classe(NumeroPatronal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPago_NM.class)) {
						classes.add(new Classe(TipoPago_NM.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CargoGrupo.class)) {
						classes.add(new Classe(CargoGrupo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCargo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(NumeroPatronal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroPatronal.class)); continue;
					}

					if(TipoPago_NM.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPago_NM.class)); continue;
					}

					if(CargoGrupo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargoGrupo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(NumeroPatronal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroPatronal.class)); continue;
					}

					if(TipoPago_NM.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPago_NM.class)); continue;
					}

					if(CargoGrupo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargoGrupo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCargo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CargoConstantesFunciones.getClassesRelationshipsOfCargo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCargo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(AsistenciaMensual.class));
				classes.add(new Classe(EmpleadoEstructura.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Cargo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(AsistenciaMensual.class)) {
						classes.add(new Classe(AsistenciaMensual.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoEstructura.class)) {
						classes.add(new Classe(EmpleadoEstructura.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cargo.class)) {
						classes.add(new Classe(Cargo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCargo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CargoConstantesFunciones.getClassesRelationshipsFromStringsOfCargo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCargo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(AsistenciaMensual.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsistenciaMensual.class)); continue;
					}

					if(EmpleadoEstructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoEstructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(AsistenciaMensual.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsistenciaMensual.class)); continue;
					}

					if(EmpleadoEstructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoEstructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
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
	public static void actualizarLista(Cargo cargo,List<Cargo> cargos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Cargo cargoEncontrado=null;
			
			for(Cargo cargoLocal:cargos) {
				if(cargoLocal.getId().equals(cargo.getId())) {
					cargoEncontrado=cargoLocal;
					
					cargoLocal.setIsChanged(cargo.getIsChanged());
					cargoLocal.setIsNew(cargo.getIsNew());
					cargoLocal.setIsDeleted(cargo.getIsDeleted());
					
					cargoLocal.setGeneralEntityOriginal(cargo.getGeneralEntityOriginal());
					
					cargoLocal.setId(cargo.getId());	
					cargoLocal.setVersionRow(cargo.getVersionRow());	
					cargoLocal.setid_empresa(cargo.getid_empresa());	
					cargoLocal.setid_cargo(cargo.getid_cargo());	
					cargoLocal.setid_cuenta_contable(cargo.getid_cuenta_contable());	
					cargoLocal.setid_numero_patronal(cargo.getid_numero_patronal());	
					cargoLocal.setid_tipo_pago__n_m(cargo.getid_tipo_pago__n_m());	
					cargoLocal.setid_cargo_grupo(cargo.getid_cargo_grupo());	
					cargoLocal.setcodigo(cargo.getcodigo());	
					cargoLocal.setnombre(cargo.getnombre());	
					cargoLocal.setvalor_anticipo(cargo.getvalor_anticipo());	
					cargoLocal.setporcentaje_anticipo(cargo.getporcentaje_anticipo());	
					cargoLocal.setes_jefe(cargo.getes_jefe());	
					cargoLocal.setes_anual(cargo.getes_anual());	
					cargoLocal.setporcentaje(cargo.getporcentaje());	
					cargoLocal.setvalor(cargo.getvalor());	
					
					
					cargoLocal.setAsistenciaMensuals(cargo.getAsistenciaMensuals());
					cargoLocal.setEmpleadoEstructuras(cargo.getEmpleadoEstructuras());
					cargoLocal.setEmpleados(cargo.getEmpleados());
					cargoLocal.setCargos(cargo.getCargos());
					
					existe=true;
					break;
				}
			}
			
			if(!cargo.getIsDeleted()) {
				if(!existe) {
					cargos.add(cargo);
				}
			} else {
				if(cargoEncontrado!=null && permiteQuitar)  {
					cargos.remove(cargoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Cargo cargo,List<Cargo> cargos) throws Exception {
		try	{			
			for(Cargo cargoLocal:cargos) {
				if(cargoLocal.getId().equals(cargo.getId())) {
					cargoLocal.setIsSelected(cargo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCargo(List<Cargo> cargosAux) throws Exception {
		//this.cargosAux=cargosAux;
		
		for(Cargo cargoAux:cargosAux) {
			if(cargoAux.getIsChanged()) {
				cargoAux.setIsChanged(false);
			}		
			
			if(cargoAux.getIsNew()) {
				cargoAux.setIsNew(false);
			}	
			
			if(cargoAux.getIsDeleted()) {
				cargoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCargo(Cargo cargoAux) throws Exception {
		//this.cargoAux=cargoAux;
		
			if(cargoAux.getIsChanged()) {
				cargoAux.setIsChanged(false);
			}		
			
			if(cargoAux.getIsNew()) {
				cargoAux.setIsNew(false);
			}	
			
			if(cargoAux.getIsDeleted()) {
				cargoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Cargo cargoAsignar,Cargo cargo) throws Exception {
		cargoAsignar.setId(cargo.getId());	
		cargoAsignar.setVersionRow(cargo.getVersionRow());	
		cargoAsignar.setid_empresa(cargo.getid_empresa());
		cargoAsignar.setempresa_descripcion(cargo.getempresa_descripcion());	
		cargoAsignar.setid_cargo(cargo.getid_cargo());
		cargoAsignar.setcargo_descripcion(cargo.getcargo_descripcion());	
		cargoAsignar.setid_cuenta_contable(cargo.getid_cuenta_contable());
		cargoAsignar.setcuentacontable_descripcion(cargo.getcuentacontable_descripcion());	
		cargoAsignar.setid_numero_patronal(cargo.getid_numero_patronal());
		cargoAsignar.setnumeropatronal_descripcion(cargo.getnumeropatronal_descripcion());	
		cargoAsignar.setid_tipo_pago__n_m(cargo.getid_tipo_pago__n_m());
		cargoAsignar.settipopago_nm_descripcion(cargo.gettipopago_nm_descripcion());	
		cargoAsignar.setid_cargo_grupo(cargo.getid_cargo_grupo());
		cargoAsignar.setcargogrupo_descripcion(cargo.getcargogrupo_descripcion());	
		cargoAsignar.setcodigo(cargo.getcodigo());	
		cargoAsignar.setnombre(cargo.getnombre());	
		cargoAsignar.setvalor_anticipo(cargo.getvalor_anticipo());	
		cargoAsignar.setporcentaje_anticipo(cargo.getporcentaje_anticipo());	
		cargoAsignar.setes_jefe(cargo.getes_jefe());	
		cargoAsignar.setes_anual(cargo.getes_anual());	
		cargoAsignar.setporcentaje(cargo.getporcentaje());	
		cargoAsignar.setvalor(cargo.getvalor());	
	}
	
	public static void inicializarCargo(Cargo cargo) throws Exception {
		try {
				cargo.setId(0L);	
					
				cargo.setid_empresa(-1L);	
				cargo.setid_cargo(-1L);	
				cargo.setid_cuenta_contable(-1L);	
				cargo.setid_numero_patronal(-1L);	
				cargo.setid_tipo_pago__n_m(-1L);	
				cargo.setid_cargo_grupo(-1L);	
				cargo.setcodigo("");	
				cargo.setnombre("");	
				cargo.setvalor_anticipo(0.0);	
				cargo.setporcentaje_anticipo(0.0);	
				cargo.setes_jefe(false);	
				cargo.setes_anual(false);	
				cargo.setporcentaje(0.0);	
				cargo.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCargo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoConstantesFunciones.LABEL_IDCARGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoConstantesFunciones.LABEL_IDNUMEROPATRONAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoConstantesFunciones.LABEL_IDTIPOPAGO_NM);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoConstantesFunciones.LABEL_IDCARGOGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoConstantesFunciones.LABEL_VALORANTICIPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoConstantesFunciones.LABEL_PORCENTAJEANTICIPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoConstantesFunciones.LABEL_ESJEFE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoConstantesFunciones.LABEL_ESANUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCargo(String sTipo,Row row,Workbook workbook,Cargo cargo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cargo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargo.getcargo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargo.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargo.getnumeropatronal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargo.gettipopago_nm_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargo.getcargogrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargo.getvalor_anticipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargo.getporcentaje_anticipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cargo.getes_jefe()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cargo.getes_anual()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargo.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargo.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCargo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCargo() {
		return this.sFinalQueryCargo;
	}
	
	public void setsFinalQueryCargo(String sFinalQueryCargo) {
		this.sFinalQueryCargo= sFinalQueryCargo;
	}
	
	public Border resaltarSeleccionarCargo=null;
	
	public Border setResaltarSeleccionarCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCargo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCargo() {
		return this.resaltarSeleccionarCargo;
	}
	
	public void setResaltarSeleccionarCargo(Border borderResaltarSeleccionarCargo) {
		this.resaltarSeleccionarCargo= borderResaltarSeleccionarCargo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCargo=null;
	public Boolean mostraridCargo=true;
	public Boolean activaridCargo=true;

	public Border resaltarid_empresaCargo=null;
	public Boolean mostrarid_empresaCargo=true;
	public Boolean activarid_empresaCargo=true;
	public Boolean cargarid_empresaCargo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCargo=false;//ConEventDepend=true

	public Border resaltarid_cargoCargo=null;
	public Boolean mostrarid_cargoCargo=true;
	public Boolean activarid_cargoCargo=true;
	public Boolean cargarid_cargoCargo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cargoCargo=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableCargo=null;
	public Boolean mostrarid_cuenta_contableCargo=true;
	public Boolean activarid_cuenta_contableCargo=true;
	public Boolean cargarid_cuenta_contableCargo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableCargo=false;//ConEventDepend=true

	public Border resaltarid_numero_patronalCargo=null;
	public Boolean mostrarid_numero_patronalCargo=true;
	public Boolean activarid_numero_patronalCargo=true;
	public Boolean cargarid_numero_patronalCargo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_numero_patronalCargo=false;//ConEventDepend=true

	public Border resaltarid_tipo_pago__n_mCargo=null;
	public Boolean mostrarid_tipo_pago__n_mCargo=true;
	public Boolean activarid_tipo_pago__n_mCargo=true;
	public Boolean cargarid_tipo_pago__n_mCargo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_pago__n_mCargo=false;//ConEventDepend=true

	public Border resaltarid_cargo_grupoCargo=null;
	public Boolean mostrarid_cargo_grupoCargo=true;
	public Boolean activarid_cargo_grupoCargo=true;
	public Boolean cargarid_cargo_grupoCargo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cargo_grupoCargo=false;//ConEventDepend=true

	public Border resaltarcodigoCargo=null;
	public Boolean mostrarcodigoCargo=true;
	public Boolean activarcodigoCargo=true;

	public Border resaltarnombreCargo=null;
	public Boolean mostrarnombreCargo=true;
	public Boolean activarnombreCargo=true;

	public Border resaltarvalor_anticipoCargo=null;
	public Boolean mostrarvalor_anticipoCargo=true;
	public Boolean activarvalor_anticipoCargo=true;

	public Border resaltarporcentaje_anticipoCargo=null;
	public Boolean mostrarporcentaje_anticipoCargo=true;
	public Boolean activarporcentaje_anticipoCargo=true;

	public Border resaltares_jefeCargo=null;
	public Boolean mostrares_jefeCargo=true;
	public Boolean activares_jefeCargo=true;

	public Border resaltares_anualCargo=null;
	public Boolean mostrares_anualCargo=true;
	public Boolean activares_anualCargo=true;

	public Border resaltarporcentajeCargo=null;
	public Boolean mostrarporcentajeCargo=true;
	public Boolean activarporcentajeCargo=true;

	public Border resaltarvalorCargo=null;
	public Boolean mostrarvalorCargo=true;
	public Boolean activarvalorCargo=true;

	
	

	public Border setResaltaridCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltar);
		
		this.resaltaridCargo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCargo() {
		return this.resaltaridCargo;
	}

	public void setResaltaridCargo(Border borderResaltar) {
		this.resaltaridCargo= borderResaltar;
	}

	public Boolean getMostraridCargo() {
		return this.mostraridCargo;
	}

	public void setMostraridCargo(Boolean mostraridCargo) {
		this.mostraridCargo= mostraridCargo;
	}

	public Boolean getActivaridCargo() {
		return this.activaridCargo;
	}

	public void setActivaridCargo(Boolean activaridCargo) {
		this.activaridCargo= activaridCargo;
	}

	public Border setResaltarid_empresaCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltar);
		
		this.resaltarid_empresaCargo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCargo() {
		return this.resaltarid_empresaCargo;
	}

	public void setResaltarid_empresaCargo(Border borderResaltar) {
		this.resaltarid_empresaCargo= borderResaltar;
	}

	public Boolean getMostrarid_empresaCargo() {
		return this.mostrarid_empresaCargo;
	}

	public void setMostrarid_empresaCargo(Boolean mostrarid_empresaCargo) {
		this.mostrarid_empresaCargo= mostrarid_empresaCargo;
	}

	public Boolean getActivarid_empresaCargo() {
		return this.activarid_empresaCargo;
	}

	public void setActivarid_empresaCargo(Boolean activarid_empresaCargo) {
		this.activarid_empresaCargo= activarid_empresaCargo;
	}

	public Boolean getCargarid_empresaCargo() {
		return this.cargarid_empresaCargo;
	}

	public void setCargarid_empresaCargo(Boolean cargarid_empresaCargo) {
		this.cargarid_empresaCargo= cargarid_empresaCargo;
	}

	public Border setResaltarid_cargoCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltar);
		
		this.resaltarid_cargoCargo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cargoCargo() {
		return this.resaltarid_cargoCargo;
	}

	public void setResaltarid_cargoCargo(Border borderResaltar) {
		this.resaltarid_cargoCargo= borderResaltar;
	}

	public Boolean getMostrarid_cargoCargo() {
		return this.mostrarid_cargoCargo;
	}

	public void setMostrarid_cargoCargo(Boolean mostrarid_cargoCargo) {
		this.mostrarid_cargoCargo= mostrarid_cargoCargo;
	}

	public Boolean getActivarid_cargoCargo() {
		return this.activarid_cargoCargo;
	}

	public void setActivarid_cargoCargo(Boolean activarid_cargoCargo) {
		this.activarid_cargoCargo= activarid_cargoCargo;
	}

	public Boolean getCargarid_cargoCargo() {
		return this.cargarid_cargoCargo;
	}

	public void setCargarid_cargoCargo(Boolean cargarid_cargoCargo) {
		this.cargarid_cargoCargo= cargarid_cargoCargo;
	}

	public Border setResaltarid_cuenta_contableCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableCargo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableCargo() {
		return this.resaltarid_cuenta_contableCargo;
	}

	public void setResaltarid_cuenta_contableCargo(Border borderResaltar) {
		this.resaltarid_cuenta_contableCargo= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableCargo() {
		return this.mostrarid_cuenta_contableCargo;
	}

	public void setMostrarid_cuenta_contableCargo(Boolean mostrarid_cuenta_contableCargo) {
		this.mostrarid_cuenta_contableCargo= mostrarid_cuenta_contableCargo;
	}

	public Boolean getActivarid_cuenta_contableCargo() {
		return this.activarid_cuenta_contableCargo;
	}

	public void setActivarid_cuenta_contableCargo(Boolean activarid_cuenta_contableCargo) {
		this.activarid_cuenta_contableCargo= activarid_cuenta_contableCargo;
	}

	public Boolean getCargarid_cuenta_contableCargo() {
		return this.cargarid_cuenta_contableCargo;
	}

	public void setCargarid_cuenta_contableCargo(Boolean cargarid_cuenta_contableCargo) {
		this.cargarid_cuenta_contableCargo= cargarid_cuenta_contableCargo;
	}

	public Border setResaltarid_numero_patronalCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltar);
		
		this.resaltarid_numero_patronalCargo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_numero_patronalCargo() {
		return this.resaltarid_numero_patronalCargo;
	}

	public void setResaltarid_numero_patronalCargo(Border borderResaltar) {
		this.resaltarid_numero_patronalCargo= borderResaltar;
	}

	public Boolean getMostrarid_numero_patronalCargo() {
		return this.mostrarid_numero_patronalCargo;
	}

	public void setMostrarid_numero_patronalCargo(Boolean mostrarid_numero_patronalCargo) {
		this.mostrarid_numero_patronalCargo= mostrarid_numero_patronalCargo;
	}

	public Boolean getActivarid_numero_patronalCargo() {
		return this.activarid_numero_patronalCargo;
	}

	public void setActivarid_numero_patronalCargo(Boolean activarid_numero_patronalCargo) {
		this.activarid_numero_patronalCargo= activarid_numero_patronalCargo;
	}

	public Boolean getCargarid_numero_patronalCargo() {
		return this.cargarid_numero_patronalCargo;
	}

	public void setCargarid_numero_patronalCargo(Boolean cargarid_numero_patronalCargo) {
		this.cargarid_numero_patronalCargo= cargarid_numero_patronalCargo;
	}

	public Border setResaltarid_tipo_pago__n_mCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltar);
		
		this.resaltarid_tipo_pago__n_mCargo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_pago__n_mCargo() {
		return this.resaltarid_tipo_pago__n_mCargo;
	}

	public void setResaltarid_tipo_pago__n_mCargo(Border borderResaltar) {
		this.resaltarid_tipo_pago__n_mCargo= borderResaltar;
	}

	public Boolean getMostrarid_tipo_pago__n_mCargo() {
		return this.mostrarid_tipo_pago__n_mCargo;
	}

	public void setMostrarid_tipo_pago__n_mCargo(Boolean mostrarid_tipo_pago__n_mCargo) {
		this.mostrarid_tipo_pago__n_mCargo= mostrarid_tipo_pago__n_mCargo;
	}

	public Boolean getActivarid_tipo_pago__n_mCargo() {
		return this.activarid_tipo_pago__n_mCargo;
	}

	public void setActivarid_tipo_pago__n_mCargo(Boolean activarid_tipo_pago__n_mCargo) {
		this.activarid_tipo_pago__n_mCargo= activarid_tipo_pago__n_mCargo;
	}

	public Boolean getCargarid_tipo_pago__n_mCargo() {
		return this.cargarid_tipo_pago__n_mCargo;
	}

	public void setCargarid_tipo_pago__n_mCargo(Boolean cargarid_tipo_pago__n_mCargo) {
		this.cargarid_tipo_pago__n_mCargo= cargarid_tipo_pago__n_mCargo;
	}

	public Border setResaltarid_cargo_grupoCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltar);
		
		this.resaltarid_cargo_grupoCargo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cargo_grupoCargo() {
		return this.resaltarid_cargo_grupoCargo;
	}

	public void setResaltarid_cargo_grupoCargo(Border borderResaltar) {
		this.resaltarid_cargo_grupoCargo= borderResaltar;
	}

	public Boolean getMostrarid_cargo_grupoCargo() {
		return this.mostrarid_cargo_grupoCargo;
	}

	public void setMostrarid_cargo_grupoCargo(Boolean mostrarid_cargo_grupoCargo) {
		this.mostrarid_cargo_grupoCargo= mostrarid_cargo_grupoCargo;
	}

	public Boolean getActivarid_cargo_grupoCargo() {
		return this.activarid_cargo_grupoCargo;
	}

	public void setActivarid_cargo_grupoCargo(Boolean activarid_cargo_grupoCargo) {
		this.activarid_cargo_grupoCargo= activarid_cargo_grupoCargo;
	}

	public Boolean getCargarid_cargo_grupoCargo() {
		return this.cargarid_cargo_grupoCargo;
	}

	public void setCargarid_cargo_grupoCargo(Boolean cargarid_cargo_grupoCargo) {
		this.cargarid_cargo_grupoCargo= cargarid_cargo_grupoCargo;
	}

	public Border setResaltarcodigoCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltar);
		
		this.resaltarcodigoCargo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCargo() {
		return this.resaltarcodigoCargo;
	}

	public void setResaltarcodigoCargo(Border borderResaltar) {
		this.resaltarcodigoCargo= borderResaltar;
	}

	public Boolean getMostrarcodigoCargo() {
		return this.mostrarcodigoCargo;
	}

	public void setMostrarcodigoCargo(Boolean mostrarcodigoCargo) {
		this.mostrarcodigoCargo= mostrarcodigoCargo;
	}

	public Boolean getActivarcodigoCargo() {
		return this.activarcodigoCargo;
	}

	public void setActivarcodigoCargo(Boolean activarcodigoCargo) {
		this.activarcodigoCargo= activarcodigoCargo;
	}

	public Border setResaltarnombreCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltar);
		
		this.resaltarnombreCargo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCargo() {
		return this.resaltarnombreCargo;
	}

	public void setResaltarnombreCargo(Border borderResaltar) {
		this.resaltarnombreCargo= borderResaltar;
	}

	public Boolean getMostrarnombreCargo() {
		return this.mostrarnombreCargo;
	}

	public void setMostrarnombreCargo(Boolean mostrarnombreCargo) {
		this.mostrarnombreCargo= mostrarnombreCargo;
	}

	public Boolean getActivarnombreCargo() {
		return this.activarnombreCargo;
	}

	public void setActivarnombreCargo(Boolean activarnombreCargo) {
		this.activarnombreCargo= activarnombreCargo;
	}

	public Border setResaltarvalor_anticipoCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltar);
		
		this.resaltarvalor_anticipoCargo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_anticipoCargo() {
		return this.resaltarvalor_anticipoCargo;
	}

	public void setResaltarvalor_anticipoCargo(Border borderResaltar) {
		this.resaltarvalor_anticipoCargo= borderResaltar;
	}

	public Boolean getMostrarvalor_anticipoCargo() {
		return this.mostrarvalor_anticipoCargo;
	}

	public void setMostrarvalor_anticipoCargo(Boolean mostrarvalor_anticipoCargo) {
		this.mostrarvalor_anticipoCargo= mostrarvalor_anticipoCargo;
	}

	public Boolean getActivarvalor_anticipoCargo() {
		return this.activarvalor_anticipoCargo;
	}

	public void setActivarvalor_anticipoCargo(Boolean activarvalor_anticipoCargo) {
		this.activarvalor_anticipoCargo= activarvalor_anticipoCargo;
	}

	public Border setResaltarporcentaje_anticipoCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltar);
		
		this.resaltarporcentaje_anticipoCargo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_anticipoCargo() {
		return this.resaltarporcentaje_anticipoCargo;
	}

	public void setResaltarporcentaje_anticipoCargo(Border borderResaltar) {
		this.resaltarporcentaje_anticipoCargo= borderResaltar;
	}

	public Boolean getMostrarporcentaje_anticipoCargo() {
		return this.mostrarporcentaje_anticipoCargo;
	}

	public void setMostrarporcentaje_anticipoCargo(Boolean mostrarporcentaje_anticipoCargo) {
		this.mostrarporcentaje_anticipoCargo= mostrarporcentaje_anticipoCargo;
	}

	public Boolean getActivarporcentaje_anticipoCargo() {
		return this.activarporcentaje_anticipoCargo;
	}

	public void setActivarporcentaje_anticipoCargo(Boolean activarporcentaje_anticipoCargo) {
		this.activarporcentaje_anticipoCargo= activarporcentaje_anticipoCargo;
	}

	public Border setResaltares_jefeCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltar);
		
		this.resaltares_jefeCargo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_jefeCargo() {
		return this.resaltares_jefeCargo;
	}

	public void setResaltares_jefeCargo(Border borderResaltar) {
		this.resaltares_jefeCargo= borderResaltar;
	}

	public Boolean getMostrares_jefeCargo() {
		return this.mostrares_jefeCargo;
	}

	public void setMostrares_jefeCargo(Boolean mostrares_jefeCargo) {
		this.mostrares_jefeCargo= mostrares_jefeCargo;
	}

	public Boolean getActivares_jefeCargo() {
		return this.activares_jefeCargo;
	}

	public void setActivares_jefeCargo(Boolean activares_jefeCargo) {
		this.activares_jefeCargo= activares_jefeCargo;
	}

	public Border setResaltares_anualCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltar);
		
		this.resaltares_anualCargo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_anualCargo() {
		return this.resaltares_anualCargo;
	}

	public void setResaltares_anualCargo(Border borderResaltar) {
		this.resaltares_anualCargo= borderResaltar;
	}

	public Boolean getMostrares_anualCargo() {
		return this.mostrares_anualCargo;
	}

	public void setMostrares_anualCargo(Boolean mostrares_anualCargo) {
		this.mostrares_anualCargo= mostrares_anualCargo;
	}

	public Boolean getActivares_anualCargo() {
		return this.activares_anualCargo;
	}

	public void setActivares_anualCargo(Boolean activares_anualCargo) {
		this.activares_anualCargo= activares_anualCargo;
	}

	public Border setResaltarporcentajeCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltar);
		
		this.resaltarporcentajeCargo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeCargo() {
		return this.resaltarporcentajeCargo;
	}

	public void setResaltarporcentajeCargo(Border borderResaltar) {
		this.resaltarporcentajeCargo= borderResaltar;
	}

	public Boolean getMostrarporcentajeCargo() {
		return this.mostrarporcentajeCargo;
	}

	public void setMostrarporcentajeCargo(Boolean mostrarporcentajeCargo) {
		this.mostrarporcentajeCargo= mostrarporcentajeCargo;
	}

	public Boolean getActivarporcentajeCargo() {
		return this.activarporcentajeCargo;
	}

	public void setActivarporcentajeCargo(Boolean activarporcentajeCargo) {
		this.activarporcentajeCargo= activarporcentajeCargo;
	}

	public Border setResaltarvalorCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltar);
		
		this.resaltarvalorCargo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorCargo() {
		return this.resaltarvalorCargo;
	}

	public void setResaltarvalorCargo(Border borderResaltar) {
		this.resaltarvalorCargo= borderResaltar;
	}

	public Boolean getMostrarvalorCargo() {
		return this.mostrarvalorCargo;
	}

	public void setMostrarvalorCargo(Boolean mostrarvalorCargo) {
		this.mostrarvalorCargo= mostrarvalorCargo;
	}

	public Boolean getActivarvalorCargo() {
		return this.activarvalorCargo;
	}

	public void setActivarvalorCargo(Boolean activarvalorCargo) {
		this.activarvalorCargo= activarvalorCargo;
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
		
		
		this.setMostraridCargo(esInicial);
		this.setMostrarid_empresaCargo(esInicial);
		this.setMostrarid_cargoCargo(esInicial);
		this.setMostrarid_cuenta_contableCargo(esInicial);
		this.setMostrarid_numero_patronalCargo(esInicial);
		this.setMostrarid_tipo_pago__n_mCargo(esInicial);
		this.setMostrarid_cargo_grupoCargo(esInicial);
		this.setMostrarcodigoCargo(esInicial);
		this.setMostrarnombreCargo(esInicial);
		this.setMostrarvalor_anticipoCargo(esInicial);
		this.setMostrarporcentaje_anticipoCargo(esInicial);
		this.setMostrares_jefeCargo(esInicial);
		this.setMostrares_anualCargo(esInicial);
		this.setMostrarporcentajeCargo(esInicial);
		this.setMostrarvalorCargo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CargoConstantesFunciones.ID)) {
				this.setMostraridCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDCARGO)) {
				this.setMostrarid_cargoCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setMostrarid_numero_patronalCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDTIPOPAGO_NM)) {
				this.setMostrarid_tipo_pago__n_mCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDCARGOGRUPO)) {
				this.setMostrarid_cargo_grupoCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.VALORANTICIPO)) {
				this.setMostrarvalor_anticipoCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.PORCENTAJEANTICIPO)) {
				this.setMostrarporcentaje_anticipoCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.ESJEFE)) {
				this.setMostrares_jefeCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.ESANUAL)) {
				this.setMostrares_anualCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.VALOR)) {
				this.setMostrarvalorCargo(esAsigna);
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
		
		
		this.setActivaridCargo(esInicial);
		this.setActivarid_empresaCargo(esInicial);
		this.setActivarid_cargoCargo(esInicial);
		this.setActivarid_cuenta_contableCargo(esInicial);
		this.setActivarid_numero_patronalCargo(esInicial);
		this.setActivarid_tipo_pago__n_mCargo(esInicial);
		this.setActivarid_cargo_grupoCargo(esInicial);
		this.setActivarcodigoCargo(esInicial);
		this.setActivarnombreCargo(esInicial);
		this.setActivarvalor_anticipoCargo(esInicial);
		this.setActivarporcentaje_anticipoCargo(esInicial);
		this.setActivares_jefeCargo(esInicial);
		this.setActivares_anualCargo(esInicial);
		this.setActivarporcentajeCargo(esInicial);
		this.setActivarvalorCargo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CargoConstantesFunciones.ID)) {
				this.setActivaridCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDCARGO)) {
				this.setActivarid_cargoCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setActivarid_numero_patronalCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDTIPOPAGO_NM)) {
				this.setActivarid_tipo_pago__n_mCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDCARGOGRUPO)) {
				this.setActivarid_cargo_grupoCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.VALORANTICIPO)) {
				this.setActivarvalor_anticipoCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.PORCENTAJEANTICIPO)) {
				this.setActivarporcentaje_anticipoCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.ESJEFE)) {
				this.setActivares_jefeCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.ESANUAL)) {
				this.setActivares_anualCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.VALOR)) {
				this.setActivarvalorCargo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCargo(esInicial);
		this.setResaltarid_empresaCargo(esInicial);
		this.setResaltarid_cargoCargo(esInicial);
		this.setResaltarid_cuenta_contableCargo(esInicial);
		this.setResaltarid_numero_patronalCargo(esInicial);
		this.setResaltarid_tipo_pago__n_mCargo(esInicial);
		this.setResaltarid_cargo_grupoCargo(esInicial);
		this.setResaltarcodigoCargo(esInicial);
		this.setResaltarnombreCargo(esInicial);
		this.setResaltarvalor_anticipoCargo(esInicial);
		this.setResaltarporcentaje_anticipoCargo(esInicial);
		this.setResaltares_jefeCargo(esInicial);
		this.setResaltares_anualCargo(esInicial);
		this.setResaltarporcentajeCargo(esInicial);
		this.setResaltarvalorCargo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CargoConstantesFunciones.ID)) {
				this.setResaltaridCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDCARGO)) {
				this.setResaltarid_cargoCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setResaltarid_numero_patronalCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDTIPOPAGO_NM)) {
				this.setResaltarid_tipo_pago__n_mCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.IDCARGOGRUPO)) {
				this.setResaltarid_cargo_grupoCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.VALORANTICIPO)) {
				this.setResaltarvalor_anticipoCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.PORCENTAJEANTICIPO)) {
				this.setResaltarporcentaje_anticipoCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.ESJEFE)) {
				this.setResaltares_jefeCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.ESANUAL)) {
				this.setResaltares_anualCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeCargo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoConstantesFunciones.VALOR)) {
				this.setResaltarvalorCargo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarAsistenciaMensualCargo=null;

	public Border getResaltarAsistenciaMensualCargo() {
		return this.resaltarAsistenciaMensualCargo;
	}

	public void setResaltarAsistenciaMensualCargo(Border borderResaltarAsistenciaMensual) {
		if(borderResaltarAsistenciaMensual!=null) {
			this.resaltarAsistenciaMensualCargo= borderResaltarAsistenciaMensual;
		}
	}

	public Border setResaltarAsistenciaMensualCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltarAsistenciaMensual=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltarAsistenciaMensual);
			
		this.resaltarAsistenciaMensualCargo= borderResaltarAsistenciaMensual;

		 return borderResaltarAsistenciaMensual;
	}



	public Boolean mostrarAsistenciaMensualCargo=true;

	public Boolean getMostrarAsistenciaMensualCargo() {
		return this.mostrarAsistenciaMensualCargo;
	}

	public void setMostrarAsistenciaMensualCargo(Boolean visibilidadResaltarAsistenciaMensual) {
		this.mostrarAsistenciaMensualCargo= visibilidadResaltarAsistenciaMensual;
	}



	public Boolean activarAsistenciaMensualCargo=true;

	public Boolean gethabilitarResaltarAsistenciaMensualCargo() {
		return this.activarAsistenciaMensualCargo;
	}

	public void setActivarAsistenciaMensualCargo(Boolean habilitarResaltarAsistenciaMensual) {
		this.activarAsistenciaMensualCargo= habilitarResaltarAsistenciaMensual;
	}


	public Border resaltarEmpleadoEstructuraCargo=null;

	public Border getResaltarEmpleadoEstructuraCargo() {
		return this.resaltarEmpleadoEstructuraCargo;
	}

	public void setResaltarEmpleadoEstructuraCargo(Border borderResaltarEmpleadoEstructura) {
		if(borderResaltarEmpleadoEstructura!=null) {
			this.resaltarEmpleadoEstructuraCargo= borderResaltarEmpleadoEstructura;
		}
	}

	public Border setResaltarEmpleadoEstructuraCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoEstructura=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltarEmpleadoEstructura);
			
		this.resaltarEmpleadoEstructuraCargo= borderResaltarEmpleadoEstructura;

		 return borderResaltarEmpleadoEstructura;
	}



	public Boolean mostrarEmpleadoEstructuraCargo=true;

	public Boolean getMostrarEmpleadoEstructuraCargo() {
		return this.mostrarEmpleadoEstructuraCargo;
	}

	public void setMostrarEmpleadoEstructuraCargo(Boolean visibilidadResaltarEmpleadoEstructura) {
		this.mostrarEmpleadoEstructuraCargo= visibilidadResaltarEmpleadoEstructura;
	}



	public Boolean activarEmpleadoEstructuraCargo=true;

	public Boolean gethabilitarResaltarEmpleadoEstructuraCargo() {
		return this.activarEmpleadoEstructuraCargo;
	}

	public void setActivarEmpleadoEstructuraCargo(Boolean habilitarResaltarEmpleadoEstructura) {
		this.activarEmpleadoEstructuraCargo= habilitarResaltarEmpleadoEstructura;
	}


	public Border resaltarEmpleadoCargo=null;

	public Border getResaltarEmpleadoCargo() {
		return this.resaltarEmpleadoCargo;
	}

	public void setResaltarEmpleadoCargo(Border borderResaltarEmpleado) {
		if(borderResaltarEmpleado!=null) {
			this.resaltarEmpleadoCargo= borderResaltarEmpleado;
		}
	}

	public Border setResaltarEmpleadoCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltarEmpleado);
			
		this.resaltarEmpleadoCargo= borderResaltarEmpleado;

		 return borderResaltarEmpleado;
	}



	public Boolean mostrarEmpleadoCargo=true;

	public Boolean getMostrarEmpleadoCargo() {
		return this.mostrarEmpleadoCargo;
	}

	public void setMostrarEmpleadoCargo(Boolean visibilidadResaltarEmpleado) {
		this.mostrarEmpleadoCargo= visibilidadResaltarEmpleado;
	}



	public Boolean activarEmpleadoCargo=true;

	public Boolean gethabilitarResaltarEmpleadoCargo() {
		return this.activarEmpleadoCargo;
	}

	public void setActivarEmpleadoCargo(Boolean habilitarResaltarEmpleado) {
		this.activarEmpleadoCargo= habilitarResaltarEmpleado;
	}


	public Border resaltarCargoCargo=null;

	public Border getResaltarCargoCargo() {
		return this.resaltarCargoCargo;
	}

	public void setResaltarCargoCargo(Border borderResaltarCargo) {
		if(borderResaltarCargo!=null) {
			this.resaltarCargoCargo= borderResaltarCargo;
		}
	}

	public Border setResaltarCargoCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltarCargo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cargoBeanSwingJInternalFrame.jTtoolBarCargo.setBorder(borderResaltarCargo);
			
		this.resaltarCargoCargo= borderResaltarCargo;

		 return borderResaltarCargo;
	}



	public Boolean mostrarCargoCargo=true;

	public Boolean getMostrarCargoCargo() {
		return this.mostrarCargoCargo;
	}

	public void setMostrarCargoCargo(Boolean visibilidadResaltarCargo) {
		this.mostrarCargoCargo= visibilidadResaltarCargo;
	}



	public Boolean activarCargoCargo=true;

	public Boolean gethabilitarResaltarCargoCargo() {
		return this.activarCargoCargo;
	}

	public void setActivarCargoCargo(Boolean habilitarResaltarCargo) {
		this.activarCargoCargo= habilitarResaltarCargo;
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

		this.setMostrarAsistenciaMensualCargo(esInicial);
		this.setMostrarEmpleadoEstructuraCargo(esInicial);
		this.setMostrarEmpleadoCargo(esInicial);
		this.setMostrarCargoCargo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(AsistenciaMensual.class)) {
				this.setMostrarAsistenciaMensualCargo(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoEstructura.class)) {
				this.setMostrarEmpleadoEstructuraCargo(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setMostrarEmpleadoCargo(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cargo.class)) {
				this.setMostrarCargoCargo(esAsigna);
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

		this.setActivarAsistenciaMensualCargo(esInicial);
		this.setActivarEmpleadoEstructuraCargo(esInicial);
		this.setActivarEmpleadoCargo(esInicial);
		this.setActivarCargoCargo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(AsistenciaMensual.class)) {
				this.setActivarAsistenciaMensualCargo(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoEstructura.class)) {
				this.setActivarEmpleadoEstructuraCargo(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setActivarEmpleadoCargo(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cargo.class)) {
				this.setActivarCargoCargo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarAsistenciaMensualCargo(esInicial);
		this.setResaltarEmpleadoEstructuraCargo(esInicial);
		this.setResaltarEmpleadoCargo(esInicial);
		this.setResaltarCargoCargo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(AsistenciaMensual.class)) {
				this.setResaltarAsistenciaMensualCargo(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoEstructura.class)) {
				this.setResaltarEmpleadoEstructuraCargo(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setResaltarEmpleadoCargo(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cargo.class)) {
				this.setResaltarCargoCargo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCargoCargo=true;

	public Boolean getMostrarFK_IdCargoCargo() {
		return this.mostrarFK_IdCargoCargo;
	}

	public void setMostrarFK_IdCargoCargo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCargoCargo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCargoGrupoCargo=true;

	public Boolean getMostrarFK_IdCargoGrupoCargo() {
		return this.mostrarFK_IdCargoGrupoCargo;
	}

	public void setMostrarFK_IdCargoGrupoCargo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCargoGrupoCargo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCargo=true;

	public Boolean getMostrarFK_IdCuentaContableCargo() {
		return this.mostrarFK_IdCuentaContableCargo;
	}

	public void setMostrarFK_IdCuentaContableCargo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCargo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCargo=true;

	public Boolean getMostrarFK_IdEmpresaCargo() {
		return this.mostrarFK_IdEmpresaCargo;
	}

	public void setMostrarFK_IdEmpresaCargo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCargo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdNumeroPatronalCargo=true;

	public Boolean getMostrarFK_IdNumeroPatronalCargo() {
		return this.mostrarFK_IdNumeroPatronalCargo;
	}

	public void setMostrarFK_IdNumeroPatronalCargo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdNumeroPatronalCargo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPago_NMCargo=true;

	public Boolean getMostrarFK_IdTipoPago_NMCargo() {
		return this.mostrarFK_IdTipoPago_NMCargo;
	}

	public void setMostrarFK_IdTipoPago_NMCargo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPago_NMCargo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCargoCargo=true;

	public Boolean getActivarFK_IdCargoCargo() {
		return this.activarFK_IdCargoCargo;
	}

	public void setActivarFK_IdCargoCargo(Boolean habilitarResaltar) {
		this.activarFK_IdCargoCargo= habilitarResaltar;
	}

	public Boolean activarFK_IdCargoGrupoCargo=true;

	public Boolean getActivarFK_IdCargoGrupoCargo() {
		return this.activarFK_IdCargoGrupoCargo;
	}

	public void setActivarFK_IdCargoGrupoCargo(Boolean habilitarResaltar) {
		this.activarFK_IdCargoGrupoCargo= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCargo=true;

	public Boolean getActivarFK_IdCuentaContableCargo() {
		return this.activarFK_IdCuentaContableCargo;
	}

	public void setActivarFK_IdCuentaContableCargo(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCargo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCargo=true;

	public Boolean getActivarFK_IdEmpresaCargo() {
		return this.activarFK_IdEmpresaCargo;
	}

	public void setActivarFK_IdEmpresaCargo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCargo= habilitarResaltar;
	}

	public Boolean activarFK_IdNumeroPatronalCargo=true;

	public Boolean getActivarFK_IdNumeroPatronalCargo() {
		return this.activarFK_IdNumeroPatronalCargo;
	}

	public void setActivarFK_IdNumeroPatronalCargo(Boolean habilitarResaltar) {
		this.activarFK_IdNumeroPatronalCargo= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPago_NMCargo=true;

	public Boolean getActivarFK_IdTipoPago_NMCargo() {
		return this.activarFK_IdTipoPago_NMCargo;
	}

	public void setActivarFK_IdTipoPago_NMCargo(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPago_NMCargo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCargoCargo=null;

	public Border getResaltarFK_IdCargoCargo() {
		return this.resaltarFK_IdCargoCargo;
	}

	public void setResaltarFK_IdCargoCargo(Border borderResaltar) {
		this.resaltarFK_IdCargoCargo= borderResaltar;
	}

	public void setResaltarFK_IdCargoCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCargoCargo= borderResaltar;
	}

	public Border resaltarFK_IdCargoGrupoCargo=null;

	public Border getResaltarFK_IdCargoGrupoCargo() {
		return this.resaltarFK_IdCargoGrupoCargo;
	}

	public void setResaltarFK_IdCargoGrupoCargo(Border borderResaltar) {
		this.resaltarFK_IdCargoGrupoCargo= borderResaltar;
	}

	public void setResaltarFK_IdCargoGrupoCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCargoGrupoCargo= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCargo=null;

	public Border getResaltarFK_IdCuentaContableCargo() {
		return this.resaltarFK_IdCuentaContableCargo;
	}

	public void setResaltarFK_IdCuentaContableCargo(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCargo= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCargo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCargo=null;

	public Border getResaltarFK_IdEmpresaCargo() {
		return this.resaltarFK_IdEmpresaCargo;
	}

	public void setResaltarFK_IdEmpresaCargo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCargo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCargo= borderResaltar;
	}

	public Border resaltarFK_IdNumeroPatronalCargo=null;

	public Border getResaltarFK_IdNumeroPatronalCargo() {
		return this.resaltarFK_IdNumeroPatronalCargo;
	}

	public void setResaltarFK_IdNumeroPatronalCargo(Border borderResaltar) {
		this.resaltarFK_IdNumeroPatronalCargo= borderResaltar;
	}

	public void setResaltarFK_IdNumeroPatronalCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdNumeroPatronalCargo= borderResaltar;
	}

	public Border resaltarFK_IdTipoPago_NMCargo=null;

	public Border getResaltarFK_IdTipoPago_NMCargo() {
		return this.resaltarFK_IdTipoPago_NMCargo;
	}

	public void setResaltarFK_IdTipoPago_NMCargo(Border borderResaltar) {
		this.resaltarFK_IdTipoPago_NMCargo= borderResaltar;
	}

	public void setResaltarFK_IdTipoPago_NMCargo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoBeanSwingJInternalFrame cargoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPago_NMCargo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}